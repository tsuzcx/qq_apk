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
    StringBuilder localStringBuilder1;
    if (this.routeRegister == null)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("register fail for ");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append(", routeRegister not assigned");
      Logger.warning(localStringBuilder1.toString());
      return;
    }
    if (!this.registeredClassName.add(paramString)) {
      return;
    }
    try
    {
      ((RouteInitializer)Class.forName(paramString).newInstance()).init(this.routeRegister);
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("register class for ");
      localStringBuilder1.append(paramString);
      Logger.info(localStringBuilder1.toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("register class not found for ");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(", ");
      localStringBuilder2.append(localException.toString());
      Logger.warning(localStringBuilder2.toString());
    }
  }
  
  protected void register(String paramString1, String paramString2)
  {
    if (this.routeRegister == null) {
      return;
    }
    if (this.registeredActivityName.put(paramString1, paramString2) != null) {
      return;
    }
    this.routeRegister.register(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.BaseRouteInitializer
 * JD-Core Version:    0.7.0.1
 */