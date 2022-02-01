package com.tencent.mobileqq.config.business.tendoc;

import org.json.JSONObject;

public class TencentDocEditConvertConfigBean$TencentDocEditConvertConfigItem
{
  private int a = 0;
  private String b = "";
  private float c = 1.0F;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private int i = 0;
  
  public static TencentDocEditConvertConfigItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    TencentDocEditConvertConfigItem localTencentDocEditConvertConfigItem = new TencentDocEditConvertConfigItem();
    localTencentDocEditConvertConfigItem.a = paramJSONObject.getInt("type");
    localTencentDocEditConvertConfigItem.b = paramJSONObject.getString("color");
    localTencentDocEditConvertConfigItem.c = ((float)paramJSONObject.getDouble("alpha"));
    localTencentDocEditConvertConfigItem.d = paramJSONObject.getString("text");
    localTencentDocEditConvertConfigItem.e = paramJSONObject.getString("tcolor");
    localTencentDocEditConvertConfigItem.f = paramJSONObject.getString("icon");
    localTencentDocEditConvertConfigItem.h = paramJSONObject.getString("tshow");
    localTencentDocEditConvertConfigItem.g = paramJSONObject.getString("tpress");
    localTencentDocEditConvertConfigItem.i = paramJSONObject.getInt("click");
    return localTencentDocEditConvertConfigItem;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public float c()
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
  
  public String g()
  {
    return this.g;
  }
  
  public String h()
  {
    return this.h;
  }
  
  public int i()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem
 * JD-Core Version:    0.7.0.1
 */