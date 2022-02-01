package com.tencent.mobileqq.qroute.route;

import android.app.Activity;

public abstract interface IRouteRegister
{
  public abstract void register(String paramString, Class<? extends Activity> paramClass);
  
  public abstract void register(String paramString1, String paramString2);
  
  public abstract void register(String paramString1, String paramString2, URIHandler paramURIHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.IRouteRegister
 * JD-Core Version:    0.7.0.1
 */