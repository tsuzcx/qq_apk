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
    //   10: ifnull +510 -> 520
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
    //   52: ifne +479 -> 531
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
    //   305: aconst_null
    //   306: astore 11
    //   308: aload 9
    //   310: ldc 154
    //   312: invokevirtual 72	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   315: astore 18
    //   317: aload 18
    //   319: ifnull +72 -> 391
    //   322: aload 18
    //   324: ldc 156
    //   326: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: astore 12
    //   331: aload 18
    //   333: ldc 158
    //   335: invokevirtual 162	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   338: astore 18
    //   340: aload 12
    //   342: astore 11
    //   344: aload 18
    //   346: ifnull +45 -> 391
    //   349: iconst_0
    //   350: istore 7
    //   352: aload 12
    //   354: astore 11
    //   356: iload 7
    //   358: aload 18
    //   360: invokevirtual 168	org/json/JSONArray:length	()I
    //   363: if_icmpge +28 -> 391
    //   366: aload 17
    //   368: aload 18
    //   370: iload 7
    //   372: invokevirtual 172	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   375: checkcast 41	java/lang/String
    //   378: invokevirtual 176	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   381: pop
    //   382: iload 7
    //   384: iconst_1
    //   385: iadd
    //   386: istore 7
    //   388: goto -36 -> 352
    //   391: new 114	java/util/HashMap
    //   394: dup
    //   395: invokespecial 115	java/util/HashMap:<init>	()V
    //   398: astore 12
    //   400: aload 9
    //   402: ldc 178
    //   404: invokevirtual 72	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   407: astore 9
    //   409: aload 9
    //   411: ifnull +50 -> 461
    //   414: aload 9
    //   416: invokevirtual 121	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   419: astore 18
    //   421: aload 18
    //   423: invokeinterface 127 1 0
    //   428: ifeq +33 -> 461
    //   431: aload 18
    //   433: invokeinterface 131 1 0
    //   438: checkcast 41	java/lang/String
    //   441: astore 19
    //   443: aload 12
    //   445: aload 19
    //   447: aload 9
    //   449: aload 19
    //   451: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   454: invokevirtual 135	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   457: pop
    //   458: goto -37 -> 421
    //   461: new 151	java/util/ArrayList
    //   464: dup
    //   465: invokespecial 152	java/util/ArrayList:<init>	()V
    //   468: astore 9
    //   470: aload 9
    //   472: aload_1
    //   473: invokevirtual 176	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   476: pop
    //   477: invokestatic 184	bmtk:a	()Lbmtk;
    //   480: aload 13
    //   482: putfield 186	bmtk:a	Ljava/lang/String;
    //   485: aload 14
    //   487: aload 9
    //   489: iload 8
    //   491: aload 15
    //   493: aload 10
    //   495: aload 11
    //   497: aload 17
    //   499: aload 12
    //   501: aload 16
    //   503: ldc 188
    //   505: iconst_2
    //   506: invokestatic 193	bmtd:a	(Ljava/lang/String;Ljava/util/ArrayList;ILcooperation/qzone/LbsDataV2$PoiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;I)V
    //   509: aload_2
    //   510: iconst_1
    //   511: aconst_null
    //   512: ldc 195
    //   514: invokeinterface 201 4 0
    //   519: return
    //   520: aload_2
    //   521: iconst_0
    //   522: aconst_null
    //   523: ldc 203
    //   525: invokeinterface 201 4 0
    //   530: return
    //   531: goto -468 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	534	0	this	QzonePublishPlugin
    //   0	534	1	paramJSONObject	org.json.JSONObject
    //   0	534	2	paramJSContext	com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext
    //   102	33	3	d1	double
    //   110	39	5	d2	double
    //   350	37	7	i	int
    //   70	420	8	j	int
    //   6	482	9	localObject1	Object
    //   79	415	10	localObject2	Object
    //   175	321	11	localObject3	Object
    //   219	281	12	localObject4	Object
    //   23	458	13	str1	String
    //   35	451	14	str2	String
    //   88	404	15	localPoiInfo	cooperation.qzone.LbsDataV2.PoiInfo
    //   198	304	16	localHashMap	java.util.HashMap
    //   241	257	17	localObject5	Object
    //   315	117	18	localObject6	Object
    //   441	9	19	str3	String
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
    //   308	317	261	java/lang/Exception
    //   322	340	261	java/lang/Exception
    //   356	382	261	java/lang/Exception
    //   391	409	261	java/lang/Exception
    //   414	421	261	java/lang/Exception
    //   421	458	261	java/lang/Exception
    //   461	519	261	java/lang/Exception
    //   0	8	278	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.QzonePublishPlugin
 * JD-Core Version:    0.7.0.1
 */