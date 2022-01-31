package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.b.h;
import com.tencent.tvkbeacon.core.b.i;
import com.tencent.tvkbeacon.core.c.b;
import com.tencent.tvkbeacon.core.c.d;
import com.tencent.tvkbeacon.core.info.IccIdJNI;
import com.tencent.tvkbeacon.core.info.e;
import com.tencent.tvkbeacon.core.protocol.event.EventRecord;
import com.tencent.tvkbeacon.event.UserAction;
import com.tencent.tvkbeacon.g.QimeiSDK;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k
{
  public static RDBean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramString2 == null) {
      return null;
    }
    e locale = e.b(UserAction.mContext);
    if (locale == null)
    {
      com.tencent.tvkbeacon.core.c.c.d("[event] BeaconInfo is null!", new Object[0]);
      return null;
    }
    String str3 = UserAction.getUserID(paramString1);
    long l = com.tencent.tvkbeacon.core.c.a.a(locale.i());
    String str2 = locale.h();
    String str1 = d.c(paramContext);
    if (str1 == null) {
      str1 = "null";
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      if (paramMap != null) {
        localHashMap.putAll(paramMap);
      }
      int j = 0;
      int i = j;
      if (EventStrategyBean.getInstance().isTidyEventFields())
      {
        i = j;
        if (!com.tencent.tvkbeacon.core.c.a.c(paramString2)) {
          i = 1;
        }
      }
      paramMap = com.tencent.tvkbeacon.core.info.c.a(paramContext);
      if (i == 0)
      {
        localHashMap.put("A1", String.valueOf(str3));
        str3 = paramMap.h();
        if ((str3 != null) && (!str3.equals(""))) {
          localHashMap.put("QQ", String.valueOf(str3));
        }
        localHashMap.put("A32", IccIdJNI.a());
        localHashMap.put("A141", QimeiSDK.getInstance().getBeaconIdInfo(paramContext));
        localHashMap.put("A143", paramMap.g());
        localHashMap.put("A2", paramMap.a());
        localHashMap.put("A4", paramMap.c());
        localHashMap.put("A6", paramMap.b());
        localHashMap.put("A7", paramMap.d());
        localHashMap.put("A3", QimeiSDK.getInstance().getQimeiInternal());
        localHashMap.put("A23", locale.a(paramString1));
        localHashMap.put("A31", paramMap.e());
        localHashMap.put("A67", com.tencent.tvkbeacon.core.info.a.g(paramContext));
        localHashMap.put("A76", com.tencent.tvkbeacon.core.info.a.a());
        if (!localHashMap.containsKey("A95")) {
          localHashMap.put("A95", com.tencent.tvkbeacon.core.info.a.c(paramContext));
        }
        if (!paramBoolean2) {
          break label634;
        }
      }
      label634:
      for (paramString1 = "Y";; paramString1 = "N")
      {
        localHashMap.put("A99", paramString1);
        localHashMap.put("A34", String.valueOf(l));
        paramContext = h.a(paramContext).c();
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramContext = (i)paramContext.get(0);
          paramString1 = paramContext.getEventSerialNumber(paramString2, paramBoolean2);
          if (paramString1 != null) {
            localHashMap.put("A100", paramString1);
          }
          localHashMap.put("A88", paramContext.getAppFirstInstallTime());
        }
        if (!"".equals(locale.l())) {
          localHashMap.put("A113", locale.l());
        }
        paramContext = new RDBean();
        paramContext.setEN(String.valueOf(paramString2));
        paramContext.setTM(l);
        paramContext.setTP("UA");
        paramContext.setEMap(localHashMap);
        paramContext.setImmediatelyUpload(paramBoolean3);
        paramContext.setApn(str1);
        paramContext.setSrcIp(str2);
        paramContext.setEventResult(paramBoolean1);
        paramContext.setElapse(paramLong1);
        paramContext.setSize(paramLong2);
        return paramContext;
      }
    }
  }
  
  public static EventRecord a(RDBean paramRDBean)
  {
    if ((paramRDBean == null) || (!"UA".equals(paramRDBean.getTP()))) {}
    Map localMap;
    do
    {
      return null;
      localMap = paramRDBean.getEMap();
    } while (localMap == null);
    try
    {
      EventRecord localEventRecord = new EventRecord();
      localEventRecord.eventName = paramRDBean.getEN();
      localEventRecord.eventTime = paramRDBean.getTM();
      if (paramRDBean.getApn() != null)
      {
        str = paramRDBean.getApn();
        localEventRecord.apn = str;
        if (paramRDBean.getSrcIp() == null) {
          break label127;
        }
      }
      label127:
      for (String str = paramRDBean.getSrcIp();; str = localEventRecord.srcIp)
      {
        localEventRecord.srcIp = str;
        localEventRecord.cosumeTime = paramRDBean.getElapse();
        localEventRecord.eventResult = paramRDBean.isEventResult();
        localEventRecord.packageSize = paramRDBean.getSize();
        localEventRecord.eventValue = b.a(localMap);
        return localEventRecord;
        str = localEventRecord.apn;
        break;
      }
      return null;
    }
    catch (Throwable paramRDBean)
    {
      com.tencent.tvkbeacon.core.c.c.a(paramRDBean);
      com.tencent.tvkbeacon.core.c.c.d(paramRDBean.getMessage(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.k
 * JD-Core Version:    0.7.0.1
 */