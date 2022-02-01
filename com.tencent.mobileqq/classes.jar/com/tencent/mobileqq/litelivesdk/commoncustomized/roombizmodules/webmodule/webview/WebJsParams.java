package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import java.util.HashMap;

public class WebJsParams
{
  private String a;
  private String b;
  private HashMap<String, String> c;
  
  public WebJsParams(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramHashMap;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public HashMap<String, String> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebJsParams
 * JD-Core Version:    0.7.0.1
 */