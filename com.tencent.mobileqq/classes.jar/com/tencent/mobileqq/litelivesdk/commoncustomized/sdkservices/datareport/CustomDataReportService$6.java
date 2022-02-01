package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;

class CustomDataReportService$6
  implements IAsyncQimeiListener
{
  CustomDataReportService$6(CustomDataReportService paramCustomDataReportService) {}
  
  public void onQimeiDispatch(Qimei paramQimei)
  {
    paramQimei = paramQimei.getQimeiOld();
    LogInterface localLogInterface = this.a.a.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate end sync get qImei=");
    localStringBuilder.append(paramQimei);
    localLogInterface.i("DataReportService", localStringBuilder.toString(), new Object[0]);
    this.a.a.onGetBeaconImei(paramQimei);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportService.6
 * JD-Core Version:    0.7.0.1
 */