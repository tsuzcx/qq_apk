package com.tencent.qqmini.sdk.monitor.common;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProcessStats
{
  private static final int COUNT_SPLIT = 17;
  public static final String ID_APP = "-1";
  public static final String ID_DEV = "-2";
  public static final long INVALID_VALUE = -1L;
  private static final int PERCENT_RATIO = 100;
  private static final String TAG = "ProcessStats";
  private static long baseTotalCpu = 0L;
  private static long baseTotalIdle;
  public static ProcessStats.Stats sAppSt;
  public static int sCpuCoreNum;
  public static long sLastUpdateTime;
  private static final RecyclablePool sPool = new RecyclablePool(ProcessStats.Stats.class, 30);
  private static Map<String, ProcessStats.Stats> sThreadUsageMap;
  public static int sTotalCpuUsage;
  static int[] sWhiteIndexs;
  static int[] sWordIndexs;
  private static int threadUsageUpdateTimes;
  
  static
  {
    sLastUpdateTime = 0L;
    sTotalCpuUsage = 0;
    sAppSt = obtainStats();
    sCpuCoreNum = -1;
    sWordIndexs = new int[17];
    sWhiteIndexs = new int[17];
    sThreadUsageMap = new HashMap(30);
    threadUsageUpdateTimes = 0;
    baseTotalIdle = 0L;
  }
  
  public static long collectCpuUsage(String paramString)
  {
    paramString = collectProcessStats(paramString);
    if (paramString == null) {
      return -1L;
    }
    return ((Long)paramString[1]).longValue() + ((Long)paramString[2]).longValue();
  }
  
  private static void collectProcessStats(String paramString, ProcessStats.Stats paramStats, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = collectProcessStats(paramString);
        paramString = null;
        if (arrayOfObject != null)
        {
          paramString = (String)arrayOfObject[0];
          l1 = ((Long)arrayOfObject[1]).longValue();
          l2 = ((Long)arrayOfObject[2]).longValue();
          if (paramBoolean)
          {
            paramStats.baseUtime = l1;
            paramStats.baseStime = l2;
            paramStats.name = paramString;
            return;
          }
          if (paramStats.baseUtime == -100L)
          {
            paramStats.relUtime = -100L;
            paramStats.relStime = -100L;
            return;
          }
          paramStats.relUtime = (l1 - paramStats.baseUtime);
          paramStats.relStime = (l2 - paramStats.baseStime);
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      long l1 = -100L;
      long l2 = l1;
    }
  }
  
  /* Error */
  public static Object[] collectProcessStats(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 121	com/tencent/qqmini/sdk/monitor/common/ProcessStats:getReader	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   4: astore 21
    //   6: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   9: sipush 1024
    //   12: invokevirtual 131	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getBuf	(I)[B
    //   15: astore 22
    //   17: aload 21
    //   19: lconst_0
    //   20: invokevirtual 137	java/io/RandomAccessFile:seek	(J)V
    //   23: aload 21
    //   25: aload 22
    //   27: invokevirtual 141	java/io/RandomAccessFile:read	([B)I
    //   30: istore 4
    //   32: iconst_0
    //   33: istore_1
    //   34: iconst_0
    //   35: istore_3
    //   36: goto +625 -> 661
    //   39: iload_2
    //   40: istore_1
    //   41: iload_2
    //   42: iload 4
    //   44: if_icmpge +653 -> 697
    //   47: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   50: iload_3
    //   51: iload_2
    //   52: iastore
    //   53: iload_2
    //   54: istore_1
    //   55: goto +642 -> 697
    //   58: iload_1
    //   59: iload 4
    //   61: if_icmpge +658 -> 719
    //   64: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   67: iload_3
    //   68: iload_1
    //   69: iastore
    //   70: goto +649 -> 719
    //   73: iload_3
    //   74: bipush 17
    //   76: if_icmpne +530 -> 606
    //   79: ldc 14
    //   81: aload_0
    //   82: invokevirtual 145	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifne +213 -> 298
    //   88: new 100	java/lang/String
    //   91: dup
    //   92: aload 22
    //   94: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   97: iconst_1
    //   98: iaload
    //   99: iconst_1
    //   100: iadd
    //   101: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   104: iconst_1
    //   105: iaload
    //   106: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   109: iconst_1
    //   110: iaload
    //   111: isub
    //   112: iconst_1
    //   113: isub
    //   114: invokespecial 148	java/lang/String:<init>	([BII)V
    //   117: astore 23
    //   119: new 100	java/lang/String
    //   122: dup
    //   123: aload 22
    //   125: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   128: bipush 13
    //   130: iaload
    //   131: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   134: bipush 13
    //   136: iaload
    //   137: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   140: bipush 13
    //   142: iaload
    //   143: isub
    //   144: invokespecial 148	java/lang/String:<init>	([BII)V
    //   147: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   150: lstore 5
    //   152: new 100	java/lang/String
    //   155: dup
    //   156: aload 22
    //   158: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   161: bipush 15
    //   163: iaload
    //   164: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   167: bipush 15
    //   169: iaload
    //   170: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   173: bipush 15
    //   175: iaload
    //   176: isub
    //   177: invokespecial 148	java/lang/String:<init>	([BII)V
    //   180: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   183: lstore 7
    //   185: new 100	java/lang/String
    //   188: dup
    //   189: aload 22
    //   191: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   194: bipush 14
    //   196: iaload
    //   197: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   200: bipush 14
    //   202: iaload
    //   203: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   206: bipush 14
    //   208: iaload
    //   209: isub
    //   210: invokespecial 148	java/lang/String:<init>	([BII)V
    //   213: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   216: lstore 9
    //   218: new 100	java/lang/String
    //   221: dup
    //   222: aload 22
    //   224: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   227: bipush 16
    //   229: iaload
    //   230: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   233: bipush 16
    //   235: iaload
    //   236: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   239: bipush 16
    //   241: iaload
    //   242: isub
    //   243: invokespecial 148	java/lang/String:<init>	([BII)V
    //   246: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   249: lstore 11
    //   251: iconst_3
    //   252: anewarray 4	java/lang/Object
    //   255: astore_0
    //   256: aload_0
    //   257: iconst_0
    //   258: aload 23
    //   260: aastore
    //   261: aload_0
    //   262: iconst_1
    //   263: lload 5
    //   265: lload 7
    //   267: ladd
    //   268: invokestatic 155	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   271: aastore
    //   272: aload_0
    //   273: iconst_2
    //   274: lload 9
    //   276: lload 11
    //   278: ladd
    //   279: invokestatic 155	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   282: aastore
    //   283: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   286: aload 22
    //   288: invokevirtual 159	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:returnBuf	([B)V
    //   291: aload 21
    //   293: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   296: aload_0
    //   297: areturn
    //   298: new 100	java/lang/String
    //   301: dup
    //   302: aload 22
    //   304: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   307: iconst_4
    //   308: iaload
    //   309: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   312: iconst_4
    //   313: iaload
    //   314: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   317: iconst_4
    //   318: iaload
    //   319: isub
    //   320: invokespecial 148	java/lang/String:<init>	([BII)V
    //   323: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   326: lstore 5
    //   328: new 100	java/lang/String
    //   331: dup
    //   332: aload 22
    //   334: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   337: iconst_1
    //   338: iaload
    //   339: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   342: iconst_1
    //   343: iaload
    //   344: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   347: iconst_1
    //   348: iaload
    //   349: isub
    //   350: invokespecial 148	java/lang/String:<init>	([BII)V
    //   353: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   356: lstore 7
    //   358: new 100	java/lang/String
    //   361: dup
    //   362: aload 22
    //   364: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   367: iconst_2
    //   368: iaload
    //   369: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   372: iconst_2
    //   373: iaload
    //   374: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   377: iconst_2
    //   378: iaload
    //   379: isub
    //   380: invokespecial 148	java/lang/String:<init>	([BII)V
    //   383: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   386: lstore 9
    //   388: new 100	java/lang/String
    //   391: dup
    //   392: aload 22
    //   394: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   397: iconst_3
    //   398: iaload
    //   399: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   402: iconst_3
    //   403: iaload
    //   404: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   407: iconst_3
    //   408: iaload
    //   409: isub
    //   410: invokespecial 148	java/lang/String:<init>	([BII)V
    //   413: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   416: lstore 11
    //   418: new 100	java/lang/String
    //   421: dup
    //   422: aload 22
    //   424: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   427: iconst_5
    //   428: iaload
    //   429: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   432: iconst_5
    //   433: iaload
    //   434: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   437: iconst_5
    //   438: iaload
    //   439: isub
    //   440: invokespecial 148	java/lang/String:<init>	([BII)V
    //   443: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   446: lstore 13
    //   448: new 100	java/lang/String
    //   451: dup
    //   452: aload 22
    //   454: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   457: bipush 6
    //   459: iaload
    //   460: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   463: bipush 6
    //   465: iaload
    //   466: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   469: bipush 6
    //   471: iaload
    //   472: isub
    //   473: invokespecial 148	java/lang/String:<init>	([BII)V
    //   476: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   479: lstore 15
    //   481: new 100	java/lang/String
    //   484: dup
    //   485: aload 22
    //   487: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   490: bipush 7
    //   492: iaload
    //   493: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   496: bipush 7
    //   498: iaload
    //   499: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   502: bipush 7
    //   504: iaload
    //   505: isub
    //   506: invokespecial 148	java/lang/String:<init>	([BII)V
    //   509: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   512: lstore 17
    //   514: new 100	java/lang/String
    //   517: dup
    //   518: aload 22
    //   520: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   523: bipush 8
    //   525: iaload
    //   526: getstatic 67	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWhiteIndexs	[I
    //   529: bipush 8
    //   531: iaload
    //   532: getstatic 65	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sWordIndexs	[I
    //   535: bipush 8
    //   537: iaload
    //   538: isub
    //   539: invokespecial 148	java/lang/String:<init>	([BII)V
    //   542: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   545: lstore 19
    //   547: iconst_3
    //   548: anewarray 4	java/lang/Object
    //   551: astore_0
    //   552: aload_0
    //   553: iconst_0
    //   554: ldc 164
    //   556: aastore
    //   557: aload_0
    //   558: iconst_1
    //   559: lload 5
    //   561: invokestatic 155	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   564: aastore
    //   565: aload_0
    //   566: iconst_2
    //   567: lload 7
    //   569: lload 9
    //   571: ladd
    //   572: lload 11
    //   574: ladd
    //   575: lload 13
    //   577: ladd
    //   578: lload 15
    //   580: ladd
    //   581: lload 17
    //   583: ladd
    //   584: lload 19
    //   586: ladd
    //   587: invokestatic 155	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   590: aastore
    //   591: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   594: aload 22
    //   596: invokevirtual 159	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:returnBuf	([B)V
    //   599: aload 21
    //   601: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   604: aload_0
    //   605: areturn
    //   606: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   609: aload 22
    //   611: invokevirtual 159	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:returnBuf	([B)V
    //   614: aload 21
    //   616: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   619: goto +19 -> 638
    //   622: astore_0
    //   623: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   626: aload 22
    //   628: invokevirtual 159	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:returnBuf	([B)V
    //   631: aload 21
    //   633: invokevirtual 162	java/io/RandomAccessFile:close	()V
    //   636: aload_0
    //   637: athrow
    //   638: aconst_null
    //   639: areturn
    //   640: astore_0
    //   641: goto -35 -> 606
    //   644: astore 21
    //   646: aload_0
    //   647: areturn
    //   648: astore 21
    //   650: aload_0
    //   651: areturn
    //   652: astore_0
    //   653: goto -15 -> 638
    //   656: astore 21
    //   658: goto -22 -> 636
    //   661: iload_1
    //   662: iload 4
    //   664: if_icmpge -591 -> 73
    //   667: iload_3
    //   668: bipush 17
    //   670: if_icmpge -597 -> 73
    //   673: iload_1
    //   674: istore_2
    //   675: iload_2
    //   676: iload 4
    //   678: if_icmpge -639 -> 39
    //   681: aload 22
    //   683: iload_2
    //   684: baload
    //   685: bipush 32
    //   687: if_icmpne -648 -> 39
    //   690: iload_2
    //   691: iconst_1
    //   692: iadd
    //   693: istore_2
    //   694: goto -19 -> 675
    //   697: iload_1
    //   698: iload 4
    //   700: if_icmpge -642 -> 58
    //   703: aload 22
    //   705: iload_1
    //   706: baload
    //   707: bipush 32
    //   709: if_icmpeq -651 -> 58
    //   712: iload_1
    //   713: iconst_1
    //   714: iadd
    //   715: istore_1
    //   716: goto -19 -> 697
    //   719: iload_3
    //   720: iconst_1
    //   721: iadd
    //   722: istore_3
    //   723: goto -62 -> 661
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	paramString	String
    //   33	683	1	i	int
    //   39	655	2	j	int
    //   35	688	3	k	int
    //   30	671	4	m	int
    //   150	410	5	l1	long
    //   183	385	7	l2	long
    //   216	354	9	l3	long
    //   249	324	11	l4	long
    //   446	130	13	l5	long
    //   479	100	15	l6	long
    //   512	70	17	l7	long
    //   545	40	19	l8	long
    //   4	628	21	localRandomAccessFile	RandomAccessFile
    //   644	1	21	localException1	Exception
    //   648	1	21	localException2	Exception
    //   656	1	21	localException3	Exception
    //   15	689	22	arrayOfByte	byte[]
    //   117	142	23	str	String
    // Exception table:
    //   from	to	target	type
    //   17	32	622	finally
    //   47	53	622	finally
    //   64	70	622	finally
    //   79	256	622	finally
    //   261	283	622	finally
    //   298	552	622	finally
    //   557	591	622	finally
    //   17	32	640	java/lang/Exception
    //   47	53	640	java/lang/Exception
    //   64	70	640	java/lang/Exception
    //   79	256	640	java/lang/Exception
    //   261	283	640	java/lang/Exception
    //   298	552	640	java/lang/Exception
    //   557	591	640	java/lang/Exception
    //   291	296	644	java/lang/Exception
    //   599	604	648	java/lang/Exception
    //   614	619	652	java/lang/Exception
    //   631	636	656	java/lang/Exception
  }
  
  /* Error */
  public static final String dumpProcessStats(int paramInt)
  {
    // Byte code:
    //   0: new 168	java/lang/StringBuilder
    //   3: dup
    //   4: iload_0
    //   5: bipush 110
    //   7: imul
    //   8: invokespecial 169	java/lang/StringBuilder:<init>	(I)V
    //   11: astore_1
    //   12: ldc 11
    //   14: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   17: iconst_0
    //   18: invokestatic 171	com/tencent/qqmini/sdk/monitor/common/ProcessStats:collectProcessStats	(Ljava/lang/String;Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;Z)V
    //   21: new 168	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   28: astore_2
    //   29: aload_2
    //   30: ldc 174
    //   32: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   40: getfield 103	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats:baseUtime	J
    //   43: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_2
    //   48: ldc 183
    //   50: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   58: getfield 106	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats:baseStime	J
    //   61: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 185
    //   67: aload_2
    //   68: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 195	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: invokestatic 201	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   78: astore_2
    //   79: new 168	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   86: astore_3
    //   87: aload_3
    //   88: ldc 203
    //   90: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: iload_0
    //   96: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: ldc 208
    //   103: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: new 210	java/io/BufferedReader
    //   110: dup
    //   111: new 212	java/io/InputStreamReader
    //   114: dup
    //   115: aload_2
    //   116: aload_3
    //   117: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokevirtual 216	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   123: invokevirtual 222	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   126: invokespecial 225	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   129: invokespecial 228	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 231	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   137: astore_3
    //   138: aload_3
    //   139: ifnull +19 -> 158
    //   142: aload_1
    //   143: aload_3
    //   144: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_1
    //   149: ldc 233
    //   151: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: goto -22 -> 133
    //   158: ldc 11
    //   160: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   163: iconst_0
    //   164: invokestatic 171	com/tencent/qqmini/sdk/monitor/common/ProcessStats:collectProcessStats	(Ljava/lang/String;Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;Z)V
    //   167: new 168	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   174: astore_2
    //   175: aload_2
    //   176: ldc 174
    //   178: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_2
    //   183: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   186: getfield 103	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats:baseUtime	J
    //   189: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_2
    //   194: ldc 183
    //   196: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_2
    //   201: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   204: getfield 106	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats:baseStime	J
    //   207: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: ldc 185
    //   213: aload_2
    //   214: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 195	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   220: pop
    //   221: aload_1
    //   222: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore_1
    //   226: aload_1
    //   227: areturn
    //   228: astore_1
    //   229: aload_1
    //   230: athrow
    //   231: aconst_null
    //   232: areturn
    //   233: astore_1
    //   234: goto -3 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramInt	int
    //   11	216	1	localObject1	Object
    //   228	2	1	localObject2	Object
    //   233	1	1	localException	Exception
    //   28	186	2	localObject3	Object
    //   86	58	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	133	228	finally
    //   133	138	228	finally
    //   142	155	228	finally
    //   158	226	228	finally
    //   0	133	233	java/lang/Exception
    //   133	138	233	java/lang/Exception
    //   142	155	233	java/lang/Exception
    //   158	226	233	java/lang/Exception
  }
  
  public static final List<String> dumpThreadStats(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new HashMap();
    int i;
    if (paramBoolean)
    {
      localObject1 = Thread.currentThread().getThreadGroup();
      localObject3 = new Thread[((ThreadGroup)localObject1).activeCount()];
      ((ThreadGroup)localObject1).enumerate((Thread[])localObject3);
      localObject2 = new HashMap(localObject3.length);
      int j = localObject3.length;
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = localObject3[i];
        if (localObject1 != null) {
          ((Map)localObject2).put(((Thread)localObject1).getName(), localObject1);
        }
        i += 1;
      }
    }
    Object localObject2 = new ArrayList(sThreadUsageMap.size() / 2);
    Object localObject3 = sThreadUsageMap.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (String)((Iterator)localObject3).next();
      ProcessStats.Stats localStats = (ProcessStats.Stats)sThreadUsageMap.get(localObject4);
      if (localStats.cpuUsage >= paramInt)
      {
        if (paramBoolean) {
          i = 300;
        } else {
          i = 50;
        }
        StringBuilder localStringBuilder = new StringBuilder(i);
        localStringBuilder.append(localStats.name);
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject4);
        localStringBuilder.append(":");
        localStringBuilder.append(localStats.cpuUsage);
        localStringBuilder.append("\r\n");
        if (paramBoolean)
        {
          localObject4 = (Thread)((Map)localObject1).get(localStats.name);
          if (localObject4 != null) {
            localStringBuilder.append(Arrays.toString(((Thread)localObject4).getStackTrace()));
          }
          localObject4 = StringUtils.getStringValue(localStringBuilder);
          if (localObject4 != null) {
            ((List)localObject2).add(StringUtils.newStringWithData((char[])localObject4));
          } else {
            ((List)localObject2).add(localStringBuilder.toString());
          }
        }
      }
    }
    if (paramBoolean) {
      ((List)localObject2).add(Arrays.toString(Looper.getMainLooper().getThread().getStackTrace()));
    }
    return localObject2;
  }
  
  private static final int getNumCoresOldPhones()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new ProcessStats.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    return 1;
  }
  
  @SuppressLint({"NewApi"})
  public static final int getNumberOfCores()
  {
    if (sCpuCoreNum == -1) {
      if (Build.VERSION.SDK_INT >= 17) {
        sCpuCoreNum = Runtime.getRuntime().availableProcessors();
      } else {
        sCpuCoreNum = getNumCoresOldPhones();
      }
    }
    return sCpuCoreNum;
  }
  
  private static final RandomAccessFile getReader(String paramString)
  {
    try
    {
      boolean bool = paramString.equals("-2");
      if (bool) {
        return new RandomAccessFile("/proc/stat", "r");
      }
      bool = paramString.equals("-1");
      if (bool)
      {
        paramString = new StringBuilder();
        paramString.append("/proc/");
        paramString.append(Process.myPid());
        paramString.append("/stat");
        return new RandomAccessFile(paramString.toString(), "r");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/proc/");
      localStringBuilder.append(Process.myPid());
      localStringBuilder.append("/task/");
      localStringBuilder.append(paramString);
      localStringBuilder.append("/stat");
      paramString = new RandomAccessFile(localStringBuilder.toString(), "r");
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static final String[] getThreadPids(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/proc/");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("/task");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory())) {
      return ((File)localObject).list();
    }
    return null;
  }
  
  public static ProcessStats.Stats obtainStats()
  {
    return (ProcessStats.Stats)sPool.obtain(ProcessStats.Stats.class);
  }
  
  public static void returnStats(ProcessStats.Stats paramStats)
  {
    paramStats.recycle();
  }
  
  /* Error */
  public static void traceEnd(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   3: sipush 1024
    //   6: invokevirtual 131	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getBuf	(I)[B
    //   9: astore 5
    //   11: ldc 14
    //   13: invokestatic 89	com/tencent/qqmini/sdk/monitor/common/ProcessStats:collectProcessStats	(Ljava/lang/String;)[Ljava/lang/Object;
    //   16: astore 6
    //   18: ldc2_w 17
    //   21: lstore_1
    //   22: aload 6
    //   24: ifnull +216 -> 240
    //   27: aload 6
    //   29: iconst_1
    //   30: aaload
    //   31: checkcast 91	java/lang/Long
    //   34: invokevirtual 95	java/lang/Long:longValue	()J
    //   37: lstore_3
    //   38: aload 6
    //   40: iconst_2
    //   41: aaload
    //   42: checkcast 91	java/lang/Long
    //   45: invokevirtual 95	java/lang/Long:longValue	()J
    //   48: lstore_1
    //   49: goto +3 -> 52
    //   52: lload_3
    //   53: lload_1
    //   54: ladd
    //   55: getstatic 80	com/tencent/qqmini/sdk/monitor/common/ProcessStats:baseTotalCpu	J
    //   58: lsub
    //   59: getstatic 78	com/tencent/qqmini/sdk/monitor/common/ProcessStats:baseTotalIdle	J
    //   62: lsub
    //   63: lstore_3
    //   64: ldc 11
    //   66: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   69: iconst_0
    //   70: invokestatic 171	com/tencent/qqmini/sdk/monitor/common/ProcessStats:collectProcessStats	(Ljava/lang/String;Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;Z)V
    //   73: iload_0
    //   74: ifeq +89 -> 163
    //   77: getstatic 74	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sThreadUsageMap	Ljava/util/Map;
    //   80: invokeinterface 275 1 0
    //   85: invokeinterface 281 1 0
    //   90: astore 6
    //   92: aload 6
    //   94: invokeinterface 287 1 0
    //   99: ifeq +64 -> 163
    //   102: aload 6
    //   104: invokeinterface 291 1 0
    //   109: checkcast 100	java/lang/String
    //   112: astore 7
    //   114: getstatic 74	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sThreadUsageMap	Ljava/util/Map;
    //   117: aload 7
    //   119: invokeinterface 295 2 0
    //   124: checkcast 45	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats
    //   127: astore 8
    //   129: aload 7
    //   131: aload 8
    //   133: iconst_0
    //   134: invokestatic 171	com/tencent/qqmini/sdk/monitor/common/ProcessStats:collectProcessStats	(Ljava/lang/String;Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;Z)V
    //   137: aload 8
    //   139: aload 8
    //   141: getfield 117	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats:relStime	J
    //   144: aload 8
    //   146: getfield 114	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats:relUtime	J
    //   149: ladd
    //   150: ldc2_w 419
    //   153: lmul
    //   154: lload_3
    //   155: ldiv
    //   156: l2i
    //   157: putfield 298	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats:cpuUsage	I
    //   160: goto -68 -> 92
    //   163: lload_1
    //   164: getstatic 80	com/tencent/qqmini/sdk/monitor/common/ProcessStats:baseTotalCpu	J
    //   167: lsub
    //   168: ldc2_w 419
    //   171: lmul
    //   172: lload_3
    //   173: ldiv
    //   174: l2i
    //   175: putstatic 55	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sTotalCpuUsage	I
    //   178: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   181: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   184: getfield 117	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats:relStime	J
    //   187: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   190: getfield 114	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats:relUtime	J
    //   193: ladd
    //   194: ldc2_w 419
    //   197: lmul
    //   198: lload_3
    //   199: ldiv
    //   200: l2i
    //   201: putfield 298	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats:cpuUsage	I
    //   204: invokestatic 425	android/os/SystemClock:uptimeMillis	()J
    //   207: putstatic 53	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sLastUpdateTime	J
    //   210: goto +16 -> 226
    //   213: astore 6
    //   215: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   218: aload 5
    //   220: invokevirtual 159	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:returnBuf	([B)V
    //   223: aload 6
    //   225: athrow
    //   226: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   229: aload 5
    //   231: invokevirtual 159	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:returnBuf	([B)V
    //   234: return
    //   235: astore 6
    //   237: goto -11 -> 226
    //   240: ldc2_w 17
    //   243: lstore_3
    //   244: goto -192 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramBoolean	boolean
    //   21	143	1	l1	long
    //   37	207	3	l2	long
    //   9	221	5	arrayOfByte	byte[]
    //   16	87	6	localObject1	Object
    //   213	11	6	localObject2	Object
    //   235	1	6	localException	Exception
    //   112	18	7	str	String
    //   127	18	8	localStats	ProcessStats.Stats
    // Exception table:
    //   from	to	target	type
    //   11	18	213	finally
    //   27	49	213	finally
    //   52	73	213	finally
    //   77	92	213	finally
    //   92	160	213	finally
    //   163	210	213	finally
    //   11	18	235	java/lang/Exception
    //   27	49	235	java/lang/Exception
    //   52	73	235	java/lang/Exception
    //   77	92	235	java/lang/Exception
    //   92	160	235	java/lang/Exception
    //   163	210	235	java/lang/Exception
  }
  
  /* Error */
  public static void traceStart(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   3: sipush 1024
    //   6: invokevirtual 131	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getBuf	(I)[B
    //   9: astore_3
    //   10: ldc 14
    //   12: invokestatic 89	com/tencent/qqmini/sdk/monitor/common/ProcessStats:collectProcessStats	(Ljava/lang/String;)[Ljava/lang/Object;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +32 -> 51
    //   22: aload 4
    //   24: iconst_1
    //   25: aaload
    //   26: checkcast 91	java/lang/Long
    //   29: invokevirtual 95	java/lang/Long:longValue	()J
    //   32: putstatic 78	com/tencent/qqmini/sdk/monitor/common/ProcessStats:baseTotalIdle	J
    //   35: aload 4
    //   37: iconst_2
    //   38: aaload
    //   39: checkcast 91	java/lang/Long
    //   42: invokevirtual 95	java/lang/Long:longValue	()J
    //   45: putstatic 80	com/tencent/qqmini/sdk/monitor/common/ProcessStats:baseTotalCpu	J
    //   48: goto +15 -> 63
    //   51: ldc2_w 17
    //   54: putstatic 78	com/tencent/qqmini/sdk/monitor/common/ProcessStats:baseTotalIdle	J
    //   57: ldc2_w 17
    //   60: putstatic 80	com/tencent/qqmini/sdk/monitor/common/ProcessStats:baseTotalCpu	J
    //   63: ldc 11
    //   65: getstatic 61	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sAppSt	Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   68: iconst_1
    //   69: invokestatic 171	com/tencent/qqmini/sdk/monitor/common/ProcessStats:collectProcessStats	(Ljava/lang/String;Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;Z)V
    //   72: iload_0
    //   73: ifeq +128 -> 201
    //   76: getstatic 74	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sThreadUsageMap	Ljava/util/Map;
    //   79: invokeinterface 430 1 0
    //   84: invokeinterface 433 1 0
    //   89: astore 4
    //   91: aload 4
    //   93: invokeinterface 287 1 0
    //   98: ifeq +19 -> 117
    //   101: aload 4
    //   103: invokeinterface 291 1 0
    //   108: checkcast 45	com/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats
    //   111: invokestatic 435	com/tencent/qqmini/sdk/monitor/common/ProcessStats:returnStats	(Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;)V
    //   114: goto -23 -> 91
    //   117: getstatic 74	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sThreadUsageMap	Ljava/util/Map;
    //   120: invokeinterface 438 1 0
    //   125: invokestatic 385	android/os/Process:myPid	()I
    //   128: i2l
    //   129: invokestatic 440	com/tencent/qqmini/sdk/monitor/common/ProcessStats:getThreadPids	(J)[Ljava/lang/String;
    //   132: astore 4
    //   134: aload 4
    //   136: ifnull +65 -> 201
    //   139: aload 4
    //   141: arraylength
    //   142: istore_2
    //   143: iconst_0
    //   144: istore_1
    //   145: iload_1
    //   146: iload_2
    //   147: if_icmpge +54 -> 201
    //   150: aload 4
    //   152: iload_1
    //   153: aaload
    //   154: astore 5
    //   156: invokestatic 59	com/tencent/qqmini/sdk/monitor/common/ProcessStats:obtainStats	()Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;
    //   159: astore 6
    //   161: aload 5
    //   163: aload 6
    //   165: iconst_1
    //   166: invokestatic 171	com/tencent/qqmini/sdk/monitor/common/ProcessStats:collectProcessStats	(Ljava/lang/String;Lcom/tencent/qqmini/sdk/monitor/common/ProcessStats$Stats;Z)V
    //   169: getstatic 74	com/tencent/qqmini/sdk/monitor/common/ProcessStats:sThreadUsageMap	Ljava/util/Map;
    //   172: aload 5
    //   174: aload 6
    //   176: invokeinterface 265 3 0
    //   181: pop
    //   182: iload_1
    //   183: iconst_1
    //   184: iadd
    //   185: istore_1
    //   186: goto -41 -> 145
    //   189: astore 4
    //   191: goto +18 -> 209
    //   194: astore 4
    //   196: aload 4
    //   198: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   201: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   204: aload_3
    //   205: invokevirtual 159	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:returnBuf	([B)V
    //   208: return
    //   209: invokestatic 127	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:getGenericInstance	()Lcom/tencent/qqmini/sdk/monitor/common/ByteArrayPool;
    //   212: aload_3
    //   213: invokevirtual 159	com/tencent/qqmini/sdk/monitor/common/ByteArrayPool:returnBuf	([B)V
    //   216: goto +6 -> 222
    //   219: aload 4
    //   221: athrow
    //   222: goto -3 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramBoolean	boolean
    //   144	42	1	i	int
    //   142	6	2	j	int
    //   9	204	3	arrayOfByte	byte[]
    //   15	136	4	localObject1	Object
    //   189	1	4	localObject2	Object
    //   194	26	4	localException	Exception
    //   154	19	5	str	String
    //   159	16	6	localStats	ProcessStats.Stats
    // Exception table:
    //   from	to	target	type
    //   10	17	189	finally
    //   22	48	189	finally
    //   51	63	189	finally
    //   63	72	189	finally
    //   76	91	189	finally
    //   91	114	189	finally
    //   117	134	189	finally
    //   139	143	189	finally
    //   156	182	189	finally
    //   196	201	189	finally
    //   10	17	194	java/lang/Exception
    //   22	48	194	java/lang/Exception
    //   51	63	194	java/lang/Exception
    //   63	72	194	java/lang/Exception
    //   76	91	194	java/lang/Exception
    //   91	114	194	java/lang/Exception
    //   117	134	194	java/lang/Exception
    //   139	143	194	java/lang/Exception
    //   156	182	194	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.ProcessStats
 * JD-Core Version:    0.7.0.1
 */