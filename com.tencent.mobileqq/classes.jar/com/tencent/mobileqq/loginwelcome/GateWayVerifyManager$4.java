package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.werewolves.ReflectUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

class GateWayVerifyManager$4
  implements Runnable
{
  GateWayVerifyManager$4(GateWayVerifyManager paramGateWayVerifyManager, GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
        ReflectUtils.a(ConnectivityManager.class, "startUsingNetworkFeature", new Class[] { Integer.TYPE, String.class }).invoke(localObject1, new Object[] { Integer.valueOf(0), "enableHIPRI" });
        i = 0;
        if (i < 4)
        {
          localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(5);
          if (localObject2 == null)
          {
            QLog.e("GateWayVerifyManager", 1, "networkInfo is null");
          }
          else
          {
            localObject2 = ((NetworkInfo)localObject2).getState();
            if (localObject2 == null)
            {
              QLog.e("GateWayVerifyManager", 1, "checkState is null");
            }
            else if (((NetworkInfo.State)localObject2).compareTo(NetworkInfo.State.CONNECTED) != 0)
            {
              Thread.sleep(1000L);
              i += 1;
              continue;
            }
          }
        }
        Object localObject2 = InetAddress.getByName(new URL(this.a.str_upload_url.get()).getHost());
        if ((localObject2 instanceof Inet4Address))
        {
          i = GateWayVerifyManager.a(this.this$0, ((InetAddress)localObject2).getHostAddress());
        }
        else
        {
          if (!(localObject2 instanceof Inet6Address)) {
            break label382;
          }
          i = GateWayVerifyManager.b(this.this$0, ((InetAddress)localObject2).getHostAddress()).intValue();
        }
        localObject1 = ReflectUtils.a(ConnectivityManager.class, "requestRouteToHost", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(5), Integer.valueOf(i) });
        if ((!(localObject1 instanceof Boolean)) || (!((Boolean)localObject1).booleanValue())) {
          break label387;
        }
        bool = true;
        QLog.d("GateWayVerifyManager", 1, new Object[] { "changeNetTypeToMobileV19 finish: ", Boolean.valueOf(bool) });
        if (bool)
        {
          GateWayVerifyManager.a(this.this$0, this.a, this.b);
          return;
        }
        QLog.e("GateWayVerifyManager", 1, "切换网络失败or无数据网络");
        this.b.a(new Exception("change network to mobile failed or no mobile network"));
        return;
      }
      catch (Exception localException)
      {
        QLog.e("GateWayVerifyManager", 1, new Object[] { "switch network error", localException.getMessage() });
        this.b.a(localException);
        return;
      }
      label382:
      int i = 0;
      continue;
      label387:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.4
 * JD-Core Version:    0.7.0.1
 */