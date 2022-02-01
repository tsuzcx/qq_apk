package com.tencent.mobileqq.businessCard.helpers;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy
  extends Animation
{
  public static final boolean a;
  static final WeakHashMap<View, AnimatorProxy> b = new WeakHashMap();
  final WeakReference<View> c;
  final Camera d = new Camera();
  boolean e;
  float f = 1.0F;
  float g;
  float h;
  float i;
  float j;
  float k;
  float l = 1.0F;
  float m = 1.0F;
  float n;
  float o;
  final RectF p = new RectF();
  final RectF q = new RectF();
  final Matrix r = new Matrix();
  
  static
  {
    boolean bool;
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
  
  private AnimatorProxy(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    paramView.setAnimation(this);
    this.c = new WeakReference(paramView);
  }
  
  public static AnimatorProxy a(View paramView)
  {
    AnimatorProxy localAnimatorProxy2 = (AnimatorProxy)b.get(paramView);
    AnimatorProxy localAnimatorProxy1;
    if (localAnimatorProxy2 != null)
    {
      localAnimatorProxy1 = localAnimatorProxy2;
      if (localAnimatorProxy2 == paramView.getAnimation()) {}
    }
    else
    {
      localAnimatorProxy1 = new AnimatorProxy(paramView);
      b.put(paramView, localAnimatorProxy1);
    }
    return localAnimatorProxy1;
  }
  
  private void a()
  {
    View localView = (View)this.c.get();
    if (localView != null) {
      a(this.p, localView);
    }
  }
  
  private void a(Matrix paramMatrix, View paramView)
  {
    float f3 = paramView.getWidth();
    float f4 = paramView.getHeight();
    boolean bool = this.e;
    float f1;
    if (bool) {
      f1 = this.g;
    } else {
      f1 = f3 / 2.0F;
    }
    float f2;
    if (bool) {
      f2 = this.h;
    } else {
      f2 = f4 / 2.0F;
    }
    float f5 = this.i;
    float f6 = this.j;
    float f7 = this.k;
    if ((f5 != 0.0F) || (f6 != 0.0F) || (f7 != 0.0F))
    {
      paramView = this.d;
      paramView.save();
      paramView.rotateX(f5);
      paramView.rotateY(f6);
      paramView.rotateZ(-f7);
      paramView.getMatrix(paramMatrix);
      paramView.restore();
      paramMatrix.preTranslate(-f1, -f2);
      paramMatrix.postTranslate(f1, f2);
    }
    f5 = this.l;
    f6 = this.m;
    if ((f5 != 1.0F) || (f6 != 1.0F))
    {
      paramMatrix.postScale(f5, f6);
      paramMatrix.postTranslate(-(f1 / f3) * (f5 * f3 - f3), -(f2 / f4) * (f6 * f4 - f4));
    }
    paramMatrix.postTranslate(this.n, this.o);
  }
  
  private void b()
  {
    View localView = (View)this.c.get();
    if (localView != null)
    {
      if (localView.getParent() == null) {
        return;
      }
      RectF localRectF = this.q;
      a(localRectF, localView);
      localRectF.union(this.p);
      ((View)localView.getParent()).invalidate((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.f != paramFloat)
    {
      this.f = paramFloat;
      View localView = (View)this.c.get();
      if (localView != null) {
        localView.invalidate();
      }
    }
  }
  
  public void a(RectF paramRectF, View paramView)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = this.r;
    localMatrix.reset();
    a(localMatrix, paramView);
    this.r.mapRect(paramRectF);
    paramRectF.offset(paramView.getLeft(), paramView.getTop());
    float f1;
    if (paramRectF.right < paramRectF.left)
    {
      f1 = paramRectF.right;
      paramRectF.right = paramRectF.left;
      paramRectF.left = f1;
    }
    if (paramRectF.bottom < paramRectF.top)
    {
      f1 = paramRectF.top;
      paramRectF.top = paramRectF.bottom;
      paramRectF.bottom = f1;
    }
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.c.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.f);
      a(paramTransformation.getMatrix(), localView);
    }
  }
  
  public void b(float paramFloat)
  {
    if ((!this.e) || (this.g != paramFloat))
    {
      a();
      this.e = true;
      this.g = paramFloat;
      b();
    }
  }
  
  public void c(float paramFloat)
  {
    if ((!this.e) || (this.h != paramFloat))
    {
      a();
      this.e = true;
      this.h = paramFloat;
      b();
    }
  }
  
  public void d(float paramFloat)
  {
    if (this.l != paramFloat)
    {
      a();
      this.l = paramFloat;
      b();
    }
  }
  
  public void e(float paramFloat)
  {
    if (this.m != paramFloat)
    {
      a();
      this.m = paramFloat;
      b();
    }
  }
  
  public void f(float paramFloat)
  {
    if (this.n != paramFloat)
    {
      a();
      this.n = paramFloat;
      b();
    }
  }
  
  public void g(float paramFloat)
  {
    if (this.o != paramFloat)
    {
      a();
      this.o = paramFloat;
      b();
    }
  }
  
  public void h(float paramFloat)
  {
    View localView = (View)this.c.get();
    if (localView != null) {
      f(paramFloat - localView.getLeft());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.helpers.AnimatorProxy
 * JD-Core Version:    0.7.0.1
 */