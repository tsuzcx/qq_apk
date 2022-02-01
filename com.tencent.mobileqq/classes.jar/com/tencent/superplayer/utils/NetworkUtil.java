package com.tencent.superplayer.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class NetworkUtil
{
  private static final String TAG = "NetworkUtil";
  
  public static int getMobileSubType(int paramInt)
  {
    if (paramInt != 20)
    {
      switch (paramInt)
      {
      default: 
        return 0;
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
        return 3;
      }
      return 2;
    }
    return 5;
  }
  
  @SuppressLint({"MissingPermission"})
  public static int getNetWorkType()
  {
    Object localObject = SuperPlayerSDKMgr.getContext();
    if (localObject == null) {
      return 0;
    }
    try
    {
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          int i = ((NetworkInfo)localObject).getType();
          if (i != 0)
          {
            if (i == 1) {
              break label84;
            }
            if (i == 9) {
              break label81;
            }
            return 0;
          }
          i = getMobileSubType(((NetworkInfo)localObject).getSubtype());
          return i;
        }
      }
    }
    catch (Exception localException)
    {
      TPLogUtil.e("NetworkUtil", localException);
    }
    return 0;
    label81:
    return 10;
    label84:
    return 1;
  }
  
  public static boolean isWifiConnected()
  {
    return getNetWorkType() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */