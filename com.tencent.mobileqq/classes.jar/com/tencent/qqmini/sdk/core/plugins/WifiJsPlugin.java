package com.tencent.qqmini.sdk.core.plugins;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bglu;
import bglv;
import bgnk;
import bgok;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WifiJsPlugin
  extends BaseJsPlugin
{
  private static final String API_ON_GET_WIFI_LIST = "onGetWifiList";
  private static final String API_ON_WIFI_CONNECTED = "onWifiConnected";
  public static final int MODE_EAP = 3;
  public static final int MODE_NONE = 0;
  public static final int MODE_PSK = 2;
  public static final int MODE_WEP = 1;
  private boolean hasRegister;
  private Activity mActivity;
  private WifiManager wifiManager;
  private BroadcastReceiver wifiReceiver = new WifiJsPlugin.1(this);
  
  private int calculateSignalStrength(int paramInt)
  {
    if (paramInt <= -100) {
      return 0;
    }
    if (paramInt >= -50) {
      return 100;
    }
    return (paramInt + 100) * 2;
  }
  
  private JSONObject getWifiInfo(WifiInfo paramWifiInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    label162:
    label167:
    for (;;)
    {
      try
      {
        String str = paramWifiInfo.getSSID();
        if (str == null) {
          break label167;
        }
        str = str.replace("\"", "");
        Iterator localIterator = this.wifiManager.getScanResults().iterator();
        if (!localIterator.hasNext()) {
          break label162;
        }
        ScanResult localScanResult = (ScanResult)localIterator.next();
        if (!localScanResult.SSID.equals(str)) {
          continue;
        }
        bool = isSecurity(localScanResult);
        localJSONObject.put("SSID", str);
        localJSONObject.put("BSSID", paramWifiInfo.getBSSID());
        localJSONObject.put("secure", bool);
        localJSONObject.put("signalStrength", calculateSignalStrength(paramWifiInfo.getRssi()));
      }
      catch (Exception paramWifiInfo)
      {
        try
        {
          paramWifiInfo.put("wifi", localJSONObject);
          return paramWifiInfo;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          return paramWifiInfo;
        }
        paramWifiInfo = paramWifiInfo;
        paramWifiInfo.printStackTrace();
        continue;
      }
      paramWifiInfo = new JSONObject();
      boolean bool = false;
    }
  }
  
  private JSONArray getWifiList()
  {
    localJSONArray = new JSONArray();
    Object localObject = this.wifiManager.getScanResults();
    try
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ScanResult localScanResult = (ScanResult)((Iterator)localObject).next();
        String str1 = localScanResult.SSID;
        String str2 = localScanResult.BSSID;
        boolean bool = isSecurity(localScanResult);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("SSID", str1);
        localJSONObject.put("BSSID", str2);
        localJSONObject.put("secure", bool);
        localJSONObject.put("signalStrength", calculateSignalStrength(localScanResult.level));
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void handlerWifiState(Intent paramIntent)
  {
    NetworkInfo localNetworkInfo = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
    {
      paramIntent = (WifiInfo)paramIntent.getParcelableExtra("wifiInfo");
      if (paramIntent != null) {
        sendSubscribeEvent("onWifiConnected", getWifiInfo(paramIntent).toString());
      }
    }
  }
  
  private WifiConfiguration isExsits(String paramString)
  {
    Object localObject = this.wifiManager.getConfiguredNetworks();
    if ((localObject == null) || (paramString == null)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
      if ((localWifiConfiguration != null) && (localWifiConfiguration.SSID != null) && (localWifiConfiguration.SSID.equals("\"" + paramString + "\""))) {
        return localWifiConfiguration;
      }
    }
    return null;
  }
  
  private void registerWifiReceiver()
  {
    if ((!this.hasRegister) && (this.wifiReceiver != null))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      this.mContext.registerReceiver(this.wifiReceiver, localIntentFilter);
      this.hasRegister = true;
    }
  }
  
  private void unregisterWifiReceiver()
  {
    if ((this.hasRegister) && (this.wifiReceiver != null))
    {
      this.mContext.unregisterReceiver(this.wifiReceiver);
      this.hasRegister = false;
    }
  }
  
  @TargetApi(23)
  public void checkPermission(WifiJsPlugin.LocationPermissionListener paramLocationPermissionListener)
  {
    if (this.mActivity == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.mMiniAppContext.a();
    } while ((localActivity == null) || (paramLocationPermissionListener == null));
    bgnk.a().a(new WifiJsPlugin.3(this, paramLocationPermissionListener));
    localActivity.requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 9528);
  }
  
  public String connectWifi(bgok parambgok)
  {
    if (this.wifiManager != null) {
      if (!this.wifiManager.isWifiEnabled()) {}
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(parambgok.b);
        if (localObject1 != null)
        {
          String str = ((JSONObject)localObject1).optString("SSID");
          ((JSONObject)localObject1).optString("BSSID");
          localObject1 = ((JSONObject)localObject1).optString("password");
          Iterator localIterator = this.wifiManager.getScanResults().iterator();
          if (!localIterator.hasNext()) {
            break label211;
          }
          ScanResult localScanResult = (ScanResult)localIterator.next();
          if (!localScanResult.SSID.equals(str)) {
            continue;
          }
          i = getSecurityMode(localScanResult);
          localObject1 = createWifiInfo(str, (String)localObject1, i);
          if (localObject1 != null)
          {
            i = this.wifiManager.addNetwork((WifiConfiguration)localObject1);
            if (i != -1) {
              this.wifiManager.enableNetwork(i, true);
            }
            parambgok.a();
            return "";
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        Object localObject2 = null;
        continue;
        parambgok.a(":invalid network id");
        continue;
        parambgok.a(":invalid data");
        continue;
      }
      parambgok.a(":wifi is disable");
      continue;
      parambgok.a(":not invoke startWifi");
      continue;
      label211:
      int i = 0;
    }
  }
  
  protected WifiConfiguration createWifiInfo(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    while ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      return null;
    }
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.allowedAuthAlgorithms.clear();
    localWifiConfiguration.allowedGroupCiphers.clear();
    localWifiConfiguration.allowedKeyManagement.clear();
    localWifiConfiguration.allowedPairwiseCiphers.clear();
    localWifiConfiguration.allowedProtocols.clear();
    localWifiConfiguration.SSID = ("\"" + paramString1 + "\"");
    paramString1 = isExsits(paramString1);
    if (paramString1 != null) {
      this.wifiManager.removeNetwork(paramString1.networkId);
    }
    if (paramInt == 0)
    {
      String[] arrayOfString = localWifiConfiguration.wepKeys;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = "";
        arrayOfString[0] = paramString1;
        localWifiConfiguration.allowedKeyManagement.set(0);
        localWifiConfiguration.wepTxKeyIndex = 0;
      }
    }
    for (;;)
    {
      return localWifiConfiguration;
      paramString1 = "\"" + paramString2 + "\"";
      break;
      if (paramInt == 1)
      {
        localWifiConfiguration.hiddenSSID = true;
        localWifiConfiguration.wepKeys[0] = ("\"" + paramString2 + "\"");
        localWifiConfiguration.allowedAuthAlgorithms.set(1);
        localWifiConfiguration.allowedGroupCiphers.set(3);
        localWifiConfiguration.allowedGroupCiphers.set(2);
        localWifiConfiguration.allowedGroupCiphers.set(0);
        localWifiConfiguration.allowedGroupCiphers.set(1);
        localWifiConfiguration.allowedKeyManagement.set(0);
        localWifiConfiguration.wepTxKeyIndex = 0;
      }
      else if (paramInt == 2)
      {
        localWifiConfiguration.preSharedKey = ("\"" + paramString2 + "\"");
        localWifiConfiguration.hiddenSSID = true;
        localWifiConfiguration.allowedAuthAlgorithms.set(0);
        localWifiConfiguration.allowedGroupCiphers.set(2);
        localWifiConfiguration.allowedKeyManagement.set(1);
        localWifiConfiguration.allowedPairwiseCiphers.set(1);
        localWifiConfiguration.allowedGroupCiphers.set(3);
        localWifiConfiguration.allowedPairwiseCiphers.set(2);
        localWifiConfiguration.status = 2;
      }
    }
  }
  
  public String getConnectedWifi(bgok parambgok)
  {
    JSONObject localJSONObject;
    if (this.wifiManager != null) {
      if (this.wifiManager.isWifiEnabled()) {
        localJSONObject = getWifiInfo(this.wifiManager.getConnectionInfo());
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("errCode", 0);
        parambgok.a(localJSONObject);
        return "";
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", 12005);
        parambgok.a(localJSONObject, ":wifi is disable");
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", 12000);
        parambgok.a(localJSONObject, ":not invoke startWifi");
      }
      catch (JSONException localJSONException3)
      {
        for (;;)
        {
          localJSONException3.printStackTrace();
        }
      }
    }
  }
  
  public int getSecurityMode(ScanResult paramScanResult)
  {
    paramScanResult = paramScanResult.capabilities;
    if (paramScanResult.contains("WEP")) {
      return 1;
    }
    if (paramScanResult.contains("PSK")) {
      return 2;
    }
    if (paramScanResult.contains("EAP")) {
      return 3;
    }
    return 0;
  }
  
  public String getWifiList(bgok parambgok)
  {
    JSONArray localJSONArray;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    if (this.wifiManager != null) {
      if (this.wifiManager.isWifiEnabled())
      {
        localJSONArray = getWifiList();
        localJSONObject1 = new JSONObject();
        localJSONObject2 = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject1.put("wifiList", localJSONArray);
        localJSONObject2.put("errCode", 0);
        parambgok.a(localJSONObject2);
        parambgok.a.a("onGetWifiList", localJSONObject1.toString(), 0);
        return "";
      }
      catch (JSONException localJSONException3)
      {
        localJSONException3.printStackTrace();
        continue;
      }
      localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("errCode", 12005);
        parambgok.a(localJSONObject1, ":wifi is disable");
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
      localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("errCode", 12000);
        parambgok.a(localJSONObject1, ":not invoke startWifi");
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  public boolean isSecurity(ScanResult paramScanResult)
  {
    return getSecurityMode(paramScanResult) > 1;
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    this.mActivity = parambglv.a();
  }
  
  public void onDestroy()
  {
    unregisterWifiReceiver();
    this.wifiReceiver = null;
  }
  
  public String startWifi(bgok parambgok)
  {
    JSONObject localJSONObject;
    if (Build.VERSION.SDK_INT >= 23) {
      if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
      {
        this.wifiManager = ((WifiManager)this.mContext.getApplicationContext().getSystemService("wifi"));
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("errCode", 0);
        parambgok.a(localJSONObject);
        registerWifiReceiver();
        return "";
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      checkPermission(new WifiJsPlugin.2(this, parambgok));
      continue;
      this.wifiManager = ((WifiManager)this.mContext.getApplicationContext().getSystemService("wifi"));
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", 0);
        parambgok.a(localJSONObject);
        registerWifiReceiver();
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  public String stopWifi(bgok parambgok)
  {
    JSONObject localJSONObject1;
    if (this.wifiManager != null)
    {
      this.wifiManager = null;
      localJSONObject1 = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject1.put("errCode", 0);
        parambgok.a();
        unregisterWifiReceiver();
        return "";
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("errCode", 12000);
        parambgok.a(":not invoke startWifi");
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.WifiJsPlugin
 * JD-Core Version:    0.7.0.1
 */