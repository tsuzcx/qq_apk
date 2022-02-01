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
import java.util.Random;

public class VideoPreviewFaceOutlineDetector
  extends FaceDetector
  implements FaceActionCounterListener
{
  public static final int FACE_CENTER_INDEX = 63;
  private static final String TAG = VideoPreviewFaceOutlineDetector.class.getSimpleName();
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
    }
    while ((!CollectionUtils.isEmpty(this.faceInfos)) || (this.faceinfoOutdate >= 0)) {
      return;
    }
    this.faceInfos.addAll(this.lastFaceInfos);
    this.faceinfoOutdate += 1;
  }
  
  private float calFaceRectSize(List<List<PointF>> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    float f2;
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = AlgoUtils.getFaceRectF((List)paramList.get(0));
      if (paramList == null) {
        return 0.0F;
      }
      if (paramInt3 == 0)
      {
        f1 = paramList.width();
        f2 = paramList.height();
        paramList.left -= f1 * 0.1F;
        paramList.top -= f2 * 0.1F;
        paramList.right = (f1 * 0.1F + paramList.right);
        paramList.bottom += f2 * 0.5F;
        f1 = paramList.width();
      }
    }
    for (float f1 = paramList.height() * f1 / paramInt1 / paramInt2;; f1 = 0.0F)
    {
      return f1;
      if (paramInt3 == 90)
      {
        f1 = paramList.width();
        f2 = paramList.height();
        paramList.left -= f1 * 0.5F;
        paramList.top -= f2 * 0.1F;
        paramList.right = (f1 * 0.1F + paramList.right);
        paramList.bottom += f2 * 0.1F;
        break;
      }
      if (paramInt3 == 180)
      {
        f1 = paramList.width();
        f2 = paramList.height();
        paramList.left -= f1 * 0.1F;
        paramList.top -= f2 * 0.5F;
        paramList.right = (f1 * 0.1F + paramList.right);
        paramList.bottom += f2 * 0.1F;
        break;
      }
      f1 = paramList.width();
      f2 = paramList.height();
      paramList.left -= f1 * 0.1F;
      paramList.top -= f2 * 0.1F;
      paramList.right = (f1 * 0.5F + paramList.right);
      paramList.bottom += f2 * 0.1F;
      break;
    }
  }
  
  private VideoPreviewFaceOutlineDetector.TraceFaceItem creatTraceFaceItem(FaceInfo paramFaceInfo)
  {
    long l = this.sFaceIndexCount;
    this.sFaceIndexCount = (1L + l);
    return new VideoPreviewFaceOutlineDetector.TraceFaceItem(this, l, paramFaceInfo);
  }
  
  private double distance2Points(PointF paramPointF1, PointF paramPointF2)
  {
    Log.i(TAG, "DIS:(" + paramPointF1.x + "," + paramPointF1.y + ")->(" + paramPointF2.x + "," + paramPointF2.y + ")");
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private float getDist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
  }
  
  private long getFaceIDByFaceInfo(FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (this.mFaceCodeIDMap == null)) {
      return -1L;
    }
    paramFaceInfo = (Long)this.mFaceCodeIDMap.get(Integer.valueOf(paramFaceInfo.hashCode()));
    if (paramFaceInfo == null) {
      return -2L;
    }
    return paramFaceInfo.longValue();
  }
  
  private float getFakeFaceValues(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0.0F;
    case 1: 
      return 0.18F + new Random().nextFloat() * 0.12F;
    case 2: 
      return new Random().nextFloat();
    case 4: 
      return new Random().nextFloat() * 0.2F + 0.8F;
    }
    return new Random().nextFloat() * 0.2F + 0.8F;
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
    if (CollectionUtils.isEmpty(this.faceDetectListeners)) {}
    for (;;)
    {
      return;
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
  }
  
  public static void setFov(float paramFloat)
  {
    fov = paramFloat;
  }
  
  private void updateExpressionWeights(int paramInt1, int paramInt2, AnimojiSDK paramAnimojiSDK, int paramInt3, FaceInfo paramFaceInfo)
  {
    Object localObject = paramFaceInfo.points;
    int i = ((List)localObject).size();
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { i, 2 });
    i = 0;
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
      arrayOfFloat1[i] = (paramInt2 - ((Float)localArrayList2.get(i)).floatValue());
      arrayOfFloat2[(i * 2)] = localObject[i];
      arrayOfFloat2[(i * 2 + 1)] = (paramInt2 - arrayOfFloat1[i]);
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
    float f3 = (float)(1.570796F / 3.0D * ((f1 - f2) / f2));
    localPointF2 = new PointF(((PointF)((List)localObject).get(45)).x - ((PointF)((List)localObject).get(49)).x, ((PointF)((List)localObject).get(45)).y - ((PointF)((List)localObject).get(49)).y);
    f2 = (float)((Math.atan2(localPointF1.x, localPointF1.y) - Math.atan2(localPointF2.x, localPointF2.y)) * 180.0D / 3.141592653589793D);
    float f4;
    if (f2 > 180.0D)
    {
      f1 = (float)(f2 - 360.0D);
      localPointF1 = new PointF(f1 * -1.570796F / 270.0F, f3);
      PointF localPointF3 = new PointF(((PointF)((List)localObject).get(44)).x, ((PointF)((List)localObject).get(44)).y);
      localPointF2 = new PointF(localPointF3.x - ((PointF)((List)localObject).get(39)).x, localPointF3.y - ((PointF)((List)localObject).get(39)).y);
      localPointF3 = new PointF(localPointF3.x - ((PointF)((List)localObject).get(35)).x, localPointF3.y - ((PointF)((List)localObject).get(35)).y);
      f1 = (float)Math.sqrt(Math.pow(localPointF2.x, 2.0D) + Math.pow(localPointF2.y, 2.0D));
      double d = Math.pow(localPointF3.x, 2.0D);
      f2 = ((float)Math.sqrt(Math.pow(localPointF3.y, 2.0D) + d) + f1) * 0.5F;
      f3 = -(1.570796F / 3.0F);
      f4 = (f1 - f2) / f2;
      localObject = new PointF(((PointF)((List)localObject).get(35)).x - ((PointF)((List)localObject).get(39)).x, ((PointF)((List)localObject).get(35)).y - ((PointF)((List)localObject).get(39)).y);
      f2 = (float)(180.0D * (Math.atan2(localPointF2.x, localPointF2.y) - Math.atan2(((PointF)localObject).x, ((PointF)localObject).y)) / 3.141592653589793D);
      if (f2 <= 180.0D) {
        break label903;
      }
      f1 = (float)(f2 - 360.0D);
    }
    for (;;)
    {
      localObject = new PointF(f1 * 1.570796F / 270.0F, f3 * f4);
      f1 = localPointF1.x;
      f2 = ((PointF)localObject).x;
      f3 = localPointF1.y;
      localObject = new PointF((f1 + f2) * 0.5F, (((PointF)localObject).y + f3) * 0.5F);
      paramFaceInfo.eyeRollWeights = new float[] { ((PointF)localObject).x, ((PointF)localObject).y, 0.0F };
      return;
      f1 = f2;
      if (f2 >= -180.0D) {
        break;
      }
      f1 = (float)(f2 + 360.0D);
      break;
      label903:
      f1 = f2;
      if (f2 < -180.0D) {
        f1 = (float)(f2 + 360.0D);
      }
    }
  }
  
  public void autoChangeFaceRefine(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mIsSupportSmallFace) {}
    float f;
    do
    {
      do
      {
        return;
      } while ((isInRefineCrashWhiteName()) || (isInSmallFaceTimeInterval()));
      f = calFaceRectSize(getAllFaces(), paramInt1, paramInt2, paramInt3);
      if ((!this.mIsSmallFace) && (!isInitRefine()) && (f < 0.03F) && (f > 0.01F))
      {
        this.mIsSmallFace = true;
        nativeSetRefine(this.mIsSmallFace);
        this.mSmallFaceChangeTime = System.currentTimeMillis();
        Log.i("faceDetect", "refine open! smallFaceSize = " + f);
        return;
      }
    } while ((!this.mIsSmallFace) || (isInitRefine()) || ((f < 0.03F) && (f >= 0.01F)));
    this.mIsSmallFace = false;
    nativeSetRefine(this.mIsSmallFace);
    this.mSmallFaceChangeTime = System.currentTimeMillis();
    Log.i("faceDetect", "refine close! smallFaceSize = " + f);
  }
  
  float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {}
    for (;;)
    {
      if (paramFloat2 > paramFloat3) {
        return paramFloat3;
      }
      return paramFloat2;
      paramFloat2 = paramFloat1;
    }
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
    if ((!this.mInitSuccess) || (paramArrayOfByte == null) || (paramArrayOfByte.length != paramInt1 * paramInt2 * 4)) {
      return false;
    }
    synchronized (mDetectLock)
    {
      if (this.mFaceDetect != null)
      {
        boolean bool = this.mFaceDetect.doFaceDetect(paramArrayOfByte, paramInt1, paramInt2);
        return bool;
      }
    }
    return false;
  }
  
  public void doFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != paramInt1 * paramInt2)) {
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
  
  public boolean doTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((!this.mInitSuccess) || (this.mFaceDetect == null)) {
      return false;
    }
    this.lastDoTrackSize.x = paramInt1;
    this.lastDoTrackSize.y = paramInt2;
    this.mTrackFrameCount += 1;
    int i;
    Object localObject1;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == paramInt1 * paramInt2 * 4))
    {
      i = 1;
      this.faceTrackTime = System.currentTimeMillis();
      if (i == 0) {
        break label1074;
      }
      BenchUtil.benchStart("only doTrack");
      if (!this.needDetect3D) {
        break label508;
      }
      BenchUtil.benchStart("faceDetect3D");
      localObject1 = this.mFaceDetect.doTrack3D(paramArrayOfByte, paramInt1, paramInt2, fov);
      BenchUtil.benchEnd("faceDetect3D");
      label112:
      BenchUtil.benchEnd("only doTrack");
    }
    for (;;)
    {
      this.faceTrackTime = (System.currentTimeMillis() - this.faceTrackTime);
      boolean bool1;
      label145:
      Object localObject2;
      Object localObject3;
      float f1;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        bool1 = true;
        this.mIsLastFaceDetected = bool1;
        if (!bool1)
        {
          this.lastFaceDetectedPhoneRotation = 0;
          if (this.lastFaceKitPoint83 != null) {
            this.lastFaceKitPoint83.clear();
          }
        }
        updatePointsAndAngles((FaceStatus[])localObject1);
        if ((!this.needFaceMeshFaceKit) && (!this.needExpressionWeights) && (!this.needAvatarFaceKit) && (!this.need3DMMTransform)) {
          break label1004;
        }
        if (!FeatureManager.Features.FACE_3D_LIB.isFunctionReady()) {
          FeatureManager.Features.FACE_3D_LIB.init();
        }
        if ((!FeatureManager.Features.FACE_3D_LIB.isFunctionReady()) || (localObject1 == null)) {
          break label1004;
        }
        if (this.face3DVerticesArray.size() == 0) {
          this.face3DVerticesArray.add(new float[10344]);
        }
        if (this.face3DRotationArray.size() == 0)
        {
          this.face3DRotationArray.add(new float[16]);
          this.face3DRotationArray.add(new float[16]);
          this.face3DRotationArray.add(new float[16]);
        }
        if (this.faceInfos.size() <= 0) {
          break label953;
        }
        i = 0;
        if (i >= this.faceInfos.size()) {
          break label1004;
        }
        localObject1 = (FaceInfo)this.faceInfos.get(i);
        localObject2 = ((FaceInfo)localObject1).points;
        if (i != 0) {
          break label884;
        }
        if (!AlgoUtils.isFacePointsValid((List)localObject2)) {
          break label899;
        }
        localObject3 = AlgoUtils.getFaceRectF((List)localObject2);
        if ((localObject3 == null) || (Math.min(((RectF)localObject3).width(), ((RectF)localObject3).height()) <= 0.0F)) {
          break label1068;
        }
        if (!this.needFaceMeshFaceKit) {
          break label546;
        }
        f1 = 1.0F;
      }
      for (;;)
      {
        label427:
        int j = 0;
        for (;;)
        {
          if (j < 83)
          {
            this.face3DInputPtsArray[(j * 2)] = (((PointF)((List)localObject2).get(j)).x * f1);
            this.face3DInputPtsArray[(j * 2 + 1)] = (((PointF)((List)localObject2).get(j)).y * f1);
            j += 1;
            continue;
            i = 0;
            break;
            label508:
            BenchUtil.benchStart("faceDetect");
            localObject1 = this.mFaceDetect.doTrack(paramArrayOfByte, paramInt1, paramInt2, this.needPoseEstimate);
            BenchUtil.benchEnd("faceDetect");
            break label112;
            bool1 = false;
            break label145;
            label546:
            f1 = 60.0F / Math.min(((RectF)localObject3).width(), ((RectF)localObject3).height());
            break label427;
          }
        }
        if ((((FaceInfo)localObject1).expressionWeights == null) || (((FaceInfo)localObject1).expressionWeights.length != 52)) {
          ((FaceInfo)localObject1).expressionWeights = new float[52];
        }
        float f4 = -((FaceInfo)localObject1).pitch;
        float f5 = -((FaceInfo)localObject1).yaw;
        float f6 = -((FaceInfo)localObject1).roll;
        float f3 = 0.0F;
        float f2 = f3;
        if (this.needTongueDetect)
        {
          if (!FeatureManager.Features.TNN_TONGUE_DETECT.isFunctionReady()) {
            FeatureManager.Features.TNN_TONGUE_DETECT.init();
          }
          f2 = f3;
          if (FeatureManager.Features.TNN_TONGUE_DETECT.isFunctionReady()) {
            f2 = FeatureManager.Features.TNN_TONGUE_DETECT.forward(paramArrayOfByte, paramInt1, paramInt2, VideoMaterial.toFlatArray((List)localObject2));
          }
        }
        f2 = f2 * 0.3F + this.lastTongueOut * 0.7F;
        this.lastTongueOut = f2;
        j = (int)(paramInt1 * f1);
        int k = (int)(paramInt2 * f1);
        localObject2 = Face3DLibJNI.getInstance();
        localObject3 = this.face3DInputPtsArray;
        float[] arrayOfFloat1 = (float[])this.face3DVerticesArray.get(0);
        float[] arrayOfFloat2 = this.face3DOutputPoseParams;
        float[] arrayOfFloat3 = ((FaceInfo)localObject1).expressionWeights;
        boolean bool2 = this.needFaceMeshFaceKit;
        boolean bool3 = this.needAvatarFaceKit;
        boolean bool4 = this.need3DMMTransform;
        ((Face3DLibJNI)localObject2).track((float[])localObject3, new float[] { f4, f5, f6 }, arrayOfFloat1, arrayOfFloat2, arrayOfFloat3, j, k, bool2, bool3, bool4, f2);
        AlgoUtils.calcTransformMatrix(this.face3DOutputPoseParams, (float[])this.face3DRotationArray.get(0), f1);
        AlgoUtils.calcRotateMatrix(this.face3DOutputPoseParams, (float[])this.face3DRotationArray.get(1));
        this.face3DRotationArray.set(2, AlgoUtils.calcPerspectiveProjTransformMatrix(this.face3DOutputPoseParams, j, k, f1));
        for (;;)
        {
          label884:
          updateEyeRollWeights((FaceInfo)localObject1);
          i += 1;
          break;
          label899:
          Arrays.fill((float[])this.face3DVerticesArray.get(0), 0.0F);
          Arrays.fill((float[])this.face3DRotationArray.get(0), 0.0F);
          Arrays.fill((float[])this.face3DRotationArray.get(1), 0.0F);
        }
        label953:
        Arrays.fill((float[])this.face3DVerticesArray.get(0), 0.0F);
        Arrays.fill((float[])this.face3DRotationArray.get(0), 0.0F);
        Arrays.fill((float[])this.face3DRotationArray.get(1), 0.0F);
        label1004:
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
        label1068:
        f1 = 1.0F;
      }
      label1074:
      localObject1 = null;
    }
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
  
  /* Error */
  public int init()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 109	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mInitSuccess	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial 776	com/tencent/ttpic/openapi/facedetect/FaceDetector:init	()I
    //   21: pop
    //   22: aload_0
    //   23: getfield 197	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mFaceDetect	Lcom/tencent/ttpic/util/youtu/VideoFaceDetector;
    //   26: ifnull +14 -> 40
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 197	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mFaceDetect	Lcom/tencent/ttpic/util/youtu/VideoFaceDetector;
    //   34: invokevirtual 777	com/tencent/ttpic/util/youtu/VideoFaceDetector:init	()Z
    //   37: putfield 109	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mInitSuccess	Z
    //   40: getstatic 89	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:TAG	Ljava/lang/String;
    //   43: new 287	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 779
    //   53: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 109	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mInitSuccess	Z
    //   60: invokevirtual 782	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   63: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 787	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 109	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mInitSuccess	Z
    //   73: istore_2
    //   74: iload_2
    //   75: ifne -62 -> 13
    //   78: iconst_2
    //   79: istore_1
    //   80: goto -67 -> 13
    //   83: astore_3
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	VideoPreviewFaceOutlineDetector
    //   1	79	1	i	int
    //   8	67	2	bool	boolean
    //   83	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	83	finally
    //   17	40	83	finally
    //   40	74	83	finally
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
    LogUtils.e(TAG, "[setRefine] enable = " + paramBoolean);
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
      if (this.doTrackHandler != null)
      {
        this.doTrackHandler.post(paramRunnable);
        return;
      }
      paramRunnable.run();
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
    if (this.mFaceCodeIDMap != null) {
      this.mFaceCodeIDMap.clear();
    }
    if (this.mTraceFcaeList != null) {
      this.mTraceFcaeList.clear();
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
    Log.i("faceDetect", "IsSupportSmallFace = " + this.mIsSupportSmallFace);
  }
  
  public void updateFacesTrack(List<FaceInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (this.mTraceFcaeList != null) {
        this.mTraceFcaeList.clear();
      }
      this.mTraceFcaeList = null;
    }
    int j;
    int k;
    int i;
    for (;;)
    {
      return;
      if (this.mTraceFcaeList == null) {
        this.mTraceFcaeList = new ArrayList();
      }
      j = paramList.size();
      k = this.mTraceFcaeList.size();
      if (j != k) {
        break;
      }
      i = 0;
      while (i < j)
      {
        ((VideoPreviewFaceOutlineDetector.TraceFaceItem)this.mTraceFcaeList.get(i)).updatePoints((FaceInfo)paramList.get(i));
        i += 1;
      }
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    label209:
    FaceInfo localFaceInfo;
    if (k > j)
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      Log.i(TAG, "人脸变少了：mTraceFcaeList=" + this.mTraceFcaeList.size() + "-->Faces=" + paramList.size());
      Iterator localIterator1 = paramList.iterator();
      if (localIterator1.hasNext())
      {
        localFaceInfo = (FaceInfo)localIterator1.next();
        double d1 = this.DISTANCE_MAX_TWO_POINTS;
        Iterator localIterator2 = this.mTraceFcaeList.iterator();
        paramList = null;
        label250:
        while (localIterator2.hasNext())
        {
          VideoPreviewFaceOutlineDetector.TraceFaceItem localTraceFaceItem = (VideoPreviewFaceOutlineDetector.TraceFaceItem)localIterator2.next();
          if (!localArrayList2.contains(localTraceFaceItem))
          {
            double d2 = localTraceFaceItem.distanceTwoFaces(localFaceInfo);
            if (d2 >= d1) {
              break label475;
            }
            d1 = d2;
            paramList = localTraceFaceItem;
          }
        }
      }
    }
    label396:
    label447:
    label475:
    for (;;)
    {
      break label250;
      if (paramList != null)
      {
        paramList.updatePoints(localFaceInfo);
        localArrayList1.add(paramList);
        localArrayList2.add(paramList);
        Log.i(TAG, "匹配上一帧人脸，ID：" + VideoPreviewFaceOutlineDetector.TraceFaceItem.access$600(paramList));
        break label209;
      }
      Log.i(TAG, "人脸丢失，ID");
      break label209;
      this.mTraceFcaeList.clear();
      this.mTraceFcaeList = localArrayList1;
      return;
      i = 0;
      if (i < j)
      {
        if (i >= k) {
          break label447;
        }
        ((VideoPreviewFaceOutlineDetector.TraceFaceItem)this.mTraceFcaeList.get(i)).updatePoints((FaceInfo)paramList.get(i));
      }
      for (;;)
      {
        i += 1;
        break label396;
        break;
        this.mTraceFcaeList.add(creatTraceFaceItem((FaceInfo)paramList.get(i)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector
 * JD-Core Version:    0.7.0.1
 */