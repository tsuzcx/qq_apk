package com.tencent.mobileqq.microapp.out.plugins;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.microapp.R.string;
import com.tencent.mobileqq.microapp.app.a.a;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.microapp.sdk.OutBaseJsPlugin;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OtherJsPlugin
  extends OutBaseJsPlugin
{
  public static final String MA_PERMISSION_BROADCAST = "com.tencent.msg.permission.pushnotify";
  public static final String MICRO_APP_SCAN_DATA_RESULT = "com.tencent.mobileqq.microapp.out.plugins.scanResultData";
  public static final String MICRO_APP_SCAN_RESULT = "com.tencent.mobileqq.microapp.out.plugins.scanResultAction";
  public static final String MICRO_APP_SCAN_RESULT_TYPE = "com.tencent.mobileqq.microapp.out.plugins.scanResultType";
  public static final String TAG = "OtherJsPlugin";
  Set eventMap = new HashSet();
  private int mSeq;
  private BroadcastReceiver scanResultReceiver = null;
  
  public OtherJsPlugin(MiniAppInterface paramMiniAppInterface)
  {
    super(paramMiniAppInterface);
    this.eventMap.add("openSetting");
    this.eventMap.add("getSetting");
    this.eventMap.add("scanCode");
  }
  
  private void callbackSettingEvent(String paramString1, String paramString2, int paramInt)
  {
    String str = "";
    Object localObject1 = this.appInterface.getAuthorizeCenter(paramString2);
    if (localObject1 == null) {
      return;
    }
    Object localObject3 = ((com.tencent.mobileqq.microapp.app.a)localObject1).a(6);
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        localObject3 = ((List)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          a.a locala = (a.a)((Iterator)localObject3).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("scope", locala.a);
          if (locala.b != 2) {
            break label241;
          }
          i = 1;
          localJSONObject.put("state", i);
          localJSONArray.put(localJSONObject);
          continue;
        }
        ((JSONObject)localObject1).put("authSetting", localJSONArray);
        localObject1 = com.tencent.mobileqq.microapp.a.c.a(paramString1, (JSONObject)localObject1);
        if (localObject1 == null) {
          break label247;
        }
        localObject1 = ((JSONObject)localObject1).toString();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          handleNativeResponse(paramString1, (String)localObject1, paramInt);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        if (com.tencent.mobileqq.microapp.appbrand.b.c.b(paramString2)) {
          com.tencent.mobileqq.microapp.appbrand.b.c.a("OtherJsPlugin", 2, paramString2, localJSONException, new Object[0]);
        }
        localObject2 = com.tencent.mobileqq.microapp.a.c.b(paramString1, null);
        paramString2 = str;
        if (localObject2 != null) {
          paramString2 = ((JSONObject)localObject2).toString();
        }
        if (paramString2 != null) {
          handleNativeResponse(paramString1, paramString2, paramInt);
        }
      }
      return;
      label241:
      int i = 0;
      continue;
      label247:
      Object localObject2 = "";
    }
  }
  
  private void openSettingActivity(Activity paramActivity, String paramString) {}
  
  public void enterQRCode(BaseActivity paramBaseActivity)
  {
    if (!RecentOptPopBar.canEnterQRCode(paramBaseActivity)) {
      return;
    }
    Intent localIntent = new Intent(paramBaseActivity, ScannerActivity.class);
    localIntent.putExtra("leftViewText", paramBaseActivity.getString(R.string.a));
    localIntent.putExtra("selfSet_leftViewText", paramBaseActivity.getString(R.string.a));
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("from", "micro_app");
    paramBaseActivity.startActivity(localIntent);
    Object localObject = this.scanResultReceiver;
    if (localObject != null) {}
    try
    {
      paramBaseActivity.unregisterReceiver((BroadcastReceiver)localObject);
      label85:
      this.scanResultReceiver = null;
      this.scanResultReceiver = new a(this);
      localObject = new IntentFilter("com.tencent.mobileqq.microapp.out.plugins.scanResultAction");
      paramBaseActivity.registerReceiver(this.scanResultReceiver, (IntentFilter)localObject, "com.tencent.msg.permission.pushnotify", null);
      paramBaseActivity.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label85;
    }
  }
  
  public Set getEventMap()
  {
    return this.eventMap;
  }
  
  public String handleNativeRequest(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ("openSetting".equals(paramString2))
    {
      MiniAppController.getInstance().setActivityResultListener(new b(this, paramString1, paramString2, paramInt));
      openSettingActivity(paramActivity, paramString1);
    }
    else if ("getSetting".equals(paramString2))
    {
      com.tencent.mobileqq.microapp.appbrand.b.a.a(new c(this, paramString2, paramString1, paramInt));
    }
    else if ("scanCode".equals(paramString2))
    {
      this.mSeq = paramInt;
      enterQRCode((BaseActivity)paramActivity);
    }
    return super.handleNativeRequest(paramActivity, paramString1, paramString2, paramString3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.plugins.OtherJsPlugin
 * JD-Core Version:    0.7.0.1
 */