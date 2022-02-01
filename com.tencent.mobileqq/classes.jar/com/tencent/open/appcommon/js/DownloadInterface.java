package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
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
  implements IJsCallBack
{
  public static final String PLUGIN_NAMESPACE = "q_download";
  private static final String TAG = "DownloadInterface";
  protected String jsCallBackMethod = "";
  LastDownloadAction lastActionRecord;
  protected UpdateManager.OnCheckUpdateListener listener;
  protected Activity mActivity;
  protected Handler mHandler;
  protected final WebView webview;
  
  public DownloadInterface(Activity paramActivity, WebView paramWebView)
  {
    Object localObject = null;
    this.lastActionRecord = null;
    LogUtility.c("DownloadInterface", "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool))
    {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    else
    {
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
    DownloadManager.b().a(paramWebView);
    JsCallbackManager.a().a(this);
    LogUtility.c("DownloadInterface", "init out");
  }
  
  public static boolean changeIntToBoolean(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    if (paramInt == 1) {}
    return true;
  }
  
  public static String getRefIdFromActivity(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
      return paramActivity;
    }
    catch (Throwable paramActivity)
    {
      label12:
      break label12;
    }
    return "";
  }
  
  public static String getSourceInfoFromActivity(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getIntent().getStringExtra("big_brother_source_key");
      return paramActivity;
    }
    catch (Throwable paramActivity)
    {
      label12:
      break label12;
    }
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
        localDownloadInfo.l = localJSONObject.optString("myAppId");
        localDownloadInfo.m = localJSONObject.optString("apkId");
        localDownloadInfo.e = localJSONObject.optString("packageName");
        localDownloadInfo.n = localJSONObject.optInt("versionCode");
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      DownloadApi.a(localArrayList, new DownloadInterface.1(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      LogUtility.c("DownloadInterface", "innerQueryDownloadInfo>>>", paramJSONArray);
    }
  }
  
  private void innerQueryDownloadInfoByVia(String paramString1, String paramString2)
  {
    try
    {
      DownloadApi.a(paramString1, new DownloadInterface.2(this, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      LogUtility.c("DownloadInterface", "innerQueryDownloadInfoByVia Exception>>>", paramString1);
    }
  }
  
  public static String parseCurrentPageId(Activity paramActivity)
  {
    String str2 = getRefIdFromActivity(paramActivity);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getSourceInfoFromActivity(paramActivity);
    }
    paramActivity = new StringBuilder();
    paramActivity.append(">parseCurrentPageId ");
    paramActivity.append(str1);
    LogUtility.c("DownloadInterface", paramActivity.toString());
    return str1;
  }
  
  public static String parseSourceType(Activity paramActivity, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("sourceType");
    paramJSONObject = paramJSONObject.optString("source");
    if (!TextUtils.isEmpty(paramJSONObject)) {
      return paramJSONObject;
    }
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = getSourceInfoFromActivity(paramActivity);
    }
    paramActivity = new StringBuilder();
    paramActivity.append(">parseSourceType sourceType=");
    paramActivity.append(paramJSONObject);
    LogUtility.b("DownloadInterface", paramActivity.toString());
    return paramJSONObject;
  }
  
  public void cancelDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    DownloadApi.a(paramString1, paramString2, true);
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    DownloadManager.b().a(paramString);
  }
  
  public void checkUpdate(String paramString)
  {
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enter checkUpdate json=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", guid = ");
    ((StringBuilder)localObject).append(paramString2);
    LogUtility.c("DownloadInterface", ((StringBuilder)localObject).toString());
    if (!hasRight()) {
      return;
    }
    try
    {
      localObject = new JSONObject(paramString1);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = ((JSONObject)localObject).optString("guid");
      }
      paramString2 = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("packageNames");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramString2.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
      }
      if (this.listener == null)
      {
        this.listener = new DownloadInterface.JsCheckUpdateCallback(this, paramString1);
        UpdateManager.b().a(this.listener);
      }
      else
      {
        ((DownloadInterface.JsCheckUpdateCallback)this.listener).b(paramString1);
      }
      UpdateManager.b().a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c("DownloadInterface", "httpRequest JSONException", paramString1);
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
        GameCenterUtil.b(paramString.get(i).toString(), "DELAY_LIST");
        i += 1;
      }
      jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("DownloadInterface", "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  public void deleteDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    DownloadApi.b(paramString1, paramString2, true);
  }
  
  public void destroy()
  {
    LogUtility.c("DownloadInterface", "destroy");
    JsCallbackManager.a().b(this);
    if (UpdateManager.a()) {
      UpdateManager.b().b(this.listener);
    }
  }
  
  public int doDownloadAction(String paramString)
  {
    LogUtility.c("TIME-STATISTIC", "DownloadInterface--doDownloadAction");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.mActivity) >= 6) {
      localBundle.putLong("OuterCall_JS_DoDownloadAction", System.currentTimeMillis());
    }
    String str;
    try
    {
      localJSONObject = new JSONObject(paramString);
      boolean bool = localJSONObject.has("delayDownload");
      if (!bool) {
        break label1194;
      }
      i = localJSONObject.optInt("delayDownload", -1);
      if ((this.mActivity instanceof BaseActivity)) {
        localObject1 = (AppInterface)((BaseActivity)this.mActivity).getAppRuntime();
      }
      localObject1 = localJSONObject.optString("appid");
      if (1 == i)
      {
        GameCenterUtil.a((String)localObject1, "DELAY_LIST");
        GameCenterUtil.a((String)localObject1, paramString, "DELAY_APPID_DETAIL_");
        GameCenterBroadcastReceiver.a();
        sendRemoteReq(DataFactory.a("gamecenter_delaydownload", "callback", 0, null), false, false);
        return 0;
      }
      if (i == 0) {
        GameCenterUtil.b((String)localObject1, "DELAY_LIST");
      }
      localObject1 = null;
      localBundle.putString(DownloadConstants.b, localJSONObject.optString("appid"));
      localBundle.putString(DownloadConstants.j, localJSONObject.optString("url"));
      localBundle.putString(DownloadConstants.f, localJSONObject.optString("packageName"));
      localBundle.putInt(DownloadConstants.k, localJSONObject.optInt("actionCode"));
      localBundle.putString(DownloadConstants.i, localJSONObject.optString("via"));
      localBundle.putString(DownloadConstants.l, localJSONObject.optString("appName"));
      localBundle.putBoolean(DownloadConstants.s, changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
      localBundle.putString(DownloadConstants.F, localJSONObject.optString("iconUrl"));
      localBundle.putInt(DownloadConstants.J, localJSONObject.optInt("showNotification"));
      localBundle.putBoolean(DownloadConstants.L, changeIntToBoolean(localJSONObject.optInt("isAutoInstallBySdk")));
      localBundle.putString(DownloadConstants.K, localJSONObject.optString("extraData"));
      localBundle.putString(DownloadConstants.H, localJSONObject.optString("downloadStyle"));
      localBundle.putString(DownloadConstants.I, localJSONObject.optString("downloadSize"));
      localBundle.putString(DownloadConstants.p, localJSONObject.optString("wording"));
      paramString = localJSONObject.optString("source");
      localBundle.putString("big_brother_source_key", paramString);
      bool = localJSONObject.optBoolean("isUniteDownload", false);
      localBundle.putBoolean(DownloadConstants.A, bool);
      if (QLog.isColorLevel()) {
        QLog.d("DownloadInterface", 2, new Object[] { "[UniteDownload] jsapi doDownloadAction: invoked. ", " source: ", paramString, " isUniteDownload: ", Boolean.valueOf(bool) });
      }
      str = localJSONObject.optString(DownloadConstants.D);
      paramString = new StringBuilder();
      paramString.append(" feedChannel:");
      paramString.append(str);
      LogUtility.d("DownloadInterface", paramString.toString());
      bool = TextUtils.isEmpty(str);
      localObject2 = "";
      paramString = (String)localObject2;
      if (!bool) {
        if (str.startsWith("0;"))
        {
          paramString = (String)localObject2;
        }
        else
        {
          paramString = str.split(";");
          if (paramString == null)
          {
            paramString = (String)localObject2;
          }
          else if (paramString.length <= 0)
          {
            paramString = (String)localObject2;
          }
          else
          {
            str = paramString[0];
            paramString = (String)localObject2;
            if (!TextUtils.isEmpty(str))
            {
              if (!str.equals("0")) {
                break label1197;
              }
              paramString = (String)localObject2;
            }
          }
        }
      }
      label629:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" finalFeedChannel:");
      ((StringBuilder)localObject2).append(paramString);
      LogUtility.d("DownloadInterface", ((StringBuilder)localObject2).toString());
      localBundle.putString(DownloadConstants.D, paramString);
      paramString = localJSONObject.optString("via");
      localObject2 = localJSONObject.optString("appid");
      i = localJSONObject.optInt("actionCode");
      if (this.lastActionRecord == null) {
        this.lastActionRecord = new LastDownloadAction((String)localObject2, paramString, i);
      } else if (this.lastActionRecord.a((String)localObject2, paramString, i)) {
        return 0;
      }
      paramString = (String)localObject1;
      if (localJSONObject.optInt("actionCode") == 12)
      {
        bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
        localBundle.putBoolean(DownloadConstants.o, bool);
        bool = localJSONObject.has("updateData");
        paramString = (String)localObject1;
        if (!bool) {}
      }
    }
    catch (NumberFormatException paramString)
    {
      JSONObject localJSONObject;
      int i;
      Object localObject1;
      Object localObject2;
      LogUtility.c("DownloadInterface", "Exception", paramString);
    }
    catch (JSONException paramString)
    {
      label944:
      label946:
      LogUtility.c("DownloadInterface", "JSONException", paramString);
    }
    try
    {
      localObject2 = localJSONObject.optString("updateData");
      paramString = (String)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramString = new ApkUpdateDetail();
      }
    }
    catch (Exception paramString)
    {
      break label944;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject2);
      paramString.packageName = ((JSONObject)localObject1).optString("packageName");
      paramString.newapksize = ((JSONObject)localObject1).optInt("newapksize");
      paramString.patchsize = ((JSONObject)localObject1).optInt("patchsize");
      paramString.updatemethod = ((JSONObject)localObject1).optInt("updatemethod");
      paramString.versioncode = ((JSONObject)localObject1).optInt("versioncode");
      paramString.versionname = ((JSONObject)localObject1).optString("versionname");
      paramString.fileMd5 = ((JSONObject)localObject1).optString("fileMd5");
      paramString.sigMd5 = ((JSONObject)localObject1).optString("sigMd5");
      paramString.url = ((JSONObject)localObject1).optString("url");
    }
    catch (Exception localException)
    {
      break label946;
    }
    paramString = null;
    LogUtility.c("DownloadInterface", "enter doDownloadAction updateData json");
    for (;;)
    {
      i = localJSONObject.optInt("myAppConfig");
      localBundle.putString(DownloadConstants.c, localJSONObject.optString("myAppId"));
      localBundle.putString(DownloadConstants.d, localJSONObject.optString("apkId"));
      localBundle.putInt(DownloadConstants.e, localJSONObject.optInt("versionCode"));
      localBundle.putInt(DownloadConstants.n, localJSONObject.optInt("toPageType"));
      localBundle.putBoolean(DownloadConstants.g, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
      localBundle.putBoolean(DownloadConstants.h, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
      localBundle.putBoolean(DownloadConstants.y, localJSONObject.optBoolean("bolckNotify"));
      localObject1 = parseSourceType(this.mActivity, localJSONObject);
      localBundle.putString("big_brother_ref_source_key", parseCurrentPageId(this.mActivity));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doDownloadAction object ");
      ((StringBuilder)localObject2).append(localJSONObject.toString());
      LogUtility.c("DownloadInterface", ((StringBuilder)localObject2).toString());
      DownloadApi.a(this.mActivity, localBundle, (String)localObject1, paramString, i);
      return 0;
      return -1;
      label1194:
      break;
      label1197:
      paramString = str;
      break label629;
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
      localObject = DownloadManager.b().h((String)localObject);
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
      LogUtility.c("DownloadInterface", "JSONException", paramString);
    }
    return -1;
  }
  
  public void doWifiDownloadAction(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doDownloadAction object ");
      localStringBuilder.append(paramString.toString());
      LogUtility.c("DownloadInterface", localStringBuilder.toString());
      paramString = paramString.optString("via");
      MyAppApi.l().a(this.mActivity, paramString, "biz_src_yyb");
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("DownloadInterface", "doWifiDownloadAction>>>", paramString);
    }
  }
  
  public void getDelayDownloadTasks()
  {
    Object localObject2 = GameCenterSpUtils.a("DELAY_LIST");
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = new JSONObject();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = ((String)localObject2).split("\\|");
      int i = 0;
      while (i < localObject2.length)
      {
        if (!TextUtils.isEmpty(localObject2[i])) {
          try
          {
            ((JSONObject)localObject1).put("appid", localObject2[i]);
            localJSONArray.put(localObject1);
          }
          catch (JSONException localJSONException)
          {
            LogUtility.c("DownloadInterface", "getDelayDownloadTasks>>>", localJSONException);
          }
        }
        i += 1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":");
    ((StringBuilder)localObject1).append(localJSONArray.toString());
    ((StringBuilder)localObject1).append("});}void(0);");
    jsCallBack(((StringBuilder)localObject1).toString());
  }
  
  public String getDownloadVersion()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DownloadApi.a());
    localStringBuilder.append("");
    return localStringBuilder.toString();
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
      LogUtility.c("DownloadInterface", "query>>>", paramString);
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
      LogUtility.c("DownloadInterface", "query>>>", paramString1);
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
      LogUtility.c("DownloadInterface", "query>>>", paramString);
    }
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  public void installYYB()
  {
    MyAppApi.l().c(this.mActivity);
  }
  
  protected void jsCallBack(String paramString)
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
      DownloadApi.a(this.mActivity, localBundle);
    }
    catch (JSONException paramString)
    {
      LogUtility.c("DownloadInterface", "JSONException", paramString);
    }
    return 0;
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    LogUtility.c("DownloadInterface", "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131901615), 0).show();
      }
    }
    else
    {
      if (paramBoolean1)
      {
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramBundle);
        return;
      }
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
    }
  }
  
  public int setDownloaderFirstOpenPage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new Bundle();
      paramString.putString("url", ((JSONObject)localObject).optString("url"));
      long l1 = ((JSONObject)localObject).optLong("starttime");
      long l2 = ((JSONObject)localObject).optLong("endtime");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      LogUtility.c("DownloadInterface", ((StringBuilder)localObject).toString());
      paramString.putLong("startTime", l1);
      paramString.putLong("endTime", l2);
      DownloadApi.a(paramString);
    }
    catch (JSONException paramString)
    {
      LogUtility.c("DownloadInterface", "JSONException", paramString);
    }
    return 0;
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
      DownloadApi.b(localBundle);
    }
    catch (JSONException paramString)
    {
      LogUtility.c("DownloadInterface", "JSONException", paramString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DownloadInterface
 * JD-Core Version:    0.7.0.1
 */