package com.tencent.mobileqq.service.message;

import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class MsgCacheStrategyReport
{
  public static void a(MessageCache paramMessageCache, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        long l1 = System.nanoTime();
        HashMap localHashMap = new HashMap();
        localHashMap.put("isFirstOpen", String.valueOf(paramInt3));
        Object localObject1 = UinTypeUtil.a(paramString, paramInt1);
        Object localObject2 = MessageCache.b;
        if ((localObject2 != null) && (MessageCache.b.containsKey(localObject1)))
        {
          localObject1 = (MessageCache.MsgCacheStrategyParam)MessageCache.b.get(localObject1);
          localHashMap.put("isInited", String.valueOf(((MessageCache.MsgCacheStrategyParam)localObject1).jdField_a_of_type_Boolean));
          localHashMap.put("isMsgExisted", String.valueOf(((MessageCache.MsgCacheStrategyParam)localObject1).b));
          localHashMap.put("msgCostTime", String.valueOf(((MessageCache.MsgCacheStrategyParam)localObject1).jdField_a_of_type_Long));
        }
        else
        {
          localHashMap.put("isInited", "true");
          localHashMap.put("isMsgExisted", "true");
          localHashMap.put("msgCostTime", "0");
        }
        if (paramInt1 == 1)
        {
          i = paramMessageCache.c(paramString);
          paramString = ((IRecentUserProxyService)paramMessageCache.a().getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().a(paramString, paramInt1);
          int j = -2;
          if (paramString == null) {
            break label627;
          }
          j = paramString.a;
          k = paramString.b;
          m = paramString.c;
          paramString = paramMessageCache.a().a().b();
          localObject1 = paramString.keySet();
          if (((Set)localObject1).size() <= 0) {
            break label641;
          }
          n = ((Set)localObject1).size();
          localObject1 = ((Set)localObject1).iterator();
          paramInt3 = 0;
          if (!((Iterator)localObject1).hasNext()) {
            break label638;
          }
          localObject2 = (String)((Iterator)localObject1).next();
          if (paramString.get(localObject2) == null) {
            continue;
          }
          paramInt3 += ((List)paramString.get(localObject2)).size();
          continue;
          localHashMap.put("uintype", String.valueOf(paramInt1));
          localHashMap.put("recentLoc", String.valueOf(j));
          localHashMap.put("activeConvLoc", String.valueOf(k));
          localHashMap.put("convCount", String.valueOf(m));
          localHashMap.put("msgFrom", String.valueOf(paramInt2));
          localHashMap.put("troopSpeType", String.valueOf(i));
          localHashMap.put("msgCacheSize", String.valueOf(paramInt3));
          localHashMap.put("cacheSize", String.valueOf(n));
          localHashMap.put("isCacheExpired", String.valueOf(MessageCache.jdField_a_of_type_Boolean));
          long l2 = Runtime.getRuntime().freeMemory() / 1024L / 1024L;
          long l3 = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
          long l4 = Runtime.getRuntime().maxMemory() / 1024L / 1024L;
          localHashMap.put("freeMemory", String.valueOf(l2));
          localHashMap.put("totalMemory", String.valueOf(l3));
          localHashMap.put("maxMemory", String.valueOf(l4));
          localHashMap.put("cacheVersion", "2");
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramMessageCache.a().getCurrentAccountUin(), "msg_cache_strategy_tag", true, StartupTracker.jdField_a_of_type_Long, 0L, localHashMap, "");
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.ChatFragment", 2, new Object[] { "AIOTime reportMsgCacheStrategy cost:%d ", Long.valueOf((System.nanoTime() - l1) / 1000000L), " param: ", localHashMap });
          }
          return;
        }
      }
      catch (Exception paramMessageCache)
      {
        paramMessageCache.printStackTrace();
        return;
      }
      int i = 1;
      continue;
      label627:
      int k = -2;
      int m = -2;
      continue;
      label638:
      continue;
      label641:
      paramInt3 = 0;
      int n = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MsgCacheStrategyReport
 * JD-Core Version:    0.7.0.1
 */