package com.tencent.mobileqq.flashshow.preload;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.flashshow.api.bean.FSFolderBean;
import com.tencent.mobileqq.flashshow.helper.FSGpsHelper;
import com.tencent.mobileqq.flashshow.request.FSGetTabListRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

public class FSFolderPreLoaderTask
  extends BasePreLoadTask
{
  FeedCloudMeta.StGPSV2 a = FSGpsHelper.a().d();
  FSFolderBean b = new FSFolderBean(null);
  
  VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetBusiInfoRsp> a(OnPreLoadListener paramOnPreLoadListener)
  {
    return new FSFolderPreLoaderTask.1(this, paramOnPreLoadListener);
  }
  
  public void onRemove() {}
  
  public void startLoadData(OnPreLoadListener paramOnPreLoadListener)
  {
    FSGetTabListRequest localFSGetTabListRequest = new FSGetTabListRequest(this.a, this.b);
    paramOnPreLoadListener = a(paramOnPreLoadListener);
    VSNetworkHelper.getInstance().sendRequest(localFSGetTabListRequest, paramOnPreLoadListener);
    paramOnPreLoadListener = new StringBuilder();
    paramOnPreLoadListener.append("FSFolderPreLoaderTask->sendFSRequest: CmdName:");
    paramOnPreLoadListener.append(localFSGetTabListRequest.getCmdName());
    paramOnPreLoadListener.append("| TraceId:");
    paramOnPreLoadListener.append(localFSGetTabListRequest.getTraceId());
    paramOnPreLoadListener.append(" | SeqId:");
    paramOnPreLoadListener.append(localFSGetTabListRequest.getCurrentSeq());
    paramOnPreLoadListener.append(" | extInfo:");
    paramOnPreLoadListener.append(((FeedCloudCommon.Entry)localFSGetTabListRequest.mReq.extInfo.mapInfo.get(0)).key.get());
    paramOnPreLoadListener.append(": ");
    paramOnPreLoadListener.append(((FeedCloudCommon.Entry)localFSGetTabListRequest.mReq.extInfo.mapInfo.get(0)).value.get());
    QLog.d("FSFolderPreLoaderTask", 1, paramOnPreLoadListener.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.preload.FSFolderPreLoaderTask
 * JD-Core Version:    0.7.0.1
 */