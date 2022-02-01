package com.tencent.mobileqq.kandian.glue.baseconfig;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.image.RIJImageOptConfig;
import com.tencent.mobileqq.kandian.base.image.imageloader.IRIJImageOptReport;
import com.tencent.mobileqq.kandian.glue.report.api.impl.RIJImageOptReportImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/baseconfig/RIJImageAladdinConfig;", "", "()V", "TAG", "", "updateConfig", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJImageAladdinConfig
{
  public static final RIJImageAladdinConfig a = new RIJImageAladdinConfig();
  private static final String b = "RIJImageOptConfig";
  
  public final void a()
  {
    int i = Aladdin.getConfig(293).getIntegerFromString("reportOn", 0);
    int j = Aladdin.getConfig(293).getIntegerFromString("lifoOn", 0);
    int k = Aladdin.getConfig(293).getIntegerFromString("renderFirst", 0);
    int m = Aladdin.getConfig(293).getIntegerFromString("decodeHttpStream", 0);
    int n = Aladdin.getConfig(293).getIntegerFromString("bitmapOpt", 0);
    long l = Aladdin.getConfig(293).getIntegerFromString("monitorTime", 10000);
    int i1 = Aladdin.getConfig(323).getIntegerFromString("image_flow_optimization_config", 0);
    int i2 = Aladdin.getConfig(323).getIntegerFromString("use_ip", 0);
    int i3 = Aladdin.getConfig(293).getIntegerFromString("use_kandian_ip_connect", 0);
    int i4 = Aladdin.getConfig(293).getIntegerFromString("rollback_to_domain_connect", 0);
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportOn:");
    localStringBuilder.append(i);
    localStringBuilder.append(", lifoOn:");
    localStringBuilder.append(j);
    localStringBuilder.append(", renderFirst:");
    localStringBuilder.append(k);
    localStringBuilder.append(", decodeHttpStream:");
    localStringBuilder.append(m);
    localStringBuilder.append(", bitmapOpt:");
    localStringBuilder.append(n);
    localStringBuilder.append(", monitorTime:");
    localStringBuilder.append(l);
    localStringBuilder.append(", fileTypeOpt:");
    localStringBuilder.append(i1);
    localStringBuilder.append(", use_ip:");
    localStringBuilder.append(i2);
    localStringBuilder.append(", use_ip_connect:");
    localStringBuilder.append(i3);
    localStringBuilder.append(", isRollbackToDomainConnect:");
    localStringBuilder.append(i4);
    QLog.d(str, 1, localStringBuilder.toString());
    RIJImageOptConfig.INSTANCE.setReportOn(i);
    RIJImageOptConfig.INSTANCE.setLifoOn(j);
    RIJImageOptConfig.INSTANCE.setRenderFirst(k);
    RIJImageOptConfig.INSTANCE.setDecodeHttpStream(m);
    RIJImageOptConfig.INSTANCE.setBitmapOpt(n);
    RIJImageOptConfig.INSTANCE.setMonitorTime(l);
    RIJImageOptConfig.INSTANCE.setFileTypeOpt(i1);
    RIJImageOptConfig.INSTANCE.setUseInnerDns(i2);
    RIJImageOptConfig.INSTANCE.setUseKanDianIpConnect(i3);
    RIJImageOptConfig.INSTANCE.setRollbackToDomainConnect(i4);
    com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport.h = (IRIJImageOptReport)RIJImageOptReportImpl.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.baseconfig.RIJImageAladdinConfig
 * JD-Core Version:    0.7.0.1
 */