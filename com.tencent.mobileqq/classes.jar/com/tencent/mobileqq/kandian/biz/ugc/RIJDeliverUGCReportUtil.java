package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJDeliverUGCReportUtil
{
  public static void a()
  {
    PublicAccountReportUtils.a(null, "", "0X800B26E", "0X800B26E", 0, 0, "", "", "", "", false);
  }
  
  public static void a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("publisher_type", 1);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("RIJDeliverUGCReportUtil", 2, localJSONException, new Object[0]);
    }
    PublicAccountReportUtils.a(null, "", "0X800B25C", "0X800B25C", 0, 0, String.valueOf(paramInt), "", "", localJSONObject.toString(), false);
  }
  
  public static void a(String paramString)
  {
    PublicAccountReportUtils.a(null, "", "0X800B262", "0X800B262", 0, 0, paramString, "", "", "", false);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    PublicAccountReportUtils.a(null, "", "0X800B26D", "0X800B26D", 0, 0, paramString1, String.valueOf(paramInt), "", paramString2, false);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    PublicAccountReportUtils.a(null, "", "0X800B264", "0X800B264", 0, 0, paramString1, paramString2, "", "", false);
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar == 0) || (paramChar == '\t') || (paramChar == '\n') || (paramChar == '\r') || ((paramChar >= ' ') && (paramChar <= 55295)) || ((paramChar >= 57344) && (paramChar <= 65533)) || ((paramChar >= 65536) && (paramChar <= 1114111));
  }
  
  public static void b()
  {
    PublicAccountReportUtils.a(null, "", "0X800B25D", "0X800B25D", 0, 0, "", "", "", "", false);
  }
  
  public static void b(String paramString)
  {
    PublicAccountReportUtils.a(null, "", "0X800B267", "0X800B267", 0, 0, paramString, "", "", "", false);
  }
  
  public static void c()
  {
    PublicAccountReportUtils.a(null, "", "0X800B25E", "0X800B25E", 0, 0, "", "", "", "", false);
  }
  
  public static void c(String paramString)
  {
    PublicAccountReportUtils.a(null, "", "0X800B26C", "0X800B26C", 0, 0, paramString, "", "", "", false);
  }
  
  public static void d()
  {
    PublicAccountReportUtils.a(null, "", "0X800B25F", "0X800B25F", 0, 0, "", "", "", "", false);
  }
  
  public static void d(String paramString)
  {
    PublicAccountReportUtils.a(null, "", "0x800BC45", "0x800BC45", 0, 0, "", "", "", paramString, false);
  }
  
  public static void e()
  {
    PublicAccountReportUtils.a(null, "", "0X800B260", "0X800B260", 0, 0, "", "", "", "", false);
  }
  
  public static boolean e(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!a(paramString.charAt(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void f()
  {
    PublicAccountReportUtils.a(null, "", "0X800B261", "0X800B261", 0, 0, "", "", "", "", false);
  }
  
  public static void g()
  {
    PublicAccountReportUtils.a(null, "", "0X800B263", "0X800B263", 0, 0, "", "", "", "", false);
  }
  
  public static void h()
  {
    PublicAccountReportUtils.a(null, "", "0X800B265", "0X800B265", 0, 0, "", "", "", "", false);
  }
  
  public static void i()
  {
    PublicAccountReportUtils.a(null, "", "0X800B266", "0X800B266", 0, 0, "", "", "", "", false);
  }
  
  public static void j()
  {
    PublicAccountReportUtils.a(null, "", "0X800B268", "0X800B268", 0, 0, "", "", "", "", false);
  }
  
  public static void k()
  {
    PublicAccountReportUtils.a(null, "", "0X800B269", "0X800B269", 0, 0, "", "", "", "", false);
  }
  
  public static void l()
  {
    PublicAccountReportUtils.a(null, "", "0X800B26A", "0X800B26A", 0, 0, "", "", "", "", false);
  }
  
  public static void m()
  {
    PublicAccountReportUtils.a(null, "", "0X800B26B", "0X800B26B", 0, 0, "", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJDeliverUGCReportUtil
 * JD-Core Version:    0.7.0.1
 */