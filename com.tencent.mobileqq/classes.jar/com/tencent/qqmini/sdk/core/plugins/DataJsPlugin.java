package com.tencent.qqmini.sdk.core.plugins;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import begz;
import behe;
import behf;
import beil;
import bejy;
import beka;
import bekg;
import bemw;
import besl;
import beuc;
import beyr;
import bfgt;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
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
  
  private void getGroupInfo(beka parambeka)
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
          if (this.mMiniAppInfo.launchParam.a != null) {
            bool1 = this.mMiniAppInfo.launchParam.a.jdField_a_of_type_Boolean;
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
    parambeka.a(localJSONObject);
  }
  
  private void getNativeUserInfo(beka parambeka)
  {
    if ((MiniAppEnv.g().getAuthSate(this.mMiniAppContext.a().appId).a("scope.userInfo")) || (behe.a(this.mMiniAppContext.a().appId)) || (behe.a(this.mMiniAppContext.a())))
    {
      parambeka.a(bekg.a("getUserInfo", null).toString());
      return;
    }
    besl.d("DataJsPlugin", "getUserInfo已弃用，请使用createUserInfoButton");
    parambeka.a(bekg.a("getUserInfo", null, "getUserInfo已弃用，请使用createUserInfoButton").toString());
  }
  
  private void getNativeWeRunData(beka parambeka)
  {
    parambeka.a();
  }
  
  private void getUserInfo(beka parambeka, String paramString1, boolean paramBoolean, String paramString2)
  {
    String str = this.mApkgInfo.d;
    besl.a("DataJsPlugin", "getUserInfo appID:" + str);
    this.mChannelProxy.getUserInfo(str, paramBoolean, paramString2, new DataJsPlugin.10(this, paramString1, parambeka));
  }
  
  private String handleGetTextLineHeight(beka parambeka)
  {
    try
    {
      Object localObject1 = new JSONObject(parambeka.b);
      String str2 = ((JSONObject)localObject1).optString("fontStyle");
      String str3 = ((JSONObject)localObject1).optString("fontWeight");
      String str4 = ((JSONObject)localObject1).optString("fontFamily");
      String str1 = ((JSONObject)localObject1).optString("text");
      int i = ((JSONObject)localObject1).getInt("fontSize");
      if ((!"normal".equals(str3)) && (!"bold".equals(str3)))
      {
        parambeka.a("fontWeight is illegal");
        return "";
      }
      if ((!"normal".equals(str2)) && (!"italic".equals(str2)))
      {
        parambeka.a("fontStyle is illegal");
        return "";
      }
      if (i <= 0)
      {
        parambeka.a("jsPluginEngine is illegal");
        return "";
      }
      if (TextUtils.isEmpty(str1))
      {
        parambeka.a("text is empty");
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
        parambeka.a("cannot create this font");
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
      parambeka.a();
      localObject1 = "" + ((Rect)localObject1).height();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      parambeka.a("json exception");
    }
    return "";
  }
  
  private void invokeGroupJSApi(beka parambeka)
  {
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      String str = ((JSONObject)localObject).optString("entryDataHash");
      localObject = ((JSONObject)localObject).optString("url");
      if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.a != null) && (str != null) && (str.equals(this.mMiniAppInfo.launchParam.a.a())) && (this.mMiniAppInfo.launchParam.a.jdField_a_of_type_Boolean) && (localObject != null) && (((String)localObject).contains("{{gid}}"))) {
        startGroupBrowserActivity(((String)localObject).replace("{{gid}}", String.valueOf(this.mMiniAppInfo.launchParam.a.jdField_a_of_type_Long)), parambeka);
      }
      return;
    }
    catch (JSONException parambeka)
    {
      parambeka.printStackTrace();
    }
  }
  
  private void operateGetShareInfo(String paramString, int paramInt, beka parambeka)
  {
    if (TextUtils.isEmpty(paramString))
    {
      parambeka.a("shareTicket can not be null");
      return;
    }
    Object localObject = new HandlerThread("getShareInfoHandlerThread");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper(), new DataJsPlugin.11(this, parambeka));
    ((Handler)localObject).sendEmptyMessageDelayed(1, paramInt);
    String str = this.mApkgInfo.d;
    this.mChannelProxy.getGroupShareInfo(str, paramString, new DataJsPlugin.12(this, parambeka, (Handler)localObject));
  }
  
  private void private_addContact(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      if (!this.mMiniAppProxy.addPublicAccount(beuc.a().a(), localJSONObject.optString("mpid"), new DataJsPlugin.2(this, parambeka)))
      {
        bemw.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bfgt.a(this.mContext) + "中关注公众号", 1);
        parambeka.b();
      }
      return;
    }
    catch (JSONException parambeka)
    {
      parambeka.printStackTrace();
    }
  }
  
  private void profile(beka parambeka)
  {
    try
    {
      parambeka = new JSONObject(parambeka.b);
      besl.a("DataJsPlugin", "查看公众号: " + parambeka);
      if (!this.mMiniAppProxy.jump2PublicAccount(this.mMiniAppContext.a(), parambeka.optString("uin"), parambeka.optString("pubName"))) {
        bemw.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bfgt.a(this.mContext) + "中打开公众号", 1);
      }
      return;
    }
    catch (JSONException parambeka)
    {
      besl.d("DataJsPlugin", "profile", parambeka);
      parambeka.printStackTrace();
    }
  }
  
  private void scanCode(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      if (!this.mMiniAppProxy.enterQRCode(this.mMiniAppContext.a(), localJSONObject.optBoolean("onlyFromCamera", false), new DataJsPlugin.1(this, parambeka)))
      {
        bemw.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bfgt.a(this.mContext) + "中扫码二维码", 1);
        parambeka.b();
      }
      return;
    }
    catch (Throwable parambeka) {}
  }
  
  private void startGroupBrowserActivity(String paramString, beka parambeka)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    paramString = new Bundle();
    paramString.putBoolean("hide_more_button", true);
    localIntent.putExtras(paramString);
    beil.a().a(new DataJsPlugin.13(this, parambeka));
    localMiniAppProxy.startBrowserActivityForResult(this.mMiniAppContext.a(), localIntent, 9);
  }
  
  public void batchGetContact(beka parambeka)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(parambeka.b).optJSONArray("appIds");
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
      this.mChannelProxy.batchGetContact(localArrayList, new DataJsPlugin.5(this, parambeka));
      return;
    }
    catch (Throwable localThrowable)
    {
      parambeka.a("batchGetContact failed.");
    }
  }
  
  public void getCloudTicket(beka parambeka)
  {
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      String str = this.mApkgInfo.d;
      localObject = ((JSONObject)localObject).optString("envId");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.mChannelProxy.getTcbTicket(str, (String)localObject, new DataJsPlugin.4(this, parambeka));
      }
      return;
    }
    catch (Throwable parambeka)
    {
      besl.d("DataJsPlugin", "API_GET_CLOUD_TICKET error, ", parambeka);
    }
  }
  
  public void getPerformance(beka parambeka)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", beyr.a(this.mMiniAppInfo.appId));
      parambeka.a(localJSONObject);
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
  
  public void getShareInfo(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      String str = localJSONObject.optString("shareTicket");
      int j = localJSONObject.optInt("timeout", 0);
      int i = j;
      if (j <= 0) {
        i = 30000;
      }
      operateGetShareInfo(str, i, parambeka);
      return;
    }
    catch (JSONException parambeka)
    {
      besl.d("DataJsPlugin", parambeka.getMessage(), parambeka);
      parambeka.printStackTrace();
    }
  }
  
  public void getUserInfoExtra(beka parambeka)
  {
    bejy localbejy = this.mApkgInfo;
    this.mChannelProxy.getUserInfoExtra(localbejy.d, new DataJsPlugin.9(this, parambeka));
  }
  
  public void operateWXData(beka parambeka)
  {
    Object localObject3;
    String str2;
    try
    {
      localObject3 = new JSONObject(parambeka.b);
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
          getUserInfo(parambeka, str2, bool, (String)localObject1);
          return;
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = "en";
          }
        }
      }
      if ("webapi_wxa_subscribe_biz".equals(str2))
      {
        besl.d("DataJsPlugin", "webapi_wxa_subscribe_biz IN DEVELOPMENT");
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      parambeka.a("json exception");
      return;
    }
    Object localObject2;
    if ("webapi_getnavigatewxaappinfo".equals(str2))
    {
      localObject2 = ((JSONObject)localObject3).optJSONObject("reqData").optString("target_appid");
      if ("1108291530".equals(this.mApkgInfo.d))
      {
        besl.a("DataJsPlugin", "MINI_APP_STORE skip checkNavigateRight");
        localObject2 = new JSONObject();
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("data", "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}");
          ((JSONObject)localObject2).put("respData", localObject3);
          parambeka.a((JSONObject)localObject2);
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
      this.mChannelProxy.checkNavigateRight(this.mApkgInfo.d, (String)localObject2, new DataJsPlugin.7(this, parambeka));
      return;
    }
    if ("webapi_getadvert".equals(str2))
    {
      besl.d("DataJsPlugin", "webapi_getadvert IN DEVELOPMENT");
      return;
    }
    if ("advert_tap".equals(str2))
    {
      besl.d("DataJsPlugin", "advert_tap IN DEVELOPMENT");
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
      operateGetShareInfo(str1, i, parambeka);
      return;
    }
    if ("webapi_getwerunstep_history".equals(str2))
    {
      localObject2 = this.mApkgInfo.d;
      this.mChannelProxy.getUserHealthData((String)localObject2, new DataJsPlugin.8(this, parambeka));
    }
  }
  
  public void reportSubmitForm(beka parambeka)
  {
    String str = this.mApkgInfo.d;
    this.mChannelProxy.getFormId(str, new DataJsPlugin.3(this, parambeka));
  }
  
  public void verifyPlugin(beka parambeka)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = new JSONObject(parambeka.b).optJSONObject("data").optJSONArray("plugins");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
          PluginInfo localPluginInfo = new PluginInfo();
          localPluginInfo.a(localJSONObject.optString("provider"));
          localPluginInfo.b(localJSONObject.optString("inner_version"));
          localArrayList.add(localPluginInfo);
          i += 1;
        }
      }
      localObject = this.mApkgInfo.d;
      this.mChannelProxy.verifyPlugin((String)localObject, localArrayList, new DataJsPlugin.6(this, parambeka));
      return;
    }
    catch (Throwable localThrowable)
    {
      parambeka.a("verifyPlugin failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin
 * JD-Core Version:    0.7.0.1
 */