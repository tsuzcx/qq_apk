package com.tencent.mobileqq.flashshow.list.presenter;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StClearRedPointRsp;

class FSBaseMessagePresenter$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StClearRedPointRsp>
{
  FSBaseMessagePresenter$1(FSBaseMessagePresenter paramFSBaseMessagePresenter, FSBaseRequest paramFSBaseRequest) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StClearRedPointRsp paramStClearRedPointRsp)
  {
    paramBaseRequest = this.b.f();
    paramStClearRedPointRsp = new StringBuilder();
    paramStClearRedPointRsp.append("traceId:");
    paramStClearRedPointRsp.append(this.a.getTraceId());
    paramStClearRedPointRsp.append(" isSuccess:");
    paramStClearRedPointRsp.append(paramBoolean);
    paramStClearRedPointRsp.append(" errorCode");
    paramStClearRedPointRsp.append(paramLong);
    paramStClearRedPointRsp.append(" err:");
    paramStClearRedPointRsp.append(paramString);
    QLog.i(paramBaseRequest, 1, paramStClearRedPointRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSBaseMessagePresenter.1
 * JD-Core Version:    0.7.0.1
 */