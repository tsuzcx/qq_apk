package oicq.wlogin_sdk.report.event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tools.util;

public class c
{
  private static String a;
  private static SimpleDateFormat b = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
  
  public static void a(b paramb)
  {
    String str1 = b.format(new Date());
    String str2 = String.valueOf(2477L);
    if (a == null) {
      a = t.m();
    }
    StringBuilder localStringBuilder = new StringBuilder(util.LOG_TAG_EVENT_REPORT);
    localStringBuilder.append(",type=");
    localStringBuilder.append(paramb.a());
    localStringBuilder.append(",subType=");
    localStringBuilder.append(paramb.b());
    localStringBuilder.append(",detail=");
    localStringBuilder.append(paramb.d());
    localStringBuilder.append(",isRealTime=");
    localStringBuilder.append(paramb.e());
    localStringBuilder.append(",isImmediatelyUpload=");
    localStringBuilder.append(paramb.f());
    localStringBuilder.append(",uin=");
    localStringBuilder.append(paramb.g());
    localStringBuilder.append(",time=");
    localStringBuilder.append(str1);
    localStringBuilder.append(",version=");
    localStringBuilder.append(str2);
    localStringBuilder.append(",process=");
    localStringBuilder.append(a);
    localStringBuilder.append(",isReportAtta=");
    localStringBuilder.append(paramb.h());
    HashMap localHashMap = paramb.c();
    if (!localHashMap.isEmpty())
    {
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(",");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry.getValue());
      }
    }
    localHashMap.put("user_id", paramb.g());
    localHashMap.put("sub_type", paramb.b());
    localHashMap.put("detail", paramb.d());
    localHashMap.put("wt_version", str2);
    localHashMap.put("happen_time", str1);
    localHashMap.put("process", a);
    oicq.wlogin_sdk.report.c.a(paramb);
    util.LOGI(localStringBuilder.toString(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.report.event.c
 * JD-Core Version:    0.7.0.1
 */