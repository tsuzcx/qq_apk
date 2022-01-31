package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import atvi;
import atvk;
import bely;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;

public final class GateWayVerifyMobileHelper$2
  implements Runnable
{
  public GateWayVerifyMobileHelper$2(String paramString, atvk paramatvk) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      Object localObject2;
      boolean bool;
      try
      {
        Object localObject1 = (ConnectivityManager)BaseApplicationImpl.getApplication().getSystemService("connectivity");
        bely.a(ConnectivityManager.class, "startUsingNetworkFeature", new Class[] { Integer.TYPE, String.class }).invoke(localObject1, new Object[] { Integer.valueOf(0), "enableHIPRI" });
        i = 0;
        if (i < 4)
        {
          localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(5);
          if (localObject2 == null) {
            QLog.e("GateWayVerifyMobileHelper", 1, "networkInfo is null");
          }
        }
        else
        {
          localObject2 = InetAddress.getByName(new URL(this.jdField_a_of_type_JavaLangString).getHost());
          if (!(localObject2 instanceof Inet4Address)) {
            break label302;
          }
          i = atvi.a(((InetAddress)localObject2).getHostAddress());
          localObject1 = bely.a(ConnectivityManager.class, "requestRouteToHost", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(5), Integer.valueOf(i) });
          if ((!(localObject1 instanceof Boolean)) || (!((Boolean)localObject1).booleanValue())) {
            break label357;
          }
          bool = true;
          QLog.d("GateWayVerifyMobileHelper", 1, new Object[] { "changeNetTypeToMobileV19 finish: ", Boolean.valueOf(bool) });
          if (!bool) {
            break label325;
          }
          atvi.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atvk);
          return;
        }
        localObject2 = ((NetworkInfo)localObject2).getState();
        if (localObject2 == null)
        {
          QLog.e("GateWayVerifyMobileHelper", 1, "checkState is null");
          continue;
        }
        if (((NetworkInfo.State)localObject2).compareTo(NetworkInfo.State.CONNECTED) == 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.e("GateWayVerifyMobileHelper", 1, new Object[] { "switch network error", localException.getMessage() });
        this.jdField_a_of_type_Atvk.a(localException);
        return;
      }
      Thread.sleep(1000L);
      i += 1;
      continue;
      label302:
      if ((localObject2 instanceof Inet6Address))
      {
        i = atvi.a(((InetAddress)localObject2).getHostAddress()).intValue();
        continue;
        label325:
        QLog.e("GateWayVerifyMobileHelper", 1, "切换网络失败or无数据网络");
        this.jdField_a_of_type_Atvk.a(new Exception("change network to mobile failed or no mobile network"));
      }
      else
      {
        i = 0;
        continue;
        label357:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyMobileHelper.2
 * JD-Core Version:    0.7.0.1
 */