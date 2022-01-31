package com.tencent.mobileqq.shortvideo.gesture;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DownloadInfo
{
  double jdField_a_of_type_Double;
  int jdField_a_of_type_Int = 0;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  String e;
  public String f;
  String g;
  String h;
  public String i;
  public String j;
  String k;
  
  public static DownloadInfo a()
  {
    String str = GestureUtil.a().getString("config", null);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return a(str);
  }
  
  static DownloadInfo a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.jdField_a_of_type_Int = paramString.getInt("task_id");
      localDownloadInfo.jdField_a_of_type_Double = paramString.getDouble("time");
      localDownloadInfo.jdField_a_of_type_Boolean = paramString.getBoolean("enable");
      localDownloadInfo.jdField_a_of_type_JavaLangString = paramString.getString("url_zip_so");
      localDownloadInfo.jdField_b_of_type_JavaLangString = paramString.getString("MD5_zip_so");
      localDownloadInfo.c = paramString.getString("url_zip_model");
      localDownloadInfo.d = paramString.getString("MD5_zip_model");
      localDownloadInfo.e = paramString.getString("MD5_so");
      localDownloadInfo.f = paramString.getString("so_fullname");
      localDownloadInfo.g = paramString.getString("so_name");
      localDownloadInfo.h = paramString.getString("model_fullname");
      localDownloadInfo.jdField_b_of_type_Boolean = paramString.optBoolean("gameenable");
      localDownloadInfo.i = paramString.optString("url_zip_gamemodel");
      localDownloadInfo.j = paramString.optString("MD5_zip_gamemodel");
      localDownloadInfo.k = paramString.optString("gamemodel_fullname");
      return localDownloadInfo;
    }
    catch (Exception paramString)
    {
      QLog.d("QavGesture", 1, String.format("parseJson, Exception\n%s", new Object[] { paramString }));
    }
    return null;
  }
  
  public String toString()
  {
    return String.format("task_id[%s], time[%s], enable[%s], url_zip_so[%s], MD5_zip_so[%s], url_zip_model[%s], MD5_zip_model[%s], MD5_so[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Double.valueOf(this.jdField_a_of_type_Double), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.e });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */