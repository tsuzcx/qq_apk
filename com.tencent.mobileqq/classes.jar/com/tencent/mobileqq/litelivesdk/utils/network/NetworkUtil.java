package com.tencent.mobileqq.litelivesdk.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil
{
  public static boolean a = false;
  
  public static int a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()))
      {
        int i = paramContext.getType();
        if (i != 0)
        {
          if (i != 1) {
            return 4;
          }
          return 1;
        }
        switch (paramContext.getSubtype())
        {
        case 19: 
        default: 
          break;
        case 20: 
          return 5;
        case 13: 
        case 18: 
          return 4;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
        case 17: 
          return 3;
        case 1: 
        case 2: 
        case 4: 
        case 7: 
        case 11: 
        case 16: 
          return 2;
        }
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.network.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */