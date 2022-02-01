package com.tencent.qg.sdk.base64;

public class Base64Utils
{
  public static final String MINETYPE_JPEG = "image/jpeg";
  public static final String MINETYPE_PNG = "image/png";
  
  public static String getBase64StrFromDataUrl(String paramString)
  {
    int i = paramString.indexOf(",");
    if ((i > 0) && (i < paramString.length())) {
      return paramString.substring(i + 1, paramString.length());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bad dataUrl format! url = ");
    localStringBuilder.append(paramString);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public static String getDataUrlHead(String paramString)
  {
    int i = paramString.indexOf(",");
    if (i > 0) {
      return paramString.substring(0, i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bad format! dataUrl = ");
    localStringBuilder.append(paramString);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public static String getMineType(String paramString)
  {
    if (paramString.startsWith("data:"))
    {
      if (paramString.contains("image/png")) {
        return "image/png";
      }
      if (paramString.contains("image/jpeg")) {
        return "image/jpeg";
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unsupport minetype! urlHead = ");
      localStringBuilder.append(getDataUrlHead(paramString));
      throw new RuntimeException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknow dataUrl format: ");
    localStringBuilder.append(getDataUrlHead(paramString));
    throw new RuntimeException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.base64.Base64Utils
 * JD-Core Version:    0.7.0.1
 */