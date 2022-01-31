package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AudioInfo
  extends UploadEditItemInfo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public AudioInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramString3;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (this.g = 0;; this.g = 3)
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("type", "voice");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("path", this.jdField_a_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("url", this.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_Int > 0) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("time", this.jdField_a_of_type_Int);
        }
        if (this.jdField_b_of_type_Int > 0) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("size", this.jdField_b_of_type_Int);
        }
        return;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public AudioInfo(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("path");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("url");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("time");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("size");
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.g = 0;
      return;
    }
    this.g = 3;
  }
  
  public boolean a()
  {
    return HttpUtil.a(this.jdField_b_of_type_JavaLangString);
  }
  
  public int b()
  {
    return 3;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("path", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("url", paramString);
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.g = 0;
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      this.g = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo
 * JD-Core Version:    0.7.0.1
 */