package com.tencent.tmassistant.st;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.tmassistant.common.jce.BatchReportConfig;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.storage.b;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.tmassistant.common.jce.StatItem;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SDKReportManager2
  implements d, INetworkChangedObserver
{
  private static final int MSG_BATCH_REPORT = 2;
  private static final int MSG_POST_REPORT = 1;
  private static final String TAG = "SDKReportManager2";
  private static volatile SDKReportManager2 sInstance;
  private long mBatchReportInterval = 1800000L;
  private int mBatchReportMaxCount = 50;
  private Map<Integer, ArrayList<String>> mPostCache = new ConcurrentHashMap();
  private Handler mPostHandler;
  private int mReportRetryCount = 2;
  private h mStatReportEngine;
  private SparseArray<ArrayList<StatItem>> mTimelyStatListCache = new SparseArray();
  
  private SDKReportManager2()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<init>SDKReportManager2() process : ");
    localStringBuilder.append(s.e());
    ab.c("SDKReportManager2", localStringBuilder.toString());
    if (!s.a())
    {
      k.a().post(new e(this));
      return;
    }
    this.mStatReportEngine = new h();
    this.mStatReportEngine.a(this);
    initHandler();
    initConfig();
    registerNetWork();
  }
  
  private void batchReport()
  {
    Object localObject1 = com.tencent.tmdownloader.internal.storage.table.a.c();
    Object localObject2 = new ArrayList();
    Object localObject3;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject3 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        int i = ((Integer)((Iterator)localObject3).next()).intValue();
        ArrayList localArrayList = (ArrayList)((Map)localObject1).get(Integer.valueOf(i));
        if (localArrayList.size() > 0) {
          ((ArrayList)localObject2).add(new StatItem(i, localArrayList));
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      this.mStatReportEngine.a((ArrayList)localObject2);
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StatItem)((Iterator)localObject1).next();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("batchReport type = ");
        ((StringBuilder)localObject3).append(((StatItem)localObject2).type);
        ((StringBuilder)localObject3).append(" records = ");
        ((StringBuilder)localObject3).append(com.tencent.tmdownloader.internal.notification.g.a(((StatItem)localObject2).records));
        ab.c("SDKReportManager2", ((StringBuilder)localObject3).toString());
      }
    }
    this.mPostHandler.sendEmptyMessageDelayed(2, this.mBatchReportInterval);
  }
  
  private void cacheDataOnFailed(ArrayList<StatItem> paramArrayList)
  {
    ab.c("SDKReportManager2", ">>cacheDataOnFailed enter");
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      SparseArray localSparseArray = new SparseArray();
      Iterator localIterator = paramArrayList.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        StatItem localStatItem = (StatItem)localIterator.next();
        localObject = (List)localSparseArray.get(localStatItem.type);
        paramArrayList = (ArrayList<StatItem>)localObject;
        if (localObject == null)
        {
          paramArrayList = new ArrayList();
          localSparseArray.put(localStatItem.type, paramArrayList);
        }
        paramArrayList.addAll(localStatItem.records);
      }
      int j = localSparseArray.size();
      int i = 0;
      while (i < j)
      {
        int k = localSparseArray.keyAt(i);
        localObject = (List)localSparseArray.get(k);
        paramArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramArrayList.add((String)((Iterator)localObject).next());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(">>cacheDataOnFailed saveReportItemToDB type = ");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" saveData = ");
        ((StringBuilder)localObject).append(com.tencent.tmdownloader.internal.notification.g.a(paramArrayList));
        ab.c("SDKReportManager2", ((StringBuilder)localObject).toString());
        com.tencent.tmdownloader.internal.storage.table.a.a(String.valueOf(k), paramArrayList);
        i += 1;
      }
    }
    ab.c("SDKReportManager2", ">>cacheDataOnFailed exit");
  }
  
  public static SDKReportManager2 getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new SDKReportManager2();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void initConfig()
  {
    com.tencent.tmdownloader.internal.a.a.a().b();
    BatchReportConfig localBatchReportConfig = b.a().b();
    if ((localBatchReportConfig != null) && (localBatchReportConfig.batchReportInterval > 0L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>BatchReportConfig != null BatchReportConfig.batchReportInterval = ");
      localStringBuilder.append(localBatchReportConfig.batchReportInterval);
      localStringBuilder.append(" BatchReportConfig.batchReportMaxCount = ");
      localStringBuilder.append(localBatchReportConfig.batchReportMaxCount);
      ab.c("SDKReportManager2", localStringBuilder.toString());
      this.mBatchReportInterval = localBatchReportConfig.batchReportInterval;
      this.mBatchReportMaxCount = localBatchReportConfig.batchReportMaxCount;
      this.mReportRetryCount = localBatchReportConfig.reportRetryCount;
    }
  }
  
  private void initHandler()
  {
    this.mPostHandler = new f(this, k.a(l.a));
    this.mPostHandler.sendEmptyMessage(2);
  }
  
  private void registerNetWork()
  {
    NetworkMonitorReceiver.getInstance().registerReceiver();
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this);
  }
  
  private void timlyReport()
  {
    Object localObject = this.mPostCache.keySet();
    if ((localObject != null) && (((Set)localObject).size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((Set)localObject).iterator();
      int i;
      while (((Iterator)localObject).hasNext())
      {
        i = ((Integer)((Iterator)localObject).next()).intValue();
        if ((i > 0) && (this.mPostCache.get(Integer.valueOf(i)) != null))
        {
          StatItem localStatItem = new StatItem();
          localStatItem.type = i;
          localStatItem.records = ((ArrayList)this.mPostCache.get(Integer.valueOf(i)));
          localArrayList.add(localStatItem);
        }
      }
      this.mPostCache.clear();
      if (localArrayList.size() > 0)
      {
        i = this.mStatReportEngine.a(localArrayList);
        ab.c("SDKReportManager2", "timelyReport");
        this.mTimelyStatListCache.put(i, localArrayList);
      }
    }
  }
  
  public void onNetworkChanged()
  {
    k.a().post(new g(this));
  }
  
  public void onStatReportFinish(int paramInt1, StatReportRequest paramStatReportRequest, StatReportResponse paramStatReportResponse, int paramInt2)
  {
    paramStatReportRequest = new StringBuilder();
    paramStatReportRequest.append(">>onStatReportFinish reportLog onReportFinish errorCode = ");
    paramStatReportRequest.append(paramInt2);
    ab.c("SDKReportManager2", paramStatReportRequest.toString());
    paramStatReportRequest = (ArrayList)this.mTimelyStatListCache.get(paramInt1);
    if (paramInt2 != 0) {
      cacheDataOnFailed(paramStatReportRequest);
    }
    this.mTimelyStatListCache.delete(paramInt1);
  }
  
  public void postReport(int paramInt, String paramString)
  {
    try
    {
      if (!s.a())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(">>postReport not in sdk process, post report at SDK process,current process : ");
        ((StringBuilder)localObject).append(s.e());
        ab.c("SDKReportManager2", ((StringBuilder)localObject).toString());
        com.tencent.tmdownloader.f.a().a(paramInt, paramString);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>postReport type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" data = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",process:");
      ((StringBuilder)localObject).append(s.e());
      ab.c("SDKReportManager2", ((StringBuilder)localObject).toString());
      if ((paramInt >= 0) && (!TextUtils.isEmpty(paramString)))
      {
        ArrayList localArrayList = (ArrayList)this.mPostCache.get(Integer.valueOf(paramInt));
        localObject = localArrayList;
        if (localArrayList == null)
        {
          localObject = new ArrayList();
          this.mPostCache.put(Integer.valueOf(paramInt), localObject);
        }
        ((ArrayList)localObject).add(paramString);
        this.mPostHandler.removeMessages(1);
        this.mPostHandler.sendEmptyMessageDelayed(1, 500L);
      }
      ab.c("SDKReportManager2", ">>postReport exit");
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.st.SDKReportManager2
 * JD-Core Version:    0.7.0.1
 */