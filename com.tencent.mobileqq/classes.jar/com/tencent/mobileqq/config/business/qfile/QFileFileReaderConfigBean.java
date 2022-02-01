package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileFileReaderConfigBean
  implements IQStorageSafable<String>
{
  public String a;
  public boolean a;
  
  public QFileFileReaderConfigBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "{}";
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileFileReaderConfigBean<QFile>", 1, "onParse: but configContent is null!");
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("barShowSwitch")) {
          this.jdField_a_of_type_Boolean = paramString.getBoolean("barShowSwitch");
        }
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("QFileFileReaderConfigBean<QFile>", 1, QLog.getStackTraceString(paramString));
      }
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileFileReaderConfigBean
 * JD-Core Version:    0.7.0.1
 */