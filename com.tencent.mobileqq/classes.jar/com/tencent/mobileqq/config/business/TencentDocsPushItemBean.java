package com.tencent.mobileqq.config.business;

import org.json.JSONObject;

public class TencentDocsPushItemBean
{
  private boolean a = false;
  private String b = "1108338344";
  private String c = "pages/list/list";
  private String d = "";
  private String e = "";
  
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
      localTencentDocsPushItemBean.a = bool;
    }
    if (paramJSONObject.has("miniCodeAppid")) {
      localTencentDocsPushItemBean.b = paramJSONObject.getString("miniCodeAppid");
    }
    if (paramJSONObject.has("miniCodePage")) {
      localTencentDocsPushItemBean.c = paramJSONObject.getString("miniCodePage");
    }
    if (paramJSONObject.has("miniCodeEnvVersion")) {
      localTencentDocsPushItemBean.d = paramJSONObject.getString("miniCodeEnvVersion");
    }
    if (paramJSONObject.has("miniCodeUrlBlackRegular")) {
      localTencentDocsPushItemBean.e = paramJSONObject.getString("miniCodeUrlBlackRegular");
    }
    return localTencentDocsPushItemBean;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TencentDocsPushItemBean
 * JD-Core Version:    0.7.0.1
 */