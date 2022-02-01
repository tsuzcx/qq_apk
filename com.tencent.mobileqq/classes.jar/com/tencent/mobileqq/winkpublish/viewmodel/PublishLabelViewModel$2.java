package com.tencent.mobileqq.winkpublish.viewmodel;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudTagcategorysvr.StTagCategoryRecomRsp;

class PublishLabelViewModel$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudTagcategorysvr.StTagCategoryRecomRsp>
{
  PublishLabelViewModel$2(PublishLabelViewModel paramPublishLabelViewModel) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudTagcategorysvr.StTagCategoryRecomRsp paramStTagCategoryRecomRsp)
  {
    paramBaseRequest = PublishLabelViewModel.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleGetRecommendTagRequest onReceive isSuccess:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.i(paramBaseRequest, 1, localStringBuilder.toString());
    PublishLabelViewModel.a(this.a, paramBoolean, paramLong, paramString, paramStTagCategoryRecomRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.viewmodel.PublishLabelViewModel.2
 * JD-Core Version:    0.7.0.1
 */