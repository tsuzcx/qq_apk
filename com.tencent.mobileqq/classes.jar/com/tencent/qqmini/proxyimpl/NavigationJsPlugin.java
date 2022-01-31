package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import bdcz;
import bdfx;
import bdfz;
import bdgi;
import bdnw;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.WnsConfigProxy;
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
    localLaunchParam.fromMiniAppId = this.mApkgInfo.d;
    paramString2 = this.mMiniAppContext.a();
    MiniAppController.navigateBackMiniApp(paramString2, paramString1, localLaunchParam, new NavigationJsPlugin.4(this, paramString2));
    return true;
  }
  
  private void savaShowInfoToDB(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new NavigationJsPlugin.3(this, paramMiniAppInfo), 32, null, true);
  }
  
  public void exitMiniProgram(bdfz parambdfz)
  {
    bdgi.a(new NavigationJsPlugin.1(this, this.mMiniAppContext.a()));
    parambdfz.a();
  }
  
  public void navigateBackMiniProgram(bdfz parambdfz)
  {
    try
    {
      String str1 = new JSONObject(parambdfz.b).optString("extraData");
      String str2 = this.mApkgInfo.d;
      if ((!TextUtils.isEmpty(str2)) && (navigateBackMiniApp(str2, str1)))
      {
        parambdfz.a();
        return;
      }
      parambdfz.b();
      return;
    }
    catch (Throwable parambdfz)
    {
      bdnw.d("NavigationJsPlugin", "", parambdfz);
    }
  }
  
  /* Error */
  public void navigateToMiniProgram(bdfz parambdfz)
  {
    // Byte code:
    //   0: sipush 2001
    //   3: istore_3
    //   4: new 105	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: getfield 108	bdfz:b	Ljava/lang/String;
    //   12: invokespecial 111	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: invokestatic 143	com/tencent/mobileqq/mini/app/MiniAppStateManager:getInstance	()Lcom/tencent/mobileqq/mini/app/MiniAppStateManager;
    //   20: ldc 145
    //   22: invokevirtual 149	com/tencent/mobileqq/mini/app/MiniAppStateManager:notifyChange	(Ljava/lang/Object;)V
    //   25: aload 5
    //   27: ifnull +257 -> 284
    //   30: aload 5
    //   32: ldc 151
    //   34: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 8
    //   39: aload 5
    //   41: ldc 153
    //   43: invokevirtual 157	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   46: invokestatic 163	com/tencent/mobileqq/mini/apkg/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   49: astore 11
    //   51: aload_0
    //   52: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbdcz;
    //   55: invokeinterface 166 1 0
    //   60: astore 9
    //   62: aload 9
    //   64: getfield 172	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   67: getfield 177	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   70: astore 10
    //   72: aload 11
    //   74: ifnull +283 -> 357
    //   77: aload_0
    //   78: getfield 24	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:wnsConfigProxy	Lcom/tencent/qqmini/sdk/core/proxy/WnsConfigProxy;
    //   81: ldc 179
    //   83: ldc 181
    //   85: invokevirtual 185	com/tencent/qqmini/sdk/core/proxy/WnsConfigProxy:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: astore 7
    //   90: aload 7
    //   92: astore 6
    //   94: aload 7
    //   96: invokestatic 190	bdhe:a	(Ljava/lang/String;)Z
    //   99: ifeq +7 -> 106
    //   102: ldc 192
    //   104: astore 6
    //   106: aload_0
    //   107: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbdcz;
    //   110: invokeinterface 166 1 0
    //   115: ifnull +190 -> 305
    //   118: aload 6
    //   120: aload_0
    //   121: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbdcz;
    //   124: invokeinterface 166 1 0
    //   129: getfield 195	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   132: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifeq +170 -> 305
    //   138: sipush 2077
    //   141: istore_2
    //   142: aload 5
    //   144: ldc 113
    //   146: invokevirtual 157	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   149: astore 6
    //   151: aload 6
    //   153: ifnull +167 -> 320
    //   156: aload 6
    //   158: invokevirtual 204	org/json/JSONObject:toString	()Ljava/lang/String;
    //   161: astore 6
    //   163: new 29	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   166: dup
    //   167: invokespecial 30	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   170: astore 7
    //   172: aload 7
    //   174: iload_2
    //   175: putfield 37	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   178: aload 7
    //   180: aload 9
    //   182: getfield 172	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   185: getfield 206	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: putfield 52	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   191: aload 7
    //   193: aload 6
    //   195: putfield 40	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   198: aload 10
    //   200: ifnull +13 -> 213
    //   203: aload 7
    //   205: aload 10
    //   207: invokestatic 212	com/tencent/qqmini/proxyimpl/MiniSdkUtil:convertFromSdk	(Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;)Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   210: putfield 216	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   213: aload 5
    //   215: invokestatic 163	com/tencent/mobileqq/mini/apkg/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   218: astore 6
    //   220: aload_0
    //   221: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbdcz;
    //   224: invokeinterface 62 1 0
    //   229: aload 6
    //   231: aload 7
    //   233: invokestatic 220	com/tencent/mobileqq/mini/sdk/MiniAppController:launchMiniAppByAppInfo	(Landroid/app/Activity;Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;)V
    //   236: aload_1
    //   237: invokevirtual 100	bdfz:a	()Ljava/lang/String;
    //   240: pop
    //   241: ldc 8
    //   243: new 222	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   250: ldc 225
    //   252: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 11
    //   257: invokevirtual 230	com/tencent/mobileqq/mini/apkg/MiniAppInfo:toString	()Ljava/lang/String;
    //   260: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 234	bdnw:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload 11
    //   271: getfield 237	com/tencent/mobileqq/mini/apkg/MiniAppInfo:verType	I
    //   274: iconst_3
    //   275: if_icmpne +9 -> 284
    //   278: aload_0
    //   279: aload 6
    //   281: invokespecial 239	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:savaShowInfoToDB	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   284: return
    //   285: astore 5
    //   287: ldc 8
    //   289: aload 5
    //   291: invokevirtual 242	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   294: aload 5
    //   296: invokestatic 134	bdnw:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   299: aconst_null
    //   300: astore 5
    //   302: goto -285 -> 17
    //   305: aload 9
    //   307: invokevirtual 246	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   310: ifeq +409 -> 719
    //   313: sipush 2001
    //   316: istore_2
    //   317: goto +399 -> 716
    //   320: ldc 129
    //   322: astore 6
    //   324: goto -161 -> 163
    //   327: astore 6
    //   329: ldc 8
    //   331: new 222	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   338: ldc 248
    //   340: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 6
    //   345: invokestatic 254	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   348: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 256	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 5
    //   359: ldc_w 258
    //   362: invokevirtual 262	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   365: istore_2
    //   366: aload 5
    //   368: ldc_w 263
    //   371: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: astore 6
    //   376: iload_2
    //   377: ifne +303 -> 680
    //   380: aload 5
    //   382: ldc_w 265
    //   385: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   388: astore 7
    //   390: aload 5
    //   392: ldc_w 267
    //   395: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 11
    //   400: aload 5
    //   402: ldc 113
    //   404: invokevirtual 157	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   407: astore 5
    //   409: aload 5
    //   411: ifnull +208 -> 619
    //   414: aload 5
    //   416: invokevirtual 204	org/json/JSONObject:toString	()Ljava/lang/String;
    //   419: astore 5
    //   421: new 29	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   424: dup
    //   425: invokespecial 30	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   428: astore 12
    //   430: aload 9
    //   432: invokevirtual 246	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   435: ifeq +191 -> 626
    //   438: iload_3
    //   439: istore_2
    //   440: aload 12
    //   442: iload_2
    //   443: putfield 37	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   446: aload 12
    //   448: aload 7
    //   450: putfield 270	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   453: aload 12
    //   455: aload 5
    //   457: putfield 40	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   460: aload 12
    //   462: aload 9
    //   464: getfield 172	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   467: getfield 206	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   470: putfield 52	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   473: aload 12
    //   475: aload 10
    //   477: invokestatic 273	com/tencent/qqmini/proxyimpl/MiniSdkUtil:convert	(Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;)Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   480: putfield 216	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   483: aload 12
    //   485: aload 11
    //   487: putfield 275	com/tencent/mobileqq/mini/sdk/LaunchParam:envVersion	Ljava/lang/String;
    //   490: aload 8
    //   492: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   495: ifne +150 -> 645
    //   498: aload 12
    //   500: new 277	java/util/HashMap
    //   503: dup
    //   504: invokespecial 278	java/util/HashMap:<init>	()V
    //   507: putfield 281	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/util/Map;
    //   510: aload 8
    //   512: ldc_w 283
    //   515: invokevirtual 287	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   518: astore 5
    //   520: aload 5
    //   522: arraylength
    //   523: istore_3
    //   524: iconst_0
    //   525: istore_2
    //   526: iload_2
    //   527: iload_3
    //   528: if_icmpge +117 -> 645
    //   531: aload 5
    //   533: iload_2
    //   534: aaload
    //   535: astore 9
    //   537: aload 9
    //   539: ldc_w 289
    //   542: invokevirtual 292	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   545: istore 4
    //   547: iload 4
    //   549: ifle +63 -> 612
    //   552: iload 4
    //   554: aload 9
    //   556: invokevirtual 296	java/lang/String:length	()I
    //   559: iconst_1
    //   560: isub
    //   561: if_icmpge +51 -> 612
    //   564: aload 9
    //   566: iconst_0
    //   567: iload 4
    //   569: invokevirtual 300	java/lang/String:substring	(II)Ljava/lang/String;
    //   572: ldc_w 302
    //   575: invokestatic 307	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   578: astore 8
    //   580: aload 9
    //   582: iload 4
    //   584: iconst_1
    //   585: iadd
    //   586: invokevirtual 310	java/lang/String:substring	(I)Ljava/lang/String;
    //   589: ldc_w 302
    //   592: invokestatic 307	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   595: astore 9
    //   597: aload 12
    //   599: getfield 281	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/util/Map;
    //   602: aload 8
    //   604: aload 9
    //   606: invokeinterface 316 3 0
    //   611: pop
    //   612: iload_2
    //   613: iconst_1
    //   614: iadd
    //   615: istore_2
    //   616: goto -90 -> 526
    //   619: ldc 129
    //   621: astore 5
    //   623: goto -202 -> 421
    //   626: sipush 1037
    //   629: istore_2
    //   630: goto -190 -> 440
    //   633: astore 5
    //   635: ldc 8
    //   637: ldc_w 318
    //   640: aload 5
    //   642: invokestatic 134	bdnw:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   645: aload_0
    //   646: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbdcz;
    //   649: invokeinterface 62 1 0
    //   654: aload 6
    //   656: aload 7
    //   658: aload 11
    //   660: aload 12
    //   662: new 320	com/tencent/qqmini/proxyimpl/NavigationJsPlugin$2
    //   665: dup
    //   666: aload_0
    //   667: aload_1
    //   668: invokespecial 323	com/tencent/qqmini/proxyimpl/NavigationJsPlugin$2:<init>	(Lcom/tencent/qqmini/proxyimpl/NavigationJsPlugin;Lbdfz;)V
    //   671: invokestatic 327	com/tencent/mobileqq/mini/sdk/MiniAppController:startAppByAppid	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)V
    //   674: aload_1
    //   675: invokevirtual 100	bdfz:a	()Ljava/lang/String;
    //   678: pop
    //   679: return
    //   680: iload_2
    //   681: iconst_1
    //   682: if_icmpne -398 -> 284
    //   685: aload_0
    //   686: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbdcz;
    //   689: invokeinterface 62 1 0
    //   694: aload 6
    //   696: aload 5
    //   698: invokestatic 333	com/tencent/mobileqq/microapp/ext/GameProxy:startGameByMiniApp	(Landroid/app/Activity;Ljava/lang/String;Lorg/json/JSONObject;)Z
    //   701: ifeq +9 -> 710
    //   704: aload_1
    //   705: invokevirtual 100	bdfz:a	()Ljava/lang/String;
    //   708: pop
    //   709: return
    //   710: aload_1
    //   711: invokevirtual 127	bdfz:b	()Ljava/lang/String;
    //   714: pop
    //   715: return
    //   716: goto -574 -> 142
    //   719: sipush 1037
    //   722: istore_2
    //   723: goto -7 -> 716
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	this	NavigationJsPlugin
    //   0	726	1	parambdfz	bdfz
    //   141	582	2	i	int
    //   3	526	3	j	int
    //   545	41	4	k	int
    //   15	199	5	localJSONObject	JSONObject
    //   285	10	5	localThrowable	Throwable
    //   300	322	5	localObject1	java.lang.Object
    //   633	64	5	localException1	java.lang.Exception
    //   92	231	6	localObject2	java.lang.Object
    //   327	17	6	localException2	java.lang.Exception
    //   374	321	6	str1	String
    //   88	569	7	localObject3	java.lang.Object
    //   37	566	8	str2	String
    //   60	545	9	localObject4	java.lang.Object
    //   70	406	10	localEntryModel	com.tencent.qqmini.sdk.launcher.model.EntryModel
    //   49	610	11	localObject5	java.lang.Object
    //   428	233	12	localLaunchParam	LaunchParam
    // Exception table:
    //   from	to	target	type
    //   4	17	285	java/lang/Throwable
    //   77	90	327	java/lang/Exception
    //   94	102	327	java/lang/Exception
    //   106	138	327	java/lang/Exception
    //   142	151	327	java/lang/Exception
    //   156	163	327	java/lang/Exception
    //   163	198	327	java/lang/Exception
    //   203	213	327	java/lang/Exception
    //   213	284	327	java/lang/Exception
    //   305	313	327	java/lang/Exception
    //   498	524	633	java/lang/Exception
    //   537	547	633	java/lang/Exception
    //   552	612	633	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */