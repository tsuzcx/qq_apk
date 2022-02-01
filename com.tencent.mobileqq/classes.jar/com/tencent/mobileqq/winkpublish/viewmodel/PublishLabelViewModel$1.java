package com.tencent.mobileqq.winkpublish.viewmodel;

import circlesearch.CircleSearchExhibition.StMoreDataRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;

class PublishLabelViewModel$1
  implements VSDispatchObserver.onVSRspCallBack<CircleSearchExhibition.StMoreDataRsp>
{
  PublishLabelViewModel$1(PublishLabelViewModel paramPublishLabelViewModel, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CircleSearchExhibition.StMoreDataRsp paramStMoreDataRsp)
  {
    String str = PublishLabelViewModel.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleGetAssociateTagRequest onReceive isSuccess:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.i(str, 1, localStringBuilder.toString());
    PublishLabelViewModel.a(this.b, paramBaseRequest, this.a, paramBoolean, paramLong, paramString, paramStMoreDataRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.viewmodel.PublishLabelViewModel.1
 * JD-Core Version:    0.7.0.1
 */