package com.tencent.ttpic.openapi.util;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.AgeType;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.initializer.AgeDetectorInitailizer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AgeDetector
{
  public static final AgeDetector.AgeRang[] AGE_RANGS = { new AgeDetector.AgeRang(0, 5), new AgeDetector.AgeRang(6, 15), new AgeDetector.AgeRang(16, 35), new AgeDetector.AgeRang(36, 1000) };
  private static final String TAG = "AgeDetector";
  private static boolean isInitial = false;
  private static ThreadLocal<AgeDetector> sInstance;
  private final int DETECT_FRAME_NUMS = 5;
  private int DISTANCE_MAX_TWO_POINTS = 100;
  private final int LEFT_MOUTH_INDEX = 65;
  private final int NOSE_INDEX = 64;
  private final int RIGHT_MOUTH_INDEX = 66;
  private final int SLEFT_EYE_INDEX = 43;
  private final int SRIGHT_EYE_INDEX = 53;
  private Bitmap bitmap = null;
  private boolean isClear = false;
  private boolean isDetectorContinue = true;
  private boolean isReset = false;
  private AgeDetector.DetectAgeRunnable mDetectAgeRunnable;
  private Handler mDetectorAgeHandler;
  private int mFaceCount = 0;
  private List<FaceInfo> mFaceInfos = new ArrayList();
  private int mInitCheckCount = 0;
  private boolean mIsDetectingAge = false;
  private boolean mNeedDetectAge = false;
  private boolean mSyncDetectAge = false;
  
  private void addFaceKeyPoint2Detect(int paramInt, FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    if ((paramFaceInfo != null) && (paramFaceInfo.points != null) && (paramFaceInfo.points.size() > 0))
    {
      int i = (int)((PointF)paramFaceInfo.points.get(43)).x;
      int j = (int)((PointF)paramFaceInfo.points.get(43)).y;
      int k = (int)((PointF)paramFaceInfo.points.get(53)).x;
      int m = (int)((PointF)paramFaceInfo.points.get(53)).y;
      int n = (int)((PointF)paramFaceInfo.points.get(64)).x;
      int i1 = (int)((PointF)paramFaceInfo.points.get(64)).y;
      int i2 = (int)((PointF)paramFaceInfo.points.get(65)).x;
      int i3 = (int)((PointF)paramFaceInfo.points.get(65)).y;
      int i4 = (int)((PointF)paramFaceInfo.points.get(66)).x;
      int i5 = (int)((PointF)paramFaceInfo.points.get(66)).y;
      this.mDetectAgeRunnable.setKeyPointLocationByIndex(paramInt, i, j, k, m, n, i1, i2, i3, i4, i5, paramBoolean, paramFaceInfo.faceId);
    }
  }
  
  public static AgeDetector getInstance()
  {
    if (sInstance == null) {
      sInstance = new AgeDetector.1();
    }
    return (AgeDetector)sInstance.get();
  }
  
  public static int getRangeIndex(int paramInt)
  {
    int i = 0;
    AgeDetector.AgeRang[] arrayOfAgeRang;
    for (;;)
    {
      arrayOfAgeRang = AGE_RANGS;
      if (i >= arrayOfAgeRang.length) {
        break;
      }
      if (arrayOfAgeRang[i].isMatch(paramInt)) {
        return i;
      }
      i += 1;
    }
    return arrayOfAgeRang.length - 1;
  }
  
  private void initThreadHandle()
  {
    if (this.mDetectorAgeHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("AgeDetectThread");
      localHandlerThread.start();
      this.mDetectorAgeHandler = new Handler(localHandlerThread.getLooper());
    }
    this.mDetectorAgeHandler.post(new AgeDetector.2(this));
  }
  
  private boolean isOutImage(FaceInfo paramFaceInfo, int paramInt)
  {
    boolean bool = false;
    if ((paramFaceInfo == null) || (((PointF)paramFaceInfo.points.get(43)).x < 5.0F) || (((PointF)paramFaceInfo.points.get(53)).x > paramInt - 5) || (((PointF)paramFaceInfo.points.get(43)).y < 5.0F) || (((PointF)paramFaceInfo.points.get(53)).y < 5.0F) || (paramFaceInfo.angles[0] < -0.75D)) {
      bool = true;
    }
    return bool;
  }
  
  private void realDectect(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    updateDetectStatus(true);
    if (this.mDetectorAgeHandler == null) {
      initThreadHandle();
    }
    if (this.mDetectAgeRunnable == null) {
      this.mDetectAgeRunnable = new AgeDetector.DetectAgeRunnable(this, null);
    }
    this.mDetectAgeRunnable.setData(paramArrayOfByte);
    this.mDetectAgeRunnable.setImgWH(paramInt1, paramInt2);
    paramInt2 = 0;
    boolean bool1 = false;
    while (paramInt2 < paramList.size())
    {
      paramArrayOfByte = (FaceInfo)paramList.get(paramInt2);
      paramArrayOfByte.age = AgeType.DEFAULT.value;
      boolean bool2 = isOutImage(paramArrayOfByte, paramInt1);
      if (!bool2) {
        bool1 = true;
      }
      addFaceKeyPoint2Detect(paramInt2, paramArrayOfByte, bool2 ^ true);
      paramInt2 += 1;
    }
    updateDetectStatus(bool1);
    if (bool1)
    {
      this.mDetectorAgeHandler.removeCallbacks(this.mDetectAgeRunnable);
      this.mDetectorAgeHandler.post(this.mDetectAgeRunnable);
    }
  }
  
  public void destroy()
  {
    Object localObject = this.mDetectorAgeHandler;
    if (localObject != null)
    {
      ((Handler)localObject).getLooper().quit();
      this.mDetectorAgeHandler = null;
    }
    localObject = this.mDetectAgeRunnable;
    if (localObject != null) {
      ((AgeDetector.DetectAgeRunnable)localObject).clear();
    }
    sInstance = null;
    updateDetectStatus(false);
  }
  
  public void detectAge(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    this.mFaceInfos = paramList;
    if (!isInitial) {
      if (this.mSyncDetectAge)
      {
        if (this.mDetectorAgeHandler == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("AgeDetectThread");
          localHandlerThread.start();
          this.mDetectorAgeHandler = new Handler(localHandlerThread.getLooper());
        }
        getInstance().init();
      }
      else
      {
        if (this.mInitCheckCount % 30 == 0) {
          initThreadHandle();
        }
        this.mInitCheckCount += 1;
        return;
      }
    }
    this.DISTANCE_MAX_TWO_POINTS = (paramInt1 * 3 / 4);
    if (!this.mNeedDetectAge)
    {
      paramArrayOfByte = this.mDetectorAgeHandler;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.removeCallbacks(this.mDetectAgeRunnable);
      }
      paramArrayOfByte = this.mDetectAgeRunnable;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.reset();
      }
      this.mFaceCount = 0;
      return;
    }
    if ((paramList != null) && (paramList.size() != this.mFaceCount)) {
      this.mFaceCount = paramList.size();
    }
    if ((paramArrayOfByte != null) && (paramList != null) && (paramList.size() > 0))
    {
      if ((!this.mIsDetectingAge) && (this.mFaceCount > 0)) {
        realDectect(paramArrayOfByte, paramInt1, paramInt2, paramList);
      }
      return;
    }
    reset();
  }
  
  public void detectAgeAndUpdateFaceInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    detectAge(paramArrayOfByte, paramInt1, paramInt2, paramList);
    getAge();
  }
  
  public List<FaceInfo> getAge()
  {
    if ((isInitial) && (this.mDetectAgeRunnable != null))
    {
      List localList = this.mFaceInfos;
      if ((localList != null) && (localList.size() >= 1))
      {
        if (this.mSyncDetectAge) {
          try
          {
            for (;;)
            {
              boolean bool = this.mIsDetectingAge;
              if (!bool) {
                break;
              }
              try
              {
                wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Log.e("AgeDetector", localInterruptedException.getMessage());
              }
            }
          }
          finally {}
        }
        Iterator localIterator = this.mFaceInfos.iterator();
        while (localIterator.hasNext())
        {
          FaceInfo localFaceInfo = (FaceInfo)localIterator.next();
          if (localFaceInfo != null) {
            localFaceInfo.age = this.mDetectAgeRunnable.getAgeByFaceID(localFaceInfo.faceId);
          }
        }
        return this.mFaceInfos;
      }
    }
    return this.mFaceInfos;
  }
  
  public void init()
  {
    if ((!isInitial) && (FeatureManager.Features.AGE_DETECT.init()))
    {
      LogUtils.i("AgeDetector", "AgeDetector has inited.");
      isInitial = true;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AgeDetector not need init:!");
    localStringBuilder.append(isInitial);
    localStringBuilder.append(",ready:");
    localStringBuilder.append(FeatureManager.Features.AGE_DETECT.isFunctionReady());
    LogUtils.e("AgeDetector", localStringBuilder.toString());
  }
  
  public boolean isDetectAge()
  {
    return this.mNeedDetectAge;
  }
  
  public void reset()
  {
    Object localObject = this.mDetectorAgeHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.mDetectAgeRunnable);
    }
    localObject = this.mDetectAgeRunnable;
    if (localObject != null) {
      ((AgeDetector.DetectAgeRunnable)localObject).reset();
    }
  }
  
  public void setNeedDetectAge(boolean paramBoolean)
  {
    this.mNeedDetectAge = paramBoolean;
  }
  
  public void setSyncDetectAge(boolean paramBoolean)
  {
    this.mSyncDetectAge = paramBoolean;
  }
  
  public void updateDetectStatus(boolean paramBoolean)
  {
    try
    {
      this.mIsDetectingAge = paramBoolean;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.AgeDetector
 * JD-Core Version:    0.7.0.1
 */