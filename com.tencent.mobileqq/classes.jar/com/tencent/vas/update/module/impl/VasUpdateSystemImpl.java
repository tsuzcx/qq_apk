package com.tencent.vas.update.module.impl;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.DLReportInfo;
import com.tencent.vas.update.entity.DownloadResultParams;
import com.tencent.vas.update.entity.ReportItemParams;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.factory.api.ICmdManager;
import com.tencent.vas.update.factory.api.ICommonManager;
import com.tencent.vas.update.factory.api.IDbManager;
import com.tencent.vas.update.factory.api.IHttpDownloader;
import com.tencent.vas.update.factory.api.IReportManager;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.module.api.IDownloadModule;
import com.tencent.vas.update.module.api.INotificationModule;
import com.tencent.vas.update.module.api.ITimerModule;
import com.tencent.vas.update.module.api.IVasUpdateSystem;
import com.tencent.vas.update.module.thread.ThreadManager;
import com.tencent.vas.update.request.TaskBatchUrlReq;
import com.tencent.vas.update.request.TaskBatchUrlRsp;
import com.tencent.vas.update.request.TaskSyncReq;
import com.tencent.vas.update.request.TaskSyncRsp;
import com.tencent.vas.update.task.DownloadItemTask;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class VasUpdateSystemImpl
  implements IVasUpdateSystem
{
  private ITimerModule a = new TimerModuleImpl(this);
  private IDownloadModule b = new DownloadModuleImpl();
  private INotificationModule c;
  private final AtomicBoolean d = new AtomicBoolean(false);
  private ConcurrentHashMap<String, DownloadItemTask> e = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> f = new ConcurrentHashMap();
  private List<TaskBatchUrlReq> g = Collections.synchronizedList(new ArrayList());
  private Queue<ItemUpdateVerPtr> h;
  private ConcurrentHashMap<String, ItemUpdateVerPtr> i = new ConcurrentHashMap();
  private volatile boolean j = true;
  private TaskSyncReq k;
  private int l;
  
  private DownloadItemTask a(@NonNull ItemUpdateVerPtr paramItemUpdateVerPtr, @NonNull BusinessUpdateParams paramBusinessUpdateParams, int paramInt, String paramString)
  {
    Object localObject = a(CommonUtil.sParseBidId(paramString));
    if (localObject == null)
    {
      paramItemUpdateVerPtr = VasUpdateWrapper.getLog();
      paramBusinessUpdateParams = new StringBuilder();
      paramBusinessUpdateParams.append("addItemVersionForStartRun currentItem not register , itemId = ");
      paramBusinessUpdateParams.append(paramString);
      paramItemUpdateVerPtr.c("VasUpdate_System", paramBusinessUpdateParams.toString());
      VasUpdateWrapper.getDbManager().b(1, paramString);
      return null;
    }
    localObject = ((IBusinessCallback)localObject).getBusinessItemInfo(CommonUtil.sParseBidId(paramString), CommonUtil.sParseScid(paramString));
    if (localObject == null)
    {
      paramItemUpdateVerPtr = VasUpdateWrapper.getLog();
      paramBusinessUpdateParams = new StringBuilder();
      paramBusinessUpdateParams.append("addItemVersionForStartRun getItemInfo fail, itemId = ");
      paramBusinessUpdateParams.append(paramString);
      paramItemUpdateVerPtr.c("VasUpdate_System", paramBusinessUpdateParams.toString());
      VasUpdateWrapper.getDbManager().b(1, paramString);
      return null;
    }
    paramItemUpdateVerPtr = new DownloadItemTask(paramBusinessUpdateParams, paramItemUpdateVerPtr, (BusinessItemInfo)localObject);
    paramItemUpdateVerPtr.a(paramInt);
    return paramItemUpdateVerPtr;
  }
  
  private LinkedList<ItemUpdateVerPtr> a(int paramInt, HashMap<String, ItemUpdateVerPtr> paramHashMap)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject1 = (Map.Entry)paramHashMap.next();
        if ((localObject1 != null) && (((Map.Entry)localObject1).getValue() != null))
        {
          localObject1 = (ItemUpdateVerPtr)((Map.Entry)localObject1).getValue();
          if (!a(paramInt, (ItemUpdateVerPtr)localObject1)) {
            synchronized (this.e)
            {
              if ((this.e.containsKey(((ItemUpdateVerPtr)localObject1).mItemId)) && (this.e.get(((ItemUpdateVerPtr)localObject1).mItemId) != null))
              {
                ((DownloadItemTask)this.e.get(((ItemUpdateVerPtr)localObject1).mItemId)).a(paramInt);
              }
              else if (((ItemUpdateVerPtr)localObject1).mRunCount >= 10)
              {
                ??? = VasUpdateWrapper.getLog();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("onTaskSyncTableComplete item runcount >= 10 , delete, itemId = ");
                localStringBuilder.append(((ItemUpdateVerPtr)localObject1).mItemId);
                ((IVasLog)???).c("VasUpdate_System", localStringBuilder.toString());
                VasUpdateWrapper.getDbManager().b(1, ((ItemUpdateVerPtr)localObject1).mItemId);
              }
              else if (!a((ItemUpdateVerPtr)localObject1))
              {
                localLinkedList.add(localObject1);
              }
            }
          }
        }
      }
    }
    return localLinkedList;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.k != null)
    {
      paramString = TaskSyncRsp.parseResponseJson(paramString);
      this.k.handlePbResponse(paramInt, paramString);
    }
  }
  
  private void a(ItemUpdateVerPtr paramItemUpdateVerPtr, int paramInt)
  {
    if (paramItemUpdateVerPtr != null)
    {
      if (TextUtils.isEmpty(paramItemUpdateVerPtr.mItemId)) {
        return;
      }
      if (a(CommonUtil.sParseBidId(paramItemUpdateVerPtr.mItemId)) == null)
      {
        IVasLog localIVasLog = VasUpdateWrapper.getLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTaskSyncTableComplete requestList currentItem not register , itemId = ");
        localStringBuilder.append(paramItemUpdateVerPtr.mItemId);
        localIVasLog.c("VasUpdate_System", localStringBuilder.toString());
        VasUpdateWrapper.getDbManager().b(1, paramItemUpdateVerPtr.mItemId);
        return;
      }
      a(paramItemUpdateVerPtr, new BusinessUpdateParams(CommonUtil.sParseBidId(paramItemUpdateVerPtr.mItemId), CommonUtil.sParseScid(paramItemUpdateVerPtr.mItemId), paramItemUpdateVerPtr.mFrom), paramInt);
    }
  }
  
  private void a(@NonNull ItemUpdateVerPtr paramItemUpdateVerPtr, @NonNull BusinessUpdateParams paramBusinessUpdateParams, int paramInt)
  {
    if (a(paramItemUpdateVerPtr.mItemId))
    {
      paramItemUpdateVerPtr = VasUpdateWrapper.getLog();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("addItemVersionForStartRun currentItem is filter , itemId = ");
      ((StringBuilder)???).append(paramBusinessUpdateParams.mItemId);
      paramItemUpdateVerPtr.c("VasUpdate_System", ((StringBuilder)???).toString());
      return;
    }
    Object localObject2;
    if (this.d.get())
    {
      ??? = VasUpdateWrapper.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("addItemVersionForStartRun currentItem thread is lock , itemId = ");
      ((StringBuilder)localObject2).append(paramBusinessUpdateParams.mItemId);
      ((IVasLog)???).c("VasUpdate_System", ((StringBuilder)localObject2).toString());
    }
    synchronized (this.e)
    {
      localObject2 = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start addItemVersionForStartRun itemId = ");
      localStringBuilder.append(paramBusinessUpdateParams.mItemId);
      localStringBuilder.append(" mGetUrlTimerFinish = ");
      localStringBuilder.append(this.j);
      ((IVasLog)localObject2).c("VasUpdate_System", localStringBuilder.toString());
      if (this.e.containsKey(paramItemUpdateVerPtr.mItemId))
      {
        paramBusinessUpdateParams = VasUpdateWrapper.getLog();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addItemVersionForStartRun mTempTaskMaps hasContain itemid = ");
        ((StringBuilder)localObject2).append(paramItemUpdateVerPtr.mItemId);
        paramBusinessUpdateParams.c("VasUpdate_System", ((StringBuilder)localObject2).toString());
        return;
      }
      localObject2 = paramItemUpdateVerPtr.mItemId;
      paramItemUpdateVerPtr = a(paramItemUpdateVerPtr, paramBusinessUpdateParams, paramInt, (String)localObject2);
      if (paramItemUpdateVerPtr == null) {
        return;
      }
      this.e.put(localObject2, paramItemUpdateVerPtr);
      if ((paramInt != 3) && (this.e.size() < 50))
      {
        this.a.a(1);
        this.a.a(1, VasUpdateWrapper.getCommonManager().a(), false);
        return;
      }
      onTime(1);
      return;
    }
  }
  
  private boolean a(int paramInt, ItemUpdateVerPtr paramItemUpdateVerPtr)
  {
    if ((paramItemUpdateVerPtr != null) && (!TextUtils.isEmpty(paramItemUpdateVerPtr.mItemId)))
    {
      if (!paramItemUpdateVerPtr.checkItemIsCurrentVersion()) {
        return true;
      }
      paramItemUpdateVerPtr.mFrom = "silent_update";
      long l1 = CommonUtil.sParseBidId(paramItemUpdateVerPtr.mItemId);
      localObject1 = CommonUtil.sParseScid(paramItemUpdateVerPtr.mItemId);
      localObject2 = a(l1);
      if (localObject2 == null)
      {
        localObject1 = VasUpdateWrapper.getLog();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onTaskSyncTableComplete currentItem not register , itemId = ");
        ((StringBuilder)localObject2).append(paramItemUpdateVerPtr.mItemId);
        ((IVasLog)localObject1).c("VasUpdate_System", ((StringBuilder)localObject2).toString());
        VasUpdateWrapper.getDbManager().b(1, paramItemUpdateVerPtr.mItemId);
        return true;
      }
      localObject2 = ((IBusinessCallback)localObject2).getBusinessItemInfo(l1, (String)localObject1);
      if (localObject2 == null)
      {
        localObject1 = VasUpdateWrapper.getLog();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onTaskSyncTableComplete getItemInfo fail , itemId = ");
        ((StringBuilder)localObject2).append(paramItemUpdateVerPtr.mItemId);
        ((IVasLog)localObject1).c("VasUpdate_System", ((StringBuilder)localObject2).toString());
        VasUpdateWrapper.getDbManager().b(1, paramItemUpdateVerPtr.mItemId);
        return true;
      }
      paramItemUpdateVerPtr = new BusinessUpdateParams(l1, (String)localObject1, paramItemUpdateVerPtr.mFrom);
      if (!((BusinessItemInfo)localObject2).mIsCanUpdate)
      {
        localObject1 = new DownloadResultParams();
        ((DownloadResultParams)localObject1).a = paramInt;
        ((DownloadResultParams)localObject1).b = 1;
        ((DownloadResultParams)localObject1).c = 0;
        ((DownloadResultParams)localObject1).d = "can update = false";
        a(paramItemUpdateVerPtr, (DownloadResultParams)localObject1, null);
        return true;
      }
      return false;
    }
    Object localObject1 = VasUpdateWrapper.getLog();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onTaskSyncTableComplete node doesn't have updateItem , continue , itemId = ");
    ((StringBuilder)localObject2).append(paramItemUpdateVerPtr.mItemId);
    ((IVasLog)localObject1).c("VasUpdate_System", ((StringBuilder)localObject2).toString());
    return true;
  }
  
  private boolean a(@NonNull BusinessUpdateParams paramBusinessUpdateParams, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = ItemUpdateVerPtr.parseJsonToItemUpdateVerPrt(paramString);
      if (paramString != null)
      {
        long l1 = System.currentTimeMillis() / 1000L - paramString.mLastRunTime;
        if ((paramString.mRunCount >= 3) && (l1 >= 0L) && (l1 < 8L))
        {
          paramString = new DownloadResultParams();
          paramString.a = 3;
          paramString.b = 20;
          paramString.c = 0;
          paramString.d = " update delay retry ";
          a(paramBusinessUpdateParams, paramString, null);
          return true;
        }
        a(paramString, paramBusinessUpdateParams, 3);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(@NonNull ItemUpdateVerPtr paramItemUpdateVerPtr)
  {
    long l1 = System.currentTimeMillis() / 1000L - paramItemUpdateVerPtr.mLastRunTime;
    if ((paramItemUpdateVerPtr.mRunCount >= 3) && (l1 < 21600L))
    {
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTaskSyncTableComplete checkLastTime , itemId = ");
      localStringBuilder.append(paramItemUpdateVerPtr.mItemId);
      localStringBuilder.append(" time = ");
      localStringBuilder.append(l1);
      localIVasLog.c("VasUpdate_System", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    return this.f.containsKey(paramString);
  }
  
  private void b(int paramInt)
  {
    if ((this.h != null) && (this.i.size() <= 0))
    {
      localObject1 = VasUpdateWrapper.getLog();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleSyncQueue syncQueue size = ");
      ((StringBuilder)localObject2).append(this.h.size());
      ((StringBuilder)localObject2).append(" syncMap size = ");
      ((StringBuilder)localObject2).append(this.i.size());
      ((StringBuilder)localObject2).append(" mContineueFlag = ");
      ((StringBuilder)localObject2).append(this.l);
      ((IVasLog)localObject1).c("VasUpdate_System", ((StringBuilder)localObject2).toString());
      if ((this.h.size() == 0) && (this.l == 1))
      {
        c(4);
        return;
      }
      localObject1 = this.i;
      int m = 0;
      for (;;)
      {
        if (m < 50) {}
        try
        {
          if (this.h.size() > 0)
          {
            localObject2 = (ItemUpdateVerPtr)this.h.poll();
            if (localObject2 == null) {
              return;
            }
            this.i.put(((ItemUpdateVerPtr)localObject2).mItemId, localObject2);
            a((ItemUpdateVerPtr)localObject2, paramInt);
            m += 1;
          }
          else
          {
            return;
          }
        }
        finally {}
      }
    }
    Object localObject1 = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSyncQueue filter mSyncDownloadMap size = ");
    localStringBuilder.append(this.i.size());
    ((IVasLog)localObject1).c("VasUpdate_System", localStringBuilder.toString());
  }
  
  private void b(int paramInt, String paramString)
  {
    TaskBatchUrlRsp localTaskBatchUrlRsp = TaskBatchUrlRsp.parseResponse(paramString);
    if (localTaskBatchUrlRsp == null) {
      return;
    }
    paramString = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPbResponse response cookie = ");
    localStringBuilder.append(localTaskBatchUrlRsp.mCookie);
    paramString.b("VasUpdate_System", localStringBuilder.toString());
    localStringBuilder = null;
    synchronized (this.g)
    {
      Iterator localIterator = this.g.iterator();
      do
      {
        paramString = localStringBuilder;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (TaskBatchUrlReq)localIterator.next();
      } while ((paramString == null) || (paramString.getCookieId() != localTaskBatchUrlRsp.mCookie));
      localIterator.remove();
      if (paramString != null) {
        paramString.handlePbResponse(paramInt, localTaskBatchUrlRsp);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void c(int paramInt)
  {
    if ((!c()) && (paramInt != 4))
    {
      VasUpdateWrapper.getLog().c("VasUpdate_System", "doSyncTable enable = false");
      return;
    }
    Object localObject = this.h;
    if ((localObject != null) && (((Queue)localObject).size() != 0))
    {
      localObject = VasUpdateWrapper.getLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doSyncTable isDoing , queue size = ");
      localStringBuilder.append(this.h.size());
      ((IVasLog)localObject).c("VasUpdate_System", localStringBuilder.toString());
      return;
    }
    if (this.k != null)
    {
      VasUpdateWrapper.getLog().a("VasUpdate_System", "doSyncTable request != null");
      return;
    }
    localObject = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start doSyncTable dlFrom = ");
    localStringBuilder.append(paramInt);
    ((IVasLog)localObject).a("VasUpdate_System", localStringBuilder.toString());
    this.a.a(2);
    this.k = new TaskSyncReq(paramInt);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.getInstance().post(new VasUpdateSystemImpl.2(this));
      return;
    }
    d();
  }
  
  private void c(@NonNull BusinessUpdateParams paramBusinessUpdateParams)
  {
    Object localObject1 = paramBusinessUpdateParams.mFrom;
    String str = paramBusinessUpdateParams.mItemId;
    Object localObject2 = VasUpdateWrapper.getLog();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("selfDownloadItem params = \n");
    ((StringBuilder)localObject3).append(paramBusinessUpdateParams.toString());
    ((IVasLog)localObject2).b("VasUpdate_System", ((StringBuilder)localObject3).toString());
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new DownloadResultParams();
      ((DownloadResultParams)localObject1).a = 3;
      ((DownloadResultParams)localObject1).b = 11;
      ((DownloadResultParams)localObject1).c = 0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("current from = null , itemId ");
      ((StringBuilder)localObject2).append(str);
      ((DownloadResultParams)localObject1).d = ((StringBuilder)localObject2).toString();
      a(paramBusinessUpdateParams, (DownloadResultParams)localObject1, null);
      return;
    }
    localObject2 = VasUpdateWrapper.getDbManager().a(1, str);
    localObject3 = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("selfDownloadItem select should_update , ItemId = ");
    localStringBuilder.append(str);
    localStringBuilder.append(" , content = ");
    localStringBuilder.append((String)localObject2);
    ((IVasLog)localObject3).b("VasUpdate_System", localStringBuilder.toString());
    if (a(paramBusinessUpdateParams, (String)localObject2)) {
      return;
    }
    localObject3 = VasUpdateWrapper.getDbManager().a(0, str);
    localObject2 = VasUpdateWrapper.getLog();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("selfDownloadItem select local , ItemId = ");
    localStringBuilder.append(str);
    localStringBuilder.append(" , content = ");
    localStringBuilder.append((String)localObject3);
    ((IVasLog)localObject2).b("VasUpdate_System", localStringBuilder.toString());
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
    a((ItemUpdateVerPtr)localObject2, paramBusinessUpdateParams, 3);
  }
  
  private boolean c()
  {
    try
    {
      long l1 = Long.parseLong(VasUpdateWrapper.getDbManager().a(3, "time_value"));
      long l2 = Long.parseLong(VasUpdateWrapper.getDbManager().a(3, "time_success"));
      long l3 = VasUpdateWrapper.getCommonManager().g();
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("syncEnable timeValue = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" offest = ");
      l2 = l3 - l2;
      localStringBuilder.append(l2);
      localIVasLog.b("VasUpdate_System", localStringBuilder.toString());
      return l2 >= l1;
    }
    catch (Throwable localThrowable)
    {
      VasUpdateWrapper.getLog().a("VasUpdate_System", "doSyncTable exception", localThrowable);
      localThrowable.printStackTrace();
    }
    return true;
  }
  
  private void d()
  {
    TaskSyncReq localTaskSyncReq = this.k;
    if (localTaskSyncReq != null)
    {
      localTaskSyncReq.loadSeqConfig();
      int m = 0;
      try
      {
        boolean bool = VasUpdateWrapper.getCmdManager().a("SyncVCRReq", this.k.getRequest(), this);
        m = bool;
      }
      catch (Throwable localThrowable)
      {
        VasUpdateWrapper.getLog().a("VasUpdate_System", "sendSyncRequest exception", localThrowable);
        localThrowable.printStackTrace();
      }
      if (m == 0) {
        this.k.onSendPbMsgError();
      }
    }
  }
  
  private void d(int paramInt)
  {
    VasUpdateWrapper.getDbManager().a(3, "time_value", String.valueOf(paramInt));
    VasUpdateWrapper.getDbManager().a(3, "time_success", String.valueOf(VasUpdateWrapper.getCommonManager().g()));
  }
  
  private void e()
  {
    c(2);
  }
  
  private void f()
  {
    TaskBatchUrlReq localTaskBatchUrlReq = new TaskBatchUrlReq();
    synchronized (this.e)
    {
      this.d.compareAndSet(false, true);
      Object localObject4 = this.e.entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        localTaskBatchUrlReq.addTask((String)localEntry.getKey(), (DownloadItemTask)localEntry.getValue());
      }
      this.e.clear();
      this.d.set(false);
      this.j = true;
      ??? = VasUpdateWrapper.getLog();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("onTimeGetUrl ， mGetUrlTimerFinish = ");
      ((StringBuilder)localObject4).append(this.j);
      ((IVasLog)???).b("VasUpdate_System", ((StringBuilder)localObject4).toString());
      synchronized (this.g)
      {
        if (localTaskBatchUrlReq.getTaskCount() > 0)
        {
          this.g.add(localTaskBatchUrlReq);
          localObject4 = localTaskBatchUrlReq.getRequest();
          if (!VasUpdateWrapper.getCmdManager().a("GetUrlReq", (String)localObject4, this))
          {
            localTaskBatchUrlReq.onSendPbMsgError();
            this.g.remove(localTaskBatchUrlReq);
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
  
  public IBusinessCallback a(long paramLong)
  {
    INotificationModule localINotificationModule = this.c;
    if (localINotificationModule == null)
    {
      VasUpdateWrapper.getLog().c("VasUpdate_System", "getObserver , notification = null");
      return null;
    }
    return localINotificationModule.a(paramLong);
  }
  
  public void a()
  {
    c(1);
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, HashMap<String, ItemUpdateVerPtr> paramHashMap)
  {
    this.k = null;
    paramHashMap = a(paramInt2, paramHashMap);
    Object localObject = this.h;
    if (localObject == null) {
      this.h = paramHashMap;
    } else {
      ((Queue)localObject).addAll(paramHashMap);
    }
    paramHashMap = VasUpdateWrapper.getLog();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTaskSyncTableComplete mSyncItemList size = ");
    ((StringBuilder)localObject).append(this.h.size());
    paramHashMap.c("VasUpdate_System", ((StringBuilder)localObject).toString());
    b(paramInt2);
    paramHashMap = VasUpdateWrapper.getLog();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTaskSyncTableComplete start update request , size = ");
    ((StringBuilder)localObject).append(this.e.size());
    paramHashMap.a("VasUpdate_System", ((StringBuilder)localObject).toString());
    if (paramInt1 > 0)
    {
      d(paramInt1);
      this.a.a(2, paramInt1 * 1000, false);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelDownload bid = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" scid = ");
    localStringBuilder.append(paramString);
    localIVasLog.b("VasUpdate_System", localStringBuilder.toString());
    VasUpdateWrapper.getHttpDownloader().a(CommonUtil.sComposeItemId(paramLong, paramString));
  }
  
  public void a(BusinessUpdateParams paramBusinessUpdateParams)
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
      localIVasLog.b("VasUpdate_System", localStringBuilder.toString());
      ThreadManager.getInstance().post(new VasUpdateSystemImpl.1(this, paramBusinessUpdateParams));
      return;
    }
    throw new RuntimeException("system request download business or params = null or bid <= 0");
  }
  
  public void a(BusinessUpdateParams paramBusinessUpdateParams, long paramLong1, long paramLong2, int paramInt)
  {
    INotificationModule localINotificationModule = this.c;
    if (localINotificationModule == null)
    {
      VasUpdateWrapper.getLog().c("VasUpdate_System", "onTaskItemProgress , notify = null");
      return;
    }
    localINotificationModule.a(paramBusinessUpdateParams, paramLong1, paramLong2, paramInt);
  }
  
  public void a(@NonNull BusinessUpdateParams paramBusinessUpdateParams, @NonNull DownloadResultParams arg2, DLReportInfo paramDLReportInfo)
  {
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTaskItemComplete itemId = ");
    localStringBuilder.append(paramBusinessUpdateParams.mItemId);
    localStringBuilder.append(", errorCode = ");
    localStringBuilder.append(???.b);
    localStringBuilder.append(" , httpCode = ");
    localStringBuilder.append(???.c);
    localIVasLog.b("VasUpdate_System", localStringBuilder.toString());
    if (this.c == null)
    {
      VasUpdateWrapper.getLog().c("VasUpdate_System", "onTaskItemComplete , notify = null");
      return;
    }
    if (???.b != 0) {
      this.c.a(paramBusinessUpdateParams, ???.b, ???.c, ???.d);
    } else {
      this.c.a(paramBusinessUpdateParams);
    }
    ??? = new ReportItemParams(???, CommonUtil.sParseBidId(paramBusinessUpdateParams.mItemId), CommonUtil.sParseScid(paramBusinessUpdateParams.mItemId));
    if (paramDLReportInfo != null)
    {
      ???.d = paramDLReportInfo.mDstMd5;
      ???.e = paramDLReportInfo.mIsIncrement;
      ???.h = paramDLReportInfo.mRetryCount;
      VasUpdateWrapper.getReportManager().a(???);
    }
    else
    {
      ???.d = "";
      ???.e = false;
      ???.h = 0;
      VasUpdateWrapper.getReportManager().a(???);
    }
    synchronized (this.i)
    {
      this.i.remove(paramBusinessUpdateParams.mItemId);
      b(5);
      return;
    }
  }
  
  public void a(INotificationModule paramINotificationModule)
  {
    this.c = paramINotificationModule;
  }
  
  public IDownloadModule b()
  {
    return this.b;
  }
  
  public void b(BusinessUpdateParams paramBusinessUpdateParams)
  {
    if (paramBusinessUpdateParams == null) {
      return;
    }
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addFilterTaskItem params = ");
    localStringBuilder.append(paramBusinessUpdateParams.toString());
    localIVasLog.b("VasUpdate_System", localStringBuilder.toString());
    this.f.put(paramBusinessUpdateParams.mItemId, paramBusinessUpdateParams.mItemId);
  }
  
  public void onPbResponse(int paramInt, String paramString1, String paramString2)
  {
    if (VasUpdateWrapper.getLog().a())
    {
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPbResponse cmd = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" result = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" response = ");
      localStringBuilder.append(paramString2);
      localIVasLog.b("VasUpdate_System", localStringBuilder.toString());
    }
    if ("GetUrlRsp".equalsIgnoreCase(paramString1))
    {
      b(paramInt, paramString2);
      return;
    }
    if ("SyncVCRRsp".equalsIgnoreCase(paramString1)) {
      a(paramInt, paramString2);
    }
  }
  
  public void onTime(int paramInt)
  {
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTime type = ");
    localStringBuilder.append(paramInt);
    localIVasLog.b("VasUpdate_System", localStringBuilder.toString());
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      e();
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.VasUpdateSystemImpl
 * JD-Core Version:    0.7.0.1
 */