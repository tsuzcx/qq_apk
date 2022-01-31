package com.tencent.smtt.export.external.interfaces;

public abstract class UrlRequest$Builder
{
  public static final int REQUEST_PRIORITY_HIGHEST = 4;
  public static final int REQUEST_PRIORITY_IDLE = 0;
  public static final int REQUEST_PRIORITY_LOW = 2;
  public static final int REQUEST_PRIORITY_LOWEST = 1;
  public static final int REQUEST_PRIORITY_MEDIUM = 3;
  
  public abstract Builder addHeader(String paramString1, String paramString2);
  
  public abstract UrlRequest build();
  
  public abstract Builder disableCache();
  
  public abstract Builder setHttpMethod(String paramString);
  
  public abstract Builder setPriority(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
 * JD-Core Version:    0.7.0.1
 */