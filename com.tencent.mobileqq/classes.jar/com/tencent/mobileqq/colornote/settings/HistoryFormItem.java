package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import aoeo;
import aoep;
import bdaq;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class HistoryFormItem
  extends FormSimpleItem
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private aoep jdField_a_of_type_Aoep;
  private boolean d;
  private boolean e = true;
  
  public HistoryFormItem(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public HistoryFormItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setBackgroundResource(2130849749);
      return;
    }
    setBgType(2);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839080);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839079);
  }
  
  private void d()
  {
    e();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131690928));
    c(this.d);
    int i = getResources().getDimensionPixelSize(2131298703);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(11, 1);
    localLayoutParams.addRule(15, 1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aoeo(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    b(paramBoolean);
    c(paramBoolean);
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void b()
  {
    super.b();
    this.o = bdaq.a(getContext(), 290.0F);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.d = paramBoolean;
    a(this.jdField_a_of_type_AndroidWidgetImageView, paramBoolean);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setIndex(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setItemLeftText(CharSequence paramCharSequence)
  {
    setLeftText(paramCharSequence);
  }
  
  public void setItemOnClickListener(View.OnClickListener paramOnClickListener)
  {
    setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftIconResource(int paramInt)
  {
    if (paramInt != 0) {
      setLeftIcon(getResources().getDrawable(paramInt));
    }
  }
  
  public void setOnIconClickListener(aoep paramaoep)
  {
    this.jdField_a_of_type_Aoep = paramaoep;
  }
  
  public void setRightIconResource(int paramInt)
  {
    if (paramInt != 0) {
      setRightIcon(getResources().getDrawable(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.HistoryFormItem
 * JD-Core Version:    0.7.0.1
 */