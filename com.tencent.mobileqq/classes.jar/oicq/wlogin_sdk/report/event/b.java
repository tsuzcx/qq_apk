package oicq.wlogin_sdk.report.event;

import java.util.Date;
import java.util.HashMap;
import oicq.wlogin_sdk.report.c;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tools.util;

public class b
{
  private static String a;
  
  public static void a(a parama)
  {
    String str1 = new Date().toString();
    String str2 = String.valueOf(2473L);
    if (a == null) {
      a = t.m();
    }
    StringBuffer localStringBuffer = new StringBuffer(util.LOG_TAG_EVENT_REPORT);
    localStringBuffer.append(",type=");
    localStringBuffer.append(parama.a());
    localStringBuffer.append(",subType=");
    localStringBuffer.append(parama.b());
    localStringBuffer.append(",detail=");
    localStringBuffer.append(parama.d());
    localStringBuffer.append(",isRealTime=");
    localStringBuffer.append(parama.e());
    localStringBuffer.append(",isImmediatelyUpload=");
    localStringBuffer.append(parama.f());
    localStringBuffer.append(",uin=");
    localStringBuffer.append(parama.g());
    localStringBuffer.append(",time=");
    localStringBuffer.append(str1);
    localStringBuffer.append(",version=");
    localStringBuffer.append(str2);
    localStringBuffer.append(",process=");
    localStringBuffer.append(a);
    HashMap localHashMap = parama.c();
    localHashMap.put("user_id", parama.g());
    localHashMap.put("sub_type", parama.b());
    localHashMap.put("detail", parama.d());
    localHashMap.put("wt_version", str2);
    localHashMap.put("happen_time", str1);
    localHashMap.put("process", a);
    c.a(parama);
    util.LOGI(localStringBuffer.toString(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.report.event.b
 * JD-Core Version:    0.7.0.1
 */