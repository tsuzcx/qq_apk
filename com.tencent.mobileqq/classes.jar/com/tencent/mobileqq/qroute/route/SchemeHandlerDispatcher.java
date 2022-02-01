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
    if ((paramUri == null) || (paramUri.isRelative())) {
      return "";
    }
    return getSchemeHost(paramUri.getScheme(), paramUri.getHost());
  }
  
  protected static String getSchemeHost(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      paramString1 = "";
      if (paramString2 != null) {
        break label46;
      }
    }
    label46:
    for (paramString2 = "";; paramString2 = paramString2.toLowerCase())
    {
      return paramString1 + "://" + paramString2;
      paramString1 = paramString1.toLowerCase();
      break;
    }
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
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramURIHandler == null)) {
      Logger.warning("invalid register arguments");
    }
    String str;
    do
    {
      return;
      str = getSchemeHost(paramString1, paramString2);
    } while ((URIHandler)this.handlers.put(getSchemeHost(paramString1, paramString2), paramURIHandler) == null);
    Logger.warning("handler already exists, key is " + str);
  }
  
  protected boolean shouldHandleURI(URIRequest paramURIRequest)
  {
    paramURIRequest = getSchemeHost(paramURIRequest.getURI());
    return this.handlers.containsKey(paramURIRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.SchemeHandlerDispatcher
 * JD-Core Version:    0.7.0.1
 */