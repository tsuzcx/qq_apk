package com.tencent.mobileqq.qroute.route;

import android.net.Uri;
import java.util.concurrent.ConcurrentHashMap;

public class SchemeHandlerDispatcher
  extends URIHandler
{
  private static final String TAG = "SchemeHandler";
  private final ConcurrentHashMap<String, URIHandler> handlers = new ConcurrentHashMap();
  
  protected static String getSchemeHost(Uri paramUri)
  {
    if ((paramUri != null) && (!paramUri.isRelative())) {
      return getSchemeHost(paramUri.getScheme(), paramUri.getHost());
    }
    return "";
  }
  
  protected static String getSchemeHost(String paramString1, String paramString2)
  {
    Object localObject = "";
    if (paramString1 == null) {
      paramString1 = "";
    } else {
      paramString1 = paramString1.toLowerCase();
    }
    if (paramString2 == null) {
      paramString2 = (String)localObject;
    } else {
      paramString2 = paramString2.toLowerCase();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("://");
    ((StringBuilder)localObject).append(paramString2);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void handleURI(URIRequest paramURIRequest, URIRequestCallback paramURIRequestCallback)
  {
    URIHandler localURIHandler = (URIHandler)this.handlers.get(getSchemeHost(paramURIRequest.getURI()));
    if (localURIHandler == null)
    {
      paramURIRequestCallback.onComplete(1001);
      return;
    }
    localURIHandler.handle(paramURIRequest, paramURIRequestCallback);
  }
  
  public void register(String paramString1, String paramString2, URIHandler paramURIHandler)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramURIHandler != null))
    {
      String str = getSchemeHost(paramString1, paramString2);
      if ((URIHandler)this.handlers.put(getSchemeHost(paramString1, paramString2), paramURIHandler) != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("handler already exists, key is ");
        paramString1.append(str);
        Logger.warning(paramString1.toString());
      }
      return;
    }
    Logger.warning("invalid register arguments");
  }
  
  protected boolean shouldHandleURI(URIRequest paramURIRequest)
  {
    paramURIRequest = getSchemeHost(paramURIRequest.getURI());
    return this.handlers.containsKey(paramURIRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.SchemeHandlerDispatcher
 * JD-Core Version:    0.7.0.1
 */