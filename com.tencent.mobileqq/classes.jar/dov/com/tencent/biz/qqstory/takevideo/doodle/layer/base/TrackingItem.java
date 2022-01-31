package dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build;
import android.view.animation.LinearInterpolator;
import java.util.HashMap;
import java.util.Map;

public abstract class TrackingItem
{
  public ValueAnimator a;
  public Map a;
  public ValueAnimator b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public int i = 0;
  public float j;
  public float k;
  public float l;
  public float m;
  public float n = 1.0F;
  public float o = 1.0F;
  public float p = 1.0F;
  
  public TrackingItem()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private static boolean d()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("vivo")) && (str.contains("Y51A"));
  }
  
  public void a(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    if (this.b == null)
    {
      this.b = ValueAnimator.ofInt(new int[] { 12, 1, 12 });
      this.b.setDuration(2000L);
      this.b.setInterpolator(new LinearInterpolator());
      this.b.setRepeatMode(1);
      this.b.setRepeatCount(-1);
      this.b.addUpdateListener(paramAnimatorUpdateListener);
      this.b.addListener(paramAnimatorListenerAdapter);
    }
    if (!this.b.isRunning()) {
      this.b.start();
    }
  }
  
  public void a(TrackingItem paramTrackingItem)
  {
    if (paramTrackingItem != null)
    {
      this.c = paramTrackingItem.c;
      this.j = paramTrackingItem.j;
      this.k = paramTrackingItem.k;
      this.l = paramTrackingItem.l;
      this.m = paramTrackingItem.m;
      this.d = paramTrackingItem.d;
      this.f = paramTrackingItem.f;
      this.g = paramTrackingItem.g;
      this.o = paramTrackingItem.o;
      this.i = paramTrackingItem.i;
    }
  }
  
  public boolean a()
  {
    return this.i == 0;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!d())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.c = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    return this.i == 2;
  }
  
  public boolean c()
  {
    return this.i == 3;
  }
  
  public void f()
  {
    this.f = false;
    this.g = false;
    this.j = 0.0F;
    this.k = 0.0F;
    this.l = 0.0F;
    this.m = 0.0F;
    this.o = 1.0F;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.i = 0;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    g();
  }
  
  public void g()
  {
    if ((this.b != null) && (this.b.isRunning())) {
      this.b.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.TrackingItem
 * JD-Core Version:    0.7.0.1
 */