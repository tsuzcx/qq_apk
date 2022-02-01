package com.tencent.mobileqq.loginwelcome;

import android.net.Network;
import mqq.os.MqqHandler;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

class GateWayVerifyManager$6
  implements GateWayVerifyManager.OnNetChangedListener
{
  GateWayVerifyManager$6(GateWayVerifyManager paramGateWayVerifyManager, GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback) {}
  
  public void a(Network paramNetwork)
  {
    GateWayVerifyManager.a(this.c).removeCallbacksAndMessages(null);
    GateWayVerifyManager.a(this.c, this.a, paramNetwork, new NetGatewayCallback(this.b, paramNetwork));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.6
 * JD-Core Version:    0.7.0.1
 */