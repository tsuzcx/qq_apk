package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.AuthStateItem;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.auth.SubscribeMessage;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class SettingsJsPlugin
  extends BaseJsPlugin
{
  private static final String ACTION_RETURN_ADDRESS_TO_MINIAPP = "action_return_address_to_miniapp";
  private static final String KEY_MINIAPP_ADDRESS_INFO = "key_miniapp_address_info";
  private static final String TAG = "SettingsJsPlugin";
  private BroadcastReceiver addressReceiver = new SettingsJsPlugin.1(this);
  private RequestEvent addressReq = null;
  private ChannelProxy mProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  private boolean receiverRegistered = false;
  
  private void callbackChooseAddress(String paramString, RequestEvent paramRequestEvent)
  {
    try
    {
      paramRequestEvent.ok(new JSONObject(paramString));
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e("SettingsJsPlugin", "callbackChooseAddress get an error.", paramString);
      paramRequestEvent.fail();
    }
  }
  
  private void callbackSettingEvent(AuthState paramAuthState, RequestEvent paramRequestEvent, boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramAuthState == null)
    {
      paramRequestEvent.fail();
      return;
    }
    Object localObject2 = paramAuthState.getAuthStateList(6);
    for (;;)
    {
      try
      {
        paramAuthState = new JSONObject();
        Object localObject1 = new JSONArray();
        localObject2 = ((List)localObject2).iterator();
        Object localObject3;
        Object localObject4;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (AuthStateItem)((Iterator)localObject2).next();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("scope", ((AuthStateItem)localObject3).scopeName);
          if (((AuthStateItem)localObject3).authFlag == 2)
          {
            i = 1;
            ((JSONObject)localObject4).put("state", i);
            ((JSONArray)localObject1).put(localObject4);
          }
        }
        else
        {
          paramAuthState.put("authSetting", localObject1);
          if (paramBoolean)
          {
            localObject1 = new JSONObject();
            localObject2 = new JSONObject();
            if ((paramMap != null) && (paramMap.size() > 0))
            {
              localObject3 = paramMap.keySet().iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (String)((Iterator)localObject3).next();
                ((JSONObject)localObject2).put((String)localObject4, paramMap.get(localObject4));
                continue;
              }
            }
            ((JSONObject)localObject1).put("itemSettings", localObject2);
            paramAuthState.put("subscriptionsSetting", localObject1);
          }
          paramRequestEvent.ok(paramAuthState);
          return;
        }
      }
      catch (JSONException paramAuthState)
      {
        paramMap = new StringBuilder();
        paramMap.append(paramRequestEvent.event);
        paramMap.append(" error.");
        QMLog.e("SettingsJsPlugin", paramMap.toString(), paramAuthState);
        paramRequestEvent.fail();
        return;
      }
      int i = 0;
    }
  }
  
  private void callbackSettingEvent(RequestEvent paramRequestEvent)
  {
    AuthState localAuthState = MiniAppEnv.g().getAuthSate(this.mApkgInfo.appId);
    boolean bool;
    if (!TextUtils.isEmpty(paramRequestEvent.jsonParams)) {
      try
      {
        bool = new JSONObject(paramRequestEvent.jsonParams).optBoolean("withSubscriptions");
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("SettingsJsPlugin", "openSetting parse jsonParams exception", localJSONException);
      }
    } else {
      bool = false;
    }
    if (bool)
    {
      requestAuthList(bool, paramRequestEvent, this.mApkgInfo.appId, localAuthState);
      return;
    }
    callbackSettingEvent(localAuthState, paramRequestEvent, bool, null);
  }
  
  private Map<String, String> getInteractiveSubscribeList(List<SubscribeMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SubscribeMessage localSubscribeMessage = (SubscribeMessage)paramList.next();
        if (localSubscribeMessage.authState != 0)
        {
          String str = localSubscribeMessage.templateId;
          if (localSubscribeMessage.authState == 1) {
            localHashMap.put(str, "accept");
          } else if (localSubscribeMessage.authState == 2) {
            localHashMap.put(str, "reject");
          } else if (localSubscribeMessage.authState == 3) {
            localHashMap.put(str, "ban");
          }
        }
      }
      return localHashMap;
    }
    return null;
  }
  
  private void launchChooseAddressH5(String paramString)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("webStyle", "noBottomBar");
    localMiniAppProxy.startBrowserActivity(this.mMiniAppContext.getAttachedActivity(), localIntent);
  }
  
  @JsEvent({"openAddress"})
  private void openAddress(RequestEvent paramRequestEvent)
  {
    String str = WnsConfig.getConfig("qqminiapp", "miniappChooseAddressUrl", "https://i.qianbao.qq.com/profile/address/choose.html");
    this.addressReq = paramRequestEvent;
    registerChooseAddressReceiver();
    launchChooseAddressH5(str);
  }
  
  private void openSettingActivity(Activity paramActivity, ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null)
    {
      paramActivity = new StringBuilder();
      paramActivity.append("openSettingActivity, appInfo:");
      paramActivity.append(paramApkgInfo);
      QMLog.e("SettingsJsPlugin", paramActivity.toString());
      return;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openPermissionSettingsActivity(paramActivity, paramApkgInfo.appId, paramApkgInfo.apkgName);
  }
  
  private void registerChooseAddressReceiver()
  {
    if (this.receiverRegistered) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_return_address_to_miniapp");
    this.mMiniAppContext.getAttachedActivity().registerReceiver(this.addressReceiver, localIntentFilter);
    this.receiverRegistered = true;
  }
  
  private void requestAuthList(boolean paramBoolean, RequestEvent paramRequestEvent, String paramString, AuthState paramAuthState)
  {
    this.mProxy.getAuthList(paramString, new SettingsJsPlugin.3(this, paramAuthState, paramBoolean, paramRequestEvent));
  }
  
  private void unregisterChooseAddressReceiver()
  {
    if (this.receiverRegistered)
    {
      if (this.addressReceiver == null) {
        return;
      }
      this.mMiniAppContext.getAttachedActivity().unregisterReceiver(this.addressReceiver);
      this.receiverRegistered = false;
    }
  }
  
  @JsEvent(isSync=false, value={"getSetting"})
  public void getSetting(RequestEvent paramRequestEvent)
  {
    String str = this.mApkgInfo.appId;
    AuthState localAuthState = MiniAppEnv.g().getAuthSate(str);
    if (localAuthState == null)
    {
      QMLog.e("SettingsJsPlugin", "getSetting, but authorizeCenter is null?!");
      return;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramRequestEvent.jsonParams)) {
      try
      {
        bool1 = new JSONObject(paramRequestEvent.jsonParams).optBoolean("withSubscriptions");
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("SettingsJsPlugin", "getSetting parse jsonParams exception", localJSONException);
        bool1 = bool2;
      }
    }
    if (localAuthState.isSynchronized())
    {
      if (bool1)
      {
        requestAuthList(bool1, paramRequestEvent, str, localAuthState);
        return;
      }
      callbackSettingEvent(localAuthState, paramRequestEvent, bool1, null);
      return;
    }
    requestAuthList(bool1, paramRequestEvent, str, localAuthState);
  }
  
  public void onDestroy()
  {
    unregisterChooseAddressReceiver();
    super.onDestroy();
  }
  
  @JsEvent({"openSetting"})
  public void openSetting(RequestEvent paramRequestEvent)
  {
    ActivityResultManager.g().addActivityResultListener(new SettingsJsPlugin.2(this, paramRequestEvent));
    openSettingActivity(this.mMiniAppContext.getAttachedActivity(), this.mApkgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SettingsJsPlugin
 * JD-Core Version:    0.7.0.1
 */