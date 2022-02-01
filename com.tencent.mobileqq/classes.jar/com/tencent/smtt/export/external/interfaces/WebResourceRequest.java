package com.tencent.smtt.export.external.interfaces;

import android.net.Uri;
import java.util.Map;

public abstract interface WebResourceRequest
{
  public abstract String getMethod();
  
  public abstract Map<String, String> getRequestHeaders();
  
  public abstract Uri getUrl();
  
  public abstract boolean hasGesture();
  
  public abstract boolean isForMainFrame();
  
  public abstract boolean isRedirect();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.WebResourceRequest
 * JD-Core Version:    0.7.0.1
 */