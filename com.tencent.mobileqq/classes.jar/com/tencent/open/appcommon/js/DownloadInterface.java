package com.tencent.open.appcommon.js;

import abub;
import abuf;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import anvx;
import asdd;
import ashz;
import bjid;
import bjie;
import bjif;
import bjil;
import bjko;
import bjlq;
import bjlr;
import bjmu;
import bjmy;
import bjna;
import bjnn;
import bjog;
import bjoh;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadInterface
  extends BaseInterface
  implements bjlq
{
  public static final String PLUGIN_NAMESPACE = "q_download";
  private static final String TAG = "DownloadInterface";
  protected String jsCallBackMethod = "";
  bjil lastActionRecord = null;
  protected bjoh listener;
  protected Activity mActivity;
  protected Handler mHandler;
  protected final WebView webview;
  
  public DownloadInterface(Activity paramActivity, WebView paramWebView)
  {
    bjko.c("DownloadInterface", "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      bjna.a().a(paramWebView);
      bjlr.a().a(this);
      bjko.c("DownloadInterface", "init out");
      return;
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
  }
  
  public static boolean changeIntToBoolean(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      bool = false;
    }
    while (paramInt != 1) {
      return bool;
    }
    return true;
  }
  
  public static String getRefIdFromActivity(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
      return paramActivity;
    }
    catch (Throwable paramActivity) {}
    return "";
  }
  
  public static String getSourceInfoFromActivity(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getIntent().getStringExtra("big_brother_source_key");
      return paramActivity;
    }
    catch (Throwable paramActivity) {}
    return "";
  }
  
  private void innerQueryDownloadInfo(JSONArray paramJSONArray, String paramString)
  {
    try
    {
      int j = paramJSONArray.length();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.c = localJSONObject.optString("appid");
        localDownloadInfo.j = localJSONObject.optString("myAppId");
        localDownloadInfo.k = localJSONObject.optString("apkId");
        localDownloadInfo.e = localJSONObject.optString("packageName");
        localDownloadInfo.b = localJSONObject.optInt("versionCode");
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      bjmu.a(localArrayList, new bjid(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      bjko.c("DownloadInterface", "innerQueryDownloadInfo>>>", paramJSONArray);
    }
  }
  
  private void innerQueryDownloadInfoByVia(String paramString1, String paramString2)
  {
    try
    {
      bjmu.a(paramString1, new bjie(this, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      bjko.c("DownloadInterface", "innerQueryDownloadInfoByVia Exception>>>", paramString1);
    }
  }
  
  public static String parseCurrentPageId(Activity paramActivity)
  {
    String str2 = getRefIdFromActivity(paramActivity);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getSourceInfoFromActivity(paramActivity);
    }
    bjko.c("DownloadInterface", ">parseCurrentPageId " + str1);
    return str1;
  }
  
  public static String parseSourceType(Activity paramActivity, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("sourceType");
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = getSourceInfoFromActivity(paramActivity);
    }
    bjko.b("DownloadInterface", ">parseSourceType sourceType=" + paramJSONObject);
    return paramJSONObject;
  }
  
  public void cancelDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    bjmu.a(paramString1, paramString2, true);
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bjna.a().a(paramString);
  }
  
  public void checkUpdate(String paramString)
  {
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    bjko.c("DownloadInterface", "enter checkUpdate json=" + paramString1 + ", guid = " + paramString2);
    if (!hasRight()) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString1);
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = ((JSONObject)localObject).optString("guid");
        }
        paramString2 = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("packageNames");
        if (localObject != null)
        {
          int i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramString2.add(((JSONArray)localObject).getString(i));
            i += 1;
            continue;
          }
        }
        if (this.listener == null)
        {
          this.listener = new bjif(this, paramString1);
          bjog.a().a(this.listener);
          bjog.a().a(paramString2);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        bjko.c("DownloadInterface", "httpRequest JSONException", paramString1);
        return;
      }
      ((bjif)this.listener).a(paramString1);
    }
  }
  
  public void delDelayDownloadTasks(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("tasks");
      int i = 0;
      while (i < paramString.length())
      {
        abuf.b(paramString.get(i).toString(), "DELAY_LIST");
        i += 1;
      }
      jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
      return;
    }
    catch (Exception paramString)
    {
      bjko.c("DownloadInterface", "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  public void deleteDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    bjmu.b(paramString1, paramString2, true);
  }
  
  public void destroy()
  {
    bjko.c("DownloadInterface", "destroy");
    bjlr.a().b(this);
    if (bjog.a()) {
      bjog.a().b(this.listener);
    }
  }
  
  public int doDownloadAction(String paramString)
  {
    bjko.c("TIME-STATISTIC", "DownloadInterface--doDownloadAction");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.mActivity) >= 6) {
      localBundle.putLong("OuterCall_JS_DoDownloadAction", System.currentTimeMillis());
    }
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("delayDownload"))
      {
        i = localJSONObject.optInt("delayDownload", -1);
        if ((this.mActivity instanceof BaseActivity)) {
          localObject = (AppInterface)((BaseActivity)this.mActivity).getAppRuntime();
        }
        localObject = localJSONObject.optString("appid");
        if (1 == i)
        {
          abuf.c((String)localObject, "DELAY_LIST");
          abuf.a((String)localObject, paramString, "DELAY_APPID_DETAIL_");
          abub.a();
          sendRemoteReq(asdd.a("gamecenter_delaydownload", "callback", 0, null), false, false);
          return 0;
        }
        if (i == 0) {
          abuf.b((String)localObject, "DELAY_LIST");
        }
      }
      localBundle.putString(bjmy.b, localJSONObject.optString("appid"));
      localBundle.putString(bjmy.j, localJSONObject.optString("url"));
      localBundle.putString(bjmy.f, localJSONObject.optString("packageName"));
      localBundle.putInt(bjmy.k, localJSONObject.optInt("actionCode"));
      localBundle.putString(bjmy.i, localJSONObject.optString("via"));
      localBundle.putString(bjmy.l, localJSONObject.optString("appName"));
      localBundle.putBoolean(bjmy.r, changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
      localBundle.putString(bjmy.E, localJSONObject.optString("iconUrl"));
      localBundle.putInt(bjmy.I, localJSONObject.optInt("showNotification"));
      localBundle.putBoolean(bjmy.K, changeIntToBoolean(localJSONObject.optInt("isAutoInstallBySdk")));
      localBundle.putString(bjmy.J, localJSONObject.optString("extraData"));
      localBundle.putString(bjmy.G, localJSONObject.optString("downloadStyle"));
      localBundle.putString(bjmy.H, localJSONObject.optString("downloadSize"));
      localBundle.putString(bjmy.p, localJSONObject.optString("wording"));
      paramString = localJSONObject.optString("source");
      localBundle.putString("big_brother_source_key", paramString);
      bool = localJSONObject.optBoolean("isUniteDownload", false);
      localBundle.putBoolean(bjmy.z, bool);
      if (QLog.isColorLevel()) {
        QLog.d("DownloadInterface", 2, new Object[] { "[UniteDownload] jsapi doDownloadAction: invoked. ", " source: ", paramString, " isUniteDownload: ", Boolean.valueOf(bool) });
      }
      paramString = localJSONObject.optString(bjmy.C);
      bjko.d("DownloadInterface", " feedChannel:" + paramString);
      if (TextUtils.isEmpty(paramString)) {
        break label1125;
      }
      if (!paramString.startsWith("0;")) {
        break label1004;
      }
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      int i;
      Object localObject;
      boolean bool;
      bjko.c("DownloadInterface", "JSONException", paramString);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        bjko.c("DownloadInterface", "Exception", paramString);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        paramString = "";
      }
    }
    bjko.d("DownloadInterface", " finalFeedChannel:" + paramString);
    localBundle.putString(bjmy.C, paramString);
    paramString = localJSONObject.optString("via");
    localObject = localJSONObject.optString("appid");
    i = localJSONObject.optInt("actionCode");
    if (this.lastActionRecord == null)
    {
      this.lastActionRecord = new bjil((String)localObject, paramString, i);
      label620:
      if (localJSONObject.optInt("actionCode") == 12)
      {
        bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
        localBundle.putBoolean(bjmy.o, bool);
        bool = localJSONObject.has("updateData");
        if (!bool) {}
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          localObject = localJSONObject.optString("updateData");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          paramString = new ApkUpdateDetail();
        }
        catch (Exception paramString)
        {
          label1004:
          paramString = null;
          continue;
        }
        try
        {
          localObject = new JSONObject((String)localObject);
          paramString.packageName = ((JSONObject)localObject).optString("packageName");
          paramString.newapksize = ((JSONObject)localObject).optInt("newapksize");
          paramString.patchsize = ((JSONObject)localObject).optInt("patchsize");
          paramString.updatemethod = ((JSONObject)localObject).optInt("updatemethod");
          paramString.versioncode = ((JSONObject)localObject).optInt("versioncode");
          paramString.versionname = ((JSONObject)localObject).optString("versionname");
          paramString.fileMd5 = ((JSONObject)localObject).optString("fileMd5");
          paramString.sigMd5 = ((JSONObject)localObject).optString("sigMd5");
          paramString.url = ((JSONObject)localObject).optString("url");
          i = localJSONObject.optInt("myAppConfig");
          localBundle.putString(bjmy.c, localJSONObject.optString("myAppId"));
          localBundle.putString(bjmy.d, localJSONObject.optString("apkId"));
          localBundle.putInt(bjmy.e, localJSONObject.optInt("versionCode"));
          localBundle.putInt(bjmy.n, localJSONObject.optInt("toPageType"));
          localBundle.putBoolean(bjmy.g, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
          localBundle.putBoolean(bjmy.h, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
          localBundle.putBoolean(bjmy.x, localJSONObject.optBoolean("bolckNotify"));
          localObject = parseSourceType(this.mActivity, localJSONObject);
          localBundle.putString("big_brother_ref_source_key", parseCurrentPageId(this.mActivity));
          bjko.c("DownloadInterface", "doDownloadAction object " + localJSONObject.toString());
          bjmu.a(this.mActivity, localBundle, (String)localObject, paramString, i);
          return 0;
        }
        catch (Exception localException)
        {
          continue;
        }
        paramString = paramString.split(";");
        if (paramString == null)
        {
          paramString = "";
          break;
        }
        if (paramString.length <= 0)
        {
          paramString = "";
          break;
        }
        localObject = paramString[0];
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        paramString = (String)localObject;
        if (!((String)localObject).equals("0")) {
          break;
        }
        continue;
        if (!this.lastActionRecord.a((String)localObject, paramString, i)) {
          break label620;
        }
        return 0;
        bjko.c("DownloadInterface", "enter doDownloadAction updateData json");
      }
    }
  }
  
  public void doGCDownloadAction(String paramString)
  {
    doDownloadAction(paramString);
  }
  
  public int doQueryDownloadStatus(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.optString("downloadUrl");
      paramString = paramString.optString("callback");
      localObject = bjna.a().a((String)localObject);
      if (localObject == null) {
        return -1;
      }
      int i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
      int j = ((TMAssistantDownloadTaskInfo)localObject).mState;
      localObject = new JSONObject();
      ((JSONObject)localObject).put("progress", i);
      ((JSONObject)localObject).put("status", j);
      if ((this.webview != null) && ((this.webview instanceof CustomWebView))) {
        ((CustomWebView)this.webview).callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      }
      return 0;
    }
    catch (JSONException paramString)
    {
      bjko.c("DownloadInterface", "JSONException", paramString);
    }
    return -1;
  }
  
  public void doWifiDownloadAction(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      bjko.c("DownloadInterface", "doDownloadAction object " + paramString.toString());
      paramString = paramString.optString("via");
      bjnn.a().a(this.mActivity, paramString, "biz_src_yyb");
      return;
    }
    catch (Exception paramString)
    {
      bjko.c("DownloadInterface", "doWifiDownloadAction>>>", paramString);
    }
  }
  
  public void getDelayDownloadTasks()
  {
    Object localObject = abuf.a("DELAY_LIST");
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      int i = 0;
      for (;;)
      {
        if (i < localObject.length)
        {
          if (!TextUtils.isEmpty(localObject[i])) {}
          try
          {
            localJSONObject.put("appid", localObject[i]);
            localJSONArray.put(localJSONObject);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              bjko.c("DownloadInterface", "getDelayDownloadTasks>>>", localJSONException);
            }
          }
        }
      }
    }
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + localJSONArray.toString() + "});}void(0);");
  }
  
  public String getDownloadVersion()
  {
    return bjmu.a() + "";
  }
  
  public String getInterfaceName()
  {
    return "q_download";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jsCallBackMethod;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      innerQueryDownloadInfo(paramString.getJSONArray("infolist"), paramString.getString("guid"));
      return;
    }
    catch (Exception paramString)
    {
      bjko.c("DownloadInterface", "query>>>", paramString);
    }
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    try
    {
      innerQueryDownloadInfo(new JSONArray(paramString1), paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      bjko.c("DownloadInterface", "query>>>", paramString1);
    }
  }
  
  public void getQueryDownloadActionByVia(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      innerQueryDownloadInfoByVia(paramString.getString("via"), paramString.getString("guid"));
      return;
    }
    catch (Exception paramString)
    {
      bjko.c("DownloadInterface", "query>>>", paramString);
    }
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  public void installYYB()
  {
    bjnn.a().c(this.mActivity);
  }
  
  public void jsCallBack(String paramString)
  {
    this.mHandler.post(new DownloadInterface.3(this, paramString));
  }
  
  public int openDownloaderWebview(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString.optString("url"));
      bjmu.a(this.mActivity, localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bjko.c("DownloadInterface", "JSONException", paramString);
      }
    }
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    bjko.c("DownloadInterface", "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!ashz.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), anvx.a(2131702987), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      ashz.a().b(paramBundle);
      return;
    }
    ashz.a().a(paramBundle);
  }
  
  public int setDownloaderFirstOpenPage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString.optString("url"));
      long l1 = paramString.optLong("starttime");
      long l2 = paramString.optLong("endtime");
      bjko.c("DownloadInterface", l1 + "|" + l2 + "|" + (System.currentTimeMillis() - l1));
      localBundle.putLong("startTime", l1);
      localBundle.putLong("endTime", l2);
      bjmu.a(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bjko.c("DownloadInterface", "JSONException", paramString);
      }
    }
  }
  
  public int setDownloaderFirstOpenPageByTmast(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString.optString("url"));
      bjmu.b(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bjko.c("DownloadInterface", "JSONException", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DownloadInterface
 * JD-Core Version:    0.7.0.1
 */