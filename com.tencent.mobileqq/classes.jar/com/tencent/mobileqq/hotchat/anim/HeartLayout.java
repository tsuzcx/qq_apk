package com.tencent.mobileqq.hotchat.anim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder.AnimationView;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

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
    a();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener.a(this, paramFloat1, paramFloat2);
      }
    }
    while ((paramFloat1 < this.jdField_a_of_type_AndroidGraphicsRect.left) || (paramFloat1 > this.jdField_a_of_type_AndroidGraphicsRect.right) || (paramFloat2 < this.jdField_a_of_type_AndroidGraphicsRect.top) || (paramFloat2 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) || (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener.a(this, paramFloat1, paramFloat2);
  }
  
  public HeartAnimator.Config a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator != null) {
      return this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a();
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
    a(paramBitmap, paramFloat1, paramFloat2, -1L, 0);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, long paramLong, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator == null) || (paramBitmap == null)) {
      return;
    }
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a(localImageView, paramFloat1, paramFloat2, this, paramLong, paramInt);
  }
  
  public void a(Bitmap paramBitmap, QQAppInterface paramQQAppInterface, BaseFloatViewBuilder paramBaseFloatViewBuilder, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator == null)) {
      return;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    paramQQAppInterface = new PayLikeFloatViewBuilder.AnimationView(getContext(), paramQQAppInterface, paramBaseFloatViewBuilder);
    paramBaseFloatViewBuilder = new ImageView(getContext());
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(13);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams2.addRule(13);
    localRelativeLayout.addView(paramBaseFloatViewBuilder, localLayoutParams1);
    localRelativeLayout.addView(paramQQAppInterface, localLayoutParams2);
    paramBaseFloatViewBuilder.setImageBitmap(paramBitmap);
    paramBaseFloatViewBuilder.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a(localRelativeLayout, paramFloat1, paramFloat2, paramInt1, paramInt2, this, -1L, 0);
  }
  
  public void a(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener.a(paramAnimation);
    }
  }
  
  public void b(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout$HeartLayoutListener.b(paramAnimation);
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
    boolean bool2 = false;
    boolean bool1;
    if (!this.jdField_c_of_type_Boolean) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.jdField_a_of_type_Boolean);
      bool1 = bool2;
    } while (!super.isEnabled());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Boolean = true;
      continue;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        double d = Math.pow(f1 - this.jdField_a_of_type_Float, 2.0D);
        if ((float)Math.sqrt(Math.pow(f2 - this.jdField_b_of_type_Float, 2.0D) + d) <= this.jdField_c_of_type_Float) {
          a(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
    }
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
      if (i >= 0)
      {
        View localView = getChildAt(i);
        if (localView == null) {}
        for (;;)
        {
          i -= 1;
          break;
          Boolean localBoolean = (Boolean)localView.getTag(2131362176);
          if ((localBoolean != null) && (localBoolean.booleanValue()))
          {
            localView.clearAnimation();
            super.removeView(localView);
          }
        }
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
  
  public void setSpecialHeart(int paramInt, Set paramSet)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (paramInt >= 0) {
        jdField_c_of_type_Int = paramInt;
      }
    } while ((paramSet == null) || (paramSet.size() <= 0));
    jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[paramSet.size()];
    paramSet = paramSet.iterator();
    paramInt = 0;
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[paramInt] = BitmapFactory.decodeFile(str);
        label85:
        paramInt += 1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label85;
      }
    }
  }
  
  public void setValidRect(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartLayout
 * JD-Core Version:    0.7.0.1
 */