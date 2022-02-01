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
    Router localRouter = instance;
    if (localRouter != null) {
      return localRouter;
    }
    try
    {
      if (instance == null) {
        instance = new Router();
      }
      localRouter = instance;
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("route init begin. pid=");
      ((StringBuilder)localObject1).append(Process.myPid());
      Logger.info(((StringBuilder)localObject1).toString());
      long l = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (BaseRouteInitializer)Class.forName("com.tencent.mobileqq.qroute.route.generated.DefaultRouteInitializer").newInstance();
      ((BaseRouteInitializer)localObject2).routeRegister = new Router.1(this, (ArrayList)localObject1);
      ((BaseRouteInitializer)localObject2).init();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("route path:\n");
      ((StringBuilder)localObject2).append(routePathToString((List)localObject1));
      Logger.debug(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("route init finished, count=");
      ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
      ((StringBuilder)localObject2).append(" cost-time=");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      Logger.info(((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("init route failed, ");
      ((StringBuilder)localObject2).append(localException.toString());
      Logger.warning(((StringBuilder)localObject2).toString());
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
    while (paramList.hasNext())
    {
      localStringBuilder.append((String)paramList.next());
      localStringBuilder.append('\n');
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.Router
 * JD-Core Version:    0.7.0.1
 */