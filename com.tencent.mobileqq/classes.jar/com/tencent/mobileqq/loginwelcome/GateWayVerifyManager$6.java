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
    GateWayVerifyManager.a(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager).removeCallbacksAndMessages(null);
    GateWayVerifyManager.a(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager, this.jdField_a_of_type_TencentImLoginGatewayVerify$SelfPhoneUrl, paramNetwork, new NetGatewayCallback(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback, paramNetwork));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.6
 * JD-Core Version:    0.7.0.1
 */