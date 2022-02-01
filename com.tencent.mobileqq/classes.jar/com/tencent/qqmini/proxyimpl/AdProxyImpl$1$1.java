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
    //   1: ifeq +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +28 -> 33
    //   8: aload_0
    //   9: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   12: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   15: ifnull +17 -> 32
    //   18: aload_0
    //   19: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   22: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   25: iconst_0
    //   26: aload_2
    //   27: invokeinterface 31 3 0
    //   32: return
    //   33: new 33	org/json/JSONObject
    //   36: dup
    //   37: invokespecial 34	org/json/JSONObject:<init>	()V
    //   40: astore 4
    //   42: aload_2
    //   43: ldc 36
    //   45: invokevirtual 40	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: checkcast 42	NS_MINI_AD/MiniAppAd$StGetAdRsp
    //   51: astore 5
    //   53: aload_2
    //   54: ldc 44
    //   56: invokevirtual 48	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   59: istore_3
    //   60: aload_2
    //   61: ldc 50
    //   63: invokevirtual 54	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: aload 5
    //   69: getfield 58	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdsJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   72: invokevirtual 63	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   75: astore 6
    //   77: ldc 65
    //   79: iconst_1
    //   80: new 67	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   87: ldc 70
    //   89: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload_3
    //   93: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc 79
    //   98: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_2
    //   102: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +29 -> 143
    //   117: ldc 65
    //   119: iconst_2
    //   120: new 67	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   127: ldc 94
    //   129: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 6
    //   134: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload 4
    //   145: ldc 44
    //   147: iload_3
    //   148: invokevirtual 98	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload 4
    //   154: ldc 50
    //   156: aload_2
    //   157: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload 4
    //   163: ldc 36
    //   165: aload 6
    //   167: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   170: pop
    //   171: aload 4
    //   173: ldc 103
    //   175: aload 5
    //   177: getfield 106	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdTemplateJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   180: invokevirtual 63	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   183: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   186: pop
    //   187: aload_0
    //   188: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   191: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   194: ifnull +18 -> 212
    //   197: aload_0
    //   198: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   201: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   204: iload_1
    //   205: aload 4
    //   207: invokeinterface 31 3 0
    //   212: iload_3
    //   213: ifne -181 -> 32
    //   216: aload 6
    //   218: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: istore_1
    //   222: iload_1
    //   223: ifne -191 -> 32
    //   226: aload 5
    //   228: getfield 116	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   231: ifnull -199 -> 32
    //   234: aload 5
    //   236: getfield 116	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   239: invokevirtual 122	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   242: ifle -210 -> 32
    //   245: aload 5
    //   247: getfield 126	NS_MINI_AD/MiniAppAd$StGetAdRsp:iPreLoadLevel	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   250: invokevirtual 131	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   253: ldc2_w 132
    //   256: lcmp
    //   257: ifne -225 -> 32
    //   260: iconst_0
    //   261: istore_3
    //   262: iload_3
    //   263: aload 5
    //   265: getfield 116	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   268: invokevirtual 122	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   271: if_icmpge -239 -> 32
    //   274: aload 5
    //   276: getfield 116	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   279: iload_3
    //   280: invokevirtual 136	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   283: checkcast 138	NS_MINI_INTERFACE/INTERFACE$StApiAppInfo
    //   286: invokestatic 144	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:from	(LNS_MINI_INTERFACE/INTERFACE$StApiAppInfo;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   289: invokestatic 149	com/tencent/qqmini/proxyimpl/MiniSdkUtil:a	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   292: invokestatic 155	com/tencent/mobileqq/mini/sdk/MiniAppController:preloadPackage	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   295: iload_3
    //   296: iconst_1
    //   297: iadd
    //   298: istore_3
    //   299: goto -37 -> 262
    //   302: astore_2
    //   303: ldc 65
    //   305: iconst_1
    //   306: ldc 157
    //   308: aload_2
    //   309: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: return
    //   313: astore_2
    //   314: aload_2
    //   315: invokevirtual 164	org/json/JSONException:printStackTrace	()V
    //   318: aload_0
    //   319: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   322: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   325: ifnull -293 -> 32
    //   328: aload_0
    //   329: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:a	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   332: getfield 27	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:a	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;
    //   335: iconst_0
    //   336: aconst_null
    //   337: invokeinterface 31 3 0
    //   342: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	1
    //   0	343	1	paramBoolean	boolean
    //   0	343	2	paramJSONObject	org.json.JSONObject
    //   59	240	3	i	int
    //   40	166	4	localJSONObject	org.json.JSONObject
    //   51	224	5	localStGetAdRsp	NS_MINI_AD.MiniAppAd.StGetAdRsp
    //   75	142	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   226	260	302	java/lang/Throwable
    //   262	295	302	java/lang/Throwable
    //   42	143	313	org/json/JSONException
    //   143	212	313	org/json/JSONException
    //   216	222	313	org/json/JSONException
    //   226	260	313	org/json/JSONException
    //   262	295	313	org/json/JSONException
    //   303	312	313	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */