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
  private static int jdField_a_of_type_Int;
  public static final int[] a;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private TypeEvaluator jdField_a_of_type_AndroidAnimationTypeEvaluator = new BreatheEffectView.1(this);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  private Rect[] jdField_a_of_type_ArrayOfAndroidGraphicsRect;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private int[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 170, 112, 112 };
  }
  
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
  
  private boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable != null) && (getBackground() == this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable);
  }
  
  private void e()
  {
    jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131298626);
    setBackgroundResource(2130847641);
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof LayerDrawable))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = ((LayerDrawable)localDrawable);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = new Drawable[3];
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2] = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131363509);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1] = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131363511);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0] = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131363501);
      return;
    }
    throw new RuntimeException("Background is not a layer drawable!");
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect == null)
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsRect = new Rect[3];
      int i = 0;
      while (i < 3)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i] = new Rect(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i].getBounds());
        i += 1;
      }
      i = 1;
      while (i < 3)
      {
        Drawable localDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i];
        Rect localRect = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i];
        int j = localRect.centerX();
        int k = localRect.centerY();
        localDrawable.setBounds(j, k, j, k);
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if (a())
    {
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null)
      {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
        int i = 0;
        while (i < 3)
        {
          Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i];
          Object localObject2 = new Rect();
          ((Rect)localObject2).left = (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i].left - jdField_a_of_type_Int);
          ((Rect)localObject2).top = (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i].top - jdField_a_of_type_Int);
          ((Rect)localObject2).right = (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i].right + jdField_a_of_type_Int);
          ((Rect)localObject2).bottom = (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i].bottom + jdField_a_of_type_Int);
          localObject2 = ObjectAnimator.ofObject(localObject1, "bounds", this.jdField_a_of_type_AndroidAnimationTypeEvaluator, new Object[] { this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i], localObject2 });
          long l = i * 180;
          ((ValueAnimator)localObject2).setStartDelay(l);
          ((ValueAnimator)localObject2).setDuration(600L);
          ((ValueAnimator)localObject2).setInterpolator(new CycleInterpolator(0.5F));
          localObject1 = ObjectAnimator.ofInt(localObject1, "alpha", new int[] { 0, 255 });
          ((ValueAnimator)localObject1).setInterpolator(new CycleInterpolator(0.5F));
          ((ValueAnimator)localObject1).setStartDelay(l);
          ((ValueAnimator)localObject1).setDuration(600L);
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObject1 });
          if (2 == i) {
            ((ValueAnimator)localObject2).addListener(new BreatheEffectView.2(this));
          }
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObject2 });
          i += 1;
        }
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    }
  }
  
  public void a(BreatheEffectView.BreatheListener paramBreatheListener)
  {
    if (a())
    {
      b();
      f();
      AnimatorSet localAnimatorSet = new AnimatorSet();
      int i = 1;
      while (i < 3)
      {
        Drawable localDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i];
        Object localObject = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i];
        int j = ((Rect)localObject).centerX();
        int k = ((Rect)localObject).centerY();
        Rect localRect = new Rect(j, k, j, k);
        localDrawable.setBounds(localRect);
        localObject = ObjectAnimator.ofObject(this.jdField_a_of_type_AndroidAnimationTypeEvaluator, new Object[] { localRect, localObject });
        ((ValueAnimator)localObject).addUpdateListener(new BreatheEffectView.3(this, localDrawable));
        ((ValueAnimator)localObject).setDuration(400L);
        ((ValueAnimator)localObject).setStartDelay(i * 50);
        localAnimatorSet.playTogether(new Animator[] { localObject });
        i += 1;
      }
      if (paramBreatheListener != null) {
        localAnimatorSet.addListener(new BreatheEffectView.4(this, paramBreatheListener));
      }
      localAnimatorSet.setInterpolator(new OvershootInterpolator(1.6F));
      localAnimatorSet.start();
    }
  }
  
  public void a(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    d();
    a();
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    if (localObject != null) {
      return ((Rect)localObject).contains((int)paramFloat1, (int)paramFloat2);
    }
    if (this.b == null)
    {
      this.b = new int[2];
      getLocationOnScreen(this.b);
    }
    int i = getWidth();
    localObject = this.b;
    boolean bool2 = false;
    int j = localObject[0];
    int k = getHeight();
    localObject = this.b;
    int m = localObject[1];
    boolean bool1 = bool2;
    if (paramFloat1 >= localObject[0])
    {
      bool1 = bool2;
      if (paramFloat1 <= i + j)
      {
        bool1 = bool2;
        if (paramFloat2 >= localObject[1])
        {
          bool1 = bool2;
          if (paramFloat2 <= k + m) {
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
    if ((a()) && (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect != null))
    {
      clearAnimation();
      int i = 0;
      while (i < 3)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i].setBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i]);
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i].setAlpha(255);
        i += 1;
      }
    }
  }
  
  public void b(BreatheEffectView.BreatheListener paramBreatheListener)
  {
    if (a())
    {
      clearAnimation();
      paramBreatheListener = new AnimatorSet();
      int i = 1;
      while (i < 3)
      {
        Drawable localDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i];
        Object localObject = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i];
        int j = ((Rect)localObject).centerX();
        int k = ((Rect)localObject).centerY();
        localObject = ObjectAnimator.ofObject(this.jdField_a_of_type_AndroidAnimationTypeEvaluator, new Object[] { localObject, new Rect(j, k, j, k) });
        ((ValueAnimator)localObject).addUpdateListener(new BreatheEffectView.5(this, localDrawable));
        ((ValueAnimator)localObject).setDuration(400L);
        paramBreatheListener.playTogether(new Animator[] { localObject });
        i += 1;
      }
      paramBreatheListener.start();
    }
  }
  
  public void b(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2) {}
  
  public boolean b(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    c();
    return true;
  }
  
  public void c()
  {
    if (a())
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      int i = 0;
      while (i < 3)
      {
        Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i];
        Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i];
        Object localObject3 = new Rect();
        ((Rect)localObject2).left -= jdField_a_of_type_Int;
        ((Rect)localObject2).top -= jdField_a_of_type_Int;
        ((Rect)localObject2).right += jdField_a_of_type_Int;
        ((Rect)localObject2).bottom += jdField_a_of_type_Int;
        localObject2 = ObjectAnimator.ofObject(localObject1, "bounds", this.jdField_a_of_type_AndroidAnimationTypeEvaluator, new Object[] { localObject2, localObject3 }).setDuration(800L);
        ((ValueAnimator)localObject2).setInterpolator(new AccelerateInterpolator(0.24F));
        localObject1 = ObjectAnimator.ofInt(localObject1, "alpha", new int[] { 204, 0 }).setDuration(800L);
        ((ValueAnimator)localObject1).setInterpolator(new AccelerateInterpolator(0.24F));
        localObject3 = ObjectAnimator.ofInt(new int[] { 0, 0 });
        ((ValueAnimator)localObject3).setDuration(1000L);
        localAnimatorSet.playTogether(new Animator[] { localObject2, localObject1, localObject3 });
        i += 1;
      }
      localAnimatorSet.start();
    }
  }
  
  public void d()
  {
    b();
  }
  
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
    if (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable != null)
    {
      int i = 0;
      while (i < 3)
      {
        Drawable[] arrayOfDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
        if ((arrayOfDrawable[i] instanceof GradientDrawable))
        {
          int j = 0xFFFFFF & paramInt | jdField_a_of_type_ArrayOfInt[i] << 24;
          if (i != 0) {
            ((GradientDrawable)arrayOfDrawable[i]).setColor(j);
          } else {
            ((GradientDrawable)arrayOfDrawable[i]).setStroke(2, j);
          }
        }
        i += 1;
      }
    }
  }
  
  public void setHoverHotArea(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.BreatheEffectView
 * JD-Core Version:    0.7.0.1
 */