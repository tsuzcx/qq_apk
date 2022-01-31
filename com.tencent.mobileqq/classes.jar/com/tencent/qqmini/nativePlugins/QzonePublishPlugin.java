package com.tencent.qqmini.nativePlugins;

import bgkd;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QzonePublishPlugin
  extends BaseJsPlugin
{
  public static final String API_NAVIGATE_TO_PUBLISH_PROGRAM = "checkin_qzoneUploadAndPublish";
  private static final String TAG = "[mini] QzonePublishPlugin";
  
  private JSONObject getParam(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("[mini] QzonePublishPlugin", "Failed to parse jsonParams=" + parambgkd.b);
    }
    return null;
  }
  
  /* Error */
  public void checkinQzoneUploadAndPublish(bgkd parambgkd)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 57	com/tencent/qqmini/nativePlugins/QzonePublishPlugin:getParam	(Lbgkd;)Lorg/json/JSONObject;
    //   5: ldc 59
    //   7: invokevirtual 63	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10: astore 9
    //   12: aload 9
    //   14: ifnull +512 -> 526
    //   17: aload 9
    //   19: ldc 65
    //   21: invokevirtual 69	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast 71	java/lang/String
    //   27: astore 13
    //   29: aload 9
    //   31: ldc 73
    //   33: invokevirtual 69	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: checkcast 71	java/lang/String
    //   39: astore 14
    //   41: aload 9
    //   43: ldc 75
    //   45: invokevirtual 69	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: checkcast 71	java/lang/String
    //   51: astore 8
    //   53: aload 8
    //   55: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +476 -> 534
    //   61: invokestatic 87	bgjm:a	()Lbgjm;
    //   64: aload 8
    //   66: invokevirtual 90	bgjm:a	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 8
    //   71: aload 9
    //   73: ldc 92
    //   75: invokevirtual 96	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   78: istore 7
    //   80: aload 9
    //   82: ldc 98
    //   84: invokevirtual 101	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   87: astore 10
    //   89: new 103	cooperation/qzone/LbsDataV2$PoiInfo
    //   92: dup
    //   93: invokespecial 104	cooperation/qzone/LbsDataV2$PoiInfo:<init>	()V
    //   96: astore 15
    //   98: aload 10
    //   100: ifnull +73 -> 173
    //   103: aload 10
    //   105: ldc 106
    //   107: invokevirtual 110	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   110: dstore_2
    //   111: aload 10
    //   113: ldc 112
    //   115: invokevirtual 110	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   118: dstore 4
    //   120: aload 10
    //   122: ldc 114
    //   124: invokevirtual 96	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   127: pop
    //   128: aload 10
    //   130: ldc 116
    //   132: invokevirtual 119	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 10
    //   137: aload 15
    //   139: getfield 123	cooperation/qzone/LbsDataV2$PoiInfo:gpsInfo	Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   142: dload_2
    //   143: ldc2_w 124
    //   146: dmul
    //   147: d2i
    //   148: putfield 131	cooperation/qzone/LbsDataV2$GpsInfo:lon	I
    //   151: aload 15
    //   153: getfield 123	cooperation/qzone/LbsDataV2$PoiInfo:gpsInfo	Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   156: dload 4
    //   158: ldc2_w 124
    //   161: dmul
    //   162: d2i
    //   163: putfield 134	cooperation/qzone/LbsDataV2$GpsInfo:lat	I
    //   166: aload 15
    //   168: aload 10
    //   170: putfield 137	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   173: aconst_null
    //   174: astore 10
    //   176: aload 9
    //   178: ldc 139
    //   180: invokevirtual 101	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   183: astore 11
    //   185: aload 11
    //   187: ifnull +12 -> 199
    //   190: aload 11
    //   192: ldc 141
    //   194: invokevirtual 119	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   197: astore 10
    //   199: new 143	java/util/HashMap
    //   202: dup
    //   203: invokespecial 144	java/util/HashMap:<init>	()V
    //   206: astore 16
    //   208: aload 9
    //   210: ldc 146
    //   212: invokevirtual 101	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   215: astore 11
    //   217: aload 11
    //   219: ifnull +87 -> 306
    //   222: aload 11
    //   224: invokevirtual 150	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   227: astore 12
    //   229: aload 12
    //   231: invokeinterface 156 1 0
    //   236: ifeq +70 -> 306
    //   239: aload 12
    //   241: invokeinterface 160 1 0
    //   246: checkcast 71	java/lang/String
    //   249: astore 17
    //   251: aload 16
    //   253: aload 17
    //   255: aload 11
    //   257: aload 17
    //   259: invokevirtual 119	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   262: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: pop
    //   266: goto -37 -> 229
    //   269: astore_1
    //   270: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +12 -> 285
    //   276: ldc 11
    //   278: iconst_2
    //   279: ldc 171
    //   281: aload_1
    //   282: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: return
    //   286: astore 8
    //   288: ldc 11
    //   290: iconst_1
    //   291: aload 8
    //   293: iconst_0
    //   294: anewarray 176	java/lang/Object
    //   297: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   300: aconst_null
    //   301: astore 9
    //   303: goto -291 -> 12
    //   306: new 181	java/util/ArrayList
    //   309: dup
    //   310: invokespecial 182	java/util/ArrayList:<init>	()V
    //   313: astore 17
    //   315: aconst_null
    //   316: astore 11
    //   318: aload 9
    //   320: ldc 184
    //   322: invokevirtual 101	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   325: astore 18
    //   327: aload 18
    //   329: ifnull +72 -> 401
    //   332: aload 18
    //   334: ldc 186
    //   336: invokevirtual 119	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   339: astore 12
    //   341: aload 18
    //   343: ldc 188
    //   345: invokevirtual 192	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   348: astore 18
    //   350: aload 12
    //   352: astore 11
    //   354: aload 18
    //   356: ifnull +45 -> 401
    //   359: iconst_0
    //   360: istore 6
    //   362: aload 12
    //   364: astore 11
    //   366: iload 6
    //   368: aload 18
    //   370: invokevirtual 198	org/json/JSONArray:length	()I
    //   373: if_icmpge +28 -> 401
    //   376: aload 17
    //   378: aload 18
    //   380: iload 6
    //   382: invokevirtual 202	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   385: checkcast 71	java/lang/String
    //   388: invokevirtual 206	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   391: pop
    //   392: iload 6
    //   394: iconst_1
    //   395: iadd
    //   396: istore 6
    //   398: goto -36 -> 362
    //   401: new 143	java/util/HashMap
    //   404: dup
    //   405: invokespecial 144	java/util/HashMap:<init>	()V
    //   408: astore 12
    //   410: aload 9
    //   412: ldc 208
    //   414: invokevirtual 101	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   417: astore 9
    //   419: aload 9
    //   421: ifnull +50 -> 471
    //   424: aload 9
    //   426: invokevirtual 150	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   429: astore 18
    //   431: aload 18
    //   433: invokeinterface 156 1 0
    //   438: ifeq +33 -> 471
    //   441: aload 18
    //   443: invokeinterface 160 1 0
    //   448: checkcast 71	java/lang/String
    //   451: astore 19
    //   453: aload 12
    //   455: aload 19
    //   457: aload 9
    //   459: aload 19
    //   461: invokevirtual 119	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   464: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   467: pop
    //   468: goto -37 -> 431
    //   471: new 181	java/util/ArrayList
    //   474: dup
    //   475: invokespecial 182	java/util/ArrayList:<init>	()V
    //   478: astore 9
    //   480: aload 9
    //   482: aload 8
    //   484: invokevirtual 206	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   487: pop
    //   488: invokestatic 213	bizt:a	()Lbizt;
    //   491: aload 13
    //   493: putfield 215	bizt:a	Ljava/lang/String;
    //   496: aload 14
    //   498: aload 9
    //   500: iload 7
    //   502: aload 15
    //   504: aload 10
    //   506: aload 11
    //   508: aload 17
    //   510: aload 12
    //   512: aload 16
    //   514: ldc 217
    //   516: iconst_2
    //   517: invokestatic 222	bizm:a	(Ljava/lang/String;Ljava/util/ArrayList;ILcooperation/qzone/LbsDataV2$PoiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;I)V
    //   520: aload_1
    //   521: invokevirtual 224	bgkd:a	()Ljava/lang/String;
    //   524: pop
    //   525: return
    //   526: aload_1
    //   527: ldc 226
    //   529: invokevirtual 227	bgkd:a	(Ljava/lang/String;)Ljava/lang/String;
    //   532: pop
    //   533: return
    //   534: goto -463 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	QzonePublishPlugin
    //   0	537	1	parambgkd	bgkd
    //   110	33	2	d1	double
    //   118	39	4	d2	double
    //   360	37	6	i	int
    //   78	423	7	j	int
    //   51	19	8	str1	String
    //   286	197	8	localThrowable	java.lang.Throwable
    //   10	489	9	localObject1	java.lang.Object
    //   87	418	10	localObject2	java.lang.Object
    //   183	324	11	localObject3	java.lang.Object
    //   227	284	12	localObject4	java.lang.Object
    //   27	465	13	str2	String
    //   39	458	14	str3	String
    //   96	407	15	localPoiInfo	cooperation.qzone.LbsDataV2.PoiInfo
    //   206	307	16	localHashMap	java.util.HashMap
    //   249	260	17	localObject5	java.lang.Object
    //   325	117	18	localObject6	java.lang.Object
    //   451	9	19	str4	String
    // Exception table:
    //   from	to	target	type
    //   17	71	269	java/lang/Exception
    //   71	98	269	java/lang/Exception
    //   103	173	269	java/lang/Exception
    //   176	185	269	java/lang/Exception
    //   190	199	269	java/lang/Exception
    //   199	217	269	java/lang/Exception
    //   222	229	269	java/lang/Exception
    //   229	266	269	java/lang/Exception
    //   306	315	269	java/lang/Exception
    //   318	327	269	java/lang/Exception
    //   332	350	269	java/lang/Exception
    //   366	392	269	java/lang/Exception
    //   401	419	269	java/lang/Exception
    //   424	431	269	java/lang/Exception
    //   431	468	269	java/lang/Exception
    //   471	525	269	java/lang/Exception
    //   0	12	286	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.QzonePublishPlugin
 * JD-Core Version:    0.7.0.1
 */