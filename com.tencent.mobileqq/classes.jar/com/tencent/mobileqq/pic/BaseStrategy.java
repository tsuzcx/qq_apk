package com.tencent.mobileqq.pic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.pic.api.IPicPreDownload.ConfigInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class BaseStrategy
{
  public static BaseStrategy.TrafficStat a;
  public static boolean a = true;
  public static long c;
  protected long a;
  protected AppInterface a;
  protected long b;
  protected long d = 524288000L;
  protected long e = 31457280L;
  protected long f = 31457280L;
  protected long g = 31457280L;
  
  public static final void b()
  {
    c();
    jdField_a_of_type_ComTencentMobileqqPicBaseStrategy$TrafficStat.b();
  }
  
  public static final void c()
  {
    if (jdField_a_of_type_ComTencentMobileqqPicBaseStrategy$TrafficStat == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqPicBaseStrategy$TrafficStat == null) {
          jdField_a_of_type_ComTencentMobileqqPicBaseStrategy$TrafficStat = new BaseStrategy.TrafficStat();
        }
        return;
      }
      finally {}
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    d();
    paramBoolean = a();
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
        paramLong = this.jdField_a_of_type_Long;
        l = this.e;
        if (paramLong >= l)
        {
          PicReporter.a(paramInt2, l);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("result:true,netWokrType:");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(",picTrafficFlowXG:");
          localStringBuilder.append(this.jdField_a_of_type_Long);
          localStringBuilder.append(",PreDownMax4GFlow:");
          localStringBuilder.append(this.e);
          Logger.a("PIC_TAG_PRELOAD", "isOverLimit", localStringBuilder.toString());
          return -8;
        }
      }
      else if (paramInt2 == 2)
      {
        paramLong = this.jdField_a_of_type_Long;
        l = this.f;
        if (paramLong >= l)
        {
          PicReporter.a(paramInt2, l);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("result:true,netWokrType:");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(",picTrafficFlowXG:");
          localStringBuilder.append(this.jdField_a_of_type_Long);
          localStringBuilder.append(",PreDownMax3GFlow:");
          localStringBuilder.append(this.f);
          Logger.a("PIC_TAG_PRELOAD", "isOverLimit", localStringBuilder.toString());
          return -8;
        }
      }
      else if (paramInt2 == 3)
      {
        paramLong = this.jdField_a_of_type_Long;
        l = this.g;
        if (paramLong >= l)
        {
          PicReporter.a(paramInt2, l);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("result:true,netWokrType:");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(",picTrafficFlowXG:");
          localStringBuilder.append(this.jdField_a_of_type_Long);
          localStringBuilder.append(",PreDownMax2GFlow:");
          localStringBuilder.append(this.g);
          Logger.a("PIC_TAG_PRELOAD", "isOverLimit", localStringBuilder.toString());
          return -8;
        }
      }
    }
    else
    {
      paramLong = this.b;
      l = this.d;
      if (paramLong >= l)
      {
        PicReporter.a(paramInt2, l);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("result:true,netWokrType:");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(",picTrafficFlowWIFI:");
        localStringBuilder.append(this.b);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", localStringBuilder.toString());
        return -8;
      }
    }
    return 0;
  }
  
  public IPicPreDownload.ConfigInfo a()
  {
    return null;
  }
  
  public void a()
  {
    jdField_a_of_type_Boolean = PicPreDownloadUtils.a("PicPreDownSwitchNew", Boolean.valueOf(true)).booleanValue();
    c = PicPreDownloadUtils.a("PicAuDownTimePoint", 0L);
    this.d = PicPreDownloadUtils.a("MaxWifiFlow", 524288000L);
    this.e = PicPreDownloadUtils.a("Max4GFlow", 31457280L);
    this.f = PicPreDownloadUtils.a("Max3GFlow", 31457280L);
    this.g = PicPreDownloadUtils.a("Max2GFlow", 31457280L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initConfig(): PreDownUseLocalFlowSet=");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      localStringBuilder.append(" PicAuDownTimePoint=");
      localStringBuilder.append(c);
      localStringBuilder.append(" PreDownMaxWifiFlow=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" PreDownMax4GFlow=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" PreDownMax3GFlow=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" PreDownMax2GFlow=");
      localStringBuilder.append(this.g);
      QLog.d("PIC_TAG_PRELOAD.BaseStrategy", 2, localStringBuilder.toString());
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a();
  }
  
  public void a(IPicPreDownload.ConfigInfo paramConfigInfo) {}
  
  public boolean a()
  {
    return ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name());
  }
  
  public void d()
  {
    c();
    long[] arrayOfLong = jdField_a_of_type_ComTencentMobileqqPicBaseStrategy$TrafficStat.a();
    this.jdField_a_of_type_Long = (arrayOfLong[0] + arrayOfLong[1]);
    this.b = (arrayOfLong[2] + arrayOfLong[3]);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("picTrafficFlowXG:");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(",C2CPicDownFlowXG:");
      localStringBuilder.append(arrayOfLong[0]);
      localStringBuilder.append(",Group/DiscussPicDownFlowXG:");
      localStringBuilder.append(arrayOfLong[1]);
      localStringBuilder.append(",picTrafficFlowWIFI:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",C2CPicDownFlowWIFI:");
      localStringBuilder.append(arrayOfLong[2]);
      localStringBuilder.append(",Group/DiscussPicDownFlowWIFI:");
      localStringBuilder.append(arrayOfLong[3]);
      Logger.a("PIC_TAG_PRELOAD", "", "updateTrafficData ", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BaseStrategy
 * JD-Core Version:    0.7.0.1
 */