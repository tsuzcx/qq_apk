package com.tencent.open.appstore.js;

import ajyc;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import anqp;
import anvl;
import bdfq;
import bdgv;
import bdgz;
import bdhe;
import bdht;
import bdiy;
import bdiz;
import bdkm;
import bdlc;
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
import ynz;
import yod;

public class DINewForCommonWebView
  extends BaseInterface
  implements bdiy
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bdfq jdField_a_of_type_Bdfq;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = "";
  
  public DINewForCommonWebView(Activity paramActivity, WebView paramWebView)
  {
    bdht.b("DINewForCommonWebView", "<DINewForCommonWebView>");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      bdgv.a().a(paramWebView);
      bdiz.a().a(this);
      return;
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!anvl.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), ajyc.a(2131703322), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      anvl.a().b(paramBundle);
      return;
    }
    anvl.a().a(paramBundle);
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
      bdgz.a().a(localArrayList, new bdhe(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      bdht.c("DINewForCommonWebView", "[innerQuery] e=", paramJSONArray);
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
    bdht.b("DINewForCommonWebView", ">batchDownloadByYYB" + paramString);
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
        localObject1 = localJSONObject.optString(bdkm.i);
        localObject2 = paramString;
        localObject4 = localObject1;
        i = localJSONObject.optInt(bdkm.k);
        bdht.c("DINewForCommonWebView", ">batchDownloadByYYB JSONException", (Throwable)localObject2);
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
          bdht.b("DINewForCommonWebView", ">batchDownloadByYYB appInfo:" + localObject4 + "||via:" + (String)localObject1);
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
    bdlc.a().a(this.jdField_a_of_type_AndroidAppActivity, (JSONArray)localObject4, i, (String)localObject1, (String)localObject2);
    return 0;
  }
  
  public void destroy()
  {
    bdht.b("DINewForCommonWebView", "destroy");
    bdiz.a().b(this);
  }
  
  public int doDownloadAction(String paramString)
  {
    localObject2 = null;
    bdht.b("DINewForCommonWebView", "[doDownloadAction]" + paramString);
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
            yod.c(str1, "DELAY_LIST");
            yod.a(str1, paramString, "DELAY_APPID_DETAIL_");
            ynz.a();
            a(anqp.a("gamecenter_delaydownload", "callback", 0, null), false, false);
            return 0;
          }
          if (i == 0) {
            yod.b(str1, "DELAY_LIST");
          }
        }
        localBundle.putString(bdkm.b, str1);
        localBundle.putString(bdkm.j, localJSONObject.optString("url"));
        localBundle.putString(bdkm.f, localJSONObject.optString("packageName"));
        localBundle.putInt(bdkm.k, localJSONObject.optInt("actionCode"));
        localBundle.putString(bdkm.i, localJSONObject.optString("via"));
        localBundle.putString(bdkm.l, localJSONObject.optString("appName"));
        localBundle.putBoolean(bdkm.r, a(localJSONObject.optInt("showNetworkDialog")));
        localBundle.putString(bdkm.D, localJSONObject.optString("iconUrl"));
        localBundle.putInt(bdkm.H, localJSONObject.optInt("showNotification"));
        localBundle.putBoolean(bdkm.J, a(localJSONObject.optInt("isAutoInstallBySdk")));
        localBundle.putString(bdkm.I, localJSONObject.optString("extraData"));
        localBundle.putString(bdkm.F, localJSONObject.optString("downloadStyle"));
        localBundle.putLong(bdkm.G, localJSONObject.optLong("downloadSize"));
        localBundle.putString(bdkm.p, localJSONObject.optString("wording"));
        paramString = localJSONObject.optString(bdkm.B);
        bdht.b("DINewForCommonWebView", "[doDownloadAction] feedChannel:" + paramString);
        if (TextUtils.isEmpty(paramString)) {
          break label1336;
        }
        String str2;
        if (paramString.startsWith("0;"))
        {
          break label1336;
          str2 = localJSONObject.optString(bdkm.K);
          bdht.b("DINewForCommonWebView", "[doDownloadAction] finalFeedChannel:" + paramString);
          if (!TextUtils.isEmpty(paramString)) {
            break label1225;
          }
          localBundle.putString(bdkm.B, str2);
        }
        for (;;)
        {
          paramString = localJSONObject.optString("via");
          i = localJSONObject.optInt("actionCode");
          if (this.jdField_a_of_type_Bdfq != null) {
            break label1249;
          }
          this.jdField_a_of_type_Bdfq = new bdfq(str1, paramString, i);
          if (localJSONObject.optInt("actionCode") != 12) {
            break label1328;
          }
          boolean bool = a(localJSONObject.optInt("updateType"));
          localBundle.putBoolean(bdkm.o, bool);
          bool = localJSONObject.has("updateData");
          if (!bool) {
            break label1328;
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
              label1225:
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
              localBundle.putString(bdkm.c, str1);
              localBundle.putString(bdkm.d, localJSONObject.optString("apkId"));
              localBundle.putInt(bdkm.e, localJSONObject.optInt("versionCode"));
              localBundle.putInt(bdkm.n, localJSONObject.optInt("toPageType"));
              localBundle.putBoolean(bdkm.g, a(localJSONObject.optInt("isAutoDownload")));
              localBundle.putBoolean(bdkm.h, a(localJSONObject.optInt("isAutoInstall")));
              localBundle.putBoolean(bdkm.x, localJSONObject.optBoolean("bolckNotify"));
              localBundle.putString("recommendId", localJSONObject.optString("recommendId"));
              localBundle.putString("sourceFromServer", "" + localJSONObject.optInt("sourceFromServer"));
              localBundle.putString(bdkm.K, str2);
              localBundle.putString("pageId", "" + localJSONObject.optInt("pageId"));
              localBundle.putString("moduleId", "" + localJSONObject.optInt("moduleId"));
              localBundle.putString("positionId", "" + localJSONObject.optInt("positionId"));
              localBundle.putString("apkId", localJSONObject.optString("apkId"));
              localBundle.putString("appId", str1);
              localBundle.putInt("auto_start_yyb_download", localJSONObject.optInt("auto_start_yyb_download"));
              str1 = DownloadInterface.parseSourceType(this.jdField_a_of_type_AndroidAppActivity, localJSONObject);
              localBundle.putString("big_brother_ref_source_key", DownloadInterface.parseCurrentPageId(this.jdField_a_of_type_AndroidAppActivity));
              bdht.b("DINewForCommonWebView", "[doDownloadAction] object " + localJSONObject.toString());
              bdgz.a().a(this.jdField_a_of_type_AndroidAppActivity, localBundle, str1, paramString, i);
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
            break label1342;
          }
          paramString = (String)localObject1;
          if (!((String)localObject1).equals("0")) {
            break;
          }
          break label1342;
          localBundle.putString(bdkm.B, paramString);
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
        bdht.c("DINewForCommonWebView", "[doDownloadAction] JSONException", paramString);
        return -1;
        if (this.jdField_a_of_type_Bdfq.a(str1, paramString, i))
        {
          bdht.b("DINewForCommonWebView", "[doDownloadAction] repeat action,return");
          return 0;
          bdht.c("DINewForCommonWebView", "[doDownloadAction]  updateData e=" + ((Exception)localObject1).getMessage());
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        label1249:
        bdht.c("DINewForCommonWebView", "[doDownloadAction] Exception", paramString);
        continue;
        paramString = null;
        continue;
        label1328:
        paramString = null;
        continue;
        continue;
        label1336:
        paramString = "";
        continue;
        label1342:
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
    bdht.b("DINewForCommonWebView", "<getQueryDownloadAction> paramJson=" + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      a(new JSONArray(paramString.optString("queryParams")), paramString.optString("callback"));
      return;
    }
    catch (JSONException paramString)
    {
      bdht.e("DINewForCommonWebView", "[queryDownloadAction] e=" + paramString.getMessage());
    }
  }
  
  public WebView getWebview()
  {
    return this.jdField_a_of_type_ComTencentSmttSdkWebView;
  }
  
  public void isYYBSupportBatchDownload(String paramString)
  {
    bdht.b("DINewForCommonWebView", ">isYYBSupportBatchDownload " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = bdlc.b();
      bdht.b("DINewForCommonWebView", ">isYYBSupportBatchDownload yybApiLevel=" + i);
      paramString = new StringBuilder().append("javascript:").append(paramString).append("(");
      if (i >= 9) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = bool + ")";
        bdht.c("DINewForCommonWebView", ">isYYBSupportBatchDownload:" + paramString);
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
      bdgz.a(this.jdField_a_of_type_AndroidAppActivity, localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bdht.c("DINewForCommonWebView", "JSONException", paramString);
      }
    }
  }
  
  public void queryYYBApiLevel(String paramString)
  {
    bdht.b("DINewForCommonWebView", ">queryYYBApiLevel " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = bdlc.b();
      bdht.b("DINewForCommonWebView", ">queryYYBApiLevel yybApiLevel=" + i);
      paramString = "javascript:" + paramString + "(" + i + ")";
      bdht.c("DINewForCommonWebView", ">queryYYBApiLevel:" + paramString);
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
    bdht.b("DINewForCommonWebView", "<registerDownloadCallBackListener> paramJsonStr=" + paramString);
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      bdht.b("DINewForCommonWebView", "<registerDownloadCallBackListener>" + this.jdField_a_of_type_JavaLangString);
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
      bdgz.a(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bdht.c("DINewForCommonWebView", "JSONException", paramString);
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
      bdgz.b(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bdht.c("DINewForCommonWebView", "JSONException", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.js.DINewForCommonWebView
 * JD-Core Version:    0.7.0.1
 */