package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
    if (paramHippyMap.containsKey("valueType")) {
      this.i = paramHippyMap.getString("valueType");
    }
    if (paramHippyMap.containsKey("timingFunction")) {
      this.g = paramHippyMap.getString("timingFunction");
    }
    if (paramHippyMap.containsKey("repeatCount"))
    {
      this.j = paramHippyMap.getInt("repeatCount");
      if (this.j > 0) {
        this.j -= 1;
      }
      this.h.setRepeatCount(this.j);
      this.h.setRepeatMode(1);
    }
    if (paramHippyMap.containsKey("inputRange"))
    {
      HippyArray localHippyArray = paramHippyMap.getArray("inputRange");
      if (paramHippyMap.containsKey("outputRange")) {
        this.k = new f(localHippyArray, paramHippyMap.getArray("outputRange"));
      }
    }
    this.h.setFloatValues(new float[] { this.d, this.e });
    this.h.setDuration(this.f);
    if (TextUtils.equals("ease-in", this.g)) {
      this.h.setInterpolator(new AccelerateInterpolator());
    }
    for (;;)
    {
      this.h.setStartDelay(this.l);
      return;
      if (TextUtils.equals("ease-out", this.g)) {
        this.h.setInterpolator(new DecelerateInterpolator());
      } else if (TextUtils.equals("ease-in-out", this.g)) {
        this.h.setInterpolator(new AccelerateDecelerateInterpolator());
      } else if (TextUtils.equals("ease_bezier", this.g))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          this.h.setInterpolator(new PathInterpolator(0.42F, 0.0F, 1.0F, 1.0F));
        } else {
          this.h.setInterpolator(new d(0.42F, 0.0F, 1.0F, 1.0F));
        }
      }
      else {
        this.h.setInterpolator(new LinearInterpolator());
      }
    }
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
      localObject1 = localObject2;
      if (this.k != null)
      {
        Object localObject3 = this.k.a((Number)localObject2);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
    if (TextUtils.equals(this.i, "rad")) {
      localObject2 = localObject1 + "rad";
    }
    do
    {
      return localObject2;
      localObject2 = localObject1;
    } while (!TextUtils.equals(this.i, "deg"));
    return localObject1 + "deg";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.e
 * JD-Core Version:    0.7.0.1
 */