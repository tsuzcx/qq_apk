package com.tencent.mobileqq.vip;

import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class DownloaderFactory
  implements Manager
{
  static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  private static Map jdField_a_of_type_JavaUtilMap = new DownloaderFactory.2();
  public static ConcurrentHashMap a;
  public static volatile boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static ConcurrentHashMap b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ArrayOfInt = WebpSoLoader.a();
  }
  
  public DownloaderFactory(AppRuntime paramAppRuntime)
  {
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  /* Error */
  public static int a(DownloadTask paramDownloadTask, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 74
    //   8: iconst_2
    //   9: ldc 76
    //   11: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: bipush 254
    //   16: istore_3
    //   17: aload_0
    //   18: invokevirtual 85	com/tencent/mobileqq/vip/DownloadTask:a	()Lcom/tencent/mobileqq/vip/DownloadListener;
    //   21: ifnonnull +14 -> 35
    //   24: aload_0
    //   25: new 87	aksn
    //   28: dup
    //   29: invokespecial 88	aksn:<init>	()V
    //   32: invokevirtual 91	com/tencent/mobileqq/vip/DownloadTask:a	(Lcom/tencent/mobileqq/vip/DownloadListener;)V
    //   35: aload_1
    //   36: ifnull +26 -> 62
    //   39: aload_0
    //   40: getfield 94	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo	Lcom/tencent/mobileqq/vip/DownloadTask$ReportInfo;
    //   43: getfield 99	com/tencent/mobileqq/vip/DownloadTask$ReportInfo:a	J
    //   46: lconst_0
    //   47: lcmp
    //   48: ifge +14 -> 62
    //   51: aload_0
    //   52: getfield 94	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo	Lcom/tencent/mobileqq/vip/DownloadTask$ReportInfo;
    //   55: aload_1
    //   56: invokestatic 105	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   59: putfield 99	com/tencent/mobileqq/vip/DownloadTask$ReportInfo:a	J
    //   62: iload_3
    //   63: istore 5
    //   65: aload_0
    //   66: ifnull +255 -> 321
    //   69: aload_0
    //   70: invokestatic 110	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   73: iconst_m1
    //   74: istore 5
    //   76: iload 5
    //   78: istore_3
    //   79: aload_0
    //   80: invokevirtual 113	com/tencent/mobileqq/vip/DownloadTask:c	()Z
    //   83: ifne +62 -> 145
    //   86: iload 5
    //   88: istore_3
    //   89: aload_0
    //   90: bipush 147
    //   92: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   95: iload 5
    //   97: istore_3
    //   98: aload_0
    //   99: invokevirtual 119	com/tencent/mobileqq/vip/DownloadTask:e	()V
    //   102: iload 5
    //   104: istore_3
    //   105: iload 5
    //   107: istore 4
    //   109: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +7546 -> 7658
    //   115: iload 5
    //   117: istore_3
    //   118: ldc 74
    //   120: iconst_2
    //   121: new 121	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   128: ldc 124
    //   130: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: iconst_m1
    //   144: ireturn
    //   145: iload 5
    //   147: istore_3
    //   148: new 137	org/apache/http/params/BasicHttpParams
    //   151: dup
    //   152: invokespecial 138	org/apache/http/params/BasicHttpParams:<init>	()V
    //   155: astore 38
    //   157: iload 5
    //   159: istore_3
    //   160: aload 38
    //   162: ldc 140
    //   164: sipush 10000
    //   167: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokeinterface 152 3 0
    //   175: pop
    //   176: iload 5
    //   178: istore_3
    //   179: aload 38
    //   181: ldc 154
    //   183: ldc 155
    //   185: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: invokeinterface 152 3 0
    //   193: pop
    //   194: iload 5
    //   196: istore_3
    //   197: aload_0
    //   198: getfield 158	com/tencent/mobileqq/vip/DownloadTask:l	Z
    //   201: ifeq +159 -> 360
    //   204: ldc 160
    //   206: astore 28
    //   208: iload 5
    //   210: istore_3
    //   211: aload 38
    //   213: ldc 162
    //   215: aload 28
    //   217: invokeinterface 152 3 0
    //   222: pop
    //   223: iload 5
    //   225: istore_3
    //   226: aload_0
    //   227: getfield 165	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   230: ifnull +18 -> 248
    //   233: iload 5
    //   235: istore_3
    //   236: aload_0
    //   237: getfield 165	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   240: invokeinterface 171 1 0
    //   245: ifgt +122 -> 367
    //   248: iload 5
    //   250: istore_3
    //   251: aload_0
    //   252: bipush 149
    //   254: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   257: iload 5
    //   259: istore_3
    //   260: aload_0
    //   261: invokevirtual 119	com/tencent/mobileqq/vip/DownloadTask:e	()V
    //   264: iload 5
    //   266: istore_3
    //   267: iload 5
    //   269: istore 4
    //   271: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +7384 -> 7658
    //   277: iload 5
    //   279: istore_3
    //   280: ldc 74
    //   282: iconst_2
    //   283: new 121	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   290: ldc 173
    //   292: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_0
    //   296: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: iconst_m1
    //   306: ireturn
    //   307: astore_0
    //   308: ldc 74
    //   310: iconst_1
    //   311: aload_0
    //   312: invokevirtual 176	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   315: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: iload_3
    //   319: istore 5
    //   321: iload 5
    //   323: istore 4
    //   325: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +7330 -> 7658
    //   331: ldc 74
    //   333: iconst_2
    //   334: new 121	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   341: ldc 180
    //   343: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload 5
    //   348: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: iload 5
    //   359: ireturn
    //   360: ldc 185
    //   362: astore 28
    //   364: goto -156 -> 208
    //   367: iload 5
    //   369: istore_3
    //   370: aload_0
    //   371: getfield 165	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   374: invokeinterface 171 1 0
    //   379: istore 9
    //   381: iconst_0
    //   382: istore 10
    //   384: aconst_null
    //   385: astore 28
    //   387: iconst_m1
    //   388: istore 8
    //   390: aconst_null
    //   391: astore 30
    //   393: aconst_null
    //   394: astore 29
    //   396: sipush 2048
    //   399: istore_3
    //   400: iconst_0
    //   401: istore 13
    //   403: iload 8
    //   405: istore 4
    //   407: iload 10
    //   409: aload_0
    //   410: getfield 165	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   413: invokeinterface 171 1 0
    //   418: if_icmpge +6390 -> 6808
    //   421: iconst_m1
    //   422: istore 4
    //   424: iload 4
    //   426: istore 8
    //   428: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   431: lstore 24
    //   433: iload 4
    //   435: istore 8
    //   437: new 4	java/lang/Object
    //   440: dup
    //   441: invokespecial 34	java/lang/Object:<init>	()V
    //   444: astore 39
    //   446: lconst_0
    //   447: lstore 16
    //   449: iload 4
    //   451: istore 8
    //   453: new 193	java/util/HashMap
    //   456: dup
    //   457: invokespecial 194	java/util/HashMap:<init>	()V
    //   460: astore 35
    //   462: iload 4
    //   464: istore 8
    //   466: aload_0
    //   467: getfield 165	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   470: iload 10
    //   472: invokeinterface 198 2 0
    //   477: checkcast 200	java/lang/String
    //   480: astore 32
    //   482: iload 4
    //   484: istore 8
    //   486: aload_0
    //   487: aload 32
    //   489: putfield 203	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   492: iload 4
    //   494: istore 8
    //   496: aload_0
    //   497: getfield 204	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   500: aload 32
    //   502: invokeinterface 209 2 0
    //   507: checkcast 211	java/io/File
    //   510: astore 37
    //   512: ldc 213
    //   514: astore 33
    //   516: aload 37
    //   518: ifnull +6188 -> 6706
    //   521: iload 4
    //   523: istore 8
    //   525: aload 37
    //   527: invokevirtual 217	java/io/File:getParentFile	()Ljava/io/File;
    //   530: astore 40
    //   532: iload 4
    //   534: istore 8
    //   536: new 211	java/io/File
    //   539: dup
    //   540: aload 40
    //   542: new 121	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   549: aload 37
    //   551: invokevirtual 220	java/io/File:getName	()Ljava/lang/String;
    //   554: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: ldc 222
    //   559: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokespecial 225	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   568: astore 41
    //   570: aload 32
    //   572: astore 31
    //   574: iload 4
    //   576: istore 8
    //   578: aload_0
    //   579: getfield 227	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   582: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   585: ifne +18 -> 603
    //   588: iload 4
    //   590: istore 8
    //   592: aload_0
    //   593: getfield 227	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   596: aload 32
    //   598: invokestatic 239	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   601: astore 31
    //   603: iload 4
    //   605: istore 8
    //   607: new 241	com/tencent/mobileqq/emoticon/DownloadInfo
    //   610: dup
    //   611: aload 31
    //   613: aconst_null
    //   614: iconst_0
    //   615: invokespecial 244	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   618: astore 36
    //   620: aload 31
    //   622: astore 33
    //   624: iconst_0
    //   625: istore 7
    //   627: iconst_m1
    //   628: istore 11
    //   630: iconst_m1
    //   631: istore 6
    //   633: lconst_0
    //   634: lstore 18
    //   636: aload 28
    //   638: astore 32
    //   640: aload 29
    //   642: astore 31
    //   644: aload 33
    //   646: astore 28
    //   648: iload 6
    //   650: istore 4
    //   652: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   655: lstore 26
    //   657: iload 6
    //   659: istore 4
    //   661: new 121	java/lang/StringBuilder
    //   664: dup
    //   665: ldc 246
    //   667: invokespecial 249	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   670: ldc 251
    //   672: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: aload_0
    //   676: getfield 158	com/tencent/mobileqq/vip/DownloadTask:l	Z
    //   679: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   682: ldc_w 256
    //   685: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload_0
    //   689: getfield 259	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   692: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   695: ldc_w 261
    //   698: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload_0
    //   702: getfield 263	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Int	I
    //   705: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   708: astore 42
    //   710: iconst_0
    //   711: istore 8
    //   713: iconst_0
    //   714: istore 5
    //   716: iconst_0
    //   717: istore 12
    //   719: aload 28
    //   721: astore 34
    //   723: aload 28
    //   725: astore 33
    //   727: iload 5
    //   729: istore 4
    //   731: aload 36
    //   733: invokevirtual 265	com/tencent/mobileqq/emoticon/DownloadInfo:a	()V
    //   736: aload 40
    //   738: ifnull +1168 -> 1906
    //   741: aload 28
    //   743: astore 34
    //   745: aload 28
    //   747: astore 33
    //   749: iload 5
    //   751: istore 4
    //   753: aload 40
    //   755: invokevirtual 268	java/io/File:exists	()Z
    //   758: ifne +1148 -> 1906
    //   761: aload 28
    //   763: astore 34
    //   765: aload 28
    //   767: astore 33
    //   769: iload 5
    //   771: istore 4
    //   773: aload 40
    //   775: invokevirtual 271	java/io/File:mkdirs	()Z
    //   778: ifne +1128 -> 1906
    //   781: iconst_1
    //   782: istore 4
    //   784: iconst_1
    //   785: istore 12
    //   787: bipush 153
    //   789: istore 8
    //   791: aload 28
    //   793: astore 34
    //   795: aload 28
    //   797: astore 33
    //   799: aload_0
    //   800: bipush 153
    //   802: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   805: iload 12
    //   807: istore 5
    //   809: iload 8
    //   811: istore 4
    //   813: iload 8
    //   815: istore 6
    //   817: aload 42
    //   819: ldc_w 273
    //   822: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: aload 40
    //   827: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   830: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: ldc_w 278
    //   836: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: invokestatic 282	com/tencent/mobileqq/util/Utils:a	()Z
    //   842: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   845: ldc_w 284
    //   848: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokestatic 286	com/tencent/mobileqq/util/Utils:b	()J
    //   854: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: iload 12
    //   860: istore 5
    //   862: iload 8
    //   864: istore 4
    //   866: iload 8
    //   868: istore 6
    //   870: new 64	java/lang/Exception
    //   873: dup
    //   874: ldc_w 291
    //   877: invokespecial 292	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   880: athrow
    //   881: astore 33
    //   883: iload_3
    //   884: istore 6
    //   886: iconst_0
    //   887: istore 13
    //   889: iload 5
    //   891: istore 8
    //   893: iload 4
    //   895: istore_3
    //   896: aload 31
    //   898: astore 29
    //   900: aload 32
    //   902: astore 31
    //   904: iload 6
    //   906: istore 5
    //   908: iload 8
    //   910: istore 4
    //   912: iload 7
    //   914: istore 6
    //   916: aload 33
    //   918: astore 32
    //   920: iconst_0
    //   921: istore 7
    //   923: aload 32
    //   925: instanceof 294
    //   928: ifne +6733 -> 7661
    //   931: aload 32
    //   933: instanceof 296
    //   936: ifne +6725 -> 7661
    //   939: aload 32
    //   941: instanceof 298
    //   944: ifeq +6 -> 950
    //   947: goto +6714 -> 7661
    //   950: aload 32
    //   952: instanceof 62
    //   955: ifeq +5446 -> 6401
    //   958: aload_0
    //   959: bipush 145
    //   961: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   964: aload_0
    //   965: aload 32
    //   967: invokevirtual 176	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   970: putfield 300	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   973: iload 13
    //   975: ifne +18 -> 993
    //   978: iload 7
    //   980: ifeq +13 -> 993
    //   983: iload 6
    //   985: ifeq +5491 -> 6476
    //   988: aload_0
    //   989: iconst_1
    //   990: putfield 303	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   993: aload 42
    //   995: ldc_w 305
    //   998: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokestatic 308	com/tencent/mobileqq/utils/FileUtils:a	()Z
    //   1004: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1007: ldc_w 310
    //   1010: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: invokestatic 313	com/tencent/mobileqq/utils/FileUtils:c	()F
    //   1016: ldc_w 314
    //   1019: fdiv
    //   1020: invokevirtual 317	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1023: pop
    //   1024: aload 42
    //   1026: ldc_w 319
    //   1029: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: aload 32
    //   1034: invokevirtual 176	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1037: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: iload_3
    //   1042: istore 8
    //   1044: ldc 74
    //   1046: iconst_1
    //   1047: new 121	java/lang/StringBuilder
    //   1050: dup
    //   1051: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1054: aload 42
    //   1056: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1059: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: ldc_w 321
    //   1065: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   1071: lload 26
    //   1073: lsub
    //   1074: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokestatic 324	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: iload_3
    //   1084: ifeq +112 -> 1196
    //   1087: iload_3
    //   1088: istore 8
    //   1090: aload_0
    //   1091: invokevirtual 326	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   1094: ifne +102 -> 1196
    //   1097: iload_3
    //   1098: istore 8
    //   1100: aload_0
    //   1101: getfield 328	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   1104: ifeq +92 -> 1196
    //   1107: iload_3
    //   1108: istore 8
    //   1110: aload 36
    //   1112: getfield 329	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1115: ifeq +5403 -> 6518
    //   1118: iload_3
    //   1119: istore 8
    //   1121: aload 36
    //   1123: getfield 331	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1126: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1129: ifne +5355 -> 6484
    //   1132: iload_3
    //   1133: istore 8
    //   1135: invokestatic 336	com/tencent/mobileqq/transfile/dns/InnerDns:a	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   1138: aload 36
    //   1140: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1143: aload 36
    //   1145: getfield 331	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1148: getstatic 31	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1151: aload 36
    //   1153: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1156: invokeinterface 209 2 0
    //   1161: checkcast 142	java/lang/Integer
    //   1164: invokevirtual 340	java/lang/Integer:intValue	()I
    //   1167: invokevirtual 343	com/tencent/mobileqq/transfile/dns/InnerDns:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1170: iload_3
    //   1171: istore 8
    //   1173: aload 36
    //   1175: getfield 344	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1178: aload 37
    //   1180: invokevirtual 220	java/io/File:getName	()Ljava/lang/String;
    //   1183: iconst_m1
    //   1184: aload_2
    //   1185: invokestatic 347	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   1188: iload_3
    //   1189: istore 8
    //   1191: aload_0
    //   1192: iconst_0
    //   1193: putfield 349	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   1196: iload_3
    //   1197: istore 8
    //   1199: new 121	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1206: astore 33
    //   1208: iload_3
    //   1209: istore 8
    //   1211: aload 36
    //   1213: getfield 351	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   1216: ifeq +6695 -> 7911
    //   1219: ldc_w 353
    //   1222: astore 32
    //   1224: iload_3
    //   1225: istore 8
    //   1227: aload 33
    //   1229: aload 32
    //   1231: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: astore 33
    //   1236: iload_3
    //   1237: istore 8
    //   1239: aload 36
    //   1241: getfield 329	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1244: ifeq +6675 -> 7919
    //   1247: ldc_w 355
    //   1250: astore 32
    //   1252: iload_3
    //   1253: istore 8
    //   1255: aload 33
    //   1257: aload 32
    //   1259: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1265: astore 32
    //   1267: iload 11
    //   1269: iconst_1
    //   1270: iadd
    //   1271: istore 7
    //   1273: aload 31
    //   1275: ifnull +13 -> 1288
    //   1278: iload_3
    //   1279: istore 8
    //   1281: aload 31
    //   1283: invokeinterface 360 1 0
    //   1288: aload 30
    //   1290: ifnull +11 -> 1301
    //   1293: iload_3
    //   1294: istore 8
    //   1296: aload 30
    //   1298: invokevirtual 365	java/io/InputStream:close	()V
    //   1301: aload 29
    //   1303: ifnull +11 -> 1314
    //   1306: iload_3
    //   1307: istore 8
    //   1309: aload 29
    //   1311: invokevirtual 368	java/io/BufferedOutputStream:close	()V
    //   1314: iload 7
    //   1316: istore 8
    //   1318: lload 18
    //   1320: lstore 20
    //   1322: iload 4
    //   1324: istore 7
    //   1326: iload 5
    //   1328: istore 4
    //   1330: lload 16
    //   1332: lstore 18
    //   1334: lload 20
    //   1336: lstore 16
    //   1338: iload 8
    //   1340: istore 5
    //   1342: iload_3
    //   1343: ifeq +34 -> 1377
    //   1346: iload 7
    //   1348: ifne +29 -> 1377
    //   1351: iload_3
    //   1352: istore 8
    //   1354: iload 5
    //   1356: aload_0
    //   1357: getfield 263	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Int	I
    //   1360: if_icmpge +17 -> 1377
    //   1363: iload_3
    //   1364: istore 8
    //   1366: aload_0
    //   1367: invokevirtual 326	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   1370: istore 14
    //   1372: iload 14
    //   1374: ifeq +6243 -> 7617
    //   1377: aload 29
    //   1379: astore 33
    //   1381: lload 18
    //   1383: lstore 20
    //   1385: aload 31
    //   1387: astore 29
    //   1389: aload 30
    //   1391: astore 34
    //   1393: lload 16
    //   1395: lstore 18
    //   1397: lload 20
    //   1399: lstore 16
    //   1401: aload 28
    //   1403: astore 31
    //   1405: iload 5
    //   1407: istore 6
    //   1409: aload 29
    //   1411: astore 30
    //   1413: aload 34
    //   1415: astore 29
    //   1417: aload 33
    //   1419: astore 28
    //   1421: iload 4
    //   1423: istore 5
    //   1425: iload_3
    //   1426: istore 4
    //   1428: aload_0
    //   1429: invokevirtual 370	com/tencent/mobileqq/vip/DownloadTask:d	()V
    //   1432: aload 35
    //   1434: astore 33
    //   1436: aload 35
    //   1438: ifnonnull +15 -> 1453
    //   1441: iload_3
    //   1442: istore 4
    //   1444: new 193	java/util/HashMap
    //   1447: dup
    //   1448: invokespecial 194	java/util/HashMap:<init>	()V
    //   1451: astore 33
    //   1453: iload_3
    //   1454: istore 4
    //   1456: aload 33
    //   1458: ldc_w 372
    //   1461: aload 31
    //   1463: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1466: pop
    //   1467: iload_3
    //   1468: istore 4
    //   1470: aload 33
    //   1472: ldc_w 378
    //   1475: aload_0
    //   1476: getfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   1479: invokestatic 381	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1482: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1485: pop
    //   1486: iload_3
    //   1487: istore 4
    //   1489: aload 33
    //   1491: ldc_w 383
    //   1494: aload_0
    //   1495: getfield 385	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Int	I
    //   1498: invokestatic 381	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1501: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1504: pop
    //   1505: iload_3
    //   1506: istore 4
    //   1508: aload 33
    //   1510: ldc_w 387
    //   1513: iload 6
    //   1515: invokestatic 381	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1518: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1521: pop
    //   1522: iload_3
    //   1523: istore 4
    //   1525: aload 33
    //   1527: ldc_w 389
    //   1530: lload 16
    //   1532: invokestatic 392	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1535: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1538: pop
    //   1539: iload_3
    //   1540: istore 4
    //   1542: aload 33
    //   1544: ldc_w 394
    //   1547: aload_0
    //   1548: getfield 165	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1551: invokeinterface 171 1 0
    //   1556: invokestatic 381	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1559: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1562: pop
    //   1563: iload_3
    //   1564: istore 4
    //   1566: aload 33
    //   1568: ldc_w 396
    //   1571: aload_0
    //   1572: getfield 398	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1575: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1578: pop
    //   1579: iload_3
    //   1580: istore 4
    //   1582: aload 33
    //   1584: ldc_w 400
    //   1587: iload 13
    //   1589: invokestatic 405	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1592: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1595: pop
    //   1596: iload_3
    //   1597: istore 4
    //   1599: aload 33
    //   1601: ldc_w 407
    //   1604: aload 32
    //   1606: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1609: pop
    //   1610: ldc 213
    //   1612: astore 34
    //   1614: iload_3
    //   1615: istore 4
    //   1617: aload_0
    //   1618: getfield 300	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1621: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1624: ifne +6043 -> 7667
    //   1627: iload_3
    //   1628: istore 4
    //   1630: aload 33
    //   1632: ldc_w 409
    //   1635: aload_0
    //   1636: getfield 300	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1639: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1642: pop
    //   1643: iload_3
    //   1644: istore 4
    //   1646: aload_0
    //   1647: getfield 300	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1650: astore 34
    //   1652: goto +6015 -> 7667
    //   1655: iload_3
    //   1656: istore 4
    //   1658: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   1661: lstore 20
    //   1663: aload_2
    //   1664: ifnull +197 -> 1861
    //   1667: iload_3
    //   1668: istore 4
    //   1670: aload_1
    //   1671: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1674: istore 15
    //   1676: iload 15
    //   1678: ifne +183 -> 1861
    //   1681: ldc_w 411
    //   1684: aload 31
    //   1686: new 121	java/lang/StringBuilder
    //   1689: dup
    //   1690: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1693: aload_0
    //   1694: getfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   1697: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1700: ldc 213
    //   1702: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: new 121	java/lang/StringBuilder
    //   1711: dup
    //   1712: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1715: lload 16
    //   1717: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1720: ldc 213
    //   1722: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1728: aload_0
    //   1729: getfield 398	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1732: new 121	java/lang/StringBuilder
    //   1735: dup
    //   1736: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1739: iload 13
    //   1741: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1744: ldc 213
    //   1746: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1752: aload 34
    //   1754: aload 32
    //   1756: ldc 213
    //   1758: ldc_w 413
    //   1761: invokestatic 418	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1764: ldc_w 420
    //   1767: astore 32
    //   1769: aload 32
    //   1771: astore 31
    //   1773: aload_0
    //   1774: getfield 398	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1777: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1780: ifne +57 -> 1837
    //   1783: aload 32
    //   1785: astore 31
    //   1787: aload_0
    //   1788: getfield 398	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1791: ldc_w 422
    //   1794: invokevirtual 425	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1797: ifeq +40 -> 1837
    //   1800: ldc_w 427
    //   1803: astore 31
    //   1805: aload 33
    //   1807: ldc_w 429
    //   1810: aload_0
    //   1811: getfield 432	com/tencent/mobileqq/vip/DownloadTask:p	Z
    //   1814: invokestatic 434	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1817: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1820: pop
    //   1821: aload 33
    //   1823: ldc_w 436
    //   1826: aload_0
    //   1827: getfield 439	com/tencent/mobileqq/vip/DownloadTask:o	Z
    //   1830: invokestatic 434	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1833: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1836: pop
    //   1837: aload_2
    //   1838: invokestatic 444	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1841: aload_1
    //   1842: aload 31
    //   1844: iload 14
    //   1846: lload 20
    //   1848: lload 24
    //   1850: lsub
    //   1851: lload 18
    //   1853: aload 33
    //   1855: ldc 213
    //   1857: iconst_0
    //   1858: invokevirtual 447	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1861: iload_3
    //   1862: ifne +4928 -> 6790
    //   1865: iload 9
    //   1867: iconst_1
    //   1868: isub
    //   1869: istore 4
    //   1871: iload 10
    //   1873: iconst_1
    //   1874: iadd
    //   1875: istore 10
    //   1877: aload 30
    //   1879: astore 31
    //   1881: iload_3
    //   1882: istore 8
    //   1884: aload 29
    //   1886: astore 30
    //   1888: iload 5
    //   1890: istore_3
    //   1891: aload 28
    //   1893: astore 29
    //   1895: aload 31
    //   1897: astore 28
    //   1899: iload 4
    //   1901: istore 9
    //   1903: goto -1500 -> 403
    //   1906: aload 28
    //   1908: astore 34
    //   1910: aload 28
    //   1912: astore 33
    //   1914: iload 5
    //   1916: istore 4
    //   1918: getstatic 43	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1921: ifnonnull +29 -> 1950
    //   1924: aload 28
    //   1926: astore 34
    //   1928: aload 28
    //   1930: astore 33
    //   1932: iload 5
    //   1934: istore 4
    //   1936: invokestatic 49	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1939: ldc 51
    //   1941: invokevirtual 55	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1944: checkcast 57	android/net/ConnectivityManager
    //   1947: putstatic 43	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1950: aload 28
    //   1952: astore 34
    //   1954: aload 28
    //   1956: astore 33
    //   1958: iload 5
    //   1960: istore 4
    //   1962: invokestatic 453	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   1965: astore 43
    //   1967: aload 43
    //   1969: ifnonnull +358 -> 2327
    //   1972: bipush 152
    //   1974: istore 8
    //   1976: aload 28
    //   1978: astore 34
    //   1980: aload 28
    //   1982: astore 33
    //   1984: iload 5
    //   1986: istore 4
    //   1988: aload_0
    //   1989: bipush 152
    //   1991: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   1994: iload 12
    //   1996: istore 5
    //   1998: iload 8
    //   2000: istore 4
    //   2002: iload 8
    //   2004: istore 6
    //   2006: aload 42
    //   2008: ldc_w 455
    //   2011: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2014: pop
    //   2015: iload 12
    //   2017: istore 5
    //   2019: iload 8
    //   2021: istore 4
    //   2023: iload 8
    //   2025: istore 6
    //   2027: new 64	java/lang/Exception
    //   2030: dup
    //   2031: ldc_w 457
    //   2034: invokespecial 292	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2037: athrow
    //   2038: astore_1
    //   2039: iload 6
    //   2041: istore 4
    //   2043: ldc 74
    //   2045: iconst_1
    //   2046: new 121	java/lang/StringBuilder
    //   2049: dup
    //   2050: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2053: aload 42
    //   2055: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2058: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2061: ldc_w 321
    //   2064: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2067: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   2070: lload 26
    //   2072: lsub
    //   2073: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2076: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2079: invokestatic 324	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2082: iload 6
    //   2084: ifeq +119 -> 2203
    //   2087: iload 6
    //   2089: istore 4
    //   2091: aload_0
    //   2092: invokevirtual 326	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   2095: ifne +108 -> 2203
    //   2098: iload 6
    //   2100: istore 4
    //   2102: aload_0
    //   2103: getfield 328	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   2106: ifeq +97 -> 2203
    //   2109: iload 6
    //   2111: istore 4
    //   2113: aload 36
    //   2115: getfield 329	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   2118: ifeq +4528 -> 6646
    //   2121: iload 6
    //   2123: istore 4
    //   2125: aload 36
    //   2127: getfield 331	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2130: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2133: ifne +4477 -> 6610
    //   2136: iload 6
    //   2138: istore 4
    //   2140: invokestatic 336	com/tencent/mobileqq/transfile/dns/InnerDns:a	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   2143: aload 36
    //   2145: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2148: aload 36
    //   2150: getfield 331	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2153: getstatic 31	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   2156: aload 36
    //   2158: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2161: invokeinterface 209 2 0
    //   2166: checkcast 142	java/lang/Integer
    //   2169: invokevirtual 340	java/lang/Integer:intValue	()I
    //   2172: invokevirtual 343	com/tencent/mobileqq/transfile/dns/InnerDns:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2175: iload 6
    //   2177: istore 4
    //   2179: aload 36
    //   2181: getfield 344	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2184: aload 37
    //   2186: invokevirtual 220	java/io/File:getName	()Ljava/lang/String;
    //   2189: iconst_m1
    //   2190: aload_2
    //   2191: invokestatic 347	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   2194: iload 6
    //   2196: istore 4
    //   2198: aload_0
    //   2199: iconst_0
    //   2200: putfield 349	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   2203: iload 6
    //   2205: istore 4
    //   2207: new 121	java/lang/StringBuilder
    //   2210: dup
    //   2211: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2214: astore_2
    //   2215: iload 6
    //   2217: istore 4
    //   2219: aload 36
    //   2221: getfield 351	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   2224: ifeq +5703 -> 7927
    //   2227: ldc_w 353
    //   2230: astore_0
    //   2231: iload 6
    //   2233: istore 4
    //   2235: aload_2
    //   2236: aload_0
    //   2237: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2240: astore_2
    //   2241: iload 6
    //   2243: istore 4
    //   2245: aload 36
    //   2247: getfield 329	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   2250: ifeq +5684 -> 7934
    //   2253: ldc_w 355
    //   2256: astore_0
    //   2257: iload 6
    //   2259: istore 4
    //   2261: aload_2
    //   2262: aload_0
    //   2263: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2269: pop
    //   2270: aload 32
    //   2272: ifnull +14 -> 2286
    //   2275: iload 6
    //   2277: istore 4
    //   2279: aload 32
    //   2281: invokeinterface 360 1 0
    //   2286: aload 30
    //   2288: ifnull +12 -> 2300
    //   2291: iload 6
    //   2293: istore 4
    //   2295: aload 30
    //   2297: invokevirtual 365	java/io/InputStream:close	()V
    //   2300: aload 31
    //   2302: ifnull +12 -> 2314
    //   2305: iload 6
    //   2307: istore 4
    //   2309: aload 31
    //   2311: invokevirtual 368	java/io/BufferedOutputStream:close	()V
    //   2314: iload 6
    //   2316: istore 4
    //   2318: aload_1
    //   2319: athrow
    //   2320: astore_0
    //   2321: iload 4
    //   2323: istore_3
    //   2324: goto -2016 -> 308
    //   2327: aload 28
    //   2329: astore 29
    //   2331: aload 28
    //   2333: astore 34
    //   2335: aload 28
    //   2337: astore 33
    //   2339: iload 5
    //   2341: istore 4
    //   2343: aload_0
    //   2344: getfield 439	com/tencent/mobileqq/vip/DownloadTask:o	Z
    //   2347: ifeq +122 -> 2469
    //   2350: aload 28
    //   2352: astore 29
    //   2354: aload 28
    //   2356: astore 34
    //   2358: aload 28
    //   2360: astore 33
    //   2362: iload 5
    //   2364: istore 4
    //   2366: aload 28
    //   2368: ldc_w 459
    //   2371: invokevirtual 425	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2374: ifne +95 -> 2469
    //   2377: aload 28
    //   2379: astore 34
    //   2381: aload 28
    //   2383: astore 33
    //   2385: iload 5
    //   2387: istore 4
    //   2389: new 461	java/util/Random
    //   2392: dup
    //   2393: aload_1
    //   2394: invokestatic 465	com/tencent/mobileqq/qcall/UinUtils:a	(Ljava/lang/String;)J
    //   2397: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   2400: lor
    //   2401: invokespecial 468	java/util/Random:<init>	(J)V
    //   2404: invokevirtual 471	java/util/Random:nextInt	()I
    //   2407: istore 12
    //   2409: aload 28
    //   2411: astore 34
    //   2413: aload 28
    //   2415: astore 33
    //   2417: iload 5
    //   2419: istore 4
    //   2421: aload 28
    //   2423: invokestatic 474	com/tencent/mobileqq/vip/DownloaderFactory:b	(Ljava/lang/String;)Z
    //   2426: ifeq +383 -> 2809
    //   2429: aload 28
    //   2431: astore 34
    //   2433: aload 28
    //   2435: astore 33
    //   2437: iload 5
    //   2439: istore 4
    //   2441: new 121	java/lang/StringBuilder
    //   2444: dup
    //   2445: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2448: aload 28
    //   2450: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2453: ldc_w 476
    //   2456: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2459: iload 12
    //   2461: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2464: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2467: astore 29
    //   2469: aload 29
    //   2471: astore 34
    //   2473: aload 29
    //   2475: astore 33
    //   2477: iload 5
    //   2479: istore 4
    //   2481: aload 29
    //   2483: invokestatic 479	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2486: astore 28
    //   2488: aload 28
    //   2490: astore 34
    //   2492: aload 28
    //   2494: astore 33
    //   2496: iload 5
    //   2498: istore 4
    //   2500: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2503: ifeq +42 -> 2545
    //   2506: aload 28
    //   2508: astore 34
    //   2510: aload 28
    //   2512: astore 33
    //   2514: iload 5
    //   2516: istore 4
    //   2518: ldc 74
    //   2520: iconst_2
    //   2521: new 121	java/lang/StringBuilder
    //   2524: dup
    //   2525: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2528: ldc_w 481
    //   2531: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2534: aload 28
    //   2536: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2539: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2542: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2545: aload 28
    //   2547: astore 34
    //   2549: aload 28
    //   2551: astore 33
    //   2553: iload 5
    //   2555: istore 4
    //   2557: aload_0
    //   2558: getfield 385	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Int	I
    //   2561: sipush 302
    //   2564: if_icmpne +5046 -> 7610
    //   2567: iload 11
    //   2569: ifne +5041 -> 7610
    //   2572: aload 28
    //   2574: astore 34
    //   2576: aload 28
    //   2578: astore 33
    //   2580: iload 5
    //   2582: istore 4
    //   2584: aload_0
    //   2585: getfield 432	com/tencent/mobileqq/vip/DownloadTask:p	Z
    //   2588: ifeq +5022 -> 7610
    //   2591: aload 28
    //   2593: astore 34
    //   2595: aload 28
    //   2597: astore 33
    //   2599: iload 5
    //   2601: istore 4
    //   2603: aload 28
    //   2605: ldc_w 483
    //   2608: invokevirtual 486	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2611: ifeq +4999 -> 7610
    //   2614: aload 28
    //   2616: astore 34
    //   2618: aload 28
    //   2620: astore 33
    //   2622: iload 5
    //   2624: istore 4
    //   2626: aload_0
    //   2627: iconst_0
    //   2628: putfield 328	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   2631: iconst_1
    //   2632: istore 4
    //   2634: iconst_1
    //   2635: istore 5
    //   2637: aload 28
    //   2639: astore 34
    //   2641: aload 28
    //   2643: astore 33
    //   2645: aload 28
    //   2647: ldc_w 488
    //   2650: ldc_w 490
    //   2653: invokevirtual 493	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2656: astore 28
    //   2658: new 495	org/apache/http/client/methods/HttpGet
    //   2661: dup
    //   2662: aload 28
    //   2664: invokespecial 496	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   2667: astore 33
    //   2669: aload_0
    //   2670: invokevirtual 499	com/tencent/mobileqq/vip/DownloadTask:a	()Ljava/util/Map;
    //   2673: astore 29
    //   2675: aload 29
    //   2677: ifnull +175 -> 2852
    //   2680: aload 29
    //   2682: invokeinterface 503 1 0
    //   2687: invokeinterface 509 1 0
    //   2692: astore 34
    //   2694: aload 34
    //   2696: invokeinterface 514 1 0
    //   2701: ifeq +151 -> 2852
    //   2704: aload 34
    //   2706: invokeinterface 518 1 0
    //   2711: checkcast 200	java/lang/String
    //   2714: astore 44
    //   2716: aload 29
    //   2718: aload 44
    //   2720: invokeinterface 209 2 0
    //   2725: checkcast 200	java/lang/String
    //   2728: astore 45
    //   2730: aload 33
    //   2732: aload 44
    //   2734: aload 45
    //   2736: invokevirtual 522	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2739: aload 42
    //   2741: ldc_w 524
    //   2744: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2747: aload 44
    //   2749: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2752: ldc_w 526
    //   2755: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2758: aload 45
    //   2760: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2763: pop
    //   2764: goto -70 -> 2694
    //   2767: astore 34
    //   2769: aload 32
    //   2771: astore 33
    //   2773: iconst_0
    //   2774: istore 13
    //   2776: iload 5
    //   2778: istore 4
    //   2780: aload 31
    //   2782: astore 29
    //   2784: iload 6
    //   2786: istore 8
    //   2788: aload 34
    //   2790: astore 32
    //   2792: iload 7
    //   2794: istore 6
    //   2796: iload_3
    //   2797: istore 5
    //   2799: aload 33
    //   2801: astore 31
    //   2803: iload 8
    //   2805: istore_3
    //   2806: goto -1886 -> 920
    //   2809: aload 28
    //   2811: astore 34
    //   2813: aload 28
    //   2815: astore 33
    //   2817: iload 5
    //   2819: istore 4
    //   2821: new 121	java/lang/StringBuilder
    //   2824: dup
    //   2825: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2828: aload 28
    //   2830: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2833: ldc_w 528
    //   2836: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2839: iload 12
    //   2841: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2844: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2847: astore 29
    //   2849: goto -380 -> 2469
    //   2852: aload_0
    //   2853: getfield 530	com/tencent/mobileqq/vip/DownloadTask:jdField_i_of_type_Boolean	Z
    //   2856: ifeq +41 -> 2897
    //   2859: getstatic 533	com/tencent/qqsharpP/QQSharpPUtil:jdField_a_of_type_Boolean	Z
    //   2862: ifeq +35 -> 2897
    //   2865: invokestatic 534	com/tencent/qqsharpP/QQSharpPUtil:a	()Z
    //   2868: ifeq +29 -> 2897
    //   2871: aload 33
    //   2873: ldc_w 536
    //   2876: ldc_w 538
    //   2879: invokevirtual 522	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2882: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2885: ifeq +12 -> 2897
    //   2888: ldc 74
    //   2890: iconst_2
    //   2891: ldc_w 540
    //   2894: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2897: aload_0
    //   2898: getfield 543	com/tencent/mobileqq/vip/DownloadTask:j	Z
    //   2901: ifeq +154 -> 3055
    //   2904: invokestatic 548	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   2907: getstatic 554	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:AcceptType	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   2910: invokevirtual 557	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   2913: invokevirtual 558	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2916: astore 29
    //   2918: aload 29
    //   2920: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2923: ifne +972 -> 3895
    //   2926: aload 29
    //   2928: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2931: iconst_1
    //   2932: iand
    //   2933: iconst_1
    //   2934: if_icmpne +961 -> 3895
    //   2937: aload 33
    //   2939: ldc_w 536
    //   2942: ldc_w 564
    //   2945: invokevirtual 522	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2948: ldc_w 566
    //   2951: iconst_3
    //   2952: anewarray 4	java/lang/Object
    //   2955: dup
    //   2956: iconst_0
    //   2957: getstatic 24	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ArrayOfInt	[I
    //   2960: iconst_0
    //   2961: iaload
    //   2962: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2965: aastore
    //   2966: dup
    //   2967: iconst_1
    //   2968: getstatic 24	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ArrayOfInt	[I
    //   2971: iconst_1
    //   2972: iaload
    //   2973: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2976: aastore
    //   2977: dup
    //   2978: iconst_2
    //   2979: getstatic 24	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ArrayOfInt	[I
    //   2982: iconst_2
    //   2983: iaload
    //   2984: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2987: aastore
    //   2988: invokestatic 570	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2991: astore 29
    //   2993: aload 33
    //   2995: ldc_w 572
    //   2998: new 121	java/lang/StringBuilder
    //   3001: dup
    //   3002: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   3005: ldc_w 574
    //   3008: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3011: aload 29
    //   3013: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3016: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3019: invokevirtual 522	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3022: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3025: ifeq +30 -> 3055
    //   3028: ldc 74
    //   3030: iconst_2
    //   3031: new 121	java/lang/StringBuilder
    //   3034: dup
    //   3035: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   3038: ldc_w 576
    //   3041: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3044: aload 28
    //   3046: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3049: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3052: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3055: aload 41
    //   3057: ifnull +80 -> 3137
    //   3060: aload 41
    //   3062: invokevirtual 268	java/io/File:exists	()Z
    //   3065: ifeq +72 -> 3137
    //   3068: aload 41
    //   3070: invokevirtual 579	java/io/File:length	()J
    //   3073: lstore 20
    //   3075: aload 33
    //   3077: ldc_w 581
    //   3080: new 121	java/lang/StringBuilder
    //   3083: dup
    //   3084: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   3087: ldc_w 583
    //   3090: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3093: lload 20
    //   3095: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3098: ldc_w 585
    //   3101: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3104: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3107: invokevirtual 522	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3110: aload 42
    //   3112: new 121	java/lang/StringBuilder
    //   3115: dup
    //   3116: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   3119: ldc_w 587
    //   3122: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3125: lload 20
    //   3127: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3130: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3133: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3136: pop
    //   3137: aload_0
    //   3138: getfield 590	com/tencent/mobileqq/vip/DownloadTask:k	Z
    //   3141: ifne +111 -> 3252
    //   3144: aload_0
    //   3145: getfield 593	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   3148: ifeq +104 -> 3252
    //   3151: aload 37
    //   3153: ifnull +99 -> 3252
    //   3156: aload 37
    //   3158: invokevirtual 268	java/io/File:exists	()Z
    //   3161: ifeq +91 -> 3252
    //   3164: aload 37
    //   3166: invokevirtual 596	java/io/File:lastModified	()J
    //   3169: lstore 20
    //   3171: lload 20
    //   3173: lconst_0
    //   3174: lcmp
    //   3175: ifle +77 -> 3252
    //   3178: new 598	java/text/SimpleDateFormat
    //   3181: dup
    //   3182: ldc_w 600
    //   3185: getstatic 606	java/util/Locale:US	Ljava/util/Locale;
    //   3188: invokespecial 609	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   3191: astore 29
    //   3193: aload 29
    //   3195: ldc_w 611
    //   3198: invokestatic 617	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   3201: invokevirtual 621	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   3204: aload 29
    //   3206: new 623	java/util/Date
    //   3209: dup
    //   3210: lload 20
    //   3212: invokespecial 624	java/util/Date:<init>	(J)V
    //   3215: invokevirtual 627	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3218: astore 29
    //   3220: aload 29
    //   3222: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3225: ifne +27 -> 3252
    //   3228: aload 33
    //   3230: ldc_w 629
    //   3233: aload 29
    //   3235: invokevirtual 522	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3238: aload 42
    //   3240: ldc_w 631
    //   3243: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3246: aload 29
    //   3248: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3251: pop
    //   3252: getstatic 17	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   3255: ifeq +105 -> 3360
    //   3258: aload_0
    //   3259: getfield 328	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   3262: ifeq +98 -> 3360
    //   3265: aload_0
    //   3266: getfield 349	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   3269: ifeq +91 -> 3360
    //   3272: aload 36
    //   3274: getfield 351	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   3277: ifne +83 -> 3360
    //   3280: aload 36
    //   3282: invokestatic 634	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   3285: aload 36
    //   3287: getfield 329	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   3290: ifeq +70 -> 3360
    //   3293: aload 33
    //   3295: new 636	java/net/URI
    //   3298: dup
    //   3299: aload 36
    //   3301: getfield 344	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3304: invokespecial 637	java/net/URI:<init>	(Ljava/lang/String;)V
    //   3307: invokevirtual 641	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   3310: aload 33
    //   3312: ldc_w 643
    //   3315: aload 36
    //   3317: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3320: invokevirtual 522	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3323: aload 42
    //   3325: ldc_w 645
    //   3328: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3331: aload 36
    //   3333: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3336: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: ldc_w 647
    //   3342: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3345: aload 36
    //   3347: getfield 331	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3350: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3353: ldc_w 649
    //   3356: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3359: pop
    //   3360: aload 43
    //   3362: invokevirtual 654	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   3365: invokestatic 658	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3368: astore 29
    //   3370: aload 29
    //   3372: aload_0
    //   3373: getfield 659	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3376: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3379: ifne +14 -> 3393
    //   3382: aload_0
    //   3383: iconst_0
    //   3384: putfield 303	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   3387: aload_0
    //   3388: aload 29
    //   3390: putfield 659	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3393: aload 43
    //   3395: invokestatic 668	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   3398: ifeq +519 -> 3917
    //   3401: aload_0
    //   3402: getfield 303	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   3405: ifne +4196 -> 7601
    //   3408: invokestatic 673	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   3411: astore 29
    //   3413: invokestatic 676	android/net/Proxy:getDefaultPort	()I
    //   3416: istore 8
    //   3418: aload 29
    //   3420: ifnull +4174 -> 7594
    //   3423: iload 8
    //   3425: ifle +4169 -> 7594
    //   3428: aload 38
    //   3430: ldc_w 678
    //   3433: new 680	org/apache/http/HttpHost
    //   3436: dup
    //   3437: aload 29
    //   3439: iload 8
    //   3441: invokespecial 683	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   3444: invokeinterface 152 3 0
    //   3449: pop
    //   3450: iconst_1
    //   3451: istore 4
    //   3453: aload 42
    //   3455: ldc_w 685
    //   3458: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3461: iconst_1
    //   3462: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3465: ldc_w 687
    //   3468: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3471: aload 29
    //   3473: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3476: ldc_w 689
    //   3479: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3482: iload 8
    //   3484: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3487: pop
    //   3488: iload 4
    //   3490: istore 7
    //   3492: iload_3
    //   3493: istore 4
    //   3495: iload 7
    //   3497: istore_3
    //   3498: aload_0
    //   3499: getfield 259	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   3502: ifne +18 -> 3520
    //   3505: invokestatic 49	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3508: invokestatic 692	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   3511: ifeq +9 -> 3520
    //   3514: aload 38
    //   3516: iconst_0
    //   3517: invokestatic 698	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   3520: aload 38
    //   3522: ldc_w 700
    //   3525: iload 4
    //   3527: invokeinterface 704 3 0
    //   3532: pop
    //   3533: aload 33
    //   3535: aload 38
    //   3537: invokevirtual 708	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   3540: aload_0
    //   3541: getfield 158	com/tencent/mobileqq/vip/DownloadTask:l	Z
    //   3544: ifeq +383 -> 3927
    //   3547: ldc 160
    //   3549: astore 29
    //   3551: aload 33
    //   3553: ldc 162
    //   3555: aload 29
    //   3557: invokevirtual 711	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3560: getstatic 716	com/tencent/mobileqq/utils/HttpDownloadUtil:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   3563: aload 33
    //   3565: invokevirtual 722	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   3568: astore 34
    //   3570: iload 5
    //   3572: istore 7
    //   3574: aload 34
    //   3576: invokeinterface 728 1 0
    //   3581: invokeinterface 733 1 0
    //   3586: istore 8
    //   3588: iload 5
    //   3590: istore 7
    //   3592: aload_0
    //   3593: iload 8
    //   3595: putfield 385	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Int	I
    //   3598: iload 5
    //   3600: istore 7
    //   3602: aload 36
    //   3604: iload 8
    //   3606: putfield 735	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_Int	I
    //   3609: iload 5
    //   3611: istore 7
    //   3613: aload 42
    //   3615: ldc_w 737
    //   3618: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3621: aload 33
    //   3623: invokevirtual 741	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   3626: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3629: ldc_w 743
    //   3632: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3635: iload 8
    //   3637: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3640: ldc_w 745
    //   3643: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3646: pop
    //   3647: iload 5
    //   3649: istore 7
    //   3651: aload 34
    //   3653: invokeinterface 749 1 0
    //   3658: astore 29
    //   3660: iload 5
    //   3662: istore 7
    //   3664: aload 29
    //   3666: invokeinterface 752 1 0
    //   3671: ifeq +263 -> 3934
    //   3674: iload 5
    //   3676: istore 7
    //   3678: aload 29
    //   3680: invokeinterface 756 1 0
    //   3685: astore 33
    //   3687: iload 5
    //   3689: istore 7
    //   3691: aload 33
    //   3693: invokeinterface 759 1 0
    //   3698: astore 43
    //   3700: iload 5
    //   3702: istore 7
    //   3704: ldc_w 761
    //   3707: aload 43
    //   3709: invokevirtual 764	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3712: ifne +108 -> 3820
    //   3715: iload 5
    //   3717: istore 7
    //   3719: ldc_w 766
    //   3722: aload 43
    //   3724: invokevirtual 764	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3727: ifne +93 -> 3820
    //   3730: iload 5
    //   3732: istore 7
    //   3734: ldc_w 768
    //   3737: aload 43
    //   3739: invokevirtual 764	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3742: ifne +78 -> 3820
    //   3745: iload 5
    //   3747: istore 7
    //   3749: ldc_w 770
    //   3752: aload 43
    //   3754: invokevirtual 764	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3757: ifne +63 -> 3820
    //   3760: iload 5
    //   3762: istore 7
    //   3764: ldc_w 772
    //   3767: aload 43
    //   3769: invokevirtual 764	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3772: ifne +48 -> 3820
    //   3775: iload 5
    //   3777: istore 7
    //   3779: ldc_w 774
    //   3782: aload 43
    //   3784: invokevirtual 764	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3787: ifne +33 -> 3820
    //   3790: iload 5
    //   3792: istore 7
    //   3794: ldc_w 776
    //   3797: aload 43
    //   3799: invokevirtual 764	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3802: ifne +18 -> 3820
    //   3805: iload 5
    //   3807: istore 7
    //   3809: ldc_w 778
    //   3812: aload 43
    //   3814: invokevirtual 764	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3817: ifeq -157 -> 3660
    //   3820: iload 5
    //   3822: istore 7
    //   3824: aload 42
    //   3826: ldc_w 524
    //   3829: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3832: aload 43
    //   3834: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3837: ldc_w 780
    //   3840: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3843: aload 33
    //   3845: invokeinterface 783 1 0
    //   3850: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3853: pop
    //   3854: goto -194 -> 3660
    //   3857: astore 33
    //   3859: iconst_1
    //   3860: istore 13
    //   3862: iload 4
    //   3864: istore 5
    //   3866: aload 31
    //   3868: astore 29
    //   3870: aload 32
    //   3872: astore 31
    //   3874: iload 6
    //   3876: istore 8
    //   3878: aload 33
    //   3880: astore 32
    //   3882: iload_3
    //   3883: istore 6
    //   3885: iload 7
    //   3887: istore 4
    //   3889: iload 8
    //   3891: istore_3
    //   3892: goto -2972 -> 920
    //   3895: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3898: ifeq -843 -> 3055
    //   3901: ldc 74
    //   3903: iconst_2
    //   3904: ldc_w 785
    //   3907: invokestatic 788	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3910: goto -855 -> 3055
    //   3913: astore_1
    //   3914: goto -1875 -> 2039
    //   3917: sipush 4096
    //   3920: istore 4
    //   3922: iconst_0
    //   3923: istore_3
    //   3924: goto -426 -> 3498
    //   3927: ldc 185
    //   3929: astore 29
    //   3931: goto -380 -> 3551
    //   3934: sipush 200
    //   3937: iload 8
    //   3939: if_icmpeq +11 -> 3950
    //   3942: sipush 206
    //   3945: iload 8
    //   3947: if_icmpne +1886 -> 5833
    //   3950: iload 5
    //   3952: istore 7
    //   3954: aload 34
    //   3956: invokeinterface 792 1 0
    //   3961: astore 29
    //   3963: aload 29
    //   3965: invokeinterface 795 1 0
    //   3970: lstore 22
    //   3972: lload 22
    //   3974: lstore 20
    //   3976: iload 5
    //   3978: istore 7
    //   3980: aload 34
    //   3982: ldc_w 797
    //   3985: invokeinterface 801 2 0
    //   3990: astore 32
    //   3992: lload 22
    //   3994: lstore 20
    //   3996: iload 5
    //   3998: istore 7
    //   4000: aload 34
    //   4002: ldc_w 768
    //   4005: invokeinterface 801 2 0
    //   4010: astore 33
    //   4012: aload 32
    //   4014: ifnull +224 -> 4238
    //   4017: lload 22
    //   4019: lstore 20
    //   4021: iload 5
    //   4023: istore 7
    //   4025: aload 32
    //   4027: invokeinterface 783 1 0
    //   4032: ldc_w 803
    //   4035: invokevirtual 807	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4038: iconst_1
    //   4039: aaload
    //   4040: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4043: i2l
    //   4044: lstore 16
    //   4046: lload 16
    //   4048: lstore 20
    //   4050: iload 5
    //   4052: istore 7
    //   4054: aload 41
    //   4056: invokevirtual 579	java/io/File:length	()J
    //   4059: lstore 22
    //   4061: lload 16
    //   4063: lstore 20
    //   4065: iload 5
    //   4067: istore 7
    //   4069: aload 42
    //   4071: ldc_w 809
    //   4074: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4077: lload 22
    //   4079: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4082: pop
    //   4083: lload 16
    //   4085: lconst_1
    //   4086: lcmp
    //   4087: iflt +38 -> 4125
    //   4090: lload 16
    //   4092: lstore 20
    //   4094: iload 5
    //   4096: istore 7
    //   4098: aload_0
    //   4099: getfield 811	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   4102: lconst_0
    //   4103: lcmp
    //   4104: ifle +167 -> 4271
    //   4107: lload 16
    //   4109: lstore 20
    //   4111: iload 5
    //   4113: istore 7
    //   4115: lload 16
    //   4117: aload_0
    //   4118: getfield 811	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   4121: lcmp
    //   4122: ifle +149 -> 4271
    //   4125: iconst_1
    //   4126: istore 7
    //   4128: iconst_1
    //   4129: istore 12
    //   4131: bipush 138
    //   4133: istore 8
    //   4135: lload 16
    //   4137: lstore 20
    //   4139: aload_0
    //   4140: bipush 138
    //   4142: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   4145: iload 8
    //   4147: istore 6
    //   4149: iload 12
    //   4151: istore 5
    //   4153: iload 8
    //   4155: istore 7
    //   4157: aload 42
    //   4159: ldc_w 813
    //   4162: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4165: aload_0
    //   4166: getfield 811	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   4169: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4172: pop
    //   4173: iload 8
    //   4175: istore 6
    //   4177: iload 12
    //   4179: istore 5
    //   4181: iload 8
    //   4183: istore 7
    //   4185: new 64	java/lang/Exception
    //   4188: dup
    //   4189: ldc_w 815
    //   4192: invokespecial 292	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4195: athrow
    //   4196: astore 32
    //   4198: iload 6
    //   4200: istore 7
    //   4202: iload 4
    //   4204: istore 8
    //   4206: aload 29
    //   4208: astore 33
    //   4210: iload 5
    //   4212: istore 4
    //   4214: iconst_1
    //   4215: istore 13
    //   4217: iload_3
    //   4218: istore 6
    //   4220: iload 8
    //   4222: istore 5
    //   4224: aload 31
    //   4226: astore 29
    //   4228: aload 33
    //   4230: astore 31
    //   4232: iload 7
    //   4234: istore_3
    //   4235: goto -3315 -> 920
    //   4238: lload 22
    //   4240: lstore 16
    //   4242: aload 33
    //   4244: ifnull -198 -> 4046
    //   4247: lload 22
    //   4249: lstore 20
    //   4251: iload 5
    //   4253: istore 7
    //   4255: aload 33
    //   4257: invokeinterface 783 1 0
    //   4262: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4265: i2l
    //   4266: lstore 16
    //   4268: goto -222 -> 4046
    //   4271: lconst_0
    //   4272: lload 22
    //   4274: lcmp
    //   4275: ifeq +74 -> 4349
    //   4278: lload 22
    //   4280: lload 16
    //   4282: lcmp
    //   4283: iflt +66 -> 4349
    //   4286: lload 16
    //   4288: lstore 20
    //   4290: iload 5
    //   4292: istore 7
    //   4294: aload 41
    //   4296: invokevirtual 818	java/io/File:delete	()Z
    //   4299: pop
    //   4300: bipush 139
    //   4302: istore 8
    //   4304: lload 16
    //   4306: lstore 20
    //   4308: iload 5
    //   4310: istore 7
    //   4312: aload_0
    //   4313: bipush 139
    //   4315: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   4318: iload 8
    //   4320: istore 6
    //   4322: iload 8
    //   4324: istore 7
    //   4326: new 64	java/lang/Exception
    //   4329: dup
    //   4330: ldc_w 820
    //   4333: invokespecial 292	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4336: athrow
    //   4337: astore_1
    //   4338: iload 7
    //   4340: istore 6
    //   4342: aload 29
    //   4344: astore 32
    //   4346: goto -2307 -> 2039
    //   4349: lload 22
    //   4351: lconst_0
    //   4352: lcmp
    //   4353: ifeq +328 -> 4681
    //   4356: iconst_1
    //   4357: istore 13
    //   4359: lload 16
    //   4361: lstore 20
    //   4363: iload 5
    //   4365: istore 7
    //   4367: new 367	java/io/BufferedOutputStream
    //   4370: dup
    //   4371: new 822	java/io/FileOutputStream
    //   4374: dup
    //   4375: aload 41
    //   4377: iload 13
    //   4379: invokespecial 825	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   4382: invokespecial 828	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   4385: astore 32
    //   4387: aload 34
    //   4389: ldc_w 830
    //   4392: invokeinterface 801 2 0
    //   4397: ifnull +290 -> 4687
    //   4400: ldc 160
    //   4402: aload 34
    //   4404: ldc_w 830
    //   4407: invokeinterface 801 2 0
    //   4412: invokeinterface 783 1 0
    //   4417: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4420: ifeq +267 -> 4687
    //   4423: new 832	java/util/zip/GZIPInputStream
    //   4426: dup
    //   4427: aload 29
    //   4429: invokeinterface 836 1 0
    //   4434: invokespecial 839	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   4437: astore 31
    //   4439: aload 42
    //   4441: ldc_w 841
    //   4444: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4447: pop
    //   4448: aload 31
    //   4450: astore 30
    //   4452: invokestatic 847	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   4455: iload 4
    //   4457: invokevirtual 851	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   4460: astore 43
    //   4462: iconst_0
    //   4463: istore 7
    //   4465: lload 18
    //   4467: lstore 20
    //   4469: aload_0
    //   4470: invokevirtual 326	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   4473: ifne +319 -> 4792
    //   4476: lload 18
    //   4478: lstore 20
    //   4480: aload 30
    //   4482: aload 43
    //   4484: invokevirtual 855	java/io/InputStream:read	([B)I
    //   4487: istore 8
    //   4489: iload 8
    //   4491: iconst_m1
    //   4492: if_icmpeq +300 -> 4792
    //   4495: lload 18
    //   4497: lstore 20
    //   4499: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4502: ifeq +64 -> 4566
    //   4505: lconst_0
    //   4506: lload 22
    //   4508: lcmp
    //   4509: ifne +57 -> 4566
    //   4512: aconst_null
    //   4513: astore 33
    //   4515: iload 8
    //   4517: iconst_4
    //   4518: if_icmple +185 -> 4703
    //   4521: iconst_m1
    //   4522: aload 43
    //   4524: iconst_0
    //   4525: baload
    //   4526: if_icmpne +177 -> 4703
    //   4529: bipush 216
    //   4531: aload 43
    //   4533: iconst_1
    //   4534: baload
    //   4535: if_icmpne +168 -> 4703
    //   4538: ldc_w 857
    //   4541: astore 31
    //   4543: aload 31
    //   4545: ifnull +21 -> 4566
    //   4548: lload 18
    //   4550: lstore 20
    //   4552: aload 42
    //   4554: ldc_w 859
    //   4557: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4560: aload 31
    //   4562: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4565: pop
    //   4566: lload 18
    //   4568: lstore 20
    //   4570: aload 32
    //   4572: aload 43
    //   4574: iconst_0
    //   4575: iload 8
    //   4577: invokevirtual 863	java/io/BufferedOutputStream:write	([BII)V
    //   4580: lload 22
    //   4582: iload 8
    //   4584: i2l
    //   4585: ladd
    //   4586: lstore 22
    //   4588: lload 18
    //   4590: iload 8
    //   4592: i2l
    //   4593: ladd
    //   4594: lstore 18
    //   4596: iload 7
    //   4598: iload 8
    //   4600: iadd
    //   4601: istore 7
    //   4603: lload 18
    //   4605: lstore 20
    //   4607: aload_0
    //   4608: getfield 865	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Long	J
    //   4611: lconst_0
    //   4612: lcmp
    //   4613: ifne +17 -> 4630
    //   4616: lload 18
    //   4618: lstore 20
    //   4620: aload_0
    //   4621: lload 16
    //   4623: ldc2_w 866
    //   4626: ldiv
    //   4627: putfield 865	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Long	J
    //   4630: lload 18
    //   4632: lstore 20
    //   4634: iload 7
    //   4636: i2l
    //   4637: aload_0
    //   4638: getfield 865	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Long	J
    //   4641: lcmp
    //   4642: ifge +11 -> 4653
    //   4645: lload 22
    //   4647: lload 16
    //   4649: lcmp
    //   4650: iflt +2941 -> 7591
    //   4653: lload 18
    //   4655: lstore 20
    //   4657: aload_0
    //   4658: lload 16
    //   4660: lload 22
    //   4662: iload 10
    //   4664: invokevirtual 870	com/tencent/mobileqq/vip/DownloadTask:a	(JJI)V
    //   4667: lload 18
    //   4669: lstore 20
    //   4671: aload_0
    //   4672: invokevirtual 872	com/tencent/mobileqq/vip/DownloadTask:b	()V
    //   4675: iconst_0
    //   4676: istore 7
    //   4678: goto -213 -> 4465
    //   4681: iconst_0
    //   4682: istore 13
    //   4684: goto -325 -> 4359
    //   4687: aload 29
    //   4689: invokeinterface 836 1 0
    //   4694: astore 31
    //   4696: aload 31
    //   4698: astore 30
    //   4700: goto -248 -> 4452
    //   4703: iload 8
    //   4705: bipush 8
    //   4707: if_icmple +2970 -> 7677
    //   4710: bipush 137
    //   4712: aload 43
    //   4714: iconst_0
    //   4715: baload
    //   4716: if_icmpne +2961 -> 7677
    //   4719: bipush 80
    //   4721: aload 43
    //   4723: iconst_1
    //   4724: baload
    //   4725: if_icmpne +2952 -> 7677
    //   4728: bipush 78
    //   4730: aload 43
    //   4732: iconst_2
    //   4733: baload
    //   4734: if_icmpne +2943 -> 7677
    //   4737: bipush 71
    //   4739: aload 43
    //   4741: iconst_3
    //   4742: baload
    //   4743: if_icmpne +2934 -> 7677
    //   4746: bipush 13
    //   4748: aload 43
    //   4750: iconst_4
    //   4751: baload
    //   4752: if_icmpne +2925 -> 7677
    //   4755: bipush 10
    //   4757: aload 43
    //   4759: iconst_5
    //   4760: baload
    //   4761: if_icmpne +2916 -> 7677
    //   4764: bipush 26
    //   4766: aload 43
    //   4768: bipush 6
    //   4770: baload
    //   4771: if_icmpne +2906 -> 7677
    //   4774: bipush 10
    //   4776: aload 43
    //   4778: bipush 7
    //   4780: baload
    //   4781: if_icmpne +2896 -> 7677
    //   4784: ldc_w 874
    //   4787: astore 31
    //   4789: goto -246 -> 4543
    //   4792: lload 18
    //   4794: lstore 20
    //   4796: aload 32
    //   4798: invokevirtual 877	java/io/BufferedOutputStream:flush	()V
    //   4801: lload 18
    //   4803: lstore 20
    //   4805: invokestatic 847	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   4808: aload 43
    //   4810: invokevirtual 881	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   4813: lload 18
    //   4815: lstore 20
    //   4817: aload 41
    //   4819: invokevirtual 579	java/io/File:length	()J
    //   4822: lload 16
    //   4824: lcmp
    //   4825: ifeq +62 -> 4887
    //   4828: lload 18
    //   4830: lstore 20
    //   4832: aload 34
    //   4834: ldc_w 830
    //   4837: invokeinterface 801 2 0
    //   4842: ifnull +805 -> 5647
    //   4845: lload 18
    //   4847: lstore 20
    //   4849: ldc 160
    //   4851: aload 34
    //   4853: ldc_w 830
    //   4856: invokeinterface 801 2 0
    //   4861: invokeinterface 783 1 0
    //   4866: invokevirtual 663	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4869: ifeq +778 -> 5647
    //   4872: lload 18
    //   4874: lstore 20
    //   4876: aload 41
    //   4878: invokevirtual 579	java/io/File:length	()J
    //   4881: lload 16
    //   4883: lcmp
    //   4884: iflt +763 -> 5647
    //   4887: lload 18
    //   4889: lstore 20
    //   4891: aload_0
    //   4892: iconst_0
    //   4893: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   4896: aload 37
    //   4898: invokevirtual 268	java/io/File:exists	()Z
    //   4901: ifeq +9 -> 4910
    //   4904: aload 37
    //   4906: invokevirtual 818	java/io/File:delete	()Z
    //   4909: pop
    //   4910: aload 41
    //   4912: aload 37
    //   4914: invokevirtual 885	java/io/File:renameTo	(Ljava/io/File;)Z
    //   4917: pop
    //   4918: aload_0
    //   4919: getfield 593	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   4922: ifeq +2663 -> 7585
    //   4925: aload 34
    //   4927: ldc_w 772
    //   4930: invokeinterface 888 2 0
    //   4935: ifeq +2650 -> 7585
    //   4938: aload 34
    //   4940: ldc_w 772
    //   4943: invokeinterface 801 2 0
    //   4948: invokeinterface 783 1 0
    //   4953: astore 31
    //   4955: aload 31
    //   4957: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4960: istore 13
    //   4962: iload 13
    //   4964: ifne +116 -> 5080
    //   4967: new 598	java/text/SimpleDateFormat
    //   4970: dup
    //   4971: ldc_w 890
    //   4974: getstatic 606	java/util/Locale:US	Ljava/util/Locale;
    //   4977: invokespecial 609	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   4980: astore 33
    //   4982: aload 33
    //   4984: ldc_w 611
    //   4987: invokestatic 617	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   4990: invokevirtual 621	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   4993: aload 33
    //   4995: aload 31
    //   4997: invokevirtual 894	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   5000: invokevirtual 897	java/util/Date:getTime	()J
    //   5003: lstore 20
    //   5005: aload 37
    //   5007: lload 20
    //   5009: invokevirtual 901	java/io/File:setLastModified	(J)Z
    //   5012: pop
    //   5013: aload_0
    //   5014: lload 20
    //   5016: putfield 903	com/tencent/mobileqq/vip/DownloadTask:jdField_i_of_type_Long	J
    //   5019: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5022: ifeq +58 -> 5080
    //   5025: ldc 74
    //   5027: iconst_2
    //   5028: new 121	java/lang/StringBuilder
    //   5031: dup
    //   5032: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   5035: ldc_w 905
    //   5038: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5041: lload 20
    //   5043: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5046: ldc_w 907
    //   5049: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5052: aload 37
    //   5054: invokevirtual 220	java/io/File:getName	()Ljava/lang/String;
    //   5057: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5060: ldc_w 909
    //   5063: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5066: aload 37
    //   5068: invokevirtual 596	java/io/File:lastModified	()J
    //   5071: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5074: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5077: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5080: iconst_0
    //   5081: istore 6
    //   5083: lload 18
    //   5085: lstore 20
    //   5087: aload 29
    //   5089: astore 31
    //   5091: aload 32
    //   5093: astore 29
    //   5095: iload 6
    //   5097: istore 7
    //   5099: lload 16
    //   5101: lstore 18
    //   5103: lload 20
    //   5105: lstore 16
    //   5107: iload 5
    //   5109: istore 6
    //   5111: getstatic 39	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5114: ifnonnull +17 -> 5131
    //   5117: iload 5
    //   5119: istore 6
    //   5121: new 36	java/util/concurrent/ConcurrentHashMap
    //   5124: dup
    //   5125: invokespecial 37	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   5128: putstatic 39	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5131: iload 7
    //   5133: ifeq +1131 -> 6264
    //   5136: iload 5
    //   5138: istore 6
    //   5140: aload_0
    //   5141: invokevirtual 326	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   5144: ifne +1120 -> 6264
    //   5147: iload 5
    //   5149: istore 6
    //   5151: iload 11
    //   5153: aload_0
    //   5154: getfield 263	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Int	I
    //   5157: if_icmpge +1004 -> 6161
    //   5160: iload 5
    //   5162: istore 6
    //   5164: aload 39
    //   5166: monitorenter
    //   5167: sipush 2000
    //   5170: i2l
    //   5171: lstore 20
    //   5173: aload 39
    //   5175: lload 20
    //   5177: invokevirtual 912	java/lang/Object:wait	(J)V
    //   5180: aload 39
    //   5182: monitorexit
    //   5183: iload 5
    //   5185: istore 6
    //   5187: aload_0
    //   5188: getfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5191: sipush 302
    //   5194: if_icmpne +44 -> 5238
    //   5197: iload 5
    //   5199: istore 6
    //   5201: aload 34
    //   5203: ldc_w 774
    //   5206: invokeinterface 801 2 0
    //   5211: astore 32
    //   5213: aload 32
    //   5215: ifnull +23 -> 5238
    //   5218: iload 5
    //   5220: istore 6
    //   5222: aload 35
    //   5224: ldc_w 914
    //   5227: aload 32
    //   5229: invokeinterface 783 1 0
    //   5234: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5237: pop
    //   5238: iload 7
    //   5240: istore 8
    //   5242: ldc 74
    //   5244: iconst_1
    //   5245: new 121	java/lang/StringBuilder
    //   5248: dup
    //   5249: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   5252: aload 42
    //   5254: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5257: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5260: ldc_w 321
    //   5263: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5266: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   5269: lload 26
    //   5271: lsub
    //   5272: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5275: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5278: invokestatic 324	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5281: iload 7
    //   5283: ifeq +119 -> 5402
    //   5286: iload 7
    //   5288: istore 8
    //   5290: aload_0
    //   5291: invokevirtual 326	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   5294: ifne +108 -> 5402
    //   5297: iload 7
    //   5299: istore 8
    //   5301: aload_0
    //   5302: getfield 328	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   5305: ifeq +97 -> 5402
    //   5308: iload 7
    //   5310: istore 8
    //   5312: aload 36
    //   5314: getfield 329	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   5317: ifeq +1001 -> 6318
    //   5320: iload 7
    //   5322: istore 8
    //   5324: aload 36
    //   5326: getfield 331	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   5329: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5332: ifne +950 -> 6282
    //   5335: iload 7
    //   5337: istore 8
    //   5339: invokestatic 336	com/tencent/mobileqq/transfile/dns/InnerDns:a	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   5342: aload 36
    //   5344: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5347: aload 36
    //   5349: getfield 331	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   5352: getstatic 31	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   5355: aload 36
    //   5357: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5360: invokeinterface 209 2 0
    //   5365: checkcast 142	java/lang/Integer
    //   5368: invokevirtual 340	java/lang/Integer:intValue	()I
    //   5371: invokevirtual 343	com/tencent/mobileqq/transfile/dns/InnerDns:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   5374: iload 7
    //   5376: istore 8
    //   5378: aload 36
    //   5380: getfield 344	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5383: aload 37
    //   5385: invokevirtual 220	java/io/File:getName	()Ljava/lang/String;
    //   5388: iconst_m1
    //   5389: aload_2
    //   5390: invokestatic 347	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   5393: iload 7
    //   5395: istore 8
    //   5397: aload_0
    //   5398: iconst_0
    //   5399: putfield 349	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   5402: iload 7
    //   5404: istore 8
    //   5406: new 121	java/lang/StringBuilder
    //   5409: dup
    //   5410: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   5413: astore 33
    //   5415: iload 7
    //   5417: istore 8
    //   5419: aload 36
    //   5421: getfield 351	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   5424: ifeq +2456 -> 7880
    //   5427: ldc_w 353
    //   5430: astore 32
    //   5432: iload 7
    //   5434: istore 8
    //   5436: aload 33
    //   5438: aload 32
    //   5440: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5443: astore 33
    //   5445: iload 7
    //   5447: istore 8
    //   5449: aload 36
    //   5451: getfield 329	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   5454: ifeq +2434 -> 7888
    //   5457: ldc_w 355
    //   5460: astore 32
    //   5462: iload 7
    //   5464: istore 8
    //   5466: aload 33
    //   5468: aload 32
    //   5470: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5473: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5476: astore 32
    //   5478: iload 11
    //   5480: iconst_1
    //   5481: iadd
    //   5482: istore 6
    //   5484: aload 31
    //   5486: ifnull +14 -> 5500
    //   5489: iload 7
    //   5491: istore 8
    //   5493: aload 31
    //   5495: invokeinterface 360 1 0
    //   5500: aload 30
    //   5502: ifnull +12 -> 5514
    //   5505: iload 7
    //   5507: istore 8
    //   5509: aload 30
    //   5511: invokevirtual 365	java/io/InputStream:close	()V
    //   5514: aload 29
    //   5516: ifnull +12 -> 5528
    //   5519: iload 7
    //   5521: istore 8
    //   5523: aload 29
    //   5525: invokevirtual 368	java/io/BufferedOutputStream:close	()V
    //   5528: iload 5
    //   5530: istore 8
    //   5532: iconst_1
    //   5533: istore 13
    //   5535: iload 6
    //   5537: istore 5
    //   5539: iload_3
    //   5540: istore 6
    //   5542: iload 7
    //   5544: istore_3
    //   5545: iload 8
    //   5547: istore 7
    //   5549: goto -4207 -> 1342
    //   5552: astore 33
    //   5554: ldc 74
    //   5556: iconst_1
    //   5557: new 121	java/lang/StringBuilder
    //   5560: dup
    //   5561: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   5564: ldc_w 916
    //   5567: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5570: aload 31
    //   5572: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5575: ldc_w 918
    //   5578: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5581: aload 33
    //   5583: invokevirtual 919	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5586: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5589: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5592: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5595: goto -515 -> 5080
    //   5598: astore 33
    //   5600: aload 32
    //   5602: astore 31
    //   5604: iconst_0
    //   5605: istore 8
    //   5607: aload 33
    //   5609: astore 32
    //   5611: iload 4
    //   5613: istore 7
    //   5615: aload 29
    //   5617: astore 33
    //   5619: iload 5
    //   5621: istore 4
    //   5623: iconst_1
    //   5624: istore 13
    //   5626: iload_3
    //   5627: istore 6
    //   5629: iload 7
    //   5631: istore 5
    //   5633: aload 31
    //   5635: astore 29
    //   5637: aload 33
    //   5639: astore 31
    //   5641: iload 8
    //   5643: istore_3
    //   5644: goto -4724 -> 920
    //   5647: lload 18
    //   5649: lstore 20
    //   5651: aload_0
    //   5652: invokevirtual 326	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   5655: istore 13
    //   5657: iload 13
    //   5659: ifeq +85 -> 5744
    //   5662: iconst_1
    //   5663: istore 5
    //   5665: bipush 150
    //   5667: istore 7
    //   5669: aload_0
    //   5670: bipush 150
    //   5672: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5675: iload 7
    //   5677: istore 6
    //   5679: aload 42
    //   5681: ldc_w 921
    //   5684: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5687: pop
    //   5688: iload 7
    //   5690: istore 6
    //   5692: goto -609 -> 5083
    //   5695: astore 33
    //   5697: aload 32
    //   5699: astore 31
    //   5701: bipush 150
    //   5703: istore 7
    //   5705: iconst_1
    //   5706: istore 8
    //   5708: iconst_1
    //   5709: istore 13
    //   5711: aload 33
    //   5713: astore 32
    //   5715: iload 4
    //   5717: istore 5
    //   5719: aload 29
    //   5721: astore 33
    //   5723: iload_3
    //   5724: istore 6
    //   5726: iload 8
    //   5728: istore 4
    //   5730: aload 31
    //   5732: astore 29
    //   5734: aload 33
    //   5736: astore 31
    //   5738: iload 7
    //   5740: istore_3
    //   5741: goto -4821 -> 920
    //   5744: bipush 151
    //   5746: istore 7
    //   5748: lload 18
    //   5750: lstore 20
    //   5752: aload_0
    //   5753: bipush 151
    //   5755: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5758: iload 7
    //   5760: istore 6
    //   5762: aload 41
    //   5764: invokevirtual 818	java/io/File:delete	()Z
    //   5767: pop
    //   5768: iload 7
    //   5770: istore 6
    //   5772: new 64	java/lang/Exception
    //   5775: dup
    //   5776: ldc_w 923
    //   5779: invokespecial 292	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   5782: athrow
    //   5783: astore 34
    //   5785: aload 32
    //   5787: astore 31
    //   5789: bipush 151
    //   5791: istore 8
    //   5793: iload 4
    //   5795: istore 7
    //   5797: aload 29
    //   5799: astore 33
    //   5801: iconst_1
    //   5802: istore 13
    //   5804: iload 5
    //   5806: istore 4
    //   5808: aload 34
    //   5810: astore 32
    //   5812: iload_3
    //   5813: istore 6
    //   5815: iload 7
    //   5817: istore 5
    //   5819: aload 31
    //   5821: astore 29
    //   5823: aload 33
    //   5825: astore 31
    //   5827: iload 8
    //   5829: istore_3
    //   5830: goto -4910 -> 920
    //   5833: sipush 404
    //   5836: iload 8
    //   5838: if_icmpne +1966 -> 7804
    //   5841: iconst_1
    //   5842: istore 5
    //   5844: iconst_1
    //   5845: istore 7
    //   5847: aload_0
    //   5848: iload 8
    //   5850: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5853: lload 16
    //   5855: lstore 20
    //   5857: iload 8
    //   5859: istore 7
    //   5861: aload 31
    //   5863: astore 29
    //   5865: lload 18
    //   5867: lstore 16
    //   5869: lload 20
    //   5871: lstore 18
    //   5873: aload 32
    //   5875: astore 31
    //   5877: goto -770 -> 5107
    //   5880: iload 5
    //   5882: istore 7
    //   5884: aload_0
    //   5885: getfield 259	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   5888: ifne +82 -> 5970
    //   5891: iconst_1
    //   5892: istore 12
    //   5894: iconst_1
    //   5895: istore 7
    //   5897: iload 12
    //   5899: istore 5
    //   5901: aload_0
    //   5902: getfield 432	com/tencent/mobileqq/vip/DownloadTask:p	Z
    //   5905: ifeq +28 -> 5933
    //   5908: iload 12
    //   5910: istore 5
    //   5912: iload 8
    //   5914: sipush 302
    //   5917: if_icmpne +16 -> 5933
    //   5920: iload 12
    //   5922: istore 5
    //   5924: iload 11
    //   5926: iconst_m1
    //   5927: if_icmpne +6 -> 5933
    //   5930: iconst_0
    //   5931: istore 5
    //   5933: iload 5
    //   5935: istore 7
    //   5937: aload_0
    //   5938: iload 8
    //   5940: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5943: lload 16
    //   5945: lstore 20
    //   5947: iload 8
    //   5949: istore 7
    //   5951: aload 31
    //   5953: astore 29
    //   5955: lload 18
    //   5957: lstore 16
    //   5959: lload 20
    //   5961: lstore 18
    //   5963: aload 32
    //   5965: astore 31
    //   5967: goto -860 -> 5107
    //   5970: sipush 304
    //   5973: iload 8
    //   5975: if_icmpne +38 -> 6013
    //   5978: iload 5
    //   5980: istore 7
    //   5982: aload_0
    //   5983: iconst_0
    //   5984: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5987: lload 16
    //   5989: lstore 20
    //   5991: iconst_0
    //   5992: istore 7
    //   5994: aload 31
    //   5996: astore 29
    //   5998: lload 18
    //   6000: lstore 16
    //   6002: lload 20
    //   6004: lstore 18
    //   6006: aload 32
    //   6008: astore 31
    //   6010: goto -903 -> 5107
    //   6013: sipush 416
    //   6016: iload 8
    //   6018: if_icmpne +62 -> 6080
    //   6021: iload 5
    //   6023: istore 7
    //   6025: aload 41
    //   6027: invokevirtual 268	java/io/File:exists	()Z
    //   6030: ifeq +13 -> 6043
    //   6033: iload 5
    //   6035: istore 7
    //   6037: aload 41
    //   6039: invokevirtual 818	java/io/File:delete	()Z
    //   6042: pop
    //   6043: iload 5
    //   6045: istore 7
    //   6047: aload_0
    //   6048: iload 8
    //   6050: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6053: lload 16
    //   6055: lstore 20
    //   6057: iload 8
    //   6059: istore 7
    //   6061: aload 31
    //   6063: astore 29
    //   6065: lload 18
    //   6067: lstore 16
    //   6069: lload 20
    //   6071: lstore 18
    //   6073: aload 32
    //   6075: astore 31
    //   6077: goto -970 -> 5107
    //   6080: iload 5
    //   6082: istore 7
    //   6084: aload_0
    //   6085: iload 8
    //   6087: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6090: lload 16
    //   6092: lstore 20
    //   6094: iload 8
    //   6096: istore 7
    //   6098: aload 31
    //   6100: astore 29
    //   6102: lload 18
    //   6104: lstore 16
    //   6106: lload 20
    //   6108: lstore 18
    //   6110: aload 32
    //   6112: astore 31
    //   6114: goto -1007 -> 5107
    //   6117: astore 32
    //   6119: ldc 74
    //   6121: iconst_1
    //   6122: new 121	java/lang/StringBuilder
    //   6125: dup
    //   6126: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   6129: ldc_w 925
    //   6132: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6135: aload 28
    //   6137: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6140: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6143: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6146: goto -966 -> 5180
    //   6149: astore 32
    //   6151: aload 39
    //   6153: monitorexit
    //   6154: iload 5
    //   6156: istore 6
    //   6158: aload 32
    //   6160: athrow
    //   6161: iload 5
    //   6163: istore 6
    //   6165: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   6168: ldc2_w 926
    //   6171: ldiv
    //   6172: l2i
    //   6173: istore 8
    //   6175: iload 5
    //   6177: istore 6
    //   6179: aload_0
    //   6180: getfield 929	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_Boolean	Z
    //   6183: ifeq +23 -> 6206
    //   6186: iload 5
    //   6188: istore 6
    //   6190: getstatic 39	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6193: aload_0
    //   6194: getfield 931	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6197: iload 8
    //   6199: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6202: invokevirtual 932	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6205: pop
    //   6206: iconst_1
    //   6207: istore 6
    //   6209: new 64	java/lang/Exception
    //   6212: dup
    //   6213: new 121	java/lang/StringBuilder
    //   6216: dup
    //   6217: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   6220: ldc_w 934
    //   6223: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6226: aload 28
    //   6228: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6231: ldc_w 936
    //   6234: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6237: aload_0
    //   6238: getfield 328	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   6241: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6244: ldc_w 938
    //   6247: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6250: aload_0
    //   6251: getfield 349	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   6254: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6257: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6260: invokespecial 292	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   6263: athrow
    //   6264: iload 5
    //   6266: istore 6
    //   6268: getstatic 39	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6271: aload_0
    //   6272: getfield 931	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6275: invokevirtual 941	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6278: pop
    //   6279: goto -1096 -> 5183
    //   6282: iload 7
    //   6284: istore 8
    //   6286: invokestatic 946	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   6289: astore 32
    //   6291: aload 32
    //   6293: ifnull -919 -> 5374
    //   6296: iload 7
    //   6298: istore 8
    //   6300: aload 32
    //   6302: aload 36
    //   6304: getfield 948	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   6307: aload 36
    //   6309: getfield 344	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6312: invokevirtual 951	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   6315: goto -941 -> 5374
    //   6318: iload 7
    //   6320: istore 8
    //   6322: aload_0
    //   6323: iconst_1
    //   6324: putfield 349	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   6327: goto -925 -> 5402
    //   6330: astore 33
    //   6332: iload 7
    //   6334: istore 8
    //   6336: ldc 74
    //   6338: iconst_1
    //   6339: new 121	java/lang/StringBuilder
    //   6342: dup
    //   6343: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   6346: ldc_w 953
    //   6349: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6352: aload 33
    //   6354: invokevirtual 954	java/io/IOException:getMessage	()Ljava/lang/String;
    //   6357: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6360: ldc_w 956
    //   6363: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6366: aload 28
    //   6368: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6371: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6374: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6377: iload 5
    //   6379: istore 8
    //   6381: iconst_1
    //   6382: istore 13
    //   6384: iload 6
    //   6386: istore 5
    //   6388: iload_3
    //   6389: istore 6
    //   6391: iload 7
    //   6393: istore_3
    //   6394: iload 8
    //   6396: istore 7
    //   6398: goto -5056 -> 1342
    //   6401: aload 32
    //   6403: instanceof 958
    //   6406: ifeq +12 -> 6418
    //   6409: aload_0
    //   6410: bipush 144
    //   6412: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6415: goto -5451 -> 964
    //   6418: aload 32
    //   6420: instanceof 294
    //   6423: ifne +11 -> 6434
    //   6426: aload 32
    //   6428: instanceof 296
    //   6431: ifeq +12 -> 6443
    //   6434: aload_0
    //   6435: bipush 143
    //   6437: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6440: goto -5476 -> 964
    //   6443: aload 32
    //   6445: instanceof 298
    //   6448: ifeq +12 -> 6460
    //   6451: aload_0
    //   6452: bipush 142
    //   6454: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6457: goto -5493 -> 964
    //   6460: aload_0
    //   6461: getfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6464: ifne -5500 -> 964
    //   6467: aload_0
    //   6468: bipush 141
    //   6470: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6473: goto -5509 -> 964
    //   6476: aload_0
    //   6477: iconst_0
    //   6478: putfield 303	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   6481: goto -5488 -> 993
    //   6484: iload_3
    //   6485: istore 8
    //   6487: invokestatic 946	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   6490: astore 32
    //   6492: aload 32
    //   6494: ifnull -5324 -> 1170
    //   6497: iload_3
    //   6498: istore 8
    //   6500: aload 32
    //   6502: aload 36
    //   6504: getfield 948	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   6507: aload 36
    //   6509: getfield 344	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6512: invokevirtual 951	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   6515: goto -5345 -> 1170
    //   6518: iload_3
    //   6519: istore 8
    //   6521: aload_0
    //   6522: iconst_1
    //   6523: putfield 349	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   6526: goto -5330 -> 1196
    //   6529: astore 33
    //   6531: iload_3
    //   6532: istore 8
    //   6534: ldc 74
    //   6536: iconst_1
    //   6537: new 121	java/lang/StringBuilder
    //   6540: dup
    //   6541: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   6544: ldc_w 953
    //   6547: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6550: aload 33
    //   6552: invokevirtual 954	java/io/IOException:getMessage	()Ljava/lang/String;
    //   6555: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6558: ldc_w 956
    //   6561: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6564: aload 28
    //   6566: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6569: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6572: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6575: iload 7
    //   6577: istore 8
    //   6579: lload 16
    //   6581: lstore 20
    //   6583: iload 5
    //   6585: istore 11
    //   6587: iload 4
    //   6589: istore 7
    //   6591: lload 18
    //   6593: lstore 16
    //   6595: iload 8
    //   6597: istore 5
    //   6599: lload 20
    //   6601: lstore 18
    //   6603: iload 11
    //   6605: istore 4
    //   6607: goto -5265 -> 1342
    //   6610: iload 6
    //   6612: istore 4
    //   6614: invokestatic 946	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   6617: astore 29
    //   6619: aload 29
    //   6621: ifnull -4446 -> 2175
    //   6624: iload 6
    //   6626: istore 4
    //   6628: aload 29
    //   6630: aload 36
    //   6632: getfield 948	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   6635: aload 36
    //   6637: getfield 344	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6640: invokevirtual 951	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   6643: goto -4468 -> 2175
    //   6646: iload 6
    //   6648: istore 4
    //   6650: aload_0
    //   6651: iconst_1
    //   6652: putfield 349	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   6655: goto -4452 -> 2203
    //   6658: astore_0
    //   6659: iload 6
    //   6661: istore 4
    //   6663: ldc 74
    //   6665: iconst_1
    //   6666: new 121	java/lang/StringBuilder
    //   6669: dup
    //   6670: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   6673: ldc_w 953
    //   6676: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6679: aload_0
    //   6680: invokevirtual 954	java/io/IOException:getMessage	()Ljava/lang/String;
    //   6683: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6686: ldc_w 956
    //   6689: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6692: aload 28
    //   6694: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6697: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6700: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6703: goto -4389 -> 2314
    //   6706: iload 4
    //   6708: istore 8
    //   6710: aload_0
    //   6711: bipush 146
    //   6713: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6716: iload 4
    //   6718: istore 8
    //   6720: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6723: ifeq +16 -> 6739
    //   6726: iload 4
    //   6728: istore 8
    //   6730: ldc 74
    //   6732: iconst_2
    //   6733: ldc_w 960
    //   6736: invokestatic 788	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   6739: lconst_0
    //   6740: lstore 18
    //   6742: iconst_m1
    //   6743: istore 6
    //   6745: iconst_m1
    //   6746: istore 4
    //   6748: lconst_0
    //   6749: lstore 16
    //   6751: aload 28
    //   6753: astore 31
    //   6755: iload_3
    //   6756: istore 5
    //   6758: aload 29
    //   6760: astore 28
    //   6762: aload 30
    //   6764: astore 29
    //   6766: aload 31
    //   6768: astore 30
    //   6770: aload 32
    //   6772: astore 31
    //   6774: aload 33
    //   6776: astore 32
    //   6778: iload 4
    //   6780: istore_3
    //   6781: goto -5356 -> 1425
    //   6784: iconst_0
    //   6785: istore 14
    //   6787: goto -5132 -> 1655
    //   6790: iload_3
    //   6791: istore 4
    //   6793: aload_0
    //   6794: getfield 963	com/tencent/mobileqq/vip/DownloadTask:m	Z
    //   6797: istore 14
    //   6799: iload 14
    //   6801: iconst_1
    //   6802: if_icmpne +776 -> 7578
    //   6805: iload_3
    //   6806: istore 4
    //   6808: iload 9
    //   6810: ifle +765 -> 7575
    //   6813: iload 4
    //   6815: istore 8
    //   6817: aload_0
    //   6818: getfield 165	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6821: invokeinterface 171 1 0
    //   6826: iconst_1
    //   6827: if_icmple +748 -> 7575
    //   6830: iload 4
    //   6832: istore 8
    //   6834: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6837: ifeq +52 -> 6889
    //   6840: iload 4
    //   6842: istore 8
    //   6844: ldc 74
    //   6846: iconst_2
    //   6847: new 121	java/lang/StringBuilder
    //   6850: dup
    //   6851: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   6854: ldc_w 965
    //   6857: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6860: iload 9
    //   6862: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6865: ldc_w 967
    //   6868: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6871: aload_0
    //   6872: getfield 165	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6875: invokeinterface 171 1 0
    //   6880: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6883: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6886: invokestatic 788	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   6889: iload 4
    //   6891: istore 8
    //   6893: aload_0
    //   6894: bipush 148
    //   6896: putfield 116	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6899: iconst_m1
    //   6900: istore 4
    //   6902: iload 4
    //   6904: istore_3
    //   6905: aload_0
    //   6906: invokevirtual 326	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   6909: ifeq +45 -> 6954
    //   6912: iload 4
    //   6914: istore_3
    //   6915: aload_0
    //   6916: getfield 970	com/tencent/mobileqq/vip/DownloadTask:g	Z
    //   6919: ifne +35 -> 6954
    //   6922: iload 4
    //   6924: istore_3
    //   6925: iload 4
    //   6927: istore 5
    //   6929: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6932: ifeq -6611 -> 321
    //   6935: iload 4
    //   6937: istore_3
    //   6938: ldc 74
    //   6940: iconst_2
    //   6941: ldc_w 972
    //   6944: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6947: iload 4
    //   6949: istore 5
    //   6951: goto -6630 -> 321
    //   6954: iload 4
    //   6956: istore_3
    //   6957: aload_0
    //   6958: invokevirtual 326	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   6961: ifeq +980 -> 7941
    //   6964: iload 4
    //   6966: istore_3
    //   6967: aload_0
    //   6968: iconst_2
    //   6969: invokevirtual 975	com/tencent/mobileqq/vip/DownloadTask:a	(I)V
    //   6972: iload 4
    //   6974: istore_3
    //   6975: aload_0
    //   6976: invokevirtual 977	com/tencent/mobileqq/vip/DownloadTask:c	()V
    //   6979: iload 4
    //   6981: istore_3
    //   6982: aload_0
    //   6983: invokevirtual 119	com/tencent/mobileqq/vip/DownloadTask:e	()V
    //   6986: iload 4
    //   6988: istore 5
    //   6990: goto -6669 -> 321
    //   6993: iload 4
    //   6995: istore_3
    //   6996: aload_0
    //   6997: iload 5
    //   6999: invokevirtual 975	com/tencent/mobileqq/vip/DownloadTask:a	(I)V
    //   7002: goto -23 -> 6979
    //   7005: iconst_m1
    //   7006: istore 5
    //   7008: goto -15 -> 6993
    //   7011: astore 31
    //   7013: goto -5152 -> 1861
    //   7016: astore_1
    //   7017: aload 34
    //   7019: astore 28
    //   7021: goto -4982 -> 2039
    //   7024: astore_1
    //   7025: aload 29
    //   7027: astore 32
    //   7029: goto -4990 -> 2039
    //   7032: astore_1
    //   7033: aload 32
    //   7035: astore 31
    //   7037: aload 29
    //   7039: astore 32
    //   7041: goto -5002 -> 2039
    //   7044: astore_1
    //   7045: aload 31
    //   7047: astore 30
    //   7049: aload 32
    //   7051: astore 31
    //   7053: aload 29
    //   7055: astore 32
    //   7057: goto -5018 -> 2039
    //   7060: astore_1
    //   7061: aload 32
    //   7063: astore 31
    //   7065: aload 29
    //   7067: astore 32
    //   7069: goto -5030 -> 2039
    //   7072: astore_1
    //   7073: iconst_0
    //   7074: istore 6
    //   7076: aload 32
    //   7078: astore 31
    //   7080: aload 29
    //   7082: astore 32
    //   7084: goto -5045 -> 2039
    //   7087: astore_1
    //   7088: aload 32
    //   7090: astore 31
    //   7092: aload 29
    //   7094: astore 32
    //   7096: goto -5057 -> 2039
    //   7099: astore 28
    //   7101: aload 32
    //   7103: astore 34
    //   7105: iconst_0
    //   7106: istore 13
    //   7108: aload 31
    //   7110: astore 29
    //   7112: iload 6
    //   7114: istore 8
    //   7116: aload 28
    //   7118: astore 32
    //   7120: aload 33
    //   7122: astore 28
    //   7124: iload 7
    //   7126: istore 6
    //   7128: iload_3
    //   7129: istore 5
    //   7131: aload 34
    //   7133: astore 31
    //   7135: iload 8
    //   7137: istore_3
    //   7138: goto -6218 -> 920
    //   7141: astore 29
    //   7143: iconst_1
    //   7144: istore 8
    //   7146: aload 32
    //   7148: astore 33
    //   7150: iconst_0
    //   7151: istore 13
    //   7153: aload 29
    //   7155: astore 32
    //   7157: iload 5
    //   7159: istore 4
    //   7161: aload 31
    //   7163: astore 29
    //   7165: iload 6
    //   7167: istore 7
    //   7169: iload 8
    //   7171: istore 6
    //   7173: iload_3
    //   7174: istore 5
    //   7176: aload 33
    //   7178: astore 31
    //   7180: iload 7
    //   7182: istore_3
    //   7183: goto -6263 -> 920
    //   7186: astore 34
    //   7188: iload_3
    //   7189: istore 7
    //   7191: iload 4
    //   7193: istore_3
    //   7194: iconst_0
    //   7195: istore 13
    //   7197: aload 32
    //   7199: astore 33
    //   7201: iload 5
    //   7203: istore 4
    //   7205: aload 31
    //   7207: astore 29
    //   7209: iload 6
    //   7211: istore 8
    //   7213: aload 34
    //   7215: astore 32
    //   7217: iload 7
    //   7219: istore 6
    //   7221: iload_3
    //   7222: istore 5
    //   7224: aload 33
    //   7226: astore 31
    //   7228: iload 8
    //   7230: istore_3
    //   7231: goto -6311 -> 920
    //   7234: astore 32
    //   7236: iconst_1
    //   7237: istore 13
    //   7239: iload 4
    //   7241: istore 7
    //   7243: aload 29
    //   7245: astore 33
    //   7247: iload 6
    //   7249: istore 8
    //   7251: iload_3
    //   7252: istore 6
    //   7254: iload 5
    //   7256: istore 4
    //   7258: iload 7
    //   7260: istore 5
    //   7262: aload 31
    //   7264: astore 29
    //   7266: aload 33
    //   7268: astore 31
    //   7270: iload 8
    //   7272: istore_3
    //   7273: goto -6353 -> 920
    //   7276: astore 32
    //   7278: iload 6
    //   7280: istore 8
    //   7282: iload 4
    //   7284: istore 5
    //   7286: aload 29
    //   7288: astore 33
    //   7290: iconst_1
    //   7291: istore 13
    //   7293: iload 7
    //   7295: istore 4
    //   7297: lload 20
    //   7299: lstore 16
    //   7301: iload_3
    //   7302: istore 6
    //   7304: aload 31
    //   7306: astore 29
    //   7308: aload 33
    //   7310: astore 31
    //   7312: iload 8
    //   7314: istore_3
    //   7315: goto -6395 -> 920
    //   7318: astore 34
    //   7320: aload 32
    //   7322: astore 31
    //   7324: iload 6
    //   7326: istore 7
    //   7328: iload 4
    //   7330: istore 8
    //   7332: aload 29
    //   7334: astore 33
    //   7336: iconst_1
    //   7337: istore 13
    //   7339: iload 5
    //   7341: istore 4
    //   7343: aload 34
    //   7345: astore 32
    //   7347: iload_3
    //   7348: istore 6
    //   7350: iload 8
    //   7352: istore 5
    //   7354: aload 31
    //   7356: astore 29
    //   7358: aload 33
    //   7360: astore 31
    //   7362: iload 7
    //   7364: istore_3
    //   7365: goto -6445 -> 920
    //   7368: astore 34
    //   7370: aload 32
    //   7372: astore 30
    //   7374: iload 6
    //   7376: istore 7
    //   7378: iload 4
    //   7380: istore 8
    //   7382: aload 29
    //   7384: astore 33
    //   7386: iload 5
    //   7388: istore 4
    //   7390: iconst_1
    //   7391: istore 13
    //   7393: aload 34
    //   7395: astore 32
    //   7397: iload_3
    //   7398: istore 6
    //   7400: iload 8
    //   7402: istore 5
    //   7404: aload 30
    //   7406: astore 29
    //   7408: aload 31
    //   7410: astore 30
    //   7412: aload 33
    //   7414: astore 31
    //   7416: iload 7
    //   7418: istore_3
    //   7419: goto -6499 -> 920
    //   7422: astore 34
    //   7424: aload 32
    //   7426: astore 31
    //   7428: iload 6
    //   7430: istore 7
    //   7432: iload 4
    //   7434: istore 8
    //   7436: aload 29
    //   7438: astore 33
    //   7440: iconst_1
    //   7441: istore 13
    //   7443: iload 5
    //   7445: istore 4
    //   7447: aload 34
    //   7449: astore 32
    //   7451: iload_3
    //   7452: istore 6
    //   7454: iload 8
    //   7456: istore 5
    //   7458: aload 31
    //   7460: astore 29
    //   7462: aload 33
    //   7464: astore 31
    //   7466: iload 7
    //   7468: istore_3
    //   7469: goto -6549 -> 920
    //   7472: astore 34
    //   7474: lload 20
    //   7476: lstore 18
    //   7478: aload 32
    //   7480: astore 31
    //   7482: iload 6
    //   7484: istore 7
    //   7486: iload 4
    //   7488: istore 8
    //   7490: aload 29
    //   7492: astore 33
    //   7494: iconst_1
    //   7495: istore 13
    //   7497: iload 5
    //   7499: istore 4
    //   7501: aload 34
    //   7503: astore 32
    //   7505: iload_3
    //   7506: istore 6
    //   7508: iload 8
    //   7510: istore 5
    //   7512: aload 31
    //   7514: astore 29
    //   7516: aload 33
    //   7518: astore 31
    //   7520: iload 7
    //   7522: istore_3
    //   7523: goto -6603 -> 920
    //   7526: astore 33
    //   7528: aload 32
    //   7530: astore 31
    //   7532: iload 6
    //   7534: istore 7
    //   7536: iconst_1
    //   7537: istore 8
    //   7539: iconst_1
    //   7540: istore 13
    //   7542: aload 33
    //   7544: astore 32
    //   7546: iload 4
    //   7548: istore 5
    //   7550: aload 29
    //   7552: astore 33
    //   7554: iload_3
    //   7555: istore 6
    //   7557: iload 8
    //   7559: istore 4
    //   7561: aload 31
    //   7563: astore 29
    //   7565: aload 33
    //   7567: astore 31
    //   7569: iload 7
    //   7571: istore_3
    //   7572: goto -6652 -> 920
    //   7575: goto -673 -> 6902
    //   7578: iload 9
    //   7580: istore 4
    //   7582: goto -5711 -> 1871
    //   7585: iconst_0
    //   7586: istore 6
    //   7588: goto -2505 -> 5083
    //   7591: goto -3126 -> 4465
    //   7594: iload 7
    //   7596: istore 4
    //   7598: goto -4110 -> 3488
    //   7601: iload_3
    //   7602: istore 4
    //   7604: iload 7
    //   7606: istore_3
    //   7607: goto -4109 -> 3498
    //   7610: iload 8
    //   7612: istore 5
    //   7614: goto -4956 -> 2658
    //   7617: aload 31
    //   7619: astore 32
    //   7621: iload_3
    //   7622: istore 8
    //   7624: iload 4
    //   7626: istore_3
    //   7627: lload 18
    //   7629: lstore 20
    //   7631: iload 6
    //   7633: istore 7
    //   7635: lload 16
    //   7637: lstore 18
    //   7639: lload 20
    //   7641: lstore 16
    //   7643: aload 29
    //   7645: astore 31
    //   7647: iload 8
    //   7649: istore 6
    //   7651: iload 5
    //   7653: istore 11
    //   7655: goto -7007 -> 648
    //   7658: iload 4
    //   7660: ireturn
    //   7661: iconst_1
    //   7662: istore 7
    //   7664: goto -6714 -> 950
    //   7667: iload_3
    //   7668: ifne -884 -> 6784
    //   7671: iconst_1
    //   7672: istore 14
    //   7674: goto -6019 -> 1655
    //   7677: aload 33
    //   7679: astore 31
    //   7681: iload 8
    //   7683: bipush 12
    //   7685: if_icmple -3142 -> 4543
    //   7688: aload 33
    //   7690: astore 31
    //   7692: bipush 82
    //   7694: aload 43
    //   7696: iconst_0
    //   7697: baload
    //   7698: if_icmpne -3155 -> 4543
    //   7701: aload 33
    //   7703: astore 31
    //   7705: bipush 73
    //   7707: aload 43
    //   7709: iconst_1
    //   7710: baload
    //   7711: if_icmpne -3168 -> 4543
    //   7714: aload 33
    //   7716: astore 31
    //   7718: bipush 70
    //   7720: aload 43
    //   7722: iconst_2
    //   7723: baload
    //   7724: if_icmpne -3181 -> 4543
    //   7727: aload 33
    //   7729: astore 31
    //   7731: bipush 70
    //   7733: aload 43
    //   7735: iconst_3
    //   7736: baload
    //   7737: if_icmpne -3194 -> 4543
    //   7740: aload 33
    //   7742: astore 31
    //   7744: bipush 87
    //   7746: aload 43
    //   7748: bipush 8
    //   7750: baload
    //   7751: if_icmpne -3208 -> 4543
    //   7754: aload 33
    //   7756: astore 31
    //   7758: bipush 69
    //   7760: aload 43
    //   7762: bipush 9
    //   7764: baload
    //   7765: if_icmpne -3222 -> 4543
    //   7768: aload 33
    //   7770: astore 31
    //   7772: bipush 66
    //   7774: aload 43
    //   7776: bipush 10
    //   7778: baload
    //   7779: if_icmpne -3236 -> 4543
    //   7782: aload 33
    //   7784: astore 31
    //   7786: bipush 80
    //   7788: aload 43
    //   7790: bipush 11
    //   7792: baload
    //   7793: if_icmpne -3250 -> 4543
    //   7796: ldc_w 979
    //   7799: astore 31
    //   7801: goto -3258 -> 4543
    //   7804: sipush 302
    //   7807: iload 8
    //   7809: if_icmpeq -1929 -> 5880
    //   7812: sipush 301
    //   7815: iload 8
    //   7817: if_icmpne -1847 -> 5970
    //   7820: goto -1940 -> 5880
    //   7823: astore 32
    //   7825: iconst_1
    //   7826: istore 13
    //   7828: iload 4
    //   7830: istore 5
    //   7832: lload 18
    //   7834: lstore 20
    //   7836: iload 6
    //   7838: istore 4
    //   7840: iload_3
    //   7841: istore 6
    //   7843: lload 16
    //   7845: lstore 18
    //   7847: lload 20
    //   7849: lstore 16
    //   7851: iload 7
    //   7853: istore_3
    //   7854: goto -6934 -> 920
    //   7857: astore_1
    //   7858: aload 31
    //   7860: astore 32
    //   7862: iload 7
    //   7864: istore 6
    //   7866: aload 29
    //   7868: astore 31
    //   7870: goto -5831 -> 2039
    //   7873: astore_0
    //   7874: iload 8
    //   7876: istore_3
    //   7877: goto -7569 -> 308
    //   7880: ldc_w 981
    //   7883: astore 32
    //   7885: goto -2453 -> 5432
    //   7888: ldc_w 983
    //   7891: astore 32
    //   7893: goto -2431 -> 5462
    //   7896: astore_1
    //   7897: aload 31
    //   7899: astore 32
    //   7901: aload 29
    //   7903: astore 31
    //   7905: iload_3
    //   7906: istore 6
    //   7908: goto -5869 -> 2039
    //   7911: ldc_w 981
    //   7914: astore 32
    //   7916: goto -6692 -> 1224
    //   7919: ldc_w 983
    //   7922: astore 32
    //   7924: goto -6672 -> 1252
    //   7927: ldc_w 981
    //   7930: astore_0
    //   7931: goto -5700 -> 2231
    //   7934: ldc_w 983
    //   7937: astore_0
    //   7938: goto -5681 -> 2257
    //   7941: iload 4
    //   7943: ifne -938 -> 7005
    //   7946: iconst_3
    //   7947: istore 5
    //   7949: goto -956 -> 6993
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7952	0	paramDownloadTask	DownloadTask
    //   0	7952	1	paramString	String
    //   0	7952	2	paramContext	Context
    //   16	7890	3	i	int
    //   107	7835	4	j	int
    //   63	7885	5	k	int
    //   631	7276	6	m	int
    //   625	7238	7	n	int
    //   388	7487	8	i1	int
    //   379	7200	9	i2	int
    //   382	4281	10	i3	int
    //   628	7026	11	i4	int
    //   717	5204	12	i5	int
    //   401	7426	13	bool1	boolean
    //   1370	6303	14	bool2	boolean
    //   1674	3	15	bool3	boolean
    //   447	7403	16	l1	long
    //   634	7212	18	l2	long
    //   1320	6528	20	l3	long
    //   3970	691	22	l4	long
    //   431	1418	24	l5	long
    //   655	4615	26	l6	long
    //   206	6814	28	localObject1	Object
    //   7099	18	28	localThrowable1	java.lang.Throwable
    //   7122	1	28	localObject2	Object
    //   394	6717	29	localObject3	Object
    //   7141	13	29	localThrowable2	java.lang.Throwable
    //   7163	739	29	localObject4	Object
    //   391	7020	30	localObject5	Object
    //   572	6201	31	localObject6	Object
    //   7011	1	31	localThrowable3	java.lang.Throwable
    //   7035	869	31	localObject7	Object
    //   480	3546	32	localObject8	Object
    //   4196	1	32	localThrowable4	java.lang.Throwable
    //   4344	1767	32	localObject9	Object
    //   6117	1	32	localInterruptedException	java.lang.InterruptedException
    //   6149	10	32	localObject10	Object
    //   6289	927	32	localObject11	Object
    //   7234	1	32	localThrowable5	java.lang.Throwable
    //   7276	45	32	localThrowable6	java.lang.Throwable
    //   7345	275	32	localObject12	Object
    //   7823	1	32	localThrowable7	java.lang.Throwable
    //   7860	63	32	localObject13	Object
    //   514	284	33	localObject14	Object
    //   881	36	33	localThrowable8	java.lang.Throwable
    //   1206	2638	33	localObject15	Object
    //   3857	22	33	localThrowable9	java.lang.Throwable
    //   4010	1457	33	localObject16	Object
    //   5552	30	33	localException	java.lang.Exception
    //   5598	10	33	localThrowable10	java.lang.Throwable
    //   5617	21	33	localObject17	Object
    //   5695	17	33	localThrowable11	java.lang.Throwable
    //   5721	103	33	localObject18	Object
    //   6330	23	33	localIOException1	java.io.IOException
    //   6529	592	33	localIOException2	java.io.IOException
    //   7148	369	33	localObject19	Object
    //   7526	17	33	localThrowable12	java.lang.Throwable
    //   7552	231	33	localObject20	Object
    //   721	1984	34	localObject21	Object
    //   2767	22	34	localThrowable13	java.lang.Throwable
    //   2811	2391	34	localObject22	Object
    //   5783	1235	34	localThrowable14	java.lang.Throwable
    //   7103	29	34	localObject23	Object
    //   7186	28	34	localThrowable15	java.lang.Throwable
    //   7318	26	34	localThrowable16	java.lang.Throwable
    //   7368	26	34	localThrowable17	java.lang.Throwable
    //   7422	26	34	localThrowable18	java.lang.Throwable
    //   7472	30	34	localThrowable19	java.lang.Throwable
    //   460	4763	35	localHashMap	java.util.HashMap
    //   618	6018	36	localDownloadInfo	DownloadInfo
    //   510	4874	37	localFile1	java.io.File
    //   155	3381	38	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   444	5708	39	localObject24	Object
    //   530	296	40	localFile2	java.io.File
    //   568	5470	41	localFile3	java.io.File
    //   708	4972	42	localStringBuilder	java.lang.StringBuilder
    //   1965	5824	43	localObject25	Object
    //   2714	34	44	str1	String
    //   2728	31	45	str2	String
    // Exception table:
    //   from	to	target	type
    //   69	73	307	java/lang/Throwable
    //   79	86	307	java/lang/Throwable
    //   89	95	307	java/lang/Throwable
    //   98	102	307	java/lang/Throwable
    //   109	115	307	java/lang/Throwable
    //   118	143	307	java/lang/Throwable
    //   148	157	307	java/lang/Throwable
    //   160	176	307	java/lang/Throwable
    //   179	194	307	java/lang/Throwable
    //   197	204	307	java/lang/Throwable
    //   211	223	307	java/lang/Throwable
    //   226	233	307	java/lang/Throwable
    //   236	248	307	java/lang/Throwable
    //   251	257	307	java/lang/Throwable
    //   260	264	307	java/lang/Throwable
    //   271	277	307	java/lang/Throwable
    //   280	305	307	java/lang/Throwable
    //   370	381	307	java/lang/Throwable
    //   6905	6912	307	java/lang/Throwable
    //   6915	6922	307	java/lang/Throwable
    //   6929	6935	307	java/lang/Throwable
    //   6938	6947	307	java/lang/Throwable
    //   6957	6964	307	java/lang/Throwable
    //   6967	6972	307	java/lang/Throwable
    //   6975	6979	307	java/lang/Throwable
    //   6982	6986	307	java/lang/Throwable
    //   6996	7002	307	java/lang/Throwable
    //   817	858	881	java/lang/Throwable
    //   870	881	881	java/lang/Throwable
    //   2006	2015	881	java/lang/Throwable
    //   2027	2038	881	java/lang/Throwable
    //   817	858	2038	finally
    //   870	881	2038	finally
    //   2006	2015	2038	finally
    //   2027	2038	2038	finally
    //   652	657	2320	java/lang/Throwable
    //   661	710	2320	java/lang/Throwable
    //   1428	1432	2320	java/lang/Throwable
    //   1444	1453	2320	java/lang/Throwable
    //   1456	1467	2320	java/lang/Throwable
    //   1470	1486	2320	java/lang/Throwable
    //   1489	1505	2320	java/lang/Throwable
    //   1508	1522	2320	java/lang/Throwable
    //   1525	1539	2320	java/lang/Throwable
    //   1542	1563	2320	java/lang/Throwable
    //   1566	1579	2320	java/lang/Throwable
    //   1582	1596	2320	java/lang/Throwable
    //   1599	1610	2320	java/lang/Throwable
    //   1617	1627	2320	java/lang/Throwable
    //   1630	1643	2320	java/lang/Throwable
    //   1646	1652	2320	java/lang/Throwable
    //   1658	1663	2320	java/lang/Throwable
    //   1670	1676	2320	java/lang/Throwable
    //   2043	2082	2320	java/lang/Throwable
    //   2091	2098	2320	java/lang/Throwable
    //   2102	2109	2320	java/lang/Throwable
    //   2113	2121	2320	java/lang/Throwable
    //   2125	2136	2320	java/lang/Throwable
    //   2140	2175	2320	java/lang/Throwable
    //   2179	2194	2320	java/lang/Throwable
    //   2198	2203	2320	java/lang/Throwable
    //   2207	2215	2320	java/lang/Throwable
    //   2219	2227	2320	java/lang/Throwable
    //   2235	2241	2320	java/lang/Throwable
    //   2245	2253	2320	java/lang/Throwable
    //   2261	2270	2320	java/lang/Throwable
    //   2279	2286	2320	java/lang/Throwable
    //   2295	2300	2320	java/lang/Throwable
    //   2309	2314	2320	java/lang/Throwable
    //   2318	2320	2320	java/lang/Throwable
    //   6614	6619	2320	java/lang/Throwable
    //   6628	6643	2320	java/lang/Throwable
    //   6650	6655	2320	java/lang/Throwable
    //   6663	6703	2320	java/lang/Throwable
    //   6793	6799	2320	java/lang/Throwable
    //   2658	2675	2767	java/lang/Throwable
    //   2680	2694	2767	java/lang/Throwable
    //   2694	2764	2767	java/lang/Throwable
    //   2852	2897	2767	java/lang/Throwable
    //   2897	3055	2767	java/lang/Throwable
    //   3060	3137	2767	java/lang/Throwable
    //   3137	3151	2767	java/lang/Throwable
    //   3156	3171	2767	java/lang/Throwable
    //   3178	3252	2767	java/lang/Throwable
    //   3252	3360	2767	java/lang/Throwable
    //   3360	3393	2767	java/lang/Throwable
    //   3393	3418	2767	java/lang/Throwable
    //   3428	3450	2767	java/lang/Throwable
    //   3895	3910	2767	java/lang/Throwable
    //   3574	3588	3857	java/lang/Throwable
    //   3592	3598	3857	java/lang/Throwable
    //   3602	3609	3857	java/lang/Throwable
    //   3613	3647	3857	java/lang/Throwable
    //   3651	3660	3857	java/lang/Throwable
    //   3664	3674	3857	java/lang/Throwable
    //   3678	3687	3857	java/lang/Throwable
    //   3691	3700	3857	java/lang/Throwable
    //   3704	3715	3857	java/lang/Throwable
    //   3719	3730	3857	java/lang/Throwable
    //   3734	3745	3857	java/lang/Throwable
    //   3749	3760	3857	java/lang/Throwable
    //   3764	3775	3857	java/lang/Throwable
    //   3779	3790	3857	java/lang/Throwable
    //   3794	3805	3857	java/lang/Throwable
    //   3809	3820	3857	java/lang/Throwable
    //   3824	3854	3857	java/lang/Throwable
    //   3954	3963	3857	java/lang/Throwable
    //   5847	5853	3857	java/lang/Throwable
    //   5884	5891	3857	java/lang/Throwable
    //   5901	5908	3857	java/lang/Throwable
    //   5937	5943	3857	java/lang/Throwable
    //   5982	5987	3857	java/lang/Throwable
    //   6025	6033	3857	java/lang/Throwable
    //   6037	6043	3857	java/lang/Throwable
    //   6047	6053	3857	java/lang/Throwable
    //   6084	6090	3857	java/lang/Throwable
    //   2658	2675	3913	finally
    //   2680	2694	3913	finally
    //   2694	2764	3913	finally
    //   2852	2897	3913	finally
    //   2897	3055	3913	finally
    //   3060	3137	3913	finally
    //   3137	3151	3913	finally
    //   3156	3171	3913	finally
    //   3178	3252	3913	finally
    //   3252	3360	3913	finally
    //   3360	3393	3913	finally
    //   3393	3418	3913	finally
    //   3428	3450	3913	finally
    //   3453	3488	3913	finally
    //   3498	3520	3913	finally
    //   3520	3547	3913	finally
    //   3551	3570	3913	finally
    //   3574	3588	3913	finally
    //   3592	3598	3913	finally
    //   3602	3609	3913	finally
    //   3613	3647	3913	finally
    //   3651	3660	3913	finally
    //   3664	3674	3913	finally
    //   3678	3687	3913	finally
    //   3691	3700	3913	finally
    //   3704	3715	3913	finally
    //   3719	3730	3913	finally
    //   3734	3745	3913	finally
    //   3749	3760	3913	finally
    //   3764	3775	3913	finally
    //   3779	3790	3913	finally
    //   3794	3805	3913	finally
    //   3809	3820	3913	finally
    //   3824	3854	3913	finally
    //   3895	3910	3913	finally
    //   3954	3963	3913	finally
    //   5847	5853	3913	finally
    //   5884	5891	3913	finally
    //   5901	5908	3913	finally
    //   5937	5943	3913	finally
    //   5982	5987	3913	finally
    //   6025	6033	3913	finally
    //   6037	6043	3913	finally
    //   6047	6053	3913	finally
    //   6084	6090	3913	finally
    //   4157	4173	4196	java/lang/Throwable
    //   4185	4196	4196	java/lang/Throwable
    //   4326	4337	4196	java/lang/Throwable
    //   4157	4173	4337	finally
    //   4185	4196	4337	finally
    //   4326	4337	4337	finally
    //   4967	5080	5552	java/lang/Exception
    //   4896	4910	5598	java/lang/Throwable
    //   4910	4962	5598	java/lang/Throwable
    //   4967	5080	5598	java/lang/Throwable
    //   5554	5595	5598	java/lang/Throwable
    //   5679	5688	5695	java/lang/Throwable
    //   5762	5768	5783	java/lang/Throwable
    //   5772	5783	5783	java/lang/Throwable
    //   5173	5180	6117	java/lang/InterruptedException
    //   5173	5180	6149	finally
    //   5180	5183	6149	finally
    //   6119	6146	6149	finally
    //   6151	6154	6149	finally
    //   5493	5500	6330	java/io/IOException
    //   5509	5514	6330	java/io/IOException
    //   5523	5528	6330	java/io/IOException
    //   1281	1288	6529	java/io/IOException
    //   1296	1301	6529	java/io/IOException
    //   1309	1314	6529	java/io/IOException
    //   2279	2286	6658	java/io/IOException
    //   2295	2300	6658	java/io/IOException
    //   2309	2314	6658	java/io/IOException
    //   1681	1764	7011	java/lang/Throwable
    //   1773	1783	7011	java/lang/Throwable
    //   1787	1800	7011	java/lang/Throwable
    //   1805	1837	7011	java/lang/Throwable
    //   1837	1861	7011	java/lang/Throwable
    //   731	736	7016	finally
    //   753	761	7016	finally
    //   773	781	7016	finally
    //   799	805	7016	finally
    //   1918	1924	7016	finally
    //   1936	1950	7016	finally
    //   1962	1967	7016	finally
    //   1988	1994	7016	finally
    //   2343	2350	7016	finally
    //   2366	2377	7016	finally
    //   2389	2409	7016	finally
    //   2421	2429	7016	finally
    //   2441	2469	7016	finally
    //   2481	2488	7016	finally
    //   2500	2506	7016	finally
    //   2518	2545	7016	finally
    //   2557	2567	7016	finally
    //   2584	2591	7016	finally
    //   2603	2614	7016	finally
    //   2626	2631	7016	finally
    //   2645	2658	7016	finally
    //   2821	2849	7016	finally
    //   3963	3972	7024	finally
    //   3980	3992	7024	finally
    //   4000	4012	7024	finally
    //   4025	4046	7024	finally
    //   4054	4061	7024	finally
    //   4069	4083	7024	finally
    //   4098	4107	7024	finally
    //   4115	4125	7024	finally
    //   4139	4145	7024	finally
    //   4255	4268	7024	finally
    //   4294	4300	7024	finally
    //   4312	4318	7024	finally
    //   4367	4387	7024	finally
    //   4387	4439	7032	finally
    //   4687	4696	7032	finally
    //   4439	4448	7044	finally
    //   4452	4462	7060	finally
    //   4469	4476	7060	finally
    //   4480	4489	7060	finally
    //   4499	4505	7060	finally
    //   4552	4566	7060	finally
    //   4570	4580	7060	finally
    //   4607	4616	7060	finally
    //   4620	4630	7060	finally
    //   4634	4645	7060	finally
    //   4657	4667	7060	finally
    //   4671	4675	7060	finally
    //   4796	4801	7060	finally
    //   4805	4813	7060	finally
    //   4817	4828	7060	finally
    //   4832	4845	7060	finally
    //   4849	4872	7060	finally
    //   4876	4887	7060	finally
    //   4891	4896	7060	finally
    //   5651	5657	7060	finally
    //   5669	5675	7060	finally
    //   5752	5758	7060	finally
    //   4896	4910	7072	finally
    //   4910	4962	7072	finally
    //   4967	5080	7072	finally
    //   5554	5595	7072	finally
    //   5679	5688	7087	finally
    //   5762	5768	7087	finally
    //   5772	5783	7087	finally
    //   731	736	7099	java/lang/Throwable
    //   753	761	7099	java/lang/Throwable
    //   773	781	7099	java/lang/Throwable
    //   799	805	7099	java/lang/Throwable
    //   1918	1924	7099	java/lang/Throwable
    //   1936	1950	7099	java/lang/Throwable
    //   1962	1967	7099	java/lang/Throwable
    //   1988	1994	7099	java/lang/Throwable
    //   2343	2350	7099	java/lang/Throwable
    //   2366	2377	7099	java/lang/Throwable
    //   2389	2409	7099	java/lang/Throwable
    //   2421	2429	7099	java/lang/Throwable
    //   2441	2469	7099	java/lang/Throwable
    //   2481	2488	7099	java/lang/Throwable
    //   2500	2506	7099	java/lang/Throwable
    //   2518	2545	7099	java/lang/Throwable
    //   2557	2567	7099	java/lang/Throwable
    //   2584	2591	7099	java/lang/Throwable
    //   2603	2614	7099	java/lang/Throwable
    //   2626	2631	7099	java/lang/Throwable
    //   2645	2658	7099	java/lang/Throwable
    //   2821	2849	7099	java/lang/Throwable
    //   3453	3488	7141	java/lang/Throwable
    //   3498	3520	7186	java/lang/Throwable
    //   3520	3547	7186	java/lang/Throwable
    //   3551	3570	7186	java/lang/Throwable
    //   3963	3972	7234	java/lang/Throwable
    //   3980	3992	7276	java/lang/Throwable
    //   4000	4012	7276	java/lang/Throwable
    //   4025	4046	7276	java/lang/Throwable
    //   4054	4061	7276	java/lang/Throwable
    //   4069	4083	7276	java/lang/Throwable
    //   4098	4107	7276	java/lang/Throwable
    //   4115	4125	7276	java/lang/Throwable
    //   4139	4145	7276	java/lang/Throwable
    //   4255	4268	7276	java/lang/Throwable
    //   4294	4300	7276	java/lang/Throwable
    //   4312	4318	7276	java/lang/Throwable
    //   4367	4387	7276	java/lang/Throwable
    //   4387	4439	7318	java/lang/Throwable
    //   4687	4696	7318	java/lang/Throwable
    //   4439	4448	7368	java/lang/Throwable
    //   4452	4462	7422	java/lang/Throwable
    //   4469	4476	7472	java/lang/Throwable
    //   4480	4489	7472	java/lang/Throwable
    //   4499	4505	7472	java/lang/Throwable
    //   4552	4566	7472	java/lang/Throwable
    //   4570	4580	7472	java/lang/Throwable
    //   4607	4616	7472	java/lang/Throwable
    //   4620	4630	7472	java/lang/Throwable
    //   4634	4645	7472	java/lang/Throwable
    //   4657	4667	7472	java/lang/Throwable
    //   4671	4675	7472	java/lang/Throwable
    //   4796	4801	7472	java/lang/Throwable
    //   4805	4813	7472	java/lang/Throwable
    //   4817	4828	7472	java/lang/Throwable
    //   4832	4845	7472	java/lang/Throwable
    //   4849	4872	7472	java/lang/Throwable
    //   4876	4887	7472	java/lang/Throwable
    //   4891	4896	7472	java/lang/Throwable
    //   5651	5657	7472	java/lang/Throwable
    //   5752	5758	7472	java/lang/Throwable
    //   5669	5675	7526	java/lang/Throwable
    //   5111	5117	7823	java/lang/Throwable
    //   5121	5131	7823	java/lang/Throwable
    //   5140	5147	7823	java/lang/Throwable
    //   5151	5160	7823	java/lang/Throwable
    //   5164	5167	7823	java/lang/Throwable
    //   5187	5197	7823	java/lang/Throwable
    //   5201	5213	7823	java/lang/Throwable
    //   5222	5238	7823	java/lang/Throwable
    //   6158	6161	7823	java/lang/Throwable
    //   6165	6175	7823	java/lang/Throwable
    //   6179	6186	7823	java/lang/Throwable
    //   6190	6206	7823	java/lang/Throwable
    //   6209	6264	7823	java/lang/Throwable
    //   6268	6279	7823	java/lang/Throwable
    //   5111	5117	7857	finally
    //   5121	5131	7857	finally
    //   5140	5147	7857	finally
    //   5151	5160	7857	finally
    //   5164	5167	7857	finally
    //   5187	5197	7857	finally
    //   5201	5213	7857	finally
    //   5222	5238	7857	finally
    //   6158	6161	7857	finally
    //   6165	6175	7857	finally
    //   6179	6186	7857	finally
    //   6190	6206	7857	finally
    //   6209	6264	7857	finally
    //   6268	6279	7857	finally
    //   407	421	7873	java/lang/Throwable
    //   428	433	7873	java/lang/Throwable
    //   437	446	7873	java/lang/Throwable
    //   453	462	7873	java/lang/Throwable
    //   466	482	7873	java/lang/Throwable
    //   486	492	7873	java/lang/Throwable
    //   496	512	7873	java/lang/Throwable
    //   525	532	7873	java/lang/Throwable
    //   536	570	7873	java/lang/Throwable
    //   578	588	7873	java/lang/Throwable
    //   592	603	7873	java/lang/Throwable
    //   607	620	7873	java/lang/Throwable
    //   1044	1083	7873	java/lang/Throwable
    //   1090	1097	7873	java/lang/Throwable
    //   1100	1107	7873	java/lang/Throwable
    //   1110	1118	7873	java/lang/Throwable
    //   1121	1132	7873	java/lang/Throwable
    //   1135	1170	7873	java/lang/Throwable
    //   1173	1188	7873	java/lang/Throwable
    //   1191	1196	7873	java/lang/Throwable
    //   1199	1208	7873	java/lang/Throwable
    //   1211	1219	7873	java/lang/Throwable
    //   1227	1236	7873	java/lang/Throwable
    //   1239	1247	7873	java/lang/Throwable
    //   1255	1267	7873	java/lang/Throwable
    //   1281	1288	7873	java/lang/Throwable
    //   1296	1301	7873	java/lang/Throwable
    //   1309	1314	7873	java/lang/Throwable
    //   1354	1363	7873	java/lang/Throwable
    //   1366	1372	7873	java/lang/Throwable
    //   5242	5281	7873	java/lang/Throwable
    //   5290	5297	7873	java/lang/Throwable
    //   5301	5308	7873	java/lang/Throwable
    //   5312	5320	7873	java/lang/Throwable
    //   5324	5335	7873	java/lang/Throwable
    //   5339	5374	7873	java/lang/Throwable
    //   5378	5393	7873	java/lang/Throwable
    //   5397	5402	7873	java/lang/Throwable
    //   5406	5415	7873	java/lang/Throwable
    //   5419	5427	7873	java/lang/Throwable
    //   5436	5445	7873	java/lang/Throwable
    //   5449	5457	7873	java/lang/Throwable
    //   5466	5478	7873	java/lang/Throwable
    //   5493	5500	7873	java/lang/Throwable
    //   5509	5514	7873	java/lang/Throwable
    //   5523	5528	7873	java/lang/Throwable
    //   6286	6291	7873	java/lang/Throwable
    //   6300	6315	7873	java/lang/Throwable
    //   6322	6327	7873	java/lang/Throwable
    //   6336	6377	7873	java/lang/Throwable
    //   6487	6492	7873	java/lang/Throwable
    //   6500	6515	7873	java/lang/Throwable
    //   6521	6526	7873	java/lang/Throwable
    //   6534	6575	7873	java/lang/Throwable
    //   6710	6716	7873	java/lang/Throwable
    //   6720	6726	7873	java/lang/Throwable
    //   6730	6739	7873	java/lang/Throwable
    //   6817	6830	7873	java/lang/Throwable
    //   6834	6840	7873	java/lang/Throwable
    //   6844	6889	7873	java/lang/Throwable
    //   6893	6899	7873	java/lang/Throwable
    //   923	939	7896	finally
    //   939	947	7896	finally
    //   950	964	7896	finally
    //   964	973	7896	finally
    //   988	993	7896	finally
    //   993	1041	7896	finally
    //   6401	6415	7896	finally
    //   6418	6434	7896	finally
    //   6434	6440	7896	finally
    //   6443	6457	7896	finally
    //   6460	6473	7896	finally
    //   6476	6481	7896	finally
  }
  
  public static int a(DownloadTask paramDownloadTask, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if ((paramDownloadTask.jdField_i_of_type_Boolean) && (!QQSharpPUtil.b(paramAppRuntime.getApplication())) && ((paramAppRuntime instanceof QQAppInterface)))
      {
        EarlyHandler localEarlyHandler = ((EarlyDownloadManager)((QQAppInterface)paramAppRuntime).getManager(76)).a(QavSoDownloadHandler.e());
        if (localEarlyHandler == null) {
          break label69;
        }
        localEarlyHandler.a(false);
      }
      for (;;)
      {
        return a(paramDownloadTask, paramAppRuntime.getAccount(), paramAppRuntime.getApplication());
        label69:
        QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo null == earlyHandler:");
      }
    }
    return a(paramDownloadTask, null, null);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str2 = "http://[^/\\s]*/";
      String str1 = "http://" + paramString2 + "/";
      if (paramString1.startsWith("https"))
      {
        str2 = "https://[^/\\s]*/";
        str1 = "https://" + paramString2 + "/";
      }
      return paramString1.replaceFirst(str2, str1);
    }
    return null;
  }
  
  public static void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.jdField_a_of_type_JavaLangString))) {}
    do
    {
      String str1;
      String str2;
      do
      {
        return;
        str1 = InnerDns.a(paramDownloadInfo.jdField_a_of_type_JavaLangString);
        if ((!jdField_a_of_type_JavaUtilMap.containsKey(str1)) || (!paramDownloadInfo.jdField_a_of_type_JavaLangString.startsWith("http"))) {
          break;
        }
        str2 = InnerDns.a().a(str1, ((Integer)jdField_a_of_type_JavaUtilMap.get(str1)).intValue());
      } while (TextUtils.isEmpty(str2));
      String str3 = a(paramDownloadInfo.jdField_a_of_type_JavaLangString, str2);
      if (!TextUtils.isEmpty(str3))
      {
        paramDownloadInfo.jdField_b_of_type_JavaLangString = str3;
        paramDownloadInfo.jdField_c_of_type_JavaLangString = str1;
        paramDownloadInfo.jdField_d_of_type_JavaLangString = str2;
        paramDownloadInfo.jdField_a_of_type_Boolean = true;
        return;
      }
      paramDownloadInfo.jdField_b_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
      return;
      HttpDownloadUtil.a(paramDownloadInfo);
    } while (!QLog.isColorLevel());
    QLog.d("DownloaderFactory", 2, "use new httpDNS. url: " + paramDownloadInfo.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(NetworkUtil.a(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      ReportController.b(null, "P_CliOper", "VipDownload", "0", "VipDownload", "ip", 0, paramInt, "", paramContext, paramString2, paramString1);
      return;
      paramString2 = "unknow";
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      int i = NetworkUtil.a(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "isQualityNetwork type=" + i);
      }
      if ((i != 3) && (i != 4))
      {
        bool1 = bool2;
        if (i != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return false;
    }
    if ((paramDownloadTask.jdField_a_of_type_JavaUtilList == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilList.size() < 1) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap.size() < 1) || (TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    paramDownloadTask = paramDownloadTask.jdField_a_of_type_JavaUtilList.iterator();
    while (paramDownloadTask.hasNext())
    {
      String str = (String)paramDownloadTask.next();
      if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str))) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile1, java.io.File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 8
    //   9: iload 8
    //   11: istore 6
    //   13: aload_0
    //   14: ifnull +18 -> 32
    //   17: aload_0
    //   18: invokevirtual 268	java/io/File:exists	()Z
    //   21: istore 6
    //   23: iload 6
    //   25: ifne +13 -> 38
    //   28: iload 8
    //   30: istore 6
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload 6
    //   37: ireturn
    //   38: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   41: lstore 13
    //   43: aload_1
    //   44: invokevirtual 268	java/io/File:exists	()Z
    //   47: ifeq +368 -> 415
    //   50: aload_1
    //   51: invokevirtual 1073	java/io/File:listFiles	()[Ljava/io/File;
    //   54: astore 15
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: aload 15
    //   61: arraylength
    //   62: if_icmpge +358 -> 420
    //   65: aload 15
    //   67: iload_3
    //   68: aaload
    //   69: astore 16
    //   71: aload 16
    //   73: invokevirtual 1076	java/io/File:isDirectory	()Z
    //   76: ifeq +57 -> 133
    //   79: aload 16
    //   81: invokevirtual 1073	java/io/File:listFiles	()[Ljava/io/File;
    //   84: astore 17
    //   86: aload 17
    //   88: ifnull +535 -> 623
    //   91: aload 17
    //   93: arraylength
    //   94: istore 5
    //   96: iconst_0
    //   97: istore 4
    //   99: iload 4
    //   101: iload 5
    //   103: if_icmpge +21 -> 124
    //   106: aload 17
    //   108: iload 4
    //   110: aaload
    //   111: invokevirtual 818	java/io/File:delete	()Z
    //   114: pop
    //   115: iload 4
    //   117: iconst_1
    //   118: iadd
    //   119: istore 4
    //   121: goto -22 -> 99
    //   124: aload 16
    //   126: invokevirtual 818	java/io/File:delete	()Z
    //   129: pop
    //   130: goto +493 -> 623
    //   133: aload 15
    //   135: iload_3
    //   136: aaload
    //   137: invokevirtual 818	java/io/File:delete	()Z
    //   140: pop
    //   141: goto +482 -> 623
    //   144: astore 15
    //   146: ldc 74
    //   148: iconst_2
    //   149: new 121	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1078
    //   159: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 15
    //   171: invokevirtual 919	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 7
    //   185: istore_2
    //   186: invokestatic 1084	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   189: invokestatic 1087	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   192: if_acmpeq +158 -> 350
    //   195: aload_0
    //   196: invokevirtual 579	java/io/File:length	()J
    //   199: lstore 11
    //   201: aload_0
    //   202: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: invokestatic 1090	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 17
    //   210: aconst_null
    //   211: astore 16
    //   213: lload 11
    //   215: ldc2_w 1091
    //   218: lcmp
    //   219: ifle +277 -> 496
    //   222: ldc2_w 1091
    //   225: lstore 9
    //   227: lload 9
    //   229: l2i
    //   230: newarray char
    //   232: astore 18
    //   234: new 1094	java/io/FileInputStream
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 1097	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   242: astore_0
    //   243: new 1099	java/io/InputStreamReader
    //   246: dup
    //   247: aload_0
    //   248: ldc_w 1101
    //   251: invokespecial 1104	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   254: astore 15
    //   256: aload 15
    //   258: aload 18
    //   260: invokevirtual 1107	java/io/InputStreamReader:read	([C)I
    //   263: pop
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 365	java/io/InputStream:close	()V
    //   272: aload 15
    //   274: ifnull +8 -> 282
    //   277: aload 15
    //   279: invokevirtual 1108	java/io/InputStreamReader:close	()V
    //   282: ldc 74
    //   284: iconst_2
    //   285: new 121	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 1078
    //   295: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   302: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 1110
    //   308: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: lload 11
    //   313: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: ldc_w 1112
    //   319: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 17
    //   324: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 1114
    //   330: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 18
    //   335: invokestatic 1117	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   338: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: iload 7
    //   349: istore_2
    //   350: iload_2
    //   351: istore 6
    //   353: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -324 -> 32
    //   359: ldc 74
    //   361: iconst_2
    //   362: new 121	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 1119
    //   372: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   378: lload 13
    //   380: lsub
    //   381: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   384: ldc_w 1121
    //   387: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_1
    //   391: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   394: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iload_2
    //   404: istore 6
    //   406: goto -374 -> 32
    //   409: astore_0
    //   410: ldc 2
    //   412: monitorexit
    //   413: aload_0
    //   414: athrow
    //   415: aload_1
    //   416: invokevirtual 271	java/io/File:mkdirs	()Z
    //   419: pop
    //   420: aload_0
    //   421: new 121	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   428: aload_1
    //   429: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: getstatic 1125	java/io/File:separatorChar	C
    //   438: invokevirtual 1128	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   441: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 1132	com/tencent/biz/common/util/ZipUtils:a	(Ljava/io/File;Ljava/lang/String;)V
    //   447: iload_2
    //   448: ifeq +8 -> 456
    //   451: aload_0
    //   452: invokevirtual 818	java/io/File:delete	()Z
    //   455: pop
    //   456: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +32 -> 491
    //   462: ldc 74
    //   464: iconst_2
    //   465: new 121	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 1134
    //   475: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_1
    //   479: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   482: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: iconst_1
    //   492: istore_2
    //   493: goto -143 -> 350
    //   496: lload 11
    //   498: lstore 9
    //   500: goto -273 -> 227
    //   503: astore_0
    //   504: aconst_null
    //   505: astore 15
    //   507: aconst_null
    //   508: astore_0
    //   509: aload 15
    //   511: ifnull +8 -> 519
    //   514: aload 15
    //   516: invokevirtual 365	java/io/InputStream:close	()V
    //   519: aload_0
    //   520: ifnull -238 -> 282
    //   523: aload_0
    //   524: invokevirtual 1108	java/io/InputStreamReader:close	()V
    //   527: goto -245 -> 282
    //   530: astore_0
    //   531: goto -249 -> 282
    //   534: astore_1
    //   535: aconst_null
    //   536: astore_0
    //   537: aload 16
    //   539: astore 15
    //   541: aload_0
    //   542: ifnull +7 -> 549
    //   545: aload_0
    //   546: invokevirtual 365	java/io/InputStream:close	()V
    //   549: aload 15
    //   551: ifnull +8 -> 559
    //   554: aload 15
    //   556: invokevirtual 1108	java/io/InputStreamReader:close	()V
    //   559: aload_1
    //   560: athrow
    //   561: astore_0
    //   562: goto -290 -> 272
    //   565: astore_0
    //   566: goto -284 -> 282
    //   569: astore 15
    //   571: goto -52 -> 519
    //   574: astore_0
    //   575: goto -26 -> 549
    //   578: astore_0
    //   579: goto -20 -> 559
    //   582: astore_1
    //   583: aload 16
    //   585: astore 15
    //   587: goto -46 -> 541
    //   590: astore_1
    //   591: goto -50 -> 541
    //   594: astore 15
    //   596: aconst_null
    //   597: astore 16
    //   599: aload_0
    //   600: astore 15
    //   602: aload 16
    //   604: astore_0
    //   605: goto -96 -> 509
    //   608: astore 16
    //   610: aload_0
    //   611: astore 16
    //   613: aload 15
    //   615: astore_0
    //   616: aload 16
    //   618: astore 15
    //   620: goto -111 -> 509
    //   623: iload_3
    //   624: iconst_1
    //   625: iadd
    //   626: istore_3
    //   627: goto -569 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	paramFile1	java.io.File
    //   0	630	1	paramFile2	java.io.File
    //   0	630	2	paramBoolean	boolean
    //   57	570	3	i	int
    //   97	23	4	j	int
    //   94	10	5	k	int
    //   11	394	6	bool1	boolean
    //   4	344	7	bool2	boolean
    //   7	22	8	bool3	boolean
    //   225	274	9	l1	long
    //   199	298	11	l2	long
    //   41	338	13	l3	long
    //   54	80	15	arrayOfFile	java.io.File[]
    //   144	26	15	localException1	java.lang.Exception
    //   254	301	15	localObject1	Object
    //   569	1	15	localException2	java.lang.Exception
    //   585	1	15	localObject2	Object
    //   594	1	15	localException3	java.lang.Exception
    //   600	19	15	localObject3	Object
    //   69	534	16	localFile1	java.io.File
    //   608	1	16	localException4	java.lang.Exception
    //   611	6	16	localFile2	java.io.File
    //   84	239	17	localObject4	Object
    //   232	102	18	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   43	56	144	java/lang/Exception
    //   58	65	144	java/lang/Exception
    //   71	86	144	java/lang/Exception
    //   91	96	144	java/lang/Exception
    //   106	115	144	java/lang/Exception
    //   124	130	144	java/lang/Exception
    //   133	141	144	java/lang/Exception
    //   415	420	144	java/lang/Exception
    //   420	447	144	java/lang/Exception
    //   451	456	144	java/lang/Exception
    //   456	491	144	java/lang/Exception
    //   17	23	409	finally
    //   38	43	409	finally
    //   43	56	409	finally
    //   58	65	409	finally
    //   71	86	409	finally
    //   91	96	409	finally
    //   106	115	409	finally
    //   124	130	409	finally
    //   133	141	409	finally
    //   146	183	409	finally
    //   186	210	409	finally
    //   227	234	409	finally
    //   268	272	409	finally
    //   277	282	409	finally
    //   282	347	409	finally
    //   353	403	409	finally
    //   415	420	409	finally
    //   420	447	409	finally
    //   451	456	409	finally
    //   456	491	409	finally
    //   514	519	409	finally
    //   523	527	409	finally
    //   545	549	409	finally
    //   554	559	409	finally
    //   559	561	409	finally
    //   234	243	503	java/lang/Exception
    //   523	527	530	java/lang/Exception
    //   234	243	534	finally
    //   268	272	561	java/lang/Exception
    //   277	282	565	java/lang/Exception
    //   514	519	569	java/lang/Exception
    //   545	549	574	java/lang/Exception
    //   554	559	578	java/lang/Exception
    //   243	256	582	finally
    //   256	264	590	finally
    //   243	256	594	java/lang/Exception
    //   256	264	608	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    int i;
    if (b.containsKey(paramString)) {
      i = ((Integer)b.get(paramString)).intValue();
    }
    while (i > 0) {
      if ((int)(System.currentTimeMillis() / 1000L) < i + 600)
      {
        return true;
        i = 0;
      }
      else
      {
        b.remove(paramString);
        return false;
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.indexOf('?') > -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  public DownloaderInterface a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: ifnull +178 -> 183
    //   8: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_1
    //   15: tableswitch	default:+21 -> 36, 1:+25->40, 2:+99->114
    //   37: monitorexit
    //   38: aload_2
    //   39: areturn
    //   40: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: iload_1
    //   44: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokevirtual 1135	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   50: ifeq +20 -> 70
    //   53: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: iload_1
    //   57: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokevirtual 1136	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 1143	com/tencent/mobileqq/vip/DownloaderInterface
    //   66: astore_2
    //   67: goto -31 -> 36
    //   70: new 1145	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   73: dup
    //   74: iconst_0
    //   75: invokespecial 1147	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   78: astore_2
    //   79: new 1149	akso
    //   82: dup
    //   83: invokestatic 1154	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   86: invokevirtual 1158	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   89: aload_2
    //   90: invokespecial 1161	akso:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   93: astore_2
    //   94: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: iload_1
    //   98: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: aload_2
    //   102: invokevirtual 932	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: goto -70 -> 36
    //   109: astore_2
    //   110: aload_3
    //   111: monitorexit
    //   112: aload_2
    //   113: athrow
    //   114: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   117: iload_1
    //   118: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: invokevirtual 1135	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   124: ifeq +20 -> 144
    //   127: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   130: iload_1
    //   131: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: invokevirtual 1136	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   137: checkcast 1143	com/tencent/mobileqq/vip/DownloaderInterface
    //   140: astore_2
    //   141: goto -105 -> 36
    //   144: new 1145	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   147: dup
    //   148: iconst_0
    //   149: invokespecial 1147	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   152: astore_2
    //   153: new 1149	akso
    //   156: dup
    //   157: invokestatic 1154	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   160: invokevirtual 1158	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   163: aload_2
    //   164: invokespecial 1161	akso:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   167: astore_2
    //   168: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   171: iload_1
    //   172: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aload_2
    //   176: invokevirtual 932	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: pop
    //   180: goto -144 -> 36
    //   183: aconst_null
    //   184: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	DownloaderFactory
    //   0	185	1	paramInt	int
    //   1	101	2	localObject1	Object
    //   109	4	2	localObject2	Object
    //   140	36	2	localObject3	Object
    //   11	100	3	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   36	38	109	finally
    //   40	67	109	finally
    //   70	106	109	finally
    //   110	112	109	finally
    //   114	141	109	finally
    //   144	180	109	finally
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloaderFactory", 2, "onDestroy...");
    }
    synchronized (b)
    {
      b.clear();
      synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (localIterator.hasNext()) {
          ((DownloaderInterface)((Map.Entry)localIterator.next()).getValue()).b();
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */