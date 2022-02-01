package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bjrz;
import bjsd;
import bjse;
import bjsh;
import bjtx;
import bjvc;
import bjwk;
import bjwo;
import bjwq;
import bjxw;
import bjxx;
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
  implements bjvc
{
  public static final String PLUGIN_NAMESPACE = "q_download_now";
  protected final String TAG = DownloadWebInterface.class.getSimpleName();
  protected String jsCallBackMethod = "";
  protected bjxx listener;
  protected Activity mActivity;
  protected Handler mHandler;
  protected final WebView webview;
  
  public DownloadWebInterface(Activity paramActivity, WebView paramWebView)
  {
    bjtx.c(this.TAG, "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      bjwq.a().a(paramWebView);
      bjsh.a().a(this);
      bjtx.c(this.TAG, "init out");
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
    bjtx.c(this.TAG, "destroy");
    bjsh.a().b(this);
    if (bjxw.a()) {
      bjxw.a().b(this.listener);
    }
    bjrz.a().b(bjsd.a());
  }
  
  public int doDownloadAction(String paramString)
  {
    bjtx.c("TIME-STATISTIC", "DownloadWebInterface--doDownloadAction");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    try
    {
      localJSONObject = new JSONObject(paramString);
      localBundle.putString(bjwo.b, localJSONObject.optString("appid"));
      localBundle.putString(bjwo.j, localJSONObject.optString("url"));
      localBundle.putString(bjwo.f, localJSONObject.optString("packageName"));
      localBundle.putInt(bjwo.k, localJSONObject.optInt("actionCode"));
      localBundle.putString(bjwo.i, localJSONObject.optString("via"));
      localBundle.putString(bjwo.l, localJSONObject.optString("appName"));
      localBundle.putBoolean(bjwo.r, changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
      localBundle.putString(bjwo.D, localJSONObject.optString("iconUrl"));
      localBundle.putInt(bjwo.H, localJSONObject.optInt("showNotification"));
      localBundle.putBoolean(bjwo.J, changeIntToBoolean(localJSONObject.optInt("isAutoInstallBySdk")));
      localBundle.putString(bjwo.I, localJSONObject.optString("extraData"));
      localBundle.putString(bjwo.F, localJSONObject.optString("downloadStyle"));
      localBundle.putString(bjwo.G, localJSONObject.optString("downloadSize"));
      localBundle.putString(bjwo.p, localJSONObject.optString("wording"));
      if (localJSONObject.has("bolckNotify")) {
        localBundle.putBoolean(bjwo.x, localJSONObject.optBoolean("bolckNotify"));
      }
      paramString = localJSONObject.optString(bjwo.B);
      bjtx.d(this.TAG, " feedChannel:" + paramString);
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
      bjtx.c(this.TAG, "JSONException", paramString);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        bjtx.c(this.TAG, "Exception", paramString);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        paramString = "";
      }
    }
    bjtx.d(this.TAG, " finalFeedChannel:" + paramString);
    localBundle.putString(bjwo.B, paramString);
    localJSONObject.optString("via");
    localJSONObject.optString("appid");
    i = localJSONObject.optInt("actionCode");
    localObject = null;
    paramString = (String)localObject;
    if (i == 12)
    {
      bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
      localBundle.putBoolean(bjwo.o, bool);
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
        localBundle.putString(bjwo.c, localJSONObject.optString("myAppId"));
        localBundle.putString(bjwo.d, localJSONObject.optString("apkId"));
        localBundle.putInt(bjwo.e, localJSONObject.optInt("versionCode"));
        localBundle.putInt(bjwo.n, localJSONObject.optInt("toPageType"));
        localBundle.putBoolean(bjwo.g, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
        localBundle.putBoolean(bjwo.h, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
        str = localJSONObject.optString("sourceType");
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = DownloadInterface.getSourceInfoFromActivity(this.mActivity);
        }
        bjtx.c(this.TAG, "doDownloadAction object " + localJSONObject.toString());
        bjse.a(this.mActivity, localBundle, (String)localObject, paramString, i);
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
      bjtx.c(this.TAG, "enter doDownloadAction updateData json");
    }
  }
  
  public String getDownloadVersion()
  {
    return bjwk.a() + "";
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
    bjtx.c(this.TAG, "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
    bjrz.a().a(bjsd.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadWebInterface
 * JD-Core Version:    0.7.0.1
 */