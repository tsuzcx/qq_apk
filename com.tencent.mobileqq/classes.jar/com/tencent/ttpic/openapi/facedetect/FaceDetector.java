package com.tencent.ttpic.openapi.facedetect;

import android.content.Context;
import android.graphics.PointF;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.face.LeftEyeRangeDetector;
import com.tencent.ttpic.face.MouthRangeDetector;
import com.tencent.ttpic.face.RightEyeRangeDetector;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.util.AgeDetector;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.openapi.util.YoutuPointsUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceActionCallback;
import com.tencent.ttpic.util.youtu.ExpressionDetectorObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class FaceDetector
{
  public static float FACE_DETECT_WIDTH = 180.0F;
  protected static final int FACE_DET_INTERVAL = 7;
  private static final int HIGH_FREQ_FACE_DETECT_INTERVAL = 100;
  private static final int LOW_FREQ_FACE_DETECT_INTERVAL = 800;
  public static final float SMALL_FACE_OPEN_DOWNLOW = 0.01F;
  public static final float SMALL_FACE_OPEN_UPLOW = 0.03F;
  public static final long SMALL_FACE_SWITCH_TIME_INTERVAL = 2000L;
  private static final String TAG = FaceDetector.class.getSimpleName();
  private static final int lookingForFaceDuration = 100000;
  protected static final Object mDetectLock = new Object();
  private Sensor accelerometer;
  private double angle = 0.0D;
  boolean clearFaceQueue = false;
  private int curDetectInterval = 800;
  private FaceDetector.DetectStage detectStage = FaceDetector.DetectStage.DETECT_NO_FACE;
  protected List<Set<Integer>> expressions;
  protected Set<FaceDetector.FaceDetectListener> faceDetectListeners = new HashSet();
  protected List<FaceInfo> faceInfos = new ArrayList();
  private long factor = 0L;
  private String htName;
  private boolean isFaceActionCounterInited = false;
  private long lastFaceDetectTime = 0L;
  protected Handler mDetectorThreadHandler;
  protected ExpressionDetectorObject mExpressionDetectorObject = new ExpressionDetectorObject();
  protected final SparseArray<Set<FaceActionCallback>> mFaceActionCallbacks = new SparseArray();
  protected final Map<Integer, FaceActionCounter> mFaceActionCounter = new HashMap();
  protected final Map<Integer, Boolean> mFaceActionStatus = new HashMap();
  private SensorEventListener mSensorEventListener = new FaceDetector.1(this);
  public int mTrackFrameCount;
  protected Set<Integer> mTriggeredExpressionType = new HashSet();
  protected boolean mUpdateActionCounter;
  protected Map<String, String[]> recordFaceInfo = new HashMap();
  private SensorManager sensorManager;
  private long startLostFaceTime = 0L;
  
  public void addFaceActionCallback(int paramInt, FaceActionCallback paramFaceActionCallback)
  {
    if (paramFaceActionCallback == null) {
      return;
    }
    Set localSet = (Set)this.mFaceActionCallbacks.get(paramInt);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.mFaceActionCallbacks.put(paramInt, localObject);
    }
    ((Set)localObject).add(paramFaceActionCallback);
  }
  
  public void clearActionCounter()
  {
    if (!this.isFaceActionCounterInited) {}
    for (;;)
    {
      return;
      this.mUpdateActionCounter = true;
      Iterator localIterator = this.mFaceActionCounter.values().iterator();
      while (localIterator.hasNext()) {
        ((FaceActionCounter)localIterator.next()).clear();
      }
    }
  }
  
  public void destroy()
  {
    synchronized (mDetectLock)
    {
      if (this.mDetectorThreadHandler != null)
      {
        this.mFaceActionStatus.clear();
        this.mFaceActionCallbacks.clear();
        HandlerThreadManager.getInstance().destroyHandlerThread(this.htName);
        this.mDetectorThreadHandler = null;
        this.sensorManager.unregisterListener(this.mSensorEventListener);
      }
      this.faceDetectListeners.clear();
      return;
    }
  }
  
  public boolean detectExpression(int paramInt)
  {
    return (this.mTriggeredExpressionType.contains(Integer.valueOf(paramInt))) || (paramInt == PTFaceAttr.PTExpression.ALWAYS.value);
  }
  
  public FaceRangeStatus detectFaceRangeStatus(List<PointF> paramList)
  {
    FaceRangeStatus localFaceRangeStatus = new FaceRangeStatus();
    if ((paramList == null) || (paramList.size() < 90)) {
      return localFaceRangeStatus;
    }
    localFaceRangeStatus.leftEye = LeftEyeRangeDetector.getInstance().detectRange(paramList);
    localFaceRangeStatus.rightEye = RightEyeRangeDetector.getInstance().detectRange(paramList);
    localFaceRangeStatus.mouth = MouthRangeDetector.getInstance().detectRange(paramList);
    if (AlgoUtils.getDistance((PointF)paramList.get(77), (PointF)paramList.get(69)) / AlgoUtils.getDistance((PointF)paramList.get(65), (PointF)paramList.get(66)) >= 0.6F) {}
    for (boolean bool = true;; bool = false)
    {
      localFaceRangeStatus.isKiss = bool;
      return localFaceRangeStatus;
    }
  }
  
  public abstract boolean doFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void doTrackByRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract byte[] doTrackByTexture(int paramInt1, int paramInt2, int paramInt3);
  
  public List<float[]> getAllFaceAngles()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < getFaceCount())
    {
      localArrayList.add(getFaceAngles(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public List<FaceInfo> getAllFaceInfos()
  {
    return new ArrayList(this.faceInfos);
  }
  
  public List<List<PointF>> getAllFaces()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < getFaceCount())
    {
      localArrayList.add(getAllPoints(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public List<List<PointF>> getAllIris()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < getFaceCount())
    {
      localArrayList.add(getIrisPoints(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public List<PointF> getAllPoints(int paramInt)
  {
    try
    {
      if (CollectionUtils.indexOutOfBounds(this.faceInfos, paramInt))
      {
        localObject1 = new ArrayList();
        return localObject1;
      }
      Object localObject1 = ((FaceInfo)this.faceInfos.get(paramInt)).points;
      return localObject1;
    }
    finally {}
  }
  
  public List<Float[]> getAllPointsVis()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < getFaceCount())
    {
      localArrayList.add(getAllPointsVis(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public Float[] getAllPointsVis(int paramInt)
  {
    try
    {
      if (CollectionUtils.indexOutOfBounds(this.faceInfos, paramInt)) {
        return new Float[0];
      }
      Float[] arrayOfFloat = ((FaceInfo)this.faceInfos.get(paramInt)).pointsVis;
      return arrayOfFloat;
    }
    finally {}
  }
  
  public abstract RetrieveDataManager.DATA_TYPE getDataType();
  
  public List<Set<Integer>> getExpressions()
  {
    return this.expressions;
  }
  
  public Map<Integer, FaceActionCounter> getFaceActionCounter()
  {
    if (this.isFaceActionCounterInited) {
      return new HashMap(this.mFaceActionCounter);
    }
    return new HashMap();
  }
  
  public float[] getFaceAngles(int paramInt)
  {
    try
    {
      if (CollectionUtils.indexOutOfBounds(this.faceInfos, paramInt)) {
        return new float[0];
      }
      float[] arrayOfFloat = ((FaceInfo)this.faceInfos.get(paramInt)).angles;
      return arrayOfFloat;
    }
    finally {}
  }
  
  public int getFaceCount()
  {
    return this.faceInfos.size();
  }
  
  public List<FaceInfo> getFaceInfos()
  {
    return this.faceInfos;
  }
  
  public List<FaceStatus> getFaceStatus3Ds()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.faceInfos.iterator();
    while (localIterator.hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)localIterator.next();
      FaceStatus localFaceStatus = new FaceStatus();
      localFaceStatus.pitch = localFaceInfo.pitch;
      localFaceStatus.yaw = localFaceInfo.yaw;
      localFaceStatus.roll = localFaceInfo.roll;
      localFaceStatus.tx = localFaceInfo.tx;
      localFaceStatus.ty = localFaceInfo.ty;
      localFaceStatus.scale = localFaceInfo.scale;
      localFaceStatus.denseFaceModel = localFaceInfo.denseFaceModel;
      localFaceStatus.transform = localFaceInfo.transform;
      localFaceStatus.expressionWeights = localFaceInfo.expressionWeights;
      localFaceStatus.eyeRollWeights = localFaceInfo.eyeRollWeights;
      localFaceStatus.gender = localFaceInfo.gender;
      localFaceStatus.age = localFaceInfo.age;
      localFaceStatus.faceID = localFaceInfo.faceId;
      localFaceStatus.eyeEulerAngle = localFaceInfo.eyeEulerAngle;
      localArrayList.add(localFaceStatus);
    }
    return localArrayList;
  }
  
  public List<PointF> getIrisPoints(int paramInt)
  {
    try
    {
      if (CollectionUtils.indexOutOfBounds(this.faceInfos, paramInt))
      {
        localObject1 = new ArrayList();
        return localObject1;
      }
      Object localObject1 = ((FaceInfo)this.faceInfos.get(paramInt)).irisPoints;
      return localObject1;
    }
    finally {}
  }
  
  public float getPhotoAngle()
  {
    return (float)this.angle;
  }
  
  public Map<String, String[]> getRecordFaceInfo()
  {
    Iterator localIterator = this.faceInfos.iterator();
    while (localIterator.hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)localIterator.next();
      if (!this.recordFaceInfo.containsKey(Long.valueOf(localFaceInfo.faceId)))
      {
        String str1 = localFaceInfo.faceId + "";
        String str2 = localFaceInfo.age + "";
        String str3 = localFaceInfo.gender + "";
        this.recordFaceInfo.put(localFaceInfo.faceId + "", new String[] { str1, str2, str3 });
      }
    }
    return this.recordFaceInfo;
  }
  
  public Set<Integer> getTriggeredExpression()
  {
    return new HashSet(this.mTriggeredExpressionType);
  }
  
  public int init()
  {
    if (this.mDetectorThreadHandler == null)
    {
      synchronized (mDetectLock)
      {
        if (this.mDetectorThreadHandler != null) {
          break label279;
        }
        Object localObject1 = PTFaceAttr.PTExpression.values();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          arrayOfPTExpression = localObject1[i];
          this.mFaceActionStatus.put(Integer.valueOf(arrayOfPTExpression.value), Boolean.valueOf(false));
          i += 1;
        }
        PTFaceAttr.PTExpression[] arrayOfPTExpression = PTFaceAttr.PTExpression.values();
        j = arrayOfPTExpression.length;
        i = 0;
        while (i < j)
        {
          localObject1 = arrayOfPTExpression[i];
          Map localMap = this.mFaceActionCounter;
          int k = ((PTFaceAttr.PTExpression)localObject1).value;
          if (((PTFaceAttr.PTExpression)localObject1).value != PTFaceAttr.PTExpression.MV_PART_INDEX.value)
          {
            localObject1 = new FaceActionCounter(0, -1L);
            localMap.put(Integer.valueOf(k), localObject1);
            i += 1;
          }
          else
          {
            localObject1 = new FabbyFaceActionCounter(0, -1L);
          }
        }
      }
      this.isFaceActionCounterInited = true;
      this.sensorManager = ((SensorManager)AEModule.getContext().getSystemService("sensor"));
      this.accelerometer = this.sensorManager.getDefaultSensor(1);
      this.sensorManager.registerListener(this.mSensorEventListener, this.accelerometer, 3);
      this.htName = (TAG + System.currentTimeMillis());
      this.mDetectorThreadHandler = new Handler(HandlerThreadManager.getInstance().getHandlerThread(this.htName).getLooper());
    }
    label279:
    return 0;
  }
  
  public void lockActionCounter()
  {
    this.mUpdateActionCounter = false;
  }
  
  public boolean needDetectFace(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.factor = 0L;
      if (this.mTrackFrameCount <= 7) {}
    }
    while (this.factor > 7L)
    {
      return true;
      return false;
    }
    this.factor += 1L;
    return true;
  }
  
  public boolean needDetectFace(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (this.detectStage == FaceDetector.DetectStage.DETECT_NO_FACE)
    {
      if (paramBoolean1)
      {
        this.detectStage = FaceDetector.DetectStage.DETECT_HAS_FACE;
        this.curDetectInterval = -1;
      }
      if (paramBoolean2) {
        break label198;
      }
      if (this.detectStage != FaceDetector.DetectStage.DETECT_HAS_FACE) {
        break label174;
      }
      if (this.mTrackFrameCount <= 7) {
        break label169;
      }
      paramBoolean1 = bool;
    }
    for (;;)
    {
      if (paramBoolean1) {
        this.lastFaceDetectTime = System.currentTimeMillis();
      }
      return paramBoolean1;
      if (this.detectStage == FaceDetector.DetectStage.DETECT_HAS_FACE)
      {
        if (paramBoolean1) {
          break;
        }
        this.detectStage = FaceDetector.DetectStage.DETECT_LOOKIN_FOR_FACE;
        this.startLostFaceTime = System.currentTimeMillis();
        this.curDetectInterval = 100;
        this.lastFaceDetectTime = 0L;
        break;
      }
      if (this.detectStage != FaceDetector.DetectStage.DETECT_LOOKIN_FOR_FACE) {
        break;
      }
      if (paramBoolean1)
      {
        this.detectStage = FaceDetector.DetectStage.DETECT_HAS_FACE;
        this.curDetectInterval = -1;
        break;
      }
      if (System.currentTimeMillis() - this.startLostFaceTime <= 100000L) {
        break;
      }
      this.detectStage = FaceDetector.DetectStage.DETECT_NO_FACE;
      this.curDetectInterval = 800;
      break;
      label169:
      paramBoolean1 = false;
      continue;
      label174:
      paramBoolean1 = bool;
      if (System.currentTimeMillis() - this.lastFaceDetectTime < this.curDetectInterval)
      {
        paramBoolean1 = false;
        continue;
        label198:
        paramBoolean1 = false;
      }
    }
  }
  
  public void postJob(Runnable paramRunnable)
  {
    if ((paramRunnable == null) || (this.mDetectorThreadHandler == null)) {
      return;
    }
    this.mDetectorThreadHandler.post(paramRunnable);
  }
  
  public void registerFaceDetectListener(FaceDetector.FaceDetectListener paramFaceDetectListener)
  {
    this.faceDetectListeners.add(paramFaceDetectListener);
  }
  
  public void removeFaceActionCallback(FaceActionCallback paramFaceActionCallback)
  {
    if (paramFaceActionCallback == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mFaceActionCallbacks.size())
      {
        Set localSet = (Set)this.mFaceActionCallbacks.valueAt(i);
        if (localSet != null) {
          localSet.remove(paramFaceActionCallback);
        }
        i += 1;
      }
    }
  }
  
  public void setDetectAge(boolean paramBoolean)
  {
    AgeDetector.getInstance().setNeedDetectAge(paramBoolean);
  }
  
  public void setDetectEmotion(boolean paramBoolean) {}
  
  public void setMaxFaceCount(int paramInt) {}
  
  public void unlockActionCounter()
  {
    this.mUpdateActionCounter = true;
  }
  
  public void unregisterFaceDetectListener(FaceDetector.FaceDetectListener paramFaceDetectListener)
  {
    this.faceDetectListeners.remove(paramFaceDetectListener);
  }
  
  protected void updateActionCount()
  {
    if (!this.mUpdateActionCounter) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      PTFaceAttr.PTExpression[] arrayOfPTExpression = PTFaceAttr.PTExpression.values();
      int j = arrayOfPTExpression.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfPTExpression[i];
        if (this.mTriggeredExpressionType.contains(Integer.valueOf(((PTFaceAttr.PTExpression)localObject).value)))
        {
          localObject = (FaceActionCounter)this.mFaceActionCounter.get(Integer.valueOf(((PTFaceAttr.PTExpression)localObject).value));
          if ((localObject != null) && (l - ((FaceActionCounter)localObject).updateTime > 1000L))
          {
            ((FaceActionCounter)localObject).count += 1;
            ((FaceActionCounter)localObject).updateTime = l;
          }
        }
        i += 1;
      }
    }
  }
  
  protected void updateActionStatusChanged()
  {
    int i = 0;
    while (i < this.mFaceActionCallbacks.size())
    {
      int j = this.mFaceActionCallbacks.keyAt(i);
      boolean bool1 = ((Boolean)this.mFaceActionStatus.get(Integer.valueOf(j))).booleanValue();
      boolean bool2 = detectExpression(j);
      if (bool1 != bool2)
      {
        Iterator localIterator = ((Set)this.mFaceActionCallbacks.valueAt(i)).iterator();
        while (localIterator.hasNext()) {
          ((FaceActionCallback)localIterator.next()).onActionDetected(j, bool2);
        }
      }
      this.mFaceActionStatus.put(Integer.valueOf(j), Boolean.valueOf(bool2));
      i += 1;
    }
  }
  
  public void updateAllFaceExpression(boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean)
    {
      this.expressions = new ArrayList();
      int i = 0;
      while (i < this.faceInfos.size())
      {
        this.expressions.add(new HashSet());
        i += 1;
      }
      PTFaceAttr.PTExpression[] arrayOfPTExpression = PTFaceAttr.PTExpression.values();
      int k = arrayOfPTExpression.length;
      i = j;
      while (i < k)
      {
        PTFaceAttr.PTExpression localPTExpression = arrayOfPTExpression[i];
        this.mExpressionDetectorObject.detectAllFaceExpression(this.expressions, localPTExpression.value);
        i += 1;
      }
    }
    if (this.clearFaceQueue) {
      this.mExpressionDetectorObject.clearFaceQueue();
    }
  }
  
  protected void updatePointsAndAngles(FaceStatus[] paramArrayOfFaceStatus)
  {
    int i = 0;
    try
    {
      this.faceInfos.clear();
      if (paramArrayOfFaceStatus == null) {
        return;
      }
      int j = paramArrayOfFaceStatus.length;
      while (i < j)
      {
        FaceStatus localFaceStatus = paramArrayOfFaceStatus[i];
        FaceInfo localFaceInfo = new FaceInfo();
        System.arraycopy(localFaceStatus.xys, 0, localFaceInfo.origFacePoints, 42, 134);
        System.arraycopy(localFaceStatus.xys, 134, localFaceInfo.origFacePoints, 0, 42);
        System.arraycopy(localFaceStatus.xys, 176, localFaceInfo.origFacePoints, 176, 12);
        System.arraycopy(localFaceStatus.pointVis, 0, localFaceInfo.origPointsVis, 0, localFaceStatus.pointVis.length);
        if (localFaceStatus.xys256 != null)
        {
          localFaceInfo.orig256FacePoints = new float[localFaceStatus.xys256.length];
          System.arraycopy(localFaceStatus.xys256, 0, localFaceInfo.orig256FacePoints, 0, localFaceInfo.orig256FacePoints.length);
        }
        localFaceInfo.points = YoutuPointsUtil.transformYTPointsToPtuPoints(localFaceStatus.xys);
        localFaceInfo.irisPoints = YoutuPointsUtil.getIrisPoints(localFaceStatus.xys);
        localFaceInfo.pointsVis = YoutuPointsUtil.transformYTPointsVisToPtuPoints(localFaceStatus.pointVis);
        localFaceInfo.pointsVis = YoutuPointsUtil.smoothYTPointsVisPoints(localFaceInfo.pointsVis);
        localFaceInfo.angles[0] = ((float)(localFaceStatus.pitch * 3.141592653589793D / 180.0D) * -1.0F);
        localFaceInfo.angles[1] = ((float)(localFaceStatus.yaw * 3.141592653589793D / 180.0D) * -1.0F);
        localFaceInfo.angles[2] = ((float)(localFaceStatus.roll * 3.141592653589793D / 180.0D) * -1.0F);
        localFaceInfo.rect = localFaceStatus.faceRect;
        localFaceInfo.scale = localFaceStatus.scale;
        localFaceInfo.pitch = localFaceStatus.pitch;
        localFaceInfo.yaw = localFaceStatus.yaw;
        localFaceInfo.roll = localFaceStatus.roll;
        localFaceInfo.tx = localFaceStatus.tx;
        localFaceInfo.ty = localFaceStatus.ty;
        localFaceInfo.denseFaceModel = localFaceStatus.denseFaceModel;
        localFaceInfo.transform = localFaceStatus.transform;
        localFaceInfo.expressionWeights = localFaceStatus.expressionWeights;
        localFaceInfo.gender = GenderType.DEFAULT.value;
        this.faceInfos.add(localFaceInfo);
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  protected void updateSmileEmotion() {}
  
  protected void updateTriggerExpression()
  {
    int i = 0;
    this.mTriggeredExpressionType.clear();
    this.clearFaceQueue = false;
    PTFaceAttr.PTExpression[] arrayOfPTExpression = PTFaceAttr.PTExpression.values();
    int j = arrayOfPTExpression.length;
    while (i < j)
    {
      PTFaceAttr.PTExpression localPTExpression = arrayOfPTExpression[i];
      if (this.mExpressionDetectorObject.detectExpression(localPTExpression.value))
      {
        this.mTriggeredExpressionType.add(Integer.valueOf(localPTExpression.value));
        if (ExpressionDetectorObject.needSaveDetectedExpression(localPTExpression.value)) {
          this.clearFaceQueue = true;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.facedetect.FaceDetector
 * JD-Core Version:    0.7.0.1
 */