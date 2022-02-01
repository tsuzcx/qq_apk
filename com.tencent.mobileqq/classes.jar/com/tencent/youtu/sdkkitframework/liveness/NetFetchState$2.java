package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.LiveStyleAndroidData;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class NetFetchState$2
  implements YTAGReflectLiveCheckInterface.GetLiveStyleResult
{
  NetFetchState$2(NetFetchState paramNetFetchState) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    YtLogger.e(NetFetchState.access$800(), "network failed " + paramString1 + " fix " + paramString2);
    YtSDKStats.getInstance().reportError(paramInt, paramString1);
    YtFSM.getInstance().sendFSMEvent(new NetFetchState.2.2(this, paramInt, paramString1, paramString2));
  }
  
  public void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse)
  {
    paramLiveStyleResponse = new YtLivenessNetProtoHelper.GetLiveTypeReqData();
    paramLiveStyleResponse.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
    paramLiveStyleResponse.baseInfo.appId = NetFetchState.access$000(this.this$0);
    paramLiveStyleResponse.baseInfo.businessId = "wx_default";
    paramLiveStyleResponse.baseInfo.lux = paramYTLiveStyleReq.select_data.android_data.lux;
    paramLiveStyleResponse.reflectConfig = NetFetchState.access$100(this.this$0);
    paramLiveStyleResponse.controlConfig = NetFetchState.access$200(this.this$0);
    paramLiveStyleResponse.colorNum = NetFetchState.access$300(this.this$0);
    paramLiveStyleResponse = YtLivenessNetProtoHelper.makeGetLiveTypeReq(paramLiveStyleResponse);
    NetFetchState.access$400(this.this$0).put("select_data", paramYTLiveStyleReq.select_data);
    if (((!NetFetchState.access$500(this.this$0).isEmpty()) && (NetFetchState.access$600(this.this$0))) || (NetFetchState.access$700(this.this$0) == null))
    {
      YtLogger.i(NetFetchState.access$800(), "Use local data");
      NetFetchState.access$900(this.this$0).put("color_data", NetFetchState.access$500(this.this$0));
      NetFetchState.access$1100(this.this$0).put("action_data", NetFetchState.access$1000(this.this$0));
      YtLogger.d(NetFetchState.access$800(), "select data:" + NetFetchState.access$1200(this.this$0));
      if (NetFetchState.access$1200(this.this$0) != null) {}
      for (;;)
      {
        try
        {
          if (NetFetchState.access$1200(this.this$0).has("config")) {
            NetFetchState.access$1300(this.this$0).put("control_config", NetFetchState.access$1200(this.this$0).getString("config"));
          }
          if (NetFetchState.access$1200(this.this$0).has("reflect_param")) {
            NetFetchState.access$1400(this.this$0).put("extra_config", NetFetchState.access$1200(this.this$0).getString("reflect_param"));
          }
          if (NetFetchState.access$1200(this.this$0).has("change_point_num")) {
            NetFetchState.access$1500(this.this$0).put("cp_num", NetFetchState.access$1200(this.this$0).getString("change_point_num"));
          }
        }
        catch (JSONException paramYTLiveStyleReq)
        {
          paramYTLiveStyleReq = "Select data parse failed " + paramYTLiveStyleReq.getLocalizedMessage();
          YtLogger.e(NetFetchState.access$800(), paramYTLiveStyleReq);
          YtSDKStats.getInstance().reportInfo(paramYTLiveStyleReq);
          continue;
        }
        this.this$0.moveToNextState();
        return;
        YtLogger.e(NetFetchState.access$800(), "select data is null");
        YtSDKStats.getInstance().reportInfo("select data is null");
      }
    }
    YtLogger.i(NetFetchState.access$800(), "Use online data ---> on get config info: " + paramLiveStyleResponse);
    YtFSM.getInstance().sendNetworkRequest("net_fetch_data", NetFetchState.access$700(this.this$0), paramLiveStyleResponse, null, new NetFetchState.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.2
 * JD-Core Version:    0.7.0.1
 */