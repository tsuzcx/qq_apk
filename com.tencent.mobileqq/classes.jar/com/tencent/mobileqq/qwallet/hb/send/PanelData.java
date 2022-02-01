package com.tencent.mobileqq.qwallet.hb.send;

import org.json.JSONObject;

public class PanelData
{
  public String a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  public JSONObject h;
  
  public PanelData() {}
  
  public PanelData(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" type: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" name: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" params: ");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.PanelData
 * JD-Core Version:    0.7.0.1
 */