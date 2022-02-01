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
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!paramString.startsWith("/")) || (paramString.indexOf('/', 1) < 0)) {
      return false;
    }
    return true;
  }
  
  protected void handleURI(URIRequest paramURIRequest, URIRequestCallback paramURIRequestCallback)
  {
    String str = paramURIRequest.getURI().getPath();
    URIHandler localURIHandler = (URIHandler)this.pathHandlers.get(str);
    if (localURIHandler == null)
    {
      Logger.warning("path not found. path is " + str);
      paramURIRequestCallback.onComplete(1001);
      return;
    }
    localURIHandler.handle(paramURIRequest, paramURIRequestCallback);
  }
  
  public void register(String paramString, URIHandler paramURIHandler)
  {
    if ((!isValidActivityPath(paramString)) && (paramURIHandler == null)) {
      Logger.warning("register path invalid, path is " + paramString);
    }
    URIHandler localURIHandler;
    do
    {
      return;
      localURIHandler = (URIHandler)this.pathHandlers.put(paramString, paramURIHandler);
    } while ((localURIHandler == null) || (localURIHandler.toString().equals(paramURIHandler.toString())));
    Logger.warning("register path already exists, path is " + paramString + " prev is " + localURIHandler.toString() + " current is " + paramURIHandler.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.PathHandlerDispatcher
 * JD-Core Version:    0.7.0.1
 */