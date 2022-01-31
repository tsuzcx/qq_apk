package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.TimeoutCounter;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.ProcessHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytcommon.tools.YTFaceUtils;
import com.tencent.youtu.ytcommon.tools.YTFileUtils;
import com.tencent.youtu.ytcommon.tools.YTUtils;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.YTImage;
import com.tencent.youtu.ytfacetrack.param.YTFaceAlignParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SilentLivenessState
  extends YtFSMBaseState
{
  private static final int CONTINUOUS_DETECT_COUNT = 3;
  private static int FIX_EYE;
  private static int FIX_EYEBROW_MOUTH;
  private static int FIX_EYE_EYEBROW;
  private static int FIX_EYE_EYEBROW_MOUTH;
  private static int FIX_EYE_MOUTH;
  private static int FIX_MOUTH;
  private static int FIX_NONE;
  private static int REFINE_CONFIG_ALL = 8198;
  private static int REFINE_CONFIG_EYEMOUTH = 8199;
  private static int REFINE_CONFIG_OFF;
  private static final String TAG = SilentLivenessState.class.getSimpleName();
  private final int TARGET_MASK_HEIGHT = 1280;
  private final int TARGET_MASK_WIDTH = 720;
  private float bigfaceThreshold = 0.6F;
  private float blurDetectThreshold = 0.3F;
  private int cameraRotateState;
  private int continueCloseEyeCount = 0;
  private TimeoutCounter countdowner = new TimeoutCounter();
  private int detectAvailableCount = 0;
  private int detectIntervalCount = 5;
  private float eyeOpenThreshold = 0.22F;
  private boolean isLoadResourceOnline = false;
  private float maskHeightRatio;
  private float maskWidthRatio;
  private boolean needBigFaceMode = true;
  private boolean needCheckEyeOpen = false;
  private boolean needManualTrigger = false;
  private boolean needTimeoutTimer = false;
  private int pitchThreshold = 30;
  private SilentLivenessState.FacePreviewingAdvise prevAdvise = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
  private int prevJudge = -1;
  private int previewHeight;
  private int previewWidth;
  private String resourceDownloadPath = "";
  private int rollThreshold = 25;
  private int sameFaceTipCount = 0;
  private float smallfaceThreshold = 0.1F;
  private boolean triggerLiveBeginEventFlag = false;
  private int yawThreshold = 25;
  
  static
  {
    FIX_NONE = 0;
    FIX_EYE = 1;
    FIX_EYE_EYEBROW = 3;
    FIX_MOUTH = 4;
    FIX_EYE_MOUTH = 5;
    FIX_EYEBROW_MOUTH = 6;
    FIX_EYE_EYEBROW_MOUTH = 7;
    REFINE_CONFIG_OFF = 8197;
  }
  
  private SilentLivenessState.FacePreviewingAdvise getFacePreviewAdvise(Rect paramRect1, Rect paramRect2, YTFaceTrack.FaceStatus paramFaceStatus)
  {
    if (paramFaceStatus == null) {
      return SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE;
    }
    Rect localRect = new Rect(0, 0, 0, 0);
    localRect.left = ((int)(paramRect2.left * this.maskWidthRatio));
    localRect.right = ((int)(paramRect2.right * this.maskWidthRatio));
    localRect.top = ((int)(paramRect2.top * this.maskHeightRatio));
    localRect.bottom = ((int)(paramRect2.bottom * this.maskHeightRatio));
    boolean bool = paramRect1.contains(localRect);
    int i = localRect.right;
    int j = localRect.left;
    float f = (localRect.bottom - localRect.top) * (i - j) / ((paramRect1.right - paramRect1.left) * (paramRect1.bottom - paramRect1.top));
    paramRect1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    if (paramRect1 != null)
    {
      paramRect1 = paramRect1.getStateDataBy("current_action_type");
      if (paramRect1 != null)
      {
        i = ((Integer)paramRect1).intValue();
        if ((i != 3) && (i != 4)) {}
      }
    }
    for (i = 0;; i = 1)
    {
      YtLogger.d(TAG, "face area ratio:" + f);
      if (!bool) {
        return SilentLivenessState.FacePreviewingAdvise.ADVISE_NOT_IN_RECT;
      }
      if (f < this.smallfaceThreshold) {
        return SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_FAR;
      }
      if (f > this.bigfaceThreshold) {
        return SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_CLOSE;
      }
      if ((i != 0) && ((Math.abs(paramFaceStatus.pitch) > this.pitchThreshold) || (Math.abs(paramFaceStatus.yaw) > this.yawThreshold) || (Math.abs(paramFaceStatus.roll) > this.rollThreshold))) {
        return SilentLivenessState.FacePreviewingAdvise.ADVISE_INCORRECT_POSTURE;
      }
      if ((this.needCheckEyeOpen) && (!isActionStage()))
      {
        f = YtSDKKitCommon.ProcessHelper.preCheckCloseEyeScore(paramFaceStatus.xys);
        YtLogger.d(TAG, "eye score:" + f + " cnt:" + this.continueCloseEyeCount);
        if (f < this.eyeOpenThreshold)
        {
          this.continueCloseEyeCount += 1;
          this.detectAvailableCount -= 1;
          if (this.detectAvailableCount < 0) {
            this.detectAvailableCount = 0;
          }
          if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE) {
            break label477;
          }
        }
      }
      label477:
      for (i = 10;; i = 4)
      {
        if (this.continueCloseEyeCount >= i)
        {
          paramRect1 = SilentLivenessState.FacePreviewingAdvise.ADVISE_EYE_CLOSE;
          this.continueCloseEyeCount = 0;
          return paramRect1;
          this.continueCloseEyeCount = 0;
          break;
        }
        return SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS;
        return SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS;
      }
    }
  }
  
  private SilentLivenessState.FacePreviewingAdvise getPoseJudge(YTFaceTrack.FaceStatus[] paramArrayOfFaceStatus)
  {
    paramArrayOfFaceStatus = paramArrayOfFaceStatus[0];
    Rect localRect = YTFaceUtils.getFaceScreen(paramArrayOfFaceStatus);
    return getFacePreviewAdvise(YtSDKKitFramework.getInstance().getDetectRect(), localRect, paramArrayOfFaceStatus);
  }
  
  private int getShelterJudge(YTFaceTrack.FaceStatus[] paramArrayOfFaceStatus)
  {
    return YTFaceUtils.shelterJudge(paramArrayOfFaceStatus[0].pointsVis);
  }
  
  private void initYoutuInstance()
  {
    int j = 0;
    Context localContext = YtFSM.getInstance().getContext().currentAppContex;
    Object localObject = localContext.getFilesDir().getAbsolutePath();
    if (this.isLoadResourceOnline)
    {
      localObject = this.resourceDownloadPath;
      YtLogger.d(TAG, "Use online path:" + (String)localObject);
    }
    String str1;
    String str2;
    for (;;)
    {
      arrayOfString = new String[4];
      arrayOfString[0] = "net1_18.rpnmodel";
      arrayOfString[1] = "net1_18_bin.rpnproto";
      arrayOfString[2] = "net2_36.rpnmodel";
      arrayOfString[3] = "net2_36_bin.rpnproto";
      if (this.isLoadResourceOnline) {
        break;
      }
      i = 0;
      while (i < arrayOfString.length)
      {
        str1 = arrayOfString[i];
        str2 = (String)localObject + "/" + str1;
        YTFileUtils.copyAsset(localContext.getAssets(), "FaceTrackModels/detector/" + str1, str2);
        i += 1;
      }
      YtLogger.d(TAG, "Use local path:" + (String)localObject);
    }
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "align.rpdm";
    arrayOfString[1] = "align.stb";
    arrayOfString[2] = "align_bin.rpdc";
    arrayOfString[3] = "eye.rpdm";
    arrayOfString[4] = "eye_bin.rpdc";
    if (!this.isLoadResourceOnline)
    {
      i = 0;
      while (i < arrayOfString.length)
      {
        str1 = arrayOfString[i];
        str2 = (String)localObject + "/" + str1;
        YTFileUtils.copyAsset(localContext.getAssets(), "FaceTrackModels/ufa/" + str1, str2);
        i += 1;
      }
    }
    arrayOfString = new String[1];
    arrayOfString[0] = "rotBasis.bin";
    if (!this.isLoadResourceOnline)
    {
      i = j;
      while (i < arrayOfString.length)
      {
        str1 = arrayOfString[i];
        str2 = (String)localObject + "/" + str1;
        YTFileUtils.copyAsset(localContext.getAssets(), "FaceTrackModels/poseest/" + str1, str2);
        i += 1;
      }
    }
    int i = YTFaceTrack.GlobalInit((String)localObject + "/");
    if (i != 0)
    {
      YtFSM.getInstance().sendFSMEvent(new SilentLivenessState.1(this, i));
      return;
    }
    localObject = YTFaceTrack.getInstance().GetFaceAlignParam();
    ((YTFaceAlignParam)localObject).net_fix_config = FIX_NONE;
    ((YTFaceAlignParam)localObject).refine_config = REFINE_CONFIG_OFF;
    YTFaceTrack.getInstance().SetFaceAlignParam((YTFaceAlignParam)localObject);
    localObject = YTFaceTrack.getInstance().GetFaceDetectParam();
    YtLogger.d(TAG, "big face mode" + this.needBigFaceMode);
    ((YTFaceDetectParam)localObject).bigger_face_mode = this.needBigFaceMode;
    ((YTFaceDetectParam)localObject).min_face_size = Math.max(Math.min(this.previewWidth, this.previewHeight) / 5, 40);
    YTFaceTrack.getInstance().SetFaceDetectParam((YTFaceDetectParam)localObject);
    localObject = YTFaceTrack.getInstance().GetFaceTrackParam();
    ((YTFaceTrackParam)localObject).need_pose_estimate = true;
    ((YTFaceTrackParam)localObject).detect_interval = this.detectIntervalCount;
    YTFaceTrack.getInstance().SetFaceTrackParam((YTFaceTrackParam)localObject);
  }
  
  private boolean isActionStage()
  {
    return (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE) || (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE);
  }
  
  private void sendFSMEvent(HashMap<String, Object> paramHashMap)
  {
    YtFSM.getInstance().sendFSMEvent(paramHashMap);
  }
  
  private void sendFaceStatusUITips(SilentLivenessState.FacePreviewingAdvise paramFacePreviewingAdvise, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if ((paramFacePreviewingAdvise != SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) || (paramInt != 0))
    {
      localHashMap.put("ui_action", "not_pass");
      this.detectAvailableCount = 0;
      if ((paramFacePreviewingAdvise != this.prevAdvise) || (paramInt != this.prevJudge)) {
        break label83;
      }
    }
    label83:
    for (this.sameFaceTipCount += 1;; this.sameFaceTipCount = 0)
    {
      if (this.sameFaceTipCount <= 3) {
        break label91;
      }
      return;
      this.detectAvailableCount += 1;
      break;
    }
    label91:
    this.prevAdvise = paramFacePreviewingAdvise;
    this.prevJudge = paramInt;
    if (paramFacePreviewingAdvise == SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) {
      if (paramInt == 1) {
        localHashMap.put("ui_tips", "fl_no_left_face");
      }
    }
    for (;;)
    {
      sendFSMEvent(localHashMap);
      return;
      if (paramInt == 2)
      {
        localHashMap.put("ui_tips", "fl_no_chin");
      }
      else if (paramInt == 3)
      {
        localHashMap.put("ui_tips", "fl_no_mouth");
      }
      else if (paramInt == 4)
      {
        localHashMap.put("ui_tips", "fl_no_right_face");
      }
      else if (paramInt == 5)
      {
        localHashMap.put("ui_tips", "fl_no_nose");
      }
      else if (paramInt == 6)
      {
        localHashMap.put("ui_tips", "fl_no_right_eye");
      }
      else if (paramInt == 7)
      {
        localHashMap.put("ui_tips", "fl_no_left_eye");
      }
      else if ((paramInt == 0) && (this.sameFaceTipCount > 2))
      {
        localHashMap.put("ui_tips", "fl_pose_keep");
        localHashMap.put("ui_action", "pass");
        continue;
        if (paramFacePreviewingAdvise == SilentLivenessState.FacePreviewingAdvise.ADVISE_NOT_IN_RECT) {
          localHashMap.put("ui_tips", "fl_pose_not_in_rect");
        } else if (paramFacePreviewingAdvise == SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_FAR) {
          localHashMap.put("ui_tips", "fl_pose_closer");
        } else if (paramFacePreviewingAdvise == SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_CLOSE) {
          localHashMap.put("ui_tips", "fl_pose_farer");
        } else if (paramFacePreviewingAdvise == SilentLivenessState.FacePreviewingAdvise.ADVISE_INCORRECT_POSTURE) {
          localHashMap.put("ui_tips", "fl_pose_keep");
        } else if (paramFacePreviewingAdvise == SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE) {
          localHashMap.put("ui_tips", "fl_no_face");
        } else if (paramFacePreviewingAdvise == SilentLivenessState.FacePreviewingAdvise.ADVISE_EYE_CLOSE) {
          localHashMap.put("ui_tips", "fl_pose_open_eye");
        }
      }
    }
  }
  
  private void sendUITipEvent(YTFaceTrack.FaceStatus[] paramArrayOfFaceStatus)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayOfFaceStatus == null)
    {
      localHashMap.put("ui_tips", "fl_no_face");
      localHashMap.put("ui_action", "not_pass");
      this.detectAvailableCount = 0;
      this.prevAdvise = SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE;
    }
    for (;;)
    {
      if (localHashMap.size() > 0) {
        sendFSMEvent(localHashMap);
      }
      return;
      if (paramArrayOfFaceStatus.length > 1)
      {
        localHashMap.put("ui_tips", "fl_too_many_faces");
        localHashMap.put("ui_action", "not_pass");
        localHashMap.put("ui_error", "Failed");
        this.detectAvailableCount = 0;
        this.prevAdvise = SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_MANY_FACE;
      }
      else
      {
        SilentLivenessState.FacePreviewingAdvise localFacePreviewingAdvise = getPoseJudge(paramArrayOfFaceStatus);
        YtLogger.d(TAG, "advise " + localFacePreviewingAdvise);
        sendFaceStatusUITips(localFacePreviewingAdvise, getShelterJudge(paramArrayOfFaceStatus));
      }
    }
  }
  
  public void enter()
  {
    super.enter();
  }
  
  public void enterFirst()
  {
    if (!this.needManualTrigger) {
      this.countdowner.start();
    }
  }
  
  public void exit()
  {
    super.exit();
  }
  
  public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    super.handleEvent(paramYtFrameworkFireEventType, paramObject);
    if (this.needManualTrigger)
    {
      if (paramYtFrameworkFireEventType != YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_BEGIN_LIVENESS) {
        break label35;
      }
      this.detectAvailableCount = 0;
      this.triggerLiveBeginEventFlag = true;
      resetTimeout();
    }
    label35:
    while (paramYtFrameworkFireEventType != YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS) {
      return;
    }
    this.triggerLiveBeginEventFlag = false;
    this.countdowner.cancel();
  }
  
  public void handleStateAction(String paramString, Object paramObject)
  {
    super.handleStateAction(paramString, paramObject);
    if (paramString.equals("reset_timeout")) {
      resetTimeout();
    }
    while (!paramString.equals("reset_manual_trigger")) {
      return;
    }
    this.triggerLiveBeginEventFlag = false;
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    try
    {
      if (paramJSONObject.has("resource_online")) {
        this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      }
      if (paramJSONObject.has("resource_download_path")) {
        this.resourceDownloadPath = paramJSONObject.getString("resource_download_path");
      }
      if (paramJSONObject.has("timeout_countdown_ms")) {
        this.countdowner.init(Math.max(0, Math.min(20000, paramJSONObject.getInt("timeout_countdown_ms"))));
      }
      if (paramJSONObject.has("manual_trigger")) {
        this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
      }
      if (paramJSONObject.has("check_eye_open")) {
        this.needCheckEyeOpen = paramJSONObject.getBoolean("check_eye_open");
      }
      if (paramJSONObject.has("open_eye_threshold")) {
        this.eyeOpenThreshold = ((float)paramJSONObject.getDouble("open_eye_threshold"));
      }
      if (paramJSONObject.has("pitch_threshold")) {
        this.pitchThreshold = paramJSONObject.getInt("pitch_threshold");
      }
      if (paramJSONObject.has("yaw_threshold")) {
        this.yawThreshold = paramJSONObject.getInt("yaw_threshold");
      }
      if (paramJSONObject.has("roll_threshold")) {
        this.rollThreshold = paramJSONObject.getInt("roll_threshold");
      }
      if (paramJSONObject.has("smallface_ratio_threshold")) {
        this.smallfaceThreshold = ((float)paramJSONObject.getDouble("smallface_ratio_threshold"));
      }
      if (paramJSONObject.has("bigface_ratio_threshold")) {
        this.bigfaceThreshold = ((float)paramJSONObject.getDouble("bigface_ratio_threshold"));
      }
      if (paramJSONObject.has("blur_detect_threshold")) {
        this.blurDetectThreshold = ((float)paramJSONObject.getDouble("blur_detect_threshold"));
      }
      if (paramJSONObject.has("need_big_face_mode")) {
        this.needBigFaceMode = paramJSONObject.getBoolean("need_big_face_mode");
      }
      if (paramJSONObject.has("detect_interval")) {
        this.detectIntervalCount = paramJSONObject.getInt("detect_interval");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        continue;
        this.previewWidth = paramString.width;
        this.previewHeight = paramString.height;
      }
    }
    if (!this.isLoadResourceOnline) {
      YTUtils.loadLibrary("YTFaceTrackPro2");
    }
    paramString = YtFSM.getInstance().getContext().currentCamera.getParameters().getPreviewSize();
    this.cameraRotateState = YtFSM.getInstance().getContext().currentRotateState;
    if (this.cameraRotateState >= 5)
    {
      this.previewWidth = paramString.height;
      this.previewHeight = paramString.width;
      this.maskWidthRatio = (720.0F / this.previewWidth);
      this.maskHeightRatio = (1280.0F / this.previewHeight);
      this.continueCloseEyeCount = 0;
      this.triggerLiveBeginEventFlag = false;
      this.sameFaceTipCount = 0;
      initYoutuInstance();
      return;
    }
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    if (this.countdowner.checkTimeout())
    {
      this.countdowner.cancel();
      if (this.needManualTrigger)
      {
        this.triggerLiveBeginEventFlag = false;
        YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
      }
    }
    do
    {
      return;
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
      return;
      switch (SilentLivenessState.2.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
      {
      default: 
        return;
      }
    } while (this.detectAvailableCount <= 5);
    this.countdowner.cancel();
    YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
    return;
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    return;
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
  }
  
  public void reset()
  {
    this.prevAdvise = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    this.detectAvailableCount = 0;
    this.continueCloseEyeCount = 0;
    this.triggerLiveBeginEventFlag = false;
    this.sameFaceTipCount = 0;
    this.countdowner.cancel();
    if (!this.needManualTrigger) {
      this.countdowner.reset();
    }
    super.reset();
  }
  
  public void resetTimeout()
  {
    this.countdowner.reset();
  }
  
  public void unload()
  {
    super.unload();
    try
    {
      YTFaceTrack.GlobalRelease();
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(TAG, "SDK inner bug");
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    if (this.countdowner.checkTimeout()) {
      moveToNextState();
    }
    do
    {
      return;
      YTFaceTrack localYTFaceTrack = YTFaceTrack.getInstance();
      YTFaceTrack.YTImage localYTImage = new YTFaceTrack.YTImage();
      localYTImage.width = paramInt1;
      localYTImage.height = paramInt2;
      float[] arrayOfFloat = new float[1];
      CommonUtils.benchMarkBegin("detect");
      paramArrayOfByte = localYTFaceTrack.DoDetectionProcessYUVWithBlur(paramArrayOfByte, paramInt1, paramInt2, this.cameraRotateState, true, arrayOfFloat, localYTImage);
      CommonUtils.benchMarkEnd("detect");
      YtLogger.d(TAG, CommonUtils.getBenchMarkTime("detect"));
      YtLogger.d(TAG, "Blur score:" + Arrays.toString(arrayOfFloat));
      if (paramArrayOfByte != null) {
        YtLogger.d(TAG, "face status count " + paramArrayOfByte.length);
      }
      sendUITipEvent(paramArrayOfByte);
      this.stateData.put("blur_score", Float.valueOf(arrayOfFloat[0]));
      this.stateData.put("face_status", paramArrayOfByte);
      this.stateData.put("pose_state", this.prevAdvise);
      this.stateData.put("shelter_state", Integer.valueOf(this.prevJudge));
      this.stateData.put("continuous_detect_count", Integer.valueOf(this.detectAvailableCount));
      paramArrayOfByte = new YuvImage(localYTImage.data, 17, paramInt2, paramInt1, null);
      this.stateData.put("last_frame", paramArrayOfByte);
    } while ((this.needManualTrigger) && ((this.needManualTrigger != true) || (this.triggerLiveBeginEventFlag != true)));
    moveToNextState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState
 * JD-Core Version:    0.7.0.1
 */