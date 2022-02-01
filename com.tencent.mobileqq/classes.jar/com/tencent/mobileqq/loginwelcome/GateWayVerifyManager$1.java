package com.tencent.mobileqq.loginwelcome;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;

class GateWayVerifyManager$1
  extends ConnectivityManager.NetworkCallback
{
  GateWayVerifyManager$1(GateWayVerifyManager paramGateWayVerifyManager) {}
  
  public void onAvailable(Network paramNetwork)
  {
    GateWayVerifyManager.a(this.a, paramNetwork);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.1
 * JD-Core Version:    0.7.0.1
 */