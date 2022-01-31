package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bffi;
import bffm;
import bffn;
import bffq;
import bfhg;
import bfil;
import bfju;
import bfjy;
import bfkb;
import bflh;
import bfli;
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
  implements bfil
{
  public static final String PLUGIN_NAMESPACE = "q_download_now";
  protected final String TAG = DownloadWebInterface.class.getSimpleName();
  protected String jsCallBackMethod = "";
  protected bfli listener;
  protected Activity mActivity;
  protected Handler mHandler;
  protected final WebView webview;
  
  public DownloadWebInterface(Activity paramActivity, WebView paramWebView)
  {
    bfhg.c(this.TAG, "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      bfkb.a().a(paramWebView);
      bffq.a().a(this);
      bfhg.c(this.TAG, "init out");
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
    bfhg.c(this.TAG, "destroy");
    bffq.a().b(this);
    if (bflh.a()) {
      bflh.a().b(this.listener);
    }
    bffi.a().b(bffm.a());
  }
  
  public int doDownloadAction(String paramString)
  {
    bfhg.c("TIME-STATISTIC", "DownloadWebInterface--doDownloadAction");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    try
    {
      localJSONObject = new JSONObject(paramString);
      localBundle.putString(bfjy.b, localJSONObject.optString("appid"));
      localBundle.putString(bfjy.j, localJSONObject.optString("url"));
      localBundle.putString(bfjy.f, localJSONObject.optString("packageName"));
      localBundle.putInt(bfjy.k, localJSONObject.optInt("actionCode"));
      localBundle.putString(bfjy.i, localJSONObject.optString("via"));
      localBundle.putString(bfjy.l, localJSONObject.optString("appName"));
      localBundle.putBoolean(bfjy.r, changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
      localBundle.putString(bfjy.D, localJSONObject.optString("iconUrl"));
      localBundle.putInt(bfjy.H, localJSONObject.optInt("showNotification"));
      localBundle.putBoolean(bfjy.J, changeIntToBoolean(localJSONObject.optInt("isAutoInstallBySdk")));
      localBundle.putString(bfjy.I, localJSONObject.optString("extraData"));
      localBundle.putString(bfjy.F, localJSONObject.optString("downloadStyle"));
      localBundle.putString(bfjy.G, localJSONObject.optString("downloadSize"));
      localBundle.putString(bfjy.p, localJSONObject.optString("wording"));
      if (localJSONObject.has("bolckNotify")) {
        localBundle.putBoolean(bfjy.x, localJSONObject.optBoolean("bolckNotify"));
      }
      paramString = localJSONObject.optString(bfjy.B);
      bfhg.d(this.TAG, " feedChannel:" + paramString);
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
      bfhg.c(this.TAG, "JSONException", paramString);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        bfhg.c(this.TAG, "Exception", paramString);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        paramString = "";
      }
    }
    bfhg.d(this.TAG, " finalFeedChannel:" + paramString);
    localBundle.putString(bfjy.B, paramString);
    localJSONObject.optString("via");
    localJSONObject.optString("appid");
    i = localJSONObject.optInt("actionCode");
    localObject = null;
    paramString = (String)localObject;
    if (i == 12)
    {
      bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
      localBundle.putBoolean(bfjy.o, bool);
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
        localBundle.putString(bfjy.c, localJSONObject.optString("myAppId"));
        localBundle.putString(bfjy.d, localJSONObject.optString("apkId"));
        localBundle.putInt(bfjy.e, localJSONObject.optInt("versionCode"));
        localBundle.putInt(bfjy.n, localJSONObject.optInt("toPageType"));
        localBundle.putBoolean(bfjy.g, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
        localBundle.putBoolean(bfjy.h, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
        str = localJSONObject.optString("sourceType");
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = DownloadInterface.getSourceInfoFromActivity(this.mActivity);
        }
        bfhg.c(this.TAG, "doDownloadAction object " + localJSONObject.toString());
        bffn.a(this.mActivity, localBundle, (String)localObject, paramString, i);
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
      bfhg.c(this.TAG, "enter doDownloadAction updateData json");
    }
  }
  
  public String getDownloadVersion()
  {
    return bfju.a() + "";
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
    bfhg.c(this.TAG, "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
    bffi.a().a(bffm.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadWebInterface
 * JD-Core Version:    0.7.0.1
 */