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
    throw new RuntimeException("bad dataUrl format! url = " + paramString);
  }
  
  public static String getDataUrlHead(String paramString)
  {
    int i = paramString.indexOf(",");
    if (i > 0) {
      return paramString.substring(0, i);
    }
    throw new RuntimeException("bad format! dataUrl = " + paramString);
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
      throw new RuntimeException("unsupport minetype! urlHead = " + getDataUrlHead(paramString));
    }
    throw new RuntimeException("unknow dataUrl format: " + getDataUrlHead(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.base64.Base64Utils
 * JD-Core Version:    0.7.0.1
 */