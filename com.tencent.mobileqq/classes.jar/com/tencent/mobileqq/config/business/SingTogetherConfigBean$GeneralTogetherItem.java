package com.tencent.mobileqq.config.business;

import org.json.JSONObject;

public class SingTogetherConfigBean$GeneralTogetherItem
{
  public boolean a = false;
  public boolean b = false;
  public int c;
  public int d;
  public int e = 1;
  public int f = -1;
  public String g = "";
  
  public static GeneralTogetherItem a(JSONObject paramJSONObject)
  {
    GeneralTogetherItem localGeneralTogetherItem = new GeneralTogetherItem();
    localGeneralTogetherItem.a = paramJSONObject.optBoolean("show_c2c_chat_setting", false);
    localGeneralTogetherItem.b = paramJSONObject.optBoolean("show_group_chat_setting", false);
    localGeneralTogetherItem.c = paramJSONObject.optInt("service_type", -1);
    localGeneralTogetherItem.d = paramJSONObject.optInt("jumpType", -1);
    localGeneralTogetherItem.e = paramJSONObject.optInt("version", -1);
    localGeneralTogetherItem.f = paramJSONObject.optInt("appid", -1);
    localGeneralTogetherItem.g = paramJSONObject.optString("jumpUrl", "");
    return localGeneralTogetherItem;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showC2CChatSetting=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" showGroupChatSetting=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" serviceType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" jumpType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" version=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" appId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" jumpUrl=");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.SingTogetherConfigBean.GeneralTogetherItem
 * JD-Core Version:    0.7.0.1
 */