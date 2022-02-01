package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;

public class e
  extends a
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  protected float d;
  protected float e;
  protected int f;
  protected String g;
  protected ValueAnimator h = new ValueAnimator();
  protected String i;
  protected int j = 0;
  protected f k;
  protected int l = 0;
  private Object m = Double.valueOf(0.0D);
  
  public e(int paramInt)
  {
    super(paramInt);
    this.h.addUpdateListener(this);
    this.h.addListener(this);
  }
  
  public Animator a()
  {
    return this.h;
  }
  
  public void a(HippyMap paramHippyMap)
  {
    if (paramHippyMap.containsKey("valueType")) {
      this.i = paramHippyMap.getString("valueType");
    }
    if (paramHippyMap.containsKey("delay")) {
      this.l = paramHippyMap.getInt("delay");
    }
    if (paramHippyMap.containsKey("startValue")) {
      this.d = ((float)paramHippyMap.getDouble("startValue"));
    }
    this.m = Float.valueOf(this.d);
    if (paramHippyMap.containsKey("toValue")) {
      this.e = ((float)paramHippyMap.getDouble("toValue"));
    }
    if (paramHippyMap.containsKey("duration")) {
      this.f = paramHippyMap.getInt("duration");
    }
    if (paramHippyMap.containsKey("timingFunction")) {
      this.g = paramHippyMap.getString("timingFunction");
    }
    if (paramHippyMap.containsKey("repeatCount"))
    {
      this.j = paramHippyMap.getInt("repeatCount");
      int n = this.j;
      if (n > 0) {
        this.j = (n - 1);
      }
      this.h.setRepeatCount(this.j);
      this.h.setRepeatMode(1);
    }
    Object localObject;
    if (paramHippyMap.containsKey("inputRange"))
    {
      localObject = paramHippyMap.getArray("inputRange");
      if (paramHippyMap.containsKey("outputRange")) {
        this.k = new f((HippyArray)localObject, paramHippyMap.getArray("outputRange"));
      }
    }
    if ((!TextUtils.isEmpty(this.i)) && (this.i.equals("color")))
    {
      this.h.setIntValues(new int[] { (int)this.d, (int)this.e });
      this.h.setEvaluator(new ArgbEvaluator());
    }
    else
    {
      this.h.setFloatValues(new float[] { this.d, this.e });
    }
    this.h.setDuration(this.f);
    if (TextUtils.equals("ease-in", this.g))
    {
      localObject = this.h;
      paramHippyMap = new AccelerateInterpolator();
    }
    for (;;)
    {
      ((ValueAnimator)localObject).setInterpolator(paramHippyMap);
      break;
      if (TextUtils.equals("ease-out", this.g))
      {
        localObject = this.h;
        paramHippyMap = new DecelerateInterpolator();
      }
      else if (TextUtils.equals("ease-in-out", this.g))
      {
        localObject = this.h;
        paramHippyMap = new AccelerateDecelerateInterpolator();
      }
      else if (TextUtils.equals("ease_bezier", this.g))
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject = this.h;
          paramHippyMap = new PathInterpolator(0.42F, 0.0F, 1.0F, 1.0F);
        }
        else
        {
          localObject = this.h;
          paramHippyMap = new d(0.42F, 0.0F, 1.0F, 1.0F);
        }
      }
      else
      {
        localObject = this.h;
        paramHippyMap = new LinearInterpolator();
      }
    }
    this.h.setStartDelay(this.l);
  }
  
  public void b()
  {
    this.h.start();
  }
  
  public void c()
  {
    this.h.cancel();
  }
  
  public Object f()
  {
    Object localObject2 = g();
    Object localObject1 = localObject2;
    if ((localObject2 instanceof Number))
    {
      localObject3 = this.k;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((f)localObject3).a((Number)localObject2);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
    localObject2 = this.i;
    Object localObject3 = "rad";
    if (TextUtils.equals((CharSequence)localObject2, "rad")) {}
    for (localObject2 = new StringBuilder();; localObject2 = new StringBuilder())
    {
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append((String)localObject3);
      return ((StringBuilder)localObject2).toString();
      localObject2 = this.i;
      localObject3 = "deg";
      if (!TextUtils.equals((CharSequence)localObject2, "deg")) {
        break;
      }
    }
    return localObject1;
  }
  
  public Object g()
  {
    return this.m;
  }
  
  public void h()
  {
    if ((this.h != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.h.resume();
    }
  }
  
  public void i()
  {
    if ((this.h != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.h.pause();
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator != null) {
      this.m = this.h.getAnimatedValue();
    }
    super.onAnimationUpdate(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.e
 * JD-Core Version:    0.7.0.1
 */