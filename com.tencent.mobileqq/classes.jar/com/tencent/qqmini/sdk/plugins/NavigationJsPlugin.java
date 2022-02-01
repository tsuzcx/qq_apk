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
  
  private void navigateToMiniProgramByAppid(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    int i = 2001;
    int j = paramJSONObject.optInt("openType");
    String str1 = paramJSONObject.optString("appId");
    if (j == 0)
    {
      String str2 = paramJSONObject.optString("path");
      Object localObject = paramJSONObject.optJSONObject("extraData");
      LaunchParam localLaunchParam = new LaunchParam();
      if (this.mMiniAppInfo.isAppStoreMiniApp())
      {
        localLaunchParam.scene = i;
        localLaunchParam.entryPath = str2;
        if (localObject == null) {
          break label241;
        }
      }
      label241:
      for (localObject = ((JSONObject)localObject).toString();; localObject = "")
      {
        localLaunchParam.navigateExtData = ((String)localObject);
        localLaunchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
        localLaunchParam.entryModel = this.mMiniAppInfo.launchParam.entryModel;
        paramJSONObject = paramJSONObject.optString("envVersion");
        localLaunchParam.envVersion = paramJSONObject;
        if ((!this.mMiniAppInfo.isSpecialMiniApp()) && (navigateBackByAPPInfo == 1))
        {
          localLaunchParam.fromEnvVersion = this.mMiniAppInfo.getVerTypeStr();
          localLaunchParam.fromMiniAppInfo = MiniAppInfo.copy(this.mMiniAppInfo);
        }
        localLaunchParam.reportData = paramString;
        MiniSDK.startMiniApp(this.mMiniAppContext.getAttachedActivity(), str1, localLaunchParam.scene, str2, paramJSONObject, localLaunchParam, new NavigationJsPlugin.1(this, new Handler(Looper.getMainLooper()), paramRequestEvent));
        paramRequestEvent.ok();
        return;
        i = 1037;
        break;
      }
    }
    paramString = new LaunchParam();
    if (this.mMiniAppInfo.isAppStoreMiniApp()) {}
    for (;;)
    {
      paramString.scene = i;
      if (!this.navigationProxy.launchByAppType(j, this.mMiniAppContext.getAttachedActivity(), str1, paramString.scene, paramJSONObject, new NavigationJsPlugin.2(this, new Handler(Looper.getMainLooper()), paramRequestEvent))) {
        break;
      }
      paramRequestEvent.ok();
      return;
      i = 1037;
    }
    paramRequestEvent.fail();
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
    //   0: new 177	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: getfield 276	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   8: invokespecial 279	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 40	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy;
    //   16: invokevirtual 308	com/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy:onBeforeNavigateToMiniProgram	()V
    //   19: aload_3
    //   20: ifnull +214 -> 234
    //   23: aload_3
    //   24: ldc_w 309
    //   27: invokevirtual 186	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 5
    //   32: aload_3
    //   33: ldc_w 311
    //   36: invokevirtual 194	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   39: invokestatic 315	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   42: astore 6
    //   44: aload_0
    //   45: getfield 133	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   48: getfield 114	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   51: getfield 209	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   54: astore 7
    //   56: aload 6
    //   58: ifnull +248 -> 306
    //   61: ldc 16
    //   63: ldc_w 317
    //   66: ldc_w 319
    //   69: invokestatic 322	com/tencent/qqmini/sdk/core/utils/WnsConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: aload_0
    //   73: getfield 133	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   76: getfield 117	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   79: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +167 -> 249
    //   85: sipush 2077
    //   88: istore_2
    //   89: aload_3
    //   90: ldc 190
    //   92: invokevirtual 194	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   95: astore 8
    //   97: aload 8
    //   99: ifnull +167 -> 266
    //   102: aload 8
    //   104: invokevirtual 205	org/json/JSONObject:toString	()Ljava/lang/String;
    //   107: astore 4
    //   109: new 70	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   112: dup
    //   113: invokespecial 153	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   116: astore 9
    //   118: aload 9
    //   120: iload_2
    //   121: putfield 123	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   124: aload 9
    //   126: aload_0
    //   127: getfield 133	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   130: getfield 114	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   133: getfield 120	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   136: putfield 136	com/tencent/qqmini/sdk/launcher/model/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   139: aload 9
    //   141: aload 4
    //   143: putfield 126	com/tencent/qqmini/sdk/launcher/model/LaunchParam:navigateExtData	Ljava/lang/String;
    //   146: aload 7
    //   148: ifnull +10 -> 158
    //   151: aload 9
    //   153: aload 7
    //   155: putfield 209	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   158: aload 6
    //   160: getfield 114	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   163: aload 9
    //   165: invokevirtual 332	com/tencent/qqmini/sdk/launcher/model/LaunchParam:clone	(Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;)V
    //   168: aload_0
    //   169: getfield 46	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   172: invokeinterface 142 1 0
    //   177: aload 6
    //   179: invokestatic 335	com/tencent/qqmini/sdk/MiniSDK:startMiniApp	(Landroid/app/Activity;Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)V
    //   182: aload_1
    //   183: invokevirtual 241	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   186: pop
    //   187: ldc 8
    //   189: new 337	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 340
    //   199: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 6
    //   204: invokevirtual 345	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:toString	()Ljava/lang/String;
    //   207: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 350	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload 6
    //   218: getfield 353	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:verType	I
    //   221: iconst_3
    //   222: if_icmpne +12 -> 234
    //   225: aload_0
    //   226: getfield 40	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigationProxy	Lcom/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy;
    //   229: aload 8
    //   231: invokevirtual 357	com/tencent/qqmini/sdk/launcher/core/proxy/NavigationProxy:onAfterLaunchByAppInfo	(Lorg/json/JSONObject;)V
    //   234: return
    //   235: astore_3
    //   236: ldc 8
    //   238: ldc 243
    //   240: aload_3
    //   241: invokestatic 297	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   244: aconst_null
    //   245: astore_3
    //   246: goto -234 -> 12
    //   249: aload_0
    //   250: getfield 133	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   253: invokevirtual 198	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   256: ifeq +62 -> 318
    //   259: sipush 2001
    //   262: istore_2
    //   263: goto +52 -> 315
    //   266: ldc 243
    //   268: astore 4
    //   270: goto -161 -> 109
    //   273: astore 4
    //   275: ldc 8
    //   277: new 337	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 359
    //   287: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 4
    //   292: invokevirtual 360	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   295: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: aload 4
    //   303: invokestatic 297	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   306: aload_0
    //   307: aload_1
    //   308: aload_3
    //   309: aload 5
    //   311: invokespecial 362	com/tencent/qqmini/sdk/plugins/NavigationJsPlugin:navigateToMiniProgramByAppid	(Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   314: return
    //   315: goto -226 -> 89
    //   318: sipush 1037
    //   321: istore_2
    //   322: goto -7 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	NavigationJsPlugin
    //   0	325	1	paramRequestEvent	RequestEvent
    //   88	234	2	i	int
    //   11	79	3	localJSONObject1	JSONObject
    //   235	6	3	localThrowable	Throwable
    //   245	64	3	localJSONObject2	JSONObject
    //   107	162	4	str1	String
    //   273	29	4	localException	java.lang.Exception
    //   30	280	5	str2	String
    //   42	175	6	localMiniAppInfo	MiniAppInfo
    //   54	100	7	localEntryModel	com.tencent.qqmini.sdk.launcher.model.EntryModel
    //   95	135	8	localJSONObject3	JSONObject
    //   116	48	9	localLaunchParam	LaunchParam
    // Exception table:
    //   from	to	target	type
    //   0	12	235	java/lang/Throwable
    //   61	85	273	java/lang/Exception
    //   89	97	273	java/lang/Exception
    //   102	109	273	java/lang/Exception
    //   109	146	273	java/lang/Exception
    //   151	158	273	java/lang/Exception
    //   158	234	273	java/lang/Exception
    //   249	259	273	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */