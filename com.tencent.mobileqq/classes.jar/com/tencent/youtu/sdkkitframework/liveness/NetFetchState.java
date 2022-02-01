package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetFetchState
  extends YtFSMBaseState
{
  private static final String TAG = NetFetchState.class.getSimpleName();
  private String actionSeqData = "";
  private String appId;
  private int changePointNum = 2;
  private String configUrl;
  private String controlConfig = "";
  private String extraConfig = "";
  private String localColorData = "";
  private boolean needLocalConfig = false;
  private JSONObject selectData = null;
  
  private void onReflectRequest()
  {
    YTAGReflectLiveCheckInterface.getLiveCheckType(YtFSM.getInstance().getContext().currentAppContext, new NetFetchState.2(this));
  }
  
  public void enter()
  {
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new NetFetchState.1(this));
    switch (NetFetchState.3.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
    {
    case 1: 
    default: 
      return;
    }
    onReflectRequest();
  }
  
  public void enterFirst() {}
  
  public void exit()
  {
    super.exit();
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    label331:
    for (;;)
    {
      try
      {
        this.appId = paramJSONObject.getString("app_id");
        if (this.appId == null) {
          YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
        }
        if (paramJSONObject.has("config_api_url")) {
          this.configUrl = paramJSONObject.getString("config_api_url");
        }
        if (paramJSONObject.has("color_data")) {
          this.localColorData = paramJSONObject.getString("color_data");
        }
        if (paramJSONObject.has("local_config_flag")) {
          this.needLocalConfig = paramJSONObject.getBoolean("local_config_flag");
        }
        int i;
        if (paramJSONObject.has("action_default_seq"))
        {
          paramString = paramJSONObject.getJSONArray("action_default_seq");
          i = 0;
          if (i < paramString.length())
          {
            this.actionSeqData += paramString.getString(i);
            if (i >= paramString.length() - 1) {
              break label331;
            }
            this.actionSeqData += ",";
            break label331;
          }
        }
        else
        {
          this.actionSeqData = "0";
        }
        if (paramJSONObject.has("extra_config"))
        {
          this.extraConfig = paramJSONObject.getString("extra_config");
          if (paramJSONObject.has("control_config")) {
            this.controlConfig = paramJSONObject.getString("control_config");
          }
          if (paramJSONObject.has("change_point_num")) {
            this.changePointNum = paramJSONObject.getInt("change_point_num");
          }
          if (paramJSONObject.has("select_data")) {
            this.selectData = paramJSONObject.getJSONObject("select_data");
          }
          if (!paramJSONObject.has("net_request_timeout_ms")) {
            break;
          }
          YtSDKKitFramework.getInstance().setNetworkRequestTimeoutMS(paramJSONObject.getInt("net_request_timeout_ms"));
          return;
        }
        this.extraConfig = " version 2";
        continue;
        i += 1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        return;
      }
    }
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    switch (NetFetchState.3.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
    {
    case 1: 
    default: 
      return;
    }
    YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
  }
  
  public void reset()
  {
    super.reset();
  }
  
  public void unload()
  {
    super.unload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState
 * JD-Core Version:    0.7.0.1
 */