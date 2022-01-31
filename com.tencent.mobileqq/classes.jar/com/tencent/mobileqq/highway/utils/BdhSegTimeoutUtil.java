package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class BdhSegTimeoutUtil
{
  public static final int DYN_TIMEOUT_ENABLE = 1;
  public static final int DYN_TIMEOUT_UNABLE = 0;
  public static final long HEARTBREAK_TIMEOUT_DEFAULT = 10000L;
  public static final long MAX_TIMEOUT_DEFAULT = 90000L;
  private static final long TBASE_2G_DEFAULT = 8000L;
  private static final long TBASE_3G_DEFAULT = 8000L;
  private static final long TBASE_4G_DEFAULT = 3000L;
  private static final long TBASE_WIFI_DEFAULT = 3000L;
  public static final long[] TIME_OUT_DELTA = { 0L, 4000L, 9000L, 16000L, 25000L, 36000L, 49000L, 64000L, 81000L };
  private static final long TORG_2G_DEFAULT = 15000L;
  private static final long TORG_3G_DEFAULT = 15000L;
  private static final long TORG_4G_DEFAULT = 5000L;
  private static final long TORG_WIFI_DEFAULT = 5000L;
  public static int sEnableDynTimeout;
  private static long sHbTimeoutDef;
  private static long sHbTimeout_2G;
  private static long sHbTimeout_3G;
  private static long sHbTimeout_4G;
  private static long sHbTimeout_wifi;
  private static long sMaxTimeoutDef;
  private static long sMaxTimeout_2G;
  private static long sMaxTimeout_3G;
  private static long sMaxTimeout_4G;
  private static long sMaxTimeout_wifi;
  private static long sTbase_2G = 8000L;
  private static long sTbase_3G = 8000L;
  private static long sTbase_4G = 3000L;
  private static long sTbase_wifi = 3000L;
  private static long sTorg_2G = 15000L;
  private static long sTorg_3G = 15000L;
  private static long sTorg_4G = 5000L;
  private static long sTorg_wifi = 5000L;
  
  static
  {
    sMaxTimeoutDef = 90000L;
    sMaxTimeout_2G = 90000L;
    sMaxTimeout_3G = 90000L;
    sMaxTimeout_4G = 90000L;
    sMaxTimeout_wifi = 90000L;
    sHbTimeoutDef = 10000L;
    sHbTimeout_2G = 10000L;
    sHbTimeout_3G = 10000L;
    sHbTimeout_4G = 10000L;
    sHbTimeout_wifi = 10000L;
    sEnableDynTimeout = 0;
  }
  
  /* Error */
  public static long calculateTimeout(Context paramContext, com.tencent.mobileqq.highway.segment.RequestDataTrans paramRequestDataTrans, long paramLong1, int paramInt, long paramLong2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +25 -> 29
    //   7: aload_1
    //   8: ifnull +21 -> 29
    //   11: lload_2
    //   12: lconst_0
    //   13: lcmp
    //   14: ifle +15 -> 29
    //   17: iload 4
    //   19: iflt +10 -> 29
    //   22: lload 5
    //   24: lconst_0
    //   25: lcmp
    //   26: ifge +12 -> 38
    //   29: ldc2_w 118
    //   32: lstore_2
    //   33: ldc 2
    //   35: monitorexit
    //   36: lload_2
    //   37: lreturn
    //   38: ldc2_w 118
    //   41: lstore 18
    //   43: getstatic 57	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sTbase_2G	J
    //   46: lstore 12
    //   48: getstatic 65	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sTorg_2G	J
    //   51: lstore 14
    //   53: getstatic 73	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sMaxTimeoutDef	J
    //   56: lstore 10
    //   58: aload_0
    //   59: invokestatic 125	com/tencent/mobileqq/highway/utils/HwNetworkUtil:getSystemNetwork	(Landroid/content/Context;)I
    //   62: istore 7
    //   64: iconst_2
    //   65: iload 7
    //   67: if_icmpne +257 -> 324
    //   70: getstatic 75	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sMaxTimeout_2G	J
    //   73: lstore 10
    //   75: iconst_0
    //   76: istore 9
    //   78: aload_1
    //   79: getfield 130	com/tencent/mobileqq/highway/segment/RequestDataTrans:timeOutCount	I
    //   82: istore 8
    //   84: iload 8
    //   86: istore 7
    //   88: iload 8
    //   90: getstatic 111	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:TIME_OUT_DELTA	[J
    //   93: arraylength
    //   94: if_icmplt +11 -> 105
    //   97: getstatic 111	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:TIME_OUT_DELTA	[J
    //   100: arraylength
    //   101: iconst_1
    //   102: isub
    //   103: istore 7
    //   105: lload 5
    //   107: lconst_0
    //   108: lcmp
    //   109: ifle +287 -> 396
    //   112: aload_1
    //   113: getfield 134	com/tencent/mobileqq/highway/segment/RequestDataTrans:mInfo	Lcom/tencent/mobileqq/highway/transaction/DataTransInfo;
    //   116: astore_0
    //   117: iload 9
    //   119: istore 8
    //   121: lload 18
    //   123: lstore 16
    //   125: aload_0
    //   126: ifnull +65 -> 191
    //   129: aload_0
    //   130: getfield 139	com/tencent/mobileqq/highway/transaction/DataTransInfo:length	I
    //   133: istore 9
    //   135: iload 9
    //   137: istore 8
    //   139: lload 18
    //   141: lstore 16
    //   143: iload 9
    //   145: ifle +46 -> 191
    //   148: iload 9
    //   150: istore 8
    //   152: lload 18
    //   154: lstore 16
    //   156: iload 7
    //   158: iflt +33 -> 191
    //   161: lload 12
    //   163: lload_2
    //   164: ladd
    //   165: iload 9
    //   167: i2d
    //   168: iload 4
    //   170: i2d
    //   171: ddiv
    //   172: lload 5
    //   174: l2d
    //   175: dmul
    //   176: d2l
    //   177: ladd
    //   178: getstatic 111	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:TIME_OUT_DELTA	[J
    //   181: iload 7
    //   183: laload
    //   184: ladd
    //   185: lstore 16
    //   187: iload 9
    //   189: istore 8
    //   191: ldc 141
    //   193: new 143	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   200: ldc 146
    //   202: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 154	com/tencent/mobileqq/highway/segment/RequestDataTrans:getHwSeq	()I
    //   209: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc 159
    //   214: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: lload 12
    //   219: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   222: ldc 164
    //   224: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: lload 14
    //   229: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   232: ldc 166
    //   234: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: lload 10
    //   239: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   242: ldc 168
    //   244: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: lload_2
    //   248: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   251: ldc 170
    //   253: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: iload 4
    //   258: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: ldc 172
    //   263: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: lload 5
    //   268: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   271: ldc 174
    //   273: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: iload 8
    //   278: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc 176
    //   283: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload 7
    //   288: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc 178
    //   293: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: lload 16
    //   298: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 188	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: lload 10
    //   309: lstore_2
    //   310: lload 16
    //   312: lload 10
    //   314: lcmp
    //   315: ifgt -282 -> 33
    //   318: lload 16
    //   320: lstore_2
    //   321: goto -288 -> 33
    //   324: iconst_3
    //   325: iload 7
    //   327: if_icmpne +21 -> 348
    //   330: getstatic 59	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sTbase_3G	J
    //   333: lstore 12
    //   335: getstatic 67	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sTorg_3G	J
    //   338: lstore 14
    //   340: getstatic 77	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sMaxTimeout_3G	J
    //   343: lstore 10
    //   345: goto -270 -> 75
    //   348: iconst_4
    //   349: iload 7
    //   351: if_icmpne +21 -> 372
    //   354: getstatic 61	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sTbase_4G	J
    //   357: lstore 12
    //   359: getstatic 69	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sTorg_4G	J
    //   362: lstore 14
    //   364: getstatic 79	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sMaxTimeout_4G	J
    //   367: lstore 10
    //   369: goto -294 -> 75
    //   372: iconst_1
    //   373: iload 7
    //   375: if_icmpne -300 -> 75
    //   378: getstatic 63	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sTbase_wifi	J
    //   381: lstore 12
    //   383: getstatic 71	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sTorg_wifi	J
    //   386: lstore 14
    //   388: getstatic 81	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sMaxTimeout_wifi	J
    //   391: lstore 10
    //   393: goto -318 -> 75
    //   396: iload 9
    //   398: istore 8
    //   400: lload 18
    //   402: lstore 16
    //   404: iload 7
    //   406: iflt -215 -> 191
    //   409: getstatic 111	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:TIME_OUT_DELTA	[J
    //   412: iload 7
    //   414: laload
    //   415: lstore 16
    //   417: lload 12
    //   419: lload_2
    //   420: ladd
    //   421: lload 14
    //   423: ladd
    //   424: lload 16
    //   426: ladd
    //   427: lstore 16
    //   429: iload 9
    //   431: istore 8
    //   433: goto -242 -> 191
    //   436: astore_0
    //   437: ldc 2
    //   439: monitorexit
    //   440: aload_0
    //   441: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	paramContext	Context
    //   0	442	1	paramRequestDataTrans	com.tencent.mobileqq.highway.segment.RequestDataTrans
    //   0	442	2	paramLong1	long
    //   0	442	4	paramInt	int
    //   0	442	5	paramLong2	long
    //   62	351	7	i	int
    //   82	350	8	j	int
    //   76	354	9	k	int
    //   56	336	10	l1	long
    //   46	372	12	l2	long
    //   51	371	14	l3	long
    //   123	305	16	l4	long
    //   41	360	18	l5	long
    // Exception table:
    //   from	to	target	type
    //   43	64	436	finally
    //   70	75	436	finally
    //   78	84	436	finally
    //   88	105	436	finally
    //   112	117	436	finally
    //   129	135	436	finally
    //   161	187	436	finally
    //   191	307	436	finally
    //   330	345	436	finally
    //   354	369	436	finally
    //   378	393	436	finally
    //   409	417	436	finally
  }
  
  public static long getUrgentHbTimeout(Context paramContext)
  {
    for (;;)
    {
      try
      {
        long l = sHbTimeoutDef;
        if (paramContext == null) {
          return l;
        }
        int i = HwNetworkUtil.getSystemNetwork(paramContext);
        if (2 == i) {
          l = sHbTimeout_2G;
        } else if (3 == i) {
          l = sHbTimeout_3G;
        } else if (4 == i) {
          l = sHbTimeout_3G;
        } else if (1 == i) {
          l = sHbTimeout_wifi;
        }
      }
      finally {}
    }
  }
  
  public static void updateFromSrv(subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf paramDynTimeOutConf)
  {
    if (paramDynTimeOutConf == null) {}
    for (;;)
    {
      return;
      try
      {
        int i;
        if (paramDynTimeOutConf.uint32_tbase_2g.has())
        {
          i = paramDynTimeOutConf.uint32_tbase_2g.get();
          if ((i >= 1) && (i <= 100)) {
            sTbase_2G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_tbase_3g.has())
        {
          i = paramDynTimeOutConf.uint32_tbase_3g.get();
          if ((i >= 1) && (i <= 100)) {
            sTbase_3G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_tbase_4g.has())
        {
          i = paramDynTimeOutConf.uint32_tbase_4g.get();
          if ((i >= 1) && (i <= 100)) {
            sTbase_4G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_tbase_wifi.has())
        {
          i = paramDynTimeOutConf.uint32_tbase_wifi.get();
          if ((i >= 1) && (i <= 100)) {
            sTbase_wifi = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_torg_2g.has())
        {
          i = paramDynTimeOutConf.uint32_torg_2g.get();
          if ((i >= 1) && (i <= 100)) {
            sTorg_2G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_torg_3g.has())
        {
          i = paramDynTimeOutConf.uint32_torg_3g.get();
          if ((i >= 1) && (i <= 100)) {
            sTorg_3G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_torg_4g.has())
        {
          i = paramDynTimeOutConf.uint32_torg_4g.get();
          if ((i >= 1) && (i <= 100)) {
            sTorg_4G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_torg_wifi.has())
        {
          i = paramDynTimeOutConf.uint32_torg_wifi.get();
          if ((i >= 1) && (i <= 100)) {
            sTorg_wifi = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_max_timeout.has())
        {
          i = paramDynTimeOutConf.uint32_max_timeout.get();
          if ((i >= 10) && (i <= 1000)) {
            sMaxTimeoutDef = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_max_timeout_2g.has())
        {
          i = paramDynTimeOutConf.uint32_max_timeout_2g.get();
          if ((i >= 10) && (i <= 1000)) {
            sMaxTimeout_2G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_max_timeout_3g.has())
        {
          i = paramDynTimeOutConf.uint32_max_timeout_3g.get();
          if ((i >= 10) && (i <= 1000)) {
            sMaxTimeout_3G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_max_timeout_4g.has())
        {
          i = paramDynTimeOutConf.uint32_max_timeout_4g.get();
          if ((i >= 10) && (i <= 1000)) {
            sMaxTimeout_4G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_max_timeout_wifi.has())
        {
          i = paramDynTimeOutConf.uint32_max_timeout_wifi.get();
          if ((i >= 10) && (i <= 1000)) {
            sMaxTimeout_wifi = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_enable_dyn_timeout.has())
        {
          i = paramDynTimeOutConf.uint32_enable_dyn_timeout.get();
          if ((i == 0) || (i == 1)) {
            sEnableDynTimeout = i;
          }
        }
        if (paramDynTimeOutConf.uint32_hb_timeout_default.has())
        {
          i = paramDynTimeOutConf.uint32_hb_timeout_default.get();
          if (i > 0) {
            sHbTimeoutDef = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_hb_timeout_2g.has())
        {
          i = paramDynTimeOutConf.uint32_hb_timeout_2g.get();
          if (i > 0) {
            sHbTimeout_2G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_hb_timeout_3g.has())
        {
          i = paramDynTimeOutConf.uint32_hb_timeout_3g.get();
          if (i > 0) {
            sHbTimeout_3G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_hb_timeout_4g.has())
        {
          i = paramDynTimeOutConf.uint32_hb_timeout_4g.get();
          if (i > 0) {
            sHbTimeout_4G = Long.valueOf(i).longValue() * 1000L;
          }
        }
        if (paramDynTimeOutConf.uint32_hb_timeout_wifi.has())
        {
          i = paramDynTimeOutConf.uint32_hb_timeout_wifi.get();
          if (i > 0) {
            sHbTimeout_wifi = Long.valueOf(i).longValue() * 1000L;
          }
        }
        BdhLogUtil.LogEvent("R", "BdhSegTimeoutUtil.updateFromSrv:  sTbase_2G = " + sTbase_2G + " sTbase_3G = " + sTbase_3G + " sTbase_4G = " + sTbase_4G + " sTbase_wifi = " + sTbase_wifi + " sTorg_2G = " + sTorg_2G + " sTorg_3G = " + sTorg_3G + " sTorg_4G = " + sTorg_4G + " sTorg_wifi = " + sTorg_wifi + " sMaxTimeoutDef = " + sMaxTimeoutDef + " sMaxTimeout_2G = " + sMaxTimeout_2G + " sMaxTimeout_3G = " + sMaxTimeout_3G + " sMaxTimeout_4G = " + sMaxTimeout_4G + " sMaxTimeout_wifi = " + sMaxTimeout_wifi + " sEnableDynTimeout = " + sEnableDynTimeout + " sHbTimeoutDef = " + sHbTimeoutDef + " sHbTimeout_2G = " + sHbTimeout_2G + " sHbTimeout_3G = " + sHbTimeout_3G + " sHbTimeout_4G = " + sHbTimeout_4G + " sHbTimeout_wifi = " + sHbTimeout_wifi);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil
 * JD-Core Version:    0.7.0.1
 */