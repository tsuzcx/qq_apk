package com.tencent.mobileqq.qroute.route;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.lang.reflect.Method;

class DefaultActivityLauncher
  implements ActivityLauncher
{
  protected static boolean checkStartActivity(Context paramContext)
  {
    try
    {
      localObject = paramContext.getClass().getMethod("startActivity", new Class[] { Intent.class });
      paramContext = paramContext.getClass().getMethod("startActivity", new Class[] { Intent.class, Bundle.class });
      boolean bool = ((Method)localObject).getDeclaringClass().isAssignableFrom(paramContext.getDeclaringClass());
      return bool;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("failed to check activity method, ");
      ((StringBuilder)localObject).append(paramContext.toString());
      Logger.warning(((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  protected static boolean checkStartActivityForResult(Context paramContext)
  {
    try
    {
      localObject = paramContext.getClass().getMethod("startActivityForResult", new Class[] { Intent.class, Integer.TYPE });
      paramContext = paramContext.getClass().getMethod("startActivityForResult", new Class[] { Intent.class, Integer.TYPE, Bundle.class });
      boolean bool = ((Method)localObject).getDeclaringClass().isAssignableFrom(paramContext.getDeclaringClass());
      return bool;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("failed to check activity method, ");
      ((StringBuilder)localObject).append(paramContext.toString());
      Logger.warning(((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  protected static void printCheckStartActivityFailMessage(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startActivity(Intent) and startActivity(Intent, Bundle) is either override in class ");
    localStringBuilder.append(paramContext.getClass().toString());
    localStringBuilder.append(", you should override them both or none");
    Logger.warning(localStringBuilder.toString());
  }
  
  protected static void setIntentParams(ActivityURIRequest paramActivityURIRequest, Intent paramIntent)
  {
    Object localObject = paramActivityURIRequest.extra();
    if (localObject != null) {
      paramIntent.putExtras((Bundle)localObject);
    }
    int i = paramActivityURIRequest.flags();
    if (i != 0) {
      paramIntent.setFlags(i);
    }
    localObject = paramActivityURIRequest.data();
    if (localObject != null) {
      paramIntent.setData((Uri)localObject);
    }
    localObject = paramActivityURIRequest.type();
    if (localObject != null) {
      paramIntent.setType((String)localObject);
    }
    paramActivityURIRequest = paramActivityURIRequest.intentAction();
    if (paramActivityURIRequest != null) {
      paramIntent.setAction(paramActivityURIRequest);
    }
  }
  
  protected static void setOverridePendingTransition(ActivityURIRequest paramActivityURIRequest)
  {
    Context localContext = paramActivityURIRequest.getRequest().getContext();
    paramActivityURIRequest = paramActivityURIRequest.overridePendingTransition();
    if (((localContext instanceof Activity)) && (paramActivityURIRequest != null) && (paramActivityURIRequest.length == 2)) {
      ((Activity)localContext).overridePendingTransition(paramActivityURIRequest[0], paramActivityURIRequest[1]);
    }
  }
  
  protected static int startActivity(URIRequest paramURIRequest, Intent paramIntent)
  {
    if (paramURIRequest != null)
    {
      if (paramIntent == null) {
        return 1000;
      }
      Context localContext = paramURIRequest.getContext();
      if (localContext == null)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("fail to start activity, context is null, uri is ");
        paramIntent.append(paramURIRequest.getURI().toString());
        Logger.warning(paramIntent.toString());
        return 1000;
      }
      paramURIRequest = new ActivityURIRequest(paramURIRequest);
      setIntentParams(paramURIRequest, paramIntent);
      paramIntent.setPackage(localContext.getPackageName());
      Integer localInteger = paramURIRequest.requestCode();
      int i = startIntent(paramURIRequest, paramIntent, localContext, localInteger, true);
      if (i == 0) {
        return i;
      }
      paramIntent.setPackage(null);
      return startIntent(paramURIRequest, paramIntent, localContext, localInteger, false);
    }
    return 1000;
  }
  
  protected static int startActivityByAction(ActivityURIRequest paramActivityURIRequest, Intent paramIntent)
  {
    try
    {
      StartActivityAction localStartActivityAction = paramActivityURIRequest.startActivityAction();
      if (localStartActivityAction == null) {
        return 1000;
      }
      if (!localStartActivityAction.startActivity(paramActivityURIRequest, paramIntent)) {
        return 1000;
      }
      setOverridePendingTransition(paramActivityURIRequest);
      return 0;
    }
    catch (SecurityException paramActivityURIRequest)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("fail to start activity, ");
      paramIntent.append(paramActivityURIRequest.toString());
      Logger.warning(paramIntent.toString());
      return 1002;
    }
    catch (ActivityNotFoundException paramActivityURIRequest)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("fail to start activity, ");
      paramIntent.append(paramActivityURIRequest.toString());
      Logger.warning(paramIntent.toString());
    }
    return 1001;
  }
  
  protected static int startActivityByDefault(ActivityURIRequest paramActivityURIRequest, Intent paramIntent, Context paramContext, Integer paramInteger)
  {
    try
    {
      Bundle localBundle = paramActivityURIRequest.options(false);
      if ((paramInteger != null) && ((paramContext instanceof Activity)))
      {
        if (localBundle == null)
        {
          ((Activity)paramContext).startActivityForResult(paramIntent, paramInteger.intValue());
        }
        else
        {
          if (!checkStartActivityForResult(paramContext)) {
            printCheckStartActivityFailMessage(paramContext);
          }
          ((Activity)paramContext).startActivityForResult(paramIntent, paramInteger.intValue(), localBundle);
        }
      }
      else if (localBundle == null)
      {
        paramContext.startActivity(paramIntent);
      }
      else
      {
        if (!checkStartActivity(paramContext)) {
          printCheckStartActivityFailMessage(paramContext);
        }
        paramContext.startActivity(paramIntent, localBundle);
      }
      setOverridePendingTransition(paramActivityURIRequest);
      return 0;
    }
    catch (Exception paramActivityURIRequest)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("fail to start activity, ");
      paramIntent.append(paramActivityURIRequest.toString());
      Logger.warning(paramIntent.toString());
      return 1000;
    }
    catch (SecurityException paramActivityURIRequest)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("fail to start activity, ");
      paramIntent.append(paramActivityURIRequest.toString());
      Logger.warning(paramIntent.toString());
      return 1002;
    }
    catch (ActivityNotFoundException paramActivityURIRequest)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("fail to start activity, ");
      paramIntent.append(paramActivityURIRequest.toString());
      Logger.warning(paramIntent.toString());
    }
    return 1001;
  }
  
  protected static int startIntent(ActivityURIRequest paramActivityURIRequest, Intent paramIntent, Context paramContext, Integer paramInteger, boolean paramBoolean)
  {
    if (startActivityByAction(paramActivityURIRequest, paramIntent) == 0) {
      return 0;
    }
    return startActivityByDefault(paramActivityURIRequest, paramIntent, paramContext, paramInteger);
  }
  
  public int startActivity(Intent paramIntent, URIRequest paramURIRequest)
  {
    return startActivity(paramURIRequest, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.DefaultActivityLauncher
 * JD-Core Version:    0.7.0.1
 */