package com.tencent.mobileqq.qroute.route;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

abstract class AbsActivityHandler
  extends URIHandler
{
  protected final ActivityLauncher activityLauncher;
  
  AbsActivityHandler(ActivityLauncher paramActivityLauncher)
  {
    this.activityLauncher = paramActivityLauncher;
  }
  
  static <T> Class<? extends Activity> castToActivityClass(T paramT)
  {
    try
    {
      if (Activity.class.isAssignableFrom((Class)paramT))
      {
        paramT = (Class)paramT;
        return paramT;
      }
      return null;
    }
    catch (ClassCastException paramT) {}
    return null;
  }
  
  public static <T> URIHandler createHandler(T paramT)
  {
    if ((paramT instanceof String)) {
      return new ActivityClassNameHandler((String)paramT, new DefaultActivityLauncher());
    }
    if ((paramT instanceof Class))
    {
      paramT = castToActivityClass(paramT);
      if (paramT == null)
      {
        Logger.warning("create activity handler failed, not an activity class");
        return null;
      }
      return new ActivityClassHandler(paramT, new DefaultActivityLauncher());
    }
    StringBuilder localStringBuilder = new StringBuilder().append("invalid type for create activity handler, ");
    if (paramT == null) {}
    for (paramT = "(null)";; paramT = paramT.toString())
    {
      Logger.warning(paramT);
      return null;
    }
  }
  
  protected abstract Intent createIntent(URIRequest paramURIRequest);
  
  protected void handleURI(URIRequest paramURIRequest, URIRequestCallback paramURIRequestCallback)
  {
    try
    {
      Intent localIntent = createIntent(paramURIRequest);
      if ((localIntent == null) || (localIntent.getComponent() == null))
      {
        Logger.warning("create intent fail, " + paramURIRequest.getURI().toString());
        paramURIRequestCallback.onComplete(1000);
        return;
      }
      localIntent.setData(paramURIRequest.getURI());
      int i = this.activityLauncher.startActivity(localIntent, paramURIRequest);
      if (i != 0) {
        Logger.info("start activity fail, code is " + i);
      }
      paramURIRequestCallback.onComplete(i);
      return;
    }
    catch (Exception paramURIRequest)
    {
      Logger.warning("handle activity uri fail, " + paramURIRequest.toString());
      paramURIRequestCallback.onComplete(1000);
    }
  }
  
  protected boolean shouldHandleURI(URIRequest paramURIRequest)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.AbsActivityHandler
 * JD-Core Version:    0.7.0.1
 */