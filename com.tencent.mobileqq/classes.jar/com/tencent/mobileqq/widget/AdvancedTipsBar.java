package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bkpg;
import com.tencent.common.app.BaseApplicationImpl;
import zlx;

public class AdvancedTipsBar
  extends TipsBar
{
  public AdvancedTipsBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdvancedTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (!bkpg.a()) {}
    for (int i = Color.parseColor("#03081A");; i = Color.parseColor("#FFFFFF"))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    d();
  }
  
  public void b() {}
  
  protected void c()
  {
    super.c();
    if (this.b != null)
    {
      this.b.setId(2131378770);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.rightMargin = zlx.a(BaseApplicationImpl.context, 16.0F);
      this.b.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void d()
  {
    super.d();
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setId(2131378769);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = zlx.a(BaseApplicationImpl.context, 44.0F);
      if (bkpg.a()) {
        break label110;
      }
    }
    label110:
    for (int i = Color.parseColor("#4D94FF");; i = Color.parseColor("#0071FF"))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(i);
      this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(localLayoutParams);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        localLayoutParams.addRule(0, 2131378769);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AdvancedTipsBar
 * JD-Core Version:    0.7.0.1
 */