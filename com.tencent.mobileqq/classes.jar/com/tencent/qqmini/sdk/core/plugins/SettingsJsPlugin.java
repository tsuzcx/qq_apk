package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import bglv;
import bgnk;
import bgod;
import bgok;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.auth.AuthState;
import com.tencent.qqmini.sdk.core.auth.AuthStateItem;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "SettingsJsPlugin";
  private ChannelProxy mProxy;
  
  private void callbackSettingEvent(bgok parambgok)
  {
    callbackSettingEvent(MiniAppEnv.g().getAuthSate(this.mApkgInfo.appId), parambgok);
  }
  
  private void callbackSettingEvent(AuthState paramAuthState, bgok parambgok)
  {
    if (paramAuthState == null) {
      return;
    }
    Object localObject = paramAuthState.getAuthStateList(6);
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        paramAuthState = new JSONObject();
        localJSONArray = new JSONArray();
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        AuthStateItem localAuthStateItem = (AuthStateItem)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scope", localAuthStateItem.scopeName);
        int i;
        if (localAuthStateItem.authFlag == 2)
        {
          i = 1;
          localJSONObject.put("state", i);
          localJSONArray.put(localJSONObject);
        }
        else
        {
          i = 0;
        }
      }
      catch (JSONException paramAuthState)
      {
        QMLog.e("SettingsJsPlugin", parambgok.a + " error.", paramAuthState);
        parambgok.b();
        return;
      }
    }
    paramAuthState.put("authSetting", localJSONArray);
    parambgok.a(paramAuthState);
  }
  
  private void openSettingActivity(Activity paramActivity, bgod parambgod)
  {
    if (parambgod == null)
    {
      QMLog.e("SettingsJsPlugin", "openSettingActivity, appInfo:" + parambgod);
      return;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openPermissionSettingsActivity(paramActivity, parambgod.appId, parambgod.apkgName);
  }
  
  public void getSetting(bgok parambgok)
  {
    String str = this.mApkgInfo.appId;
    AuthState localAuthState = MiniAppEnv.g().getAuthSate(str);
    if (localAuthState == null)
    {
      QMLog.e("SettingsJsPlugin", "getSetting, but authorizeCenter is null?!");
      return;
    }
    if (localAuthState.isSynchronized())
    {
      callbackSettingEvent(localAuthState, parambgok);
      return;
    }
    this.mProxy.getAuthList(str, new SettingsJsPlugin.2(this, localAuthState, parambgok));
  }
  
  public void openSetting(bgok parambgok)
  {
    bgnk.a().a(new SettingsJsPlugin.1(this, parambgok));
    openSettingActivity(this.mMiniAppContext.a(), this.mApkgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SettingsJsPlugin
 * JD-Core Version:    0.7.0.1
 */