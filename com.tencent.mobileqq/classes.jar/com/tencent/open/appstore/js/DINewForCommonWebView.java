package com.tencent.open.appstore.js;

import abub;
import abuf;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import anvx;
import asdd;
import ashz;
import bjil;
import bjjq;
import bjju;
import bjjz;
import bjko;
import bjlq;
import bjlr;
import bjmy;
import bjnn;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DINewForCommonWebView
  extends BaseInterface
  implements bjlq
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bjil jdField_a_of_type_Bjil;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = "";
  
  public DINewForCommonWebView(Activity paramActivity, WebView paramWebView)
  {
    bjko.b("DINewForCommonWebView", "<DINewForCommonWebView>");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      bjjq.a().a(paramWebView);
      bjlr.a().a(this);
      return;
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!ashz.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), anvx.a(2131702807), 0).show();
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
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new DINewForCommonWebView.2(this, paramString));
  }
  
  private void a(JSONArray paramJSONArray, String paramString)
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
        localDownloadInfo.d = localJSONObject.optString("url");
        localDownloadInfo.e = localJSONObject.optString("packageName");
        localDownloadInfo.b = localJSONObject.optInt("versionCode");
        localDownloadInfo.c = localJSONObject.optString("appid");
        localDownloadInfo.a();
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      bjju.a().a(localArrayList, new bjjz(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      bjko.c("DINewForCommonWebView", "[innerQuery] e=", paramJSONArray);
    }
  }
  
  private static boolean a(int paramInt)
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
  
  public int batchDownloadByYYB(String paramString)
  {
    bjko.b("DINewForCommonWebView", ">batchDownloadByYYB" + paramString);
    if (!hasRight()) {
      return -1;
    }
    Object localObject6 = null;
    Object localObject1 = "";
    localObject5 = "";
    Object localObject2 = localObject6;
    localObject4 = localObject1;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject2 = localObject6;
        localObject4 = localObject1;
        paramString = localJSONObject.optJSONArray("appInfo");
        localObject2 = paramString;
        localObject4 = localObject1;
        localObject1 = localJSONObject.optString(bjmy.i);
        localObject2 = paramString;
        localObject4 = localObject1;
        i = localJSONObject.optInt(bjmy.k);
        bjko.c("DINewForCommonWebView", ">batchDownloadByYYB JSONException", (Throwable)localObject2);
      }
      catch (JSONException localJSONException3)
      {
        try
        {
          localObject2 = localJSONObject.optString("sourceType");
          localObject4 = localObject2;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            int i;
            localObject4 = paramString;
            paramString = (String)localObject5;
          }
        }
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject4 = DownloadInterface.getSourceInfoFromActivity(this.jdField_a_of_type_AndroidAppActivity);
          }
          localObject2 = localObject4;
          localObject4 = paramString;
          bjko.b("DINewForCommonWebView", ">batchDownloadByYYB appInfo:" + localObject4 + "||via:" + (String)localObject1);
          if ((localObject4 != null) && (((JSONArray)localObject4).length() != 0)) {
            break;
          }
          return -1;
        }
        catch (JSONException localJSONException2)
        {
          localObject5 = localJSONException1;
          Object localObject3 = localJSONException2;
          String str = paramString;
          paramString = (String)localObject5;
          break label211;
        }
        localJSONException3 = localJSONException3;
        i = 0;
        paramString = (String)localObject5;
        localObject1 = localObject4;
        localObject4 = localObject2;
        localObject2 = localJSONException3;
      }
      label211:
      localObject2 = paramString;
    }
    bjnn.a().a(this.jdField_a_of_type_AndroidAppActivity, (JSONArray)localObject4, i, (String)localObject1, (String)localObject2);
    return 0;
  }
  
  public void destroy()
  {
    bjko.b("DINewForCommonWebView", "destroy");
    bjlr.a().b(this);
  }
  
  public int doDownloadAction(String paramString)
  {
    localObject2 = null;
    bjko.b("DINewForCommonWebView", "[doDownloadAction]" + paramString);
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.jdField_a_of_type_AndroidAppActivity) >= 6) {
      localBundle.putLong("OuterCall_JS_DoDownloadAction", System.currentTimeMillis());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      str1 = localJSONObject.optString("appId");
      if (TextUtils.isEmpty(str1))
      {
        str1 = localJSONObject.optString("appid");
        if (localJSONObject.has("delayDownload"))
        {
          i = localJSONObject.optInt("delayDownload", -1);
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
            localObject1 = (AppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
          }
          if (1 == i)
          {
            abuf.c(str1, "DELAY_LIST");
            abuf.a(str1, paramString, "DELAY_APPID_DETAIL_");
            abub.a();
            a(asdd.a("gamecenter_delaydownload", "callback", 0, null), false, false);
            return 0;
          }
          if (i == 0) {
            abuf.b(str1, "DELAY_LIST");
          }
        }
        localBundle.putString(bjmy.b, str1);
        localBundle.putString(bjmy.j, localJSONObject.optString("url"));
        localBundle.putString(bjmy.f, localJSONObject.optString("packageName"));
        localBundle.putInt(bjmy.k, localJSONObject.optInt("actionCode"));
        localBundle.putString(bjmy.i, localJSONObject.optString("via"));
        localBundle.putString(bjmy.l, localJSONObject.optString("appName"));
        localBundle.putBoolean(bjmy.r, a(localJSONObject.optInt("showNetworkDialog")));
        localBundle.putString(bjmy.E, localJSONObject.optString("iconUrl"));
        localBundle.putInt(bjmy.I, localJSONObject.optInt("showNotification"));
        localBundle.putBoolean(bjmy.K, a(localJSONObject.optInt("isAutoInstallBySdk")));
        localBundle.putString(bjmy.J, localJSONObject.optString("extraData"));
        localBundle.putString(bjmy.G, localJSONObject.optString("downloadStyle"));
        localBundle.putLong(bjmy.H, localJSONObject.optLong("downloadSize"));
        localBundle.putString(bjmy.p, localJSONObject.optString("wording"));
        paramString = localJSONObject.optString(bjmy.C);
        bjko.b("DINewForCommonWebView", "[doDownloadAction] feedChannel:" + paramString);
        if (TextUtils.isEmpty(paramString)) {
          break label1352;
        }
        String str2;
        if (paramString.startsWith("0;"))
        {
          break label1352;
          str2 = localJSONObject.optString(bjmy.L);
          bjko.b("DINewForCommonWebView", "[doDownloadAction] finalFeedChannel:" + paramString);
          if (!TextUtils.isEmpty(paramString)) {
            break label1241;
          }
          localBundle.putString(bjmy.C, str2);
        }
        for (;;)
        {
          paramString = localJSONObject.optString("via");
          i = localJSONObject.optInt("actionCode");
          if (this.jdField_a_of_type_Bjil != null) {
            break label1265;
          }
          this.jdField_a_of_type_Bjil = new bjil(str1, paramString, i);
          if (localJSONObject.optInt("actionCode") != 12) {
            break label1344;
          }
          boolean bool = a(localJSONObject.optInt("updateType"));
          localBundle.putBoolean(bjmy.o, bool);
          bool = localJSONObject.has("updateData");
          if (!bool) {
            break label1344;
          }
          for (;;)
          {
            try
            {
              localObject1 = localJSONObject.optString("updateData");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              paramString = new ApkUpdateDetail();
            }
            catch (Exception localException2)
            {
              label1241:
              paramString = localObject2;
              continue;
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
              i = localJSONObject.optInt("myAppConfig");
              localBundle.putString(bjmy.c, str1);
              localBundle.putString(bjmy.d, localJSONObject.optString("apkId"));
              localBundle.putInt(bjmy.e, localJSONObject.optInt("versionCode"));
              localBundle.putInt(bjmy.n, localJSONObject.optInt("toPageType"));
              localBundle.putBoolean(bjmy.g, a(localJSONObject.optInt("isAutoDownload")));
              localBundle.putBoolean(bjmy.h, a(localJSONObject.optInt("isAutoInstall")));
              localBundle.putBoolean(bjmy.x, localJSONObject.optBoolean("bolckNotify"));
              localBundle.putString("recommendId", localJSONObject.optString("recommendId"));
              localBundle.putString("sourceFromServer", "" + localJSONObject.optInt("sourceFromServer"));
              localBundle.putString(bjmy.L, str2);
              localBundle.putString("pageId", "" + localJSONObject.optInt("pageId"));
              localBundle.putString("moduleId", "" + localJSONObject.optInt("moduleId"));
              localBundle.putString("positionId", "" + localJSONObject.optInt("positionId"));
              localBundle.putString("apkId", localJSONObject.optString("apkId"));
              localBundle.putString("appId", str1);
              localBundle.putInt("auto_start_yyb_download", localJSONObject.optInt("auto_start_yyb_download"));
              str1 = DownloadInterface.parseSourceType(this.jdField_a_of_type_AndroidAppActivity, localJSONObject);
              localBundle.putString("big_brother_ref_source_key", DownloadInterface.parseCurrentPageId(this.jdField_a_of_type_AndroidAppActivity));
              localBundle.putInt("hideInstallSuccessPage", localJSONObject.optInt("hideInstallSuccessPage"));
              bjko.b("DINewForCommonWebView", "[doDownloadAction] object " + localJSONObject.toString());
              bjju.a().a(this.jdField_a_of_type_AndroidAppActivity, localBundle, str1, paramString, i);
              return 0;
            }
            catch (Exception localException1) {}
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
          localObject1 = paramString[0];
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1358;
          }
          paramString = (String)localObject1;
          if (!((String)localObject1).equals("0")) {
            break;
          }
          break label1358;
          localBundle.putString(bjmy.C, paramString);
        }
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        String str1;
        int i;
        Object localObject1;
        bjko.c("DINewForCommonWebView", "[doDownloadAction] JSONException", paramString);
        return -1;
        if (this.jdField_a_of_type_Bjil.a(str1, paramString, i))
        {
          bjko.b("DINewForCommonWebView", "[doDownloadAction] repeat action,return");
          return 0;
          bjko.c("DINewForCommonWebView", "[doDownloadAction]  updateData e=" + ((Exception)localObject1).getMessage());
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        label1265:
        bjko.c("DINewForCommonWebView", "[doDownloadAction] Exception", paramString);
        continue;
        paramString = null;
        continue;
        label1344:
        paramString = null;
        continue;
        continue;
        label1352:
        paramString = "";
        continue;
        label1358:
        paramString = "";
      }
    }
  }
  
  public String getInterfaceName()
  {
    return "q_download_v2";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    bjko.b("DINewForCommonWebView", "<getQueryDownloadAction> paramJson=" + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      a(new JSONArray(paramString.optString("queryParams")), paramString.optString("callback"));
      return;
    }
    catch (JSONException paramString)
    {
      bjko.e("DINewForCommonWebView", "[queryDownloadAction] e=" + paramString.getMessage());
    }
  }
  
  public WebView getWebview()
  {
    return this.jdField_a_of_type_ComTencentSmttSdkWebView;
  }
  
  public void isYYBSupportBatchDownload(String paramString)
  {
    bjko.b("DINewForCommonWebView", ">isYYBSupportBatchDownload " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = bjnn.b();
      bjko.b("DINewForCommonWebView", ">isYYBSupportBatchDownload yybApiLevel=" + i);
      paramString = new StringBuilder().append("javascript:").append(paramString).append("(");
      if (i >= 9) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = bool + ")";
        bjko.c("DINewForCommonWebView", ">isYYBSupportBatchDownload:" + paramString);
        a(paramString);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
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
      bjju.a(this.jdField_a_of_type_AndroidAppActivity, localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bjko.c("DINewForCommonWebView", "JSONException", paramString);
      }
    }
  }
  
  public void queryYYBApiLevel(String paramString)
  {
    bjko.b("DINewForCommonWebView", ">queryYYBApiLevel " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = bjnn.b();
      bjko.b("DINewForCommonWebView", ">queryYYBApiLevel yybApiLevel=" + i);
      paramString = "javascript:" + paramString + "(" + i + ")";
      bjko.c("DINewForCommonWebView", ">queryYYBApiLevel:" + paramString);
      a(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    bjko.b("DINewForCommonWebView", "<registerDownloadCallBackListener> paramJsonStr=" + paramString);
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      bjko.b("DINewForCommonWebView", "<registerDownloadCallBackListener>" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
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
      bjju.a(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bjko.c("DINewForCommonWebView", "JSONException", paramString);
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
      bjju.b(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bjko.c("DINewForCommonWebView", "JSONException", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.js.DINewForCommonWebView
 * JD-Core Version:    0.7.0.1
 */