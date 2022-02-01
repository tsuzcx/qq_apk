package com.tencent.mobileqq.shortvideo.gesture;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.SystemClock;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.Reporter;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class GestureMgrRecognize
{
  static String ACT_QQAVGESTURE = "actQQAVGesture";
  public static final int GAME_MODEL_LOAD = 2;
  public static final int GESTURE_MODEL_LOAD = 1;
  static final String GestureSoName = "libAVGesture4Android.so";
  static int GestureTypeHitCount = 0;
  static int GestureTypeMissCount = 0;
  static String Gesture_Recognize_Time;
  public static final int NONE_MODEL_LOAD = 0;
  private static final String TAG = "GestureMgrRecognize";
  private static GestureMgrRecognize instance;
  public static final Object mGestureLock = "GestureLock";
  static int s_token;
  boolean bSoLoaded = false;
  int mCurRecognizeRunnableToken = 0;
  int mFrameRateCount = 0;
  GestureMgrRecognize.GestureData mGestureData = null;
  GestureMgrRecognize.GestureInfo mGestureInfo = new GestureMgrRecognize.GestureInfo(this);
  long mLastTransferTime = 0L;
  volatile int mModelLoadStatus = 0;
  int mRecognizeFrameRate = 5;
  long mRecognizeMillis = 200L;
  GestureMgrRecognize.RecognizeRunnable mRecognizeRunnable = null;
  long mRecognizeRunnableSleepMillis = 20L;
  boolean mSoLaodSuc = true;
  
  static
  {
    instance = new GestureMgrRecognize();
    s_token = 1;
    Gesture_Recognize_Time = "actAVGestureRecognizeTime";
    GestureTypeHitCount = 1;
    GestureTypeMissCount = 2;
  }
  
  static GestureKeyInfo doProcess(int paramInt1, GestureMgrRecognize.GestureData paramGestureData, String paramString, long[] paramArrayOfLong, int paramInt2)
  {
    GestureKeyInfo localGestureKeyInfo = new GestureKeyInfo();
    long l = SystemClock.elapsedRealtime();
    AVGestureWrapper localAVGestureWrapper = new AVGestureWrapper();
    if (localAVGestureWrapper.doCalc(paramGestureData.dataRGBA, paramGestureData.dataWidth, paramGestureData.dataHeight, 0, 0, true))
    {
      localGestureKeyInfo.type = localAVGestureWrapper.getGestureType();
      localGestureKeyInfo.vaild = true;
      localGestureKeyInfo.hotArea = localAVGestureWrapper.getHotRegionInOriginImg();
      localGestureKeyInfo.hotPoints = localAVGestureWrapper.getKeyPoints();
      localGestureKeyInfo.timeStamp = System.currentTimeMillis();
      float f1 = paramGestureData.originHeight / paramGestureData.dataHeight;
      float f2 = paramGestureData.originWidth / paramGestureData.dataWidth;
      localGestureKeyInfo.hotArea.top *= f1;
      localGestureKeyInfo.hotArea.bottom *= f1;
      localGestureKeyInfo.hotArea.left *= f2;
      localGestureKeyInfo.hotArea.right *= f2;
      PointF[] arrayOfPointF = localGestureKeyInfo.hotPoints;
      int j = arrayOfPointF.length;
      int i = 0;
      while (i < j)
      {
        PointF localPointF = arrayOfPointF[i];
        localPointF.x *= f2;
        localPointF.y *= f1;
        i += 1;
      }
      localGestureKeyInfo.dataHeight = paramGestureData.dataHeight;
      localGestureKeyInfo.dataWidth = paramGestureData.dataWidth;
      localGestureKeyInfo.originWidth = paramGestureData.originWidth;
      localGestureKeyInfo.originHeight = paramGestureData.originHeight;
    }
    localAVGestureWrapper.destroyRecognizor();
    l = SystemClock.elapsedRealtime() - l;
    paramArrayOfLong[paramInt2] = l;
    if (SLog.isEnable()) {
      SLog.d("GestureMgrRecognize|costtime", String.format("doProcess, mToken[%s], cost[%s], lastType[%s], srcSize[%s, %s], timeStamp[%s], RecognizeType[%s], vaild[%s], rcHot[%s], hotPoint{%s}", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l), paramString, Integer.valueOf(paramGestureData.dataWidth), Integer.valueOf(paramGestureData.dataHeight), Long.valueOf(localGestureKeyInfo.timeStamp), localGestureKeyInfo.type, Boolean.valueOf(localGestureKeyInfo.vaild), localGestureKeyInfo.hotArea, getPointInfo(localGestureKeyInfo.hotPoints) }));
    }
    return localGestureKeyInfo;
  }
  
  static int genToken()
  {
    int i = s_token + 1;
    s_token = i;
    return i;
  }
  
  public static GestureMgrRecognize getInstance()
  {
    return instance;
  }
  
  static String getPointInfo(PointF[] paramArrayOfPointF)
  {
    if (paramArrayOfPointF == null) {
      return "null";
    }
    String str = String.format("len[%s], ", new Object[] { Integer.valueOf(paramArrayOfPointF.length) });
    int k = paramArrayOfPointF.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      PointF localPointF = paramArrayOfPointF[j];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format("[%s,%s], ", new Object[] { Integer.valueOf(i), localPointF }));
      str = localStringBuilder.toString();
      j += 1;
      i += 1;
    }
    return str;
  }
  
  private static boolean innerLoadSo()
  {
    try
    {
      String str1 = SdkContext.getInstance().getResources().getGestureResource().getSoPathDir();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append("libAVGesture4Android.so");
      System.load(localStringBuilder.toString());
      bool = true;
    }
    catch (Exception localException1)
    {
      SLog.e("GestureMgrRecognize", String.format("System.load Exception[%s]", new Object[] { localException1.getClass().getName() }), localException1);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      SLog.e("GestureMgrRecognize", String.format("System.load Exception[%s]", new Object[] { localUnsatisfiedLinkError1.getClass().getName() }), localUnsatisfiedLinkError1);
    }
    boolean bool = false;
    if (bool) {
      try
      {
        String str2 = SdkContext.getInstance().getResources().getGestureResource().getModelPath();
        AVGestureWrapper.setFilePath(str2, str2, "");
        AVGestureWrapper.setGlobalConfigFile(str2);
        AVGestureWrapper.setAVGestureReport(new GestureMgrRecognize.1());
        AVGestureWrapper.setShouldUpload(SdkContext.getInstance().getResources().getGestureResource().getGestureShouldUpload());
        SLog.d("GestureMgrRecognize", String.format("loadSo suc, [%s]", new Object[] { AVGestureWrapper.getVersionInfo() }));
        return bool;
      }
      catch (Exception localException2)
      {
        SLog.e("GestureMgrRecognize", String.format("loadSo suc, but setCnnModelPath Exception[%s]", new Object[] { localException2.getClass().getName() }), localException2);
        return false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        SLog.e("GestureMgrRecognize", String.format("loadSo suc, but setCnnModelPath Exception[%s]", new Object[] { localUnsatisfiedLinkError2.getClass().getName() }), localUnsatisfiedLinkError2);
      }
    }
    return bool;
  }
  
  static void mergeData(int paramInt, GestureMgrRecognize.GestureInfo paramGestureInfo, GestureKeyInfo paramGestureKeyInfo)
  {
    if (paramGestureKeyInfo.vaild)
    {
      if (!paramGestureKeyInfo.type.equals(paramGestureInfo.curType))
      {
        paramGestureInfo.curType = paramGestureKeyInfo.type;
        paramGestureInfo.hitCount = 1;
      }
      else
      {
        paramGestureInfo.hitCount += 1;
      }
      if (!paramGestureKeyInfo.type.equals(paramGestureInfo.type)) {
        paramGestureInfo.missCount += 1;
      }
    }
    else
    {
      paramGestureInfo.missCount += 1;
      paramGestureInfo.hitCount = 0;
    }
    if (paramGestureInfo.hitCount >= GestureTypeHitCount)
    {
      paramGestureInfo.type = paramGestureInfo.curType;
      paramGestureInfo.missCount = 0;
      paramGestureInfo.vaild = true;
    }
    else if (paramGestureInfo.missCount >= GestureTypeMissCount)
    {
      paramGestureInfo.type = null;
      paramGestureInfo.vaild = false;
    }
    if ((paramGestureKeyInfo.vaild) && (paramGestureKeyInfo.type.equals(paramGestureInfo.type))) {
      paramGestureKeyInfo.copyTo(paramGestureInfo);
    }
    if (SLog.isEnable()) {
      SLog.d("GestureMgrRecognize", String.format("mergeData, mToken[%s], vaild[%s], type[%s], missCount[%s], curType[%s], hitCount[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramGestureInfo.vaild), paramGestureInfo.type, Integer.valueOf(paramGestureInfo.missCount), paramGestureInfo.curType, Integer.valueOf(paramGestureInfo.hitCount) }));
    }
  }
  
  public static void reportCost(long[] paramArrayOfLong, long paramLong)
  {
    long l3 = 0L;
    if (paramLong == 0L) {
      return;
    }
    long l2 = -1L;
    int i = 0;
    long l1 = 0L;
    while (i < paramLong)
    {
      long l4 = paramArrayOfLong[i];
      l2 = Math.min(l2, l4);
      l1 = Math.max(l1, l4);
      l3 += l4;
      i += 1;
    }
    l3 /= paramLong;
    paramArrayOfLong = new HashMap();
    paramArrayOfLong.put("min", String.valueOf(l2));
    paramArrayOfLong.put("max", String.valueOf(l1));
    paramArrayOfLong.put("avg", String.valueOf(l3));
    paramArrayOfLong.put("count", String.valueOf(paramLong));
    SdkContext.getInstance().getReporter().reportToBeacon(Gesture_Recognize_Time, true, -1L, -1L, paramArrayOfLong);
  }
  
  private void reportGestrue(HashMap<String, Integer> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.isEmpty()) {
        return;
      }
      Object localObject = new HashMap();
      Iterator localIterator = paramHashMap.entrySet().iterator();
      StringBuilder localStringBuilder;
      for (paramHashMap = ""; localIterator.hasNext(); paramHashMap = localStringBuilder.toString())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((HashMap)localObject).put(localEntry.getKey(), String.valueOf(localEntry.getValue()));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramHashMap);
        localStringBuilder.append("&");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append(localEntry.getValue());
      }
      SdkContext.getInstance().getReporter().reportToBeacon(ACT_QQAVGESTURE, true, -1L, -1L, (HashMap)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportGestrue|");
      ((StringBuilder)localObject).append(paramHashMap);
      SLog.d("GestureMgrRecognize", ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean checkIsLoadSo()
  {
    return this.bSoLoaded;
  }
  
  public GestureKeyInfo getGestureInfo()
  {
    GestureKeyInfo localGestureKeyInfo = new GestureKeyInfo();
    this.mGestureInfo.copyTo(localGestureKeyInfo);
    return localGestureKeyInfo;
  }
  
  public int getModelLoadStatus()
  {
    return this.mModelLoadStatus;
  }
  
  public boolean loadSo()
  {
    if (this.bSoLoaded) {
      return this.mSoLaodSuc;
    }
    try
    {
      if (this.bSoLoaded)
      {
        boolean bool = this.mSoLaodSuc;
        return bool;
      }
      this.bSoLoaded = true;
      this.mSoLaodSuc = innerLoadSo();
      if (this.mSoLaodSuc) {
        setModelLoadStatus(1);
      }
      SLog.d("GestureMgrRecognize", String.format("loadSo, mSoLaodSuc[%s]", new Object[] { Boolean.valueOf(this.mSoLaodSuc) }));
      return true;
    }
    finally {}
  }
  
  boolean preLoadSo()
  {
    if (this.bSoLoaded) {
      return this.mSoLaodSuc;
    }
    try
    {
      if (this.bSoLoaded)
      {
        bool = this.mSoLaodSuc;
        return bool;
      }
      boolean bool = innerLoadSo();
      if (bool)
      {
        this.bSoLoaded = true;
        this.mSoLaodSuc = true;
        setModelLoadStatus(1);
      }
      SLog.d("GestureMgrRecognize", String.format("preLoadSo, loadSuc[%s]", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
    finally {}
  }
  
  boolean pumpingframe()
  {
    int i = this.mRecognizeFrameRate;
    if (i != 0)
    {
      int j = this.mFrameRateCount;
      if (j <= i)
      {
        this.mFrameRateCount = (j + 1);
        return false;
      }
    }
    if (this.mRecognizeMillis != 0L)
    {
      if (SystemClock.elapsedRealtime() < this.mLastTransferTime + this.mRecognizeMillis) {
        return false;
      }
      this.mLastTransferTime = SystemClock.elapsedRealtime();
    }
    this.mFrameRateCount = 0;
    return true;
  }
  
  public void setModelLoadStatus(int paramInt)
  {
    int i = this.mModelLoadStatus;
    if (i == paramInt) {
      return;
    }
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      GestureDetectManager.getInstance().ResetModel();
      return;
    }
    this.bSoLoaded = false;
  }
  
  public void setRecognizeFrameRate(int paramInt)
  {
    this.mRecognizeFrameRate = paramInt;
  }
  
  public void setRecognizeMillis(long paramLong)
  {
    this.mRecognizeMillis = paramLong;
  }
  
  public void start()
  {
    try
    {
      if (this.mCurRecognizeRunnableToken == 0)
      {
        this.mCurRecognizeRunnableToken = genToken();
        SLog.d("GestureMgrRecognize", String.format("start, runnable create, curToken[%s]", new Object[] { Integer.valueOf(this.mCurRecognizeRunnableToken) }));
        this.mRecognizeRunnable = new GestureMgrRecognize.RecognizeRunnable(this, this.mCurRecognizeRunnableToken);
        Thread localThread = new Thread(this.mRecognizeRunnable);
        localThread.setPriority(10);
        localThread.start();
      }
      else
      {
        SLog.d("GestureMgrRecognize", String.format("start, runnable exist, curToken[%s]", new Object[] { Integer.valueOf(this.mCurRecognizeRunnableToken) }));
      }
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      this.mGestureInfo.reset();
      this.mGestureData = null;
      if (this.mCurRecognizeRunnableToken != 0)
      {
        SLog.d("GestureMgrRecognize", String.format("stop, curToken[%s]", new Object[] { Integer.valueOf(this.mCurRecognizeRunnableToken) }));
        this.mCurRecognizeRunnableToken = 0;
        this.mRecognizeRunnable = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void transferRGBAbuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!SdkContext.getInstance().getResources().getGestureResource().isGestureEnable()) {
      return;
    }
    if (!pumpingframe()) {
      return;
    }
    byte[] arrayOfByte = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramInt1, paramInt2, paramInt3);
    getInstance().transferRGBAbuffer(arrayOfByte, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void transferRGBAbuffer(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!SdkContext.getInstance().getResources().getGestureResource().isGestureEnable()) {
      return;
    }
    if (!pumpingframe()) {
      return;
    }
    if (paramArrayOfByte == null)
    {
      transferRGBAbuffer(RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramInt1, paramInt2, paramInt3), paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
    transferRGBAbuffer(paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  void transferRGBAbuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mSoLaodSuc) {
      return;
    }
    if ((paramArrayOfByte != null) && (paramInt1 != 0))
    {
      if (paramInt2 == 0) {
        return;
      }
      try
      {
        this.mGestureData = new GestureMgrRecognize.GestureData(this, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        SLog.e("GestureMgrRecognize", String.format("transferRGBAbuffer occured exception[%s]", new Object[] { paramArrayOfByte.getClass().getName() }), paramArrayOfByte);
        return;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        SLog.e("GestureMgrRecognize", "transferRGBAbuffer occured OOM", paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize
 * JD-Core Version:    0.7.0.1
 */