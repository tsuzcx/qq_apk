package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.BannerAdPosInfo;

class BannerAdPlugin$2
  implements MiniAppCmdInterface
{
  BannerAdPlugin$2(BannerAdPlugin paramBannerAdPlugin, JsRuntime paramJsRuntime, BannerAdPosInfo paramBannerAdPosInfo) {}
  
  /* Error */
  public void onCmdListener(boolean paramBoolean, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_2
    //   3: ifnonnull +33 -> 36
    //   6: aload_0
    //   7: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   10: aload_0
    //   11: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   14: sipush 1000
    //   17: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   20: sipush 1000
    //   23: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 52	java/lang/String
    //   32: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   35: return
    //   36: iload_1
    //   37: ifeq +647 -> 684
    //   40: ldc 58
    //   42: iconst_1
    //   43: ldc 60
    //   45: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_2
    //   49: ldc 68
    //   51: invokevirtual 74	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   54: istore 4
    //   56: aload_2
    //   57: ldc 76
    //   59: invokevirtual 80	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   62: checkcast 82	NS_MINI_AD/MiniAppAd$StGetAdRsp
    //   65: astore_2
    //   66: aload_2
    //   67: getfield 86	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdsJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   70: invokevirtual 91	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   73: astore 5
    //   75: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +39 -> 117
    //   81: ldc 58
    //   83: iconst_2
    //   84: new 97	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   91: ldc 100
    //   93: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload 4
    //   98: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc 109
    //   103: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 5
    //   108: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: iload 4
    //   119: sipush 1000
    //   122: if_icmpne +11 -> 133
    //   125: aload 5
    //   127: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: ifeq +64 -> 194
    //   133: aload_0
    //   134: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   137: aload_0
    //   138: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   141: sipush 1000
    //   144: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   147: sipush 1000
    //   150: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 52	java/lang/String
    //   159: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   162: return
    //   163: astore_2
    //   164: aload_0
    //   165: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   168: aload_0
    //   169: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   172: sipush 1003
    //   175: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   178: sipush 1003
    //   181: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 52	java/lang/String
    //   190: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   193: return
    //   194: aload_0
    //   195: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   198: aload_0
    //   199: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   202: aload 5
    //   204: invokestatic 122	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$200	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;)Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;
    //   207: astore 6
    //   209: aload 6
    //   211: ifnull +430 -> 641
    //   214: aload_0
    //   215: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   218: getfield 126	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   221: getfield 132	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   224: instanceof 134
    //   227: ifeq +252 -> 479
    //   230: new 136	com/tencent/gdtad/aditem/GdtAd
    //   233: dup
    //   234: aload 6
    //   236: invokespecial 139	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   239: astore 7
    //   241: invokestatic 145	aail:a	()Laail;
    //   244: aload 7
    //   246: invokevirtual 148	aail:a	(Lcom/tencent/gdtad/aditem/GdtAd;)V
    //   249: aload_0
    //   250: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   253: getfield 126	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   256: getfield 132	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   259: checkcast 134	com/tencent/mobileqq/minigame/ui/GameActivity
    //   262: aload_0
    //   263: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   266: aload 6
    //   268: invokevirtual 152	com/tencent/mobileqq/minigame/ui/GameActivity:createBannerAd	(Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)Z
    //   271: istore_1
    //   272: iload_1
    //   273: ifeq +309 -> 582
    //   276: new 70	org/json/JSONObject
    //   279: dup
    //   280: invokespecial 153	org/json/JSONObject:<init>	()V
    //   283: astore 6
    //   285: aload 6
    //   287: ldc 155
    //   289: ldc 157
    //   291: invokevirtual 161	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   294: pop
    //   295: aload 6
    //   297: ldc 163
    //   299: aload_0
    //   300: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   303: getfield 169	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdUnitId	Ljava/lang/String;
    //   306: invokevirtual 161	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload 6
    //   312: ldc 171
    //   314: aload_0
    //   315: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   318: getfield 175	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdLeft	I
    //   321: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload 6
    //   327: ldc 180
    //   329: aload_0
    //   330: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   333: getfield 183	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdTop	I
    //   336: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   339: pop
    //   340: aload 6
    //   342: ldc 185
    //   344: aload_0
    //   345: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   348: getfield 188	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdWidth	I
    //   351: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   354: pop
    //   355: aload 6
    //   357: ldc 190
    //   359: aload_0
    //   360: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   363: getfield 193	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdHeight	I
    //   366: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   369: pop
    //   370: aload 6
    //   372: ldc 195
    //   374: aload_0
    //   375: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   378: getfield 198	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealWidth	I
    //   381: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   384: pop
    //   385: aload 6
    //   387: ldc 200
    //   389: aload_0
    //   390: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   393: getfield 203	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealHeight	I
    //   396: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   399: pop
    //   400: aload_0
    //   401: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   404: aload_0
    //   405: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   408: aload 6
    //   410: ldc 205
    //   412: invokestatic 209	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$300	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   415: new 70	org/json/JSONObject
    //   418: dup
    //   419: invokespecial 153	org/json/JSONObject:<init>	()V
    //   422: astore 6
    //   424: aload 6
    //   426: ldc 155
    //   428: ldc 211
    //   430: invokevirtual 161	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   433: pop
    //   434: aload 6
    //   436: ldc 185
    //   438: aload_0
    //   439: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   442: getfield 198	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealWidth	I
    //   445: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   448: pop
    //   449: aload 6
    //   451: ldc 190
    //   453: aload_0
    //   454: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   457: getfield 203	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealHeight	I
    //   460: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   463: pop
    //   464: aload_0
    //   465: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   468: aload_0
    //   469: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   472: aload 6
    //   474: ldc 205
    //   476: invokestatic 209	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$300	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   479: aload_0
    //   480: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   483: aload 5
    //   485: iconst_0
    //   486: invokestatic 215	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$400	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Ljava/lang/String;I)V
    //   489: aload_2
    //   490: ifnull -455 -> 35
    //   493: aload_2
    //   494: getfield 219	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   497: ifnull -462 -> 35
    //   500: aload_2
    //   501: getfield 219	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   504: invokevirtual 225	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   507: ifle -472 -> 35
    //   510: aload_2
    //   511: getfield 229	NS_MINI_AD/MiniAppAd$StGetAdRsp:iPreLoadLevel	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   514: invokevirtual 234	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   517: ldc2_w 235
    //   520: lcmp
    //   521: ifne -486 -> 35
    //   524: iload_3
    //   525: aload_2
    //   526: getfield 219	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   529: invokevirtual 225	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   532: if_icmpge -497 -> 35
    //   535: new 238	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   538: dup
    //   539: aload_2
    //   540: getfield 219	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   543: iload_3
    //   544: invokevirtual 241	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   547: checkcast 243	NS_MINI_INTERFACE/INTERFACE$StApiAppInfo
    //   550: invokestatic 249	com/tencent/mobileqq/mini/apkg/MiniAppInfo:from	(LNS_MINI_INTERFACE/INTERFACE$StApiAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   553: invokespecial 252	com/tencent/mobileqq/mini/apkg/MiniAppConfig:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   556: invokestatic 258	com/tencent/mobileqq/minigame/gpkg/GpkgManager:preloadGpkgByConfig	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;)V
    //   559: iload_3
    //   560: iconst_1
    //   561: iadd
    //   562: istore_3
    //   563: goto -39 -> 524
    //   566: astore 6
    //   568: ldc 58
    //   570: iconst_1
    //   571: ldc_w 260
    //   574: aload 6
    //   576: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   579: goto -100 -> 479
    //   582: aload_0
    //   583: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   586: aload_0
    //   587: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   590: sipush 1003
    //   593: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   596: sipush 1003
    //   599: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   602: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   605: checkcast 52	java/lang/String
    //   608: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   611: ldc 58
    //   613: iconst_1
    //   614: new 97	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   621: ldc_w 266
    //   624: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 5
    //   629: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: goto -159 -> 479
    //   641: ldc 58
    //   643: iconst_1
    //   644: ldc_w 268
    //   647: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: goto -171 -> 479
    //   653: astore_2
    //   654: ldc 58
    //   656: iconst_1
    //   657: new 97	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 272
    //   667: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_2
    //   671: invokevirtual 275	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   674: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: return
    //   684: aload_2
    //   685: ifnull +38 -> 723
    //   688: aload_2
    //   689: ldc 68
    //   691: invokevirtual 74	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   694: istore_3
    //   695: aload_0
    //   696: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   699: aload_0
    //   700: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   703: iload_3
    //   704: ldc_w 276
    //   707: invokestatic 281	alpo:a	(I)Ljava/lang/String;
    //   710: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   713: ldc 58
    //   715: iconst_1
    //   716: ldc_w 283
    //   719: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: return
    //   723: aload_0
    //   724: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   727: aload_0
    //   728: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   731: sipush 1003
    //   734: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   737: sipush 1003
    //   740: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   743: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   746: checkcast 52	java/lang/String
    //   749: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   752: goto -39 -> 713
    //   755: astore_2
    //   756: aload_0
    //   757: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   760: aload_0
    //   761: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   764: sipush 1003
    //   767: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   770: sipush 1003
    //   773: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   776: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   779: checkcast 52	java/lang/String
    //   782: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   785: goto -72 -> 713
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	this	2
    //   0	788	1	paramBoolean	boolean
    //   0	788	2	paramJSONObject	org.json.JSONObject
    //   1	703	3	i	int
    //   54	69	4	j	int
    //   73	555	5	str	java.lang.String
    //   207	266	6	localObject	Object
    //   566	9	6	localJSONException	org.json.JSONException
    //   239	6	7	localGdtAd	com.tencent.gdtad.aditem.GdtAd
    // Exception table:
    //   from	to	target	type
    //   40	117	163	org/json/JSONException
    //   125	133	163	org/json/JSONException
    //   133	162	163	org/json/JSONException
    //   194	209	163	org/json/JSONException
    //   214	272	163	org/json/JSONException
    //   479	489	163	org/json/JSONException
    //   493	524	163	org/json/JSONException
    //   524	559	163	org/json/JSONException
    //   568	579	163	org/json/JSONException
    //   582	638	163	org/json/JSONException
    //   641	650	163	org/json/JSONException
    //   654	683	163	org/json/JSONException
    //   276	479	566	org/json/JSONException
    //   493	524	653	java/lang/Throwable
    //   524	559	653	java/lang/Throwable
    //   688	713	755	java/lang/Exception
    //   723	752	755	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BannerAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */