package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;

class NetLivenessReqResultState$11
  implements YtSDKKitFramework.IYtSDKKitNetResponseParser
{
  NetLivenessReqResultState$11(NetLivenessReqResultState paramNetLivenessReqResultState) {}
  
  public void onNetworkResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    NetLivenessReqResultState.access$100(this.this$0, paramHashMap, paramException);
    NetLivenessReqResultState.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.11
 * JD-Core Version:    0.7.0.1
 */