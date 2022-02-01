package com.tencent.qmsp.sdk.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class f
{
  public static NetworkInfo a(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return paramContext;
    }
    finally
    {
      g.b("Qp.NU", 0, paramContext.toString());
    }
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = a(paramContext);
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.getType() == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.f
 * JD-Core Version:    0.7.0.1
 */