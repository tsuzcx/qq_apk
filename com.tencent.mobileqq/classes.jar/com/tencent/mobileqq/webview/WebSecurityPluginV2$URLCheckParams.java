package com.tencent.mobileqq.webview;

import java.util.ArrayList;

public class WebSecurityPluginV2$URLCheckParams
{
  public String a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public boolean i;
  public ArrayList<String> j;
  
  public static URLCheckParams a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    URLCheckParams localURLCheckParams = new URLCheckParams();
    localURLCheckParams.a = paramString1;
    localURLCheckParams.b = paramInt1;
    localURLCheckParams.c = paramInt2;
    localURLCheckParams.d = paramString2;
    localURLCheckParams.e = paramString3;
    localURLCheckParams.f = paramString4;
    localURLCheckParams.g = paramString5;
    localURLCheckParams.h = paramString6;
    localURLCheckParams.i = paramBoolean;
    localURLCheckParams.j = new ArrayList(paramArrayList);
    return localURLCheckParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebSecurityPluginV2.URLCheckParams
 * JD-Core Version:    0.7.0.1
 */