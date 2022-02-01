package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.auth.AuthFilterList;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class DataJsPlugin
  extends BaseJsPlugin
{
  private static final String MINI_APP_STORE_APPID = "1108291530";
  private static final String TAG = "DataJsPlugin";
  private static final int WHAT_GET_SHARE_INFO_TIMEOUT = 1;
  private static final String fakeCheckNavigateRightRsp = "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}";
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  private void advertReport(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramRequestEvent.jsonParams);
        int i = ((JSONObject)localObject).getJSONObject("data").getJSONObject("data").getInt("report_type");
        String str = ((JSONObject)localObject).getJSONObject("data").getJSONObject("data").get("ads_info").toString();
        localObject = ((JSONObject)localObject).getJSONObject("data").getJSONObject("data").get("pos_id").toString();
        AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
        if ((localAdProxy != null) && (i == 0))
        {
          bool = localAdProxy.adExposure(this.mMiniAppContext.getAttachedActivity(), str, (String)localObject);
          if (bool)
          {
            paramRequestEvent.ok();
            QMLog.i("DataJsPlugin", "advertExposure " + str + ", posId = " + (String)localObject);
            return;
          }
          paramRequestEvent.fail();
          continue;
        }
        boolean bool = false;
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
        QMLog.e("DataJsPlugin", "advertExposure, data is wrong " + paramRequestEvent.jsonParams);
        return;
      }
    }
  }
  
  private void advertTap(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        new JSONObject(paramRequestEvent.jsonParams);
        AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
        if (localAdProxy != null)
        {
          bool = localAdProxy.adClick(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.jsonParams, "");
          if (bool)
          {
            paramRequestEvent.ok();
            return;
          }
          paramRequestEvent.fail();
          return;
        }
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
        QMLog.e("DataJsPlugin", "advert_tap, data is wrong " + paramRequestEvent.jsonParams);
        return;
      }
      boolean bool = false;
    }
  }
  
  private Typeface getFont(String paramString1, String paramString2, String paramString3)
  {
    Object localObject2 = null;
    Object localObject1;
    if ("normal".equals(paramString1)) {
      if ("normal".equals(paramString2)) {
        localObject1 = Typeface.create(paramString3, 0);
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (!"bold".equals(paramString2));
        return Typeface.create(paramString3, 1);
        localObject1 = localObject2;
      } while (!"italic".equals(paramString1));
      if ("normal".equals(paramString2)) {
        return Typeface.create(paramString3, 2);
      }
      localObject1 = localObject2;
    } while (!"bold".equals(paramString2));
    return Typeface.create(paramString3, 3);
  }
  
  private void getUserInfo(RequestEvent paramRequestEvent, String paramString1, boolean paramBoolean, String paramString2)
  {
    String str = this.mApkgInfo.appId;
    QMLog.d("DataJsPlugin", "getUserInfo appID:" + str);
    this.mChannelProxy.getUserInfo(str, paramBoolean, paramString2, new DataJsPlugin.14(this, paramString1, paramRequestEvent));
  }
  
  @JsEvent({"getTextLineHeight"})
  private String handleGetTextLineHeight(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject2 = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject1 = ((JSONObject)localObject2).optString("fontStyle");
      String str2 = ((JSONObject)localObject2).optString("fontWeight");
      String str3 = ((JSONObject)localObject2).optString("fontFamily");
      String str1 = ((JSONObject)localObject2).optString("text");
      int i = ((JSONObject)localObject2).getInt("fontSize");
      if ((!"normal".equals(str2)) && (!"bold".equals(str2)))
      {
        paramRequestEvent.fail("fontWeight is illegal");
        return "";
      }
      if ((!"normal".equals(localObject1)) && (!"italic".equals(localObject1)))
      {
        paramRequestEvent.fail("fontStyle is illegal");
        return "";
      }
      if (i <= 0)
      {
        paramRequestEvent.fail("jsPluginEngine is illegal");
        return "";
      }
      if (TextUtils.isEmpty(str1))
      {
        paramRequestEvent.fail("text is empty");
        return "";
      }
      localObject2 = new Paint();
      ((Paint)localObject2).setTextSize(i);
      if (getFont((String)localObject1, str2, str3) == null)
      {
        paramRequestEvent.fail("cannot create this font");
        return "";
      }
      localObject1 = new Rect();
      ((Paint)localObject2).getTextBounds(str1, 0, str1.length(), (Rect)localObject1);
      paramRequestEvent.ok();
      str1 = "" + ((Rect)localObject1).height();
      return str1;
    }
    catch (JSONException localJSONException)
    {
      paramRequestEvent.fail("json exception");
    }
    return "";
  }
  
  private boolean isEntryModelGroupType(String paramString)
  {
    return (this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null) && (paramString != null) && (paramString.equals(this.mMiniAppInfo.launchParam.entryModel.getEntryHash())) && (this.mMiniAppInfo.launchParam.entryModel.type == 1);
  }
  
  private boolean onRequestAdInfoResult(boolean paramBoolean, JSONObject paramJSONObject, RequestEvent paramRequestEvent, int paramInt)
  {
    int j;
    if (paramBoolean)
    {
      j = paramJSONObject.getInt("retCode");
      String str1 = paramJSONObject.getString("errMsg");
      String str2 = paramJSONObject.getString("response");
      String str3 = paramJSONObject.optString("adClass");
      String str4 = paramJSONObject.optString("fromSDK");
      paramJSONObject = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      QMLog.d("DataJsPlugin", "requestAdInfo. retCode = " + j);
      int i;
      if (WnsConfig.getConfig("qqminiapp", "miniappadusetranscoding", 0) == 0) {
        i = 1;
      }
      for (;;)
      {
        if ((j != 0) && (i != 0))
        {
          paramInt = MiniSDKConst.AdConst.getRetCodeByServerResult(j);
          try
          {
            localJSONObject2.put("ret", paramInt);
            paramJSONObject.put("data", localJSONObject2.toString());
            if (paramInt != -1)
            {
              paramRequestEvent.fail(paramJSONObject, (String)MiniSDKConst.AdConst.CODE_MSG_MAP.get(Integer.valueOf(paramInt)));
              return true;
              i = 0;
            }
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              QMLog.e("DataJsPlugin", "JSONException: " + Log.getStackTraceString(localJSONException2));
              continue;
              paramRequestEvent.fail(paramJSONObject, str1);
            }
          }
        }
      }
      try
      {
        localJSONObject2.put("data", localJSONException2);
        localJSONObject2.put("ret", j);
        localJSONObject2.put("adClass", str3);
        if (!TextUtils.isEmpty(str4)) {
          localJSONObject2.put("fromSDK", str4);
        }
        paramJSONObject.put("data", localJSONObject2.toString());
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          QMLog.i("DataJsPlugin", "requestAdInfo. retCode = " + j);
        }
      }
      paramRequestEvent.ok(paramJSONObject);
      saveAdCookie(localJSONException2, paramInt);
    }
    for (;;)
    {
      return false;
      if (paramJSONObject != null)
      {
        paramInt = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        JSONObject localJSONObject1 = new JSONObject();
        try
        {
          localJSONObject1.put("ret", paramInt);
          localJSONObject1.put("errMsg", paramJSONObject);
          paramRequestEvent.fail(localJSONObject1, "");
        }
        catch (JSONException paramJSONObject)
        {
          QMLog.e("DataJsPlugin", "requestAdInfo. retCode = " + paramInt);
        }
      }
      else
      {
        paramRequestEvent.fail();
      }
    }
  }
  
  private void operateGetShareInfo(String paramString, int paramInt, RequestEvent paramRequestEvent)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 30000;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramRequestEvent.fail("shareTicket can not be null");
      return;
    }
    Object localObject = new HandlerThread("getShareInfoHandlerThread");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper(), new DataJsPlugin.15(this, paramRequestEvent));
    ((Handler)localObject).sendEmptyMessageDelayed(1, i);
    String str = this.mApkgInfo.appId;
    this.mChannelProxy.getGroupShareInfo(str, paramString, new DataJsPlugin.16(this, paramRequestEvent, (Handler)localObject));
  }
  
  @JsEvent({"private_addContact"})
  private void private_addContact(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).addPublicAccount(LoginManager.getInstance().getAccount(), localJSONObject.optString("mpid"), new DataJsPlugin.3(this, paramRequestEvent)))
      {
        MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中关注公众号", 1);
        paramRequestEvent.fail();
      }
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  private void requestAdInfo(RequestEvent paramRequestEvent, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    String str2 = AdUtil.getSpAdGdtCookie(paramInt1);
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    String str1 = "";
    Object localObject4 = "";
    Object localObject5 = "";
    Object localObject3 = str1;
    Object localObject2 = localObject4;
    Object localObject1 = localObject5;
    if (localMiniAppInfo != null)
    {
      localObject3 = str1;
      localObject2 = localObject4;
      localObject1 = localObject5;
      if (localMiniAppInfo.launchParam != null)
      {
        if (localMiniAppInfo.launchParam.entryPath == null) {
          break label213;
        }
        localObject1 = localMiniAppInfo.launchParam.entryPath;
      }
    }
    for (;;)
    {
      localObject2 = localMiniAppInfo.launchParam.reportData;
      str1 = String.valueOf(localMiniAppInfo.launchParam.scene);
      localObject3 = localObject1;
      localObject1 = str1;
      if ((localMiniAppInfo != null) && (localMiniAppInfo.via != null))
      {
        str1 = localMiniAppInfo.via;
        label133:
        localObject5 = (AdProxy)ProxyManager.get(AdProxy.class);
        if (localObject5 == null) {
          break;
        }
      }
      else
      {
        try
        {
          if (this.mMiniAppContext.getAttachedActivity() != null) {}
          for (localObject4 = this.mMiniAppContext.getAttachedActivity();; localObject4 = MiniAppEnv.g().getContext())
          {
            ((AdProxy)localObject5).requestAdInfo((Context)localObject4, String.valueOf(paramLong), paramString1, paramString2, 53, paramInt1, 0, str2, (String)localObject3, (String)localObject2, (String)localObject1, str1, paramInt2, new DataJsPlugin.13(this, paramRequestEvent, paramInt1));
            return;
            label213:
            localObject1 = "";
            break;
            str1 = "";
            break label133;
          }
          paramRequestEvent.fail();
        }
        catch (Throwable paramString1)
        {
          paramRequestEvent.fail();
          QMLog.e("DataJsPlugin", "requestAdInfo. error", paramString1);
          return;
        }
      }
    }
  }
  
  private void saveAdCookie(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).has("gdt_cookie"))
      {
        localObject = ((JSONObject)localObject).getString("gdt_cookie");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        AdUtil.putSpAdGdtCookie(paramInt, (String)localObject);
        QMLog.i("DataJsPlugin", "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + (String)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.i("DataJsPlugin", "parseAndSaveCookie error" + paramString, localException);
    }
  }
  
  private void startGroupBrowserActivity(String paramString, RequestEvent paramRequestEvent)
  {
    if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openGroup(this.mMiniAppContext.getAttachedActivity(), paramString, new DataJsPlugin.17(this, paramRequestEvent)))
    {
      MiniToast.makeText(this.mContext, 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中打开QQ群", 1);
      paramRequestEvent.fail("app not implement");
    }
  }
  
  private void webapiGetWerunStepHistory(RequestEvent paramRequestEvent)
  {
    String str = this.mApkgInfo.appId;
    this.mChannelProxy.getUserHealthData(str, new DataJsPlugin.8(this, paramRequestEvent));
  }
  
  private void webapiGetnavigateWxaappinfo(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("reqData").optString("target_appid");
    if ("1108291530".equals(this.mApkgInfo.appId))
    {
      QMLog.d("DataJsPlugin", "MINI_APP_STORE skip checkNavigateRight");
      paramJSONObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("data", "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}");
        paramJSONObject.put("respData", localJSONObject);
        paramRequestEvent.ok(paramJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    this.mChannelProxy.checkNavigateRight(this.mApkgInfo.appId, paramJSONObject, new DataJsPlugin.10(this, paramRequestEvent));
  }
  
  private void webapiPluginGetUserInfo(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("miniprogram_appid");
    boolean bool = ((JSONObject)localObject).optBoolean("withCredentials");
    localObject = ((JSONObject)localObject).optString("lang");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      this.mChannelProxy.getUserInfo(paramJSONObject, bool, (String)localObject, new DataJsPlugin.11(this, paramRequestEvent));
      return;
    }
    paramRequestEvent.fail();
    AuthState.setAllowPluginScopeName(null);
  }
  
  private void webapiPluginLogin(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("data").optString("miniprogram_appid");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      this.mChannelProxy.login(paramJSONObject, new DataJsPlugin.9(this, paramRequestEvent));
      return;
    }
    paramRequestEvent.fail();
  }
  
  private void webapiPluginSetAuth(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("data");
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("miniprogram_appid");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        String str = LoginManager.getInstance().getAccount();
        paramJSONObject = BaseJsPluginEngine.getScopePluginSetauthName((String)localObject, paramJSONObject.optString("plugin_appid"));
        AuthState.setAllowPluginScopeName(paramJSONObject);
        new AuthState(this.mContext, (String)localObject, str).grantPermission(paramJSONObject);
        paramRequestEvent.ok();
        return;
      }
      paramRequestEvent.fail();
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"batchGetContact"})
  public void batchGetContact(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("appIds");
      ArrayList localArrayList = new ArrayList();
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(String.valueOf(localJSONArray.get(i)));
          i += 1;
        }
      }
      this.mChannelProxy.batchGetContact(localArrayList, new DataJsPlugin.6(this, paramRequestEvent));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRequestEvent.fail("batchGetContact failed.");
    }
  }
  
  @JsEvent({"getCloudTicket"})
  public void getCloudTicket(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = this.mApkgInfo.appId;
      localObject = ((JSONObject)localObject).optString("envId");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.mChannelProxy.getTcbTicket(str, (String)localObject, new DataJsPlugin.5(this, paramRequestEvent));
      }
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QMLog.e("DataJsPlugin", "API_GET_CLOUD_TICKET error, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"getGroupInfo"})
  public void getGroupInfo(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.mMiniAppInfo != null)
      {
        bool1 = bool2;
        if (this.mMiniAppInfo.launchParam != null)
        {
          bool1 = bool2;
          if (this.mMiniAppInfo.launchParam.entryModel != null) {
            bool1 = this.mMiniAppInfo.launchParam.entryModel.isAdmin;
          }
        }
      }
      localJSONObject.put("isGroupManager", bool1);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    paramRequestEvent.ok(localJSONObject);
  }
  
  @JsEvent({"getGroupInfoExtra"})
  public void getGroupInfoExtra(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("entryDataHash");
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.mMiniAppInfo != null)
      {
        bool1 = bool2;
        if (this.mMiniAppInfo.launchParam != null)
        {
          bool1 = bool2;
          if (this.mMiniAppInfo.launchParam.entryModel != null) {
            bool1 = this.mMiniAppInfo.launchParam.entryModel.isAdmin;
          }
        }
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isGroupManager", bool1);
      if (isEntryModelGroupType(str))
      {
        str = this.mApkgInfo.appId;
        long l1 = this.mMiniAppInfo.launchParam.entryModel.uin;
        long l2 = this.mMiniAppInfo.launchParam.entryModel.dwGroupClassExt;
        this.mChannelProxy.getUserGroupInfo(null, str, String.valueOf(l1), l2, new DataJsPlugin.2(this, localJSONObject, paramRequestEvent));
        return;
      }
      QMLog.e("DataJsPlugin", "entryDataHash or type error.");
      paramRequestEvent.fail("entryDataHash or type error.");
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("DataJsPlugin", "getGroupInfoExtra exception", localJSONException);
      paramRequestEvent.fail("JSONException");
    }
  }
  
  @JsEvent({"getNativeUserInfo"})
  public void getNativeUserInfo(RequestEvent paramRequestEvent)
  {
    if ((MiniAppEnv.g().getAuthSate(this.mMiniAppContext.getMiniAppInfo().appId).isPermissionGranted("scope.userInfo")) || (AuthFilterList.isAppInWhiteList(this.mMiniAppContext.getMiniAppInfo().appId)) || (AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo())))
    {
      paramRequestEvent.evaluateCallbackJs(ApiUtil.wrapCallbackOk("getUserInfo", null).toString());
      return;
    }
    QMLog.e("DataJsPlugin", "getUserInfo已弃用，请使用createUserInfoButton");
    paramRequestEvent.evaluateCallbackJs(ApiUtil.wrapCallbackFail("getUserInfo", null, "getUserInfo已弃用，请使用createUserInfoButton").toString());
  }
  
  @JsEvent({"getNativeWeRunData", "openWeRunSetting"})
  public void getNativeWeRunData(RequestEvent paramRequestEvent)
  {
    paramRequestEvent.ok();
  }
  
  @JsEvent({"getPerformance"})
  public void getPerformance(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", MiniReportManager.getLaunchPerformance(this.mMiniAppInfo.appId));
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  @JsEvent({"getShareInfo"})
  public void getShareInfo(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("shareTicket");
      int j = localJSONObject.optInt("timeout", 0);
      int i = j;
      if (j <= 0) {
        i = 30000;
      }
      operateGetShareInfo(str, i, paramRequestEvent);
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("DataJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"getUserInfoExtra"})
  public void getUserInfoExtra(RequestEvent paramRequestEvent)
  {
    ApkgInfo localApkgInfo = this.mApkgInfo;
    this.mChannelProxy.getUserInfoExtra(localApkgInfo.appId, new DataJsPlugin.12(this, paramRequestEvent));
  }
  
  @JsEvent({"invokeGroupJSApi"})
  public void invokeGroupJSApi(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("entryDataHash");
      localObject = ((JSONObject)localObject).optString("url");
      if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null) && (str != null) && (str.equals(this.mMiniAppInfo.launchParam.entryModel.getEntryHash())) && (this.mMiniAppInfo.launchParam.entryModel.isAdmin) && (localObject != null) && (((String)localObject).contains("{{gid}}"))) {
        startGroupBrowserActivity(((String)localObject).replace("{{gid}}", String.valueOf(this.mMiniAppInfo.launchParam.entryModel.uin)), paramRequestEvent);
      }
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"operateAppAdData"})
  public void operateAppAdData(RequestEvent paramRequestEvent)
  {
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      str = localJSONObject.optString("api_name");
      if ("getBannerAd".equals(str))
      {
        webapiGetadvert(paramRequestEvent, localJSONObject, 2);
        return;
      }
      if ("getBlockAd".equals(str))
      {
        webapiGetadvert(paramRequestEvent, localJSONObject, 12);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      paramRequestEvent.fail("json exception");
      QMLog.d("DataJsPlugin", "operateAppAdData. Exception: " + Log.getStackTraceString(localJSONException));
      return;
    }
    if ("getCardAd".equals(str))
    {
      webapiGetadvert(paramRequestEvent, localJSONException, 5);
      return;
    }
    if ("getFeedsAd".equals(str))
    {
      webapiGetadvert(paramRequestEvent, localJSONException, 6);
      return;
    }
    if ("getInterstitialAd".equals(str))
    {
      webapiGetadvert(paramRequestEvent, localJSONException, 10);
      return;
    }
    if ("advert_tap".equals(str)) {
      advertTap(paramRequestEvent);
    }
  }
  
  @JsEvent({"operateWXData"})
  public void operateWXData(RequestEvent paramRequestEvent)
  {
    Object localObject2;
    String str;
    try
    {
      localObject2 = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject1 = ((JSONObject)localObject2).optJSONObject("data");
      str = ((JSONObject)localObject1).optString("api_name");
      QMLog.d("DataJsPlugin", "operateWXData apiName: " + str);
      if (("webapi_getuserinfo".equals(str)) || ("webapi_getuserinfo_opendata".equals(str)))
      {
        boolean bool = ((JSONObject)localObject1).optBoolean("with_credentials");
        localObject2 = ((JSONObject)localObject1).optString("lang", null);
        localObject1 = ((JSONObject)localObject1).optJSONObject("data");
        if (localObject1 != null) {
          localObject1 = ((JSONObject)localObject1).optString("lang", "en");
        }
        for (;;)
        {
          getUserInfo(paramRequestEvent, str, bool, (String)localObject1);
          return;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = "en";
          }
        }
      }
      if ("webapi_wxa_subscribe_biz".equals(str))
      {
        QMLog.e("DataJsPlugin", "webapi_wxa_subscribe_biz IN DEVELOPMENT");
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      paramRequestEvent.fail("json exception");
      return;
    }
    if ("webapi_plugin_setauth".equals(str))
    {
      webapiPluginSetAuth(paramRequestEvent, localJSONException);
      return;
    }
    if ("webapi_plugin_login".equals(str))
    {
      webapiPluginLogin(paramRequestEvent, localJSONException);
      return;
    }
    if ("webapi_plugin_getuserinfo".equals(str))
    {
      webapiPluginGetUserInfo(paramRequestEvent, localJSONException);
      return;
    }
    if ("webapi_getnavigatewxaappinfo".equals(str))
    {
      webapiGetnavigateWxaappinfo(paramRequestEvent, (JSONObject)localObject2);
      return;
    }
    if ("webapi_getadvert".equals(str))
    {
      webapiGetadvert(paramRequestEvent, localJSONException, 2);
      return;
    }
    if ("advert_tap".equals(str))
    {
      advertTap(paramRequestEvent);
      return;
    }
    if ("advert_report".equals(str))
    {
      advertReport(paramRequestEvent);
      return;
    }
    if ("getBlockAd".equals(str))
    {
      webapiGetadvert(paramRequestEvent, localJSONException, 12);
      return;
    }
    if ("webapi_getshareinfo".equals(str))
    {
      operateGetShareInfo(localJSONException.optJSONObject("data").optString("shareTicket"), localJSONException.optJSONObject("data").optInt("timeout", 0), paramRequestEvent);
      return;
    }
    if ("webapi_getwerunstep_history".equals(str)) {
      webapiGetWerunStepHistory(paramRequestEvent);
    }
  }
  
  @JsEvent({"profile"})
  public void profile(RequestEvent paramRequestEvent)
  {
    try
    {
      paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
      QMLog.d("DataJsPlugin", "查看公众号: " + paramRequestEvent);
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).jump2PublicAccount(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.optString("uin"), paramRequestEvent.optString("pubName"))) {
        MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中打开公众号", 1);
      }
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("DataJsPlugin", "profile", paramRequestEvent);
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"reportSubmitForm"})
  public void reportSubmitForm(RequestEvent paramRequestEvent)
  {
    String str = this.mApkgInfo.appId;
    this.mChannelProxy.getFormId(str, new DataJsPlugin.4(this, paramRequestEvent));
  }
  
  @JsEvent({"scanCode"})
  public void scanCode(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      if (!this.mMiniAppProxy.enterQRCode(this.mMiniAppContext.getAttachedActivity(), localJSONObject.optBoolean("onlyFromCamera", false), new DataJsPlugin.1(this, paramRequestEvent)))
      {
        MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中扫码二维码", 1);
        paramRequestEvent.fail();
      }
      return;
    }
    catch (Throwable paramRequestEvent) {}
  }
  
  @JsEvent({"verifyPlugin"})
  public void verifyPlugin(RequestEvent paramRequestEvent)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data").optJSONArray("plugins");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
          PluginInfo localPluginInfo = new PluginInfo();
          localPluginInfo.setPluginId(localJSONObject.optString("provider"));
          localPluginInfo.setInnerVersion(localJSONObject.optString("inner_version"));
          localArrayList.add(localPluginInfo);
          i += 1;
        }
      }
      localObject = this.mApkgInfo.appId;
      this.mChannelProxy.verifyPlugin((String)localObject, localArrayList, new DataJsPlugin.7(this, paramRequestEvent));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRequestEvent.fail("verifyPlugin failed.");
    }
  }
  
  public void webapiGetadvert(RequestEvent paramRequestEvent, JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str = paramJSONObject.optJSONObject("data").optString("pos_id");
        if (paramJSONObject.optJSONObject("data").has("adType"))
        {
          paramInt = paramJSONObject.optJSONObject("data").optInt("adType");
          int i = 1;
          if (paramJSONObject.optJSONObject("data").has("size")) {
            i = paramJSONObject.optJSONObject("data").optInt("size");
          }
          long l = Long.valueOf(LoginManager.getInstance().getAccount()).longValue();
          paramJSONObject = this.mMiniAppInfo.appId;
          QMLog.d("DataJsPlugin", "webapi_getadvert getAppid = " + paramJSONObject);
          if (!TextUtils.isEmpty(paramJSONObject)) {
            requestAdInfo(paramRequestEvent, str, paramInt, i, l, paramJSONObject);
          }
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramRequestEvent.fail();
        QMLog.e("DataJsPlugin", "webapiGetadvert. error", paramJSONObject);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin
 * JD-Core Version:    0.7.0.1
 */