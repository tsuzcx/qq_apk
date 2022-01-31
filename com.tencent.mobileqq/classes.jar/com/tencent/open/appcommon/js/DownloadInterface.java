package com.tencent.open.appcommon.js;

import ajya;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import anqu;
import anvq;
import bdfx;
import bdfy;
import bdfz;
import bdgf;
import bdii;
import bdjn;
import bdjo;
import bdkx;
import bdlb;
import bdle;
import bdlr;
import bdmk;
import bdml;
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
import ynw;
import yoa;

public class DownloadInterface
  extends BaseInterface
  implements bdjn
{
  public static final String PLUGIN_NAMESPACE = "q_download";
  private static final String TAG = "DownloadInterface";
  protected String jsCallBackMethod = "";
  bdgf lastActionRecord = null;
  protected bdml listener;
  protected Activity mActivity;
  protected Handler mHandler;
  protected final WebView webview;
  
  public DownloadInterface(Activity paramActivity, WebView paramWebView)
  {
    bdii.c("DownloadInterface", "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      bdle.a().a(paramWebView);
      bdjo.a().a(this);
      bdii.c("DownloadInterface", "init out");
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
      bdkx.a(localArrayList, new bdfx(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      bdii.c("DownloadInterface", "innerQueryDownloadInfo>>>", paramJSONArray);
    }
  }
  
  private void innerQueryDownloadInfoByVia(String paramString1, String paramString2)
  {
    try
    {
      bdkx.a(paramString1, new bdfy(this, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      bdii.c("DownloadInterface", "innerQueryDownloadInfoByVia Exception>>>", paramString1);
    }
  }
  
  public static String parseCurrentPageId(Activity paramActivity)
  {
    String str2 = getRefIdFromActivity(paramActivity);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getSourceInfoFromActivity(paramActivity);
    }
    bdii.c("DownloadInterface", ">parseCurrentPageId " + str1);
    return str1;
  }
  
  public static String parseSourceType(Activity paramActivity, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("sourceType");
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = getSourceInfoFromActivity(paramActivity);
    }
    bdii.b("DownloadInterface", ">parseSourceType sourceType=" + paramJSONObject);
    return paramJSONObject;
  }
  
  public void cancelDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    bdkx.a(paramString1, paramString2, true);
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bdle.a().a(paramString);
  }
  
  public void checkUpdate(String paramString)
  {
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    bdii.c("DownloadInterface", "enter checkUpdate json=" + paramString1 + ", guid = " + paramString2);
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
          this.listener = new bdfz(this, paramString1);
          bdmk.a().a(this.listener);
          bdmk.a().a(paramString2);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        bdii.c("DownloadInterface", "httpRequest JSONException", paramString1);
        return;
      }
      ((bdfz)this.listener).b(paramString1);
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
        yoa.b(paramString.get(i).toString(), "DELAY_LIST");
        i += 1;
      }
      jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
      return;
    }
    catch (Exception paramString)
    {
      bdii.c("DownloadInterface", "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  public void deleteDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    bdkx.b(paramString1, paramString2, true);
  }
  
  public void destroy()
  {
    bdii.c("DownloadInterface", "destroy");
    bdjo.a().b(this);
    if (bdmk.a()) {
      bdmk.a().b(this.listener);
    }
  }
  
  public int doDownloadAction(String paramString)
  {
    bdii.c("TIME-STATISTIC", "DownloadInterface--doDownloadAction");
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
          yoa.c((String)localObject, "DELAY_LIST");
          yoa.a((String)localObject, paramString, "DELAY_APPID_DETAIL_");
          ynw.a();
          sendRemoteReq(anqu.a("gamecenter_delaydownload", "callback", 0, null), false, false);
          return 0;
        }
        if (i == 0) {
          yoa.b((String)localObject, "DELAY_LIST");
        }
      }
      localBundle.putString(bdlb.b, localJSONObject.optString("appid"));
      localBundle.putString(bdlb.j, localJSONObject.optString("url"));
      localBundle.putString(bdlb.f, localJSONObject.optString("packageName"));
      localBundle.putInt(bdlb.k, localJSONObject.optInt("actionCode"));
      localBundle.putString(bdlb.i, localJSONObject.optString("via"));
      localBundle.putString(bdlb.l, localJSONObject.optString("appName"));
      localBundle.putBoolean(bdlb.r, changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
      localBundle.putString(bdlb.D, localJSONObject.optString("iconUrl"));
      localBundle.putInt(bdlb.H, localJSONObject.optInt("showNotification"));
      localBundle.putBoolean(bdlb.J, changeIntToBoolean(localJSONObject.optInt("isAutoInstallBySdk")));
      localBundle.putString(bdlb.I, localJSONObject.optString("extraData"));
      localBundle.putString(bdlb.F, localJSONObject.optString("downloadStyle"));
      localBundle.putString(bdlb.G, localJSONObject.optString("downloadSize"));
      localBundle.putString(bdlb.p, localJSONObject.optString("wording"));
      paramString = localJSONObject.optString(bdlb.B);
      bdii.d("DownloadInterface", " feedChannel:" + paramString);
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
      bdii.c("DownloadInterface", "JSONException", paramString);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        bdii.c("DownloadInterface", "Exception", paramString);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        paramString = "";
      }
    }
    bdii.d("DownloadInterface", " finalFeedChannel:" + paramString);
    localBundle.putString(bdlb.B, paramString);
    paramString = localJSONObject.optString("via");
    localObject = localJSONObject.optString("appid");
    i = localJSONObject.optInt("actionCode");
    if (this.lastActionRecord == null)
    {
      this.lastActionRecord = new bdgf((String)localObject, paramString, i);
      label539:
      if (localJSONObject.optInt("actionCode") == 12)
      {
        bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
        localBundle.putBoolean(bdlb.o, bool);
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
          localBundle.putString(bdlb.c, localJSONObject.optString("myAppId"));
          localBundle.putString(bdlb.d, localJSONObject.optString("apkId"));
          localBundle.putInt(bdlb.e, localJSONObject.optInt("versionCode"));
          localBundle.putInt(bdlb.n, localJSONObject.optInt("toPageType"));
          localBundle.putBoolean(bdlb.g, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
          localBundle.putBoolean(bdlb.h, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
          localBundle.putBoolean(bdlb.x, localJSONObject.optBoolean("bolckNotify"));
          localObject = parseSourceType(this.mActivity, localJSONObject);
          localBundle.putString("big_brother_ref_source_key", parseCurrentPageId(this.mActivity));
          bdii.c("DownloadInterface", "doDownloadAction object " + localJSONObject.toString());
          bdkx.a(this.mActivity, localBundle, (String)localObject, paramString, i);
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
        bdii.c("DownloadInterface", "enter doDownloadAction updateData json");
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
      localObject = bdle.a().a((String)localObject);
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
      bdii.c("DownloadInterface", "JSONException", paramString);
    }
    return -1;
  }
  
  public void doWifiDownloadAction(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      bdii.c("DownloadInterface", "doDownloadAction object " + paramString.toString());
      paramString = paramString.optString("via");
      bdlr.a().a(this.mActivity, paramString, "biz_src_yyb");
      return;
    }
    catch (Exception paramString)
    {
      bdii.c("DownloadInterface", "doWifiDownloadAction>>>", paramString);
    }
  }
  
  public void getDelayDownloadTasks()
  {
    Object localObject = yoa.a("DELAY_LIST");
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
              bdii.c("DownloadInterface", "getDelayDownloadTasks>>>", localJSONException);
            }
          }
        }
      }
    }
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + localJSONArray.toString() + "});}void(0);");
  }
  
  public String getDownloadVersion()
  {
    return bdkx.a() + "";
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
      bdii.c("DownloadInterface", "query>>>", paramString);
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
      bdii.c("DownloadInterface", "query>>>", paramString1);
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
      bdii.c("DownloadInterface", "query>>>", paramString);
    }
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  public void installYYB()
  {
    bdlr.a().c(this.mActivity);
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
      bdkx.a(this.mActivity, localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bdii.c("DownloadInterface", "JSONException", paramString);
      }
    }
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    bdii.c("DownloadInterface", "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!anvq.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), ajya.a(2131703513), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      anvq.a().b(paramBundle);
      return;
    }
    anvq.a().a(paramBundle);
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
      bdii.c("DownloadInterface", l1 + "|" + l2 + "|" + (System.currentTimeMillis() - l1));
      localBundle.putLong("startTime", l1);
      localBundle.putLong("endTime", l2);
      bdkx.a(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bdii.c("DownloadInterface", "JSONException", paramString);
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
      bdkx.b(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bdii.c("DownloadInterface", "JSONException", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DownloadInterface
 * JD-Core Version:    0.7.0.1
 */