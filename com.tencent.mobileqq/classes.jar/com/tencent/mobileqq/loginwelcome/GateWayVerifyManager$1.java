package com.tencent.mobileqq.loginwelcome;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import com.tencent.qphone.base.util.QLog;

class GateWayVerifyManager$1
  extends ConnectivityManager.NetworkCallback
{
  GateWayVerifyManager$1(GateWayVerifyManager paramGateWayVerifyManager) {}
  
  public void onAvailable(Network paramNetwork)
  {
    QLog.d("GateWayVerifyManager", 1, "switch network success");
    if ((GateWayVerifyManager.a(this.a) == null) || (!GateWayVerifyManager.a(this.a).equals(paramNetwork)))
    {
      this.a.a(paramNetwork);
      if (GateWayVerifyManager.a(this.a) != null) {
        GateWayVerifyManager.a(this.a).a(paramNetwork);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.1
 * JD-Core Version:    0.7.0.1
 */