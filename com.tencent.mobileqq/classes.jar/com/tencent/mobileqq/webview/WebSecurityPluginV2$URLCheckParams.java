package com.tencent.mobileqq.webview;

import java.util.ArrayList;

public class WebSecurityPluginV2$URLCheckParams
{
  public int a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public static URLCheckParams a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    URLCheckParams localURLCheckParams = new URLCheckParams();
    localURLCheckParams.jdField_a_of_type_JavaLangString = paramString1;
    localURLCheckParams.jdField_a_of_type_Int = paramInt1;
    localURLCheckParams.jdField_b_of_type_Int = paramInt2;
    localURLCheckParams.jdField_b_of_type_JavaLangString = paramString2;
    localURLCheckParams.c = paramString3;
    localURLCheckParams.d = paramString4;
    localURLCheckParams.e = paramString5;
    localURLCheckParams.f = paramString6;
    localURLCheckParams.jdField_a_of_type_Boolean = paramBoolean;
    localURLCheckParams.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
    return localURLCheckParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebSecurityPluginV2.URLCheckParams
 * JD-Core Version:    0.7.0.1
 */