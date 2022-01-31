package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import vzo;

public class QZoneLayoutTemplateBase
  extends ViewGroup
{
  protected int a;
  protected Drawable a;
  protected int b;
  protected int c;
  protected int d;
  protected int e = -16777216;
  
  public QZoneLayoutTemplateBase(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QZoneLayoutTemplateBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QZoneLayoutTemplateBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = vzo.a(paramContext, 5.0F);
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    paramView.setPadding(this.d, this.d, this.d, this.d);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramView.setBackgroundColor(this.e);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getChildCount();
    if (paramInt1 > 0) {
      getChildAt(0).layout(0, 0, this.b, this.b);
    }
    if (paramInt1 > 1) {
      getChildAt(1).layout(this.b + this.c, 0, this.b * 2 + this.c, this.b);
    }
    if (paramInt1 > 2) {
      getChildAt(2).layout(this.b * 2 + this.c * 2, 0, this.b * 3 + this.c * 2, this.b);
    }
    if (paramInt1 > 3) {
      getChildAt(3).layout(this.b * 3 + this.c * 3, 0, this.jdField_a_of_type_Int, this.b);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = View.MeasureSpec.getSize(paramInt1);
    this.b = ((this.jdField_a_of_type_Int - this.c * 3) / 4);
    paramInt1 = getChildCount();
    if (paramInt1 > 0) {
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(this.b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
    }
    if (paramInt1 > 1) {
      getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec(this.b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
    }
    if (paramInt1 > 2) {
      getChildAt(2).measure(View.MeasureSpec.makeMeasureSpec(this.b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
    }
    if (paramInt1 > 3) {
      getChildAt(3).measure(View.MeasureSpec.makeMeasureSpec(this.b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
    }
    setMeasuredDimension(this.jdField_a_of_type_Int, this.b);
  }
  
  public void setBorderColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setItemBg(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplateBase
 * JD-Core Version:    0.7.0.1
 */