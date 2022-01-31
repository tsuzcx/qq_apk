package com.tencent.ttpic.util.youtu;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.PointF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.initializer.GenderDetectorInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GenderDetector
{
  private static final String TAG = "GenderDetector";
  private static boolean isInitial = false;
  private static ThreadLocal<GenderDetector> sInstance;
  private final int DETECT_FRAME_NUMS = 10;
  private int DISTANCE_MAX_TWO_POINTS = 100;
  private final int SLEFT_EYE_INDEX = 43;
  private final int SRIGHT_EYE_INDEX = 53;
  private boolean isClear = false;
  private boolean isDetectorContinue = true;
  private boolean isReset = false;
  private GenderDetector.DetectGenderRunnable mDetectGenderRunnable;
  private Handler mDetectorGenderHandler;
  private HashMap<Integer, Long> mFaceCodeIDMap;
  private int mFaceCount = 0;
  private List<FaceInfo> mFaceInfos = new ArrayList();
  private HashMap<Long, Integer> mGenderDetectorCount;
  private int[] mGenderOld;
  private HashMap<Long, Integer> mGenderOldMap;
  private int[] mGenderSum;
  private HashMap<Long, Integer> mGenderSumMap;
  private int mInitCheckCount = 0;
  private boolean mIsDetectingGender = false;
  private boolean mNeedDetectGender = false;
  private List<GenderDetector.TraceFaceItem> mTraceFcaeList;
  private long sFaceIndexCount = 0L;
  
  private void addFaceEye2Detect(int paramInt, FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    if ((paramFaceInfo != null) && (paramFaceInfo.points != null) && (paramFaceInfo.points.size() > 0))
    {
      PointF localPointF1 = (PointF)paramFaceInfo.points.get(43);
      PointF localPointF2 = (PointF)paramFaceInfo.points.get(53);
      this.mDetectGenderRunnable.setEyeLocationByIndex(paramInt, (int)localPointF1.x, (int)localPointF1.y, (int)localPointF2.x, (int)localPointF2.y, paramBoolean, getFaceIDByFaceInfo(paramFaceInfo));
    }
  }
  
  public static boolean auth(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean) {
      paramBoolean = bool;
    }
    try
    {
      paramString = getInputStreamFromAssets(paramString);
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return paramBoolean;
    }
    paramBoolean = bool;
    paramString = new FileInputStream(paramString);
    while (paramString != null)
    {
      paramBoolean = bool;
      byte[] arrayOfByte = IOUtils.toByteArray(paramString);
      paramBoolean = bool;
      paramString.close();
      if (arrayOfByte == null) {
        break;
      }
      paramBoolean = bool;
      bool = xnetInitLicense(arrayOfByte);
      paramBoolean = bool;
      Log.e("GenderDetector", "buffer size: " + arrayOfByte.length);
      return bool;
    }
    return false;
  }
  
  private GenderDetector.TraceFaceItem creatTraceFaceItem(FaceInfo paramFaceInfo)
  {
    long l = this.sFaceIndexCount;
    this.sFaceIndexCount = (1L + l);
    return new GenderDetector.TraceFaceItem(this, l, paramFaceInfo);
  }
  
  private double distance2Lines(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null) || (paramPointF3 == null) || (paramPointF4 == null)) {
      return this.DISTANCE_MAX_TWO_POINTS;
    }
    return (distance2Points(paramPointF1, paramPointF3) + distance2Points(paramPointF2, paramPointF4)) / 2.0D;
  }
  
  private double distance2Points(PointF paramPointF1, PointF paramPointF2)
  {
    Log.i("GenderDetector", "DIS:(" + paramPointF1.x + "," + paramPointF1.y + ")->(" + paramPointF2.x + "," + paramPointF2.y + ")");
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
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
  
  private static InputStream getInputStreamFromAssets(String paramString)
  {
    AssetManager localAssetManager = AEModule.getContext().getAssets();
    try
    {
      paramString = localAssetManager.open(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      LogUtils.e("GenderDetector", paramString.getStackTrace().toString());
    }
    return null;
  }
  
  public static GenderDetector getInstance()
  {
    if (sInstance == null) {
      sInstance = new GenderDetector.1();
    }
    return (GenderDetector)sInstance.get();
  }
  
  private void initThreadHandle()
  {
    if (this.mDetectorGenderHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("GenderDetectThread");
      localHandlerThread.start();
      this.mDetectorGenderHandler = new Handler(localHandlerThread.getLooper());
    }
    this.mDetectorGenderHandler.post(new GenderDetector.2(this));
  }
  
  private boolean isOutImage(FaceInfo paramFaceInfo, int paramInt)
  {
    return (paramFaceInfo == null) || (((PointF)paramFaceInfo.points.get(43)).x < 5.0F) || (((PointF)paramFaceInfo.points.get(53)).x > paramInt - 5) || (((PointF)paramFaceInfo.points.get(43)).y < 5.0F) || (((PointF)paramFaceInfo.points.get(53)).y < 5.0F) || (paramFaceInfo.angles[0] < -0.75D);
  }
  
  private void realDectect(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    this.mIsDetectingGender = true;
    if (this.mDetectorGenderHandler == null) {
      initThreadHandle();
    }
    if (this.mDetectGenderRunnable == null) {
      this.mDetectGenderRunnable = new GenderDetector.DetectGenderRunnable(this, null);
    }
    this.mDetectGenderRunnable.setData(paramArrayOfByte);
    this.mDetectGenderRunnable.setImgWH(paramInt1, paramInt2);
    paramInt2 = 0;
    boolean bool1 = false;
    if (paramInt2 < paramList.size())
    {
      paramArrayOfByte = (FaceInfo)paramList.get(paramInt2);
      paramArrayOfByte.gender = GenderType.DEFAULT.value;
      boolean bool3 = isOutImage(paramArrayOfByte, paramInt1);
      long l = getFaceIDByFaceInfo(paramArrayOfByte);
      int i;
      if ((this.mGenderDetectorCount != null) && (this.mGenderDetectorCount.get(Long.valueOf(l)) != null))
      {
        i = ((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue();
        label148:
        bool2 = bool1;
        if (i < 10)
        {
          if (!bool3)
          {
            if (this.mGenderDetectorCount != null) {
              this.mGenderDetectorCount.put(Long.valueOf(l), Integer.valueOf(i + 1));
            }
            bool1 = true;
          }
          if (bool3) {
            break label231;
          }
        }
      }
      label231:
      for (boolean bool2 = true;; bool2 = false)
      {
        addFaceEye2Detect(paramInt2, paramArrayOfByte, bool2);
        bool2 = bool1;
        paramInt2 += 1;
        bool1 = bool2;
        break;
        i = 0;
        break label148;
      }
    }
    this.mIsDetectingGender = bool1;
    if (bool1)
    {
      this.mDetectorGenderHandler.removeCallbacks(this.mDetectGenderRunnable);
      this.mDetectorGenderHandler.post(this.mDetectGenderRunnable);
    }
  }
  
  private void resetTraceFaceItems()
  {
    if (this.mFaceCodeIDMap != null) {
      this.mFaceCodeIDMap.clear();
    }
    if (this.mTraceFcaeList != null) {
      this.mTraceFcaeList.clear();
    }
  }
  
  private void touchGendersByFaceIDS()
  {
    if (this.mFaceCount <= 0) {}
    Object localObject2;
    HashMap localHashMap;
    do
    {
      return;
      localObject2 = null;
      localHashMap = null;
      if (!this.isDetectorContinue) {
        break;
      }
      localObject2 = GenderDetector.DetectGenderRunnable.access$100(this.mDetectGenderRunnable);
    } while (localObject2 == null);
    Iterator localIterator = this.mFaceInfos.iterator();
    FaceInfo localFaceInfo;
    long l;
    do
    {
      localObject1 = localHashMap;
      if (!localIterator.hasNext()) {
        break;
      }
      localFaceInfo = (FaceInfo)localIterator.next();
      l = getFaceIDByFaceInfo(localFaceInfo);
    } while (l < 0L);
    if (this.mGenderSumMap == null) {
      this.mGenderSumMap = new HashMap();
    }
    Object localObject1 = (GenderDetector.GenderParams)((Map)localObject2).get(Long.valueOf(l));
    label145:
    int i;
    label196:
    label218:
    int j;
    if (localObject1 == null)
    {
      localObject1 = new GenderDetector.GenderParams(this);
      ((GenderDetector.GenderParams)localObject1).genderType = GenderType.DEFAULT.value;
      if ((localObject1 == null) || (this.mGenderDetectorCount.get(Long.valueOf(l)) == null)) {
        break label321;
      }
      if (!this.mGenderSumMap.containsKey(Long.valueOf(l))) {
        break label368;
      }
      i = ((Integer)this.mGenderSumMap.get(Long.valueOf(l))).intValue();
      if (i < 0) {
        break label376;
      }
      if (((GenderDetector.GenderParams)localObject1).genderType <= 0) {
        break label373;
      }
      i += ((GenderDetector.GenderParams)localObject1).genderType - 1;
      if (i >= 0) {
        break label409;
      }
      j = GenderType.DEFAULT.value;
      label229:
      localFaceInfo.gender = j;
      this.mGenderSumMap.put(Long.valueOf(l), Integer.valueOf(i));
      if (localHashMap != null) {
        break label680;
      }
      localHashMap = new HashMap();
    }
    label409:
    label677:
    label680:
    for (;;)
    {
      localHashMap.put(Long.valueOf(l), Integer.valueOf(localFaceInfo.gender));
      break;
      if (((GenderDetector.GenderParams)localObject1).genderType == GenderType.DEFAULT.value)
      {
        if (this.mGenderOldMap != null) {
          break label323;
        }
        i = GenderType.DEFAULT.value;
      }
      for (;;)
      {
        ((GenderDetector.GenderParams)localObject1).genderType = i;
        break label145;
        label321:
        break;
        label323:
        if (this.mGenderOldMap.containsKey(Long.valueOf(l))) {
          i = ((Integer)this.mGenderOldMap.get(Long.valueOf(l))).intValue();
        } else {
          i = GenderType.DEFAULT.value;
        }
      }
      label368:
      i = -1;
      break label196;
      label373:
      break label218;
      label376:
      i = ((GenderDetector.GenderParams)localObject1).genderType;
      i = (((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue() + 1) * (i - 1);
      break label218;
      if (i > ((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue() / 2)
      {
        j = GenderType.MALE.value;
        break label229;
      }
      j = GenderType.FEMALE.value;
      break label229;
      localObject1 = localObject2;
      if (this.mGenderSumMap != null)
      {
        localObject1 = localObject2;
        if (this.mGenderSumMap.size() > 0)
        {
          localObject1 = this.mFaceInfos.iterator();
          localHashMap = null;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FaceInfo)((Iterator)localObject1).next();
            l = getFaceIDByFaceInfo((FaceInfo)localObject2);
            if (this.mGenderSumMap.containsKey(Long.valueOf(l)))
            {
              i = ((Integer)this.mGenderSumMap.get(Long.valueOf(l))).intValue();
              label552:
              if (i >= 0) {
                break label609;
              }
              i = GenderType.DEFAULT.value;
              label563:
              ((FaceInfo)localObject2).gender = i;
              if (localHashMap != null) {
                break label677;
              }
              localHashMap = new HashMap();
            }
          }
        }
      }
      for (;;)
      {
        localHashMap.put(Long.valueOf(l), Integer.valueOf(((FaceInfo)localObject2).gender));
        break;
        i = -1;
        break label552;
        label609:
        if (i > ((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue() / 2)
        {
          i = GenderType.MALE.value;
          break label563;
        }
        i = GenderType.FEMALE.value;
        break label563;
        localObject1 = localHashMap;
        if (this.mGenderOldMap != null) {
          this.mGenderOldMap.clear();
        }
        this.mGenderOldMap = ((HashMap)localObject1);
        return;
      }
    }
  }
  
  public static native boolean xnetInit(String paramString);
  
  public static native boolean xnetInitLicense(byte[] paramArrayOfByte);
  
  public void destroy()
  {
    if (this.mDetectorGenderHandler != null)
    {
      this.mDetectorGenderHandler.getLooper().quit();
      this.mDetectorGenderHandler = null;
    }
    if (this.mDetectGenderRunnable != null) {
      this.mDetectGenderRunnable.clear();
    }
    sInstance = null;
    this.mIsDetectingGender = false;
    this.mGenderSum = null;
    this.mGenderOld = null;
    if (this.mGenderSumMap != null) {
      this.mGenderSumMap.clear();
    }
    if (this.mGenderOldMap != null) {
      this.mGenderOldMap.clear();
    }
    if (this.mGenderDetectorCount != null) {
      this.mGenderDetectorCount.clear();
    }
  }
  
  public native int detectGender(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public void detectGender(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    this.mFaceInfos = paramList;
    if (!isInitial)
    {
      if (this.mInitCheckCount % 30 == 0) {
        initThreadHandle();
      }
      this.mInitCheckCount += 1;
      return;
    }
    this.DISTANCE_MAX_TWO_POINTS = (paramInt1 * 3 / 4);
    if (!this.mNeedDetectGender)
    {
      this.mGenderDetectorCount = null;
      this.mGenderSum = null;
      this.mGenderOld = null;
      if (this.mGenderSumMap != null) {
        this.mGenderSumMap.clear();
      }
      if (this.mGenderOldMap != null) {
        this.mGenderOldMap.clear();
      }
      if (this.mDetectorGenderHandler != null) {
        this.mDetectorGenderHandler.removeCallbacks(this.mDetectGenderRunnable);
      }
      if (this.mDetectGenderRunnable != null) {
        this.mDetectGenderRunnable.reset();
      }
      this.mFaceCount = 0;
      return;
    }
    if ((paramList != null) && (paramList.size() != this.mFaceCount))
    {
      if (this.mGenderDetectorCount == null) {
        this.mGenderDetectorCount = new HashMap();
      }
      this.mGenderDetectorCount.clear();
      this.isDetectorContinue = true;
      this.mFaceCount = paramList.size();
      this.mGenderSum = new int[this.mFaceCount];
      if (this.mGenderSumMap == null) {
        this.mGenderSumMap = new HashMap();
      }
      this.mGenderSumMap.clear();
    }
    if ((paramArrayOfByte == null) || (paramList == null) || (paramList.size() <= 0))
    {
      reset();
      return;
    }
    this.isDetectorContinue = false;
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        long l = getFaceIDByFaceInfo((FaceInfo)paramList.get(i));
        if ((this.mGenderDetectorCount == null) || (this.mGenderDetectorCount.size() == 0) || (this.mGenderDetectorCount.get(Long.valueOf(l)) == null) || (((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue() < 10)) {
          this.isDetectorContinue = true;
        }
      }
      else
      {
        if ((!this.isDetectorContinue) || (this.mFaceCount <= 0)) {
          break;
        }
        realDectect(paramArrayOfByte, paramInt1, paramInt2, paramList);
        return;
      }
      i += 1;
    }
  }
  
  public void detectGenderAndUpdateFaceInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    detectGender(paramArrayOfByte, paramInt1, paramInt2, paramList);
    getGender();
  }
  
  public List<FaceInfo> getGender()
  {
    if ((!isInitial) || (this.mDetectGenderRunnable == null) || (this.mFaceInfos == null) || (this.mFaceInfos.size() < 1)) {
      return this.mFaceInfos;
    }
    touchGendersByFaceIDS();
    return this.mFaceInfos;
  }
  
  public void init()
  {
    if ((isInitial) || (!FeatureManager.Features.GENDER_DETECTOR.init()))
    {
      Log.e("GenderDetector", "GenderDetector not need init:!" + isInitial + ",ready:" + FeatureManager.Features.GENDER_DETECTOR.isFunctionReady());
      return;
    }
    isInitial = FeatureManager.Features.GENDER_DETECTOR.init();
    if (!isInitial)
    {
      LogUtils.e("GenderDetector", "GenderDetector init is failed!");
      Log.e("GenderDetector", "GenderDetector init is failed!");
      return;
    }
    LogUtils.e("GenderDetector", "GenderDetector init is successful!");
    Log.i("GenderDetector", "GenderDetector init is successful!");
  }
  
  public boolean isDetectGender()
  {
    return this.mNeedDetectGender;
  }
  
  public void reset()
  {
    this.mGenderOld = null;
    if (this.mGenderOldMap != null) {
      this.mGenderOldMap.clear();
    }
    if (this.mGenderDetectorCount != null) {
      this.mGenderDetectorCount.clear();
    }
    if (this.mDetectorGenderHandler != null) {
      this.mDetectorGenderHandler.removeCallbacks(this.mDetectGenderRunnable);
    }
    if (this.mDetectGenderRunnable != null) {
      this.mDetectGenderRunnable.reset();
    }
    resetTraceFaceItems();
  }
  
  public void setNeedDetectGender(boolean paramBoolean)
  {
    this.mNeedDetectGender = paramBoolean;
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
        ((GenderDetector.TraceFaceItem)this.mTraceFcaeList.get(i)).updatePoints((FaceInfo)paramList.get(i));
        i += 1;
      }
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    label208:
    FaceInfo localFaceInfo;
    if (k > j)
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      Log.i("GenderDetector", "人脸变少了：mTraceFcaeList=" + this.mTraceFcaeList.size() + "-->Faces=" + paramList.size());
      Iterator localIterator1 = paramList.iterator();
      if (localIterator1.hasNext())
      {
        localFaceInfo = (FaceInfo)localIterator1.next();
        double d1 = this.DISTANCE_MAX_TWO_POINTS;
        Iterator localIterator2 = this.mTraceFcaeList.iterator();
        paramList = null;
        label249:
        while (localIterator2.hasNext())
        {
          GenderDetector.TraceFaceItem localTraceFaceItem = (GenderDetector.TraceFaceItem)localIterator2.next();
          if (!localArrayList2.contains(localTraceFaceItem))
          {
            double d2 = localTraceFaceItem.distanceTwoFaces(localFaceInfo);
            if (d2 >= d1) {
              break label472;
            }
            d1 = d2;
            paramList = localTraceFaceItem;
          }
        }
      }
    }
    label393:
    label444:
    label472:
    for (;;)
    {
      break label249;
      if (paramList != null)
      {
        paramList.updatePoints(localFaceInfo);
        localArrayList1.add(paramList);
        localArrayList2.add(paramList);
        Log.i("GenderDetector", "匹配上一帧人脸，ID：" + GenderDetector.TraceFaceItem.access$900(paramList));
        break label208;
      }
      Log.i("GenderDetector", "人脸丢失，ID");
      break label208;
      this.mTraceFcaeList.clear();
      this.mTraceFcaeList = localArrayList1;
      return;
      i = 0;
      if (i < j)
      {
        if (i >= k) {
          break label444;
        }
        ((GenderDetector.TraceFaceItem)this.mTraceFcaeList.get(i)).updatePoints((FaceInfo)paramList.get(i));
      }
      for (;;)
      {
        i += 1;
        break label393;
        break;
        this.mTraceFcaeList.add(creatTraceFaceItem((FaceInfo)paramList.get(i)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.GenderDetector
 * JD-Core Version:    0.7.0.1
 */