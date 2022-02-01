package com.tencent.ttpic.openapi.util.youtu;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceActionCounterListener;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.filter.Face3DLibJNI;
import com.tencent.ttpic.openapi.facedetect.FaceDetector;
import com.tencent.ttpic.openapi.facedetect.FaceDetector.DetectType;
import com.tencent.ttpic.openapi.facedetect.FaceDetector.FaceDetectListener;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.initializer.Face3DLibInitializer;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.initializer.TNNTongueDetectIntializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.AgeDetector;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.youtu.ExpressionDetectorObject;
import com.tencent.ttpic.util.youtu.VideoFaceDetector;
import com.tencent.ttpic.util.youtu.YTFaceDetectorBase;
import com.tencent.ttpic.util.youtu.animojisdk.AnimojiSDK;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.ttpic.openapi.facedetect.FaceInfo;>;
import java.util.Random;

public class VideoPreviewFaceOutlineDetector
  extends FaceDetector
  implements FaceActionCounterListener
{
  public static final int FACE_CENTER_INDEX = 63;
  private static final String TAG = "VideoPreviewFaceOutlineDetector";
  public static TextView expressionTextView;
  private static float fov = 60.0F;
  private static final float offsetY = -0.05F;
  private static final float xishuX = 1.5F;
  private static final float xishuY = 0.8F;
  private int DISTANCE_MAX_TWO_POINTS = 100;
  private final int FACEINFO_BUFFER_LIFE = 0;
  private final int SLEFT_EYE_INDEX = 43;
  private final int SRIGHT_EYE_INDEX = 53;
  private float[] animojiSDKResetFaceAngles = { 90.0F, 90.0F, 90.0F };
  private Handler doTrackHandler;
  private float[] face3DInputPtsArray = new float['¦'];
  private float[] face3DOutputPoseParams = new float[6];
  private List<float[]> face3DRotationArray = new ArrayList();
  private List<float[]> face3DVerticesArray = new ArrayList();
  private List<float[]> faceKitVerticesArray = new ArrayList();
  private PointF facePiont2DCenter = new PointF(0.0F, 0.0F);
  private long faceTrackTime = 0L;
  private int faceinfoOutdate = 0;
  private List<int[]> featureIndicesArray = new ArrayList();
  private boolean isInitRefine = false;
  private boolean isIsLastFaceDetectedInited = false;
  private boolean isRunning = false;
  private Point lastDoTrackSize = new Point(0, 0);
  private float lastEyeRotateY = 0.0F;
  private int lastFaceDetectedPhoneRotation = 0;
  private List<FaceInfo> lastFaceInfos = new ArrayList(3);
  private List<PointF> lastFaceKitPoint83 = new ArrayList();
  private float lastTongueOut = 0.0F;
  private int mDetectType = FaceDetector.DetectType.DETECT_TYPE_NONE.value;
  private HashMap<Integer, Long> mFaceCodeIDMap;
  private VideoFaceDetector mFaceDetect = new VideoFaceDetector();
  private boolean mInitSuccess = false;
  private boolean mIsLastFaceDetected = false;
  private boolean mIsSmallFace = false;
  private boolean mIsSupportSmallFace = false;
  private long mSmallFaceChangeTime = 0L;
  private List<VideoPreviewFaceOutlineDetector.TraceFaceItem> mTraceFcaeList;
  private boolean need3DMMTransform;
  private boolean needAvatarFaceKit;
  private boolean needDetect3D = false;
  private boolean needExpressionWeights;
  private boolean needFaceMeshFaceKit = false;
  private boolean needPoseEstimate = false;
  private boolean needReset = false;
  private boolean needTongueDetect = false;
  private long sFaceIndexCount = 0L;
  
  private void bufferFaceInfos()
  {
    if (!CollectionUtils.isEmpty(this.faceInfos))
    {
      this.lastFaceInfos.clear();
      this.lastFaceInfos.addAll(this.faceInfos);
      this.faceinfoOutdate = 0;
      return;
    }
    if ((CollectionUtils.isEmpty(this.faceInfos)) && (this.faceinfoOutdate < 0))
    {
      this.faceInfos.addAll(this.lastFaceInfos);
      this.faceinfoOutdate += 1;
    }
  }
  
  private float calFaceRectSize(List<List<PointF>> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (paramList != null)
    {
      f1 = f2;
      if (paramList.size() != 0)
      {
        paramList = AlgoUtils.getFaceRectF((List)paramList.get(0));
        if (paramList == null) {
          return 0.0F;
        }
        float f3;
        if (paramInt3 == 0)
        {
          f3 = paramList.width();
          f1 = paramList.height();
          f2 = paramList.left;
          f3 *= 0.1F;
          paramList.left = (f2 - f3);
          paramList.top -= 0.1F * f1;
          paramList.right += f3;
          paramList.bottom += f1 * 0.5F;
        }
        else if (paramInt3 == 90)
        {
          f1 = paramList.width();
          f3 = paramList.height();
          paramList.left -= 0.5F * f1;
          f2 = paramList.top;
          f3 *= 0.1F;
          paramList.top = (f2 - f3);
          paramList.right += f1 * 0.1F;
          paramList.bottom += f3;
        }
        else if (paramInt3 == 180)
        {
          f3 = paramList.width();
          f1 = paramList.height();
          f2 = paramList.left;
          f3 *= 0.1F;
          paramList.left = (f2 - f3);
          paramList.top -= 0.5F * f1;
          paramList.right += f3;
          paramList.bottom += f1 * 0.1F;
        }
        else
        {
          f1 = paramList.width();
          f3 = paramList.height();
          paramList.left -= f1 * 0.1F;
          f2 = paramList.top;
          f3 *= 0.1F;
          paramList.top = (f2 - f3);
          paramList.right += f1 * 0.5F;
          paramList.bottom += f3;
        }
        f1 = paramList.width() * paramList.height() / paramInt1 / paramInt2;
      }
    }
    return f1;
  }
  
  private VideoPreviewFaceOutlineDetector.TraceFaceItem creatTraceFaceItem(FaceInfo paramFaceInfo)
  {
    long l = this.sFaceIndexCount;
    this.sFaceIndexCount = (1L + l);
    return new VideoPreviewFaceOutlineDetector.TraceFaceItem(this, l, paramFaceInfo);
  }
  
  private double distance2Points(PointF paramPointF1, PointF paramPointF2)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DIS:(");
    localStringBuilder.append(paramPointF1.x);
    localStringBuilder.append(",");
    localStringBuilder.append(paramPointF1.y);
    localStringBuilder.append(")->(");
    localStringBuilder.append(paramPointF2.x);
    localStringBuilder.append(",");
    localStringBuilder.append(paramPointF2.y);
    localStringBuilder.append(")");
    Log.i(str, localStringBuilder.toString());
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private float getDist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private long getFaceIDByFaceInfo(FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo != null)
    {
      HashMap localHashMap = this.mFaceCodeIDMap;
      if (localHashMap != null)
      {
        paramFaceInfo = (Long)localHashMap.get(Integer.valueOf(paramFaceInfo.hashCode()));
        if (paramFaceInfo == null) {
          return -2L;
        }
        return paramFaceInfo.longValue();
      }
    }
    return -1L;
  }
  
  private float getFakeFaceValues(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            return 0.0F;
          }
          return new Random().nextFloat() * 0.2F + 0.8F;
        }
        return new Random().nextFloat() * 0.2F + 0.8F;
      }
      return new Random().nextFloat();
    }
    return new Random().nextFloat() * 0.12F + 0.18F;
  }
  
  public static float getFov()
  {
    return fov;
  }
  
  private boolean isInRefineCrashWhiteName()
  {
    return false;
  }
  
  private boolean isInSmallFaceTimeInterval()
  {
    return System.currentTimeMillis() - this.mSmallFaceChangeTime <= 2000L;
  }
  
  private void notifyFaceDetectListener()
  {
    if (CollectionUtils.isEmpty(this.faceDetectListeners)) {
      return;
    }
    List localList1 = getAllFaces();
    List localList2 = getAllFaceAngles();
    Iterator localIterator = new HashSet(this.faceDetectListeners).iterator();
    while (localIterator.hasNext())
    {
      FaceDetector.FaceDetectListener localFaceDetectListener = (FaceDetector.FaceDetectListener)localIterator.next();
      if (localFaceDetectListener != null) {
        localFaceDetectListener.onFaceDetectResult(localList1, localList2);
      }
    }
  }
  
  public static void setFov(float paramFloat)
  {
    fov = paramFloat;
  }
  
  private void updateExpressionWeights(int paramInt1, int paramInt2, AnimojiSDK paramAnimojiSDK, int paramInt3, FaceInfo paramFaceInfo)
  {
    Object localObject = paramFaceInfo.points;
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { ((List)localObject).size(), 2 });
    int i = 0;
    while (i < ((List)localObject).size())
    {
      arrayOfFloat[i][0] = ((PointF)((List)localObject).get(i)).x;
      arrayOfFloat[i][1] = ((PointF)((List)localObject).get(i)).y;
      i += 1;
    }
    localObject = new float[68];
    float[] arrayOfFloat1 = new float[68];
    float[] arrayOfFloat2 = new float[''];
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    AnimojiSDK.convertPoints(arrayOfFloat, localArrayList1, localArrayList2);
    i = 0;
    while (i < 68)
    {
      localObject[i] = ((Float)localArrayList1.get(i)).floatValue();
      float f = paramInt2;
      arrayOfFloat1[i] = (f - ((Float)localArrayList2.get(i)).floatValue());
      int j = i * 2;
      arrayOfFloat2[j] = localObject[i];
      arrayOfFloat2[(j + 1)] = (f - arrayOfFloat1[i]);
      i += 1;
    }
    if (paramInt3 == 0)
    {
      paramFaceInfo.expressionWeights = paramAnimojiSDK.recognizeExpression(arrayOfFloat2, paramInt1, paramInt2).expressionWeights;
      if ((Float.isNaN(paramFaceInfo.expressionWeights[0])) || (this.needReset))
      {
        paramAnimojiSDK.nativeResetAndReTrack(arrayOfFloat2, paramInt1, paramInt2);
        this.needReset = false;
      }
      paramInt1 = 0;
      while (paramInt1 < paramFaceInfo.expressionWeights.length)
      {
        if (Float.isNaN(paramFaceInfo.expressionWeights[paramInt1]))
        {
          Log.e(TAG, String.format("faceStatus.expressionWeights[%d] = %f", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFaceInfo.expressionWeights[paramInt1]) }));
          paramFaceInfo.expressionWeights[paramInt1] = 0.0F;
        }
        paramFaceInfo.expressionWeights[paramInt1] = clamp(paramFaceInfo.expressionWeights[paramInt1], 0.0F, 1.0F);
        paramInt1 += 1;
      }
    }
  }
  
  private void updateEyeRollWeights(FaceInfo paramFaceInfo)
  {
    Object localObject = paramFaceInfo.points;
    new PointF();
    new PointF();
    PointF localPointF2 = new PointF(((PointF)((List)localObject).get(54)).x, ((PointF)((List)localObject).get(54)).y);
    PointF localPointF1 = new PointF(localPointF2.x - ((PointF)((List)localObject).get(49)).x, localPointF2.y - ((PointF)((List)localObject).get(49)).y);
    localPointF2 = new PointF(localPointF2.x - ((PointF)((List)localObject).get(45)).x, localPointF2.y - ((PointF)((List)localObject).get(45)).y);
    float f1 = (float)Math.sqrt(Math.pow(localPointF1.x, 2.0D) + Math.pow(localPointF1.y, 2.0D));
    float f2 = ((float)Math.sqrt(Math.pow(localPointF2.x, 2.0D) + Math.pow(localPointF2.y, 2.0D)) + f1) * 0.5F;
    double d1 = 1.570796F;
    Double.isNaN(d1);
    d1 /= 3.0D;
    double d2 = (f1 - f2) / f2;
    Double.isNaN(d2);
    f2 = (float)(d1 * d2);
    localPointF2 = new PointF(((PointF)((List)localObject).get(45)).x - ((PointF)((List)localObject).get(49)).x, ((PointF)((List)localObject).get(45)).y - ((PointF)((List)localObject).get(49)).y);
    f1 = (float)((Math.atan2(localPointF1.x, localPointF1.y) - Math.atan2(localPointF2.x, localPointF2.y)) * 180.0D / 3.141592653589793D);
    d1 = f1;
    if (d1 > 180.0D) {
      Double.isNaN(d1);
    }
    for (d1 -= 360.0D;; d1 += 360.0D)
    {
      f1 = (float)d1;
      break;
      if (d1 >= -180.0D) {
        break;
      }
      Double.isNaN(d1);
    }
    localPointF1 = new PointF(-1.570796F * f1 / 270.0F, f2);
    PointF localPointF3 = new PointF(((PointF)((List)localObject).get(44)).x, ((PointF)((List)localObject).get(44)).y);
    localPointF2 = new PointF(localPointF3.x - ((PointF)((List)localObject).get(39)).x, localPointF3.y - ((PointF)((List)localObject).get(39)).y);
    localPointF3 = new PointF(localPointF3.x - ((PointF)((List)localObject).get(35)).x, localPointF3.y - ((PointF)((List)localObject).get(35)).y);
    f1 = (float)Math.sqrt(Math.pow(localPointF2.x, 2.0D) + Math.pow(localPointF2.y, 2.0D));
    f2 = ((float)Math.sqrt(Math.pow(localPointF3.x, 2.0D) + Math.pow(localPointF3.y, 2.0D)) + f1) * 0.5F;
    f2 = (f1 - f2) / f2;
    localObject = new PointF(((PointF)((List)localObject).get(35)).x - ((PointF)((List)localObject).get(39)).x, ((PointF)((List)localObject).get(35)).y - ((PointF)((List)localObject).get(39)).y);
    f1 = (float)((Math.atan2(localPointF2.x, localPointF2.y) - Math.atan2(((PointF)localObject).x, ((PointF)localObject).y)) * 180.0D / 3.141592653589793D);
    d1 = f1;
    if (d1 > 180.0D) {
      Double.isNaN(d1);
    }
    for (d1 -= 360.0D;; d1 += 360.0D)
    {
      f1 = (float)d1;
      break;
      if (d1 >= -180.0D) {
        break;
      }
      Double.isNaN(d1);
    }
    localObject = new PointF(1.570796F * f1 / 270.0F, -0.5235988F * f2);
    localObject = new PointF((localPointF1.x + ((PointF)localObject).x) * 0.5F, (localPointF1.y + ((PointF)localObject).y) * 0.5F);
    paramFaceInfo.eyeRollWeights = new float[] { ((PointF)localObject).x, ((PointF)localObject).y, 0.0F };
  }
  
  public void autoChangeFaceRefine(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mIsSupportSmallFace) {
      return;
    }
    if (isInRefineCrashWhiteName()) {
      return;
    }
    if (isInSmallFaceTimeInterval()) {
      return;
    }
    float f = calFaceRectSize(getAllFaces(), paramInt1, paramInt2, paramInt3);
    StringBuilder localStringBuilder;
    if ((!this.mIsSmallFace) && (!isInitRefine()) && (f < 0.03F) && (f > 0.01F))
    {
      this.mIsSmallFace = true;
      nativeSetRefine(this.mIsSmallFace);
      this.mSmallFaceChangeTime = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refine open! smallFaceSize = ");
      localStringBuilder.append(f);
      Log.i("faceDetect", localStringBuilder.toString());
      return;
    }
    if ((this.mIsSmallFace) && (!isInitRefine()) && ((f >= 0.03F) || (f < 0.01F)))
    {
      this.mIsSmallFace = false;
      nativeSetRefine(this.mIsSmallFace);
      this.mSmallFaceChangeTime = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refine close! smallFaceSize = ");
      localStringBuilder.append(f);
      Log.i("faceDetect", localStringBuilder.toString());
    }
  }
  
  float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = paramFloat1;
    if (paramFloat1 < paramFloat2) {
      f = paramFloat2;
    }
    paramFloat1 = f;
    if (f > paramFloat3) {
      paramFloat1 = paramFloat3;
    }
    return paramFloat1;
  }
  
  public void destroy()
  {
    super.destroy();
    synchronized (mDetectLock)
    {
      if (this.mFaceDetect != null)
      {
        this.mDetectType = FaceDetector.DetectType.DETECT_TYPE_NONE.value;
        this.mFaceDetect.destroy();
        this.mFaceDetect = null;
        this.doTrackHandler = null;
        Point localPoint = this.lastDoTrackSize;
        this.lastDoTrackSize.y = 0;
        localPoint.x = 0;
      }
      resetTraceFaceItems();
      return;
    }
  }
  
  public void doDectectTrackByRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    doFaceDetect(paramArrayOfByte, paramInt1, paramInt2);
    doTrack(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean doFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.mInitSuccess) && (paramArrayOfByte != null))
    {
      if (paramArrayOfByte.length != paramInt1 * paramInt2 * 4) {
        return false;
      }
      synchronized (mDetectLock)
      {
        if (this.mFaceDetect != null)
        {
          boolean bool = this.mFaceDetect.doFaceDetect(paramArrayOfByte, paramInt1, paramInt2);
          return bool;
        }
        return false;
      }
    }
    return false;
  }
  
  public void doFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != paramInt1 * paramInt2) {
        return;
      }
      synchronized (mDetectLock)
      {
        if (this.mFaceDetect != null) {
          this.mFaceDetect.doFaceDetectByY(paramArrayOfByte, paramInt1, paramInt2);
        }
        return;
      }
    }
  }
  
  public boolean doTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = paramArrayOfByte;
    int j = paramInt1;
    int k = paramInt2;
    if ((this.mInitSuccess) && (this.mFaceDetect != null))
    {
      Object localObject1 = this.lastDoTrackSize;
      ((Point)localObject1).x = j;
      ((Point)localObject1).y = k;
      this.mTrackFrameCount += 1;
      localObject1 = null;
      int i;
      if ((localObject2 != null) && (localObject2.length == j * k * 4)) {
        i = 1;
      } else {
        i = 0;
      }
      this.faceTrackTime = System.currentTimeMillis();
      if (i != 0)
      {
        BenchUtil.benchStart("only doTrack");
        if (this.needDetect3D)
        {
          BenchUtil.benchStart("faceDetect3D");
          localObject1 = this.mFaceDetect.doTrack3D((byte[])localObject2, j, k, fov);
          BenchUtil.benchEnd("faceDetect3D");
        }
        else
        {
          BenchUtil.benchStart("faceDetect");
          localObject1 = this.mFaceDetect.doTrack((byte[])localObject2, j, k, this.needPoseEstimate);
          BenchUtil.benchEnd("faceDetect");
        }
        BenchUtil.benchEnd("only doTrack");
      }
      this.faceTrackTime = (System.currentTimeMillis() - this.faceTrackTime);
      if ((localObject1 != null) && (localObject1.length > 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.mIsLastFaceDetected = bool1;
      if (!bool1)
      {
        this.lastFaceDetectedPhoneRotation = 0;
        localObject2 = this.lastFaceKitPoint83;
        if (localObject2 != null) {
          ((List)localObject2).clear();
        }
      }
      updatePointsAndAngles((FaceStatus[])localObject1);
      boolean bool2;
      if ((!this.needFaceMeshFaceKit) && (!this.needExpressionWeights) && (!this.needAvatarFaceKit))
      {
        bool2 = bool1;
        if (!this.need3DMMTransform) {}
      }
      else
      {
        if (!FeatureManager.Features.FACE_3D_LIB.isFunctionReady()) {
          FeatureManager.Features.FACE_3D_LIB.init();
        }
        bool2 = bool1;
        if (FeatureManager.Features.FACE_3D_LIB.isFunctionReady())
        {
          bool2 = bool1;
          if (localObject1 != null)
          {
            if (this.face3DVerticesArray.size() == 0) {
              this.face3DVerticesArray.add(new float[10344]);
            }
            if (this.face3DRotationArray.size() == 0)
            {
              this.face3DRotationArray.add(new float[16]);
              this.face3DRotationArray.add(new float[16]);
              this.face3DRotationArray.add(new float[16]);
            }
            if (this.faceInfos.size() > 0)
            {
              i = 0;
              for (;;)
              {
                k = paramInt2;
                int m = paramInt1;
                bool2 = bool1;
                if (i >= this.faceInfos.size()) {
                  break;
                }
                localObject1 = (FaceInfo)this.faceInfos.get(i);
                localObject2 = ((FaceInfo)localObject1).points;
                if (i == 0) {
                  if (AlgoUtils.isFacePointsValid((List)localObject2))
                  {
                    Object localObject3 = AlgoUtils.getFaceRectF((List)localObject2);
                    float f2 = 1.0F;
                    float f1 = f2;
                    if (localObject3 != null)
                    {
                      f1 = f2;
                      if (Math.min(((RectF)localObject3).width(), ((RectF)localObject3).height()) > 0.0F) {
                        if (this.needFaceMeshFaceKit) {
                          f1 = f2;
                        } else {
                          f1 = 60.0F / Math.min(((RectF)localObject3).width(), ((RectF)localObject3).height());
                        }
                      }
                    }
                    j = 0;
                    while (j < 83)
                    {
                      localObject3 = this.face3DInputPtsArray;
                      int n = j * 2;
                      localObject3[n] = (((PointF)((List)localObject2).get(j)).x * f1);
                      this.face3DInputPtsArray[(n + 1)] = (((PointF)((List)localObject2).get(j)).y * f1);
                      j += 1;
                    }
                    if ((((FaceInfo)localObject1).expressionWeights == null) || (((FaceInfo)localObject1).expressionWeights.length != 52)) {
                      ((FaceInfo)localObject1).expressionWeights = new float[52];
                    }
                    float f3 = -((FaceInfo)localObject1).pitch;
                    float f4 = -((FaceInfo)localObject1).yaw;
                    float f5 = -((FaceInfo)localObject1).roll;
                    if (this.needTongueDetect)
                    {
                      if (!FeatureManager.Features.TNN_TONGUE_DETECT.isFunctionReady()) {
                        FeatureManager.Features.TNN_TONGUE_DETECT.init();
                      }
                      if (FeatureManager.Features.TNN_TONGUE_DETECT.isFunctionReady())
                      {
                        f2 = FeatureManager.Features.TNN_TONGUE_DETECT.forward(paramArrayOfByte, m, k, VideoMaterial.toFlatArray((List)localObject2));
                        break label744;
                      }
                    }
                    f2 = 0.0F;
                    label744:
                    f2 = f2 * 0.3F + this.lastTongueOut * 0.7F;
                    this.lastTongueOut = f2;
                    j = (int)(m * f1);
                    k = (int)(k * f1);
                    localObject2 = Face3DLibJNI.getInstance();
                    localObject3 = this.face3DInputPtsArray;
                    float[] arrayOfFloat1 = (float[])this.face3DVerticesArray.get(0);
                    float[] arrayOfFloat2 = this.face3DOutputPoseParams;
                    float[] arrayOfFloat3 = ((FaceInfo)localObject1).expressionWeights;
                    bool2 = this.needFaceMeshFaceKit;
                    boolean bool3 = this.needAvatarFaceKit;
                    boolean bool4 = this.need3DMMTransform;
                    ((Face3DLibJNI)localObject2).track((float[])localObject3, new float[] { f3, f4, f5 }, arrayOfFloat1, arrayOfFloat2, arrayOfFloat3, j, k, bool2, bool3, bool4, f2);
                    AlgoUtils.calcTransformMatrix(this.face3DOutputPoseParams, (float[])this.face3DRotationArray.get(0), f1);
                    AlgoUtils.calcRotateMatrix(this.face3DOutputPoseParams, (float[])this.face3DRotationArray.get(1));
                    this.face3DRotationArray.set(2, AlgoUtils.calcPerspectiveProjTransformMatrix(this.face3DOutputPoseParams, j, k, f1));
                  }
                  else
                  {
                    Arrays.fill((float[])this.face3DVerticesArray.get(0), 0.0F);
                    Arrays.fill((float[])this.face3DRotationArray.get(0), 0.0F);
                    Arrays.fill((float[])this.face3DRotationArray.get(1), 0.0F);
                  }
                }
                updateEyeRollWeights((FaceInfo)localObject1);
                i += 1;
              }
            }
            Arrays.fill((float[])this.face3DVerticesArray.get(0), 0.0F);
            Arrays.fill((float[])this.face3DRotationArray.get(0), 0.0F);
            Arrays.fill((float[])this.face3DRotationArray.get(1), 0.0F);
            break label1082;
          }
        }
      }
      boolean bool1 = bool2;
      label1082:
      bufferFaceInfos();
      this.mExpressionDetectorObject.addFaces(this.faceInfos);
      updateFacesTrack(this.faceInfos);
      if (AgeDetector.getInstance().isDetectAge()) {
        AgeDetector.getInstance().detectAgeAndUpdateFaceInfo(paramArrayOfByte, paramInt1, paramInt2, this.faceInfos);
      }
      updateTriggerExpression();
      updateActionCount();
      updateActionStatusChanged();
      notifyFaceDetectListener();
      return bool1;
    }
    return false;
  }
  
  public void doTrackByRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (needDetectFace(doTrack(paramArrayOfByte, paramInt1, paramInt2), this.isRunning))
    {
      this.isRunning = true;
      postJob(new VideoPreviewFaceOutlineDetector.2(this, paramArrayOfByte, paramInt1, paramInt2, paramInt3));
    }
  }
  
  public byte[] doTrackByTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramInt1, paramInt2, paramInt3);
    if (needDetectFace(doTrack(arrayOfByte, paramInt2, paramInt3))) {
      postJob(new VideoPreviewFaceOutlineDetector.1(this, arrayOfByte, paramInt2, paramInt3));
    }
    return arrayOfByte;
  }
  
  public RetrieveDataManager.DATA_TYPE getDataType()
  {
    return RetrieveDataManager.DATA_TYPE.RGBA;
  }
  
  public long getFaceTrackTime()
  {
    return this.faceTrackTime;
  }
  
  public float getFaceValues(int paramInt1, int paramInt2)
  {
    return getFakeFaceValues(paramInt2);
  }
  
  public Point getLastDoTrackSize()
  {
    return this.lastDoTrackSize;
  }
  
  public int getLastFaceDetectedPhoneRotation()
  {
    return this.lastFaceDetectedPhoneRotation;
  }
  
  public List<LinkedList<FaceInfo>> getShookFaceInfos()
  {
    return this.mExpressionDetectorObject.getShookFaceInfos();
  }
  
  public int init()
  {
    try
    {
      boolean bool = this.mInitSuccess;
      int i = 0;
      if (bool) {
        return 0;
      }
      super.init();
      if (this.mFaceDetect != null) {
        this.mInitSuccess = this.mFaceDetect.init();
      }
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPreviewFaceOutlineDetector init ret = ");
      localStringBuilder.append(this.mInitSuccess);
      LogUtils.e(str, localStringBuilder.toString());
      bool = this.mInitSuccess;
      if (!bool) {
        i = 2;
      }
      return i;
    }
    finally {}
  }
  
  public boolean isInitRefine()
  {
    return this.isInitRefine;
  }
  
  public boolean isLastFrameDetectFaces()
  {
    return this.mIsLastFaceDetected;
  }
  
  public boolean isNeed3DMMTransform()
  {
    return this.need3DMMTransform;
  }
  
  public boolean isNeedAvatarFaceKit()
  {
    return this.needAvatarFaceKit;
  }
  
  public void nativeSetRefine(boolean paramBoolean)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setRefine] enable = ");
    localStringBuilder.append(paramBoolean);
    LogUtils.e(str, localStringBuilder.toString());
    if (FeatureManager.Features.FACE_DETECT.isFunctionReady())
    {
      YTFaceDetectorBase.getInstance().nativeSetRefine(paramBoolean);
      this.isInitRefine = paramBoolean;
    }
  }
  
  public boolean needDetectFaceValue()
  {
    return this.mDetectType != FaceDetector.DetectType.DETECT_TYPE_NONE.value;
  }
  
  public void postDoTrack(Runnable paramRunnable)
  {
    synchronized (mDetectLock)
    {
      if (this.doTrackHandler != null) {
        this.doTrackHandler.post(paramRunnable);
      } else {
        paramRunnable.run();
      }
      return;
    }
  }
  
  public void reset()
  {
    this.mFaceDetect.reset();
  }
  
  public void resetAnimoji()
  {
    this.needReset = true;
  }
  
  public void resetTraceFaceItems()
  {
    Object localObject = this.mFaceCodeIDMap;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    localObject = this.mTraceFcaeList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
  
  public void setDoTrackHandler(Handler paramHandler)
  {
    this.doTrackHandler = paramHandler;
  }
  
  public void setFace3DRotationArray(List<float[]> paramList)
  {
    this.face3DRotationArray = paramList;
  }
  
  public void setFace3DVerticesArray(List<float[]> paramList)
  {
    this.face3DVerticesArray = paramList;
  }
  
  public void setFaceKitVerticesArray(List<float[]> paramList)
  {
    this.faceKitVerticesArray = paramList;
  }
  
  public void setFacePiont2DCenter(PointF paramPointF)
  {
    this.facePiont2DCenter = paramPointF;
  }
  
  public void setFaceValueDetectType(int paramInt)
  {
    this.mDetectType = paramInt;
  }
  
  public void setFeatureIndicesArray(List<int[]> paramList)
  {
    this.featureIndicesArray = paramList;
  }
  
  public void setNeed3DMMTransform(boolean paramBoolean)
  {
    this.need3DMMTransform = paramBoolean;
  }
  
  public void setNeedAvatarFaceKit(boolean paramBoolean)
  {
    this.needAvatarFaceKit = paramBoolean;
  }
  
  public void setNeedDetect3D(boolean paramBoolean)
  {
    this.needDetect3D = paramBoolean;
  }
  
  public void setNeedExpressionWeights(boolean paramBoolean)
  {
    this.needExpressionWeights = paramBoolean;
    if (paramBoolean) {
      resetAnimoji();
    }
  }
  
  public void setNeedFaceMeshFaceKit(boolean paramBoolean)
  {
    this.needFaceMeshFaceKit = paramBoolean;
  }
  
  public void setNeedPoseEstimate(boolean paramBoolean)
  {
    this.needPoseEstimate = paramBoolean;
  }
  
  public void setNeedTongueDetect(boolean paramBoolean)
  {
    this.needTongueDetect = paramBoolean;
  }
  
  public void setSupportSmallFace(boolean paramBoolean)
  {
    this.mIsSupportSmallFace = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IsSupportSmallFace = ");
    localStringBuilder.append(this.mIsSupportSmallFace);
    Log.i("faceDetect", localStringBuilder.toString());
  }
  
  public void updateFacesTrack(List<FaceInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (this.mTraceFcaeList == null) {
        this.mTraceFcaeList = new ArrayList();
      }
      int k = paramList.size();
      int m = this.mTraceFcaeList.size();
      int j = 0;
      int i = 0;
      if (k == m) {
        while (i < k)
        {
          ((VideoPreviewFaceOutlineDetector.TraceFaceItem)this.mTraceFcaeList.get(i)).updatePoints((FaceInfo)paramList.get(i));
          i += 1;
        }
      }
      i = j;
      if (m > k)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject1 = TAG;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("人脸变少了：mTraceFcaeList=");
        ((StringBuilder)localObject2).append(this.mTraceFcaeList.size());
        ((StringBuilder)localObject2).append("-->Faces=");
        ((StringBuilder)localObject2).append(paramList.size());
        Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (FaceInfo)((Iterator)localObject2).next();
          double d1 = this.DISTANCE_MAX_TWO_POINTS;
          Iterator localIterator = this.mTraceFcaeList.iterator();
          paramList = null;
          while (localIterator.hasNext())
          {
            localObject1 = (VideoPreviewFaceOutlineDetector.TraceFaceItem)localIterator.next();
            if (!localArrayList2.contains(localObject1))
            {
              double d2 = ((VideoPreviewFaceOutlineDetector.TraceFaceItem)localObject1).distanceTwoFaces((FaceInfo)localObject3);
              if (d2 < d1)
              {
                paramList = (List<FaceInfo>)localObject1;
                d1 = d2;
              }
            }
          }
          if (paramList != null)
          {
            paramList.updatePoints((FaceInfo)localObject3);
            localArrayList1.add(paramList);
            localArrayList2.add(paramList);
            localObject1 = TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("匹配上一帧人脸，ID：");
            ((StringBuilder)localObject3).append(VideoPreviewFaceOutlineDetector.TraceFaceItem.access$600(paramList));
            Log.i((String)localObject1, ((StringBuilder)localObject3).toString());
          }
          else
          {
            Log.i(TAG, "人脸丢失，ID");
          }
        }
        this.mTraceFcaeList.clear();
        this.mTraceFcaeList = localArrayList1;
        return;
      }
      while (i < k)
      {
        if (i < m) {
          ((VideoPreviewFaceOutlineDetector.TraceFaceItem)this.mTraceFcaeList.get(i)).updatePoints((FaceInfo)paramList.get(i));
        } else {
          this.mTraceFcaeList.add(creatTraceFaceItem((FaceInfo)paramList.get(i)));
        }
        i += 1;
      }
      return;
    }
    paramList = this.mTraceFcaeList;
    if (paramList != null) {
      paramList.clear();
    }
    this.mTraceFcaeList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector
 * JD-Core Version:    0.7.0.1
 */