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
  static final ValueAnimation.TypeEvaluator jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$TypeEvaluator = new ValueAnimation.1();
  static final ValueAnimation.TypeEvaluator b;
  static final ValueAnimation.TypeEvaluator c;
  static final ValueAnimation.TypeEvaluator d;
  static final ValueAnimation.TypeEvaluator e = new ValueAnimation.5();
  private long jdField_a_of_type_Long = 0L;
  protected ValueAnimation.AnimationUpdateListener<T> a;
  protected T a;
  protected boolean a;
  private Pair[] jdField_a_of_type_ArrayOfAndroidUtilPair;
  protected T b;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  protected ValueAnimation.TypeEvaluator<T> f;
  
  static
  {
    jdField_b_of_type_ComTencentMobileqqUtilsValueAnimation$TypeEvaluator = new ValueAnimation.2();
    jdField_c_of_type_ComTencentMobileqqUtilsValueAnimation$TypeEvaluator = new ValueAnimation.3();
    jdField_d_of_type_ComTencentMobileqqUtilsValueAnimation$TypeEvaluator = new ValueAnimation.4();
  }
  
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
      this.f = paramTypeEvaluator;
    }
    else if (localClass == Integer.class)
    {
      this.f = jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$TypeEvaluator;
    }
    else if (Float.class == localClass)
    {
      this.f = jdField_b_of_type_ComTencentMobileqqUtilsValueAnimation$TypeEvaluator;
    }
    else if (Rect.class == localClass)
    {
      this.f = jdField_c_of_type_ComTencentMobileqqUtilsValueAnimation$TypeEvaluator;
    }
    else if (Point.class == localClass)
    {
      this.f = jdField_d_of_type_ComTencentMobileqqUtilsValueAnimation$TypeEvaluator;
    }
    else
    {
      if (PointF.class != localClass) {
        break label139;
      }
      this.f = e;
    }
    this.jdField_a_of_type_JavaLangObject = paramT1;
    this.jdField_b_of_type_JavaLangObject = paramT2;
    a(paramAnimationUpdateListener);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    return;
    label139:
    paramT2 = new StringBuilder();
    paramT2.append("Can't support type ");
    paramT2.append(paramT1.getClass().getSimpleName());
    throw new IllegalArgumentException(paramT2.toString());
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(ValueAnimation.AnimationUpdateListener<T> paramAnimationUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener = paramAnimationUpdateListener;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    ValueAnimation.AnimationUpdateListener localAnimationUpdateListener = this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener;
    if (localAnimationUpdateListener != null) {
      localAnimationUpdateListener.a(this, paramFloat, this.f.a(paramFloat, this.jdField_a_of_type_JavaLangObject, this.jdField_b_of_type_JavaLangObject), paramTransformation);
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void cancel()
  {
    this.jdField_c_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT >= 8)
    {
      super.cancel();
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidUtilPair;
    int i = 0;
    if (localObject1 == null) {
      this.jdField_a_of_type_ArrayOfAndroidUtilPair = new Pair[] { new Pair("mEnded", Boolean.valueOf(true)), new Pair("mMore", Boolean.valueOf(false)), new Pair("mOneMoreTime", Boolean.valueOf(false)) };
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
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidUtilPair;
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        Field localField = getClass().getDeclaredField((String)localObject2.first);
        localField.setAccessible(true);
        localField.setBoolean(this, ((Boolean)localObject2.second).booleanValue());
        i += 1;
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
    if (this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Long == 0L) {
        a(paramLong - getStartTime());
      }
      setStartTime(paramLong - this.jdField_a_of_type_Long);
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
  
  public void reset()
  {
    this.jdField_c_of_type_Boolean = false;
    super.reset();
  }
  
  public boolean willChangeBounds()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ValueAnimation
 * JD-Core Version:    0.7.0.1
 */