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
import bcku;
import bckv;
import bckw;
import bckx;

@SuppressLint({"ResourceAsColor"})
public class CustomedTabWidget
  extends LinearLayout
{
  public float a;
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  public Rect a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public bckw a;
  private bckx jdField_a_of_type_Bckx;
  public boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  public Rect b;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Drawable c;
  
  public CustomedTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)inflate(paramContext, 2131562432, null));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getBackground();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130849265);
    this.c = paramContext.getResources().getDrawable(2130849264);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Bckw = new bckw(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bckx != null) {
        this.jdField_a_of_type_Bckx.a(paramInt);
      }
      getChildAt(this.jdField_b_of_type_Int).setSelected(false);
      this.jdField_b_of_type_Int = paramInt;
      getChildAt(this.jdField_b_of_type_Int).setSelected(true);
      getChildAt(this.jdField_b_of_type_Int).getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
    } while ((this.jdField_a_of_type_AndroidGraphicsRect.left == this.jdField_b_of_type_AndroidGraphicsRect.left) && (this.jdField_a_of_type_AndroidGraphicsRect.right == this.jdField_b_of_type_AndroidGraphicsRect.right));
    this.jdField_a_of_type_Float = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / 4);
    this.jdField_a_of_type_Bckw.sendEmptyMessage(0);
  }
  
  private void a(View paramView)
  {
    paramView.setOnClickListener(new bcku(this));
    paramView.setOnTouchListener(new bckv(this));
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.c.setBounds(0, getHeight() - 6, getWidth(), getHeight());
    this.c.draw(paramCanvas);
    int i = getWidth() / getChildCount();
    int j = this.jdField_b_of_type_AndroidGraphicsRect.centerX() - i / 2;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(j, this.jdField_b_of_type_AndroidGraphicsRect.bottom - (int)(4.0F * this.jdField_b_of_type_Float), i + j, this.jdField_b_of_type_AndroidGraphicsRect.bottom);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  public void setOnSwitchTabListener(bckx parambckx)
  {
    this.jdField_a_of_type_Bckw.removeMessages(0);
    this.jdField_a_of_type_Bckx = parambckx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomedTabWidget
 * JD-Core Version:    0.7.0.1
 */