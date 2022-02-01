package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher.FragmentType;
import org.json.JSONObject;

public class NavigationJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NavigationJsPlugin";
  private static final int navigateBackByAPPInfo = WnsConfig.getConfig("qqminiapp", "mini_app_navigate_back_by_appinfo", 1);
  private NavigationProxy navigationProxy = (NavigationProxy)ProxyManager.get(NavigationProxy.class);
  
  private static void navigateBackMiniApp(Activity paramActivity, String paramString, LaunchParam paramLaunchParam, ResultReceiver paramResultReceiver)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_appid", paramString);
    if (paramLaunchParam != null)
    {
      paramLaunchParam.fromBackToMiniApp = 1;
      localIntent.putExtra("mini_launch_param", paramLaunchParam);
    }
    localIntent.putExtra("mini_receiver", paramResultReceiver);
    localIntent.putExtra("public_fragment_window_feature", 1);
    MiniFragmentLauncher.startTranslucent(paramActivity, localIntent, MiniFragmentLauncher.FragmentType.FRAGMENT_APPINFO_LOADING);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void navigateBackMiniApp(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, ResultReceiver paramResultReceiver)
  {
    MiniAppInfo localMiniAppInfo = MiniAppInfo.copy(paramMiniAppInfo);
    localMiniAppInfo.launchParam.miniAppId = paramMiniAppInfo.appId;
    localMiniAppInfo.launchParam.scene = 1038;
    localMiniAppInfo.launchParam.navigateExtData = paramString1;
    localMiniAppInfo.launchParam.privateExtraData = paramString2;
    localMiniAppInfo.launchParam.fromBackToMiniApp = 1;
    localMiniAppInfo.launchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
    MiniSDK.startMiniApp(this.mMiniAppContext.getAttachedActivity(), localMiniAppInfo, new Bundle(), paramResultReceiver);
  }
  
  private boolean navigateBackMiniApp(String paramString1, String paramString2, String paramString3)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString2;
    localLaunchParam.privateExtraData = paramString3;
    localLaunchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
    navigateBackMiniApp(this.mMiniAppContext.getAttachedActivity(), paramString1, localLaunchParam, new NavigationJsPlugin.4(this, new Handler(Looper.getMainLooper())));
    return true;
  }
  
  @JsEvent({"exitMiniProgram"})
  public void exitMiniProgram(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NavigationJsPlugin.5(this, this.mMiniAppContext.getAttachedActivity()));
    paramRequestEvent.ok();
  }
  
  @JsEvent({"navigateBackMiniProgram"})
  public void navigateBackMiniProgram(RequestEvent paramRequestEvent)
  {
    new JSONObject();
    String str2;
    Object localObject2;
    String str1;
    do
    {
      do
      {
        try
        {
          Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
          if (navigateBackByAPPInfo == 0) {
            if (localObject1 != null)
            {
              str2 = ((JSONObject)localObject1).optString("extraData");
              localObject1 = ((JSONObject)localObject1).optString("privateExtraData");
              localObject2 = this.mMiniAppInfo.launchParam.fromMiniAppId;
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (navigateBackMiniApp((String)localObject2, str2, (String)localObject1))) {
                paramRequestEvent.ok();
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
            str1 = null;
          }
          paramRequestEvent.fail();
          return;
        }
      } while ((navigateBackByAPPInfo != 1) || (str1 == null));
      str2 = str1.optString("extraData");
      str1 = str1.optString("privateExtraData");
      localObject2 = this.mMiniAppInfo.launchParam.fromMiniAppInfo;
    } while (localObject2 == null);
    navigateBackMiniApp((MiniAppInfo)localObject2, str2, str1, new NavigationJsPlugin.3(this, new Handler(Looper.getMainLooper()), paramRequestEvent));
  }
  
  /* Error */
  @JsEvent({"navigateToMiniProgram"})
  public void navigateToMiniProgram(RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: sipush 2001
    //   3: istore_3
    //   4: new 192	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: getfield 196	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   12: invokespecial 199	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload_0
    //   18: getfield 40	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy;
    //   21: invokevirtual 242	com/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy:onBeforeNavigateToMiniProgram	()V
    //   24: aload 4
    //   26: ifnull +215 -> 241
    //   29: aload 4
    //   31: ldc 244
    //   33: invokevirtual 205	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 6
    //   38: aload 4
    //   40: ldc 246
    //   42: invokevirtual 250	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   45: invokestatic 254	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   48: astore 7
    //   50: aload_0
    //   51: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   54: getfield 108	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   57: getfield 258	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   60: astore 8
    //   62: aload 7
    //   64: ifnull +254 -> 318
    //   67: ldc 16
    //   69: ldc_w 260
    //   72: ldc_w 262
    //   75: invokestatic 265	com/tencent/qqmini/sdk/core/utils/WnsConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   78: aload_0
    //   79: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   82: getfield 111	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   85: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +172 -> 260
    //   91: sipush 2077
    //   94: istore_2
    //   95: aload 4
    //   97: ldc 201
    //   99: invokevirtual 250	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   102: astore 9
    //   104: aload 9
    //   106: ifnull +171 -> 277
    //   109: aload 9
    //   111: invokevirtual 274	org/json/JSONObject:toString	()Ljava/lang/String;
    //   114: astore 5
    //   116: new 64	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   119: dup
    //   120: invokespecial 147	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   123: astore 10
    //   125: aload 10
    //   127: iload_2
    //   128: putfield 117	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   131: aload 10
    //   133: aload_0
    //   134: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   137: getfield 108	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   140: getfield 114	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   143: putfield 130	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   146: aload 10
    //   148: aload 5
    //   150: putfield 120	com/tencent/qqmini/sdk/launcher/model/LaunchParam:navigateExtData	Ljava/lang/String;
    //   153: aload 8
    //   155: ifnull +10 -> 165
    //   158: aload 10
    //   160: aload 8
    //   162: putfield 258	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   165: aload 7
    //   167: getfield 108	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   170: aload 10
    //   172: invokevirtual 278	com/tencent/qqmini/sdk/launcher/model/LaunchParam:clone	(Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;)V
    //   175: aload_0
    //   176: getfield 46	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   179: invokeinterface 136 1 0
    //   184: aload 7
    //   186: invokestatic 281	com/tencent/qqmini/sdk/MiniSDK:startMiniApp	(Landroid/app/Activity;Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)V
    //   189: aload_1
    //   190: invokevirtual 186	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   193: pop
    //   194: ldc 8
    //   196: new 283	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 286
    //   206: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 7
    //   211: invokevirtual 291	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:toString	()Ljava/lang/String;
    //   214: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 296	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload 7
    //   225: getfield 299	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:verType	I
    //   228: iconst_3
    //   229: if_icmpne +12 -> 241
    //   232: aload_0
    //   233: getfield 40	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy;
    //   236: aload 9
    //   238: invokevirtual 303	com/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy:onAfterLaunchByAppInfo	(Lorg/json/JSONObject;)V
    //   241: return
    //   242: astore 4
    //   244: ldc 8
    //   246: ldc_w 305
    //   249: aload 4
    //   251: invokestatic 223	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   254: aconst_null
    //   255: astore 4
    //   257: goto -240 -> 17
    //   260: aload_0
    //   261: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   264: invokevirtual 309	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   267: ifeq +399 -> 666
    //   270: sipush 2001
    //   273: istore_2
    //   274: goto +389 -> 663
    //   277: ldc_w 305
    //   280: astore 5
    //   282: goto -166 -> 116
    //   285: astore 5
    //   287: ldc 8
    //   289: new 283	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   296: ldc_w 311
    //   299: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload 5
    //   304: invokevirtual 312	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   307: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: aload 5
    //   315: invokestatic 223	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   318: aload 4
    //   320: ldc_w 314
    //   323: invokevirtual 318	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   326: istore_2
    //   327: aload 4
    //   329: ldc_w 319
    //   332: invokevirtual 205	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore 5
    //   337: iload_2
    //   338: ifne +233 -> 571
    //   341: aload 4
    //   343: ldc_w 321
    //   346: invokevirtual 205	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: astore 7
    //   351: aload 4
    //   353: ldc_w 323
    //   356: invokevirtual 205	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   359: astore 8
    //   361: aload 4
    //   363: ldc 201
    //   365: invokevirtual 250	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   368: astore 4
    //   370: aload 4
    //   372: ifnull +184 -> 556
    //   375: aload 4
    //   377: invokevirtual 274	org/json/JSONObject:toString	()Ljava/lang/String;
    //   380: astore 4
    //   382: new 64	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   385: dup
    //   386: invokespecial 147	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   389: astore 9
    //   391: aload_0
    //   392: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   395: invokevirtual 309	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   398: ifeq +166 -> 564
    //   401: aload 9
    //   403: iload_3
    //   404: putfield 117	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   407: aload 9
    //   409: aload 7
    //   411: putfield 326	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryPath	Ljava/lang/String;
    //   414: aload 9
    //   416: aload 4
    //   418: putfield 120	com/tencent/qqmini/sdk/launcher/model/LaunchParam:navigateExtData	Ljava/lang/String;
    //   421: aload 9
    //   423: aload_0
    //   424: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   427: getfield 108	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   430: getfield 114	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   433: putfield 130	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   436: aload 9
    //   438: aload_0
    //   439: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   442: getfield 108	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   445: getfield 258	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   448: putfield 258	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   451: aload 9
    //   453: aload 8
    //   455: putfield 328	com/tencent/qqmini/sdk/launcher/model/LaunchParam:envVersion	Ljava/lang/String;
    //   458: aload_0
    //   459: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   462: invokevirtual 331	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isSpecialMiniApp	()Z
    //   465: ifne +34 -> 499
    //   468: getstatic 26	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigateBackByAPPInfo	I
    //   471: iconst_1
    //   472: if_icmpne +27 -> 499
    //   475: aload 9
    //   477: aload_0
    //   478: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   481: invokevirtual 334	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:getVerTypeStr	()Ljava/lang/String;
    //   484: putfield 337	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromEnvVersion	Ljava/lang/String;
    //   487: aload 9
    //   489: aload_0
    //   490: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   493: invokestatic 104	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:copy	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   496: putfield 229	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   499: aload 9
    //   501: aload 6
    //   503: putfield 339	com/tencent/qqmini/sdk/launcher/model/LaunchParam:reportData	Ljava/lang/String;
    //   506: aload_0
    //   507: getfield 46	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   510: invokeinterface 136 1 0
    //   515: aload 5
    //   517: aload 9
    //   519: getfield 117	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   522: aload 7
    //   524: aload 8
    //   526: aload 9
    //   528: new 341	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin$1
    //   531: dup
    //   532: aload_0
    //   533: new 151	android/os/Handler
    //   536: dup
    //   537: invokestatic 157	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   540: invokespecial 160	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   543: aload_1
    //   544: invokespecial 342	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin$1:<init>	(Lcom/tencent/qqmini/sdk/plugins/NavigationJsPlugin;Landroid/os/Handler;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V
    //   547: invokestatic 345	com/tencent/qqmini/sdk/MiniSDK:startMiniApp	(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;Landroid/os/ResultReceiver;)V
    //   550: aload_1
    //   551: invokevirtual 186	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   554: pop
    //   555: return
    //   556: ldc_w 305
    //   559: astore 4
    //   561: goto -179 -> 382
    //   564: sipush 1037
    //   567: istore_3
    //   568: goto -167 -> 401
    //   571: new 64	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   574: dup
    //   575: invokespecial 147	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   578: astore 6
    //   580: aload_0
    //   581: getfield 127	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   584: invokevirtual 309	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   587: ifeq +63 -> 650
    //   590: aload 6
    //   592: iload_3
    //   593: putfield 117	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   596: aload_0
    //   597: getfield 40	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy;
    //   600: iload_2
    //   601: aload_0
    //   602: getfield 46	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   605: invokeinterface 136 1 0
    //   610: aload 5
    //   612: aload 6
    //   614: getfield 117	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   617: aload 4
    //   619: new 347	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin$2
    //   622: dup
    //   623: aload_0
    //   624: new 151	android/os/Handler
    //   627: dup
    //   628: invokestatic 157	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   631: invokespecial 160	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   634: aload_1
    //   635: invokespecial 348	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin$2:<init>	(Lcom/tencent/qqmini/sdk/plugins/NavigationJsPlugin;Landroid/os/Handler;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V
    //   638: invokevirtual 352	com/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy:launchByAppType	(ILandroid/app/Activity;Ljava/lang/String;ILorg/json/JSONObject;Landroid/os/ResultReceiver;)Z
    //   641: ifeq +16 -> 657
    //   644: aload_1
    //   645: invokevirtual 186	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   648: pop
    //   649: return
    //   650: sipush 1037
    //   653: istore_3
    //   654: goto -64 -> 590
    //   657: aload_1
    //   658: invokevirtual 226	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   661: pop
    //   662: return
    //   663: goto -568 -> 95
    //   666: sipush 1037
    //   669: istore_2
    //   670: goto -7 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	673	0	this	NavigationJsPlugin
    //   0	673	1	paramRequestEvent	RequestEvent
    //   94	576	2	i	int
    //   3	651	3	j	int
    //   15	81	4	localJSONObject	JSONObject
    //   242	8	4	localThrowable	Throwable
    //   255	363	4	localObject1	Object
    //   114	167	5	str1	String
    //   285	29	5	localException	java.lang.Exception
    //   335	276	5	str2	String
    //   36	577	6	localObject2	Object
    //   48	475	7	localObject3	Object
    //   60	465	8	localObject4	Object
    //   102	425	9	localObject5	Object
    //   123	48	10	localLaunchParam	LaunchParam
    // Exception table:
    //   from	to	target	type
    //   4	17	242	java/lang/Throwable
    //   67	91	285	java/lang/Exception
    //   95	104	285	java/lang/Exception
    //   109	116	285	java/lang/Exception
    //   116	153	285	java/lang/Exception
    //   158	165	285	java/lang/Exception
    //   165	241	285	java/lang/Exception
    //   260	270	285	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */