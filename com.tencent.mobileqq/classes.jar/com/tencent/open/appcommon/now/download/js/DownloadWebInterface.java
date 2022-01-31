package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bdgk;
import bdgo;
import bdgp;
import bdgs;
import bdii;
import bdjn;
import bdkx;
import bdlb;
import bdle;
import bdmk;
import bdml;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadWebInterface
  extends BaseInterface
  implements bdjn
{
  public static final String PLUGIN_NAMESPACE = "q_download_now";
  protected final String TAG = DownloadWebInterface.class.getSimpleName();
  protected String jsCallBackMethod = "";
  protected bdml listener;
  protected Activity mActivity;
  protected Handler mHandler;
  protected final WebView webview;
  
  public DownloadWebInterface(Activity paramActivity, WebView paramWebView)
  {
    bdii.c(this.TAG, "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      bdle.a().a(paramWebView);
      bdgs.a().a(this);
      bdii.c(this.TAG, "init out");
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
  
  public void destroy()
  {
    bdii.c(this.TAG, "destroy");
    bdgs.a().b(this);
    if (bdmk.a()) {
      bdmk.a().b(this.listener);
    }
    bdgk.a().b(bdgo.a());
  }
  
  public int doDownloadAction(String paramString)
  {
    bdii.c("TIME-STATISTIC", "DownloadWebInterface--doDownloadAction");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    try
    {
      localJSONObject = new JSONObject(paramString);
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
      if (localJSONObject.has("bolckNotify")) {
        localBundle.putBoolean(bdlb.x, localJSONObject.optBoolean("bolckNotify"));
      }
      paramString = localJSONObject.optString(bdlb.B);
      bdii.d(this.TAG, " feedChannel:" + paramString);
      if (TextUtils.isEmpty(paramString)) {
        break label886;
      }
      if (!paramString.startsWith("0;")) {
        break label775;
      }
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      int i;
      Object localObject;
      boolean bool;
      bdii.c(this.TAG, "JSONException", paramString);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        bdii.c(this.TAG, "Exception", paramString);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        paramString = "";
      }
    }
    bdii.d(this.TAG, " finalFeedChannel:" + paramString);
    localBundle.putString(bdlb.B, paramString);
    localJSONObject.optString("via");
    localJSONObject.optString("appid");
    i = localJSONObject.optInt("actionCode");
    localObject = null;
    paramString = (String)localObject;
    if (i == 12)
    {
      bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
      localBundle.putBoolean(bdlb.o, bool);
      bool = localJSONObject.has("updateData");
      paramString = (String)localObject;
      if (!bool) {}
    }
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
        String str;
        label775:
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
        str = localJSONObject.optString("sourceType");
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = DownloadInterface.getSourceInfoFromActivity(this.mActivity);
        }
        bdii.c(this.TAG, "doDownloadAction object " + localJSONObject.toString());
        bdgp.a(this.mActivity, localBundle, (String)localObject, paramString, i);
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
      bdii.c(this.TAG, "enter doDownloadAction updateData json");
    }
  }
  
  public String getDownloadVersion()
  {
    return bdkx.a() + "";
  }
  
  public String getInterfaceName()
  {
    return "q_download_now";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jsCallBackMethod;
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  protected void jsCallBack(String paramString)
  {
    this.mHandler.post(new DownloadWebInterface.1(this, paramString));
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    bdii.c(this.TAG, "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
    bdgk.a().a(bdgo.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadWebInterface
 * JD-Core Version:    0.7.0.1
 */