package dov.com.qq.im.capture.text;

import org.json.JSONObject;

public class DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static DynamicTextFontInfo a(JSONObject paramJSONObject)
  {
    DynamicTextFontInfo localDynamicTextFontInfo = new DynamicTextFontInfo();
    localDynamicTextFontInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localDynamicTextFontInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localDynamicTextFontInfo.c = paramJSONObject.optString("name");
    localDynamicTextFontInfo.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localDynamicTextFontInfo.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localDynamicTextFontInfo;
  }
  
  public String a()
  {
    return this.c + "_" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo
 * JD-Core Version:    0.7.0.1
 */