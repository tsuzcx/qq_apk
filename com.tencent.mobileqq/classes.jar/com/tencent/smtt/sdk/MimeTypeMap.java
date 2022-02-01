package com.tencent.smtt.sdk;

public class MimeTypeMap
{
  private static MimeTypeMap a;
  
  public static String getFileExtensionFromUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().h(paramString);
    }
    return android.webkit.MimeTypeMap.getFileExtensionFromUrl(paramString);
  }
  
  public static MimeTypeMap getSingleton()
  {
    try
    {
      if (a == null) {
        a = new MimeTypeMap();
      }
      MimeTypeMap localMimeTypeMap = a;
      return localMimeTypeMap;
    }
    finally {}
  }
  
  public String getExtensionFromMimeType(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().l(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
  }
  
  public String getMimeTypeFromExtension(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().j(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
  }
  
  public boolean hasExtension(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().k(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().hasExtension(paramString);
  }
  
  public boolean hasMimeType(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().i(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().hasMimeType(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.MimeTypeMap
 * JD-Core Version:    0.7.0.1
 */