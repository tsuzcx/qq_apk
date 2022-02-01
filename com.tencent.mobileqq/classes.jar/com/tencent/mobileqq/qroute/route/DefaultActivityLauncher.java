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
      Method localMethod = paramContext.getClass().getMethod("startActivity", new Class[] { Intent.class });
      paramContext = paramContext.getClass().getMethod("startActivity", new Class[] { Intent.class, Bundle.class });
      boolean bool = localMethod.getDeclaringClass().isAssignableFrom(paramContext.getDeclaringClass());
      return bool;
    }
    catch (Exception paramContext)
    {
      Logger.warning("failed to check activity method, " + paramContext.toString());
    }
    return false;
  }
  
  protected static boolean checkStartActivityForResult(Context paramContext)
  {
    try
    {
      Method localMethod = paramContext.getClass().getMethod("startActivityForResult", new Class[] { Intent.class, Integer.TYPE });
      paramContext = paramContext.getClass().getMethod("startActivityForResult", new Class[] { Intent.class, Integer.TYPE, Bundle.class });
      boolean bool = localMethod.getDeclaringClass().isAssignableFrom(paramContext.getDeclaringClass());
      return bool;
    }
    catch (Exception paramContext)
    {
      Logger.warning("failed to check activity method, " + paramContext.toString());
    }
    return false;
  }
  
  protected static void printCheckStartActivityFailMessage(Context paramContext)
  {
    Logger.warning("startActivity(Intent) and startActivity(Intent, Bundle) is either override in class " + paramContext.getClass().toString() + ", you should override them both or none");
  }
  
  protected static void setIntentParams(ActivityURIRequest paramActivityURIRequest, Intent paramIntent)
  {
    Bundle localBundle = paramActivityURIRequest.extra();
    if (localBundle != null) {
      paramIntent.putExtras(localBundle);
    }
    int i = paramActivityURIRequest.flags();
    if (i != 0) {
      paramIntent.setFlags(i);
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
    int j = 1000;
    int i = j;
    if (paramURIRequest != null)
    {
      if (paramIntent != null) {
        break label18;
      }
      i = j;
    }
    label18:
    Context localContext;
    Integer localInteger;
    do
    {
      return i;
      localContext = paramURIRequest.getContext();
      if (localContext == null)
      {
        Logger.warning("fail to start activity, context is null, uri is " + paramURIRequest.getURI().toString());
        return 1000;
      }
      paramURIRequest = new ActivityURIRequest(paramURIRequest);
      setIntentParams(paramURIRequest, paramIntent);
      paramIntent.setPackage(localContext.getPackageName());
      localInteger = paramURIRequest.requestCode();
      j = startIntent(paramURIRequest, paramIntent, localContext, localInteger, true);
      i = j;
    } while (j == 0);
    paramIntent.setPackage(null);
    return startIntent(paramURIRequest, paramIntent, localContext, localInteger, false);
  }
  
  protected static int startActivityByAction(ActivityURIRequest paramActivityURIRequest, Intent paramIntent)
  {
    int i = 1000;
    try
    {
      StartActivityAction localStartActivityAction = paramActivityURIRequest.startActivityAction();
      if (localStartActivityAction == null) {
        return 1000;
      }
      if (localStartActivityAction.startActivity(paramActivityURIRequest, paramIntent))
      {
        setOverridePendingTransition(paramActivityURIRequest);
        return 0;
      }
    }
    catch (ActivityNotFoundException paramActivityURIRequest)
    {
      Logger.warning("fail to start activity, " + paramActivityURIRequest.toString());
      return 1001;
    }
    catch (SecurityException paramActivityURIRequest)
    {
      Logger.warning("fail to start activity, " + paramActivityURIRequest.toString());
      i = 1002;
    }
    return i;
  }
  
  protected static int startActivityByDefault(ActivityURIRequest paramActivityURIRequest, Intent paramIntent, Context paramContext, Integer paramInteger)
  {
    for (;;)
    {
      try
      {
        localBundle = paramActivityURIRequest.options(false);
        if ((paramInteger == null) || (!(paramContext instanceof Activity))) {
          continue;
        }
        if (localBundle != null) {
          continue;
        }
        ((Activity)paramContext).startActivityForResult(paramIntent, paramInteger.intValue());
      }
      catch (ActivityNotFoundException paramActivityURIRequest)
      {
        Logger.warning("fail to start activity, " + paramActivityURIRequest.toString());
        return 1001;
        if (localBundle != null) {
          continue;
        }
        paramContext.startActivity(paramIntent);
        continue;
      }
      catch (SecurityException paramActivityURIRequest)
      {
        Bundle localBundle;
        Logger.warning("fail to start activity, " + paramActivityURIRequest.toString());
        return 1002;
        if (checkStartActivity(paramContext)) {
          continue;
        }
        printCheckStartActivityFailMessage(paramContext);
        paramContext.startActivity(paramIntent, localBundle);
        continue;
      }
      catch (Exception paramActivityURIRequest)
      {
        Logger.warning("fail to start activity, " + paramActivityURIRequest.toString());
      }
      setOverridePendingTransition(paramActivityURIRequest);
      return 0;
      if (!checkStartActivityForResult(paramContext)) {
        printCheckStartActivityFailMessage(paramContext);
      }
      ((Activity)paramContext).startActivityForResult(paramIntent, paramInteger.intValue(), localBundle);
    }
    return 1000;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.DefaultActivityLauncher
 * JD-Core Version:    0.7.0.1
 */