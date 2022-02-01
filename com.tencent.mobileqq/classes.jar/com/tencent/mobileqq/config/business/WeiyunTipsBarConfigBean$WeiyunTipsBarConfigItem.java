package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import org.json.JSONObject;

public class WeiyunTipsBarConfigBean$WeiyunTipsBarConfigItem
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static WeiyunTipsBarConfigItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    WeiyunTipsBarConfigItem localWeiyunTipsBarConfigItem = new WeiyunTipsBarConfigItem();
    localWeiyunTipsBarConfigItem.a = paramJSONObject.getString("tips");
    localWeiyunTipsBarConfigItem.b = paramJSONObject.getString("buttonText");
    localWeiyunTipsBarConfigItem.c = paramJSONObject.getString("url");
    localWeiyunTipsBarConfigItem.d = paramJSONObject.getString("icon");
    return localWeiyunTipsBarConfigItem;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean a()
  {
    return (TextUtils.isEmpty(this.a)) && (TextUtils.isEmpty(this.b)) && (TextUtils.isEmpty(this.c)) && (TextUtils.isEmpty(this.d));
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
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WeiyunTipsBarConfigBean.WeiyunTipsBarConfigItem
 * JD-Core Version:    0.7.0.1
 */