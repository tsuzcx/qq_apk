package com.tencent.mobileqq.danmaku.data;

import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.IDanmakuUIConfig;
import com.tencent.mobileqq.danmaku.inject.WindowConfig;
import com.tencent.mobileqq.danmaku.tool.Duration;
import com.tencent.mobileqq.danmaku.util.Logger;

public abstract class R2LDanmaku<DATA, CONFIG extends IDanmakuUIConfig>
  extends BaseDanmaku<DATA, CONFIG>
{
  private float[] a;
  private float d = 0.0F;
  private float e = -1.0F;
  private float f;
  
  public R2LDanmaku(DanmakuContext paramDanmakuContext)
  {
    super(paramDanmakuContext);
    this.jdField_a_of_type_ArrayOfFloat = null;
  }
  
  protected float a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    return f() - (float)(paramLong - l) * this.f;
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
      Logger.c("BaseDanmaku", localStringBuilder.toString());
      this.d = a(paramLong2);
      if (!c())
      {
        this.e = paramFloat2;
        a(true);
      }
      return;
    }
    a(false);
  }
  
  public void a(long paramLong)
  {
    this.d = a(paramLong);
  }
  
  public float[] a(long paramLong)
  {
    if (!b()) {
      return null;
    }
    float f1 = a(paramLong);
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = new float[4];
    }
    this.jdField_a_of_type_ArrayOfFloat[0] = (f1 - DanmakuContext.a().b());
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat[1] = this.e;
    arrayOfFloat[2] = (f1 + this.jdField_a_of_type_Float + this.c);
    this.jdField_a_of_type_ArrayOfFloat[3] = (this.e + this.b);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public float[] b(long paramLong)
  {
    if (!b()) {
      return null;
    }
    float f1 = a(paramLong);
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = new float[4];
    }
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = this.e;
    arrayOfFloat[2] = (f1 + this.jdField_a_of_type_Float);
    this.jdField_a_of_type_ArrayOfFloat[3] = (this.e + this.b);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public float c()
  {
    return -this.f;
  }
  
  public float d()
  {
    return this.d;
  }
  
  public float e()
  {
    return this.e;
  }
  
  public float f()
  {
    return this.d + this.jdField_a_of_type_Float;
  }
  
  public float g()
  {
    return this.e + this.b;
  }
  
  public void g()
  {
    super.g();
    this.f = ((int)(f() + this.jdField_a_of_type_Float) / (float)this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDuration.a());
  }
  
  public void g(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void h(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void i(float paramFloat)
  {
    this.e = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.data.R2LDanmaku
 * JD-Core Version:    0.7.0.1
 */