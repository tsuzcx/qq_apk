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
    Object localObject2;
    if (this.mIsTaskWait.get())
    {
      ??? = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("addItemVersionForStartRun currentItem thread is lock , itemId = ");
      ((StringBuilder)localObject2).append(paramBusinessUpdateParams.mItemId);
      ((IVasLog)???).e("VasUpdate_System", ((StringBuilder)localObject2).toString());
    }
    synchronized (this.mTempTaskMaps)
    {
      localObject2 = VasUpdateWrapper.getLog();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("start addItemVersionForStartRun itemId = ");
      ((StringBuilder)localObject3).append(paramBusinessUpdateParams.mItemId);
      ((StringBuilder)localObject3).append(" mGetUrlTimerFinish = ");
      ((StringBuilder)localObject3).append(this.mGetUrlTimerFinish);
      ((IVasLog)localObject2).e("VasUpdate_System", ((StringBuilder)localObject3).toString());
      if (this.mTempTaskMaps.containsKey(paramItemUpdateVerPtr.mItemId))
      {
        paramBusinessUpdateParams = VasUpdateWrapper.getLog();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addItemVersionForStartRun mTempTaskMaps hasContain itemid = ");
        ((StringBuilder)localObject2).append(paramItemUpdateVerPtr.mItemId);
        paramBusinessUpdateParams.e("VasUpdate_System", ((StringBuilder)localObject2).toString());
        return;
      }
      localObject2 = paramItemUpdateVerPtr.mItemId;
      localObject3 = getObserver(CommonUtil.sParseBidId((String)localObject2));
      if (localObject3 == null)
      {
        paramItemUpdateVerPtr = VasUpdateWrapper.getLog();
        paramBusinessUpdateParams = new StringBuilder();
        paramBusinessUpdateParams.append("addItemVersionForStartRun currentItem not register , itemId = ");
        paramBusinessUpdateParams.append((String)localObject2);
        paramItemUpdateVerPtr.e("VasUpdate_System", paramBusinessUpdateParams.toString());
        VasUpdateWrapper.getDbManager().deleteItem(1, (String)localObject2);
        return;
      }
      localObject3 = ((IBusinessCallback)localObject3).getBusinessItemInfo(CommonUtil.sParseBidId((String)localObject2), CommonUtil.sParseScid((String)localObject2));
      if (localObject3 == null)
      {
        paramItemUpdateVerPtr = VasUpdateWrapper.getLog();
        paramBusinessUpdateParams = new StringBuilder();
        paramBusinessUpdateParams.append("addItemVersionForStartRun getItemInfo fail, itemId = ");
        paramBusinessUpdateParams.append((String)localObject2);
        paramItemUpdateVerPtr.e("VasUpdate_System", paramBusinessUpdateParams.toString());
        VasUpdateWrapper.getDbManager().deleteItem(1, (String)localObject2);
        return;
      }
      paramItemUpdateVerPtr = new BaseItemTask(paramBusinessUpdateParams, paramItemUpdateVerPtr, (BusinessItemInfo)localObject3);
      paramItemUpdateVerPtr.setDLFrom(paramInt);
      this.mTempTaskMaps.put(localObject2, paramItemUpdateVerPtr);
      if (this.mGetUrlTimerFinish)
      {
        long l;
        if (paramInt == 3) {
          l = 0L;
        } else {
          l = VasUpdateWrapper.getCommonManager().getTimerDelay();
        }
        if (l == 0L)
        {
          onTime(1);
          return;
        }
        this.mTimerModule.setTimer(1, l, false);
        this.mGetUrlTimerFinish = false;
      }
      return;
    }
  }
  
  private boolean checkLastTime(@NonNull ItemUpdateVerPtr paramItemUpdateVerPtr)
  {
    long l = System.currentTimeMillis() / 1000L - paramItemUpdateVerPtr.mLastRunTime;
    if ((paramItemUpdateVerPtr.mRunCount >= 3) && (l < 21600L))
    {
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTaskSyncTableComplete checkLastTime , itemId = ");
      localStringBuilder.append(paramItemUpdateVerPtr.mItemId);
      localStringBuilder.append(" time = ");
      localStringBuilder.append(l);
      localIVasLog.e("VasUpdate_System", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public static VasUpdateSystem getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new VasUpdateSystem();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  private void onTimeGetUrl()
  {
    TaskBatchUrlReq localTaskBatchUrlReq = new TaskBatchUrlReq();
    synchronized (this.mTempTaskMaps)
    {
      this.mIsTaskWait.compareAndSet(false, true);
      Object localObject4 = this.mTempTaskMaps.entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        localTaskBatchUrlReq.addTask((String)localEntry.getKey(), (BaseItemTask)localEntry.getValue());
      }
      this.mTempTaskMaps.clear();
      this.mIsTaskWait.set(false);
      this.mGetUrlTimerFinish = true;
      ??? = VasUpdateWrapper.getLog();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("onTimeGetUrl ， mGetUrlTimerFinish = ");
      ((StringBuilder)localObject4).append(this.mGetUrlTimerFinish);
      ((IVasLog)???).i("VasUpdate_System", ((StringBuilder)localObject4).toString());
      synchronized (this.mRequestUrlList)
      {
        if (localTaskBatchUrlReq.getTaskCount() > 0)
        {
          this.mRequestUrlList.add(localTaskBatchUrlReq);
          localObject4 = localTaskBatchUrlReq.getRequest();
          if (!VasUpdateWrapper.getCmdManager().sendPbRequest("GetUrlReq", (String)localObject4, this))
          {
            localTaskBatchUrlReq.onSendPbMsgError();
            this.mRequestUrlList.remove(localTaskBatchUrlReq);
          }
        }
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void onTimeUpdateItem()
  {
    doSyncTable(2);
  }
  
  private void selfDownloadItem(@NonNull BusinessUpdateParams paramBusinessUpdateParams)
  {
    Object localObject1 = paramBusinessUpdateParams.mFrom;
    String str = paramBusinessUpdateParams.mItemId;
    Object localObject2 = VasUpdateWrapper.getLog();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("selfDownloadItem params = \n");
    ((StringBuilder)localObject3).append(paramBusinessUpdateParams.toString());
    ((IVasLog)localObject2).i("VasUpdate_System", ((StringBuilder)localObject3).toString());
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("current from = null , itemId ");
      ((StringBuilder)localObject1).append(str);
      onTaskItemComplete(paramBusinessUpdateParams, 3, 11, 0, ((StringBuilder)localObject1).toString(), null);
      return;
    }
    localObject2 = VasUpdateWrapper.getDbManager().selectItem(1, str);
    localObject3 = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("selfDownloadItem select should_update , ItemId = ");
    localStringBuilder.append(str);
    localStringBuilder.append(" , content = ");
    localStringBuilder.append((String)localObject2);
    ((IVasLog)localObject3).i("VasUpdate_System", localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = ItemUpdateVerPtr.parseJsonToItemUpdateVerPrt((String)localObject2);
      if (localObject2 != null)
      {
        long l = System.currentTimeMillis() / 1000L - ((ItemUpdateVerPtr)localObject2).mLastRunTime;
        if ((((ItemUpdateVerPtr)localObject2).mRunCount >= 3) && (l >= 0L) && (l < 8L))
        {
          onTaskItemComplete(paramBusinessUpdateParams, 3, 20, 0, " update delay retry ", null);
          return;
        }
        addItemVersionForStartRun((ItemUpdateVerPtr)localObject2, paramBusinessUpdateParams, 3);
        return;
      }
    }
    localObject3 = VasUpdateWrapper.getDbManager().selectItem(0, str);
    localObject2 = VasUpdateWrapper.getLog();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("selfDownloadItem select local , ItemId = ");
    localStringBuilder.append(str);
    localStringBuilder.append(" , content = ");
    localStringBuilder.append((String)localObject3);
    ((IVasLog)localObject2).i("VasUpdate_System", localStringBuilder.toString());
    localObject2 = new ItemUpdateVerPtr();
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      ((ItemUpdateVerPtr)localObject2).mItemId = str;
      ((ItemUpdateVerPtr)localObject2).mSrcMd5 = "";
      ((ItemUpdateVerPtr)localObject2).mDstMd5 = "";
      ((ItemUpdateVerPtr)localObject2).mFrom = ((String)localObject1);
      ((ItemUpdateVerPtr)localObject2).mLastRunTime = 0L;
      ((ItemUpdateVerPtr)localObject2).mRunCount = 0;
    }
    else
    {
      localObject3 = ItemLocalVerPrt.parseJsonToItemLocalVerPrt((String)localObject3);
      ((ItemUpdateVerPtr)localObject2).mItemId = str;
      if (localObject3 != null) {
        str = ((ItemLocalVerPrt)localObject3).mMd5;
      } else {
        str = "";
      }
      ((ItemUpdateVerPtr)localObject2).mSrcMd5 = str;
      ((ItemUpdateVerPtr)localObject2).mDstMd5 = "";
      ((ItemUpdateVerPtr)localObject2).mFrom = ((String)localObject1);
      ((ItemUpdateVerPtr)localObject2).mLastRunTime = 0L;
      ((ItemUpdateVerPtr)localObject2).mRunCount = 0;
    }
    addItemVersionForStartRun((ItemUpdateVerPtr)localObject2, paramBusinessUpdateParams, 3);
  }
  
  private void sendSyncRequest()
  {
    TaskSyncReq localTaskSyncReq = this.mTaskSyncReq;
    if (localTaskSyncReq != null)
    {
      localTaskSyncReq.run();
      int i = 0;
      try
      {
        boolean bool = VasUpdateWrapper.getCmdManager().sendPbRequest("SyncVCRReq", this.mTaskSyncReq.getRequest(), this);
        i = bool;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      if (i == 0) {
        this.mTaskSyncReq.onSendPbMsgError();
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
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("syncEnable timeValue = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" offest = ");
      l2 = l3 - l2;
      localStringBuilder.append(l2);
      localIVasLog.i("VasUpdate_System", localStringBuilder.toString());
      return l2 > l1;
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
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelDownload bid = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" scid = ");
    localStringBuilder.append(paramString);
    localIVasLog.i("VasUpdate_System", localStringBuilder.toString());
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
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start doSyncTable dlFrom = ");
    localStringBuilder.append(paramInt);
    localIVasLog.d("VasUpdate_System", localStringBuilder.toString());
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
    if ((paramBusinessUpdateParams != null) && (paramBusinessUpdateParams.mBid > 0L))
    {
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadItem bid = ");
      localStringBuilder.append(paramBusinessUpdateParams.mBid);
      localStringBuilder.append(" mainThread = ");
      boolean bool;
      if (Looper.getMainLooper() == Looper.myLooper()) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localIVasLog.i("VasUpdate_System", localStringBuilder.toString());
      ThreadManager.getInstance().post(new VasUpdateSystem.1(this, paramBusinessUpdateParams));
      return;
    }
    throw new RuntimeException("system request download business or params = null or bid <= 0");
  }
  
  public DownloadModule getDownloadModule()
  {
    return this.mDownloadModule;
  }
  
  public IBusinessCallback getObserver(long paramLong)
  {
    NotificationModule localNotificationModule = this.mNotificationModule;
    if (localNotificationModule == null)
    {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "getObserver , notification = null");
      return null;
    }
    return localNotificationModule.getObserver(Long.valueOf(paramLong));
  }
  
  public void onPbResponse(int paramInt, String paramString1, String paramString2)
  {
    Object localObject1;
    if (VasUpdateWrapper.getLog().isColorLevel())
    {
      localObject1 = VasUpdateWrapper.getLog();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onPbResponse cmd = ");
      ((StringBuilder)???).append(paramString1);
      ((StringBuilder)???).append(" result = ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(" response = ");
      ((StringBuilder)???).append(paramString2);
      ((IVasLog)localObject1).i("VasUpdate_System", ((StringBuilder)???).toString());
    }
    if ("GetUrlRsp".equalsIgnoreCase(paramString1))
    {
      localObject1 = TaskBatchUrlRsp.parseResponse(paramString2);
      if (localObject1 == null) {
        return;
      }
      paramString1 = VasUpdateWrapper.getLog();
      paramString2 = new StringBuilder();
      paramString2.append("onPbResponse response cookie = ");
      paramString2.append(((TaskBatchUrlRsp)localObject1).mCookie);
      paramString1.i("VasUpdate_System", paramString2.toString());
      paramString2 = null;
      synchronized (this.mRequestUrlList)
      {
        Iterator localIterator = this.mRequestUrlList.iterator();
        do
        {
          paramString1 = paramString2;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString1 = (TaskBatchUrlReq)localIterator.next();
        } while ((paramString1 == null) || (paramString1.getCookieId() != ((TaskBatchUrlRsp)localObject1).mCookie));
        localIterator.remove();
        if (paramString1 == null) {
          return;
        }
        paramString1.handlePbResponse(paramInt, (TaskBatchUrlRsp)localObject1);
        return;
      }
    }
    if (("SyncVCRRsp".equalsIgnoreCase(paramString1)) && (this.mTaskSyncReq != null))
    {
      paramString1 = TaskSyncRsp.parseResponseJson(paramString2);
      this.mTaskSyncReq.handlePbResponse(paramInt, paramString1);
    }
  }
  
  public void onTaskItemComplete(@NonNull BusinessUpdateParams paramBusinessUpdateParams, int paramInt1, int paramInt2, int paramInt3, String paramString, DLReportInfo paramDLReportInfo)
  {
    Object localObject = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTaskItemComplete itemId = ");
    localStringBuilder.append(paramBusinessUpdateParams.mItemId);
    localStringBuilder.append(", errorCode = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" , httpCode = ");
    localStringBuilder.append(paramInt3);
    ((IVasLog)localObject).i("VasUpdate_System", localStringBuilder.toString());
    localObject = this.mNotificationModule;
    if (localObject == null)
    {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskItemComplete , notify = null");
      return;
    }
    if (paramInt2 != 0) {
      ((NotificationModule)localObject).notifyFailure(paramBusinessUpdateParams, paramInt2, paramInt3, paramString);
    } else {
      ((NotificationModule)localObject).notifySuccess(paramBusinessUpdateParams);
    }
    long l = CommonUtil.sParseBidId(paramBusinessUpdateParams.mItemId);
    paramBusinessUpdateParams = CommonUtil.sParseScid(paramBusinessUpdateParams.mItemId);
    if (paramDLReportInfo != null)
    {
      paramString = VasUpdateWrapper.getReportManager();
      localObject = paramDLReportInfo.mDstMd5;
      boolean bool = paramDLReportInfo.mIsIncrement;
      int i = paramDLReportInfo.mRetryCount;
      paramDLReportInfo = VasUpdateWrapper.getCommonManager().getReportVersion();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(VasUpdateWrapper.getCommonManager().getNetType());
      localStringBuilder.append("");
      paramString.reportDLEvent(paramInt1, l, paramBusinessUpdateParams, (String)localObject, bool, paramInt2, paramInt3, i, "2", paramDLReportInfo, localStringBuilder.toString());
      return;
    }
    paramString = VasUpdateWrapper.getReportManager();
    paramDLReportInfo = VasUpdateWrapper.getCommonManager().getReportVersion();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(VasUpdateWrapper.getCommonManager().getNetType());
    ((StringBuilder)localObject).append("");
    paramString.reportDLEvent(paramInt1, l, paramBusinessUpdateParams, "", false, paramInt2, paramInt3, 0, "2", paramDLReportInfo, ((StringBuilder)localObject).toString());
  }
  
  public void onTaskItemProgress(BusinessUpdateParams paramBusinessUpdateParams, long paramLong1, long paramLong2, int paramInt)
  {
    NotificationModule localNotificationModule = this.mNotificationModule;
    if (localNotificationModule == null)
    {
      VasUpdateWrapper.getLog().e("VasUpdate_System", "onTaskItemProgress , notify = null");
      return;
    }
    localNotificationModule.notifyProgress(paramBusinessUpdateParams, paramLong1, paramLong2, paramInt);
  }
  
  public void onTaskSyncTableComplete(int paramInt1, int paramInt2, HashMap<String, ItemUpdateVerPtr> paramHashMap)
  {
    this.mTaskSyncReq = null;
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject2 = (Map.Entry)paramHashMap.next();
        if ((localObject2 != null) && (((Map.Entry)localObject2).getValue() != null))
        {
          localObject2 = (ItemUpdateVerPtr)((Map.Entry)localObject2).getValue();
          Object localObject4;
          if ((localObject2 != null) && (!TextUtils.isEmpty(((ItemUpdateVerPtr)localObject2).mItemId)))
          {
            if (((ItemUpdateVerPtr)localObject2).checkItemIsCurrentVersion())
            {
              ((ItemUpdateVerPtr)localObject2).mFrom = "silent_update";
              long l = CommonUtil.sParseBidId(((ItemUpdateVerPtr)localObject2).mItemId);
              ??? = CommonUtil.sParseScid(((ItemUpdateVerPtr)localObject2).mItemId);
              localObject4 = getObserver(l);
              if (localObject4 == null)
              {
                ??? = VasUpdateWrapper.getLog();
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("onTaskSyncTableComplete currentItem not register , itemId = ");
                ((StringBuilder)localObject4).append(((ItemUpdateVerPtr)localObject2).mItemId);
                ((IVasLog)???).e("VasUpdate_System", ((StringBuilder)localObject4).toString());
                VasUpdateWrapper.getDbManager().deleteItem(1, ((ItemUpdateVerPtr)localObject2).mItemId);
              }
              else
              {
                localObject4 = ((IBusinessCallback)localObject4).getBusinessItemInfo(l, (String)???);
                if (localObject4 == null)
                {
                  ??? = VasUpdateWrapper.getLog();
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("onTaskSyncTableComplete getItemInfo fail , itemId = ");
                  ((StringBuilder)localObject4).append(((ItemUpdateVerPtr)localObject2).mItemId);
                  ((IVasLog)???).e("VasUpdate_System", ((StringBuilder)localObject4).toString());
                  VasUpdateWrapper.getDbManager().deleteItem(1, ((ItemUpdateVerPtr)localObject2).mItemId);
                }
                else
                {
                  ??? = new BusinessUpdateParams(l, (String)???, ((ItemUpdateVerPtr)localObject2).mFrom);
                  if (!((BusinessItemInfo)localObject4).mIsCanUpdate) {
                    onTaskItemComplete((BusinessUpdateParams)???, paramInt2, 1, 0, "can update = false", null);
                  } else {
                    synchronized (this.mTempTaskMaps)
                    {
                      if ((this.mTempTaskMaps.containsKey(((ItemUpdateVerPtr)localObject2).mItemId)) && (this.mTempTaskMaps.get(((ItemUpdateVerPtr)localObject2).mItemId) != null))
                      {
                        ((BaseItemTask)this.mTempTaskMaps.get(((ItemUpdateVerPtr)localObject2).mItemId)).setDLFrom(paramInt2);
                        continue;
                      }
                      if (((ItemUpdateVerPtr)localObject2).mRunCount >= 10)
                      {
                        ??? = VasUpdateWrapper.getLog();
                        localObject4 = new StringBuilder();
                        ((StringBuilder)localObject4).append("onTaskSyncTableComplete item runcount >= 10 , delete, itemId = ");
                        ((StringBuilder)localObject4).append(((ItemUpdateVerPtr)localObject2).mItemId);
                        ((IVasLog)???).e("VasUpdate_System", ((StringBuilder)localObject4).toString());
                        VasUpdateWrapper.getDbManager().deleteItem(1, ((ItemUpdateVerPtr)localObject2).mItemId);
                        continue;
                      }
                      if (checkLastTime((ItemUpdateVerPtr)localObject2)) {
                        continue;
                      }
                      ((ArrayList)localObject1).add(localObject2);
                    }
                  }
                }
              }
            }
          }
          else
          {
            ??? = VasUpdateWrapper.getLog();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("onTaskSyncTableComplete node doesn't have updateItem , continue , itemId = ");
            ((StringBuilder)localObject4).append(((ItemUpdateVerPtr)localObject2).mItemId);
            ((IVasLog)???).e("VasUpdate_System", ((StringBuilder)localObject4).toString());
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
          localObject2 = VasUpdateWrapper.getLog();
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onTaskSyncTableComplete requestList currentItem not register , itemId = ");
          ((StringBuilder)???).append(((ItemUpdateVerPtr)localObject1).mItemId);
          ((IVasLog)localObject2).e("VasUpdate_System", ((StringBuilder)???).toString());
          VasUpdateWrapper.getDbManager().deleteItem(1, ((ItemUpdateVerPtr)localObject1).mItemId);
        }
        else
        {
          addItemVersionForStartRun((ItemUpdateVerPtr)localObject1, new BusinessUpdateParams(CommonUtil.sParseBidId(((ItemUpdateVerPtr)localObject1).mItemId), CommonUtil.sParseScid(((ItemUpdateVerPtr)localObject1).mItemId), ((ItemUpdateVerPtr)localObject1).mFrom), paramInt2);
        }
      }
    }
    paramHashMap = VasUpdateWrapper.getLog();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onTaskSyncTableComplete start update request , size = ");
    ((StringBuilder)localObject1).append(this.mTempTaskMaps.size());
    paramHashMap.d("VasUpdate_System", ((StringBuilder)localObject1).toString());
    if (paramInt1 > 0)
    {
      updatePollTime(paramInt1);
      this.mTimerModule.setTimer(2, paramInt1 * 1000, false);
    }
  }
  
  public void onTime(int paramInt)
  {
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTime type = ");
    localStringBuilder.append(paramInt);
    localIVasLog.i("VasUpdate_System", localStringBuilder.toString());
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      onTimeUpdateItem();
      return;
    }
    onTimeGetUrl();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.VasUpdateSystem
 * JD-Core Version:    0.7.0.1
 */