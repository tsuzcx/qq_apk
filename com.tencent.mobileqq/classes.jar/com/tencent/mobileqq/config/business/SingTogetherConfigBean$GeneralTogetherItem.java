package com.tencent.mobileqq.config.business;

import org.json.JSONObject;

public class SingTogetherConfigBean$GeneralTogetherItem
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c = 1;
  public int d = -1;
  
  public SingTogetherConfigBean$GeneralTogetherItem()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static GeneralTogetherItem a(JSONObject paramJSONObject)
  {
    GeneralTogetherItem localGeneralTogetherItem = new GeneralTogetherItem();
    localGeneralTogetherItem.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("show_c2c_chat_setting", false);
    localGeneralTogetherItem.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("show_group_chat_setting", false);
    localGeneralTogetherItem.jdField_a_of_type_Int = paramJSONObject.optInt("service_type", -1);
    localGeneralTogetherItem.jdField_b_of_type_Int = paramJSONObject.optInt("jumpType", -1);
    localGeneralTogetherItem.c = paramJSONObject.optInt("version", -1);
    localGeneralTogetherItem.d = paramJSONObject.optInt("appid", -1);
    localGeneralTogetherItem.jdField_a_of_type_JavaLangString = paramJSONObject.optString("jumpUrl", "");
    return localGeneralTogetherItem;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showC2CChatSetting=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" showGroupChatSetting=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" serviceType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" jumpType=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" version=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" appId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" jumpUrl=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.SingTogetherConfigBean.GeneralTogetherItem
 * JD-Core Version:    0.7.0.1
 */