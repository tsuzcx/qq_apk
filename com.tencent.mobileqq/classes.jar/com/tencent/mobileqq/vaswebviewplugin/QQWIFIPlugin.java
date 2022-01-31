package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class QQWIFIPlugin
  extends VasWebviewJsPlugin
{
  private static final String CAMPUSWIFI_STATE_ACTION = "campus_wifi_state_changed";
  public static final int CAMPUSWIFI_STATE_CONNECTED = 1;
  public static final int CAMPUSWIFI_STATE_CONNECT_FAIL = 3;
  public static final int CAMPUSWIFI_STATE_CONNECT_SUC = 2;
  public static final int CAMPUSWIFI_STATE_DISCONNECT_FAIL = 5;
  public static final int CAMPUSWIFI_STATE_DISCONNECT_SUC = 4;
  public static final int CAMPUSWIFI_STATE_ISNTALL_BEGIN = 6;
  private static final String KEY_BSSID = "bssid";
  private static final String KEY_FROM = "webfrom";
  private static final String KEY_ISBACKGROUND = "isbackground";
  private static final String KEY_LOGINKEY = "loginkey";
  private static final String KEY_SID = "sid";
  private static final String KEY_SSID = "ssid";
  public static final String PLUGIN_NAMESPACE = "qqwifi";
  private static final String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";
  private static final String tag = "QQWIFIPlugin";
  private final byte[] callbacklock = new byte[0];
  private QQWIFIPlugin.CampusWifiStateReceiver campusWifiStateReceiver;
  private QQWIFIPlugin.WifiScanResultReceiver wifiScanResultReceiver;
  
  public QQWIFIPlugin()
  {
    this.mPluginNameSpace = "qqwifi";
  }
  
  public static int checkSpecifiedBssidLevel(String paramString, Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext != null)
    {
      paramContext = paramContext.getScanResults();
      if ((paramContext == null) || (paramContext.isEmpty())) {
        return 0;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ScanResult localScanResult = (ScanResult)paramContext.next();
        if (paramString.equals(localScanResult.BSSID))
        {
          int i = localScanResult.level;
          int j = WifiManager.calculateSignalLevel(i, 4);
          if (QLog.isColorLevel()) {
            QLog.i("QQWIFIPlugin", 2, "checkCurBssidLevel:bssid=" + paramString + " ssid=" + localScanResult.SSID + " rssi=" + i + " level=" + j);
          }
          return j;
        }
      }
    }
    return 0;
  }
  
  public static String getConnectedSsid(Context paramContext)
  {
    String str = "";
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null) {
          break label108;
        }
        paramContext = paramContext.getConnectionInfo();
        if ((paramContext == null) || (TextUtils.isEmpty(paramContext.getSSID()))) {
          break label108;
        }
        paramContext = paramContext.getSSID().replace("\"", "");
      }
      catch (Throwable localThrowable)
      {
        paramContext = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QQWIFIPlugin", 2, "getConnectedSsid", localThrowable);
        paramContext = str;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQWIFIPlugin", 2, "ConnectedSsid:" + paramContext);
      }
      return paramContext;
      label108:
      paramContext = "";
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String arg2, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWIFIPlugin", 2, "url=" + ???);
    }
    if ((TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith("qqwifi"))) {
      return false;
    }
    try
    {
      if (TextUtils.isEmpty(paramVarArgs[0])) {}
      paramString2 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString2.optString("callback");
      if ("start".equals(paramString3))
      {
        paramJsBridgeListener = paramString2.optString("webfrom");
        ??? = paramString2.optString("sid");
        paramString2 = new Intent("com.tencent.mobileqq.action.QQWiFi");
        paramString2.putExtra("webfrom", paramJsBridgeListener);
        paramString2.putExtra("sid", ???);
        paramString2.setClass(this.mRuntime.a(), JumpActivity.class);
        this.mRuntime.a().startActivity(paramString2);
      }
      else if ("getPhoneNumber".equals(paramString3))
      {
        ??? = (TelephonyManager)this.mRuntime.a().getSystemService("phone");
        paramString2 = new JSONObject();
        paramString2.put("result", 0);
        paramString2.put("phoneNumber", ???.getLine1Number());
        callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("QQWIFIPlugin", 2, "handleJsRequest", paramJsBridgeListener);
        break label896;
        if (paramString3.startsWith("campuswifi"))
        {
          ??? = paramString2.optString("ssid");
          if ("campuswifiquery".equals(paramString3))
          {
            paramString2 = getConnectedSsid(this.mRuntime.a().getApplication());
            if ((!TextUtils.isEmpty(paramString2)) && (paramString2.equals(???)))
            {
              ??? = new JSONObject();
              ???.put("hasCampusWifi", 0);
              callJs(paramJsBridgeListener, new String[] { ???.toString() });
              return true;
            }
            if (this.wifiScanResultReceiver == null) {
              this.wifiScanResultReceiver = new QQWIFIPlugin.WifiScanResultReceiver(this, null);
            }
            this.wifiScanResultReceiver.ssid = ???;
            synchronized (this.callbacklock)
            {
              this.wifiScanResultReceiver.callback = paramJsBridgeListener;
              paramJsBridgeListener = new IntentFilter();
              paramJsBridgeListener.addAction("android.net.wifi.SCAN_RESULTS");
              this.mRuntime.a().registerReceiver(this.wifiScanResultReceiver, paramJsBridgeListener);
              paramJsBridgeListener = (WifiManager)this.mRuntime.a().getSystemService("wifi");
              if (QLog.isColorLevel()) {
                QLog.i("QQWIFIPlugin", 2, "campus startscan at " + System.currentTimeMillis());
              }
              paramJsBridgeListener.startScan();
            }
          }
          if ("campuswificonnect".equals(paramString3))
          {
            paramString3 = paramString2.optString("bssid");
            paramVarArgs = paramString2.optString("loginkey");
            boolean bool = paramString2.optBoolean("isbackground");
            if (QLog.isColorLevel()) {
              QLog.i("QQWIFIPlugin", 2, "ssid=" + ??? + " loginkey=" + paramVarArgs + " isBackgroud=" + bool);
            }
            if ((TextUtils.isEmpty(???)) || (TextUtils.isEmpty(paramVarArgs)))
            {
              QQToast.a(this.mRuntime.a(), "参数错误", 0).a();
            }
            else
            {
              if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                this.campusWifiStateReceiver.callback = paramJsBridgeListener;
              }
              paramJsBridgeListener = new Intent("com.tencent.mobileqq.msf.qqwifi.campus");
              paramJsBridgeListener.putExtra("ssid", ???);
              paramJsBridgeListener.putExtra("bssid", paramString3);
              paramJsBridgeListener.putExtra("loginkey", paramVarArgs);
              paramJsBridgeListener.putExtra("isbackground", bool);
              paramJsBridgeListener.putExtra("campus", true);
              paramJsBridgeListener.putExtra("event", "connect");
              paramJsBridgeListener.setClass(this.mRuntime.a(), JumpActivity.class);
              this.mRuntime.a().startActivity(paramJsBridgeListener);
            }
          }
          else if ("campuswifidisconnect".equals(paramString3))
          {
            paramString2 = getConnectedSsid(this.mRuntime.a().getApplication());
            if (QLog.isColorLevel()) {
              QLog.i("QQWIFIPlugin", 2, "ssid:" + ??? + " curssid:" + paramString2);
            }
            if (!TextUtils.isEmpty(paramJsBridgeListener)) {
              this.campusWifiStateReceiver.callback = paramJsBridgeListener;
            }
            if ((!TextUtils.isEmpty(paramString2)) && (paramString2.equals(???)))
            {
              paramJsBridgeListener = new Intent("com.tencent.mobileqq.msf.qqwifi.campus");
              paramJsBridgeListener.putExtra("ssid", ???);
              paramJsBridgeListener.putExtra("campus", true);
              paramJsBridgeListener.putExtra("event", "disconnect");
              paramJsBridgeListener.setClass(this.mRuntime.a(), JumpActivity.class);
              this.mRuntime.a().startActivity(paramJsBridgeListener);
            }
            else
            {
              QQToast.a(this.mRuntime.a(), "当前没有连接此WiFi", 1).a();
            }
          }
        }
      }
    }
    label896:
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.i("QQWIFIPlugin", 2, "onCreate");
    }
    if (this.campusWifiStateReceiver == null) {
      this.campusWifiStateReceiver = new QQWIFIPlugin.CampusWifiStateReceiver(this, null);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("campus_wifi_state_changed");
    this.mRuntime.a().registerReceiver(this.campusWifiStateReceiver, localIntentFilter);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("QQWIFIPlugin", 2, "onDestroy");
    }
    try
    {
      if (this.wifiScanResultReceiver != null) {
        this.mRuntime.a().unregisterReceiver(this.wifiScanResultReceiver);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (this.campusWifiStateReceiver != null) {
            this.mRuntime.a().unregisterReceiver(this.campusWifiStateReceiver);
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.i("QQWIFIPlugin", 2, "wifiScanResultReceiver unregiste fail");
          }
        }
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("QQWIFIPlugin", 2, "campusWifiStateReceiver unregiste fail");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQWIFIPlugin
 * JD-Core Version:    0.7.0.1
 */