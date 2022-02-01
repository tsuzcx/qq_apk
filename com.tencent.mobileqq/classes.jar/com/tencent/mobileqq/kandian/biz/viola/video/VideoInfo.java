package com.tencent.mobileqq.kandian.biz.viola.video;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class VideoInfo
{
  public int a;
  public long a;
  public String a;
  public Map<String, Object> a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  
  public VideoInfo()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public VideoInfo(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    if (paramJSONObject == null) {
      return;
    }
    if (paramJSONObject.has("busiType")) {
      this.jdField_a_of_type_Int = paramJSONObject.getInt("busiType");
    }
    if (paramJSONObject.has("vid")) {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("vid");
    }
    if (paramJSONObject.has("width")) {
      this.jdField_b_of_type_Int = paramJSONObject.getInt("width");
    }
    if (paramJSONObject.has("height")) {
      this.jdField_c_of_type_Int = paramJSONObject.getInt("height");
    }
    if (paramJSONObject.has("duration")) {
      this.jdField_d_of_type_Int = paramJSONObject.getInt("duration");
    }
    if (paramJSONObject.has("poster")) {
      this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("poster");
    }
    if (paramJSONObject.has("title")) {
      this.jdField_c_of_type_JavaLangString = paramJSONObject.getString("title");
    }
    if (paramJSONObject.has("xgFileSize")) {
      this.jdField_a_of_type_Long = paramJSONObject.getLong("xgFileSize");
    }
    if (paramJSONObject.has("videoUrl")) {
      this.jdField_d_of_type_JavaLangString = paramJSONObject.getString("videoUrl");
    }
    if (paramJSONObject.has("fromType")) {
      this.jdField_e_of_type_Int = paramJSONObject.getInt("fromType");
    }
    if (paramJSONObject.has("dt_pgid")) {
      this.f = paramJSONObject.optInt("dt_pgid");
    }
    if (paramJSONObject.has("isAd")) {
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isAd");
    }
    if (paramJSONObject.has("dt_extraParams"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("dt_extraParams");
      if (paramJSONObject != null)
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.jdField_a_of_type_JavaUtilMap.put(str, paramJSONObject.optString(str));
        }
        this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("rowkey");
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoInfo{busiType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", xgFileSize=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo
 * JD-Core Version:    0.7.0.1
 */