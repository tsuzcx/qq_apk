package com.tencent.mobileqq.uftransfer.depend;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.wstt.SSCM.SSCM;

public class UFTSscm
{
  private SSCM a = new SSCM();
  
  public UFTSscm()
  {
    this.a.a();
  }
  
  public int a(long paramLong1, long paramLong2)
  {
    int j = this.a.a(BaseApplication.getContext(), paramLong2, paramLong1, 1048576);
    int k = a(BaseApplication.getContext());
    int i;
    if (k != 1)
    {
      i = j;
      if (k != 2) {}
    }
    else
    {
      i = j;
      if (j > 16384) {
        i = 16384;
      }
    }
    return i;
  }
  
  public int a(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return -1;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject != null)
    {
      if (!((NetworkInfo)localObject).isAvailable()) {
        return -1;
      }
      if (((NetworkInfo)localObject).getType() == 1) {
        return 0;
      }
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
      if ((i != 1) && (i != 2) && (i != 4)) {
        return 1;
      }
      return 2;
    }
    return -1;
  }
  
  public void a()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.UFTSscm
 * JD-Core Version:    0.7.0.1
 */