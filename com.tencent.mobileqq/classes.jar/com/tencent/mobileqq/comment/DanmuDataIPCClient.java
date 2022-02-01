package com.tencent.mobileqq.comment;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DanmuDataIPCClient
  extends QIPCModule
  implements IDanmakuClearListener
{
  public static boolean a;
  private static volatile DanmuDataIPCClient b;
  private List<DanmuDataIPCClient.DanmuCacheObserver> c = new ArrayList();
  
  private DanmuDataIPCClient()
  {
    super("DanmuDataIPCClient");
  }
  
  public static DanmuDataIPCClient a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new DanmuDataIPCClient();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void b()
  {
    DanmuDataIPCClient localDanmuDataIPCClient = a();
    if (!a)
    {
      QIPCClientHelper.getInstance().register(localDanmuDataIPCClient);
      a = true;
      QLog.d("DanmuDataIPCClient", 1, "registerModule");
    }
  }
  
  public Bundle a(String paramString, Bundle paramBundle)
  {
    if ("qipc_action_get_barrage".equals(paramString))
    {
      long l1 = paramBundle.getLong("key_barrage_msg_seq");
      long l2 = paramBundle.getLong("key_barrage_grp_uin");
      int i = paramBundle.getInt("key_barrage_topic_type");
      Object localObject = DanmuDataHolder.a().a(l2, l1);
      localObject = DanmuDataHolder.a().a((String)localObject);
      boolean bool;
      if (localObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("DanmuDataIPCClient", 2, new Object[] { "get barrage list, msgSeq:", Long.valueOf(l1), " groupUin:", Long.valueOf(l2), " topicType:", Integer.valueOf(i), " peakCached:", Boolean.valueOf(bool) });
      if (bool) {
        QLog.d("DanmuDataIPCClient", 2, new Object[] { "peak listSize:", Integer.valueOf(((DanmuDataHolder.CacheHolder)localObject).i.size()), ", fullList:", ((DanmuDataHolder.CacheHolder)localObject).i.toString() });
      }
      paramBundle.putBoolean("key_barrage_is_update", bool);
      paramBundle.putLong("key_barrage_req_time", System.currentTimeMillis());
      QIPCClientHelper.getInstance().getClient().callServer("DanmuDataIPCServer", "qipc_action_get_barrage", paramBundle, new DanmuDataIPCClient.1(this));
    }
    if ("qipc_action_clear_cache".equals(paramString)) {
      QIPCClientHelper.getInstance().getClient().callServer("DanmuDataIPCServer", "qipc_action_clear_cache", null);
    }
    return null;
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    QLog.d("DanmuDataIPCClient", 1, "getDanmuList start");
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_barrage_msg_seq", paramLong1);
      localBundle.putLong("key_barrage_grp_uin", paramLong2);
      localBundle.putInt("key_barrage_topic_type", paramInt);
      a().a("qipc_action_get_barrage", localBundle);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("DanmuDataIPCClient", 1, "getDanmuList fail, ", localException);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle.setClassLoader(DanmuItemBean.class.getClassLoader());
    long l1 = paramBundle.getLong("key_barrage_msg_seq");
    long l2 = paramBundle.getLong("key_barrage_grp_uin");
    int k = paramBundle.getInt("key_barrage_topic_type");
    boolean bool = paramBundle.getBoolean("key_barrage_is_success");
    int m = paramBundle.getInt("key_barrage_interval_time");
    if (QLog.isColorLevel()) {
      QLog.d("DanmuDataIPCClient", 2, new Object[] { "handleGetBarrageEIPCResult, topicSeq:", Long.valueOf(l1), " groupUin:", Long.valueOf(l2), " topicType:", Integer.valueOf(k), " isSuccess:", Boolean.valueOf(bool) });
    }
    if (paramBundle.containsKey("key_barrage_req_time"))
    {
      long l4 = paramBundle.getLong("key_barrage_req_time");
      long l5 = paramBundle.getLong("key_barrage_net_req_time");
      long l3 = paramBundle.getLong("key_barrage_net_response_time");
      l4 = l5 - l4;
      l5 = l3 - l5;
      l3 = System.currentTimeMillis() - l3;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("ipcReqCost", String.valueOf(l4));
      ((HashMap)localObject1).put("netReqCost", String.valueOf(l5));
      ((HashMap)localObject1).put("ipcRspCost", String.valueOf(l3));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "DanmuPullCost", false, 0L, 0L, (HashMap)localObject1, null);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataIPCClient", 2, new Object[] { "handleGetBarrageEIPCResult, ipcReqCost:", Long.valueOf(l4), " netReqCost:", Long.valueOf(l5), " ipcRspCost:", Long.valueOf(l3) });
      }
    }
    ArrayList localArrayList = paramBundle.getParcelableArrayList("key_barrage_danmu_list");
    Object localObject2 = paramBundle.getLongArray("key_barrage_del_seq_list");
    int i;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((localObject2 != null) && (localObject2.length > 0)) {
      j = 1;
    } else {
      j = 0;
    }
    String str = DanmuDataHolder.a().a(l2, l1);
    Object localObject1 = DanmuDataHolder.a().a(str);
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = DanmuDataHolder.a().b(str);
    }
    if ((bool) && ((i != 0) || (j != 0)))
    {
      if (QLog.isColorLevel())
      {
        if (localArrayList != null) {
          i = localArrayList.size();
        } else {
          i = 0;
        }
        if (localObject2 != null) {
          j = localObject2.length;
        } else {
          j = 0;
        }
        QLog.d("DanmuDataIPCClient", 2, new Object[] { "handleGetBarrageEIPCResult, danmuItemList size:", Integer.valueOf(i), " delSeqArr size:", Integer.valueOf(j) });
      }
      localObject1 = new ArrayList(localObject2.length);
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        ((List)localObject1).add(Long.valueOf(localObject2[i]));
        i += 1;
      }
      localObject2 = new DanmuDataContext(l2, l1, k, true);
      paramBundle.a(localArrayList).b((List)localObject1).a((DanmuDataContext)localObject2).a(null).c();
    }
    if ((bool) && (paramBundle != null) && (!paramBundle.i.isEmpty()))
    {
      localObject1 = this.c.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((DanmuDataIPCClient.DanmuCacheObserver)((Iterator)localObject1).next()).a(l1, String.valueOf(l2), m, paramBundle.i);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DanmuDataIPCClient", 2, "handleGetBarrageEIPCResult end");
    }
  }
  
  public void a(DanmuDataIPCClient.DanmuCacheObserver paramDanmuCacheObserver)
  {
    if ((paramDanmuCacheObserver != null) && (!this.c.contains(paramDanmuCacheObserver))) {
      this.c.add(paramDanmuCacheObserver);
    }
  }
  
  public void b(DanmuDataIPCClient.DanmuCacheObserver paramDanmuCacheObserver)
  {
    if ((paramDanmuCacheObserver != null) && (this.c.contains(paramDanmuCacheObserver))) {
      this.c.remove(paramDanmuCacheObserver);
    }
  }
  
  public void c()
  {
    DanmuDataHolder.a().b();
    a("qipc_action_clear_cache", null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("qipc_action_get_barrage_result".equals(paramString))
    {
      a(paramBundle);
    }
    else if ("qipc_action_send_barrage".equals(paramString))
    {
      paramBundle.setClassLoader(DanmuItemBean.class.getClassLoader());
      paramString = (DanmuItemBean)paramBundle.getParcelable("key_barrage_danmu_msg");
      long l = paramBundle.getLong("key_barrage_msg_seq");
      paramBundle = paramBundle.getString("key_barrage_grp_uin");
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((DanmuDataIPCClient.DanmuCacheObserver)localIterator.next()).a(l, paramBundle, paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuDataIPCClient
 * JD-Core Version:    0.7.0.1
 */