package com.tencent.mobileqq.hotchat.anim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder.AnimationView;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class HeartLayout
  extends RelativeLayout
  implements HeartAnimator.HeartAnimatorListener
{
  public static int f;
  public static Bitmap[] g;
  public static final int[] k = { Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a") };
  public int a;
  public int b;
  public Rect c;
  public HeartAnimator d;
  public Random e;
  public boolean h = true;
  public HeartLayout.HeartLayoutListener i;
  public AtomicInteger j = new AtomicInteger(0);
  public float l;
  public float m;
  public boolean n = false;
  public float o;
  public boolean p = false;
  
  public HeartLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      localObject = this.i;
      if (localObject != null) {
        ((HeartLayout.HeartLayoutListener)localObject).a(this, paramFloat1, paramFloat2);
      }
      return;
    }
    if ((paramFloat1 >= ((Rect)localObject).left) && (paramFloat1 <= this.c.right) && (paramFloat2 >= this.c.top) && (paramFloat2 <= this.c.bottom))
    {
      localObject = this.i;
      if (localObject != null) {
        ((HeartLayout.HeartLayoutListener)localObject).a(this, paramFloat1, paramFloat2);
      }
    }
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.h = false;
      return;
    }
    this.o = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 5);
    this.e = new Random(System.currentTimeMillis());
    this.d = new HeartAnimator(this);
    this.d.a(this);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    a(null, paramBitmap, paramFloat1, paramFloat2, -1L, 0);
  }
  
  public void a(Bitmap paramBitmap, QQAppInterface paramQQAppInterface, BaseFloatViewBuilder paramBaseFloatViewBuilder, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    a(null, paramBitmap, paramQQAppInterface, paramBaseFloatViewBuilder, paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  public void a(Animation paramAnimation)
  {
    HeartLayout.HeartLayoutListener localHeartLayoutListener = this.i;
    if (localHeartLayoutListener != null) {
      localHeartLayoutListener.a(paramAnimation);
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    a(paramPraiseInfo, paramBitmap, paramFloat1, paramFloat2, -1L, 0);
  }
  
  public void a(PraiseInfo paramPraiseInfo, Bitmap paramBitmap, float paramFloat1, float paramFloat2, long paramLong, int paramInt)
  {
    if (!this.h) {
      return;
    }
    if (this.d != null)
    {
      if (paramBitmap == null) {
        return;
      }
      if (paramPraiseInfo != null)
      {
        if (paramBitmap == paramPraiseInfo.j) {
          localObject1 = paramPraiseInfo.l;
        }
        for (paramPraiseInfo = paramPraiseInfo.j;; paramPraiseInfo = paramPraiseInfo.h)
        {
          localObject2 = localObject1;
          localObject1 = paramPraiseInfo;
          paramPraiseInfo = (PraiseInfo)localObject2;
          break label84;
          if (paramBitmap != paramPraiseInfo.h) {
            break;
          }
          localObject1 = paramPraiseInfo.k;
        }
      }
      Object localObject1 = null;
      paramPraiseInfo = (PraiseInfo)localObject1;
      label84:
      Object localObject2 = new URLImageView(getContext());
      if (paramPraiseInfo != null)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("praise?seed=");
        ((StringBuilder)localObject3).append(this.j.getAndIncrement());
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
        Bundle localBundle = new Bundle();
        localBundle.getBoolean("key_use_cache", false);
        paramPraiseInfo = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramPraiseInfo, (String)localObject3, (Drawable)localObject1, new int[] { 14, 9, 15 }, "-praise-", localBundle);
        if (paramPraiseInfo != null)
        {
          ((URLImageView)localObject2).setImageDrawable(paramPraiseInfo);
        }
        else
        {
          QLog.e("HeartLayout", 1, "addHeartWithDrawable apng.so load fail.");
          ((URLImageView)localObject2).setImageBitmap(paramBitmap);
        }
      }
      else
      {
        ((URLImageView)localObject2).setImageBitmap(paramBitmap);
      }
      ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.d.a((View)localObject2, paramFloat1, paramFloat2, this, paramLong, paramInt);
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo, Bitmap paramBitmap, QQAppInterface paramQQAppInterface, BaseFloatViewBuilder paramBaseFloatViewBuilder, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (this.h)
    {
      if (this.d == null) {
        return;
      }
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      paramQQAppInterface = new PayLikeFloatViewBuilder.AnimationView(getContext(), paramQQAppInterface, paramBaseFloatViewBuilder);
      URLImageView localURLImageView = new URLImageView(getContext());
      paramBaseFloatViewBuilder = new RelativeLayout.LayoutParams(-2, -2);
      paramBaseFloatViewBuilder.addRule(13);
      Object localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      localRelativeLayout.addView(localURLImageView, paramBaseFloatViewBuilder);
      localRelativeLayout.addView(paramQQAppInterface, (ViewGroup.LayoutParams)localObject);
      if (paramPraiseInfo != null)
      {
        if (paramBitmap == paramPraiseInfo.j) {
          paramQQAppInterface = paramPraiseInfo.l;
        }
        for (paramPraiseInfo = paramPraiseInfo.j;; paramPraiseInfo = paramPraiseInfo.h)
        {
          paramBaseFloatViewBuilder = paramQQAppInterface;
          paramQQAppInterface = paramPraiseInfo;
          paramPraiseInfo = paramBaseFloatViewBuilder;
          break label169;
          if (paramBitmap != paramPraiseInfo.h) {
            break;
          }
          paramQQAppInterface = paramPraiseInfo.k;
        }
      }
      paramQQAppInterface = null;
      paramPraiseInfo = paramQQAppInterface;
      label169:
      if (paramPraiseInfo != null)
      {
        paramBaseFloatViewBuilder = new StringBuilder();
        paramBaseFloatViewBuilder.append("praise?seed=");
        paramBaseFloatViewBuilder.append(this.j.getAndIncrement());
        paramBaseFloatViewBuilder = paramBaseFloatViewBuilder.toString();
        paramQQAppInterface = new BitmapDrawable(getResources(), paramQQAppInterface);
        localObject = new Bundle();
        ((Bundle)localObject).getBoolean("key_use_cache", false);
        paramPraiseInfo = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramPraiseInfo, paramBaseFloatViewBuilder, paramQQAppInterface, new int[] { 14, 9, 15 }, "-praise-", (Bundle)localObject);
        if (paramPraiseInfo != null)
        {
          localURLImageView.setImageDrawable(paramPraiseInfo);
        }
        else
        {
          QLog.e("HeartLayout", 1, "addHeartWithDrawable apng.so load fail.");
          localURLImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        localURLImageView.setImageBitmap(paramBitmap);
      }
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.d.a(localRelativeLayout, paramFloat1, paramFloat2, paramInt1, paramInt2, this, -1L, 0);
    }
  }
  
  public void b(Animation paramAnimation)
  {
    HeartLayout.HeartLayoutListener localHeartLayoutListener = this.i;
    if (localHeartLayoutListener != null) {
      localHeartLayoutListener.b(paramAnimation);
    }
  }
  
  public void clearAnimation()
  {
    super.clearAnimation();
    if (!this.h) {
      return;
    }
    int i1 = 0;
    while (i1 < super.getChildCount())
    {
      super.getChildAt(i1).clearAnimation();
      i1 += 1;
    }
    super.removeAllViews();
  }
  
  public HeartAnimator getAnimator()
  {
    return this.d;
  }
  
  public HeartAnimator.Config getAnimatorConfig()
  {
    HeartAnimator localHeartAnimator = this.d;
    if (localHeartAnimator != null) {
      return localHeartAnimator.b();
    }
    return null;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.a = super.getMeasuredWidth();
    this.b = super.getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.p) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (!this.h) {
      return false;
    }
    if (!super.isEnabled()) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        return true;
      }
      if (this.n)
      {
        this.n = false;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if ((float)Math.sqrt(Math.pow(f1 - this.l, 2.0D) + Math.pow(f2 - this.m, 2.0D)) <= this.o)
        {
          a(paramMotionEvent.getX(), paramMotionEvent.getY());
          return true;
        }
      }
    }
    else
    {
      this.l = paramMotionEvent.getX();
      this.m = paramMotionEvent.getY();
      this.n = true;
    }
    return true;
  }
  
  public void setAnimator(HeartAnimator paramHeartAnimator)
  {
    this.d = paramHeartAnimator;
  }
  
  public void setCanDoAnim(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (Build.VERSION.SDK_INT < 11) {
      this.h = false;
    }
    if (!this.h)
    {
      int i1 = super.getChildCount() - 1;
      while (i1 >= 0)
      {
        View localView = getChildAt(i1);
        if (localView != null)
        {
          Boolean localBoolean = (Boolean)localView.getTag(2131442303);
          if ((localBoolean != null) && (localBoolean.booleanValue()))
          {
            localView.clearAnimation();
            super.removeView(localView);
          }
        }
        i1 -= 1;
      }
    }
  }
  
  public void setHeartListener(HeartLayout.HeartLayoutListener paramHeartLayoutListener)
  {
    this.i = paramHeartLayoutListener;
  }
  
  public void setListenTouchEvent(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setRandom(Random paramRandom)
  {
    this.e = paramRandom;
  }
  
  public void setSpecialHeart(int paramInt, Set<String> paramSet)
  {
    if (!this.h) {
      return;
    }
    if (paramInt >= 0) {
      f = paramInt;
    }
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      g = new Bitmap[paramSet.size()];
      paramSet = paramSet.iterator();
      paramInt = 0;
    }
    for (;;)
    {
      String str;
      if (paramSet.hasNext())
      {
        str = (String)paramSet.next();
        if (TextUtils.isEmpty(str)) {}
      }
      try
      {
        g[paramInt] = BitmapFactory.decodeFile(str);
        label85:
        paramInt += 1;
        continue;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label85;
      }
    }
  }
  
  public void setTouchScope(float paramFloat)
  {
    this.o = paramFloat;
  }
  
  public void setValidRect(Rect paramRect)
  {
    this.c = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartLayout
 * JD-Core Version:    0.7.0.1
 */