package com.tencent.mobileqq.qqlive.api.impl.room;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleReport;
import com.tencent.mobileqq.qqlive.callback.supervision.ReportCallback;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveCallbackObserver;
import com.tencent.protobuf.iliveReport.nano.ReportReq;

public class QQLiveModuleReportImpl
  extends IQQLiveBaseModule
  implements IQQLiveModuleReport
{
  private static final String REPORT_METHOD = "Report";
  private static final String SERVICE_CMD = "trpc.qlive.qlive_report.Report";
  
  public void destroy() {}
  
  public void report(long paramLong1, long paramLong2, long paramLong3, String paramString, ReportCallback paramReportCallback)
  {
    ReportReq localReportReq = new ReportReq();
    localReportReq.a = paramLong2;
    localReportReq.c = paramLong3;
    localReportReq.e = paramLong1;
    localReportReq.f = paramLong1;
    localReportReq.g = this.sdkImpl.getConfigModule().getConfigData().getLiveClientType();
    localReportReq.h = paramString;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.qlive_report.Report", "Report", MessageNano.toByteArray(localReportReq), new QQLiveCallbackObserver(new QQLiveModuleReportImpl.1(this, paramReportCallback)));
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.QQLiveModuleReportImpl
 * JD-Core Version:    0.7.0.1
 */