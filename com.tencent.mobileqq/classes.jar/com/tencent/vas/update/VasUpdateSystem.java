package com.tencent.vas.update;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.IReportManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.callback.listener.ICmdListener;
import com.tencent.vas.update.callback.listener.ITimerListener;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.DLReportInfo;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.module.NotificationModule;
import com.tencent.vas.update.module.TimerModule;
import com.tencent.vas.update.module.download.DownloadModule;
import com.tencent.vas.update.module.thread.ThreadManager;
import com.tencent.vas.update.request.TaskBatchUrlReq;
import com.tencent.vas.update.request.TaskBatchUrlRsp;
import com.tencent.vas.update.request.TaskSyncReq;
import com.tencent.vas.update.request.TaskSyncRsp;
import com.tencent.vas.update.task.BaseItemTask;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class VasUpdateSystem
  implements ICmdListener, ITimerListener
{
  private static final String TAG = "VasUpdate_System";
  private static VasUpdateSystem mInstance;
  private DownloadModule mDownloadModule = new DownloadModule();
  private volatile boolean mGetUrlTimerFinish = true;
  private final AtomicBoolean mIsTaskWait = new AtomicBoolean(false);
  private NotificationModule mNotificationModule;
  private List<TaskBatchUrlReq> mRequestUrlList = Collections.synchronizedList(new ArrayList());
  private TaskSyncReq mTaskSyncReq;
  private ConcurrentHashMap<String, BaseItemTask> mTempTaskMaps = new ConcurrentHashMap();
  private TimerModule mTimerModule = new TimerModule(this);
  
  private void addItemVersionForStartRun(@NonNull ItemUpdateVerPtr paramItemUpdateVerPtr, @NonNull BusinessUpdateParams paramBusinessUpdateParams, int paramInt)
  {
    if (this.mIsTaskWait.get()) {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "addItemVersionForStartRun currentItem thread is lock , itemId = " + paramBusinessUpdateParams.mItemId);
    }
    String str;
    synchronized (this.mTempTaskMaps)
    {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "start addItemVersionForStartRun itemId = " + paramBusinessUpdateParams.mItemId + " mGetUrlTimerFinish = " + this.mGetUrlTimerFinish);
      if (this.mTempTaskMaps.containsKey(paramItemUpdateVerPtr.mItemId))
      {
        VasUpdateWrapper.getLog().e("VasUpdate_System", "addItemVersionForStartRun mTempTaskMaps hasContain itemid = " + paramItemUpdateVerPtr.mItemId);
        return;
      }
      str = paramItemUpdateVerPtr.mItemId;
      localObject = getObserver(CommonUtil.sParseBidId(str));
      if (localObject == null)
      {
        VasUpdateWrapper.getLog().e("VasUpdate_System", "addItemVersionForStartRun currentItem not register , itemId = " + str);
        VasUpdateWrapper.getDbManager().deleteItem(1, str);
        return;
      }
    }
    Object localObject = ((IBusinessCallback)localObject).getBusinessItemInfo(CommonUtil.sParseBidId(str), CommonUtil.sParseScid(str));
    if (localObject == null)
    {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "addItemVersionForStartRun getItemInfo fail, itemId = " + str);
      VasUpdateWrapper.getDbManager().deleteItem(1, str);
      return;
    }
    paramItemUpdateVerPtr = new BaseItemTask(paramBusinessUpdateParams, paramItemUpdateVerPtr, (BusinessItemInfo)localObject);
    paramItemUpdateVerPtr.setDLFrom(paramInt);
    this.mTempTaskMaps.put(str, paramItemUpdateVerPtr);
    if (this.mGetUrlTimerFinish)
    {
      if (paramInt == 3) {}
      for (long l = 0L; l == 0L; l = VasUpdateWrapper.getCommonManager().getTimerDelay())
      {
        onTime(1);
        return;
      }
      this.mTimerModule.setTimer(1, l, false);
      this.mGetUrlTimerFinish = false;
    }
  }
  
  private boolean checkLastTime(@NonNull ItemUpdateVerPtr paramItemUpdateVerPtr)
  {
    long l = System.currentTimeMillis() / 1000L - paramItemUpdateVerPtr.mLastRunTime;
    if ((paramItemUpdateVerPtr.mRunCount >= 3) && (l < 21600L))
    {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete checkLastTime , itemId = " + paramItemUpdateVerPtr.mItemId + " time = " + l);
      return true;
    }
    return false;
  }
  
  public static VasUpdateSystem getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new VasUpdateSystem();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void onTimeGetUrl()
  {
    TaskBatchUrlReq localTaskBatchUrlReq = new TaskBatchUrlReq();
    Object localObject4;
    synchronized (this.mTempTaskMaps)
    {
      this.mIsTaskWait.compareAndSet(false, true);
      localObject4 = this.mTempTaskMaps.entrySet().iterator();
      if (((Iterator)localObject4).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        localTaskBatchUrlReq.addTask((String)localEntry.getKey(), (BaseItemTask)localEntry.getValue());
      }
    }
    this.mTempTaskMaps.clear();
    this.mIsTaskWait.set(false);
    this.mGetUrlTimerFinish = true;
    VasUpdateWrapper.getLog().i("VasUpdate_System", "onTimeGetUrl ， mGetUrlTimerFinish = " + this.mGetUrlTimerFinish);
    synchronized (this.mRequestUrlList)
    {
      if (localObject1.getTaskCount() > 0)
      {
        this.mRequestUrlList.add(localObject1);
        localObject4 = localObject1.getRequest();
        if (!VasUpdateWrapper.getCmdManager().sendPbRequest("GetUrlReq", (String)localObject4, this))
        {
          localObject1.onSendPbMsgError();
          this.mRequestUrlList.remove(localObject1);
        }
      }
      return;
    }
  }
  
  private void onTimeUpdateItem()
  {
    doSyncTable(2);
  }
  
  private void selfDownloadItem(@NonNull BusinessUpdateParams paramBusinessUpdateParams)
  {
    String str2 = paramBusinessUpdateParams.mFrom;
    String str1 = paramBusinessUpdateParams.mItemId;
    VasUpdateWrapper.getLog().i("VasUpdate_System", "selfDownloadItem params = \n" + paramBusinessUpdateParams.toString());
    if (TextUtils.isEmpty(str2))
    {
      onTaskItemComplete(paramBusinessUpdateParams, 3, 11, 0, "current from = null , itemId " + str1, null);
      return;
    }
    Object localObject1 = VasUpdateWrapper.getDbManager().selectItem(1, str1);
    VasUpdateWrapper.getLog().i("VasUpdate_System", "selfDownloadItem select should_update , ItemId = " + str1 + " , content = " + (String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ItemUpdateVerPtr.parseJsonToItemUpdateVerPrt((String)localObject1);
      if (localObject1 != null)
      {
        long l = System.currentTimeMillis() / 1000L - ((ItemUpdateVerPtr)localObject1).mLastRunTime;
        if ((((ItemUpdateVerPtr)localObject1).mRunCount >= 3) && (l >= 0L) && (l < 8L))
        {
          onTaskItemComplete(paramBusinessUpdateParams, 3, 20, 0, " update delay retry ", null);
          return;
        }
        addItemVersionForStartRun((ItemUpdateVerPtr)localObject1, paramBusinessUpdateParams, 3);
        return;
      }
    }
    Object localObject2 = VasUpdateWrapper.getDbManager().selectItem(0, str1);
    VasUpdateWrapper.getLog().i("VasUpdate_System", "selfDownloadItem select local , ItemId = " + str1 + " , content = " + (String)localObject2);
    localObject1 = new ItemUpdateVerPtr();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      ((ItemUpdateVerPtr)localObject1).mItemId = str1;
      ((ItemUpdateVerPtr)localObject1).mSrcMd5 = "";
      ((ItemUpdateVerPtr)localObject1).mDstMd5 = "";
      ((ItemUpdateVerPtr)localObject1).mFrom = str2;
      ((ItemUpdateVerPtr)localObject1).mLastRunTime = 0L;
      ((ItemUpdateVerPtr)localObject1).mRunCount = 0;
      addItemVersionForStartRun((ItemUpdateVerPtr)localObject1, paramBusinessUpdateParams, 3);
      return;
    }
    localObject2 = ItemLocalVerPrt.parseJsonToItemLocalVerPrt((String)localObject2);
    ((ItemUpdateVerPtr)localObject1).mItemId = str1;
    if (localObject2 != null) {}
    for (str1 = ((ItemLocalVerPrt)localObject2).mMd5;; str1 = "")
    {
      ((ItemUpdateVerPtr)localObject1).mSrcMd5 = str1;
      ((ItemUpdateVerPtr)localObject1).mDstMd5 = "";
      ((ItemUpdateVerPtr)localObject1).mFrom = str2;
      ((ItemUpdateVerPtr)localObject1).mLastRunTime = 0L;
      ((ItemUpdateVerPtr)localObject1).mRunCount = 0;
      break;
    }
  }
  
  private void sendSyncRequest()
  {
    if (this.mTaskSyncReq != null) {
      this.mTaskSyncReq.run();
    }
    try
    {
      bool = VasUpdateWrapper.getCmdManager().sendPbRequest("SyncVCRReq", this.mTaskSyncReq.getRequest(), this);
      if (!bool) {
        this.mTaskSyncReq.onSendPbMsgError();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        boolean bool = false;
      }
    }
  }
  
  private boolean syncEnable()
  {
    try
    {
      long l1 = Long.parseLong(VasUpdateWrapper.getDbManager().selectItem(3, "time_value"));
      long l2 = Long.parseLong(VasUpdateWrapper.getDbManager().selectItem(3, "time_success"));
      long l3 = VasUpdateWrapper.getCommonManager().getServiceTime();
      VasUpdateWrapper.getLog().i("VasUpdate_System", "syncEnable timeValue = " + l1 + " offest = " + (l3 - l2));
      return l3 - l2 > l1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return true;
  }
  
  private void updatePollTime(int paramInt)
  {
    VasUpdateWrapper.getDbManager().updateItem(3, "time_value", String.valueOf(paramInt));
    VasUpdateWrapper.getDbManager().updateItem(3, "time_success", String.valueOf(VasUpdateWrapper.getCommonManager().getServiceTime()));
  }
  
  public void cancelDownload(long paramLong, String paramString)
  {
    VasUpdateWrapper.getLog().i("VasUpdate_System", "cancelDownload bid = " + paramLong + " scid = " + paramString);
    VasUpdateWrapper.getHttpDownloader().cancelDownload(CommonUtil.sComposeItemId(paramLong, paramString));
  }
  
  public void doSyncTable(int paramInt)
  {
    if (!syncEnable())
    {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "doSyncTable enable = false");
      return;
    }
    if (this.mTaskSyncReq != null)
    {
      VasUpdateWrapper.getLog().d("VasUpdate_System", "doSyncTable request != null");
      return;
    }
    VasUpdateWrapper.getLog().d("VasUpdate_System", "start doSyncTable dlFrom = " + paramInt);
    this.mTimerModule.stopTimer(2);
    this.mTaskSyncReq = new TaskSyncReq(paramInt);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.getInstance().post(new VasUpdateSystem.2(this));
      return;
    }
    sendSyncRequest();
  }
  
  public void downloadItem(BusinessUpdateParams paramBusinessUpdateParams)
  {
    if ((paramBusinessUpdateParams == null) || (paramBusinessUpdateParams.mBid <= 0L)) {
      throw new RuntimeException("system request download business or params = null or bid <= 0");
    }
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder().append("downloadItem bid = ").append(paramBusinessUpdateParams.mBid).append(" mainThread = ");
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      localIVasLog.i("VasUpdate_System", bool);
      ThreadManager.getInstance().post(new VasUpdateSystem.1(this, paramBusinessUpdateParams));
      return;
    }
  }
  
  public DownloadModule getDownloadModule()
  {
    return this.mDownloadModule;
  }
  
  public IBusinessCallback getObserver(long paramLong)
  {
    if (this.mNotificationModule == null)
    {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "getObserver , notification = null");
      return null;
    }
    return this.mNotificationModule.getObserver(Long.valueOf(paramLong));
  }
  
  public void onPbResponse(int paramInt, String paramString1, String arg3)
  {
    if (VasUpdateWrapper.getLog().isColorLevel()) {
      VasUpdateWrapper.getLog().i("VasUpdate_System", "onPbResponse cmd = " + paramString1 + " result = " + paramInt + " response = " + ???);
    }
    TaskBatchUrlRsp localTaskBatchUrlRsp;
    if ("GetUrlRsp".equalsIgnoreCase(paramString1))
    {
      localTaskBatchUrlRsp = TaskBatchUrlRsp.parseResponse(???);
      if (localTaskBatchUrlRsp == null) {
        return;
      }
      VasUpdateWrapper.getLog().i("VasUpdate_System", "onPbResponse response cookie = " + localTaskBatchUrlRsp.mCookie);
    }
    for (;;)
    {
      synchronized (this.mRequestUrlList)
      {
        Iterator localIterator = this.mRequestUrlList.iterator();
        if (!localIterator.hasNext()) {
          break label230;
        }
        paramString1 = (TaskBatchUrlReq)localIterator.next();
        if ((paramString1 == null) || (paramString1.getCookieId() != localTaskBatchUrlRsp.mCookie)) {
          continue;
        }
        localIterator.remove();
        if (paramString1 == null) {
          break;
        }
        paramString1.handlePbResponse(paramInt, localTaskBatchUrlRsp);
        return;
      }
      if ((!"SyncVCRRsp".equalsIgnoreCase(paramString1)) || (this.mTaskSyncReq == null)) {
        break;
      }
      paramString1 = TaskSyncRsp.parseResponseJson(???);
      this.mTaskSyncReq.handlePbResponse(paramInt, paramString1);
      return;
      label230:
      paramString1 = null;
    }
  }
  
  public void onTaskItemComplete(@NonNull BusinessUpdateParams paramBusinessUpdateParams, int paramInt1, int paramInt2, int paramInt3, String paramString, DLReportInfo paramDLReportInfo)
  {
    VasUpdateWrapper.getLog().i("VasUpdate_System", "onTaskItemComplete itemId = " + paramBusinessUpdateParams.mItemId + ", errorCode = " + paramInt2 + " , httpCode = " + paramInt3);
    if (this.mNotificationModule == null)
    {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskItemComplete , notify = null");
      return;
    }
    if (paramInt2 != 0) {
      this.mNotificationModule.notifyFailure(paramBusinessUpdateParams, paramInt2, paramInt3, paramString);
    }
    long l;
    for (;;)
    {
      l = CommonUtil.sParseBidId(paramBusinessUpdateParams.mItemId);
      paramBusinessUpdateParams = CommonUtil.sParseScid(paramBusinessUpdateParams.mItemId);
      if (paramDLReportInfo == null) {
        break;
      }
      VasUpdateWrapper.getReportManager().reportDLEvent(paramInt1, l, paramBusinessUpdateParams, paramDLReportInfo.mDstMd5, paramDLReportInfo.mIsIncrement, paramInt2, paramInt3, paramDLReportInfo.mRetryCount, "2", VasUpdateWrapper.getCommonManager().getReportVersion(), VasUpdateWrapper.getCommonManager().getNetType() + "");
      return;
      this.mNotificationModule.notifySuccess(paramBusinessUpdateParams);
    }
    VasUpdateWrapper.getReportManager().reportDLEvent(paramInt1, l, paramBusinessUpdateParams, "", false, paramInt2, paramInt3, 0, "2", VasUpdateWrapper.getCommonManager().getReportVersion(), VasUpdateWrapper.getCommonManager().getNetType() + "");
  }
  
  public void onTaskItemProgress(BusinessUpdateParams paramBusinessUpdateParams, long paramLong1, long paramLong2, int paramInt)
  {
    if (this.mNotificationModule == null)
    {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskItemProgress , notify = null");
      return;
    }
    this.mNotificationModule.notifyProgress(paramBusinessUpdateParams, paramLong1, paramLong2, paramInt);
  }
  
  public void onTaskSyncTableComplete(int paramInt1, int paramInt2, HashMap<String, ItemUpdateVerPtr> paramHashMap)
  {
    this.mTaskSyncReq = null;
    Object localObject1 = new ArrayList();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject2 = (Map.Entry)paramHashMap.next();
        if ((localObject2 != null) && (((Map.Entry)localObject2).getValue() != null))
        {
          localObject2 = (ItemUpdateVerPtr)((Map.Entry)localObject2).getValue();
          if ((localObject2 == null) || (TextUtils.isEmpty(((ItemUpdateVerPtr)localObject2).mItemId)))
          {
            VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete node doesn't have updateItem , continue , itemId = " + ((ItemUpdateVerPtr)localObject2).mItemId);
          }
          else if (((ItemUpdateVerPtr)localObject2).checkItemIsCurrentVersion())
          {
            ((ItemUpdateVerPtr)localObject2).mFrom = "silent_update";
            long l = CommonUtil.sParseBidId(((ItemUpdateVerPtr)localObject2).mItemId);
            ??? = CommonUtil.sParseScid(((ItemUpdateVerPtr)localObject2).mItemId);
            Object localObject4 = getObserver(l);
            if (localObject4 == null)
            {
              VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete currentItem not register , itemId = " + ((ItemUpdateVerPtr)localObject2).mItemId);
              VasUpdateWrapper.getDbManager().deleteItem(1, ((ItemUpdateVerPtr)localObject2).mItemId);
            }
            else
            {
              localObject4 = ((IBusinessCallback)localObject4).getBusinessItemInfo(l, (String)???);
              if (localObject4 == null)
              {
                VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete getItemInfo fail , itemId = " + ((ItemUpdateVerPtr)localObject2).mItemId);
                VasUpdateWrapper.getDbManager().deleteItem(1, ((ItemUpdateVerPtr)localObject2).mItemId);
              }
              else
              {
                ??? = new BusinessUpdateParams(l, (String)???, ((ItemUpdateVerPtr)localObject2).mFrom);
                if (!((BusinessItemInfo)localObject4).mIsCanUpdate)
                {
                  onTaskItemComplete((BusinessUpdateParams)???, paramInt2, 1, 0, "can update = false", null);
                }
                else
                {
                  synchronized (this.mTempTaskMaps)
                  {
                    if ((this.mTempTaskMaps.containsKey(((ItemUpdateVerPtr)localObject2).mItemId)) && (this.mTempTaskMaps.get(((ItemUpdateVerPtr)localObject2).mItemId) != null)) {
                      ((BaseItemTask)this.mTempTaskMaps.get(((ItemUpdateVerPtr)localObject2).mItemId)).setDLFrom(paramInt2);
                    }
                  }
                  if (((ItemUpdateVerPtr)localObject2).mRunCount >= 10)
                  {
                    VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete item runcount >= 10 , delete, itemId = " + ((ItemUpdateVerPtr)localObject2).mItemId);
                    VasUpdateWrapper.getDbManager().deleteItem(1, ((ItemUpdateVerPtr)localObject2).mItemId);
                  }
                  else if (!checkLastTime((ItemUpdateVerPtr)localObject2))
                  {
                    ((ArrayList)localObject1).add(localObject2);
                  }
                }
              }
            }
          }
        }
      }
    }
    paramHashMap = ((ArrayList)localObject1).iterator();
    while (paramHashMap.hasNext())
    {
      localObject1 = (ItemUpdateVerPtr)paramHashMap.next();
      if ((localObject1 != null) && (!TextUtils.isEmpty(((ItemUpdateVerPtr)localObject1).mItemId))) {
        if (getObserver(CommonUtil.sParseBidId(((ItemUpdateVerPtr)localObject1).mItemId)) == null)
        {
          VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskSyncTableComplete requestList currentItem not register , itemId = " + ((ItemUpdateVerPtr)localObject1).mItemId);
          VasUpdateWrapper.getDbManager().deleteItem(1, ((ItemUpdateVerPtr)localObject1).mItemId);
        }
        else
        {
          addItemVersionForStartRun((ItemUpdateVerPtr)localObject1, new BusinessUpdateParams(CommonUtil.sParseBidId(((ItemUpdateVerPtr)localObject1).mItemId), CommonUtil.sParseScid(((ItemUpdateVerPtr)localObject1).mItemId), ((ItemUpdateVerPtr)localObject1).mFrom), paramInt2);
        }
      }
    }
    VasUpdateWrapper.getLog().d("VasUpdate_System", "onTaskSyncTableComplete start update request , size = " + this.mTempTaskMaps.size());
    if (paramInt1 > 0)
    {
      updatePollTime(paramInt1);
      this.mTimerModule.setTimer(2, paramInt1 * 1000, false);
    }
  }
  
  public void onTime(int paramInt)
  {
    VasUpdateWrapper.getLog().i("VasUpdate_System", "onTime type = " + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      onTimeGetUrl();
      return;
    }
    onTimeUpdateItem();
  }
  
  public void setNotification(NotificationModule paramNotificationModule)
  {
    this.mNotificationModule = paramNotificationModule;
  }
  
  public void updateAllItem()
  {
    doSyncTable(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.VasUpdateSystem
 * JD-Core Version:    0.7.0.1
 */