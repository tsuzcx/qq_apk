package com.tencent.mobileqq.transfile.filebrowser;

import java.util.HashMap;
import java.util.Map;

public class MimeTypes
{
  private Map<String, String> mMimeTypes = new HashMap();
  
  public static String getExtension(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public String getMimeType(String paramString)
  {
    paramString = getExtension(paramString);
    return (String)this.mMimeTypes.get(paramString);
  }
  
  public void put(String paramString1, String paramString2)
  {
    this.mMimeTypes.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.MimeTypes
 * JD-Core Version:    0.7.0.1
 */