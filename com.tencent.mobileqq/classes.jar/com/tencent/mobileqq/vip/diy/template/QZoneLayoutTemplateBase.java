package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;

public class QZoneLayoutTemplateBase
  extends ViewGroup
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e = -16777216;
  protected Drawable f;
  
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
    this.c = UIUtils.a(paramContext, 5.0F);
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    int i = this.d;
    paramView.setPadding(i, i, i, i);
    Drawable localDrawable = this.f;
    if (localDrawable != null)
    {
      paramView.setBackgroundDrawable(localDrawable);
      return;
    }
    paramView.setBackgroundColor(this.e);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getChildCount();
    View localView;
    if (paramInt1 > 0)
    {
      localView = getChildAt(0);
      paramInt2 = this.b;
      localView.layout(0, 0, paramInt2, paramInt2);
    }
    if (paramInt1 > 1)
    {
      localView = getChildAt(1);
      paramInt2 = this.b;
      paramInt3 = this.c;
      localView.layout(paramInt2 + paramInt3, 0, paramInt2 * 2 + paramInt3, paramInt2);
    }
    if (paramInt1 > 2)
    {
      localView = getChildAt(2);
      paramInt2 = this.b;
      paramInt3 = this.c;
      localView.layout(paramInt2 * 2 + paramInt3 * 2, 0, paramInt2 * 3 + paramInt3 * 2, paramInt2);
    }
    if (paramInt1 > 3)
    {
      localView = getChildAt(3);
      paramInt1 = this.b;
      localView.layout(paramInt1 * 3 + this.c * 3, 0, this.a, paramInt1);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a = View.MeasureSpec.getSize(paramInt1);
    this.b = ((this.a - this.c * 3) / 4);
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
    setMeasuredDimension(this.a, this.b);
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
    this.f = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplateBase
 * JD-Core Version:    0.7.0.1
 */