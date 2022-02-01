package com.tencent.mobileqq.vaswebviewplugin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import anni;
import arpd;
import arph;
import bcnj;
import bdoq;
import bdpc;
import bdpp;
import bdps;
import bdpt;
import bdpu;
import bdpw;
import bdqe;
import bgpa;
import bhba;
import bhod;
import biau;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.theme.diy.ThemeDIYActivity;
import com.tencent.mobileqq.theme.diy.ThemeDiyModule;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "theme";
  public static final byte REQUEST_CODE = 1;
  private static final String SAVE_DIY_THEME = "saveDiyTheme";
  public static final String TAG = "ThemeJsPlugin";
  static final int THEME_OPTION_ERROR = -1;
  static final int THEME_OPTION_FILE_LOSE_ERROR = 4;
  static final int THEME_OPTION_PKG_NOT_EXISTS = 1;
  static final int THEME_OPTION_PKG_UNZIP_ERROR = 2;
  static final int THEME_OPTION_SAVE_THEMEINFO_ERROR = 3;
  static final int THEME_OPTION_SET_SV_ERROR = 5;
  static final int THEME_OPTION_SUCCESS = 0;
  private static final String XM_3 = "Xiaomi_MI 3";
  public static String loadingThemeIdForJsCall;
  public BrowserAppInterface app;
  public Context context;
  private String currDownloadingThemeId;
  long currentTimeMillis = 0L;
  bgpa dialog;
  private ConcurrentHashMap<String, ThemeUtil.ThemeInfo> downloadThemeMap = new ConcurrentHashMap();
  String mCallbackId;
  private String mCurrentMethodName;
  Object mLock = new Object();
  bdqe mThemeDiyImpl = new ThemeJsPlugin.2(this);
  private ThemeDiyModule mThemeDiyModule;
  bdpu mThemeSwitchManager;
  ThemeUtil.ThemeInfo mThemeinfo;
  HashMap<Integer, String> reportMap = new HashMap();
  View rootView;
  public biau themeSwitchDialog;
  
  public ThemeJsPlugin()
  {
    this.mPluginNameSpace = "theme";
  }
  
  public void diyThemeSetup(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("id", paramString1);
        if ((!"999".equals(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
          continue;
        }
        localJSONObject.put("version", "20000000");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      setup(localJSONObject, paramString3, this.mThemeDiyModule.getAuthReqBundle(paramString1, paramString2), true);
      return;
      localJSONObject.put("version", paramString2);
    }
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramLong == 128L)
    {
      paramString = paramMap.get("intent");
      if ((paramString != null) && ((paramString instanceof Intent)))
      {
        paramString = ((Intent)paramString).getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (this.mCallbackId != null) {
          this.mThemeDiyModule.albumCallback(paramString, this.mCallbackId);
        }
      }
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        if (paramLong == 8589934604L)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, "EVENT_THEME_POSTCHANGED");
          }
          onPostThemeChanged();
          return true;
        }
        bool1 = bool2;
      } while (paramLong == 8589934593L);
      bool1 = bool2;
    } while (8589934600L != paramLong);
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 2147483680L;
  }
  
  void gotoDownload(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (paramInt < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "not wifi network cancel download dialog=" + this.dialog);
      }
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("result", 2);
        ((JSONObject)localObject1).put("message", "user cancel download theme in not wifi network");
        callJs(paramString3, new String[] { ((JSONObject)localObject1).toString() });
        reportTheme(null, 0, paramString1, 0L, "VipThemeMallDowned", "Cancel", "200", 153, bdpt.a, 10, paramString2, "");
        return;
      }
      catch (Exception paramString1)
      {
        do
        {
          QLog.e("ThemeJsPlugin", 2, "gotoDownload isCancel err:" + paramString1.getMessage());
        } while ((paramInt != -1) || (this.dialog == null));
        this.dialog.dismiss();
        return;
      }
      finally
      {
        if ((paramInt == -1) && (this.dialog != null)) {
          this.dialog.dismiss();
        }
      }
    }
    Object localObject2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(paramString1);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ThemeUtil.getThemeInfo(this.context, paramString1);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ThemeUtil.ThemeInfo();
      ((ThemeUtil.ThemeInfo)localObject2).themeId = paramString1;
    }
    ((ThemeUtil.ThemeInfo)localObject2).isVoiceTheme = paramBoolean;
    ThemeUtil.setThemeInfo(this.context, (ThemeUtil.ThemeInfo)localObject2);
    this.downloadThemeMap.put(paramString1, localObject2);
    this.currDownloadingThemeId = paramString1;
    loadingThemeIdForJsCall = paramString1;
    reportTheme(null, 0, paramString1, 0L, null, null, "200", 153, bdpt.a, 11, paramString2, "");
    QuickUpdateIPCModule.a(3L, ThemeUtil.getThemeConfigID(paramString1), new ThemeJsPlugin.8(this, paramString3));
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString1 == null) || (!"theme".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    this.mCurrentMethodName = paramString3;
    if (QLog.isColorLevel()) {
      QLog.d("ThemeJsPlugin", 2, "handleJsRequest themejs, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    try
    {
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramJsBridgeListener == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
      }
      paramVarArgs = paramJsBridgeListener.optString("callback");
      if (TextUtils.isEmpty(paramVarArgs))
      {
        QLog.e("ThemeJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      if ("queryInfo".equals(paramString3))
      {
        bdpp.a(paramJsBridgeListener.optString("id"), new ThemeJsPlugin.9(this, paramJsBridgeListener, paramVarArgs));
      }
      else if ("queryLocal".equals(paramString3))
      {
        paramJsBridgeListener = new Bundle();
        paramJsBridgeListener.putString("themeId", this.currDownloadingThemeId);
        sendRemoteReq(arph.a("themeQueryLocal", paramVarArgs, this.mOnRemoteResp.key, paramJsBridgeListener), false, true);
      }
    }
    catch (Throwable paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
      QLog.e("ThemeJsPlugin", 2, "handleJsRequest exception url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3 + ", msg=" + paramJsBridgeListener.getMessage());
    }
    int i;
    int j;
    if ("setup".equals(paramString3))
    {
      setup(paramJsBridgeListener, paramVarArgs, null, false);
    }
    else if ("startDownload".equals(paramString3))
    {
      startDownload(paramJsBridgeListener, paramVarArgs);
    }
    else
    {
      Object localObject;
      if ("stopDownload".equals(paramString3))
      {
        paramJsBridgeListener = paramJsBridgeListener.optString("id");
        localObject = new Bundle();
        ((Bundle)localObject).putString("themeId", paramJsBridgeListener);
        if ((TextUtils.isEmpty(paramJsBridgeListener)) && (paramJsBridgeListener.equals(this.currDownloadingThemeId))) {
          this.currDownloadingThemeId = "";
        }
        super.sendRemoteReq(arph.a("stopdownload", paramVarArgs, this.mOnRemoteResp.key, (Bundle)localObject), false, true);
      }
      else if ("openDiyTheme".equals(paramString3))
      {
        if (System.currentTimeMillis() - this.currentTimeMillis > 2000L)
        {
          reportTheme("theme_goto_diytheme", 0, "999", 0L, "VipThemeMallGoToDiy", "0", "201", 150, "0", 0, "", "");
          loadingThemeIdForJsCall = "IN_DIY_THEME";
          this.currentTimeMillis = System.currentTimeMillis();
          super.startActivityForResult(new Intent(this.mRuntime.a(), ThemeDIYActivity.class), (byte)1);
        }
        else
        {
          reportTheme("theme_goto_diytheme", 0, "999", 0L, "VipThemeMallGoToDiy", "1", "201", 150, "1", 0, "", "");
        }
      }
      else if ("getDensity".equals(paramString3))
      {
        paramJsBridgeListener = ThemeUtil.getThemeDensity(this.context);
        localObject = new JSONObject();
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "getDensity density:" + paramJsBridgeListener);
        }
        ((JSONObject)localObject).put("result", 0);
        ((JSONObject)localObject).put("density", paramJsBridgeListener);
        ((JSONObject)localObject).put("message", "returnt density " + paramJsBridgeListener);
        super.callJs(paramVarArgs, new String[] { ((JSONObject)localObject).toString() });
      }
      else if ("queryWeekLoopInfo".equals(paramString3))
      {
        paramJsBridgeListener = new Bundle();
        sendRemoteReq(arph.a("weekLoopGetData", paramVarArgs, this.mOnRemoteResp.key, paramJsBridgeListener), false, true);
      }
      else
      {
        boolean bool;
        if ("isSupportDynamic".equals(paramString3))
        {
          i = 1;
          j = 1;
          paramJsBridgeListener = new Bundle();
          bool = bdpu.a(paramJsBridgeListener);
          if (bool)
          {
            if ((!paramJsBridgeListener.getBoolean("dynamic_switch", true)) || (!paramJsBridgeListener.getBoolean("dynamic_enable", true))) {
              break label1405;
            }
            i = 1;
            if ((!paramJsBridgeListener.getBoolean("dynamic_webview_enable", true)) || (i != 1)) {
              break label1411;
            }
            j = 1;
          }
          label827:
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("result", 0);
          paramJsBridgeListener.put("isDeviceEnable", i);
          paramJsBridgeListener.put("isWebviewEnable", j);
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, "isSupportDynamic deviceEnable:" + i + ", webViewEnable:" + j + ", dpcIsOk=" + bool);
          }
          localObject = new JSONObject();
          ((JSONObject)localObject).put("result", 0);
          ((JSONObject)localObject).put("message", "isSupportDynamic return deviceEnable:" + i + ", webViewEnable:" + j + ", dpcIsOk=" + bool);
          ((JSONObject)localObject).put("data", paramJsBridgeListener);
          super.callJs(paramVarArgs, new String[] { ((JSONObject)localObject).toString() });
        }
        else if ("saveDiyTheme".equals(paramString3))
        {
          this.mCallbackId = paramVarArgs;
          this.mThemeDiyModule.saveDiyTheme(paramJsBridgeListener, paramVarArgs);
        }
        else if ("getDiyCurThemeInfo".equals(paramString3))
        {
          super.callJs(paramVarArgs, new String[] { this.mThemeDiyModule.getDiyCurThemeInfo().toString() });
        }
        else if ("openAlbum".equals(paramString3))
        {
          this.mCallbackId = paramVarArgs;
          this.mThemeDiyModule.openAlbum(getInfoIntent(), this.mRuntime.a(), paramJsBridgeListener.optInt("tabType"), getRequestCode((byte)1));
        }
        else if ("checkSimpleUISwitch".equals(paramString3))
        {
          bool = bcnj.b();
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, String.format("%s checkSimpleUISwitch bSwitch=%b callback=%s", new Object[] { "SimpleUILog", Boolean.valueOf(bool), paramVarArgs }));
          }
          if (!bool) {
            break label1417;
          }
          paramJsBridgeListener = "1";
          label1200:
          super.callJs(paramVarArgs, new String[] { paramJsBridgeListener });
        }
        else if ("isSysCustomFont".equals(paramString3))
        {
          bool = TextHook.isSysCustomFont(this.mRuntime.a());
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, "isSysCustomFont:" + bool);
          }
          if (!bool) {
            break label1424;
          }
        }
      }
    }
    label1411:
    label1417:
    label1424:
    for (paramJsBridgeListener = "1";; paramJsBridgeListener = "0")
    {
      super.callJs(paramVarArgs, new String[] { paramJsBridgeListener });
      break label1403;
      if ("setupfont".equals(paramString3))
      {
        bhba.b(paramJsBridgeListener.optInt("themefontid"));
        paramJsBridgeListener = new JSONObject();
        paramJsBridgeListener.put("result", 1);
        super.callJs(paramVarArgs, new String[] { paramJsBridgeListener.toString() });
      }
      else
      {
        QLog.e("ThemeJsPlugin", 2, "handleJsRequest error url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
      }
      label1403:
      return true;
      label1405:
      i = 0;
      break;
      j = 0;
      break label827;
      paramJsBridgeListener = "0";
      break label1200;
    }
  }
  
  public void onCreate()
  {
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.app = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.mThemeSwitchManager = new bdpu(this.app);
    this.context = this.mRuntime.a().getApplicationContext();
    this.mThemeDiyModule = new ThemeDiyModule(this.context, this.app);
    this.mThemeDiyModule.setThemeDiyImpl(this.mThemeDiyImpl);
    super.onCreate();
    this.rootView = this.mRuntime.a().getWindow().getDecorView().getRootView();
    QLog.d("ThemeJsPlugin", 1, "onCreate, nowThemeId=" + ThemeUtil.getCurrentThemeId() + ", userThemeId=" + ThemeUtil.getUserCurrentThemeId(this.app));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  @SuppressLint({"NewApi"})
  public void onPostThemeChanged()
  {
    if (QLog.isColorLevel())
    {
      if (loadingThemeIdForJsCall != null) {
        QLog.d("ThemeJsPlugin", 2, "ThemeDebugKeyLog:switch to themeid " + loadingThemeIdForJsCall);
      }
    }
    else
    {
      if (this.rootView != null) {
        break label82;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "titleView is null");
      }
    }
    for (;;)
    {
      this.mThemeSwitchManager.c();
      return;
      QLog.d("ThemeJsPlugin", 2, "ThemeDebugKeyLog:switch ok");
      break;
      label82:
      String str = Build.MANUFACTURER + "_" + Build.MODEL;
      if ((Build.VERSION.SDK_INT >= 16) && (str.contains("Xiaomi_MI 3"))) {
        this.rootView.setLayerType(1, null);
      }
      if ((this.themeSwitchDialog != null) && (this.themeSwitchDialog.isShowing())) {
        this.themeSwitchDialog.dismiss();
      }
    }
  }
  
  void onPushMsg(Bundle paramBundle)
  {
    int i = paramBundle.getInt("result");
    if (paramBundle.getInt("type") == 2)
    {
      int j = paramBundle.getInt("id");
      paramBundle = paramBundle.getString("url");
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "DOWNLOAD_BACKGROUND:" + j + ", themeId" + j + ", bgPath:" + paramBundle);
      }
      if (i != 0)
      {
        callJs(this.mCallbackId, new String[] { new bdpc(-1, "bg image download failed").a() });
        this.mCallbackId = null;
      }
    }
    else
    {
      return;
    }
    this.mThemeDiyModule.trySaveDefineImage(this.mCallbackId);
  }
  
  public void onResponse(Bundle arg1)
  {
    boolean bool = false;
    int i;
    String str1;
    String str2;
    Object localObject1;
    if (??? != null)
    {
      i = ???.getInt("respkey", 0);
      str1 = ???.getString("cmd");
      str2 = ???.getString("callbackid");
      localObject1 = ???.getBundle("response");
      if (localObject1 != null) {
        break label48;
      }
    }
    label48:
    Object localObject3;
    do
    {
      do
      {
        return;
      } while (i != this.mOnRemoteResp.key);
      i = ???.getInt("failcode", 1000);
      if ((TextUtils.isEmpty(str1)) || (QLog.isColorLevel()) || (1001 == i))
      {
        localObject3 = new StringBuilder().append("response:").append(str1).append(", backCode=").append(i).append(", isTimeOut=");
        if (1001 == i) {
          bool = true;
        }
        QLog.d("ThemeJsPlugin", 2, bool);
      }
    } while (TextUtils.isEmpty(str1));
    try
    {
      if ("stopdownload".equals(str1))
      {
        ??? = new JSONObject();
        ???.put("result", 0);
        ???.put("message", "Download process paused.");
        super.callJs(str2, new String[] { ???.toString() });
        return;
      }
    }
    catch (Throwable ???)
    {
      QLog.e("ThemeJsPlugin", 1, "onResponse Throwable cmd:" + str1 + ", msg：" + QLog.getStackTraceString(???));
      callJsOnError(str2, ???.getMessage());
      return;
    }
    if ("weekLoopGetData".equals(str1))
    {
      ??? = new JSONObject();
      ???.put("result", 0);
      localObject3 = ((Bundle)localObject1).getString("seriesID");
      localObject1 = ((Bundle)localObject1).getString("themeArray");
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "IPC_THEME_WEEK_LOOP_GET respone seriesID:" + (String)localObject3 + ", themeArr:" + (String)localObject1);
      }
      ???.put("seriesID", localObject3);
      ???.put("themeArray", localObject1);
      ???.put("message", "useSeriesID is " + (String)localObject3);
      super.callJs(str2, new String[] { ???.toString() });
      return;
    }
    if ("themeQueryLocal".equals(str1))
    {
      ??? = new JSONObject();
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("localInfo", new JSONObject(((Bundle)localObject1).getString("themeId")));
      ((JSONObject)localObject3).put("currentId", ThemeUtil.getCurrentThemeId());
      i = ThemeUtil.getUinThemePreferences(this.app).getInt("stripUserTheme", 0);
      if (i != 0) {
        ThemeUtil.getUinThemePreferences(this.app).edit().remove("stripUserTheme").commit();
      }
      ???.put("result", 0);
      ???.put("message", "ok");
      ???.put("data", localObject3);
      ???.put("authResult", i);
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler queryLocal ok:" + ???.toString());
      }
      callJs(str2, new String[] { ???.toString() });
      return;
    }
    if ("setSVTheme".equals(str1))
    {
      localObject3 = ((Bundle)localObject1).getString("themeId");
      i = ((Bundle)localObject1).getInt("themeStatus", -1);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "IPC_THEME_SET_SERVER respone themeId:" + (String)localObject3 + ", ret:" + i);
      }
      if (i == 0) {
        for (;;)
        {
          synchronized (this.mLock)
          {
            if ((!TextUtils.isEmpty(str2)) && (str2.equals(this.mCallbackId)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (this.mThemeinfo != null) && (((String)localObject3).equals(this.mThemeinfo.themeId)) && (!bdoq.a(this.mRuntime.a(), (String)localObject3, new ThemeJsPlugin.10(this, (String)localObject3))))
            {
              if (!bcnj.b())
              {
                this.mThemeDiyModule.setSpThemeBackground();
                bdpp.a((String)localObject3, new ThemeJsPlugin.ThemeSwitchListener(this, (String)localObject3, true));
              }
            }
            else {
              return;
            }
          }
          if (!ThemeUtil.isFixTheme((String)localObject3)) {
            bdpw.a(this.app, (String)localObject3, "20000000");
          }
          new ThemeJsPlugin.ThemeSwitchListener(this, (String)localObject3, false).postSwitch(0);
        }
      }
      if ("saveDiyTheme".equals(this.mCurrentMethodName))
      {
        super.callJs(str2, new String[] { new bdpc(???.getInt("result_int"), anni.a(2131713613)).a() });
        return;
      }
      ??? = new JSONObject();
      ???.put("themeId", localObject3);
      ???.put("result", 5);
      ???.put("message", "setup theme setSV error.");
      super.callJs(str2, new String[] { ???.toString() });
      return;
    }
    super.onResponse(???);
  }
  
  public void queryInfo(JSONObject paramJSONObject, String paramString, bdps parambdps)
  {
    for (;;)
    {
      String str;
      Object localObject;
      try
      {
        str = paramJSONObject.optString("id");
        if (!TextUtils.isEmpty(str)) {
          break label616;
        }
        QLog.e("ThemeJsPlugin", 1, "queryInfo err themeId=null：" + str);
        str = "1000";
        localObject = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(str);
        paramJSONObject = (JSONObject)localObject;
        if ("1000".equals(str)) {
          break label610;
        }
        if (localObject != null) {
          break label620;
        }
        paramJSONObject = ThemeUtil.getThemeInfo(this.context, str);
        if ((parambdps != null) && (parambdps.a())) {
          break label610;
        }
        QLog.e("ThemeJsPlugin", 1, "queryInfo zip is missing: " + parambdps);
        ThemeUtil.removeThemeInfo(this.context, str);
        i = 0;
        paramJSONObject = null;
        parambdps = new JSONObject();
        parambdps.put("result", 0);
        parambdps.put("message", "ok");
        localObject = new JSONObject();
        if ("1000".equals(str))
        {
          ((JSONObject)localObject).put("status", Integer.parseInt("3"));
          ((JSONObject)localObject).put("version", 0);
          ((JSONObject)localObject).put("progress", 100);
          parambdps.put("data", localObject);
          super.callJs(paramString, new String[] { parambdps.toString() });
          if (!QLog.isColorLevel()) {
            break label619;
          }
          QLog.i("ThemeJsPlugin", 2, "queryInfo,themeId=" + str + "result=" + parambdps.toString());
          return;
        }
        if (paramJSONObject == null)
        {
          ((JSONObject)localObject).put("status", Integer.parseInt("1"));
          ((JSONObject)localObject).put("version", 0);
          ((JSONObject)localObject).put("progress", 0);
          continue;
        }
        if (!"2".equals(paramJSONObject.status)) {
          break label443;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("ThemeJsPlugin", 1, "queryInfo Exception：" + paramJSONObject.getMessage());
        super.callJsOnError(paramString, paramJSONObject.getMessage());
        reportTheme(null, 0, "", 0L, null, null, "200", 152, bdpt.a, -35, "1", "");
        return;
      }
      if (i != 0)
      {
        if (!str.equals(this.currDownloadingThemeId)) {
          paramJSONObject.status = "4";
        }
        label443:
        if ("5".equals(paramJSONObject.status)) {
          paramJSONObject.status = "3";
        }
        ((JSONObject)localObject).put("status", Integer.parseInt(paramJSONObject.status));
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "queryInfo downsize:" + paramJSONObject.downsize + ",size:" + paramJSONObject.size);
        }
        if (paramJSONObject.size <= 0L) {
          break label604;
        }
      }
      label604:
      for (int i = (int)Math.floor(paramJSONObject.downsize * 1.0D / paramJSONObject.size * 100.0D);; i = 0)
      {
        i = Math.min(i, 100);
        ((JSONObject)localObject).put("version", paramJSONObject.version);
        ((JSONObject)localObject).put("progress", i);
        break;
        paramJSONObject.status = "1";
        break label443;
      }
      label610:
      i = 0;
      continue;
      label616:
      continue;
      label619:
      return;
      label620:
      i = 1;
      paramJSONObject = (JSONObject)localObject;
    }
  }
  
  void reportTheme(String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, String paramString8)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new ThemeJsPlugin.1(this, paramString2, paramInt1, paramString1, paramLong, paramString3, paramString4, paramString5, paramInt2, paramInt3, paramString7, paramString8, paramString6), 2000L);
  }
  
  public void setup(JSONObject paramJSONObject, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject1 = "201";; localObject1 = "200")
    {
      String str1;
      String str2;
      String str3;
      JSONArray localJSONArray;
      long l;
      for (;;)
      {
        try
        {
          str1 = paramJSONObject.optString("id");
          str2 = paramJSONObject.optString("version", "0");
          int i = paramJSONObject.optInt("isSound", 0);
          str3 = paramJSONObject.optString("seriesID", null);
          localJSONArray = paramJSONObject.optJSONArray("themeArray");
          l = paramJSONObject.optLong("startTime", 0L);
          if ((TextUtils.isEmpty(str1)) || ((!TextUtils.isEmpty(str3)) && ((localJSONArray == null) || (localJSONArray.length() < 1))))
          {
            QLog.e("ThemeJsPlugin", 1, "ThemeJsHandler setup setWeekLoopThemeArray err,seriesID=" + str3 + ",themeArray=" + localJSONArray);
            paramJSONObject = new JSONObject();
            paramJSONObject.put("result", 1);
            paramJSONObject.put("message", "seriesID || themeArray data error");
            super.callJs(paramString, new String[] { paramJSONObject.toString() });
            reportTheme(null, 0, str1, 0L, null, null, (String)localObject1, 155, bdpt.a, -8, str2, "");
            return;
          }
          paramJSONObject = ThemeUtil.getCurrentThemeId();
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler setup,themeId=" + str1 + ",version=" + str2 + ",isSound=" + i + " isDiyTheme:" + paramBoolean + " currentThemeId:" + paramJSONObject);
          }
          if ((!str1.equals(paramJSONObject)) || (paramBoolean)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler setup the same theme,themeId=" + str1 + ",version=" + str2);
          }
          paramJSONObject = new JSONObject();
          paramJSONObject.put("result", 0);
          paramJSONObject.put("message", "set the same theme");
          super.callJs(paramString, new String[] { paramJSONObject.toString() });
          if (this.reportMap.containsKey(Integer.valueOf((str1 + "_" + str2).hashCode())))
          {
            paramJSONObject = (String)this.reportMap.get(Integer.valueOf((str1 + "_" + str2).hashCode()));
            reportTheme(null, 1, str1, 0L, null, null, "200", 155, paramJSONObject, 23, str2, "0");
            return;
          }
        }
        catch (Throwable paramJSONObject)
        {
          callJsOnError(paramString, paramJSONObject.getMessage());
          QLog.e("ThemeJsPlugin", 1, "setup theme error:" + paramJSONObject.getMessage());
          return;
        }
        paramJSONObject = bdpt.b;
      }
      synchronized (this.mLock)
      {
        localObject1 = ThemeUtil.getThemeInfo(this.context, str1);
        paramJSONObject = (JSONObject)localObject1;
        if (localObject1 == null)
        {
          paramJSONObject = new ThemeUtil.ThemeInfo();
          paramJSONObject.themeId = str1;
          paramJSONObject.version = str2;
          if ("1000".equals(str1)) {
            paramJSONObject.status = "5";
          }
          ThemeUtil.setThemeInfo(this.context, paramJSONObject);
        }
        this.mThemeinfo = paramJSONObject;
        this.mThemeinfo.seriesID = str3;
        this.mThemeinfo.themeArray = localJSONArray;
        this.mThemeinfo.startTime = (l * 1000L);
        this.mCallbackId = paramString;
        if ("1103".equals(str1))
        {
          this.mThemeDiyModule.setSpThemeBackground();
          bdpp.a(str1, new ThemeJsPlugin.ThemeSwitchListener(this, str1, true));
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, "setup server :id:" + str1);
          }
        }
        else
        {
          paramJSONObject = paramBundle;
          if (paramBundle == null) {
            paramJSONObject = new Bundle();
          }
          paramJSONObject.putString("themeId", str1);
          paramJSONObject.putString("seriesID", str3);
          super.sendRemoteReq(arph.a("setSVTheme", paramString, this.mOnRemoteResp.key, paramJSONObject), false, true);
        }
      }
      return;
    }
  }
  
  public void startDownload(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      bdpp.a(paramJSONObject.optString("id"), new ThemeJsPlugin.3(this, paramJSONObject, paramString));
      return;
    }
    finally
    {
      paramJSONObject = finally;
      throw paramJSONObject;
    }
  }
  
  /* Error */
  public void startDownload(JSONObject paramJSONObject, String paramString, bdps parambdps)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 140
    //   5: invokevirtual 343	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 10
    //   10: aload_1
    //   11: ldc 120
    //   13: invokevirtual 343	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 11
    //   18: aload_1
    //   19: ldc_w 991
    //   22: ldc_w 992
    //   25: invokevirtual 924	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   28: istore 4
    //   30: aload_1
    //   31: ldc_w 922
    //   34: iconst_0
    //   35: invokevirtual 924	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   38: istore 5
    //   40: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +63 -> 106
    //   46: ldc 17
    //   48: iconst_2
    //   49: new 214	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 994
    //   59: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 10
    //   64: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 996
    //   70: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 11
    //   75: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 998
    //   81: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload 4
    //   86: invokevirtual 484	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: ldc_w 952
    //   92: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload 5
    //   97: invokevirtual 484	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload 11
    //   108: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   111: ifeq +194 -> 305
    //   114: ldc 17
    //   116: iconst_1
    //   117: new 214	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 1000
    //   127: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 10
    //   132: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 996
    //   138: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 11
    //   143: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 998
    //   149: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: iload 4
    //   154: invokevirtual 484	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: ldc_w 952
    //   160: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload 5
    //   165: invokevirtual 484	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: new 117	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 118	org/json/JSONObject:<init>	()V
    //   181: astore_1
    //   182: aload_1
    //   183: ldc 232
    //   185: bipush 248
    //   187: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_1
    //   192: ldc 237
    //   194: ldc_w 1002
    //   197: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   200: pop
    //   201: aload_0
    //   202: aload_2
    //   203: iconst_1
    //   204: anewarray 128	java/lang/String
    //   207: dup
    //   208: iconst_0
    //   209: aload_1
    //   210: invokevirtual 240	org/json/JSONObject:toString	()Ljava/lang/String;
    //   213: aastore
    //   214: invokespecial 454	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   217: aload_0
    //   218: aconst_null
    //   219: iconst_0
    //   220: aload 11
    //   222: lconst_0
    //   223: aconst_null
    //   224: aconst_null
    //   225: ldc 250
    //   227: sipush 153
    //   230: getstatic 255	bdpt:a	Ljava/lang/String;
    //   233: bipush 248
    //   235: aload 10
    //   237: ldc_w 257
    //   240: invokevirtual 261	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   243: aconst_null
    //   244: ldc_w 1004
    //   247: ldc_w 1006
    //   250: ldc_w 1008
    //   253: aconst_null
    //   254: fconst_0
    //   255: invokestatic 1013	bgzu:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   258: new 77	java/util/HashMap
    //   261: dup
    //   262: invokespecial 78	java/util/HashMap:<init>	()V
    //   265: astore_1
    //   266: aload_1
    //   267: ldc_w 1006
    //   270: ldc_w 1015
    //   273: invokevirtual 1016	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   276: pop
    //   277: invokestatic 1022	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   280: invokestatic 1027	bctj:a	(Landroid/content/Context;)Lbctj;
    //   283: ldc_w 257
    //   286: ldc_w 1004
    //   289: iconst_0
    //   290: lconst_0
    //   291: ldc2_w 1028
    //   294: aload_1
    //   295: ldc_w 257
    //   298: iconst_1
    //   299: invokevirtual 1032	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   302: aload_0
    //   303: monitorexit
    //   304: return
    //   305: aload_0
    //   306: getfield 279	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   309: aload 11
    //   311: invokestatic 285	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   314: astore 9
    //   316: aload_3
    //   317: ifnull +326 -> 643
    //   320: aload_3
    //   321: invokevirtual 1033	bdps:b	()Z
    //   324: ifeq +319 -> 643
    //   327: iconst_1
    //   328: istore 6
    //   330: aload_3
    //   331: ifnull +318 -> 649
    //   334: aload_3
    //   335: invokevirtual 838	bdps:a	()Z
    //   338: ifeq +311 -> 649
    //   341: iconst_1
    //   342: istore 7
    //   344: goto +681 -> 1025
    //   347: aload 9
    //   349: astore_1
    //   350: aload 9
    //   352: ifnonnull +52 -> 404
    //   355: new 277	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   358: dup
    //   359: invokespecial 286	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   362: astore_1
    //   363: aload_1
    //   364: aload 11
    //   366: putfield 289	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   369: aload_1
    //   370: ldc_w 1034
    //   373: putfield 1037	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:zipVer	I
    //   376: aload_1
    //   377: ldc 142
    //   379: putfield 897	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   382: aload_1
    //   383: ldc_w 848
    //   386: putfield 866	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   389: iload 5
    //   391: iconst_1
    //   392: if_icmpne +263 -> 655
    //   395: iconst_1
    //   396: istore 8
    //   398: aload_1
    //   399: iload 8
    //   401: putfield 293	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   404: ldc 17
    //   406: iconst_1
    //   407: new 214	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 1039
    //   417: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload 11
    //   422: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 1041
    //   428: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: iload 6
    //   433: invokevirtual 491	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   436: ldc_w 1043
    //   439: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: iload 7
    //   444: invokevirtual 491	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   447: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: aload_1
    //   454: ldc_w 848
    //   457: putfield 866	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   460: aload_1
    //   461: getfield 883	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   464: lconst_1
    //   465: lcmp
    //   466: ifge +10 -> 476
    //   469: aload_1
    //   470: ldc2_w 1044
    //   473: putfield 883	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   476: aload_1
    //   477: aload_1
    //   478: getfield 883	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   481: putfield 875	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   484: aload_0
    //   485: getfield 75	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   488: aload 11
    //   490: aload_1
    //   491: invokevirtual 300	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   494: pop
    //   495: new 117	org/json/JSONObject
    //   498: dup
    //   499: invokespecial 118	org/json/JSONObject:<init>	()V
    //   502: astore_1
    //   503: aload_1
    //   504: ldc 232
    //   506: iconst_3
    //   507: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   510: pop
    //   511: aload_1
    //   512: ldc 237
    //   514: ldc_w 1047
    //   517: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   520: pop
    //   521: aload_0
    //   522: aload_2
    //   523: iconst_1
    //   524: anewarray 128	java/lang/String
    //   527: dup
    //   528: iconst_0
    //   529: aload_1
    //   530: invokevirtual 240	org/json/JSONObject:toString	()Ljava/lang/String;
    //   533: aastore
    //   534: invokespecial 454	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   537: aload_0
    //   538: aconst_null
    //   539: iconst_0
    //   540: aload 11
    //   542: lconst_0
    //   543: ldc 246
    //   545: ldc_w 1049
    //   548: ldc 250
    //   550: sipush 153
    //   553: getstatic 255	bdpt:a	Ljava/lang/String;
    //   556: iconst_2
    //   557: aload 10
    //   559: ldc_w 257
    //   562: invokevirtual 261	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   565: goto -263 -> 302
    //   568: astore_1
    //   569: aload_0
    //   570: aload_2
    //   571: aload_1
    //   572: invokevirtual 1050	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   575: invokespecial 862	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: ldc 17
    //   580: iconst_1
    //   581: new 214	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 1052
    //   591: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_1
    //   595: invokevirtual 1050	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   598: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: aload_0
    //   608: aconst_null
    //   609: iconst_0
    //   610: ldc_w 257
    //   613: lconst_0
    //   614: aconst_null
    //   615: aconst_null
    //   616: ldc 250
    //   618: sipush 153
    //   621: getstatic 255	bdpt:a	Ljava/lang/String;
    //   624: bipush 220
    //   626: ldc_w 257
    //   629: ldc_w 257
    //   632: invokevirtual 261	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   635: goto -333 -> 302
    //   638: astore_1
    //   639: aload_0
    //   640: monitorexit
    //   641: aload_1
    //   642: athrow
    //   643: iconst_0
    //   644: istore 6
    //   646: goto -316 -> 330
    //   649: iconst_0
    //   650: istore 7
    //   652: goto +373 -> 1025
    //   655: iconst_0
    //   656: istore 8
    //   658: goto -260 -> 398
    //   661: iload 5
    //   663: iconst_1
    //   664: if_icmpne +334 -> 998
    //   667: iconst_1
    //   668: istore 6
    //   670: aload_1
    //   671: ldc_w 1054
    //   674: iconst_0
    //   675: invokevirtual 1057	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   678: ifne +326 -> 1004
    //   681: iconst_1
    //   682: istore 4
    //   684: aload_0
    //   685: getfield 80	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportMap	Ljava/util/HashMap;
    //   688: new 214	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   695: aload 11
    //   697: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: ldc_w 640
    //   703: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload 10
    //   708: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokevirtual 963	java/lang/String:hashCode	()I
    //   717: invokestatic 966	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   720: getstatic 255	bdpt:a	Ljava/lang/String;
    //   723: invokevirtual 1016	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   726: pop
    //   727: aload_0
    //   728: getfield 279	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   731: invokestatic 1062	bgnt:a	(Landroid/content/Context;)I
    //   734: istore 5
    //   736: iload 4
    //   738: ifeq +272 -> 1010
    //   741: iload 5
    //   743: iconst_1
    //   744: if_icmple +266 -> 1010
    //   747: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   750: ifeq +12 -> 762
    //   753: ldc 17
    //   755: iconst_2
    //   756: ldc_w 1064
    //   759: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: aload_0
    //   763: getfield 425	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lbhod;
    //   766: invokevirtual 430	bhod:a	()Landroid/app/Activity;
    //   769: iconst_2
    //   770: new 1066	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4
    //   773: dup
    //   774: aload_0
    //   775: aload 11
    //   777: aload 10
    //   779: iload 6
    //   781: aload_2
    //   782: invokespecial 1069	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   785: ldc_w 1071
    //   788: invokestatic 1076	bhhb:a	(Landroid/app/Activity;ILbhhd;Ljava/lang/String;)Z
    //   791: ifeq -489 -> 302
    //   794: aload_0
    //   795: new 1078	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5
    //   798: dup
    //   799: aload_0
    //   800: aload_0
    //   801: getfield 425	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lbhod;
    //   804: invokevirtual 430	bhod:a	()Landroid/app/Activity;
    //   807: ldc_w 1079
    //   810: aload 11
    //   812: aload 10
    //   814: iload 6
    //   816: aload_2
    //   817: invokespecial 1082	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   820: putfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lbgpa;
    //   823: aload_0
    //   824: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lbgpa;
    //   827: ldc_w 1083
    //   830: invokevirtual 1086	bgpa:setContentView	(I)V
    //   833: aload_0
    //   834: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lbgpa;
    //   837: ldc_w 1087
    //   840: invokestatic 825	anni:a	(I)Ljava/lang/String;
    //   843: invokevirtual 1091	bgpa:setTitle	(Ljava/lang/String;)Lbgpa;
    //   846: pop
    //   847: aload_0
    //   848: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lbgpa;
    //   851: ldc_w 1092
    //   854: invokevirtual 1096	bgpa:setMessage	(I)Lbgpa;
    //   857: pop
    //   858: aload_0
    //   859: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lbgpa;
    //   862: iconst_0
    //   863: invokevirtual 1100	bgpa:setCanceledOnTouchOutside	(Z)V
    //   866: aload_0
    //   867: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lbgpa;
    //   870: ldc_w 1101
    //   873: new 1103	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$6
    //   876: dup
    //   877: aload_0
    //   878: aload 11
    //   880: aload 10
    //   882: iload 6
    //   884: aload_2
    //   885: invokespecial 1104	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$6:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   888: invokevirtual 1108	bgpa:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lbgpa;
    //   891: pop
    //   892: aload_0
    //   893: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lbgpa;
    //   896: ldc_w 1109
    //   899: new 1111	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$7
    //   902: dup
    //   903: aload_0
    //   904: aload 11
    //   906: aload 10
    //   908: iload 6
    //   910: aload_2
    //   911: invokespecial 1112	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$7:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   914: invokevirtual 1115	bgpa:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lbgpa;
    //   917: pop
    //   918: aload_0
    //   919: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lbgpa;
    //   922: invokevirtual 1118	bgpa:show	()V
    //   925: goto -623 -> 302
    //   928: astore_1
    //   929: aload_0
    //   930: aload_2
    //   931: aload_1
    //   932: invokevirtual 271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   935: invokespecial 862	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   938: ldc 17
    //   940: iconst_1
    //   941: new 214	java/lang/StringBuilder
    //   944: dup
    //   945: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   948: ldc_w 1120
    //   951: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: aload_1
    //   955: invokevirtual 271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   958: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   967: aload_0
    //   968: aconst_null
    //   969: iconst_0
    //   970: ldc_w 257
    //   973: lconst_0
    //   974: aconst_null
    //   975: aconst_null
    //   976: ldc 250
    //   978: sipush 153
    //   981: getstatic 255	bdpt:a	Ljava/lang/String;
    //   984: bipush 221
    //   986: ldc_w 257
    //   989: ldc_w 257
    //   992: invokevirtual 261	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   995: goto -693 -> 302
    //   998: iconst_0
    //   999: istore 6
    //   1001: goto -331 -> 670
    //   1004: iconst_0
    //   1005: istore 4
    //   1007: goto -323 -> 684
    //   1010: aload_0
    //   1011: iconst_1
    //   1012: aload 11
    //   1014: aload 10
    //   1016: iload 6
    //   1018: aload_2
    //   1019: invokevirtual 1122	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:gotoDownload	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   1022: goto -720 -> 302
    //   1025: iload 6
    //   1027: ifne -680 -> 347
    //   1030: iload 7
    //   1032: ifeq -371 -> 661
    //   1035: goto -688 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1038	0	this	ThemeJsPlugin
    //   0	1038	1	paramJSONObject	JSONObject
    //   0	1038	2	paramString	String
    //   0	1038	3	parambdps	bdps
    //   28	978	4	i	int
    //   38	707	5	j	int
    //   328	698	6	bool1	boolean
    //   342	689	7	bool2	boolean
    //   396	261	8	bool3	boolean
    //   314	37	9	localThemeInfo	ThemeUtil.ThemeInfo
    //   8	1007	10	str1	String
    //   16	997	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	106	568	org/json/JSONException
    //   106	302	568	org/json/JSONException
    //   305	316	568	org/json/JSONException
    //   320	327	568	org/json/JSONException
    //   334	341	568	org/json/JSONException
    //   355	389	568	org/json/JSONException
    //   398	404	568	org/json/JSONException
    //   404	476	568	org/json/JSONException
    //   476	565	568	org/json/JSONException
    //   670	681	568	org/json/JSONException
    //   684	736	568	org/json/JSONException
    //   747	762	568	org/json/JSONException
    //   762	925	568	org/json/JSONException
    //   1010	1022	568	org/json/JSONException
    //   2	106	638	finally
    //   106	302	638	finally
    //   305	316	638	finally
    //   320	327	638	finally
    //   334	341	638	finally
    //   355	389	638	finally
    //   398	404	638	finally
    //   404	476	638	finally
    //   476	565	638	finally
    //   569	635	638	finally
    //   670	681	638	finally
    //   684	736	638	finally
    //   747	762	638	finally
    //   762	925	638	finally
    //   929	995	638	finally
    //   1010	1022	638	finally
    //   2	106	928	java/lang/Exception
    //   106	302	928	java/lang/Exception
    //   305	316	928	java/lang/Exception
    //   320	327	928	java/lang/Exception
    //   334	341	928	java/lang/Exception
    //   355	389	928	java/lang/Exception
    //   398	404	928	java/lang/Exception
    //   404	476	928	java/lang/Exception
    //   476	565	928	java/lang/Exception
    //   670	681	928	java/lang/Exception
    //   684	736	928	java/lang/Exception
    //   747	762	928	java/lang/Exception
    //   762	925	928	java/lang/Exception
    //   1010	1022	928	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */