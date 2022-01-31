package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import bgho;
import bgjw;
import bgkd;
import bgkk;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class NavigationJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NavigationJsPlugin";
  private WnsConfigProxy wnsConfigProxy = (WnsConfigProxy)ProxyManager.get(WnsConfigProxy.class);
  
  private boolean navigateBackMiniApp(String paramString1, String paramString2)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = 1038;
    localLaunchParam.navigateExtData = paramString2;
    localLaunchParam.fromMiniAppId = this.mApkgInfo.appId;
    paramString2 = this.mMiniAppContext.a();
    MiniAppController.navigateBackMiniApp(paramString2, paramString1, localLaunchParam, new NavigationJsPlugin.4(this, paramString2));
    return true;
  }
  
  private void savaShowInfoToDB(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new NavigationJsPlugin.3(this, paramMiniAppInfo), 32, null, true);
  }
  
  public void exitMiniProgram(bgkd parambgkd)
  {
    bgkk.a(new NavigationJsPlugin.1(this, this.mMiniAppContext.a()));
    parambgkd.a();
  }
  
  public void navigateBackMiniProgram(bgkd parambgkd)
  {
    try
    {
      String str1 = new JSONObject(parambgkd.b).optString("extraData");
      String str2 = this.mApkgInfo.appId;
      if ((!TextUtils.isEmpty(str2)) && (navigateBackMiniApp(str2, str1)))
      {
        parambgkd.a();
        return;
      }
      parambgkd.b();
      return;
    }
    catch (Throwable parambgkd)
    {
      QMLog.e("NavigationJsPlugin", "", parambgkd);
    }
  }
  
  /* Error */
  public void navigateToMiniProgram(bgkd parambgkd)
  {
    // Byte code:
    //   0: sipush 2001
    //   3: istore_3
    //   4: new 105	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: getfield 108	bgkd:b	Ljava/lang/String;
    //   12: invokespecial 111	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: invokestatic 144	com/tencent/mobileqq/mini/app/MiniAppStateManager:getInstance	()Lcom/tencent/mobileqq/mini/app/MiniAppStateManager;
    //   20: ldc 146
    //   22: invokevirtual 150	com/tencent/mobileqq/mini/app/MiniAppStateManager:notifyChange	(Ljava/lang/Object;)V
    //   25: aload 4
    //   27: ifnull +252 -> 279
    //   30: aload 4
    //   32: ldc 152
    //   34: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 7
    //   39: aload 4
    //   41: invokestatic 158	com/tencent/mobileqq/mini/apkg/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   44: astore 10
    //   46: aload_0
    //   47: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbgho;
    //   50: invokeinterface 161 1 0
    //   55: astore 8
    //   57: aload 8
    //   59: getfield 167	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   62: getfield 173	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   65: astore 9
    //   67: aload 10
    //   69: ifnull +283 -> 352
    //   72: aload_0
    //   73: getfield 24	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:wnsConfigProxy	Lcom/tencent/qqmini/sdk/core/proxy/WnsConfigProxy;
    //   76: ldc 175
    //   78: ldc 177
    //   80: invokevirtual 181	com/tencent/qqmini/sdk/core/proxy/WnsConfigProxy:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 6
    //   85: aload 6
    //   87: astore 5
    //   89: aload 6
    //   91: invokestatic 186	bglo:a	(Ljava/lang/String;)Z
    //   94: ifeq +7 -> 101
    //   97: ldc 188
    //   99: astore 5
    //   101: aload_0
    //   102: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbgho;
    //   105: invokeinterface 161 1 0
    //   110: ifnull +190 -> 300
    //   113: aload 5
    //   115: aload_0
    //   116: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbgho;
    //   119: invokeinterface 161 1 0
    //   124: getfield 189	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   127: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq +170 -> 300
    //   133: sipush 2077
    //   136: istore_2
    //   137: aload 4
    //   139: ldc 113
    //   141: invokevirtual 199	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   144: astore 5
    //   146: aload 5
    //   148: ifnull +167 -> 315
    //   151: aload 5
    //   153: invokevirtual 202	org/json/JSONObject:toString	()Ljava/lang/String;
    //   156: astore 5
    //   158: new 29	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   161: dup
    //   162: invokespecial 30	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   165: astore 6
    //   167: aload 6
    //   169: iload_2
    //   170: putfield 37	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   173: aload 6
    //   175: aload 8
    //   177: getfield 167	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   180: getfield 203	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   183: putfield 52	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   186: aload 6
    //   188: aload 5
    //   190: putfield 40	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   193: aload 9
    //   195: ifnull +13 -> 208
    //   198: aload 6
    //   200: aload 9
    //   202: invokestatic 209	com/tencent/qqmini/proxyimpl/MiniSdkUtil:convertFromSdk	(Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;)Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   205: putfield 212	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   208: aload 4
    //   210: invokestatic 158	com/tencent/mobileqq/mini/apkg/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   213: astore 5
    //   215: aload_0
    //   216: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbgho;
    //   219: invokeinterface 62 1 0
    //   224: aload 5
    //   226: aload 6
    //   228: invokestatic 216	com/tencent/mobileqq/mini/sdk/MiniAppController:launchMiniAppByAppInfo	(Landroid/app/Activity;Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;)V
    //   231: aload_1
    //   232: invokevirtual 100	bgkd:a	()Ljava/lang/String;
    //   235: pop
    //   236: ldc 8
    //   238: new 218	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   245: ldc 221
    //   247: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 10
    //   252: invokevirtual 226	com/tencent/mobileqq/mini/apkg/MiniAppInfo:toString	()Ljava/lang/String;
    //   255: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 231	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload 10
    //   266: getfield 234	com/tencent/mobileqq/mini/apkg/MiniAppInfo:verType	I
    //   269: iconst_3
    //   270: if_icmpne +9 -> 279
    //   273: aload_0
    //   274: aload 5
    //   276: invokespecial 236	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:savaShowInfoToDB	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   279: return
    //   280: astore 4
    //   282: ldc 8
    //   284: aload 4
    //   286: invokevirtual 239	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   289: aload 4
    //   291: invokestatic 135	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   294: aconst_null
    //   295: astore 4
    //   297: goto -280 -> 17
    //   300: aload 8
    //   302: invokevirtual 243	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   305: ifeq +274 -> 579
    //   308: sipush 2001
    //   311: istore_2
    //   312: goto +264 -> 576
    //   315: ldc 129
    //   317: astore 5
    //   319: goto -161 -> 158
    //   322: astore 5
    //   324: ldc 8
    //   326: new 218	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   333: ldc 245
    //   335: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 5
    //   340: invokestatic 251	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   343: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 253	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload 4
    //   354: ldc 255
    //   356: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   359: istore_2
    //   360: aload 4
    //   362: ldc_w 260
    //   365: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   368: astore 5
    //   370: iload_2
    //   371: ifne +169 -> 540
    //   374: aload 4
    //   376: ldc_w 262
    //   379: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   382: astore 6
    //   384: aload 4
    //   386: ldc_w 264
    //   389: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   392: astore 10
    //   394: aload 4
    //   396: ldc 113
    //   398: invokevirtual 199	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   401: astore 4
    //   403: aload 4
    //   405: ifnull +121 -> 526
    //   408: aload 4
    //   410: invokevirtual 202	org/json/JSONObject:toString	()Ljava/lang/String;
    //   413: astore 4
    //   415: new 29	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   418: dup
    //   419: invokespecial 30	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   422: astore 11
    //   424: aload 8
    //   426: invokevirtual 243	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   429: ifeq +104 -> 533
    //   432: iload_3
    //   433: istore_2
    //   434: aload 11
    //   436: iload_2
    //   437: putfield 37	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   440: aload 11
    //   442: aload 6
    //   444: putfield 267	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   447: aload 11
    //   449: aload 4
    //   451: putfield 40	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   454: aload 11
    //   456: aload 8
    //   458: getfield 167	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   461: getfield 203	com/tencent/qqmini/sdk/launcher/model/LaunchParam:miniAppId	Ljava/lang/String;
    //   464: putfield 52	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   467: aload 11
    //   469: aload 9
    //   471: invokestatic 270	com/tencent/qqmini/proxyimpl/MiniSdkUtil:convert	(Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;)Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   474: putfield 212	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   477: aload 11
    //   479: aload 10
    //   481: putfield 272	com/tencent/mobileqq/mini/sdk/LaunchParam:envVersion	Ljava/lang/String;
    //   484: aload 11
    //   486: aload 7
    //   488: putfield 274	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/lang/String;
    //   491: aload_0
    //   492: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbgho;
    //   495: invokeinterface 62 1 0
    //   500: aload 5
    //   502: aload 6
    //   504: aload 10
    //   506: aload 11
    //   508: new 276	com/tencent/qqmini/proxyimpl/NavigationJsPlugin$2
    //   511: dup
    //   512: aload_0
    //   513: aload_1
    //   514: invokespecial 279	com/tencent/qqmini/proxyimpl/NavigationJsPlugin$2:<init>	(Lcom/tencent/qqmini/proxyimpl/NavigationJsPlugin;Lbgkd;)V
    //   517: invokestatic 283	com/tencent/mobileqq/mini/sdk/MiniAppController:startAppByAppid	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)V
    //   520: aload_1
    //   521: invokevirtual 100	bgkd:a	()Ljava/lang/String;
    //   524: pop
    //   525: return
    //   526: ldc 129
    //   528: astore 4
    //   530: goto -115 -> 415
    //   533: sipush 1037
    //   536: istore_2
    //   537: goto -103 -> 434
    //   540: iload_2
    //   541: iconst_1
    //   542: if_icmpne -263 -> 279
    //   545: aload_0
    //   546: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbgho;
    //   549: invokeinterface 62 1 0
    //   554: aload 5
    //   556: aload 4
    //   558: invokestatic 289	com/tencent/mobileqq/microapp/ext/GameProxy:startGameByMiniApp	(Landroid/app/Activity;Ljava/lang/String;Lorg/json/JSONObject;)Z
    //   561: ifeq +9 -> 570
    //   564: aload_1
    //   565: invokevirtual 100	bgkd:a	()Ljava/lang/String;
    //   568: pop
    //   569: return
    //   570: aload_1
    //   571: invokevirtual 127	bgkd:b	()Ljava/lang/String;
    //   574: pop
    //   575: return
    //   576: goto -439 -> 137
    //   579: sipush 1037
    //   582: istore_2
    //   583: goto -7 -> 576
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	this	NavigationJsPlugin
    //   0	586	1	parambgkd	bgkd
    //   136	447	2	i	int
    //   3	430	3	j	int
    //   15	194	4	localJSONObject	JSONObject
    //   280	10	4	localThrowable	Throwable
    //   295	262	4	localObject1	java.lang.Object
    //   87	231	5	localObject2	java.lang.Object
    //   322	17	5	localException	java.lang.Exception
    //   368	187	5	str1	String
    //   83	420	6	localObject3	java.lang.Object
    //   37	450	7	str2	String
    //   55	402	8	localMiniAppInfo	com.tencent.qqmini.sdk.launcher.model.MiniAppInfo
    //   65	405	9	localEntryModel	com.tencent.qqmini.sdk.launcher.model.EntryModel
    //   44	461	10	localObject4	java.lang.Object
    //   422	85	11	localLaunchParam	LaunchParam
    // Exception table:
    //   from	to	target	type
    //   4	17	280	java/lang/Throwable
    //   72	85	322	java/lang/Exception
    //   89	97	322	java/lang/Exception
    //   101	133	322	java/lang/Exception
    //   137	146	322	java/lang/Exception
    //   151	158	322	java/lang/Exception
    //   158	193	322	java/lang/Exception
    //   198	208	322	java/lang/Exception
    //   208	279	322	java/lang/Exception
    //   300	308	322	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */