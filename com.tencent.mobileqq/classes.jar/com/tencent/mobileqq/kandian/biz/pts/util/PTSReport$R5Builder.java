package com.tencent.mobileqq.kandian.biz.pts.util;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.pts.loaders.PTSAppLoader;
import com.tencent.mobileqq.kandian.biz.pts.loaders.PTSEngineLoader;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PTSReport$R5Builder
{
  private JSONObject a;
  
  public PTSReport$R5Builder()
  {
    this.a = new JSONObject();
    b();
  }
  
  public PTSReport$R5Builder(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        this.a = new JSONObject(paramString);
        b();
        return;
      }
      catch (JSONException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(paramString);
        QLog.e("PTSReport", 1, localStringBuilder.toString());
        this.a = new JSONObject();
        b();
        return;
      }
    }
    this.a = new JSONObject();
    b();
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        this.a.put("os", "1");
        this.a.put("version", "8.8.17");
        this.a.put("pts_engine_version", PTSEngineLoader.a().e());
        this.a.put("pts_app_version", PTSAppLoader.a().d());
        this.a.put("sdk_version", String.valueOf(Build.VERSION.SDK_INT));
        JSONObject localJSONObject = this.a;
        boolean bool = TextUtils.isEmpty(Build.BRAND);
        localObject2 = "";
        if (!bool)
        {
          Object localObject1 = Build.BRAND;
          localJSONObject.put("device_brand", localObject1);
          localJSONObject = this.a;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(Build.MODEL)) {
            localObject1 = Build.MODEL;
          }
          localJSONObject.put("device_model", localObject1);
          this.a.put("is_debug", "0");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[initCommonField], e = ");
        ((StringBuilder)localObject2).append(localJSONException);
        QLog.e("PTSReport", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      String str = "";
    }
  }
  
  public R5Builder a(String paramString1, String paramString2)
  {
    try
    {
      this.a.put(paramString1, paramString2);
      return this;
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[addString], e = ");
      paramString2.append(paramString1);
      QLog.e("PTSReport", 1, paramString2.toString());
    }
    return this;
  }
  
  public String a()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSReport.R5Builder
 * JD-Core Version:    0.7.0.1
 */