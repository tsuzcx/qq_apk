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
    switch (paramInt)
    {
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 2;
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
    case 13: 
      return 4;
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
      if (localObject == null) {
        break label109;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject == null) || (!((NetworkInfo)localObject).isConnected())) {
        break label109;
      }
      switch (((NetworkInfo)localObject).getType())
      {
      case 0: 
        i = getMobileSubType(((NetworkInfo)localObject).getSubtype());
      }
    }
    catch (Exception localException)
    {
      TPLogUtil.e("NetworkUtil", localException);
      i = 0;
    }
    int i = 1;
    return i;
    return 10;
    label109:
    i = 0;
    return i;
  }
  
  public static boolean isWifiConnected()
  {
    return getNetWorkType() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */