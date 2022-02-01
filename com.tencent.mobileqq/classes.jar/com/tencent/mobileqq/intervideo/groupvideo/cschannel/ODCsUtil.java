package com.tencent.mobileqq.intervideo.groupvideo.cschannel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ODCsUtil
{
  public static int a(Context paramContext)
  {
    int j = b(paramContext);
    if (j != 0)
    {
      int i = 1;
      if (j != 1)
      {
        i = 2;
        if (j != 2)
        {
          i = 3;
          if (j != 3)
          {
            i = 4;
            if (j != 4)
            {
              if (j != 5) {
                return -1;
              }
              return 0;
            }
          }
        }
      }
      return i;
    }
    return -1;
  }
  
  public static int b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext != null)
    {
      if (!paramContext.isConnected()) {
        return 0;
      }
      int j = paramContext.getType();
      if (j != 0)
      {
        int i = 1;
        if (j != 1)
        {
          if (j != 9) {
            return -1;
          }
          i = 5;
        }
        return i;
      }
      switch (paramContext.getSubtype())
      {
      case 16: 
      default: 
        return -1;
      case 13: 
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
      }
      return 2;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.cschannel.ODCsUtil
 * JD-Core Version:    0.7.0.1
 */