package com.tencent.mobileqq.config.splashlogo;

import bmqa;
import com.tencent.qphone.base.util.QLog;
import oat;
import org.json.JSONObject;

public final class KandianConfigServlet$2
  implements Runnable
{
  public KandianConfigServlet$2(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      bmqa.a(localJSONObject);
      oat.a(null, null, this.a, this.a, 0, 0, this.b, this.c, null, localJSONObject.toString(), false);
      QLog.d("KandianConfigServlet", 1, "reportID:" + this.a + " reportKDConfigFailed  isAll:" + this.b + "  errorCode:" + this.c);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("KandianConfigServlet", 1, "reportKDConfigFailed ecception:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.KandianConfigServlet.2
 * JD-Core Version:    0.7.0.1
 */