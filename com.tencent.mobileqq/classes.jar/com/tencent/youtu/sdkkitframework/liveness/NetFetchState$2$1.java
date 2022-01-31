package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import java.util.HashMap;

class NetFetchState$2$1
  implements YtSDKKitFramework.IYtSDKKitNetResponseParser
{
  NetFetchState$2$1(NetFetchState.2 param2) {}
  
  public void onNetworkResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    if (paramException != null) {
      YtFSM.getInstance().sendFSMEvent(new NetFetchState.2.1.1(this, paramException));
    }
    int i;
    do
    {
      return;
      paramException = new LiveStyleResponse();
      paramException.parseResponse((String)paramHashMap.get("response"));
      int j = 1;
      i = j;
      if (paramException.responseParsed != null)
      {
        i = j;
        if (paramException.responseParsed.errorcode == 0)
        {
          YtLogger.d(NetFetchState.access$300(), "color_data : " + paramException.responseParsed.color_data);
          NetFetchState.access$700(this.this$1.this$0).put("color_data", paramException.responseParsed.color_data);
          NetFetchState.access$800(this.this$1.this$0).put("action_data", paramException.responseParsed.action_data);
          this.this$1.this$0.moveToNextState();
          i = 0;
        }
      }
    } while (i == 0);
    YtFSM.getInstance().sendFSMEvent(new NetFetchState.2.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.2.1
 * JD-Core Version:    0.7.0.1
 */