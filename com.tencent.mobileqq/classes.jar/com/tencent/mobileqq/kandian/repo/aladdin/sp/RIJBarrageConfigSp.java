package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJBarrageConfigSp
{
  public static String a()
  {
    return (String)RIJSPUtils.a("BARRAGE_CONFIG_KEY", "");
  }
  
  public static JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(a());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return new JSONObject();
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBarrageConfig value=");
      localStringBuilder.append(paramString);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("BARRAGE_CONFIG_KEY", paramString);
  }
  
  public static String b()
  {
    return (String)RIJSPUtils.a("VIDEO_BARRAGE_CONFIG_KEY", "");
  }
  
  public static JSONObject b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(b());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return new JSONObject();
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateVideoBarrageConfig value=");
      localStringBuilder.append(paramString);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("VIDEO_BARRAGE_CONFIG_KEY", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJBarrageConfigSp
 * JD-Core Version:    0.7.0.1
 */