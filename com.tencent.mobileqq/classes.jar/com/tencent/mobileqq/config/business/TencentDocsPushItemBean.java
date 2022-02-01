package com.tencent.mobileqq.config.business;

import org.json.JSONObject;

public class TencentDocsPushItemBean
{
  private String jdField_a_of_type_JavaLangString = "1108338344";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "pages/list/list";
  private String c = "";
  private String d = "";
  
  public static TencentDocsPushItemBean a(JSONObject paramJSONObject)
  {
    TencentDocsPushItemBean localTencentDocsPushItemBean = new TencentDocsPushItemBean();
    if (paramJSONObject.has("enableOpenMiniCode"))
    {
      int i = paramJSONObject.getInt("enableOpenMiniCode");
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localTencentDocsPushItemBean.jdField_a_of_type_Boolean = bool;
    }
    if (paramJSONObject.has("miniCodeAppid")) {
      localTencentDocsPushItemBean.jdField_a_of_type_JavaLangString = paramJSONObject.getString("miniCodeAppid");
    }
    if (paramJSONObject.has("miniCodePage")) {
      localTencentDocsPushItemBean.b = paramJSONObject.getString("miniCodePage");
    }
    if (paramJSONObject.has("miniCodeEnvVersion")) {
      localTencentDocsPushItemBean.c = paramJSONObject.getString("miniCodeEnvVersion");
    }
    if (paramJSONObject.has("miniCodeUrlBlackRegular")) {
      localTencentDocsPushItemBean.d = paramJSONObject.getString("miniCodeUrlBlackRegular");
    }
    return localTencentDocsPushItemBean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TencentDocsPushItemBean
 * JD-Core Version:    0.7.0.1
 */