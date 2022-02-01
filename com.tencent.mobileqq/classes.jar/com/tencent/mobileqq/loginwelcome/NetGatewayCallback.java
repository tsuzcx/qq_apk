package com.tencent.mobileqq.loginwelcome;

import android.net.Network;
import android.support.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

@RequiresApi(api=21)
public class NetGatewayCallback
  implements GatewayCallback
{
  private GatewayCallback a;
  private Network b;
  
  NetGatewayCallback(GatewayCallback paramGatewayCallback, Network paramNetwork)
  {
    this.a = paramGatewayCallback;
    this.b = paramNetwork;
  }
  
  private boolean a()
  {
    for (;;)
    {
      try
      {
        boolean bool2 = GateWayVerifyManager.b();
        bool1 = true;
        if (bool2) {
          return true;
        }
        if (!this.b.equals(GateWayVerifyManager.a().c())) {
          return bool1;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  private void b()
  {
    try
    {
      if (!GateWayVerifyManager.b()) {
        GateWayVerifyManager.a().e();
      }
      return;
    }
    finally {}
  }
  
  public void a(Exception paramException)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onChangeNetworkError, but this request is expired");
      return;
    }
    b();
    this.a.a(paramException);
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onRedirect, but this request is expired");
      return;
    }
    this.a.a(paramSelfPhoneUrl);
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, String paramString)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onResponse, but this request is expired");
      return;
    }
    this.a.a(paramSelfPhoneUrl, paramString);
  }
  
  public void b(int paramInt, Exception paramException)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onGetTokenError, but this request is expired");
      return;
    }
    b();
    this.a.b(paramInt, paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.NetGatewayCallback
 * JD-Core Version:    0.7.0.1
 */