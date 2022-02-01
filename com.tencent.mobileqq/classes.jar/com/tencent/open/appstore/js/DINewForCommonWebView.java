package com.tencent.open.appstore.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.js.LastDownloadAction;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi;
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
  implements IJsCallBack
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LastDownloadAction jdField_a_of_type_ComTencentOpenAppcommonJsLastDownloadAction;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = "";
  
  public DINewForCommonWebView(Activity paramActivity, WebView paramWebView)
  {
    Object localObject = null;
    this.jdField_a_of_type_ComTencentOpenAppcommonJsLastDownloadAction = null;
    LogUtility.b("DINewForCommonWebView", "<DINewForCommonWebView>");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool))
    {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    else
    {
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
    DownloadManagerV2.a().a(paramWebView);
    JsCallbackManager.a().a(this);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131703487), 0).show();
      }
    }
    else
    {
      if (paramBoolean1)
      {
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramBundle);
        return;
      }
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
    }
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
      DownloadProxy.a().a(localArrayList, new DINewForCommonWebView.1(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      LogUtility.c("DINewForCommonWebView", "[innerQuery] e=", paramJSONArray);
    }
  }
  
  private static boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    if (paramInt == 1) {}
    return true;
  }
  
  /* Error */
  public int batchDownloadByYYB(String paramString)
  {
    // Byte code:
    //   0: ldc 19
    //   2: astore 7
    //   4: new 225	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   11: astore 4
    //   13: aload 4
    //   15: ldc 228
    //   17: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 4
    //   23: aload_1
    //   24: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc 25
    //   30: aload 4
    //   32: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 33	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: invokevirtual 239	com/tencent/open/appstore/js/DINewForCommonWebView:hasRight	()Z
    //   42: ifne +5 -> 47
    //   45: iconst_m1
    //   46: ireturn
    //   47: aconst_null
    //   48: astore 4
    //   50: aload 4
    //   52: astore 5
    //   54: new 171	org/json/JSONObject
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 241	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   62: astore 6
    //   64: aload 4
    //   66: astore 5
    //   68: aload 6
    //   70: ldc 243
    //   72: invokevirtual 247	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   75: astore_1
    //   76: aload_1
    //   77: astore 5
    //   79: aload 6
    //   81: getstatic 252	com/tencent/open/downloadnew/DownloadConstants:i	Ljava/lang/String;
    //   84: invokevirtual 175	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 4
    //   89: aload 6
    //   91: getstatic 255	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   94: invokevirtual 189	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   97: istore_2
    //   98: aload 7
    //   100: astore 5
    //   102: aload 6
    //   104: ldc_w 257
    //   107: invokevirtual 175	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore 9
    //   112: aload 9
    //   114: astore 5
    //   116: aload 9
    //   118: astore 6
    //   120: aload_1
    //   121: astore 8
    //   123: iload_2
    //   124: istore_3
    //   125: aload 4
    //   127: astore 7
    //   129: aload 9
    //   131: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifeq +76 -> 210
    //   137: aload 9
    //   139: astore 5
    //   141: aload_0
    //   142: getfield 35	com/tencent/open/appstore/js/DINewForCommonWebView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   145: invokestatic 269	com/tencent/open/appcommon/js/DownloadInterface:getSourceInfoFromActivity	(Landroid/app/Activity;)Ljava/lang/String;
    //   148: astore 6
    //   150: aload_1
    //   151: astore 8
    //   153: iload_2
    //   154: istore_3
    //   155: aload 4
    //   157: astore 7
    //   159: goto +51 -> 210
    //   162: astore 6
    //   164: goto +23 -> 187
    //   167: astore 6
    //   169: goto +12 -> 181
    //   172: astore 6
    //   174: ldc 19
    //   176: astore 4
    //   178: aload 5
    //   180: astore_1
    //   181: iconst_0
    //   182: istore_2
    //   183: aload 7
    //   185: astore 5
    //   187: ldc 25
    //   189: ldc_w 271
    //   192: aload 6
    //   194: invokestatic 221	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload 4
    //   199: astore 7
    //   201: iload_2
    //   202: istore_3
    //   203: aload_1
    //   204: astore 8
    //   206: aload 5
    //   208: astore 6
    //   210: new 225	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   217: astore_1
    //   218: aload_1
    //   219: ldc_w 273
    //   222: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_1
    //   227: aload 8
    //   229: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_1
    //   234: ldc_w 278
    //   237: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_1
    //   242: aload 7
    //   244: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: ldc 25
    //   250: aload_1
    //   251: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 33	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload 8
    //   259: ifnull +32 -> 291
    //   262: aload 8
    //   264: invokevirtual 157	org/json/JSONArray:length	()I
    //   267: ifne +5 -> 272
    //   270: iconst_m1
    //   271: ireturn
    //   272: invokestatic 283	com/tencent/open/downloadnew/MyAppApi:a	()Lcom/tencent/open/downloadnew/MyAppApi;
    //   275: aload_0
    //   276: getfield 35	com/tencent/open/appstore/js/DINewForCommonWebView:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   279: aload 8
    //   281: iload_3
    //   282: aload 7
    //   284: aload 6
    //   286: invokevirtual 286	com/tencent/open/downloadnew/MyAppApi:a	(Landroid/content/Context;Lorg/json/JSONArray;ILjava/lang/String;Ljava/lang/String;)V
    //   289: iconst_0
    //   290: ireturn
    //   291: iconst_m1
    //   292: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	DINewForCommonWebView
    //   0	293	1	paramString	String
    //   97	105	2	i	int
    //   124	158	3	j	int
    //   11	187	4	localObject1	Object
    //   52	155	5	localObject2	Object
    //   62	87	6	localObject3	Object
    //   162	1	6	localJSONException1	JSONException
    //   167	1	6	localJSONException2	JSONException
    //   172	21	6	localJSONException3	JSONException
    //   208	77	6	localObject4	Object
    //   2	281	7	localObject5	Object
    //   121	159	8	str1	String
    //   110	28	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   102	112	162	org/json/JSONException
    //   129	137	162	org/json/JSONException
    //   141	150	162	org/json/JSONException
    //   89	98	167	org/json/JSONException
    //   54	64	172	org/json/JSONException
    //   68	76	172	org/json/JSONException
    //   79	89	172	org/json/JSONException
  }
  
  public void destroy()
  {
    LogUtility.b("DINewForCommonWebView", "destroy");
    JsCallbackManager.a().b(this);
  }
  
  public int doDownloadAction(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[doDownloadAction]");
    ((StringBuilder)localObject1).append(paramString);
    LogUtility.b("DINewForCommonWebView", ((StringBuilder)localObject1).toString());
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.jdField_a_of_type_AndroidAppActivity) >= 6) {
      localBundle.putLong("OuterCall_JS_DoDownloadAction", System.currentTimeMillis());
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Object localObject2 = localJSONObject.optString("appId");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localJSONObject.optString("appid");
        }
        if (!localJSONObject.has("delayDownload")) {
          break label1447;
        }
        int i = localJSONObject.optInt("delayDownload", -1);
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
          localObject2 = (AppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
        }
        if (1 == i)
        {
          GameCenterUtil.a((String)localObject1, "DELAY_LIST");
          GameCenterUtil.a((String)localObject1, paramString, "DELAY_APPID_DETAIL_");
          GameCenterBroadcastReceiver.a();
          a(DataFactory.a("gamecenter_delaydownload", "callback", 0, null), false, false);
          return 0;
        }
        if (i == 0) {
          GameCenterUtil.b((String)localObject1, "DELAY_LIST");
        }
        localBundle.putString(DownloadConstants.b, (String)localObject1);
        localBundle.putString(DownloadConstants.j, localJSONObject.optString("url"));
        localBundle.putString(DownloadConstants.f, localJSONObject.optString("packageName"));
        localBundle.putInt(DownloadConstants.k, localJSONObject.optInt("actionCode"));
        localBundle.putString(DownloadConstants.i, localJSONObject.optString("via"));
        localBundle.putString(DownloadConstants.l, localJSONObject.optString("appName"));
        localBundle.putBoolean(DownloadConstants.s, a(localJSONObject.optInt("showNetworkDialog")));
        localBundle.putString(DownloadConstants.F, localJSONObject.optString("iconUrl"));
        localBundle.putInt(DownloadConstants.J, localJSONObject.optInt("showNotification"));
        localBundle.putBoolean(DownloadConstants.L, a(localJSONObject.optInt("isAutoInstallBySdk")));
        localBundle.putString(DownloadConstants.K, localJSONObject.optString("extraData"));
        localBundle.putString(DownloadConstants.H, localJSONObject.optString("downloadStyle"));
        localBundle.putLong(DownloadConstants.I, localJSONObject.optLong("downloadSize"));
        localBundle.putString(DownloadConstants.p, localJSONObject.optString("wording"));
        paramString = localJSONObject.optString(DownloadConstants.D);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doDownloadAction] feedChannel:");
        ((StringBuilder)localObject2).append(paramString);
        LogUtility.b("DINewForCommonWebView", ((StringBuilder)localObject2).toString());
        boolean bool = TextUtils.isEmpty(paramString);
        if ((bool) || (paramString.startsWith("0;"))) {
          break label1450;
        }
        paramString = paramString.split(";");
        if ((paramString == null) || (paramString.length <= 0)) {
          break label1450;
        }
        localObject2 = paramString[0];
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1450;
        }
        paramString = (String)localObject2;
        if (((String)localObject2).equals("0")) {
          break label1450;
        }
        String str = localJSONObject.optString(DownloadConstants.M);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doDownloadAction] finalFeedChannel:");
        ((StringBuilder)localObject2).append(paramString);
        LogUtility.b("DINewForCommonWebView", ((StringBuilder)localObject2).toString());
        if (TextUtils.isEmpty(paramString)) {
          localBundle.putString(DownloadConstants.D, str);
        } else {
          localBundle.putString(DownloadConstants.D, paramString);
        }
        paramString = localJSONObject.optString("via");
        i = localJSONObject.optInt("actionCode");
        if (this.jdField_a_of_type_ComTencentOpenAppcommonJsLastDownloadAction == null)
        {
          this.jdField_a_of_type_ComTencentOpenAppcommonJsLastDownloadAction = new LastDownloadAction((String)localObject1, paramString, i);
        }
        else if (this.jdField_a_of_type_ComTencentOpenAppcommonJsLastDownloadAction.a((String)localObject1, paramString, i))
        {
          LogUtility.b("DINewForCommonWebView", "[doDownloadAction] repeat action,return");
          return 0;
        }
        if (localJSONObject.optInt("actionCode") != 12) {
          break label1456;
        }
        bool = a(localJSONObject.optInt("updateType"));
        localBundle.putBoolean(DownloadConstants.o, bool);
        bool = localJSONObject.has("updateData");
        if (!bool) {
          break label1456;
        }
        try
        {
          localObject2 = localJSONObject.optString("updateData");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramString = new ApkUpdateDetail();
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
            }
            catch (Exception localException1)
            {
              continue;
            }
          }
          else
          {
            paramString = null;
          }
        }
        catch (Exception localException2)
        {
          paramString = null;
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("[doDownloadAction]  updateData e=");
          localStringBuilder2.append(localException2.getMessage());
          LogUtility.c("DINewForCommonWebView", localStringBuilder2.toString());
        }
        i = localJSONObject.optInt("myAppConfig");
        localBundle.putString(DownloadConstants.c, (String)localObject1);
        localBundle.putString(DownloadConstants.d, localJSONObject.optString("apkId"));
        localBundle.putInt(DownloadConstants.e, localJSONObject.optInt("versionCode"));
        localBundle.putInt(DownloadConstants.n, localJSONObject.optInt("toPageType"));
        localBundle.putBoolean(DownloadConstants.g, a(localJSONObject.optInt("isAutoDownload")));
        localBundle.putBoolean(DownloadConstants.h, a(localJSONObject.optInt("isAutoInstall")));
        localBundle.putBoolean(DownloadConstants.y, localJSONObject.optBoolean("bolckNotify"));
        localBundle.putString("recommendId", localJSONObject.optString("recommendId"));
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("");
        localStringBuilder1.append(localJSONObject.optInt("sourceFromServer"));
        localBundle.putString("sourceFromServer", localStringBuilder1.toString());
        localBundle.putString(DownloadConstants.M, str);
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("");
        localStringBuilder1.append(localJSONObject.optInt("pageId"));
        localBundle.putString("pageId", localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("");
        localStringBuilder1.append(localJSONObject.optInt("moduleId"));
        localBundle.putString("moduleId", localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("");
        localStringBuilder1.append(localJSONObject.optInt("positionId"));
        localBundle.putString("positionId", localStringBuilder1.toString());
        localBundle.putString("apkId", localJSONObject.optString("apkId"));
        localBundle.putString("appId", (String)localObject1);
        localBundle.putInt("auto_start_yyb_download", localJSONObject.optInt("auto_start_yyb_download"));
        localObject1 = DownloadInterface.parseSourceType(this.jdField_a_of_type_AndroidAppActivity, localJSONObject);
        localBundle.putString("big_brother_ref_source_key", DownloadInterface.parseCurrentPageId(this.jdField_a_of_type_AndroidAppActivity));
        localBundle.putInt("hideInstallSuccessPage", localJSONObject.optInt("hideInstallSuccessPage"));
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[doDownloadAction] object ");
        localStringBuilder1.append(localJSONObject.toString());
        LogUtility.b("DINewForCommonWebView", localStringBuilder1.toString());
        DownloadProxy.a().a(this.jdField_a_of_type_AndroidAppActivity, localBundle, (String)localObject1, paramString, i);
        return 0;
      }
      catch (NumberFormatException paramString)
      {
        LogUtility.c("DINewForCommonWebView", "[doDownloadAction] Exception", paramString);
      }
      catch (JSONException paramString)
      {
        LogUtility.c("DINewForCommonWebView", "[doDownloadAction] JSONException", paramString);
      }
      return -1;
      label1447:
      continue;
      label1450:
      paramString = "";
      continue;
      label1456:
      paramString = null;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<getQueryDownloadAction> paramJson=");
    localStringBuilder.append(paramString);
    LogUtility.b("DINewForCommonWebView", localStringBuilder.toString());
    try
    {
      paramString = new JSONObject(paramString);
      a(new JSONArray(paramString.optString("queryParams")), paramString.optString("callback"));
      return;
    }
    catch (JSONException paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[queryDownloadAction] e=");
      localStringBuilder.append(paramString.getMessage());
      LogUtility.e("DINewForCommonWebView", localStringBuilder.toString());
    }
  }
  
  public WebView getWebview()
  {
    return this.jdField_a_of_type_ComTencentSmttSdkWebView;
  }
  
  public void isYYBSupportBatchDownload(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">isYYBSupportBatchDownload ");
    localStringBuilder.append(paramString);
    LogUtility.b("DINewForCommonWebView", localStringBuilder.toString());
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optString("callback");
        int i = MyAppApi.c();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(">isYYBSupportBatchDownload yybApiLevel=");
        localStringBuilder.append(i);
        LogUtility.b("DINewForCommonWebView", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("(");
        if (i >= 9)
        {
          bool = true;
          localStringBuilder.append(bool);
          localStringBuilder.append(")");
          paramString = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(">isYYBSupportBatchDownload:");
          localStringBuilder.append(paramString);
          LogUtility.c("DINewForCommonWebView", localStringBuilder.toString());
          a(paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool = false;
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
      DownloadProxy.a(this.jdField_a_of_type_AndroidAppActivity, localBundle);
    }
    catch (JSONException paramString)
    {
      LogUtility.c("DINewForCommonWebView", "JSONException", paramString);
    }
    return 0;
  }
  
  public void queryYYBApiLevel(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">queryYYBApiLevel ");
    localStringBuilder.append(paramString);
    LogUtility.b("DINewForCommonWebView", localStringBuilder.toString());
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = MyAppApi.c();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">queryYYBApiLevel yybApiLevel=");
      localStringBuilder.append(i);
      LogUtility.b("DINewForCommonWebView", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(i);
      localStringBuilder.append(")");
      paramString = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">queryYYBApiLevel:");
      localStringBuilder.append(paramString);
      LogUtility.c("DINewForCommonWebView", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<registerDownloadCallBackListener> paramJsonStr=");
    localStringBuilder.append(paramString);
    LogUtility.b("DINewForCommonWebView", localStringBuilder.toString());
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      paramString = new StringBuilder();
      paramString.append("<registerDownloadCallBackListener>");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      LogUtility.b("DINewForCommonWebView", paramString.toString());
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
      DownloadProxy.a(localBundle);
    }
    catch (JSONException paramString)
    {
      LogUtility.c("DINewForCommonWebView", "JSONException", paramString);
    }
    return 0;
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
      DownloadProxy.b(localBundle);
    }
    catch (JSONException paramString)
    {
      LogUtility.c("DINewForCommonWebView", "JSONException", paramString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.js.DINewForCommonWebView
 * JD-Core Version:    0.7.0.1
 */