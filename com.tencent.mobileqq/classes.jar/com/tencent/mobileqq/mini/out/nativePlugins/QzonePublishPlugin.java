package com.tencent.mobileqq.mini.out.nativePlugins;

import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;

public class QzonePublishPlugin
  implements NativePlugin
{
  public static final String API_NAVIGATE_TO_PUBLISH_PROGRAM = "checkin_qzoneUploadAndPublish";
  private static final String TAG = "[mini] QzonePublishPlugin";
  
  public void onDestroy() {}
  
  /* Error */
  public void onInvoke(org.json.JSONObject paramJSONObject, com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext paramJSContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 27
    //   3: invokevirtual 33	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: astore 9
    //   8: aload 9
    //   10: ifnull +511 -> 521
    //   13: aload 9
    //   15: ldc 35
    //   17: invokevirtual 39	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast 41	java/lang/String
    //   23: astore 13
    //   25: aload 9
    //   27: ldc 43
    //   29: invokevirtual 39	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 41	java/lang/String
    //   35: astore 14
    //   37: aload 9
    //   39: ldc 45
    //   41: invokevirtual 39	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   44: checkcast 41	java/lang/String
    //   47: astore_1
    //   48: aload_1
    //   49: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne +480 -> 532
    //   55: invokestatic 57	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   58: aload_1
    //   59: invokevirtual 61	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_1
    //   63: aload 9
    //   65: ldc 63
    //   67: invokevirtual 67	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   70: istore 8
    //   72: aload 9
    //   74: ldc 69
    //   76: invokevirtual 72	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   79: astore 10
    //   81: new 74	cooperation/qzone/LbsDataV2$PoiInfo
    //   84: dup
    //   85: invokespecial 75	cooperation/qzone/LbsDataV2$PoiInfo:<init>	()V
    //   88: astore 15
    //   90: aload 10
    //   92: ifnull +73 -> 165
    //   95: aload 10
    //   97: ldc 77
    //   99: invokevirtual 81	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   102: dstore_3
    //   103: aload 10
    //   105: ldc 83
    //   107: invokevirtual 81	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   110: dstore 5
    //   112: aload 10
    //   114: ldc 85
    //   116: invokevirtual 67	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   119: pop
    //   120: aload 10
    //   122: ldc 87
    //   124: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 10
    //   129: aload 15
    //   131: getfield 94	cooperation/qzone/LbsDataV2$PoiInfo:gpsInfo	Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   134: dload_3
    //   135: ldc2_w 95
    //   138: dmul
    //   139: d2i
    //   140: putfield 102	cooperation/qzone/LbsDataV2$GpsInfo:lon	I
    //   143: aload 15
    //   145: getfield 94	cooperation/qzone/LbsDataV2$PoiInfo:gpsInfo	Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   148: dload 5
    //   150: ldc2_w 95
    //   153: dmul
    //   154: d2i
    //   155: putfield 105	cooperation/qzone/LbsDataV2$GpsInfo:lat	I
    //   158: aload 15
    //   160: aload 10
    //   162: putfield 108	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   165: aconst_null
    //   166: astore 10
    //   168: aload 9
    //   170: ldc 110
    //   172: invokevirtual 72	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   175: astore 11
    //   177: aload 11
    //   179: ifnull +12 -> 191
    //   182: aload 11
    //   184: ldc 112
    //   186: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 10
    //   191: new 114	java/util/HashMap
    //   194: dup
    //   195: invokespecial 115	java/util/HashMap:<init>	()V
    //   198: astore 16
    //   200: aload 9
    //   202: ldc 117
    //   204: invokevirtual 72	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   207: astore 11
    //   209: aload 11
    //   211: ifnull +85 -> 296
    //   214: aload 11
    //   216: invokevirtual 121	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   219: astore 12
    //   221: aload 12
    //   223: invokeinterface 127 1 0
    //   228: ifeq +68 -> 296
    //   231: aload 12
    //   233: invokeinterface 131 1 0
    //   238: checkcast 41	java/lang/String
    //   241: astore 17
    //   243: aload 16
    //   245: aload 17
    //   247: aload 11
    //   249: aload 17
    //   251: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   254: invokevirtual 135	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   257: pop
    //   258: goto -37 -> 221
    //   261: astore_1
    //   262: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +12 -> 277
    //   268: ldc 13
    //   270: iconst_2
    //   271: ldc 142
    //   273: aload_1
    //   274: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   277: return
    //   278: astore_1
    //   279: ldc 13
    //   281: iconst_1
    //   282: aload_1
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   290: aconst_null
    //   291: astore 9
    //   293: goto -285 -> 8
    //   296: new 151	java/util/ArrayList
    //   299: dup
    //   300: invokespecial 152	java/util/ArrayList:<init>	()V
    //   303: astore 17
    //   305: ldc 154
    //   307: astore 11
    //   309: aload 9
    //   311: ldc 156
    //   313: invokevirtual 72	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   316: astore 18
    //   318: aload 18
    //   320: ifnull +72 -> 392
    //   323: aload 18
    //   325: ldc 158
    //   327: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   330: astore 12
    //   332: aload 18
    //   334: ldc 160
    //   336: invokevirtual 164	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   339: astore 18
    //   341: aload 12
    //   343: astore 11
    //   345: aload 18
    //   347: ifnull +45 -> 392
    //   350: iconst_0
    //   351: istore 7
    //   353: aload 12
    //   355: astore 11
    //   357: iload 7
    //   359: aload 18
    //   361: invokevirtual 170	org/json/JSONArray:length	()I
    //   364: if_icmpge +28 -> 392
    //   367: aload 17
    //   369: aload 18
    //   371: iload 7
    //   373: invokevirtual 174	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   376: checkcast 41	java/lang/String
    //   379: invokevirtual 178	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   382: pop
    //   383: iload 7
    //   385: iconst_1
    //   386: iadd
    //   387: istore 7
    //   389: goto -36 -> 353
    //   392: new 114	java/util/HashMap
    //   395: dup
    //   396: invokespecial 115	java/util/HashMap:<init>	()V
    //   399: astore 12
    //   401: aload 9
    //   403: ldc 180
    //   405: invokevirtual 72	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   408: astore 9
    //   410: aload 9
    //   412: ifnull +50 -> 462
    //   415: aload 9
    //   417: invokevirtual 121	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   420: astore 18
    //   422: aload 18
    //   424: invokeinterface 127 1 0
    //   429: ifeq +33 -> 462
    //   432: aload 18
    //   434: invokeinterface 131 1 0
    //   439: checkcast 41	java/lang/String
    //   442: astore 19
    //   444: aload 12
    //   446: aload 19
    //   448: aload 9
    //   450: aload 19
    //   452: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   455: invokevirtual 135	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   458: pop
    //   459: goto -37 -> 422
    //   462: new 151	java/util/ArrayList
    //   465: dup
    //   466: invokespecial 152	java/util/ArrayList:<init>	()V
    //   469: astore 9
    //   471: aload 9
    //   473: aload_1
    //   474: invokevirtual 178	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   477: pop
    //   478: invokestatic 185	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   481: aload 13
    //   483: putfield 188	cooperation/qzone/QZoneHelper$UserInfo:qzone_uin	Ljava/lang/String;
    //   486: aload 14
    //   488: aload 9
    //   490: iload 8
    //   492: aload 15
    //   494: aload 10
    //   496: aload 11
    //   498: aload 17
    //   500: aload 12
    //   502: aload 16
    //   504: ldc 190
    //   506: iconst_2
    //   507: invokestatic 196	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;ILcooperation/qzone/LbsDataV2$PoiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;I)V
    //   510: aload_2
    //   511: iconst_1
    //   512: aconst_null
    //   513: ldc 154
    //   515: invokeinterface 202 4 0
    //   520: return
    //   521: aload_2
    //   522: iconst_0
    //   523: aconst_null
    //   524: ldc 204
    //   526: invokeinterface 202 4 0
    //   531: return
    //   532: goto -469 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	QzonePublishPlugin
    //   0	535	1	paramJSONObject	org.json.JSONObject
    //   0	535	2	paramJSContext	com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext
    //   102	33	3	d1	double
    //   110	39	5	d2	double
    //   351	37	7	i	int
    //   70	421	8	j	int
    //   6	483	9	localObject1	Object
    //   79	416	10	localObject2	Object
    //   175	322	11	localObject3	Object
    //   219	282	12	localObject4	Object
    //   23	459	13	str1	String
    //   35	452	14	str2	String
    //   88	405	15	localPoiInfo	cooperation.qzone.LbsDataV2.PoiInfo
    //   198	305	16	localHashMap	java.util.HashMap
    //   241	258	17	localObject5	Object
    //   316	117	18	localObject6	Object
    //   442	9	19	str3	String
    // Exception table:
    //   from	to	target	type
    //   13	63	261	java/lang/Exception
    //   63	90	261	java/lang/Exception
    //   95	165	261	java/lang/Exception
    //   168	177	261	java/lang/Exception
    //   182	191	261	java/lang/Exception
    //   191	209	261	java/lang/Exception
    //   214	221	261	java/lang/Exception
    //   221	258	261	java/lang/Exception
    //   296	305	261	java/lang/Exception
    //   309	318	261	java/lang/Exception
    //   323	341	261	java/lang/Exception
    //   357	383	261	java/lang/Exception
    //   392	410	261	java/lang/Exception
    //   415	422	261	java/lang/Exception
    //   422	459	261	java/lang/Exception
    //   462	520	261	java/lang/Exception
    //   0	8	278	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.QzonePublishPlugin
 * JD-Core Version:    0.7.0.1
 */