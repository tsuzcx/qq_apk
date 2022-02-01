package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

@SuppressLint({"ResourceAsColor"})
public class CustomedTabWidget
  extends LinearLayout
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  CustomedTabWidget.MyHandler jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$MyHandler;
  private CustomedTabWidget.OnSwitchTabListener jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$OnSwitchTabListener;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Drawable c;
  
  public CustomedTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)inflate(paramContext, 2131563022, null));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getBackground();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130850803);
    this.c = paramContext.getResources().getDrawable(2130850802);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$MyHandler = new CustomedTabWidget.MyHandler(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$OnSwitchTabListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$OnSwitchTabListener.a(paramInt);
      }
      getChildAt(this.jdField_b_of_type_Int).setSelected(false);
      this.jdField_b_of_type_Int = paramInt;
      getChildAt(this.jdField_b_of_type_Int).setSelected(true);
      getChildAt(this.jdField_b_of_type_Int).getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
    } while ((this.jdField_a_of_type_AndroidGraphicsRect.left == this.jdField_b_of_type_AndroidGraphicsRect.left) && (this.jdField_a_of_type_AndroidGraphicsRect.right == this.jdField_b_of_type_AndroidGraphicsRect.right));
    this.jdField_a_of_type_Float = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / 4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$MyHandler.sendEmptyMessage(0);
  }
  
  private void a(View paramView)
  {
    paramView.setOnClickListener(new CustomedTabWidget.1(this));
    paramView.setOnTouchListener(new CustomedTabWidget.2(this));
    if (getChildCount() == 1) {
      paramView.setSelected(true);
    }
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    super.addView(paramView, paramInt);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    super.addView(paramView, paramInt1, paramInt2);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    a(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramLayoutParams);
    a(paramView);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.c.setBounds(0, getHeight() - 6, getWidth(), getHeight());
    this.c.draw(paramCanvas);
    int i = getWidth() / getChildCount();
    int j = this.jdField_b_of_type_AndroidGraphicsRect.centerX() - i / 2;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(j, this.jdField_b_of_type_AndroidGraphicsRect.bottom - (int)(4.0F * this.jdField_b_of_type_Float), i + j, this.jdField_b_of_type_AndroidGraphicsRect.bottom);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getChildAt(this.jdField_b_of_type_Int).getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    setCurrentTab(this.jdField_b_of_type_Int);
  }
  
  public void setCurrentTab(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount())) {
      a(paramInt);
    }
  }
  
  public void setOnSwitchTabListener(CustomedTabWidget.OnSwitchTabListener paramOnSwitchTabListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$MyHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$OnSwitchTabListener = paramOnSwitchTabListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomedTabWidget
 * JD-Core Version:    0.7.0.1
 */