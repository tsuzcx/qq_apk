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
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeSwitchManager.ThemeSwitchListener;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.theme.diy.ThemeDIYActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class ThemeJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "theme";
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
  QQCustomDialog dialog;
  private HashMap downloadThemeMap = new HashMap();
  String mCallbackId;
  Object mLock = new Object();
  ThemeSwitchManager mThemeSwitchManager;
  ThemeUtil.ThemeInfo mThemeinfo;
  HashMap reportMap = new HashMap();
  View rootView;
  public QQProgressDialog themeSwitchDialog;
  ThemeSwitchManager.ThemeSwitchListener themeSwitchListener = new ThemeJsPlugin.2(this);
  
  public ThemeJsPlugin()
  {
    this.mPluginNameSpace = "theme";
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map paramMap)
  {
    if (8589934604L == paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "EVENT_THEME_POSTCHANGED");
      }
      onPostThemeChanged();
      return true;
    }
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 2147483680L;
  }
  
  void gotoDownload(int paramInt, String paramString1, String paramString2, Bundle paramBundle, String paramString3)
  {
    if (paramInt < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "not wifi network cancel download dialog=" + this.dialog);
      }
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("result", 2);
        paramBundle.put("message", "user cancel download theme in not wifi network");
        callJs(paramString3, new String[] { paramBundle.toString() });
        reportTheme(null, 0, paramString1, 0L, "VipThemeMallDowned", "Cancel", "200", 153, ThemeReporter.a, 10, paramString2, "");
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
    this.downloadThemeMap.put(paramString1, localObject2);
    this.currDownloadingThemeId = paramString1;
    loadingThemeIdForJsCall = paramString1;
    paramBundle.putString("themeId", paramString1);
    super.sendRemoteReq(DataFactory.a("startDownloadTheme", paramString3, this.mOnRemoteResp.key, paramBundle), false, true);
    reportTheme(null, 0, paramString1, 0L, null, null, "200", 153, ThemeReporter.a, 11, paramString2, "");
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString1 == null) || (!"theme".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeJsPlugin", 2, "handleJsRequest themejs, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    try
    {
      paramVarArgs = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramVarArgs == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "handleJsRequest JSON = " + paramVarArgs.toString());
      }
      paramJsBridgeListener = paramVarArgs.optString("callback");
      if (TextUtils.isEmpty(paramJsBridgeListener))
      {
        QLog.e("ThemeJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      if ("queryInfo".equals(paramString3))
      {
        queryInfo(paramVarArgs, paramJsBridgeListener);
      }
      else if ("queryLocal".equals(paramString3))
      {
        paramVarArgs = new Bundle();
        paramVarArgs.putString("themeId", this.currDownloadingThemeId);
        sendRemoteReq(DataFactory.a("themeQueryLocal", paramJsBridgeListener, this.mOnRemoteResp.key, paramVarArgs), false, true);
      }
    }
    catch (Throwable paramJsBridgeListener)
    {
      QLog.e("ThemeJsPlugin", 2, "handleJsRequest exception url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3 + ", msg=" + paramJsBridgeListener.getMessage());
    }
    Object localObject;
    int i;
    boolean bool;
    if ("setup".equals(paramString3))
    {
      setup(paramVarArgs, paramJsBridgeListener);
    }
    else if ("startDownload".equals(paramString3))
    {
      startDownload(paramVarArgs, paramJsBridgeListener);
    }
    else if ("stopDownload".equals(paramString3))
    {
      paramVarArgs = paramVarArgs.optString("id");
      localObject = new Bundle();
      ((Bundle)localObject).putString("themeId", paramVarArgs);
      if ((TextUtils.isEmpty(paramVarArgs)) && (paramVarArgs.equals(this.currDownloadingThemeId))) {
        this.currDownloadingThemeId = "";
      }
      super.sendRemoteReq(DataFactory.a("stopdownload", paramJsBridgeListener, this.mOnRemoteResp.key, (Bundle)localObject), false, true);
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
      paramVarArgs = ThemeUtil.getThemeDensity(this.context);
      localObject = new JSONObject();
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "getDensity density:" + paramVarArgs);
      }
      ((JSONObject)localObject).put("result", 0);
      ((JSONObject)localObject).put("density", paramVarArgs);
      ((JSONObject)localObject).put("message", "returnt density " + paramVarArgs);
      super.callJs(paramJsBridgeListener, new String[] { ((JSONObject)localObject).toString() });
    }
    else if ("queryWeekLoopInfo".equals(paramString3))
    {
      paramVarArgs = new Bundle();
      sendRemoteReq(DataFactory.a("weekLoopGetData", paramJsBridgeListener, this.mOnRemoteResp.key, paramVarArgs), false, true);
    }
    else if ("isSupportDynamic".equals(paramString3))
    {
      i = 1;
      j = 1;
      paramVarArgs = new Bundle();
      bool = ThemeSwitchManager.a(paramVarArgs);
      if (bool)
      {
        if ((!paramVarArgs.getBoolean("dynamic_switch", true)) || (!paramVarArgs.getBoolean("dynamic_enable", true))) {
          break label1052;
        }
        i = 1;
        if ((!paramVarArgs.getBoolean("dynamic_webview_enable", true)) || (i != 1)) {
          break label1058;
        }
      }
    }
    label1050:
    label1052:
    label1058:
    for (int j = 1;; j = 0)
    {
      paramVarArgs = new JSONObject();
      paramVarArgs.put("result", 0);
      paramVarArgs.put("isDeviceEnable", i);
      paramVarArgs.put("isWebviewEnable", j);
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "isSupportDynamic deviceEnable:" + i + ", webViewEnable:" + j + ", dpcIsOk=" + bool);
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("result", 0);
      ((JSONObject)localObject).put("message", "isSupportDynamic return deviceEnable:" + i + ", webViewEnable:" + j + ", dpcIsOk=" + bool);
      ((JSONObject)localObject).put("data", paramVarArgs);
      super.callJs(paramJsBridgeListener, new String[] { ((JSONObject)localObject).toString() });
      break label1050;
      QLog.e("ThemeJsPlugin", 2, "handleJsRequest error url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
      return true;
      i = 0;
      break;
    }
  }
  
  protected void onCreate()
  {
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.app = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.context = this.mRuntime.a().getApplicationContext();
    super.onCreate();
    this.rootView = this.mRuntime.a().getWindow().getDecorView().getRootView();
    QLog.d("ThemeJsPlugin", 1, "onCreate, nowThemeId=" + ThemeUtil.getCurrentThemeId() + ", userThemeId=" + ThemeUtil.getUserCurrentThemeId(this.app));
  }
  
  protected void onDestroy()
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
        break label89;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "titleView is null");
      }
    }
    for (;;)
    {
      if (this.mThemeSwitchManager != null) {
        this.mThemeSwitchManager.b();
      }
      return;
      QLog.d("ThemeJsPlugin", 2, "ThemeDebugKeyLog:switch ok");
      break;
      label89:
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
    String str1 = paramBundle.getString("status");
    int i = paramBundle.getInt("result");
    Long localLong1 = Long.valueOf(paramBundle.getLong("readSize"));
    Long localLong2 = Long.valueOf(paramBundle.getLong("size"));
    String str2 = paramBundle.getString("callbackid");
    long l = paramBundle.getLong("downloadTime");
    String str3 = paramBundle.getString("themeId");
    if ((TextUtils.isEmpty(str3)) || (QLog.isColorLevel())) {
      QLog.d("ThemeJsPlugin", 1, "onPushMsg Error status:" + str1 + ", themeId" + str3 + ", readSize:" + localLong1 + ", size=" + localLong2 + ", result=" + i);
    }
    ThemeUtil.ThemeInfo localThemeInfo = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(str3);
    if (localThemeInfo == null) {
      QLog.d("ThemeJsPlugin", 1, "onPushMsg null info Error status:" + str1 + ", themeId" + str3 + ", readSize:" + localLong1 + ", size=" + localLong2 + ", result=" + i);
    }
    int k;
    do
    {
      do
      {
        do
        {
          return;
          if (!"onProgress".equals(str1)) {
            break;
          }
          localThemeInfo.downsize = localLong1.longValue();
          localThemeInfo.size = localLong2.longValue();
          localThemeInfo.status = "2";
        } while (!QLog.isColorLevel());
        QLog.d("ThemeJsPlugin", 2, "onPushMsg onProgress: themeid=" + localThemeInfo + ", readSize:" + localLong1 + ", size:" + localLong2);
        return;
      } while (!"onDone".equals(str1));
      k = paramBundle.getInt("errCode", 0);
      if ((QLog.isColorLevel()) || (i < 0) || (k != 0)) {
        QLog.d("ThemeJsPlugin", 2, "onPushMsg onDone, result=" + i + ", errCode=" + k + ", themeid=" + str3);
      }
      reportTheme("theme_download", 0, this.currDownloadingThemeId, Long.valueOf(l).longValue(), "VipThemeMallDowned", "ok", "200", 153, ThemeReporter.a, 9, localThemeInfo.version, "");
    } while (!str3.equals(this.currDownloadingThemeId));
    int j = 0;
    str1 = "ok";
    if (i >= 0)
    {
      localThemeInfo.status = "3";
      paramBundle = str1;
      i = j;
      if (localThemeInfo.size > 1L)
      {
        localThemeInfo.downsize = localThemeInfo.size;
        i = j;
        paramBundle = str1;
      }
    }
    for (;;)
    {
      super.callJs(str2, new String[] { "{'result':" + i + ", 'message':'" + paramBundle + "'}" });
      return;
      if (i == -8)
      {
        i = 8;
        paramBundle = "param error.";
      }
      else if (i == -11)
      {
        i = 7;
        paramBundle = "SDCard not available.";
      }
      else if (i == -12)
      {
        i = 1;
        paramBundle = "Insufficient SDCard space.";
      }
      else if (i == -13)
      {
        i = 5;
        paramBundle = "No network access.";
      }
      else
      {
        paramBundle = "download errCode:" + k;
      }
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    int i;
    String str1;
    String str2;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("respkey", 0);
      str1 = paramBundle.getString("cmd");
      str2 = paramBundle.getString("callbackid");
      ??? = paramBundle.getBundle("response");
      if (??? != null) {
        break label46;
      }
    }
    label46:
    int j;
    Object localObject2;
    boolean bool;
    do
    {
      do
      {
        return;
      } while (i != this.mOnRemoteResp.key);
      j = paramBundle.getInt("failcode", 1000);
      if ((TextUtils.isEmpty(str1)) || (QLog.isColorLevel()) || (1001 == j))
      {
        localObject2 = new StringBuilder().append("response:").append(str1).append(", backCode=").append(j).append(", isTimeOut=");
        if (1001 != j) {
          break;
        }
        bool = true;
        QLog.d("ThemeJsPlugin", 2, bool);
      }
    } while (TextUtils.isEmpty(str1));
    for (;;)
    {
      try
      {
        if (!"startDownloadTheme".equals(str1)) {
          break label301;
        }
        i = ((Bundle)???).getInt("StartDownloadResult");
        if (i >= 0) {
          break label945;
        }
        QLog.e("ThemeJsPlugin", 1, "ThemeJsPlugin.onResponse, startDownload fail.opCode" + i);
      }
      catch (Throwable paramBundle)
      {
        QLog.e("ThemeJsPlugin", 1, "onResponse Throwable cmd:" + str1 + ", msg：" + paramBundle.getMessage());
        callJsOnError(str2, paramBundle.getMessage());
        return;
      }
      reportTheme(null, 0, "", 0L, null, null, "200", 153, String.valueOf(i), j, "", "");
      return;
      bool = false;
      break;
      label301:
      label945:
      do
      {
        i = -34;
        break;
        if ("stopdownload".equals(str1))
        {
          paramBundle = new JSONObject();
          paramBundle.put("result", 0);
          paramBundle.put("message", "Download process paused.");
          super.callJs(str2, new String[] { paramBundle.toString() });
          return;
        }
        if ("weekLoopGetData".equals(str1))
        {
          paramBundle = new JSONObject();
          paramBundle.put("result", 0);
          localObject2 = ((Bundle)???).getString("seriesID");
          ??? = ((Bundle)???).getString("themeArray");
          if (QLog.isColorLevel()) {
            QLog.d("ThemeJsPlugin", 2, "IPC_THEME_WEEK_LOOP_GET respone seriesID:" + (String)localObject2 + ", themeArr:" + (String)???);
          }
          paramBundle.put("seriesID", localObject2);
          paramBundle.put("themeArray", ???);
          paramBundle.put("message", "useSeriesID is " + (String)localObject2);
          super.callJs(str2, new String[] { paramBundle.toString() });
          return;
        }
        if ("themeQueryLocal".equals(str1))
        {
          paramBundle = new JSONObject();
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("localInfo", new JSONObject(((Bundle)???).getString("themeId")));
          ((JSONObject)localObject2).put("currentId", ThemeUtil.getCurrentThemeId());
          i = ThemeUtil.getUinThemePreferences(this.app).getInt("stripUserTheme", 0);
          if (i != 0) {
            ThemeUtil.getUinThemePreferences(this.app).edit().remove("stripUserTheme").commit();
          }
          paramBundle.put("result", 0);
          paramBundle.put("message", "ok");
          paramBundle.put("data", localObject2);
          paramBundle.put("authResult", i);
          if (QLog.isColorLevel()) {
            QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler queryLocal ok:" + paramBundle.toString());
          }
          callJs(str2, new String[] { paramBundle.toString() });
          return;
        }
        if ("setSVTheme".equals(str1))
        {
          paramBundle = ((Bundle)???).getString("themeId");
          i = ((Bundle)???).getInt("themeStatus", -1);
          if (QLog.isColorLevel()) {
            QLog.d("ThemeJsPlugin", 2, "IPC_THEME_SET_SERVER respone themeId:" + paramBundle + ", ret:" + i);
          }
          if (i == 0) {
            synchronized (this.mLock)
            {
              if ((!TextUtils.isEmpty(str2)) && (str2.equals(this.mCallbackId)) && (!TextUtils.isEmpty(paramBundle)) && (this.mThemeinfo != null) && (paramBundle.equals(this.mThemeinfo.themeId))) {
                this.mThemeSwitchManager.a(this.app, this.mRuntime.a(), this.mThemeinfo, false, true, "200");
              }
              return;
            }
          }
          ??? = new JSONObject();
          ((JSONObject)???).put("themeId", paramBundle);
          ((JSONObject)???).put("result", 5);
          ((JSONObject)???).put("message", "setup theme setSV error.");
          super.callJs(str2, new String[] { ((JSONObject)???).toString() });
          return;
        }
        super.onResponse(paramBundle);
        return;
      } while (i < 0);
      i = 34;
    }
  }
  
  public void queryInfo(JSONObject paramJSONObject, String paramString)
  {
    label397:
    label589:
    label594:
    for (;;)
    {
      ThemeUtil.ThemeInfo localThemeInfo;
      Boolean localBoolean;
      JSONObject localJSONObject2;
      try
      {
        paramJSONObject = paramJSONObject.optString("id");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          break label594;
        }
        QLog.e("ThemeJsPlugin", 1, "queryInfo err themeId=null：" + paramJSONObject);
        paramJSONObject = "1000";
        localThemeInfo = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(paramJSONObject);
        if (localThemeInfo == null)
        {
          localThemeInfo = ThemeUtil.getThemeInfo(this.context, paramJSONObject);
          localBoolean = Boolean.valueOf(false);
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", "ok");
          localJSONObject2 = new JSONObject();
          if ("1000".equals(paramJSONObject))
          {
            localJSONObject2.put("status", Integer.parseInt("3"));
            localJSONObject2.put("version", 0);
            localJSONObject2.put("progress", 100);
            localJSONObject1.put("data", localJSONObject2);
            super.callJs(paramString, new String[] { localJSONObject1.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ThemeJsPlugin", 2, "queryInfo,themeId=" + paramJSONObject + "result=" + localJSONObject1.toString());
          }
        }
        else
        {
          localBoolean = Boolean.valueOf(true);
          continue;
        }
        if (localThemeInfo == null)
        {
          localJSONObject2.put("status", Integer.parseInt("1"));
          localJSONObject2.put("version", 0);
          localJSONObject2.put("progress", 0);
          continue;
        }
        if (!"2".equals(localThemeInfo.status)) {
          break label397;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("ThemeJsPlugin", 1, "queryInfo Exception：" + paramJSONObject.getMessage());
        super.callJsOnError(paramString, paramJSONObject.getMessage());
        reportTheme(null, 0, "", 0L, null, null, "200", 152, ThemeReporter.a, -35, "1", "");
        return;
      }
      if (localBoolean.booleanValue())
      {
        if (!paramJSONObject.equals(this.currDownloadingThemeId)) {
          localThemeInfo.status = "4";
        }
        if (((localThemeInfo.zipVer > 0) && (localThemeInfo.zipVer >= Integer.parseInt(localThemeInfo.version))) || ("5".equals(localThemeInfo.status))) {
          localThemeInfo.status = "3";
        }
        localJSONObject2.put("status", Integer.parseInt(localThemeInfo.status));
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "queryInfo downsize:" + localThemeInfo.downsize + ",size:" + localThemeInfo.size);
        }
        if (localThemeInfo.size <= 0L) {
          break label589;
        }
      }
      for (int i = (int)Math.floor(localThemeInfo.downsize * 1.0D / localThemeInfo.size * 100.0D);; i = 0)
      {
        i = Math.min(i, 100);
        localJSONObject2.put("version", localThemeInfo.version);
        localJSONObject2.put("progress", i);
        break;
        localThemeInfo.status = "1";
        break label397;
      }
    }
  }
  
  void reportTheme(String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, String paramString8)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new ThemeJsPlugin.1(this, paramString2, paramInt1, paramString1, paramLong, paramString3, paramString4, paramString5, paramInt2, paramInt3, paramString7, paramString8, paramString6), 2000L);
  }
  
  public void setup(JSONObject paramJSONObject, String paramString)
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
          reportTheme(null, 0, str1, 0L, null, null, "200", 155, ThemeReporter.a, -8, str2, "");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler setup,themeId=" + str1 + ",version=" + str2 + ",isSound=" + i);
        }
        if (!str1.equals(ThemeUtil.getCurrentThemeId())) {
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
      paramJSONObject = ThemeReporter.b;
    }
    if ((this.mThemeSwitchManager == null) || (!this.mThemeSwitchManager.a.get())) {
      synchronized (this.mLock)
      {
        ThemeUtil.ThemeInfo localThemeInfo = ThemeUtil.getThemeInfo(this.context, str1);
        paramJSONObject = localThemeInfo;
        if (localThemeInfo == null)
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
        if (this.mThemeSwitchManager == null) {}
        for (paramJSONObject = new ThemeSwitchManager(this.app);; paramJSONObject = this.mThemeSwitchManager)
        {
          this.mThemeSwitchManager = paramJSONObject;
          this.mThemeSwitchManager.a(this.themeSwitchListener, true, false);
          this.mCallbackId = paramString;
          if (!"1103".equals(str1)) {
            break;
          }
          this.mThemeSwitchManager.a(this.app, this.mRuntime.a(), this.mThemeinfo, false, true, "200");
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ThemeJsPlugin", 2, "setup server :id:" + str1);
          return;
        }
        paramJSONObject = new Bundle();
        paramJSONObject.putString("themeId", str1);
        paramJSONObject.putString("seriesID", str3);
        super.sendRemoteReq(DataFactory.a("setSVTheme", paramString, this.mOnRemoteResp.key, paramJSONObject), false, true);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler return because setupping.");
    }
    paramJSONObject = new JSONObject();
    paramJSONObject.put("result", 2);
    paramJSONObject.put("message", "is switching theme");
    super.callJs(paramString, new String[] { paramJSONObject.toString() });
  }
  
  /* Error */
  public void startDownload(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 851
    //   5: aload_1
    //   6: ldc_w 853
    //   9: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12: invokestatic 858	com/tencent/mobileqq/emosm/EmosmUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: pop
    //   16: aload_1
    //   17: ldc_w 702
    //   20: invokevirtual 265	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 9
    //   25: aload_1
    //   26: ldc_w 301
    //   29: invokevirtual 265	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 10
    //   34: aload_1
    //   35: ldc_w 518
    //   38: invokevirtual 860	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   41: istore_3
    //   42: aload_1
    //   43: ldc_w 765
    //   46: iconst_0
    //   47: invokevirtual 768	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   50: istore 4
    //   52: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +62 -> 117
    //   58: ldc 11
    //   60: iconst_2
    //   61: new 113	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 862
    //   71: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 9
    //   76: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 864
    //   82: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 10
    //   87: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 866
    //   93: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload_3
    //   97: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc_w 796
    //   103: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload 4
    //   108: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload 10
    //   119: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifeq +148 -> 270
    //   125: ldc 11
    //   127: iconst_1
    //   128: new 113	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 868
    //   138: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 9
    //   143: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 864
    //   149: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 10
    //   154: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 866
    //   160: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload_3
    //   164: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 796
    //   170: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload 4
    //   175: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: new 131	org/json/JSONObject
    //   187: dup
    //   188: invokespecial 132	org/json/JSONObject:<init>	()V
    //   191: astore_1
    //   192: aload_1
    //   193: ldc 134
    //   195: bipush 248
    //   197: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   200: pop
    //   201: aload_1
    //   202: ldc 140
    //   204: ldc_w 870
    //   207: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   210: pop
    //   211: aload_0
    //   212: aload_2
    //   213: iconst_1
    //   214: anewarray 147	java/lang/String
    //   217: dup
    //   218: iconst_0
    //   219: aload_1
    //   220: invokevirtual 148	org/json/JSONObject:toString	()Ljava/lang/String;
    //   223: aastore
    //   224: invokespecial 358	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   227: aload_0
    //   228: aconst_null
    //   229: iconst_0
    //   230: aload 10
    //   232: lconst_0
    //   233: aconst_null
    //   234: aconst_null
    //   235: ldc 158
    //   237: sipush 153
    //   240: getstatic 163	com/tencent/mobileqq/theme/ThemeReporter:a	Ljava/lang/String;
    //   243: bipush 248
    //   245: aload 9
    //   247: ldc 165
    //   249: invokevirtual 169	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   252: aconst_null
    //   253: ldc_w 872
    //   256: ldc_w 874
    //   259: ldc_w 876
    //   262: aconst_null
    //   263: fconst_0
    //   264: invokestatic 881	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   267: aload_0
    //   268: monitorexit
    //   269: return
    //   270: aload_0
    //   271: getfield 190	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   274: aload 10
    //   276: invokestatic 196	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   279: astore 8
    //   281: aload 8
    //   283: ifnull +363 -> 646
    //   286: aload_0
    //   287: getfield 190	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   290: aload 10
    //   292: aload 8
    //   294: getfield 572	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   297: aload 8
    //   299: getfield 884	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:fileNum	I
    //   302: ldc_w 886
    //   305: invokestatic 891	com/tencent/mobileqq/theme/ThemeDownloader:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z
    //   308: ifeq +338 -> 646
    //   311: iconst_1
    //   312: istore 5
    //   314: aload_0
    //   315: getfield 190	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   318: aload 10
    //   320: ldc_w 893
    //   323: lconst_0
    //   324: ldc_w 895
    //   327: invokestatic 898	com/tencent/mobileqq/theme/ThemeDownloader:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Z
    //   330: istore 7
    //   332: iload 5
    //   334: ifne +8 -> 342
    //   337: iload 7
    //   339: ifeq +319 -> 658
    //   342: aload 8
    //   344: astore_1
    //   345: aload 8
    //   347: ifnonnull +46 -> 393
    //   350: new 188	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   353: dup
    //   354: invokespecial 197	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   357: astore_1
    //   358: aload_1
    //   359: aload 10
    //   361: putfield 200	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   364: aload_1
    //   365: sipush 200
    //   368: putfield 719	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:zipVer	I
    //   371: aload_1
    //   372: ldc_w 574
    //   375: putfield 548	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   378: iload 4
    //   380: iconst_1
    //   381: if_icmpne +271 -> 652
    //   384: iconst_1
    //   385: istore 6
    //   387: aload_1
    //   388: iload 6
    //   390: putfield 902	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   393: iload 5
    //   395: ifne +10 -> 405
    //   398: aload_1
    //   399: ldc_w 574
    //   402: putfield 548	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   405: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +52 -> 460
    //   411: ldc 11
    //   413: iconst_2
    //   414: new 113	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 904
    //   424: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 10
    //   429: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc_w 906
    //   435: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: iload 5
    //   440: invokevirtual 395	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   443: ldc_w 908
    //   446: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: iload 7
    //   451: invokevirtual 395	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   454: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: aload_1
    //   461: ldc_w 345
    //   464: putfield 548	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   467: aload_1
    //   468: getfield 544	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   471: lconst_1
    //   472: lcmp
    //   473: ifge +10 -> 483
    //   476: aload_1
    //   477: ldc2_w 909
    //   480: putfield 544	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   483: aload_1
    //   484: aload_1
    //   485: getfield 544	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   488: putfield 542	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   491: aload_0
    //   492: getfield 64	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/HashMap;
    //   495: aload 10
    //   497: aload_1
    //   498: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   501: pop
    //   502: new 131	org/json/JSONObject
    //   505: dup
    //   506: invokespecial 132	org/json/JSONObject:<init>	()V
    //   509: astore_1
    //   510: aload_1
    //   511: ldc 134
    //   513: iconst_3
    //   514: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   517: pop
    //   518: aload_1
    //   519: ldc 140
    //   521: ldc_w 912
    //   524: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   527: pop
    //   528: aload_0
    //   529: aload_2
    //   530: iconst_1
    //   531: anewarray 147	java/lang/String
    //   534: dup
    //   535: iconst_0
    //   536: aload_1
    //   537: invokevirtual 148	org/json/JSONObject:toString	()Ljava/lang/String;
    //   540: aastore
    //   541: invokespecial 358	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   544: aload_0
    //   545: aconst_null
    //   546: iconst_0
    //   547: aload 10
    //   549: lconst_0
    //   550: ldc 154
    //   552: ldc_w 914
    //   555: ldc 158
    //   557: sipush 153
    //   560: getstatic 163	com/tencent/mobileqq/theme/ThemeReporter:a	Ljava/lang/String;
    //   563: iconst_2
    //   564: aload 9
    //   566: ldc 165
    //   568: invokevirtual 169	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   571: goto -304 -> 267
    //   574: astore_1
    //   575: aload_0
    //   576: aload_2
    //   577: aload_1
    //   578: invokevirtual 915	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   581: invokespecial 711	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: ldc 11
    //   586: iconst_1
    //   587: new 113	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   594: ldc_w 917
    //   597: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_1
    //   601: invokevirtual 915	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   604: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: aload_0
    //   614: aconst_null
    //   615: iconst_0
    //   616: ldc 165
    //   618: lconst_0
    //   619: aconst_null
    //   620: aconst_null
    //   621: ldc 158
    //   623: sipush 153
    //   626: getstatic 163	com/tencent/mobileqq/theme/ThemeReporter:a	Ljava/lang/String;
    //   629: bipush 220
    //   631: ldc 165
    //   633: ldc 165
    //   635: invokevirtual 169	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   638: goto -371 -> 267
    //   641: astore_1
    //   642: aload_0
    //   643: monitorexit
    //   644: aload_1
    //   645: athrow
    //   646: iconst_0
    //   647: istore 5
    //   649: goto -335 -> 314
    //   652: iconst_0
    //   653: istore 6
    //   655: goto -268 -> 387
    //   658: new 210	android/os/Bundle
    //   661: dup
    //   662: invokespecial 281	android/os/Bundle:<init>	()V
    //   665: astore 8
    //   667: aload 8
    //   669: ldc 208
    //   671: aload 10
    //   673: invokevirtual 214	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: aload 8
    //   678: ldc_w 702
    //   681: aload 9
    //   683: invokevirtual 214	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: iload 4
    //   688: ifeq +336 -> 1024
    //   691: iconst_1
    //   692: istore 5
    //   694: aload 8
    //   696: ldc_w 918
    //   699: iload 5
    //   701: invokevirtual 922	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   704: aload_1
    //   705: ldc_w 924
    //   708: iconst_0
    //   709: invokevirtual 927	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   712: ifne +318 -> 1030
    //   715: iconst_1
    //   716: istore_3
    //   717: aload_0
    //   718: getfield 66	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportMap	Ljava/util/HashMap;
    //   721: new 113	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   728: aload 10
    //   730: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: ldc_w 469
    //   736: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: aload 9
    //   741: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokevirtual 803	java/lang/String:hashCode	()I
    //   750: invokestatic 806	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   753: getstatic 163	com/tencent/mobileqq/theme/ThemeReporter:a	Ljava/lang/String;
    //   756: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   759: pop
    //   760: aload_0
    //   761: getfield 190	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   764: invokestatic 932	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   767: istore 4
    //   769: iload_3
    //   770: ifeq +265 -> 1035
    //   773: iload 4
    //   775: iconst_1
    //   776: if_icmple +259 -> 1035
    //   779: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   782: ifeq +12 -> 794
    //   785: ldc 11
    //   787: iconst_2
    //   788: ldc_w 934
    //   791: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   794: aload_0
    //   795: getfield 329	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   798: invokevirtual 334	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   801: iconst_2
    //   802: new 936	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$3
    //   805: dup
    //   806: aload_0
    //   807: aload 10
    //   809: aload 9
    //   811: aload 8
    //   813: aload_2
    //   814: invokespecial 939	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$3:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V
    //   817: ldc_w 941
    //   820: invokestatic 946	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Landroid/app/Activity;ILcom/tencent/mobileqq/vip/CUKingCardHelper$CUKingDialogListener;Ljava/lang/String;)Z
    //   823: ifeq -556 -> 267
    //   826: aload_0
    //   827: new 948	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4
    //   830: dup
    //   831: aload_0
    //   832: aload_0
    //   833: getfield 329	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   836: invokevirtual 334	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   839: ldc_w 949
    //   842: aload 10
    //   844: aload 9
    //   846: aload 8
    //   848: aload_2
    //   849: invokespecial 952	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V
    //   852: putfield 122	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   855: aload_0
    //   856: getfield 122	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   859: ldc_w 953
    //   862: invokevirtual 957	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   865: aload_0
    //   866: getfield 122	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   869: ldc_w 959
    //   872: invokevirtual 963	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   875: pop
    //   876: aload_0
    //   877: getfield 122	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   880: ldc_w 964
    //   883: invokevirtual 968	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   886: pop
    //   887: aload_0
    //   888: getfield 122	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   891: iconst_0
    //   892: invokevirtual 972	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   895: aload_0
    //   896: getfield 122	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   899: ldc_w 973
    //   902: new 975	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5
    //   905: dup
    //   906: aload_0
    //   907: aload 10
    //   909: aload 9
    //   911: aload 8
    //   913: aload_2
    //   914: invokespecial 976	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V
    //   917: invokevirtual 980	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   920: pop
    //   921: aload_0
    //   922: getfield 122	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   925: ldc_w 981
    //   928: new 983	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$6
    //   931: dup
    //   932: aload_0
    //   933: aload 10
    //   935: aload 9
    //   937: aload 8
    //   939: aload_2
    //   940: invokespecial 984	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$6:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V
    //   943: invokevirtual 987	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   946: pop
    //   947: aload_0
    //   948: getfield 122	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   951: invokevirtual 990	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   954: goto -687 -> 267
    //   957: astore_1
    //   958: aload_0
    //   959: aload_2
    //   960: aload_1
    //   961: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   964: invokespecial 711	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   967: ldc 11
    //   969: iconst_1
    //   970: new 113	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   977: ldc_w 992
    //   980: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload_1
    //   984: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   987: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: aload_0
    //   997: aconst_null
    //   998: iconst_0
    //   999: ldc 165
    //   1001: lconst_0
    //   1002: aconst_null
    //   1003: aconst_null
    //   1004: ldc 158
    //   1006: sipush 153
    //   1009: getstatic 163	com/tencent/mobileqq/theme/ThemeReporter:a	Ljava/lang/String;
    //   1012: bipush 221
    //   1014: ldc 165
    //   1016: ldc 165
    //   1018: invokevirtual 169	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1021: goto -754 -> 267
    //   1024: iconst_0
    //   1025: istore 5
    //   1027: goto -333 -> 694
    //   1030: iconst_0
    //   1031: istore_3
    //   1032: goto -315 -> 717
    //   1035: aload_0
    //   1036: iconst_1
    //   1037: aload 10
    //   1039: aload 9
    //   1041: aload 8
    //   1043: aload_2
    //   1044: invokevirtual 994	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:gotoDownload	(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V
    //   1047: goto -780 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1050	0	this	ThemeJsPlugin
    //   0	1050	1	paramJSONObject	JSONObject
    //   0	1050	2	paramString	String
    //   41	991	3	i	int
    //   50	727	4	j	int
    //   312	714	5	bool1	boolean
    //   385	269	6	bool2	boolean
    //   330	120	7	bool3	boolean
    //   279	763	8	localObject	Object
    //   23	1017	9	str1	String
    //   32	1006	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	117	574	org/json/JSONException
    //   117	267	574	org/json/JSONException
    //   270	281	574	org/json/JSONException
    //   286	311	574	org/json/JSONException
    //   314	332	574	org/json/JSONException
    //   350	378	574	org/json/JSONException
    //   387	393	574	org/json/JSONException
    //   398	405	574	org/json/JSONException
    //   405	460	574	org/json/JSONException
    //   460	483	574	org/json/JSONException
    //   483	571	574	org/json/JSONException
    //   658	686	574	org/json/JSONException
    //   694	715	574	org/json/JSONException
    //   717	769	574	org/json/JSONException
    //   779	794	574	org/json/JSONException
    //   794	954	574	org/json/JSONException
    //   1035	1047	574	org/json/JSONException
    //   2	117	641	finally
    //   117	267	641	finally
    //   270	281	641	finally
    //   286	311	641	finally
    //   314	332	641	finally
    //   350	378	641	finally
    //   387	393	641	finally
    //   398	405	641	finally
    //   405	460	641	finally
    //   460	483	641	finally
    //   483	571	641	finally
    //   575	638	641	finally
    //   658	686	641	finally
    //   694	715	641	finally
    //   717	769	641	finally
    //   779	794	641	finally
    //   794	954	641	finally
    //   958	1021	641	finally
    //   1035	1047	641	finally
    //   2	117	957	java/lang/Exception
    //   117	267	957	java/lang/Exception
    //   270	281	957	java/lang/Exception
    //   286	311	957	java/lang/Exception
    //   314	332	957	java/lang/Exception
    //   350	378	957	java/lang/Exception
    //   387	393	957	java/lang/Exception
    //   398	405	957	java/lang/Exception
    //   405	460	957	java/lang/Exception
    //   460	483	957	java/lang/Exception
    //   483	571	957	java/lang/Exception
    //   658	686	957	java/lang/Exception
    //   694	715	957	java/lang/Exception
    //   717	769	957	java/lang/Exception
    //   779	794	957	java/lang/Exception
    //   794	954	957	java/lang/Exception
    //   1035	1047	957	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */