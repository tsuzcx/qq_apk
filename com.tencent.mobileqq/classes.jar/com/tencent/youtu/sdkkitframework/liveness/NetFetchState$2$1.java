package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class NetFetchState$2$1
  implements YtSDKKitFramework.IYtSDKKitNetResponseParser
{
  NetFetchState$2$1(NetFetchState.2 param2) {}
  
  public void onNetworkResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    String str1;
    if (paramException != null)
    {
      YtSDKStats.getInstance().reportError(2097153, paramException.getMessage());
      String str2 = paramException.getLocalizedMessage();
      str1 = str2;
      if (paramHashMap != null)
      {
        str1 = str2;
        if (paramHashMap.containsKey("response")) {
          str1 = (String)paramHashMap.get("response");
        }
      }
      YtFSM.getInstance().sendFSMEvent(new NetFetchState.2.1.1(this, paramException, str1));
      return;
    }
    YtLogger.d(NetFetchState.access$800(), "response : " + (String)paramHashMap.get("response"));
    paramException = new LiveStyleResponse();
    paramException.parseResponse((String)paramHashMap.get("response"));
    int j = 1;
    int i = j;
    if (paramException.responseParsed != null)
    {
      i = j;
      if (paramException.responseParsed.errorcode == 0)
      {
        YtLogger.d(NetFetchState.access$800(), "color_data : " + paramException.responseParsed.color_data);
        NetFetchState.access$1600(this.this$1.this$0).put("color_data", paramException.responseParsed.color_data);
        NetFetchState.access$1700(this.this$1.this$0).put("action_data", paramException.responseParsed.action_data);
      }
    }
    for (;;)
    {
      try
      {
        paramException = new JSONObject((String)paramHashMap.get("response"));
        if (!paramException.has("select_data")) {
          continue;
        }
        if (paramException.getJSONObject("select_data").has("config")) {
          NetFetchState.access$1800(this.this$1.this$0).put("control_config", paramException.getJSONObject("select_data").getString("config"));
        }
        if (paramException.getJSONObject("select_data").has("reflect_param")) {
          NetFetchState.access$1900(this.this$1.this$0).put("extra_config", paramException.getJSONObject("select_data").getString("reflect_param"));
        }
        if (paramException.getJSONObject("select_data").has("change_point_num")) {
          NetFetchState.access$2000(this.this$1.this$0).put("cp_num", paramException.getJSONObject("select_data").getString("change_point_num"));
        }
        if (paramException.has("video_config"))
        {
          paramException = paramException.getJSONObject("video_config");
          if (paramException.has("video_bitrate")) {
            NetFetchState.access$2100(this.this$1.this$0).put("video_bitrate", Integer.valueOf(paramException.getInt("video_bitrate")));
          }
          if (paramException.has("video_framerate")) {
            NetFetchState.access$2200(this.this$1.this$0).put("video_framerate", Integer.valueOf(paramException.getInt("video_framerate")));
          }
          if (paramException.has("video_iframeinterval")) {
            NetFetchState.access$2300(this.this$1.this$0).put("video_iframeinterval", Integer.valueOf(paramException.getInt("video_iframeinterval")));
          }
        }
      }
      catch (JSONException paramException)
      {
        YtLogger.e(NetFetchState.access$800(), "parse response json other object failed:" + paramException.getLocalizedMessage());
        continue;
      }
      this.this$1.this$0.moveToNextState();
      i = 0;
      if (i == 0) {
        break;
      }
      YtLogger.e(NetFetchState.access$800(), "parse response failed");
      YtSDKStats.getInstance().reportError(2097153, "server return failed");
      str1 = "server return failed";
      paramException = str1;
      if (paramHashMap != null)
      {
        paramException = str1;
        if (paramHashMap.containsKey("response")) {
          paramException = (String)paramHashMap.get("response");
        }
      }
      YtFSM.getInstance().sendFSMEvent(new NetFetchState.2.1.2(this, paramException));
      return;
      YtLogger.e(NetFetchState.access$800(), "select_data not found or select_data.config not found");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.2.1
 * JD-Core Version:    0.7.0.1
 */