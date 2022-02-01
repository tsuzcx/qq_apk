package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.qqpay.ui.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class ViewPagerTabLayout
  extends HorizontalScrollView
  implements ViewPager.OnPageChangeListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private ViewPagerTabLayout.OnTabSelectListener jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewPagerTabLayout$OnTabSelectListener;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 1;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private float h;
  private float i;
  private float j;
  private float k;
  
  public ViewPagerTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewPagerTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewPagerTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt, String paramString, View paramView)
  {
    TextView localTextView = (TextView)paramView.getTag();
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    paramView.setOnClickListener(new ViewPagerTabLayout.1(this));
    if (this.jdField_a_of_type_Boolean) {
      paramString = new LinearLayout.LayoutParams(0, -1, 1.0F);
    } else {
      paramString = new LinearLayout.LayoutParams(-2, -1);
    }
    float f1 = this.jdField_c_of_type_Float;
    if (f1 > 0.0F) {
      paramString = new LinearLayout.LayoutParams((int)f1, -1);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramInt, paramString);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setFillViewport(true);
    setWillNotDraw(false);
    setClipChildren(false);
    setClipToPadding(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    b(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    int m = 0;
    while (m < this.jdField_b_of_type_Int)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m).getTag();
      if (localTextView != null)
      {
        if (m == this.jdField_a_of_type_Int) {
          n = this.jdField_d_of_type_Int;
        } else {
          n = this.jdField_e_of_type_Int;
        }
        localTextView.setTextColor(n);
        localTextView.setTextSize(0, this.k);
        float f1 = this.jdField_b_of_type_Float;
        localTextView.setPadding((int)f1, 0, (int)f1, 0);
        int n = this.jdField_f_of_type_Int;
        if (n == 2) {
          localTextView.getPaint().setFakeBoldText(true);
        } else if (n == 0) {
          localTextView.getPaint().setFakeBoldText(false);
        }
      }
      m += 1;
    }
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bS);
    this.jdField_c_of_type_Int = paramContext.getColor(R.styleable.jdField_d_of_type_Int, Color.parseColor("#ffffff"));
    this.jdField_d_of_type_Float = paramContext.getDimension(R.styleable.jdField_f_of_type_Int, -1.0F);
    this.jdField_e_of_type_Float = paramContext.getDimension(R.styleable.jdField_g_of_type_Int, -1.0F);
    this.jdField_f_of_type_Float = paramContext.getDimension(R.styleable.jdField_e_of_type_Int, -1.0F);
    this.k = paramContext.getDimension(R.styleable.l, b(16.0F));
    this.jdField_d_of_type_Int = paramContext.getColor(R.styleable.j, Color.parseColor("#FF2051"));
    this.jdField_e_of_type_Int = paramContext.getColor(R.styleable.k, Color.parseColor("#F5F6FA"));
    this.jdField_c_of_type_Float = paramContext.getDimension(R.styleable.i, a(-1.0F));
    int n = R.styleable.h;
    int m;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Float <= 0.0F)) {
      m = a(15.0F);
    } else {
      m = a(0.0F);
    }
    this.jdField_b_of_type_Float = paramContext.getDimension(n, m);
    paramContext.recycle();
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Int <= 0) {
      return;
    }
    int i1 = (int)(this.jdField_a_of_type_Float * this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).getWidth());
    int n = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).getLeft() + i1;
    int m;
    if (this.jdField_a_of_type_Int <= 0)
    {
      m = n;
      if (i1 <= 0) {}
    }
    else
    {
      m = getWidth() / 2;
      i1 = getPaddingLeft();
      d();
      m = n - (m - i1) + (this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_b_of_type_AndroidGraphicsRect.left) / 2;
    }
    if (m != this.jdField_g_of_type_Int)
    {
      this.jdField_g_of_type_Int = m;
      scrollTo(m, 0);
    }
  }
  
  private void d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int);
    float f4 = ((View)localObject1).getLeft();
    float f3 = ((View)localObject1).getRight();
    int m = this.jdField_a_of_type_Int;
    float f2 = f4;
    float f1 = f3;
    if (m < this.jdField_b_of_type_Int - 1)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m + 1);
      f2 = ((View)localObject2).getLeft();
      f1 = ((View)localObject2).getRight();
      float f5 = this.jdField_a_of_type_Float;
      f2 = f4 + (f2 - f4) * f5;
      f1 = f3 + f5 * (f1 - f3);
    }
    Object localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
    m = (int)f2;
    ((Rect)localObject2).left = m;
    int n = (int)f1;
    ((Rect)localObject2).right = n;
    localObject2 = this.jdField_b_of_type_AndroidGraphicsRect;
    ((Rect)localObject2).left = m;
    ((Rect)localObject2).right = n;
    if (this.jdField_e_of_type_Float < 0.0F) {
      return;
    }
    f2 = ((View)localObject1).getLeft() + (((View)localObject1).getWidth() - this.jdField_e_of_type_Float) / 2.0F;
    m = this.jdField_a_of_type_Int;
    f1 = f2;
    if (m < this.jdField_b_of_type_Int - 1)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m + 1);
      f1 = f2 + this.jdField_a_of_type_Float * (((View)localObject1).getWidth() / 2 + ((View)localObject2).getWidth() / 2);
    }
    localObject1 = this.jdField_a_of_type_AndroidGraphicsRect;
    ((Rect)localObject1).left = ((int)f1);
    ((Rect)localObject1).right = ((int)(((Rect)localObject1).left + this.jdField_e_of_type_Float));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected int a(float paramFloat)
  {
    return (int)(paramFloat * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getAdapter().getCount();
    int m = 0;
    while (m < this.jdField_b_of_type_Int)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setClipChildren(false);
      localRelativeLayout.setClipToPadding(false);
      TextView localTextView = new TextView(getContext());
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getAdapter().getPageTitle(m);
      localRelativeLayout.setTag(localTextView);
      if (localObject != null) {
        a(m, ((CharSequence)localObject).toString(), localRelativeLayout);
      }
      m += 1;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    int m = 0;
    while (m < this.jdField_b_of_type_Int)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
      boolean bool;
      if (m == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = (TextView)((View)localObject).getTag();
      if (localObject != null)
      {
        int n;
        if (bool) {
          n = this.jdField_d_of_type_Int;
        } else {
          n = this.jdField_e_of_type_Int;
        }
        ((TextView)localObject).setTextColor(n);
        if (this.jdField_f_of_type_Int == 1) {
          ((TextView)localObject).getPaint().setFakeBoldText(bool);
        }
      }
      m += 1;
    }
  }
  
  protected int b(float paramFloat)
  {
    return (int)(paramFloat * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!isInEditMode())
    {
      if (this.jdField_b_of_type_Int <= 0) {
        return;
      }
      int m = getHeight();
      int n = getPaddingLeft();
      d();
      if (this.jdField_d_of_type_Float < 0.0F) {
        this.jdField_d_of_type_Float = (m - this.h - this.j);
      }
      float f1 = this.jdField_d_of_type_Float;
      if (f1 > 0.0F)
      {
        float f2 = this.jdField_f_of_type_Float;
        if ((f2 < 0.0F) || (f2 > f1 / 2.0F)) {
          this.jdField_f_of_type_Float = (this.jdField_d_of_type_Float / 2.0F);
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setBounds((int)this.jdField_g_of_type_Float + n + this.jdField_a_of_type_AndroidGraphicsRect.left, (int)this.h, (int)(n + this.jdField_a_of_type_AndroidGraphicsRect.right - this.i), (int)(this.h + this.jdField_d_of_type_Float));
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(this.jdField_f_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Float = paramFloat;
    c();
    invalidate();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" positionOffset:");
      localStringBuilder.append(paramFloat);
      QLog.i("ViewPagerTabLayout", 2, localStringBuilder.toString());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    a(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected:");
      localStringBuilder.append(paramInt);
      QLog.i("ViewPagerTabLayout", 2, localStringBuilder.toString());
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Parcelable localParcelable = paramParcelable;
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.jdField_a_of_type_Int = paramParcelable.getInt("currentTab");
      paramParcelable = paramParcelable.getParcelable("currentState");
      localParcelable = paramParcelable;
      if (this.jdField_a_of_type_Int != 0)
      {
        localParcelable = paramParcelable;
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0)
        {
          a(this.jdField_a_of_type_Int);
          c();
          localParcelable = paramParcelable;
        }
      }
    }
    super.onRestoreInstanceState(localParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("currentState", super.onSaveInstanceState());
    localBundle.putInt("currentTab", this.jdField_a_of_type_Int);
    return localBundle;
  }
  
  public void setBoldStyle(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setCurrentTab(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(paramInt);
  }
  
  public void setCurrentTab(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(paramInt, paramBoolean);
    if (!paramBoolean) {
      onPageScrolled(paramInt, 0.0F, 0);
    }
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setOnTabSelectListener(ViewPagerTabLayout.OnTabSelectListener paramOnTabSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplViewPagerTabLayout$OnTabSelectListener = paramOnTabSelectListener;
  }
  
  public void setScrollOnTabClick(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setTextsize(float paramFloat)
  {
    this.k = b(paramFloat);
    b();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if ((paramViewPager != null) && (paramViewPager.getAdapter() != null))
    {
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(this);
      a();
      return;
    }
    throw new IllegalStateException("ViewPager or it's adapter can not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.ViewPagerTabLayout
 * JD-Core Version:    0.7.0.1
 */