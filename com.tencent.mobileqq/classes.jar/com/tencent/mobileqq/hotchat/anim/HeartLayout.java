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
  public static final int[] a;
  public static Bitmap[] a;
  public static int c;
  public float a;
  public int a;
  public Rect a;
  public HeartAnimator a;
  public HeartLayout.HeartLayoutListener a;
  public Random a;
  public AtomicInteger a;
  public boolean a;
  public float b;
  public int b;
  public boolean b;
  public float c;
  public boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a") };
  }
  
  public HeartLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener;
      if (localObject != null) {
        ((HeartLayout.HeartLayoutListener)localObject).a(this, paramFloat1, paramFloat2);
      }
      return;
    }
    if ((paramFloat1 >= ((Rect)localObject).left) && (paramFloat1 <= this.jdField_a_of_type_AndroidGraphicsRect.right) && (paramFloat2 >= this.jdField_a_of_type_AndroidGraphicsRect.top) && (paramFloat2 <= this.jdField_a_of_type_AndroidGraphicsRect.bottom))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener;
      if (localObject != null) {
        ((HeartLayout.HeartLayoutListener)localObject).a(this, paramFloat1, paramFloat2);
      }
    }
  }
  
  public HeartAnimator.Config a()
  {
    HeartAnimator localHeartAnimator = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator;
    if (localHeartAnimator != null) {
      return localHeartAnimator.a();
    }
    return null;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Float = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 5);
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator = new HeartAnimator(this);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a(this);
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
    HeartLayout.HeartLayoutListener localHeartLayoutListener = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener;
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
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator != null)
    {
      if (paramBitmap == null) {
        return;
      }
      if (paramPraiseInfo != null)
      {
        if (paramBitmap == paramPraiseInfo.c) {
          localObject1 = paramPraiseInfo.g;
        }
        for (paramPraiseInfo = paramPraiseInfo.c;; paramPraiseInfo = paramPraiseInfo.b)
        {
          localObject2 = localObject1;
          localObject1 = paramPraiseInfo;
          paramPraiseInfo = (PraiseInfo)localObject2;
          break label84;
          if (paramBitmap != paramPraiseInfo.b) {
            break;
          }
          localObject1 = paramPraiseInfo.f;
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
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
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
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a((View)localObject2, paramFloat1, paramFloat2, this, paramLong, paramInt);
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo, Bitmap paramBitmap, QQAppInterface paramQQAppInterface, BaseFloatViewBuilder paramBaseFloatViewBuilder, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator == null) {
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
        if (paramBitmap == paramPraiseInfo.c) {
          paramQQAppInterface = paramPraiseInfo.g;
        }
        for (paramPraiseInfo = paramPraiseInfo.c;; paramPraiseInfo = paramPraiseInfo.b)
        {
          paramBaseFloatViewBuilder = paramQQAppInterface;
          paramQQAppInterface = paramPraiseInfo;
          paramPraiseInfo = paramBaseFloatViewBuilder;
          break label169;
          if (paramBitmap != paramPraiseInfo.b) {
            break;
          }
          paramQQAppInterface = paramPraiseInfo.f;
        }
      }
      paramQQAppInterface = null;
      paramPraiseInfo = paramQQAppInterface;
      label169:
      if (paramPraiseInfo != null)
      {
        paramBaseFloatViewBuilder = new StringBuilder();
        paramBaseFloatViewBuilder.append("praise?seed=");
        paramBaseFloatViewBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
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
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a(localRelativeLayout, paramFloat1, paramFloat2, paramInt1, paramInt2, this, -1L, 0);
    }
  }
  
  public void b(Animation paramAnimation)
  {
    HeartLayout.HeartLayoutListener localHeartLayoutListener = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener;
    if (localHeartLayoutListener != null) {
      localHeartLayoutListener.b(paramAnimation);
    }
  }
  
  public void clearAnimation()
  {
    super.clearAnimation();
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = 0;
    while (i < super.getChildCount())
    {
      super.getChildAt(i).clearAnimation();
      i += 1;
    }
    super.removeAllViews();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = super.getMeasuredWidth();
    this.jdField_b_of_type_Int = super.getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (!super.isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if ((float)Math.sqrt(Math.pow(f1 - this.jdField_a_of_type_Float, 2.0D) + Math.pow(f2 - this.jdField_b_of_type_Float, 2.0D)) <= this.jdField_c_of_type_Float)
        {
          a(paramMotionEvent.getX(), paramMotionEvent.getY());
          return true;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Boolean = true;
    }
    return true;
  }
  
  public void setAnimator(HeartAnimator paramHeartAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator = paramHeartAnimator;
  }
  
  public void setCanDoAnim(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (Build.VERSION.SDK_INT < 11) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = super.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = getChildAt(i);
        if (localView != null)
        {
          Boolean localBoolean = (Boolean)localView.getTag(2131374208);
          if ((localBoolean != null) && (localBoolean.booleanValue()))
          {
            localView.clearAnimation();
            super.removeView(localView);
          }
        }
        i -= 1;
      }
    }
  }
  
  public void setHeartListener(HeartLayout.HeartLayoutListener paramHeartLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener = paramHeartLayoutListener;
  }
  
  public void setListenTouchEvent(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setRandom(Random paramRandom)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
  }
  
  public void setSpecialHeart(int paramInt, Set<String> paramSet)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt >= 0) {
      jdField_c_of_type_Int = paramInt;
    }
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[paramSet.size()];
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
        jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[paramInt] = BitmapFactory.decodeFile(str);
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
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void setValidRect(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartLayout
 * JD-Core Version:    0.7.0.1
 */