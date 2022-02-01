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
    int k = 0;
    Object localObject2;
    Object localObject1;
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
    YtLogger.d(NetFetchState.access$400(), "response : " + (String)paramHashMap.get("response"));
    int j = 1;
    if ((NetFetchState.access$1200(this.this$1.this$0) != 2) && (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE)) {}
    label929:
    label935:
    label940:
    label945:
    label950:
    label957:
    for (;;)
    {
      try
      {
        paramException = new JSONObject((String)paramHashMap.get("response"));
        if ((!paramException.has("errorcode")) || (paramException.getInt("errorcode") != 0)) {
          break label945;
        }
        localObject2 = paramException.getString("validate_data");
        if (localObject2 == null) {
          break label945;
        }
        paramException = "";
        i = 0;
        if (i < ((String)localObject2).length())
        {
          localObject1 = paramException + ((String)localObject2).charAt(i);
          paramException = (Exception)localObject1;
          if (i == ((String)localObject2).length() - 1) {
            break label950;
          }
          paramException = (String)localObject1 + ",";
          break label950;
        }
        NetFetchState.access$1700(this.this$1.this$0).put("action_data", paramException);
        YtFSM.getInstance().sendFSMEvent(new NetFetchState.3.1.2(this, (String)localObject2));
        this.this$1.this$0.moveToNextState();
        i = 0;
      }
      catch (JSONException paramException)
      {
        YtLogger.e(NetFetchState.access$400(), "parse response 1 json other object failed:" + paramException.getLocalizedMessage());
        i = j;
        continue;
      }
      catch (Exception paramException)
      {
        YtLogger.e(NetFetchState.access$400(), "response 1 failed:" + paramException.getLocalizedMessage());
        i = j;
        continue;
      }
      if (i == 0) {
        break;
      }
      YtLogger.e(NetFetchState.access$400(), "parse response failed");
      YtSDKStats.getInstance().reportError(2097153, "server return failed");
      localObject1 = "server return failed";
      paramException = (Exception)localObject1;
      if (paramHashMap != null)
      {
        paramException = (Exception)localObject1;
        if (paramHashMap.containsKey("response")) {
          paramException = (String)paramHashMap.get("response");
        }
      }
      YtFSM.getInstance().sendFSMEvent(new NetFetchState.3.1.3(this, paramException));
      return;
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject((String)paramHashMap.get("response"));
          i = -1;
          if (((JSONObject)localObject2).has("error_code"))
          {
            i = ((JSONObject)localObject2).getInt("error_code");
            if (i != 0) {
              break label940;
            }
            if (!((JSONObject)localObject2).has("color_data")) {
              break label935;
            }
            paramException = ((JSONObject)localObject2).getString("color_data");
            if (!((JSONObject)localObject2).has("action_data")) {
              break label929;
            }
            localObject1 = ((JSONObject)localObject2).getString("action_data");
            YtLogger.d(NetFetchState.access$400(), "color_data : " + paramException);
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
              i = k;
              break label957;
            }
          }
          else
          {
            if (!((JSONObject)localObject2).has("errorcode")) {
              continue;
            }
            i = ((JSONObject)localObject2).getInt("errorcode");
            continue;
          }
          YtLogger.e(NetFetchState.access$400(), "select_data not found or select_data.config not found");
          continue;
        }
        catch (JSONException paramException)
        {
          YtLogger.e(NetFetchState.access$400(), "parse response json other object failed:" + paramException.getLocalizedMessage());
          i = j;
        }
        localObject1 = null;
        continue;
        paramException = null;
      }
      int i = 1;
      break label957;
      i = 1;
      continue;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.3.1
 * JD-Core Version:    0.7.0.1
 */