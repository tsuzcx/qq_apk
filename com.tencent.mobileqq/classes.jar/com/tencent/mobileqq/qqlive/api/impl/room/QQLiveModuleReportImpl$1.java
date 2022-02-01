package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.callback.supervision.ReportCallback;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.protobuf.iliveReport.nano.ReportRsp;

class QQLiveModuleReportImpl$1
  extends BaseSsoCallback
{
  QQLiveModuleReportImpl$1(QQLiveModuleReportImpl paramQQLiveModuleReportImpl, ReportCallback paramReportCallback) {}
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    super.onBusinessFailed(paramInt, paramString);
    this.val$callback.onFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    paramQQLiveRspData = ReportRsp.a(paramQQLiveRspData.a());
    if (paramQQLiveRspData.a == 0)
    {
      this.val$callback.a();
      return;
    }
    this.val$callback.onFailed(paramQQLiveRspData.a, paramQQLiveRspData.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.QQLiveModuleReportImpl.1
 * JD-Core Version:    0.7.0.1
 */