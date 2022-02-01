package com.tencent.mobileqq.profile.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DragSource;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.Draggable;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DropTarget;

public class BreatheEffectView
  extends ImageView
  implements DragAndDropDetector.DropTarget
{
  public static final int[] a = { 170, 112, 112 };
  private static int c;
  private AnimatorSet b;
  private LayerDrawable d;
  private Drawable[] e;
  private Rect[] f;
  private int[] g;
  private Rect h;
  private TypeEvaluator i = new BreatheEffectView.1(this);
  
  public BreatheEffectView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public BreatheEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public BreatheEffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void e()
  {
    c = getResources().getDimensionPixelSize(2131299343);
    setBackgroundResource(2130849301);
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof LayerDrawable))
    {
      this.d = ((LayerDrawable)localDrawable);
      this.e = new Drawable[3];
      this.e[2] = this.d.findDrawableByLayerId(2131429411);
      this.e[1] = this.d.findDrawableByLayerId(2131429414);
      this.e[0] = this.d.findDrawableByLayerId(2131429403);
      return;
    }
    throw new RuntimeException("Background is not a layer drawable!");
  }
  
  private void f()
  {
    if (this.f == null)
    {
      this.f = new Rect[3];
      int j = 0;
      while (j < 3)
      {
        this.f[j] = new Rect(this.e[j].getBounds());
        j += 1;
      }
      j = 1;
      while (j < 3)
      {
        Drawable localDrawable = this.e[j];
        Rect localRect = this.f[j];
        int k = localRect.centerX();
        int m = localRect.centerY();
        localDrawable.setBounds(k, m, k, m);
        j += 1;
      }
    }
  }
  
  private boolean g()
  {
    return (this.d != null) && (getBackground() == this.d);
  }
  
  public void a()
  {
    if (g())
    {
      if (this.b == null)
      {
        this.b = new AnimatorSet();
        int j = 0;
        while (j < 3)
        {
          Object localObject1 = this.e[j];
          Object localObject2 = new Rect();
          ((Rect)localObject2).left = (this.f[j].left - c);
          ((Rect)localObject2).top = (this.f[j].top - c);
          ((Rect)localObject2).right = (this.f[j].right + c);
          ((Rect)localObject2).bottom = (this.f[j].bottom + c);
          localObject2 = ObjectAnimator.ofObject(localObject1, "bounds", this.i, new Object[] { this.f[j], localObject2 });
          long l = j * 180;
          ((ValueAnimator)localObject2).setStartDelay(l);
          ((ValueAnimator)localObject2).setDuration(600L);
          ((ValueAnimator)localObject2).setInterpolator(new CycleInterpolator(0.5F));
          localObject1 = ObjectAnimator.ofInt(localObject1, "alpha", new int[] { 0, 255 });
          ((ValueAnimator)localObject1).setInterpolator(new CycleInterpolator(0.5F));
          ((ValueAnimator)localObject1).setStartDelay(l);
          ((ValueAnimator)localObject1).setDuration(600L);
          this.b.playTogether(new Animator[] { localObject1 });
          if (2 == j) {
            ((ValueAnimator)localObject2).addListener(new BreatheEffectView.2(this));
          }
          this.b.playTogether(new Animator[] { localObject2 });
          j += 1;
        }
      }
      this.b.start();
    }
  }
  
  public void a(BreatheEffectView.BreatheListener paramBreatheListener)
  {
    if (g())
    {
      b();
      f();
      AnimatorSet localAnimatorSet = new AnimatorSet();
      int j = 1;
      while (j < 3)
      {
        Drawable localDrawable = this.e[j];
        Object localObject = this.f[j];
        int k = ((Rect)localObject).centerX();
        int m = ((Rect)localObject).centerY();
        Rect localRect = new Rect(k, m, k, m);
        localDrawable.setBounds(localRect);
        localObject = ObjectAnimator.ofObject(this.i, new Object[] { localRect, localObject });
        ((ValueAnimator)localObject).addUpdateListener(new BreatheEffectView.3(this, localDrawable));
        ((ValueAnimator)localObject).setDuration(400L);
        ((ValueAnimator)localObject).setStartDelay(j * 50);
        localAnimatorSet.playTogether(new Animator[] { localObject });
        j += 1;
      }
      if (paramBreatheListener != null) {
        localAnimatorSet.addListener(new BreatheEffectView.4(this, paramBreatheListener));
      }
      localAnimatorSet.setInterpolator(new OvershootInterpolator(1.6F));
      localAnimatorSet.start();
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.h;
    if (localObject != null) {
      return ((Rect)localObject).contains((int)paramFloat1, (int)paramFloat2);
    }
    if (this.g == null)
    {
      this.g = new int[2];
      getLocationOnScreen(this.g);
    }
    int j = getWidth();
    localObject = this.g;
    boolean bool2 = false;
    int k = localObject[0];
    int m = getHeight();
    localObject = this.g;
    int n = localObject[1];
    boolean bool1 = bool2;
    if (paramFloat1 >= localObject[0])
    {
      bool1 = bool2;
      if (paramFloat1 <= j + k)
      {
        bool1 = bool2;
        if (paramFloat2 >= localObject[1])
        {
          bool1 = bool2;
          if (paramFloat2 <= m + n) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public void b()
  {
    if ((g()) && (this.f != null))
    {
      clearAnimation();
      int j = 0;
      while (j < 3)
      {
        this.e[j].setBounds(this.f[j]);
        this.e[j].setAlpha(255);
        j += 1;
      }
    }
  }
  
  public void b(BreatheEffectView.BreatheListener paramBreatheListener)
  {
    if (g())
    {
      clearAnimation();
      paramBreatheListener = new AnimatorSet();
      int j = 1;
      while (j < 3)
      {
        Drawable localDrawable = this.e[j];
        Object localObject = this.f[j];
        int k = ((Rect)localObject).centerX();
        int m = ((Rect)localObject).centerY();
        localObject = ObjectAnimator.ofObject(this.i, new Object[] { localObject, new Rect(k, m, k, m) });
        ((ValueAnimator)localObject).addUpdateListener(new BreatheEffectView.5(this, localDrawable));
        ((ValueAnimator)localObject).setDuration(400L);
        paramBreatheListener.playTogether(new Animator[] { localObject });
        j += 1;
      }
      paramBreatheListener.start();
    }
  }
  
  public boolean b(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    c();
    return true;
  }
  
  public void c()
  {
    if (g())
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      int j = 0;
      while (j < 3)
      {
        Object localObject1 = this.e[j];
        Object localObject2 = this.f[j];
        Object localObject3 = new Rect();
        ((Rect)localObject2).left -= c;
        ((Rect)localObject2).top -= c;
        ((Rect)localObject2).right += c;
        ((Rect)localObject2).bottom += c;
        localObject2 = ObjectAnimator.ofObject(localObject1, "bounds", this.i, new Object[] { localObject2, localObject3 }).setDuration(800L);
        ((ValueAnimator)localObject2).setInterpolator(new AccelerateInterpolator(0.24F));
        localObject1 = ObjectAnimator.ofInt(localObject1, "alpha", new int[] { 204, 0 }).setDuration(800L);
        ((ValueAnimator)localObject1).setInterpolator(new AccelerateInterpolator(0.24F));
        localObject3 = ObjectAnimator.ofInt(new int[] { 0, 0 });
        ((ValueAnimator)localObject3).setDuration(1000L);
        localAnimatorSet.playTogether(new Animator[] { localObject2, localObject1, localObject3 });
        j += 1;
      }
      localAnimatorSet.start();
    }
  }
  
  public void c(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    d();
    a();
  }
  
  public void d()
  {
    b();
  }
  
  public void d(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2) {}
  
  protected void onDraw(Canvas paramCanvas)
  {
    f();
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setHaloColor(int paramInt)
  {
    if (this.e != null)
    {
      int j = 0;
      while (j < 3)
      {
        Drawable[] arrayOfDrawable = this.e;
        if ((arrayOfDrawable[j] instanceof GradientDrawable))
        {
          int k = 0xFFFFFF & paramInt | a[j] << 24;
          if (j != 0) {
            ((GradientDrawable)arrayOfDrawable[j]).setColor(k);
          } else {
            ((GradientDrawable)arrayOfDrawable[j]).setStroke(2, k);
          }
        }
        j += 1;
      }
    }
  }
  
  public void setHoverHotArea(Rect paramRect)
  {
    this.h = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.BreatheEffectView
 * JD-Core Version:    0.7.0.1
 */