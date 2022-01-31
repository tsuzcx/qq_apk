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
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.util.AgeDetector;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.MustRunOnGLThread;
import com.tencent.ttpic.util.youtu.GenderDetector;
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
  private static final String TAG = PTFaceDetector.class.getSimpleName();
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
  }
  
  public void destroy()
  {
    if (this.mDetGLThread != null) {
      this.mDetGLThread.postFaceDetectorDestroy();
    }
    this.mRotateFilter.ClearGLSL();
    this.mRotateFrame.clear();
    this.mCopyFilter.ClearGLSL();
    if (this.mDetGLThread != null)
    {
      this.mDetGLThread.destroy();
      activeRefCount.getAndDecrement();
      this.mDetGLThread = null;
    }
    this.mOffsetTimeInited = false;
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    if ((paramAIInput != null) && (paramAIParam != null))
    {
      paramAIInput = (Frame)paramAIInput.getInput("frame");
      int j = paramAIParam.getRotation();
      int i;
      if (this.mLastHasFace)
      {
        i = this.mLastRotation;
        paramAIInput = detectFrame(paramAIInput, i, paramAIParam);
        paramAIInput.setSrcRotation(j);
        if (paramAIInput.getFaceCount() <= 0) {
          break label89;
        }
      }
      label89:
      for (boolean bool = true;; bool = false)
      {
        this.mLastHasFace = bool;
        if (this.mLastHasFace) {
          this.mLastRotation = paramAIInput.getRotation();
        }
        return paramAIInput;
        i = j;
        break;
      }
    }
    return null;
  }
  
  public PTFaceAttr detectFrame(Frame paramFrame, int paramInt, AIParam paramAIParam)
  {
    Map localMap = paramAIParam.getModuleParam(AEDetectorType.FACE.value);
    float f1 = ((Float)paramAIParam.getModuleParam(AEDetectorType.FACE.value).get("scale")).floatValue();
    float f2 = ((Float)localMap.get("phoneRoll")).floatValue();
    StarParam localStarParam = (StarParam)localMap.get("starParam");
    boolean bool2;
    boolean bool1;
    label134:
    boolean bool3;
    label167:
    label208:
    int i;
    if ((localMap.containsKey("FaceKit")) && (((Boolean)localMap.get("FaceKit")).booleanValue()))
    {
      bool2 = true;
      if ((!localMap.containsKey("allFrameDetect")) || (!((Boolean)localMap.get("allFrameDetect")).booleanValue())) {
        break label297;
      }
      bool1 = true;
      if ((!localMap.containsKey("enableGenderDetect")) || (!((Boolean)localMap.get("enableGenderDetect")).booleanValue())) {
        break label303;
      }
      bool3 = true;
      GenderDetector.getInstance().setNeedDetectGender(bool3);
      if ((!localMap.containsKey("enableAgeDetect")) || (!((Boolean)localMap.get("enableAgeDetect")).booleanValue())) {
        break label309;
      }
      bool3 = true;
      AgeDetector.getInstance().setNeedDetectAge(bool3);
      if ((!localMap.containsKey("needDetectAndTrackFirstFrame")) || (!((Boolean)localMap.get("needDetectAndTrackFirstFrame")).booleanValue())) {
        break label315;
      }
      i = 1;
      label249:
      if ((!this.firstDet) || (i == 0)) {
        break label321;
      }
      bool1 = true;
    }
    label297:
    label303:
    label309:
    label315:
    label321:
    for (;;)
    {
      this.firstDet = false;
      return detectFrame(paramFrame, paramAIParam.getSurfaceTime(), paramInt, bool2, f1, f2, bool1, localStarParam);
      bool2 = false;
      break;
      bool1 = false;
      break label134;
      bool3 = false;
      break label167;
      bool3 = false;
      break label208;
      i = 0;
      break label249;
    }
  }
  
  public PTFaceAttr detectFrame(Frame paramFrame, long paramLong, int paramInt, boolean paramBoolean1, double paramDouble, float paramFloat, boolean paramBoolean2, StarParam paramStarParam)
  {
    int i;
    boolean bool;
    int k;
    int j;
    int m;
    if (this.mDetGLThread != null)
    {
      i = this.mDetGLThread.getLastFaceDetectedPhoneRotation();
      bool = isPhoneFlatHorizontal(paramFloat);
      k = paramInt;
      if (bool) {
        k = i;
      }
      paramInt = paramFrame.width;
      j = paramFrame.height;
      m = (k + 360) % 360;
      if ((m != 90) && (m != 270)) {
        break label833;
      }
      k = paramInt;
      paramInt = j;
      j = k;
    }
    label833:
    for (;;)
    {
      k = (int)(paramInt * paramDouble);
      j = (int)(j * paramDouble);
      Object localObject11 = new ArrayList();
      Object localObject10 = new ArrayList();
      Object localObject6 = new ArrayList();
      Object localObject5 = new HashMap();
      Object localObject9 = new ArrayList();
      Object localObject4 = new HashSet();
      ((Set)localObject4).add(Integer.valueOf(1));
      Object localObject8 = new ArrayList();
      Object localObject3 = new ArrayList();
      Object localObject2 = new HashMap();
      Pair localPair = Pair.create(Integer.valueOf(255), null);
      Object localObject1 = new HashMap();
      Object localObject7;
      byte[] arrayOfByte;
      float[] arrayOfFloat;
      int[] arrayOfInt;
      List localList1;
      Frame localFrame1;
      double d;
      List localList2;
      if ((this.mDetGLThread != null) && (this.mDetGLThread.isInitReady()))
      {
        localObject7 = this.mDetGLThread.postFaceGestureDet(paramFrame, paramDouble, paramBoolean2, m, paramStarParam, paramBoolean1);
        if ((localObject7 != null) && (((SegmentDataPipe)localObject7).mTexFrame.width == paramInt))
        {
          localObject11 = ((SegmentDataPipe)localObject7).allFacePoints;
          localObject10 = ((SegmentDataPipe)localObject7).allIrisPoints;
          localObject6 = ((SegmentDataPipe)localObject7).allPointsVis;
          localObject5 = ((SegmentDataPipe)localObject7).recordFaceInfo;
          localObject9 = ((SegmentDataPipe)localObject7).allFaceAngles;
          localObject4 = ((SegmentDataPipe)localObject7).mTriggeredExpressionType;
          localObject8 = ((SegmentDataPipe)localObject7).faceStatus;
          localObject3 = ((SegmentDataPipe)localObject7).faceInfos;
          arrayOfByte = ((SegmentDataPipe)localObject7).mData;
          localObject1 = ((SegmentDataPipe)localObject7).faceActionCounter;
          localPair = ((SegmentDataPipe)localObject7).histogram;
          arrayOfFloat = ((SegmentDataPipe)localObject7).rgbGain;
          arrayOfInt = ((SegmentDataPipe)localObject7).curve;
          localList1 = ((SegmentDataPipe)localObject7).starPoints;
          localFrame1 = ((SegmentDataPipe)localObject7).starMaskFrame;
          d = ((SegmentDataPipe)localObject7).faceAverageL;
          localObject2 = ((SegmentDataPipe)localObject7).detectTimes;
          localList2 = ((SegmentDataPipe)localObject7).faceKitVerticesArray;
          paramStarParam = ((SegmentDataPipe)localObject7).featureIndicesArray;
          localObject7 = ((SegmentDataPipe)localObject7).facePiont2DCenter;
        }
      }
      for (;;)
      {
        Frame localFrame2 = paramFrame;
        if (this.mLastInputFrame != null) {
          this.mLastInputFrame.setCanUnlock(true);
        }
        paramFrame.setCanUnlock(false);
        if ((paramFrame == localFrame2) && (this.mLastInputFrame != null)) {
          this.mLastInputFrame.unlock();
        }
        this.mLastInputFrame = paramFrame;
        paramFrame = AlgoUtils.rotatePointsForList((List)localObject11, k, j, m);
        localObject10 = AlgoUtils.rotatePointsForList((List)localObject10, k, j, m);
        localObject9 = AlgoUtils.rotateAngles((List)localObject9, -m);
        localObject8 = FaceStatusUtil.rotateFaceStatusFor3D((List)localObject8, k, j, m);
        localList2 = AlgoUtils.rotatePointsForFloat3DList(localList2, 6445, k, j, m);
        localObject7 = AlgoUtils.rotatePoint((PointF)localObject7, k, j, m);
        localObject11 = new PTFaceAttr.Builder();
        if ((paramLong != 0L) && (!this.mOffsetTimeInited))
        {
          this.mOffsetTimeInited = true;
          this.mOffsetTime = (System.currentTimeMillis() - paramLong / 1000000L);
        }
        if (paramLong == 0L) {}
        for (paramLong = System.currentTimeMillis();; paramLong = paramLong / 1000000L + this.mOffsetTime)
        {
          ((PTFaceAttr.Builder)localObject11).facePoints(paramFrame).irisPoints((List)localObject10).pointsVis((List)localObject6).recordFaceInfo((Map)localObject5).faceAngles((List)localObject9).triggeredExpression((Set)localObject4).faceStatusList((List)localObject8).faceInfoList((List)localObject3).faceDetectScale(paramDouble).data(arrayOfByte).origFrame(localFrame2).rotation(m).faceActionCounter((Map)localObject1).histogram(localPair).faceDetector(this.mFaceDetector).rgbGain(arrayOfFloat).curve(arrayOfInt).starPoints(localList1).starMaskFrame(localFrame1).isPhoneFlatHorizontal(bool).lastFaceDetectedPhoneRotation(i).faceAverageL(d).faceKitVerticesArray(localList2).featureIndicesArray(paramStarParam).facePiont2DCenter((PointF)localObject7).shookFaceInfos(getFaceDetector().getShookFaceInfos()).faceDetWidth(k).faceDetHeight(j).faceDetRotation(m).timeStamp(paramLong).detectTimes((Map)localObject2);
          return new PTFaceAttr((PTFaceAttr.Builder)localObject11);
          i = paramInt;
          break;
        }
        localObject7 = null;
        paramStarParam = null;
        localList2 = null;
        d = 60.0D;
        localFrame1 = null;
        localList1 = null;
        arrayOfInt = null;
        arrayOfFloat = new float[] { 1.0F, 1.0F, 1.0F };
        arrayOfByte = new byte[0];
      }
    }
  }
  
  public VideoPreviewFaceOutlineDetector getFaceDetector()
  {
    if (this.mFaceDetector == null)
    {
      if (mSpareFaceDetector == null) {}
      try
      {
        if (mSpareFaceDetector == null)
        {
          ReportUtil.report("PTFaceDetector.getFaceDetector() is null!, OS version is " + Build.VERSION.SDK_INT);
          mSpareFaceDetector = new VideoPreviewFaceOutlineDetector();
        }
        return mSpareFaceDetector;
      }
      finally {}
    }
    return this.mFaceDetector;
  }
  
  public String getHistogramInfo()
  {
    if (this.mDetGLThread != null) {
      return this.mDetGLThread.getHistogramInfo();
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
    if ((this.isInited) || (!ApiHelper.hasJellyBeanMR1())) {
      return false;
    }
    init(false);
    this.firstDet = true;
    this.isInited = true;
    this.mOffsetTimeInited = false;
    return true;
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
    if (this.mDetGLThread != null) {
      this.mDetGLThread.onPreviewStartPreImmediately();
    }
  }
  
  public boolean reInit()
  {
    return true;
  }
  
  public void resetDetector()
  {
    if (this.mLastInputFrame != null)
    {
      this.mLastInputFrame.setCanUnlock(false);
      this.mLastInputFrame.unlock();
    }
    this.mDetDataPipe = null;
  }
  
  public void setAgeDetectable(boolean paramBoolean)
  {
    if (this.mDetGLThread != null) {
      this.mDetGLThread.setAgeDetectable(paramBoolean);
    }
  }
  
  public void setGenderDetectable(boolean paramBoolean)
  {
    if (this.mDetGLThread != null) {
      this.mDetGLThread.setGenderDetectable(paramBoolean);
    }
  }
  
  public void setMaxFaceCount(int paramInt)
  {
    if (this.mDetGLThread != null) {
      this.mDetGLThread.setMaxFaceCount(paramInt);
    }
  }
  
  public void setSupportSmallFace(boolean paramBoolean)
  {
    if (this.mFaceDetector != null) {
      this.mFaceDetector.setSupportSmallFace(paramBoolean);
    }
  }
  
  public void tryFaceDetectorInit()
  {
    if (this.mDetGLThread != null) {
      this.mDetGLThread.tryFaceDetectorInit();
    }
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTFaceDetector
 * JD-Core Version:    0.7.0.1
 */