package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileAppStorePromoteConfigBean
  implements IQFileAppStorePromoteConfigBean, IQStorageSafable<String>
{
  public String a;
  public boolean a;
  public String b = "";
  public String c = "{}";
  
  public QFileAppStorePromoteConfigBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileAppStorePromoteConfigBean<QFile>", 1, "onParse: but configContent is null!");
    }
    this.c = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("actionSwitch")) {
        this.jdField_a_of_type_Boolean = paramString.getBoolean("actionSwitch");
      }
      if (paramString.has("actionHint")) {
        this.jdField_a_of_type_JavaLangString = paramString.getString("actionHint");
      }
      if (paramString.has("actionYYBDownloadUrl"))
      {
        this.b = paramString.getString("actionYYBDownloadUrl");
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileAppStorePromoteConfigBean<QFile>", 1, QLog.getStackTraceString(paramString));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteConfigBean
 * JD-Core Version:    0.7.0.1
 */