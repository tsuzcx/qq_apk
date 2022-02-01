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
  public long a;
  public String a;
  public boolean a;
  public long b;
  public boolean b;
  public long c = 3000L;
  
  public QFileDatalineConfigBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 104857600L;
    this.jdField_b_of_type_Long = 3145728L;
    this.jdField_a_of_type_JavaLangString = "{}";
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileDatalineConfigBean", 1, "onParse: but configContent is null!");
    }
    paramString = paramString.toLowerCase();
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.has("switch")) {
        return;
      }
      this.jdField_a_of_type_Boolean = paramString.getBoolean("switch");
      if (!paramString.has("options")) {
        return;
      }
      paramString = paramString.getJSONObject("options");
      if (paramString.has("offline"))
      {
        JSONObject localJSONObject = paramString.getJSONObject("offline");
        this.jdField_a_of_type_Long = localJSONObject.getLong("onlyofflinesize");
        this.jdField_b_of_type_Long = localJSONObject.getLong("autodown");
      }
      if (paramString.has("wlan"))
      {
        this.c = paramString.getJSONObject("wlan").getLong("offlinedealy");
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
      ((JSONObject)localObject2).put("onlyofflinesize", this.jdField_a_of_type_Long);
      ((JSONObject)localObject2).put("autodown", this.jdField_b_of_type_Long);
      ((JSONObject)localObject3).put("offlinedealy", this.c);
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
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public long c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileDatalineConfigBean
 * JD-Core Version:    0.7.0.1
 */