package com.tencent.rmonitor.base.config.impl;

import android.content.SharedPreferences;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.config.PluginCombination.Companion;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.upload.QAPMUpload;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AsyncSPEditor;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/config/impl/ConfigApply;", "Lcom/tencent/rmonitor/base/upload/QAPMUpload;", "Lcom/tencent/rmonitor/base/config/impl/IConfigApply;", "url", "Ljava/net/URL;", "(Ljava/net/URL;)V", "applyUtil", "Lcom/tencent/rmonitor/base/config/impl/ConfigApplyUtil;", "configMd5", "", "dataJson", "Lorg/json/JSONObject;", "serviceSwitch", "", "userMode", "getDataJson", "getServiceSwitch", "loadConfigs", "loadServiceConfigs", "Lcom/tencent/rmonitor/base/config/impl/ConfigApply$LoadConfigMode;", "request", "", "Companion", "LoadConfigMode", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ConfigApply
  extends QAPMUpload
  implements IConfigApply
{
  public static final ConfigApply.Companion a = new ConfigApply.Companion(null);
  private final ConfigApplyUtil b = new ConfigApplyUtil();
  private String e = "";
  private JSONObject f;
  private int g;
  private int h = PluginCombination.a.c();
  
  public ConfigApply(@NotNull URL paramURL)
  {
    super(paramURL);
  }
  
  /* Error */
  private final ConfigApply.LoadConfigMode b(int paramInt)
  {
    // Byte code:
    //   0: getstatic 103	com/tencent/rmonitor/base/config/impl/ConfigApply$LoadConfigMode:NO_AUTHORITY	Lcom/tencent/rmonitor/base/config/impl/ConfigApply$LoadConfigMode;
    //   3: astore 11
    //   5: getstatic 108	com/tencent/rmonitor/base/meta/BaseInfo:token	Ljava/lang/String;
    //   8: checkcast 110	java/lang/CharSequence
    //   11: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +33 -> 47
    //   17: getstatic 121	com/tencent/rmonitor/base/authorization/AuthorizationProxy:a	Lcom/tencent/rmonitor/base/authorization/AuthorizationProxy;
    //   20: invokevirtual 124	com/tencent/rmonitor/base/authorization/AuthorizationProxy:a	()Lcom/tencent/rmonitor/base/authorization/Authorization;
    //   23: getstatic 128	com/tencent/rmonitor/base/meta/BaseInfo:userMeta	Lcom/tencent/rmonitor/base/meta/UserMeta;
    //   26: getfield 133	com/tencent/rmonitor/base/meta/UserMeta:appKey	Ljava/lang/String;
    //   29: iconst_1
    //   30: invokevirtual 138	com/tencent/rmonitor/base/authorization/Authorization:a	(Ljava/lang/String;Z)Z
    //   33: ifne +14 -> 47
    //   36: aload_0
    //   37: aconst_null
    //   38: checkcast 140	org/json/JSONObject
    //   41: putfield 142	com/tencent/rmonitor/base/config/impl/ConfigApply:f	Lorg/json/JSONObject;
    //   44: aload 11
    //   46: areturn
    //   47: invokestatic 148	android/os/SystemClock:elapsedRealtime	()J
    //   50: lstore 4
    //   52: new 150	java/util/HashMap
    //   55: dup
    //   56: invokespecial 151	java/util/HashMap:<init>	()V
    //   59: astore 12
    //   61: aload 12
    //   63: checkcast 153	java/util/Map
    //   66: astore 13
    //   68: aload 13
    //   70: ldc 155
    //   72: ldc 157
    //   74: invokeinterface 161 3 0
    //   79: pop
    //   80: aload 13
    //   82: ldc 163
    //   84: ldc 165
    //   86: invokeinterface 161 3 0
    //   91: pop
    //   92: aload 13
    //   94: ldc 167
    //   96: getstatic 108	com/tencent/rmonitor/base/meta/BaseInfo:token	Ljava/lang/String;
    //   99: invokeinterface 161 3 0
    //   104: pop
    //   105: aload_0
    //   106: aload 12
    //   108: invokevirtual 170	com/tencent/rmonitor/base/config/impl/ConfigApply:a	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   111: astore 15
    //   113: iconst_0
    //   114: istore 8
    //   116: iconst_0
    //   117: istore 9
    //   119: iconst_0
    //   120: istore 10
    //   122: iconst_0
    //   123: istore_2
    //   124: aload 15
    //   126: ifnull +798 -> 924
    //   129: aload_0
    //   130: getfield 76	com/tencent/rmonitor/base/config/impl/ConfigApply:b	Lcom/tencent/rmonitor/base/config/impl/ConfigApplyUtil;
    //   133: invokevirtual 172	com/tencent/rmonitor/base/config/impl/ConfigApplyUtil:b	()I
    //   136: istore_3
    //   137: new 140	org/json/JSONObject
    //   140: dup
    //   141: getstatic 128	com/tencent/rmonitor/base/meta/BaseInfo:userMeta	Lcom/tencent/rmonitor/base/meta/UserMeta;
    //   144: aconst_null
    //   145: aconst_null
    //   146: aconst_null
    //   147: aconst_null
    //   148: aconst_null
    //   149: aconst_null
    //   150: aconst_null
    //   151: aconst_null
    //   152: aconst_null
    //   153: aconst_null
    //   154: aconst_null
    //   155: aconst_null
    //   156: aconst_null
    //   157: sipush 8191
    //   160: aconst_null
    //   161: invokestatic 176	com/tencent/rmonitor/base/meta/UserMeta:copy$default	(Lcom/tencent/rmonitor/base/meta/UserMeta;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lcom/tencent/rmonitor/base/meta/UserMeta;
    //   164: invokevirtual 180	com/tencent/rmonitor/base/meta/UserMeta:toJSON	()Ljava/lang/String;
    //   167: invokespecial 183	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   170: astore 17
    //   172: aload 17
    //   174: ldc 185
    //   176: iload_1
    //   177: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   180: pop
    //   181: aload 17
    //   183: ldc 190
    //   185: aload_0
    //   186: getfield 76	com/tencent/rmonitor/base/config/impl/ConfigApply:b	Lcom/tencent/rmonitor/base/config/impl/ConfigApplyUtil;
    //   189: invokevirtual 192	com/tencent/rmonitor/base/config/impl/ConfigApplyUtil:a	()I
    //   192: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   195: pop
    //   196: aload 17
    //   198: ldc 194
    //   200: aload 17
    //   202: ldc 196
    //   204: invokevirtual 200	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   207: invokevirtual 203	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   210: pop
    //   211: aload 17
    //   213: ldc 205
    //   215: iload_3
    //   216: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   219: pop
    //   220: aload 17
    //   222: ldc 196
    //   224: invokevirtual 208	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   227: pop
    //   228: aload_0
    //   229: getfield 79	com/tencent/rmonitor/base/config/impl/ConfigApply:e	Ljava/lang/String;
    //   232: checkcast 110	java/lang/CharSequence
    //   235: invokeinterface 211 1 0
    //   240: ifle +745 -> 985
    //   243: iconst_1
    //   244: istore_1
    //   245: goto +3 -> 248
    //   248: iload_1
    //   249: ifeq +15 -> 264
    //   252: aload 17
    //   254: ldc 213
    //   256: aload_0
    //   257: getfield 79	com/tencent/rmonitor/base/config/impl/ConfigApply:e	Ljava/lang/String;
    //   260: invokevirtual 203	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   263: pop
    //   264: getstatic 218	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   267: astore 12
    //   269: aload 17
    //   271: invokevirtual 221	org/json/JSONObject:toString	()Ljava/lang/String;
    //   274: astore 13
    //   276: aload 13
    //   278: ldc 223
    //   280: invokestatic 226	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   283: aload 12
    //   285: iconst_2
    //   286: anewarray 228	java/lang/String
    //   289: dup
    //   290: iconst_0
    //   291: ldc 230
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: aload 13
    //   298: aastore
    //   299: invokevirtual 234	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   302: new 236	java/util/zip/GZIPOutputStream
    //   305: dup
    //   306: new 238	java/io/DataOutputStream
    //   309: dup
    //   310: aload 15
    //   312: invokevirtual 244	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   315: invokespecial 247	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   318: checkcast 249	java/io/OutputStream
    //   321: invokespecial 250	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   324: checkcast 252	java/io/Closeable
    //   327: astore 14
    //   329: aconst_null
    //   330: checkcast 98	java/lang/Throwable
    //   333: astore 13
    //   335: aload 13
    //   337: astore 12
    //   339: aload 14
    //   341: checkcast 236	java/util/zip/GZIPOutputStream
    //   344: astore 16
    //   346: aload 13
    //   348: astore 12
    //   350: aload 17
    //   352: invokevirtual 221	org/json/JSONObject:toString	()Ljava/lang/String;
    //   355: astore 17
    //   357: aload 13
    //   359: astore 12
    //   361: aload 17
    //   363: ldc 223
    //   365: invokestatic 226	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   368: aload 13
    //   370: astore 12
    //   372: ldc 254
    //   374: invokestatic 260	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   377: astore 18
    //   379: aload 13
    //   381: astore 12
    //   383: aload 18
    //   385: ldc_w 262
    //   388: invokestatic 226	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   391: aload 17
    //   393: ifnull +411 -> 804
    //   396: aload 13
    //   398: astore 12
    //   400: aload 17
    //   402: aload 18
    //   404: invokevirtual 266	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   407: astore 17
    //   409: aload 13
    //   411: astore 12
    //   413: aload 17
    //   415: ldc_w 268
    //   418: invokestatic 226	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   421: aload 13
    //   423: astore 12
    //   425: aload 16
    //   427: aload 17
    //   429: invokevirtual 272	java/util/zip/GZIPOutputStream:write	([B)V
    //   432: aload 13
    //   434: astore 12
    //   436: aload 16
    //   438: invokevirtual 275	java/util/zip/GZIPOutputStream:finish	()V
    //   441: aload 13
    //   443: astore 12
    //   445: getstatic 281	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   448: astore 16
    //   450: aload 14
    //   452: aload 13
    //   454: invokestatic 287	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   457: aload 15
    //   459: invokevirtual 290	java/net/HttpURLConnection:getResponseCode	()I
    //   462: istore_1
    //   463: iload_1
    //   464: sipush 200
    //   467: if_icmpne +276 -> 743
    //   470: new 292	java/io/BufferedInputStream
    //   473: dup
    //   474: aload 15
    //   476: invokevirtual 296	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   479: invokespecial 299	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   482: checkcast 252	java/io/Closeable
    //   485: astore 16
    //   487: aconst_null
    //   488: checkcast 98	java/lang/Throwable
    //   491: astore 13
    //   493: aload 16
    //   495: checkcast 292	java/io/BufferedInputStream
    //   498: astore 12
    //   500: getstatic 304	com/tencent/rmonitor/common/util/FileUtil:a	Lcom/tencent/rmonitor/common/util/FileUtil$Companion;
    //   503: aload 12
    //   505: checkcast 306	java/io/InputStream
    //   508: sipush 8192
    //   511: invokevirtual 311	com/tencent/rmonitor/common/util/FileUtil$Companion:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   514: astore 14
    //   516: getstatic 218	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   519: astore 17
    //   521: aload 13
    //   523: astore 12
    //   525: aload 17
    //   527: iconst_2
    //   528: anewarray 228	java/lang/String
    //   531: dup
    //   532: iconst_0
    //   533: ldc 230
    //   535: aastore
    //   536: dup
    //   537: iconst_1
    //   538: aload 14
    //   540: aastore
    //   541: invokevirtual 234	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   544: aload 13
    //   546: astore 12
    //   548: getstatic 281	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   551: astore 17
    //   553: aload 16
    //   555: aload 13
    //   557: invokestatic 287	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   560: new 140	org/json/JSONObject
    //   563: dup
    //   564: aload 14
    //   566: invokespecial 183	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   569: astore 12
    //   571: aload_0
    //   572: aload 12
    //   574: ldc_w 313
    //   577: invokevirtual 317	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   580: putfield 92	com/tencent/rmonitor/base/config/impl/ConfigApply:h	I
    //   583: aload 12
    //   585: ldc_w 319
    //   588: invokevirtual 317	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   591: sipush 1000
    //   594: if_icmpne +51 -> 645
    //   597: aload 12
    //   599: ldc_w 321
    //   602: invokevirtual 325	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   605: astore 13
    //   607: aload 13
    //   609: ldc_w 327
    //   612: invokestatic 226	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   615: aload_0
    //   616: aload 13
    //   618: putfield 79	com/tencent/rmonitor/base/config/impl/ConfigApply:e	Ljava/lang/String;
    //   621: aload_0
    //   622: aload 12
    //   624: ldc_w 329
    //   627: invokevirtual 333	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   630: putfield 142	com/tencent/rmonitor/base/config/impl/ConfigApply:f	Lorg/json/JSONObject;
    //   633: getstatic 336	com/tencent/rmonitor/base/config/impl/ConfigApply$LoadConfigMode:FROM_SERVICE	Lcom/tencent/rmonitor/base/config/impl/ConfigApply$LoadConfigMode;
    //   636: astore 12
    //   638: aload 12
    //   640: astore 11
    //   642: goto +20 -> 662
    //   645: aload_0
    //   646: aconst_null
    //   647: checkcast 140	org/json/JSONObject
    //   650: putfield 142	com/tencent/rmonitor/base/config/impl/ConfigApply:f	Lorg/json/JSONObject;
    //   653: getstatic 339	com/tencent/rmonitor/base/config/impl/ConfigApply$LoadConfigMode:FROM_LOCAL	Lcom/tencent/rmonitor/base/config/impl/ConfigApply$LoadConfigMode;
    //   656: astore 12
    //   658: aload 12
    //   660: astore 11
    //   662: iconst_1
    //   663: istore 8
    //   665: iload_2
    //   666: istore_1
    //   667: goto +98 -> 765
    //   670: astore 12
    //   672: goto +10 -> 682
    //   675: astore 12
    //   677: goto +26 -> 703
    //   680: astore 12
    //   682: aload 12
    //   684: astore 13
    //   686: aload 13
    //   688: astore 12
    //   690: aload 13
    //   692: athrow
    //   693: astore 14
    //   695: aload 12
    //   697: astore 13
    //   699: aload 14
    //   701: astore 12
    //   703: aload 16
    //   705: aload 13
    //   707: invokestatic 287	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   710: aload 12
    //   712: athrow
    //   713: astore 12
    //   715: goto +10 -> 725
    //   718: astore 12
    //   720: goto +15 -> 735
    //   723: astore 12
    //   725: iconst_0
    //   726: istore_1
    //   727: iconst_1
    //   728: istore 8
    //   730: goto +122 -> 852
    //   733: astore 12
    //   735: iconst_0
    //   736: istore_1
    //   737: iconst_1
    //   738: istore 8
    //   740: goto +140 -> 880
    //   743: aload 15
    //   745: invokevirtual 290	java/net/HttpURLConnection:getResponseCode	()I
    //   748: istore_1
    //   749: aload_0
    //   750: aconst_null
    //   751: checkcast 140	org/json/JSONObject
    //   754: putfield 142	com/tencent/rmonitor/base/config/impl/ConfigApply:f	Lorg/json/JSONObject;
    //   757: getstatic 339	com/tencent/rmonitor/base/config/impl/ConfigApply$LoadConfigMode:FROM_LOCAL	Lcom/tencent/rmonitor/base/config/impl/ConfigApply$LoadConfigMode;
    //   760: astore 12
    //   762: iconst_0
    //   763: istore 8
    //   765: aload_0
    //   766: getfield 76	com/tencent/rmonitor/base/config/impl/ConfigApply:b	Lcom/tencent/rmonitor/base/config/impl/ConfigApplyUtil;
    //   769: iload_3
    //   770: aload_0
    //   771: getfield 92	com/tencent/rmonitor/base/config/impl/ConfigApply:h	I
    //   774: invokevirtual 342	com/tencent/rmonitor/base/config/impl/ConfigApplyUtil:a	(II)V
    //   777: goto +153 -> 930
    //   780: astore 12
    //   782: goto +70 -> 852
    //   785: astore 12
    //   787: goto +93 -> 880
    //   790: astore 12
    //   792: goto +60 -> 852
    //   795: astore 12
    //   797: iload 9
    //   799: istore 8
    //   801: goto +79 -> 880
    //   804: aload 13
    //   806: astore 12
    //   808: new 344	kotlin/TypeCastException
    //   811: dup
    //   812: ldc_w 346
    //   815: invokespecial 347	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   818: athrow
    //   819: astore 13
    //   821: goto +12 -> 833
    //   824: astore 13
    //   826: aload 13
    //   828: astore 12
    //   830: aload 13
    //   832: athrow
    //   833: aload 14
    //   835: aload 12
    //   837: invokestatic 287	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   840: aload 13
    //   842: athrow
    //   843: astore 11
    //   845: goto +66 -> 911
    //   848: astore 12
    //   850: iconst_0
    //   851: istore_1
    //   852: getstatic 218	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   855: ldc 230
    //   857: aload 12
    //   859: invokevirtual 350	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   862: iload_1
    //   863: istore_2
    //   864: aload 11
    //   866: astore 12
    //   868: iload 8
    //   870: istore 9
    //   872: aload 15
    //   874: ifnull +86 -> 960
    //   877: goto +68 -> 945
    //   880: getstatic 218	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   883: ldc 230
    //   885: aload 12
    //   887: checkcast 98	java/lang/Throwable
    //   890: invokevirtual 350	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   893: iload_1
    //   894: istore_2
    //   895: aload 11
    //   897: astore 12
    //   899: iload 8
    //   901: istore 9
    //   903: aload 15
    //   905: ifnull +55 -> 960
    //   908: goto +37 -> 945
    //   911: aload 15
    //   913: ifnull +8 -> 921
    //   916: aload 15
    //   918: invokevirtual 353	java/net/HttpURLConnection:disconnect	()V
    //   921: aload 11
    //   923: athrow
    //   924: iconst_0
    //   925: istore_1
    //   926: iload 10
    //   928: istore 8
    //   930: iload_1
    //   931: istore_2
    //   932: aload 11
    //   934: astore 12
    //   936: iload 8
    //   938: istore 9
    //   940: aload 15
    //   942: ifnull +18 -> 960
    //   945: aload 15
    //   947: invokevirtual 353	java/net/HttpURLConnection:disconnect	()V
    //   950: iload 8
    //   952: istore 9
    //   954: aload 11
    //   956: astore 12
    //   958: iload_1
    //   959: istore_2
    //   960: invokestatic 148	android/os/SystemClock:elapsedRealtime	()J
    //   963: lstore 6
    //   965: invokestatic 358	com/tencent/rmonitor/sla/AttaReporter:a	()Lcom/tencent/rmonitor/sla/AttaReporter;
    //   968: ldc_w 360
    //   971: iload 9
    //   973: iload_2
    //   974: lload 6
    //   976: lload 4
    //   978: lsub
    //   979: invokevirtual 363	com/tencent/rmonitor/sla/AttaReporter:a	(Ljava/lang/String;ZIJ)V
    //   982: aload 12
    //   984: areturn
    //   985: iconst_0
    //   986: istore_1
    //   987: goto -739 -> 248
    //   990: astore 12
    //   992: iconst_0
    //   993: istore_1
    //   994: iload 9
    //   996: istore 8
    //   998: goto -118 -> 880
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1001	0	this	ConfigApply
    //   0	1001	1	paramInt	int
    //   123	851	2	i	int
    //   136	634	3	j	int
    //   50	927	4	l1	long
    //   963	12	6	l2	long
    //   114	883	8	bool1	boolean
    //   117	878	9	bool2	boolean
    //   120	807	10	bool3	boolean
    //   3	658	11	localObject1	Object
    //   843	112	11	localObject2	Object
    //   59	600	12	localObject3	Object
    //   670	1	12	localThrowable1	Throwable
    //   675	1	12	localObject4	Object
    //   680	3	12	localThrowable2	Throwable
    //   688	23	12	localObject5	Object
    //   713	1	12	localThrowable3	Throwable
    //   718	1	12	localJSONException1	org.json.JSONException
    //   723	1	12	localThrowable4	Throwable
    //   733	1	12	localJSONException2	org.json.JSONException
    //   760	1	12	localLoadConfigMode	ConfigApply.LoadConfigMode
    //   780	1	12	localThrowable5	Throwable
    //   785	1	12	localJSONException3	org.json.JSONException
    //   790	1	12	localThrowable6	Throwable
    //   795	1	12	localJSONException4	org.json.JSONException
    //   806	30	12	localObject6	Object
    //   848	10	12	localThrowable7	Throwable
    //   866	117	12	localObject7	Object
    //   990	1	12	localJSONException5	org.json.JSONException
    //   66	739	13	localObject8	Object
    //   819	1	13	localObject9	Object
    //   824	17	13	localThrowable8	Throwable
    //   327	238	14	localObject10	Object
    //   693	141	14	localCloseable	java.io.Closeable
    //   111	835	15	localHttpURLConnection	java.net.HttpURLConnection
    //   344	360	16	localObject11	Object
    //   170	382	17	localObject12	Object
    //   377	26	18	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   525	544	670	java/lang/Throwable
    //   548	553	670	java/lang/Throwable
    //   493	521	675	finally
    //   493	521	680	java/lang/Throwable
    //   525	544	693	finally
    //   548	553	693	finally
    //   690	693	693	finally
    //   553	638	713	java/lang/Throwable
    //   645	658	713	java/lang/Throwable
    //   703	713	713	java/lang/Throwable
    //   553	638	718	org/json/JSONException
    //   645	658	718	org/json/JSONException
    //   703	713	718	org/json/JSONException
    //   470	493	723	java/lang/Throwable
    //   470	493	733	org/json/JSONException
    //   765	777	780	java/lang/Throwable
    //   765	777	785	org/json/JSONException
    //   749	762	790	java/lang/Throwable
    //   749	762	795	org/json/JSONException
    //   339	346	819	finally
    //   350	357	819	finally
    //   361	368	819	finally
    //   372	379	819	finally
    //   383	391	819	finally
    //   400	409	819	finally
    //   413	421	819	finally
    //   425	432	819	finally
    //   436	441	819	finally
    //   445	450	819	finally
    //   808	819	819	finally
    //   830	833	819	finally
    //   339	346	824	java/lang/Throwable
    //   350	357	824	java/lang/Throwable
    //   361	368	824	java/lang/Throwable
    //   372	379	824	java/lang/Throwable
    //   383	391	824	java/lang/Throwable
    //   400	409	824	java/lang/Throwable
    //   413	421	824	java/lang/Throwable
    //   425	432	824	java/lang/Throwable
    //   436	441	824	java/lang/Throwable
    //   445	450	824	java/lang/Throwable
    //   808	819	824	java/lang/Throwable
    //   129	243	843	finally
    //   252	264	843	finally
    //   264	335	843	finally
    //   450	463	843	finally
    //   470	493	843	finally
    //   553	638	843	finally
    //   645	658	843	finally
    //   703	713	843	finally
    //   743	749	843	finally
    //   749	762	843	finally
    //   765	777	843	finally
    //   833	843	843	finally
    //   852	862	843	finally
    //   880	893	843	finally
    //   129	243	848	java/lang/Throwable
    //   252	264	848	java/lang/Throwable
    //   264	335	848	java/lang/Throwable
    //   450	463	848	java/lang/Throwable
    //   743	749	848	java/lang/Throwable
    //   833	843	848	java/lang/Throwable
    //   129	243	990	org/json/JSONException
    //   252	264	990	org/json/JSONException
    //   264	335	990	org/json/JSONException
    //   450	463	990	org/json/JSONException
    //   743	749	990	org/json/JSONException
    //   833	843	990	org/json/JSONException
  }
  
  public int a()
  {
    return this.h;
  }
  
  public int a(int paramInt)
  {
    this.g = paramInt;
    PluginController.b.c();
    for (;;)
    {
      try
      {
        Object localObject = BaseInfo.sharePreference;
        if (localObject == null) {
          break label144;
        }
        localObject = ((SharedPreferences)localObject).getString("rmonitor_config_data_md5", "");
        if (localObject == null) {
          break label144;
        }
        this.e = ((String)localObject);
        localObject = b(paramInt);
        paramInt = ConfigApply.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt == 3)
            {
              BaseInfo.editor.a("rmonitor_config_data_md5", this.e).b();
              return 1;
            }
          }
          else
          {
            this.f = ((JSONObject)null);
            return 2;
          }
        }
        else
        {
          this.h = 0;
          this.f = ((JSONObject)null);
          return 3;
        }
      }
      catch (Throwable localThrowable)
      {
        this.h = 0;
        this.f = ((JSONObject)null);
        Logger.b.a("RMonitor_config_ConfigApply", localThrowable);
      }
      return 4;
      label144:
      String str = "";
    }
  }
  
  @Nullable
  public JSONObject b()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.impl.ConfigApply
 * JD-Core Version:    0.7.0.1
 */