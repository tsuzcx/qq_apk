package com.tencent.mobileqq.highway.netprobe;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class LoginWifiProbe
  extends ProbeItem
{
  public static final String PROBE_NAME = "LoginWifi_Probe";
  public final int RESULT_ECHO_NORMAL = 0;
  public final int RESULT_NEED_LOGIN = 2;
  public final int RESULT_NO_WIFI = 1;
  public final int RESULT_UNSPECT_EXCEPTION = 3;
  private EchoTask echoTask;
  private String ssid = "XG";
  
  private String getWifiSSID()
  {
    WifiInfo localWifiInfo = ((WifiManager)WeakNetLearner.mContext.getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null) {
      return localWifiInfo.getSSID();
    }
    return null;
  }
  
  public void doProbe()
  {
    if (isWifiEnabled()) {
      this.ssid = getWifiSSID();
    }
    this.echoTask = new EchoTask(WeakNetLearner.mContext);
    int i = this.echoTask.doEcho();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        onFinish(3, this.echoTask.getErrorMsg());
        return;
      }
      onFinish(2, this.echoTask.getResponseUrl());
      return;
    }
    onFinish(0, null);
  }
  
  public String getProbeName()
  {
    return "LoginWifi_Probe";
  }
  
  public boolean isWifiEnabled()
  {
    try
    {
      boolean bool = ((ConnectivityManager)WeakNetLearner.mContext.getSystemService("connectivity")).getActiveNetworkInfo().getTypeName().toLowerCase().equals("wifi");
      if (bool) {
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void onFinish(int paramInt, Object paramObject)
  {
    this.mResult.errCode = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          this.mResult.success = false;
          localProbeResult = this.mResult;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("the echo test has some exception:");
          localStringBuilder.append((String)paramObject);
          localProbeResult.errDesc = localStringBuilder.toString();
          return;
        }
        this.mResult.success = false;
        ProbeItem.ProbeResult localProbeResult = this.mResult;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("the wifi(");
        localStringBuilder.append(this.ssid);
        localStringBuilder.append(") need to login , the login-url:");
        localStringBuilder.append(paramObject);
        localProbeResult.errDesc = localStringBuilder.toString();
        return;
      }
      this.mResult.success = true;
      this.mResult.appendResult("the network type is not wifi!");
      return;
    }
    this.mResult.success = true;
    this.mResult.appendResult("echo function is normal , wifi maybe is good !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.LoginWifiProbe
 * JD-Core Version:    0.7.0.1
 */