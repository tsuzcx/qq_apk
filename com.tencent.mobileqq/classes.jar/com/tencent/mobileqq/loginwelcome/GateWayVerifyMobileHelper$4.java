package com.tencent.mobileqq.loginwelcome;

import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import atvk;

public final class GateWayVerifyMobileHelper$4
  implements Runnable
{
  public GateWayVerifyMobileHelper$4(atvk paramatvk, ConnectivityManager paramConnectivityManager, ConnectivityManager.NetworkCallback paramNetworkCallback) {}
  
  public void run()
  {
    this.jdField_a_of_type_Atvk.a(new Exception("change network to mobile timeout"));
    this.jdField_a_of_type_AndroidNetConnectivityManager.unregisterNetworkCallback(this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyMobileHelper.4
 * JD-Core Version:    0.7.0.1
 */