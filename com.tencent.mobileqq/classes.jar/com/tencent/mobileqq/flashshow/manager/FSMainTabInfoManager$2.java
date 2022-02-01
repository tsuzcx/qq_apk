package com.tencent.mobileqq.flashshow.manager;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

class FSMainTabInfoManager$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetBusiInfoRsp>
{
  FSMainTabInfoManager$2(FSMainTabInfoManager paramFSMainTabInfoManager) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchNewDataNow requestTabData onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | isCache:");
    localStringBuilder.append(bool);
    QLog.d("FSMainTabInfoManager", 1, localStringBuilder.toString());
    this.a.a(paramBoolean, paramLong, paramString, paramStGetBusiInfoRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.manager.FSMainTabInfoManager.2
 * JD-Core Version:    0.7.0.1
 */