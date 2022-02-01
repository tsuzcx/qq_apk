package com.tencent.mobileqq.utils;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import java.lang.reflect.Field;

public class ValueAnimation<T>
  extends Animation
{
  static final ValueAnimation.TypeEvaluator a = new ValueAnimation.1();
  static final ValueAnimation.TypeEvaluator b = new ValueAnimation.2();
  static final ValueAnimation.TypeEvaluator c = new ValueAnimation.3();
  static final ValueAnimation.TypeEvaluator d = new ValueAnimation.4();
  static final ValueAnimation.TypeEvaluator e = new ValueAnimation.5();
  protected T f;
  protected T g;
  protected ValueAnimation.TypeEvaluator<T> h;
  protected ValueAnimation.AnimationUpdateListener<T> i;
  protected boolean j;
  protected boolean k;
  protected boolean l;
  protected boolean m;
  private long n = 0L;
  private Pair[] o;
  
  public ValueAnimation(T paramT1, T paramT2, ValueAnimation.AnimationUpdateListener<T> paramAnimationUpdateListener)
  {
    this(paramT1, paramT2, paramAnimationUpdateListener, false, false, null);
  }
  
  public ValueAnimation(T paramT1, T paramT2, ValueAnimation.AnimationUpdateListener<T> paramAnimationUpdateListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramT1, paramT2, paramAnimationUpdateListener, paramBoolean1, paramBoolean2, null);
  }
  
  public ValueAnimation(T paramT1, T paramT2, ValueAnimation.AnimationUpdateListener<T> paramAnimationUpdateListener, boolean paramBoolean1, boolean paramBoolean2, ValueAnimation.TypeEvaluator<T> paramTypeEvaluator)
  {
    Class localClass = paramT1.getClass();
    if (paramTypeEvaluator != null)
    {
      this.h = paramTypeEvaluator;
    }
    else if (localClass == Integer.class)
    {
      this.h = a;
    }
    else if (Float.class == localClass)
    {
      this.h = b;
    }
    else if (Rect.class == localClass)
    {
      this.h = c;
    }
    else if (Point.class == localClass)
    {
      this.h = d;
    }
    else
    {
      if (PointF.class != localClass) {
        break label139;
      }
      this.h = e;
    }
    this.f = paramT1;
    this.g = paramT2;
    a(paramAnimationUpdateListener);
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    return;
    label139:
    paramT2 = new StringBuilder();
    paramT2.append("Can't support type ");
    paramT2.append(paramT1.getClass().getSimpleName());
    throw new IllegalArgumentException(paramT2.toString());
  }
  
  public void a(long paramLong)
  {
    this.n = paramLong;
  }
  
  public void a(ValueAnimation.AnimationUpdateListener<T> paramAnimationUpdateListener)
  {
    this.i = paramAnimationUpdateListener;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    ValueAnimation.AnimationUpdateListener localAnimationUpdateListener = this.i;
    if (localAnimationUpdateListener != null) {
      localAnimationUpdateListener.a(this, paramFloat, this.h.a(paramFloat, this.f, this.g), paramTransformation);
    }
  }
  
  public void cancel()
  {
    this.l = true;
    if (Build.VERSION.SDK_INT >= 8)
    {
      super.cancel();
      return;
    }
    Object localObject1 = this.o;
    int i1 = 0;
    if (localObject1 == null) {
      this.o = new Pair[] { new Pair("mEnded", Boolean.valueOf(true)), new Pair("mMore", Boolean.valueOf(false)), new Pair("mOneMoreTime", Boolean.valueOf(false)) };
    }
    try
    {
      localObject1 = getClass().getDeclaredField("mListener");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(this);
      if ((localObject1 instanceof Animation.AnimationListener)) {
        ((Animation.AnimationListener)localObject1).onAnimationEnd(this);
      }
      localObject1 = getClass().getDeclaredField("mStartTime");
      ((Field)localObject1).setAccessible(true);
      ((Field)localObject1).setLong(this, -9223372036854775808L);
      localObject1 = this.o;
      int i2 = localObject1.length;
      while (i1 < i2)
      {
        Object localObject2 = localObject1[i1];
        Field localField = getClass().getDeclaredField((String)localObject2.first);
        localField.setAccessible(true);
        localField.setBoolean(this, ((Boolean)localObject2.second).booleanValue());
        i1 += 1;
      }
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    if (this.m)
    {
      if (this.n == 0L) {
        a(paramLong - getStartTime());
      }
      setStartTime(paramLong - this.n);
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
  
  public void reset()
  {
    this.l = false;
    super.reset();
  }
  
  public boolean willChangeBounds()
  {
    return this.j;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ValueAnimation
 * JD-Core Version:    0.7.0.1
 */