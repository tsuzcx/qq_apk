package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class NetFetchState
  extends YtFSMBaseState
{
  private static final String TAG = NetFetchState.class.getSimpleName();
  private String actionSeqData = "0";
  private String appId;
  private String configUrl;
  private String localColorData = "";
  private boolean needLocalConfig = false;
  
  private void onReflectRequest()
  {
    YTAGReflectLiveCheckInterface.getLiveCheckType(YtFSM.getInstance().getContext().currentAppContex, new NetFetchState.2(this));
  }
  
  public void enter()
  {
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new NetFetchState.1(this));
    switch (NetFetchState.3.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
    {
    case 1: 
    case 2: 
    case 3: 
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
    try
    {
      this.appId = paramJSONObject.getString("app_id");
      this.configUrl = paramJSONObject.getString("config_api_url");
      if (paramJSONObject.has("color_data")) {
        this.localColorData = paramJSONObject.getString("color_data");
      }
      if (paramJSONObject.has("local_config_flag")) {
        this.needLocalConfig = paramJSONObject.getBoolean("local_config_flag");
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
    }
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    switch (NetFetchState.3.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
    {
    case 1: 
    case 2: 
    case 3: 
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState
 * JD-Core Version:    0.7.0.1
 */