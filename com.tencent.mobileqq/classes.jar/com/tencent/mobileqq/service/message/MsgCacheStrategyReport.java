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
    label654:
    label660:
    for (;;)
    {
      long l1;
      HashMap localHashMap;
      int i1;
      int n;
      try
      {
        l1 = System.nanoTime();
        localHashMap = new HashMap();
        localHashMap.put("isFirstOpen", String.valueOf(paramInt3));
        Object localObject = UinTypeUtil.a(paramString, paramInt1);
        if ((MessageCache.b != null) && (MessageCache.b.containsKey(localObject)))
        {
          localObject = (MessageCache.MsgCacheStrategyParam)MessageCache.b.get(localObject);
          localHashMap.put("isInited", String.valueOf(((MessageCache.MsgCacheStrategyParam)localObject).jdField_a_of_type_Boolean));
          localHashMap.put("isMsgExisted", String.valueOf(((MessageCache.MsgCacheStrategyParam)localObject).b));
          localHashMap.put("msgCostTime", String.valueOf(((MessageCache.MsgCacheStrategyParam)localObject).jdField_a_of_type_Long));
          if (paramInt1 != 1) {
            break label654;
          }
          i = paramMessageCache.c(paramString);
          paramString = ((IRecentUserProxyService)paramMessageCache.a().getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().a(paramString, paramInt1);
          if (paramString == null) {
            break label639;
          }
          k = paramString.a;
          j = paramString.b;
          m = paramString.c;
          paramString = paramMessageCache.a().a().b();
          i1 = 0;
          paramInt3 = 0;
          localObject = paramString.keySet();
          if (((Set)localObject).size() <= 0) {
            break label629;
          }
          n = ((Set)localObject).size();
          localObject = ((Set)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (paramString.get(str) == null) {
              break label626;
            }
            paramInt3 = ((List)paramString.get(str)).size() + paramInt3;
            break label660;
          }
        }
        else
        {
          localHashMap.put("isInited", "true");
          localHashMap.put("isMsgExisted", "true");
          localHashMap.put("msgCostTime", "0");
          continue;
        }
        localHashMap.put("uintype", String.valueOf(paramInt1));
      }
      catch (Exception paramMessageCache)
      {
        paramMessageCache.printStackTrace();
        return;
      }
      for (;;)
      {
        localHashMap.put("recentLoc", String.valueOf(k));
        localHashMap.put("activeConvLoc", String.valueOf(j));
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
        if ((m - 5 <= n) || (n >= 40)) {
          break;
        }
        return;
        label626:
        break label660;
        label629:
        n = 0;
        paramInt3 = i1;
      }
      label639:
      int m = -2;
      int j = -2;
      int k = -2;
      continue;
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MsgCacheStrategyReport
 * JD-Core Version:    0.7.0.1
 */