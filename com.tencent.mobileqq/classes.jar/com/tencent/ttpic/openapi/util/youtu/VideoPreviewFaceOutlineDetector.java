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
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.openapi.facedetect.FaceDetector;
import com.tencent.ttpic.openapi.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.openapi.facedetect.FaceDetector.FaceDetectListener;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.initializer.AnimojiInitializer;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.initializer.FaceKitInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.util.AgeDetector;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.openapi.util.YoutuPointsUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.youtu.ExpressionDetectorObject;
import com.tencent.ttpic.util.youtu.FaceKitSDK;
import com.tencent.ttpic.util.youtu.GenderDetector;
import com.tencent.ttpic.util.youtu.VideoFaceDetector;
import com.tencent.ttpic.util.youtu.YTFaceDetectorBase;
import com.tencent.ttpic.util.youtu.animojisdk.AnimojiSDK;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
  private static final float offsetY = -0.05F;
  private static final float xishuX = 1.5F;
  private static final float xishuY = 0.8F;
  private final int FACEINFO_BUFFER_LIFE = 0;
  private float[] animojiSDKResetFaceAngles = { 90.0F, 90.0F, 90.0F };
  private Handler doTrackHandler;
  private FaceKitSDK faceKitSDK = FaceKitSDK.INSTANCE;
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
  private int mDetectType = FaceDetector.DETECT_TYPE.DETECT_TYPE_NONE.value;
  private VideoFaceDetector mFaceDetect = new VideoFaceDetector();
  private boolean mInitSuccess = false;
  private boolean mIsLastFaceDetected = false;
  private boolean mIsSmallFace = false;
  private boolean mIsSupportSmallFace = false;
  private long mSmallFaceChangeTime = 0L;
  private boolean needDetect3D = false;
  private boolean needExpressionWeights;
  private boolean needFaceKit = false;
  private boolean needReset = false;
  
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
  
  private float getDist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
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
  
  private boolean isFaceKitValid(List<PointF> paramList, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramArrayOfFloat == null) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return false;
    }
    if ((paramList.size() < 83) || (paramArrayOfFloat.length < 19335)) {
      return false;
    }
    PointF localPointF1 = new PointF((paramArrayOfFloat[18576] + paramArrayOfFloat[8439]) / 2.0F, paramInt2 - (paramArrayOfFloat[18577] + paramArrayOfFloat[8440]) / 2.0F);
    paramArrayOfFloat = new PointF((paramArrayOfFloat[16227] + paramArrayOfFloat[13191]) / 2.0F, paramInt2 - (paramArrayOfFloat[16228] + paramArrayOfFloat[13192]) / 2.0F);
    float f1 = ((PointF)paramList.get(37)).x;
    f1 = (((PointF)paramList.get(41)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList.get(37)).y;
    PointF localPointF2 = new PointF(f1, (((PointF)paramList.get(41)).y + f2) / 2.0F);
    f1 = ((PointF)paramList.get(47)).x;
    f1 = (((PointF)paramList.get(51)).x + f1) / 2.0F;
    f2 = ((PointF)paramList.get(47)).y;
    paramList = new PointF(f1, (((PointF)paramList.get(51)).y + f2) / 2.0F);
    f1 = getDist(localPointF1.x, localPointF1.y, localPointF2.x, localPointF2.y);
    f2 = getDist(paramArrayOfFloat.x, paramArrayOfFloat.y, paramList.x, paramList.y);
    float f3 = getDist(localPointF2.x, localPointF2.y, paramList.x, paramList.y);
    if (f1 + f2 > f3 / 2.0F)
    {
      Log.d("FaceKitIsValid", "leftEyeDis : " + f1 + "，rightEyeDis: " + f2 + "，eye2DDis：" + f3);
      return false;
    }
    return true;
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
        break label899;
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
      label899:
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
        this.mDetectType = FaceDetector.DETECT_TYPE.DETECT_TYPE_NONE.value;
        this.mFaceDetect.destroy();
        this.mFaceDetect = null;
        this.doTrackHandler = null;
        Point localPoint = this.lastDoTrackSize;
        this.lastDoTrackSize.y = 0;
        localPoint.x = 0;
      }
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
        break label1443;
      }
      BenchUtil.benchStart("only doTrack");
      if (!this.needDetect3D) {
        break label369;
      }
      BenchUtil.benchStart("faceDetect3D");
      localObject1 = this.mFaceDetect.doTrack3D(paramArrayOfByte, paramInt1, paramInt2, GamePlaySDK.getInstance().getFov());
      BenchUtil.benchEnd("faceDetect3D");
      label115:
      BenchUtil.benchEnd("only doTrack");
    }
    for (;;)
    {
      this.faceTrackTime = (System.currentTimeMillis() - this.faceTrackTime);
      boolean bool;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        bool = true;
        label148:
        this.mIsLastFaceDetected = bool;
        if (!bool)
        {
          this.lastFaceDetectedPhoneRotation = 0;
          if (this.lastFaceKitPoint83 != null) {
            this.lastFaceKitPoint83.clear();
          }
        }
        if ((this.needFaceKit) && (!FeatureManager.Features.FACE_KIT.isFunctionReady())) {
          FeatureManager.Features.FACE_KIT.init();
        }
        if ((this.needFaceKit) && (FeatureManager.Features.FACE_KIT.isFunctionReady()) && (localObject1 != null))
        {
          BenchUtil.benchStart("faceKit detect");
          i = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (i >= localObject1.length) {
            break label1240;
          }
          if (i == 0)
          {
            localAnimojiSDK = localObject1[i];
            List localList = YoutuPointsUtil.transform90PointsTo83(localAnimojiSDK.xys);
            int j = localList.size();
            Object localObject2 = (float[][])Array.newInstance(Float.TYPE, new int[] { j, 2 });
            j = 0;
            for (;;)
            {
              if (j < localList.size())
              {
                localObject2[j][0] = ((PointF)localList.get(j)).x;
                localObject2[j][1] = ((PointF)localList.get(j)).y;
                j += 1;
                continue;
                i = 0;
                break;
                label369:
                BenchUtil.benchStart("faceDetect");
                localObject1 = this.mFaceDetect.doTrack(paramArrayOfByte, paramInt1, paramInt2);
                BenchUtil.benchEnd("faceDetect");
                break label115;
                bool = false;
                break label148;
              }
            }
            Object localObject3 = new float[68];
            float[] arrayOfFloat2 = new float[68];
            float[] arrayOfFloat1 = new float[''];
            ArrayList localArrayList1 = new ArrayList();
            ArrayList localArrayList2 = new ArrayList();
            FaceKitSDK localFaceKitSDK = this.faceKitSDK;
            FaceKitSDK.convertPoints((float[][])localObject2, localArrayList1, localArrayList2);
            j = 0;
            while (j < 68)
            {
              localObject3[j] = ((Float)localArrayList1.get(j)).floatValue();
              arrayOfFloat2[j] = (paramInt2 - ((Float)localArrayList2.get(j)).floatValue());
              arrayOfFloat1[(j * 2)] = localObject3[j];
              arrayOfFloat1[(j * 2 + 1)] = (paramInt2 - arrayOfFloat2[j]);
              j += 1;
            }
            if (this.faceKitVerticesArray.size() == 0)
            {
              localObject2 = this.faceKitVerticesArray;
              localObject3 = this.faceKitSDK;
              ((List)localObject2).add(new float[19335]);
              this.featureIndicesArray.add(new int[68]);
            }
            if (!AlgoUtils.samePeople(localList, this.lastFaceKitPoint83))
            {
              this.faceKitSDK.nativeReset();
              this.animojiSDKResetFaceAngles[0] = localAnimojiSDK.pitch;
              this.animojiSDKResetFaceAngles[1] = localAnimojiSDK.yaw;
              this.animojiSDKResetFaceAngles[2] = localAnimojiSDK.roll;
            }
            for (;;)
            {
              this.lastFaceKitPoint83 = localList;
              this.facePiont2DCenter.x = ((PointF)localList.get(63)).x;
              this.facePiont2DCenter.y = ((PointF)localList.get(63)).y;
              this.faceKitSDK.doTrack(arrayOfFloat1, paramInt1, paramInt2, (float[])this.faceKitVerticesArray.get(i), (int[])this.featureIndicesArray.get(i), true);
              localObject2 = this.faceKitSDK;
              j = 6310;
              for (;;)
              {
                localObject2 = this.faceKitSDK;
                if (j >= 6445) {
                  break;
                }
                localObject2 = this.faceKitSDK;
                localObject2 = FaceKitSDK.FACEKIT_INDEX_MAP;
                localObject3 = this.faceKitSDK;
                int k = localObject2[(j - 6310)];
                ((float[])this.faceKitVerticesArray.get(i))[(j * 3)] = ((float[])this.faceKitVerticesArray.get(i))[(k * 3)];
                ((float[])this.faceKitVerticesArray.get(i))[(j * 3 + 1)] = ((float[])this.faceKitVerticesArray.get(i))[(k * 3 + 1)];
                ((float[])this.faceKitVerticesArray.get(i))[(j * 3 + 2)] = ((float[])this.faceKitVerticesArray.get(i))[(k * 3 + 2)];
                j += 1;
              }
              if ((Math.abs(localAnimojiSDK.pitch) <= 15.0F) && (Math.abs(localAnimojiSDK.yaw) <= 15.0F) && (Math.abs(localAnimojiSDK.roll) <= 15.0F) && ((Math.abs(this.animojiSDKResetFaceAngles[0]) > 15.0F) || (Math.abs(this.animojiSDKResetFaceAngles[1]) > 15.0F) || (Math.abs(this.animojiSDKResetFaceAngles[2]) > 15.0F)))
              {
                this.faceKitSDK.nativeReset();
                this.animojiSDKResetFaceAngles[0] = localAnimojiSDK.pitch;
                this.animojiSDKResetFaceAngles[1] = localAnimojiSDK.yaw;
                this.animojiSDKResetFaceAngles[2] = localAnimojiSDK.roll;
              }
            }
            if (Float.isNaN(((float[])this.faceKitVerticesArray.get(i))[0]))
            {
              this.faceKitSDK.nativeResetAndReTrack(arrayOfFloat1, paramInt1, paramInt2);
              this.animojiSDKResetFaceAngles[0] = localAnimojiSDK.pitch;
              this.animojiSDKResetFaceAngles[1] = localAnimojiSDK.yaw;
              this.animojiSDKResetFaceAngles[2] = localAnimojiSDK.roll;
            }
            if ((this.faceKitVerticesArray != null) && (!isFaceKitValid(localList, (float[])this.faceKitVerticesArray.get(i), paramInt1, paramInt2)))
            {
              if (this.lastFaceKitPoint83 != null) {
                this.lastFaceKitPoint83.clear();
              }
              this.faceKitVerticesArray.clear();
              this.featureIndicesArray.clear();
              this.faceKitSDK.nativeReset();
              this.animojiSDKResetFaceAngles[0] = localAnimojiSDK.pitch;
              this.animojiSDKResetFaceAngles[1] = localAnimojiSDK.yaw;
              this.animojiSDKResetFaceAngles[2] = localAnimojiSDK.roll;
            }
          }
          i += 1;
        }
      }
      label1240:
      updatePointsAndAngles((FaceStatus[])localObject1);
      if (this.needExpressionWeights) {
        FeatureManager.Features.ANIMOJI.init();
      }
      AnimojiSDK localAnimojiSDK = FeatureManager.Features.ANIMOJI.getAnimojiSDK();
      if ((this.needExpressionWeights) && (FeatureManager.Features.ANIMOJI.isFunctionReady()) && (localObject1 != null))
      {
        BenchUtil.benchStart("animoji expression detect");
        i = 0;
        while (i < this.faceInfos.size())
        {
          localObject1 = (FaceInfo)this.faceInfos.get(i);
          updateExpressionWeights(paramInt1, paramInt2, localAnimojiSDK, i, (FaceInfo)localObject1);
          updateEyeRollWeights((FaceInfo)localObject1);
          i += 1;
        }
      }
      bufferFaceInfos();
      this.mExpressionDetectorObject.addFaces(this.faceInfos);
      GenderDetector.getInstance().updateFacesTrack(this.faceInfos);
      if (GenderDetector.getInstance().isDetectGender()) {
        GenderDetector.getInstance().detectGenderAndUpdateFaceInfo(paramArrayOfByte, paramInt1, paramInt2, this.faceInfos);
      }
      if (AgeDetector.getInstance().isDetectAge()) {
        AgeDetector.getInstance().detectAgeAndUpdateFaceInfo(paramArrayOfByte, paramInt1, paramInt2, this.faceInfos);
      }
      updateTriggerExpression();
      updateActionCount();
      updateActionStatusChanged();
      notifyFaceDetectListener();
      return bool;
      label1443:
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
    //   5: getfield 88	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mInitSuccess	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial 709	com/tencent/ttpic/openapi/facedetect/FaceDetector:init	()I
    //   21: pop
    //   22: aload_0
    //   23: getfield 161	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mFaceDetect	Lcom/tencent/ttpic/util/youtu/VideoFaceDetector;
    //   26: ifnull +14 -> 40
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 161	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mFaceDetect	Lcom/tencent/ttpic/util/youtu/VideoFaceDetector;
    //   34: invokevirtual 710	com/tencent/ttpic/util/youtu/VideoFaceDetector:init	()Z
    //   37: putfield 88	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mInitSuccess	Z
    //   40: getstatic 71	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:TAG	Ljava/lang/String;
    //   43: new 261	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 712
    //   53: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 88	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mInitSuccess	Z
    //   60: invokevirtual 715	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   63: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 720	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 88	com/tencent/ttpic/openapi/util/youtu/VideoPreviewFaceOutlineDetector:mInitSuccess	Z
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
    return this.mDetectType != FaceDetector.DETECT_TYPE.DETECT_TYPE_NONE.value;
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
  
  public void resetAnimoji()
  {
    this.needReset = true;
  }
  
  public void setDoTrackHandler(Handler paramHandler)
  {
    this.doTrackHandler = paramHandler;
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
  
  public void setNeedFaceKit(boolean paramBoolean)
  {
    this.needFaceKit = paramBoolean;
  }
  
  public void setSupportSmallFace(boolean paramBoolean)
  {
    this.mIsSupportSmallFace = paramBoolean;
    Log.i("faceDetect", "IsSupportSmallFace = " + this.mIsSupportSmallFace);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector
 * JD-Core Version:    0.7.0.1
 */