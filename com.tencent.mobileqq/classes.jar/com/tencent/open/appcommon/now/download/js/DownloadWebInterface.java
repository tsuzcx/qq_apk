package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadWebInterface
  extends BaseInterface
  implements IJsCallBack
{
  public static final String PLUGIN_NAMESPACE = "q_download_now";
  protected final String TAG = DownloadWebInterface.class.getSimpleName();
  protected String jsCallBackMethod = "";
  protected UpdateManager.OnCheckUpdateListener listener;
  protected Activity mActivity;
  protected Handler mHandler;
  protected final WebView webview;
  
  public DownloadWebInterface(Activity paramActivity, WebView paramWebView)
  {
    LogUtility.c(this.TAG, "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    boolean bool = paramActivity instanceof PublicFragmentActivityForTool;
    paramWebView = null;
    if (bool) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    } else if ((paramActivity instanceof BaseActivity)) {
      paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
    }
    DownloadManager.b().a(paramWebView);
    H5JSCallbackManager.a().a(this);
    LogUtility.c(this.TAG, "init out");
  }
  
  public static boolean changeIntToBoolean(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    if (paramInt == 1) {}
    return true;
  }
  
  public void destroy()
  {
    LogUtility.c(this.TAG, "destroy");
    H5JSCallbackManager.a().b(this);
    if (UpdateManager.a()) {
      UpdateManager.b().b(this.listener);
    }
    DownloadCenterImpl.a().b(DownloadCallbackWebImpl.a());
  }
  
  public int doDownloadAction(String paramString)
  {
    LogUtility.c("TIME-STATISTIC", "DownloadWebInterface--doDownloadAction");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
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
        if (localJSONObject.has("bolckNotify")) {
          localBundle.putBoolean(DownloadConstants.y, localJSONObject.optBoolean("bolckNotify"));
        }
        localObject2 = localJSONObject.optString(DownloadConstants.D);
        paramString = this.TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" feedChannel:");
        ((StringBuilder)localObject1).append((String)localObject2);
        LogUtility.d(paramString, ((StringBuilder)localObject1).toString());
        boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
        localObject1 = "";
        paramString = (String)localObject1;
        if (!bool) {
          if (((String)localObject2).startsWith("0;"))
          {
            paramString = (String)localObject1;
          }
          else
          {
            paramString = ((String)localObject2).split(";");
            if (paramString == null)
            {
              paramString = (String)localObject1;
            }
            else if (paramString.length <= 0)
            {
              paramString = (String)localObject1;
            }
            else
            {
              localObject2 = paramString[0];
              paramString = (String)localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                if (!((String)localObject2).equals("0")) {
                  break label953;
                }
                paramString = (String)localObject1;
              }
            }
          }
        }
        localObject1 = this.TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" finalFeedChannel:");
        ((StringBuilder)localObject2).append(paramString);
        LogUtility.d((String)localObject1, ((StringBuilder)localObject2).toString());
        localBundle.putString(DownloadConstants.D, paramString);
        localJSONObject.optString("via");
        localJSONObject.optString("appid");
        i = localJSONObject.optInt("actionCode");
        localObject2 = null;
        localObject1 = null;
        paramString = (String)localObject2;
        if (i == 12)
        {
          bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
          localBundle.putBoolean(DownloadConstants.o, bool);
          bool = localJSONObject.has("updateData");
          paramString = (String)localObject2;
          if (!bool) {}
        }
      }
      catch (NumberFormatException paramString)
      {
        JSONObject localJSONObject;
        int i;
        Object localObject3;
        LogUtility.c(this.TAG, "Exception", paramString);
        return -1;
      }
      catch (JSONException paramString)
      {
        LogUtility.c(this.TAG, "JSONException", paramString);
        return -1;
      }
      try
      {
        localObject3 = localJSONObject.optString("updateData");
        paramString = (String)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          paramString = new ApkUpdateDetail();
        }
      }
      catch (Exception paramString)
      {
        paramString = (String)localObject1;
        continue;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject3);
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
        continue;
      }
      LogUtility.c(this.TAG, "enter doDownloadAction updateData json");
      i = localJSONObject.optInt("myAppConfig");
      localBundle.putString(DownloadConstants.c, localJSONObject.optString("myAppId"));
      localBundle.putString(DownloadConstants.d, localJSONObject.optString("apkId"));
      localBundle.putInt(DownloadConstants.e, localJSONObject.optInt("versionCode"));
      localBundle.putInt(DownloadConstants.n, localJSONObject.optInt("toPageType"));
      localBundle.putBoolean(DownloadConstants.g, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
      localBundle.putBoolean(DownloadConstants.h, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
      Object localObject2 = localJSONObject.optString("sourceType");
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = DownloadInterface.getSourceInfoFromActivity(this.mActivity);
      }
      localObject2 = this.TAG;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("doDownloadAction object ");
      ((StringBuilder)localObject3).append(localJSONObject.toString());
      LogUtility.c((String)localObject2, ((StringBuilder)localObject3).toString());
      DownloadJSApi.a(this.mActivity, localBundle, (String)localObject1, paramString, i);
      return 0;
      label953:
      paramString = (String)localObject2;
    }
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
    LogUtility.c(this.TAG, "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
    DownloadCenterImpl.a().a(DownloadCallbackWebImpl.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadWebInterface
 * JD-Core Version:    0.7.0.1
 */