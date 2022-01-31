package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import bglv;
import bgok;
import bgor;
import bgpx;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.proxy.NavigationProxy;
import com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.ui.MiniTranslucentFragmentActivity;
import org.json.JSONObject;

public class NavigationJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NavigationJsPlugin";
  private static final int navigateBackByAPPInfo = bgpx.a("qqminiapp", "mini_app_navigate_back_by_appinfo", 1);
  private NavigationProxy navigationProxy;
  
  private static void navigateBackMiniApp(Activity paramActivity, String paramString, LaunchParam paramLaunchParam, ResultReceiver paramResultReceiver)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("mini_appid", paramString);
    if (paramLaunchParam != null)
    {
      paramLaunchParam.fromBackToMiniApp = 1;
      localIntent.putExtra("mini_launch_param", paramLaunchParam);
    }
    localIntent.putExtra("mini_receiver", paramResultReceiver);
    localIntent.putExtra("public_fragment_window_feature", 1);
    MiniTranslucentFragmentActivity.a(paramActivity, localIntent, MiniAppInfoLoadingFragment.class);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void navigateBackMiniApp(MiniAppInfo paramMiniAppInfo, String paramString, ResultReceiver paramResultReceiver)
  {
    MiniAppInfo localMiniAppInfo = MiniAppInfo.copy(paramMiniAppInfo);
    localMiniAppInfo.launchParam.miniAppId = paramMiniAppInfo.appId;
    localMiniAppInfo.launchParam.scene = 1038;
    localMiniAppInfo.launchParam.navigateExtData = paramString;
    localMiniAppInfo.launchParam.fromBackToMiniApp = 1;
    localMiniAppInfo.launchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
    MiniSDK.startMiniApp(this.mMiniAppContext.a(), localMiniAppInfo, new Bundle(), paramResultReceiver);
  }
  
  private boolean navigateBackMiniApp(String paramString1, String paramString2)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString2;
    localLaunchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
    navigateBackMiniApp(this.mMiniAppContext.a(), paramString1, localLaunchParam, new NavigationJsPlugin.4(this, new Handler(Looper.getMainLooper())));
    return true;
  }
  
  public void exitMiniProgram(bgok parambgok)
  {
    bgor.a(new NavigationJsPlugin.5(this, this.mMiniAppContext.a()));
    parambgok.a();
  }
  
  public void navigateBackMiniProgram(bgok parambgok)
  {
    new JSONObject();
    Object localObject2;
    String str;
    do
    {
      do
      {
        try
        {
          Object localObject1 = new JSONObject(parambgok.b);
          if (navigateBackByAPPInfo == 0) {
            if (localObject1 != null)
            {
              localObject1 = ((JSONObject)localObject1).optString("extraData");
              localObject2 = this.mMiniAppInfo.launchParam.fromMiniAppId;
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (navigateBackMiniApp((String)localObject2, (String)localObject1))) {
                parambgok.a();
              }
            }
            else
            {
              return;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QMLog.e("NavigationJsPlugin", localThrowable.getMessage(), localThrowable);
            str = null;
          }
          parambgok.b();
          return;
        }
      } while ((navigateBackByAPPInfo != 1) || (str == null));
      str = str.optString("extraData");
      localObject2 = this.mMiniAppInfo.launchParam.fromMiniAppInfo;
    } while (localObject2 == null);
    navigateBackMiniApp((MiniAppInfo)localObject2, str, new NavigationJsPlugin.3(this, new Handler(Looper.getMainLooper()), parambgok));
  }
  
  /* Error */
  public void navigateToMiniProgram(bgok parambgok)
  {
    // Byte code:
    //   0: sipush 2001
    //   3: istore_3
    //   4: new 161	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: getfield 165	bgok:b	Ljava/lang/String;
    //   12: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload_0
    //   18: getfield 208	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/core/proxy/NavigationProxy;
    //   21: invokevirtual 213	com/tencent/qqmini/sdk/core/proxy/NavigationProxy:onBeforeNavigateToMiniProgram	()V
    //   24: aload 4
    //   26: ifnull +207 -> 233
    //   29: aload 4
    //   31: ldc 215
    //   33: invokevirtual 174	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 6
    //   38: aload 4
    //   40: invokestatic 219	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   43: astore 7
    //   45: aload_0
    //   46: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   49: getfield 82	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   52: getfield 223	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   55: astore 8
    //   57: aload 7
    //   59: ifnull +251 -> 310
    //   62: ldc 16
    //   64: ldc 225
    //   66: ldc 227
    //   68: invokestatic 230	bgpx:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: aload_0
    //   72: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   75: getfield 85	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   78: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +171 -> 252
    //   84: sipush 2077
    //   87: istore_2
    //   88: aload 4
    //   90: ldc 170
    //   92: invokevirtual 240	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   95: astore 9
    //   97: aload 9
    //   99: ifnull +170 -> 269
    //   102: aload 9
    //   104: invokevirtual 243	org/json/JSONObject:toString	()Ljava/lang/String;
    //   107: astore 5
    //   109: new 43	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   112: dup
    //   113: invokespecial 121	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   116: astore 10
    //   118: aload 10
    //   120: iload_2
    //   121: putfield 91	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   124: aload 10
    //   126: aload_0
    //   127: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   130: getfield 82	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   133: getfield 88	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   136: putfield 101	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   139: aload 10
    //   141: aload 5
    //   143: putfield 94	com/tencent/qqmini/sdk/launcher/model/LaunchParam:navigateExtData	Ljava/lang/String;
    //   146: aload 8
    //   148: ifnull +10 -> 158
    //   151: aload 10
    //   153: aload 8
    //   155: putfield 223	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   158: aload 7
    //   160: getfield 82	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   163: aload 10
    //   165: invokevirtual 247	com/tencent/qqmini/sdk/launcher/model/LaunchParam:clone	(Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;)V
    //   168: aload_0
    //   169: getfield 105	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppContext	Lbglv;
    //   172: invokeinterface 110 1 0
    //   177: aload 7
    //   179: invokestatic 250	com/tencent/qqmini/sdk/MiniSDK:startMiniApp	(Landroid/app/Activity;Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)V
    //   182: aload_1
    //   183: invokevirtual 156	bgok:a	()Ljava/lang/String;
    //   186: pop
    //   187: ldc 8
    //   189: new 252	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   196: ldc 255
    //   198: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 7
    //   203: invokevirtual 260	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:toString	()Ljava/lang/String;
    //   206: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 265	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload 7
    //   217: getfield 268	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:verType	I
    //   220: iconst_3
    //   221: if_icmpne +12 -> 233
    //   224: aload_0
    //   225: getfield 208	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/core/proxy/NavigationProxy;
    //   228: aload 9
    //   230: invokevirtual 272	com/tencent/qqmini/sdk/core/proxy/NavigationProxy:onAfterLaunchByAppInfo	(Lorg/json/JSONObject;)V
    //   233: return
    //   234: astore 4
    //   236: ldc 8
    //   238: ldc_w 274
    //   241: aload 4
    //   243: invokestatic 191	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: aconst_null
    //   247: astore 4
    //   249: goto -232 -> 17
    //   252: aload_0
    //   253: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   256: invokevirtual 278	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   259: ifeq +399 -> 658
    //   262: sipush 2001
    //   265: istore_2
    //   266: goto +389 -> 655
    //   269: ldc_w 274
    //   272: astore 5
    //   274: goto -165 -> 109
    //   277: astore 5
    //   279: ldc 8
    //   281: new 252	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 280
    //   291: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload 5
    //   296: invokevirtual 281	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   299: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: aload 5
    //   307: invokestatic 191	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   310: aload 4
    //   312: ldc_w 283
    //   315: invokevirtual 287	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   318: istore_2
    //   319: aload 4
    //   321: ldc_w 288
    //   324: invokevirtual 174	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   327: astore 5
    //   329: iload_2
    //   330: ifne +233 -> 563
    //   333: aload 4
    //   335: ldc_w 290
    //   338: invokevirtual 174	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: astore 7
    //   343: aload 4
    //   345: ldc_w 292
    //   348: invokevirtual 174	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   351: astore 8
    //   353: aload 4
    //   355: ldc 170
    //   357: invokevirtual 240	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   360: astore 4
    //   362: aload 4
    //   364: ifnull +184 -> 548
    //   367: aload 4
    //   369: invokevirtual 243	org/json/JSONObject:toString	()Ljava/lang/String;
    //   372: astore 4
    //   374: new 43	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   377: dup
    //   378: invokespecial 121	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   381: astore 9
    //   383: aload_0
    //   384: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   387: invokevirtual 278	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   390: ifeq +166 -> 556
    //   393: aload 9
    //   395: iload_3
    //   396: putfield 91	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   399: aload 9
    //   401: aload 7
    //   403: putfield 295	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryPath	Ljava/lang/String;
    //   406: aload 9
    //   408: aload 4
    //   410: putfield 94	com/tencent/qqmini/sdk/launcher/model/LaunchParam:navigateExtData	Ljava/lang/String;
    //   413: aload 9
    //   415: aload_0
    //   416: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   419: getfield 82	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   422: getfield 88	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   425: putfield 101	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   428: aload 9
    //   430: aload_0
    //   431: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   434: getfield 82	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   437: getfield 223	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   440: putfield 223	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   443: aload 9
    //   445: aload 8
    //   447: putfield 297	com/tencent/qqmini/sdk/launcher/model/LaunchParam:envVersion	Ljava/lang/String;
    //   450: aload_0
    //   451: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   454: invokevirtual 300	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isSpecialMiniApp	()Z
    //   457: ifne +34 -> 491
    //   460: getstatic 26	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:navigateBackByAPPInfo	I
    //   463: iconst_1
    //   464: if_icmpne +27 -> 491
    //   467: aload 9
    //   469: aload_0
    //   470: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   473: invokevirtual 303	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:getVerTypeStr	()Ljava/lang/String;
    //   476: putfield 306	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromEnvVersion	Ljava/lang/String;
    //   479: aload 9
    //   481: aload_0
    //   482: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   485: invokestatic 78	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:copy	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   488: putfield 196	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   491: aload 9
    //   493: aload 6
    //   495: putfield 308	com/tencent/qqmini/sdk/launcher/model/LaunchParam:reportData	Ljava/lang/String;
    //   498: aload_0
    //   499: getfield 105	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppContext	Lbglv;
    //   502: invokeinterface 110 1 0
    //   507: aload 5
    //   509: aload 9
    //   511: getfield 91	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   514: aload 7
    //   516: aload 8
    //   518: aload 9
    //   520: new 310	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin$1
    //   523: dup
    //   524: aload_0
    //   525: new 125	android/os/Handler
    //   528: dup
    //   529: invokestatic 131	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   532: invokespecial 134	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   535: aload_1
    //   536: invokespecial 311	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin$1:<init>	(Lcom/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin;Landroid/os/Handler;Lbgok;)V
    //   539: invokestatic 314	com/tencent/qqmini/sdk/MiniSDK:startMiniApp	(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;Landroid/os/ResultReceiver;)V
    //   542: aload_1
    //   543: invokevirtual 156	bgok:a	()Ljava/lang/String;
    //   546: pop
    //   547: return
    //   548: ldc_w 274
    //   551: astore 4
    //   553: goto -179 -> 374
    //   556: sipush 1037
    //   559: istore_3
    //   560: goto -167 -> 393
    //   563: new 43	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   566: dup
    //   567: invokespecial 121	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   570: astore 6
    //   572: aload_0
    //   573: getfield 98	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   576: invokevirtual 278	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   579: ifeq +63 -> 642
    //   582: aload 6
    //   584: iload_3
    //   585: putfield 91	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   588: aload_0
    //   589: getfield 208	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/core/proxy/NavigationProxy;
    //   592: iload_2
    //   593: aload_0
    //   594: getfield 105	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppContext	Lbglv;
    //   597: invokeinterface 110 1 0
    //   602: aload 5
    //   604: aload 6
    //   606: getfield 91	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   609: aload 4
    //   611: new 316	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin$2
    //   614: dup
    //   615: aload_0
    //   616: new 125	android/os/Handler
    //   619: dup
    //   620: invokestatic 131	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   623: invokespecial 134	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   626: aload_1
    //   627: invokespecial 317	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin$2:<init>	(Lcom/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin;Landroid/os/Handler;Lbgok;)V
    //   630: invokevirtual 321	com/tencent/qqmini/sdk/core/proxy/NavigationProxy:launchByAppType	(ILandroid/app/Activity;Ljava/lang/String;ILorg/json/JSONObject;Landroid/os/ResultReceiver;)Z
    //   633: ifeq +16 -> 649
    //   636: aload_1
    //   637: invokevirtual 156	bgok:a	()Ljava/lang/String;
    //   640: pop
    //   641: return
    //   642: sipush 1037
    //   645: istore_3
    //   646: goto -64 -> 582
    //   649: aload_1
    //   650: invokevirtual 193	bgok:b	()Ljava/lang/String;
    //   653: pop
    //   654: return
    //   655: goto -567 -> 88
    //   658: sipush 1037
    //   661: istore_2
    //   662: goto -7 -> 655
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	665	0	this	NavigationJsPlugin
    //   0	665	1	parambgok	bgok
    //   87	575	2	i	int
    //   3	643	3	j	int
    //   15	74	4	localJSONObject	JSONObject
    //   234	8	4	localThrowable	Throwable
    //   247	363	4	localObject1	Object
    //   107	166	5	str1	String
    //   277	29	5	localException	java.lang.Exception
    //   327	276	5	str2	String
    //   36	569	6	localObject2	Object
    //   43	472	7	localObject3	Object
    //   55	462	8	localObject4	Object
    //   95	424	9	localObject5	Object
    //   116	48	10	localLaunchParam	LaunchParam
    // Exception table:
    //   from	to	target	type
    //   4	17	234	java/lang/Throwable
    //   62	84	277	java/lang/Exception
    //   88	97	277	java/lang/Exception
    //   102	109	277	java/lang/Exception
    //   109	146	277	java/lang/Exception
    //   151	158	277	java/lang/Exception
    //   158	233	277	java/lang/Exception
    //   252	262	277	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */