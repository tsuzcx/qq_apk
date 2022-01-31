package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectSettings;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtu.ytcommon.tools.YTUtils;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import org.json.JSONException;
import org.json.JSONObject;

public class ReflectLivenessState
  extends YtFSMBaseState
{
  private static final String TAG = ReflectLivenessState.class.getSimpleName();
  private YTActRefData actRefData;
  private String appId;
  private String colorData;
  private int continuousDetectCount = 0;
  private ReflectLivenessState.ReflectProcessType currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_INIT;
  private YTFaceTrack.FaceStatus[] faceStatus;
  private boolean isLoadResourceOnline = false;
  private boolean needCheckFaces = true;
  private boolean needLocalConfig = false;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
  private SilentLivenessState.FacePreviewingAdvise poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
  private int securityLevel = 2;
  private LiveStyleRequester.SeleceData seleceData;
  private int simiThreshold = 70;
  
  private static Bitmap imageScale(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  private void setupRequset()
  {
    
    if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE)
    {
      YTAGReflectLiveCheckInterface.setUploadVideoRequesterV3(new ReflectLivenessState.8(this));
      return;
    }
    YTAGReflectLiveCheckInterface.setUploadVideoRequesterV2(new ReflectLivenessState.9(this));
  }
  
  private void startReflect()
  {
    boolean bool = false;
    YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.5(this));
    this.currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_REFLECT;
    YTAGReflectLiveCheckInterface.setRGBConfigRequest(new ReflectLivenessState.6(this));
    setupRequset();
    Object localObject = YTAGReflectLiveCheckInterface.getAGSettings();
    ((YTAGReflectSettings)localObject).safetylevel = this.securityLevel;
    ((YTAGReflectSettings)localObject).isEncodeReflectData = false;
    if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
      bool = true;
    }
    ((YTAGReflectSettings)localObject).isActionReflect = bool;
    YTAGReflectLiveCheckInterface.setAGSettings((YTAGReflectSettings)localObject);
    YtLogger.i(TAG, "Settings: safetyLevel " + ((YTAGReflectSettings)localObject).safetylevel);
    YtLogger.i(TAG, "Settings: isEncodeReflectData " + ((YTAGReflectSettings)localObject).isEncodeReflectData);
    YtLogger.i(TAG, "Settings: isActionReflect " + ((YTAGReflectSettings)localObject).isActionReflect);
    localObject = YtFSM.getInstance().getContext();
    YTAGReflectLiveCheckInterface.start(((YtSDKKitFramework.YtSDKPlatformContex)localObject).currentAppContex, ((YtSDKKitFramework.YtSDKPlatformContex)localObject).currentCamera, ((YtSDKKitFramework.YtSDKPlatformContex)localObject).currentCameraId, (YTReflectLayout)((YtSDKKitFramework.YtSDKPlatformContex)localObject).reflectLayout, new ReflectLivenessState.7(this));
  }
  
  public void enter()
  {
    super.enter();
    YtFSMBaseState localYtFSMBaseState = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
    try
    {
      this.poseState = ((SilentLivenessState.FacePreviewingAdvise)localYtFSMBaseState.getStateDataBy("pose_state"));
      this.continuousDetectCount = ((Integer)localYtFSMBaseState.getStateDataBy("continuous_detect_count")).intValue();
      this.faceStatus = ((YTFaceTrack.FaceStatus[])localYtFSMBaseState.getStateDataBy("face_status"));
      localYtFSMBaseState = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
      if (localYtFSMBaseState != null)
      {
        this.seleceData = ((LiveStyleRequester.SeleceData)localYtFSMBaseState.getStateDataBy("select_data"));
        if (!this.needLocalConfig) {
          this.colorData = ((String)localYtFSMBaseState.getStateDataBy("color_data"));
        }
      }
      localYtFSMBaseState = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
      if (localYtFSMBaseState != null) {
        this.actRefData = ((YTActRefData)localYtFSMBaseState.getStateDataBy("act_reflect_data"));
      }
      if ((this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) && (this.faceStatus != null) && (this.faceStatus.length > 0)) {
        YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.4(this));
      }
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(TAG, localException.getLocalizedMessage());
    }
  }
  
  public void enterFirst()
  {
    YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
  }
  
  public void exit()
  {
    super.exit();
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    try
    {
      this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      if (paramJSONObject.has("similarity_threshold"))
      {
        this.simiThreshold = paramJSONObject.getInt("similarity_threshold");
        if (paramJSONObject.has("reflect_security_level")) {
          this.securityLevel = paramJSONObject.getInt("reflect_security_level");
        }
        if (paramJSONObject.has("local_config_flag")) {
          this.needLocalConfig = paramJSONObject.getBoolean("local_config_flag");
        }
        if (paramJSONObject.has("color_data")) {
          this.colorData = paramJSONObject.getString("color_data");
        }
        if (!this.isLoadResourceOnline) {
          YTUtils.loadLibrary("YTAGReflectLiveCheck");
        }
      }
    }
    catch (JSONException paramString)
    {
      try
      {
        for (;;)
        {
          this.appId = paramJSONObject.getString("app_id");
          int i = YTAGReflectLiveCheckInterface.initModel(this.appId);
          if (i != 0)
          {
            YtLogger.e(TAG, "failed to init reflect sdk " + i);
            YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.1(this, i));
          }
          YTAGReflectLiveCheckInterface.setReflectNotice(new ReflectLivenessState.2(this));
          if (YtFSM.getInstance().getContext().reflectListener == null) {
            break;
          }
          YTAGReflectLiveCheckInterface.setReflectListener(new ReflectLivenessState.3(this));
          return;
          this.simiThreshold = 70;
        }
        paramString = paramString;
        paramString.printStackTrace();
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        }
        YTAGReflectLiveCheckInterface.setReflectListener(null);
      }
    }
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)
    {
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
      return;
    }
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void reset()
  {
    this.currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_INIT;
    this.continuousDetectCount = 0;
    this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    this.needCheckFaces = true;
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    super.reset();
  }
  
  public void unload()
  {
    super.unload();
    YTAGReflectLiveCheckInterface.cancel();
    YTAGReflectLiveCheckInterface.releaseModel();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    switch (ReflectLivenessState.10.$SwitchMap$com$tencent$youtu$sdkkitframework$liveness$ReflectLivenessState$ReflectProcessType[this.currentProcessType.ordinal()])
    {
    }
    for (;;)
    {
      moveToNextState();
      return;
      if ((this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) && (this.faceStatus != null) && (this.faceStatus.length > 0)) {
        startReflect();
      }
      this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
      continue;
      YtLogger.d(TAG, "reflect continuous_detect_count " + this.continuousDetectCount);
      if ((this.needCheckFaces) && ((this.poseState != SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) || ((this.faceStatus != null) && (this.faceStatus.length > 1)))) {
        YTAGReflectLiveCheckInterface.cancel();
      }
      YTAGReflectLiveCheckInterface.onPreviewFrame(paramArrayOfByte, YtFSM.getInstance().getContext().currentCamera);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState
 * JD-Core Version:    0.7.0.1
 */