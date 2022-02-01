package com.tencent.mobileqq.qwallet.hb.send;

import org.json.JSONObject;

public class PanelData
{
  public int a;
  public String a;
  public JSONObject a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public PanelData() {}
  
  public PanelData(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" type: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" name: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" params: ");
    localStringBuilder.append(this.jdField_a_of_type_OrgJsonJSONObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.PanelData
 * JD-Core Version:    0.7.0.1
 */