package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;

class AdProxyImpl$1$1
  implements MiniAppCmdInterface
{
  AdProxyImpl$1$1(AdProxyImpl.1 param1) {}
  
  /* Error */
  public void onCmdListener(boolean paramBoolean, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +346 -> 347
    //   4: aload_2
    //   5: ifnonnull +6 -> 11
    //   8: goto +339 -> 347
    //   11: new 24	org/json/JSONObject
    //   14: dup
    //   15: invokespecial 25	org/json/JSONObject:<init>	()V
    //   18: astore 4
    //   20: aload_2
    //   21: ldc 27
    //   23: invokevirtual 31	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   26: checkcast 33	NS_MINI_AD/MiniAppAd$StGetAdRsp
    //   29: astore 5
    //   31: aload_2
    //   32: ldc 35
    //   34: invokevirtual 39	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   37: istore_3
    //   38: aload_2
    //   39: ldc 41
    //   41: invokevirtual 45	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_2
    //   45: aload 5
    //   47: getfield 49	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdsJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   50: invokevirtual 54	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   53: astore 6
    //   55: new 56	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   62: astore 7
    //   64: aload 7
    //   66: ldc 59
    //   68: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 7
    //   74: iload_3
    //   75: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 7
    //   81: ldc 68
    //   83: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 7
    //   89: aload_2
    //   90: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: ldc 70
    //   96: iconst_1
    //   97: aload 7
    //   99: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +39 -> 147
    //   111: new 56	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   118: astore 7
    //   120: aload 7
    //   122: ldc 85
    //   124: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 7
    //   130: aload 6
    //   132: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: ldc 70
    //   138: iconst_2
    //   139: aload 7
    //   141: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload 4
    //   149: ldc 35
    //   151: iload_3
    //   152: invokevirtual 89	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   155: pop
    //   156: aload 4
    //   158: ldc 41
    //   160: aload_2
    //   161: invokevirtual 92	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload 4
    //   167: ldc 27
    //   169: aload 6
    //   171: invokevirtual 92	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   174: pop
    //   175: aload 4
    //   177: ldc 94
    //   179: aload 5
    //   181: getfield 97	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdTemplateJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   184: invokevirtual 54	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   187: invokevirtual 92	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_0
    //   192: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   195: getfield 102	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   198: ifnull +18 -> 216
    //   201: aload_0
    //   202: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   205: getfield 102	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   208: iload_1
    //   209: aload 4
    //   211: invokeinterface 106 3 0
    //   216: iload_3
    //   217: ifne +129 -> 346
    //   220: aload 6
    //   222: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   225: istore_1
    //   226: iload_1
    //   227: ifne +119 -> 346
    //   230: aload 5
    //   232: getfield 116	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   235: ifnull +111 -> 346
    //   238: aload 5
    //   240: getfield 116	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   243: invokevirtual 122	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   246: ifle +100 -> 346
    //   249: aload 5
    //   251: getfield 126	NS_MINI_AD/MiniAppAd$StGetAdRsp:iPreLoadLevel	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   254: invokevirtual 131	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   257: ldc2_w 132
    //   260: lcmp
    //   261: ifne +85 -> 346
    //   264: iconst_0
    //   265: istore_3
    //   266: iload_3
    //   267: aload 5
    //   269: getfield 116	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   272: invokevirtual 122	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   275: if_icmpge +71 -> 346
    //   278: aload 5
    //   280: getfield 116	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   283: iload_3
    //   284: invokevirtual 136	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   287: checkcast 138	NS_MINI_INTERFACE/INTERFACE$StApiAppInfo
    //   290: invokestatic 144	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:from	(LNS_MINI_INTERFACE/INTERFACE$StApiAppInfo;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   293: invokestatic 149	com/tencent/qqmini/proxyimpl/MiniSdkUtil:a	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   296: invokestatic 155	com/tencent/mobileqq/mini/sdk/MiniAppController:preloadPackage	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   299: iload_3
    //   300: iconst_1
    //   301: iadd
    //   302: istore_3
    //   303: goto -37 -> 266
    //   306: astore_2
    //   307: ldc 70
    //   309: iconst_1
    //   310: ldc 157
    //   312: aload_2
    //   313: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: return
    //   317: astore_2
    //   318: aload_2
    //   319: invokevirtual 164	org/json/JSONException:printStackTrace	()V
    //   322: aload_0
    //   323: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   326: getfield 102	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   329: ifnull +17 -> 346
    //   332: aload_0
    //   333: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   336: getfield 102	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   339: iconst_0
    //   340: aconst_null
    //   341: invokeinterface 106 3 0
    //   346: return
    //   347: aload_0
    //   348: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   351: getfield 102	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   354: ifnull +17 -> 371
    //   357: aload_0
    //   358: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   361: getfield 102	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   364: iconst_0
    //   365: aload_2
    //   366: invokeinterface 106 3 0
    //   371: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	1
    //   0	372	1	paramBoolean	boolean
    //   0	372	2	paramJSONObject	org.json.JSONObject
    //   37	266	3	i	int
    //   18	192	4	localJSONObject	org.json.JSONObject
    //   29	250	5	localStGetAdRsp	NS_MINI_AD.MiniAppAd.StGetAdRsp
    //   53	168	6	str	java.lang.String
    //   62	78	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   230	264	306	java/lang/Throwable
    //   266	299	306	java/lang/Throwable
    //   20	147	317	org/json/JSONException
    //   147	216	317	org/json/JSONException
    //   220	226	317	org/json/JSONException
    //   230	264	317	org/json/JSONException
    //   266	299	317	org/json/JSONException
    //   307	316	317	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */