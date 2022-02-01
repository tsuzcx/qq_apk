package com.tencent.open.appstore.js;

import acig;
import acik;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import anzj;
import asev;
import asjw;
import bjru;
import bjsz;
import bjtd;
import bjtk;
import bjtx;
import bjvc;
import bjvd;
import bjwo;
import bjxd;
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

public class DownloadInterfaceNew
  extends BaseInterface
  implements bjvc
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bjru jdField_a_of_type_Bjru;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = "";
  
  public DownloadInterfaceNew(Activity paramActivity, WebView paramWebView)
  {
    bjtx.b("DownloadInterfaceNew", "<DownloadInterfaceNew>");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      bjsz.a().a(paramWebView);
      bjvd.a().a(this);
      return;
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!asjw.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), anzj.a(2131702389), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      asjw.a().b(paramBundle);
      return;
    }
    asjw.a().a(paramBundle);
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new DownloadInterfaceNew.2(this, paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = bjtd.a().a();
    bjtx.c("DownloadInterfaceNew", "[getAllSDKDownloadInfos] infos size = " + paramString1.size());
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
    bjtx.c("DownloadInterfaceNew", "[getAllSDKDownloadInfos]:" + paramString1);
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
      bjtd.a().a(localArrayList, new bjtk(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      bjtx.c("DownloadInterfaceNew", "[innerQuery] e=", paramJSONArray);
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
    bjtx.b("DownloadInterfaceNew", ">batchDownloadByYYB" + paramString);
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
        localObject1 = localJSONObject.optString(bjwo.i);
        localObject2 = paramString;
        localObject4 = localObject1;
        i = localJSONObject.optInt(bjwo.k);
        bjtx.c("DownloadInterfaceNew", ">batchDownloadByYYB JSONException", (Throwable)localObject2);
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
          bjtx.b("DownloadInterfaceNew", ">batchDownloadByYYB appInfo:" + localObject4 + "||via:" + (String)localObject1);
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
    bjxd.a().a(this.jdField_a_of_type_AndroidAppActivity, (JSONArray)localObject4, i, (String)localObject1, (String)localObject2);
    return 0;
  }
  
  public void cancelDownload(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bjtd.a().a(paramString, true);
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bjsz.a().a(paramString);
  }
  
  public void deleteDownload(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bjtd.a().b(paramString, true);
  }
  
  public void destroy()
  {
    bjtx.b("DownloadInterfaceNew", "destroy");
    bjvd.a().b(this);
  }
  
  public int doDownloadAction(String paramString)
  {
    localObject3 = null;
    bjtx.b("DownloadInterfaceNew", "[doDownloadAction]");
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
            acik.c((String)localObject1, "DELAY_LIST");
            acik.a((String)localObject1, paramString, "DELAY_APPID_DETAIL_");
            acig.a();
            a(asev.a("gamecenter_delaydownload", "callback", 0, null), false, false);
            return 0;
          }
          if (i == 0) {
            acik.b((String)localObject1, "DELAY_LIST");
          }
        }
        localBundle.putString(bjwo.b, (String)localObject1);
        localBundle.putString(bjwo.j, localJSONObject.optString("url"));
        localBundle.putString(bjwo.f, localJSONObject.optString("packageName"));
        localBundle.putInt(bjwo.k, localJSONObject.optInt("actionCode"));
        localBundle.putString(bjwo.i, localJSONObject.optString("via"));
        localBundle.putString(bjwo.l, localJSONObject.optString("appName"));
        localBundle.putBoolean(bjwo.r, a(localJSONObject.optInt("showNetworkDialog")));
        localBundle.putString(bjwo.D, localJSONObject.optString("iconUrl"));
        localBundle.putInt(bjwo.H, localJSONObject.optInt("showNotification"));
        localBundle.putBoolean(bjwo.J, a(localJSONObject.optInt("isAutoInstallBySdk")));
        localBundle.putString(bjwo.I, localJSONObject.optString("extraData"));
        localBundle.putString(bjwo.F, localJSONObject.optString("downloadStyle"));
        localBundle.putLong(bjwo.G, localJSONObject.optLong("downloadSize"));
        localBundle.putString(bjwo.p, localJSONObject.optString("wording"));
        paramString = localJSONObject.optString(bjwo.B);
        bjtx.b("DownloadInterfaceNew", "[doDownloadAction] feedChannel:" + paramString);
        if (TextUtils.isEmpty(paramString)) {
          break label1378;
        }
        String str;
        if (paramString.startsWith("0;"))
        {
          break label1378;
          str = localJSONObject.optString(bjwo.K);
          bjtx.b("DownloadInterfaceNew", "[doDownloadAction] finalFeedChannel:" + paramString);
          if (!TextUtils.isEmpty(paramString)) {
            break label1267;
          }
          localBundle.putString(bjwo.B, str);
        }
        for (;;)
        {
          paramString = localJSONObject.optString("via");
          i = localJSONObject.optInt("actionCode");
          if (this.jdField_a_of_type_Bjru != null) {
            break label1291;
          }
          this.jdField_a_of_type_Bjru = new bjru((String)localObject1, paramString, i);
          if (localJSONObject.optInt("actionCode") != 12) {
            break label1370;
          }
          boolean bool = a(localJSONObject.optInt("updateType"));
          localBundle.putBoolean(bjwo.o, bool);
          bool = localJSONObject.has("updateData");
          if (!bool) {
            break label1370;
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
              label1267:
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
              localBundle.putString(bjwo.jdField_c_of_type_JavaLangString, (String)localObject1);
              localBundle.putString(bjwo.d, localJSONObject.optString("apkId"));
              localBundle.putInt(bjwo.e, localJSONObject.optInt("versionCode"));
              localBundle.putInt(bjwo.n, localJSONObject.optInt("toPageType"));
              localBundle.putBoolean(bjwo.g, a(localJSONObject.optInt("isAutoDownload")));
              localBundle.putBoolean(bjwo.jdField_h_of_type_JavaLangString, a(localJSONObject.optInt("isAutoInstall")));
              localBundle.putBoolean(bjwo.x, localJSONObject.optBoolean("bolckNotify"));
              localBundle.putString("recommendId", localJSONObject.optString("recommendId"));
              localBundle.putString("sourceFromServer", "" + localJSONObject.optInt("sourceFromServer"));
              localBundle.putString(bjwo.K, str);
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
              localBundle.putInt("hideInstallSuccessPage", localJSONObject.optInt("hideInstallSuccessPage"));
              bjtx.b("DownloadInterfaceNew", "[doDownloadAction] sourceType=" + (String)localObject1);
              bjtx.b("DownloadInterfaceNew", "[doDownloadAction] object " + localJSONObject.toString());
              bjtd.a().a(this.jdField_a_of_type_AndroidAppActivity, localBundle, (String)localObject1, paramString, i);
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
            break label1384;
          }
          paramString = (String)localObject2;
          if (!((String)localObject2).equals("0")) {
            break;
          }
          break label1384;
          localBundle.putString(bjwo.B, paramString);
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
        bjtx.c("DownloadInterfaceNew", "[doDownloadAction] JSONException", paramString);
        return -1;
        if (this.jdField_a_of_type_Bjru.a((String)localObject1, paramString, i))
        {
          bjtx.b("DownloadInterfaceNew", "[doDownloadAction] repeat action,return");
          return 0;
          bjtx.c("DownloadInterfaceNew", "[doDownloadAction]  updateData e=" + ((Exception)localObject2).getMessage());
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        label1291:
        bjtx.c("DownloadInterfaceNew", "[doDownloadAction] Exception", paramString);
        continue;
        paramString = null;
        continue;
        label1370:
        paramString = null;
        continue;
        continue;
        label1378:
        paramString = "";
        continue;
        label1384:
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
    bjtx.b("DownloadInterfaceNew", "[queryDownloadAction] guid=" + paramString2 + ",paramJson=" + paramString1);
    try
    {
      a(new JSONArray(paramString1), paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      bjtx.e("DownloadInterfaceNew", "[queryDownloadAction] e=" + paramString1.getMessage());
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
    //   4: invokestatic 686	bjjo:a	()Lbjjo;
    //   7: invokevirtual 689	bjjo:a	()Landroid/content/Context;
    //   10: invokevirtual 695	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   13: pop
    //   14: new 274	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 275	java/util/ArrayList:<init>	()V
    //   21: astore 5
    //   23: new 177	org/json/JSONArray
    //   26: dup
    //   27: invokespecial 178	org/json/JSONArray:<init>	()V
    //   30: astore_1
    //   31: aload 5
    //   33: invokeinterface 699 1 0
    //   38: astore 5
    //   40: aload 5
    //   42: invokeinterface 704 1 0
    //   47: ifeq +172 -> 219
    //   50: aload 5
    //   52: invokeinterface 708 1 0
    //   57: checkcast 710	android/content/pm/PackageInfo
    //   60: astore 7
    //   62: aload 7
    //   64: getfield 714	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   67: getfield 719	android/content/pm/ApplicationInfo:flags	I
    //   70: iconst_1
    //   71: iand
    //   72: ifne -32 -> 40
    //   75: getstatic 723	java/lang/System:out	Ljava/io/PrintStream;
    //   78: new 152	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 725
    //   88: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 7
    //   93: getfield 726	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   96: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokevirtual 731	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   105: new 180	org/json/JSONObject
    //   108: dup
    //   109: invokespecial 181	org/json/JSONObject:<init>	()V
    //   112: astore 6
    //   114: aload 6
    //   116: ldc 202
    //   118: aload 7
    //   120: getfield 726	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   123: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   126: pop
    //   127: aload 6
    //   129: ldc 207
    //   131: aload 7
    //   133: getfield 733	android/content/pm/PackageInfo:versionCode	I
    //   136: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload 6
    //   142: ldc_w 735
    //   145: aload 7
    //   147: getfield 739	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   150: aload 7
    //   152: getfield 739	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   155: arraylength
    //   156: iconst_1
    //   157: isub
    //   158: aaload
    //   159: invokevirtual 744	android/content/pm/Signature:toCharsString	()Ljava/lang/String;
    //   162: invokestatic 748	bjty:a	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokevirtual 195	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload_1
    //   170: aload 6
    //   172: invokevirtual 256	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   175: pop
    //   176: goto -136 -> 40
    //   179: astore_1
    //   180: ldc 23
    //   182: new 152	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 750
    //   192: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_1
    //   196: invokevirtual 656	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 678	bjtx:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: return
    //   209: astore 7
    //   211: aload 7
    //   213: invokevirtual 259	org/json/JSONException:printStackTrace	()V
    //   216: goto -47 -> 169
    //   219: new 152	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 752
    //   229: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_2
    //   233: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc_w 263
    //   239: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_1
    //   243: invokevirtual 264	org/json/JSONArray:toString	()Ljava/lang/String;
    //   246: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc_w 266
    //   252: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore_1
    //   259: ldc 23
    //   261: new 152	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 754
    //   271: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokestatic 398	java/lang/System:currentTimeMillis	()J
    //   277: lload_3
    //   278: lsub
    //   279: invokevirtual 757	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: ldc_w 759
    //   285: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_1
    //   289: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 175	bjtx:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_0
    //   299: aload_1
    //   300: invokespecial 132	com/tencent/open/appstore/js/DownloadInterfaceNew:a	(Ljava/lang/String;)V
    //   303: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	DownloadInterfaceNew
    //   0	304	1	paramString1	String
    //   0	304	2	paramString2	String
    //   3	275	3	l	long
    //   21	30	5	localObject	Object
    //   112	59	6	localJSONObject	JSONObject
    //   60	91	7	localPackageInfo	android.content.pm.PackageInfo
    //   209	3	7	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   0	40	179	java/lang/Exception
    //   40	114	179	java/lang/Exception
    //   114	169	179	java/lang/Exception
    //   169	176	179	java/lang/Exception
    //   211	216	179	java/lang/Exception
    //   219	303	179	java/lang/Exception
    //   114	169	209	org/json/JSONException
  }
  
  public void installYYB()
  {
    bjxd.a().c(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void isYYBSupportBatchDownload(String paramString)
  {
    bjtx.b("DownloadInterfaceNew", ">isYYBSupportBatchDownload " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = bjxd.b();
      bjtx.b("DownloadInterfaceNew", ">isYYBSupportBatchDownload yybApiLevel=" + i);
      paramString = new StringBuilder().append("javascript:").append(paramString).append("(");
      if (i >= 9) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = bool + ")";
        bjtx.c("DownloadInterfaceNew", ">isYYBSupportBatchDownload:" + paramString);
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
      bjtd.a(this.jdField_a_of_type_AndroidAppActivity, localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bjtx.c("DownloadInterfaceNew", "JSONException", paramString);
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
    bjtx.b("DownloadInterfaceNew", ">queryYYBApiLevel " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = bjxd.b();
      bjtx.b("DownloadInterfaceNew", ">queryYYBApiLevel yybApiLevel=" + i);
      paramString = "javascript:" + paramString + "(" + i + ")";
      bjtx.c("DownloadInterfaceNew", ">queryYYBApiLevel:" + paramString);
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
    bjtx.b("DownloadInterfaceNew", "[registerDownloadCallBackListener] callbackMethod=" + paramString);
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
      bjtd.a(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bjtx.c("DownloadInterfaceNew", "JSONException", paramString);
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
      bjtd.b(localBundle);
      return 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bjtx.c("DownloadInterfaceNew", "JSONException", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.js.DownloadInterfaceNew
 * JD-Core Version:    0.7.0.1
 */