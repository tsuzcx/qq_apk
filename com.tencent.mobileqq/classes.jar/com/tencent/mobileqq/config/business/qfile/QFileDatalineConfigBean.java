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
  implements IQStorageSafable<String>
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
      if (paramString.has("options"))
      {
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
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileDatalineConfigBean", 1, QLog.getStackTraceString(paramString));
    }
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    label225:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject4 = new JSONObject();
        localJSONObject4.put("switch", paramBoolean);
        Object localObject = localJSONObject4.optJSONObject("options");
        if (localObject != null) {
          break label225;
        }
        localObject = new JSONObject();
        JSONObject localJSONObject1 = localJSONObject4.optJSONObject("offline");
        if (localJSONObject1 == null)
        {
          localJSONObject1 = new JSONObject();
          JSONObject localJSONObject3 = localJSONObject4.optJSONObject("wlan");
          JSONObject localJSONObject2 = localJSONObject3;
          if (localJSONObject3 == null) {
            localJSONObject2 = new JSONObject();
          }
          localJSONObject1.put("onlyofflinesize", this.jdField_a_of_type_Long);
          localJSONObject1.put("autodown", this.jdField_b_of_type_Long);
          localJSONObject2.put("offlinedealy", this.c);
          ((JSONObject)localObject).putOpt("offline", localJSONObject1);
          ((JSONObject)localObject).putOpt("wlan", localJSONObject2);
          localJSONObject4.putOpt("options", localObject);
          localObject = localJSONObject4.toString();
          paramAppRuntime = paramAppRuntime.getApplicationContext().getSharedPreferences("file_config_" + paramAppRuntime.getCurrentUin(), 4).edit();
          paramAppRuntime.putString("file_dataline_key", (String)localObject);
          paramAppRuntime.apply();
          return;
        }
      }
      catch (JSONException paramAppRuntime)
      {
        QLog.e("QFileDatalineConfigBean", 1, QLog.getStackTraceString(paramAppRuntime));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileDatalineConfigBean
 * JD-Core Version:    0.7.0.1
 */