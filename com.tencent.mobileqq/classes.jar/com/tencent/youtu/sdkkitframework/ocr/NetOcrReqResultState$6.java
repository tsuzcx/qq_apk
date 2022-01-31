package com.tencent.youtu.sdkkitframework.ocr;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class NetOcrReqResultState$6
  implements YtSDKKitFramework.IYtSDKKitNetResponseParser
{
  NetOcrReqResultState$6(NetOcrReqResultState paramNetOcrReqResultState) {}
  
  public void onNetworkResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    YtLogger.d(NetOcrReqResultState.access$000(), "Parse ocr response");
    if (paramException != null)
    {
      YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.6.1(this, paramException));
      return;
    }
    int i;
    try
    {
      paramException = new JSONObject((String)paramHashMap.get("response"));
      i = paramException.getInt("errorcode");
      if (i == 0)
      {
        YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.6.2(this, paramHashMap));
        return;
      }
    }
    catch (JSONException paramHashMap)
    {
      YtLogger.e(NetOcrReqResultState.access$000(), "json parse error " + paramHashMap.getLocalizedMessage());
      return;
    }
    YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.6.3(this, i, paramException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState.6
 * JD-Core Version:    0.7.0.1
 */