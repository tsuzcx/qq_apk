package com.tencent.rmonitor.base.authorization;

import android.content.SharedPreferences;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.upload.QAPMUpload;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AsyncSPEditor;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/authorization/Authorization;", "Lcom/tencent/rmonitor/base/upload/QAPMUpload;", "url", "Ljava/net/URL;", "(Ljava/net/URL;)V", "appKey", "", "getToken", "", "local", "readTokenFromLocal", "readTokenFromServer", "request", "", "writeTokenToLocal", "token", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class Authorization
  extends QAPMUpload
{
  public static final Authorization.Companion a = new Authorization.Companion(null);
  private String b = "";
  
  public Authorization(@NotNull URL paramURL)
  {
    super(paramURL);
  }
  
  private final void a(String paramString)
  {
    if (BaseInfo.sharePreference != null) {
      BaseInfo.editor.a("token", paramString).b();
    }
  }
  
  private final boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (BaseInfo.sharePreference == null) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = BaseInfo.sharePreference;
        if (localObject == null) {
          break label77;
        }
        localObject = ((SharedPreferences)localObject).getString("token", "");
        if (localObject == null) {
          break label77;
        }
        BaseInfo.token = (String)localObject;
        int i = ((CharSequence)BaseInfo.token).length();
        if (i > 0) {
          return true;
        }
      }
      catch (Exception localException)
      {
        Logger.b.a("RMonitor_base_Authorization", "readTokenFromLocal", (Throwable)localException);
      }
      return false;
      label77:
      String str = "";
    }
  }
  
  /* Error */
  private final boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 116	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aload_1
    //   5: checkcast 92	java/lang/CharSequence
    //   8: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +793 -> 804
    //   14: aload_0
    //   15: invokevirtual 126	com/tencent/rmonitor/base/authorization/Authorization:e	()Ljava/net/URL;
    //   18: invokevirtual 132	java/net/URL:toString	()Ljava/lang/String;
    //   21: astore 8
    //   23: aload 8
    //   25: ldc 134
    //   27: invokestatic 137	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   30: aload 8
    //   32: checkcast 92	java/lang/CharSequence
    //   35: invokeinterface 96 1 0
    //   40: ifne +8 -> 48
    //   43: iconst_1
    //   44: istore_2
    //   45: goto +5 -> 50
    //   48: iconst_0
    //   49: istore_2
    //   50: iload_2
    //   51: ifeq +6 -> 57
    //   54: goto +750 -> 804
    //   57: new 139	java/util/HashMap
    //   60: dup
    //   61: invokespecial 141	java/util/HashMap:<init>	()V
    //   64: astore_1
    //   65: aload_1
    //   66: checkcast 143	java/util/Map
    //   69: ldc 145
    //   71: ldc 147
    //   73: invokeinterface 151 3 0
    //   78: pop
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 154	com/tencent/rmonitor/base/authorization/Authorization:a	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   84: astore 10
    //   86: aload 10
    //   88: ifnull +589 -> 677
    //   91: getstatic 158	com/tencent/rmonitor/base/meta/BaseInfo:pubJson	Lorg/json/JSONObject;
    //   94: astore_1
    //   95: new 160	java/lang/StringBuffer
    //   98: dup
    //   99: sipush 1024
    //   102: invokespecial 163	java/lang/StringBuffer:<init>	(I)V
    //   105: astore 8
    //   107: aload_1
    //   108: invokevirtual 169	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   111: astore 9
    //   113: aload 9
    //   115: ldc 171
    //   117: invokestatic 137	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   120: aload 9
    //   122: invokeinterface 177 1 0
    //   127: ifeq +59 -> 186
    //   130: aload 9
    //   132: invokeinterface 181 1 0
    //   137: checkcast 183	java/lang/String
    //   140: astore 11
    //   142: aload 8
    //   144: ldc 185
    //   146: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   149: pop
    //   150: aload 8
    //   152: aload 11
    //   154: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   157: pop
    //   158: aload 8
    //   160: ldc 191
    //   162: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   165: pop
    //   166: aload 8
    //   168: aload_1
    //   169: aload 11
    //   171: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: ldc 196
    //   176: invokestatic 201	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   179: invokevirtual 189	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   182: pop
    //   183: goto -63 -> 120
    //   186: aload 8
    //   188: checkcast 92	java/lang/CharSequence
    //   191: invokeinterface 96 1 0
    //   196: ifne +681 -> 877
    //   199: iconst_1
    //   200: istore_2
    //   201: goto +3 -> 204
    //   204: iload_2
    //   205: ifeq +12 -> 217
    //   208: aload 8
    //   210: invokevirtual 202	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   213: astore_1
    //   214: goto +15 -> 229
    //   217: aload 8
    //   219: iconst_1
    //   220: aload 8
    //   222: invokevirtual 203	java/lang/StringBuffer:length	()I
    //   225: invokevirtual 207	java/lang/StringBuffer:substring	(II)Ljava/lang/String;
    //   228: astore_1
    //   229: aload_1
    //   230: ldc 209
    //   232: invokestatic 137	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   235: new 211	java/io/DataOutputStream
    //   238: dup
    //   239: aload 10
    //   241: invokevirtual 217	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   244: invokespecial 220	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   247: checkcast 222	java/io/Closeable
    //   250: astore 11
    //   252: aconst_null
    //   253: checkcast 106	java/lang/Throwable
    //   256: astore 9
    //   258: aload 9
    //   260: astore 8
    //   262: aload 11
    //   264: checkcast 211	java/io/DataOutputStream
    //   267: astore 12
    //   269: aload 9
    //   271: astore 8
    //   273: getstatic 228	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   276: astore 13
    //   278: aload_1
    //   279: ifnull +314 -> 593
    //   282: aload 9
    //   284: astore 8
    //   286: aload_1
    //   287: aload 13
    //   289: invokevirtual 232	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   292: astore 13
    //   294: aload 9
    //   296: astore 8
    //   298: aload 13
    //   300: ldc 234
    //   302: invokestatic 137	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   305: aload 9
    //   307: astore 8
    //   309: aload 12
    //   311: aload 13
    //   313: invokevirtual 238	java/io/DataOutputStream:write	([B)V
    //   316: aload 9
    //   318: astore 8
    //   320: aload 12
    //   322: invokevirtual 241	java/io/DataOutputStream:flush	()V
    //   325: aload 9
    //   327: astore 8
    //   329: getstatic 247	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   332: astore 12
    //   334: aload 11
    //   336: aload 9
    //   338: invokestatic 253	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   341: aload 10
    //   343: invokevirtual 256	java/net/HttpURLConnection:getResponseCode	()I
    //   346: sipush 200
    //   349: if_icmpne +128 -> 477
    //   352: new 165	org/json/JSONObject
    //   355: dup
    //   356: getstatic 261	com/tencent/rmonitor/common/util/FileUtil:a	Lcom/tencent/rmonitor/common/util/FileUtil$Companion;
    //   359: new 263	java/io/BufferedInputStream
    //   362: dup
    //   363: aload 10
    //   365: invokevirtual 267	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   368: invokespecial 270	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   371: checkcast 272	java/io/InputStream
    //   374: sipush 8192
    //   377: invokevirtual 277	com/tencent/rmonitor/common/util/FileUtil$Companion:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   380: invokespecial 279	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   383: ldc 72
    //   385: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   388: astore_1
    //   389: aload_1
    //   390: ldc_w 281
    //   393: invokestatic 137	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   396: aload_1
    //   397: putstatic 90	com/tencent/rmonitor/base/meta/BaseInfo:token	Ljava/lang/String;
    //   400: getstatic 101	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   403: astore_1
    //   404: new 283	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   411: astore 8
    //   413: aload 8
    //   415: ldc_w 286
    //   418: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 8
    //   424: aload_0
    //   425: invokevirtual 126	com/tencent/rmonitor/base/authorization/Authorization:e	()Ljava/net/URL;
    //   428: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 8
    //   434: ldc_w 294
    //   437: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 8
    //   443: getstatic 90	com/tencent/rmonitor/base/meta/BaseInfo:token	Ljava/lang/String;
    //   446: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload_1
    //   451: iconst_2
    //   452: anewarray 183	java/lang/String
    //   455: dup
    //   456: iconst_0
    //   457: ldc 103
    //   459: aastore
    //   460: dup
    //   461: iconst_1
    //   462: aload 8
    //   464: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: aastore
    //   468: invokevirtual 299	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   471: iconst_1
    //   472: istore 7
    //   474: goto +206 -> 680
    //   477: aload 10
    //   479: invokevirtual 256	java/net/HttpURLConnection:getResponseCode	()I
    //   482: istore_2
    //   483: getstatic 101	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   486: astore 8
    //   488: new 283	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   495: astore 9
    //   497: aload 9
    //   499: ldc_w 301
    //   502: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 9
    //   508: ldc_w 303
    //   511: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 9
    //   517: aload 10
    //   519: invokevirtual 256	java/net/HttpURLConnection:getResponseCode	()I
    //   522: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 9
    //   528: ldc_w 308
    //   531: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 9
    //   537: aload_0
    //   538: invokevirtual 126	com/tencent/rmonitor/base/authorization/Authorization:e	()Ljava/net/URL;
    //   541: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 9
    //   547: ldc_w 310
    //   550: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 9
    //   556: aload_1
    //   557: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 8
    //   563: iconst_2
    //   564: anewarray 183	java/lang/String
    //   567: dup
    //   568: iconst_0
    //   569: ldc 103
    //   571: aastore
    //   572: dup
    //   573: iconst_1
    //   574: aload 9
    //   576: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: aastore
    //   580: invokevirtual 299	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   583: iconst_0
    //   584: istore 7
    //   586: goto +96 -> 682
    //   589: astore_1
    //   590: goto +44 -> 634
    //   593: aload 9
    //   595: astore 8
    //   597: new 312	kotlin/TypeCastException
    //   600: dup
    //   601: ldc_w 314
    //   604: invokespecial 315	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   607: athrow
    //   608: astore_1
    //   609: goto +9 -> 618
    //   612: astore_1
    //   613: aload_1
    //   614: astore 8
    //   616: aload_1
    //   617: athrow
    //   618: aload 11
    //   620: aload 8
    //   622: invokestatic 253	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   625: aload_1
    //   626: athrow
    //   627: astore_1
    //   628: goto +37 -> 665
    //   631: astore_1
    //   632: iconst_0
    //   633: istore_2
    //   634: getstatic 101	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   637: ldc 103
    //   639: ldc_w 316
    //   642: aload_1
    //   643: checkcast 106	java/lang/Throwable
    //   646: invokevirtual 109	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   649: aload 10
    //   651: ifnull +8 -> 659
    //   654: aload 10
    //   656: invokevirtual 319	java/net/HttpURLConnection:disconnect	()V
    //   659: iconst_0
    //   660: istore 7
    //   662: goto +30 -> 692
    //   665: aload 10
    //   667: ifnull +8 -> 675
    //   670: aload 10
    //   672: invokevirtual 319	java/net/HttpURLConnection:disconnect	()V
    //   675: aload_1
    //   676: athrow
    //   677: iconst_0
    //   678: istore 7
    //   680: iconst_0
    //   681: istore_2
    //   682: aload 10
    //   684: ifnull +8 -> 692
    //   687: aload 10
    //   689: invokevirtual 319	java/net/HttpURLConnection:disconnect	()V
    //   692: getstatic 101	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   695: astore_1
    //   696: new 283	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   703: astore 8
    //   705: aload 8
    //   707: ldc_w 321
    //   710: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload 8
    //   716: iload 7
    //   718: invokevirtual 324	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload 8
    //   724: ldc_w 308
    //   727: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload 8
    //   733: aload_0
    //   734: invokevirtual 126	com/tencent/rmonitor/base/authorization/Authorization:e	()Ljava/net/URL;
    //   737: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload 8
    //   743: ldc_w 294
    //   746: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload 8
    //   752: getstatic 90	com/tencent/rmonitor/base/meta/BaseInfo:token	Ljava/lang/String;
    //   755: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload_1
    //   760: iconst_2
    //   761: anewarray 183	java/lang/String
    //   764: dup
    //   765: iconst_0
    //   766: ldc 103
    //   768: aastore
    //   769: dup
    //   770: iconst_1
    //   771: aload 8
    //   773: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: aastore
    //   777: invokevirtual 299	com/tencent/rmonitor/common/logger/Logger:i	([Ljava/lang/String;)V
    //   780: invokestatic 116	android/os/SystemClock:elapsedRealtime	()J
    //   783: lstore 5
    //   785: invokestatic 329	com/tencent/rmonitor/sla/AttaReporter:a	()Lcom/tencent/rmonitor/sla/AttaReporter;
    //   788: ldc_w 331
    //   791: iload 7
    //   793: iload_2
    //   794: lload 5
    //   796: lload_3
    //   797: lsub
    //   798: invokevirtual 334	com/tencent/rmonitor/sla/AttaReporter:a	(Ljava/lang/String;ZIJ)V
    //   801: iload 7
    //   803: ireturn
    //   804: getstatic 101	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   807: astore 8
    //   809: new 283	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   816: astore 9
    //   818: aload 9
    //   820: ldc_w 336
    //   823: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload 9
    //   829: aload_1
    //   830: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload 9
    //   836: ldc_w 338
    //   839: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload 9
    //   845: aload_0
    //   846: invokevirtual 126	com/tencent/rmonitor/base/authorization/Authorization:e	()Ljava/net/URL;
    //   849: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload 8
    //   855: iconst_2
    //   856: anewarray 183	java/lang/String
    //   859: dup
    //   860: iconst_0
    //   861: ldc 103
    //   863: aastore
    //   864: dup
    //   865: iconst_1
    //   866: aload 9
    //   868: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: aastore
    //   872: invokevirtual 340	com/tencent/rmonitor/common/logger/Logger:e	([Ljava/lang/String;)V
    //   875: iconst_0
    //   876: ireturn
    //   877: iconst_0
    //   878: istore_2
    //   879: goto -675 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	882	0	this	Authorization
    //   0	882	1	paramString	String
    //   44	835	2	i	int
    //   3	794	3	l1	long
    //   783	12	5	l2	long
    //   472	330	7	bool	boolean
    //   21	833	8	localObject1	Object
    //   111	756	9	localObject2	Object
    //   84	604	10	localHttpURLConnection	java.net.HttpURLConnection
    //   140	479	11	localObject3	Object
    //   267	66	12	localObject4	Object
    //   276	36	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   483	583	589	java/lang/Exception
    //   262	269	608	finally
    //   273	278	608	finally
    //   286	294	608	finally
    //   298	305	608	finally
    //   309	316	608	finally
    //   320	325	608	finally
    //   329	334	608	finally
    //   597	608	608	finally
    //   616	618	608	finally
    //   262	269	612	java/lang/Throwable
    //   273	278	612	java/lang/Throwable
    //   286	294	612	java/lang/Throwable
    //   298	305	612	java/lang/Throwable
    //   309	316	612	java/lang/Throwable
    //   320	325	612	java/lang/Throwable
    //   329	334	612	java/lang/Throwable
    //   597	608	612	java/lang/Throwable
    //   91	120	627	finally
    //   120	183	627	finally
    //   186	199	627	finally
    //   208	214	627	finally
    //   217	229	627	finally
    //   229	258	627	finally
    //   334	471	627	finally
    //   477	483	627	finally
    //   483	583	627	finally
    //   618	627	627	finally
    //   634	649	627	finally
    //   91	120	631	java/lang/Exception
    //   120	183	631	java/lang/Exception
    //   186	199	631	java/lang/Exception
    //   208	214	631	java/lang/Exception
    //   217	229	631	java/lang/Exception
    //   229	258	631	java/lang/Exception
    //   334	471	631	java/lang/Exception
    //   477	483	631	java/lang/Exception
    //   618	627	631	java/lang/Exception
  }
  
  public final boolean a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appKey");
    if (!a(paramBoolean)) {
      try
      {
        if (!b(paramString)) {
          return false;
        }
        a(BaseInfo.token);
      }
      catch (Exception paramString)
      {
        Logger.b.a("RMonitor_base_Authorization", (Throwable)paramString);
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.authorization.Authorization
 * JD-Core Version:    0.7.0.1
 */