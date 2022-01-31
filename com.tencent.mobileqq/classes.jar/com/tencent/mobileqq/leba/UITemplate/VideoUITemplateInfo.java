package com.tencent.mobileqq.leba.UITemplate;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class VideoUITemplateInfo
  extends BaseUITemplateInfo
{
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  
  public boolean a(JSONObject paramJSONObject)
  {
    try
    {
      a(paramJSONObject);
      JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
      this.jdField_a_of_type_JavaLangString = localJSONObject.optString("vid");
      this.jdField_b_of_type_JavaLangString = localJSONObject.optString("video_url");
      this.jdField_b_of_type_Int = localJSONObject.optInt("video_width");
      this.jdField_c_of_type_Int = localJSONObject.optInt("video_height");
      this.jdField_c_of_type_JavaLangString = localJSONObject.optString("video_cover");
      this.jdField_a_of_type_Long = localJSONObject.optLong("video_duration");
      this.jdField_b_of_type_Long = localJSONObject.optLong("file_size");
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("new_leba", 1, "pareseJson fail,  json = " + paramJSONObject.toString(), localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.UITemplate.VideoUITemplateInfo
 * JD-Core Version:    0.7.0.1
 */