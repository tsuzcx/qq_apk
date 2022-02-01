package com.tencent.mobileqq.microapp.sdk;

import java.io.Serializable;

public class BaseLibInfo
  implements Serializable
{
  public String baseLibKey;
  public String baseLibUrl;
  public String baseLibVersion;
  
  public BaseLibInfo(String paramString1, String paramString2, String paramString3)
  {
    this.baseLibUrl = paramString1;
    this.baseLibKey = paramString2;
    this.baseLibVersion = paramString3;
  }
  
  public String toString()
  {
    return "BaseLibInfo{baseLibUrl='" + this.baseLibUrl + '\'' + ", baseLibKey='" + this.baseLibKey + '\'' + ", baseLibVersion='" + this.baseLibVersion + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.BaseLibInfo
 * JD-Core Version:    0.7.0.1
 */