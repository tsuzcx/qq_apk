package com.tencent.mobileqq.config.business.tendoc;

import org.json.JSONObject;

public class TencentDocEditConvertConfigBean$TencentDocEditConvertConfigItem
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  
  public static TencentDocEditConvertConfigItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    TencentDocEditConvertConfigItem localTencentDocEditConvertConfigItem = new TencentDocEditConvertConfigItem();
    localTencentDocEditConvertConfigItem.jdField_a_of_type_Int = paramJSONObject.getInt("type");
    localTencentDocEditConvertConfigItem.jdField_a_of_type_JavaLangString = paramJSONObject.getString("color");
    localTencentDocEditConvertConfigItem.jdField_a_of_type_Float = ((float)paramJSONObject.getDouble("alpha"));
    localTencentDocEditConvertConfigItem.jdField_b_of_type_JavaLangString = paramJSONObject.getString("text");
    localTencentDocEditConvertConfigItem.c = paramJSONObject.getString("tcolor");
    localTencentDocEditConvertConfigItem.d = paramJSONObject.getString("icon");
    localTencentDocEditConvertConfigItem.f = paramJSONObject.getString("tshow");
    localTencentDocEditConvertConfigItem.e = paramJSONObject.getString("tpress");
    localTencentDocEditConvertConfigItem.jdField_b_of_type_Int = paramJSONObject.getInt("click");
    return localTencentDocEditConvertConfigItem;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem
 * JD-Core Version:    0.7.0.1
 */