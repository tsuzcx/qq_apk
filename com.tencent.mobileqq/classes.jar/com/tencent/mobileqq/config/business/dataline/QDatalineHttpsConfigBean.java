package com.tencent.mobileqq.config.business.dataline;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QDatalineHttpsConfigBean
  implements IQStorageSafable<String>
{
  public String a;
  public boolean a;
  public boolean b = false;
  
  public QDatalineHttpsConfigBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QDatalineHttpsConfigBean", 1, "receiveAllConfigs|type: 637configContent is empty");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.getJSONObject("UseNewHttpClient");
      if (localObject != null) {
        try
        {
          this.jdField_a_of_type_Boolean = ((JSONObject)localObject).getBoolean("AQQ");
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("UseNewHttpClient = ");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
            QLog.d("QDatalineHttpsConfigBean", 2, ((StringBuilder)localObject).toString());
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.e("QDatalineHttpsConfigBean", 1, localJSONException, new Object[0]);
        }
      }
      paramString = paramString.getJSONObject("UseHttps");
      if (paramString != null) {
        try
        {
          this.b = paramString.getBoolean("AQQ");
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("UseHttpsConnect = ");
            paramString.append(this.b);
            QLog.d("QDatalineHttpsConfigBean", 2, paramString.toString());
            return;
          }
        }
        catch (JSONException paramString)
        {
          QLog.e("QDatalineHttpsConfigBean", 1, paramString, new Object[0]);
          return;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QDatalineHttpsConfigBean", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.dataline.QDatalineHttpsConfigBean
 * JD-Core Version:    0.7.0.1
 */