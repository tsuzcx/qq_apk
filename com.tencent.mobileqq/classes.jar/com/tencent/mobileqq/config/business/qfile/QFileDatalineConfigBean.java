package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileDatalineConfigBean
  implements IQFileDatalineConfigBean, IQStorageSafable<String>
{
  public boolean a = false;
  public boolean b = false;
  public long c = 104857600L;
  public long d = 3145728L;
  public long e = 3000L;
  public String f = "{}";
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileDatalineConfigBean", 1, "onParse: but configContent is null!");
    }
    paramString = paramString.toLowerCase();
    this.f = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.has("switch")) {
        return;
      }
      this.a = paramString.getBoolean("switch");
      if (!paramString.has("options")) {
        return;
      }
      paramString = paramString.getJSONObject("options");
      if (paramString.has("offline"))
      {
        JSONObject localJSONObject = paramString.getJSONObject("offline");
        this.c = localJSONObject.getLong("onlyofflinesize");
        this.d = localJSONObject.getLong("autodown");
      }
      if (paramString.has("wlan"))
      {
        this.e = paramString.getJSONObject("wlan").getLong("offlinedealy");
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileDatalineConfigBean", 1, QLog.getStackTraceString(paramString));
    }
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("switch", paramBoolean);
      Object localObject2 = localJSONObject2.optJSONObject("options");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONObject();
      }
      Object localObject3 = localJSONObject2.optJSONObject("offline");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new JSONObject();
      }
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("wlan");
      localObject3 = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject3 = new JSONObject();
      }
      ((JSONObject)localObject2).put("onlyofflinesize", this.c);
      ((JSONObject)localObject2).put("autodown", this.d);
      ((JSONObject)localObject3).put("offlinedealy", this.e);
      ((JSONObject)localObject1).putOpt("offline", localObject2);
      ((JSONObject)localObject1).putOpt("wlan", localObject3);
      localJSONObject2.putOpt("options", localObject1);
      localObject1 = localJSONObject2.toString();
      localObject2 = paramAppRuntime.getApplicationContext();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("file_config_");
      ((StringBuilder)localObject3).append(paramAppRuntime.getCurrentUin());
      paramAppRuntime = ((Context)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 4).edit();
      paramAppRuntime.putString("file_dataline_key", (String)localObject1);
      paramAppRuntime.apply();
      return;
    }
    catch (JSONException paramAppRuntime)
    {
      QLog.e("QFileDatalineConfigBean", 1, QLog.getStackTraceString(paramAppRuntime));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileDatalineConfigBean
 * JD-Core Version:    0.7.0.1
 */