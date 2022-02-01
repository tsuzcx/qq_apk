package com.tencent.mobileqq.loginwelcome;

import android.net.Network;
import android.support.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

@RequiresApi(api=21)
public class NetGatewayCallback
  implements GatewayCallback
{
  private Network jdField_a_of_type_AndroidNetNetwork;
  private GatewayCallback jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback;
  
  NetGatewayCallback(GatewayCallback paramGatewayCallback, Network paramNetwork)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback = paramGatewayCallback;
    this.jdField_a_of_type_AndroidNetNetwork = paramNetwork;
  }
  
  private void a()
  {
    try
    {
      if (!GateWayVerifyManager.a()) {
        GateWayVerifyManager.a().a();
      }
      return;
    }
    finally {}
  }
  
  private boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (GateWayVerifyManager.a()) {
          return true;
        }
        if (!this.jdField_a_of_type_AndroidNetNetwork.equals(GateWayVerifyManager.a().a())) {
          return bool;
        }
      }
      finally {}
      bool = false;
    }
  }
  
  public void a(Exception paramException)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onChangeNetworkError, but this request is expired");
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback.a(paramException);
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onRedirect, but this request is expired");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback.a(paramSelfPhoneUrl);
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, String paramString)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onResponse, but this request is expired");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback.a(paramSelfPhoneUrl, paramString);
  }
  
  public void b(int paramInt, Exception paramException)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onGetTokenError, but this request is expired");
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback.b(paramInt, paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.NetGatewayCallback
 * JD-Core Version:    0.7.0.1
 */