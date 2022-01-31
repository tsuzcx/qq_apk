package com.tencent.mobileqq.tribe;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("vid", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("url", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("video_md5", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("video_thumbe_url", this.d);
      localJSONObject.put("text", this.e);
      localJSONObject.put("duration", this.jdField_a_of_type_Int);
      localJSONObject.put("size", this.jdField_a_of_type_Long);
      localJSONObject.put("width", this.jdField_b_of_type_Int);
      localJSONObject.put("height", this.jdField_c_of_type_Int);
      localJSONObject.put("isLocalVideo", this.jdField_a_of_type_Boolean);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoInfo", 2, "VideoInfo: " + QLog.getStackTraceString(localJSONException));
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.VideoInfo
 * JD-Core Version:    0.7.0.1
 */