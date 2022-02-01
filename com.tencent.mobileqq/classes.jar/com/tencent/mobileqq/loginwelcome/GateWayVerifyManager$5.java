package com.tencent.mobileqq.loginwelcome;

class GateWayVerifyManager$5
  implements Runnable
{
  GateWayVerifyManager$5(GateWayVerifyManager paramGateWayVerifyManager, GateWayVerifyManager.OnNetChangedListener paramOnNetChangedListener, GatewayCallback paramGatewayCallback) {}
  
  public void run()
  {
    GateWayVerifyManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager$OnNetChangedListener);
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback.a(new Exception("change network to mobile timeout"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.5
 * JD-Core Version:    0.7.0.1
 */