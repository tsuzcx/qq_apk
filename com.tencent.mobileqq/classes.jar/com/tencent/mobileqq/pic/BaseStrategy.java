package com.tencent.mobileqq.pic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.pic.api.IPicPreDownload.ConfigInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class BaseStrategy
{
  public static boolean d = true;
  public static long e;
  public static BaseStrategy.TrafficStat j;
  protected AppInterface a;
  protected long b;
  protected long c;
  protected long f = 524288000L;
  protected long g = 31457280L;
  protected long h = 31457280L;
  protected long i = 31457280L;
  
  public static final void c()
  {
    d();
    j.b();
  }
  
  public static final void d()
  {
    if (j == null) {
      try
      {
        if (j == null) {
          j = new BaseStrategy.TrafficStat();
        }
        return;
      }
      finally {}
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    e();
    paramBoolean = b();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isInDPCWhiteList:");
      localStringBuilder.append(paramBoolean);
      Logger.a("PIC_TAG_PRELOAD", "isOverLimit", localStringBuilder.toString());
    }
    long l;
    if ((paramInt2 != 0) && ((!paramBoolean) || (paramInt2 == 3)))
    {
      if (paramInt2 == 1)
      {
        paramLong = this.b;
        l = this.g;
        if (paramLong >= l)
        {
          PicReporter.a(paramInt2, l);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("result:true,netWokrType:");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(",picTrafficFlowXG:");
          localStringBuilder.append(this.b);
          localStringBuilder.append(",PreDownMax4GFlow:");
          localStringBuilder.append(this.g);
          Logger.a("PIC_TAG_PRELOAD", "isOverLimit", localStringBuilder.toString());
          return -8;
        }
      }
      else if (paramInt2 == 2)
      {
        paramLong = this.b;
        l = this.h;
        if (paramLong >= l)
        {
          PicReporter.a(paramInt2, l);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("result:true,netWokrType:");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(",picTrafficFlowXG:");
          localStringBuilder.append(this.b);
          localStringBuilder.append(",PreDownMax3GFlow:");
          localStringBuilder.append(this.h);
          Logger.a("PIC_TAG_PRELOAD", "isOverLimit", localStringBuilder.toString());
          return -8;
        }
      }
      else if (paramInt2 == 3)
      {
        paramLong = this.b;
        l = this.i;
        if (paramLong >= l)
        {
          PicReporter.a(paramInt2, l);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("result:true,netWokrType:");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(",picTrafficFlowXG:");
          localStringBuilder.append(this.b);
          localStringBuilder.append(",PreDownMax2GFlow:");
          localStringBuilder.append(this.i);
          Logger.a("PIC_TAG_PRELOAD", "isOverLimit", localStringBuilder.toString());
          return -8;
        }
      }
    }
    else
    {
      paramLong = this.c;
      l = this.f;
      if (paramLong >= l)
      {
        PicReporter.a(paramInt2, l);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("result:true,netWokrType:");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(",picTrafficFlowWIFI:");
        localStringBuilder.append(this.c);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", localStringBuilder.toString());
        return -8;
      }
    }
    return 0;
  }
  
  public void a()
  {
    d = PicPreDownloadUtils.a("PicPreDownSwitchNew", Boolean.valueOf(true)).booleanValue();
    e = PicPreDownloadUtils.b("PicAuDownTimePoint", 0L);
    this.f = PicPreDownloadUtils.b("MaxWifiFlow", 524288000L);
    this.g = PicPreDownloadUtils.b("Max4GFlow", 31457280L);
    this.h = PicPreDownloadUtils.b("Max3GFlow", 31457280L);
    this.i = PicPreDownloadUtils.b("Max2GFlow", 31457280L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initConfig(): PreDownUseLocalFlowSet=");
      localStringBuilder.append(d);
      localStringBuilder.append(" PicAuDownTimePoint=");
      localStringBuilder.append(e);
      localStringBuilder.append(" PreDownMaxWifiFlow=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" PreDownMax4GFlow=");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" PreDownMax3GFlow=");
      localStringBuilder.append(this.h);
      localStringBuilder.append(" PreDownMax2GFlow=");
      localStringBuilder.append(this.i);
      QLog.d("PIC_TAG_PRELOAD.BaseStrategy", 2, localStringBuilder.toString());
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    a();
  }
  
  public void a(IPicPreDownload.ConfigInfo paramConfigInfo) {}
  
  public boolean b()
  {
    return ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name());
  }
  
  public void e()
  {
    d();
    long[] arrayOfLong = j.c();
    this.b = (arrayOfLong[0] + arrayOfLong[1]);
    this.c = (arrayOfLong[2] + arrayOfLong[3]);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("picTrafficFlowXG:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",C2CPicDownFlowXG:");
      localStringBuilder.append(arrayOfLong[0]);
      localStringBuilder.append(",Group/DiscussPicDownFlowXG:");
      localStringBuilder.append(arrayOfLong[1]);
      localStringBuilder.append(",picTrafficFlowWIFI:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(",C2CPicDownFlowWIFI:");
      localStringBuilder.append(arrayOfLong[2]);
      localStringBuilder.append(",Group/DiscussPicDownFlowWIFI:");
      localStringBuilder.append(arrayOfLong[3]);
      Logger.a("PIC_TAG_PRELOAD", "", "updateTrafficData ", localStringBuilder.toString());
    }
  }
  
  public IPicPreDownload.ConfigInfo f()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BaseStrategy
 * JD-Core Version:    0.7.0.1
 */