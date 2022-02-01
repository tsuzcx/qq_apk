package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;

class NetLivenessReqResultState$7
  implements YtSDKKitFramework.IYtSDKKitNetResponseParser
{
  NetLivenessReqResultState$7(NetLivenessReqResultState paramNetLivenessReqResultState) {}
  
  public void onNetworkResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    CommonUtils.benchMarkEnd("reflect_request_s2");
    CommonUtils.benchMarkBegin("reflect_request_s3");
    YtLogger.i(NetLivenessReqResultState.access$000(), "handle reflection response");
    NetLivenessReqResultState.access$100(this.this$0, paramHashMap, paramException);
    CommonUtils.benchMarkEnd("reflect_request_s3");
    NetLivenessReqResultState.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.7
 * JD-Core Version:    0.7.0.1
 */