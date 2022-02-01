package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.LiveStyleAndroidData;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class NetFetchState$3
  implements YTAGReflectLiveCheckInterface.GetLiveStyleResult
{
  NetFetchState$3(NetFetchState paramNetFetchState) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    String str = NetFetchState.access$400();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("network failed ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" fix ");
    localStringBuilder.append(paramString2);
    YtLogger.e(str, localStringBuilder.toString());
    YtSDKStats.getInstance().reportError(paramInt, paramString1);
    YtFSM.getInstance().sendFSMEvent(new NetFetchState.3.2(this, paramInt, paramString1, paramString2));
  }
  
  public void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse)
  {
    NetFetchState.access$000(this.this$0).put("select_data", paramYTLiveStyleReq.select_data);
    if (((!NetFetchState.access$100(this.this$0).isEmpty()) && (NetFetchState.access$200(this.this$0))) || (NetFetchState.access$300(this.this$0) == null))
    {
      YtLogger.i(NetFetchState.access$400(), "Use local data");
      NetFetchState.access$500(this.this$0).put("color_data", NetFetchState.access$100(this.this$0));
      NetFetchState.access$700(this.this$0).put("action_data", NetFetchState.access$600(this.this$0));
      paramYTLiveStyleReq = NetFetchState.access$400();
      paramLiveStyleResponse = new StringBuilder();
      paramLiveStyleResponse.append("select data:");
      paramLiveStyleResponse.append(NetFetchState.access$800(this.this$0));
      YtLogger.d(paramYTLiveStyleReq, paramLiveStyleResponse.toString());
      if (NetFetchState.access$800(this.this$0) != null)
      {
        try
        {
          if (NetFetchState.access$800(this.this$0).has("config")) {
            NetFetchState.access$900(this.this$0).put("control_config", NetFetchState.access$800(this.this$0).getString("config"));
          }
          if (NetFetchState.access$800(this.this$0).has("reflect_param")) {
            NetFetchState.access$1000(this.this$0).put("extra_config", NetFetchState.access$800(this.this$0).getString("reflect_param"));
          }
          if (!NetFetchState.access$800(this.this$0).has("change_point_num")) {
            break label333;
          }
          NetFetchState.access$1100(this.this$0).put("cp_num", NetFetchState.access$800(this.this$0).getString("change_point_num"));
        }
        catch (JSONException paramYTLiveStyleReq)
        {
          paramLiveStyleResponse = new StringBuilder();
          paramLiveStyleResponse.append("Select data parse failed ");
          paramLiveStyleResponse.append(paramYTLiveStyleReq.getLocalizedMessage());
          paramYTLiveStyleReq = paramLiveStyleResponse.toString();
          YtLogger.e(NetFetchState.access$400(), paramYTLiveStyleReq);
          YtSDKStats.getInstance().reportInfo(paramYTLiveStyleReq);
        }
      }
      else
      {
        YtLogger.e(NetFetchState.access$400(), "select data is null");
        YtSDKStats.getInstance().reportInfo("select data is null");
      }
      label333:
      this.this$0.moveToNextState();
      return;
    }
    if ((NetFetchState.access$1200(this.this$0) != 2) && (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE))
    {
      paramYTLiveStyleReq = new YtLivenessNetProtoHelper.GetFourLiveTypeReqData();
      paramYTLiveStyleReq.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
      paramYTLiveStyleReq.baseInfo.appId = NetFetchState.access$1300(this.this$0);
      paramYTLiveStyleReq = YtLivenessNetProtoHelper.makeGetFourLiveReq(paramYTLiveStyleReq);
    }
    else
    {
      paramLiveStyleResponse = new YtLivenessNetProtoHelper.GetLiveTypeReqData();
      paramLiveStyleResponse.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
      paramLiveStyleResponse.baseInfo.appId = NetFetchState.access$1300(this.this$0);
      paramLiveStyleResponse.baseInfo.businessId = "wx_default";
      paramLiveStyleResponse.baseInfo.lux = paramYTLiveStyleReq.select_data.android_data.lux;
      paramLiveStyleResponse.reflectConfig = NetFetchState.access$1400(this.this$0);
      paramLiveStyleResponse.controlConfig = NetFetchState.access$1500(this.this$0);
      paramLiveStyleResponse.colorNum = NetFetchState.access$1600(this.this$0);
      paramYTLiveStyleReq = YtLivenessNetProtoHelper.makeGetLiveTypeReq(paramLiveStyleResponse);
    }
    paramLiveStyleResponse = NetFetchState.access$400();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Use online data ---> on get config info: ");
    localStringBuilder.append(paramYTLiveStyleReq);
    YtLogger.i(paramLiveStyleResponse, localStringBuilder.toString());
    YtFSM.getInstance().sendNetworkRequest("net_fetch_data", NetFetchState.access$300(this.this$0), paramYTLiveStyleReq, null, new NetFetchState.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.3
 * JD-Core Version:    0.7.0.1
 */