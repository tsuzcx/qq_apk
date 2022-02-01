package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.TimeoutCounter;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.ProcessHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytcommon.tools.YTFaceUtils;
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
  private float bigfaceThreshold = 1.0F;
  private float blurDetectThreshold = 0.3F;
  private int cameraRotateState;
  private int continueCloseEyeCount = 0;
  private int continueNoValidFaceCount = 0;
  private int continueNovalidFaceCountThreshold = 5;
  private TimeoutCounter countdowner = new TimeoutCounter("Liveness timeout counter");
  private int detectAvailableCount = 0;
  private int detectIntervalCount = 5;
  private float eyeOpenThreshold = 0.22F;
  private boolean isFirstStablePass = false;
  private boolean isLoadResourceOnline = false;
  private float maskHeightRatio;
  private float maskWidthRatio;
  private float maxEyeScore = -99999.0F;
  private float minMouthScore = 99999.0F;
  private boolean needBigFaceMode = true;
  private boolean needCheckEyeOpen = false;
  private boolean needCheckPose = false;
  private boolean needManualTrigger = false;
  private boolean needTimeoutTimer = false;
  private int pitchThreshold = 30;
  private TimeoutCounter predetectCountdowner = new TimeoutCounter("Predetect timeout counter");
  private SilentLivenessState.FacePreviewingAdvise prevAdvise = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
  private int prevJudge = -1;
  private int previewHeight;
  private int previewWidth;
  private String resourceDownloadPath = "";
  private int rollThreshold = 25;
  private int sameFaceTipCount = 0;
  private float smallfaceThreshold = 0.5F;
  private int stableCountNum = 5;
  private boolean tipFilterFlag = true;
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
  
  private void checkBestImage(YTFaceTrack.FaceStatus paramFaceStatus, YuvImage paramYuvImage)
  {
    float f1 = YtSDKKitCommon.ProcessHelper.calcEyeScore(paramFaceStatus.xys);
    float f2 = YtSDKKitCommon.ProcessHelper.calcMouthScore(paramFaceStatus.xys);
    if ((f1 > this.maxEyeScore) && (f2 < this.minMouthScore))
    {
      this.maxEyeScore = f1;
      this.minMouthScore = f2;
      this.stateData.put("best_image", paramYuvImage);
      this.stateData.put("best_shape", paramFaceStatus.xys);
    }
  }
  
  private SilentLivenessState.FacePreviewingAdvise getFacePreviewAdvise(Rect paramRect1, Rect paramRect2, YTFaceTrack.FaceStatus paramFaceStatus)
  {
    if (paramFaceStatus == null) {
      return SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE;
    }
    Rect localRect = new Rect(0, 0, 0, 0);
    YtLogger.d(TAG, "camera" + this.previewWidth + "x" + this.previewHeight + " ratio " + this.maskWidthRatio + "x" + this.maskHeightRatio);
    YtLogger.d(TAG, "detectrect :" + paramRect1.left + " " + paramRect1.top + " " + paramRect1.right + " " + paramRect1.bottom);
    localRect.left = ((int)(paramRect2.left * this.maskWidthRatio));
    localRect.right = ((int)(paramRect2.right * this.maskWidthRatio));
    localRect.top = ((int)(paramRect2.top * this.maskHeightRatio));
    localRect.bottom = ((int)(paramRect2.bottom * this.maskHeightRatio));
    boolean bool = paramRect1.contains(localRect);
    YtLogger.d(TAG, "faceInMask : " + localRect.left + " " + localRect.top + " " + localRect.right + " " + localRect.bottom + "in rect" + bool);
    float f = (paramRect2.right - paramRect2.left) / (this.previewWidth * 1.0F);
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
    for (int i = 0;; i = 1)
    {
      YtLogger.d(TAG, "face area ratio:" + f);
      if (f > this.bigfaceThreshold) {
        return SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_CLOSE;
      }
      if (!bool) {
        return SilentLivenessState.FacePreviewingAdvise.ADVISE_NOT_IN_RECT;
      }
      if (f < this.smallfaceThreshold) {
        return SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_FAR;
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
            break label659;
          }
        }
      }
      label659:
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
  
  private Rect getFaceRect(YTFaceTrack.FaceStatus paramFaceStatus)
  {
    float f4 = paramFaceStatus.xys[0];
    float f3 = paramFaceStatus.xys[0];
    float f2 = paramFaceStatus.xys[1];
    float f1 = paramFaceStatus.xys[1];
    int i = 0;
    while (i < 180)
    {
      f4 = Math.min(f4, paramFaceStatus.xys[i]);
      f3 = Math.max(f3, paramFaceStatus.xys[i]);
      i += 1;
      f2 = Math.min(f2, paramFaceStatus.xys[i]);
      f1 = Math.max(f1, paramFaceStatus.xys[i]);
      i += 1;
    }
    float f5 = this.previewWidth - 1 - f4;
    f3 = this.previewWidth - 1 - f3;
    f4 = (float)(f3 - (f5 - f3) * 0.1D / 2.0D);
    f3 = (float)(f5 + (f5 - f4) * 0.1D / 2.0D);
    f5 = (float)(f2 - (f1 - f2) * 0.1D / 2.0D);
    float f6 = (float)(f1 + (f1 - f5) * 0.1D / 2.0D);
    f1 = f4;
    if (f4 < 0.0F) {
      f1 = 0.0F;
    }
    f2 = f3;
    if (f3 < 0.0F) {
      f2 = 0.0F;
    }
    f3 = f1;
    if (f1 > this.previewWidth - 1) {
      f3 = this.previewWidth - 1;
    }
    if (f2 > this.previewWidth - 1)
    {
      f4 = this.previewWidth - 1;
      f1 = f5;
      if (f5 < 0.0F) {
        f1 = 0.0F;
      }
      if (f6 >= 0.0F) {
        break label388;
      }
      f2 = 0.0F;
      label301:
      if (f1 <= this.previewHeight - 1) {
        break label394;
      }
      f1 = this.previewHeight - 1;
    }
    label388:
    label394:
    for (;;)
    {
      f5 = f2;
      if (f2 > this.previewHeight - 1) {
        f5 = this.previewHeight - 1;
      }
      paramFaceStatus = new Rect();
      paramFaceStatus.left = ((int)f3);
      paramFaceStatus.top = ((int)f1);
      paramFaceStatus.right = ((int)f4);
      paramFaceStatus.bottom = ((int)f5);
      return paramFaceStatus;
      f4 = f2;
      break;
      f2 = f6;
      break label301;
    }
  }
  
  private SilentLivenessState.FacePreviewingAdvise getPoseJudge(YTFaceTrack.FaceStatus[] paramArrayOfFaceStatus)
  {
    paramArrayOfFaceStatus = paramArrayOfFaceStatus[0];
    Rect localRect = getFaceRect(paramArrayOfFaceStatus);
    YtLogger.d(TAG, "rect is: " + localRect.left + ", " + localRect.top + ", " + localRect.right + ", " + localRect.bottom);
    return getFacePreviewAdvise(YtSDKKitFramework.getInstance().getDetectRect(), localRect, paramArrayOfFaceStatus);
  }
  
  private int getShelterJudge(YTFaceTrack.FaceStatus[] paramArrayOfFaceStatus)
  {
    return YTFaceUtils.shelterJudge(paramArrayOfFaceStatus[0].pointsVis);
  }
  
  private void initYoutuInstance()
  {
    int j = 0;
    Context localContext = YtFSM.getInstance().getContext().currentAppContext;
    Object localObject = localContext.getFilesDir().getAbsolutePath();
    if (this.isLoadResourceOnline)
    {
      localObject = this.resourceDownloadPath;
      YtLogger.i(TAG, "Use online path:" + (String)localObject);
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
        FileUtils.copyAsset(localContext.getAssets(), "FaceTrackModels/detector/" + str1, str2);
        i += 1;
      }
      YtLogger.i(TAG, "Use local path:" + (String)localObject);
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
        FileUtils.copyAsset(localContext.getAssets(), "FaceTrackModels/ufa/" + str1, str2);
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
        FileUtils.copyAsset(localContext.getAssets(), "FaceTrackModels/poseest/" + str1, str2);
        i += 1;
      }
    }
    int i = YTFaceTrack.GlobalInit((String)localObject + "/");
    if (i != 0)
    {
      YtSDKStats.getInstance().reportError(300101, "模式初始化失败");
      YtFSM.getInstance().sendFSMEvent(new SilentLivenessState.1(this, i));
      return;
    }
    localObject = YTFaceTrack.getInstance().GetFaceAlignParam();
    ((YTFaceAlignParam)localObject).net_fix_config = FIX_EYE_MOUTH;
    ((YTFaceAlignParam)localObject).refine_config = REFINE_CONFIG_OFF;
    YTFaceTrack.getInstance().SetFaceAlignParam((YTFaceAlignParam)localObject);
    localObject = YTFaceTrack.getInstance().GetFaceDetectParam();
    YtLogger.i(TAG, "big face mode" + this.needBigFaceMode);
    ((YTFaceDetectParam)localObject).bigger_face_mode = this.needBigFaceMode;
    ((YTFaceDetectParam)localObject).min_face_size = Math.max(Math.min(this.previewWidth, this.previewHeight) / 5, 40);
    YTFaceTrack.getInstance().SetFaceDetectParam((YTFaceDetectParam)localObject);
    localObject = YTFaceTrack.getInstance().GetFaceTrackParam();
    ((YTFaceTrackParam)localObject).need_pose_estimate = true;
    ((YTFaceTrackParam)localObject).detect_interval = this.detectIntervalCount;
    YTFaceTrack.getInstance().SetFaceTrackParam((YTFaceTrackParam)localObject);
    YtLogger.i(TAG, "Detect version:" + YTFaceTrack.Version);
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
        break label90;
      }
    }
    label90:
    for (this.sameFaceTipCount += 1;; this.sameFaceTipCount = 0)
    {
      if ((!this.tipFilterFlag) || (this.sameFaceTipCount <= 3)) {
        break label98;
      }
      return;
      this.detectAvailableCount += 1;
      break;
    }
    label98:
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
      else if ((paramInt == 0) && (this.sameFaceTipCount > 2) && (this.sameFaceTipCount < 5))
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
          localHashMap.put("ui_tips", "fl_pose_incorrect");
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
        YtLogger.i(TAG, "advise " + localFacePreviewingAdvise);
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
    if (!this.needManualTrigger)
    {
      this.countdowner.start();
      return;
    }
    this.predetectCountdowner.start();
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
    this.detectAvailableCount = 0;
    this.triggerLiveBeginEventFlag = false;
    this.countdowner.cancel();
    this.predetectCountdowner.reset();
  }
  
  public void handleStateAction(String paramString, Object paramObject)
  {
    super.handleStateAction(paramString, paramObject);
    if (paramString.equals("reset_timeout"))
    {
      YtLogger.d(TAG, "predetect status:" + this.predetectCountdowner.isRunning());
      if (!this.predetectCountdowner.isRunning()) {
        resetTimeout();
      }
    }
    while (!paramString.equals("reset_manual_trigger")) {
      return;
    }
    this.triggerLiveBeginEventFlag = false;
    this.countdowner.cancel();
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
        if (paramJSONObject.has("resource_download_path")) {
          this.resourceDownloadPath = paramJSONObject.getString("resource_download_path");
        }
        if (paramJSONObject.has("timeout_countdown_ms")) {
          this.countdowner.init(Math.max(0, Math.min(30000, paramJSONObject.getInt("timeout_countdown_ms"))), true);
        }
        if (!paramJSONObject.has("predetect_countdown_ms")) {
          continue;
        }
        this.predetectCountdowner.init(paramJSONObject.getInt("predetect_countdown_ms"), true);
        if (paramJSONObject.has("same_tips_filter")) {
          this.tipFilterFlag = paramJSONObject.getBoolean("same_tips_filter");
        }
        if (paramJSONObject.has("manual_trigger")) {
          this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
        }
        updateSDKSetting(paramJSONObject);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        continue;
        this.previewWidth = paramString.width;
        this.previewHeight = paramString.height;
        continue;
      }
      if (!this.isLoadResourceOnline) {
        FileUtils.loadLibrary("YTFaceTrackPro");
      }
      paramString = YtFSM.getInstance().getContext().currentCamera.getParameters().getPreviewSize();
      this.cameraRotateState = YtFSM.getInstance().getContext().currentRotateState;
      if (this.cameraRotateState < 5) {
        continue;
      }
      this.previewWidth = paramString.height;
      this.previewHeight = paramString.width;
      this.maskWidthRatio = (YtSDKKitFramework.getInstance().getPreviewRect().width() / this.previewWidth);
      this.maskHeightRatio = (YtSDKKitFramework.getInstance().getPreviewRect().height() / this.previewHeight);
      initYoutuInstance();
      reset();
      return;
      this.predetectCountdowner.init(25000L, true);
    }
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    if ((this.needManualTrigger) && (((this.needCheckPose) && (this.prevAdvise != SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS)) || (this.prevAdvise == SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_MANY_FACE) || (this.prevAdvise == SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE)))
    {
      this.continueNoValidFaceCount += 1;
      if (this.continueNoValidFaceCount <= this.continueNovalidFaceCountThreshold) {
        break label225;
      }
      Object localObject = "no valid face count > " + this.continueNovalidFaceCountThreshold;
      YtSDKStats.getInstance().reportInfo((String)localObject);
      String str = CommonUtils.makeMessageJson(4194304, (String)localObject, "action check failed");
      YtSDKStats.getInstance().reportError(4194304, (String)localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put("ui_tips", "rst_failed");
      ((HashMap)localObject).put("ui_action", "process_finished");
      ((HashMap)localObject).put("process_action", "failed");
      ((HashMap)localObject).put("error_code", Integer.valueOf(4194304));
      ((HashMap)localObject).put("error_reason_code", Integer.valueOf(4194304));
      ((HashMap)localObject).put("message", str);
      YtFSM.getInstance().sendFSMEvent((HashMap)localObject);
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
    }
    label225:
    do
    {
      return;
      this.continueNoValidFaceCount = 0;
      if ((this.needManualTrigger) && (this.predetectCountdowner.checkTimeout()))
      {
        YtLogger.d(TAG, "predectcountdowner.checkTimeout(): " + this.predetectCountdowner.checkTimeout());
        this.predetectCountdowner.cancel();
        YtSDKStats.getInstance().reportError(4194307, "yt_verify_step_timeout");
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
        return;
      }
      if (this.countdowner.checkTimeout())
      {
        this.countdowner.cancel();
        YtLogger.d(TAG, "liveness timeout");
        YtSDKStats.getInstance().reportError(4194307, "yt_verify_step_timeout");
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
        return;
      }
    } while ((this.needManualTrigger != true) && (!this.isFirstStablePass) && (this.detectAvailableCount <= this.stableCountNum));
    this.isFirstStablePass = true;
    this.predetectCountdowner.cancel();
    switch (SilentLivenessState.2.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
    {
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
      return;
    case 4: 
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
      return;
    }
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.LIPREAD_STATE));
  }
  
  public void reset()
  {
    this.prevAdvise = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    this.detectAvailableCount = 0;
    this.continueCloseEyeCount = 0;
    this.triggerLiveBeginEventFlag = false;
    this.sameFaceTipCount = 0;
    this.maxEyeScore = -99999.0F;
    this.minMouthScore = 99999.0F;
    this.isFirstStablePass = false;
    this.continueNoValidFaceCount = 0;
    this.countdowner.cancel();
    this.predetectCountdowner.cancel();
    if (!this.needManualTrigger) {
      this.countdowner.reset();
    }
    for (;;)
    {
      super.reset();
      return;
      this.predetectCountdowner.reset();
    }
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
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    if ((this.countdowner.checkTimeout()) || ((this.needManualTrigger) && (this.predetectCountdowner.checkTimeout()))) {
      moveToNextState();
    }
    do
    {
      return;
      YTFaceTrack localYTFaceTrack = YTFaceTrack.getInstance();
      Object localObject = new YTFaceTrack.YTImage();
      ((YTFaceTrack.YTImage)localObject).width = paramInt1;
      ((YTFaceTrack.YTImage)localObject).height = paramInt2;
      float[] arrayOfFloat = new float[1];
      CommonUtils.benchMarkBegin("detect");
      paramArrayOfByte = localYTFaceTrack.DoDetectionProcessYUVWithBlur(paramArrayOfByte, paramInt1, paramInt2, this.cameraRotateState, true, arrayOfFloat, (YTFaceTrack.YTImage)localObject);
      CommonUtils.benchMarkEnd("detect");
      YtLogger.d(TAG, CommonUtils.getBenchMarkTime("detect"));
      YtLogger.d(TAG, "Blur score:" + Arrays.toString(arrayOfFloat));
      if (paramArrayOfByte != null) {
        YtLogger.i(TAG, "face status count " + paramArrayOfByte.length);
      }
      for (;;)
      {
        sendUITipEvent(paramArrayOfByte);
        this.stateData.put("blur_score", Float.valueOf(arrayOfFloat[0]));
        this.stateData.put("face_status", paramArrayOfByte);
        this.stateData.put("pose_state", this.prevAdvise);
        this.stateData.put("shelter_state", Integer.valueOf(this.prevJudge));
        this.stateData.put("continuous_detect_count", Integer.valueOf(this.detectAvailableCount));
        if (((YTFaceTrack.YTImage)localObject).data != null) {
          break;
        }
        YtLogger.e(TAG, "yuv image data is null");
        return;
        YtLogger.i(TAG, "face status is null");
      }
      localObject = new YuvImage(((YTFaceTrack.YTImage)localObject).data, 17, paramInt2, paramInt1, null);
      if ((!this.stateData.containsKey("last_frame")) && (this.detectAvailableCount > this.stableCountNum))
      {
        this.stateData.put("last_face_status", paramArrayOfByte);
        this.stateData.put("last_frame", localObject);
      }
      if (this.prevAdvise == SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) {
        checkBestImage(paramArrayOfByte[0], (YuvImage)localObject);
      }
    } while ((this.needManualTrigger) && ((this.needManualTrigger != true) || (this.triggerLiveBeginEventFlag != true)));
    moveToNextState();
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject)
  {
    try
    {
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
      if (paramJSONObject.has("stable_frame_num")) {
        this.stableCountNum = paramJSONObject.getInt("stable_frame_num");
      }
      if (paramJSONObject.has("net_request_timeout_ms")) {
        YtSDKKitFramework.getInstance().setNetworkRequestTimeoutMS(paramJSONObject.getInt("net_request_timeout_ms"));
      }
      if (paramJSONObject.has("force_pose_check")) {
        this.needCheckPose = paramJSONObject.getBoolean("force_pose_check");
      }
      if (paramJSONObject.has("novalid_face_count")) {
        this.continueNovalidFaceCountThreshold = paramJSONObject.getInt("novalid_face_count");
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      YtLogger.e(TAG, "Failed to parse json:" + paramJSONObject.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState
 * JD-Core Version:    0.7.0.1
 */