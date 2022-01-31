package com.tencent.smtt.sdk;

public class MimeTypeMap
{
  private static MimeTypeMap mInstance;
  
  public static String getFileExtensionFromUrl(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().mimeTypeMapGetFileExtensionFromUrl(paramString);
    }
    return android.webkit.MimeTypeMap.getFileExtensionFromUrl(paramString);
  }
  
  public static MimeTypeMap getSingleton()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new MimeTypeMap();
      }
      MimeTypeMap localMimeTypeMap = mInstance;
      return localMimeTypeMap;
    }
    finally {}
  }
  
  public String getExtensionFromMimeType(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().mimeTypeMapGetExtensionFromMimeType(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
  }
  
  public String getMimeTypeFromExtension(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().mimeTypeMapGetMimeTypeFromExtension(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
  }
  
  public boolean hasExtension(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().mimeTypeMapHasExtension(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().hasExtension(paramString);
  }
  
  public boolean hasMimeType(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().mimeTypeMapHasMimeType(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().hasMimeType(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.MimeTypeMap
 * JD-Core Version:    0.7.0.1
 */