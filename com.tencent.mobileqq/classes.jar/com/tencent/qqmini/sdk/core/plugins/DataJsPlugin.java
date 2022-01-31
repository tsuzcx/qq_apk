package com.tencent.qqmini.sdk.core.plugins;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import bglv;
import bgod;
import bgok;
import bgop;
import bgrm;
import bgxl;
import bhck;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.auth.AuthFilterList;
import com.tencent.qqmini.sdk.core.auth.AuthState;
import com.tencent.qqmini.sdk.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataJsPlugin
  extends BaseJsPlugin
{
  private static final String MINI_APP_STORE_APPID = "1108291530";
  private static final String TAG = "DataJsPlugin";
  private static final int WHAT_GET_SHARE_INFO_TIMEOUT = 1;
  private static final String fakeCheckNavigateRightRsp = "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}";
  private ChannelProxy mChannelProxy;
  private MiniAppProxy mMiniAppProxy;
  
  private void getGroupInfo(bgok parambgok)
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
    parambgok.a(localJSONObject);
  }
  
  private void getNativeUserInfo(bgok parambgok)
  {
    if ((MiniAppEnv.g().getAuthSate(this.mMiniAppContext.a().appId).isPermissionGranted("scope.userInfo")) || (AuthFilterList.isAppInWhiteList(this.mMiniAppContext.a().appId)) || (AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.a())))
    {
      parambgok.a(bgop.a("getUserInfo", null).toString());
      return;
    }
    QMLog.e("DataJsPlugin", "getUserInfo已弃用，请使用createUserInfoButton");
    parambgok.a(bgop.a("getUserInfo", null, "getUserInfo已弃用，请使用createUserInfoButton").toString());
  }
  
  private void getNativeWeRunData(bgok parambgok)
  {
    parambgok.a();
  }
  
  private void getUserInfo(bgok parambgok, String paramString1, boolean paramBoolean, String paramString2)
  {
    String str = this.mApkgInfo.appId;
    QMLog.d("DataJsPlugin", "getUserInfo appID:" + str);
    this.mChannelProxy.getUserInfo(str, paramBoolean, paramString2, new DataJsPlugin.11(this, paramString1, parambgok));
  }
  
  private String handleGetTextLineHeight(bgok parambgok)
  {
    try
    {
      Object localObject1 = new JSONObject(parambgok.b);
      String str2 = ((JSONObject)localObject1).optString("fontStyle");
      String str3 = ((JSONObject)localObject1).optString("fontWeight");
      String str4 = ((JSONObject)localObject1).optString("fontFamily");
      String str1 = ((JSONObject)localObject1).optString("text");
      int i = ((JSONObject)localObject1).getInt("fontSize");
      if ((!"normal".equals(str3)) && (!"bold".equals(str3)))
      {
        parambgok.a("fontWeight is illegal");
        return "";
      }
      if ((!"normal".equals(str2)) && (!"italic".equals(str2)))
      {
        parambgok.a("fontStyle is illegal");
        return "";
      }
      if (i <= 0)
      {
        parambgok.a("jsPluginEngine is illegal");
        return "";
      }
      if (TextUtils.isEmpty(str1))
      {
        parambgok.a("text is empty");
        return "";
      }
      Paint localPaint = new Paint();
      localPaint.setTextSize(i);
      Object localObject2 = null;
      if ("normal".equals(str2)) {
        if ("normal".equals(str3)) {
          localObject1 = Typeface.create(str4, 0);
        }
      }
      while (localObject1 == null)
      {
        parambgok.a("cannot create this font");
        return "";
        localObject1 = localObject2;
        if ("bold".equals(str3))
        {
          localObject1 = Typeface.create(str4, 1);
          continue;
          localObject1 = localObject2;
          if ("italic".equals(str2)) {
            if ("normal".equals(str3))
            {
              localObject1 = Typeface.create(str4, 2);
            }
            else
            {
              localObject1 = localObject2;
              if ("bold".equals(str3)) {
                localObject1 = Typeface.create(str4, 3);
              }
            }
          }
        }
      }
      localObject1 = new Rect();
      localPaint.getTextBounds(str1, 0, str1.length(), (Rect)localObject1);
      parambgok.a();
      localObject1 = "" + ((Rect)localObject1).height();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      parambgok.a("json exception");
    }
    return "";
  }
  
  private void invokeGroupJSApi(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      String str = ((JSONObject)localObject).optString("entryDataHash");
      localObject = ((JSONObject)localObject).optString("url");
      if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null) && (str != null) && (str.equals(this.mMiniAppInfo.launchParam.entryModel.getEntryHash())) && (this.mMiniAppInfo.launchParam.entryModel.isAdmin) && (localObject != null) && (((String)localObject).contains("{{gid}}"))) {
        startGroupBrowserActivity(((String)localObject).replace("{{gid}}", String.valueOf(this.mMiniAppInfo.launchParam.entryModel.uin)), parambgok);
      }
      return;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
  }
  
  private void operateGetShareInfo(String paramString, int paramInt, bgok parambgok)
  {
    if (TextUtils.isEmpty(paramString))
    {
      parambgok.a("shareTicket can not be null");
      return;
    }
    Object localObject = new HandlerThread("getShareInfoHandlerThread");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper(), new DataJsPlugin.12(this, parambgok));
    ((Handler)localObject).sendEmptyMessageDelayed(1, paramInt);
    String str = this.mApkgInfo.appId;
    this.mChannelProxy.getGroupShareInfo(str, paramString, new DataJsPlugin.13(this, parambgok, (Handler)localObject));
  }
  
  private void private_addContact(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).addPublicAccount(bgxl.a().a(), localJSONObject.optString("mpid"), new DataJsPlugin.2(this, parambgok)))
      {
        bgrm.a(this.mMiniAppContext.a(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中关注公众号", 1);
        parambgok.b();
      }
      return;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
  }
  
  private void profile(bgok parambgok)
  {
    try
    {
      parambgok = new JSONObject(parambgok.b);
      QMLog.d("DataJsPlugin", "查看公众号: " + parambgok);
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).jump2PublicAccount(this.mMiniAppContext.a(), parambgok.optString("uin"), parambgok.optString("pubName"))) {
        bgrm.a(this.mMiniAppContext.a(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中打开公众号", 1);
      }
      return;
    }
    catch (JSONException parambgok)
    {
      QMLog.e("DataJsPlugin", "profile", parambgok);
      parambgok.printStackTrace();
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
  
  private void scanCode(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      if (!this.mMiniAppProxy.enterQRCode(this.mMiniAppContext.a(), localJSONObject.optBoolean("onlyFromCamera", false), new DataJsPlugin.1(this, parambgok)))
      {
        bgrm.a(this.mMiniAppContext.a(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中扫码二维码", 1);
        parambgok.b();
      }
      return;
    }
    catch (Throwable parambgok) {}
  }
  
  private void startGroupBrowserActivity(String paramString, bgok parambgok)
  {
    if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openGroup(this.mMiniAppContext.a(), paramString, new DataJsPlugin.14(this, parambgok)))
    {
      bgrm.a(this.mContext, 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中打开QQ群", 1);
      parambgok.a("app not implement");
    }
  }
  
  public void advertTap(bgok parambgok)
  {
    for (;;)
    {
      try
      {
        String str = new JSONObject(parambgok.b).getJSONObject("data").getJSONObject("data").get("ads_info").toString();
        AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
        if (localAdProxy != null)
        {
          bool = localAdProxy.adClick(this.mMiniAppContext.a(), str);
          if (bool)
          {
            parambgok.a();
            return;
          }
          parambgok.b();
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("DataJsPlugin", "advert_tap, data is wrong " + parambgok.b);
        return;
      }
      boolean bool = false;
    }
  }
  
  public void batchGetContact(bgok parambgok)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambgok.b).optJSONArray("appIds");
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
      this.mChannelProxy.batchGetContact(localArrayList, new DataJsPlugin.5(this, parambgok));
      return;
    }
    catch (Throwable localThrowable)
    {
      parambgok.a("batchGetContact failed.");
    }
  }
  
  public void getCloudTicket(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      String str = this.mApkgInfo.appId;
      localObject = ((JSONObject)localObject).optString("envId");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.mChannelProxy.getTcbTicket(str, (String)localObject, new DataJsPlugin.4(this, parambgok));
      }
      return;
    }
    catch (Throwable parambgok)
    {
      QMLog.e("DataJsPlugin", "API_GET_CLOUD_TICKET error, ", parambgok);
    }
  }
  
  public void getPerformance(bgok parambgok)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", bhck.a(this.mMiniAppInfo.appId));
      parambgok.a(localJSONObject);
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
  
  public void getShareInfo(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      String str = localJSONObject.optString("shareTicket");
      int j = localJSONObject.optInt("timeout", 0);
      int i = j;
      if (j <= 0) {
        i = 30000;
      }
      operateGetShareInfo(str, i, parambgok);
      return;
    }
    catch (JSONException parambgok)
    {
      QMLog.e("DataJsPlugin", parambgok.getMessage(), parambgok);
      parambgok.printStackTrace();
    }
  }
  
  public void getUserInfoExtra(bgok parambgok)
  {
    bgod localbgod = this.mApkgInfo;
    this.mChannelProxy.getUserInfoExtra(localbgod.appId, new DataJsPlugin.9(this, parambgok));
  }
  
  public void operateWXData(bgok parambgok)
  {
    Object localObject3;
    String str2;
    try
    {
      localObject3 = new JSONObject(parambgok.b);
      Object localObject1 = ((JSONObject)localObject3).optJSONObject("data");
      str2 = ((JSONObject)localObject1).optString("api_name");
      if (("webapi_getuserinfo".equals(str2)) || ("webapi_getuserinfo_opendata".equals(str2)))
      {
        boolean bool = ((JSONObject)localObject1).optBoolean("with_credentials");
        localObject3 = ((JSONObject)localObject1).optString("lang", null);
        localObject1 = ((JSONObject)localObject1).optJSONObject("data");
        if (localObject1 != null) {
          localObject1 = ((JSONObject)localObject1).optString("lang", "en");
        }
        for (;;)
        {
          getUserInfo(parambgok, str2, bool, (String)localObject1);
          return;
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = "en";
          }
        }
      }
      if ("webapi_wxa_subscribe_biz".equals(str2))
      {
        QMLog.e("DataJsPlugin", "webapi_wxa_subscribe_biz IN DEVELOPMENT");
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      parambgok.a("json exception");
      return;
    }
    Object localObject2;
    if ("webapi_getnavigatewxaappinfo".equals(str2))
    {
      localObject2 = ((JSONObject)localObject3).optJSONObject("reqData").optString("target_appid");
      if ("1108291530".equals(this.mApkgInfo.appId))
      {
        QMLog.d("DataJsPlugin", "MINI_APP_STORE skip checkNavigateRight");
        localObject2 = new JSONObject();
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("data", "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}");
          ((JSONObject)localObject2).put("respData", localObject3);
          parambgok.a((JSONObject)localObject2);
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
      }
      this.mChannelProxy.checkNavigateRight(this.mApkgInfo.appId, (String)localObject2, new DataJsPlugin.7(this, parambgok));
      return;
    }
    if ("webapi_getadvert".equals(str2))
    {
      webapiGetadvert(parambgok, (JSONObject)localObject2);
      return;
    }
    if ("advert_tap".equals(str2))
    {
      advertTap(parambgok);
      return;
    }
    if ("webapi_getshareinfo".equals(str2))
    {
      String str1 = ((JSONObject)localObject2).optJSONObject("data").optString("shareTicket");
      int j = ((JSONObject)localObject2).optJSONObject("data").optInt("timeout", 0);
      int i = j;
      if (j <= 0) {
        i = 30000;
      }
      operateGetShareInfo(str1, i, parambgok);
      return;
    }
    if ("webapi_getwerunstep_history".equals(str2))
    {
      localObject2 = this.mApkgInfo.appId;
      this.mChannelProxy.getUserHealthData((String)localObject2, new DataJsPlugin.8(this, parambgok));
    }
  }
  
  public void reportSubmitForm(bgok parambgok)
  {
    String str = this.mApkgInfo.appId;
    this.mChannelProxy.getFormId(str, new DataJsPlugin.3(this, parambgok));
  }
  
  public void verifyPlugin(bgok parambgok)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = new JSONObject(parambgok.b).optJSONObject("data").optJSONArray("plugins");
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
      this.mChannelProxy.verifyPlugin((String)localObject, localArrayList, new DataJsPlugin.6(this, parambgok));
      return;
    }
    catch (Throwable localThrowable)
    {
      parambgok.a("verifyPlugin failed.");
    }
  }
  
  public void webapiGetadvert(bgok parambgok, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        String str4 = paramJSONObject.optJSONObject("data").optString("pos_id");
        int i = 2;
        if (paramJSONObject.optJSONObject("data").has("adType")) {
          i = paramJSONObject.optJSONObject("data").optInt("adType");
        }
        long l = Long.valueOf(bgxl.a().a()).longValue();
        String str5 = this.mMiniAppInfo.appId;
        QMLog.d("DataJsPlugin", "webapi_getadvert getAppid = " + str5);
        if (!TextUtils.isEmpty(str5))
        {
          String str6 = AdUtil.getSpAdGdtCookie(i);
          MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
          String str2 = "";
          Object localObject2 = "";
          String str3 = "";
          paramJSONObject = str2;
          localObject1 = localObject2;
          String str1 = str3;
          if (localMiniAppInfo != null)
          {
            paramJSONObject = str2;
            localObject1 = localObject2;
            str1 = str3;
            if (localMiniAppInfo.launchParam != null)
            {
              if (localMiniAppInfo.launchParam.entryPath == null) {
                break label310;
              }
              paramJSONObject = localMiniAppInfo.launchParam.entryPath;
              if (localMiniAppInfo.launchParam == null) {
                break label316;
              }
              localObject1 = localMiniAppInfo.launchParam.reportData;
              str1 = String.valueOf(localMiniAppInfo.launchParam.scene);
            }
          }
          if ((localMiniAppInfo != null) && (localMiniAppInfo.via != null))
          {
            str2 = localMiniAppInfo.via;
            localObject2 = (AdProxy)ProxyManager.get(AdProxy.class);
            if (localObject2 != null) {
              ((AdProxy)localObject2).requestAdInfo(this.mMiniAppContext.a(), String.valueOf(l), str4, str5, 53, 0, i, str6, paramJSONObject, (String)localObject1, str1, str2, new DataJsPlugin.10(this, parambgok, i));
            }
          }
          else
          {
            str2 = "";
            continue;
          }
        }
        return;
      }
      catch (Exception parambgok)
      {
        parambgok.printStackTrace();
      }
      label310:
      paramJSONObject = "";
      continue;
      label316:
      Object localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin
 * JD-Core Version:    0.7.0.1
 */