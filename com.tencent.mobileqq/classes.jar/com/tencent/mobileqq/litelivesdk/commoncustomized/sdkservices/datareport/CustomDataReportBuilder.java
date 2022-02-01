package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class CustomDataReportBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    CustomDataReportService localCustomDataReportService = new CustomDataReportService();
    localCustomDataReportService.init(new CustomDataReportBuilder.1(this, paramServiceAccessor));
    return localCustomDataReportService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportBuilder
 * JD-Core Version:    0.7.0.1
 */