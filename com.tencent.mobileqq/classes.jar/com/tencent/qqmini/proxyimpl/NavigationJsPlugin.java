package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import common.config.service.QzoneConfig;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class NavigationJsPlugin
  extends BaseJsPlugin
{
  private static final int b = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_navigate_back_by_appinfo", 1);
  private WnsConfigProxy a = (WnsConfigProxy)AppLoaderFactory.g().getProxyManager().get(WnsConfigProxy.class);
  
  private void a(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAndRemoveTask();
      return;
    }
    paramActivity.finish();
  }
  
  private void a(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new NavigationJsPlugin.5(this, paramMiniAppInfo), 32, null, true);
  }
  
  private void a(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.miniAppId = paramMiniAppInfo.appId;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString1;
    localLaunchParam.privateExtraData = paramString2;
    localLaunchParam.fromBackToMiniApp = 1;
    localLaunchParam.fromMiniAppId = this.mApkgInfo.appId;
    paramMiniAppInfo = new MiniAppConfig(paramMiniAppInfo);
    paramMiniAppInfo.launchParam = localLaunchParam;
    MiniAppController.startApp(this.mMiniAppContext.getAttachedActivity(), paramMiniAppInfo, new NavigationJsPlugin.7(this, new Handler(Looper.getMainLooper()), paramMiniAppLaunchListener));
  }
  
  private void a(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("appId");
    paramJSONObject = paramJSONObject.optString("path");
    int i;
    if (this.mMiniAppInfo.isAppStoreMiniApp()) {
      i = 2001;
    } else {
      i = 1037;
    }
    ((IWxMiniManager)QRoute.api(IWxMiniManager.class)).startWxMiniAppById(this.mMiniAppContext.getAttachedActivity(), str, paramJSONObject, i);
    paramRequestEvent.ok();
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString2;
    localLaunchParam.privateExtraData = paramString3;
    localLaunchParam.fromMiniAppId = this.mApkgInfo.appId;
    paramString2 = this.mMiniAppContext.getAttachedActivity();
    MiniAppController.navigateBackMiniApp(paramString2, paramString1, localLaunchParam, new NavigationJsPlugin.6(this, paramString2));
    return true;
  }
  
  @JsEvent({"exitMiniProgram"})
  public void exitMiniProgram(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NavigationJsPlugin.1(this, this.mMiniAppContext.getAttachedActivity()));
    paramRequestEvent.ok();
  }
  
  @JsEvent({"navigateBackMiniProgram"})
  public void navigateBackMiniProgram(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int i = b;
      String str;
      Object localObject2;
      if (i == 0)
      {
        str = ((JSONObject)localObject1).optString("extraData");
        localObject1 = ((JSONObject)localObject1).optString("privateExtraData");
        localObject2 = this.mMiniAppInfo.launchParam.fromMiniAppId;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (a((String)localObject2, str, (String)localObject1)))
        {
          paramRequestEvent.ok();
          return;
        }
        paramRequestEvent.fail();
        return;
      }
      if (b == 1)
      {
        str = ((JSONObject)localObject1).optString("extraData");
        localObject1 = ((JSONObject)localObject1).optString("privateExtraData");
        localObject2 = MiniSdkLauncher.convert(this.mMiniAppInfo.launchParam.fromMiniAppInfo);
        if (localObject2 != null)
        {
          a((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2, str, (String)localObject1, new NavigationJsPlugin.2(this, paramRequestEvent));
          return;
        }
      }
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("NavigationJsPlugin", 1, "navigateBackMiniProgram error, ", paramRequestEvent);
    }
  }
  
  /* Error */
  @JsEvent({"navigateToMiniProgram"})
  public void navigateToMiniProgram(RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: new 161	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: getfield 232	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   8: invokespecial 235	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: goto +22 -> 35
    //   16: astore 6
    //   18: ldc_w 273
    //   21: iconst_1
    //   22: aload 6
    //   24: invokevirtual 287	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   27: aload 6
    //   29: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   32: aconst_null
    //   33: astore 7
    //   35: aload_0
    //   36: getfield 126	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   39: invokeinterface 132 1 0
    //   44: astore 11
    //   46: aload 7
    //   48: ifnull +801 -> 849
    //   51: aload 11
    //   53: ifnull +796 -> 849
    //   56: aload 7
    //   58: ldc_w 289
    //   61: iconst_0
    //   62: invokevirtual 293	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   65: istore_3
    //   66: aload 7
    //   68: ldc_w 295
    //   71: iconst_0
    //   72: invokevirtual 293	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   75: istore 4
    //   77: aload 7
    //   79: ldc_w 297
    //   82: iconst_0
    //   83: invokevirtual 293	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   86: istore 5
    //   88: aload 7
    //   90: ldc_w 299
    //   93: invokevirtual 165	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 12
    //   98: aload 7
    //   100: invokestatic 303	com/tencent/mobileqq/mini/apkg/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   103: astore 14
    //   105: aload_0
    //   106: getfield 126	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   109: invokeinterface 307 1 0
    //   114: astore 10
    //   116: aload 10
    //   118: getfield 241	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   121: getfield 311	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   124: astore 13
    //   126: ldc_w 313
    //   129: astore 9
    //   131: aload 14
    //   133: ifnull +386 -> 519
    //   136: aload 10
    //   138: getfield 317	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appMode	Lcom/tencent/qqmini/sdk/launcher/model/AppMode;
    //   141: getfield 322	com/tencent/qqmini/sdk/launcher/model/AppMode:useAppInfoWhenNavigate	Z
    //   144: ifeq +375 -> 519
    //   147: aload_0
    //   148: getfield 51	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/WnsConfigProxy;
    //   151: astore 6
    //   153: aload 6
    //   155: ldc 19
    //   157: ldc_w 324
    //   160: invokevirtual 327	com/tencent/qqmini/sdk/launcher/core/proxy/WnsConfigProxy:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 8
    //   165: aload 8
    //   167: astore 6
    //   169: aload 8
    //   171: invokestatic 332	com/tencent/mobileqq/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   174: ifeq +8 -> 182
    //   177: ldc_w 334
    //   180: astore 6
    //   182: aload_0
    //   183: getfield 126	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   186: invokeinterface 307 1 0
    //   191: ifnull +30 -> 221
    //   194: aload 6
    //   196: aload_0
    //   197: getfield 126	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   200: invokeinterface 307 1 0
    //   205: getfield 335	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   208: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifeq +10 -> 221
    //   214: sipush 2077
    //   217: istore_2
    //   218: goto +18 -> 236
    //   221: aload 10
    //   223: invokevirtual 177	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   226: ifeq +624 -> 850
    //   229: sipush 2001
    //   232: istore_2
    //   233: goto +3 -> 236
    //   236: aload 7
    //   238: ldc 237
    //   240: invokevirtual 345	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   243: astore 6
    //   245: aload 6
    //   247: ifnull +610 -> 857
    //   250: aload 6
    //   252: invokevirtual 348	org/json/JSONObject:toString	()Ljava/lang/String;
    //   255: astore 6
    //   257: goto +3 -> 260
    //   260: aload 7
    //   262: ldc 238
    //   264: invokevirtual 345	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   267: astore 8
    //   269: aload 8
    //   271: ifnull +594 -> 865
    //   274: aload 8
    //   276: invokevirtual 348	org/json/JSONObject:toString	()Ljava/lang/String;
    //   279: astore 8
    //   281: goto +3 -> 284
    //   284: new 82	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   287: dup
    //   288: invokespecial 83	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   291: astore 15
    //   293: aload 15
    //   295: iload_2
    //   296: putfield 95	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   299: aload 15
    //   301: aload 10
    //   303: getfield 241	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   306: getfield 349	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   309: putfield 114	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   312: aload 15
    //   314: aload 6
    //   316: putfield 98	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   319: aload 15
    //   321: aload 8
    //   323: putfield 101	com/tencent/mobileqq/mini/sdk/LaunchParam:privateExtraData	Ljava/lang/String;
    //   326: aload 15
    //   328: iload 5
    //   330: putfield 351	com/tencent/mobileqq/mini/sdk/LaunchParam:skipHotReload	Z
    //   333: aload 13
    //   335: ifnull +13 -> 348
    //   338: aload 15
    //   340: aload 13
    //   342: invokestatic 356	com/tencent/qqmini/proxyimpl/MiniSdkUtil:a	(Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;)Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   345: putfield 359	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   348: iload 4
    //   350: ifeq +523 -> 873
    //   353: aload 15
    //   355: iconst_2
    //   356: putfield 362	com/tencent/mobileqq/mini/sdk/LaunchParam:forceReload	I
    //   359: goto +3 -> 362
    //   362: aload 7
    //   364: invokestatic 303	com/tencent/mobileqq/mini/apkg/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   367: astore 6
    //   369: new 136	android/os/Handler
    //   372: dup
    //   373: invokespecial 363	android/os/Handler:<init>	()V
    //   376: astore 8
    //   378: aload 11
    //   380: aload 6
    //   382: aload 15
    //   384: new 365	com/tencent/qqmini/proxyimpl/NavigationJsPlugin$3
    //   387: dup
    //   388: aload_0
    //   389: aload 8
    //   391: iload_3
    //   392: aload 11
    //   394: aload_1
    //   395: invokespecial 368	com/tencent/qqmini/proxyimpl/NavigationJsPlugin$3:<init>	(Lcom/tencent/qqmini/proxyimpl/NavigationJsPlugin;Landroid/os/Handler;ZLandroid/app/Activity;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V
    //   398: invokestatic 372	com/tencent/mobileqq/mini/sdk/MiniAppController:launchMiniAppByAppInfo	(Landroid/app/Activity;Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Landroid/os/ResultReceiver;)V
    //   401: aload_1
    //   402: invokevirtual 195	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   405: pop
    //   406: new 374	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 375	java/lang/StringBuilder:<init>	()V
    //   413: astore 8
    //   415: aload 8
    //   417: ldc_w 377
    //   420: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 8
    //   426: aload 14
    //   428: invokevirtual 382	com/tencent/mobileqq/mini/apkg/MiniAppInfo:toString	()Ljava/lang/String;
    //   431: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: ldc_w 273
    //   438: iconst_1
    //   439: aload 8
    //   441: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload 14
    //   449: getfield 389	com/tencent/mobileqq/mini/apkg/MiniAppInfo:verType	I
    //   452: iconst_3
    //   453: if_icmpne +9 -> 462
    //   456: aload_0
    //   457: aload 6
    //   459: invokespecial 391	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:a	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   462: return
    //   463: astore 6
    //   465: goto +10 -> 475
    //   468: astore 6
    //   470: goto +5 -> 475
    //   473: astore 6
    //   475: new 374	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 375	java/lang/StringBuilder:<init>	()V
    //   482: astore 8
    //   484: aload 8
    //   486: ldc_w 393
    //   489: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 8
    //   495: aload 6
    //   497: invokestatic 399	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   500: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: ldc_w 273
    //   507: iconst_1
    //   508: aload 8
    //   510: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 401	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: goto +3 -> 519
    //   519: aload 7
    //   521: ldc_w 403
    //   524: invokevirtual 407	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   527: istore_2
    //   528: aload 7
    //   530: ldc 159
    //   532: invokevirtual 165	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   535: astore 14
    //   537: iload_2
    //   538: ifne +283 -> 821
    //   541: aload 7
    //   543: ldc 167
    //   545: invokevirtual 165	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   548: astore 15
    //   550: aload 7
    //   552: ldc_w 409
    //   555: invokevirtual 165	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   558: astore 8
    //   560: aload 7
    //   562: ldc 237
    //   564: invokevirtual 345	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   567: astore 6
    //   569: aload 6
    //   571: ifnull +13 -> 584
    //   574: aload 6
    //   576: invokevirtual 348	org/json/JSONObject:toString	()Ljava/lang/String;
    //   579: astore 6
    //   581: goto +8 -> 589
    //   584: ldc_w 313
    //   587: astore 6
    //   589: aload_0
    //   590: getfield 171	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   593: ifnull +27 -> 620
    //   596: ldc_w 411
    //   599: aload_0
    //   600: getfield 171	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   603: invokevirtual 414	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:getVerTypeStr	()Ljava/lang/String;
    //   606: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   609: ifeq +11 -> 620
    //   612: ldc_w 411
    //   615: astore 8
    //   617: goto +3 -> 620
    //   620: new 82	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   623: dup
    //   624: invokespecial 83	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   627: astore 16
    //   629: aload 10
    //   631: invokevirtual 177	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   634: ifeq +10 -> 644
    //   637: sipush 2001
    //   640: istore_2
    //   641: goto +7 -> 648
    //   644: sipush 1037
    //   647: istore_2
    //   648: aload 16
    //   650: iload_2
    //   651: putfield 95	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   654: aload 16
    //   656: aload 15
    //   658: putfield 417	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   661: aload 16
    //   663: aload 6
    //   665: putfield 98	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   668: aload 16
    //   670: aload 10
    //   672: getfield 241	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   675: getfield 349	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   678: putfield 114	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   681: aload 16
    //   683: aload 13
    //   685: invokestatic 356	com/tencent/qqmini/proxyimpl/MiniSdkUtil:a	(Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;)Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   688: putfield 359	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   691: aload 16
    //   693: aload 8
    //   695: putfield 419	com/tencent/mobileqq/mini/sdk/LaunchParam:envVersion	Ljava/lang/String;
    //   698: aload 16
    //   700: aload 12
    //   702: putfield 421	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/lang/String;
    //   705: aload 16
    //   707: iload 5
    //   709: putfield 351	com/tencent/mobileqq/mini/sdk/LaunchParam:skipHotReload	Z
    //   712: aload 7
    //   714: ldc 238
    //   716: invokevirtual 345	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   719: astore 7
    //   721: aload 9
    //   723: astore 6
    //   725: aload 7
    //   727: ifnull +10 -> 737
    //   730: aload 7
    //   732: invokevirtual 348	org/json/JSONObject:toString	()Ljava/lang/String;
    //   735: astore 6
    //   737: aload 16
    //   739: aload 6
    //   741: putfield 101	com/tencent/mobileqq/mini/sdk/LaunchParam:privateExtraData	Ljava/lang/String;
    //   744: aload 10
    //   746: invokevirtual 424	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isSpecialMiniApp	()Z
    //   749: ifne +30 -> 779
    //   752: getstatic 27	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:b	I
    //   755: iconst_1
    //   756: if_icmpne +23 -> 779
    //   759: aload 16
    //   761: aload 10
    //   763: invokevirtual 414	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:getVerTypeStr	()Ljava/lang/String;
    //   766: putfield 427	com/tencent/mobileqq/mini/sdk/LaunchParam:fromEnvVersion	Ljava/lang/String;
    //   769: aload 16
    //   771: aload 10
    //   773: invokestatic 264	com/tencent/mobileqq/mini/launch/MiniSdkLauncher:convert	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   776: putfield 430	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppInfo	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   779: iload 4
    //   781: ifeq +9 -> 790
    //   784: aload 16
    //   786: iconst_2
    //   787: putfield 362	com/tencent/mobileqq/mini/sdk/LaunchParam:forceReload	I
    //   790: aload 11
    //   792: aload 14
    //   794: aload 15
    //   796: aload 8
    //   798: aload 16
    //   800: new 432	com/tencent/qqmini/proxyimpl/NavigationJsPlugin$4
    //   803: dup
    //   804: aload_0
    //   805: iload_3
    //   806: aload 11
    //   808: aload_1
    //   809: invokespecial 435	com/tencent/qqmini/proxyimpl/NavigationJsPlugin$4:<init>	(Lcom/tencent/qqmini/proxyimpl/NavigationJsPlugin;ZLandroid/app/Activity;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V
    //   812: invokestatic 439	com/tencent/mobileqq/mini/sdk/MiniAppController:startAppByAppid	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)V
    //   815: aload_1
    //   816: invokevirtual 195	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   819: pop
    //   820: return
    //   821: iload_2
    //   822: iconst_1
    //   823: if_icmpne +26 -> 849
    //   826: aload 11
    //   828: aload 14
    //   830: aload 7
    //   832: invokestatic 445	com/tencent/mobileqq/microapp/ext/GameProxy:startGameByMiniApp	(Landroid/app/Activity;Ljava/lang/String;Lorg/json/JSONObject;)Z
    //   835: ifeq +9 -> 844
    //   838: aload_1
    //   839: invokevirtual 195	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   842: pop
    //   843: return
    //   844: aload_1
    //   845: invokevirtual 255	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   848: pop
    //   849: return
    //   850: sipush 1037
    //   853: istore_2
    //   854: goto -618 -> 236
    //   857: ldc_w 313
    //   860: astore 6
    //   862: goto -602 -> 260
    //   865: ldc_w 313
    //   868: astore 8
    //   870: goto -586 -> 284
    //   873: goto -511 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	876	0	this	NavigationJsPlugin
    //   0	876	1	paramRequestEvent	RequestEvent
    //   217	637	2	i	int
    //   65	741	3	bool1	boolean
    //   75	705	4	bool2	boolean
    //   86	622	5	bool3	boolean
    //   16	12	6	localThrowable	Throwable
    //   151	307	6	localObject1	Object
    //   463	1	6	localException1	Exception
    //   468	1	6	localException2	Exception
    //   473	23	6	localException3	Exception
    //   567	294	6	localObject2	Object
    //   11	820	7	localJSONObject	JSONObject
    //   163	706	8	localObject3	Object
    //   129	593	9	str1	String
    //   114	658	10	localMiniAppInfo	com.tencent.qqmini.sdk.launcher.model.MiniAppInfo
    //   44	783	11	localActivity	Activity
    //   96	605	12	str2	String
    //   124	560	13	localEntryModel	com.tencent.qqmini.sdk.launcher.model.EntryModel
    //   103	726	14	localObject4	Object
    //   291	504	15	localObject5	Object
    //   627	172	16	localLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    // Exception table:
    //   from	to	target	type
    //   0	13	16	java/lang/Throwable
    //   378	462	463	java/lang/Exception
    //   153	165	468	java/lang/Exception
    //   169	177	468	java/lang/Exception
    //   182	214	468	java/lang/Exception
    //   221	229	468	java/lang/Exception
    //   236	245	468	java/lang/Exception
    //   250	257	468	java/lang/Exception
    //   260	269	468	java/lang/Exception
    //   274	281	468	java/lang/Exception
    //   284	333	468	java/lang/Exception
    //   338	348	468	java/lang/Exception
    //   353	359	468	java/lang/Exception
    //   362	378	468	java/lang/Exception
    //   147	153	473	java/lang/Exception
  }
  
  @JsEvent({"navigateToWeMiniProgram"})
  public void navigateToWeMiniProgram(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo = com.tencent.qqmini.sdk.launcher.model.MiniAppInfo.createMiniAppInfo(localJSONObject.optJSONObject("appInfo"));
        if ((localMiniAppInfo != null) && (this.mMiniAppInfo.appMode.useAppInfoWhenNavigate))
        {
          try
          {
            if (TextUtils.equals(WnsConfig.getConfig("qqminiapp", "miniappsearchappid", "1109875297"), this.mMiniAppInfo.appId))
            {
              i = 2077;
            }
            else
            {
              if (!this.mMiniAppInfo.isAppStoreMiniApp()) {
                break label244;
              }
              i = 2001;
            }
            ((IWxMiniManager)QRoute.api(IWxMiniManager.class)).startWxMiniAppById(this.mMiniAppContext.getAttachedActivity(), localMiniAppInfo.appId, localMiniAppInfo.launchParam.entryPath, i);
            paramRequestEvent.ok();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("navigateToMiniProgram, open miniApp from appInfo, appInfo: ");
            localStringBuilder.append(localMiniAppInfo.toString());
            QMLog.d("NavigationJsPlugin", localStringBuilder.toString());
            return;
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("navigateToMiniProgram, ");
            localStringBuilder.append(localException.getMessage());
            QMLog.e("NavigationJsPlugin", localStringBuilder.toString(), localException);
          }
        }
        else
        {
          a(paramRequestEvent, localJSONObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("NavigationJsPlugin", "navigateToWeMiniProgram failed!", localJSONException);
        paramRequestEvent.fail(localJSONException.getMessage());
        return;
      }
      label244:
      int i = 1037;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */