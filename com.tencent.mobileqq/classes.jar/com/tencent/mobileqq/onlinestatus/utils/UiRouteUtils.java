package com.tencent.mobileqq.onlinestatus.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;

public class UiRouteUtils
{
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    QLog.d("RouteUtils", 1, new Object[] { "startActivity, path : ", paramString });
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramContext, paramString);
    if (paramIntent != null)
    {
      paramString = paramIntent.getExtras();
      Bundle localBundle = localActivityURIRequest.extra();
      paramContext = paramString;
      if (paramString == null) {
        paramContext = new Bundle();
      }
      localBundle.putAll(paramContext);
      localActivityURIRequest.setFlags(paramIntent.getFlags());
    }
    QRoute.startUri(localActivityURIRequest, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.UiRouteUtils
 * JD-Core Version:    0.7.0.1
 */