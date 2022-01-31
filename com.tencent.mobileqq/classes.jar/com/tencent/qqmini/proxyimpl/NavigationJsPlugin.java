package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import behq;
import bekp;
import bekr;
import bekz;
import betc;
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
  
  public void exitMiniProgram(bekr parambekr)
  {
    bekz.a(new NavigationJsPlugin.1(this, this.mMiniAppContext.a()));
    parambekr.a();
  }
  
  public void navigateBackMiniProgram(bekr parambekr)
  {
    try
    {
      String str1 = new JSONObject(parambekr.b).optString("extraData");
      String str2 = this.mApkgInfo.d;
      if ((!TextUtils.isEmpty(str2)) && (navigateBackMiniApp(str2, str1)))
      {
        parambekr.a();
        return;
      }
      parambekr.b();
      return;
    }
    catch (Throwable parambekr)
    {
      betc.d("NavigationJsPlugin", "", parambekr);
    }
  }
  
  /* Error */
  public void navigateToMiniProgram(bekr parambekr)
  {
    // Byte code:
    //   0: sipush 2001
    //   3: istore_3
    //   4: new 105	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: getfield 108	bekr:b	Ljava/lang/String;
    //   12: invokespecial 111	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: invokestatic 143	com/tencent/mobileqq/mini/app/MiniAppStateManager:getInstance	()Lcom/tencent/mobileqq/mini/app/MiniAppStateManager;
    //   20: ldc 145
    //   22: invokevirtual 149	com/tencent/mobileqq/mini/app/MiniAppStateManager:notifyChange	(Ljava/lang/Object;)V
    //   25: aload 5
    //   27: ifnull +252 -> 279
    //   30: aload 5
    //   32: ldc 151
    //   34: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 8
    //   39: aload 5
    //   41: invokestatic 157	com/tencent/mobileqq/mini/apkg/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   44: astore 11
    //   46: aload_0
    //   47: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbehq;
    //   50: invokeinterface 160 1 0
    //   55: astore 9
    //   57: aload 9
    //   59: getfield 166	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   62: getfield 171	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   65: astore 10
    //   67: aload 11
    //   69: ifnull +283 -> 352
    //   72: aload_0
    //   73: getfield 24	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:wnsConfigProxy	Lcom/tencent/qqmini/sdk/core/proxy/WnsConfigProxy;
    //   76: ldc 173
    //   78: ldc 175
    //   80: invokevirtual 179	com/tencent/qqmini/sdk/core/proxy/WnsConfigProxy:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 7
    //   85: aload 7
    //   87: astore 6
    //   89: aload 7
    //   91: invokestatic 184	bely:a	(Ljava/lang/String;)Z
    //   94: ifeq +7 -> 101
    //   97: ldc 186
    //   99: astore 6
    //   101: aload_0
    //   102: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbehq;
    //   105: invokeinterface 160 1 0
    //   110: ifnull +190 -> 300
    //   113: aload 6
    //   115: aload_0
    //   116: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbehq;
    //   119: invokeinterface 160 1 0
    //   124: getfield 189	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   127: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq +170 -> 300
    //   133: sipush 2077
    //   136: istore_2
    //   137: aload 5
    //   139: ldc 113
    //   141: invokevirtual 199	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   144: astore 6
    //   146: aload 6
    //   148: ifnull +167 -> 315
    //   151: aload 6
    //   153: invokevirtual 202	org/json/JSONObject:toString	()Ljava/lang/String;
    //   156: astore 6
    //   158: new 29	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   161: dup
    //   162: invokespecial 30	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   165: astore 7
    //   167: aload 7
    //   169: iload_2
    //   170: putfield 37	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   173: aload 7
    //   175: aload 9
    //   177: getfield 166	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   180: getfield 204	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   183: putfield 52	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   186: aload 7
    //   188: aload 6
    //   190: putfield 40	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   193: aload 10
    //   195: ifnull +13 -> 208
    //   198: aload 7
    //   200: aload 10
    //   202: invokestatic 210	com/tencent/qqmini/proxyimpl/MiniSdkUtil:convertFromSdk	(Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;)Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   205: putfield 214	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   208: aload 5
    //   210: invokestatic 157	com/tencent/mobileqq/mini/apkg/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   213: astore 6
    //   215: aload_0
    //   216: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbehq;
    //   219: invokeinterface 62 1 0
    //   224: aload 6
    //   226: aload 7
    //   228: invokestatic 218	com/tencent/mobileqq/mini/sdk/MiniAppController:launchMiniAppByAppInfo	(Landroid/app/Activity;Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;)V
    //   231: aload_1
    //   232: invokevirtual 100	bekr:a	()Ljava/lang/String;
    //   235: pop
    //   236: ldc 8
    //   238: new 220	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   245: ldc 223
    //   247: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 11
    //   252: invokevirtual 228	com/tencent/mobileqq/mini/apkg/MiniAppInfo:toString	()Ljava/lang/String;
    //   255: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 232	betc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload 11
    //   266: getfield 235	com/tencent/mobileqq/mini/apkg/MiniAppInfo:verType	I
    //   269: iconst_3
    //   270: if_icmpne +9 -> 279
    //   273: aload_0
    //   274: aload 6
    //   276: invokespecial 237	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:savaShowInfoToDB	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   279: return
    //   280: astore 5
    //   282: ldc 8
    //   284: aload 5
    //   286: invokevirtual 240	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   289: aload 5
    //   291: invokestatic 134	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   294: aconst_null
    //   295: astore 5
    //   297: goto -280 -> 17
    //   300: aload 9
    //   302: invokevirtual 244	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   305: ifeq +409 -> 714
    //   308: sipush 2001
    //   311: istore_2
    //   312: goto +399 -> 711
    //   315: ldc 129
    //   317: astore 6
    //   319: goto -161 -> 158
    //   322: astore 6
    //   324: ldc 8
    //   326: new 220	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   333: ldc 246
    //   335: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 6
    //   340: invokestatic 252	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   343: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 254	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload 5
    //   354: ldc_w 256
    //   357: invokevirtual 260	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   360: istore_2
    //   361: aload 5
    //   363: ldc_w 261
    //   366: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   369: astore 6
    //   371: iload_2
    //   372: ifne +303 -> 675
    //   375: aload 5
    //   377: ldc_w 263
    //   380: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   383: astore 7
    //   385: aload 5
    //   387: ldc_w 265
    //   390: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   393: astore 11
    //   395: aload 5
    //   397: ldc 113
    //   399: invokevirtual 199	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   402: astore 5
    //   404: aload 5
    //   406: ifnull +208 -> 614
    //   409: aload 5
    //   411: invokevirtual 202	org/json/JSONObject:toString	()Ljava/lang/String;
    //   414: astore 5
    //   416: new 29	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   419: dup
    //   420: invokespecial 30	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   423: astore 12
    //   425: aload 9
    //   427: invokevirtual 244	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   430: ifeq +191 -> 621
    //   433: iload_3
    //   434: istore_2
    //   435: aload 12
    //   437: iload_2
    //   438: putfield 37	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   441: aload 12
    //   443: aload 7
    //   445: putfield 268	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   448: aload 12
    //   450: aload 5
    //   452: putfield 40	com/tencent/mobileqq/mini/sdk/LaunchParam:navigateExtData	Ljava/lang/String;
    //   455: aload 12
    //   457: aload 9
    //   459: getfield 166	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   462: getfield 204	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   465: putfield 52	com/tencent/mobileqq/mini/sdk/LaunchParam:fromMiniAppId	Ljava/lang/String;
    //   468: aload 12
    //   470: aload 10
    //   472: invokestatic 271	com/tencent/qqmini/proxyimpl/MiniSdkUtil:convert	(Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;)Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   475: putfield 214	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   478: aload 12
    //   480: aload 11
    //   482: putfield 273	com/tencent/mobileqq/mini/sdk/LaunchParam:envVersion	Ljava/lang/String;
    //   485: aload 8
    //   487: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   490: ifne +150 -> 640
    //   493: aload 12
    //   495: new 275	java/util/HashMap
    //   498: dup
    //   499: invokespecial 276	java/util/HashMap:<init>	()V
    //   502: putfield 279	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/util/Map;
    //   505: aload 8
    //   507: ldc_w 281
    //   510: invokevirtual 285	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   513: astore 5
    //   515: aload 5
    //   517: arraylength
    //   518: istore_3
    //   519: iconst_0
    //   520: istore_2
    //   521: iload_2
    //   522: iload_3
    //   523: if_icmpge +117 -> 640
    //   526: aload 5
    //   528: iload_2
    //   529: aaload
    //   530: astore 9
    //   532: aload 9
    //   534: ldc_w 287
    //   537: invokevirtual 290	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   540: istore 4
    //   542: iload 4
    //   544: ifle +63 -> 607
    //   547: iload 4
    //   549: aload 9
    //   551: invokevirtual 294	java/lang/String:length	()I
    //   554: iconst_1
    //   555: isub
    //   556: if_icmpge +51 -> 607
    //   559: aload 9
    //   561: iconst_0
    //   562: iload 4
    //   564: invokevirtual 298	java/lang/String:substring	(II)Ljava/lang/String;
    //   567: ldc_w 300
    //   570: invokestatic 305	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   573: astore 8
    //   575: aload 9
    //   577: iload 4
    //   579: iconst_1
    //   580: iadd
    //   581: invokevirtual 308	java/lang/String:substring	(I)Ljava/lang/String;
    //   584: ldc_w 300
    //   587: invokestatic 305	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   590: astore 9
    //   592: aload 12
    //   594: getfield 279	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/util/Map;
    //   597: aload 8
    //   599: aload 9
    //   601: invokeinterface 314 3 0
    //   606: pop
    //   607: iload_2
    //   608: iconst_1
    //   609: iadd
    //   610: istore_2
    //   611: goto -90 -> 521
    //   614: ldc 129
    //   616: astore 5
    //   618: goto -202 -> 416
    //   621: sipush 1037
    //   624: istore_2
    //   625: goto -190 -> 435
    //   628: astore 5
    //   630: ldc 8
    //   632: ldc_w 316
    //   635: aload 5
    //   637: invokestatic 134	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   640: aload_0
    //   641: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbehq;
    //   644: invokeinterface 62 1 0
    //   649: aload 6
    //   651: aload 7
    //   653: aload 11
    //   655: aload 12
    //   657: new 318	com/tencent/qqmini/proxyimpl/NavigationJsPlugin$2
    //   660: dup
    //   661: aload_0
    //   662: aload_1
    //   663: invokespecial 321	com/tencent/qqmini/proxyimpl/NavigationJsPlugin$2:<init>	(Lcom/tencent/qqmini/proxyimpl/NavigationJsPlugin;Lbekr;)V
    //   666: invokestatic 325	com/tencent/mobileqq/mini/sdk/MiniAppController:startAppByAppid	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)V
    //   669: aload_1
    //   670: invokevirtual 100	bekr:a	()Ljava/lang/String;
    //   673: pop
    //   674: return
    //   675: iload_2
    //   676: iconst_1
    //   677: if_icmpne -398 -> 279
    //   680: aload_0
    //   681: getfield 56	com/tencent/qqmini/proxyimpl/NavigationJsPlugin:mMiniAppContext	Lbehq;
    //   684: invokeinterface 62 1 0
    //   689: aload 6
    //   691: aload 5
    //   693: invokestatic 331	com/tencent/mobileqq/microapp/ext/GameProxy:startGameByMiniApp	(Landroid/app/Activity;Ljava/lang/String;Lorg/json/JSONObject;)Z
    //   696: ifeq +9 -> 705
    //   699: aload_1
    //   700: invokevirtual 100	bekr:a	()Ljava/lang/String;
    //   703: pop
    //   704: return
    //   705: aload_1
    //   706: invokevirtual 127	bekr:b	()Ljava/lang/String;
    //   709: pop
    //   710: return
    //   711: goto -574 -> 137
    //   714: sipush 1037
    //   717: istore_2
    //   718: goto -7 -> 711
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	NavigationJsPlugin
    //   0	721	1	parambekr	bekr
    //   136	582	2	i	int
    //   3	521	3	j	int
    //   540	41	4	k	int
    //   15	194	5	localJSONObject	JSONObject
    //   280	10	5	localThrowable	Throwable
    //   295	322	5	localObject1	java.lang.Object
    //   628	64	5	localException1	java.lang.Exception
    //   87	231	6	localObject2	java.lang.Object
    //   322	17	6	localException2	java.lang.Exception
    //   369	321	6	str1	String
    //   83	569	7	localObject3	java.lang.Object
    //   37	561	8	str2	String
    //   55	545	9	localObject4	java.lang.Object
    //   65	406	10	localEntryModel	com.tencent.qqmini.sdk.launcher.model.EntryModel
    //   44	610	11	localObject5	java.lang.Object
    //   423	233	12	localLaunchParam	LaunchParam
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
    //   493	519	628	java/lang/Exception
    //   532	542	628	java/lang/Exception
    //   547	607	628	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */