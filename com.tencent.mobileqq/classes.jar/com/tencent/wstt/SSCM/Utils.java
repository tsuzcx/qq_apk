package com.tencent.wstt.SSCM;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class Utils
{
  public static final int a(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return -1;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if ((localObject == null) || (!((NetworkInfo)localObject).isAvailable())) {
      return -1;
    }
    if (((NetworkInfo)localObject).getType() == 1) {
      return 0;
    }
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
    {
    case 3: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 2;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.wstt.SSCM.Utils
 * JD-Core Version:    0.7.0.1
 */