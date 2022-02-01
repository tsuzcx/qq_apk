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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid type for create activity handler, ");
    if (paramT == null) {
      paramT = "(null)";
    } else {
      paramT = paramT.toString();
    }
    localStringBuilder.append(paramT);
    Logger.warning(localStringBuilder.toString());
    return null;
  }
  
  protected abstract Intent createIntent(URIRequest paramURIRequest);
  
  protected void handleURI(URIRequest paramURIRequest, URIRequestCallback paramURIRequestCallback)
  {
    try
    {
      localObject = createIntent(paramURIRequest);
      if ((localObject != null) && (((Intent)localObject).getComponent() != null))
      {
        int i = this.activityLauncher.startActivity((Intent)localObject, paramURIRequest);
        if (i != 0)
        {
          paramURIRequest = new StringBuilder();
          paramURIRequest.append("start activity fail, code is ");
          paramURIRequest.append(i);
          Logger.info(paramURIRequest.toString());
        }
        paramURIRequestCallback.onComplete(i);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create intent fail, ");
      ((StringBuilder)localObject).append(paramURIRequest.getURI().toString());
      Logger.warning(((StringBuilder)localObject).toString());
      paramURIRequestCallback.onComplete(1000);
      return;
    }
    catch (Exception paramURIRequest)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle activity uri fail, ");
      ((StringBuilder)localObject).append(paramURIRequest.toString());
      Logger.warning(((StringBuilder)localObject).toString());
      paramURIRequestCallback.onComplete(1000);
    }
  }
  
  protected boolean shouldHandleURI(URIRequest paramURIRequest)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.AbsActivityHandler
 * JD-Core Version:    0.7.0.1
 */