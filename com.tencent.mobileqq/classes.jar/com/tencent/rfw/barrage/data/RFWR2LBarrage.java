package com.tencent.rfw.barrage.data;

import com.tencent.rfw.barrage.inject.IRFWBarrageUIConfig;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import com.tencent.rfw.barrage.tool.RFWDuration;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import com.tencent.rfw.barrage.util.RFWQQUtils;

public abstract class RFWR2LBarrage<DATA, CONFIG extends IRFWBarrageUIConfig>
  extends RFWBaseBarrage<DATA, CONFIG>
{
  private float[] A = null;
  private float B;
  private float y = 0.0F;
  private float z = -1.0F;
  
  public RFWR2LBarrage(RFWBarrageContext paramRFWBarrageContext)
  {
    super(paramRFWBarrageContext);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    if (!a(paramLong1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayout, Y = ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append(", danmaku = ");
      localStringBuilder.append(toString());
      RFWBarrageLogger.c("RFWBaseBarrage", localStringBuilder.toString());
      this.y = i(paramLong2);
      if (!o())
      {
        this.z = paramFloat2;
        b(true);
      }
      return;
    }
    b(false);
  }
  
  public void d(long paramLong)
  {
    this.y = i(paramLong);
  }
  
  public float[] e(long paramLong)
  {
    if (!m()) {
      return null;
    }
    float f = i(paramLong);
    if (this.A == null) {
      this.A = new float[4];
    }
    this.A[0] = (f - RFWBarrageContext.a().h());
    float[] arrayOfFloat = this.A;
    arrayOfFloat[1] = this.z;
    arrayOfFloat[2] = (f + this.i + this.k);
    this.A[3] = (this.z + this.j);
    return this.A;
  }
  
  public float[] f(long paramLong)
  {
    if (!m()) {
      return null;
    }
    float f = i(paramLong);
    if (this.A == null) {
      this.A = new float[4];
    }
    float[] arrayOfFloat = this.A;
    arrayOfFloat[0] = f;
    arrayOfFloat[1] = this.z;
    arrayOfFloat[2] = (f + this.i);
    this.A[3] = (this.z + this.j);
    return this.A;
  }
  
  public float g()
  {
    return -this.B;
  }
  
  public void g(float paramFloat)
  {
    this.B = paramFloat;
  }
  
  public void h(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  protected float i(long paramLong)
  {
    long l = this.c;
    return H() - (float)(paramLong - l) * this.B;
  }
  
  public void i(float paramFloat)
  {
    this.z = paramFloat;
  }
  
  public void n()
  {
    super.n();
    int i = (int)(H() + this.i);
    if (RFWQQUtils.b()) {
      RFWBarrageLogger.a("RFWBaseBarrage", new Object[] { "[afterMeasure] mDuration.value(): ", Long.valueOf(this.d.a()) });
    }
    this.B = (i / (float)this.d.a());
  }
  
  public float s()
  {
    return this.y;
  }
  
  public float t()
  {
    return this.z;
  }
  
  public float u()
  {
    return this.y + this.i;
  }
  
  public float v()
  {
    return this.z + this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.data.RFWR2LBarrage
 * JD-Core Version:    0.7.0.1
 */