package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.youtu.YTFaceTracker;
import com.tencent.youtu.YTFaceTracker.Param;
import com.tencent.youtu.YTFaceTracker.TrackedFace;
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
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SilentLivenessState
  extends YtFSMBaseState
{
  private static final int CONTINUOUS_DETECT_COUNT = 3;
  private static final String TAG = SilentLivenessState.class.getSimpleName();
  private float bigFaceThresholdBuffer = 0.05F;
  private float bigfaceThreshold = 1.0F;
  private float blurDetectThreshold = 0.3F;
  private int cameraRotateState;
  private String configIniName = "yt_model_config.ini";
  private int continueCloseEyeCount = 0;
  private int continueNoValidFaceCount = 0;
  private int continueNovalidFaceCountThreshold = 5;
  private int continueShelterJudgeCount = 0;
  private TimeoutCounter countdowner = new TimeoutCounter("Liveness timeout counter");
  private int currentAdviseTip = 0;
  private int currentShelterJudge = -1;
  private int detectAvailableCount = 0;
  private int detectIntervalCount = 5;
  private String extraTips = "";
  private float eyeOpenThreshold = 0.22F;
  private int frameNum = 0;
  private float inRectThreshold = 0.7F;
  float intersectRatio = -1.0E+010F;
  private int invalidPointCount;
  private boolean isFirstStablePass = false;
  private boolean isLoadResourceOnline = false;
  private float maskHeightRatio;
  private float maskWidthRatio;
  private float maxEyeScore = -1.0E+010F;
  private float maxInRectRatio = -1.0E+010F;
  private float maxMouthScore = -1.0E+010F;
  private float maxShelterScore = -1.0E+010F;
  private float minEyeScore = 1.0E+010F;
  private float minMouthScore = 1.0E+010F;
  private boolean needBigFaceMode = true;
  private boolean needCheckEyeOpen = false;
  private boolean needCheckMultiFaces = false;
  private boolean needCheckPose = false;
  private boolean needCheckShelter = true;
  private boolean needManualTrigger = false;
  private boolean needTimeoutTimer = false;
  private int pitchThreshold = 30;
  private float poseThresholdBuffer = 0.05F;
  private TimeoutCounter predetectCountdowner = new TimeoutCounter("Predetect timeout counter");
  private int prevAdvise = -1;
  private int prevJudge = -1;
  private int previewHeight;
  private int previewWidth;
  private Rect previousFaceRect = null;
  private int previousShelterJudge = 0;
  private String resourceDownloadPath = "";
  private int rollThreshold = 25;
  private int sameFaceTipCount = 0;
  private float smallFaceThresholdBuffer = 0.05F;
  private float smallfaceThreshold = 0.5F;
  private int stableCountNum = 5;
  private int stableFaceCount = 0;
  private float stableRoiThreshold = 0.9F;
  private boolean tipFilterFlag = true;
  private boolean triggerLiveBeginEventFlag = false;
  private int unstableCount = 0;
  private int yawThreshold = 25;
  private YTFaceTracker ytFaceTracker = null;
  
  private void checkBestImage(YTFaceTracker.TrackedFace paramTrackedFace, YuvImage paramYuvImage)
  {
    int i = 0;
    float[] arrayOfFloat = YtSDKKitCommon.ProcessHelper.calcEyeScore(paramTrackedFace.faceShape);
    float f2 = YtSDKKitCommon.ProcessHelper.calcMouthScore(paramTrackedFace.faceShape);
    float f1 = 0.0F;
    float f3 = arrayOfFloat[0];
    f3 = arrayOfFloat[1] + f3;
    while (i < paramTrackedFace.faceVisible.length)
    {
      f1 += paramTrackedFace.faceVisible[i];
      i += 1;
    }
    if (this.stableFaceCount < this.stableCountNum) {
      YtLogger.e(TAG, "stable count " + this.stableFaceCount);
    }
    do
    {
      return;
      if (this.intersectRatio < this.maxInRectRatio - 0.05D) {
        break label510;
      }
      this.maxInRectRatio = this.intersectRatio;
      if (this.needCheckShelter)
      {
        if (this.maxShelterScore > f1) {
          break;
        }
        this.maxShelterScore = f1;
      }
      YtLogger.d(TAG, "test2 shelter score " + f1 + " inRectThreshold " + this.intersectRatio + " eye " + f3 + " mouth " + f2);
      if ((f3 >= this.maxEyeScore - 0.05D) && (f2 <= Math.max(this.minMouthScore, 15.0F)))
      {
        YtLogger.d(TAG, "best shelter score " + f1 + " inRectThreshold " + this.intersectRatio);
        this.maxEyeScore = f3;
        this.minMouthScore = f2;
        this.stateData.put("best_image", paramYuvImage);
        this.stateData.put("best_shape", paramTrackedFace.faceShape);
        this.stateData.put("best_face_status", paramTrackedFace);
      }
      if (f3 < this.minEyeScore)
      {
        this.minEyeScore = f3;
        this.stateData.put("closeeye_image", paramYuvImage);
        this.stateData.put("closeeye_shape", paramTrackedFace.faceShape);
        this.stateData.put("closeeye_face_status", paramTrackedFace);
      }
    } while (f2 <= this.maxMouthScore);
    this.maxMouthScore = f2;
    this.stateData.put("openmouth_image", paramYuvImage);
    this.stateData.put("openmouth_shape", paramTrackedFace.faceShape);
    this.stateData.put("openmouth_face_status", paramTrackedFace);
    return;
    YtLogger.d(TAG, "test1 shelter score " + f1 + " inRectThreshold " + this.intersectRatio + " eye " + f3 + " mouth " + f2);
    return;
    label510:
    YtLogger.d(TAG, "test3 shelter score " + f1 + " inRectThreshold " + this.intersectRatio + " (" + this.maxInRectRatio + ") eye " + f3 + " mouth " + f2);
  }
  
  private float[] convert130PtsTo90Pts(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat1 = new float['´'];
    int[] arrayOfInt = new int[13];
    int[] tmp15_13 = arrayOfInt;
    tmp15_13[0] = 0;
    int[] tmp19_15 = tmp15_13;
    tmp19_15[1] = 4;
    int[] tmp23_19 = tmp19_15;
    tmp23_19[2] = 18;
    int[] tmp28_23 = tmp23_19;
    tmp28_23[3] = 19;
    int[] tmp33_28 = tmp28_23;
    tmp33_28[4] = 7;
    int[] tmp38_33 = tmp33_28;
    tmp38_33[5] = 8;
    int[] tmp43_38 = tmp38_33;
    tmp43_38[6] = 10;
    int[] tmp49_43 = tmp43_38;
    tmp49_43[7] = 11;
    int[] tmp55_49 = tmp49_43;
    tmp55_49[8] = 12;
    int[] tmp61_55 = tmp55_49;
    tmp61_55[9] = 14;
    int[] tmp67_61 = tmp61_55;
    tmp67_61[10] = 15;
    int[] tmp73_67 = tmp67_61;
    tmp73_67[11] = 21;
    int[] tmp79_73 = tmp73_67;
    tmp79_73[12] = 20;
    tmp79_73;
    int k = 0;
    int i = 0;
    int j = 0;
    while (k < 32)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[j];
      j += 1;
      k += 1;
      i += 1;
    }
    k = 0;
    while (k < 32)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[j];
      j += 1;
      k += 1;
      i += 1;
    }
    float[] arrayOfFloat2 = new float[44];
    k = 0;
    while (k < 44)
    {
      arrayOfFloat2[k] = paramArrayOfFloat[j];
      k += 1;
      j += 1;
    }
    arrayOfFloat2[16] = ((arrayOfFloat2[16] + arrayOfFloat2[18]) / 2.0F);
    arrayOfFloat2[19] = ((arrayOfFloat2[19] + arrayOfFloat2[19]) / 2.0F);
    arrayOfFloat2[28] = ((arrayOfFloat2[28] + arrayOfFloat2[26]) / 2.0F);
    arrayOfFloat2[29] = ((arrayOfFloat2[29] + arrayOfFloat2[27]) / 2.0F);
    k = 0;
    while (k < 13)
    {
      int m = i + 1;
      arrayOfFloat1[i] = arrayOfFloat2[(arrayOfInt[k] * 2)];
      arrayOfFloat1[m] = arrayOfFloat2[(arrayOfInt[k] * 2 + 1)];
      k += 1;
      i = m + 1;
    }
    k = 0;
    while (k < 44)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[j];
      j += 1;
      k += 1;
      i += 1;
    }
    k = 0;
    if (k < 82)
    {
      if (k / 2 % 2 == 1) {}
      for (;;)
      {
        j += 1;
        k += 1;
        break;
        arrayOfFloat1[i] = paramArrayOfFloat[j];
        i += 1;
      }
    }
    k = 0;
    while (k < 14)
    {
      k += 1;
      j += 1;
    }
    k = 0;
    while (k < 4)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[j];
      k += 1;
      j += 1;
      i += 1;
    }
    return arrayOfFloat1;
  }
  
  private YTFaceTracker.TrackedFace[] convert130To90(YTFaceTracker.TrackedFace[] paramArrayOfTrackedFace)
  {
    if (paramArrayOfTrackedFace != null)
    {
      int i = 0;
      while (i < paramArrayOfTrackedFace.length)
      {
        paramArrayOfTrackedFace[i].faceShape = convert130PtsTo90Pts(paramArrayOfTrackedFace[i].faceShape);
        paramArrayOfTrackedFace[i].faceVisible = convert130VisTo90Vis(paramArrayOfTrackedFace[i].faceVisible);
        i += 1;
      }
    }
    return paramArrayOfTrackedFace;
  }
  
  private float[] convert130VisTo90Vis(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat1 = new float[90];
    int k = 0;
    int i = 0;
    int j = 0;
    while (k < 16)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[j];
      j += 1;
      k += 1;
      i += 1;
    }
    k = 0;
    while (k < 16)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[j];
      j += 1;
      k += 1;
      i += 1;
    }
    float[] arrayOfFloat2 = new float[22];
    k = 0;
    while (k < 22)
    {
      arrayOfFloat2[k] = paramArrayOfFloat[j];
      k += 1;
      j += 1;
    }
    arrayOfFloat2[8] = ((arrayOfFloat2[8] + arrayOfFloat2[9]) / 2.0F);
    arrayOfFloat2[14] = ((arrayOfFloat2[14] + arrayOfFloat2[13]) / 2.0F);
    k = 0;
    while (k < 13)
    {
      arrayOfFloat1[i] = arrayOfFloat2[new int[] { 0, 4, 18, 19, 7, 8, 10, 11, 12, 14, 15, 21, 20 }[k]];
      k += 1;
      i += 1;
    }
    k = 0;
    while (k < 22)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[j];
      j += 1;
      k += 1;
      i += 1;
    }
    k = 0;
    if (k < 41)
    {
      if (k % 2 == 1) {}
      for (;;)
      {
        j += 1;
        k += 1;
        break;
        arrayOfFloat1[i] = paramArrayOfFloat[j];
        i += 1;
      }
    }
    k = 0;
    while (k < 7)
    {
      k += 1;
      j += 1;
    }
    k = 0;
    while (k < 2)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[j];
      k += 1;
      j += 1;
      i += 1;
    }
    return arrayOfFloat1;
  }
  
  public static String convertAdvise(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 9)) {
      return "fl_pose_keep";
    }
    if (paramInt == 4) {
      return "fl_pose_not_in_rect";
    }
    if (paramInt == 2) {
      return "fl_pose_closer";
    }
    if (paramInt == 3) {
      return "fl_pose_farer";
    }
    if (paramInt == 5) {
      return "fl_pose_incorrect";
    }
    if (paramInt == 1) {
      return "fl_no_face";
    }
    if (paramInt == 6) {
      return "fl_pose_open_eye";
    }
    if (paramInt == 8) {
      return "fl_incomplete_face";
    }
    if (paramInt == 7) {
      return "fl_too_many_faces";
    }
    return "fl_act_silence";
  }
  
  private int getFacePreviewAdvise(Rect paramRect1, Rect paramRect2, YTFaceTracker.TrackedFace paramTrackedFace)
  {
    int i = 1;
    int j = 0;
    if (paramTrackedFace == null)
    {
      this.currentAdviseTip = i;
      if (j != 0) {
        i = 9;
      }
      return i;
    }
    Rect localRect = new Rect(0, 0, 0, 0);
    YtLogger.d(TAG, "camera" + this.previewWidth + "x" + this.previewHeight + " ratio " + this.maskWidthRatio + "x" + this.maskHeightRatio);
    YtLogger.d(TAG, "detectrect :" + paramRect1.left + " " + paramRect1.top + " " + paramRect1.right + " " + paramRect1.bottom);
    localRect.left = ((int)(paramRect2.left * this.maskWidthRatio));
    localRect.right = ((int)(paramRect2.right * this.maskWidthRatio));
    localRect.top = ((int)(paramRect2.top * this.maskHeightRatio));
    localRect.bottom = ((int)(paramRect2.bottom * this.maskHeightRatio));
    this.invalidPointCount = 0;
    i = 0;
    int k;
    while (i < paramTrackedFace.faceShape.length / 2)
    {
      k = (int)paramTrackedFace.faceShape[(i * 2)];
      k = (int)paramTrackedFace.faceShape[(i * 2 + 1)];
      if ((paramTrackedFace.faceShape[(i * 2)] > this.previewWidth) || (paramTrackedFace.faceShape[(i * 2)] < 0.0F) || (paramTrackedFace.faceShape[(i * 2 + 1)] < 0.0F) || (paramTrackedFace.faceShape[(i * 2 + 1)] > this.previewHeight)) {
        this.invalidPointCount += 1;
      }
      i += 1;
    }
    paramRect1 = getIntersectionRect(paramRect1, localRect);
    float f = paramRect1.width();
    this.intersectRatio = Math.abs(paramRect1.height() * f / localRect.width() / localRect.height());
    YtLogger.d(TAG, "faceInMask : " + localRect.left + " " + localRect.top + " " + localRect.right + " " + localRect.bottom + " in rect ratio" + this.intersectRatio);
    f = Math.abs((paramRect2.right - paramRect2.left) / (this.previewWidth * 1.0F));
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
      if (this.invalidPointCount >= 3)
      {
        YtLogger.w(TAG, "face incomplete invalid point count:" + this.invalidPointCount);
        i = 8;
        break;
      }
      if (f > this.bigfaceThreshold)
      {
        YtLogger.w(TAG, "face too big:" + f);
        if (f > this.bigfaceThreshold + this.bigFaceThresholdBuffer) {
          break label1194;
        }
        j = 1;
        i = 3;
        break;
      }
      if (this.intersectRatio < this.inRectThreshold)
      {
        YtLogger.w(TAG, "face not in rect ratio:" + this.intersectRatio);
        i = 4;
        break;
      }
      if (f < this.smallfaceThreshold)
      {
        YtLogger.w(TAG, "face too small:" + f);
        i = 2;
        if (f < this.smallfaceThreshold - this.smallFaceThresholdBuffer) {
          break label1191;
        }
        j = 1;
        i = 2;
        break;
      }
      if ((i != 0) && ((Math.abs(paramTrackedFace.pitch) > this.pitchThreshold) || (Math.abs(paramTrackedFace.yaw) > this.yawThreshold) || (Math.abs(paramTrackedFace.roll) > this.rollThreshold)))
      {
        YtLogger.w(TAG, "face pose not right (" + paramTrackedFace.pitch + "," + paramTrackedFace.yaw + "," + paramTrackedFace.roll + ")");
        k = 5;
        i = k;
        if (Math.abs(paramTrackedFace.pitch) > this.pitchThreshold + this.poseThresholdBuffer) {
          break label1191;
        }
        i = k;
        if (Math.abs(paramTrackedFace.yaw) > this.yawThreshold + this.poseThresholdBuffer) {
          break label1191;
        }
        i = k;
        if (Math.abs(paramTrackedFace.roll) > this.rollThreshold + this.poseThresholdBuffer) {
          break label1191;
        }
        j = 1;
        i = 5;
        break;
      }
      if ((this.needCheckEyeOpen) && (!isActionStage()))
      {
        f = YtSDKKitCommon.ProcessHelper.preCheckCloseEyeScore(paramTrackedFace.faceShape);
        YtLogger.d(TAG, "eye score:" + f + " cnt:" + this.continueCloseEyeCount);
        if (f < this.eyeOpenThreshold)
        {
          this.continueCloseEyeCount += 1;
          this.detectAvailableCount -= 1;
          if (this.detectAvailableCount < 0) {
            this.detectAvailableCount = 0;
          }
          label1128:
          if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE) {
            break label1185;
          }
        }
      }
      label1185:
      for (i = 10;; i = 4)
      {
        if (this.continueCloseEyeCount >= i)
        {
          i = 6;
          this.continueCloseEyeCount = 0;
        }
        for (;;)
        {
          break;
          this.continueCloseEyeCount = 0;
          break label1128;
          i = 0;
        }
        i = 0;
        break;
      }
      label1191:
      break;
      label1194:
      i = 3;
      break;
    }
  }
  
  private Rect getFaceRect(YTFaceTracker.TrackedFace paramTrackedFace)
  {
    float f4 = paramTrackedFace.faceShape[0];
    float f3 = paramTrackedFace.faceShape[0];
    float f2 = paramTrackedFace.faceShape[1];
    float f1 = paramTrackedFace.faceShape[1];
    int i = 0;
    while (i < 180)
    {
      f4 = Math.min(f4, paramTrackedFace.faceShape[i]);
      f3 = Math.max(f3, paramTrackedFace.faceShape[i]);
      i += 1;
      f2 = Math.min(f2, paramTrackedFace.faceShape[i]);
      f1 = Math.max(f1, paramTrackedFace.faceShape[i]);
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
      paramTrackedFace = new Rect();
      paramTrackedFace.left = ((int)f3);
      paramTrackedFace.top = ((int)f1);
      paramTrackedFace.right = ((int)f4);
      paramTrackedFace.bottom = ((int)f5);
      return paramTrackedFace;
      f4 = f2;
      break;
      f2 = f6;
      break label301;
    }
  }
  
  private int getPoseJudge(YTFaceTracker.TrackedFace[] paramArrayOfTrackedFace)
  {
    paramArrayOfTrackedFace = paramArrayOfTrackedFace[0];
    Rect localRect1 = getFaceRect(paramArrayOfTrackedFace);
    if (this.previousFaceRect == null)
    {
      this.previousFaceRect = localRect1;
      this.stableFaceCount = 0;
      YtLogger.d(TAG, "rect is: " + localRect1.left + ", " + localRect1.top + ", " + localRect1.right + ", " + localRect1.bottom);
      return getFacePreviewAdvise(YtSDKKitFramework.getInstance().getDetectRect(), localRect1, paramArrayOfTrackedFace);
    }
    Rect localRect2 = getIntersectionRect(localRect1, this.previousFaceRect);
    if ((localRect1.height() != 0) && (localRect1.width() != 0))
    {
      float f = localRect2.width();
      f = Math.abs(localRect2.height() * f / localRect1.height() / localRect1.width());
      YtLogger.d(TAG, "pose ratio " + f);
      if (f >= this.stableRoiThreshold) {
        break label219;
      }
      this.extraTips = "fl_act_screen_shaking";
    }
    for (this.stableFaceCount = 0;; this.stableFaceCount += 1)
    {
      this.previousFaceRect = localRect1;
      break;
      label219:
      this.extraTips = "";
    }
  }
  
  private int getShelterJudge(YTFaceTracker.TrackedFace[] paramArrayOfTrackedFace)
  {
    int i = shelterJudge(paramArrayOfTrackedFace[0].faceVisible);
    if (this.currentShelterJudge != i)
    {
      this.continueShelterJudgeCount = 0;
      this.currentShelterJudge = i;
    }
    while ((this.frameNum >= 7) && (this.continueShelterJudgeCount < 7))
    {
      return this.previousShelterJudge;
      this.continueShelterJudgeCount += 1;
    }
    this.previousShelterJudge = this.currentShelterJudge;
    return i;
  }
  
  private void initYoutuInstance()
  {
    Context localContext = YtFSM.getInstance().getContext().currentAppContext;
    Object localObject = localContext.getFilesDir().getAbsolutePath();
    if (this.isLoadResourceOnline)
    {
      localObject = this.resourceDownloadPath;
      YtLogger.i(TAG, "Use online path:" + (String)localObject);
    }
    for (;;)
    {
      try
      {
        if (!this.isLoadResourceOnline)
        {
          YtLogger.i(TAG, "init from asset");
          this.ytFaceTracker = new YTFaceTracker(localContext.getAssets(), "models/face-tracker-v001", this.configIniName);
          localObject = this.ytFaceTracker.getParam();
          YtLogger.i(TAG, "big face mode" + this.needBigFaceMode);
          if (this.needBigFaceMode)
          {
            i = 1;
            ((YTFaceTracker.Param)localObject).biggerFaceMode = i;
            ((YTFaceTracker.Param)localObject).minFaceSize = Math.max(Math.min(this.previewWidth, this.previewHeight) / 5, 40);
            ((YTFaceTracker.Param)localObject).detInterval = this.detectIntervalCount;
            YTFaceTracker.getVersion();
            YtLogger.i(TAG, "Detect version:" + YTFaceTracker.getVersion());
            return;
            YtLogger.i(TAG, "Use local path:" + (String)localObject);
          }
        }
        else
        {
          YtLogger.i(TAG, "init from filesystem");
          this.ytFaceTracker = new YTFaceTracker((String)localObject, this.configIniName);
          continue;
        }
        int i = 0;
      }
      catch (Exception localException)
      {
        YtSDKStats.getInstance().reportError(300101, "模式初始化失败");
        YtFSM.getInstance().sendFSMEvent(new SilentLivenessState.1(this));
        localException.printStackTrace();
        return;
      }
    }
  }
  
  private boolean isActionStage()
  {
    return (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE) || (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE);
  }
  
  private void sendFSMEvent(HashMap<String, Object> paramHashMap)
  {
    YtFSM.getInstance().sendFSMEvent(paramHashMap);
  }
  
  private void sendFaceStatusUITips(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (((paramInt1 != 0) && (paramInt1 != 9)) || (paramInt2 != 0))
    {
      localHashMap.put("ui_action", "not_pass");
      this.detectAvailableCount = 0;
      if ((paramInt1 != this.prevAdvise) || (paramInt2 != this.prevJudge)) {
        break label101;
      }
    }
    label101:
    for (this.sameFaceTipCount += 1;; this.sameFaceTipCount = 0)
    {
      if ((!this.tipFilterFlag) || (this.sameFaceTipCount <= 3) || (this.currentAdviseTip != paramInt1)) {
        break label109;
      }
      return;
      this.detectAvailableCount += 1;
      break;
    }
    label109:
    this.prevAdvise = paramInt1;
    this.prevJudge = paramInt2;
    YtLogger.d(TAG, " tips:" + convertAdvise(this.currentAdviseTip));
    if ((this.currentAdviseTip == 0) || (this.currentAdviseTip == 9)) {
      if (paramInt2 == 1) {
        localHashMap.put("ui_tips", "fl_no_left_face");
      }
    }
    for (;;)
    {
      if (this.extraTips != "") {
        localHashMap.put("ui_extra_tips", this.extraTips);
      }
      sendFSMEvent(localHashMap);
      return;
      if (paramInt2 == 2)
      {
        localHashMap.put("ui_tips", "fl_no_chin");
      }
      else if (paramInt2 == 3)
      {
        localHashMap.put("ui_tips", "fl_no_mouth");
      }
      else if (paramInt2 == 4)
      {
        localHashMap.put("ui_tips", "fl_no_right_face");
      }
      else if (paramInt2 == 5)
      {
        localHashMap.put("ui_tips", "fl_no_nose");
      }
      else if (paramInt2 == 6)
      {
        localHashMap.put("ui_tips", "fl_no_right_eye");
      }
      else if (paramInt2 == 7)
      {
        localHashMap.put("ui_tips", "fl_no_left_eye");
      }
      else if ((paramInt2 == 0) && (this.sameFaceTipCount > 2) && (this.sameFaceTipCount < 5))
      {
        localHashMap.put("ui_tips", "fl_pose_keep");
        localHashMap.put("ui_action", "pass");
        continue;
        localHashMap.put("ui_tips", convertAdvise(this.currentAdviseTip));
      }
    }
  }
  
  private void sendUITipEvent(YTFaceTracker.TrackedFace[] paramArrayOfTrackedFace)
  {
    int i = 1;
    int j = -1;
    HashMap localHashMap = new HashMap();
    if (paramArrayOfTrackedFace == null) {
      if (YtFSM.getInstance().getContext().baseFunctionListener == null) {
        break label509;
      }
    }
    label391:
    label499:
    label504:
    label509:
    for (paramArrayOfTrackedFace = YtFSM.getInstance().getContext().baseFunctionListener.getFrameResult(null);; paramArrayOfTrackedFace = null)
    {
      if (paramArrayOfTrackedFace != null)
      {
        if (!paramArrayOfTrackedFace.containsKey("Advise")) {
          break label504;
        }
        i = ((Integer)paramArrayOfTrackedFace.get("Advise")).intValue();
        this.currentAdviseTip = i;
      }
      for (;;)
      {
        sendFaceStatusUITips(i, j);
        if (localHashMap.size() > 0) {
          sendFSMEvent(localHashMap);
        }
        return;
        this.currentAdviseTip = 1;
        continue;
        if (paramArrayOfTrackedFace.length > 1)
        {
          localHashMap.put("ui_error", "Failed");
          if (!this.needCheckMultiFaces) {
            break label499;
          }
          this.detectAvailableCount = 0;
          this.prevAdvise = 7;
        }
        for (i = 7;; i = -1)
        {
          this.currentAdviseTip = 7;
          break;
          if (YtFSM.getInstance().getContext().baseFunctionListener != null)
          {
            Object localObject1 = new SilentLivenessState.YtFaceStatus(this);
            Object localObject2 = getFaceRect(paramArrayOfTrackedFace[0]);
            ((SilentLivenessState.YtFaceStatus)localObject1).x = ((Rect)localObject2).left;
            ((SilentLivenessState.YtFaceStatus)localObject1).y = ((Rect)localObject2).top;
            ((SilentLivenessState.YtFaceStatus)localObject1).w = (((Rect)localObject2).right - ((Rect)localObject2).left);
            ((SilentLivenessState.YtFaceStatus)localObject1).h = (((Rect)localObject2).bottom - ((Rect)localObject2).top);
            ((SilentLivenessState.YtFaceStatus)localObject1).pitch = paramArrayOfTrackedFace[0].pitch;
            ((SilentLivenessState.YtFaceStatus)localObject1).yaw = paramArrayOfTrackedFace[0].yaw;
            ((SilentLivenessState.YtFaceStatus)localObject1).roll = paramArrayOfTrackedFace[0].roll;
            ((SilentLivenessState.YtFaceStatus)localObject1).illuminationScore = 0;
            localObject2 = YtSDKKitCommon.ProcessHelper.calcEyeScore(paramArrayOfTrackedFace[0].faceShape);
            ((SilentLivenessState.YtFaceStatus)localObject1).leftEyeOpenScore = localObject2[0];
            ((SilentLivenessState.YtFaceStatus)localObject1).rightEyeOpenScore = localObject2[1];
            ((SilentLivenessState.YtFaceStatus)localObject1).mouthOpenScore = YtSDKKitCommon.ProcessHelper.calcMouthScore(paramArrayOfTrackedFace[0].faceShape);
            ((SilentLivenessState.YtFaceStatus)localObject1).xys = paramArrayOfTrackedFace[0].faceShape;
            ((SilentLivenessState.YtFaceStatus)localObject1).pointsVis = paramArrayOfTrackedFace[0].faceVisible;
            localObject1 = YtFSM.getInstance().getContext().baseFunctionListener.getFrameResult(localObject1);
            if (localObject1 != null) {
              if (((HashMap)localObject1).containsKey("Advise"))
              {
                i = ((Integer)((HashMap)localObject1).get("Advise")).intValue();
                if (((HashMap)localObject1).containsKey("Shelter")) {
                  j = ((Integer)((HashMap)localObject1).get("Shelter")).intValue();
                }
              }
            }
          }
          for (;;)
          {
            int k = i;
            if (i == -1) {
              k = getPoseJudge(paramArrayOfTrackedFace);
            }
            YtLogger.i(TAG, "advise " + k);
            if (j == -1)
            {
              j = getShelterJudge(paramArrayOfTrackedFace);
              i = k;
              break;
            }
            i = k;
            break;
            j = -1;
            continue;
            i = -1;
            break label391;
            j = -1;
            i = -1;
          }
        }
        i = -1;
      }
    }
  }
  
  public static int shelterJudge(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      YtLogger.e(TAG, "[YTFaceTraceInterface.blockJudge] input pointsVis is null.");
      return -1;
    }
    if (paramArrayOfFloat.length != 90)
    {
      YtLogger.e(TAG, "[YTFaceTraceInterface.blockJudge] input pointsVis.length != 90. current pointsVis.length: " + paramArrayOfFloat.length);
      return -2;
    }
    int i = 33;
    int k;
    for (int j = 0; i <= 45; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.8F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 4) {
      return 5;
    }
    i = 46;
    for (j = 0; i <= 67; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.8F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 4) {
      return 3;
    }
    j = 9;
    for (i = 0; j <= 16; i = k)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.9F) {
        k = i + 1;
      }
      j += 1;
    }
    j = 25;
    while (j <= 32)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.9F) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    j = i;
    if (paramArrayOfFloat[89] < 0.7F) {
      j = i + 1;
    }
    if (j >= 4) {
      return 6;
    }
    j = 1;
    for (i = 0; j <= 8; i = k)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.9F) {
        k = i + 1;
      }
      j += 1;
    }
    j = 17;
    while (j <= 24)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.9F) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    j = i;
    if (paramArrayOfFloat[88] < 0.9F) {
      j = i + 1;
    }
    if (j >= 4) {
      return 7;
    }
    i = 68;
    for (j = 0; i < 74; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.95F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 3) {
      return 1;
    }
    i = 82;
    for (j = 0; i <= 88; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.95F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 3) {
      return 4;
    }
    i = 75;
    for (j = 0; i <= 81; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.95F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 3) {
      return 2;
    }
    return 0;
  }
  
  public void enter()
  {
    super.enter();
  }
  
  public void enterFirst()
  {
    this.stateData.put("detect_instance", this.ytFaceTracker);
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
  
  Rect getIntersectionRect(Rect paramRect1, Rect paramRect2)
  {
    return new Rect(Math.max(paramRect1.left, paramRect2.left), Math.max(paramRect1.top, paramRect2.top), Math.min(paramRect1.right, paramRect2.right), Math.min(paramRect1.bottom, paramRect2.bottom));
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
        this.configIniName = paramJSONObject.optString("model_config_ini_name", "yt_model_config.ini");
        this.needCheckMultiFaces = paramJSONObject.optBoolean("need_check_multiface", false);
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
        FileUtils.loadLibrary("YTFaceTracker");
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
    if ((this.needManualTrigger) && (((this.needCheckPose) && (this.prevAdvise != 0) && (this.prevAdvise != 9)) || ((this.needCheckMultiFaces) && (this.prevAdvise == 7)) || (this.prevAdvise == 8) || (this.prevAdvise == 1)))
    {
      this.continueNoValidFaceCount += 1;
      if (this.continueNoValidFaceCount <= this.continueNovalidFaceCountThreshold) {
        break label221;
      }
      Object localObject = convertAdvise(this.prevAdvise);
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
    label221:
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
    this.prevAdvise = -1;
    this.detectAvailableCount = 0;
    this.continueCloseEyeCount = 0;
    this.frameNum = 0;
    this.triggerLiveBeginEventFlag = false;
    this.sameFaceTipCount = 0;
    this.maxEyeScore = -1.0E+010F;
    this.minMouthScore = 1.0E+010F;
    this.minEyeScore = 1.0E+010F;
    this.maxMouthScore = -1.0E+010F;
    this.maxShelterScore = -1.0E+010F;
    this.isFirstStablePass = false;
    this.continueNoValidFaceCount = 0;
    this.invalidPointCount = 0;
    this.unstableCount = 0;
    this.maxInRectRatio = -1.0E+010F;
    this.countdowner.cancel();
    this.predetectCountdowner.cancel();
    this.stableFaceCount = 0;
    this.currentShelterJudge = -1;
    this.previousFaceRect = null;
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
    if (this.ytFaceTracker != null) {
      this.ytFaceTracker.destroy();
    }
    this.ytFaceTracker = null;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    if ((this.countdowner.checkTimeout()) || ((this.needManualTrigger) && (this.predetectCountdowner.checkTimeout())))
    {
      moveToNextState();
      return;
    }
    byte[] arrayOfByte = (byte[])paramArrayOfByte.clone();
    this.frameNum += 1;
    float[] arrayOfFloat = new float[1];
    CommonUtils.benchMarkBegin("detect");
    Object localObject;
    try
    {
      paramArrayOfByte = this.ytFaceTracker.track(0, paramArrayOfByte, paramInt1, paramInt2, this.cameraRotateState, true, arrayOfByte);
      if (paramArrayOfByte != null)
      {
        localObject = paramArrayOfByte;
        if (paramArrayOfByte.length != 0) {}
      }
      else
      {
        localObject = null;
      }
      paramArrayOfByte = convert130To90((YTFaceTracker.TrackedFace[])localObject);
      CommonUtils.benchMarkEnd("detect");
      YtLogger.d(TAG, CommonUtils.getBenchMarkTime("detect"));
      YtLogger.d(TAG, "Blur score:" + Arrays.toString(arrayOfFloat));
      if (paramArrayOfByte != null)
      {
        YtLogger.i(TAG, "face status count " + paramArrayOfByte.length);
        if (paramArrayOfByte.length > 1)
        {
          int i = -2147483648;
          k = 0;
          paramInt3 = 0;
          while (paramInt3 < paramArrayOfByte.length)
          {
            localObject = getFaceRect(paramArrayOfByte[paramInt3]);
            int j = ((Rect)localObject).width();
            int m = ((Rect)localObject).height() * j;
            j = i;
            if (m >= i)
            {
              k = paramInt3;
              j = m;
            }
            paramInt3 += 1;
            i = j;
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      int k;
      for (;;)
      {
        YtLogger.e(TAG, paramArrayOfByte.getLocalizedMessage());
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      if (k != 0)
      {
        YtLogger.i(TAG, "Found max face id:" + k);
        paramArrayOfByte[0] = paramArrayOfByte[k];
      }
    }
    for (;;)
    {
      sendUITipEvent(paramArrayOfByte);
      this.stateData.put("pose_state", Integer.valueOf(this.prevAdvise));
      this.stateData.put("shelter_state", Integer.valueOf(this.prevJudge));
      this.stateData.put("face_status", paramArrayOfByte);
      this.stateData.put("continuous_detect_count", Integer.valueOf(this.detectAvailableCount));
      localObject = new YuvImage(arrayOfByte, 17, paramInt2, paramInt1, null);
      this.stateData.put("last_face_status", paramArrayOfByte);
      this.stateData.put("last_frame", localObject);
      if ((this.prevAdvise == 0) || (this.prevAdvise == 9)) {
        checkBestImage(paramArrayOfByte[0], (YuvImage)localObject);
      }
      if ((this.stateData.get("best_image") == null) || ((this.needManualTrigger) && ((this.needManualTrigger != true) || (this.triggerLiveBeginEventFlag != true)))) {
        break;
      }
      moveToNextState();
      return;
      YtLogger.i(TAG, "face status is null");
    }
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
      if (paramJSONObject.has("in_rect_ratio_threshold")) {
        this.inRectThreshold = ((float)paramJSONObject.getDouble("in_rect_ratio_threshold"));
      }
      if (paramJSONObject.has("need_check_shelter")) {
        this.needCheckShelter = paramJSONObject.getBoolean("need_check_shelter");
      }
      if (paramJSONObject.has("stable_roi_threshold")) {
        this.stableRoiThreshold = ((float)paramJSONObject.getDouble("stable_roi_threshold"));
      }
      this.bigFaceThresholdBuffer = ((float)paramJSONObject.optDouble("bigface_ratio_buffer", 0.0500000007450581D));
      this.smallFaceThresholdBuffer = ((float)paramJSONObject.optDouble("smallface_ratio_buffer", 0.0500000007450581D));
      this.poseThresholdBuffer = ((float)paramJSONObject.optDouble("pose_ratio_buffer", 0.0500000007450581D));
      this.stableRoiThreshold = ((float)paramJSONObject.optDouble("stable_roi_threshold", 0.8999999761581421D));
      this.needCheckMultiFaces = paramJSONObject.optBoolean("need_check_multiface", false);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      YtLogger.e(TAG, "Failed to parse json:" + paramJSONObject.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState
 * JD-Core Version:    0.7.0.1
 */