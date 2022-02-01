package com.tencent.mobileqq.loginwelcome;

class GateWayVerifyManager$5
  implements Runnable
{
  GateWayVerifyManager$5(GateWayVerifyManager paramGateWayVerifyManager, GateWayVerifyManager.OnNetChangedListener paramOnNetChangedListener, GatewayCallback paramGatewayCallback) {}
  
  public void run()
  {
    GateWayVerifyManager.a(this.this$0, this.a);
    this.b.a(new Exception("change network to mobile timeout"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.5
 * JD-Core Version:    0.7.0.1
 */