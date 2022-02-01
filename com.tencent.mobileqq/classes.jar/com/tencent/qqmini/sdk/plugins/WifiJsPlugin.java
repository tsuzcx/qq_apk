package com.tencent.qqmini.sdk.plugins;

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
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class WifiJsPlugin
  extends BaseJsPlugin
{
  private static final String API_ON_GET_WIFI_LIST = "onGetWifiList";
  private static final String API_ON_WIFI_CONNECTED = "onWifiConnected";
  public static final int MODE_EAP = 3;
  public static final int MODE_NONE = 0;
  public static final int MODE_PSK = 2;
  public static final int MODE_WEP = 1;
  private boolean hasRegister = false;
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
    try
    {
      Object localObject2 = paramWifiInfo.getSSID();
      Object localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).replace("\"", "");
      }
      localObject2 = this.wifiManager.getScanResults();
      boolean bool2 = false;
      localObject2 = ((List)localObject2).iterator();
      ScanResult localScanResult;
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localScanResult = (ScanResult)((Iterator)localObject2).next();
      } while (!localScanResult.SSID.equals(localObject1));
      boolean bool1 = isSecurity(localScanResult);
      localJSONObject.put("SSID", localObject1);
      localJSONObject.put("BSSID", paramWifiInfo.getBSSID());
      localJSONObject.put("secure", bool1);
      localJSONObject.put("signalStrength", calculateSignalStrength(paramWifiInfo.getRssi()));
    }
    catch (Exception paramWifiInfo)
    {
      paramWifiInfo.printStackTrace();
    }
    paramWifiInfo = new JSONObject();
    try
    {
      paramWifiInfo.put("wifi", localJSONObject);
      return paramWifiInfo;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramWifiInfo;
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
    if (localObject != null)
    {
      if (paramString == null) {
        return null;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
        if ((localWifiConfiguration != null) && (localWifiConfiguration.SSID != null))
        {
          String str = localWifiConfiguration.SSID;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("\"");
          localStringBuilder.append(paramString);
          localStringBuilder.append("\"");
          if (str.equals(localStringBuilder.toString())) {
            return localWifiConfiguration;
          }
        }
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
    if (this.mActivity == null) {
      return;
    }
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    if ((localActivity != null) && (paramLocationPermissionListener != null))
    {
      ActivityResultManager.g().addRequestPermissionResultListener(new WifiJsPlugin.3(this, paramLocationPermissionListener));
      localActivity.requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 9528);
    }
  }
  
  @JsEvent({"connectWifi"})
  public String connectWifi(RequestEvent paramRequestEvent)
  {
    Object localObject1 = this.wifiManager;
    if (localObject1 != null)
    {
      if (((WifiManager)localObject1).isWifiEnabled())
      {
        localObject1 = null;
        try
        {
          JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
          localObject1 = localJSONObject;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        if (localObject1 != null)
        {
          String str = ((JSONObject)localObject1).optString("SSID");
          ((JSONObject)localObject1).optString("BSSID");
          localObject1 = ((JSONObject)localObject1).optString("password");
          Object localObject2 = this.wifiManager.getScanResults();
          int j = 0;
          localObject2 = ((List)localObject2).iterator();
          ScanResult localScanResult;
          do
          {
            i = j;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localScanResult = (ScanResult)((Iterator)localObject2).next();
          } while (!localScanResult.SSID.equals(str));
          int i = getSecurityMode(localScanResult);
          localObject1 = createWifiInfo(str, (String)localObject1, i);
          if (localObject1 != null)
          {
            i = this.wifiManager.addNetwork((WifiConfiguration)localObject1);
            if (i != -1) {
              this.wifiManager.enableNetwork(i, true);
            }
            paramRequestEvent.ok();
          }
          else
          {
            paramRequestEvent.fail(":invalid network id");
          }
        }
        else
        {
          paramRequestEvent.fail(":invalid data");
        }
      }
      else
      {
        paramRequestEvent.fail(":wifi is disable");
      }
    }
    else {
      paramRequestEvent.fail(":not invoke startWifi");
    }
    return "";
  }
  
  protected WifiConfiguration createWifiInfo(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      return null;
    }
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.allowedAuthAlgorithms.clear();
    localWifiConfiguration.allowedGroupCiphers.clear();
    localWifiConfiguration.allowedKeyManagement.clear();
    localWifiConfiguration.allowedPairwiseCiphers.clear();
    localWifiConfiguration.allowedProtocols.clear();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("\"");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("\"");
    localWifiConfiguration.SSID = ((StringBuilder)localObject).toString();
    paramString1 = isExsits(paramString1);
    if (paramString1 != null) {
      this.wifiManager.removeNetwork(paramString1.networkId);
    }
    if (paramInt == 0)
    {
      localObject = localWifiConfiguration.wepKeys;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = "";
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("\"");
        paramString1.append(paramString2);
        paramString1.append("\"");
        paramString1 = paramString1.toString();
      }
      localObject[0] = paramString1;
      localWifiConfiguration.allowedKeyManagement.set(0);
      localWifiConfiguration.wepTxKeyIndex = 0;
      return localWifiConfiguration;
    }
    if (paramInt == 1)
    {
      localWifiConfiguration.hiddenSSID = true;
      paramString1 = localWifiConfiguration.wepKeys;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("\"");
      paramString1[0] = ((StringBuilder)localObject).toString();
      localWifiConfiguration.allowedAuthAlgorithms.set(1);
      localWifiConfiguration.allowedGroupCiphers.set(3);
      localWifiConfiguration.allowedGroupCiphers.set(2);
      localWifiConfiguration.allowedGroupCiphers.set(0);
      localWifiConfiguration.allowedGroupCiphers.set(1);
      localWifiConfiguration.allowedKeyManagement.set(0);
      localWifiConfiguration.wepTxKeyIndex = 0;
      return localWifiConfiguration;
    }
    if (paramInt == 2)
    {
      paramString1 = new StringBuilder();
      paramString1.append("\"");
      paramString1.append(paramString2);
      paramString1.append("\"");
      localWifiConfiguration.preSharedKey = paramString1.toString();
      localWifiConfiguration.hiddenSSID = true;
      localWifiConfiguration.allowedAuthAlgorithms.set(0);
      localWifiConfiguration.allowedGroupCiphers.set(2);
      localWifiConfiguration.allowedKeyManagement.set(1);
      localWifiConfiguration.allowedPairwiseCiphers.set(1);
      localWifiConfiguration.allowedGroupCiphers.set(3);
      localWifiConfiguration.allowedPairwiseCiphers.set(2);
      localWifiConfiguration.status = 2;
    }
    return localWifiConfiguration;
  }
  
  @JsEvent({"getConnectedWifi"})
  public String getConnectedWifi(RequestEvent paramRequestEvent)
  {
    Object localObject = this.wifiManager;
    if (localObject != null)
    {
      if (((WifiManager)localObject).isWifiEnabled())
      {
        localObject = getWifiInfo(this.wifiManager.getConnectionInfo());
        try
        {
          ((JSONObject)localObject).put("errCode", 0);
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        paramRequestEvent.ok((JSONObject)localObject);
      }
      else
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("errCode", 12005);
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        paramRequestEvent.fail((JSONObject)localObject, ":wifi is disable");
      }
    }
    else
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("errCode", 12000);
      }
      catch (JSONException localJSONException3)
      {
        localJSONException3.printStackTrace();
      }
      paramRequestEvent.fail((JSONObject)localObject, ":not invoke startWifi");
    }
    return "";
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
  
  @JsEvent({"getWifiList"})
  public String getWifiList(RequestEvent paramRequestEvent)
  {
    Object localObject = this.wifiManager;
    if (localObject != null)
    {
      if (((WifiManager)localObject).isWifiEnabled())
      {
        JSONArray localJSONArray = getWifiList();
        localObject = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("wifiList", localJSONArray);
          localJSONObject.put("errCode", 0);
        }
        catch (JSONException localJSONException3)
        {
          localJSONException3.printStackTrace();
        }
        paramRequestEvent.ok(localJSONObject);
        paramRequestEvent.jsService.evaluateSubscribeJS("onGetWifiList", ((JSONObject)localObject).toString(), 0);
      }
      else
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("errCode", 12005);
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        paramRequestEvent.fail((JSONObject)localObject, ":wifi is disable");
      }
    }
    else
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("errCode", 12000);
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      paramRequestEvent.fail((JSONObject)localObject, ":not invoke startWifi");
    }
    return "";
  }
  
  public boolean isSecurity(ScanResult paramScanResult)
  {
    return getSecurityMode(paramScanResult) > 1;
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.mActivity = paramIMiniAppContext.getAttachedActivity();
  }
  
  public void onDestroy()
  {
    unregisterWifiReceiver();
    this.wifiReceiver = null;
  }
  
  @JsEvent({"startWifi"})
  public String startWifi(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
      {
        this.wifiManager = ((WifiManager)this.mContext.getApplicationContext().getSystemService("wifi"));
        localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("errCode", 0);
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        paramRequestEvent.ok(localJSONObject);
        registerWifiReceiver();
      }
      else
      {
        checkPermission(new WifiJsPlugin.2(this, paramRequestEvent));
      }
    }
    else
    {
      this.wifiManager = ((WifiManager)this.mContext.getApplicationContext().getSystemService("wifi"));
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", 0);
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      paramRequestEvent.ok(localJSONObject);
      registerWifiReceiver();
    }
    return "";
  }
  
  @JsEvent({"stopWifi"})
  public String stopWifi(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject;
    if (this.wifiManager != null)
    {
      this.wifiManager = null;
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", 0);
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      paramRequestEvent.ok(localJSONObject);
      unregisterWifiReceiver();
    }
    else
    {
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", 12000);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      paramRequestEvent.fail(":not invoke startWifi");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.WifiJsPlugin
 * JD-Core Version:    0.7.0.1
 */