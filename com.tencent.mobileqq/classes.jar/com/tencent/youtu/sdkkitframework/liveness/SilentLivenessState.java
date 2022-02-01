package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.youtu.YTFaceTracker;
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
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SilentLivenessState
  extends YtFSMBaseState
{
  private static final int CONTINUOUS_DETECT_COUNT = 3;
  private static final String TAG = "SilentLivenessState";
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
    Object localObject = YtSDKKitCommon.ProcessHelper.calcEyeScore(paramTrackedFace.faceShape);
    float f2 = YtSDKKitCommon.ProcessHelper.calcMouthScore(paramTrackedFace.faceShape);
    int i = 0;
    float f3 = localObject[0] + localObject[1];
    float f1 = 0.0F;
    while (i < paramTrackedFace.faceVisible.length)
    {
      f1 += paramTrackedFace.faceVisible[i];
      i += 1;
    }
    if (this.stableFaceCount < this.stableCountNum)
    {
      paramTrackedFace = TAG;
      paramYuvImage = new StringBuilder();
      paramYuvImage.append("stable count ");
      paramYuvImage.append(this.stableFaceCount);
      YtLogger.e(paramTrackedFace, paramYuvImage.toString());
      return;
    }
    float f4 = this.intersectRatio;
    double d1 = f4;
    double d2 = this.maxInRectRatio;
    Double.isNaN(d2);
    if (d1 >= d2 - 0.05D)
    {
      this.maxInRectRatio = f4;
      if (this.needCheckShelter) {
        if (this.maxShelterScore <= f1)
        {
          this.maxShelterScore = f1;
        }
        else
        {
          paramTrackedFace = TAG;
          paramYuvImage = new StringBuilder();
          paramYuvImage.append("test1 shelter score ");
          paramYuvImage.append(f1);
          paramYuvImage.append(" inRectThreshold ");
          paramYuvImage.append(this.intersectRatio);
          paramYuvImage.append(" eye ");
          paramYuvImage.append(f3);
          paramYuvImage.append(" mouth ");
          paramYuvImage.append(f2);
          YtLogger.d(paramTrackedFace, paramYuvImage.toString());
          return;
        }
      }
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("test2 shelter score ");
      localStringBuilder.append(f1);
      localStringBuilder.append(" inRectThreshold ");
      localStringBuilder.append(this.intersectRatio);
      localStringBuilder.append(" eye ");
      localStringBuilder.append(f3);
      localStringBuilder.append(" mouth ");
      localStringBuilder.append(f2);
      YtLogger.d((String)localObject, localStringBuilder.toString());
      d1 = f3;
      d2 = this.maxEyeScore;
      Double.isNaN(d2);
      if ((d1 >= d2 - 0.05D) && (f2 <= Math.max(this.minMouthScore, 15.0F)))
      {
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("best shelter score ");
        localStringBuilder.append(f1);
        localStringBuilder.append(" inRectThreshold ");
        localStringBuilder.append(this.intersectRatio);
        YtLogger.d((String)localObject, localStringBuilder.toString());
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
      if (f2 > this.maxMouthScore)
      {
        this.maxMouthScore = f2;
        this.stateData.put("openmouth_image", paramYuvImage);
        this.stateData.put("openmouth_shape", paramTrackedFace.faceShape);
        this.stateData.put("openmouth_face_status", paramTrackedFace);
      }
    }
    else
    {
      paramTrackedFace = TAG;
      paramYuvImage = new StringBuilder();
      paramYuvImage.append("test3 shelter score ");
      paramYuvImage.append(f1);
      paramYuvImage.append(" inRectThreshold ");
      paramYuvImage.append(this.intersectRatio);
      paramYuvImage.append(" (");
      paramYuvImage.append(this.maxInRectRatio);
      paramYuvImage.append(") eye ");
      paramYuvImage.append(f3);
      paramYuvImage.append(" mouth ");
      paramYuvImage.append(f2);
      YtLogger.d(paramTrackedFace, paramYuvImage.toString());
    }
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
    int i2 = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    while (k < 32)
    {
      arrayOfFloat1[j] = paramArrayOfFloat[i];
      k += 1;
      i += 1;
      j += 1;
    }
    k = 0;
    while (k < 32)
    {
      arrayOfFloat1[j] = paramArrayOfFloat[i];
      k += 1;
      i += 1;
      j += 1;
    }
    float[] arrayOfFloat2 = new float[44];
    k = 0;
    while (k < 44)
    {
      arrayOfFloat2[k] = paramArrayOfFloat[i];
      k += 1;
      i += 1;
    }
    arrayOfFloat2[16] = ((arrayOfFloat2[16] + arrayOfFloat2[18]) / 2.0F);
    arrayOfFloat2[19] = ((arrayOfFloat2[19] + arrayOfFloat2[19]) / 2.0F);
    arrayOfFloat2[28] = ((arrayOfFloat2[28] + arrayOfFloat2[26]) / 2.0F);
    arrayOfFloat2[29] = ((arrayOfFloat2[29] + arrayOfFloat2[27]) / 2.0F);
    k = 0;
    while (k < 13)
    {
      m = j + 1;
      arrayOfFloat1[j] = arrayOfFloat2[(arrayOfInt[k] * 2)];
      j = m + 1;
      arrayOfFloat1[m] = arrayOfFloat2[(arrayOfInt[k] * 2 + 1)];
      k += 1;
    }
    int m = 0;
    k = i;
    i = j;
    j = m;
    while (j < 44)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[k];
      j += 1;
      k += 1;
      i += 1;
    }
    m = 0;
    j = k;
    k = m;
    while (k < 82)
    {
      if (k / 2 % 2 != 1)
      {
        arrayOfFloat1[i] = paramArrayOfFloat[j];
        i += 1;
      }
      k += 1;
      j += 1;
    }
    int n = 0;
    int i1;
    for (;;)
    {
      k = i2;
      m = i;
      i1 = j;
      if (n >= 14) {
        break;
      }
      n += 1;
      j += 1;
    }
    while (k < 4)
    {
      arrayOfFloat1[m] = paramArrayOfFloat[i1];
      k += 1;
      i1 += 1;
      m += 1;
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
    int i2 = 0;
    int k = 0;
    int i = 0;
    int j = 0;
    while (k < 16)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[j];
      k += 1;
      j += 1;
      i += 1;
    }
    k = 0;
    while (k < 16)
    {
      arrayOfFloat1[i] = paramArrayOfFloat[j];
      k += 1;
      j += 1;
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
      k += 1;
      j += 1;
      i += 1;
    }
    k = 0;
    while (k < 41)
    {
      if (k % 2 != 1)
      {
        arrayOfFloat1[i] = paramArrayOfFloat[j];
        i += 1;
      }
      k += 1;
      j += 1;
    }
    int n = 0;
    int m;
    int i1;
    for (;;)
    {
      k = i2;
      m = i;
      i1 = j;
      if (n >= 7) {
        break;
      }
      n += 1;
      j += 1;
    }
    while (k < 2)
    {
      arrayOfFloat1[m] = paramArrayOfFloat[i1];
      k += 1;
      i1 += 1;
      m += 1;
    }
    return arrayOfFloat1;
  }
  
  public static String convertAdvise(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 9))
    {
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
    return "fl_pose_keep";
  }
  
  private int getFacePreviewAdvise(Rect paramRect1, Rect paramRect2, YTFaceTracker.TrackedFace paramTrackedFace)
  {
    int i = 4;
    int m = 0;
    int j;
    if (paramTrackedFace == null)
    {
      i = 1;
      j = m;
    }
    else
    {
      Rect localRect = new Rect(0, 0, 0, 0);
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("camera");
      localStringBuilder.append(this.previewWidth);
      localStringBuilder.append("x");
      localStringBuilder.append(this.previewHeight);
      localStringBuilder.append(" ratio ");
      localStringBuilder.append(this.maskWidthRatio);
      localStringBuilder.append("x");
      localStringBuilder.append(this.maskHeightRatio);
      YtLogger.d((String)localObject, localStringBuilder.toString());
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("detectrect :");
      localStringBuilder.append(paramRect1.left);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramRect1.top);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramRect1.right);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramRect1.bottom);
      YtLogger.d((String)localObject, localStringBuilder.toString());
      localRect.left = ((int)(paramRect2.left * this.maskWidthRatio));
      localRect.right = ((int)(paramRect2.right * this.maskWidthRatio));
      localRect.top = ((int)(paramRect2.top * this.maskHeightRatio));
      localRect.bottom = ((int)(paramRect2.bottom * this.maskHeightRatio));
      this.invalidPointCount = 0;
      j = 0;
      int k;
      while (j < paramTrackedFace.faceShape.length / 2)
      {
        localObject = paramTrackedFace.faceShape;
        k = j * 2;
        f = localObject[k];
        localObject = paramTrackedFace.faceShape;
        int n = k + 1;
        f = localObject[n];
        if ((paramTrackedFace.faceShape[k] > this.previewWidth) || (paramTrackedFace.faceShape[k] < 0.0F) || (paramTrackedFace.faceShape[n] < 0.0F) || (paramTrackedFace.faceShape[n] > this.previewHeight)) {
          this.invalidPointCount += 1;
        }
        j += 1;
      }
      paramRect1 = getIntersectionRect(paramRect1, localRect);
      this.intersectRatio = Math.abs(paramRect1.width() * paramRect1.height() / localRect.width() / localRect.height());
      paramRect1 = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("faceInMask : ");
      ((StringBuilder)localObject).append(localRect.left);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(localRect.top);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(localRect.right);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(localRect.bottom);
      ((StringBuilder)localObject).append(" in rect ratio");
      ((StringBuilder)localObject).append(this.intersectRatio);
      YtLogger.d(paramRect1, ((StringBuilder)localObject).toString());
      float f = Math.abs((paramRect2.right - paramRect2.left) / (this.previewWidth * 1.0F));
      paramRect1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
      if (paramRect1 != null)
      {
        paramRect1 = paramRect1.getStateDataBy("current_action_type");
        if (paramRect1 != null)
        {
          j = ((Integer)paramRect1).intValue();
          if ((j == 3) || (j == 4))
          {
            j = 0;
            break label673;
          }
        }
      }
      j = 1;
      label673:
      paramRect1 = TAG;
      paramRect2 = new StringBuilder();
      paramRect2.append("face area ratio:");
      paramRect2.append(f);
      YtLogger.d(paramRect1, paramRect2.toString());
      if (this.invalidPointCount >= 3)
      {
        paramRect1 = TAG;
        paramRect2 = new StringBuilder();
        paramRect2.append("face incomplete invalid point count:");
        paramRect2.append(this.invalidPointCount);
        YtLogger.w(paramRect1, paramRect2.toString());
        i = 8;
        j = m;
      }
      else
      {
        if (f > this.bigfaceThreshold)
        {
          paramRect1 = TAG;
          paramRect2 = new StringBuilder();
          paramRect2.append("face too big:");
          paramRect2.append(f);
          YtLogger.w(paramRect1, paramRect2.toString());
          if (f <= this.bigfaceThreshold + this.bigFaceThresholdBuffer) {
            i = 3;
          }
        }
        for (;;)
        {
          j = 1;
          break label1377;
          i = 3;
          j = m;
          break label1377;
          if (this.intersectRatio < this.inRectThreshold)
          {
            paramRect1 = TAG;
            paramRect2 = new StringBuilder();
            paramRect2.append("face not in rect ratio:");
            paramRect2.append(this.intersectRatio);
            YtLogger.w(paramRect1, paramRect2.toString());
            j = m;
            break label1377;
          }
          if (f < this.smallfaceThreshold)
          {
            paramRect1 = TAG;
            paramRect2 = new StringBuilder();
            paramRect2.append("face too small:");
            paramRect2.append(f);
            YtLogger.w(paramRect1, paramRect2.toString());
            if (f >= this.smallfaceThreshold - this.smallFaceThresholdBuffer)
            {
              i = 2;
            }
            else
            {
              i = 2;
              j = m;
              break label1377;
            }
          }
          else
          {
            if ((j == 0) || ((Math.abs(paramTrackedFace.pitch) <= this.pitchThreshold) && (Math.abs(paramTrackedFace.yaw) <= this.yawThreshold) && (Math.abs(paramTrackedFace.roll) <= this.rollThreshold))) {
              break;
            }
            paramRect1 = TAG;
            paramRect2 = new StringBuilder();
            paramRect2.append("face pose not right (");
            paramRect2.append(paramTrackedFace.pitch);
            paramRect2.append(",");
            paramRect2.append(paramTrackedFace.yaw);
            paramRect2.append(",");
            paramRect2.append(paramTrackedFace.roll);
            paramRect2.append(")");
            YtLogger.w(paramRect1, paramRect2.toString());
            k = 5;
            i = k;
            j = m;
            if (Math.abs(paramTrackedFace.pitch) > this.pitchThreshold + this.poseThresholdBuffer) {
              break label1377;
            }
            i = k;
            j = m;
            if (Math.abs(paramTrackedFace.yaw) > this.yawThreshold + this.poseThresholdBuffer) {
              break label1377;
            }
            i = k;
            j = m;
            if (Math.abs(paramTrackedFace.roll) > this.rollThreshold + this.poseThresholdBuffer) {
              break label1377;
            }
            i = k;
          }
        }
        if ((this.needCheckEyeOpen) && (!isActionStage()))
        {
          f = YtSDKKitCommon.ProcessHelper.preCheckCloseEyeScore(paramTrackedFace.faceShape);
          paramRect1 = TAG;
          paramRect2 = new StringBuilder();
          paramRect2.append("eye score:");
          paramRect2.append(f);
          paramRect2.append(" cnt:");
          paramRect2.append(this.continueCloseEyeCount);
          YtLogger.d(paramRect1, paramRect2.toString());
          if (f < this.eyeOpenThreshold)
          {
            this.continueCloseEyeCount += 1;
            this.detectAvailableCount -= 1;
            if (this.detectAvailableCount < 0) {
              this.detectAvailableCount = 0;
            }
          }
          else
          {
            this.continueCloseEyeCount = 0;
          }
          if (YtFSM.getInstance().getWorkMode() != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE) {
            i = 10;
          }
          if (this.continueCloseEyeCount >= i)
          {
            this.continueCloseEyeCount = 0;
            i = 6;
            j = m;
            break label1377;
          }
        }
        i = 0;
        j = m;
      }
    }
    label1377:
    this.currentAdviseTip = i;
    if (j != 0) {
      i = 9;
    }
    return i;
  }
  
  private Rect getFaceRect(YTFaceTracker.TrackedFace paramTrackedFace)
  {
    float[] arrayOfFloat = paramTrackedFace.faceShape;
    int i = 0;
    float f4 = arrayOfFloat[0];
    float f3 = paramTrackedFace.faceShape[0];
    float f2 = paramTrackedFace.faceShape[1];
    float f1 = paramTrackedFace.faceShape[1];
    while (i < 180)
    {
      f4 = Math.min(f4, paramTrackedFace.faceShape[i]);
      f3 = Math.max(f3, paramTrackedFace.faceShape[i]);
      i += 1;
      f2 = Math.min(f2, paramTrackedFace.faceShape[i]);
      f1 = Math.max(f1, paramTrackedFace.faceShape[i]);
      i += 1;
    }
    i = this.previewWidth;
    float f5 = i - 1 - f4;
    f3 = i - 1 - f3;
    double d1 = f3;
    double d2 = f5 - f3;
    Double.isNaN(d2);
    d2 = d2 * 0.1D / 2.0D;
    Double.isNaN(d1);
    f4 = (float)(d1 - d2);
    d1 = f5;
    d2 = f5 - f4;
    Double.isNaN(d2);
    d2 = d2 * 0.1D / 2.0D;
    Double.isNaN(d1);
    f3 = (float)(d1 + d2);
    d1 = f2;
    d2 = f1 - f2;
    Double.isNaN(d2);
    d2 = d2 * 0.1D / 2.0D;
    Double.isNaN(d1);
    float f6 = (float)(d1 - d2);
    d1 = f1;
    d2 = f1 - f6;
    Double.isNaN(d2);
    d2 = d2 * 0.1D / 2.0D;
    Double.isNaN(d1);
    f5 = (float)(d1 + d2);
    f1 = f4;
    if (f4 < 0.0F) {
      f1 = 0.0F;
    }
    f2 = f3;
    if (f3 < 0.0F) {
      f2 = 0.0F;
    }
    i = this.previewWidth;
    f3 = f1;
    if (f1 > i - 1) {
      f3 = i - 1;
    }
    i = this.previewWidth;
    f4 = f2;
    if (f2 > i - 1) {
      f4 = i - 1;
    }
    f1 = f6;
    if (f6 < 0.0F) {
      f1 = 0.0F;
    }
    f2 = f5;
    if (f5 < 0.0F) {
      f2 = 0.0F;
    }
    i = this.previewHeight;
    f5 = f1;
    if (f1 > i - 1) {
      f5 = i - 1;
    }
    i = this.previewHeight;
    f1 = f2;
    if (f2 > i - 1) {
      f1 = i - 1;
    }
    paramTrackedFace = new Rect();
    paramTrackedFace.left = ((int)f3);
    paramTrackedFace.top = ((int)f5);
    paramTrackedFace.right = ((int)f4);
    paramTrackedFace.bottom = ((int)f1);
    return paramTrackedFace;
  }
  
  private int getPoseJudge(YTFaceTracker.TrackedFace[] paramArrayOfTrackedFace)
  {
    paramArrayOfTrackedFace = paramArrayOfTrackedFace[0];
    Rect localRect = getFaceRect(paramArrayOfTrackedFace);
    Object localObject = this.previousFaceRect;
    if (localObject == null)
    {
      this.previousFaceRect = localRect;
      this.stableFaceCount = 0;
    }
    else
    {
      localObject = getIntersectionRect(localRect, (Rect)localObject);
      if ((localRect.height() != 0) && (localRect.width() != 0))
      {
        float f = Math.abs(((Rect)localObject).width() * ((Rect)localObject).height() / localRect.height() / localRect.width());
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pose ratio ");
        localStringBuilder.append(f);
        YtLogger.d((String)localObject, localStringBuilder.toString());
        if (f < this.stableRoiThreshold)
        {
          this.extraTips = "fl_act_screen_shaking";
          this.stableFaceCount = 0;
        }
        else
        {
          this.extraTips = "";
          this.stableFaceCount += 1;
        }
      }
      this.previousFaceRect = localRect;
    }
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rect is: ");
    localStringBuilder.append(localRect.left);
    localStringBuilder.append(", ");
    localStringBuilder.append(localRect.top);
    localStringBuilder.append(", ");
    localStringBuilder.append(localRect.right);
    localStringBuilder.append(", ");
    localStringBuilder.append(localRect.bottom);
    YtLogger.d((String)localObject, localStringBuilder.toString());
    return getFacePreviewAdvise(YtSDKKitFramework.getInstance().getDetectRect(), localRect, paramArrayOfTrackedFace);
  }
  
  private int getShelterJudge(YTFaceTracker.TrackedFace[] paramArrayOfTrackedFace)
  {
    int i = shelterJudge(paramArrayOfTrackedFace[0].faceVisible);
    if (this.currentShelterJudge != i)
    {
      this.continueShelterJudgeCount = 0;
      this.currentShelterJudge = i;
    }
    else
    {
      this.continueShelterJudgeCount += 1;
    }
    if ((this.frameNum >= 7) && (this.continueShelterJudgeCount < 7)) {
      return this.previousShelterJudge;
    }
    this.previousShelterJudge = this.currentShelterJudge;
    return i;
  }
  
  private void initYoutuInstance()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    }
    else
    {
      this.detectAvailableCount += 1;
    }
    if ((paramInt1 == this.prevAdvise) && (paramInt2 == this.prevJudge)) {
      this.sameFaceTipCount += 1;
    } else {
      this.sameFaceTipCount = 0;
    }
    if ((this.tipFilterFlag) && (this.sameFaceTipCount > 3) && (this.currentAdviseTip == paramInt1)) {
      return;
    }
    this.prevAdvise = paramInt1;
    this.prevJudge = paramInt2;
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" tips:");
    localStringBuilder.append(convertAdvise(this.currentAdviseTip));
    YtLogger.d(str, localStringBuilder.toString());
    paramInt1 = this.currentAdviseTip;
    if ((paramInt1 != 0) && (paramInt1 != 9))
    {
      localHashMap.put("ui_tips", convertAdvise(paramInt1));
    }
    else if (paramInt2 == 1)
    {
      localHashMap.put("ui_tips", "fl_no_left_face");
    }
    else if (paramInt2 == 2)
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
    else if (paramInt2 == 0)
    {
      paramInt1 = this.sameFaceTipCount;
      if ((paramInt1 > 2) && (paramInt1 < 5))
      {
        localHashMap.put("ui_tips", "fl_pose_keep");
        localHashMap.put("ui_action", "pass");
      }
    }
    str = this.extraTips;
    if (str != "") {
      localHashMap.put("ui_extra_tips", str);
    }
    sendFSMEvent(localHashMap);
  }
  
  private void sendUITipEvent(YTFaceTracker.TrackedFace[] paramArrayOfTrackedFace)
  {
    HashMap localHashMap = new HashMap();
    int i = 1;
    int k = -1;
    Object localObject1;
    if (paramArrayOfTrackedFace == null)
    {
      localObject1 = YtFSM.getInstance().getContext().baseFunctionListener;
      paramArrayOfTrackedFace = null;
      if (localObject1 != null) {
        paramArrayOfTrackedFace = YtFSM.getInstance().getContext().baseFunctionListener.getFrameResult(null);
      }
      if (paramArrayOfTrackedFace != null)
      {
        if (paramArrayOfTrackedFace.containsKey("Advise"))
        {
          i = ((Integer)paramArrayOfTrackedFace.get("Advise")).intValue();
          this.currentAdviseTip = i;
        }
        else
        {
          i = -1;
        }
      }
      else {
        this.currentAdviseTip = 1;
      }
    }
    else if (paramArrayOfTrackedFace.length > 1)
    {
      localHashMap.put("ui_error", "Failed");
      if (this.needCheckMultiFaces)
      {
        this.detectAvailableCount = 0;
        this.prevAdvise = 7;
        i = 7;
      }
      else
      {
        i = -1;
      }
      this.currentAdviseTip = 7;
    }
    else
    {
      if (YtFSM.getInstance().getContext().baseFunctionListener != null)
      {
        localObject1 = new SilentLivenessState.YtFaceStatus(this);
        localObject2 = getFaceRect(paramArrayOfTrackedFace[0]);
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
        if (localObject1 != null)
        {
          if (((HashMap)localObject1).containsKey("Advise")) {
            j = ((Integer)((HashMap)localObject1).get("Advise")).intValue();
          } else {
            j = -1;
          }
          if (((HashMap)localObject1).containsKey("Shelter"))
          {
            i = ((Integer)((HashMap)localObject1).get("Shelter")).intValue();
            k = j;
            break label440;
          }
          i = -1;
          k = j;
          break label440;
        }
      }
      i = -1;
      k = -1;
      label440:
      int j = k;
      if (k == -1) {
        j = getPoseJudge(paramArrayOfTrackedFace);
      }
      localObject1 = TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("advise ");
      ((StringBuilder)localObject2).append(j);
      YtLogger.i((String)localObject1, ((StringBuilder)localObject2).toString());
      if (i == -1)
      {
        k = getShelterJudge(paramArrayOfTrackedFace);
        i = j;
      }
      else
      {
        k = i;
        i = j;
      }
    }
    sendFaceStatusUITips(i, k);
    if (localHashMap.size() > 0) {
      sendFSMEvent(localHashMap);
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[YTFaceTraceInterface.blockJudge] input pointsVis.length != 90. current pointsVis.length: ");
      localStringBuilder.append(paramArrayOfFloat.length);
      YtLogger.e(str, localStringBuilder.toString());
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
      if (paramYtFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_BEGIN_LIVENESS)
      {
        this.detectAvailableCount = 0;
        this.triggerLiveBeginEventFlag = true;
        resetTimeout();
        return;
      }
      if (paramYtFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS)
      {
        this.detectAvailableCount = 0;
        this.triggerLiveBeginEventFlag = false;
        this.countdowner.cancel();
        this.predetectCountdowner.reset();
      }
    }
  }
  
  public void handleStateAction(String paramString, Object paramObject)
  {
    super.handleStateAction(paramString, paramObject);
    if (paramString.equals("reset_timeout"))
    {
      paramString = TAG;
      paramObject = new StringBuilder();
      paramObject.append("predetect status:");
      paramObject.append(this.predetectCountdowner.isRunning());
      YtLogger.d(paramString, paramObject.toString());
      if (!this.predetectCountdowner.isRunning()) {
        resetTimeout();
      }
    }
    else if (paramString.equals("reset_manual_trigger"))
    {
      this.triggerLiveBeginEventFlag = false;
      this.countdowner.cancel();
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
      if (paramJSONObject.has("resource_download_path")) {
        this.resourceDownloadPath = paramJSONObject.getString("resource_download_path");
      }
      if (paramJSONObject.has("timeout_countdown_ms")) {
        this.countdowner.init(Math.max(0, Math.min(30000, paramJSONObject.getInt("timeout_countdown_ms"))), true);
      }
      if (paramJSONObject.has("predetect_countdown_ms")) {
        this.predetectCountdowner.init(paramJSONObject.getInt("predetect_countdown_ms"), true);
      } else {
        this.predetectCountdowner.init(25000L, true);
      }
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
      paramJSONObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to parse json:");
      localStringBuilder.append(paramString.getLocalizedMessage());
      YtLogger.e(paramJSONObject, localStringBuilder.toString());
    }
    if (!this.isLoadResourceOnline) {
      FileUtils.loadLibrary("YTFaceTracker");
    }
    paramString = YtFSM.getInstance().getContext().currentCamera.getParameters().getPreviewSize();
    this.cameraRotateState = YtFSM.getInstance().getContext().currentRotateState;
    if (this.cameraRotateState >= 5)
    {
      this.previewWidth = paramString.height;
      this.previewHeight = paramString.width;
    }
    else
    {
      this.previewWidth = paramString.width;
      this.previewHeight = paramString.height;
    }
    this.maskWidthRatio = (YtSDKKitFramework.getInstance().getPreviewRect().width() / this.previewWidth);
    this.maskHeightRatio = (YtSDKKitFramework.getInstance().getPreviewRect().height() / this.previewHeight);
    initYoutuInstance();
    reset();
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    int i;
    Object localObject;
    String str;
    if (this.needManualTrigger)
    {
      if (this.needCheckPose)
      {
        i = this.prevAdvise;
        if ((i != 0) && (i != 9)) {}
      }
      else if ((!this.needCheckMultiFaces) || (this.prevAdvise != 7))
      {
        i = this.prevAdvise;
        if ((i != 8) && (i != 1)) {
          break label214;
        }
      }
      this.continueNoValidFaceCount += 1;
      if (this.continueNoValidFaceCount <= this.continueNovalidFaceCountThreshold) {
        break label219;
      }
      localObject = convertAdvise(this.prevAdvise);
      str = CommonUtils.makeMessageJson(4194304, (String)localObject, "action check failed");
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
      return;
    }
    label214:
    this.continueNoValidFaceCount = 0;
    label219:
    if ((this.needManualTrigger) && (this.predetectCountdowner.checkTimeout()))
    {
      str = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("predectcountdowner.checkTimeout(): ");
      ((StringBuilder)localObject).append(this.predetectCountdowner.checkTimeout());
      YtLogger.d(str, ((StringBuilder)localObject).toString());
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
    if ((this.needManualTrigger == true) || (this.isFirstStablePass) || (this.detectAvailableCount > this.stableCountNum))
    {
      this.isFirstStablePass = true;
      this.predetectCountdowner.cancel();
      i = SilentLivenessState.2.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()];
      if ((i != 1) && (i != 2) && (i != 3))
      {
        if (i != 4)
        {
          if (i != 5) {
            return;
          }
          YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.LIPREAD_STATE));
          return;
        }
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
        return;
      }
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    }
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
    } else {
      this.predetectCountdowner.reset();
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
    YTFaceTracker localYTFaceTracker = this.ytFaceTracker;
    if (localYTFaceTracker != null) {
      localYTFaceTracker.destroy();
    }
    this.ytFaceTracker = null;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    if ((!this.countdowner.checkTimeout()) && ((!this.needManualTrigger) || (!this.predetectCountdowner.checkTimeout())))
    {
      byte[] arrayOfByte = (byte[])paramArrayOfByte.clone();
      this.frameNum += 1;
      float[] arrayOfFloat = new float[1];
      CommonUtils.benchMarkBegin("detect");
      StringBuilder localStringBuilder = null;
      try
      {
        paramArrayOfByte = this.ytFaceTracker.track(0, paramArrayOfByte, paramInt1, paramInt2, this.cameraRotateState, true, arrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        YtLogger.e(TAG, paramArrayOfByte.getLocalizedMessage());
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      Object localObject = localStringBuilder;
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.length == 0) {
          localObject = localStringBuilder;
        } else {
          localObject = paramArrayOfByte;
        }
      }
      paramArrayOfByte = convert130To90((YTFaceTracker.TrackedFace[])localObject);
      CommonUtils.benchMarkEnd("detect");
      YtLogger.d(TAG, CommonUtils.getBenchMarkTime("detect"));
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Blur score:");
      localStringBuilder.append(Arrays.toString(arrayOfFloat));
      YtLogger.d((String)localObject, localStringBuilder.toString());
      if (paramArrayOfByte != null)
      {
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("face status count ");
        localStringBuilder.append(paramArrayOfByte.length);
        YtLogger.i((String)localObject, localStringBuilder.toString());
        if (paramArrayOfByte.length > 1)
        {
          paramInt3 = 0;
          int k = 0;
          int j;
          for (int i = -2147483648; paramInt3 < paramArrayOfByte.length; i = j)
          {
            localObject = getFaceRect(paramArrayOfByte[paramInt3]);
            int m = ((Rect)localObject).width() * ((Rect)localObject).height();
            j = i;
            if (m >= i)
            {
              k = paramInt3;
              j = m;
            }
            paramInt3 += 1;
          }
          if (k != 0)
          {
            localObject = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Found max face id:");
            localStringBuilder.append(k);
            YtLogger.i((String)localObject, localStringBuilder.toString());
            paramArrayOfByte[0] = paramArrayOfByte[k];
          }
        }
      }
      else
      {
        YtLogger.i(TAG, "face status is null");
      }
      sendUITipEvent(paramArrayOfByte);
      this.stateData.put("pose_state", Integer.valueOf(this.prevAdvise));
      this.stateData.put("shelter_state", Integer.valueOf(this.prevJudge));
      this.stateData.put("face_status", paramArrayOfByte);
      this.stateData.put("continuous_detect_count", Integer.valueOf(this.detectAvailableCount));
      localObject = new YuvImage(arrayOfByte, 17, paramInt2, paramInt1, null);
      this.stateData.put("last_face_status", paramArrayOfByte);
      this.stateData.put("last_frame", localObject);
      paramInt1 = this.prevAdvise;
      if ((paramInt1 == 0) || (paramInt1 == 9)) {
        checkBestImage(paramArrayOfByte[0], (YuvImage)localObject);
      }
      if (this.stateData.get("best_image") != null)
      {
        boolean bool = this.needManualTrigger;
        if ((!bool) || ((bool == true) && (this.triggerLiveBeginEventFlag == true))) {
          moveToNextState();
        }
      }
      return;
    }
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to parse json:");
      localStringBuilder.append(paramJSONObject.getLocalizedMessage());
      YtLogger.e(str, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState
 * JD-Core Version:    0.7.0.1
 */