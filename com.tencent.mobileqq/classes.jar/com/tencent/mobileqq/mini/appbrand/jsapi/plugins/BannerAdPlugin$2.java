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
    //   37: ifeq +721 -> 758
    //   40: ldc 58
    //   42: iconst_1
    //   43: ldc 60
    //   45: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_2
    //   49: ldc 68
    //   51: invokevirtual 74	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   54: checkcast 76	NS_MINI_AD/MiniAppAd$StGetAdRsp
    //   57: astore 5
    //   59: aload 5
    //   61: getfield 80	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdsJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   64: invokevirtual 85	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   67: astore 6
    //   69: aload_2
    //   70: ldc 87
    //   72: invokevirtual 91	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   75: istore 4
    //   77: aload_2
    //   78: ldc 93
    //   80: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_2
    //   84: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +39 -> 126
    //   90: ldc 58
    //   92: iconst_2
    //   93: new 103	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   100: ldc 106
    //   102: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: iload 4
    //   107: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: ldc 115
    //   112: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 6
    //   117: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: iload 4
    //   128: ifne +11 -> 139
    //   131: aload 6
    //   133: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   136: ifeq +99 -> 235
    //   139: iload 4
    //   141: invokestatic 130	com/tencent/mobileqq/mini/appbrand/jsapi/PluginConst$AdConst:getRetCodeByServerResult	(I)I
    //   144: istore_3
    //   145: iload_3
    //   146: iconst_m1
    //   147: if_icmpeq +60 -> 207
    //   150: aload_0
    //   151: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   154: aload_0
    //   155: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   158: iload_3
    //   159: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   162: iload_3
    //   163: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   169: checkcast 52	java/lang/String
    //   172: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   175: return
    //   176: astore_2
    //   177: aload_0
    //   178: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   181: aload_0
    //   182: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   185: sipush 1003
    //   188: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   191: sipush 1003
    //   194: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   200: checkcast 52	java/lang/String
    //   203: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   206: return
    //   207: getstatic 134	com/tencent/mobileqq/mini/appbrand/jsapi/PluginConst$AdConst:CodeMsgMap	Ljava/util/HashMap;
    //   210: iload 4
    //   212: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aload_2
    //   216: invokevirtual 138	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: pop
    //   220: aload_0
    //   221: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   224: aload_0
    //   225: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   228: iload 4
    //   230: aload_2
    //   231: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   234: return
    //   235: aload_0
    //   236: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   239: aload_0
    //   240: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   243: aload 6
    //   245: invokestatic 142	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$200	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;)Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;
    //   248: astore_2
    //   249: aload_2
    //   250: ifnull +465 -> 715
    //   253: aload_0
    //   254: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   257: getfield 146	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   260: getfield 152	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   263: instanceof 154
    //   266: ifeq +283 -> 549
    //   269: new 156	com/tencent/gdtad/aditem/GdtAd
    //   272: dup
    //   273: aload_2
    //   274: invokespecial 159	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   277: astore 7
    //   279: invokestatic 165	ackk:a	()Lackk;
    //   282: aload 7
    //   284: invokevirtual 168	ackk:a	(Lcom/tencent/gdtad/aditem/GdtAd;)V
    //   287: aload_0
    //   288: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   291: getfield 146	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   294: getfield 152	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   297: checkcast 154	com/tencent/mobileqq/minigame/ui/GameActivity
    //   300: aload_0
    //   301: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   304: aload_2
    //   305: invokevirtual 172	com/tencent/mobileqq/minigame/ui/GameActivity:createBannerAd	(Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)Z
    //   308: istore_1
    //   309: iload_1
    //   310: ifeq +346 -> 656
    //   313: new 70	org/json/JSONObject
    //   316: dup
    //   317: invokespecial 173	org/json/JSONObject:<init>	()V
    //   320: astore 7
    //   322: aload 7
    //   324: ldc 175
    //   326: ldc 177
    //   328: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   331: pop
    //   332: aload 7
    //   334: ldc 182
    //   336: aload_0
    //   337: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   340: getfield 188	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdUnitId	Ljava/lang/String;
    //   343: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   346: pop
    //   347: aload 7
    //   349: ldc 190
    //   351: aload_0
    //   352: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   355: getfield 194	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdLeft	I
    //   358: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   361: pop
    //   362: aload 7
    //   364: ldc 199
    //   366: aload_0
    //   367: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   370: getfield 202	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdTop	I
    //   373: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   376: pop
    //   377: aload 7
    //   379: ldc 204
    //   381: aload_0
    //   382: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   385: getfield 207	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdWidth	I
    //   388: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   391: pop
    //   392: aload 7
    //   394: ldc 209
    //   396: aload_0
    //   397: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   400: getfield 212	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdHeight	I
    //   403: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   406: pop
    //   407: aload 7
    //   409: ldc 214
    //   411: aload_0
    //   412: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   415: getfield 217	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealWidth	I
    //   418: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload 7
    //   424: ldc 219
    //   426: aload_0
    //   427: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   430: getfield 222	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealHeight	I
    //   433: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   436: pop
    //   437: aload_0
    //   438: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   441: aload_0
    //   442: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   445: aload 7
    //   447: ldc 224
    //   449: invokestatic 228	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$300	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   452: new 70	org/json/JSONObject
    //   455: dup
    //   456: invokespecial 173	org/json/JSONObject:<init>	()V
    //   459: astore 7
    //   461: aload 7
    //   463: ldc 175
    //   465: ldc 230
    //   467: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   470: pop
    //   471: aload 7
    //   473: ldc 204
    //   475: aload_0
    //   476: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   479: getfield 217	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealWidth	I
    //   482: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   485: pop
    //   486: aload 7
    //   488: ldc 209
    //   490: aload_0
    //   491: getfield 20	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$adPosInfo	Lcom/tencent/mobileqq/minigame/data/BannerAdPosInfo;
    //   494: getfield 222	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:mAdRealHeight	I
    //   497: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   500: pop
    //   501: aload_0
    //   502: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   505: aload_0
    //   506: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   509: aload 7
    //   511: ldc 224
    //   513: invokestatic 228	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$300	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   516: aload_2
    //   517: getfield 236	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   520: ifnull +29 -> 549
    //   523: aload_0
    //   524: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   527: getfield 146	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   530: getfield 240	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   533: getfield 246	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   536: aload_2
    //   537: getfield 236	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   540: getfield 251	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   543: invokevirtual 85	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   546: invokestatic 256	bjvn:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   549: aload_0
    //   550: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   553: aload 6
    //   555: iconst_0
    //   556: invokestatic 260	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$400	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Ljava/lang/String;I)V
    //   559: aload 5
    //   561: ifnull -526 -> 35
    //   564: aload 5
    //   566: getfield 264	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   569: ifnull -534 -> 35
    //   572: aload 5
    //   574: getfield 264	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   577: invokevirtual 270	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   580: ifle -545 -> 35
    //   583: aload 5
    //   585: getfield 274	NS_MINI_AD/MiniAppAd$StGetAdRsp:iPreLoadLevel	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   588: invokevirtual 279	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   591: ldc2_w 280
    //   594: lcmp
    //   595: ifne -560 -> 35
    //   598: iload_3
    //   599: aload 5
    //   601: getfield 264	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   604: invokevirtual 270	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   607: if_icmpge -572 -> 35
    //   610: new 283	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   613: dup
    //   614: aload 5
    //   616: getfield 264	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   619: iload_3
    //   620: invokevirtual 286	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   623: checkcast 288	NS_MINI_INTERFACE/INTERFACE$StApiAppInfo
    //   626: invokestatic 294	com/tencent/mobileqq/mini/apkg/MiniAppInfo:from	(LNS_MINI_INTERFACE/INTERFACE$StApiAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   629: invokespecial 297	com/tencent/mobileqq/mini/apkg/MiniAppConfig:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   632: invokestatic 303	com/tencent/mobileqq/minigame/gpkg/GpkgManager:preloadGpkgByConfig	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;)V
    //   635: iload_3
    //   636: iconst_1
    //   637: iadd
    //   638: istore_3
    //   639: goto -41 -> 598
    //   642: astore_2
    //   643: ldc 58
    //   645: iconst_1
    //   646: ldc_w 305
    //   649: aload_2
    //   650: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   653: goto -104 -> 549
    //   656: aload_0
    //   657: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   660: aload_0
    //   661: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   664: sipush 1003
    //   667: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   670: sipush 1003
    //   673: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   676: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   679: checkcast 52	java/lang/String
    //   682: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   685: ldc 58
    //   687: iconst_1
    //   688: new 103	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   695: ldc_w 311
    //   698: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload 6
    //   703: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: goto -163 -> 549
    //   715: ldc 58
    //   717: iconst_1
    //   718: ldc_w 313
    //   721: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   724: goto -175 -> 549
    //   727: astore_2
    //   728: ldc 58
    //   730: iconst_1
    //   731: new 103	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   738: ldc_w 317
    //   741: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload_2
    //   745: invokevirtual 320	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   748: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: return
    //   758: aload_2
    //   759: ifnull +39 -> 798
    //   762: aload_2
    //   763: ldc_w 322
    //   766: invokevirtual 91	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   769: istore_3
    //   770: aload_0
    //   771: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   774: aload_0
    //   775: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   778: iload_3
    //   779: ldc_w 323
    //   782: invokestatic 328	anni:a	(I)Ljava/lang/String;
    //   785: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   788: ldc 58
    //   790: iconst_1
    //   791: ldc_w 330
    //   794: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   797: return
    //   798: aload_0
    //   799: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   802: aload_0
    //   803: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   806: sipush 1003
    //   809: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   812: sipush 1003
    //   815: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   818: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   821: checkcast 52	java/lang/String
    //   824: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   827: goto -39 -> 788
    //   830: astore_2
    //   831: aload_0
    //   832: getfield 16	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;
    //   835: aload_0
    //   836: getfield 18	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin$2:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   839: sipush 1003
    //   842: invokestatic 38	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$000	()Ljava/util/HashMap;
    //   845: sipush 1003
    //   848: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   851: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   854: checkcast 52	java/lang/String
    //   857: invokestatic 56	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BannerAdPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   860: goto -72 -> 788
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	863	0	this	2
    //   0	863	1	paramBoolean	boolean
    //   0	863	2	paramJSONObject	org.json.JSONObject
    //   1	778	3	i	int
    //   75	154	4	j	int
    //   57	558	5	localStGetAdRsp	NS_MINI_AD.MiniAppAd.StGetAdRsp
    //   67	635	6	str	java.lang.String
    //   277	233	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	126	176	org/json/JSONException
    //   131	139	176	org/json/JSONException
    //   139	145	176	org/json/JSONException
    //   150	175	176	org/json/JSONException
    //   207	234	176	org/json/JSONException
    //   235	249	176	org/json/JSONException
    //   253	309	176	org/json/JSONException
    //   549	559	176	org/json/JSONException
    //   564	598	176	org/json/JSONException
    //   598	635	176	org/json/JSONException
    //   643	653	176	org/json/JSONException
    //   656	712	176	org/json/JSONException
    //   715	724	176	org/json/JSONException
    //   728	757	176	org/json/JSONException
    //   313	549	642	org/json/JSONException
    //   564	598	727	java/lang/Throwable
    //   598	635	727	java/lang/Throwable
    //   762	788	830	java/lang/Exception
    //   798	827	830	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BannerAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */