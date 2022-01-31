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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 4113, 4113, 4097, 4097, 256 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "/proc/net/tcp6", "/proc/net/udp6", "/proc/net/tcp", "/proc/net/udp", "/proc/net/unix" };
  private static String jdField_c_of_type_JavaLangString;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FDStatsInspector jdField_a_of_type_ComTencentMobileqqStatisticsFDStatsInspector = new FDStatsInspector();
  private String jdField_a_of_type_JavaLangString = "/proc/" + Process.myPid() + "/fd";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "ls -l " + this.jdField_a_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  
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
  private String a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: invokestatic 145	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   6: astore 6
    //   8: new 48	java/lang/StringBuilder
    //   11: dup
    //   12: ldc 147
    //   14: invokespecial 150	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: astore 12
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 152	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_Int	I
    //   24: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   27: lstore 4
    //   29: new 159	com/tencent/mobileqq/statistics/FDStatsTree
    //   32: dup
    //   33: invokespecial 160	com/tencent/mobileqq/statistics/FDStatsTree:<init>	()V
    //   36: astore 13
    //   38: aload 6
    //   40: aload_1
    //   41: invokevirtual 164	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   44: invokevirtual 170	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   47: astore_1
    //   48: new 172	java/io/BufferedReader
    //   51: dup
    //   52: new 174	java/io/InputStreamReader
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 177	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   60: invokespecial 180	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: astore 6
    //   65: aload 6
    //   67: astore 8
    //   69: aload_1
    //   70: astore 7
    //   72: aload 6
    //   74: invokevirtual 183	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: astore 11
    //   79: aload 11
    //   81: ifnull +301 -> 382
    //   84: aload 6
    //   86: astore 8
    //   88: aload_1
    //   89: astore 7
    //   91: aload 11
    //   93: ldc 185
    //   95: invokevirtual 188	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   98: istore_3
    //   99: aload 11
    //   101: astore 9
    //   103: iload_3
    //   104: ifle +25 -> 129
    //   107: aload 6
    //   109: astore 8
    //   111: aload_1
    //   112: astore 7
    //   114: aload 11
    //   116: iload_3
    //   117: iconst_2
    //   118: iadd
    //   119: aload 11
    //   121: invokevirtual 110	java/lang/String:length	()I
    //   124: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   127: astore 9
    //   129: aload 6
    //   131: astore 8
    //   133: aload_1
    //   134: astore 7
    //   136: aload 13
    //   138: aload 9
    //   140: invokevirtual 190	com/tencent/mobileqq/statistics/FDStatsTree:a	(Ljava/lang/String;)V
    //   143: aload 6
    //   145: astore 8
    //   147: aload_1
    //   148: astore 7
    //   150: aload 12
    //   152: new 48	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   159: aload 9
    //   161: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 192
    //   166: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 6
    //   178: astore 8
    //   180: aload_1
    //   181: astore 7
    //   183: aload_0
    //   184: aload_0
    //   185: getfield 152	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_Int	I
    //   188: iconst_1
    //   189: iadd
    //   190: putfield 152	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_Int	I
    //   193: goto -128 -> 65
    //   196: astore 9
    //   198: aload 6
    //   200: astore 8
    //   202: aload_1
    //   203: astore 7
    //   205: ldc 194
    //   207: iconst_2
    //   208: new 48	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   215: ldc 196
    //   217: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload 9
    //   222: invokevirtual 197	java/io/IOException:toString	()Ljava/lang/String;
    //   225: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload 6
    //   236: ifnull +8 -> 244
    //   239: aload 6
    //   241: invokevirtual 206	java/io/BufferedReader:close	()V
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 209	java/io/InputStream:close	()V
    //   252: aload 13
    //   254: aload_0
    //   255: getfield 81	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ComTencentMobileqqStatisticsFDStatsInspector	Lcom/tencent/mobileqq/statistics/FDStatsInspector;
    //   258: invokevirtual 212	com/tencent/mobileqq/statistics/FDStatsTree:a	(Lcom/tencent/mobileqq/statistics/FDStatsInspector;)V
    //   261: aload_0
    //   262: getfield 81	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ComTencentMobileqqStatisticsFDStatsInspector	Lcom/tencent/mobileqq/statistics/FDStatsInspector;
    //   265: invokevirtual 214	com/tencent/mobileqq/statistics/FDStatsInspector:a	()V
    //   268: getstatic 216	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   271: ifnonnull +30 -> 301
    //   274: new 48	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   281: invokestatic 222	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   284: invokevirtual 225	java/io/File:getPath	()Ljava/lang/String;
    //   287: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 227
    //   292: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: putstatic 216	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   301: aload 10
    //   303: astore_1
    //   304: iload_2
    //   305: ifeq +44 -> 349
    //   308: new 48	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   315: getstatic 216	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   318: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: lload 4
    //   323: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   326: ldc 101
    //   328: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: astore_1
    //   335: aload_0
    //   336: aload_1
    //   337: aload 12
    //   339: invokespecial 233	com/tencent/mobileqq/statistics/FDStats:a	(Ljava/lang/String;Ljava/lang/StringBuilder;)V
    //   342: aload_0
    //   343: lload 4
    //   345: iconst_1
    //   346: invokevirtual 236	com/tencent/mobileqq/statistics/FDStats:a	(JZ)V
    //   349: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +28 -> 380
    //   355: ldc 194
    //   357: iconst_2
    //   358: new 48	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   365: ldc 242
    //   367: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: iload_2
    //   371: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   374: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload_1
    //   381: areturn
    //   382: aload 6
    //   384: astore 8
    //   386: aload_1
    //   387: astore 7
    //   389: aload 12
    //   391: new 48	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   398: ldc 250
    //   400: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: getfield 252	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   407: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload 6
    //   419: astore 8
    //   421: aload_1
    //   422: astore 7
    //   424: aload 12
    //   426: new 48	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   433: ldc 254
    //   435: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc_w 256
    //   441: lload 4
    //   443: invokestatic 262	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;
    //   446: invokeinterface 265 1 0
    //   451: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 6
    //   463: astore 8
    //   465: aload_1
    //   466: astore 7
    //   468: aload 12
    //   470: ldc_w 267
    //   473: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 6
    //   479: astore 8
    //   481: aload_1
    //   482: astore 7
    //   484: aload 12
    //   486: new 48	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 269
    //   496: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokestatic 273	com/tencent/common/config/AppSetting:d	()Ljava/lang/String;
    //   502: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc 192
    //   507: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 6
    //   519: ifnull +8 -> 527
    //   522: aload 6
    //   524: invokevirtual 206	java/io/BufferedReader:close	()V
    //   527: aload_1
    //   528: ifnull -276 -> 252
    //   531: aload_1
    //   532: invokevirtual 209	java/io/InputStream:close	()V
    //   535: goto -283 -> 252
    //   538: astore_1
    //   539: goto -287 -> 252
    //   542: astore 6
    //   544: aconst_null
    //   545: astore 8
    //   547: aconst_null
    //   548: astore_1
    //   549: aload 8
    //   551: ifnull +8 -> 559
    //   554: aload 8
    //   556: invokevirtual 206	java/io/BufferedReader:close	()V
    //   559: aload_1
    //   560: ifnull +7 -> 567
    //   563: aload_1
    //   564: invokevirtual 209	java/io/InputStream:close	()V
    //   567: aload 6
    //   569: athrow
    //   570: astore 6
    //   572: goto -45 -> 527
    //   575: astore 6
    //   577: goto -333 -> 244
    //   580: astore_1
    //   581: goto -329 -> 252
    //   584: astore 7
    //   586: goto -27 -> 559
    //   589: astore_1
    //   590: goto -23 -> 567
    //   593: astore 6
    //   595: aconst_null
    //   596: astore 8
    //   598: goto -49 -> 549
    //   601: astore 6
    //   603: aload 7
    //   605: astore_1
    //   606: goto -57 -> 549
    //   609: astore 9
    //   611: aconst_null
    //   612: astore 6
    //   614: aconst_null
    //   615: astore_1
    //   616: goto -418 -> 198
    //   619: astore 9
    //   621: aconst_null
    //   622: astore 6
    //   624: goto -426 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	FDStats
    //   0	627	1	paramString	String
    //   0	627	2	paramBoolean	boolean
    //   98	21	3	i	int
    //   27	415	4	l	long
    //   6	517	6	localObject1	Object
    //   542	26	6	localObject2	Object
    //   570	1	6	localIOException1	java.io.IOException
    //   575	1	6	localIOException2	java.io.IOException
    //   593	1	6	localObject3	Object
    //   601	1	6	localObject4	Object
    //   612	11	6	localObject5	Object
    //   70	413	7	str1	String
    //   584	20	7	localIOException3	java.io.IOException
    //   67	530	8	localObject6	Object
    //   101	59	9	str2	String
    //   196	25	9	localIOException4	java.io.IOException
    //   609	1	9	localIOException5	java.io.IOException
    //   619	1	9	localIOException6	java.io.IOException
    //   1	301	10	localObject7	Object
    //   77	43	11	str3	String
    //   17	468	12	localStringBuilder	StringBuilder
    //   36	217	13	localFDStatsTree	FDStatsTree
    // Exception table:
    //   from	to	target	type
    //   72	79	196	java/io/IOException
    //   91	99	196	java/io/IOException
    //   114	129	196	java/io/IOException
    //   136	143	196	java/io/IOException
    //   150	176	196	java/io/IOException
    //   183	193	196	java/io/IOException
    //   389	417	196	java/io/IOException
    //   424	461	196	java/io/IOException
    //   468	477	196	java/io/IOException
    //   484	517	196	java/io/IOException
    //   531	535	538	java/io/IOException
    //   38	48	542	finally
    //   522	527	570	java/io/IOException
    //   239	244	575	java/io/IOException
    //   248	252	580	java/io/IOException
    //   554	559	584	java/io/IOException
    //   563	567	589	java/io/IOException
    //   48	65	593	finally
    //   72	79	601	finally
    //   91	99	601	finally
    //   114	129	601	finally
    //   136	143	601	finally
    //   150	176	601	finally
    //   183	193	601	finally
    //   205	234	601	finally
    //   389	417	601	finally
    //   424	461	601	finally
    //   468	477	601	finally
    //   484	517	601	finally
    //   38	48	609	java/io/IOException
    //   48	65	619	java/io/IOException
  }
  
  /* Error */
  private void a(String paramString, StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 86	java/io/File
    //   3: dup
    //   4: getstatic 216	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokespecial 276	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: new 86	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 276	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 6
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 4
    //   27: aload_3
    //   28: astore_1
    //   29: aload 5
    //   31: invokevirtual 279	java/io/File:exists	()Z
    //   34: ifne +11 -> 45
    //   37: aload_3
    //   38: astore_1
    //   39: aload 5
    //   41: invokevirtual 282	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: aload_3
    //   46: astore_1
    //   47: aload 6
    //   49: invokevirtual 279	java/io/File:exists	()Z
    //   52: ifne +11 -> 63
    //   55: aload_3
    //   56: astore_1
    //   57: aload 6
    //   59: invokevirtual 285	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: aload_3
    //   64: astore_1
    //   65: new 287	java/io/BufferedWriter
    //   68: dup
    //   69: new 289	java/io/FileWriter
    //   72: dup
    //   73: aload 6
    //   75: iconst_1
    //   76: invokespecial 292	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   79: sipush 8192
    //   82: invokespecial 295	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   85: astore_3
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 298	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokevirtual 301	java/io/BufferedWriter:flush	()V
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 302	java/io/BufferedWriter:close	()V
    //   106: return
    //   107: astore_3
    //   108: aload 4
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +14 -> 130
    //   119: aload_2
    //   120: astore_1
    //   121: ldc 194
    //   123: iconst_2
    //   124: ldc 147
    //   126: aload_3
    //   127: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_2
    //   131: ifnull -25 -> 106
    //   134: aload_2
    //   135: invokevirtual 302	java/io/BufferedWriter:close	()V
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
    //   151: invokevirtual 302	java/io/BufferedWriter:close	()V
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
  
  private String b(String paramString, boolean paramBoolean)
  {
    int i = 16;
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder;
    int k;
    try
    {
      paramString = paramString.split(":");
      if (paramString.length < 2) {
        return "";
      }
      if (paramString[0].length() < 8) {
        return "";
      }
      localStringBuilder = new StringBuilder();
      if (!paramBoolean) {
        break label197;
      }
    }
    catch (Exception paramString)
    {
      String str;
      if (!QLog.isColorLevel()) {
        break label154;
      }
      QLog.e("FDStats", 1, paramString.toString());
      label154:
      return "";
    }
    if (j < i)
    {
      str = Integer.valueOf(paramString[0].substring(k, k + 2), 16).toString();
      k += 2;
      localStringBuilder.append(str);
      if (j == i - 1) {
        localStringBuilder.append(":");
      } else {
        localStringBuilder.append(".");
      }
    }
    else
    {
      localStringBuilder.append(Integer.valueOf(paramString[1], 16).toString());
      paramString = localStringBuilder.toString();
      return paramString;
    }
    for (;;)
    {
      k = 0;
      break;
      j += 1;
      break;
      label197:
      i = 4;
    }
  }
  
  private void e()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    boolean bool;
    if ((localObject == null) || (((File)localObject).list() == null)) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("checkFDCount file:");
        if (localObject != null) {
          break label72;
        }
        bool = true;
        QLog.d("FDStats", 2, bool);
      }
    }
    label72:
    int m;
    do
    {
      return;
      bool = false;
      break;
      m = ((File)localObject).list().length;
      int k = 0;
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
      long l1 = ((SharedPreferences)localObject).getLong("key_last_dump", 0L);
      long l2 = System.currentTimeMillis();
      int i = 512;
      if (this.jdField_b_of_type_Int > 0) {
        i = Math.min(512, this.jdField_b_of_type_Int / 2);
      }
      int j = k;
      if (m > i)
      {
        j = k;
        if (Math.abs(l2 - l1) > (this.jdField_a_of_type_Int + 1) * jdField_a_of_type_Long)
        {
          j = k;
          if (this.jdField_a_of_type_Int < 5)
          {
            j = 1;
            this.jdField_a_of_type_Int += 1;
            a(this.jdField_b_of_type_JavaLangString, true);
            ((SharedPreferences)localObject).edit().putLong("key_last_dump", l2).commit();
          }
        }
      }
      if ((m > 900) && (j != 0)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1005);
      }
      if ((Math.abs(l2 - ((SharedPreferences)localObject).getLong("key_last_report", 0L)) > 43200000L) || (m >= 800)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
      }
    } while (!QLog.isColorLevel());
    QLog.d("FDStats", 2, "checkFDCount count:" + m);
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
  
  public void a()
  {
    int n = 0;
    int k = 0;
    int m = 0;
    for (;;)
    {
      Object localObject1;
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        localObject1 = a();
        i = n;
        j = k;
      }
      finally {}
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          j = k;
          Object localObject3 = ((String)localObject1).split(";");
          j = k;
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
          j = k;
          long l = ((SharedPreferences)localObject1).getLong("last_rand_timestamp", 0L);
          j = k;
          String str = ((SharedPreferences)localObject1).getString("rand_factor", "");
          localObject3 = localObject3[1];
          j = k;
          if (Math.abs(System.currentTimeMillis() - l) <= 43200000L)
          {
            i = n;
            j = k;
            if (str.equals(localObject3)) {}
          }
          else
          {
            j = k;
            QLog.d("FDStats", 2, "new random." + str + ", " + (String)localObject3);
            i = m;
            j = k;
            if (Math.random() < Float.valueOf((String)localObject3).floatValue()) {
              i = 1;
            }
            j = i;
            ((SharedPreferences)localObject1).edit().putLong("last_rand_timestamp", System.currentTimeMillis()).putString("rand_factor", (String)localObject3).commit();
          }
        }
      }
      catch (Exception localException)
      {
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FDStats", 2, localException.toString());
        i = j;
        continue;
      }
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 120000L);
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("FDStats", 2, "start");
        }
      }
    }
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
  
  /* Error */
  public void a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 145	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore 13
    //   5: aconst_null
    //   6: astore 11
    //   8: aconst_null
    //   9: astore 10
    //   11: new 48	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   18: astore 14
    //   20: new 48	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   27: astore 15
    //   29: invokestatic 61	android/os/Process:myPid	()I
    //   32: istore 8
    //   34: iconst_0
    //   35: istore 4
    //   37: iload 4
    //   39: getstatic 40	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   42: arraylength
    //   43: if_icmpge +577 -> 620
    //   46: getstatic 40	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   49: iload 4
    //   51: aaload
    //   52: astore 16
    //   54: aload 13
    //   56: new 48	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 508
    //   66: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 16
    //   71: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokevirtual 164	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   80: invokevirtual 170	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   83: astore 12
    //   85: aload 12
    //   87: astore 11
    //   89: new 172	java/io/BufferedReader
    //   92: dup
    //   93: new 174	java/io/InputStreamReader
    //   96: dup
    //   97: aload 11
    //   99: invokespecial 177	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   102: invokespecial 180	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   105: astore 12
    //   107: aload 14
    //   109: new 48	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 510
    //   119: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 16
    //   124: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc_w 512
    //   130: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 15
    //   142: new 48	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 510
    //   152: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 16
    //   157: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 512
    //   163: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 14
    //   175: new 48	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   182: aload 12
    //   184: invokevirtual 183	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   187: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 510
    //   193: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: getstatic 42	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ArrayOfInt	[I
    //   206: iload 4
    //   208: iaload
    //   209: iconst_1
    //   210: iand
    //   211: ifeq +522 -> 733
    //   214: iconst_1
    //   215: istore 5
    //   217: getstatic 42	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ArrayOfInt	[I
    //   220: iload 4
    //   222: iaload
    //   223: bipush 16
    //   225: iand
    //   226: ifeq +513 -> 739
    //   229: iconst_1
    //   230: istore 9
    //   232: getstatic 42	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ArrayOfInt	[I
    //   235: iload 4
    //   237: iaload
    //   238: sipush 256
    //   241: iand
    //   242: ifeq +503 -> 745
    //   245: iconst_1
    //   246: istore 6
    //   248: getstatic 42	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ArrayOfInt	[I
    //   251: iload 4
    //   253: iaload
    //   254: sipush 4096
    //   257: iand
    //   258: ifeq +493 -> 751
    //   261: iconst_1
    //   262: istore 7
    //   264: goto +451 -> 715
    //   267: aload 12
    //   269: invokevirtual 183	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   272: astore 10
    //   274: aload 10
    //   276: ifnull +444 -> 720
    //   279: aload 10
    //   281: ldc_w 514
    //   284: invokevirtual 317	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   287: astore 16
    //   289: iload 7
    //   291: ifeq +224 -> 515
    //   294: aload 16
    //   296: arraylength
    //   297: bipush 11
    //   299: if_icmple +216 -> 515
    //   302: ldc_w 516
    //   305: aload 16
    //   307: bipush 10
    //   309: aaload
    //   310: invokevirtual 462	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   313: ifeq +202 -> 515
    //   316: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq -52 -> 267
    //   322: ldc 194
    //   324: iconst_2
    //   325: new 48	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 518
    //   335: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 10
    //   340: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: goto -82 -> 267
    //   352: astore 13
    //   354: aload 12
    //   356: astore 10
    //   358: aload 13
    //   360: astore 12
    //   362: ldc 194
    //   364: iconst_2
    //   365: new 48	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 520
    //   375: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload 12
    //   380: invokevirtual 197	java/io/IOException:toString	()Ljava/lang/String;
    //   383: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: aload 10
    //   394: ifnull +8 -> 402
    //   397: aload 10
    //   399: invokevirtual 206	java/io/BufferedReader:close	()V
    //   402: aload 11
    //   404: ifnull +8 -> 412
    //   407: aload 11
    //   409: invokevirtual 209	java/io/InputStream:close	()V
    //   412: getstatic 216	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   415: ifnonnull +30 -> 445
    //   418: new 48	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   425: invokestatic 222	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   428: invokevirtual 225	java/io/File:getPath	()Ljava/lang/String;
    //   431: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc 227
    //   436: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: putstatic 216	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   445: aload 14
    //   447: ldc_w 522
    //   450: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 14
    //   456: aload 15
    //   458: invokevirtual 525	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 14
    //   464: ldc_w 527
    //   467: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: iload 8
    //   472: invokestatic 529	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   475: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: iload_3
    //   480: ifeq +34 -> 514
    //   483: aload_0
    //   484: new 48	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   491: getstatic 216	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   494: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: lload_1
    //   498: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   501: ldc 125
    //   503: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: aload 14
    //   511: invokespecial 233	com/tencent/mobileqq/statistics/FDStats:a	(Ljava/lang/String;Ljava/lang/StringBuilder;)V
    //   514: return
    //   515: aload 14
    //   517: aload 10
    //   519: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: ldc_w 510
    //   525: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload 16
    //   531: arraylength
    //   532: bipush 11
    //   534: if_icmple -267 -> 267
    //   537: iload 5
    //   539: ifeq -272 -> 267
    //   542: aload 15
    //   544: ldc_w 531
    //   547: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload_0
    //   551: aload 16
    //   553: iconst_3
    //   554: aaload
    //   555: iload 9
    //   557: invokespecial 533	com/tencent/mobileqq/statistics/FDStats:b	(Ljava/lang/String;Z)Ljava/lang/String;
    //   560: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: ldc_w 535
    //   566: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 16
    //   571: bipush 10
    //   573: aaload
    //   574: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc_w 510
    //   580: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: goto -317 -> 267
    //   587: astore 13
    //   589: aload 12
    //   591: astore 10
    //   593: aload 13
    //   595: astore 12
    //   597: aload 10
    //   599: ifnull +8 -> 607
    //   602: aload 10
    //   604: invokevirtual 206	java/io/BufferedReader:close	()V
    //   607: aload 11
    //   609: ifnull +8 -> 617
    //   612: aload 11
    //   614: invokevirtual 209	java/io/InputStream:close	()V
    //   617: aload 12
    //   619: athrow
    //   620: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +14 -> 637
    //   626: ldc 194
    //   628: iconst_2
    //   629: aload 15
    //   631: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: aload 10
    //   639: ifnull +8 -> 647
    //   642: aload 10
    //   644: invokevirtual 206	java/io/BufferedReader:close	()V
    //   647: aload 11
    //   649: ifnull -237 -> 412
    //   652: aload 11
    //   654: invokevirtual 209	java/io/InputStream:close	()V
    //   657: goto -245 -> 412
    //   660: astore 10
    //   662: goto -250 -> 412
    //   665: astore 10
    //   667: goto -20 -> 647
    //   670: astore 10
    //   672: goto -270 -> 402
    //   675: astore 10
    //   677: goto -265 -> 412
    //   680: astore 10
    //   682: goto -75 -> 607
    //   685: astore 10
    //   687: goto -70 -> 617
    //   690: astore 12
    //   692: goto -95 -> 597
    //   695: astore 12
    //   697: goto -100 -> 597
    //   700: astore 12
    //   702: goto -105 -> 597
    //   705: astore 12
    //   707: goto -345 -> 362
    //   710: astore 12
    //   712: goto -350 -> 362
    //   715: iload 6
    //   717: ifeq -450 -> 267
    //   720: iload 4
    //   722: iconst_1
    //   723: iadd
    //   724: istore 4
    //   726: aload 12
    //   728: astore 10
    //   730: goto -693 -> 37
    //   733: iconst_0
    //   734: istore 5
    //   736: goto -519 -> 217
    //   739: iconst_0
    //   740: istore 9
    //   742: goto -510 -> 232
    //   745: iconst_0
    //   746: istore 6
    //   748: goto -500 -> 248
    //   751: iconst_0
    //   752: istore 7
    //   754: goto -39 -> 715
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	757	0	this	FDStats
    //   0	757	1	paramLong	long
    //   0	757	3	paramBoolean	boolean
    //   35	690	4	i	int
    //   215	520	5	j	int
    //   246	501	6	k	int
    //   262	491	7	m	int
    //   32	439	8	n	int
    //   230	511	9	bool	boolean
    //   9	634	10	localObject1	Object
    //   660	1	10	localIOException1	java.io.IOException
    //   665	1	10	localIOException2	java.io.IOException
    //   670	1	10	localIOException3	java.io.IOException
    //   675	1	10	localIOException4	java.io.IOException
    //   680	1	10	localIOException5	java.io.IOException
    //   685	1	10	localIOException6	java.io.IOException
    //   728	1	10	localObject2	Object
    //   6	647	11	localObject3	Object
    //   83	535	12	localObject4	Object
    //   690	1	12	localObject5	Object
    //   695	1	12	localObject6	Object
    //   700	1	12	localObject7	Object
    //   705	1	12	localIOException7	java.io.IOException
    //   710	17	12	localIOException8	java.io.IOException
    //   3	52	13	localRuntime	java.lang.Runtime
    //   352	7	13	localIOException9	java.io.IOException
    //   587	7	13	localObject8	Object
    //   18	498	14	localStringBuilder1	StringBuilder
    //   27	603	15	localStringBuilder2	StringBuilder
    //   52	518	16	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   107	214	352	java/io/IOException
    //   217	229	352	java/io/IOException
    //   232	245	352	java/io/IOException
    //   248	261	352	java/io/IOException
    //   267	274	352	java/io/IOException
    //   279	289	352	java/io/IOException
    //   294	349	352	java/io/IOException
    //   515	537	352	java/io/IOException
    //   542	584	352	java/io/IOException
    //   107	214	587	finally
    //   217	229	587	finally
    //   232	245	587	finally
    //   248	261	587	finally
    //   267	274	587	finally
    //   279	289	587	finally
    //   294	349	587	finally
    //   515	537	587	finally
    //   542	584	587	finally
    //   652	657	660	java/io/IOException
    //   642	647	665	java/io/IOException
    //   397	402	670	java/io/IOException
    //   407	412	675	java/io/IOException
    //   602	607	680	java/io/IOException
    //   612	617	685	java/io/IOException
    //   37	85	690	finally
    //   620	637	690	finally
    //   89	107	695	finally
    //   362	392	700	finally
    //   37	85	705	java/io/IOException
    //   620	637	705	java/io/IOException
    //   89	107	710	java/io/IOException
  }
  
  public void a(String paramString)
  {
    try
    {
      d();
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
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 252	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: invokestatic 145	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: astore_1
    //   14: aload_1
    //   15: iconst_3
    //   16: anewarray 28	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 620
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc_w 622
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: ldc_w 624
    //   36: aastore
    //   37: invokevirtual 627	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   40: invokevirtual 170	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   43: astore_1
    //   44: new 172	java/io/BufferedReader
    //   47: dup
    //   48: new 174	java/io/InputStreamReader
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 177	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: sipush 7777
    //   59: invokespecial 630	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   62: astore_3
    //   63: aload_3
    //   64: invokevirtual 183	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull +102 -> 171
    //   72: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +29 -> 104
    //   78: ldc 194
    //   80: iconst_2
    //   81: new 48	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 632
    //   91: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload_0
    //   105: aload_2
    //   106: invokestatic 635	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: putfield 252	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   112: goto -49 -> 63
    //   115: astore 4
    //   117: aload_1
    //   118: astore_2
    //   119: aload_3
    //   120: astore_1
    //   121: aload 4
    //   123: astore_3
    //   124: ldc 194
    //   126: iconst_2
    //   127: new 48	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   134: ldc 196
    //   136: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_3
    //   140: invokevirtual 197	java/io/IOException:toString	()Ljava/lang/String;
    //   143: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 206	java/io/BufferedReader:close	()V
    //   160: aload_2
    //   161: ifnull -152 -> 9
    //   164: aload_2
    //   165: invokevirtual 209	java/io/InputStream:close	()V
    //   168: return
    //   169: astore_1
    //   170: return
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 206	java/io/BufferedReader:close	()V
    //   179: aload_1
    //   180: ifnull -171 -> 9
    //   183: aload_1
    //   184: invokevirtual 209	java/io/InputStream:close	()V
    //   187: return
    //   188: astore_1
    //   189: return
    //   190: astore_2
    //   191: aconst_null
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_1
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 206	java/io/BufferedReader:close	()V
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 209	java/io/InputStream:close	()V
    //   211: aload_2
    //   212: athrow
    //   213: astore_2
    //   214: goto -35 -> 179
    //   217: astore_1
    //   218: goto -58 -> 160
    //   221: astore_3
    //   222: goto -19 -> 203
    //   225: astore_1
    //   226: goto -15 -> 211
    //   229: astore_2
    //   230: aconst_null
    //   231: astore_3
    //   232: goto -37 -> 195
    //   235: astore_2
    //   236: goto -41 -> 195
    //   239: astore_3
    //   240: aload_2
    //   241: astore 4
    //   243: aload_3
    //   244: astore_2
    //   245: aload_1
    //   246: astore_3
    //   247: aload 4
    //   249: astore_1
    //   250: goto -55 -> 195
    //   253: astore_3
    //   254: aconst_null
    //   255: astore_1
    //   256: goto -132 -> 124
    //   259: astore_3
    //   260: aconst_null
    //   261: astore 4
    //   263: aload_1
    //   264: astore_2
    //   265: aload 4
    //   267: astore_1
    //   268: goto -144 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	FDStats
    //   13	144	1	localObject1	Object
    //   169	15	1	localIOException1	java.io.IOException
    //   188	1	1	localIOException2	java.io.IOException
    //   194	14	1	localObject2	Object
    //   217	1	1	localIOException3	java.io.IOException
    //   225	21	1	localIOException4	java.io.IOException
    //   249	19	1	localObject3	Object
    //   1	164	2	localObject4	Object
    //   190	22	2	localObject5	Object
    //   213	1	2	localIOException5	java.io.IOException
    //   229	1	2	localObject6	Object
    //   235	6	2	localObject7	Object
    //   244	21	2	localObject8	Object
    //   62	138	3	localObject9	Object
    //   221	1	3	localIOException6	java.io.IOException
    //   231	1	3	localObject10	Object
    //   239	5	3	localObject11	Object
    //   246	1	3	localIOException7	java.io.IOException
    //   253	1	3	localIOException8	java.io.IOException
    //   259	1	3	localIOException9	java.io.IOException
    //   115	7	4	localIOException10	java.io.IOException
    //   241	25	4	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   63	68	115	java/io/IOException
    //   72	104	115	java/io/IOException
    //   104	112	115	java/io/IOException
    //   164	168	169	java/io/IOException
    //   183	187	188	java/io/IOException
    //   14	44	190	finally
    //   175	179	213	java/io/IOException
    //   156	160	217	java/io/IOException
    //   199	203	221	java/io/IOException
    //   207	211	225	java/io/IOException
    //   44	63	229	finally
    //   63	68	235	finally
    //   72	104	235	finally
    //   104	112	235	finally
    //   124	152	239	finally
    //   14	44	253	java/io/IOException
    //   44	63	259	java/io/IOException
  }
  
  void c() {}
  
  public void d()
  {
    a(this.jdField_b_of_type_JavaLangString, true);
    a(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      b();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 120000L);
      continue;
      e();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 120000L);
      continue;
      a(false);
      continue;
      a(((Long)paramMessage.obj).longValue());
      continue;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStats
 * JD-Core Version:    0.7.0.1
 */