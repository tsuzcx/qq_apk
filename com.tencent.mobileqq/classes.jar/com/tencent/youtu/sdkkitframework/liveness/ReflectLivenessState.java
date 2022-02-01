package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.util.Base64;
import com.tencent.youtu.YTFaceTracker;
import com.tencent.youtu.YTFaceTracker.Param;
import com.tencent.youtu.YTFaceTracker.TrackedFace;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.TimeoutCounter;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSM.YtFSMUpdateStrategy;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectSettings;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectData;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectImage;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.DataPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ReflectLivenessState
  extends YtFSMBaseState
{
  private static final String TAG = "ReflectLivenessState";
  private YTActRefData actRefData;
  private int actReflectUXMode = 0;
  private String appId;
  private int backendProtoType = 0;
  private int changePointNum = 2;
  private String colorData;
  private int continuousDetectCount = 0;
  private String controlConfig = "";
  private ReflectLivenessState.ReflectProcessType currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_INIT;
  private String extraConfig = "";
  private YTFaceTracker.TrackedFace[] faceStatus;
  private boolean isLoadResourceOnline = false;
  private String legitimateReflectVersion = "3.6.2";
  private YTFaceTracker.Param mOriginParam;
  private boolean needCheckFaces = true;
  private boolean needCheckMultiFaces = false;
  private boolean needCheckPose = false;
  private boolean needLocalConfig = false;
  private boolean needManualTrigger = false;
  private boolean needRandom = false;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
  private int poseState = -1;
  private String randomColorData;
  private int securityLevel = 2;
  private LiveStyleRequester.SeleceData seleceData;
  private int simiThreshold = 70;
  private int stableFrameCount = 5;
  private TimeoutCounter tipsTimer = new TimeoutCounter("reflect tips timeout counter");
  private YTFaceTracker tracker = null;
  
  private void clearData()
  {
    this.currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_TIPWAIT;
    this.continuousDetectCount = 0;
    this.poseState = -1;
    this.needCheckFaces = true;
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    YTAGReflectLiveCheckInterface.cancel();
  }
  
  private ActionReflectReq getActionReflectLiveReq(FullPack paramFullPack, YTActReflectData paramYTActReflectData, String paramString)
  {
    ActionReflectReq localActionReflectReq = new ActionReflectReq();
    localActionReflectReq.app_id = YTAGReflectLiveCheckInterface.mAppId;
    localActionReflectReq.color_data = paramString;
    localActionReflectReq.platform = 2;
    localActionReflectReq.select_data = paramYTActReflectData.select_data;
    if (paramFullPack != null) {
      localActionReflectReq.reflect_data = translation(paramFullPack.AGin);
    }
    localActionReflectReq.live_image = new YTImageInfo(paramYTActReflectData.best);
    localActionReflectReq.eye_image = new YTImageInfo(paramYTActReflectData.eye);
    localActionReflectReq.mouth_image = new YTImageInfo(paramYTActReflectData.mouth);
    localActionReflectReq.compare_image = null;
    localActionReflectReq.mode = 0;
    localActionReflectReq.session_id = null;
    return localActionReflectReq;
  }
  
  private ReflectLiveReq getReflectLiveReq(FullPack paramFullPack, String paramString)
  {
    ReflectLiveReq localReflectLiveReq = new ReflectLiveReq();
    localReflectLiveReq.color_data = paramString;
    localReflectLiveReq.platform = 2;
    if (paramFullPack != null)
    {
      localReflectLiveReq.reflect_data = translation(paramFullPack.AGin);
      localReflectLiveReq.live_image = null;
    }
    localReflectLiveReq.compare_image = null;
    localReflectLiveReq.session_id = null;
    localReflectLiveReq.app_id = YTAGReflectLiveCheckInterface.mAppId;
    return localReflectLiveReq;
  }
  
  private void handleFailure(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("message:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("\ntips:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("\ncode:");
    ((StringBuilder)localObject).append(paramInt);
    paramString2 = ((StringBuilder)localObject).toString();
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("failed :");
    localStringBuilder.append(paramString2);
    YtLogger.e((String)localObject, localStringBuilder.toString());
    paramString2 = SilentLivenessState.convertAdvise(this.poseState);
    paramString1 = CommonUtils.makeMessageJson(4194304, paramString2, paramString1);
    YtSDKStats.getInstance().reportError(paramInt, paramString2);
    paramString2 = new HashMap();
    paramString2.put("ui_tips", "rst_failed");
    paramString2.put("ui_action", "process_finished");
    paramString2.put("process_action", "failed");
    paramString2.put("error_code", Integer.valueOf(4194304));
    paramString2.put("error_reason_code", Integer.valueOf(paramInt));
    paramString2.put("message", paramString1);
    YtFSM.getInstance().sendFSMEvent(paramString2);
    this.currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_FINISH;
  }
  
  private void handleSuccess(FullPack paramFullPack)
  {
    if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {}
    for (;;)
    {
      ByteArrayOutputStream localByteArrayOutputStream;
      int j;
      int k;
      StringBuilder localStringBuilder;
      try
      {
        localObject2 = getActionReflectLiveReq(paramFullPack, new YTActReflectData(new YTActReflectImage(this.actRefData.best.image, this.actRefData.best.xys, this.actRefData.best.checksum), new YTActReflectImage(this.actRefData.eye.image, this.actRefData.eye.xys, this.actRefData.eye.checksum), new YTActReflectImage(this.actRefData.mouth.image, this.actRefData.mouth.xys, this.actRefData.mouth.checksum), this.seleceData), this.colorData);
        ((ActionReflectReq)localObject2).app_id = this.appId;
        localObject1 = YtFSM.getInstance().getContext().imageToCompare;
        if (localObject1 != null)
        {
          localByteArrayOutputStream = new ByteArrayOutputStream();
          j = ((Bitmap)localObject1).getWidth();
          k = ((Bitmap)localObject1).getHeight();
          if (j <= k) {
            break label720;
          }
          i = j;
          paramFullPack = (FullPack)localObject1;
          if (i > 640)
          {
            paramFullPack = imageScale((Bitmap)localObject1, j * 640 / i, k * 640 / i);
            localObject1 = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("resize image. from w:");
            localStringBuilder.append(j);
            localStringBuilder.append(" h:");
            localStringBuilder.append(k);
            localStringBuilder.append(" to w:");
            localStringBuilder.append(paramFullPack.getWidth());
            localStringBuilder.append(" h:");
            localStringBuilder.append(paramFullPack.getHeight());
            YtLogger.d((String)localObject1, localStringBuilder.toString());
          }
          paramFullPack.compress(Bitmap.CompressFormat.JPEG, 95, localByteArrayOutputStream);
          ((ActionReflectReq)localObject2).compare_image = new YTImageInfo(new YTActReflectImage(localByteArrayOutputStream.toByteArray(), null, null));
        }
        ((ActionReflectReq)localObject2).color_data = this.colorData;
        this.stateData.put("reflect_request_object", localObject2);
      }
      catch (Exception paramFullPack)
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Handle actref data failed:");
        ((StringBuilder)localObject2).append(paramFullPack.getLocalizedMessage());
        YtLogger.e((String)localObject1, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = getReflectLiveReq(paramFullPack, this.colorData);
      Object localObject1 = YtFSM.getInstance().getContext().imageToCompare;
      if (localObject1 != null)
      {
        localByteArrayOutputStream = new ByteArrayOutputStream();
        j = ((Bitmap)localObject1).getWidth();
        k = ((Bitmap)localObject1).getHeight();
        if (j > k) {
          i = j;
        } else {
          i = k;
        }
        paramFullPack = (FullPack)localObject1;
        if (i > 640)
        {
          paramFullPack = imageScale((Bitmap)localObject1, j * 640 / i, k * 640 / i);
          localObject1 = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("resize image. from w:");
          localStringBuilder.append(j);
          localStringBuilder.append(" h:");
          localStringBuilder.append(k);
          localStringBuilder.append(" to w:");
          localStringBuilder.append(paramFullPack.getWidth());
          localStringBuilder.append(" h:");
          localStringBuilder.append(paramFullPack.getHeight());
          YtLogger.d((String)localObject1, localStringBuilder.toString());
        }
        paramFullPack.compress(Bitmap.CompressFormat.JPEG, 95, localByteArrayOutputStream);
        ((ReflectLiveReq)localObject2).compare_image = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 2));
      }
      YtLogger.d(TAG, "on Request...");
      ((ReflectLiveReq)localObject2).color_data = this.colorData;
      ((ReflectLiveReq)localObject2).select_data = this.seleceData;
      this.stateData.put("reflect_request_object", localObject2);
      this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE;
      this.tracker.setParam(this.mOriginParam);
      return;
      label720:
      int i = k;
    }
  }
  
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
  
  private void setupRequset() {}
  
  private void startReflect()
  {
    YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.10(this));
    if (this.mOriginParam == null)
    {
      localObject1 = this.tracker;
      if (localObject1 != null) {
        this.mOriginParam = ((YTFaceTracker)localObject1).getParam();
      }
    }
    Object localObject1 = this.tracker;
    if (localObject1 != null)
    {
      localObject2 = this.mOriginParam;
      ((YTFaceTracker.Param)localObject2).detInterval = 30;
      ((YTFaceTracker)localObject1).setParam((YTFaceTracker.Param)localObject2);
    }
    this.currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_REFLECT;
    setupRequset();
    localObject1 = YTAGReflectLiveCheckInterface.getAGSettings();
    ((YTAGReflectSettings)localObject1).safetylevel = this.securityLevel;
    boolean bool = false;
    ((YTAGReflectSettings)localObject1).isEncodeReflectData = false;
    if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
      bool = true;
    }
    ((YTAGReflectSettings)localObject1).isActionReflect = bool;
    YTAGReflectLiveCheckInterface.setAGSettings((YTAGReflectSettings)localObject1);
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Settings: safetyLevel ");
    localStringBuilder.append(((YTAGReflectSettings)localObject1).safetylevel);
    YtLogger.i((String)localObject2, localStringBuilder.toString());
    localObject2 = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Settings: isEncodeReflectData ");
    localStringBuilder.append(((YTAGReflectSettings)localObject1).isEncodeReflectData);
    YtLogger.i((String)localObject2, localStringBuilder.toString());
    localObject2 = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Settings: isActionReflect ");
    localStringBuilder.append(((YTAGReflectSettings)localObject1).isActionReflect);
    YtLogger.i((String)localObject2, localStringBuilder.toString());
    localObject1 = YtFSM.getInstance().getContext();
    YTAGReflectLiveCheckInterface.start(((YtSDKKitFramework.YtSDKPlatformContext)localObject1).currentAppContext, ((YtSDKKitFramework.YtSDKPlatformContext)localObject1).currentCamera, ((YtSDKKitFramework.YtSDKPlatformContext)localObject1).currentRotateState, this.colorData, new ReflectLivenessState.11(this));
  }
  
  private ColorImgData translation(RawImgData paramRawImgData)
  {
    ColorImgData localColorImgData = new ColorImgData();
    localColorImgData.setImage(new String(Base64.encode(paramRawImgData.frameBuffer, 2)));
    localColorImgData.checksum = paramRawImgData.checksum;
    localColorImgData.setCapture_time(paramRawImgData.captureTime);
    localColorImgData.setX(paramRawImgData.x);
    localColorImgData.setY(paramRawImgData.y);
    return localColorImgData;
  }
  
  private ReflectColorData translation(DataPack paramDataPack)
  {
    ReflectColorData localReflectColorData = new ReflectColorData();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    while (i < paramDataPack.videoData.length)
    {
      localArrayList.add(translation(paramDataPack.videoData[i]));
      i += 1;
    }
    localReflectColorData.setImages_data(localArrayList);
    localReflectColorData.setBegin_time(paramDataPack.beginTime);
    localReflectColorData.setChangepoint_time(paramDataPack.changePointTime);
    localReflectColorData.changepoint_time_list = new ArrayList();
    i = j;
    while (i < paramDataPack.changePointTimeList.length)
    {
      localReflectColorData.changepoint_time_list.add(Long.valueOf(paramDataPack.changePointTimeList[i]));
      i += 1;
    }
    localReflectColorData.setOffset_sys(paramDataPack.offsetSys);
    localReflectColorData.setFrame_num(paramDataPack.frameNum);
    localReflectColorData.setLandmark_num(paramDataPack.landMarkNum);
    localReflectColorData.setWidth(paramDataPack.width);
    localReflectColorData.setHeight(paramDataPack.height);
    localReflectColorData.version = "3.6.8";
    try
    {
      localReflectColorData.setLog(new String(paramDataPack.log, "UTF-8"));
      label199:
      localReflectColorData.setConfig_begin(paramDataPack.config_begin);
      return localReflectColorData;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label199;
    }
  }
  
  public void enter()
  {
    super.enter();
    Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
    for (;;)
    {
      int i;
      try
      {
        this.poseState = ((Integer)((YtFSMBaseState)localObject1).getStateDataBy("pose_state")).intValue();
        this.continuousDetectCount = ((Integer)((YtFSMBaseState)localObject1).getStateDataBy("continuous_detect_count")).intValue();
        this.faceStatus = ((YTFaceTracker.TrackedFace[])((YtFSMBaseState)localObject1).getStateDataBy("face_status"));
        localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        if (localObject1 != null)
        {
          this.seleceData = ((LiveStyleRequester.SeleceData)((YtFSMBaseState)localObject1).getStateDataBy("select_data"));
          if (!this.needLocalConfig) {
            this.colorData = ((String)((YtFSMBaseState)localObject1).getStateDataBy("color_data"));
          } else if (this.needRandom) {
            this.colorData = this.randomColorData;
          }
          localObject1 = (String)((YtFSMBaseState)localObject1).getStateDataBy("control_config");
          if (localObject1 != null) {
            this.controlConfig = ((String)localObject1);
          }
        }
        if (!this.controlConfig.isEmpty())
        {
          localObject1 = this.controlConfig.split("&");
          if (localObject1.length > 0)
          {
            int j = localObject1.length;
            i = 0;
            if (i < j)
            {
              localObject2 = localObject1[i].split("=");
              if ((localObject2.length <= 1) || (!localObject2[0].equals("actref_ux_mode"))) {
                break label401;
              }
              this.actReflectUXMode = Integer.parseInt(localObject2[1]);
            }
          }
        }
        localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
        if (localObject1 != null) {
          this.actRefData = ((YTActRefData)((YtFSMBaseState)localObject1).getStateDataBy("act_reflect_data"));
        }
        if ((this.continuousDetectCount > this.stableFrameCount) && (this.poseState == 0) && (this.faceStatus != null) && (this.faceStatus.length > 0)) {
          YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.8(this));
        }
        if (this.actReflectUXMode == 2)
        {
          this.currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_FINISH;
          handleSuccess(null);
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reflection enter failed ");
        localStringBuilder.append(localException.getLocalizedMessage());
        YtLogger.e((String)localObject2, localStringBuilder.toString());
        CommonUtils.reportException("reflection enter failed ", localException);
      }
      YtFSM.getInstance().updateCacheStrategy(YtFSM.YtFSMUpdateStrategy.CacheStrategy);
      return;
      label401:
      i += 1;
    }
  }
  
  public void enterFirst()
  {
    YtFSMBaseState localYtFSMBaseState = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
    localYtFSMBaseState.handleStateAction("reset_timeout", null);
    this.tracker = ((YTFaceTracker)localYtFSMBaseState.getStateDataBy("detect_instance"));
    this.mOriginParam = this.tracker.getParam();
    this.tipsTimer.reset();
    YtFSM.getInstance().cleanUpQueue();
  }
  
  public void exit()
  {
    super.exit();
  }
  
  public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    super.handleEvent(paramYtFrameworkFireEventType, paramObject);
    if ((this.needManualTrigger) && (paramYtFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS)) {
      clearData();
    }
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    try
    {
      if (paramJSONObject.has("resource_online")) {
        this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      }
      if (paramJSONObject.has("similarity_threshold")) {
        this.simiThreshold = paramJSONObject.getInt("similarity_threshold");
      } else {
        this.simiThreshold = 70;
      }
      if (paramJSONObject.has("reflect_security_level")) {
        this.securityLevel = paramJSONObject.getInt("reflect_security_level");
      }
      if (paramJSONObject.has("local_config_flag")) {
        this.needLocalConfig = paramJSONObject.getBoolean("local_config_flag");
      }
      if (paramJSONObject.has("color_data")) {
        this.colorData = paramJSONObject.getString("color_data");
      }
      if (paramJSONObject.has("stable_frame_num")) {
        this.stableFrameCount = paramJSONObject.getInt("stable_frame_num");
      }
      if (paramJSONObject.has("backend_proto_type")) {
        this.backendProtoType = paramJSONObject.getInt("backend_proto_type");
      }
      if (paramJSONObject.has("force_pose_check")) {
        this.needCheckPose = paramJSONObject.getBoolean("force_pose_check");
      }
      if (paramJSONObject.has("manual_trigger")) {
        this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
      }
      if (paramJSONObject.has("reflect_tips_countdown_ms")) {
        this.tipsTimer.init(Math.max(0, Math.min(10000, paramJSONObject.getInt("reflect_tips_countdown_ms"))), false);
      }
      if (paramJSONObject.has("control_config")) {
        this.controlConfig = paramJSONObject.getString("control_config");
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Failed to parse json:");
      ((StringBuilder)localObject2).append(paramString.getLocalizedMessage());
      YtLogger.e((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    if (!this.isLoadResourceOnline) {
      FileUtils.loadLibrary("YTAGReflectLiveCheck");
    }
    YtLogger.i(TAG, "Reflection version:3.6.8");
    paramString = "3.6.8".split("\\.");
    Object localObject1 = this.legitimateReflectVersion;
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wanted Reflection Version: ");
    localStringBuilder.append((String)localObject1);
    YtLogger.i((String)localObject2, localStringBuilder.toString());
    localObject1 = ((String)localObject1).split("\\.");
    if (Integer.parseInt(paramString[0]) != Integer.parseInt(localObject1[0])) {
      YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.1(this));
    } else if (Integer.parseInt(paramString[1]) != Integer.parseInt(localObject1[1])) {
      YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.2(this));
    } else if (Integer.parseInt(paramString[2]) < Integer.parseInt(localObject1[2])) {
      YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.3(this));
    }
    try
    {
      this.appId = paramJSONObject.getString("app_id");
      if (paramJSONObject.has("extra_config")) {
        this.extraConfig = paramJSONObject.getString("extra_config");
      }
      if (paramJSONObject.has("change_point_num")) {
        this.changePointNum = paramJSONObject.getInt("change_point_num");
      }
      if (paramJSONObject.has("need_random_flag")) {
        this.needRandom = paramJSONObject.getBoolean("need_random_flag");
      }
      this.needCheckMultiFaces = paramJSONObject.optBoolean("need_check_multiface", false);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramJSONObject = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to parse json:");
      ((StringBuilder)localObject1).append(paramString.getLocalizedMessage());
      YtLogger.e(paramJSONObject, ((StringBuilder)localObject1).toString());
    }
    int i = YTAGReflectLiveCheckInterface.initModel(this.appId);
    if (i != 0)
    {
      paramString = TAG;
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("failed to init reflect sdk ");
      paramJSONObject.append(i);
      YtLogger.e(paramString, paramJSONObject.toString());
      YtSDKStats.getInstance().reportError(i, "failed to init reflect sdk");
      YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.4(this, i));
    }
    if (this.needRandom) {
      this.randomColorData = YTAGReflectLiveCheckJNIInterface.FRGenConfigData(this.changePointNum, this.extraConfig);
    }
    YTAGReflectLiveCheckInterface.setReflectNotice(new ReflectLivenessState.5(this));
    if (YtFSM.getInstance().getContext().reflectListener != null) {
      YTAGReflectLiveCheckInterface.setReflectListener(new ReflectLivenessState.6(this));
    } else {
      YTAGReflectLiveCheckInterface.setReflectListener(null);
    }
    YTAGReflectLiveCheckJNIInterface.configNativeLog(true);
    YTAGReflectLiveCheckJNIInterface.updateParam("log_level", "3");
    YTAGReflectLiveCheckJNIInterface.setLoggerListener(new ReflectLivenessState.7(this));
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
    clearData();
    super.reset();
  }
  
  public void unload()
  {
    super.unload();
    YTAGReflectLiveCheckInterface.cancel();
    YTAGReflectLiveCheckInterface.releaseModel();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    paramInt3 = ReflectLivenessState.12.$SwitchMap$com$tencent$youtu$sdkkitframework$liveness$ReflectLivenessState$ReflectProcessType[this.currentProcessType.ordinal()];
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2)
      {
        if (paramInt3 == 3)
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reflect continuous_detect_count ");
          localStringBuilder.append(this.continuousDetectCount);
          localStringBuilder.append("pass flag ");
          boolean bool;
          if (this.poseState != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localStringBuilder.append(bool);
          YtLogger.d(str, localStringBuilder.toString());
          str = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("reflect pose state ");
          localStringBuilder.append(this.poseState);
          YtLogger.d(str, localStringBuilder.toString());
          if (this.needCheckFaces)
          {
            if (this.needCheckPose)
            {
              paramInt3 = this.poseState;
              if ((paramInt3 != 0) && (paramInt3 != 9)) {}
            }
            else
            {
              if (((!this.needCheckMultiFaces) || (this.poseState != 1)) && (this.poseState != 1)) {
                break label276;
              }
            }
            str = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("reflect cancel:");
            localStringBuilder.append(this.continuousDetectCount);
            YtLogger.i(str, localStringBuilder.toString());
            YTAGReflectLiveCheckInterface.cancel();
            handleFailure(-1, "检测异常", "请保持姿态");
          }
          label276:
          if (this.faceStatus != null) {
            YTAGReflectLiveCheckInterface.pushImageData(paramArrayOfByte, paramInt1, paramInt2, paramLong, YtFSM.getInstance().getContext().currentRotateState, this.faceStatus[0].faceShape, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
          }
        }
      }
      else
      {
        if (this.continuousDetectCount > this.stableFrameCount)
        {
          paramInt1 = this.poseState;
          if ((paramInt1 == 0) || (paramInt1 == 9))
          {
            paramArrayOfByte = this.faceStatus;
            if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
              startReflect();
            }
          }
        }
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
      }
    }
    else if ((this.tipsTimer.isRunning()) && (!this.tipsTimer.checkTimeout()))
    {
      if (this.continuousDetectCount <= 1) {
        this.tipsTimer.reset();
      } else {
        YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.9(this));
      }
    }
    else
    {
      this.tipsTimer.cancel();
      this.currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_INIT;
    }
    moveToNextState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState
 * JD-Core Version:    0.7.0.1
 */