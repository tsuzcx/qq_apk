package com.tencent.mobileqq.qroute.route;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

public class ActivityURIRequest
  extends URIRequest
{
  final URIRequest request;
  
  public ActivityURIRequest(Context paramContext, String paramString)
  {
    super(paramContext, Uri.parse(normalizePath(paramString)), null);
    this.request = this;
  }
  
  ActivityURIRequest(URIRequest paramURIRequest)
  {
    super(null, null, null);
    this.request = paramURIRequest;
  }
  
  protected static String normalizePath(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    String str = paramString;
    if (!paramString.startsWith("/")) {
      str = "/" + paramString;
    }
    return "qroute://page" + str;
  }
  
  public Bundle extra()
  {
    Bundle localBundle2 = (Bundle)this.request.getField(Bundle.class, "com.tencent.mobileqq.qroute.route.intentExtra");
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null)
    {
      localBundle1 = new Bundle();
      this.request.putField("com.tencent.mobileqq.qroute.route.intentExtra", localBundle1);
    }
    return localBundle1;
  }
  
  public int flags()
  {
    return ((Integer)this.request.getField(Integer.class, "com.tencent.mobileqq.qroute.route.flags", Integer.valueOf(0))).intValue();
  }
  
  public URIRequest getRequest()
  {
    return this.request;
  }
  
  public Bundle options()
  {
    return options(true);
  }
  
  Bundle options(boolean paramBoolean)
  {
    Bundle localBundle2 = (Bundle)this.request.getField(Bundle.class, "com.tencent.mobileqq.qroute.route.options");
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null)
    {
      localBundle1 = localBundle2;
      if (paramBoolean)
      {
        localBundle1 = new Bundle();
        this.request.putField("com.tencent.mobileqq.qroute.route.options", localBundle1);
      }
    }
    return localBundle1;
  }
  
  public int[] overridePendingTransition()
  {
    return (int[])this.request.getField([I.class, "com.tencent.mobileqq.qroute.route.overridePendingTransition", null);
  }
  
  public Integer requestCode()
  {
    return (Integer)this.request.getField(Integer.class, "com.tencent.mobileqq.qroute.route.requestCode", null);
  }
  
  public ActivityURIRequest setFlags(int paramInt)
  {
    this.request.putField("com.tencent.mobileqq.qroute.route.flags", Integer.valueOf(paramInt));
    return this;
  }
  
  public ActivityURIRequest setOptions(Bundle paramBundle)
  {
    options().putAll(paramBundle);
    return this;
  }
  
  public ActivityURIRequest setOverridePendingTransition(int paramInt1, int paramInt2)
  {
    this.request.putField("com.tencent.mobileqq.qroute.route.overridePendingTransition", new int[] { paramInt1, paramInt2 });
    return this;
  }
  
  public ActivityURIRequest setRequestCode(int paramInt)
  {
    this.request.putField("com.tencent.mobileqq.qroute.route.requestCode", Integer.valueOf(paramInt));
    return this;
  }
  
  public ActivityURIRequest setStartActivityAction(StartActivityAction paramStartActivityAction)
  {
    this.request.putField("com.tencent.mobileqq.qroute.route.action", paramStartActivityAction);
    return this;
  }
  
  public StartActivityAction startActivityAction()
  {
    return (StartActivityAction)this.request.getField(StartActivityAction.class, "com.tencent.mobileqq.qroute.route.action");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.ActivityURIRequest
 * JD-Core Version:    0.7.0.1
 */