package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import behq;
import behw;
import behz;
import bejc;
import bekp;
import bekr;
import betc;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
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
  
  private void callbackSettingEvent(behw parambehw, bekr parambekr)
  {
    if (parambehw == null) {
      return;
    }
    Object localObject = parambehw.a(6);
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        parambehw = new JSONObject();
        localJSONArray = new JSONArray();
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        behz localbehz = (behz)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scope", localbehz.jdField_a_of_type_JavaLangString);
        int i;
        if (localbehz.jdField_a_of_type_Int == 2)
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
      catch (JSONException parambehw)
      {
        betc.d("SettingsJsPlugin", parambekr.jdField_a_of_type_JavaLangString + " error.", parambehw);
        parambekr.b();
        return;
      }
    }
    parambehw.put("authSetting", localJSONArray);
    parambekr.a(parambehw);
  }
  
  private void callbackSettingEvent(bekr parambekr)
  {
    callbackSettingEvent(MiniAppEnv.g().getAuthSate(this.mApkgInfo.d), parambekr);
  }
  
  private void openSettingActivity(Activity paramActivity, bekp parambekp)
  {
    if (parambekp == null)
    {
      betc.d("SettingsJsPlugin", "openSettingActivity, appInfo:" + parambekp);
      return;
    }
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openPermissionSettingsActivity(paramActivity, parambekp.d, parambekp.c);
  }
  
  public void getSetting(bekr parambekr)
  {
    String str = this.mApkgInfo.d;
    behw localbehw = MiniAppEnv.g().getAuthSate(str);
    if (localbehw == null)
    {
      betc.d("SettingsJsPlugin", "getSetting, but authorizeCenter is null?!");
      return;
    }
    if (localbehw.a())
    {
      callbackSettingEvent(localbehw, parambekr);
      return;
    }
    this.mProxy.getAuthList(str, new SettingsJsPlugin.2(this, localbehw, parambekr));
  }
  
  public void openSetting(bekr parambekr)
  {
    bejc.a().a(new SettingsJsPlugin.1(this, parambekr));
    openSettingActivity(this.mMiniAppContext.a(), this.mApkgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SettingsJsPlugin
 * JD-Core Version:    0.7.0.1
 */