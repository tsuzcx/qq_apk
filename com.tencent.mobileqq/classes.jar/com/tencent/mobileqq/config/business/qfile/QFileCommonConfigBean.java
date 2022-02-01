package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileCommonConfigBean
  implements IQStorageSafable<String>
{
  public String a;
  public boolean a;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public boolean k = false;
  public boolean l = false;
  public boolean m = false;
  public boolean n = false;
  public boolean o = false;
  public boolean p = false;
  
  public QFileCommonConfigBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no troop");
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("videopreview");
      if (paramJSONObject == null)
      {
        QLog.e("QFileCommonConfigBean", 1, "parse Troop Json |type: 396no videoPreview");
        return;
      }
      this.m = paramJSONObject.getBoolean("switch");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopVideoPriview = ");
        localStringBuilder.append(this.m);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.n = paramJSONObject.getBoolean("svip");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("troopVideoPriview for SVIP = ");
        localStringBuilder.append(this.n);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.o = paramJSONObject.getBoolean("yearsvip");
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("troopVideoPriview for YearSVIP = ");
        paramJSONObject.append(this.n);
        QLog.d("QFileCommonConfigBean", 2, paramJSONObject.toString());
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileCommonConfigBean", 1, paramJSONObject, new Object[0]);
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no httpsJson");
      return;
    }
    try
    {
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("c2c_up");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_c2c_up = ");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.b = paramJSONObject.getBoolean("c2c_down");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_c2c_down = ");
        localStringBuilder.append(this.b);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.c = paramJSONObject.getBoolean("c2czip_down");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_c2czip_down = ");
        localStringBuilder.append(this.c);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.d = paramJSONObject.getBoolean("c2c_thumb");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_c2c_thumb = ");
        localStringBuilder.append(this.d);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.e = paramJSONObject.getBoolean("disc_up");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_disc_up = ");
        localStringBuilder.append(this.e);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.f = paramJSONObject.getBoolean("disc_down");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_disc_down = ");
        localStringBuilder.append(this.f);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.g = paramJSONObject.getBoolean("disczip_down");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_disczip_down = ");
        localStringBuilder.append(this.g);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.h = paramJSONObject.getBoolean("disc_thumb");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_disc_thumb = ");
        localStringBuilder.append(this.h);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.i = paramJSONObject.getBoolean("troop_up");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_troop_up = ");
        localStringBuilder.append(this.i);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.j = paramJSONObject.getBoolean("troop_down");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_troop_down = ");
        localStringBuilder.append(this.j);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.k = paramJSONObject.getBoolean("troopzip_down");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https_troopzip_down = ");
        localStringBuilder.append(this.k);
        QLog.d("QFileCommonConfigBean", 2, localStringBuilder.toString());
      }
      this.l = paramJSONObject.getBoolean("troop_thumb");
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("https_troop_thumb = ");
        paramJSONObject.append(this.l);
        QLog.d("QFileCommonConfigBean", 2, paramJSONObject.toString());
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileCommonConfigBean", 1, paramJSONObject, new Object[0]);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no mediaPlatformJson");
      return;
    }
    try
    {
      this.p = paramJSONObject.getBoolean("EnableAQQ");
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("enableFileMediaPlatform = ");
        paramJSONObject.append(this.p);
        QLog.d("QFileCommonConfigBean", 2, paramJSONObject.toString());
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileCommonConfigBean", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396configContent is empty");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      b(paramString.getJSONObject("https"));
      a(paramString.getJSONObject("troop"));
      c(paramString.getJSONObject("UseMediaPlatform"));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileCommonConfigBean", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileCommonConfigBean
 * JD-Core Version:    0.7.0.1
 */