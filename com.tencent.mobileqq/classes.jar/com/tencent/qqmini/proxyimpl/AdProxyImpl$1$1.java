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
    //   9: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:this$1	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   12: getfield 28	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:val$listener	Lcom/tencent/qqmini/sdk/core/proxy/AdProxy$ICmdListener;
    //   15: ifnull +17 -> 32
    //   18: aload_0
    //   19: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:this$1	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   22: getfield 28	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:val$listener	Lcom/tencent/qqmini/sdk/core/proxy/AdProxy$ICmdListener;
    //   25: iconst_0
    //   26: aload_2
    //   27: invokeinterface 32 3 0
    //   32: return
    //   33: new 34	org/json/JSONObject
    //   36: dup
    //   37: invokespecial 35	org/json/JSONObject:<init>	()V
    //   40: astore 4
    //   42: aload_2
    //   43: ldc 37
    //   45: invokevirtual 41	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: checkcast 43	NS_MINI_AD/MiniAppAd$StGetAdRsp
    //   51: astore 5
    //   53: aload_2
    //   54: ldc 45
    //   56: invokevirtual 49	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   59: istore_3
    //   60: aload_2
    //   61: ldc 51
    //   63: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: aload 5
    //   69: getfield 59	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdsJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   72: invokevirtual 64	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   75: astore 6
    //   77: ldc 66
    //   79: iconst_1
    //   80: new 68	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   87: ldc 71
    //   89: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload_3
    //   93: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc 80
    //   98: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_2
    //   102: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 82
    //   107: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 6
    //   112: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload 4
    //   123: ldc 45
    //   125: iload_3
    //   126: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload 4
    //   132: ldc 51
    //   134: aload_2
    //   135: invokevirtual 98	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload 4
    //   141: ldc 37
    //   143: aload 6
    //   145: invokevirtual 98	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload 4
    //   151: ldc 100
    //   153: aload 5
    //   155: getfield 103	NS_MINI_AD/MiniAppAd$StGetAdRsp:strAdTemplateJson	Lcom/tencent/mobileqq/pb/PBStringField;
    //   158: invokevirtual 64	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   161: invokevirtual 98	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: iload_3
    //   166: ifne +155 -> 321
    //   169: aload 6
    //   171: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifne +147 -> 321
    //   177: aload_0
    //   178: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:this$1	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   181: getfield 28	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:val$listener	Lcom/tencent/qqmini/sdk/core/proxy/AdProxy$ICmdListener;
    //   184: ifnull +18 -> 202
    //   187: aload_0
    //   188: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:this$1	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   191: getfield 28	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:val$listener	Lcom/tencent/qqmini/sdk/core/proxy/AdProxy$ICmdListener;
    //   194: iconst_1
    //   195: aload 4
    //   197: invokeinterface 32 3 0
    //   202: aload 5
    //   204: ifnull -172 -> 32
    //   207: aload 5
    //   209: getfield 113	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   212: ifnull -180 -> 32
    //   215: aload 5
    //   217: getfield 113	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   220: invokevirtual 119	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   223: ifle -191 -> 32
    //   226: aload 5
    //   228: getfield 123	NS_MINI_AD/MiniAppAd$StGetAdRsp:iPreLoadLevel	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   231: invokevirtual 128	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   234: ldc2_w 129
    //   237: lcmp
    //   238: ifne -206 -> 32
    //   241: iconst_0
    //   242: istore_3
    //   243: iload_3
    //   244: aload 5
    //   246: getfield 113	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   249: invokevirtual 119	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   252: if_icmpge -220 -> 32
    //   255: aload 5
    //   257: getfield 113	NS_MINI_AD/MiniAppAd$StGetAdRsp:vecAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   260: iload_3
    //   261: invokevirtual 133	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   264: checkcast 135	NS_MINI_INTERFACE/INTERFACE$StApiAppInfo
    //   267: invokestatic 141	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:from	(LNS_MINI_INTERFACE/INTERFACE$StApiAppInfo;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   270: invokestatic 147	bgud:a	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)V
    //   273: iload_3
    //   274: iconst_1
    //   275: iadd
    //   276: istore_3
    //   277: goto -34 -> 243
    //   280: astore_2
    //   281: ldc 66
    //   283: iconst_1
    //   284: ldc 149
    //   286: aload_2
    //   287: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   290: return
    //   291: astore_2
    //   292: aload_2
    //   293: invokevirtual 156	org/json/JSONException:printStackTrace	()V
    //   296: aload_0
    //   297: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:this$1	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   300: getfield 28	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:val$listener	Lcom/tencent/qqmini/sdk/core/proxy/AdProxy$ICmdListener;
    //   303: ifnull -271 -> 32
    //   306: aload_0
    //   307: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:this$1	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   310: getfield 28	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:val$listener	Lcom/tencent/qqmini/sdk/core/proxy/AdProxy$ICmdListener;
    //   313: iconst_0
    //   314: aconst_null
    //   315: invokeinterface 32 3 0
    //   320: return
    //   321: aload_0
    //   322: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:this$1	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   325: getfield 28	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:val$listener	Lcom/tencent/qqmini/sdk/core/proxy/AdProxy$ICmdListener;
    //   328: ifnull -296 -> 32
    //   331: aload_0
    //   332: getfield 12	com/tencent/qqmini/proxyimpl/AdProxyImpl$1$1:this$1	Lcom/tencent/qqmini/proxyimpl/AdProxyImpl$1;
    //   335: getfield 28	com/tencent/qqmini/proxyimpl/AdProxyImpl$1:val$listener	Lcom/tencent/qqmini/sdk/core/proxy/AdProxy$ICmdListener;
    //   338: iconst_0
    //   339: aload 4
    //   341: invokeinterface 32 3 0
    //   346: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	1
    //   0	347	1	paramBoolean	boolean
    //   0	347	2	paramJSONObject	org.json.JSONObject
    //   59	218	3	i	int
    //   40	300	4	localJSONObject	org.json.JSONObject
    //   51	205	5	localStGetAdRsp	NS_MINI_AD.MiniAppAd.StGetAdRsp
    //   75	95	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   207	241	280	java/lang/Throwable
    //   243	273	280	java/lang/Throwable
    //   42	165	291	org/json/JSONException
    //   169	202	291	org/json/JSONException
    //   207	241	291	org/json/JSONException
    //   243	273	291	org/json/JSONException
    //   281	290	291	org/json/JSONException
    //   321	346	291	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */