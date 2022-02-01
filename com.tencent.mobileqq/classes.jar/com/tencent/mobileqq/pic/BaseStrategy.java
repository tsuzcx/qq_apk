package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class BaseStrategy
{
  public static BaseStrategy.TrafficStat a;
  public static boolean a;
  public static long c;
  protected long a;
  protected QQAppInterface a;
  protected long b;
  protected long d = 524288000L;
  protected long e = 31457280L;
  protected long f = 31457280L;
  protected long g = 31457280L;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    c = 0L;
    jdField_a_of_type_ComTencentMobileqqPicBaseStrategy$TrafficStat = null;
  }
  
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
    if (QLog.isColorLevel()) {
      Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "isInDPCWhiteList:" + paramBoolean);
    }
    if ((paramInt2 == 0) || ((paramBoolean) && (paramInt2 != 3)))
    {
      if (this.b >= this.d)
      {
        PicReporter.a(paramInt2, this.d);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowWIFI:" + this.b);
        return -8;
      }
    }
    else if (paramInt2 == 1)
    {
      if (this.jdField_a_of_type_Long >= this.e)
      {
        PicReporter.a(paramInt2, this.e);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long + ",PreDownMax4GFlow:" + this.e);
        return -8;
      }
    }
    else if (paramInt2 == 2)
    {
      if (this.jdField_a_of_type_Long >= this.f)
      {
        PicReporter.a(paramInt2, this.f);
        Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long + ",PreDownMax3GFlow:" + this.f);
        return -8;
      }
    }
    else if ((paramInt2 == 3) && (this.jdField_a_of_type_Long >= this.g))
    {
      PicReporter.a(paramInt2, this.g);
      Logger.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long + ",PreDownMax2GFlow:" + this.g);
      return -8;
    }
    return 0;
  }
  
  public void a()
  {
    jdField_a_of_type_Boolean = PicPreDownloadUtils.a("PicPreDownSwitchNew", Boolean.valueOf(true)).booleanValue();
    c = PicPreDownloadUtils.a("PicAuDownTimePoint", 0L);
    this.d = PicPreDownloadUtils.a("MaxWifiFlow", 524288000L);
    this.e = PicPreDownloadUtils.a("Max4GFlow", 31457280L);
    this.f = PicPreDownloadUtils.a("Max3GFlow", 31457280L);
    this.g = PicPreDownloadUtils.a("Max2GFlow", 31457280L);
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.BaseStrategy", 2, "initConfig(): PreDownUseLocalFlowSet=" + jdField_a_of_type_Boolean + " PicAuDownTimePoint=" + c + " PreDownMaxWifiFlow=" + this.d + " PreDownMax4GFlow=" + this.e + " PreDownMax3GFlow=" + this.f + " PreDownMax2GFlow=" + this.g);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
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
    if (QLog.isColorLevel()) {
      Logger.a("PIC_TAG_PRELOAD", "", "updateTrafficData ", "picTrafficFlowXG:" + this.jdField_a_of_type_Long + ",C2CPicDownFlowXG:" + arrayOfLong[0] + ",Group/DiscussPicDownFlowXG:" + arrayOfLong[1] + ",picTrafficFlowWIFI:" + this.b + ",C2CPicDownFlowWIFI:" + arrayOfLong[2] + ",Group/DiscussPicDownFlowWIFI:" + arrayOfLong[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BaseStrategy
 * JD-Core Version:    0.7.0.1
 */