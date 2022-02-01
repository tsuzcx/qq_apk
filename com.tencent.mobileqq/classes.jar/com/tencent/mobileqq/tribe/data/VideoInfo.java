package com.tencent.mobileqq.tribe.data;

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
  private int d;
  public String d;
  public String e;
  
  public VideoInfo()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("vid", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("url", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("video_md5", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("video_thumbe_url", this.jdField_d_of_type_JavaLangString);
      localJSONObject.put("text", this.e);
      localJSONObject.put("duration", this.jdField_a_of_type_Int);
      localJSONObject.put("size", this.jdField_a_of_type_Long);
      localJSONObject.put("width", this.jdField_b_of_type_Int);
      localJSONObject.put("height", this.jdField_c_of_type_Int);
      localJSONObject.put("isLocalVideo", this.jdField_a_of_type_Boolean);
      localJSONObject.put("takeVideoMode", this.jdField_d_of_type_Int);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoInfo: ");
        localStringBuilder.append(QLog.getStackTraceString(localJSONException));
        QLog.e("VideoInfo", 2, localStringBuilder.toString());
      }
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.data.VideoInfo
 * JD-Core Version:    0.7.0.1
 */