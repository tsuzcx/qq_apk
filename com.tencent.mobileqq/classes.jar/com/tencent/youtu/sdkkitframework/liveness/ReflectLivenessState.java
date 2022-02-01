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
  private static final String TAG = ReflectLivenessState.class.getSimpleName();
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
    paramString2 = "message:" + paramString1 + "\ntips:" + paramString2 + "\ncode:" + paramInt;
    YtLogger.e(TAG, "failed :" + paramString2);
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
    ByteArrayOutputStream localByteArrayOutputStream;
    int j;
    int k;
    if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
      for (;;)
      {
        try
        {
          localObject = getActionReflectLiveReq(paramFullPack, new YTActReflectData(new YTActReflectImage(this.actRefData.best.image, this.actRefData.best.xys, this.actRefData.best.checksum), new YTActReflectImage(this.actRefData.eye.image, this.actRefData.eye.xys, this.actRefData.eye.checksum), new YTActReflectImage(this.actRefData.mouth.image, this.actRefData.mouth.xys, this.actRefData.mouth.checksum), this.seleceData), this.colorData);
          ((ActionReflectReq)localObject).app_id = this.appId;
          localBitmap = YtFSM.getInstance().getContext().imageToCompare;
          if (localBitmap != null)
          {
            localByteArrayOutputStream = new ByteArrayOutputStream();
            j = localBitmap.getWidth();
            k = localBitmap.getHeight();
            if (j <= k) {
              continue;
            }
            i = j;
            paramFullPack = localBitmap;
            if (i > 640)
            {
              paramFullPack = imageScale(localBitmap, j * 640 / i, k * 640 / i);
              YtLogger.d(TAG, "resize image. from w:" + j + " h:" + k + " to w:" + paramFullPack.getWidth() + " h:" + paramFullPack.getHeight());
            }
            paramFullPack.compress(Bitmap.CompressFormat.JPEG, 95, localByteArrayOutputStream);
            ((ActionReflectReq)localObject).compare_image = new YTImageInfo(new YTActReflectImage(localByteArrayOutputStream.toByteArray(), null, null));
          }
          ((ActionReflectReq)localObject).color_data = this.colorData;
          this.stateData.put("reflect_request_object", localObject);
        }
        catch (Exception paramFullPack)
        {
          YtLogger.e(TAG, "Handle actref data failed:" + paramFullPack.getLocalizedMessage());
          continue;
        }
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE;
        this.tracker.setParam(this.mOriginParam);
        return;
        i = k;
      }
    }
    Object localObject = getReflectLiveReq(paramFullPack, this.colorData);
    Bitmap localBitmap = YtFSM.getInstance().getContext().imageToCompare;
    if (localBitmap != null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      j = localBitmap.getWidth();
      k = localBitmap.getHeight();
      if (j <= k) {
        break label639;
      }
    }
    label639:
    for (int i = j;; i = k)
    {
      paramFullPack = localBitmap;
      if (i > 640)
      {
        paramFullPack = imageScale(localBitmap, j * 640 / i, k * 640 / i);
        YtLogger.d(TAG, "resize image. from w:" + j + " h:" + k + " to w:" + paramFullPack.getWidth() + " h:" + paramFullPack.getHeight());
      }
      paramFullPack.compress(Bitmap.CompressFormat.JPEG, 95, localByteArrayOutputStream);
      ((ReflectLiveReq)localObject).compare_image = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 2));
      YtLogger.d(TAG, "on Request...");
      ((ReflectLiveReq)localObject).color_data = this.colorData;
      ((ReflectLiveReq)localObject).select_data = this.seleceData;
      this.stateData.put("reflect_request_object", localObject);
      break;
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
    boolean bool = false;
    YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.10(this));
    if ((this.mOriginParam == null) && (this.tracker != null)) {
      this.mOriginParam = this.tracker.getParam();
    }
    if (this.tracker != null)
    {
      localObject = this.mOriginParam;
      ((YTFaceTracker.Param)localObject).detInterval = 30;
      this.tracker.setParam((YTFaceTracker.Param)localObject);
    }
    this.currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_REFLECT;
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
    YTAGReflectLiveCheckInterface.start(((YtSDKKitFramework.YtSDKPlatformContext)localObject).currentAppContext, ((YtSDKKitFramework.YtSDKPlatformContext)localObject).currentCamera, ((YtSDKKitFramework.YtSDKPlatformContext)localObject).currentRotateState, this.colorData, new ReflectLivenessState.11(this));
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
    int j = 0;
    ReflectColorData localReflectColorData = new ReflectColorData();
    ArrayList localArrayList = new ArrayList();
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
    Object localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
    for (;;)
    {
      try
      {
        this.poseState = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("pose_state")).intValue();
        this.continuousDetectCount = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("continuous_detect_count")).intValue();
        this.faceStatus = ((YTFaceTracker.TrackedFace[])((YtFSMBaseState)localObject).getStateDataBy("face_status"));
        localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        if (localObject != null)
        {
          this.seleceData = ((LiveStyleRequester.SeleceData)((YtFSMBaseState)localObject).getStateDataBy("select_data"));
          if (this.needLocalConfig) {
            continue;
          }
          this.colorData = ((String)((YtFSMBaseState)localObject).getStateDataBy("color_data"));
          localObject = (String)((YtFSMBaseState)localObject).getStateDataBy("control_config");
          if (localObject != null) {
            this.controlConfig = ((String)localObject);
          }
        }
        if (this.controlConfig.isEmpty()) {
          continue;
        }
        localObject = this.controlConfig.split("&");
        if (localObject.length <= 0) {
          continue;
        }
        j = localObject.length;
        i = 0;
      }
      catch (Exception localException)
      {
        int j;
        int i;
        String[] arrayOfString;
        YtLogger.e(TAG, "reflection enter failed " + localException.getLocalizedMessage());
        CommonUtils.reportException("reflection enter failed ", localException);
        continue;
        i += 1;
        continue;
      }
      if (i < j)
      {
        arrayOfString = localObject[i].split("=");
        if ((arrayOfString.length <= 1) || (!arrayOfString[0].equals("actref_ux_mode"))) {
          continue;
        }
        this.actReflectUXMode = Integer.parseInt(arrayOfString[1]);
      }
      localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
      if (localObject != null) {
        this.actRefData = ((YTActRefData)((YtFSMBaseState)localObject).getStateDataBy("act_reflect_data"));
      }
      if ((this.continuousDetectCount > this.stableFrameCount) && (this.poseState == 0) && (this.faceStatus != null) && (this.faceStatus.length > 0)) {
        YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.8(this));
      }
      if (this.actReflectUXMode == 2)
      {
        this.currentProcessType = ReflectLivenessState.ReflectProcessType.RPT_FINISH;
        handleSuccess(null);
      }
      YtFSM.getInstance().updateCacheStrategy(YtFSM.YtFSMUpdateStrategy.CacheStrategy);
      return;
      if (this.needRandom) {
        this.colorData = this.randomColorData;
      }
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
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("resource_online")) {
          this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
        }
        if (!paramJSONObject.has("similarity_threshold")) {
          continue;
        }
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
        Object localObject;
        paramString.printStackTrace();
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        continue;
        if (Integer.parseInt(paramString[1]) == Integer.parseInt(localObject[1])) {
          continue;
        }
        YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.2(this));
        continue;
        if (Integer.parseInt(paramString[2]) >= Integer.parseInt(localObject[2])) {
          continue;
        }
        YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.3(this));
        continue;
      }
      if (!this.isLoadResourceOnline) {
        FileUtils.loadLibrary("YTAGReflectLiveCheck");
      }
      YtLogger.i(TAG, "Reflection version:3.6.8");
      paramString = "3.6.8".split("\\.");
      localObject = this.legitimateReflectVersion;
      YtLogger.i(TAG, "Wanted Reflection Version: " + (String)localObject);
      localObject = ((String)localObject).split("\\.");
      if (Integer.parseInt(paramString[0]) == Integer.parseInt(localObject[0])) {
        continue;
      }
      YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.1(this));
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
        int i;
        paramString.printStackTrace();
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        continue;
        YTAGReflectLiveCheckInterface.setReflectListener(null);
        continue;
      }
      i = YTAGReflectLiveCheckInterface.initModel(this.appId);
      if (i != 0)
      {
        YtLogger.e(TAG, "failed to init reflect sdk " + i);
        YtSDKStats.getInstance().reportError(i, "failed to init reflect sdk");
        YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.4(this, i));
      }
      if (this.needRandom) {
        this.randomColorData = YTAGReflectLiveCheckJNIInterface.FRGenConfigData(this.changePointNum, this.extraConfig);
      }
      YTAGReflectLiveCheckInterface.setReflectNotice(new ReflectLivenessState.5(this));
      if (YtFSM.getInstance().getContext().reflectListener == null) {
        break label737;
      }
      YTAGReflectLiveCheckInterface.setReflectListener(new ReflectLivenessState.6(this));
      YTAGReflectLiveCheckJNIInterface.configNativeLog(true);
      YTAGReflectLiveCheckJNIInterface.updateParam("log_level", "3");
      YTAGReflectLiveCheckJNIInterface.setLoggerListener(new ReflectLivenessState.7(this));
      return;
      this.simiThreshold = 70;
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
    switch (ReflectLivenessState.12.$SwitchMap$com$tencent$youtu$sdkkitframework$liveness$ReflectLivenessState$ReflectProcessType[this.currentProcessType.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
      for (;;)
      {
        moveToNextState();
        return;
        if ((this.tipsTimer.isRunning()) && (!this.tipsTimer.checkTimeout()))
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
          continue;
          if ((this.continuousDetectCount > this.stableFrameCount) && ((this.poseState == 0) || (this.poseState == 9)) && (this.faceStatus != null) && (this.faceStatus.length > 0)) {
            startReflect();
          }
          this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        }
      }
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("reflect continuous_detect_count ").append(this.continuousDetectCount).append("pass flag ");
    if (this.poseState != 0) {}
    for (boolean bool = true;; bool = false)
    {
      YtLogger.d(str, bool);
      YtLogger.d(TAG, "reflect pose state " + this.poseState);
      if ((this.needCheckFaces) && (((this.needCheckPose) && (this.poseState != 0) && (this.poseState != 9)) || ((this.needCheckMultiFaces) && (this.poseState == 1)) || (this.poseState == 1)))
      {
        YtLogger.i(TAG, "reflect cancel:" + this.continuousDetectCount);
        YTAGReflectLiveCheckInterface.cancel();
        handleFailure(-1, "检测异常", "请保持姿态");
      }
      if (this.faceStatus == null) {
        break;
      }
      YTAGReflectLiveCheckInterface.pushImageData(paramArrayOfByte, paramInt1, paramInt2, paramLong, YtFSM.getInstance().getContext().currentRotateState, this.faceStatus[0].faceShape, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState
 * JD-Core Version:    0.7.0.1
 */