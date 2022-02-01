package com.tencent.mobileqq.qroute.route;

import android.app.Activity;
import android.net.Uri;
import java.util.concurrent.ConcurrentHashMap;

class PathHandlerDispatcher
  extends URIHandler
{
  private static final String TAG = "PathHandler";
  private final ConcurrentHashMap<String, URIHandler> pathHandlers = new ConcurrentHashMap();
  
  static boolean isValidActivityPath(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      if (!paramString.startsWith("/")) {
        return false;
      }
      return paramString.indexOf('/', 1) >= 0;
    }
    return false;
  }
  
  protected void handleURI(URIRequest paramURIRequest, URIRequestCallback paramURIRequestCallback)
  {
    String str = paramURIRequest.getURI().getPath();
    URIHandler localURIHandler = (URIHandler)this.pathHandlers.get(str);
    if (localURIHandler == null)
    {
      paramURIRequest = new StringBuilder();
      paramURIRequest.append("path not found. path is ");
      paramURIRequest.append(str);
      Logger.warning(paramURIRequest.toString());
      paramURIRequestCallback.onComplete(1001);
      return;
    }
    localURIHandler.handle(paramURIRequest, paramURIRequestCallback);
  }
  
  public void register(String paramString, URIHandler paramURIHandler)
  {
    if ((!isValidActivityPath(paramString)) && (paramURIHandler == null))
    {
      paramURIHandler = new StringBuilder();
      paramURIHandler.append("register path invalid, path is ");
      paramURIHandler.append(paramString);
      Logger.warning(paramURIHandler.toString());
      return;
    }
    URIHandler localURIHandler = (URIHandler)this.pathHandlers.put(paramString, paramURIHandler);
    if ((localURIHandler != null) && (!localURIHandler.toString().equals(paramURIHandler.toString())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("register path already exists, path is ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" prev is ");
      localStringBuilder.append(localURIHandler.toString());
      localStringBuilder.append(" current is ");
      localStringBuilder.append(paramURIHandler.toString());
      Logger.warning(localStringBuilder.toString());
    }
  }
  
  public void register(String paramString, Class<? extends Activity> paramClass)
  {
    register(paramString, ActivityClassHandler.createHandler(paramClass));
  }
  
  public void register(String paramString1, String paramString2)
  {
    register(paramString1, ActivityClassNameHandler.createHandler(paramString2));
  }
  
  protected boolean shouldHandleURI(URIRequest paramURIRequest)
  {
    return "qroute://page".equals(SchemeHandlerDispatcher.getSchemeHost(paramURIRequest.getURI()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.PathHandlerDispatcher
 * JD-Core Version:    0.7.0.1
 */