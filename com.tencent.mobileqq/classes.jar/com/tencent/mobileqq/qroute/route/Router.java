package com.tencent.mobileqq.qroute.route;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Router
{
  private static final String INIT_CLASS_NAME = "com.tencent.mobileqq.qroute.route.generated.DefaultRouteInitializer";
  private static final String TAG = "UIRouter";
  private static Router instance;
  private final List<URIHandler> chainedHandlers = new ArrayList();
  private final PathHandlerDispatcher pathDispatcher = new PathHandlerDispatcher();
  private final SchemeHandlerDispatcher schemeDispatcher = new SchemeHandlerDispatcher();
  
  Router()
  {
    this.schemeDispatcher.register("qroute", "page", this.pathDispatcher);
    this.chainedHandlers.add(this.schemeDispatcher);
  }
  
  public static Router getInstance()
  {
    if (instance != null) {
      return instance;
    }
    try
    {
      if (instance == null) {
        instance = new Router();
      }
      Router localRouter = instance;
      return localRouter;
    }
    finally {}
  }
  
  protected void handleURI(Iterator<URIHandler> paramIterator, URIRequest paramURIRequest, Router.OnCompleteListener paramOnCompleteListener)
  {
    if (!paramIterator.hasNext())
    {
      if (paramOnCompleteListener != null) {
        paramOnCompleteListener.onError(1001);
      }
      return;
    }
    URIHandler localURIHandler = (URIHandler)paramIterator.next();
    if (!localURIHandler.shouldHandleURI(paramURIRequest))
    {
      handleURI(paramIterator, paramURIRequest, paramOnCompleteListener);
      return;
    }
    localURIHandler.handle(paramURIRequest, new Router.3(this, paramIterator, paramURIRequest, paramOnCompleteListener));
  }
  
  public void init()
  {
    try
    {
      Logger.info("route init begin. pid=" + Process.myPid());
      long l = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      BaseRouteInitializer localBaseRouteInitializer = (BaseRouteInitializer)Class.forName("com.tencent.mobileqq.qroute.route.generated.DefaultRouteInitializer").newInstance();
      localBaseRouteInitializer.routeRegister = new Router.1(this, localArrayList);
      localBaseRouteInitializer.init();
      Logger.debug("route path:\n" + routePathToString(localArrayList));
      Logger.info("route init finished, count=" + localArrayList.size() + " cost-time=" + (System.currentTimeMillis() - l));
      return;
    }
    catch (Exception localException)
    {
      Logger.warning("init route failed, " + localException.toString());
    }
  }
  
  public void init(ILogger paramILogger)
  {
    setLogger(paramILogger);
    init();
  }
  
  public void register(String paramString, Class<? extends Activity> paramClass)
  {
    this.pathDispatcher.register(paramString, paramClass);
  }
  
  public void register(String paramString1, String paramString2)
  {
    this.pathDispatcher.register(paramString1, paramString2);
  }
  
  public void register(String paramString1, String paramString2, URIHandler paramURIHandler)
  {
    this.schemeDispatcher.register(paramString1, paramString2, paramURIHandler);
  }
  
  String routePathToString(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append((String)paramList.next()).append('\n');
    }
    return localStringBuilder.toString();
  }
  
  public void setLogger(ILogger paramILogger)
  {
    Logger.logger = paramILogger;
  }
  
  public void start(Context paramContext, String paramString)
  {
    paramContext = new ActivityURIRequest(paramContext, paramString);
    handleURI(this.chainedHandlers.iterator(), paramContext.getRequest(), new Router.2(this, paramString));
  }
  
  public void start(URIRequest paramURIRequest, Router.OnCompleteListener paramOnCompleteListener)
  {
    handleURI(this.chainedHandlers.iterator(), paramURIRequest, paramOnCompleteListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.Router
 * JD-Core Version:    0.7.0.1
 */