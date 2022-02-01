package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.AuthStateItem;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.auth.SubscribeMessage;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
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
  private static final String TAG = "SettingsJsPlugin";
  private ChannelProxy mProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  
  private void callbackSettingEvent(AuthState paramAuthState, RequestEvent paramRequestEvent, boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramAuthState == null) {
      return;
    }
    Object localObject2 = paramAuthState.getAuthStateList(6);
    Object localObject1;
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      try
      {
        paramAuthState = new JSONObject();
        localObject1 = new JSONArray();
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (AuthStateItem)((Iterator)localObject2).next();
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("scope", ((AuthStateItem)localObject3).scopeName);
        int i;
        if (((AuthStateItem)localObject3).authFlag == 2)
        {
          i = 1;
          ((JSONObject)localObject4).put("state", i);
          ((JSONArray)localObject1).put(localObject4);
        }
        else
        {
          i = 0;
        }
      }
      catch (JSONException paramAuthState)
      {
        QMLog.e("SettingsJsPlugin", paramRequestEvent.event + " error.", paramAuthState);
        paramRequestEvent.fail();
        return;
      }
    }
    paramAuthState.put("authSetting", localObject1);
    if (paramBoolean)
    {
      localObject1 = new JSONObject();
      localObject2 = new JSONObject();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        localObject3 = paramMap.keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          ((JSONObject)localObject2).put((String)localObject4, paramMap.get(localObject4));
        }
      }
      ((JSONObject)localObject1).put("itemSettings", localObject2);
      paramAuthState.put("subscriptionsSetting", localObject1);
    }
    paramRequestEvent.ok(paramAuthState);
  }
  
  private void callbackSettingEvent(RequestEvent paramRequestEvent)
  {
    AuthState localAuthState = MiniAppEnv.g().getAuthSate(this.mApkgInfo.appId);
    if (!TextUtils.isEmpty(paramRequestEvent.jsonParams)) {}
    boolean bool;
    for (;;)
    {
      try
      {
        bool = new JSONObject(paramRequestEvent.jsonParams).optBoolean("withSubscriptions");
        if (!bool) {
          break;
        }
        requestAuthList(bool, paramRequestEvent, this.mApkgInfo.appId, localAuthState);
        return;
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("SettingsJsPlugin", "openSetting parse jsonParams exception", localJSONException);
      }
      bool = false;
    }
    callbackSettingEvent(localAuthState, paramRequestEvent, bool, null);
  }
  
  private Map<String, String> getInteractiveSubscribeList(List<SubscribeMessage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
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
  
  private void openSettingActivity(Activity paramActivity, ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null)
    {
      QMLog.e("SettingsJsPlugin", "openSettingActivity, appInfo:" + paramApkgInfo);
      return;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openPermissionSettingsActivity(paramActivity, paramApkgInfo.appId, paramApkgInfo.apkgName);
  }
  
  private void requestAuthList(boolean paramBoolean, RequestEvent paramRequestEvent, String paramString, AuthState paramAuthState)
  {
    this.mProxy.getAuthList(paramString, new SettingsJsPlugin.2(this, paramAuthState, paramBoolean, paramRequestEvent));
  }
  
  @JsEvent({"getSetting"})
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
    if (!TextUtils.isEmpty(paramRequestEvent.jsonParams)) {}
    try
    {
      bool1 = new JSONObject(paramRequestEvent.jsonParams).optBoolean("withSubscriptions");
      if (localAuthState.isSynchronized()) {
        if (bool1)
        {
          requestAuthList(bool1, paramRequestEvent, str, localAuthState);
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("SettingsJsPlugin", "getSetting parse jsonParams exception", localJSONException);
        bool1 = bool2;
      }
      callbackSettingEvent(localAuthState, paramRequestEvent, bool1, null);
      return;
    }
    requestAuthList(bool1, paramRequestEvent, str, localAuthState);
  }
  
  @JsEvent({"openSetting"})
  public void openSetting(RequestEvent paramRequestEvent)
  {
    ActivityResultManager.g().addActivityResultListener(new SettingsJsPlugin.1(this, paramRequestEvent));
    openSettingActivity(this.mMiniAppContext.getAttachedActivity(), this.mApkgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SettingsJsPlugin
 * JD-Core Version:    0.7.0.1
 */