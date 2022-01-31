package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.debug.io.tools.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class FDStats
  implements Handler.Callback, StatisticCollector.StatisticCallback
{
  private static long jdField_a_of_type_Long = 1800000L;
  public static FDStats a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 4113, 4113, 4097, 4097 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "/proc/net/tcp6", "/proc/net/udp6", "/proc/net/tcp", "/proc/net/udp" };
  private static String jdField_c_of_type_JavaLangString;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private FDStatsInspector jdField_a_of_type_ComTencentMobileqqStatisticsFDStatsInspector = new FDStatsInspector();
  private String jdField_a_of_type_JavaLangString = "/proc/" + Process.myPid() + "/fd";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "ls -l " + this.jdField_a_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  static long a(File paramFile, boolean paramBoolean)
  {
    paramFile = paramFile.getName();
    try
    {
      paramFile = paramFile.substring(paramFile.lastIndexOf("/") + 1);
      if ((paramFile.endsWith(".txt")) || ((paramBoolean) && (paramFile.endsWith(".zip")))) {
        return Long.valueOf(paramFile.substring(0, paramFile.length() - 4)).longValue();
      }
      if (paramFile.endsWith(".socket"))
      {
        long l = Long.valueOf(paramFile.substring(0, paramFile.length() - 7)).longValue();
        return l;
      }
    }
    catch (Exception paramFile) {}
    return -1L;
  }
  
  public static FDStats a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsFDStats == null) {
      jdField_a_of_type_ComTencentMobileqqStatisticsFDStats = new FDStats();
    }
    if (StatisticCollector.a == null) {
      StatisticCollector.a = jdField_a_of_type_ComTencentMobileqqStatisticsFDStats;
    }
    return jdField_a_of_type_ComTencentMobileqqStatisticsFDStats;
  }
  
  /* Error */
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: invokestatic 158	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   6: astore 7
    //   8: new 46	java/lang/StringBuilder
    //   11: dup
    //   12: ldc 160
    //   14: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: astore 13
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 165	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   24: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   27: lstore 5
    //   29: new 172	com/tencent/mobileqq/statistics/FDStatsTree
    //   32: dup
    //   33: invokespecial 173	com/tencent/mobileqq/statistics/FDStatsTree:<init>	()V
    //   36: astore 14
    //   38: aload 7
    //   40: aload_1
    //   41: invokevirtual 177	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   44: invokevirtual 183	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   47: astore_1
    //   48: new 185	java/io/BufferedReader
    //   51: dup
    //   52: new 187	java/io/InputStreamReader
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 190	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   60: invokespecial 193	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: astore 9
    //   65: aload 9
    //   67: astore 8
    //   69: aload_1
    //   70: astore 7
    //   72: aload 9
    //   74: invokevirtual 196	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: astore 12
    //   79: aload 12
    //   81: ifnull +331 -> 412
    //   84: aload 9
    //   86: astore 8
    //   88: aload_1
    //   89: astore 7
    //   91: aload 12
    //   93: ldc 198
    //   95: invokevirtual 201	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   98: istore 4
    //   100: aload 12
    //   102: astore 10
    //   104: iload 4
    //   106: ifle +26 -> 132
    //   109: aload 9
    //   111: astore 8
    //   113: aload_1
    //   114: astore 7
    //   116: aload 12
    //   118: iload 4
    //   120: iconst_2
    //   121: iadd
    //   122: aload 12
    //   124: invokevirtual 121	java/lang/String:length	()I
    //   127: invokevirtual 124	java/lang/String:substring	(II)Ljava/lang/String;
    //   130: astore 10
    //   132: aload 9
    //   134: astore 8
    //   136: aload_1
    //   137: astore 7
    //   139: aload 14
    //   141: aload 10
    //   143: invokevirtual 203	com/tencent/mobileqq/statistics/FDStatsTree:a	(Ljava/lang/String;)V
    //   146: aload 9
    //   148: astore 8
    //   150: aload_1
    //   151: astore 7
    //   153: aload 13
    //   155: new 46	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   162: aload 10
    //   164: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 205
    //   169: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 9
    //   181: astore 8
    //   183: aload_1
    //   184: astore 7
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 165	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   191: iconst_1
    //   192: iadd
    //   193: putfield 165	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   196: iload_3
    //   197: ifeq -132 -> 65
    //   200: aload 9
    //   202: astore 8
    //   204: aload_1
    //   205: astore 7
    //   207: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -145 -> 65
    //   213: aload 9
    //   215: astore 8
    //   217: aload_1
    //   218: astore 7
    //   220: ldc 213
    //   222: iconst_2
    //   223: new 46	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   230: aload 10
    //   232: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc 205
    //   237: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: goto -181 -> 65
    //   249: astore 10
    //   251: aload 9
    //   253: astore 8
    //   255: aload_1
    //   256: astore 7
    //   258: ldc 213
    //   260: iconst_2
    //   261: new 46	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   268: ldc 219
    //   270: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 10
    //   275: invokevirtual 220	java/io/IOException:toString	()Ljava/lang/String;
    //   278: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 9
    //   289: ifnull +8 -> 297
    //   292: aload 9
    //   294: invokevirtual 226	java/io/BufferedReader:close	()V
    //   297: aload_1
    //   298: ifnull +7 -> 305
    //   301: aload_1
    //   302: invokevirtual 229	java/io/InputStream:close	()V
    //   305: getstatic 231	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   308: ifnonnull +30 -> 338
    //   311: new 46	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   318: invokestatic 237	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   321: invokevirtual 240	java/io/File:getPath	()Ljava/lang/String;
    //   324: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc 242
    //   329: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: putstatic 231	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   338: aload 11
    //   340: astore_1
    //   341: iload_2
    //   342: ifeq +37 -> 379
    //   345: new 46	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   352: getstatic 231	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   355: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: lload 5
    //   360: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   363: ldc 112
    //   365: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: astore_1
    //   372: aload_0
    //   373: aload_1
    //   374: aload 13
    //   376: invokespecial 248	com/tencent/mobileqq/statistics/FDStats:a	(Ljava/lang/String;Ljava/lang/StringBuilder;)V
    //   379: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +28 -> 410
    //   385: ldc 213
    //   387: iconst_2
    //   388: new 46	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   395: ldc 250
    //   397: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: iload_2
    //   401: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: aload_1
    //   411: areturn
    //   412: aload 9
    //   414: astore 8
    //   416: aload_1
    //   417: astore 7
    //   419: aload 13
    //   421: new 46	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   428: ldc 255
    //   430: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_0
    //   434: getfield 257	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_Int	I
    //   437: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 9
    //   449: astore 8
    //   451: aload_1
    //   452: astore 7
    //   454: aload 13
    //   456: new 46	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 259
    //   466: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc_w 261
    //   472: lload 5
    //   474: invokestatic 267	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;
    //   477: invokeinterface 270 1 0
    //   482: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 9
    //   494: astore 8
    //   496: aload_1
    //   497: astore 7
    //   499: aload 13
    //   501: ldc_w 272
    //   504: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 9
    //   510: astore 8
    //   512: aload_1
    //   513: astore 7
    //   515: aload 13
    //   517: new 46	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 274
    //   527: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokestatic 278	com/tencent/common/config/AppSetting:d	()Ljava/lang/String;
    //   533: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 9
    //   545: astore 8
    //   547: aload_1
    //   548: astore 7
    //   550: aload 13
    //   552: new 46	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 280
    //   562: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: iconst_2
    //   566: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: ldc 205
    //   571: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 9
    //   583: ifnull +8 -> 591
    //   586: aload 9
    //   588: invokevirtual 226	java/io/BufferedReader:close	()V
    //   591: aload_1
    //   592: ifnull -287 -> 305
    //   595: aload_1
    //   596: invokevirtual 229	java/io/InputStream:close	()V
    //   599: goto -294 -> 305
    //   602: astore_1
    //   603: goto -298 -> 305
    //   606: astore 10
    //   608: aconst_null
    //   609: astore 9
    //   611: aconst_null
    //   612: astore_1
    //   613: aload 9
    //   615: astore 8
    //   617: aload_1
    //   618: astore 7
    //   620: ldc 213
    //   622: iconst_2
    //   623: new 46	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   630: ldc_w 282
    //   633: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload 10
    //   638: invokevirtual 283	java/lang/NullPointerException:toString	()Ljava/lang/String;
    //   641: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: aload 9
    //   652: ifnull +8 -> 660
    //   655: aload 9
    //   657: invokevirtual 226	java/io/BufferedReader:close	()V
    //   660: aload_1
    //   661: ifnull -356 -> 305
    //   664: aload_1
    //   665: invokevirtual 229	java/io/InputStream:close	()V
    //   668: goto -363 -> 305
    //   671: astore_1
    //   672: goto -367 -> 305
    //   675: astore 9
    //   677: aconst_null
    //   678: astore 8
    //   680: aconst_null
    //   681: astore_1
    //   682: aload 8
    //   684: ifnull +8 -> 692
    //   687: aload 8
    //   689: invokevirtual 226	java/io/BufferedReader:close	()V
    //   692: aload_1
    //   693: ifnull +7 -> 700
    //   696: aload_1
    //   697: invokevirtual 229	java/io/InputStream:close	()V
    //   700: aload 9
    //   702: athrow
    //   703: astore 7
    //   705: goto -114 -> 591
    //   708: astore 7
    //   710: goto -413 -> 297
    //   713: astore_1
    //   714: goto -409 -> 305
    //   717: astore 7
    //   719: goto -59 -> 660
    //   722: astore 7
    //   724: goto -32 -> 692
    //   727: astore_1
    //   728: goto -28 -> 700
    //   731: astore 9
    //   733: aconst_null
    //   734: astore 8
    //   736: goto -54 -> 682
    //   739: astore 9
    //   741: aload 7
    //   743: astore_1
    //   744: goto -62 -> 682
    //   747: astore 10
    //   749: aconst_null
    //   750: astore 9
    //   752: goto -139 -> 613
    //   755: astore 10
    //   757: goto -144 -> 613
    //   760: astore 10
    //   762: aconst_null
    //   763: astore 9
    //   765: aconst_null
    //   766: astore_1
    //   767: goto -516 -> 251
    //   770: astore 10
    //   772: aconst_null
    //   773: astore 9
    //   775: goto -524 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	778	0	this	FDStats
    //   0	778	1	paramString	String
    //   0	778	2	paramBoolean1	boolean
    //   0	778	3	paramBoolean2	boolean
    //   98	24	4	i	int
    //   27	446	5	l	long
    //   6	613	7	localObject1	Object
    //   703	1	7	localIOException1	java.io.IOException
    //   708	1	7	localIOException2	java.io.IOException
    //   717	1	7	localIOException3	java.io.IOException
    //   722	20	7	localIOException4	java.io.IOException
    //   67	668	8	localBufferedReader1	java.io.BufferedReader
    //   63	593	9	localBufferedReader2	java.io.BufferedReader
    //   675	26	9	localObject2	Object
    //   731	1	9	localObject3	Object
    //   739	1	9	localObject4	Object
    //   750	24	9	localObject5	Object
    //   102	129	10	str1	String
    //   249	25	10	localIOException5	java.io.IOException
    //   606	31	10	localNullPointerException1	NullPointerException
    //   747	1	10	localNullPointerException2	NullPointerException
    //   755	1	10	localNullPointerException3	NullPointerException
    //   760	1	10	localIOException6	java.io.IOException
    //   770	1	10	localIOException7	java.io.IOException
    //   1	338	11	localObject6	Object
    //   77	46	12	str2	String
    //   17	534	13	localStringBuilder	StringBuilder
    //   36	104	14	localFDStatsTree	FDStatsTree
    // Exception table:
    //   from	to	target	type
    //   72	79	249	java/io/IOException
    //   91	100	249	java/io/IOException
    //   116	132	249	java/io/IOException
    //   139	146	249	java/io/IOException
    //   153	179	249	java/io/IOException
    //   186	196	249	java/io/IOException
    //   207	213	249	java/io/IOException
    //   220	246	249	java/io/IOException
    //   419	447	249	java/io/IOException
    //   454	492	249	java/io/IOException
    //   499	508	249	java/io/IOException
    //   515	543	249	java/io/IOException
    //   550	581	249	java/io/IOException
    //   595	599	602	java/io/IOException
    //   38	48	606	java/lang/NullPointerException
    //   664	668	671	java/io/IOException
    //   38	48	675	finally
    //   586	591	703	java/io/IOException
    //   292	297	708	java/io/IOException
    //   301	305	713	java/io/IOException
    //   655	660	717	java/io/IOException
    //   687	692	722	java/io/IOException
    //   696	700	727	java/io/IOException
    //   48	65	731	finally
    //   72	79	739	finally
    //   91	100	739	finally
    //   116	132	739	finally
    //   139	146	739	finally
    //   153	179	739	finally
    //   186	196	739	finally
    //   207	213	739	finally
    //   220	246	739	finally
    //   258	287	739	finally
    //   419	447	739	finally
    //   454	492	739	finally
    //   499	508	739	finally
    //   515	543	739	finally
    //   550	581	739	finally
    //   620	650	739	finally
    //   48	65	747	java/lang/NullPointerException
    //   72	79	755	java/lang/NullPointerException
    //   91	100	755	java/lang/NullPointerException
    //   116	132	755	java/lang/NullPointerException
    //   139	146	755	java/lang/NullPointerException
    //   153	179	755	java/lang/NullPointerException
    //   186	196	755	java/lang/NullPointerException
    //   207	213	755	java/lang/NullPointerException
    //   220	246	755	java/lang/NullPointerException
    //   419	447	755	java/lang/NullPointerException
    //   454	492	755	java/lang/NullPointerException
    //   499	508	755	java/lang/NullPointerException
    //   515	543	755	java/lang/NullPointerException
    //   550	581	755	java/lang/NullPointerException
    //   38	48	760	java/io/IOException
    //   48	65	770	java/io/IOException
  }
  
  /* Error */
  private void a(String paramString, StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 97	java/io/File
    //   3: dup
    //   4: getstatic 231	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokespecial 286	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: new 97	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 286	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 6
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 4
    //   27: aload_3
    //   28: astore_1
    //   29: aload 5
    //   31: invokevirtual 289	java/io/File:exists	()Z
    //   34: ifne +11 -> 45
    //   37: aload_3
    //   38: astore_1
    //   39: aload 5
    //   41: invokevirtual 292	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: aload_3
    //   46: astore_1
    //   47: aload 6
    //   49: invokevirtual 289	java/io/File:exists	()Z
    //   52: ifne +11 -> 63
    //   55: aload_3
    //   56: astore_1
    //   57: aload 6
    //   59: invokevirtual 295	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: aload_3
    //   64: astore_1
    //   65: new 297	java/io/BufferedWriter
    //   68: dup
    //   69: new 299	java/io/FileWriter
    //   72: dup
    //   73: aload 6
    //   75: iconst_1
    //   76: invokespecial 302	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   79: sipush 8192
    //   82: invokespecial 305	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   85: astore_3
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 308	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokevirtual 311	java/io/BufferedWriter:flush	()V
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 312	java/io/BufferedWriter:close	()V
    //   106: return
    //   107: astore_3
    //   108: aload 4
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +14 -> 130
    //   119: aload_2
    //   120: astore_1
    //   121: ldc 213
    //   123: iconst_2
    //   124: ldc 160
    //   126: aload_3
    //   127: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_2
    //   131: ifnull -25 -> 106
    //   134: aload_2
    //   135: invokevirtual 312	java/io/BufferedWriter:close	()V
    //   138: return
    //   139: astore_1
    //   140: return
    //   141: astore_3
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: astore_1
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 312	java/io/BufferedWriter:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: return
    //   158: astore_2
    //   159: goto -5 -> 154
    //   162: astore_1
    //   163: aload_3
    //   164: astore_2
    //   165: goto -19 -> 146
    //   168: astore_1
    //   169: aload_3
    //   170: astore_2
    //   171: aload_1
    //   172: astore_3
    //   173: goto -62 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	FDStats
    //   0	176	1	paramString	String
    //   0	176	2	paramStringBuilder	StringBuilder
    //   23	80	3	localBufferedWriter	java.io.BufferedWriter
    //   107	20	3	localThrowable	Throwable
    //   141	29	3	localObject1	Object
    //   172	1	3	str	String
    //   25	84	4	localObject2	Object
    //   10	30	5	localFile1	File
    //   20	54	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   29	37	107	java/lang/Throwable
    //   39	45	107	java/lang/Throwable
    //   47	55	107	java/lang/Throwable
    //   57	63	107	java/lang/Throwable
    //   65	86	107	java/lang/Throwable
    //   134	138	139	java/io/IOException
    //   29	37	141	finally
    //   39	45	141	finally
    //   47	55	141	finally
    //   57	63	141	finally
    //   65	86	141	finally
    //   113	119	141	finally
    //   121	130	141	finally
    //   102	106	156	java/io/IOException
    //   150	154	158	java/io/IOException
    //   86	98	162	finally
    //   86	98	168	java/lang/Throwable
  }
  
  private void f()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    boolean bool;
    if ((localObject == null) || (((File)localObject).list() == null)) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("checkFDCount file:");
        if (localObject != null) {
          break label77;
        }
        bool = true;
        QLog.d("FDStats", 2, bool);
      }
    }
    for (;;)
    {
      return;
      label77:
      bool = false;
      break;
      int i = 0;
      try
      {
        j = ((File)localObject).list().length;
        if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
          continue;
        }
        m = 0;
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
        l2 = System.currentTimeMillis();
        k = 512;
        if (this.jdField_a_of_type_Int > 0) {
          k = Math.min(512, this.jdField_a_of_type_Int / 2);
        }
        l3 = ((SharedPreferences)localObject).getLong("key_last_report", 0L);
        long l4 = ((SharedPreferences)localObject).getLong("key_last_threadhold_report", 0L);
        if (j >= 600)
        {
          i = ((SharedPreferences)localObject).getInt("key_last_threadhold_size", 0);
          if (QLog.isColorLevel()) {
            QLog.d("FDStats", 2, "lastReportTime:" + l3 + " lastThreadHoldTime:" + l4 + " lastSize:" + i);
          }
          if ((Math.abs(l2 - l4) <= 86400000L) && (j - i < 100)) {
            break label553;
          }
          k = 1;
          a(this.jdField_b_of_type_JavaLangString, true, false);
          a(true);
          ((SharedPreferences)localObject).edit().putLong("key_last_threadhold_report", l2).commit();
          ((SharedPreferences)localObject).edit().putInt("key_last_threadhold_size", j).commit();
          i = k;
          if (this.jdField_a_of_type_AndroidOsHandler != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).obj = Long.valueOf(l3);
            ((Message)localObject).what = 1004;
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 500L);
            i = k;
          }
          if ((j > 900) && (i != 0) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1005);
          }
          l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FDStats", 2, "checkFDCount count:" + j + " time:" + (l2 - l1));
          return;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          int m;
          long l2;
          int k;
          long l3;
          int j = i;
          if (QLog.isColorLevel())
          {
            QLog.e("FDStats", 2, localNullPointerException.toString());
            j = i;
            continue;
            i = m;
            if (Math.abs(l2 - l3) > 43200000L)
            {
              i = m;
              if (j > k)
              {
                k = 1;
                a(this.jdField_b_of_type_JavaLangString, true, false);
                i = k;
                if (this.jdField_a_of_type_AndroidOsHandler != null)
                {
                  this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
                  i = k;
                  continue;
                  label553:
                  i = 0;
                }
              }
            }
          }
        }
      }
    }
  }
  
  File a(long paramLong1, long paramLong2)
  {
    Object localObject2;
    if (jdField_c_of_type_JavaLangString == null)
    {
      localObject2 = null;
      return localObject2;
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        Object localObject1;
        try
        {
          localObject1 = new ArrayList();
          localObject2 = new File(jdField_c_of_type_JavaLangString);
          if (!((File)localObject2).exists()) {
            return null;
          }
          localObject2 = ((File)localObject2).listFiles();
          int j = localObject2.length;
          i = 0;
          if (i < j)
          {
            File localFile = localObject2[i];
            long l = a(localFile, false);
            if ((l == -1L) || (l >= paramLong2) || (l <= paramLong1)) {
              break label239;
            }
            ((List)localObject1).add(localFile.getAbsolutePath());
            break label239;
          }
          if (((List)localObject1).size() > 0)
          {
            localObject2 = jdField_c_of_type_JavaLangString + paramLong2 + ".zip";
            if (FileUtil.zipFiles((List)localObject1, (String)localObject2)) {
              localObject1 = new File((String)localObject2);
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          boolean bool;
          localObject1 = null;
          localObject2 = localObject1;
        }
        try
        {
          bool = ((File)localObject1).exists();
          localObject2 = localObject1;
          if (bool) {
            break;
          }
          return null;
        }
        catch (Throwable localThrowable2) {}
      }
      QLog.e("FDStats", 2, "zip fail");
      return null;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FDStats", 2, "", localThrowable1);
      return localObject1;
      label239:
      i += 1;
    }
  }
  
  final String a()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.batteryCfg.name());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("#")))
    {
      localObject = ((String)localObject).split("#");
      if (localObject.length > 2) {
        return localObject[2];
      }
      return "";
    }
    return "";
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 490	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_Boolean	Z
    //   8: ifne +112 -> 120
    //   11: aload_0
    //   12: invokevirtual 492	com/tencent/mobileqq/statistics/FDStats:a	()Ljava/lang/String;
    //   15: astore 4
    //   17: aload 4
    //   19: invokestatic 479	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +236 -> 258
    //   25: aload 4
    //   27: ldc_w 494
    //   30: invokevirtual 488	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore 4
    //   35: invokestatic 332	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   38: ldc_w 334
    //   41: iconst_0
    //   42: invokevirtual 338	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   45: astore 5
    //   47: aload 5
    //   49: ldc_w 496
    //   52: lconst_0
    //   53: invokeinterface 352 4 0
    //   58: lstore_2
    //   59: aload 5
    //   61: ldc_w 498
    //   64: ldc 160
    //   66: invokeinterface 502 3 0
    //   71: astore 6
    //   73: aload 4
    //   75: iconst_1
    //   76: aaload
    //   77: astore 7
    //   79: ldc_w 504
    //   82: aload 4
    //   84: iconst_1
    //   85: aaload
    //   86: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifeq +51 -> 140
    //   92: aload_0
    //   93: iconst_0
    //   94: putfield 324	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Boolean	Z
    //   97: aload_0
    //   98: iconst_1
    //   99: putfield 326	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_Boolean	Z
    //   102: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +12 -> 117
    //   108: ldc 213
    //   110: iconst_2
    //   111: ldc_w 509
    //   114: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_0
    //   118: monitorexit
    //   119: return
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 324	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Boolean	Z
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 326	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_Boolean	Z
    //   130: goto -13 -> 117
    //   133: astore 4
    //   135: aload_0
    //   136: monitorexit
    //   137: aload 4
    //   139: athrow
    //   140: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   143: lload_2
    //   144: lsub
    //   145: invokestatic 370	java/lang/Math:abs	(J)J
    //   148: ldc2_w 425
    //   151: lcmp
    //   152: ifgt +13 -> 165
    //   155: aload 6
    //   157: aload 7
    //   159: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifne +96 -> 258
    //   165: ldc 213
    //   167: iconst_2
    //   168: new 46	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 511
    //   178: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 6
    //   183: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 513
    //   189: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 7
    //   194: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: invokestatic 517	java/lang/Math:random	()D
    //   206: aload 7
    //   208: invokestatic 522	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   211: invokevirtual 526	java/lang/Float:floatValue	()F
    //   214: f2d
    //   215: dcmpg
    //   216: ifge +108 -> 324
    //   219: aload_0
    //   220: iload_1
    //   221: putfield 324	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Boolean	Z
    //   224: aload 5
    //   226: invokeinterface 381 1 0
    //   231: ldc_w 496
    //   234: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   237: invokeinterface 387 4 0
    //   242: ldc_w 498
    //   245: aload 7
    //   247: invokeinterface 530 3 0
    //   252: invokeinterface 390 1 0
    //   257: pop
    //   258: aload_0
    //   259: getfield 324	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Boolean	Z
    //   262: ifeq -145 -> 117
    //   265: aload_0
    //   266: getfield 92	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   269: sipush 1000
    //   272: ldc2_w 531
    //   275: invokevirtual 536	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   278: pop
    //   279: aload_0
    //   280: iconst_1
    //   281: putfield 490	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_Boolean	Z
    //   284: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq -170 -> 117
    //   290: ldc 213
    //   292: iconst_2
    //   293: ldc_w 538
    //   296: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: goto -182 -> 117
    //   302: astore 4
    //   304: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq -49 -> 258
    //   310: ldc 213
    //   312: iconst_2
    //   313: aload 4
    //   315: invokevirtual 539	java/lang/Exception:toString	()Ljava/lang/String;
    //   318: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: goto -63 -> 258
    //   324: iconst_0
    //   325: istore_1
    //   326: goto -107 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	FDStats
    //   1	325	1	bool	boolean
    //   58	86	2	l	long
    //   15	68	4	localObject1	Object
    //   133	5	4	localObject2	Object
    //   302	12	4	localException	Exception
    //   45	180	5	localSharedPreferences	SharedPreferences
    //   71	111	6	str	String
    //   77	169	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	17	133	finally
    //   17	73	133	finally
    //   79	117	133	finally
    //   120	130	133	finally
    //   140	165	133	finally
    //   165	219	133	finally
    //   219	258	133	finally
    //   258	299	133	finally
    //   304	321	133	finally
    //   17	73	302	java/lang/Exception
    //   79	117	302	java/lang/Exception
    //   140	165	302	java/lang/Exception
    //   165	219	302	java/lang/Exception
    //   219	258	302	java/lang/Exception
  }
  
  void a(long paramLong)
  {
    if (jdField_c_of_type_JavaLangString == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new File(jdField_c_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          localObject = ((File)localObject).listFiles();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            File localFile = localObject[i];
            long l = a(localFile, true);
            if ((l != -1L) && (l < paramLong)) {
              localFile.delete();
            }
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FDStats", 2, "", localThrowable);
        }
      }
    }
    QLog.d("FDStats", 2, "cleanStorage " + paramLong);
  }
  
  public void a(String paramString)
  {
    try
    {
      e();
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("FDStats", 1, "analyseCurFD on crash error", paramString);
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    long l2 = ((SharedPreferences)localObject1).getLong("key_last_report", 0L);
    long l1 = System.currentTimeMillis();
    Object localObject2;
    if ((Math.abs(l1 - l2) > 43200000L) || (paramBoolean))
    {
      localObject2 = a(l2, l1);
      if (localObject2 == null) {
        break label329;
      }
      ((SharedPreferences)localObject1).edit().putLong("key_last_report", l1).commit();
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("fileObj1", ((File)localObject2).getAbsolutePath());
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("p_id", MagnifierSDK.a());
        ((JSONObject)localObject2).put("plugin", String.valueOf(137));
        ((JSONObject)localObject1).put("fileObj", localJSONObject);
        ((JSONObject)localObject1).put("clientinfo", localObject2);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("FDStats", 2, "report fail.", localThrowable);
        continue;
      }
      try
      {
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
        if (localObject2 == null) {
          break label369;
        }
        l1 = Long.parseLong(((QQAppInterface)localObject2).c());
      }
      catch (Exception localException)
      {
        QLog.e("FDStats", 2, "reportFileToAPM get uin " + 0L);
        l1 = 0L;
        continue;
      }
      ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject1, true, true, l1));
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, "reportFileToAPM");
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).obj = Long.valueOf(l2);
        ((Message)localObject1).what = 1004;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 500L);
      }
      return;
      label329:
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, "no file to report");
      }
      localThrowable.edit().putLong("key_last_report", l1).commit();
      continue;
      label369:
      l1 = 0L;
    }
  }
  
  public void b()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
  }
  
  /* Error */
  void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 257	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_Int	I
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: invokestatic 158	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: astore_1
    //   14: aload_1
    //   15: iconst_3
    //   16: anewarray 28	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 609
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc_w 611
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: ldc_w 613
    //   36: aastore
    //   37: invokevirtual 616	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +125 -> 167
    //   45: aload_1
    //   46: invokevirtual 183	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   49: astore_1
    //   50: new 185	java/io/BufferedReader
    //   53: dup
    //   54: new 187	java/io/InputStreamReader
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 190	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   62: sipush 7777
    //   65: invokespecial 619	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   68: astore_3
    //   69: aload_3
    //   70: invokevirtual 196	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 5
    //   75: aload_3
    //   76: astore 4
    //   78: aload_1
    //   79: astore_2
    //   80: aload 5
    //   82: ifnull +90 -> 172
    //   85: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +30 -> 118
    //   91: ldc 213
    //   93: iconst_2
    //   94: new 46	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 621
    //   104: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 5
    //   109: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_0
    //   119: aload 5
    //   121: invokestatic 626	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: putfield 257	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_Int	I
    //   127: goto -58 -> 69
    //   130: astore 4
    //   132: aload_1
    //   133: astore_2
    //   134: aload_3
    //   135: astore_1
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 213
    //   141: iconst_1
    //   142: ldc 219
    //   144: aload_3
    //   145: invokestatic 551	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 226	java/io/BufferedReader:close	()V
    //   156: aload_2
    //   157: ifnull -148 -> 9
    //   160: aload_2
    //   161: invokevirtual 229	java/io/InputStream:close	()V
    //   164: return
    //   165: astore_1
    //   166: return
    //   167: aconst_null
    //   168: astore 4
    //   170: aconst_null
    //   171: astore_2
    //   172: aload 4
    //   174: ifnull +8 -> 182
    //   177: aload 4
    //   179: invokevirtual 226	java/io/BufferedReader:close	()V
    //   182: aload_2
    //   183: ifnull -174 -> 9
    //   186: aload_2
    //   187: invokevirtual 229	java/io/InputStream:close	()V
    //   190: return
    //   191: astore_1
    //   192: return
    //   193: astore_2
    //   194: aconst_null
    //   195: astore_3
    //   196: aconst_null
    //   197: astore_1
    //   198: aload_3
    //   199: ifnull +7 -> 206
    //   202: aload_3
    //   203: invokevirtual 226	java/io/BufferedReader:close	()V
    //   206: aload_1
    //   207: ifnull +7 -> 214
    //   210: aload_1
    //   211: invokevirtual 229	java/io/InputStream:close	()V
    //   214: aload_2
    //   215: athrow
    //   216: astore_1
    //   217: goto -35 -> 182
    //   220: astore_1
    //   221: goto -65 -> 156
    //   224: astore_3
    //   225: goto -19 -> 206
    //   228: astore_1
    //   229: goto -15 -> 214
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_3
    //   235: goto -37 -> 198
    //   238: astore_2
    //   239: goto -41 -> 198
    //   242: astore_3
    //   243: aload_2
    //   244: astore 4
    //   246: aload_3
    //   247: astore_2
    //   248: aload_1
    //   249: astore_3
    //   250: aload 4
    //   252: astore_1
    //   253: goto -55 -> 198
    //   256: astore_3
    //   257: aconst_null
    //   258: astore_1
    //   259: goto -120 -> 139
    //   262: astore_3
    //   263: aconst_null
    //   264: astore 4
    //   266: aload_1
    //   267: astore_2
    //   268: aload 4
    //   270: astore_1
    //   271: goto -132 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	FDStats
    //   13	140	1	localObject1	Object
    //   165	1	1	localIOException1	java.io.IOException
    //   191	1	1	localIOException2	java.io.IOException
    //   197	14	1	localObject2	Object
    //   216	1	1	localIOException3	java.io.IOException
    //   220	1	1	localIOException4	java.io.IOException
    //   228	21	1	localIOException5	java.io.IOException
    //   252	19	1	localObject3	Object
    //   1	186	2	localObject4	Object
    //   193	22	2	localObject5	Object
    //   232	1	2	localObject6	Object
    //   238	6	2	localObject7	Object
    //   247	21	2	localObject8	Object
    //   68	135	3	localObject9	Object
    //   224	1	3	localIOException6	java.io.IOException
    //   234	1	3	localObject10	Object
    //   242	5	3	localObject11	Object
    //   249	1	3	localIOException7	java.io.IOException
    //   256	1	3	localThrowable1	Throwable
    //   262	1	3	localThrowable2	Throwable
    //   76	1	4	localObject12	Object
    //   130	7	4	localThrowable3	Throwable
    //   168	101	4	localObject13	Object
    //   73	47	5	str	String
    // Exception table:
    //   from	to	target	type
    //   69	75	130	java/lang/Throwable
    //   85	118	130	java/lang/Throwable
    //   118	127	130	java/lang/Throwable
    //   160	164	165	java/io/IOException
    //   186	190	191	java/io/IOException
    //   14	41	193	finally
    //   45	50	193	finally
    //   177	182	216	java/io/IOException
    //   152	156	220	java/io/IOException
    //   202	206	224	java/io/IOException
    //   210	214	228	java/io/IOException
    //   50	69	232	finally
    //   69	75	238	finally
    //   85	118	238	finally
    //   118	127	238	finally
    //   139	148	242	finally
    //   14	41	256	java/lang/Throwable
    //   45	50	256	java/lang/Throwable
    //   50	69	262	java/lang/Throwable
  }
  
  void d() {}
  
  public void e()
  {
    a(this.jdField_b_of_type_JavaLangString, false, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      c();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 120000L);
      continue;
      f();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 120000L);
      continue;
      a(false);
      continue;
      a(((Long)paramMessage.obj).longValue());
      continue;
      d();
      continue;
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStats
 * JD-Core Version:    0.7.0.1
 */