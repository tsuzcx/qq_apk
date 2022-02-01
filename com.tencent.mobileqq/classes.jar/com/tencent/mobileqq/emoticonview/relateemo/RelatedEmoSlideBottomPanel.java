package com.tencent.mobileqq.emoticonview.relateemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import assx;
import assy;
import assz;
import asta;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class RelatedEmoSlideBottomPanel
  extends FrameLayout
  implements NestedScrollingParent
{
  private byte jdField_a_of_type_Byte = 0;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private final NestedScrollingParentHelper jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private asta jdField_a_of_type_Asta;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  
  public RelatedEmoSlideBottomPanel(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RelatedEmoSlideBottomPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RelatedEmoSlideBottomPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a(int paramInt)
  {
    float f3 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getY() - paramInt;
    float f4 = paramInt;
    float f1;
    float f2;
    if (f3 > getMeasuredHeight())
    {
      f1 = f4 - (f3 - getMeasuredHeight());
      f2 = getMeasuredHeight();
    }
    for (;;)
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = true;
        if (this.jdField_a_of_type_Asta != null) {
          this.jdField_a_of_type_Asta.a();
        }
      }
      if (this.jdField_a_of_type_Asta != null) {
        this.jdField_a_of_type_Asta.a(f2 - a());
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setY(f2);
      return f1;
      f1 = f4;
      f2 = f3;
      if (f3 < a())
      {
        f1 = f4 - (a() - f3);
        f2 = a();
      }
    }
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt * this.jdField_a_of_type_Float + 0.5F);
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.jdField_a_of_type_Byte = 1;
    }
    while (paramFloat >= 0.0F) {
      return;
    }
    this.jdField_a_of_type_Byte = 2;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawY();
    float f2 = f1 - this.jdField_b_of_type_Float;
    a(f2);
    a((int)(this.jdField_b_of_type_Float - f1));
    this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    this.jdField_d_of_type_Int = ((int)(this.jdField_d_of_type_Int + Math.abs(f2)));
  }
  
  private void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Float = getContext().getResources().getDisplayMetrics().density;
    this.jdField_c_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).height = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if ("2971".equals(ThemeUtil.getCurrentThemeId())) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(a(Color.parseColor("#F5F6FA")));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      int i = a(38);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      localObject = new LinearLayout.LayoutParams(-1, i);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localObject = new FrameLayout.LayoutParams(i, i);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849671);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      setOnClickListener(new assx(this));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new assy(this));
      setVisibility(4);
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849669);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getY() != paramInt)
    {
      a(new float[] { this.jdField_a_of_type_AndroidWidgetLinearLayout.getY(), paramInt });
      this.jdField_a_of_type_Boolean = false;
      a(false);
    }
  }
  
  private void c()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_Asta != null) {
        this.jdField_a_of_type_Asta.b();
      }
    }
    if (this.jdField_b_of_type_Int == 0) {
      throw new IllegalArgumentException("content height is 0 !!!");
    }
    float f = (this.jdField_a_of_type_AndroidWidgetLinearLayout.getY() - a()) * 1.0F / this.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_Byte == 1) && (f > 0.2F))
    {
      b(getMeasuredHeight());
      return;
    }
    b(a());
  }
  
  public int a()
  {
    return getMeasuredHeight() - this.jdField_b_of_type_Int;
  }
  
  public Drawable a(@ColorInt int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadii(new float[] { a(6), a(6), a(6), a(6), 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  public void a()
  {
    post(new RelatedEmoSlideBottomPanel.3(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(true, new float[] { this.jdField_a_of_type_AndroidWidgetLinearLayout.getY(), getMeasuredHeight() });
    }
  }
  
  public void a(boolean paramBoolean, float... paramVarArgs)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "y", paramVarArgs);
    localObjectAnimator.addUpdateListener(new assz(this, paramBoolean, paramVarArgs));
    localObjectAnimator.setDuration(250L).start();
  }
  
  public void a(float... paramVarArgs)
  {
    a(true, paramVarArgs);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.jdField_a_of_type_Boolean)
    {
      return true;
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      Object localObject = new int[2];
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getLocationOnScreen((int[])localObject);
      localObject = new Rect(localObject[0], localObject[1], localObject[0] + this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth(), localObject[1] + this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight());
      boolean bool1 = bool2;
      if (!((Rect)localObject).isEmpty())
      {
        bool1 = bool2;
        if (((Rect)localObject).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          bool1 = true;
        }
      }
      this.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_Boolean) {
        a(true);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("RelatedSlideBottomPanel", 2, "mConsumeTouchEvent : " + this.jdField_a_of_type_Boolean);
        continue;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          a(paramMotionEvent);
          return true;
          this.jdField_b_of_type_Boolean = false;
          if (this.jdField_a_of_type_Boolean)
          {
            if (((this.jdField_d_of_type_Int != 0) || (this.jdField_c_of_type_Boolean)) && ((!this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Int >= this.jdField_c_of_type_Int))) {
              break label295;
            }
            this.jdField_a_of_type_AndroidWidgetFrameLayout.performClick();
          }
          for (;;)
          {
            this.jdField_c_of_type_Boolean = false;
            break;
            label295:
            this.jdField_a_of_type_Int = 3;
            c();
          }
          this.jdField_b_of_type_Boolean = false;
          this.jdField_c_of_type_Boolean = false;
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getNestedScrollAxes()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getY() == a()) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getY() > a()) {
        i = 1;
      }
      if (((paramInt1 != 0) && (!ViewCompat.canScrollVertically(paramView, paramInt2))) || (i != 0))
      {
        a(-paramInt2);
        paramArrayOfInt[1] = ((int)a(paramInt2));
      }
      return;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2;
    float f1;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getY() >= a())
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        f2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getY() - paramInt4;
        if (f2 <= getMeasuredHeight()) {
          break label100;
        }
        f1 = getMeasuredHeight();
      }
    }
    for (;;)
    {
      a(-paramInt4);
      if (this.jdField_a_of_type_Asta != null) {
        this.jdField_a_of_type_Asta.a(f1 - a());
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setY(f1);
      return;
      paramInt1 = 0;
      break;
      label100:
      f1 = f2;
      if (f2 < a()) {
        f1 = a();
      }
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onStopNestedScroll(paramView);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int != 4))
    {
      this.jdField_a_of_type_Int = 3;
      c();
    }
  }
  
  public void setCallback(asta paramasta)
  {
    this.jdField_a_of_type_Asta = paramasta;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    b();
  }
  
  public void setContentView(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, new LinearLayout.LayoutParams(-1, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSlideBottomPanel
 * JD-Core Version:    0.7.0.1
 */