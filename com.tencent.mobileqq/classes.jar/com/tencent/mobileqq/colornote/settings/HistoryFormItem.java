package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QFormSimpleItem;

public class HistoryFormItem
  extends QFormSimpleItem
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private HistoryFormItem.OnIconClickListener jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem$OnIconClickListener;
  private boolean d = false;
  private boolean e = true;
  private int k = 0;
  
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
      setBackgroundResource(2130850700);
      return;
    }
    setBgType(2);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839248);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839247);
  }
  
  private void d()
  {
    e();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131690916));
    c(this.d);
    int i = getResources().getDimensionPixelSize(2131298960);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(11, 1);
    localLayoutParams.addRule(15, 1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new HistoryFormItem.1(this));
  }
  
  public int a()
  {
    return this.k;
  }
  
  protected void a()
  {
    super.a();
    this.j = DisplayUtil.a(getContext(), 290.0F);
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
  
  public void setEnable(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setIndex(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setItemOnClickListener(View.OnClickListener paramOnClickListener)
  {
    setOnClickListener(paramOnClickListener);
  }
  
  public void setOnIconClickListener(HistoryFormItem.OnIconClickListener paramOnIconClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem$OnIconClickListener = paramOnIconClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.HistoryFormItem
 * JD-Core Version:    0.7.0.1
 */