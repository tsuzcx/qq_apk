package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileAppStorePromoteDialogConfigBean
  implements IQStorageSafable<String>
{
  public String a;
  public boolean a;
  
  public QFileAppStorePromoteDialogConfigBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "{}";
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileAppStorePromoteDialogConfigBean<QFile>", 1, "onParse: but configContent is null!");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("dialogSwitch")) {
        this.jdField_a_of_type_Boolean = paramString.getBoolean("dialogSwitch");
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileAppStorePromoteDialogConfigBean<QFile>", 1, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteDialogConfigBean
 * JD-Core Version:    0.7.0.1
 */