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
    try
    {
      Object localObject2 = new JSONObject(paramRequestEvent.jsonParams);
      int i = ((JSONObject)localObject2).getJSONObject("data").getJSONObject("data").getInt("report_type");
      localObject1 = ((JSONObject)localObject2).getJSONObject("data").getJSONObject("data").get("ads_info").toString();
      localObject2 = ((JSONObject)localObject2).getJSONObject("data").getJSONObject("data").get("pos_id").toString();
      Object localObject3 = (AdProxy)ProxyManager.get(AdProxy.class);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject3 != null)
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = ((AdProxy)localObject3).adExposure(this.mMiniAppContext.getAttachedActivity(), (String)localObject1, (String)localObject2);
        }
      }
      if (bool1) {
        paramRequestEvent.ok();
      } else {
        paramRequestEvent.fail();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("advertExposure ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(", posId = ");
      ((StringBuilder)localObject3).append((String)localObject2);
      QMLog.i("DataJsPlugin", ((StringBuilder)localObject3).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      label191:
      break label191;
    }
    paramRequestEvent.fail();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("advertExposure, data is wrong ");
    ((StringBuilder)localObject1).append(paramRequestEvent.jsonParams);
    QMLog.e("DataJsPlugin", ((StringBuilder)localObject1).toString());
  }
  
  private void advertTap(RequestEvent paramRequestEvent)
  {
    try
    {
      new JSONObject(paramRequestEvent.jsonParams);
      localObject = (AdProxy)ProxyManager.get(AdProxy.class);
      boolean bool = false;
      if (localObject != null) {
        bool = ((AdProxy)localObject).adClick(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.jsonParams, "");
      }
      if (bool)
      {
        paramRequestEvent.ok();
        return;
      }
      paramRequestEvent.fail();
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      label63:
      break label63;
    }
    paramRequestEvent.fail();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("advert_tap, data is wrong ");
    ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
    QMLog.e("DataJsPlugin", ((StringBuilder)localObject).toString());
  }
  
  private Typeface getFont(String paramString1, String paramString2, String paramString3)
  {
    if ("normal".equals(paramString1))
    {
      if ("normal".equals(paramString2)) {
        return Typeface.create(paramString3, 0);
      }
      if ("bold".equals(paramString2)) {
        return Typeface.create(paramString3, 1);
      }
    }
    else if ("italic".equals(paramString1))
    {
      if ("normal".equals(paramString2)) {
        return Typeface.create(paramString3, 2);
      }
      if ("bold".equals(paramString2)) {
        return Typeface.create(paramString3, 3);
      }
    }
    return null;
  }
  
  private void getUserInfo(RequestEvent paramRequestEvent, String paramString1, boolean paramBoolean, String paramString2)
  {
    String str = this.mApkgInfo.appId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUserInfo appID:");
    localStringBuilder.append(str);
    QMLog.d("DataJsPlugin", localStringBuilder.toString());
    this.mChannelProxy.getUserInfo(str, paramBoolean, paramString2, new DataJsPlugin.14(this, paramString1, paramRequestEvent));
  }
  
  @JsEvent({"getTextLineHeight"})
  private String handleGetTextLineHeight(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject3 = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject2 = ((JSONObject)localObject3).optString("fontStyle");
      String str1 = ((JSONObject)localObject3).optString("fontWeight");
      String str2 = ((JSONObject)localObject3).optString("fontFamily");
      Object localObject1 = ((JSONObject)localObject3).optString("text");
      int i = ((JSONObject)localObject3).getInt("fontSize");
      if ((!"normal".equals(str1)) && (!"bold".equals(str1)))
      {
        paramRequestEvent.fail("fontWeight is illegal");
        return "";
      }
      if ((!"normal".equals(localObject2)) && (!"italic".equals(localObject2)))
      {
        paramRequestEvent.fail("fontStyle is illegal");
        return "";
      }
      if (i <= 0)
      {
        paramRequestEvent.fail("jsPluginEngine is illegal");
        return "";
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramRequestEvent.fail("text is empty");
        return "";
      }
      localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(i);
      if (getFont((String)localObject2, str1, str2) == null)
      {
        paramRequestEvent.fail("cannot create this font");
        return "";
      }
      localObject2 = new Rect();
      ((Paint)localObject3).getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
      paramRequestEvent.ok();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(((Rect)localObject2).height());
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      label245:
      break label245;
    }
    paramRequestEvent.fail("json exception");
    return "";
  }
  
  private boolean isEntryModelGroupType(String paramString)
  {
    return (this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null) && (paramString != null) && (paramString.equals(this.mMiniAppInfo.launchParam.entryModel.getEntryHash())) && (this.mMiniAppInfo.launchParam.entryModel.type == 1);
  }
  
  private boolean onRequestAdInfoResult(boolean paramBoolean, JSONObject paramJSONObject, RequestEvent paramRequestEvent, int paramInt)
  {
    int j;
    Object localObject2;
    String str2;
    JSONObject localJSONObject;
    if (paramBoolean)
    {
      j = paramJSONObject.getInt("retCode");
      localObject1 = paramJSONObject.getString("errMsg");
      String str1 = paramJSONObject.getString("response");
      localObject2 = paramJSONObject.optString("adClass");
      str2 = paramJSONObject.optString("fromSDK");
      paramJSONObject = new JSONObject();
      localJSONObject = new JSONObject();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestAdInfo. retCode = ");
      localStringBuilder.append(j);
      QMLog.d("DataJsPlugin", localStringBuilder.toString());
      int i;
      if (WnsConfig.getConfig("qqminiapp", "miniappadusetranscoding", 0) == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((j != 0) && (i != 0))
      {
        paramInt = MiniSDKConst.AdConst.getRetCodeByServerResult(j);
        try
        {
          localJSONObject.put("ret", paramInt);
          paramJSONObject.put("data", localJSONObject.toString());
        }
        catch (JSONException localJSONException2)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("JSONException: ");
          ((StringBuilder)localObject2).append(Log.getStackTraceString(localJSONException2));
          QMLog.e("DataJsPlugin", ((StringBuilder)localObject2).toString());
        }
        if (paramInt != -1)
        {
          paramRequestEvent.fail(paramJSONObject, (String)MiniSDKConst.AdConst.CODE_MSG_MAP.get(Integer.valueOf(paramInt)));
          return true;
        }
        paramRequestEvent.fail(paramJSONObject, (String)localObject1);
        return true;
      }
    }
    try
    {
      localJSONObject.put("data", localJSONException2);
      localJSONObject.put("ret", j);
      localJSONObject.put("adClass", localObject2);
      if (!TextUtils.isEmpty(str2)) {
        localJSONObject.put("fromSDK", str2);
      }
      paramJSONObject.put("data", localJSONObject.toString());
    }
    catch (JSONException localJSONException1)
    {
      label312:
      break label312;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("requestAdInfo. retCode = ");
    ((StringBuilder)localObject1).append(j);
    QMLog.i("DataJsPlugin", ((StringBuilder)localObject1).toString());
    paramRequestEvent.ok(paramJSONObject);
    saveAdCookie(localJSONException2, paramInt);
    break label468;
    if (paramJSONObject != null)
    {
      paramInt = paramJSONObject.getInt("retCode");
      paramJSONObject = paramJSONObject.getString("errMsg");
      localObject1 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject1).put("ret", paramInt);
      ((JSONObject)localObject1).put("errMsg", paramJSONObject);
      paramRequestEvent.fail((JSONObject)localObject1, "");
    }
    catch (JSONException paramJSONObject)
    {
      label428:
      break label428;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("requestAdInfo. retCode = ");
    paramJSONObject.append(paramInt);
    QMLog.e("DataJsPlugin", paramJSONObject.toString());
    break label468;
    paramRequestEvent.fail();
    label468:
    return false;
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
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).addPublicAccount(LoginManager.getInstance().getAccount(), ((JSONObject)localObject).optString("mpid"), new DataJsPlugin.3(this, paramRequestEvent)))
      {
        localObject = this.mMiniAppContext.getAttachedActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("暂不支持在");
        localStringBuilder.append(QUAUtil.getApplicationName(this.mContext));
        localStringBuilder.append("中关注公众号");
        MiniToast.makeText((Context)localObject, 0, localStringBuilder.toString(), 1);
        paramRequestEvent.fail();
        return;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  private void requestAdInfo(RequestEvent paramRequestEvent, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    String str2 = AdUtil.getSpAdGdtCookie(paramInt1);
    Object localObject4 = this.mMiniAppInfo;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    String str1;
    if ((localObject4 != null) && (((MiniAppInfo)localObject4).launchParam != null))
    {
      if (((MiniAppInfo)localObject4).launchParam.entryPath != null) {
        localObject1 = ((MiniAppInfo)localObject4).launchParam.entryPath;
      } else {
        localObject1 = "";
      }
      localObject2 = ((MiniAppInfo)localObject4).launchParam.reportData;
      int i = ((MiniAppInfo)localObject4).launchParam.scene;
      localObject3 = String.valueOf(i);
    }
    else
    {
      str1 = "";
      localObject1 = str1;
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = str1;
    }
    if ((localObject4 != null) && (((MiniAppInfo)localObject4).via != null)) {
      str1 = ((MiniAppInfo)localObject4).via;
    } else {
      str1 = "";
    }
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if (localAdProxy != null) {
      try
      {
        if (this.mMiniAppContext.getAttachedActivity() != null) {
          localObject4 = this.mMiniAppContext.getAttachedActivity();
        } else {
          localObject4 = MiniAppEnv.g().getContext();
        }
        localAdProxy.requestAdInfo((Context)localObject4, String.valueOf(paramLong), paramString1, paramString2, 53, paramInt1, 0, str2, (String)localObject1, (String)localObject2, (String)localObject3, str1, paramInt2, new DataJsPlugin.13(this, paramRequestEvent, paramInt1));
        return;
      }
      catch (Throwable paramString1)
      {
        paramRequestEvent.fail();
        QMLog.e("DataJsPlugin", "requestAdInfo. error", paramString1);
        return;
      }
    }
    paramRequestEvent.fail();
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseAndSaveCookie save key success, adType = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", value = ");
        localStringBuilder.append((String)localObject);
        QMLog.i("DataJsPlugin", localStringBuilder.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseAndSaveCookie error");
      localStringBuilder.append(paramString);
      QMLog.i("DataJsPlugin", localStringBuilder.toString(), localException);
    }
  }
  
  private void startGroupBrowserActivity(String paramString, RequestEvent paramRequestEvent)
  {
    if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openGroup(this.mMiniAppContext.getAttachedActivity(), paramString, new DataJsPlugin.17(this, paramRequestEvent)))
    {
      paramString = this.mContext;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("暂不支持在");
      localStringBuilder.append(QUAUtil.getApplicationName(this.mContext));
      localStringBuilder.append("中打开QQ群");
      MiniToast.makeText(paramString, 0, localStringBuilder.toString(), 1);
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
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      paramRequestEvent.ok(paramJSONObject);
      return;
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
      label90:
      break label90;
    }
    paramRequestEvent.fail("batchGetContact failed.");
  }
  
  @JsEvent({"getCloudTicket"})
  public void getCloudTicket(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = this.mApkgInfo.appId;
      localObject = ((JSONObject)localObject).optString("envId");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.mChannelProxy.getTcbTicket(str, (String)localObject, new DataJsPlugin.5(this, paramRequestEvent));
        return;
      }
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
      localJSONException.printStackTrace();
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
    if ((!MiniAppEnv.g().getAuthSate(this.mMiniAppContext.getMiniAppInfo().appId).isPermissionGranted("scope.userInfo")) && (!AuthFilterList.isAppInWhiteList(this.mMiniAppContext.getMiniAppInfo().appId)) && (!AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo())))
    {
      QMLog.e("DataJsPlugin", "getUserInfo已弃用，请使用createUserInfoButton");
      paramRequestEvent.evaluateCallbackJs(ApiUtil.wrapCallbackFail("getUserInfo", null, "getUserInfo已弃用，请使用createUserInfoButton").toString());
      return;
    }
    paramRequestEvent.evaluateCallbackJs(ApiUtil.wrapCallbackOk("getUserInfo", null).toString());
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
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    paramRequestEvent.ok(localJSONObject);
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
      if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null) && (str != null) && (str.equals(this.mMiniAppInfo.launchParam.entryModel.getEntryHash())) && (this.mMiniAppInfo.launchParam.entryModel.isAdmin) && (localObject != null) && (((String)localObject).contains("{{gid}}")))
      {
        startGroupBrowserActivity(((String)localObject).replace("{{gid}}", String.valueOf(this.mMiniAppInfo.launchParam.entryModel.uin)), paramRequestEvent);
        return;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getMiniAppInfo() != null))
    {
      this.mMiniAppInfo = this.mMiniAppContext.getMiniAppInfo();
      this.mApkgInfo = ((ApkgInfo)this.mMiniAppInfo.apkgInfo);
    }
  }
  
  @JsEvent({"operateAppAdData"})
  public void operateAppAdData(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("api_name");
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
      if ("getCardAd".equals(str))
      {
        webapiGetadvert(paramRequestEvent, localJSONObject, 5);
        return;
      }
      if ("getFeedsAd".equals(str))
      {
        webapiGetadvert(paramRequestEvent, localJSONObject, 6);
        return;
      }
      if ("getInterstitialAd".equals(str))
      {
        webapiGetadvert(paramRequestEvent, localJSONObject, 10);
        return;
      }
      if ("advert_tap".equals(str))
      {
        advertTap(paramRequestEvent);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      paramRequestEvent.fail("json exception");
      paramRequestEvent = new StringBuilder();
      paramRequestEvent.append("operateAppAdData. Exception: ");
      paramRequestEvent.append(Log.getStackTraceString(localJSONException));
      QMLog.d("DataJsPlugin", paramRequestEvent.toString());
    }
  }
  
  @JsEvent({"operateWXData"})
  public void operateWXData(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("data");
      str2 = localJSONObject.optString("api_name");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("operateWXData apiName: ");
      localStringBuilder.append(str2);
      QMLog.d("DataJsPlugin", localStringBuilder.toString());
      if ((!"webapi_getuserinfo".equals(str2)) && (!"webapi_getuserinfo_opendata".equals(str2)))
      {
        if ("webapi_wxa_subscribe_biz".equals(str2))
        {
          QMLog.e("DataJsPlugin", "webapi_wxa_subscribe_biz IN DEVELOPMENT");
          return;
        }
        if ("webapi_plugin_setauth".equals(str2))
        {
          webapiPluginSetAuth(paramRequestEvent, localJSONObject);
          return;
        }
        if ("webapi_plugin_login".equals(str2))
        {
          webapiPluginLogin(paramRequestEvent, localJSONObject);
          return;
        }
        if ("webapi_plugin_getuserinfo".equals(str2))
        {
          webapiPluginGetUserInfo(paramRequestEvent, localJSONObject);
          return;
        }
        if ("webapi_getnavigatewxaappinfo".equals(str2))
        {
          webapiGetnavigateWxaappinfo(paramRequestEvent, (JSONObject)localObject);
          return;
        }
        if ("webapi_getadvert".equals(str2))
        {
          webapiGetadvert(paramRequestEvent, localJSONObject, 2);
          return;
        }
        if ("advert_tap".equals(str2))
        {
          advertTap(paramRequestEvent);
          return;
        }
        if ("advert_report".equals(str2))
        {
          advertReport(paramRequestEvent);
          return;
        }
        if ("getBlockAd".equals(str2))
        {
          webapiGetadvert(paramRequestEvent, localJSONObject, 12);
          return;
        }
        if ("webapi_getshareinfo".equals(str2))
        {
          operateGetShareInfo(localJSONObject.optJSONObject("data").optString("shareTicket"), localJSONObject.optJSONObject("data").optInt("timeout", 0), paramRequestEvent);
          return;
        }
        if (!"webapi_getwerunstep_history".equals(str2)) {
          break label398;
        }
        webapiGetWerunStepHistory(paramRequestEvent);
        return;
      }
      bool = localJSONObject.optBoolean("with_credentials");
      localObject = localJSONObject.optString("lang", null);
      localJSONObject = localJSONObject.optJSONObject("data");
      if (localJSONObject != null) {
        localObject = localJSONObject.optString("lang", "en");
      } else {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label403;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject;
        String str2;
        boolean bool;
        label398:
        continue;
        label403:
        String str1 = "en";
      }
    }
    getUserInfo(paramRequestEvent, str2, bool, (String)localObject);
    return;
    paramRequestEvent.fail("json exception");
  }
  
  @JsEvent({"profile"})
  public void profile(RequestEvent paramRequestEvent)
  {
    try
    {
      paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("查看公众号: ");
      localStringBuilder.append(paramRequestEvent);
      QMLog.d("DataJsPlugin", localStringBuilder.toString());
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).jump2PublicAccount(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.optString("uin"), paramRequestEvent.optString("pubName")))
      {
        paramRequestEvent = this.mMiniAppContext.getAttachedActivity();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("暂不支持在");
        localStringBuilder.append(QUAUtil.getApplicationName(this.mContext));
        localStringBuilder.append("中打开公众号");
        MiniToast.makeText(paramRequestEvent, 0, localStringBuilder.toString(), 1);
        return;
      }
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
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      if (!this.mMiniAppProxy.enterQRCode(this.mMiniAppContext.getAttachedActivity(), ((JSONObject)localObject).optBoolean("onlyFromCamera", false), new DataJsPlugin.1(this, paramRequestEvent)))
      {
        localObject = this.mMiniAppContext.getAttachedActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("暂不支持在");
        localStringBuilder.append(QUAUtil.getApplicationName(this.mContext));
        localStringBuilder.append("中扫码二维码");
        MiniToast.makeText((Context)localObject, 0, localStringBuilder.toString(), 1);
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
      label147:
      break label147;
    }
    paramRequestEvent.fail("verifyPlugin failed.");
  }
  
  public void webapiGetadvert(RequestEvent paramRequestEvent, JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str = paramJSONObject.optJSONObject("data").optString("pos_id");
        if (!paramJSONObject.optJSONObject("data").has("adType")) {
          break label174;
        }
        paramInt = paramJSONObject.optJSONObject("data").optInt("adType");
        if (!paramJSONObject.optJSONObject("data").has("size")) {
          break label177;
        }
        i = paramJSONObject.optJSONObject("data").optInt("size");
        long l = Long.valueOf(LoginManager.getInstance().getAccount()).longValue();
        try
        {
          paramJSONObject = this.mMiniAppInfo.appId;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("webapi_getadvert getAppid = ");
          localStringBuilder.append(paramJSONObject);
          QMLog.d("DataJsPlugin", localStringBuilder.toString());
          if (TextUtils.isEmpty(paramJSONObject)) {
            break label173;
          }
          requestAdInfo(paramRequestEvent, str, paramInt, i, l, paramJSONObject);
          return;
        }
        catch (Exception paramJSONObject) {}
        paramRequestEvent.fail();
      }
      catch (Exception paramJSONObject) {}
      QMLog.e("DataJsPlugin", "webapiGetadvert. error", paramJSONObject);
      label173:
      return;
      label174:
      continue;
      label177:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin
 * JD-Core Version:    0.7.0.1
 */