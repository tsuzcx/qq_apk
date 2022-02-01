package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileIPv6ConfigBean
  implements IQStorageSafable<String>
{
  public int a;
  public boolean a;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  
  public QFileIPv6ConfigBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("configID:449 onParse FileIPv6Config:");
    localStringBuilder.append(paramString);
    QLog.i("QFileIPv6ConfigBean", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.toLowerCase();
    } else {
      paramString = "";
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("QFileIPv6ConfigBean", 1, "FileIPv6ConfigContent is empty, configID:449 use default value");
      a();
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("ipv6config");
      if (paramString != null)
      {
        if (paramString.has("allswitch")) {
          this.jdField_a_of_type_Boolean = paramString.getBoolean("allswitch");
        } else {
          this.jdField_a_of_type_Boolean = false;
        }
        if (paramString.has("c2cenable")) {
          this.b = paramString.getBoolean("c2cenable");
        } else {
          this.b = false;
        }
        if (paramString.has("groupenable")) {
          this.c = paramString.getBoolean("groupenable");
        } else {
          this.c = false;
        }
        if (paramString.has("discenable")) {
          this.d = paramString.getBoolean("discenable");
        } else {
          this.d = false;
        }
        if (paramString.has("datalineenable")) {
          this.e = paramString.getBoolean("datalineenable");
        } else {
          this.e = false;
        }
        if (paramString.has("strategy"))
        {
          this.jdField_a_of_type_Int = paramString.getInt("strategy");
          return;
        }
        this.jdField_a_of_type_Int = 0;
        return;
      }
      QLog.w("QFileIPv6ConfigBean", 1, "FileIPv6ConfigContent is no ipv6config. use default value");
      a();
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileIPv6ConfigBean", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileIPv6ConfigBean
 * JD-Core Version:    0.7.0.1
 */