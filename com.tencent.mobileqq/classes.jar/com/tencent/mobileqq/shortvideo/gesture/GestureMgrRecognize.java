package com.tencent.mobileqq.shortvideo.gesture;

import aigk;
import aigl;
import aigm;
import aign;
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
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class GestureMgrRecognize
{
  private static GestureMgrRecognize jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize;
  public static final Object a;
  static String jdField_a_of_type_JavaLangString;
  static int jdField_b_of_type_Int;
  static String jdField_b_of_type_JavaLangString = "actQQAVGesture";
  static int f;
  static int g;
  int jdField_a_of_type_Int = 5;
  public long a;
  public aigl a;
  public aigm a;
  aign jdField_a_of_type_Aign = null;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 200L;
  boolean jdField_b_of_type_Boolean = true;
  public int c;
  long c;
  volatile int d = 0;
  int e = 0;
  
  static
  {
    jdField_a_of_type_JavaLangObject = "GestureLock";
    jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize = new GestureMgrRecognize();
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "actAVGestureRecognizeTime";
    f = 1;
    g = 2;
  }
  
  private GestureMgrRecognize()
  {
    this.jdField_a_of_type_Aigm = new aigm(this);
    this.jdField_a_of_type_Long = 20L;
    this.jdField_a_of_type_Aigl = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
  }
  
  static int a()
  {
    int i = jdField_b_of_type_Int + 1;
    jdField_b_of_type_Int = i;
    return i;
  }
  
  public static GestureKeyInfo a(int paramInt1, aigl paramaigl, String paramString, long[] paramArrayOfLong, int paramInt2)
  {
    GestureKeyInfo localGestureKeyInfo = new GestureKeyInfo();
    long l1 = SystemClock.elapsedRealtime();
    AVGestureWrapper localAVGestureWrapper = new AVGestureWrapper();
    if (localAVGestureWrapper.doCalc(paramaigl.jdField_a_of_type_ArrayOfByte, paramaigl.jdField_a_of_type_Int, paramaigl.jdField_b_of_type_Int, 0, 0, true))
    {
      localGestureKeyInfo.jdField_a_of_type_JavaLangString = localAVGestureWrapper.getGestureType();
      localGestureKeyInfo.jdField_a_of_type_Boolean = true;
      localGestureKeyInfo.jdField_a_of_type_AndroidGraphicsRectF = localAVGestureWrapper.getHotRegionInOriginImg();
      localGestureKeyInfo.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = localAVGestureWrapper.getKeyPoints();
      localGestureKeyInfo.jdField_a_of_type_Long = System.currentTimeMillis();
      float f1 = paramaigl.d / paramaigl.jdField_b_of_type_Int;
      float f2 = paramaigl.jdField_c_of_type_Int / paramaigl.jdField_a_of_type_Int;
      localGestureKeyInfo.jdField_a_of_type_AndroidGraphicsRectF.top *= f1;
      localGestureKeyInfo.jdField_a_of_type_AndroidGraphicsRectF.bottom *= f1;
      localGestureKeyInfo.jdField_a_of_type_AndroidGraphicsRectF.left *= f2;
      localGestureKeyInfo.jdField_a_of_type_AndroidGraphicsRectF.right *= f2;
      PointF[] arrayOfPointF = localGestureKeyInfo.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
      int j = arrayOfPointF.length;
      int i = 0;
      while (i < j)
      {
        PointF localPointF = arrayOfPointF[i];
        localPointF.x *= f2;
        localPointF.y *= f1;
        i += 1;
      }
      localGestureKeyInfo.jdField_b_of_type_Int = paramaigl.jdField_b_of_type_Int;
      localGestureKeyInfo.jdField_a_of_type_Int = paramaigl.jdField_a_of_type_Int;
      localGestureKeyInfo.jdField_c_of_type_Int = paramaigl.jdField_c_of_type_Int;
      localGestureKeyInfo.d = paramaigl.d;
    }
    localAVGestureWrapper.destroyRecognizor();
    long l2 = SystemClock.elapsedRealtime();
    paramArrayOfLong[paramInt2] = (l2 - l1);
    if (SLog.a()) {
      SLog.d("GestureMgrRecognize|costtime", String.format("doProcess, mToken[%s], cost[%s], lastType[%s], srcSize[%s, %s], timeStamp[%s], RecognizeType[%s], vaild[%s], rcHot[%s], hotPoint{%s}", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2 - l1), paramString, Integer.valueOf(paramaigl.jdField_a_of_type_Int), Integer.valueOf(paramaigl.jdField_b_of_type_Int), Long.valueOf(localGestureKeyInfo.jdField_a_of_type_Long), localGestureKeyInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(localGestureKeyInfo.jdField_a_of_type_Boolean), localGestureKeyInfo.jdField_a_of_type_AndroidGraphicsRectF, a(localGestureKeyInfo.jdField_a_of_type_ArrayOfAndroidGraphicsPointF) }));
    }
    return localGestureKeyInfo;
  }
  
  public static GestureMgrRecognize a()
  {
    return jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize;
  }
  
  static String a(PointF[] paramArrayOfPointF)
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
  
  public static void a(int paramInt, aigm paramaigm, GestureKeyInfo paramGestureKeyInfo)
  {
    if (paramGestureKeyInfo.jdField_a_of_type_Boolean) {
      if (!paramGestureKeyInfo.jdField_a_of_type_JavaLangString.equals(paramaigm.jdField_b_of_type_JavaLangString))
      {
        paramaigm.jdField_b_of_type_JavaLangString = paramGestureKeyInfo.jdField_a_of_type_JavaLangString;
        paramaigm.e = 1;
        if (!paramGestureKeyInfo.jdField_a_of_type_JavaLangString.equals(paramaigm.jdField_a_of_type_JavaLangString)) {
          paramaigm.f += 1;
        }
        label58:
        if (paramaigm.e < f) {
          break label216;
        }
        paramaigm.jdField_a_of_type_JavaLangString = paramaigm.jdField_b_of_type_JavaLangString;
        paramaigm.f = 0;
        paramaigm.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      if ((paramGestureKeyInfo.jdField_a_of_type_Boolean) && (paramGestureKeyInfo.jdField_a_of_type_JavaLangString.equals(paramaigm.jdField_a_of_type_JavaLangString))) {
        paramGestureKeyInfo.a(paramaigm);
      }
      if (SLog.a()) {
        SLog.d("GestureMgrRecognize", String.format("mergeData, mToken[%s], vaild[%s], type[%s], missCount[%s], curType[%s], hitCount[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramaigm.jdField_a_of_type_Boolean), paramaigm.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaigm.f), paramaigm.jdField_b_of_type_JavaLangString, Integer.valueOf(paramaigm.e) }));
      }
      return;
      paramaigm.e += 1;
      break;
      paramaigm.f += 1;
      paramaigm.e = 0;
      break label58;
      label216:
      if (paramaigm.f >= g)
      {
        paramaigm.jdField_a_of_type_JavaLangString = null;
        paramaigm.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void a(HashMap paramHashMap)
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
    SdkContext.a().a().a(jdField_b_of_type_JavaLangString, true, -1L, -1L, localHashMap);
    SLog.d("GestureMgrRecognize", "reportGestrue|" + paramHashMap);
  }
  
  public static void a(long[] paramArrayOfLong, long paramLong)
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
    SdkContext.a().a().a(jdField_a_of_type_JavaLangString, true, -1L, -1L, paramArrayOfLong);
  }
  
  private static boolean c()
  {
    try
    {
      str = SdkContext.a().a().a().c();
      System.load(str + "libAVGesture4Android.so");
      bool = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        try
        {
          String str = SdkContext.a().a().a().d();
          AVGestureWrapper.setFilePath(str, str, "");
          AVGestureWrapper.setGlobalConfigFile(str);
          AVGestureWrapper.setAVGestureReport(new aigk());
          AVGestureWrapper.setShouldUpload(SdkContext.a().a().a().a());
          SLog.d("GestureMgrRecognize", String.format("loadSo suc, [%s]", new Object[] { AVGestureWrapper.getVersionInfo() }));
          return bool;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          boolean bool;
          SLog.a("GestureMgrRecognize", String.format("loadSo suc, but setCnnModelPath Exception[%s]", new Object[] { localUnsatisfiedLinkError2.getClass().getName() }), localUnsatisfiedLinkError2);
          return bool;
        }
        catch (Exception localException2)
        {
          SLog.a("GestureMgrRecognize", String.format("loadSo suc, but setCnnModelPath Exception[%s]", new Object[] { localException2.getClass().getName() }), localException2);
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        SLog.a("GestureMgrRecognize", String.format("System.load Exception[%s]", new Object[] { localUnsatisfiedLinkError1.getClass().getName() }), localUnsatisfiedLinkError1);
        bool = false;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        SLog.a("GestureMgrRecognize", String.format("System.load Exception[%s]", new Object[] { localException1.getClass().getName() }), localException1);
        bool = false;
      }
    }
    if (bool) {}
    return false;
  }
  
  public GestureKeyInfo a()
  {
    GestureKeyInfo localGestureKeyInfo = new GestureKeyInfo();
    this.jdField_a_of_type_Aigm.a(localGestureKeyInfo);
    return localGestureKeyInfo;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:jdField_c_of_type_Int	I
    //   6: ifne +76 -> 82
    //   9: aload_0
    //   10: invokestatic 392	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:a	()I
    //   13: putfield 72	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:jdField_c_of_type_Int	I
    //   16: ldc 232
    //   18: ldc_w 394
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: getfield 72	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:jdField_c_of_type_Int	I
    //   31: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokestatic 197	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   38: invokestatic 200	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: new 396	aign
    //   45: dup
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 72	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:jdField_c_of_type_Int	I
    //   51: invokespecial 399	aign:<init>	(Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;I)V
    //   54: putfield 74	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:jdField_a_of_type_Aign	Laign;
    //   57: new 401	java/lang/Thread
    //   60: dup
    //   61: aload_0
    //   62: getfield 74	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:jdField_a_of_type_Aign	Laign;
    //   65: invokespecial 404	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   68: astore_1
    //   69: aload_1
    //   70: bipush 10
    //   72: invokevirtual 408	java/lang/Thread:setPriority	(I)V
    //   75: aload_1
    //   76: invokevirtual 411	java/lang/Thread:start	()V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: ldc 232
    //   84: ldc_w 413
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_0
    //   94: getfield 72	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:jdField_c_of_type_Int	I
    //   97: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: aastore
    //   101: invokestatic 197	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokestatic 200	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public void a(int paramInt)
  {
    int i = this.d;
    if (i == paramInt) {
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    GestureDetectManager.a().a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!SdkContext.a().a().a().b()) {}
    while (!b()) {
      return;
    }
    byte[] arrayOfByte = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramInt1, paramInt2, paramInt3);
    a().a(arrayOfByte, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!SdkContext.a().a().a().b()) {}
    while (!b()) {
      return;
    }
    if (paramArrayOfByte == null)
    {
      a(RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramInt1, paramInt2, paramInt3), paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
    a(paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while ((paramArrayOfByte == null) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Aigl = new aigl(this, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      SLog.a("GestureMgrRecognize", "transferRGBAbuffer occured OOM", paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      SLog.a("GestureMgrRecognize", String.format("transferRGBAbuffer occured exception[%s]", new Object[] { paramArrayOfByte.getClass().getName() }), paramArrayOfByte);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_b_of_type_Boolean;
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        boolean bool = this.jdField_b_of_type_Boolean;
        return bool;
      }
    }
    finally {}
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = c();
    if (this.jdField_b_of_type_Boolean) {
      a(1);
    }
    SLog.d("GestureMgrRecognize", String.format("loadSo, mSoLaodSuc[%s]", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    return true;
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Aigm.a();
      this.jdField_a_of_type_Aigl = null;
      if (this.jdField_c_of_type_Int != 0)
      {
        SLog.d("GestureMgrRecognize", String.format("stop, curToken[%s]", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) }));
        this.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Aign = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  boolean b()
  {
    if ((this.jdField_a_of_type_Int != 0) && (this.e <= this.jdField_a_of_type_Int)) {
      this.e += 1;
    }
    do
    {
      return false;
      if (this.jdField_b_of_type_Long == 0L) {
        break;
      }
    } while (SystemClock.elapsedRealtime() < this.jdField_c_of_type_Long + this.jdField_b_of_type_Long);
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    this.e = 0;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize
 * JD-Core Version:    0.7.0.1
 */