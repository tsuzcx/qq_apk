package com.tencent.open.export.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.JavaScriptInterface;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipDownloadInterface
  extends BaseInterface
  implements JavaScriptInterface, IJsCallBack
{
  protected final String a = VipDownloadInterface.class.getSimpleName();
  protected String b = "";
  protected Handler c;
  protected final WebView d;
  protected final Activity e;
  protected UpdateManager.OnCheckUpdateListener f;
  
  public VipDownloadInterface(Activity paramActivity, WebView paramWebView)
  {
    LogUtility.c(this.a, "init in");
    this.d = paramWebView;
    this.e = paramActivity;
    this.c = new Handler(Looper.getMainLooper());
    paramWebView = this.e;
    boolean bool = paramWebView instanceof PublicFragmentActivityForTool;
    paramActivity = null;
    if (bool) {
      paramActivity = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    } else if ((paramWebView instanceof BaseActivity)) {
      paramActivity = (AppInterface)((BaseActivity)paramWebView).getAppRuntime();
    }
    DownloadManager.b().a(paramActivity);
    DownloadManager.b();
    LogUtility.c(this.a, "init out");
  }
  
  protected void a(String paramString)
  {
    this.c.post(new VipDownloadInterface.3(this, paramString));
  }
  
  public boolean cancelDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return false;
    }
    DownloadApi.a(paramString1, paramString2, true);
    return true;
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
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enter checkUpdate json=");
    localStringBuilder.append(paramString1);
    LogUtility.c((String)localObject, localStringBuilder.toString());
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
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramString2.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
      }
      if (this.f == null)
      {
        this.f = new VipDownloadInterface.JsCheckUpdateCallback(this, paramString1);
        UpdateManager.b().a(this.f);
      }
      UpdateManager.b().a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c(this.a, "httpRequest JSONException", paramString1);
    }
  }
  
  public void destroy()
  {
    LogUtility.c(this.a, "destroy");
    JsCallbackManager.a().b(this);
    if (UpdateManager.a()) {
      UpdateManager.b().b(this.f);
    }
  }
  
  public void doDownloadAction(String paramString)
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("enter doDownloadAction json=");
    ((StringBuilder)localObject2).append(paramString);
    LogUtility.a((String)localObject1, ((StringBuilder)localObject2).toString());
    if (!hasRight()) {
      return;
    }
    Bundle localBundle = new Bundle();
    try
    {
      localObject2 = new JSONObject(paramString);
      int i = ((JSONObject)localObject2).optInt("myAppConfig");
      localObject1 = ((JSONObject)localObject2).optString(DownloadConstants.D);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals("0"))) {
        localObject1 = "";
      }
      Object localObject3 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finalChannel :");
      localStringBuilder.append((String)localObject1);
      LogUtility.a((String)localObject3, localStringBuilder.toString());
      if (i == 0) {
        try
        {
          localBundle.putString(DownloadConstants.b, ((JSONObject)localObject2).optString("appid"));
          localBundle.putString(DownloadConstants.j, ((JSONObject)localObject2).optString("url"));
          localBundle.putString(DownloadConstants.f, ((JSONObject)localObject2).optString("packageName"));
          localBundle.putInt(DownloadConstants.k, ((JSONObject)localObject2).optInt("actionCode"));
          localBundle.putString(DownloadConstants.i, ((JSONObject)localObject2).optString("via"));
          localBundle.putString(DownloadConstants.l, ((JSONObject)localObject2).optString("appName"));
          localBundle.putString(DownloadConstants.D, (String)localObject1);
          localObject1 = ((JSONObject)localObject2).optString("sourceType");
          paramString = (String)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramString = DownloadInterface.getSourceInfoFromActivity(this.e);
          }
          localObject1 = paramString;
          if (!"biz_src_news".equals(paramString)) {
            localObject1 = "biz_src_jc_vip";
          }
          paramString = this.a;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("doDownloadAction object ");
          ((StringBuilder)localObject3).append(((JSONObject)localObject2).toString());
          LogUtility.a(paramString, ((StringBuilder)localObject3).toString());
          DownloadApi.a(this.e, localBundle, (String)localObject1, null, 0);
          return;
        }
        catch (NumberFormatException paramString)
        {
          LogUtility.c(this.a, "Exception", paramString);
          return;
        }
      }
      try
      {
        try
        {
          localObject3 = new JSONObject(paramString);
          paramString = DownloadConstants.b;
          label750:
          try
          {
            localBundle.putString(paramString, ((JSONObject)localObject3).optString("appid"));
            localBundle.putString(DownloadConstants.j, ((JSONObject)localObject3).optString("url"));
            localBundle.putString(DownloadConstants.f, ((JSONObject)localObject3).optString("packageName"));
            localBundle.putInt(DownloadConstants.k, ((JSONObject)localObject3).optInt("actionCode"));
            localBundle.putString(DownloadConstants.i, ((JSONObject)localObject3).optString("via"));
            localBundle.putString(DownloadConstants.l, ((JSONObject)localObject3).optString("appName"));
            localBundle.putBoolean(DownloadConstants.s, DownloadInterface.changeIntToBoolean(((JSONObject)localObject3).optInt("showNetworkDialog")));
            localBundle.putString(DownloadConstants.p, ((JSONObject)localObject3).optString("wording"));
            localBundle.putString(DownloadConstants.D, (String)localObject1);
            ((JSONObject)localObject3).optString("via");
            ((JSONObject)localObject3).optString("appid");
            ((JSONObject)localObject3).optInt("actionCode");
            if (((JSONObject)localObject3).optInt("actionCode") != 12) {
              break label1014;
            }
            boolean bool = DownloadInterface.changeIntToBoolean(((JSONObject)localObject3).optInt("updateType"));
            localBundle.putBoolean(DownloadConstants.o, bool);
            bool = ((JSONObject)localObject3).has("updateData");
            if (!bool) {
              break label1014;
            }
          }
          catch (NumberFormatException paramString) {}
        }
        catch (NumberFormatException paramString) {}
      }
      catch (JSONException paramString)
      {
        LogUtility.c(this.a, "JSONException", paramString);
        return;
      }
    }
    catch (JSONException paramString)
    {
      LogUtility.c(this.a, "JSONException", paramString);
      return;
    }
    try
    {
      localObject1 = ((JSONObject)localObject3).optString("updateData");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1014;
      }
      paramString = new ApkUpdateDetail();
    }
    catch (Exception paramString)
    {
      break label753;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
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
      break label750;
    }
    break label755;
    label753:
    paramString = null;
    label755:
    LogUtility.c(this.a, "enter doDownloadAction updateData json");
    for (;;)
    {
      localBundle.putString(DownloadConstants.c, ((JSONObject)localObject3).optString("myAppId"));
      localBundle.putString(DownloadConstants.d, ((JSONObject)localObject3).optString("apkId"));
      localBundle.putInt(DownloadConstants.e, ((JSONObject)localObject3).optInt("versionCode", -10));
      localBundle.putInt(DownloadConstants.n, ((JSONObject)localObject3).optInt("toPageType"));
      localBundle.putBoolean(DownloadConstants.g, DownloadInterface.changeIntToBoolean(((JSONObject)localObject3).optInt("isAutoDownload")));
      localBundle.putBoolean(DownloadConstants.h, DownloadInterface.changeIntToBoolean(((JSONObject)localObject3).optInt("isAutoInstall")));
      localObject2 = ((JSONObject)localObject3).optString("sourceType");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = DownloadInterface.getSourceInfoFromActivity(this.e);
      }
      localObject2 = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doDownloadAction object ");
      localStringBuilder.append(((JSONObject)localObject3).toString());
      LogUtility.c((String)localObject2, localStringBuilder.toString());
      DownloadApi.a(this.e, localBundle, (String)localObject1, paramString, i);
      return;
      LogUtility.c(this.a, "Exception", paramString);
      return;
      label1014:
      paramString = null;
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
    return "q_download_vip";
  }
  
  public String getJsCallbackMethod()
  {
    return this.b;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("enter getQueryDownloadAction = ");
    ((StringBuilder)localObject2).append(paramString);
    LogUtility.b((String)localObject1, ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getJSONArray("infolist");
      localObject1 = ((JSONObject)localObject1).getString("guid");
      int j = paramString.length();
      localObject2 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.c = localJSONObject.optString("appid");
        localDownloadInfo.l = localJSONObject.optString("myAppId");
        localDownloadInfo.m = localJSONObject.optString("apkId");
        localDownloadInfo.e = localJSONObject.optString("packageName");
        localDownloadInfo.n = localJSONObject.optInt("versionCode");
        ((List)localObject2).add(localDownloadInfo);
        i += 1;
      }
      DownloadApi.a((List)localObject2, new VipDownloadInterface.1(this, (String)localObject1));
      return;
    }
    catch (JSONException paramString)
    {
      LogUtility.c(this.a, "getQueryDownloadAction>>>", paramString);
    }
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    paramString2 = this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enter getQueryDownloadAction = ");
    ((StringBuilder)localObject).append(paramString1);
    LogUtility.a(paramString2, ((StringBuilder)localObject).toString());
    if (!hasRight()) {
      return;
    }
    try
    {
      paramString1 = new JSONArray(paramString1);
      int j = paramString1.length();
      paramString2 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).c = paramString1.getString(i);
        paramString2.add(localObject);
        i += 1;
      }
      DownloadApi.a(paramString2, new VipDownloadInterface.2(this));
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c(this.a, "getQueryDownloadAction>>>", paramString1);
    }
  }
  
  public WebView getWebview()
  {
    return this.d;
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    JsCallbackManager.a().a(this);
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.export.js.VipDownloadInterface
 * JD-Core Version:    0.7.0.1
 */