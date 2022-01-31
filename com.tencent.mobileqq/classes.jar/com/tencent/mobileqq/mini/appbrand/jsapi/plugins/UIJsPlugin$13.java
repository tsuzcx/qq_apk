package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;

class UIJsPlugin$13
  implements Runnable
{
  UIJsPlugin$13(UIJsPlugin paramUIJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   6: getfield 42	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9: invokevirtual 48	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   12: invokestatic 54	bfpc:a	(Landroid/content/Context;)Lbfpc;
    //   15: astore 10
    //   17: new 56	org/json/JSONObject
    //   20: dup
    //   21: aload_0
    //   22: getfield 21	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$jsonParams	Ljava/lang/String;
    //   25: invokespecial 59	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: astore 11
    //   30: aload 11
    //   32: ldc 61
    //   34: invokevirtual 65	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   37: astore 12
    //   39: aload 11
    //   41: ldc 67
    //   43: iconst_0
    //   44: invokevirtual 71	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   47: istore_2
    //   48: iload_2
    //   49: tableswitch	default:+994 -> 1043, 0:+80->129, 1:+218->267
    //   73: dstore_2
    //   74: iconst_1
    //   75: new 75	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   86: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 82
    //   91: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: iload_2
    //   95: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: return
    //   105: aload 10
    //   107: aload 12
    //   109: iload_1
    //   110: invokevirtual 101	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   113: bipush 9
    //   115: aload 11
    //   117: ldc 103
    //   119: invokevirtual 106	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokevirtual 109	bfpc:a	(Ljava/lang/CharSequence;ILjava/lang/String;)V
    //   125: iload_1
    //   126: iconst_1
    //   127: iadd
    //   128: istore_1
    //   129: iload_1
    //   130: aload 12
    //   132: invokevirtual 113	org/json/JSONArray:length	()I
    //   135: if_icmpge +69 -> 204
    //   138: aload 12
    //   140: iload_1
    //   141: invokevirtual 117	org/json/JSONArray:isNull	(I)Z
    //   144: ifeq -39 -> 105
    //   147: aload_0
    //   148: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   151: getfield 42	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   154: aload_0
    //   155: getfield 23	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   158: aload_0
    //   159: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   162: aconst_null
    //   163: aload_0
    //   164: getfield 27	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$callbackId	I
    //   167: invokevirtual 121	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   170: return
    //   171: astore 10
    //   173: ldc 73
    //   175: iconst_1
    //   176: new 75	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   183: aload_0
    //   184: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   187: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 123
    //   192: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: aload 10
    //   200: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   203: return
    //   204: aload 10
    //   206: ldc 127
    //   208: invokestatic 131	ajya:a	(I)Ljava/lang/String;
    //   211: invokevirtual 135	bfpc:d	(Ljava/lang/CharSequence;)V
    //   214: aload 10
    //   216: invokevirtual 138	bfpc:show	()V
    //   219: aload 10
    //   221: iconst_1
    //   222: invokevirtual 142	bfpc:c	(Z)V
    //   225: aload 10
    //   227: new 144	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13$1
    //   230: dup
    //   231: aload_0
    //   232: invokespecial 147	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13$1:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13;)V
    //   235: invokevirtual 150	bfpc:a	(Lbfpj;)V
    //   238: aload 10
    //   240: new 152	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13$2
    //   243: dup
    //   244: aload_0
    //   245: invokespecial 153	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13;)V
    //   248: invokevirtual 157	bfpc:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   251: aload 10
    //   253: new 159	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13$3
    //   256: dup
    //   257: aload_0
    //   258: aload 10
    //   260: invokespecial 162	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13;Lbfpc;)V
    //   263: invokevirtual 165	bfpc:a	(Lbfph;)V
    //   266: return
    //   267: aload_0
    //   268: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   271: getfield 42	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   274: ifnull +738 -> 1012
    //   277: aload_0
    //   278: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   281: getfield 42	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   284: getfield 169	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   287: ifnull +685 -> 972
    //   290: new 171	java/util/HashMap
    //   293: dup
    //   294: invokespecial 172	java/util/HashMap:<init>	()V
    //   297: astore 11
    //   299: aload_0
    //   300: getfield 21	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$jsonParams	Ljava/lang/String;
    //   303: ifnull +31 -> 334
    //   306: ldc 174
    //   308: aload_0
    //   309: getfield 21	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$jsonParams	Ljava/lang/String;
    //   312: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifne +19 -> 334
    //   318: ldc 182
    //   320: aload_0
    //   321: getfield 21	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$jsonParams	Ljava/lang/String;
    //   324: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: istore 6
    //   329: iload 6
    //   331: ifeq +110 -> 441
    //   334: new 56	org/json/JSONObject
    //   337: dup
    //   338: invokespecial 183	org/json/JSONObject:<init>	()V
    //   341: astore 10
    //   343: aload 10
    //   345: ldc 185
    //   347: ldc 187
    //   349: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   352: pop
    //   353: aload_0
    //   354: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   357: getfield 42	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   360: aload_0
    //   361: getfield 23	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   364: aload_0
    //   365: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   368: aload 10
    //   370: aload_0
    //   371: getfield 27	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$callbackId	I
    //   374: invokevirtual 121	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   377: ldc 73
    //   379: iconst_1
    //   380: new 75	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   387: aload_0
    //   388: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   391: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc 193
    //   396: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: return
    //   406: astore 10
    //   408: ldc 73
    //   410: iconst_1
    //   411: new 75	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   418: aload_0
    //   419: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   422: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc 123
    //   427: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: aload 10
    //   435: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   438: goto -61 -> 377
    //   441: new 56	org/json/JSONObject
    //   444: dup
    //   445: aload_0
    //   446: getfield 21	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$jsonParams	Ljava/lang/String;
    //   449: invokespecial 59	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   452: ldc 61
    //   454: invokevirtual 197	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   457: checkcast 97	org/json/JSONArray
    //   460: astore 10
    //   462: aload 10
    //   464: ifnonnull +583 -> 1047
    //   467: new 56	org/json/JSONObject
    //   470: dup
    //   471: invokespecial 183	org/json/JSONObject:<init>	()V
    //   474: astore 10
    //   476: aload 10
    //   478: ldc 185
    //   480: ldc 199
    //   482: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   485: pop
    //   486: aload_0
    //   487: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   490: getfield 42	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   493: aload_0
    //   494: getfield 23	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   497: aload_0
    //   498: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   501: aload 10
    //   503: aload_0
    //   504: getfield 27	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$callbackId	I
    //   507: invokevirtual 121	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   510: ldc 73
    //   512: iconst_1
    //   513: new 75	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   520: aload_0
    //   521: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   524: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc 201
    //   529: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: return
    //   539: astore 10
    //   541: aload 10
    //   543: invokevirtual 204	org/json/JSONException:printStackTrace	()V
    //   546: ldc 73
    //   548: iconst_1
    //   549: aload 10
    //   551: iconst_0
    //   552: anewarray 4	java/lang/Object
    //   555: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   558: aload_0
    //   559: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   562: getfield 42	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   565: aload_0
    //   566: getfield 23	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   569: aload_0
    //   570: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   573: aload_0
    //   574: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   577: aconst_null
    //   578: invokestatic 213	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   581: aload_0
    //   582: getfield 27	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$callbackId	I
    //   585: invokevirtual 121	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   588: return
    //   589: astore 10
    //   591: ldc 73
    //   593: iconst_1
    //   594: new 75	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   601: aload_0
    //   602: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   605: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: ldc 123
    //   610: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: aload 10
    //   618: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   621: goto -111 -> 510
    //   624: iload 5
    //   626: aload 10
    //   628: invokevirtual 113	org/json/JSONArray:length	()I
    //   631: if_icmpge +122 -> 753
    //   634: aload 10
    //   636: iload 5
    //   638: invokevirtual 216	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   641: astore 12
    //   643: aload 12
    //   645: ldc 218
    //   647: invokevirtual 222	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   650: ifeq +19 -> 669
    //   653: aload 11
    //   655: ldc 224
    //   657: iload 5
    //   659: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   662: invokevirtual 233	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   665: pop
    //   666: iconst_1
    //   667: istore 4
    //   669: aload 12
    //   671: ldc 235
    //   673: invokevirtual 222	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   676: ifeq +18 -> 694
    //   679: aload 11
    //   681: ldc 237
    //   683: iload 5
    //   685: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   688: invokevirtual 233	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   691: pop
    //   692: iconst_1
    //   693: istore_3
    //   694: aload 12
    //   696: ldc 239
    //   698: invokevirtual 222	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   701: ifeq +18 -> 719
    //   704: aload 11
    //   706: ldc 241
    //   708: iload 5
    //   710: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   713: invokevirtual 233	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   716: pop
    //   717: iconst_1
    //   718: istore_2
    //   719: aload 12
    //   721: ldc 243
    //   723: invokevirtual 222	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   726: ifeq +18 -> 744
    //   729: aload 11
    //   731: ldc 245
    //   733: iload 5
    //   735: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   738: invokevirtual 233	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   741: pop
    //   742: iconst_1
    //   743: istore_1
    //   744: iload 5
    //   746: iconst_1
    //   747: iadd
    //   748: istore 5
    //   750: goto -126 -> 624
    //   753: iload 4
    //   755: iconst_m1
    //   756: if_icmpne +284 -> 1040
    //   759: iconst_0
    //   760: istore 4
    //   762: iload_3
    //   763: iconst_m1
    //   764: if_icmpne +273 -> 1037
    //   767: iconst_0
    //   768: istore_3
    //   769: iload_2
    //   770: istore 5
    //   772: iload_2
    //   773: iconst_m1
    //   774: if_icmpne +6 -> 780
    //   777: iconst_0
    //   778: istore 5
    //   780: iload_1
    //   781: iconst_m1
    //   782: if_icmpne +252 -> 1034
    //   785: iconst_0
    //   786: istore_1
    //   787: aload_0
    //   788: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   791: invokevirtual 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:isMiniGameRuntime	()Z
    //   794: ifeq +106 -> 900
    //   797: aload_0
    //   798: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   801: invokevirtual 253	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   804: astore 10
    //   806: aload 10
    //   808: ifnull +214 -> 1022
    //   811: aload 10
    //   813: getfield 259	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:activity	Landroid/app/Activity;
    //   816: instanceof 261
    //   819: ifeq +203 -> 1022
    //   822: aload 10
    //   824: getfield 259	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:activity	Landroid/app/Activity;
    //   827: checkcast 261	com/tencent/mobileqq/minigame/ui/GameActivity
    //   830: invokevirtual 265	com/tencent/mobileqq/minigame/ui/GameActivity:getNavBar	()Lcom/tencent/mobileqq/minigame/ui/NavigatorBarForMiniGame;
    //   833: astore 10
    //   835: aload 10
    //   837: ifnull +185 -> 1022
    //   840: aload 10
    //   842: invokevirtual 271	com/tencent/mobileqq/minigame/ui/NavigatorBarForMiniGame:getCapsuleButton	()Lcom/tencent/mobileqq/mini/appbrand/ui/CapsuleButton;
    //   845: astore 10
    //   847: goto +215 -> 1062
    //   850: aload 10
    //   852: iload 6
    //   854: iload 7
    //   856: iload 8
    //   858: iload 9
    //   860: aload 11
    //   862: aload_0
    //   863: getfield 27	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$callbackId	I
    //   866: invokevirtual 277	com/tencent/mobileqq/mini/appbrand/ui/CapsuleButton:showShareMenuForInnerShareButton	(ZZZZLjava/util/HashMap;I)V
    //   869: return
    //   870: astore 10
    //   872: ldc 73
    //   874: iconst_1
    //   875: new 75	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   882: ldc_w 279
    //   885: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: aload 10
    //   890: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   893: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   896: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   899: return
    //   900: aload_0
    //   901: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   904: getfield 42	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   907: getfield 169	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   910: invokevirtual 288	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   913: checkcast 290	com/tencent/mobileqq/mini/appbrand/page/AppBrandPageContainer
    //   916: invokevirtual 294	com/tencent/mobileqq/mini/appbrand/page/AppBrandPageContainer:getCurrentPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   919: astore 10
    //   921: aload 10
    //   923: ifnull +105 -> 1028
    //   926: aload 10
    //   928: invokevirtual 299	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getNavBar	()Lcom/tencent/mobileqq/mini/ui/NavigationBar;
    //   931: astore 10
    //   933: aload 10
    //   935: ifnull +87 -> 1022
    //   938: aload 10
    //   940: invokevirtual 302	com/tencent/mobileqq/mini/ui/NavigationBar:getCapsuleButton	()Lcom/tencent/mobileqq/mini/appbrand/ui/CapsuleButton;
    //   943: astore 10
    //   945: goto +117 -> 1062
    //   948: iconst_0
    //   949: istore 6
    //   951: goto +125 -> 1076
    //   954: iconst_0
    //   955: istore 7
    //   957: goto +127 -> 1084
    //   960: iconst_0
    //   961: istore 8
    //   963: goto +130 -> 1093
    //   966: iconst_0
    //   967: istore 9
    //   969: goto -119 -> 850
    //   972: ldc 73
    //   974: iconst_1
    //   975: ldc_w 304
    //   978: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   981: aload_0
    //   982: getfield 19	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin;
    //   985: getfield 42	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   988: aload_0
    //   989: getfield 23	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$webview	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   992: aload_0
    //   993: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   996: aload_0
    //   997: getfield 25	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$event	Ljava/lang/String;
    //   1000: aconst_null
    //   1001: invokestatic 213	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1004: aload_0
    //   1005: getfield 27	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/UIJsPlugin$13:val$callbackId	I
    //   1008: invokevirtual 121	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   1011: return
    //   1012: ldc 73
    //   1014: iconst_1
    //   1015: ldc_w 306
    //   1018: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1021: return
    //   1022: aconst_null
    //   1023: astore 10
    //   1025: goto +37 -> 1062
    //   1028: aconst_null
    //   1029: astore 10
    //   1031: goto -98 -> 933
    //   1034: goto -247 -> 787
    //   1037: goto -268 -> 769
    //   1040: goto -278 -> 762
    //   1043: goto -971 -> 72
    //   1046: return
    //   1047: iconst_0
    //   1048: istore 5
    //   1050: iconst_m1
    //   1051: istore_1
    //   1052: iconst_m1
    //   1053: istore_2
    //   1054: iconst_m1
    //   1055: istore_3
    //   1056: iconst_m1
    //   1057: istore 4
    //   1059: goto -435 -> 624
    //   1062: aload 10
    //   1064: ifnull -18 -> 1046
    //   1067: iload 4
    //   1069: iconst_1
    //   1070: if_icmpne -122 -> 948
    //   1073: iconst_1
    //   1074: istore 6
    //   1076: iload_3
    //   1077: iconst_1
    //   1078: if_icmpne -124 -> 954
    //   1081: iconst_1
    //   1082: istore 7
    //   1084: iload 5
    //   1086: iconst_1
    //   1087: if_icmpne -127 -> 960
    //   1090: iconst_1
    //   1091: istore 8
    //   1093: iload_1
    //   1094: iconst_1
    //   1095: if_icmpne -129 -> 966
    //   1098: iconst_1
    //   1099: istore 9
    //   1101: goto -251 -> 850
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1104	0	this	13
    //   1	1095	1	i	int
    //   47	1007	2	j	int
    //   693	386	3	k	int
    //   667	404	4	m	int
    //   624	464	5	n	int
    //   327	748	6	bool1	boolean
    //   854	229	7	bool2	boolean
    //   856	236	8	bool3	boolean
    //   858	242	9	bool4	boolean
    //   15	91	10	localbfpc	bfpc
    //   171	88	10	localJSONException1	org.json.JSONException
    //   341	28	10	localJSONObject	org.json.JSONObject
    //   406	28	10	localJSONException2	org.json.JSONException
    //   460	42	10	localObject1	Object
    //   539	11	10	localJSONException3	org.json.JSONException
    //   589	46	10	localJSONException4	org.json.JSONException
    //   804	47	10	localObject2	Object
    //   870	19	10	localNullPointerException	java.lang.NullPointerException
    //   919	144	10	localObject3	Object
    //   28	833	11	localObject4	Object
    //   37	683	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	171	org/json/JSONException
    //   72	104	171	org/json/JSONException
    //   105	125	171	org/json/JSONException
    //   129	170	171	org/json/JSONException
    //   204	266	171	org/json/JSONException
    //   267	329	171	org/json/JSONException
    //   377	405	171	org/json/JSONException
    //   408	438	171	org/json/JSONException
    //   541	588	171	org/json/JSONException
    //   787	806	171	org/json/JSONException
    //   811	835	171	org/json/JSONException
    //   840	847	171	org/json/JSONException
    //   850	869	171	org/json/JSONException
    //   872	899	171	org/json/JSONException
    //   900	921	171	org/json/JSONException
    //   926	933	171	org/json/JSONException
    //   938	945	171	org/json/JSONException
    //   972	1011	171	org/json/JSONException
    //   1012	1021	171	org/json/JSONException
    //   334	377	406	org/json/JSONException
    //   441	462	539	org/json/JSONException
    //   510	538	539	org/json/JSONException
    //   591	621	539	org/json/JSONException
    //   624	643	539	org/json/JSONException
    //   643	666	539	org/json/JSONException
    //   669	692	539	org/json/JSONException
    //   694	717	539	org/json/JSONException
    //   719	742	539	org/json/JSONException
    //   467	510	589	org/json/JSONException
    //   787	806	870	java/lang/NullPointerException
    //   811	835	870	java/lang/NullPointerException
    //   840	847	870	java/lang/NullPointerException
    //   850	869	870	java/lang/NullPointerException
    //   900	921	870	java/lang/NullPointerException
    //   926	933	870	java/lang/NullPointerException
    //   938	945	870	java/lang/NullPointerException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */