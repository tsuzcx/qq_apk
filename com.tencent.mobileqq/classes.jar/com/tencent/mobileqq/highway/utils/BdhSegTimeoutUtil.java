package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf;
import com.tencent.mobileqq.highway.segment.RequestDataTrans;
import com.tencent.mobileqq.highway.transaction.DataTransInfo;
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
  
  public static long calculateTimeout(Context paramContext, RequestDataTrans paramRequestDataTrans, long paramLong1, int paramInt, long paramLong2)
  {
    if ((paramContext == null) || (paramRequestDataTrans == null) || (paramLong1 <= 0L) || (paramInt < 0) || (paramLong2 < 0L))
    {
      paramLong1 = -1L;
      return paramLong1;
    }
    long l5 = -1L;
    label447:
    label450:
    label461:
    for (;;)
    {
      long l4;
      try
      {
        l1 = sTbase_2G;
        long l2 = sTorg_2G;
        l4 = sMaxTimeoutDef;
        i = HwNetworkUtil.getSystemNetwork(paramContext);
        int j;
        if (2 == i)
        {
          l4 = sMaxTimeout_2G;
          l3 = l1;
          l1 = l4;
          i = 0;
          j = paramRequestDataTrans.timeOutCount;
          if (j < TIME_OUT_DELTA.length) {
            break label447;
          }
          j = TIME_OUT_DELTA.length - 1;
          if (paramLong2 <= 0L) {
            continue;
          }
          paramContext = paramRequestDataTrans.mInfo;
          l4 = l5;
          if (paramContext == null) {
            break label461;
          }
          int k = paramContext.length;
          i = k;
          l4 = l5;
          if (k <= 0) {
            break label461;
          }
          i = k;
          l4 = l5;
          if (j < 0) {
            break label461;
          }
          l4 = l3 + paramLong1 + (k / paramInt * paramLong2) + TIME_OUT_DELTA[j];
          i = k;
          break label461;
          BdhLogUtil.LogEvent("R", "BdhSegTimeoutUtil.calculateTimeout:  req.hwSeq = " + paramRequestDataTrans.getHwSeq() + " tBase = " + l3 + " tOrg = " + l2 + " tMaxTimeout = " + l1 + " rtt = " + paramLong1 + " lastSegSize = " + paramInt + " lastTimeCost = " + paramLong2 + " segSize = " + i + " timeoutCount = " + j + " timeout = " + l4);
          paramLong1 = l4;
          if (l4 <= l1) {
            break;
          }
          paramLong1 = l1;
          break;
        }
        if (3 == i)
        {
          l3 = sTbase_3G;
          l2 = sTorg_3G;
          l1 = sMaxTimeout_3G;
          continue;
        }
        if (4 == i)
        {
          l3 = sTbase_4G;
          l2 = sTorg_4G;
          l1 = sMaxTimeout_4G;
          continue;
        }
        if (1 != i) {
          break label450;
        }
        l3 = sTbase_wifi;
        l2 = sTorg_wifi;
        l1 = sMaxTimeout_wifi;
        continue;
        if (j >= 0)
        {
          l4 = TIME_OUT_DELTA[j];
          l4 = l3 + paramLong1 + l2 + l4;
          i = 0;
          continue;
        }
        l4 = -1L;
      }
      finally {}
      int i = 0;
      continue;
      continue;
      long l3 = l1;
      long l1 = l4;
    }
  }
  
  /* Error */
  public static long getUrgentHbTimeout(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 83	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sHbTimeoutDef	J
    //   6: lstore_2
    //   7: aload_0
    //   8: ifnonnull +8 -> 16
    //   11: ldc 2
    //   13: monitorexit
    //   14: lload_2
    //   15: lreturn
    //   16: aload_0
    //   17: invokestatic 125	com/tencent/mobileqq/highway/utils/HwNetworkUtil:getSystemNetwork	(Landroid/content/Context;)I
    //   20: istore_1
    //   21: iconst_2
    //   22: iload_1
    //   23: if_icmpne +10 -> 33
    //   26: getstatic 85	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sHbTimeout_2G	J
    //   29: lstore_2
    //   30: goto -19 -> 11
    //   33: iconst_3
    //   34: iload_1
    //   35: if_icmpne +10 -> 45
    //   38: getstatic 87	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sHbTimeout_3G	J
    //   41: lstore_2
    //   42: goto -31 -> 11
    //   45: iconst_4
    //   46: iload_1
    //   47: if_icmpne +10 -> 57
    //   50: getstatic 87	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sHbTimeout_3G	J
    //   53: lstore_2
    //   54: goto -43 -> 11
    //   57: iconst_1
    //   58: iload_1
    //   59: if_icmpne -48 -> 11
    //   62: getstatic 91	com/tencent/mobileqq/highway/utils/BdhSegTimeoutUtil:sHbTimeout_wifi	J
    //   65: lstore_2
    //   66: goto -55 -> 11
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramContext	Context
    //   20	40	1	i	int
    //   6	60	2	l	long
    // Exception table:
    //   from	to	target	type
    //   3	7	69	finally
    //   16	21	69	finally
    //   26	30	69	finally
    //   38	42	69	finally
    //   50	54	69	finally
    //   62	66	69	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil
 * JD-Core Version:    0.7.0.1
 */