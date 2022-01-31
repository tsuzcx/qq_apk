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
    long l1 = SystemClock.elapsedRealtime();
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
    long l2 = SystemClock.elapsedRealtime();
    paramArrayOfLong[paramInt2] = (l2 - l1);
    if (SLog.isEnable()) {
      SLog.d("GestureMgrRecognize|costtime", String.format("doProcess, mToken[%s], cost[%s], lastType[%s], srcSize[%s, %s], timeStamp[%s], RecognizeType[%s], vaild[%s], rcHot[%s], hotPoint{%s}", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2 - l1), paramString, Integer.valueOf(paramGestureData.dataWidth), Integer.valueOf(paramGestureData.dataHeight), Long.valueOf(localGestureKeyInfo.timeStamp), localGestureKeyInfo.type, Boolean.valueOf(localGestureKeyInfo.vaild), localGestureKeyInfo.hotArea, getPointInfo(localGestureKeyInfo.hotPoints) }));
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
    Object localObject;
    if (paramArrayOfPointF == null)
    {
      localObject = "null";
      return localObject;
    }
    String str = String.format("len[%s], ", new Object[] { Integer.valueOf(paramArrayOfPointF.length) });
    int k = paramArrayOfPointF.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (j >= k) {
        break;
      }
      localObject = paramArrayOfPointF[j];
      str = str + String.format("[%s,%s], ", new Object[] { Integer.valueOf(i), localObject });
      j += 1;
      i += 1;
    }
  }
  
  private static boolean innerLoadSo()
  {
    try
    {
      str = SdkContext.getInstance().getResources().getGestureResource().getSoPathDir();
      System.load(str + "libAVGesture4Android.so");
      bool = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        try
        {
          String str = SdkContext.getInstance().getResources().getGestureResource().getModelPath();
          AVGestureWrapper.setFilePath(str, str, "");
          AVGestureWrapper.setGlobalConfigFile(str);
          AVGestureWrapper.setAVGestureReport(new GestureMgrRecognize.1());
          AVGestureWrapper.setShouldUpload(SdkContext.getInstance().getResources().getGestureResource().getGestureShouldUpload());
          SLog.d("GestureMgrRecognize", String.format("loadSo suc, [%s]", new Object[] { AVGestureWrapper.getVersionInfo() }));
          return bool;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          boolean bool;
          SLog.e("GestureMgrRecognize", String.format("loadSo suc, but setCnnModelPath Exception[%s]", new Object[] { localUnsatisfiedLinkError2.getClass().getName() }), localUnsatisfiedLinkError2);
          return bool;
        }
        catch (Exception localException2)
        {
          SLog.e("GestureMgrRecognize", String.format("loadSo suc, but setCnnModelPath Exception[%s]", new Object[] { localException2.getClass().getName() }), localException2);
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        SLog.e("GestureMgrRecognize", String.format("System.load Exception[%s]", new Object[] { localUnsatisfiedLinkError1.getClass().getName() }), localUnsatisfiedLinkError1);
        bool = false;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        SLog.e("GestureMgrRecognize", String.format("System.load Exception[%s]", new Object[] { localException1.getClass().getName() }), localException1);
        bool = false;
      }
    }
    if (bool) {}
    return false;
  }
  
  static void mergeData(int paramInt, GestureMgrRecognize.GestureInfo paramGestureInfo, GestureKeyInfo paramGestureKeyInfo)
  {
    if (paramGestureKeyInfo.vaild) {
      if (!paramGestureKeyInfo.type.equals(paramGestureInfo.curType))
      {
        paramGestureInfo.curType = paramGestureKeyInfo.type;
        paramGestureInfo.hitCount = 1;
        if (!paramGestureKeyInfo.type.equals(paramGestureInfo.type)) {
          paramGestureInfo.missCount += 1;
        }
        label58:
        if (paramGestureInfo.hitCount < GestureTypeHitCount) {
          break label217;
        }
        paramGestureInfo.type = paramGestureInfo.curType;
        paramGestureInfo.missCount = 0;
        paramGestureInfo.vaild = true;
      }
    }
    for (;;)
    {
      if ((paramGestureKeyInfo.vaild) && (paramGestureKeyInfo.type.equals(paramGestureInfo.type))) {
        paramGestureKeyInfo.copyTo(paramGestureInfo);
      }
      if (SLog.isEnable()) {
        SLog.d("GestureMgrRecognize", String.format("mergeData, mToken[%s], vaild[%s], type[%s], missCount[%s], curType[%s], hitCount[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramGestureInfo.vaild), paramGestureInfo.type, Integer.valueOf(paramGestureInfo.missCount), paramGestureInfo.curType, Integer.valueOf(paramGestureInfo.hitCount) }));
      }
      return;
      paramGestureInfo.hitCount += 1;
      break;
      paramGestureInfo.missCount += 1;
      paramGestureInfo.hitCount = 0;
      break label58;
      label217:
      if (paramGestureInfo.missCount >= GestureTypeMissCount)
      {
        paramGestureInfo.type = null;
        paramGestureInfo.vaild = false;
      }
    }
  }
  
  public static void reportCost(long[] paramArrayOfLong, long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    long l2 = -1L;
    long l1 = 0L;
    long l3 = 0L;
    int i = 0;
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
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    Map.Entry localEntry;
    for (paramHashMap = ""; localIterator.hasNext(); paramHashMap = paramHashMap + "&" + (String)localEntry.getKey() + "=" + localEntry.getValue())
    {
      localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(localEntry.getKey(), String.valueOf(localEntry.getValue()));
    }
    SdkContext.getInstance().getReporter().reportToBeacon(ACT_QQAVGESTURE, true, -1L, -1L, localHashMap);
    SLog.d("GestureMgrRecognize", "reportGestrue|" + paramHashMap);
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
    }
    finally {}
    this.bSoLoaded = true;
    this.mSoLaodSuc = innerLoadSo();
    if (this.mSoLaodSuc) {
      setModelLoadStatus(1);
    }
    SLog.d("GestureMgrRecognize", String.format("loadSo, mSoLaodSuc[%s]", new Object[] { Boolean.valueOf(this.mSoLaodSuc) }));
    return true;
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
    }
    finally {}
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
  
  boolean pumpingframe()
  {
    if ((this.mRecognizeFrameRate != 0) && (this.mFrameRateCount <= this.mRecognizeFrameRate)) {
      this.mFrameRateCount += 1;
    }
    do
    {
      return false;
      if (this.mRecognizeMillis == 0L) {
        break;
      }
    } while (SystemClock.elapsedRealtime() < this.mLastTransferTime + this.mRecognizeMillis);
    this.mLastTransferTime = SystemClock.elapsedRealtime();
    this.mFrameRateCount = 0;
    return true;
  }
  
  public void setModelLoadStatus(int paramInt)
  {
    int i = this.mModelLoadStatus;
    if (i == paramInt) {
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 1: 
      this.bSoLoaded = false;
      return;
    }
    GestureDetectManager.getInstance().ResetModel();
  }
  
  public void setRecognizeFrameRate(int paramInt)
  {
    this.mRecognizeFrameRate = paramInt;
  }
  
  public void setRecognizeMillis(long paramLong)
  {
    this.mRecognizeMillis = paramLong;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 96	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mCurRecognizeRunnableToken	I
    //   6: ifne +76 -> 82
    //   9: aload_0
    //   10: invokestatic 486	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:genToken	()I
    //   13: putfield 96	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mCurRecognizeRunnableToken	I
    //   16: ldc 22
    //   18: ldc_w 488
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: getfield 96	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mCurRecognizeRunnableToken	I
    //   31: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokestatic 246	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   38: invokestatic 250	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: new 490	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable
    //   45: dup
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 96	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mCurRecognizeRunnableToken	I
    //   51: invokespecial 493	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:<init>	(Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;I)V
    //   54: putfield 98	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mRecognizeRunnable	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable;
    //   57: new 495	java/lang/Thread
    //   60: dup
    //   61: aload_0
    //   62: getfield 98	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mRecognizeRunnable	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable;
    //   65: invokespecial 498	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   68: astore_1
    //   69: aload_1
    //   70: bipush 10
    //   72: invokevirtual 501	java/lang/Thread:setPriority	(I)V
    //   75: aload_1
    //   76: invokevirtual 503	java/lang/Thread:start	()V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: ldc 22
    //   84: ldc_w 505
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_0
    //   94: getfield 96	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mCurRecognizeRunnableToken	I
    //   97: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: aastore
    //   101: invokestatic 246	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokestatic 250	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: goto -28 -> 79
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	GestureMgrRecognize
    //   68	8	1	localThread	java.lang.Thread
    //   110	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	79	110	finally
    //   82	107	110	finally
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
    if (!SdkContext.getInstance().getResources().getGestureResource().isGestureEnable()) {}
    while (!pumpingframe()) {
      return;
    }
    byte[] arrayOfByte = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramInt1, paramInt2, paramInt3);
    getInstance().transferRGBAbuffer(arrayOfByte, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void transferRGBAbuffer(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!SdkContext.getInstance().getResources().getGestureResource().isGestureEnable()) {}
    while (!pumpingframe()) {
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
    if (!this.mSoLaodSuc) {}
    while ((paramArrayOfByte == null) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    try
    {
      this.mGestureData = new GestureMgrRecognize.GestureData(this, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      SLog.e("GestureMgrRecognize", "transferRGBAbuffer occured OOM", paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      SLog.e("GestureMgrRecognize", String.format("transferRGBAbuffer occured exception[%s]", new Object[] { paramArrayOfByte.getClass().getName() }), paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize
 * JD-Core Version:    0.7.0.1
 */