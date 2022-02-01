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
  private static final String TAG = "NetFetchState";
  private String actionSeqData = "";
  private String appId;
  private int backendProtoType = 0;
  private int changePointNum = 2;
  private String configUrl;
  private String controlConfig = "";
  private String extraConfig = "";
  private String localColorData = "";
  private boolean needLocalConfig = false;
  private JSONObject selectData = null;
  
  private void onReflectRequest()
  {
    YTAGReflectLiveCheckInterface.getLiveCheckType(YtFSM.getInstance().getContext().currentAppContext, new NetFetchState.3(this));
  }
  
  public void enter()
  {
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new NetFetchState.1(this));
    switch (NetFetchState.4.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      onReflectRequest();
    }
  }
  
  public void enterFirst() {}
  
  public void exit()
  {
    super.exit();
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    for (;;)
    {
      int i;
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
        if (paramJSONObject.has("action_default_seq"))
        {
          paramString = paramJSONObject.getJSONArray("action_default_seq");
          i = 0;
          if (i < paramString.length())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.actionSeqData);
            localStringBuilder.append(paramString.getString(i));
            this.actionSeqData = localStringBuilder.toString();
            if (i >= paramString.length() - 1) {
              break label382;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.actionSeqData);
            localStringBuilder.append(",");
            this.actionSeqData = localStringBuilder.toString();
            break label382;
          }
        }
        else
        {
          this.actionSeqData = "0";
        }
        if (paramJSONObject.has("extra_config")) {
          this.extraConfig = paramJSONObject.getString("extra_config");
        } else {
          this.extraConfig = " version 2";
        }
        if (paramJSONObject.has("control_config")) {
          this.controlConfig = paramJSONObject.getString("control_config");
        }
        if (paramJSONObject.has("change_point_num")) {
          this.changePointNum = paramJSONObject.getInt("change_point_num");
        }
        if (paramJSONObject.has("select_data")) {
          this.selectData = paramJSONObject.getJSONObject("select_data");
        }
        if (paramJSONObject.has("backend_proto_type")) {
          this.backendProtoType = paramJSONObject.getInt("backend_proto_type");
        }
        if (paramJSONObject.has("net_request_timeout_ms"))
        {
          YtSDKKitFramework.getInstance().setNetworkRequestTimeoutMS(paramJSONObject.getInt("net_request_timeout_ms"));
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramJSONObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to parse json:");
        localStringBuilder.append(paramString.getLocalizedMessage());
        YtLogger.e(paramJSONObject, localStringBuilder.toString());
      }
      return;
      label382:
      i += 1;
    }
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    int i = NetFetchState.4.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()];
    if ((i != 2) && (i != 3) && (i != 4) && (i != 5) && (i != 6))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msg_param_error current unknown work mode:");
      ((StringBuilder)localObject).append(YtFSM.getInstance().getWorkMode());
      localObject = ((StringBuilder)localObject).toString();
      YtSDKStats.getInstance().reportError(4194304, (String)localObject);
      YtFSM.getInstance().sendFSMEvent(new NetFetchState.2(this, (String)localObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState
 * JD-Core Version:    0.7.0.1
 */