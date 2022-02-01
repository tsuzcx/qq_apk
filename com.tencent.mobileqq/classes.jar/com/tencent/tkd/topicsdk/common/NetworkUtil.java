package com.tencent.tkd.topicsdk.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.util.Log;

public class NetworkUtil
{
  public static NetworkInfo a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      a("NetWorkState Unavailabel");
      return null;
    }
    NetworkInfo localNetworkInfo = paramContext.getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      a("default NetWorkState Availabel");
      return localNetworkInfo;
    }
    paramContext = paramContext.getAllNetworkInfo();
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.length)
      {
        if (paramContext[i].getState() == NetworkInfo.State.CONNECTED)
        {
          a("NetWorkState Availabel");
          return paramContext[i];
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    Log.d("NetworkUtil", paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    return a(a(paramContext));
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {}
    while ((paramNetworkInfo.getType() != 0) && (50 != paramNetworkInfo.getType())) {
      return false;
    }
    return true;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      a("NetWorkState Unavailabel");
    }
    for (;;)
    {
      return false;
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          if (paramContext[i].getState() == NetworkInfo.State.CONNECTED)
          {
            a("NetWorkState Availabel");
            return true;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */