package com.tencent.mobileqq.secspy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.unifiedebug.SnapshotResultReceiver;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugReporter;
import com.tencent.mobileqq.unifiedebug.UnifiedFileUtil;
import com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter.TraceRouteInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody;

public class SecSpyFileManager
  implements Manager
{
  private static final String d = HardCodeUtil.a(2131713604);
  private static final String e = HardCodeUtil.a(2131713603);
  public Handler a;
  public QQAppInterface a;
  public UnifiedDebugManager a;
  public UnifiedDebugReporter a;
  private Runnable a;
  public String a;
  public String b = "https://qprostat.imtt.qq.com/";
  public String c = ".mgz";
  
  public SecSpyFileManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "https://logic.content.qq.com/public/file_upload2?";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRunnable = new SecSpyFileManager.1(this);
    if (paramQQAppInterface.getApplication().getSharedPreferences("x5_proxy_setting", 4).getBoolean("is_in_proxy", false)) {
      ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 101	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   5: aload_1
    //   6: invokevirtual 106	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   12: astore 9
    //   14: aload 9
    //   16: ifnull +851 -> 867
    //   19: aload 9
    //   21: invokevirtual 115	java/io/File:exists	()Z
    //   24: ifeq +843 -> 867
    //   27: aload 9
    //   29: invokevirtual 118	java/io/File:isFile	()Z
    //   32: ifeq +835 -> 867
    //   35: aload_0
    //   36: lload_3
    //   37: iconst_2
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload 9
    //   46: invokevirtual 122	java/io/File:length	()J
    //   49: invokestatic 128	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: aastore
    //   53: invokevirtual 131	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: lload_3
    //   58: iconst_3
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: bipush 100
    //   67: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: invokevirtual 131	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   74: new 138	java/util/HashMap
    //   77: dup
    //   78: invokespecial 139	java/util/HashMap:<init>	()V
    //   81: astore 10
    //   83: aload 10
    //   85: ldc 141
    //   87: aload_2
    //   88: invokeinterface 147 3 0
    //   93: pop
    //   94: aload 10
    //   96: ldc 149
    //   98: ldc 151
    //   100: invokeinterface 147 3 0
    //   105: pop
    //   106: aload 10
    //   108: ldc 153
    //   110: ldc 155
    //   112: invokeinterface 147 3 0
    //   117: pop
    //   118: new 157	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   125: astore_1
    //   126: aload_1
    //   127: ldc 160
    //   129: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: aload_2
    //   135: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_1
    //   140: ldc 166
    //   142: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 10
    //   148: ldc 168
    //   150: aload_1
    //   151: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokeinterface 147 3 0
    //   159: pop
    //   160: aconst_null
    //   161: astore 7
    //   163: aconst_null
    //   164: astore_2
    //   165: aconst_null
    //   166: astore 8
    //   168: new 174	java/net/URL
    //   171: dup
    //   172: aload_0
    //   173: getfield 43	com/tencent/mobileqq/secspy/SecSpyFileManager:b	Ljava/lang/String;
    //   176: invokespecial 177	java/net/URL:<init>	(Ljava/lang/String;)V
    //   179: invokevirtual 181	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   182: checkcast 183	java/net/HttpURLConnection
    //   185: astore_1
    //   186: aload_1
    //   187: astore_2
    //   188: aload 7
    //   190: astore 5
    //   192: aload_1
    //   193: iconst_1
    //   194: invokevirtual 187	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   197: aload_1
    //   198: astore_2
    //   199: aload 7
    //   201: astore 5
    //   203: aload_1
    //   204: iconst_1
    //   205: invokevirtual 190	java/net/HttpURLConnection:setDoInput	(Z)V
    //   208: aload_1
    //   209: astore_2
    //   210: aload 7
    //   212: astore 5
    //   214: aload_1
    //   215: iconst_0
    //   216: invokevirtual 193	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   219: aload_1
    //   220: astore_2
    //   221: aload 7
    //   223: astore 5
    //   225: aload_1
    //   226: ldc 195
    //   228: invokevirtual 198	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   231: aload_1
    //   232: astore_2
    //   233: aload 7
    //   235: astore 5
    //   237: new 157	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   244: astore 11
    //   246: aload_1
    //   247: astore_2
    //   248: aload 7
    //   250: astore 5
    //   252: aload 11
    //   254: ldc 200
    //   256: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_1
    //   261: astore_2
    //   262: aload 7
    //   264: astore 5
    //   266: aload 11
    //   268: aload 9
    //   270: invokevirtual 122	java/io/File:length	()J
    //   273: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_1
    //   278: astore_2
    //   279: aload 7
    //   281: astore 5
    //   283: aload_1
    //   284: ldc 205
    //   286: aload 11
    //   288: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_1
    //   295: astore_2
    //   296: aload 7
    //   298: astore 5
    //   300: aload_1
    //   301: ldc 211
    //   303: ldc 213
    //   305: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_1
    //   309: astore_2
    //   310: aload 7
    //   312: astore 5
    //   314: aload_1
    //   315: ldc 215
    //   317: ldc 217
    //   319: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_1
    //   323: astore_2
    //   324: aload 7
    //   326: astore 5
    //   328: aload 10
    //   330: invokeinterface 221 1 0
    //   335: invokeinterface 227 1 0
    //   340: astore 11
    //   342: aload_1
    //   343: astore_2
    //   344: aload 7
    //   346: astore 5
    //   348: aload 11
    //   350: invokeinterface 232 1 0
    //   355: ifeq +48 -> 403
    //   358: aload_1
    //   359: astore_2
    //   360: aload 7
    //   362: astore 5
    //   364: aload 11
    //   366: invokeinterface 236 1 0
    //   371: checkcast 238	java/lang/String
    //   374: astore 12
    //   376: aload_1
    //   377: astore_2
    //   378: aload 7
    //   380: astore 5
    //   382: aload_1
    //   383: aload 12
    //   385: aload 10
    //   387: aload 12
    //   389: invokeinterface 242 2 0
    //   394: checkcast 238	java/lang/String
    //   397: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: goto -58 -> 342
    //   403: aload_1
    //   404: astore_2
    //   405: aload 7
    //   407: astore 5
    //   409: aload_1
    //   410: invokevirtual 246	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   413: astore 7
    //   415: sipush 10240
    //   418: newarray byte
    //   420: astore 8
    //   422: new 248	java/io/FileInputStream
    //   425: dup
    //   426: aload 9
    //   428: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   431: astore 5
    //   433: aload 5
    //   435: astore_2
    //   436: aload 5
    //   438: aload 8
    //   440: iconst_0
    //   441: sipush 10240
    //   444: invokevirtual 255	java/io/FileInputStream:read	([BII)I
    //   447: istore 6
    //   449: iload 6
    //   451: iconst_m1
    //   452: if_icmpeq +19 -> 471
    //   455: aload 5
    //   457: astore_2
    //   458: aload 7
    //   460: aload 8
    //   462: iconst_0
    //   463: iload 6
    //   465: invokevirtual 261	java/io/OutputStream:write	([BII)V
    //   468: goto -35 -> 433
    //   471: aload 5
    //   473: invokevirtual 264	java/io/FileInputStream:close	()V
    //   476: goto +8 -> 484
    //   479: astore_2
    //   480: aload_2
    //   481: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   484: aload_1
    //   485: invokevirtual 271	java/net/HttpURLConnection:getResponseCode	()I
    //   488: istore 6
    //   490: iload 6
    //   492: sipush 200
    //   495: if_icmpne +16 -> 511
    //   498: aload_0
    //   499: lload_3
    //   500: iconst_0
    //   501: iconst_0
    //   502: anewarray 4	java/lang/Object
    //   505: invokevirtual 131	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   508: goto +43 -> 551
    //   511: new 157	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   518: astore_2
    //   519: aload_2
    //   520: ldc_w 273
    //   523: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload_2
    //   528: iload 6
    //   530: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload_0
    //   535: lload_3
    //   536: iconst_m1
    //   537: iconst_1
    //   538: anewarray 4	java/lang/Object
    //   541: dup
    //   542: iconst_0
    //   543: aload_2
    //   544: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: aastore
    //   548: invokevirtual 131	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   551: aload 7
    //   553: ifnull +8 -> 561
    //   556: aload 7
    //   558: invokevirtual 277	java/io/OutputStream:close	()V
    //   561: aload_1
    //   562: ifnull +257 -> 819
    //   565: aload_1
    //   566: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   569: goto +250 -> 819
    //   572: astore 8
    //   574: goto +15 -> 589
    //   577: astore 5
    //   579: aconst_null
    //   580: astore_2
    //   581: goto +114 -> 695
    //   584: astore 8
    //   586: aconst_null
    //   587: astore 5
    //   589: aload 5
    //   591: astore_2
    //   592: new 157	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   599: astore 10
    //   601: aload 5
    //   603: astore_2
    //   604: aload 10
    //   606: ldc_w 282
    //   609: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload 5
    //   615: astore_2
    //   616: aload 10
    //   618: aload 8
    //   620: invokevirtual 285	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   623: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: aload 5
    //   629: astore_2
    //   630: aload_0
    //   631: lload_3
    //   632: iconst_m1
    //   633: iconst_1
    //   634: anewarray 4	java/lang/Object
    //   637: dup
    //   638: iconst_0
    //   639: aload 10
    //   641: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: aastore
    //   645: invokevirtual 131	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   648: aload 5
    //   650: ifnull +16 -> 666
    //   653: aload 5
    //   655: invokevirtual 264	java/io/FileInputStream:close	()V
    //   658: goto +8 -> 666
    //   661: astore_2
    //   662: aload_2
    //   663: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   666: aload 7
    //   668: ifnull +11 -> 679
    //   671: aload 7
    //   673: invokevirtual 277	java/io/OutputStream:close	()V
    //   676: goto +3 -> 679
    //   679: aload_1
    //   680: ifnull +12 -> 692
    //   683: aload_1
    //   684: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   687: return
    //   688: aload_1
    //   689: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   692: return
    //   693: astore 5
    //   695: aload_2
    //   696: ifnull +15 -> 711
    //   699: aload_2
    //   700: invokevirtual 264	java/io/FileInputStream:close	()V
    //   703: goto +8 -> 711
    //   706: astore_2
    //   707: aload_2
    //   708: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   711: aload 5
    //   713: athrow
    //   714: astore 5
    //   716: goto +120 -> 836
    //   719: astore_2
    //   720: aload 7
    //   722: astore 8
    //   724: aload_2
    //   725: astore 7
    //   727: goto +22 -> 749
    //   730: astore 7
    //   732: goto +17 -> 749
    //   735: astore 5
    //   737: aconst_null
    //   738: astore_1
    //   739: aload_2
    //   740: astore 7
    //   742: goto +94 -> 836
    //   745: astore 7
    //   747: aconst_null
    //   748: astore_1
    //   749: aload_1
    //   750: astore_2
    //   751: aload 8
    //   753: astore 5
    //   755: ldc_w 287
    //   758: iconst_1
    //   759: ldc_w 289
    //   762: aload 7
    //   764: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   767: aload_1
    //   768: astore_2
    //   769: aload 8
    //   771: astore 5
    //   773: aload_0
    //   774: lload_3
    //   775: iconst_m1
    //   776: iconst_1
    //   777: anewarray 4	java/lang/Object
    //   780: dup
    //   781: iconst_0
    //   782: aload 7
    //   784: invokevirtual 295	java/io/IOException:getMessage	()Ljava/lang/String;
    //   787: aastore
    //   788: invokevirtual 131	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   791: aload 8
    //   793: ifnull +11 -> 804
    //   796: aload 8
    //   798: invokevirtual 277	java/io/OutputStream:close	()V
    //   801: goto +3 -> 804
    //   804: aload_1
    //   805: ifnull +14 -> 819
    //   808: aload_1
    //   809: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   812: goto +7 -> 819
    //   815: aload_1
    //   816: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   819: aload 9
    //   821: invokevirtual 298	java/io/File:delete	()Z
    //   824: pop
    //   825: return
    //   826: astore_1
    //   827: aload 5
    //   829: astore 7
    //   831: aload_1
    //   832: astore 5
    //   834: aload_2
    //   835: astore_1
    //   836: aload 7
    //   838: ifnull +11 -> 849
    //   841: aload 7
    //   843: invokevirtual 277	java/io/OutputStream:close	()V
    //   846: goto +3 -> 849
    //   849: aload_1
    //   850: ifnull +14 -> 864
    //   853: aload_1
    //   854: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   857: goto +7 -> 864
    //   860: aload_1
    //   861: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   864: aload 5
    //   866: athrow
    //   867: aload_0
    //   868: lload_3
    //   869: iconst_m1
    //   870: iconst_1
    //   871: anewarray 4	java/lang/Object
    //   874: dup
    //   875: iconst_0
    //   876: ldc_w 300
    //   879: aastore
    //   880: invokevirtual 131	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   883: return
    //   884: astore_1
    //   885: goto -197 -> 688
    //   888: astore_1
    //   889: goto -74 -> 815
    //   892: astore_1
    //   893: goto -33 -> 860
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	896	0	this	SecSpyFileManager
    //   0	896	1	paramString1	String
    //   0	896	2	paramString2	String
    //   0	896	3	paramLong	long
    //   0	896	5	paramString3	String
    //   447	82	6	i	int
    //   161	565	7	localObject1	Object
    //   730	1	7	localIOException1	java.io.IOException
    //   740	1	7	str1	String
    //   745	38	7	localIOException2	java.io.IOException
    //   829	13	7	str2	String
    //   166	295	8	arrayOfByte	byte[]
    //   572	1	8	localException1	Exception
    //   584	35	8	localException2	Exception
    //   722	75	8	localObject2	Object
    //   12	808	9	localFile	File
    //   81	559	10	localObject3	Object
    //   244	121	11	localObject4	Object
    //   374	14	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   471	476	479	java/io/IOException
    //   436	449	572	java/lang/Exception
    //   458	468	572	java/lang/Exception
    //   422	433	577	finally
    //   422	433	584	java/lang/Exception
    //   653	658	661	java/io/IOException
    //   436	449	693	finally
    //   458	468	693	finally
    //   592	601	693	finally
    //   604	613	693	finally
    //   616	627	693	finally
    //   630	648	693	finally
    //   699	703	706	java/io/IOException
    //   415	422	714	finally
    //   471	476	714	finally
    //   480	484	714	finally
    //   484	490	714	finally
    //   498	508	714	finally
    //   511	551	714	finally
    //   653	658	714	finally
    //   662	666	714	finally
    //   699	703	714	finally
    //   707	711	714	finally
    //   711	714	714	finally
    //   415	422	719	java/io/IOException
    //   480	484	719	java/io/IOException
    //   484	490	719	java/io/IOException
    //   498	508	719	java/io/IOException
    //   511	551	719	java/io/IOException
    //   662	666	719	java/io/IOException
    //   707	711	719	java/io/IOException
    //   711	714	719	java/io/IOException
    //   192	197	730	java/io/IOException
    //   203	208	730	java/io/IOException
    //   214	219	730	java/io/IOException
    //   225	231	730	java/io/IOException
    //   237	246	730	java/io/IOException
    //   252	260	730	java/io/IOException
    //   266	277	730	java/io/IOException
    //   283	294	730	java/io/IOException
    //   300	308	730	java/io/IOException
    //   314	322	730	java/io/IOException
    //   328	342	730	java/io/IOException
    //   348	358	730	java/io/IOException
    //   364	376	730	java/io/IOException
    //   382	400	730	java/io/IOException
    //   409	415	730	java/io/IOException
    //   168	186	735	finally
    //   168	186	745	java/io/IOException
    //   192	197	826	finally
    //   203	208	826	finally
    //   214	219	826	finally
    //   225	231	826	finally
    //   237	246	826	finally
    //   252	260	826	finally
    //   266	277	826	finally
    //   283	294	826	finally
    //   300	308	826	finally
    //   314	322	826	finally
    //   328	342	826	finally
    //   348	358	826	finally
    //   364	376	826	finally
    //   382	400	826	finally
    //   409	415	826	finally
    //   755	767	826	finally
    //   773	791	826	finally
    //   671	676	884	java/io/IOException
    //   683	687	884	java/io/IOException
    //   556	561	888	java/io/IOException
    //   565	569	888	java/io/IOException
    //   796	801	888	java/io/IOException
    //   808	812	888	java/io/IOException
    //   841	846	892	java/io/IOException
    //   853	857	892	java/io/IOException
  }
  
  public File a(String paramString)
  {
    Object localObject2 = paramString;
    try
    {
      boolean bool = paramString.startsWith("/data/data/com.tencent.mobileqq/");
      Object localObject3;
      if (bool)
      {
        localObject1 = paramString;
        localObject2 = paramString;
        if (!paramString.endsWith("/"))
        {
          localObject2 = paramString;
          localObject1 = new StringBuilder();
          localObject2 = paramString;
          ((StringBuilder)localObject1).append(paramString);
          localObject2 = paramString;
          ((StringBuilder)localObject1).append("/");
          localObject2 = paramString;
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = localObject1;
        localObject3 = ((String)localObject1).substring(((String)localObject1).indexOf("/data/data/com.tencent.mobileqq/") + 32);
        localObject2 = localObject1;
        paramString = ((String)localObject3).substring(0, ((String)localObject3).indexOf("/"));
        localObject2 = localObject1;
        localObject3 = ((String)localObject3).substring(((String)localObject3).indexOf("/") + 1);
        localObject2 = localObject1;
        Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
        localObject2 = localObject1;
        if (paramString.equals("files"))
        {
          localObject2 = localObject1;
          return new File(localContext.getFilesDir(), (String)localObject3);
        }
        localObject2 = localObject1;
        if (paramString.equals("cache"))
        {
          localObject2 = localObject1;
          return new File(localContext.getCacheDir(), (String)localObject3);
        }
        localObject2 = localObject1;
        if (paramString.startsWith("app_"))
        {
          localObject2 = localObject1;
          paramString = paramString.substring(4);
          localObject2 = localObject1;
          return new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getDir(paramString, 0), (String)localObject3);
        }
        localObject2 = localObject1;
        return new File((String)localObject1);
      }
      localObject2 = paramString;
      if (paramString.startsWith("sdcard/"))
      {
        localObject2 = paramString;
        localObject1 = paramString.replace("sdcard/", "");
        localObject2 = paramString;
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          localObject2 = paramString;
          if (Environment.getExternalStorageDirectory().canWrite())
          {
            localObject2 = paramString;
            localObject3 = new StringBuilder();
            localObject2 = paramString;
            ((StringBuilder)localObject3).append(Environment.getExternalStorageDirectory().getPath());
            localObject2 = paramString;
            ((StringBuilder)localObject3).append("/");
            localObject2 = paramString;
            ((StringBuilder)localObject3).append((String)localObject1);
            localObject2 = paramString;
            return new File(((StringBuilder)localObject3).toString());
          }
        }
      }
      else
      {
        localObject2 = paramString;
        paramString = new File(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("wrong to parse file from path :");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.e("SecSpyFileManager", 2, ((StringBuilder)localObject1).toString(), paramString);
      }
      paramString.printStackTrace();
      return null;
    }
    paramString = null;
    return paramString;
  }
  
  public String a(TreeMap<String, Object> paramTreeMap, String paramString)
  {
    Iterator localIterator = paramTreeMap.keySet().iterator();
    StringBuilder localStringBuilder;
    for (String str1 = ""; localIterator.hasNext(); str1 = localStringBuilder.toString())
    {
      String str2 = (String)localIterator.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(paramTreeMap.get(str2));
    }
    paramTreeMap = new StringBuilder();
    paramTreeMap.append(str1);
    paramTreeMap.append(paramString);
    return MD5.toMD5(paramTreeMap.toString());
  }
  
  public List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public JSONArray a(Collection paramCollection)
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localJSONArray.put(paramCollection.next());
    }
    return localJSONArray;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramLong);
  }
  
  public void a(long paramLong, int paramInt, Object... paramVarArgs)
  {
    if (paramInt != -1) {
      if ((paramInt != 0) && (paramInt != 1)) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            return;
          }
        }
      }
    }
    try
    {
      localJSONObject = new JSONObject();
      if (paramVarArgs.length > 0) {
        localJSONObject.put("percent", paramVarArgs[0]);
      }
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter.a(paramLong, paramInt, localJSONObject);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      JSONObject localJSONObject;
      paramVarArgs.printStackTrace();
    }
    localJSONObject = new JSONObject();
    if (paramVarArgs.length > 0) {
      localJSONObject.put("sizes", paramVarArgs[0]);
    }
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter.a(paramLong, paramInt, localJSONObject);
    return;
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter.a(paramLong, paramInt, null);
    return;
    localJSONObject = new JSONObject();
    if (paramVarArgs.length > 0) {
      localJSONObject.put("msg", paramVarArgs[0]);
    }
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter.a(paramLong, paramInt, localJSONObject);
    return;
  }
  
  public void a(long paramLong, String paramString)
  {
    a(paramLong, -1, new Object[] { paramString });
  }
  
  public void a(long paramLong, String paramString, Map<String, Object> paramMap, List<UnifiedTraceRouter.TraceRouteInfo> paramList)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramList.size())
    {
      localJSONArray.put(((UnifiedTraceRouter.TraceRouteInfo)paramList.get(i)).a());
      i += 1;
    }
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramMap.get(str));
      }
      localJSONObject.put("dns", this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a());
      localJSONObject.put("ip", this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.d(paramString));
      localJSONObject.put("traceRoute", localJSONArray);
      if (QLog.isColorLevel()) {
        QLog.d("SecSpyFileManager", 2, localJSONObject.toString());
      }
      a(paramLong, localJSONObject);
    }
    catch (Exception paramString)
    {
      a(paramLong, -1, new Object[] { paramString.getMessage() });
    }
    paramList.clear();
  }
  
  public void a(long paramLong, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter.a(paramLong, 0, paramJSONObject);
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString1, paramInt, paramLong1, paramLong2, paramString2);
  }
  
  public void a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    File localFile = new File(paramString1);
    if ((localFile.exists()) && (localFile.isFile()))
    {
      a(paramLong, 2, new Object[] { Long.valueOf(localFile.length()) });
      if (a(paramString1, paramLong, paramString2, false))
      {
        if (paramBoolean)
        {
          localFile.delete();
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append(" delete success");
            QLog.d("SecSpyFileManager", 2, paramString2.toString());
          }
        }
      }
      else {
        a(paramLong, -1, new Object[] { "file upload failed" });
      }
    }
  }
  
  public void a(List<String> paramList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramLong)) {
      b(paramList, paramLong, paramString);
    }
  }
  
  public void a(submsgtype0x7c.MsgBody paramMsgBody, int paramInt)
  {
    if (paramInt < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecSpyFileManager", 2, "retry to max retry number ");
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("SecSpyFile", 0);
      localHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager = new UnifiedDebugManager(new SnapshotResultReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsHandler));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter == null) {
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter = new UnifiedDebugReporter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SecSpyFileManager.2(this, paramMsgBody, paramInt));
  }
  
  /* Error */
  public boolean a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore 5
    //   11: iconst_0
    //   12: istore 4
    //   14: new 248	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 6
    //   24: new 157	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   31: astore 8
    //   33: aload 8
    //   35: aload_1
    //   36: invokevirtual 551	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   39: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 8
    //   45: aload_0
    //   46: getfield 47	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   49: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_0
    //   54: aload 8
    //   56: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   62: astore_1
    //   63: aload_1
    //   64: ifnonnull +56 -> 120
    //   67: aload 6
    //   69: invokevirtual 264	java/io/FileInputStream:close	()V
    //   72: goto +21 -> 93
    //   75: astore_1
    //   76: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +14 -> 93
    //   82: ldc_w 287
    //   85: iconst_2
    //   86: ldc_w 553
    //   89: aload_1
    //   90: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: aload 6
    //   95: invokevirtual 264	java/io/FileInputStream:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_1
    //   101: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +14 -> 118
    //   107: ldc_w 287
    //   110: iconst_2
    //   111: ldc_w 553
    //   114: aload_1
    //   115: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   118: iconst_0
    //   119: ireturn
    //   120: new 555	java/util/zip/GZIPOutputStream
    //   123: dup
    //   124: new 557	java/io/FileOutputStream
    //   127: dup
    //   128: aload_1
    //   129: invokespecial 558	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: invokespecial 561	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   135: astore_1
    //   136: iload 4
    //   138: istore_3
    //   139: sipush 10240
    //   142: newarray byte
    //   144: astore 7
    //   146: iload 4
    //   148: istore_3
    //   149: aload 6
    //   151: aload 7
    //   153: iconst_0
    //   154: sipush 10240
    //   157: invokevirtual 255	java/io/FileInputStream:read	([BII)I
    //   160: istore_2
    //   161: iload_2
    //   162: iconst_m1
    //   163: if_icmpeq +17 -> 180
    //   166: iload 4
    //   168: istore_3
    //   169: aload_1
    //   170: aload 7
    //   172: iconst_0
    //   173: iload_2
    //   174: invokevirtual 562	java/util/zip/GZIPOutputStream:write	([BII)V
    //   177: goto -31 -> 146
    //   180: iconst_1
    //   181: istore_3
    //   182: iconst_1
    //   183: istore 4
    //   185: iconst_1
    //   186: istore 5
    //   188: aload_1
    //   189: invokevirtual 565	java/util/zip/GZIPOutputStream:flush	()V
    //   192: aload 6
    //   194: invokevirtual 264	java/io/FileInputStream:close	()V
    //   197: aload_1
    //   198: invokevirtual 566	java/util/zip/GZIPOutputStream:close	()V
    //   201: iconst_1
    //   202: ireturn
    //   203: astore_1
    //   204: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +130 -> 337
    //   210: iload 5
    //   212: istore_3
    //   213: ldc_w 287
    //   216: iconst_2
    //   217: ldc_w 553
    //   220: aload_1
    //   221: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: iload_3
    //   225: ireturn
    //   226: astore 7
    //   228: goto +114 -> 342
    //   231: astore 7
    //   233: goto +19 -> 252
    //   236: astore 8
    //   238: aload 7
    //   240: astore_1
    //   241: aload 8
    //   243: astore 7
    //   245: goto +97 -> 342
    //   248: astore 7
    //   250: aconst_null
    //   251: astore_1
    //   252: goto +29 -> 281
    //   255: astore 8
    //   257: aconst_null
    //   258: astore 6
    //   260: aload 7
    //   262: astore_1
    //   263: aload 8
    //   265: astore 7
    //   267: goto +75 -> 342
    //   270: astore 7
    //   272: aconst_null
    //   273: astore_1
    //   274: iload 5
    //   276: istore_3
    //   277: aload 8
    //   279: astore 6
    //   281: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +15 -> 299
    //   287: ldc_w 287
    //   290: iconst_2
    //   291: ldc_w 553
    //   294: aload 7
    //   296: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   299: aload 6
    //   301: ifnull +11 -> 312
    //   304: aload 6
    //   306: invokevirtual 264	java/io/FileInputStream:close	()V
    //   309: goto +3 -> 312
    //   312: iload_3
    //   313: istore 4
    //   315: aload_1
    //   316: ifnull +21 -> 337
    //   319: aload_1
    //   320: invokevirtual 566	java/util/zip/GZIPOutputStream:close	()V
    //   323: iload_3
    //   324: ireturn
    //   325: iload_3
    //   326: istore 4
    //   328: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +6 -> 337
    //   334: goto -121 -> 213
    //   337: iload 4
    //   339: ireturn
    //   340: astore 7
    //   342: aload 6
    //   344: ifnull +11 -> 355
    //   347: aload 6
    //   349: invokevirtual 264	java/io/FileInputStream:close	()V
    //   352: goto +3 -> 355
    //   355: aload_1
    //   356: ifnull +27 -> 383
    //   359: aload_1
    //   360: invokevirtual 566	java/util/zip/GZIPOutputStream:close	()V
    //   363: goto +20 -> 383
    //   366: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   369: ifeq +14 -> 383
    //   372: ldc_w 287
    //   375: iconst_2
    //   376: ldc_w 553
    //   379: aload_1
    //   380: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   383: goto +6 -> 389
    //   386: aload 7
    //   388: athrow
    //   389: goto -3 -> 386
    //   392: astore_1
    //   393: goto -68 -> 325
    //   396: astore_1
    //   397: goto -31 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	SecSpyFileManager
    //   0	400	1	paramFile	File
    //   160	14	2	i	int
    //   7	319	3	bool1	boolean
    //   12	326	4	bool2	boolean
    //   9	266	5	bool3	boolean
    //   22	326	6	localObject1	Object
    //   1	170	7	arrayOfByte	byte[]
    //   226	1	7	localObject2	Object
    //   231	8	7	localIOException1	java.io.IOException
    //   243	1	7	localObject3	Object
    //   248	13	7	localIOException2	java.io.IOException
    //   265	1	7	localObject4	Object
    //   270	25	7	localIOException3	java.io.IOException
    //   340	47	7	localObject5	Object
    //   4	51	8	localStringBuilder	StringBuilder
    //   236	6	8	localObject6	Object
    //   255	23	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   67	72	75	java/lang/Exception
    //   93	98	100	java/lang/Exception
    //   192	201	203	java/lang/Exception
    //   139	146	226	finally
    //   149	161	226	finally
    //   169	177	226	finally
    //   188	192	226	finally
    //   139	146	231	java/io/IOException
    //   149	161	231	java/io/IOException
    //   169	177	231	java/io/IOException
    //   188	192	231	java/io/IOException
    //   24	63	236	finally
    //   67	72	236	finally
    //   76	93	236	finally
    //   120	136	236	finally
    //   24	63	248	java/io/IOException
    //   67	72	248	java/io/IOException
    //   76	93	248	java/io/IOException
    //   120	136	248	java/io/IOException
    //   14	24	255	finally
    //   14	24	270	java/io/IOException
    //   281	299	340	finally
    //   304	309	392	java/lang/Exception
    //   319	323	392	java/lang/Exception
    //   347	352	396	java/lang/Exception
    //   359	363	396	java/lang/Exception
  }
  
  /* Error */
  public boolean a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 13
    //   3: aload_1
    //   4: invokestatic 412	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: new 568	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 569	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:<init>	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager;)V
    //   20: astore 18
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   27: astore 16
    //   29: aload 16
    //   31: ifnull +1800 -> 1831
    //   34: aload 16
    //   36: invokevirtual 115	java/io/File:exists	()Z
    //   39: ifeq +1792 -> 1831
    //   42: aload 16
    //   44: invokevirtual 118	java/io/File:isFile	()Z
    //   47: ifne +6 -> 53
    //   50: goto +1781 -> 1831
    //   53: invokestatic 574	com/tencent/biz/common/util/HttpUtil:getNetWorkType	()I
    //   56: iconst_1
    //   57: if_icmpne +2280 -> 2337
    //   60: ldc2_w 575
    //   63: lstore 8
    //   65: goto +3 -> 68
    //   68: aload 16
    //   70: invokevirtual 122	java/io/File:length	()J
    //   73: lstore 10
    //   75: lload 10
    //   77: lload 8
    //   79: lcmp
    //   80: ifle +191 -> 271
    //   83: aload_0
    //   84: lload_2
    //   85: iconst_m1
    //   86: iconst_1
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: getstatic 27	com/tencent/mobileqq/secspy/SecSpyFileManager:d	Ljava/lang/String;
    //   95: aastore
    //   96: invokevirtual 131	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   99: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +44 -> 146
    //   105: new 157	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   112: astore 4
    //   114: aload 4
    //   116: ldc_w 578
    //   119: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: aload 16
    //   127: invokevirtual 122	java/io/File:length	()J
    //   130: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: ldc_w 287
    //   137: iconst_2
    //   138: aload 4
    //   140: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 479	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: iload 5
    //   148: ifeq +52 -> 200
    //   151: new 157	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   158: astore_1
    //   159: aload_1
    //   160: aload 13
    //   162: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_1
    //   167: aload_0
    //   168: getfield 47	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   171: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_0
    //   176: aload_1
    //   177: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   183: astore_1
    //   184: aload_1
    //   185: ifnull +15 -> 200
    //   188: aload_1
    //   189: invokevirtual 115	java/io/File:exists	()Z
    //   192: ifeq +8 -> 200
    //   195: aload_1
    //   196: invokevirtual 298	java/io/File:delete	()Z
    //   199: pop
    //   200: aload 18
    //   202: iconst_1
    //   203: invokestatic 581	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   206: pop
    //   207: iconst_0
    //   208: ireturn
    //   209: astore_1
    //   210: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +14 -> 227
    //   216: ldc_w 287
    //   219: iconst_2
    //   220: ldc_w 583
    //   223: aload_1
    //   224: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload_1
    //   228: invokevirtual 380	java/lang/Exception:printStackTrace	()V
    //   231: iconst_0
    //   232: ireturn
    //   233: astore 13
    //   235: aconst_null
    //   236: astore 14
    //   238: aconst_null
    //   239: astore 15
    //   241: aconst_null
    //   242: astore 4
    //   244: aload_1
    //   245: astore 16
    //   247: aload 13
    //   249: astore_1
    //   250: aload 16
    //   252: astore 13
    //   254: goto +1947 -> 2201
    //   257: astore 15
    //   259: aconst_null
    //   260: astore 13
    //   262: aconst_null
    //   263: astore 4
    //   265: aconst_null
    //   266: astore 14
    //   268: goto +1762 -> 2030
    //   271: aload 13
    //   273: aload 13
    //   275: bipush 47
    //   277: invokevirtual 587	java/lang/String:lastIndexOf	(I)I
    //   280: iconst_1
    //   281: iadd
    //   282: invokevirtual 318	java/lang/String:substring	(I)Ljava/lang/String;
    //   285: astore 17
    //   287: aload 16
    //   289: astore 14
    //   291: aload 17
    //   293: astore 15
    //   295: iload 5
    //   297: ifeq +336 -> 633
    //   300: new 157	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   307: astore 14
    //   309: aload 14
    //   311: aload 17
    //   313: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 14
    //   319: ldc_w 589
    //   322: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 14
    //   328: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: astore 15
    //   333: aload_0
    //   334: aload 16
    //   336: invokevirtual 591	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/io/File;)Z
    //   339: ifeq +207 -> 546
    //   342: new 157	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   349: astore 14
    //   351: aload 14
    //   353: aload 13
    //   355: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 14
    //   361: aload_0
    //   362: getfield 47	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   365: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_0
    //   370: aload 14
    //   372: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   378: astore 16
    //   380: aload 16
    //   382: ifnull +23 -> 405
    //   385: aload 16
    //   387: invokevirtual 115	java/io/File:exists	()Z
    //   390: ifeq +15 -> 405
    //   393: aload 16
    //   395: astore 14
    //   397: aload 16
    //   399: invokevirtual 118	java/io/File:isFile	()Z
    //   402: ifne +231 -> 633
    //   405: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +51 -> 459
    //   411: new 157	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   418: astore 4
    //   420: aload 4
    //   422: ldc_w 593
    //   425: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 4
    //   431: aload 13
    //   433: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 4
    //   439: aload_0
    //   440: getfield 47	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   443: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: ldc_w 287
    //   450: iconst_2
    //   451: aload 4
    //   453: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 479	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: iload 5
    //   461: ifeq +52 -> 513
    //   464: new 157	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   471: astore_1
    //   472: aload_1
    //   473: aload 13
    //   475: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload_1
    //   480: aload_0
    //   481: getfield 47	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   484: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload_0
    //   489: aload_1
    //   490: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   496: astore_1
    //   497: aload_1
    //   498: ifnull +15 -> 513
    //   501: aload_1
    //   502: invokevirtual 115	java/io/File:exists	()Z
    //   505: ifeq +8 -> 513
    //   508: aload_1
    //   509: invokevirtual 298	java/io/File:delete	()Z
    //   512: pop
    //   513: aload 18
    //   515: iconst_1
    //   516: invokestatic 581	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   519: pop
    //   520: iconst_0
    //   521: ireturn
    //   522: astore_1
    //   523: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +14 -> 540
    //   529: ldc_w 287
    //   532: iconst_2
    //   533: ldc_w 583
    //   536: aload_1
    //   537: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   540: aload_1
    //   541: invokevirtual 380	java/lang/Exception:printStackTrace	()V
    //   544: iconst_0
    //   545: ireturn
    //   546: iload 5
    //   548: ifeq +52 -> 600
    //   551: new 157	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   558: astore_1
    //   559: aload_1
    //   560: aload 13
    //   562: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload_1
    //   567: aload_0
    //   568: getfield 47	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   571: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload_0
    //   576: aload_1
    //   577: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   583: astore_1
    //   584: aload_1
    //   585: ifnull +15 -> 600
    //   588: aload_1
    //   589: invokevirtual 115	java/io/File:exists	()Z
    //   592: ifeq +8 -> 600
    //   595: aload_1
    //   596: invokevirtual 298	java/io/File:delete	()Z
    //   599: pop
    //   600: aload 18
    //   602: iconst_1
    //   603: invokestatic 581	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   606: pop
    //   607: iconst_0
    //   608: ireturn
    //   609: astore_1
    //   610: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   613: ifeq +14 -> 627
    //   616: ldc_w 287
    //   619: iconst_2
    //   620: ldc_w 583
    //   623: aload_1
    //   624: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   627: aload_1
    //   628: invokevirtual 380	java/lang/Exception:printStackTrace	()V
    //   631: iconst_0
    //   632: ireturn
    //   633: new 383	java/util/TreeMap
    //   636: dup
    //   637: invokespecial 594	java/util/TreeMap:<init>	()V
    //   640: astore 16
    //   642: aload 16
    //   644: ldc_w 596
    //   647: lload_2
    //   648: invokestatic 128	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   651: invokevirtual 597	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   654: pop
    //   655: aload 16
    //   657: ldc_w 599
    //   660: ldc_w 601
    //   663: invokevirtual 597	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   666: pop
    //   667: aload 16
    //   669: ldc_w 603
    //   672: aload 15
    //   674: invokevirtual 597	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   677: pop
    //   678: aload 16
    //   680: ldc_w 605
    //   683: aload 14
    //   685: invokevirtual 122	java/io/File:length	()J
    //   688: invokestatic 128	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   691: invokevirtual 597	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   694: pop
    //   695: aload 16
    //   697: ldc_w 607
    //   700: iconst_0
    //   701: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   704: invokevirtual 597	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   707: pop
    //   708: aload 16
    //   710: ldc_w 609
    //   713: aload_0
    //   714: aload 16
    //   716: aload 4
    //   718: invokevirtual 611	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/util/TreeMap;Ljava/lang/String;)Ljava/lang/String;
    //   721: invokevirtual 597	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   724: pop
    //   725: aload_0
    //   726: getfield 39	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   729: astore 4
    //   731: aload 16
    //   733: invokevirtual 384	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   736: invokeinterface 227 1 0
    //   741: astore 13
    //   743: aload 13
    //   745: invokeinterface 232 1 0
    //   750: istore 12
    //   752: iload 12
    //   754: ifeq +106 -> 860
    //   757: aload 13
    //   759: invokeinterface 236 1 0
    //   764: checkcast 238	java/lang/String
    //   767: astore 17
    //   769: new 157	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   776: astore 19
    //   778: aload 19
    //   780: aload 4
    //   782: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload 19
    //   788: aload 17
    //   790: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload 19
    //   796: ldc_w 613
    //   799: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 19
    //   805: aload 16
    //   807: aload 17
    //   809: invokevirtual 385	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   812: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload 19
    //   818: ldc_w 615
    //   821: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload 19
    //   827: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: astore 4
    //   832: goto -89 -> 743
    //   835: astore 4
    //   837: aload_1
    //   838: astore 13
    //   840: aload 4
    //   842: astore_1
    //   843: goto +1147 -> 1990
    //   846: astore 15
    //   848: aconst_null
    //   849: astore 13
    //   851: aconst_null
    //   852: astore 4
    //   854: aconst_null
    //   855: astore 14
    //   857: goto +1173 -> 2030
    //   860: aload 4
    //   862: ldc_w 615
    //   865: invokevirtual 311	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   868: istore 12
    //   870: aload 4
    //   872: astore 13
    //   874: iload 12
    //   876: ifeq +18 -> 894
    //   879: aload 4
    //   881: iconst_0
    //   882: aload 4
    //   884: invokevirtual 616	java/lang/String:length	()I
    //   887: iconst_1
    //   888: isub
    //   889: invokevirtual 321	java/lang/String:substring	(II)Ljava/lang/String;
    //   892: astore 13
    //   894: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   897: istore 12
    //   899: iload 12
    //   901: ifeq +41 -> 942
    //   904: new 157	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   911: astore 4
    //   913: aload 4
    //   915: ldc_w 618
    //   918: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 4
    //   924: aload 13
    //   926: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: ldc_w 287
    //   933: iconst_2
    //   934: aload 4
    //   936: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: invokestatic 479	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   942: new 174	java/net/URL
    //   945: dup
    //   946: aload 13
    //   948: invokespecial 177	java/net/URL:<init>	(Ljava/lang/String;)V
    //   951: invokevirtual 181	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   954: checkcast 183	java/net/HttpURLConnection
    //   957: astore 4
    //   959: aload 4
    //   961: iconst_0
    //   962: invokevirtual 193	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   965: aload 4
    //   967: iconst_1
    //   968: invokevirtual 187	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   971: aload_0
    //   972: getfield 49	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   975: iconst_2
    //   976: invokevirtual 622	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   979: checkcast 624	mqq/app/TicketManagerImpl
    //   982: astore 13
    //   984: new 157	java/lang/StringBuilder
    //   987: dup
    //   988: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   991: astore 16
    //   993: aload 16
    //   995: ldc_w 626
    //   998: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: pop
    //   1002: aload 16
    //   1004: aload_0
    //   1005: getfield 49	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1008: invokevirtual 629	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1011: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: pop
    //   1015: aload 16
    //   1017: ldc_w 631
    //   1020: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: pop
    //   1024: aload 16
    //   1026: aload 13
    //   1028: aload_0
    //   1029: getfield 49	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1032: invokevirtual 629	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1035: invokevirtual 634	mqq/app/TicketManagerImpl:getSkey	(Ljava/lang/String;)Ljava/lang/String;
    //   1038: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: pop
    //   1042: aload 4
    //   1044: ldc_w 636
    //   1047: aload 16
    //   1049: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1055: aload 4
    //   1057: ldc 195
    //   1059: invokevirtual 198	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1062: aload 4
    //   1064: ldc_w 638
    //   1067: ldc_w 640
    //   1070: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1073: aload 4
    //   1075: ldc_w 642
    //   1078: ldc_w 644
    //   1081: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1084: new 157	java/lang/StringBuilder
    //   1087: dup
    //   1088: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1091: astore 13
    //   1093: aload 13
    //   1095: ldc_w 646
    //   1098: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 13
    //   1104: ldc_w 648
    //   1107: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload 4
    //   1113: ldc 211
    //   1115: aload 13
    //   1117: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1123: new 650	java/io/DataOutputStream
    //   1126: dup
    //   1127: aload 4
    //   1129: invokevirtual 246	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1132: invokespecial 651	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1135: astore 13
    //   1137: new 157	java/lang/StringBuilder
    //   1140: dup
    //   1141: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1144: astore 16
    //   1146: aload 16
    //   1148: ldc_w 653
    //   1151: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: aload 16
    //   1157: ldc_w 648
    //   1160: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: pop
    //   1164: aload 16
    //   1166: ldc_w 655
    //   1169: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: pop
    //   1173: aload 13
    //   1175: aload 16
    //   1177: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: invokevirtual 658	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1183: new 157	java/lang/StringBuilder
    //   1186: dup
    //   1187: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1190: astore 16
    //   1192: aload 16
    //   1194: ldc_w 660
    //   1197: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: pop
    //   1201: aload 16
    //   1203: aload 15
    //   1205: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: pop
    //   1209: aload 16
    //   1211: ldc_w 662
    //   1214: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: pop
    //   1218: aload 16
    //   1220: ldc_w 655
    //   1223: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: pop
    //   1227: aload 13
    //   1229: aload 16
    //   1231: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1234: invokevirtual 658	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1237: aload 13
    //   1239: ldc_w 655
    //   1242: invokevirtual 658	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1245: new 248	java/io/FileInputStream
    //   1248: dup
    //   1249: aload 14
    //   1251: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1254: astore 14
    //   1256: aload 14
    //   1258: invokevirtual 665	java/io/FileInputStream:available	()I
    //   1261: istore 6
    //   1263: iload 6
    //   1265: ldc_w 666
    //   1268: invokestatic 672	java/lang/Math:min	(II)I
    //   1271: istore 7
    //   1273: iload 7
    //   1275: newarray byte
    //   1277: astore 15
    //   1279: aload 18
    //   1281: iload 6
    //   1283: i2f
    //   1284: invokestatic 675	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;F)F
    //   1287: pop
    //   1288: aload_0
    //   1289: getfield 101	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   1292: invokevirtual 678	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	()Landroid/os/Handler;
    //   1295: new 680	com/tencent/mobileqq/secspy/SecSpyFileManager$3
    //   1298: dup
    //   1299: aload_0
    //   1300: aload 18
    //   1302: lload_2
    //   1303: invokespecial 683	com/tencent/mobileqq/secspy/SecSpyFileManager$3:<init>	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager;Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;J)V
    //   1306: ldc2_w 684
    //   1309: invokevirtual 689	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1312: pop
    //   1313: aload 14
    //   1315: aload 15
    //   1317: iconst_0
    //   1318: iload 7
    //   1320: invokevirtual 255	java/io/FileInputStream:read	([BII)I
    //   1323: istore 6
    //   1325: iload 6
    //   1327: ifle +82 -> 1409
    //   1330: aload 13
    //   1332: aload 15
    //   1334: iconst_0
    //   1335: iload 7
    //   1337: invokevirtual 690	java/io/DataOutputStream:write	([BII)V
    //   1340: aload 18
    //   1342: aload 18
    //   1344: invokestatic 693	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;)F
    //   1347: iload 6
    //   1349: i2f
    //   1350: fadd
    //   1351: invokestatic 695	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:b	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;F)F
    //   1354: pop
    //   1355: aload 14
    //   1357: invokevirtual 665	java/io/FileInputStream:available	()I
    //   1360: ldc_w 666
    //   1363: invokestatic 672	java/lang/Math:min	(II)I
    //   1366: istore 7
    //   1368: aload 14
    //   1370: aload 15
    //   1372: iconst_0
    //   1373: iload 7
    //   1375: invokevirtual 255	java/io/FileInputStream:read	([BII)I
    //   1378: istore 6
    //   1380: goto -55 -> 1325
    //   1383: astore 15
    //   1385: aload 13
    //   1387: astore 16
    //   1389: aload 15
    //   1391: astore 13
    //   1393: aload 4
    //   1395: astore 15
    //   1397: aload 16
    //   1399: astore 4
    //   1401: goto -1157 -> 244
    //   1404: astore 15
    //   1406: goto +342 -> 1748
    //   1409: aload 13
    //   1411: ldc_w 655
    //   1414: invokevirtual 658	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1417: new 157	java/lang/StringBuilder
    //   1420: dup
    //   1421: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1424: astore 15
    //   1426: aload 15
    //   1428: ldc_w 653
    //   1431: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: pop
    //   1435: aload 15
    //   1437: ldc_w 648
    //   1440: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: pop
    //   1444: aload 15
    //   1446: ldc_w 653
    //   1449: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: pop
    //   1453: aload 15
    //   1455: ldc_w 655
    //   1458: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: pop
    //   1462: aload 13
    //   1464: aload 15
    //   1466: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1469: invokevirtual 658	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1472: aload 4
    //   1474: invokevirtual 271	java/net/HttpURLConnection:getResponseCode	()I
    //   1477: istore 6
    //   1479: aload 4
    //   1481: invokevirtual 698	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   1484: astore 15
    //   1486: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1489: istore 12
    //   1491: iload 12
    //   1493: ifeq +57 -> 1550
    //   1496: new 157	java/lang/StringBuilder
    //   1499: dup
    //   1500: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1503: astore 16
    //   1505: aload 16
    //   1507: ldc 200
    //   1509: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload 16
    //   1515: iload 6
    //   1517: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1520: pop
    //   1521: aload 16
    //   1523: ldc_w 700
    //   1526: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1529: pop
    //   1530: aload 16
    //   1532: aload 15
    //   1534: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: pop
    //   1538: ldc_w 287
    //   1541: iconst_2
    //   1542: aload 16
    //   1544: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1547: invokestatic 479	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1550: aload 13
    //   1552: invokevirtual 701	java/io/DataOutputStream:flush	()V
    //   1555: aload 13
    //   1557: invokevirtual 702	java/io/DataOutputStream:close	()V
    //   1560: aload 14
    //   1562: invokevirtual 264	java/io/FileInputStream:close	()V
    //   1565: iload 6
    //   1567: sipush 200
    //   1570: if_icmpne +9 -> 1579
    //   1573: iconst_1
    //   1574: istore 12
    //   1576: goto +6 -> 1582
    //   1579: iconst_0
    //   1580: istore 12
    //   1582: aload 13
    //   1584: invokevirtual 702	java/io/DataOutputStream:close	()V
    //   1587: aload 4
    //   1589: ifnull +8 -> 1597
    //   1592: aload 4
    //   1594: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   1597: iload 5
    //   1599: ifeq +55 -> 1654
    //   1602: new 157	java/lang/StringBuilder
    //   1605: dup
    //   1606: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1609: astore 4
    //   1611: aload 4
    //   1613: aload_1
    //   1614: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: pop
    //   1618: aload 4
    //   1620: aload_0
    //   1621: getfield 47	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   1624: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: pop
    //   1628: aload_0
    //   1629: aload 4
    //   1631: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1634: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   1637: astore_1
    //   1638: aload_1
    //   1639: ifnull +15 -> 1654
    //   1642: aload_1
    //   1643: invokevirtual 115	java/io/File:exists	()Z
    //   1646: ifeq +8 -> 1654
    //   1649: aload_1
    //   1650: invokevirtual 298	java/io/File:delete	()Z
    //   1653: pop
    //   1654: aload 18
    //   1656: iconst_1
    //   1657: invokestatic 581	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   1660: pop
    //   1661: iload 12
    //   1663: ireturn
    //   1664: astore_1
    //   1665: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1668: ifeq +14 -> 1682
    //   1671: ldc_w 287
    //   1674: iconst_2
    //   1675: ldc_w 583
    //   1678: aload_1
    //   1679: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1682: aload_1
    //   1683: invokevirtual 380	java/lang/Exception:printStackTrace	()V
    //   1686: iload 12
    //   1688: ireturn
    //   1689: astore 15
    //   1691: aload 13
    //   1693: astore 16
    //   1695: aload 15
    //   1697: astore 13
    //   1699: aload 4
    //   1701: astore 15
    //   1703: aload 16
    //   1705: astore 4
    //   1707: goto -1463 -> 244
    //   1710: astore 15
    //   1712: goto +36 -> 1748
    //   1715: astore 14
    //   1717: aload 13
    //   1719: astore 16
    //   1721: aconst_null
    //   1722: astore 15
    //   1724: aload 14
    //   1726: astore 13
    //   1728: aload 15
    //   1730: astore 14
    //   1732: aload 4
    //   1734: astore 15
    //   1736: aload 16
    //   1738: astore 4
    //   1740: goto -1496 -> 244
    //   1743: astore 15
    //   1745: aconst_null
    //   1746: astore 14
    //   1748: aload 13
    //   1750: astore 16
    //   1752: aload 4
    //   1754: astore 13
    //   1756: aload 16
    //   1758: astore 4
    //   1760: goto -1492 -> 268
    //   1763: astore 14
    //   1765: aload_1
    //   1766: astore 13
    //   1768: aload 14
    //   1770: astore_1
    //   1771: goto +222 -> 1993
    //   1774: astore 15
    //   1776: aload 4
    //   1778: astore 16
    //   1780: goto +240 -> 2020
    //   1783: astore 4
    //   1785: aload_1
    //   1786: astore 13
    //   1788: aload 4
    //   1790: astore_1
    //   1791: goto +22 -> 1813
    //   1794: astore 4
    //   1796: aload_1
    //   1797: astore 13
    //   1799: aload 4
    //   1801: astore_1
    //   1802: goto +22 -> 1824
    //   1805: astore 4
    //   1807: aload_1
    //   1808: astore 13
    //   1810: aload 4
    //   1812: astore_1
    //   1813: goto +177 -> 1990
    //   1816: astore 4
    //   1818: aload_1
    //   1819: astore 13
    //   1821: aload 4
    //   1823: astore_1
    //   1824: goto +162 -> 1986
    //   1827: astore_1
    //   1828: goto +158 -> 1986
    //   1831: getstatic 30	com/tencent/mobileqq/secspy/SecSpyFileManager:e	Ljava/lang/String;
    //   1834: astore_1
    //   1835: aload_0
    //   1836: lload_2
    //   1837: iconst_m1
    //   1838: iconst_1
    //   1839: anewarray 4	java/lang/Object
    //   1842: dup
    //   1843: iconst_0
    //   1844: aload_1
    //   1845: aastore
    //   1846: invokevirtual 131	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1849: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1852: ifeq +37 -> 1889
    //   1855: new 157	java/lang/StringBuilder
    //   1858: dup
    //   1859: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1862: astore_1
    //   1863: aload_1
    //   1864: ldc_w 704
    //   1867: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: pop
    //   1871: aload_1
    //   1872: aload 13
    //   1874: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1877: pop
    //   1878: ldc_w 287
    //   1881: iconst_2
    //   1882: aload_1
    //   1883: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1886: invokestatic 479	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1889: iload 5
    //   1891: ifeq +52 -> 1943
    //   1894: new 157	java/lang/StringBuilder
    //   1897: dup
    //   1898: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1901: astore_1
    //   1902: aload_1
    //   1903: aload 13
    //   1905: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: pop
    //   1909: aload_1
    //   1910: aload_0
    //   1911: getfield 47	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   1914: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: pop
    //   1918: aload_0
    //   1919: aload_1
    //   1920: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1923: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   1926: astore_1
    //   1927: aload_1
    //   1928: ifnull +15 -> 1943
    //   1931: aload_1
    //   1932: invokevirtual 115	java/io/File:exists	()Z
    //   1935: ifeq +8 -> 1943
    //   1938: aload_1
    //   1939: invokevirtual 298	java/io/File:delete	()Z
    //   1942: pop
    //   1943: aload 18
    //   1945: iconst_1
    //   1946: invokestatic 581	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   1949: pop
    //   1950: goto +25 -> 1975
    //   1953: astore_1
    //   1954: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1957: ifeq +14 -> 1971
    //   1960: ldc_w 287
    //   1963: iconst_2
    //   1964: ldc_w 583
    //   1967: aload_1
    //   1968: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1971: aload_1
    //   1972: invokevirtual 380	java/lang/Exception:printStackTrace	()V
    //   1975: iconst_0
    //   1976: ireturn
    //   1977: astore_1
    //   1978: goto +33 -> 2011
    //   1981: astore_1
    //   1982: goto +8 -> 1990
    //   1985: astore_1
    //   1986: goto +25 -> 2011
    //   1989: astore_1
    //   1990: aconst_null
    //   1991: astore 4
    //   1993: aconst_null
    //   1994: astore 14
    //   1996: aconst_null
    //   1997: astore 16
    //   1999: aload 4
    //   2001: astore 15
    //   2003: aload 16
    //   2005: astore 4
    //   2007: goto +194 -> 2201
    //   2010: astore_1
    //   2011: aload_1
    //   2012: astore 15
    //   2014: aconst_null
    //   2015: astore 16
    //   2017: aload 13
    //   2019: astore_1
    //   2020: aconst_null
    //   2021: astore 4
    //   2023: aconst_null
    //   2024: astore 14
    //   2026: aload 16
    //   2028: astore 13
    //   2030: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2033: ifeq +15 -> 2048
    //   2036: ldc_w 287
    //   2039: iconst_2
    //   2040: ldc_w 706
    //   2043: aload 15
    //   2045: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2048: aload_0
    //   2049: lload_2
    //   2050: iconst_m1
    //   2051: iconst_1
    //   2052: anewarray 4	java/lang/Object
    //   2055: dup
    //   2056: iconst_0
    //   2057: aload 15
    //   2059: invokevirtual 285	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2062: aastore
    //   2063: invokevirtual 131	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2066: aload 4
    //   2068: ifnull +11 -> 2079
    //   2071: aload 4
    //   2073: invokevirtual 702	java/io/DataOutputStream:close	()V
    //   2076: goto +3 -> 2079
    //   2079: aload 14
    //   2081: ifnull +8 -> 2089
    //   2084: aload 14
    //   2086: invokevirtual 264	java/io/FileInputStream:close	()V
    //   2089: aload 13
    //   2091: ifnull +8 -> 2099
    //   2094: aload 13
    //   2096: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   2099: iload 5
    //   2101: ifeq +55 -> 2156
    //   2104: new 157	java/lang/StringBuilder
    //   2107: dup
    //   2108: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   2111: astore 4
    //   2113: aload 4
    //   2115: aload_1
    //   2116: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: pop
    //   2120: aload 4
    //   2122: aload_0
    //   2123: getfield 47	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   2126: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: pop
    //   2130: aload_0
    //   2131: aload 4
    //   2133: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2136: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   2139: astore_1
    //   2140: aload_1
    //   2141: ifnull +15 -> 2156
    //   2144: aload_1
    //   2145: invokevirtual 115	java/io/File:exists	()Z
    //   2148: ifeq +8 -> 2156
    //   2151: aload_1
    //   2152: invokevirtual 298	java/io/File:delete	()Z
    //   2155: pop
    //   2156: aload 18
    //   2158: iconst_1
    //   2159: invokestatic 581	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   2162: pop
    //   2163: goto +24 -> 2187
    //   2166: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2169: ifeq +14 -> 2183
    //   2172: ldc_w 287
    //   2175: iconst_2
    //   2176: ldc_w 583
    //   2179: aload_1
    //   2180: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2183: aload_1
    //   2184: invokevirtual 380	java/lang/Exception:printStackTrace	()V
    //   2187: iconst_0
    //   2188: ireturn
    //   2189: astore 16
    //   2191: aload 13
    //   2193: astore 15
    //   2195: aload_1
    //   2196: astore 13
    //   2198: aload 16
    //   2200: astore_1
    //   2201: aload 4
    //   2203: ifnull +11 -> 2214
    //   2206: aload 4
    //   2208: invokevirtual 702	java/io/DataOutputStream:close	()V
    //   2211: goto +3 -> 2214
    //   2214: aload 14
    //   2216: ifnull +8 -> 2224
    //   2219: aload 14
    //   2221: invokevirtual 264	java/io/FileInputStream:close	()V
    //   2224: aload 15
    //   2226: ifnull +8 -> 2234
    //   2229: aload 15
    //   2231: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   2234: iload 5
    //   2236: ifeq +60 -> 2296
    //   2239: new 157	java/lang/StringBuilder
    //   2242: dup
    //   2243: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   2246: astore 4
    //   2248: aload 4
    //   2250: aload 13
    //   2252: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: pop
    //   2256: aload 4
    //   2258: aload_0
    //   2259: getfield 47	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   2262: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: pop
    //   2266: aload_0
    //   2267: aload 4
    //   2269: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2272: invokevirtual 109	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   2275: astore 4
    //   2277: aload 4
    //   2279: ifnull +17 -> 2296
    //   2282: aload 4
    //   2284: invokevirtual 115	java/io/File:exists	()Z
    //   2287: ifeq +9 -> 2296
    //   2290: aload 4
    //   2292: invokevirtual 298	java/io/File:delete	()Z
    //   2295: pop
    //   2296: aload 18
    //   2298: iconst_1
    //   2299: invokestatic 581	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   2302: pop
    //   2303: goto +26 -> 2329
    //   2306: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2309: ifeq +15 -> 2324
    //   2312: ldc_w 287
    //   2315: iconst_2
    //   2316: ldc_w 583
    //   2319: aload 4
    //   2321: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2324: aload 4
    //   2326: invokevirtual 380	java/lang/Exception:printStackTrace	()V
    //   2329: goto +5 -> 2334
    //   2332: aload_1
    //   2333: athrow
    //   2334: goto -2 -> 2332
    //   2337: ldc2_w 707
    //   2340: lstore 8
    //   2342: goto -2274 -> 68
    //   2345: astore_1
    //   2346: goto -180 -> 2166
    //   2349: astore 4
    //   2351: goto -45 -> 2306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2354	0	this	SecSpyFileManager
    //   0	2354	1	paramString1	String
    //   0	2354	2	paramLong	long
    //   0	2354	4	paramString2	String
    //   0	2354	5	paramBoolean	boolean
    //   1261	310	6	i	int
    //   1271	103	7	j	int
    //   63	2278	8	l1	long
    //   73	3	10	l2	long
    //   750	937	12	bool	boolean
    //   1	160	13	str1	String
    //   233	15	13	localObject1	Object
    //   252	1999	13	localObject2	Object
    //   236	1325	14	localObject3	Object
    //   1715	10	14	localObject4	Object
    //   1730	17	14	localObject5	Object
    //   1763	6	14	localObject6	Object
    //   1994	226	14	localObject7	Object
    //   239	1	15	localObject8	Object
    //   257	1	15	localException1	Exception
    //   293	380	15	localObject9	Object
    //   846	358	15	localException2	Exception
    //   1277	94	15	arrayOfByte	byte[]
    //   1383	7	15	localObject10	Object
    //   1395	1	15	str2	String
    //   1404	1	15	localException3	Exception
    //   1424	109	15	localObject11	Object
    //   1689	7	15	localObject12	Object
    //   1701	1	15	str3	String
    //   1710	1	15	localException4	Exception
    //   1722	13	15	str4	String
    //   1743	1	15	localException5	Exception
    //   1774	1	15	localException6	Exception
    //   2001	229	15	localObject13	Object
    //   27	2000	16	localObject14	Object
    //   2189	10	16	localObject15	Object
    //   285	523	17	str5	String
    //   20	2277	18	localUploadProgressInfo	SecSpyFileManager.UploadProgressInfo
    //   776	50	19	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   151	184	209	java/lang/Exception
    //   188	200	209	java/lang/Exception
    //   200	207	209	java/lang/Exception
    //   83	146	233	finally
    //   300	380	233	finally
    //   385	393	233	finally
    //   397	405	233	finally
    //   405	459	233	finally
    //   83	146	257	java/lang/Exception
    //   300	380	257	java/lang/Exception
    //   385	393	257	java/lang/Exception
    //   397	405	257	java/lang/Exception
    //   405	459	257	java/lang/Exception
    //   464	497	522	java/lang/Exception
    //   501	513	522	java/lang/Exception
    //   513	520	522	java/lang/Exception
    //   551	584	609	java/lang/Exception
    //   588	600	609	java/lang/Exception
    //   600	607	609	java/lang/Exception
    //   757	832	835	finally
    //   879	894	835	finally
    //   904	942	835	finally
    //   757	832	846	java/lang/Exception
    //   879	894	846	java/lang/Exception
    //   904	942	846	java/lang/Exception
    //   1330	1380	1383	finally
    //   1496	1550	1383	finally
    //   1330	1380	1404	java/lang/Exception
    //   1496	1550	1404	java/lang/Exception
    //   1582	1587	1664	java/lang/Exception
    //   1592	1597	1664	java/lang/Exception
    //   1602	1638	1664	java/lang/Exception
    //   1642	1654	1664	java/lang/Exception
    //   1654	1661	1664	java/lang/Exception
    //   1256	1325	1689	finally
    //   1409	1491	1689	finally
    //   1550	1565	1689	finally
    //   1256	1325	1710	java/lang/Exception
    //   1409	1491	1710	java/lang/Exception
    //   1550	1565	1710	java/lang/Exception
    //   1137	1256	1715	finally
    //   1137	1256	1743	java/lang/Exception
    //   959	1137	1763	finally
    //   959	1137	1774	java/lang/Exception
    //   860	870	1783	finally
    //   894	899	1783	finally
    //   942	959	1783	finally
    //   860	870	1794	java/lang/Exception
    //   894	899	1794	java/lang/Exception
    //   942	959	1794	java/lang/Exception
    //   695	743	1805	finally
    //   743	752	1805	finally
    //   695	743	1816	java/lang/Exception
    //   743	752	1816	java/lang/Exception
    //   34	50	1827	java/lang/Exception
    //   53	60	1827	java/lang/Exception
    //   68	75	1827	java/lang/Exception
    //   271	287	1827	java/lang/Exception
    //   633	695	1827	java/lang/Exception
    //   1894	1927	1953	java/lang/Exception
    //   1931	1943	1953	java/lang/Exception
    //   1943	1950	1953	java/lang/Exception
    //   1835	1889	1977	java/lang/Exception
    //   1831	1835	1981	finally
    //   1835	1889	1981	finally
    //   1831	1835	1985	java/lang/Exception
    //   22	29	1989	finally
    //   34	50	1989	finally
    //   53	60	1989	finally
    //   68	75	1989	finally
    //   271	287	1989	finally
    //   633	695	1989	finally
    //   22	29	2010	java/lang/Exception
    //   2030	2048	2189	finally
    //   2048	2066	2189	finally
    //   2071	2076	2345	java/lang/Exception
    //   2084	2089	2345	java/lang/Exception
    //   2094	2099	2345	java/lang/Exception
    //   2104	2140	2345	java/lang/Exception
    //   2144	2156	2345	java/lang/Exception
    //   2156	2163	2345	java/lang/Exception
    //   2206	2211	2349	java/lang/Exception
    //   2219	2224	2349	java/lang/Exception
    //   2229	2234	2349	java/lang/Exception
    //   2239	2277	2349	java/lang/Exception
    //   2282	2296	2349	java/lang/Exception
    //   2296	2303	2349	java/lang/Exception
  }
  
  public void b(List<String> paramList, long paramLong, String paramString)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a(paramList), paramLong, paramString, false);
    UnifiedFileUtil.a(paramList);
    paramList.clear();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager
 * JD-Core Version:    0.7.0.1
 */