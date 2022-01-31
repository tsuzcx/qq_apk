package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import auyq;
import auyr;
import auys;
import auyt;
import auyu;
import auyv;
import auyw;
import auyx;
import auyy;
import auyz;
import bbkk;
import bblx;
import bbly;
import bblz;

public class BreatheEffectView
  extends ImageView
  implements bblz
{
  private static int jdField_a_of_type_Int;
  public static final int[] a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
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
    jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131298353);
    setBackgroundResource(2130846487);
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof LayerDrawable))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = ((LayerDrawable)localDrawable);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = new Drawable[3];
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2] = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131363155);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1] = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131363156);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0] = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131363148);
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
      if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(false);
        int i = 0;
        while (i < 3)
        {
          Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i];
          Object localObject2 = new Rect();
          ((Rect)localObject2).left = (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i].left - jdField_a_of_type_Int);
          ((Rect)localObject2).top = (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i].top - jdField_a_of_type_Int);
          ((Rect)localObject2).right = (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i].right + jdField_a_of_type_Int);
          ((Rect)localObject2).bottom = (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i].bottom + jdField_a_of_type_Int);
          localObject2 = new bbkk(this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i], localObject2, new auyq(this, (Drawable)localObject1));
          ((bbkk)localObject2).setStartOffset(i * 180);
          ((bbkk)localObject2).setDuration(600L);
          ((bbkk)localObject2).setInterpolator(new CycleInterpolator(0.5F));
          localObject1 = new bbkk(Integer.valueOf(0), Integer.valueOf(255), new auyr(this, (Drawable)localObject1));
          ((bbkk)localObject1).setInterpolator(new CycleInterpolator(0.5F));
          ((bbkk)localObject1).setStartOffset(i * 180);
          ((bbkk)localObject1).setDuration(600L);
          this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject1);
          if (2 == i) {
            ((bbkk)localObject2).setAnimationListener(new auys(this));
          }
          this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject2);
          i += 1;
        }
      }
      startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    }
  }
  
  public void a(auyz paramauyz)
  {
    int i = 1;
    if (a())
    {
      b();
      f();
      AnimationSet localAnimationSet = new AnimationSet(true);
      while (i < 3)
      {
        Drawable localDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i];
        Object localObject = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i];
        int j = ((Rect)localObject).centerX();
        int k = ((Rect)localObject).centerY();
        localObject = new bbkk(new Rect(j, k, j, k), localObject, null);
        ((bbkk)localObject).a(new auyt(this, localDrawable));
        ((bbkk)localObject).setDuration(400L);
        ((bbkk)localObject).setStartOffset(i * 50);
        localAnimationSet.addAnimation((Animation)localObject);
        i += 1;
      }
      if (paramauyz != null) {
        localAnimationSet.setAnimationListener(new auyu(this, paramauyz));
      }
      localAnimationSet.setInterpolator(new OvershootInterpolator(1.6F));
      startAnimation(localAnimationSet);
    }
  }
  
  public void a(bblx parambblx, bbly parambbly, float paramFloat1, float paramFloat2)
  {
    d();
    a();
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
      bool = this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramFloat1, (int)paramFloat2);
    }
    int i;
    int j;
    int k;
    int m;
    do
    {
      return bool;
      if (this.b == null)
      {
        this.b = new int[2];
        getLocationOnScreen(this.b);
      }
      i = getWidth();
      j = this.b[0];
      k = getHeight();
      m = this.b[1];
    } while ((paramFloat1 >= this.b[0]) && (paramFloat1 <= i + j) && (paramFloat2 >= this.b[1]) && (paramFloat2 <= k + m));
    return false;
  }
  
  public boolean a(bblx parambblx, bbly parambbly, float paramFloat1, float paramFloat2)
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
  
  public void b(auyz paramauyz)
  {
    if (a())
    {
      clearAnimation();
      paramauyz = new AnimationSet(false);
      int i = 1;
      while (i < 3)
      {
        Object localObject = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i];
        Rect localRect = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i];
        int j = localRect.centerX();
        int k = localRect.centerY();
        localObject = new bbkk(localRect, new Rect(j, k, j, k), new auyv(this, (Drawable)localObject));
        ((bbkk)localObject).setDuration(400L);
        paramauyz.addAnimation((Animation)localObject);
        i += 1;
      }
      startAnimation(paramauyz);
    }
  }
  
  public void b(bblx parambblx, bbly parambbly, float paramFloat1, float paramFloat2) {}
  
  public boolean b(bblx parambblx, bbly parambbly, float paramFloat1, float paramFloat2)
  {
    c();
    return true;
  }
  
  public void c()
  {
    if (a())
    {
      AnimationSet localAnimationSet = new AnimationSet(false);
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
        localObject2 = new bbkk(localObject2, localObject3, new auyw(this, (Drawable)localObject1));
        ((bbkk)localObject2).setDuration(800L);
        ((bbkk)localObject2).setInterpolator(new AccelerateInterpolator(0.24F));
        localObject1 = new bbkk(Integer.valueOf(204), Integer.valueOf(0), new auyx(this, (Drawable)localObject1));
        ((bbkk)localObject1).setInterpolator(new AccelerateInterpolator(0.24F));
        ((bbkk)localObject1).setDuration(800L);
        localObject3 = new bbkk(Integer.valueOf(0), Integer.valueOf(0), null);
        ((Animation)localObject3).setDuration(1000L);
        ((Animation)localObject3).setAnimationListener(new auyy(this));
        localAnimationSet.addAnimation((Animation)localObject1);
        localAnimationSet.addAnimation((Animation)localObject2);
        localAnimationSet.addAnimation((Animation)localObject3);
        i += 1;
      }
      startAnimation(localAnimationSet);
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
      if (i < 3)
      {
        int j;
        if ((this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i] instanceof GradientDrawable))
        {
          j = jdField_a_of_type_ArrayOfInt[i] << 24 | 0xFFFFFF & paramInt;
          if (i == 0) {
            break label65;
          }
          ((GradientDrawable)this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i]).setColor(j);
        }
        for (;;)
        {
          i += 1;
          break;
          label65:
          ((GradientDrawable)this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i]).setStroke(2, j);
        }
      }
    }
  }
  
  public void setHoverHotArea(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.BreatheEffectView
 * JD-Core Version:    0.7.0.1
 */