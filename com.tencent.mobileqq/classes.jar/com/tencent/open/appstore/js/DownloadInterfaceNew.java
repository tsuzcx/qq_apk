package com.tencent.open.appstore.js;

import ajjy;
import anah;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import anfc;
import bcbp;
import bccu;
import bccy;
import bcdf;
import bcds;
import bcex;
import bcey;
import bcgl;
import bchb;
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
import yev;
import yez;

public class DownloadInterfaceNew
  extends BaseInterface
  implements bcex
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bcbp jdField_a_of_type_Bcbp;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = "";
  
  public DownloadInterfaceNew(Activity paramActivity, WebView paramWebView)
  {
    bcds.b("DownloadInterfaceNew", "<DownloadInterfaceNew>");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      bccu.a().a(paramWebView);
      bcey.a().a(this);
      return;
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!anfc.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), ajjy.a(2131637705), 0).show();
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
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new DownloadInterfaceNew.2(this, paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = bccy.a().a();
    bcds.c("DownloadInterfaceNew", "[getAllSDKDownloadInfos] infos size = " + paramString1.size());
    JSONArray localJSONArray = new JSONArray();
    int j = paramString1.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        JSONObject localJSONObject = new JSONObject();
        DownloadInfo localDownloadInfo = (DownloadInfo)paramString1.get(i);
        try
        {
          localJSONObject.put("appid", localDownloadInfo.jdField_c_of_type_JavaLangString);
          localJSONObject.put("apkid", localDownloadInfo.k);
          localJSONObject.put("packagename", localDownloadInfo.e);
          localJSONObject.put("versioncode", localDownloadInfo.b);
          localJSONObject.put("url", localDownloadInfo.d);
          localJSONObject.put("pro", localDownloadInfo.f);
          localJSONObject.put("state", localDownloadInfo.a());
          localJSONObject.put("downloadType ", localDownloadInfo.jdField_c_of_type_Int);
          localJSONObject.put("download_from", localDownloadInfo.jdField_h_of_type_Int);
          localJSONObject.put("via", localDownloadInfo.jdField_h_of_type_JavaLangString);
          localJSONObject.put("totalDataLength", localDownloadInfo.jdField_c_of_type_Long);
          localJSONObject.put("writecodestate", localDownloadInfo.j);
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    paramString1 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getAllSDKDownloadInfos',{\"guid\": " + paramString2 + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);";
    bcds.c("DownloadInterfaceNew", "[getAllSDKDownloadInfos]:" + paramString1);
    a(paramString1);
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
        localDownloadInfo.jdField_c_of_type_JavaLangString = localJSONObject.optString("appid");
        localDownloadInfo.a();
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      bccy.a().a(localArrayList, new bcdf(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      bcds.c("DownloadInterfaceNew", "[innerQuery] e=", paramJSONArray);
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
    bcds.b("DownloadInterfaceNew", ">batchDownloadByYYB" + paramString);
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
        localObject1 = localJSONObject.optString(bcgl.i);
        localObject2 = paramString;
        localObject4 = localObject1;
        i = localJSONObject.optInt(bcgl.k);
        bcds.c("DownloadInterfaceNew", ">batchDownloadByYYB JSONException", (Throwable)localObject2);
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
          bcds.b("DownloadInterfaceNew", ">batchDownloadByYYB appInfo:" + localObject4 + "||via:" + (String)localObject1);
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
          break label214;
        }
        localJSONException3 = localJSONException3;
        i = 0;
        paramString = (String)localObject5;
        localObject1 = localObject4;
        localObject4 = localObject2;
        localObject2 = localJSONException3;
      }
      label214:
      localObject2 = paramString;
    }
    bchb.a().a(this.jdField_a_of_type_AndroidAppActivity, (JSONArray)localObject4, i, (String)localObject1, (String)localObject2);
    return 0;
  }
  
  public void cancelDownload(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bccy.a().a(paramString, true);
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bccu.a().a(paramString);
  }
  
  public void deleteDownload(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bccy.a().b(paramString, true);
  }
  
  public void destroy()
  {
    bcds.b("DownloadInterfaceNew", "destroy");
    bcey.a().b(this);
  }
  
  public int doDownloadAction(String paramString)
  {
    localObject3 = null;
    bcds.b("DownloadInterfaceNew", "[doDownloadAction]");
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
      localObject1 = localJSONObject.optString("appId");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = localJSONObject.optString("appid");
        if (localJSONObject.has("delayDownload"))
        {
          i = localJSONObject.optInt("delayDownload", -1);
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
            localObject2 = (AppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
          }
          if (1 == i)
          {
            yez.c((String)localObject1, "DELAY_LIST");
            yez.a((String)localObject1, paramString, "DELAY_APPID_DETAIL_");
            yev.a();
            a(anah.a("gamecenter_delaydownload", "callback", 0, null), false, false);
            return 0;
          }
          if (i == 0) {
            yez.b((String)localObject1, "DELAY_LIST");
          }
        }
        localBundle.putString(bcgl.b, (String)localObject1);
        localBundle.putString(bcgl.j, localJSONObject.optString("url"));
        localBundle.putString(bcgl.f, localJSONObject.optString("packageName"));
        localBundle.putInt(bcgl.k, localJSONObject.optInt("actionCode"));
        localBundle.putString(bcgl.i, localJSONObject.optString("via"));
        localBundle.putString(bcgl.l, localJSONObject.optString("appName"));
        localBundle.putBoolean(bcgl.r, a(localJSONObject.optInt("showNetworkDialog")));
        localBundle.putString(bcgl.D, localJSONObject.optString("iconUrl"));
        localBundle.putInt(bcgl.H, localJSONObject.optInt("showNotification"));
        localBundle.putBoolean(bcgl.J, a(localJSONObject.optInt("isAutoInstallBySdk")));
        localBundle.putString(bcgl.I, localJSONObject.optString("extraData"));
        localBundle.putString(bcgl.F, localJSONObject.optString("downloadStyle"));
        localBundle.putLong(bcgl.G, localJSONObject.optLong("downloadSize"));
        localBundle.putString(bcgl.p, localJSONObject.optString("wording"));
        paramString = localJSONObject.optString(bcgl.B);
        bcds.b("DownloadInterfaceNew", "[doDownloadAction] feedChannel:" + paramString);
        if (TextUtils.isEmpty(paramString)) {
          break label1362;
        }
        String str;
        if (paramString.startsWith("0;"))
        {
          break label1362;
          str = localJSONObject.optString(bcgl.K);
          bcds.b("DownloadInterfaceNew", "[doDownloadAction] finalFeedChannel:" + paramString);
          if (!TextUtils.isEmpty(paramString)) {
            break label1251;
          }
          localBundle.putString(bcgl.B, str);
        }
        for (;;)
        {
          paramString = localJSONObject.optString("via");
          i = localJSONObject.optInt("actionCode");
          if (this.jdField_a_of_type_Bcbp != null) {
            break label1275;
          }
          this.jdField_a_of_type_Bcbp = new bcbp((String)localObject1, paramString, i);
          if (localJSONObject.optInt("actionCode") != 12) {
            break label1354;
          }
          boolean bool = a(localJSONObject.optInt("updateType"));
          localBundle.putBoolean(bcgl.o, bool);
          bool = localJSONObject.has("updateData");
          if (!bool) {
            break label1354;
          }
          for (;;)
          {
            try
            {
              localObject2 = localJSONObject.optString("updateData");
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                continue;
              }
              paramString = new ApkUpdateDetail();
            }
            catch (Exception localException2)
            {
              label1251:
              paramString = localObject3;
              continue;
            }
            try
            {
              localObject2 = new JSONObject((String)localObject2);
              paramString.packageName = ((JSONObject)localObject2).optString("packageName");
              paramString.newapksize = ((JSONObject)localObject2).optInt("newapksize");
              paramString.patchsize = ((JSONObject)localObject2).optInt("patchsize");
              paramString.updatemethod = ((JSONObject)localObject2).optInt("updatemethod");
              paramString.versioncode = ((JSONObject)localObject2).optInt("versioncode");
              paramString.versionname = ((JSONObject)localObject2).optString("versionname");
              paramString.fileMd5 = ((JSONObject)localObject2).optString("fileMd5");
              paramString.sigMd5 = ((JSONObject)localObject2).optString("sigMd5");
              paramString.url = ((JSONObject)localObject2).optString("url");
              i = localJSONObject.optInt("myAppConfig");
              localBundle.putString(bcgl.jdField_c_of_type_JavaLangString, (String)localObject1);
              localBundle.putString(bcgl.d, localJSONObject.optString("apkId"));
              localBundle.putInt(bcgl.e, localJSONObject.optInt("versionCode"));
              localBundle.putInt(bcgl.n, localJSONObject.optInt("toPageType"));
              localBundle.putBoolean(bcgl.g, a(localJSONObject.optInt("isAutoDownload")));
              localBundle.putBoolean(bcgl.jdField_h_of_type_JavaLangString, a(localJSONObject.optInt("isAutoInstall")));
              localBundle.putBoolean(bcgl.x, localJSONObject.optBoolean("bolckNotify"));
              localBundle.putString("recommendId", localJSONObject.optString("recommendId"));
              localBundle.putString("sourceFromServer", "" + localJSONObject.optInt("sourceFromServer"));
              localBundle.putString(bcgl.K, str);
              localBundle.putString("pageId", "" + localJSONObject.optInt("pageId"));
              localBundle.putString("moduleId", "" + localJSONObject.optInt("moduleId"));
              localBundle.putString("positionId", "" + localJSONObject.optInt("positionId"));
              localBundle.putString("apkId", localJSONObject.optString("apkId"));
              localBundle.putString("appId", (String)localObject1);
              localBundle.putInt("auto_start_yyb_download", localJSONObject.optInt("auto_start_yyb_download"));
              localObject2 = DownloadInterface.parseSourceType(this.jdField_a_of_type_AndroidAppActivity, localJSONObject);
              localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = "biz_src_yyb";
              }
              localBundle.putString("big_brother_ref_source_key", DownloadInterface.parseCurrentPageId(this.jdField_a_of_type_AndroidAppActivity));
              bcds.b("DownloadInterfaceNew", "[doDownloadAction] sourceType=" + (String)localObject1);
              bcds.b("DownloadInterfaceNew", "[doDownloadAction] object " + localJSONObject.toString());
              bccy.a().a(this.jdField_a_of_type_AndroidAppActivity, localBundle, (String)localObject1, paramString, i);
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
          localObject2 = paramString[0];
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1368;
          }
          paramString = (String)localObject2;
          if (!((String)localObject2).equals("0")) {
            break;
          }
          break label1368;
          localBundle.putString(bcgl.B, paramString);
        }
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Object localObject1;
        int i;
        Object localObject2;
        bcds.c("DownloadInterfaceNew", "[doDownloadAction] JSONException", paramString);
        return -1;
        if (this.jdField_a_of_type_Bcbp.a((String)localObject1, paramString, i))
        {
          bcds.b("DownloadInterfaceNew", "[doDownloadAction] repeat action,return");
          return 0;
          bcds.c("DownloadInterfaceNew", "[doDownloadAction]  updateData e=" + ((Exception)localObject2).getMessage());
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        label1275:
        bcds.c("DownloadInterfaceNew", "[doDownloadAction] Exception", paramString);
        continue;
        paramString = null;
        continue;
        label1354:
        paramString = null;
        continue;
        continue;
        label1362:
        paramString = "";
        continue;
        label1368:
        paramString = "";
      }
    }
  }
  
  public void getAllSDKDownloadInfos(String paramString)
  {
    a("", paramString);
  }
  
  public void getAllSDKDownloadInfos(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
  
  public String getInterfaceName()
  {
    return "q_download_v2";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    bcds.b("DownloadInterfaceNew", "[queryDownloadAction] guid=" + paramString2 + ",paramJson=" + paramString1);
    try
    {
      a(new JSONArray(paramString1), paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      bcds.e("DownloadInterfaceNew", "[queryDownloadAction] e=" + paramString1.getMessage());
    }
  }
  
  public WebView getWebview()
  {
    return this.jdField_a_of_type_ComTencentSmttSdkWebView;
  }
  
  /* Error */
  public void innerQueryInstalledAppInfo(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 398	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: invokestatic 684	bbtm:a	()Lbbtm;
    //   7: invokevirtual 687	bbtm:a	()Landroid/content/Context;
    //   10: invokevirtual 693	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   13: bipush 64
    //   15: invokevirtual 699	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   18: astore 5
    //   20: new 177	org/json/JSONArray
    //   23: dup
    //   24: invokespecial 178	org/json/JSONArray:<init>	()V
    //   27: astore_1
    //   28: aload 5
    //   30: invokeinterface 703 1 0
    //   35: astore 5
    //   37: aload 5
    //   39: invokeinterface 708 1 0
    //   44: ifeq +172 -> 216
    //   47: aload 5
    //   49: invokeinterface 712 1 0
    //   54: checkcast 714	android/content/pm/PackageInfo
    //   57: astore 7
    //   59: aload 7
    //   61: getfield 718	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   64: getfield 723	android/content/pm/ApplicationInfo:flags	I
    //   67: iconst_1
    //   68: iand
    //   69: ifne -32 -> 37
    //   72: getstatic 727	java/lang/System:out	Ljava/io/PrintStream;
    //   75: new 152	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 729
    //   85: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload 7
    //   90: getfield 730	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   93: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokevirtual 735	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   102: new 180	org/json/JSONObject
    //   105: dup
    //   106: invokespecial 181	org/json/JSONObject:<init>	()V
    //   109: astore 6
    //   111: aload 6
    //   113: ldc 202
    //   115: aload 7
    //   117: getfield 730	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   120: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload 6
    //   126: ldc 207
    //   128: aload 7
    //   130: getfield 737	android/content/pm/PackageInfo:versionCode	I
    //   133: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   136: pop
    //   137: aload 6
    //   139: ldc_w 739
    //   142: aload 7
    //   144: getfield 743	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   147: aload 7
    //   149: getfield 743	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   152: arraylength
    //   153: iconst_1
    //   154: isub
    //   155: aaload
    //   156: invokevirtual 748	android/content/pm/Signature:toCharsString	()Ljava/lang/String;
    //   159: invokestatic 752	bcdt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   162: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload_1
    //   167: aload 6
    //   169: invokevirtual 256	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   172: pop
    //   173: goto -136 -> 37
    //   176: astore_1
    //   177: ldc 23
    //   179: new 152	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 754
    //   189: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 654	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   196: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 676	bcds:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: return
    //   206: astore 7
    //   208: aload 7
    //   210: invokevirtual 259	org/json/JSONException:printStackTrace	()V
    //   213: goto -47 -> 166
    //   216: new 152	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 756
    //   226: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_2
    //   230: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 263
    //   236: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_1
    //   240: invokevirtual 264	org/json/JSONArray:toString	()Ljava/lang/String;
    //   243: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc_w 266
    //   249: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: astore_1
    //   256: ldc 23
    //   258: new 152	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 758
    //   268: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokestatic 398	java/lang/System:currentTimeMillis	()J
    //   274: lload_3
    //   275: lsub
    //   276: invokevirtual 761	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   279: ldc_w 763
    //   282: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_1
    //   286: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 175	bcds:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_0
    //   296: aload_1
    //   297: invokespecial 132	com/tencent/open/appstore/js/DownloadInterfaceNew:a	(Ljava/lang/String;)V
    //   300: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	DownloadInterfaceNew
    //   0	301	1	paramString1	String
    //   0	301	2	paramString2	String
    //   3	272	3	l	long
    //   18	30	5	localObject	Object
    //   109	59	6	localJSONObject	JSONObject
    //   57	91	7	localPackageInfo	android.content.pm.PackageInfo
    //   206	3	7	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   0	37	176	java/lang/Exception
    //   37	111	176	java/lang/Exception
    //   111	166	176	java/lang/Exception
    //   166	173	176	java/lang/Exception
    //   208	213	176	java/lang/Exception
    //   216	300	176	java/lang/Exception
    //   111	166	206	org/json/JSONException
  }
  
  public void installYYB()
  {
    bchb.a().c(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void isYYBSupportBatchDownload(String paramString)
  {
    bcds.b("DownloadInterfaceNew", ">isYYBSupportBatchDownload " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = bchb.b();
      bcds.b("DownloadInterfaceNew", ">isYYBSupportBatchDownload yybApiLevel=" + i);
      paramString = new StringBuilder().append("javascript:").append(paramString).append("(");
      if (i >= 9) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = bool + ")";
        bcds.c("DownloadInterfaceNew", ">isYYBSupportBatchDownload:" + paramString);
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
      bccy.a(this.jdField_a_of_type_AndroidAppActivity, localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bcds.c("DownloadInterfaceNew", "JSONException", paramString);
      }
    }
  }
  
  public void queryInstalledAppInfo(String paramString)
  {
    innerQueryInstalledAppInfo("", paramString);
  }
  
  public void queryInstalledAppInfo(String paramString1, String paramString2)
  {
    innerQueryInstalledAppInfo(paramString1, paramString2);
  }
  
  public void queryYYBApiLevel(String paramString)
  {
    bcds.b("DownloadInterfaceNew", ">queryYYBApiLevel " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = bchb.b();
      bcds.b("DownloadInterfaceNew", ">queryYYBApiLevel yybApiLevel=" + i);
      paramString = "javascript:" + paramString + "(" + i + ")";
      bcds.c("DownloadInterfaceNew", ">queryYYBApiLevel:" + paramString);
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
    bcds.b("DownloadInterfaceNew", "[registerDownloadCallBackListener] callbackMethod=" + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
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
      bccy.a(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bcds.c("DownloadInterfaceNew", "JSONException", paramString);
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
      bccy.b(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bcds.c("DownloadInterfaceNew", "JSONException", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.js.DownloadInterfaceNew
 * JD-Core Version:    0.7.0.1
 */