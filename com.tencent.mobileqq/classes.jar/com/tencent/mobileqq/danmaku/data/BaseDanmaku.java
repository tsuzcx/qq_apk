package com.tencent.mobileqq.danmaku.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.CallSuper;
import com.tencent.mobileqq.danmaku.DanmakuDependImp;
import com.tencent.mobileqq.danmaku.IDanmakuDepend;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.IDanmakuUIConfig;
import com.tencent.mobileqq.danmaku.inject.WindowConfig;
import com.tencent.mobileqq.danmaku.tool.ClickResult;
import com.tencent.mobileqq.danmaku.tool.Duration;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import com.tencent.mobileqq.danmaku.util.Logger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseDanmaku<DATA, CONFIG extends IDanmakuUIConfig>
{
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  protected float a;
  protected final int a;
  protected long a;
  protected Bitmap a;
  protected Canvas a;
  protected BaseDanmaku.IHitLeftSideListener a;
  protected DanmakuContext a;
  protected CONFIG a;
  protected Duration a;
  private DATA jdField_a_of_type_JavaLangObject;
  private HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap;
  protected final PriorityQueue<BaseDanmaku.TimePassedData> a;
  protected boolean a;
  protected float b;
  protected int b;
  protected long b;
  protected boolean b;
  protected float c;
  protected int c;
  protected boolean c;
  private float d;
  protected int d;
  protected boolean d;
  private float jdField_e_of_type_Float = -1.0F;
  protected int e;
  private volatile boolean jdField_e_of_type_Boolean = true;
  protected int f;
  private volatile boolean f;
  protected int g;
  
  public BaseDanmaku(DanmakuContext paramDanmakuContext)
  {
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_f_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Float = -1.0F;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext = paramDanmakuContext;
    this.jdField_a_of_type_JavaUtilPriorityQueue = new PriorityQueue();
    j();
    e();
  }
  
  private void j()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuUIConfig = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a(a());
      return;
    }
    catch (Exception localException)
    {
      if (!DanmakuDependImp.a().a().a()) {
        return;
      }
      throw new RuntimeException("IDanmakuUIConfig should been provided by IDanmakuUIConfigCreator in DanmakuContext", localException);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilPriorityQueue.clear();
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_e_of_type_Int = 0;
    this.g = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_d_of_type_Float = -1.0F;
    this.jdField_e_of_type_Float = -1.0F;
    this.jdField_c_of_type_Boolean = false;
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof BaseDanmaku.IRecyclableExtraObject)) {
          ((BaseDanmaku.IRecyclableExtraObject)localObject2).a();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  public float a()
  {
    return this.jdField_e_of_type_Float;
  }
  
  public abstract int a();
  
  public int a(int paramInt)
  {
    int j = this.g;
    int i = j;
    if (j > paramInt) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDuration.a();
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Canvas a()
  {
    return this.jdField_a_of_type_AndroidGraphicsCanvas;
  }
  
  public CONFIG a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuUIConfig;
  }
  
  public ClickResult a(TouchPoint paramTouchPoint)
  {
    return new ClickResult(-1);
  }
  
  public DATA a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a()
  {
    a(new Duration(DanmakuContext.a().d()));
    b();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
  }
  
  public abstract void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2);
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public abstract void a(long paramLong);
  
  public final void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Long += paramLong1;
    }
    a(paramLong2);
    if (!this.jdField_a_of_type_JavaUtilPriorityQueue.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilPriorityQueue.iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku.TimePassedData localTimePassedData = (BaseDanmaku.TimePassedData)localIterator.next();
        localTimePassedData.jdField_a_of_type_Long -= paramLong1;
        if (localTimePassedData.jdField_a_of_type_Long <= 0L)
        {
          localIterator.remove();
          localTimePassedData.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku$ITimePassedListener.a(this);
        }
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas = paramCanvas;
    c(true);
  }
  
  public void a(Duration paramDuration)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDuration = paramDuration;
  }
  
  public void a(DATA paramDATA)
  {
    if ((DanmakuDependImp.a().a().a()) && (paramDATA == null)) {
      throw new RuntimeException("Danmaku data should been null");
    }
    this.jdField_a_of_type_JavaLangObject = paramDATA;
    c(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_Int = 1;
      return;
    }
    this.jdField_d_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    float[] arrayOfFloat = b(paramLong);
    boolean bool2 = false;
    if (arrayOfFloat == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (arrayOfFloat[0] <= paramFloat1)
    {
      bool1 = bool2;
      if (paramFloat1 <= arrayOfFloat[2] + paramFloat3)
      {
        bool1 = bool2;
        if (arrayOfFloat[1] <= paramFloat2)
        {
          bool1 = bool2;
          if (paramFloat2 <= arrayOfFloat[3]) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt)
  {
    if ((!h()) && (this.jdField_e_of_type_Int - paramInt < 0)) {
      return false;
    }
    this.jdField_e_of_type_Int -= paramInt;
    this.jdField_a_of_type_Long += paramInt;
    return true;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = this.jdField_c_of_type_Boolean;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramLong - this.jdField_b_of_type_Long >= this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDuration.a()) {
      bool1 = true;
    }
    return bool1;
  }
  
  public abstract float[] a(long paramLong);
  
  public float b()
  {
    return this.jdField_d_of_type_Float;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int b(int paramInt)
  {
    int j = this.jdField_f_of_type_Int;
    int i = j;
    if (j >= paramInt) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long + a();
  }
  
  protected void b() {}
  
  public void b(float paramFloat)
  {
    this.jdField_d_of_type_Float = paramFloat;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Float >= 0.0F) && (this.jdField_b_of_type_Float >= 0.0F) && (!g());
  }
  
  public boolean b(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    return (l > 0L) && (paramLong - l >= this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDuration.a());
  }
  
  public abstract float[] b(long paramLong);
  
  public abstract float c();
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDuration.a(paramFloat);
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Int == 1;
  }
  
  public boolean c(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    return (l > 0L) && (paramLong - l < 0L);
  }
  
  public abstract float d();
  
  public int d()
  {
    return DanmakuContext.a().c();
  }
  
  public long d()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return DanmakuContext.a().b();
  }
  
  public abstract float e();
  
  public int e()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long e()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @CallSuper
  public void e()
  {
    WindowConfig localWindowConfig = DanmakuContext.a();
    f(localWindowConfig.a());
    b(localWindowConfig.c());
    k();
    a();
  }
  
  public void e(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Boolean) && (WindowConfig.a());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (BaseDanmaku)paramObject;
      Object localObject = this.jdField_a_of_type_JavaLangObject;
      if (localObject != null) {
        return localObject.equals(paramObject.jdField_a_of_type_JavaLangObject);
      }
      return paramObject.jdField_a_of_type_JavaLangObject == null;
    }
    return false;
  }
  
  public abstract float f();
  
  public int f()
  {
    return DanmakuContext.a().e();
  }
  
  public void f()
  {
    float f1 = d();
    if ((!this.jdField_d_of_type_Boolean) && (f1 < f()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFirstExposure, danmaku = ");
      ((StringBuilder)localObject).append(toString());
      Logger.c("BaseDanmaku", ((StringBuilder)localObject).toString());
      i();
      this.jdField_d_of_type_Boolean = true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku$IHitLeftSideListener;
    if ((localObject != null) && (f1 <= 0.0F))
    {
      ((BaseDanmaku.IHitLeftSideListener)localObject).a(this);
      this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku$IHitLeftSideListener = null;
    }
  }
  
  public void f(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public boolean f()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public abstract float g();
  
  public int g()
  {
    return DanmakuContext.a().f();
  }
  
  @CallSuper
  public void g()
  {
    d(false);
  }
  
  public boolean g()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public float h()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(null);
  }
  
  public boolean h()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int hashCode()
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public float i()
  {
    return this.jdField_b_of_type_Float;
  }
  
  protected void i()
  {
    DanmakuContext localDanmakuContext = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext;
    if (localDanmakuContext != null) {
      localDanmakuContext.a(this);
    }
  }
  
  public float j()
  {
    return d() + DanmakuContext.a().g();
  }
  
  public float k()
  {
    return e() + d();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseDanmaku");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("[left:");
    localStringBuilder.append(d());
    localStringBuilder.append(",top:");
    localStringBuilder.append(e());
    localStringBuilder.append(",right:");
    localStringBuilder.append(f());
    localStringBuilder.append(",bottom:");
    localStringBuilder.append(g());
    localStringBuilder.append(", time:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", mData=");
    localStringBuilder.append(String.valueOf(this.jdField_a_of_type_JavaLangObject));
    localStringBuilder.append(", mType=");
    localStringBuilder.append(a());
    localStringBuilder.append(", playerTime=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.data.BaseDanmaku
 * JD-Core Version:    0.7.0.1
 */