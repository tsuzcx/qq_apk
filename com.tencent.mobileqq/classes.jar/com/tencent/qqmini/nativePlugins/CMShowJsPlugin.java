package com.tencent.qqmini.nativePlugins;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionManager;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class CMShowJsPlugin
  extends BaseJsPlugin
{
  private static boolean a;
  
  private void a(RequestEvent paramRequestEvent)
  {
    if (paramRequestEvent == null)
    {
      QLog.e("CMShowJsPlugin", 1, "[getCMShowInfo] error! req is null!");
      return;
    }
    try
    {
      String str1 = getMiniAppInfo().appId;
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str2 = localJSONObject.getString("openid");
      if (TextUtils.isEmpty(str2))
      {
        paramRequestEvent.fail("invalid params!");
        return;
      }
      String str3 = localJSONObject.getString("engineType");
      if ((!"laya".equals(str3)) && (!"egret".equals(str3)) && (!"cocos".equals(str3)))
      {
        paramRequestEvent.fail("invalid params!");
        return;
      }
      String str4 = localJSONObject.getString("engineVersion");
      String str5 = localJSONObject.optString("avatarType", "3D");
      if ((!"2D".equals(str5)) && (!"3D".equals(str5)))
      {
        paramRequestEvent.fail("invalid params!");
        return;
      }
      boolean bool = localJSONObject.optBoolean("useLocalRes", false);
      MiniAppCmdUtil.getInstance().getCMShowInfo(str2, str1, str3, str4, str5, new CMShowJsPlugin.3(this, bool, paramRequestEvent));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CMShowJsPlugin", 1, new Object[] { Integer.valueOf(1), "[getCMShowInfo] error! ", localThrowable });
      paramRequestEvent.fail("invalid params!");
    }
  }
  
  private void a(String paramString)
  {
    if ("2D".equals(paramString))
    {
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_open_cmshow_2d", null, null);
      return;
    }
    if ("3D".equals(paramString)) {
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_open_cmshow_3d", null, null);
    }
  }
  
  @JsEvent({"getCMShowInfo"})
  public void getCmShowInfo(RequestEvent paramRequestEvent)
  {
    Object localObject2;
    IJsPluginEngine localIJsPluginEngine;
    if ((this.mMiniAppContext instanceof BaseRuntime))
    {
      localObject2 = this.mMiniAppContext.getContext();
      if (localObject2 == null)
      {
        QLog.e("CMShowJsPlugin", 1, "getCmShowInfo context is null");
        paramRequestEvent.fail();
        return;
      }
      localIJsPluginEngine = ((BaseRuntime)this.mMiniAppContext).getJsPluginEngine();
      if (!(localIJsPluginEngine instanceof JsPluginEngine)) {
        break label365;
      }
    }
    label365:
    label366:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        PermissionInfo localPermissionInfo = new PermissionInfo();
        localPermissionInfo.reportSubAction = "getCMShowInfo";
        localPermissionInfo.rejectDescription = ((Context)localObject2).getString(2131694145);
        String str = localJSONObject.optString("avatarType", "2D");
        if ("2D".equalsIgnoreCase(str))
        {
          localObject1 = "scope.cmshowInfo2d";
          localPermissionInfo.name = ((Context)localObject2).getString(2131694141);
          localPermissionInfo.description = ((Context)localObject2).getString(2131694143);
          break label366;
        }
        if ("3D".equalsIgnoreCase(str))
        {
          localObject1 = "scope.cmshowInfo3d";
          localPermissionInfo.name = ((Context)localObject2).getString(2131694142);
          localPermissionInfo.description = ((Context)localObject2).getString(2131694144);
          break label366;
          localObject2 = MiniAppEnv.g().getAuthSate(this.mApkgInfo.appId);
          if (((AuthState)localObject2).getAuthFlag((String)localObject1) == 2)
          {
            a(paramRequestEvent);
            return;
          }
          localJSONObject.put("scope", localObject1);
          paramRequestEvent.jsonParams = localJSONObject.toString();
          PermissionManager.g().updateScopePermission((String)localObject1, localPermissionInfo);
          ((JsPluginEngine)localIJsPluginEngine).showRequestPermissionDialog(paramRequestEvent, new CMShowJsPlugin.2(this, str, (AuthState)localObject2, (String)localObject1, paramRequestEvent));
          return;
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("wrong avatarType: ");
        ((StringBuilder)localObject1).append(str);
        QLog.e("CMShowJsPlugin", 1, ((StringBuilder)localObject1).toString());
        paramRequestEvent.fail();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("CMShowJsPlugin", 1, "getCmShowInfo error", localException);
        paramRequestEvent.fail();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCmShowInfo miniAppContext: ");
      localStringBuilder.append(this.mMiniAppContext);
      QLog.e("CMShowJsPlugin", 1, localStringBuilder.toString());
      paramRequestEvent.fail();
      return;
    }
  }
  
  @JsEvent({"setCMShowPetStatus"})
  public void setCMShowPetStatus(RequestEvent paramRequestEvent)
  {
    if (paramRequestEvent == null)
    {
      QLog.e("CMShowJsPlugin", 1, "[setCMShowPetStatus] error! req is null!");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data");
      int i = localJSONObject.optInt("roleId");
      int j = localJSONObject.optInt("petStatus");
      MiniAppCmdUtil.getInstance().setCMShowPetStatus(i, j, new CMShowJsPlugin.1(this, paramRequestEvent));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CMShowJsPlugin", 1, new Object[] { Integer.valueOf(1), "[setCMShowPetStatus] error! ", localThrowable });
      paramRequestEvent.fail("invalid params!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowJsPlugin
 * JD-Core Version:    0.7.0.1
 */