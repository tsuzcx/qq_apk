package com.tencent.tmassistant.st;

import android.os.Handler;
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
  private static volatile SDKReportManager2 sInstance = null;
  private long mBatchReportInterval = 1800000L;
  private int mBatchReportMaxCount = 50;
  private Map<Integer, ArrayList<String>> mPostCache = new ConcurrentHashMap();
  private Handler mPostHandler;
  private int mReportRetryCount = 2;
  private h mStatReportEngine;
  private SparseArray<ArrayList<StatItem>> mTimelyStatListCache = new SparseArray();
  
  private SDKReportManager2()
  {
    ab.c("SDKReportManager2", "<init>SDKReportManager2() process : " + s.e());
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
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      Iterator localIterator = ((Map)localObject1).keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
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
        ab.c("SDKReportManager2", "batchReport type = " + ((StatItem)localObject2).type + " records = " + com.tencent.tmdownloader.internal.notification.g.a(((StatItem)localObject2).records));
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
        ab.c("SDKReportManager2", ">>cacheDataOnFailed saveReportItemToDB type = " + k + " saveData = " + com.tencent.tmdownloader.internal.notification.g.a(paramArrayList));
        com.tencent.tmdownloader.internal.storage.table.a.a(String.valueOf(k), paramArrayList);
        i += 1;
      }
    }
    ab.c("SDKReportManager2", ">>cacheDataOnFailed exit");
  }
  
  public static SDKReportManager2 getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new SDKReportManager2();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void initConfig()
  {
    com.tencent.tmdownloader.internal.a.a.a().b();
    BatchReportConfig localBatchReportConfig = b.a().b();
    if ((localBatchReportConfig != null) && (localBatchReportConfig.batchReportInterval > 0L))
    {
      ab.c("SDKReportManager2", ">>BatchReportConfig != null BatchReportConfig.batchReportInterval = " + localBatchReportConfig.batchReportInterval + " BatchReportConfig.batchReportMaxCount = " + localBatchReportConfig.batchReportMaxCount);
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
    ab.c("SDKReportManager2", ">>onStatReportFinish reportLog onReportFinish errorCode = " + paramInt2);
    paramStatReportRequest = (ArrayList)this.mTimelyStatListCache.get(paramInt1);
    if (paramInt2 != 0) {
      cacheDataOnFailed(paramStatReportRequest);
    }
    this.mTimelyStatListCache.delete(paramInt1);
  }
  
  /* Error */
  public void postReport(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 87	com/tencent/tmassistantbase/util/s:a	()Z
    //   5: ifne +41 -> 46
    //   8: ldc 17
    //   10: new 61	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 346
    //   20: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokestatic 74	com/tencent/tmassistantbase/util/s:e	()Ljava/lang/String;
    //   26: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 83	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokestatic 351	com/tencent/tmdownloader/f:a	()Lcom/tencent/tmdownloader/f;
    //   38: iload_1
    //   39: aload_2
    //   40: invokevirtual 353	com/tencent/tmdownloader/f:a	(ILjava/lang/String;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: ldc 17
    //   48: new 61	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 355
    //   58: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_1
    //   62: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc_w 357
    //   68: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 359
    //   78: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokestatic 74	com/tencent/tmassistantbase/util/s:e	()Ljava/lang/String;
    //   84: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 83	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: iload_1
    //   94: iflt +85 -> 179
    //   97: aload_2
    //   98: invokestatic 365	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifne +78 -> 179
    //   104: aload_0
    //   105: getfield 51	com/tencent/tmassistant/st/SDKReportManager2:mPostCache	Ljava/util/Map;
    //   108: iload_1
    //   109: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: invokeinterface 178 2 0
    //   117: checkcast 139	java/util/ArrayList
    //   120: astore 4
    //   122: aload 4
    //   124: astore_3
    //   125: aload 4
    //   127: ifnonnull +26 -> 153
    //   130: new 139	java/util/ArrayList
    //   133: dup
    //   134: invokespecial 140	java/util/ArrayList:<init>	()V
    //   137: astore_3
    //   138: aload_0
    //   139: getfield 51	com/tencent/tmassistant/st/SDKReportManager2:mPostCache	Ljava/util/Map;
    //   142: iload_1
    //   143: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aload_3
    //   147: invokeinterface 368 3 0
    //   152: pop
    //   153: aload_3
    //   154: aload_2
    //   155: invokevirtual 188	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   158: pop
    //   159: aload_0
    //   160: getfield 132	com/tencent/tmassistant/st/SDKReportManager2:mPostHandler	Landroid/os/Handler;
    //   163: iconst_1
    //   164: invokevirtual 371	android/os/Handler:removeMessages	(I)V
    //   167: aload_0
    //   168: getfield 132	com/tencent/tmassistant/st/SDKReportManager2:mPostHandler	Landroid/os/Handler;
    //   171: iconst_1
    //   172: ldc2_w 372
    //   175: invokevirtual 215	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   178: pop
    //   179: ldc 17
    //   181: ldc_w 375
    //   184: invokestatic 83	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: goto -144 -> 43
    //   190: astore_2
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_2
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	SDKReportManager2
    //   0	195	1	paramInt	int
    //   0	195	2	paramString	String
    //   124	30	3	localArrayList1	ArrayList
    //   120	6	4	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	43	190	finally
    //   46	93	190	finally
    //   97	122	190	finally
    //   130	153	190	finally
    //   153	179	190	finally
    //   179	187	190	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.st.SDKReportManager2
 * JD-Core Version:    0.7.0.1
 */