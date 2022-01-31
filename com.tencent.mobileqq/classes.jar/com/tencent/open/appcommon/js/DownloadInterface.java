package com.tencent.open.appcommon.js;

import ajjy;
import anah;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import anfc;
import bcbh;
import bcbi;
import bcbj;
import bcbp;
import bcds;
import bcex;
import bcey;
import bcgh;
import bcgl;
import bcgo;
import bchb;
import bchu;
import bchv;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.downloadnew.DownloadInfo;
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
import yev;
import yez;

public class DownloadInterface
  extends BaseInterface
  implements bcex
{
  public static final String PLUGIN_NAMESPACE = "q_download";
  private static final String TAG = "DownloadInterface";
  protected String jsCallBackMethod = "";
  bcbp lastActionRecord = null;
  protected bchv listener;
  protected Activity mActivity;
  protected Handler mHandler;
  protected final WebView webview;
  
  public DownloadInterface(Activity paramActivity, WebView paramWebView)
  {
    bcds.c("DownloadInterface", "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      bcgo.a().a(paramWebView);
      bcey.a().a(this);
      bcds.c("DownloadInterface", "init out");
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
      bcgh.a(localArrayList, new bcbh(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      bcds.c("DownloadInterface", "innerQueryDownloadInfo>>>", paramJSONArray);
    }
  }
  
  private void innerQueryDownloadInfoByVia(String paramString1, String paramString2)
  {
    try
    {
      bcgh.a(paramString1, new bcbi(this, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      bcds.c("DownloadInterface", "innerQueryDownloadInfoByVia Exception>>>", paramString1);
    }
  }
  
  public static String parseCurrentPageId(Activity paramActivity)
  {
    String str2 = getRefIdFromActivity(paramActivity);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getSourceInfoFromActivity(paramActivity);
    }
    bcds.c("DownloadInterface", ">parseCurrentPageId " + str1);
    return str1;
  }
  
  public static String parseSourceType(Activity paramActivity, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("sourceType");
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = getSourceInfoFromActivity(paramActivity);
    }
    bcds.b("DownloadInterface", ">parseSourceType sourceType=" + paramJSONObject);
    return paramJSONObject;
  }
  
  public void cancelDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    bcgh.a(paramString1, paramString2, true);
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bcgo.a().a(paramString);
  }
  
  public void checkUpdate(String paramString)
  {
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    bcds.c("DownloadInterface", "enter checkUpdate json=" + paramString1 + ", guid = " + paramString2);
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
          this.listener = new bcbj(this, paramString1);
          bchu.a().a(this.listener);
          bchu.a().a(paramString2);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        bcds.c("DownloadInterface", "httpRequest JSONException", paramString1);
        return;
      }
      ((bcbj)this.listener).b(paramString1);
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
        yez.b(paramString.get(i).toString(), "DELAY_LIST");
        i += 1;
      }
      jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
      return;
    }
    catch (Exception paramString)
    {
      bcds.c("DownloadInterface", "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  public void deleteDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    bcgh.b(paramString1, paramString2, true);
  }
  
  public void destroy()
  {
    bcds.c("DownloadInterface", "destroy");
    bcey.a().b(this);
    if (bchu.a()) {
      bchu.a().b(this.listener);
    }
  }
  
  public int doDownloadAction(String paramString)
  {
    bcds.c("TIME-STATISTIC", "DownloadInterface--doDownloadAction");
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
          yez.c((String)localObject, "DELAY_LIST");
          yez.a((String)localObject, paramString, "DELAY_APPID_DETAIL_");
          yev.a();
          sendRemoteReq(anah.a("gamecenter_delaydownload", "callback", 0, null), false, false);
          return 0;
        }
        if (i == 0) {
          yez.b((String)localObject, "DELAY_LIST");
        }
      }
      localBundle.putString(bcgl.b, localJSONObject.optString("appid"));
      localBundle.putString(bcgl.j, localJSONObject.optString("url"));
      localBundle.putString(bcgl.f, localJSONObject.optString("packageName"));
      localBundle.putInt(bcgl.k, localJSONObject.optInt("actionCode"));
      localBundle.putString(bcgl.i, localJSONObject.optString("via"));
      localBundle.putString(bcgl.l, localJSONObject.optString("appName"));
      localBundle.putBoolean(bcgl.r, changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
      localBundle.putString(bcgl.D, localJSONObject.optString("iconUrl"));
      localBundle.putInt(bcgl.H, localJSONObject.optInt("showNotification"));
      localBundle.putBoolean(bcgl.J, changeIntToBoolean(localJSONObject.optInt("isAutoInstallBySdk")));
      localBundle.putString(bcgl.I, localJSONObject.optString("extraData"));
      localBundle.putString(bcgl.F, localJSONObject.optString("downloadStyle"));
      localBundle.putString(bcgl.G, localJSONObject.optString("downloadSize"));
      localBundle.putString(bcgl.p, localJSONObject.optString("wording"));
      paramString = localJSONObject.optString(bcgl.B);
      bcds.d("DownloadInterface", " feedChannel:" + paramString);
      if (TextUtils.isEmpty(paramString)) {
        break label1044;
      }
      if (!paramString.startsWith("0;")) {
        break label923;
      }
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      int i;
      Object localObject;
      boolean bool;
      bcds.c("DownloadInterface", "JSONException", paramString);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        bcds.c("DownloadInterface", "Exception", paramString);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        paramString = "";
      }
    }
    bcds.d("DownloadInterface", " finalFeedChannel:" + paramString);
    localBundle.putString(bcgl.B, paramString);
    paramString = localJSONObject.optString("via");
    localObject = localJSONObject.optString("appid");
    i = localJSONObject.optInt("actionCode");
    if (this.lastActionRecord == null)
    {
      this.lastActionRecord = new bcbp((String)localObject, paramString, i);
      label539:
      if (localJSONObject.optInt("actionCode") == 12)
      {
        bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
        localBundle.putBoolean(bcgl.o, bool);
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
          label923:
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
          localBundle.putString(bcgl.c, localJSONObject.optString("myAppId"));
          localBundle.putString(bcgl.d, localJSONObject.optString("apkId"));
          localBundle.putInt(bcgl.e, localJSONObject.optInt("versionCode"));
          localBundle.putInt(bcgl.n, localJSONObject.optInt("toPageType"));
          localBundle.putBoolean(bcgl.g, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
          localBundle.putBoolean(bcgl.h, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
          localBundle.putBoolean(bcgl.x, localJSONObject.optBoolean("bolckNotify"));
          localObject = parseSourceType(this.mActivity, localJSONObject);
          localBundle.putString("big_brother_ref_source_key", parseCurrentPageId(this.mActivity));
          bcds.c("DownloadInterface", "doDownloadAction object " + localJSONObject.toString());
          bcgh.a(this.mActivity, localBundle, (String)localObject, paramString, i);
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
          break label539;
        }
        return 0;
        bcds.c("DownloadInterface", "enter doDownloadAction updateData json");
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
      localObject = bcgo.a().a((String)localObject);
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
      bcds.c("DownloadInterface", "JSONException", paramString);
    }
    return -1;
  }
  
  public void doWifiDownloadAction(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      bcds.c("DownloadInterface", "doDownloadAction object " + paramString.toString());
      paramString = paramString.optString("via");
      bchb.a().a(this.mActivity, paramString, "biz_src_yyb");
      return;
    }
    catch (Exception paramString)
    {
      bcds.c("DownloadInterface", "doWifiDownloadAction>>>", paramString);
    }
  }
  
  public void getDelayDownloadTasks()
  {
    Object localObject = yez.a("DELAY_LIST");
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
              bcds.c("DownloadInterface", "getDelayDownloadTasks>>>", localJSONException);
            }
          }
        }
      }
    }
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + localJSONArray.toString() + "});}void(0);");
  }
  
  public String getDownloadVersion()
  {
    return bcgh.a() + "";
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
      bcds.c("DownloadInterface", "query>>>", paramString);
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
      bcds.c("DownloadInterface", "query>>>", paramString1);
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
      bcds.c("DownloadInterface", "query>>>", paramString);
    }
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  public void installYYB()
  {
    bchb.a().c(this.mActivity);
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
      bcgh.a(this.mActivity, localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bcds.c("DownloadInterface", "JSONException", paramString);
      }
    }
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    bcds.c("DownloadInterface", "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!anfc.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), ajjy.a(2131637717), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      anfc.a().b(paramBundle);
      return;
    }
    anfc.a().a(paramBundle);
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
      bcds.c("DownloadInterface", l1 + "|" + l2 + "|" + (System.currentTimeMillis() - l1));
      localBundle.putLong("startTime", l1);
      localBundle.putLong("endTime", l2);
      bcgh.a(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bcds.c("DownloadInterface", "JSONException", paramString);
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
      bcgh.b(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bcds.c("DownloadInterface", "JSONException", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DownloadInterface
 * JD-Core Version:    0.7.0.1
 */