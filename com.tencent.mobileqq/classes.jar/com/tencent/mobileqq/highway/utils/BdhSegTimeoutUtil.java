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
  public static int sEnableDynTimeout = 0;
  private static long sHbTimeoutDef = 10000L;
  private static long sHbTimeout_2G = 10000L;
  private static long sHbTimeout_3G = 10000L;
  private static long sHbTimeout_4G = 10000L;
  private static long sHbTimeout_wifi = 10000L;
  private static long sMaxTimeoutDef = 90000L;
  private static long sMaxTimeout_2G = 90000L;
  private static long sMaxTimeout_3G = 90000L;
  private static long sMaxTimeout_4G = 90000L;
  private static long sMaxTimeout_wifi = 90000L;
  private static long sTbase_2G = 8000L;
  private static long sTbase_3G = 8000L;
  private static long sTbase_4G = 3000L;
  private static long sTbase_wifi = 3000L;
  private static long sTorg_2G = 15000L;
  private static long sTorg_3G = 15000L;
  private static long sTorg_4G = 5000L;
  private static long sTorg_wifi = 5000L;
  
  public static long calculateTimeout(Context paramContext, RequestDataTrans paramRequestDataTrans, long paramLong1, int paramInt, long paramLong2)
  {
    long l2;
    long l3;
    long l1;
    int i;
    int j;
    long l4;
    if ((paramContext != null) && (paramRequestDataTrans != null) && (paramLong1 > 0L) && (paramInt >= 0) && (paramLong2 >= 0L))
    {
      try
      {
        l2 = sTbase_2G;
        l3 = sTorg_2G;
        l1 = sMaxTimeoutDef;
        i = HwNetworkUtil.getSystemNetwork(paramContext);
        if (2 == i)
        {
          l1 = sMaxTimeout_2G;
        }
        else if (3 == i)
        {
          l2 = sTbase_3G;
          l3 = sTorg_3G;
          l1 = sMaxTimeout_3G;
        }
        else if (4 == i)
        {
          l2 = sTbase_4G;
          l3 = sTorg_4G;
          l1 = sMaxTimeout_4G;
        }
        else if (1 == i)
        {
          l2 = sTbase_wifi;
          l3 = sTorg_wifi;
          l1 = sMaxTimeout_wifi;
        }
      }
      finally {}
      i = paramRequestDataTrans.timeOutCount;
      j = i;
      if (i >= TIME_OUT_DELTA.length) {
        j = TIME_OUT_DELTA.length - 1;
      }
      if (paramLong2 > 0L)
      {
        paramContext = paramRequestDataTrans.mInfo;
        if (paramContext == null) {
          break label496;
        }
        i = paramContext.length;
        if ((i <= 0) || (j < 0)) {
          break label488;
        }
        double d1 = i;
        double d2 = paramInt;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = paramLong2;
        Double.isNaN(d2);
        l4 = (d1 * d2);
        long l5 = TIME_OUT_DELTA[j];
        l4 = l2 + paramLong1 + l4 + l5;
      }
      else
      {
        if (j < 0) {
          break label496;
        }
        l4 = l2 + paramLong1 + l3 + TIME_OUT_DELTA[j];
        break label501;
      }
    }
    for (;;)
    {
      paramContext = new StringBuilder();
      paramContext.append("BdhSegTimeoutUtil.calculateTimeout:  req.hwSeq = ");
      paramContext.append(paramRequestDataTrans.getHwSeq());
      paramContext.append(" tBase = ");
      paramContext.append(l2);
      paramContext.append(" tOrg = ");
      paramContext.append(l3);
      paramContext.append(" tMaxTimeout = ");
      paramContext.append(l1);
      paramContext.append(" rtt = ");
      paramContext.append(paramLong1);
      paramContext.append(" lastSegSize = ");
      paramContext.append(paramInt);
      paramContext.append(" lastTimeCost = ");
      paramContext.append(paramLong2);
      paramContext.append(" segSize = ");
      paramContext.append(i);
      paramContext.append(" timeoutCount = ");
      paramContext.append(j);
      paramContext.append(" timeout = ");
      paramContext.append(l4);
      BdhLogUtil.LogEvent("R", paramContext.toString());
      if (l4 <= l1) {
        l1 = l4;
      }
      return l1;
      return -1L;
      break;
      label488:
      l4 = -1L;
      continue;
      label496:
      l4 = -1L;
      label501:
      i = 0;
    }
  }
  
  public static long getUrgentHbTimeout(Context paramContext)
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
      return l;
    }
    finally {}
  }
  
  public static void updateFromSrv(subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf paramDynTimeOutConf)
  {
    if (paramDynTimeOutConf == null) {
      return;
    }
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
      paramDynTimeOutConf = new StringBuilder();
      paramDynTimeOutConf.append("BdhSegTimeoutUtil.updateFromSrv:  sTbase_2G = ");
      paramDynTimeOutConf.append(sTbase_2G);
      paramDynTimeOutConf.append(" sTbase_3G = ");
      paramDynTimeOutConf.append(sTbase_3G);
      paramDynTimeOutConf.append(" sTbase_4G = ");
      paramDynTimeOutConf.append(sTbase_4G);
      paramDynTimeOutConf.append(" sTbase_wifi = ");
      paramDynTimeOutConf.append(sTbase_wifi);
      paramDynTimeOutConf.append(" sTorg_2G = ");
      paramDynTimeOutConf.append(sTorg_2G);
      paramDynTimeOutConf.append(" sTorg_3G = ");
      paramDynTimeOutConf.append(sTorg_3G);
      paramDynTimeOutConf.append(" sTorg_4G = ");
      paramDynTimeOutConf.append(sTorg_4G);
      paramDynTimeOutConf.append(" sTorg_wifi = ");
      paramDynTimeOutConf.append(sTorg_wifi);
      paramDynTimeOutConf.append(" sMaxTimeoutDef = ");
      paramDynTimeOutConf.append(sMaxTimeoutDef);
      paramDynTimeOutConf.append(" sMaxTimeout_2G = ");
      paramDynTimeOutConf.append(sMaxTimeout_2G);
      paramDynTimeOutConf.append(" sMaxTimeout_3G = ");
      paramDynTimeOutConf.append(sMaxTimeout_3G);
      paramDynTimeOutConf.append(" sMaxTimeout_4G = ");
      paramDynTimeOutConf.append(sMaxTimeout_4G);
      paramDynTimeOutConf.append(" sMaxTimeout_wifi = ");
      paramDynTimeOutConf.append(sMaxTimeout_wifi);
      paramDynTimeOutConf.append(" sEnableDynTimeout = ");
      paramDynTimeOutConf.append(sEnableDynTimeout);
      paramDynTimeOutConf.append(" sHbTimeoutDef = ");
      paramDynTimeOutConf.append(sHbTimeoutDef);
      paramDynTimeOutConf.append(" sHbTimeout_2G = ");
      paramDynTimeOutConf.append(sHbTimeout_2G);
      paramDynTimeOutConf.append(" sHbTimeout_3G = ");
      paramDynTimeOutConf.append(sHbTimeout_3G);
      paramDynTimeOutConf.append(" sHbTimeout_4G = ");
      paramDynTimeOutConf.append(sHbTimeout_4G);
      paramDynTimeOutConf.append(" sHbTimeout_wifi = ");
      paramDynTimeOutConf.append(sHbTimeout_wifi);
      BdhLogUtil.LogEvent("R", paramDynTimeOutConf.toString());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil
 * JD-Core Version:    0.7.0.1
 */