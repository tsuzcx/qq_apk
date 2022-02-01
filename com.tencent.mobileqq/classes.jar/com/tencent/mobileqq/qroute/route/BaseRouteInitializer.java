package com.tencent.mobileqq.qroute.route;

import java.util.HashMap;
import java.util.HashSet;

public abstract class BaseRouteInitializer
{
  private final HashMap<String, String> registeredActivityName = new HashMap();
  private final HashSet<String> registeredClassName = new HashSet();
  protected IRouteRegister routeRegister;
  
  public abstract void init();
  
  protected void register(String paramString)
  {
    if (this.routeRegister == null) {
      Logger.warning("register fail for " + paramString + ", routeRegister not assigned");
    }
    while (!this.registeredClassName.add(paramString)) {
      return;
    }
    try
    {
      ((RouteInitializer)Class.forName(paramString).newInstance()).init(this.routeRegister);
      Logger.info("register class for " + paramString);
      return;
    }
    catch (Exception localException)
    {
      Logger.warning("register class not found for " + paramString + ", " + localException.toString());
    }
  }
  
  protected void register(String paramString1, String paramString2)
  {
    if (this.routeRegister == null) {}
    while (this.registeredActivityName.put(paramString1, paramString2) != null) {
      return;
    }
    this.routeRegister.register(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.BaseRouteInitializer
 * JD-Core Version:    0.7.0.1
 */