package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import bdcz;
import bdde;
import bddh;
import bddu;
import bdel;
import bdfx;
import bdfz;
import bdnw;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
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
  
  private void callbackSettingEvent(bdde parambdde, bdfz parambdfz)
  {
    if (parambdde == null) {
      return;
    }
    Object localObject = parambdde.a(6);
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        parambdde = new JSONObject();
        localJSONArray = new JSONArray();
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        bddh localbddh = (bddh)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scope", localbddh.jdField_a_of_type_JavaLangString);
        int i;
        if (localbddh.jdField_a_of_type_Int == 2)
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
      catch (JSONException parambdde)
      {
        bdnw.d("SettingsJsPlugin", parambdfz.jdField_a_of_type_JavaLangString + " error.", parambdde);
        parambdfz.b();
        return;
      }
    }
    parambdde.put("authSetting", localJSONArray);
    parambdfz.a(parambdde);
  }
  
  private void callbackSettingEvent(bdfz parambdfz)
  {
    callbackSettingEvent(MiniAppEnv.g().getAuthSate(this.mApkgInfo.d), parambdfz);
  }
  
  private void openSettingActivity(Activity paramActivity, bdfx parambdfx)
  {
    if (parambdfx == null)
    {
      bdnw.d("SettingsJsPlugin", "openSettingActivity, appInfo:" + parambdfx);
      return;
    }
    bddu.a(paramActivity, parambdfx.d, parambdfx.c, 5);
  }
  
  public void getSetting(bdfz parambdfz)
  {
    String str = this.mApkgInfo.d;
    bdde localbdde = MiniAppEnv.g().getAuthSate(str);
    if (localbdde == null)
    {
      bdnw.d("SettingsJsPlugin", "getSetting, but authorizeCenter is null?!");
      return;
    }
    if (localbdde.a())
    {
      callbackSettingEvent(localbdde, parambdfz);
      return;
    }
    this.mProxy.getAuthList(str, new SettingsJsPlugin.2(this, localbdde, parambdfz));
  }
  
  public void openSetting(bdfz parambdfz)
  {
    bdel.a().a(new SettingsJsPlugin.1(this, parambdfz));
    openSettingActivity(this.mMiniAppContext.a(), this.mApkgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SettingsJsPlugin
 * JD-Core Version:    0.7.0.1
 */