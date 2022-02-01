package com.tencent.richframework.common.part;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleConfig.GetRainbowKVConfRsp;

class RFWChangeMsfServerPart$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleConfig.GetRainbowKVConfRsp>
{
  RFWChangeMsfServerPart$2(RFWChangeMsfServerPart paramRFWChangeMsfServerPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleConfig.GetRainbowKVConfRsp paramGetRainbowKVConfRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("GetRainbowKVConfRsp isSuccess：");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(" errormsg:");
    paramBaseRequest.append(paramString);
    paramBaseRequest.append(" retCode:");
    paramBaseRequest.append(paramLong);
    QLog.i("QCircleChangeMsfServerPart", 1, paramBaseRequest.toString());
    RFWChangeMsfServerPart.a(this.a, paramBoolean, paramGetRainbowKVConfRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.common.part.RFWChangeMsfServerPart.2
 * JD-Core Version:    0.7.0.1
 */