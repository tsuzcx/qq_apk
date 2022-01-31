package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import begz;
import behf;
import behi;
import beil;
import bejy;
import beka;
import besl;
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
  
  private void callbackSettingEvent(behf parambehf, beka parambeka)
  {
    if (parambehf == null) {
      return;
    }
    Object localObject = parambehf.a(6);
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        parambehf = new JSONObject();
        localJSONArray = new JSONArray();
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        behi localbehi = (behi)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scope", localbehi.jdField_a_of_type_JavaLangString);
        int i;
        if (localbehi.jdField_a_of_type_Int == 2)
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
      catch (JSONException parambehf)
      {
        besl.d("SettingsJsPlugin", parambeka.jdField_a_of_type_JavaLangString + " error.", parambehf);
        parambeka.b();
        return;
      }
    }
    parambehf.put("authSetting", localJSONArray);
    parambeka.a(parambehf);
  }
  
  private void callbackSettingEvent(beka parambeka)
  {
    callbackSettingEvent(MiniAppEnv.g().getAuthSate(this.mApkgInfo.d), parambeka);
  }
  
  private void openSettingActivity(Activity paramActivity, bejy parambejy)
  {
    if (parambejy == null)
    {
      besl.d("SettingsJsPlugin", "openSettingActivity, appInfo:" + parambejy);
      return;
    }
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openPermissionSettingsActivity(paramActivity, parambejy.d, parambejy.c);
  }
  
  public void getSetting(beka parambeka)
  {
    String str = this.mApkgInfo.d;
    behf localbehf = MiniAppEnv.g().getAuthSate(str);
    if (localbehf == null)
    {
      besl.d("SettingsJsPlugin", "getSetting, but authorizeCenter is null?!");
      return;
    }
    if (localbehf.a())
    {
      callbackSettingEvent(localbehf, parambeka);
      return;
    }
    this.mProxy.getAuthList(str, new SettingsJsPlugin.2(this, localbehf, parambeka));
  }
  
  public void openSetting(beka parambeka)
  {
    beil.a().a(new SettingsJsPlugin.1(this, parambeka));
    openSettingActivity(this.mMiniAppContext.a(), this.mApkgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SettingsJsPlugin
 * JD-Core Version:    0.7.0.1
 */