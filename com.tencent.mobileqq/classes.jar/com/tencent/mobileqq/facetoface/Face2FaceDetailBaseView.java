package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.qphone.base.util.QLog;

public abstract class Face2FaceDetailBaseView
  extends RelativeLayout
{
  protected View a;
  protected View b;
  protected View c;
  protected View d;
  protected Face2FaceFriendBubbleView e;
  protected View f;
  protected float g = 1.5F;
  protected int h = 0;
  protected final int i = 8;
  protected final int j = 10;
  protected Canvas k;
  long l = 0L;
  protected boolean m = false;
  protected Face2FaceDetailBaseView.IFace2faceContext n;
  private boolean o = true;
  
  public Face2FaceDetailBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  private AnimationSet a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(-paramInt1, 0.0F, -paramInt2, 0.0F);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, 1.0F, paramFloat2, 1.0F, 1, 0.0F, 1, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator(this.g));
    return localAnimationSet;
  }
  
  private AnimationSet b(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, -paramInt1, 0.0F, -paramInt2);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, paramFloat1, 1.0F, paramFloat2, 1, 0.0F, 1, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator(this.g));
    return localAnimationSet;
  }
  
  private void f()
  {
    this.k = new Canvas();
    this.h = 2130840316;
  }
  
  protected abstract void a();
  
  protected void a(View paramView)
  {
    Object localObject1 = this;
    try
    {
      long l1 = System.currentTimeMillis();
      try
      {
        localObject2 = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
        long l2 = System.currentTimeMillis();
        ((Face2FaceDetailBaseView)localObject1).k.setBitmap((Bitmap)localObject2);
        paramView.draw(((Face2FaceDetailBaseView)localObject1).k);
        ((Face2FaceDetailBaseView)localObject1).k.drawColor(Color.parseColor("#70000000"), PorterDuff.Mode.DARKEN);
        long l3 = System.currentTimeMillis();
        paramView = Bitmap.createScaledBitmap((Bitmap)localObject2, ((Bitmap)localObject2).getWidth() / 10, ((Bitmap)localObject2).getHeight() / 10, true);
        if (localObject2 != null) {
          try
          {
            if (!((Bitmap)localObject2).isRecycled()) {
              ((Bitmap)localObject2).recycle();
            }
          }
          catch (Exception paramView)
          {
            break label309;
          }
        }
        long l4 = System.currentTimeMillis();
        StackBlur.a(paramView, 8);
        long l5 = System.currentTimeMillis();
        if (paramView != null)
        {
          localObject1 = ((Face2FaceDetailBaseView)localObject1).c;
          try
          {
            ((View)localObject1).setBackgroundDrawable(new BitmapDrawable(getResources(), paramView));
          }
          catch (Exception paramView)
          {
            break label309;
          }
          catch (OutOfMemoryError paramView)
          {
            break label297;
          }
        }
        try
        {
          ((Face2FaceDetailBaseView)localObject1).c.setBackgroundResource(((Face2FaceDetailBaseView)localObject1).h);
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("blurBackground, createEmptyBmp=");
            paramView.append(l2 - l1);
            paramView.append(", drawBmp=");
            paramView.append(l3 - l2);
            paramView.append(", scale-recyle=");
            paramView.append(l4 - l3);
            paramView.append(", blur=");
            paramView.append(l5 - l4);
            paramView.append(" total=");
            paramView.append(l5 - l1);
            QLog.d("Face2FaceDetailBaseView", 2, paramView.toString());
          }
          return;
        }
        catch (Exception paramView) {}catch (OutOfMemoryError paramView) {}
        label297:
        localObject1 = "blurBackground:";
      }
      catch (OutOfMemoryError paramView) {}
      label309:
      localObject1 = "blurBackground:";
    }
    catch (Exception paramView)
    {
      localObject1 = this;
      ((Face2FaceDetailBaseView)localObject1).c.setBackgroundResource(((Face2FaceDetailBaseView)localObject1).h);
      if (!QLog.isColorLevel()) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("blurBackground:");
      ((StringBuilder)localObject1).append(paramView.toString());
      QLog.e("Face2FaceDetailBaseView", 2, ((StringBuilder)localObject1).toString());
      return;
    }
    catch (OutOfMemoryError paramView) {}
    Object localObject2 = this;
    ((Face2FaceDetailBaseView)localObject2).c.setBackgroundResource(((Face2FaceDetailBaseView)localObject2).h);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramView.toString());
      QLog.e("Face2FaceDetailBaseView", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(View paramView, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView)
  {
    this.l = System.currentTimeMillis();
    this.n.b();
    this.d = paramView;
    this.e = paramFace2FaceFriendBubbleView;
    a(this.d);
    b();
  }
  
  protected void b()
  {
    long l1 = System.currentTimeMillis();
    this.m = true;
    this.o = true;
    this.a.clearAnimation();
    setVisibility(0);
    Object localObject1 = this.e.findViewById(2131433779);
    Object localObject2 = this.e.findViewById(2131433780);
    int i1 = this.a.getLeft();
    int i2 = ((View)localObject1).getLeft();
    int i3 = ((View)localObject2).getLeft();
    int i4 = this.e.getLeft();
    int i5 = this.a.getTop();
    int i6 = ((View)localObject1).getTop();
    int i7 = ((View)localObject2).getTop();
    int i8 = this.e.getTop();
    float f1 = ((View)localObject1).getWidth() * 1.0F / this.a.getWidth();
    localObject1 = a(i1 - (i2 + i3 + i4), i5 - (i6 + i7 + i8), f1, f1);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AlphaAnimation)localObject2).setStartOffset(150L);
    ((AlphaAnimation)localObject2).setAnimationListener(new Face2FaceDetailBaseView.1(this));
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation1.setStartOffset(350L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation2.setStartOffset(350L);
    this.e.a();
    this.c.startAnimation((Animation)localObject2);
    this.a.startAnimation((Animation)localObject1);
    this.b.startAnimation(localAlphaAnimation1);
    this.f.startAnimation(localAlphaAnimation2);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("animShow: totalTime=");
      ((StringBuilder)localObject1).append(l2 - this.l);
      ((StringBuilder)localObject1).append(",blurAndVisiableTime:");
      ((StringBuilder)localObject1).append(l1 - this.l);
      ((StringBuilder)localObject1).append(",buildAnimTime:");
      ((StringBuilder)localObject1).append(l2 - l1);
      ((StringBuilder)localObject1).append("");
      QLog.d("Face2FaceDetailBaseView", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected void c()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("animHide, isAnimHideEnd=");
      ((StringBuilder)localObject1).append(this.o);
      QLog.d("Face2FaceDetailBaseView", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.o) {
      return;
    }
    this.o = false;
    this.m = false;
    Object localObject1 = this.e.findViewById(2131433779);
    Object localObject2 = this.e.findViewById(2131433780);
    int i1 = this.a.getLeft();
    int i2 = ((View)localObject1).getLeft();
    int i3 = ((View)localObject2).getLeft();
    int i4 = this.e.getLeft();
    int i5 = this.a.getTop();
    int i6 = ((View)localObject1).getTop();
    int i7 = ((View)localObject2).getTop();
    int i8 = this.e.getTop();
    float f1 = ((View)localObject1).getWidth() * 1.0F / this.a.getWidth();
    localObject1 = b(i1 - (i2 + i3 + i4), i5 - (i6 + i7 + i8), f1, f1);
    this.n.d();
    ((AnimationSet)localObject1).setAnimationListener(new Face2FaceDetailBaseView.2(this));
    localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AlphaAnimation)localObject2).setFillAfter(true);
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation1.setFillAfter(true);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation2.setFillAfter(true);
    this.c.startAnimation((Animation)localObject2);
    this.b.startAnimation(localAlphaAnimation1);
    this.a.startAnimation((Animation)localObject1);
    this.f.startAnimation(localAlphaAnimation2);
  }
  
  public boolean d()
  {
    return this.m;
  }
  
  public boolean e()
  {
    c();
    return true;
  }
  
  public View getHeadView()
  {
    return this.a;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
    this.c = new View(getContext());
    addView(this.c, 0, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  public void setInfc(Face2FaceDetailBaseView.IFace2faceContext paramIFace2faceContext)
  {
    this.n = paramIFace2faceContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView
 * JD-Core Version:    0.7.0.1
 */