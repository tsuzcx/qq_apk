package com.tencent.open.appstore.js;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
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
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.js.LastDownloadAction;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadInterfaceNew
  extends BaseInterface
  implements IJsCallBack
{
  private String a = "";
  private WebView b;
  private Handler c;
  private Activity d;
  private LastDownloadAction e;
  
  public DownloadInterfaceNew(Activity paramActivity, WebView paramWebView)
  {
    Object localObject = null;
    this.e = null;
    LogUtility.b("DownloadInterfaceNew", "<DownloadInterfaceNew>");
    this.d = paramActivity;
    this.b = paramWebView;
    this.c = new Handler(Looper.getMainLooper());
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
        Toast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131901603), 0).show();
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
    this.c.post(new DownloadInterfaceNew.2(this, paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = DownloadProxy.a().b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getAllSDKDownloadInfos] infos size = ");
    ((StringBuilder)localObject).append(paramString1.size());
    LogUtility.c("DownloadInterfaceNew", ((StringBuilder)localObject).toString());
    localObject = new JSONArray();
    int j = paramString1.size();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = new JSONObject();
      DownloadInfo localDownloadInfo = (DownloadInfo)paramString1.get(i);
      try
      {
        localJSONObject.put("appid", localDownloadInfo.c);
        localJSONObject.put("apkid", localDownloadInfo.m);
        localJSONObject.put("packagename", localDownloadInfo.e);
        localJSONObject.put("versioncode", localDownloadInfo.n);
        localJSONObject.put("url", localDownloadInfo.d);
        localJSONObject.put("pro", localDownloadInfo.t);
        localJSONObject.put("state", localDownloadInfo.a());
        localJSONObject.put("downloadType ", localDownloadInfo.o);
        localJSONObject.put("download_from", localDownloadInfo.z);
        localJSONObject.put("via", localDownloadInfo.h);
        localJSONObject.put("totalDataLength", localDownloadInfo.E);
        localJSONObject.put("writecodestate", localDownloadInfo.D);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((JSONArray)localObject).put(localJSONObject);
      i += 1;
    }
    paramString1 = new StringBuilder();
    paramString1.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getAllSDKDownloadInfos',{\"guid\": ");
    paramString1.append(paramString2);
    paramString1.append(", \"r\" : 0, \"data\":");
    paramString1.append(((JSONArray)localObject).toString());
    paramString1.append("});}void(0);");
    paramString1 = paramString1.toString();
    paramString2 = new StringBuilder();
    paramString2.append("[getAllSDKDownloadInfos]:");
    paramString2.append(paramString1);
    LogUtility.c("DownloadInterfaceNew", paramString2.toString());
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
        localDownloadInfo.n = localJSONObject.optInt("versionCode");
        localDownloadInfo.c = localJSONObject.optString("appid");
        localDownloadInfo.b();
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      DownloadProxy.a().a(localArrayList, new DownloadInterfaceNew.1(this, paramString));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      LogUtility.c("DownloadInterfaceNew", "[innerQuery] e=", paramJSONArray);
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
    //   0: ldc 23
    //   2: astore 7
    //   4: new 163	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   11: astore 4
    //   13: aload 4
    //   15: ldc_w 325
    //   18: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 29
    //   31: aload 4
    //   33: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 36	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: invokevirtual 328	com/tencent/open/appstore/js/DownloadInterfaceNew:hasRight	()Z
    //   43: ifne +5 -> 48
    //   46: iconst_m1
    //   47: ireturn
    //   48: aconst_null
    //   49: astore 4
    //   51: aload 4
    //   53: astore 5
    //   55: new 190	org/json/JSONObject
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 330	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   63: astore 6
    //   65: aload 4
    //   67: astore 5
    //   69: aload 6
    //   71: ldc_w 332
    //   74: invokevirtual 336	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   77: astore_1
    //   78: aload_1
    //   79: astore 5
    //   81: aload 6
    //   83: getstatic 341	com/tencent/open/downloadnew/DownloadConstants:i	Ljava/lang/String;
    //   86: invokevirtual 296	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 4
    //   91: aload 6
    //   93: getstatic 344	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   96: invokevirtual 304	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   99: istore_2
    //   100: aload 7
    //   102: astore 5
    //   104: aload 6
    //   106: ldc_w 346
    //   109: invokevirtual 296	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 9
    //   114: aload 9
    //   116: astore 5
    //   118: aload 9
    //   120: astore 6
    //   122: aload_1
    //   123: astore 8
    //   125: iload_2
    //   126: istore_3
    //   127: aload 4
    //   129: astore 7
    //   131: aload 9
    //   133: invokestatic 352	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   136: ifeq +76 -> 212
    //   139: aload 9
    //   141: astore 5
    //   143: aload_0
    //   144: getfield 38	com/tencent/open/appstore/js/DownloadInterfaceNew:d	Landroid/app/Activity;
    //   147: invokestatic 358	com/tencent/open/appcommon/js/DownloadInterface:getSourceInfoFromActivity	(Landroid/app/Activity;)Ljava/lang/String;
    //   150: astore 6
    //   152: aload_1
    //   153: astore 8
    //   155: iload_2
    //   156: istore_3
    //   157: aload 4
    //   159: astore 7
    //   161: goto +51 -> 212
    //   164: astore 6
    //   166: goto +23 -> 189
    //   169: astore 6
    //   171: goto +12 -> 183
    //   174: astore 6
    //   176: ldc 23
    //   178: astore 4
    //   180: aload 5
    //   182: astore_1
    //   183: iconst_0
    //   184: istore_2
    //   185: aload 7
    //   187: astore 5
    //   189: ldc 29
    //   191: ldc_w 360
    //   194: aload 6
    //   196: invokestatic 321	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: aload 4
    //   201: astore 7
    //   203: iload_2
    //   204: istore_3
    //   205: aload_1
    //   206: astore 8
    //   208: aload 5
    //   210: astore 6
    //   212: new 163	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   219: astore_1
    //   220: aload_1
    //   221: ldc_w 362
    //   224: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_1
    //   229: aload 8
    //   231: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_1
    //   236: ldc_w 367
    //   239: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_1
    //   244: aload 7
    //   246: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 29
    //   252: aload_1
    //   253: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 36	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 8
    //   261: ifnull +32 -> 293
    //   264: aload 8
    //   266: invokevirtual 284	org/json/JSONArray:length	()I
    //   269: ifne +5 -> 274
    //   272: iconst_m1
    //   273: ireturn
    //   274: invokestatic 373	com/tencent/open/downloadnew/MyAppApi:l	()Lcom/tencent/open/downloadnew/MyAppApi;
    //   277: aload_0
    //   278: getfield 38	com/tencent/open/appstore/js/DownloadInterfaceNew:d	Landroid/app/Activity;
    //   281: aload 8
    //   283: iload_3
    //   284: aload 7
    //   286: aload 6
    //   288: invokevirtual 376	com/tencent/open/downloadnew/MyAppApi:a	(Landroid/content/Context;Lorg/json/JSONArray;ILjava/lang/String;Ljava/lang/String;)V
    //   291: iconst_0
    //   292: ireturn
    //   293: iconst_m1
    //   294: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	DownloadInterfaceNew
    //   0	295	1	paramString	String
    //   99	105	2	i	int
    //   126	158	3	j	int
    //   11	189	4	localObject1	Object
    //   53	156	5	localObject2	Object
    //   63	88	6	localObject3	Object
    //   164	1	6	localJSONException1	JSONException
    //   169	1	6	localJSONException2	JSONException
    //   174	21	6	localJSONException3	JSONException
    //   210	77	6	localObject4	Object
    //   2	283	7	localObject5	Object
    //   123	159	8	str1	String
    //   112	28	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   104	114	164	org/json/JSONException
    //   131	139	164	org/json/JSONException
    //   143	152	164	org/json/JSONException
    //   91	100	169	org/json/JSONException
    //   55	65	174	org/json/JSONException
    //   69	78	174	org/json/JSONException
    //   81	91	174	org/json/JSONException
  }
  
  public void cancelDownload(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    DownloadProxy.a().a(paramString, true);
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    DownloadManagerV2.a().f(paramString);
  }
  
  public void deleteDownload(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    DownloadProxy.a().b(paramString, true);
  }
  
  public void destroy()
  {
    LogUtility.b("DownloadInterfaceNew", "destroy");
    JsCallbackManager.a().b(this);
  }
  
  public int doDownloadAction(String paramString)
  {
    LogUtility.b("DownloadInterfaceNew", "[doDownloadAction]");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.d) >= 6) {
      localBundle.putLong("OuterCall_JS_DoDownloadAction", System.currentTimeMillis());
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Object localObject2 = localJSONObject.optString("appId");
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localJSONObject.optString("appid");
        }
        if (!localJSONObject.has("delayDownload")) {
          break label1489;
        }
        int i = localJSONObject.optInt("delayDownload", -1);
        if ((this.d instanceof BaseActivity)) {
          localObject2 = (AppInterface)((BaseActivity)this.d).getAppRuntime();
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
        localBundle.putString(DownloadConstants.q, localJSONObject.optString(DownloadConstants.q));
        paramString = localJSONObject.optString(DownloadConstants.D);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doDownloadAction] feedChannel:");
        ((StringBuilder)localObject2).append(paramString);
        LogUtility.b("DownloadInterfaceNew", ((StringBuilder)localObject2).toString());
        boolean bool = TextUtils.isEmpty(paramString);
        if ((bool) || (paramString.startsWith("0;"))) {
          break label1492;
        }
        paramString = paramString.split(";");
        if ((paramString == null) || (paramString.length <= 0)) {
          break label1492;
        }
        localObject2 = paramString[0];
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1492;
        }
        paramString = (String)localObject2;
        if (((String)localObject2).equals("0")) {
          break label1492;
        }
        String str = localJSONObject.optString(DownloadConstants.M);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doDownloadAction] finalFeedChannel:");
        ((StringBuilder)localObject2).append(paramString);
        LogUtility.b("DownloadInterfaceNew", ((StringBuilder)localObject2).toString());
        if (TextUtils.isEmpty(paramString)) {
          localBundle.putString(DownloadConstants.D, str);
        } else {
          localBundle.putString(DownloadConstants.D, paramString);
        }
        paramString = localJSONObject.optString("via");
        i = localJSONObject.optInt("actionCode");
        if (this.e == null)
        {
          this.e = new LastDownloadAction((String)localObject1, paramString, i);
        }
        else if (this.e.a((String)localObject1, paramString, i))
        {
          LogUtility.b("DownloadInterfaceNew", "[doDownloadAction] repeat action,return");
          return 0;
        }
        if (localJSONObject.optInt("actionCode") != 12) {
          break label1498;
        }
        bool = a(localJSONObject.optInt("updateType"));
        localBundle.putBoolean(DownloadConstants.o, bool);
        bool = localJSONObject.has("updateData");
        if (!bool) {
          break label1498;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[doDownloadAction]  updateData e=");
          localStringBuilder.append(localException2.getMessage());
          LogUtility.c("DownloadInterfaceNew", localStringBuilder.toString());
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
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(localJSONObject.optInt("sourceFromServer"));
        localBundle.putString("sourceFromServer", ((StringBuilder)localObject3).toString());
        localBundle.putString(DownloadConstants.M, str);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(localJSONObject.optInt("pageId"));
        localBundle.putString("pageId", ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(localJSONObject.optInt("moduleId"));
        localBundle.putString("moduleId", ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(localJSONObject.optInt("positionId"));
        localBundle.putString("positionId", ((StringBuilder)localObject3).toString());
        localBundle.putString("apkId", localJSONObject.optString("apkId"));
        localBundle.putString("appId", (String)localObject1);
        localBundle.putInt("auto_start_yyb_download", localJSONObject.optInt("auto_start_yyb_download"));
        localObject3 = DownloadInterface.parseSourceType(this.d, localJSONObject);
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = "biz_src_yyb";
        }
        localBundle.putString("big_brother_ref_source_key", DownloadInterface.parseCurrentPageId(this.d));
        localBundle.putInt("hideInstallSuccessPage", localJSONObject.optInt("hideInstallSuccessPage"));
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[doDownloadAction] sourceType=");
        ((StringBuilder)localObject3).append((String)localObject1);
        LogUtility.b("DownloadInterfaceNew", ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[doDownloadAction] object ");
        ((StringBuilder)localObject3).append(localJSONObject.toString());
        LogUtility.b("DownloadInterfaceNew", ((StringBuilder)localObject3).toString());
        DownloadProxy.a().a(this.d, localBundle, (String)localObject1, paramString, i);
        return 0;
      }
      catch (NumberFormatException paramString)
      {
        LogUtility.c("DownloadInterfaceNew", "[doDownloadAction] Exception", paramString);
      }
      catch (JSONException paramString)
      {
        LogUtility.c("DownloadInterfaceNew", "[doDownloadAction] JSONException", paramString);
      }
      return -1;
      label1489:
      continue;
      label1492:
      paramString = "";
      continue;
      label1498:
      paramString = null;
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
    return this.a;
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[queryDownloadAction] guid=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",paramJson=");
    localStringBuilder.append(paramString1);
    LogUtility.b("DownloadInterfaceNew", localStringBuilder.toString());
    try
    {
      a(new JSONArray(paramString1), paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[queryDownloadAction] e=");
      paramString2.append(paramString1.getMessage());
      LogUtility.e("DownloadInterfaceNew", paramString2.toString());
    }
  }
  
  public WebView getWebview()
  {
    return this.b;
  }
  
  public void innerQueryInstalledAppInfo(String paramString1, String paramString2)
  {
    try
    {
      long l = System.currentTimeMillis();
      CommonDataAdapter.a().b().getPackageManager();
      Object localObject1 = new ArrayList();
      paramString1 = new JSONArray();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject1).next();
        if ((localPackageInfo.applicationInfo.flags & 0x1) == 0)
        {
          Object localObject2 = System.out;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MainActivity.getAppList, packageInfo=");
          localStringBuilder.append(localPackageInfo.packageName);
          ((PrintStream)localObject2).println(localStringBuilder.toString());
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("packagename", localPackageInfo.packageName);
            ((JSONObject)localObject2).put("versioncode", localPackageInfo.versionCode);
            ((JSONObject)localObject2).put("signature", MD5.b(localPackageInfo.signatures[(localPackageInfo.signatures.length - 1)].toCharsString()));
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          paramString1.put(localObject2);
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.queryInstalledAppInfo',{\"guid\": ");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", \"r\" : 0, \"data\":");
      ((StringBuilder)localObject1).append(paramString1.toString());
      ((StringBuilder)localObject1).append("});}void(0);");
      paramString1 = ((StringBuilder)localObject1).toString();
      paramString2 = new StringBuilder();
      paramString2.append("[queryInstalledAppInfo]TIMECOST:");
      paramString2.append(System.currentTimeMillis() - l);
      paramString2.append("ms, JSURL:");
      paramString2.append(paramString1);
      LogUtility.c("DownloadInterfaceNew", paramString2.toString());
      a(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[queryInstalledAppInfo] e=");
      paramString2.append(paramString1.getMessage());
      LogUtility.e("DownloadInterfaceNew", paramString2.toString());
    }
  }
  
  public void installYYB()
  {
    MyAppApi.l().c(this.d);
  }
  
  public void isYYBSupportBatchDownload(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">isYYBSupportBatchDownload ");
    localStringBuilder.append(paramString);
    LogUtility.b("DownloadInterfaceNew", localStringBuilder.toString());
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optString("callback");
        int i = MyAppApi.n();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(">isYYBSupportBatchDownload yybApiLevel=");
        localStringBuilder.append(i);
        LogUtility.b("DownloadInterfaceNew", localStringBuilder.toString());
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
          LogUtility.c("DownloadInterfaceNew", localStringBuilder.toString());
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
      DownloadProxy.a(this.d, localBundle);
    }
    catch (JSONException paramString)
    {
      LogUtility.c("DownloadInterfaceNew", "JSONException", paramString);
    }
    return 0;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">queryYYBApiLevel ");
    localStringBuilder.append(paramString);
    LogUtility.b("DownloadInterfaceNew", localStringBuilder.toString());
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      int i = MyAppApi.n();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">queryYYBApiLevel yybApiLevel=");
      localStringBuilder.append(i);
      LogUtility.b("DownloadInterfaceNew", localStringBuilder.toString());
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
      LogUtility.c("DownloadInterfaceNew", localStringBuilder.toString());
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
    localStringBuilder.append("[registerDownloadCallBackListener] callbackMethod=");
    localStringBuilder.append(paramString);
    LogUtility.b("DownloadInterfaceNew", localStringBuilder.toString());
    this.a = paramString;
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
      DownloadProxy.b(localBundle);
    }
    catch (JSONException paramString)
    {
      LogUtility.c("DownloadInterfaceNew", "JSONException", paramString);
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
      DownloadProxy.c(localBundle);
    }
    catch (JSONException paramString)
    {
      LogUtility.c("DownloadInterfaceNew", "JSONException", paramString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.js.DownloadInterfaceNew
 * JD-Core Version:    0.7.0.1
 */