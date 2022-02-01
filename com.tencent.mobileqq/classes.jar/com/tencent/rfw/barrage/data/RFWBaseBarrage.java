package com.tencent.rfw.barrage.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.rfw.barrage.inject.IRFWBarrageUIConfig;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import com.tencent.rfw.barrage.tool.RFWClickResult;
import com.tencent.rfw.barrage.tool.RFWDuration;
import com.tencent.rfw.barrage.tool.RFWTouchPoint;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import com.tencent.rfw.barrage.util.RFWQQUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class RFWBaseBarrage<DATA, CONFIG extends IRFWBarrageUIConfig>
{
  private static final AtomicInteger y = new AtomicInteger();
  private float A = -1.0F;
  private volatile boolean B = true;
  private volatile boolean C = true;
  private DATA D;
  private HashMap<String, Object> E;
  protected RFWBarrageContext a;
  protected final int b = y.incrementAndGet();
  protected long c;
  protected RFWDuration d;
  protected long e;
  protected final PriorityQueue<RFWBaseBarrage.TimePassedData> f;
  protected int g;
  protected int h;
  protected float i = -1.0F;
  protected float j = -1.0F;
  protected float k;
  protected int l;
  protected boolean m;
  protected boolean n;
  protected Bitmap o;
  protected Canvas p;
  protected int q;
  protected int r = -1;
  protected int s;
  protected boolean t;
  protected boolean u;
  protected boolean v = false;
  protected RFWBaseBarrage.OnLeftBarrageListener w;
  protected CONFIG x;
  private float z = -1.0F;
  
  public RFWBaseBarrage(RFWBarrageContext paramRFWBarrageContext)
  {
    this.a = paramRFWBarrageContext;
    this.f = new PriorityQueue();
    S();
    h();
  }
  
  private void S()
  {
    try
    {
      this.x = this.a.a(q());
      return;
    }
    catch (Exception localException)
    {
      if (!RFWQQUtils.b()) {
        return;
      }
      throw new RuntimeException("IDanmakuUIConfig should been provided by IDanmakuUIConfigCreator in DanmakuContext", localException);
    }
  }
  
  private void T()
  {
    this.f.clear();
    this.g = 0;
    this.h = 0;
    this.i = -1.0F;
    this.j = -1.0F;
    this.l = 0;
    this.o = null;
    this.q = 0;
    this.s = 0;
    this.t = false;
    this.v = false;
    this.B = true;
    this.C = true;
    this.z = -1.0F;
    this.A = -1.0F;
    this.u = false;
    Object localObject1 = this.E;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RFWBaseBarrage.IRecyclableExtraObject)) {
          ((RFWBaseBarrage.IRecyclableExtraObject)localObject2).a();
        }
      }
      this.E.clear();
      this.E = null;
    }
  }
  
  public float A()
  {
    return this.i;
  }
  
  public float B()
  {
    return this.j;
  }
  
  public int C()
  {
    return RFWBarrageContext.a().d();
  }
  
  public int D()
  {
    return this.q;
  }
  
  public boolean E()
  {
    return RFWBarrageContext.a().f();
  }
  
  public float F()
  {
    return s() + RFWBarrageContext.a().l();
  }
  
  public float G()
  {
    return t() + C();
  }
  
  public int H()
  {
    return RFWBarrageContext.a().j();
  }
  
  public int I()
  {
    return RFWBarrageContext.a().k();
  }
  
  public boolean J()
  {
    return (this.n) && (RFWWindowConfig.a());
  }
  
  public Bitmap K()
  {
    return this.o;
  }
  
  public boolean L()
  {
    return this.C;
  }
  
  public boolean M()
  {
    return this.B;
  }
  
  public Canvas N()
  {
    return this.p;
  }
  
  public void O()
  {
    this.p.setBitmap(null);
  }
  
  public boolean P()
  {
    return this.u;
  }
  
  public long Q()
  {
    return this.c;
  }
  
  protected void R()
  {
    RFWBarrageContext localRFWBarrageContext = this.a;
    if (localRFWBarrageContext != null) {
      localRFWBarrageContext.b(this);
    }
  }
  
  public RFWClickResult a(RFWTouchPoint paramRFWTouchPoint)
  {
    return new RFWClickResult(-1);
  }
  
  public void a()
  {
    a(new RFWDuration(RFWBarrageContext.a().e()));
    b();
  }
  
  public void a(float paramFloat)
  {
    this.A = paramFloat;
  }
  
  public abstract void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2);
  
  public final void a(long paramLong1, long paramLong2)
  {
    if (this.t) {
      this.c += paramLong1;
    }
    d(paramLong2);
    if (!this.f.isEmpty())
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        RFWBaseBarrage.TimePassedData localTimePassedData = (RFWBaseBarrage.TimePassedData)localIterator.next();
        if (localTimePassedData != null)
        {
          localTimePassedData.a -= paramLong1;
          if (localTimePassedData.a <= 0L)
          {
            localIterator.remove();
            localTimePassedData.b.a(this);
          }
        }
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.o = paramBitmap;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.p = paramCanvas;
    d(true);
  }
  
  public void a(RFWBaseBarrage.OnLeftBarrageListener paramOnLeftBarrageListener)
  {
    this.w = paramOnLeftBarrageListener;
  }
  
  public void a(RFWDuration paramRFWDuration)
  {
    this.d = paramRFWDuration;
  }
  
  public void a(DATA paramDATA)
  {
    if ((RFWQQUtils.b()) && (paramDATA == null)) {
      throw new RuntimeException("Danmaku data should been null");
    }
    this.D = paramDATA;
    d(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    float[] arrayOfFloat = f(paramLong);
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
    if ((!P()) && (this.q - paramInt < 0)) {
      return false;
    }
    this.q -= paramInt;
    this.c += paramInt;
    return true;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = this.u;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramLong - this.e >= this.d.a()) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int b(int paramInt)
  {
    int i2 = this.s;
    int i1 = i2;
    if (i2 > paramInt) {
      i1 = paramInt - 1;
    }
    return i1;
  }
  
  protected void b() {}
  
  public void b(float paramFloat)
  {
    this.z = paramFloat;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l = 1;
      return;
    }
    this.l = 0;
  }
  
  public boolean b(long paramLong)
  {
    long l1 = this.c;
    return (l1 > 0L) && (paramLong - l1 >= this.d.a());
  }
  
  public float c()
  {
    return this.z;
  }
  
  public int c(int paramInt)
  {
    int i2 = this.r;
    int i1 = i2;
    if (i2 >= paramInt) {
      i1 = paramInt - 1;
    }
    return i1;
  }
  
  public void c(float paramFloat)
  {
    this.d.a(paramFloat);
  }
  
  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean c(long paramLong)
  {
    long l1 = this.c;
    return (l1 > 0L) && (paramLong - l1 < 0L);
  }
  
  public void d()
  {
    this.t = true;
  }
  
  public void d(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public abstract void d(long paramLong);
  
  public void d(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void e(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void e(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public boolean e()
  {
    return this.t;
  }
  
  public abstract float[] e(long paramLong);
  
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
      paramObject = (RFWBaseBarrage)paramObject;
      Object localObject = this.D;
      if (localObject != null) {
        return localObject.equals(paramObject.D);
      }
      return paramObject.D == null;
    }
    return false;
  }
  
  public void f()
  {
    this.t = false;
  }
  
  public void f(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public abstract float[] f(long paramLong);
  
  public abstract float g();
  
  public void g(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void h()
  {
    RFWWindowConfig localRFWWindowConfig = RFWBarrageContext.a();
    f(localRFWWindowConfig.g());
    c(localRFWWindowConfig.i());
    T();
    a();
  }
  
  public void h(long paramLong)
  {
    this.c = paramLong;
  }
  
  public int hashCode()
  {
    Object localObject = this.D;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public long i()
  {
    return this.d.a();
  }
  
  public long j()
  {
    return this.c + i();
  }
  
  public void k()
  {
    float f1 = s();
    Object localObject;
    if ((!this.v) && (f1 < H()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[afterDraw] exposure barrage = ");
      ((StringBuilder)localObject).append(toString());
      RFWBarrageLogger.c("RFWBaseBarrage", ((StringBuilder)localObject).toString());
      R();
      localObject = this.w;
      if (localObject != null) {
        ((RFWBaseBarrage.OnLeftBarrageListener)localObject).c(this);
      }
      this.v = true;
    }
    if ((this.w != null) && (f1 <= 0 - H()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[afterDraw] exposure barrage = ");
      ((StringBuilder)localObject).append(toString());
      RFWBarrageLogger.c("RFWBaseBarrage", ((StringBuilder)localObject).toString());
      this.w.a(this);
      this.w = null;
    }
  }
  
  public void l()
  {
    RFWBaseBarrage.OnLeftBarrageListener localOnLeftBarrageListener = this.w;
    if (localOnLeftBarrageListener != null) {
      localOnLeftBarrageListener.b(this);
    }
  }
  
  public boolean m()
  {
    return (this.i >= 0.0F) && (this.j >= 0.0F) && (!M());
  }
  
  public void n()
  {
    e(false);
  }
  
  public boolean o()
  {
    return this.l == 1;
  }
  
  public boolean p()
  {
    return this.m;
  }
  
  public abstract int q();
  
  public DATA r()
  {
    return this.D;
  }
  
  public abstract float s();
  
  public abstract float t();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseDanmaku");
    localStringBuilder.append(this.b);
    localStringBuilder.append("[left:");
    localStringBuilder.append(s());
    localStringBuilder.append(",top:");
    localStringBuilder.append(t());
    localStringBuilder.append(",right:");
    localStringBuilder.append(u());
    localStringBuilder.append(",bottom:");
    localStringBuilder.append(v());
    localStringBuilder.append(", time:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mData=");
    localStringBuilder.append(String.valueOf(this.D));
    localStringBuilder.append(", mType=");
    localStringBuilder.append(q());
    localStringBuilder.append(", playerTime=");
    localStringBuilder.append(this.a.e());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public abstract float u();
  
  public abstract float v();
  
  public long w()
  {
    return this.b;
  }
  
  public long x()
  {
    return this.e;
  }
  
  public int y()
  {
    return this.g;
  }
  
  public int z()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.data.RFWBaseBarrage
 * JD-Core Version:    0.7.0.1
 */