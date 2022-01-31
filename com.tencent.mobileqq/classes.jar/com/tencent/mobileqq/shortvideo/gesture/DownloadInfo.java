package com.tencent.mobileqq.shortvideo.gesture;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.BusinessCommonConfig.ConfigInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DownloadInfo
  extends BusinessCommonConfig.ConfigInfo
{
  double a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  String f;
  String g;
  String h;
  public String i;
  public String j;
  String k;
  
  public static SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.qavgesture", 4);
  }
  
  public static DownloadInfo a()
  {
    String str = a().getString("config", null);
    if (TextUtils.isEmpty(str)) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return null;
      localDownloadInfo = new DownloadInfo();
    } while (!localDownloadInfo.a("QavGesture", str));
    return localDownloadInfo;
  }
  
  protected boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Double = paramJSONObject.getDouble("time");
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("enable");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("url_zip_so");
      this.c = paramJSONObject.getString("MD5_zip_so");
      this.d = paramJSONObject.getString("url_zip_model");
      this.e = paramJSONObject.getString("MD5_zip_model");
      this.f = paramJSONObject.getString("MD5_so");
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("so_fullname");
      this.g = paramJSONObject.getString("so_name");
      this.h = paramJSONObject.getString("model_fullname");
      this.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("gameenable");
      this.i = paramJSONObject.optString("url_zip_gamemodel");
      this.j = paramJSONObject.optString("MD5_zip_gamemodel");
      this.k = paramJSONObject.optString("gamemodel_fullname");
      return true;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("QavGesture", 1, String.format("parseJson, Exception\n%s", new Object[] { paramJSONObject }));
    }
    return false;
  }
  
  public String toString()
  {
    return String.format("task_id[%s], time[%s], enable[%s], url_zip_so[%s], MD5_zip_so[%s], url_zip_model[%s], MD5_zip_model[%s], MD5_so[%s]", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Double.valueOf(this.jdField_a_of_type_Double), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_b_of_type_JavaLangString, this.c, this.d, this.e, this.f });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */