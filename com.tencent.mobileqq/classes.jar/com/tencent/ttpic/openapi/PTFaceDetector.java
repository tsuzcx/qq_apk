package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.facedetect.FaceStatusUtil;
import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.util.AgeDetector;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.MustRunOnGLThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class PTFaceDetector
  extends IDetect
{
  private static final long MAX_REUSE_FACE_INTEVAL = 1500L;
  private static final String TAG = "PTFaceDetector";
  public static AtomicInteger activeRefCount = new AtomicInteger(0);
  private static volatile VideoPreviewFaceOutlineDetector mSpareFaceDetector;
  private boolean firstDet = true;
  private boolean isInited = false;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private volatile SegmentDataPipe mDetDataPipe;
  private FaceGestureDetGLThread mDetGLThread;
  private final Object mFaceDetLock = new Object();
  private VideoPreviewFaceOutlineDetector mFaceDetector;
  private boolean mLastHasFace = false;
  private Frame mLastInputFrame;
  private int mLastRotation = 0;
  private long mOffsetTime = -1L;
  private boolean mOffsetTimeInited = false;
  private BaseFilter mRotateFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mRotateFrame = new Frame();
  private boolean needReset = false;
  private PTFaceAttr storedFaceAttr = null;
  
  private void setDataPipe(SegmentDataPipe paramSegmentDataPipe)
  {
    synchronized (this.mFaceDetLock)
    {
      this.mDetDataPipe = paramSegmentDataPipe;
      this.mFaceDetLock.notifyAll();
      return;
    }
  }
  
  public void clear()
  {
    this.firstDet = true;
    this.isInited = false;
    this.storedFaceAttr = null;
  }
  
  public void destroy()
  {
    FaceGestureDetGLThread localFaceGestureDetGLThread = this.mDetGLThread;
    if (localFaceGestureDetGLThread != null) {
      localFaceGestureDetGLThread.postFaceDetectorDestroy();
    }
    this.mRotateFilter.clearGLSL();
    this.mRotateFrame.clear();
    this.mCopyFilter.clearGLSL();
    localFaceGestureDetGLThread = this.mDetGLThread;
    if (localFaceGestureDetGLThread != null)
    {
      localFaceGestureDetGLThread.destroy();
      activeRefCount.getAndDecrement();
      this.mDetGLThread = null;
    }
    this.mOffsetTimeInited = false;
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    if (!this.isInited) {
      return null;
    }
    if ((paramAIInput != null) && (paramAIParam != null))
    {
      paramAIInput = (Frame)paramAIInput.getInput("frame");
      int j = paramAIParam.getRotation();
      int i;
      if (this.mLastHasFace) {
        i = this.mLastRotation;
      } else {
        i = j;
      }
      paramAIInput = detectFrame(paramAIInput, i, paramAIParam);
      paramAIInput.setSrcRotation(j);
      boolean bool;
      if (paramAIInput.getFaceCount() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.mLastHasFace = bool;
      if (this.mLastHasFace) {
        this.mLastRotation = paramAIInput.getRotation();
      }
      return paramAIInput;
    }
    return null;
  }
  
  public PTFaceAttr detectFrame(Frame paramFrame, int paramInt, AIParam paramAIParam)
  {
    Map localMap = paramAIParam.getModuleParam(AEDetectorType.FACE.value);
    float f1 = ((Float)paramAIParam.getModuleParam(AEDetectorType.FACE.value).get("scale")).floatValue();
    float f2 = ((Float)localMap.get("phoneRoll")).floatValue();
    StarParam localStarParam = (StarParam)localMap.get("starParam");
    boolean bool1 = localMap.containsKey("allFrameDetect");
    boolean bool4 = true;
    if ((bool1) && (((Boolean)localMap.get("allFrameDetect")).booleanValue())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((localMap.containsKey("expressionDetectForEveryFace")) && (((Boolean)localMap.get("expressionDetectForEveryFace")).booleanValue())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((localMap.containsKey("enableAgeDetect")) && (((Boolean)localMap.get("enableAgeDetect")).booleanValue())) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    AgeDetector.getInstance().setNeedDetectAge(bool3);
    if ((localMap.containsKey("syncAgeDetect")) && (((Boolean)localMap.get("syncAgeDetect")).booleanValue())) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    AgeDetector.getInstance().setSyncDetectAge(bool3);
    int i;
    if ((localMap.containsKey("needDetectAndTrackFirstFrame")) && (((Boolean)localMap.get("needDetectAndTrackFirstFrame")).booleanValue())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.firstDet) && (i != 0)) {
      bool1 = true;
    }
    this.firstDet = false;
    if ((localMap.containsKey("reset")) && (((Boolean)localMap.get("reset")).booleanValue())) {
      bool3 = bool4;
    } else {
      bool3 = false;
    }
    this.needReset = bool3;
    return detectFrame(paramFrame, paramAIParam.getSurfaceTime(), paramInt, f1, f2, bool1, bool2, localStarParam);
  }
  
  public PTFaceAttr detectFrame(Frame paramFrame, long paramLong, int paramInt, double paramDouble, float paramFloat, boolean paramBoolean1, boolean paramBoolean2, StarParam paramStarParam)
  {
    Object localObject1 = this.mDetGLThread;
    int i;
    if (localObject1 != null) {
      i = ((FaceGestureDetGLThread)localObject1).getLastFaceDetectedPhoneRotation();
    } else {
      i = paramInt;
    }
    boolean bool = isPhoneFlatHorizontal(paramFloat);
    if (bool) {
      k = i;
    } else {
      k = paramInt;
    }
    paramInt = paramFrame.width;
    int j = paramFrame.height;
    int m = (k + 360) % 360;
    if ((m != 90) && (m != 270))
    {
      k = j;
      j = paramInt;
    }
    else
    {
      k = paramInt;
    }
    double d = j;
    Double.isNaN(d);
    paramInt = (int)(d * paramDouble);
    d = k;
    Double.isNaN(d);
    int k = (int)(d * paramDouble);
    Object localObject8 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject4 = new HashMap();
    Object localObject3 = new ArrayList();
    Object localObject5 = new HashSet();
    ((Set)localObject5).add(Integer.valueOf(1));
    Object localObject11 = new ArrayList();
    Object localObject13 = new ArrayList();
    Object localObject6 = new ArrayList();
    Object localObject12 = new HashMap();
    byte[] arrayOfByte = new byte[0];
    Pair localPair = Pair.create(Integer.valueOf(255), null);
    Object localObject7 = new HashMap();
    float[] arrayOfFloat = new float[3];
    float[] tmp279_277 = arrayOfFloat;
    tmp279_277[0] = 1.0F;
    float[] tmp283_279 = tmp279_277;
    tmp283_279[1] = 1.0F;
    float[] tmp287_283 = tmp283_279;
    tmp287_283[2] = 1.0F;
    tmp287_283;
    Object localObject9 = this.mDetGLThread;
    if ((localObject9 != null) && (((FaceGestureDetGLThread)localObject9).isInitReady()))
    {
      localObject10 = this.mDetGLThread.postFaceGestureDet(paramFrame, paramDouble, paramBoolean1, this.needReset, m, paramStarParam, paramBoolean2);
      if ((localObject10 != null) && (((SegmentDataPipe)localObject10).mTexFrame.width == j))
      {
        localObject16 = ((SegmentDataPipe)localObject10).allFacePoints;
        localObject15 = ((SegmentDataPipe)localObject10).allIrisPoints;
        localObject3 = ((SegmentDataPipe)localObject10).allPointsVis;
        localObject4 = ((SegmentDataPipe)localObject10).recordFaceInfo;
        localObject14 = ((SegmentDataPipe)localObject10).allFaceAngles;
        localObject5 = ((SegmentDataPipe)localObject10).mTriggeredExpressionType;
        localObject1 = ((SegmentDataPipe)localObject10).expressions;
        localObject13 = ((SegmentDataPipe)localObject10).faceStatus;
        localObject6 = ((SegmentDataPipe)localObject10).faceInfos;
        arrayOfByte = ((SegmentDataPipe)localObject10).mData;
        localObject7 = ((SegmentDataPipe)localObject10).faceActionCounter;
        localPair = ((SegmentDataPipe)localObject10).histogram;
        arrayOfFloat = ((SegmentDataPipe)localObject10).rgbGain;
        localObject8 = ((SegmentDataPipe)localObject10).curve;
        localObject9 = ((SegmentDataPipe)localObject10).autoContrastCurve;
        arrayOfInt = ((SegmentDataPipe)localObject10).autoBrightnessCurve;
        localList1 = ((SegmentDataPipe)localObject10).starPoints;
        localFrame = ((SegmentDataPipe)localObject10).starMaskFrame;
        d = ((SegmentDataPipe)localObject10).faceAverageL;
        localObject12 = ((SegmentDataPipe)localObject10).detectTimes;
        localObject2 = ((SegmentDataPipe)localObject10).faceKitVerticesArray;
        localList2 = ((SegmentDataPipe)localObject10).face3DVerticesArray;
        localList3 = ((SegmentDataPipe)localObject10).face3DRotationArray;
        paramStarParam = ((SegmentDataPipe)localObject10).featureIndicesArray;
        localPointF = ((SegmentDataPipe)localObject10).facePiont2DCenter;
        localObject10 = localObject2;
        localStarParam = paramStarParam;
        localObject11 = localObject1;
        break label598;
      }
    }
    paramStarParam = (StarParam)localObject8;
    d = 60.0D;
    PointF localPointF = null;
    localObject8 = null;
    localObject9 = null;
    int[] arrayOfInt = null;
    List localList1 = null;
    Frame localFrame = null;
    Object localObject10 = null;
    List localList2 = null;
    List localList3 = null;
    StarParam localStarParam = null;
    Object localObject14 = localObject3;
    localObject3 = localObject2;
    Object localObject15 = localObject1;
    Object localObject16 = paramStarParam;
    label598:
    paramStarParam = this.mLastInputFrame;
    if (paramStarParam != null) {
      paramStarParam.setCanUnlock(true);
    }
    paramFrame.setCanUnlock(false);
    paramStarParam = this.mLastInputFrame;
    if (paramStarParam != null) {
      paramStarParam.unlock();
    }
    this.mLastInputFrame = paramFrame;
    paramStarParam = AlgoUtils.rotatePointsForList((List)localObject16, paramInt, k, m);
    localObject1 = AlgoUtils.rotatePointsForList((List)localObject15, paramInt, k, m);
    localObject2 = AlgoUtils.rotateAngles((List)localObject14, -m);
    localObject13 = FaceStatusUtil.rotateFaceStatusFor3D((List)localObject13, paramInt, k, m);
    localPointF = AlgoUtils.rotatePoint(localPointF, paramInt, k, m);
    localObject14 = new PTFaceAttr.Builder();
    if ((paramLong != 0L) && (!this.mOffsetTimeInited))
    {
      this.mOffsetTimeInited = true;
      this.mOffsetTime = (System.currentTimeMillis() - paramLong / 1000000L);
    }
    if (paramLong == 0L) {
      paramLong = System.currentTimeMillis();
    } else {
      paramLong = paramLong / 1000000L + this.mOffsetTime;
    }
    ((PTFaceAttr.Builder)localObject14).facePoints(paramStarParam).irisPoints((List)localObject1).pointsVis((List)localObject3).recordFaceInfo((Map)localObject4).faceAngles((List)localObject2).triggeredExpression((Set)localObject5).faceStatusList((List)localObject13).faceInfoList((List)localObject6).faceDetectScale(paramDouble).data(arrayOfByte).origFrame(paramFrame).rotation(m).faceActionCounter((Map)localObject7).histogram(localPair).faceDetector(this.mFaceDetector).rgbGain(arrayOfFloat).curve((int[])localObject8).autoContrastCurve((int[])localObject9).autoBrightnessCurve(arrayOfInt).starPoints(localList1).starMaskFrame(localFrame).isPhoneFlatHorizontal(bool).lastFaceDetectedPhoneRotation(i).faceAverageL(d).faceKitVerticesArray((List)localObject10).face3DVerticesArray(localList2).face3DRotationArray(localList3).featureIndicesArray(localStarParam).facePiont2DCenter(localPointF).shookFaceInfos(getFaceDetector().getShookFaceInfos()).faceDetWidth(paramInt).faceDetHeight(k).faceDetRotation(m).expressions((List)localObject11).timeStamp(paramLong).detectTimes((Map)localObject12);
    this.needReset = false;
    paramFrame = new PTFaceAttr((PTFaceAttr.Builder)localObject14);
    if (((paramStarParam == null) || (paramStarParam.size() == 0)) && (this.storedFaceAttr != null) && (System.currentTimeMillis() - this.storedFaceAttr.getTimeStamp() <= 1500L)) {
      paramFrame.setReusedFaceAttr(null);
    } else {
      paramFrame.setReusedFaceAttr(null);
    }
    if ((paramStarParam != null) && (paramStarParam.size() > 0)) {
      this.storedFaceAttr = paramFrame;
    }
    return paramFrame;
  }
  
  public VideoPreviewFaceOutlineDetector getFaceDetector()
  {
    VideoPreviewFaceOutlineDetector localVideoPreviewFaceOutlineDetector2 = this.mFaceDetector;
    Object localObject1 = localVideoPreviewFaceOutlineDetector2;
    VideoPreviewFaceOutlineDetector localVideoPreviewFaceOutlineDetector1;
    if (localVideoPreviewFaceOutlineDetector2 == null)
    {
      if (mSpareFaceDetector == null) {
        try
        {
          if (mSpareFaceDetector == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("PTFaceDetector.getFaceDetector() is null!, OS version is ");
            ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
            ReportUtil.report(((StringBuilder)localObject1).toString());
            mSpareFaceDetector = new VideoPreviewFaceOutlineDetector();
          }
        }
        finally {}
      }
      localVideoPreviewFaceOutlineDetector1 = mSpareFaceDetector;
    }
    return localVideoPreviewFaceOutlineDetector1;
  }
  
  public String getHistogramInfo()
  {
    FaceGestureDetGLThread localFaceGestureDetGLThread = this.mDetGLThread;
    if (localFaceGestureDetGLThread != null) {
      return localFaceGestureDetGLThread.getHistogramInfo();
    }
    return "";
  }
  
  public String getModuleName()
  {
    return TAG;
  }
  
  public String getModuleType()
  {
    return AEDetectorType.FACE.value;
  }
  
  @MustRunOnGLThread
  public void init(boolean paramBoolean)
  {
    if (this.mDetGLThread == null)
    {
      this.mDetGLThread = new FaceGestureDetGLThread(EGL14.eglGetCurrentContext(), paramBoolean);
      activeRefCount.getAndIncrement();
      this.mDetGLThread.setOnFaceDetListener(new PTFaceDetector.1(this));
      this.mFaceDetector = this.mDetGLThread.getDetector();
    }
    this.mRotateFilter.apply();
    this.mCopyFilter.apply();
  }
  
  @MustRunOnGLThread
  public boolean init()
  {
    if ((!this.isInited) && (ApiHelper.hasJellyBeanMR1()))
    {
      if (!FeatureManager.isBasicFeaturesFunctionReady()) {
        return false;
      }
      init(false);
      this.firstDet = true;
      this.isInited = true;
      this.mOffsetTimeInited = false;
      this.storedFaceAttr = null;
      return true;
    }
    return false;
  }
  
  public boolean isPhoneFlatHorizontal(float paramFloat)
  {
    return (paramFloat >= 170.0F) || (paramFloat <= 10.0F);
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    return FeatureManager.Features.FACE_DETECT.init();
  }
  
  public void onModuleUninstall() {}
  
  public void onPreviewStartPreImmediately()
  {
    FaceGestureDetGLThread localFaceGestureDetGLThread = this.mDetGLThread;
    if (localFaceGestureDetGLThread != null) {
      localFaceGestureDetGLThread.onPreviewStartPreImmediately();
    }
  }
  
  public void resetDetector()
  {
    Frame localFrame = this.mLastInputFrame;
    if (localFrame != null)
    {
      localFrame.setCanUnlock(false);
      this.mLastInputFrame.unlock();
    }
    this.mDetDataPipe = null;
  }
  
  public void setAgeDetectable(boolean paramBoolean)
  {
    FaceGestureDetGLThread localFaceGestureDetGLThread = this.mDetGLThread;
    if (localFaceGestureDetGLThread != null) {
      localFaceGestureDetGLThread.setAgeDetectable(paramBoolean);
    }
  }
  
  public void setMaxFaceCount(int paramInt)
  {
    FaceGestureDetGLThread localFaceGestureDetGLThread = this.mDetGLThread;
    if (localFaceGestureDetGLThread != null) {
      localFaceGestureDetGLThread.setMaxFaceCount(paramInt);
    }
  }
  
  public void setSupportSmallFace(boolean paramBoolean)
  {
    VideoPreviewFaceOutlineDetector localVideoPreviewFaceOutlineDetector = this.mFaceDetector;
    if (localVideoPreviewFaceOutlineDetector != null) {
      localVideoPreviewFaceOutlineDetector.setSupportSmallFace(paramBoolean);
    }
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTFaceDetector
 * JD-Core Version:    0.7.0.1
 */