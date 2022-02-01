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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseLibInfo{baseLibUrl='");
    localStringBuilder.append(this.baseLibUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", baseLibKey='");
    localStringBuilder.append(this.baseLibKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", baseLibVersion='");
    localStringBuilder.append(this.baseLibVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.BaseLibInfo
 * JD-Core Version:    0.7.0.1
 */