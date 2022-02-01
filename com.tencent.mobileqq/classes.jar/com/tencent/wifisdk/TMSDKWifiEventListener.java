package com.tencent.wifisdk;

public abstract interface TMSDKWifiEventListener
{
  public static final int CONN_ERR_CONFIG_ERROR = -4;
  public static final int CONN_ERR_DISCONNECTED = -9;
  public static final int CONN_ERR_INTERRUPT_BY_NEW_CONNECTION = -8;
  public static final int CONN_ERR_NEED_AUTH_BY_WIFIMGR = -1;
  public static final int CONN_ERR_NONE = 0;
  public static final int CONN_ERR_PASSWORD_ERROR = -5;
  public static final int CONN_ERR_ROUTER_ABNORMAL = -6;
  public static final int CONN_ERR_ROUTER_OVERLOAD = -7;
  public static final int CONN_ERR_TIME_OUT = -2;
  public static final int CONN_ERR_UNKNOWN_ERROR = -999;
  public static final int CONN_ERR_USER_CANCEL = -10;
  public static final int CONN_ERR_WIFI_DISABLED = -3;
  public static final int WIFI_DETAIL_STATE_AUTHENTICATING = 1;
  public static final int WIFI_DETAIL_STATE_CONNECTING = 0;
  public static final int WIFI_DETAIL_STATE_OBTAINING_IP = 2;
  
  public abstract void onConnectionCancel();
  
  public abstract void onConnectionFailed(int paramInt);
  
  public abstract void onConnectionStart(TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo);
  
  public abstract void onConnectionStateChanged(int paramInt, TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo);
  
  public abstract void onConnectionSuccess(TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo);
  
  public abstract void onGPSDisabled();
  
  public abstract void onGPSEnabled();
  
  public abstract void onWifiDisabled();
  
  public abstract void onWifiEnabled();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.wifisdk.TMSDKWifiEventListener
 * JD-Core Version:    0.7.0.1
 */