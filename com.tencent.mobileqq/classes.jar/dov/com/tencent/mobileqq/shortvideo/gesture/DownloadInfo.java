package dov.com.tencent.mobileqq.shortvideo.gesture;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DownloadInfo
{
  double jdField_a_of_type_Double;
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  String b;
  public boolean b;
  String c;
  String d;
  String e;
  public String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  
  private DownloadInfo()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
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
      JSONObject localJSONObject = new JSONObject(paramString);
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.jdField_a_of_type_Int = localJSONObject.getInt("task_id");
      localDownloadInfo.jdField_a_of_type_Double = localJSONObject.getDouble("time");
      localDownloadInfo.jdField_a_of_type_Boolean = localJSONObject.getBoolean("enable");
      localDownloadInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("url_zip_so");
      localDownloadInfo.jdField_b_of_type_JavaLangString = localJSONObject.getString("MD5_zip_so");
      localDownloadInfo.c = localJSONObject.getString("url_zip_model");
      localDownloadInfo.d = localJSONObject.getString("MD5_zip_model");
      localDownloadInfo.e = localJSONObject.getString("MD5_so");
      localDownloadInfo.f = localJSONObject.getString("so_fullname");
      localDownloadInfo.g = localJSONObject.getString("so_name");
      localDownloadInfo.h = localJSONObject.getString("model_fullname");
      localDownloadInfo.jdField_b_of_type_Boolean = localJSONObject.optBoolean("gameenable");
      localDownloadInfo.i = localJSONObject.optString("url_zip_gamemodel");
      localDownloadInfo.j = localJSONObject.optString("MD5_zip_gamemodel");
      localDownloadInfo.k = localJSONObject.optString("gamemodel_fullname");
      QLog.d("QavGesture", 1, "DownloadInfo parseJson, gameenable=" + localDownloadInfo.jdField_b_of_type_Boolean);
      if (!localDownloadInfo.jdField_b_of_type_Boolean) {
        QLog.d("QavGesture", 1, "DownloadInfo parseJson " + paramString);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */