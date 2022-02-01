package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class NetFetchState$3$1
  implements YtSDKKitFramework.IYtSDKKitNetResponseParser
{
  NetFetchState$3$1(NetFetchState.3 param3) {}
  
  public void onNetworkResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    Object localObject2;
    if (paramException != null)
    {
      YtSDKStats.getInstance().reportError(2097153, paramException.getMessage());
      localObject2 = paramException.getLocalizedMessage();
      localObject1 = localObject2;
      if (paramHashMap != null)
      {
        localObject1 = localObject2;
        if (paramHashMap.containsKey("response")) {
          localObject1 = (String)paramHashMap.get("response");
        }
      }
      YtFSM.getInstance().sendFSMEvent(new NetFetchState.3.1.1(this, paramException, (String)localObject1));
      return;
    }
    paramException = NetFetchState.access$400();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("response : ");
    ((StringBuilder)localObject1).append((String)paramHashMap.get("response"));
    YtLogger.d(paramException, ((StringBuilder)localObject1).toString());
    int i = NetFetchState.access$1200(this.this$1.this$0);
    int j = 1;
    if ((i != 2) && (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE)) {
      try
      {
        paramException = new JSONObject((String)paramHashMap.get("response"));
        i = j;
        if (paramException.has("errorcode"))
        {
          i = j;
          if (paramException.getInt("errorcode") == 0)
          {
            localObject2 = paramException.getString("validate_data");
            i = j;
            if (localObject2 != null)
            {
              paramException = "";
              i = 0;
              if (i < ((String)localObject2).length())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramException);
                ((StringBuilder)localObject1).append(((String)localObject2).charAt(i));
                localObject1 = ((StringBuilder)localObject1).toString();
                paramException = (Exception)localObject1;
                if (i == ((String)localObject2).length() - 1) {
                  break label1023;
                }
                paramException = new StringBuilder();
                paramException.append((String)localObject1);
                paramException.append(",");
                paramException = paramException.toString();
                break label1023;
              }
              NetFetchState.access$1700(this.this$1.this$0).put("action_data", paramException);
              YtFSM.getInstance().sendFSMEvent(new NetFetchState.3.1.2(this, (String)localObject2));
              this.this$1.this$0.moveToNextState();
              i = 0;
            }
          }
        }
      }
      catch (Exception paramException)
      {
        localObject1 = NetFetchState.access$400();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("response 1 failed:");
        ((StringBuilder)localObject2).append(paramException.getLocalizedMessage());
        YtLogger.e((String)localObject1, ((StringBuilder)localObject2).toString());
      }
      catch (JSONException paramException)
      {
        localObject1 = NetFetchState.access$400();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parse response 1 json other object failed:");
        ((StringBuilder)localObject2).append(paramException.getLocalizedMessage());
        YtLogger.e((String)localObject1, ((StringBuilder)localObject2).toString());
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)paramHashMap.get("response"));
        i = -1;
        if (((JSONObject)localObject2).has("error_code")) {
          i = ((JSONObject)localObject2).getInt("error_code");
        } else if (((JSONObject)localObject2).has("errorcode")) {
          i = ((JSONObject)localObject2).getInt("errorcode");
        }
        if (i == 0)
        {
          boolean bool = ((JSONObject)localObject2).has("color_data");
          localObject1 = null;
          if (!bool) {
            break label1030;
          }
          paramException = ((JSONObject)localObject2).getString("color_data");
          if (((JSONObject)localObject2).has("action_data")) {
            localObject1 = ((JSONObject)localObject2).getString("action_data");
          }
          String str = NetFetchState.access$400();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("color_data : ");
          localStringBuilder.append(paramException);
          YtLogger.d(str, localStringBuilder.toString());
          NetFetchState.access$1800(this.this$1.this$0).put("color_data", paramException);
          NetFetchState.access$1900(this.this$1.this$0).put("action_data", localObject1);
          if (((JSONObject)localObject2).has("select_data"))
          {
            if (((JSONObject)localObject2).getJSONObject("select_data").has("config")) {
              NetFetchState.access$2000(this.this$1.this$0).put("control_config", ((JSONObject)localObject2).getJSONObject("select_data").getString("config"));
            }
            if (((JSONObject)localObject2).getJSONObject("select_data").has("reflect_param")) {
              NetFetchState.access$2100(this.this$1.this$0).put("extra_config", ((JSONObject)localObject2).getJSONObject("select_data").getString("reflect_param"));
            }
            if (((JSONObject)localObject2).getJSONObject("select_data").has("change_point_num")) {
              NetFetchState.access$2200(this.this$1.this$0).put("cp_num", ((JSONObject)localObject2).getJSONObject("select_data").getString("change_point_num"));
            }
          }
          else
          {
            YtLogger.e(NetFetchState.access$400(), "select_data not found or select_data.config not found");
          }
          if (((JSONObject)localObject2).has("video_config"))
          {
            paramException = ((JSONObject)localObject2).getJSONObject("video_config");
            if (paramException.has("video_bitrate")) {
              NetFetchState.access$2300(this.this$1.this$0).put("video_bitrate", Integer.valueOf(paramException.getInt("video_bitrate")));
            }
            if (paramException.has("video_framerate")) {
              NetFetchState.access$2400(this.this$1.this$0).put("video_framerate", Integer.valueOf(paramException.getInt("video_framerate")));
            }
            if (paramException.has("video_iframeinterval")) {
              NetFetchState.access$2500(this.this$1.this$0).put("video_iframeinterval", Integer.valueOf(paramException.getInt("video_iframeinterval")));
            }
          }
          this.this$1.this$0.moveToNextState();
        }
      }
      catch (JSONException paramException)
      {
        localObject1 = NetFetchState.access$400();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parse response json other object failed:");
        ((StringBuilder)localObject2).append(paramException.getLocalizedMessage());
        YtLogger.e((String)localObject1, ((StringBuilder)localObject2).toString());
      }
      i = 1;
      if (i != 0)
      {
        YtLogger.e(NetFetchState.access$400(), "parse response failed");
        paramException = YtSDKStats.getInstance();
        localObject1 = "server return failed";
        paramException.reportError(2097153, "server return failed");
        paramException = (Exception)localObject1;
        if (paramHashMap != null)
        {
          paramException = (Exception)localObject1;
          if (paramHashMap.containsKey("response")) {
            paramException = (String)paramHashMap.get("response");
          }
        }
        YtFSM.getInstance().sendFSMEvent(new NetFetchState.3.1.3(this, paramException));
      }
      return;
      label1023:
      i += 1;
      break;
      label1030:
      paramException = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.3.1
 * JD-Core Version:    0.7.0.1
 */