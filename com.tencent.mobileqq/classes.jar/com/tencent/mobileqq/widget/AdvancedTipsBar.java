package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;

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
  
  public void a() {}
  
  protected void b()
  {
    super.b();
    if (this.b != null)
    {
      this.b.setId(2131378778);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.rightMargin = ViewUtils.a(16.0F);
      this.b.setLayoutParams(localLayoutParams);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    c();
  }
  
  protected void c()
  {
    super.c();
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setId(2131378777);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = ViewUtils.a(44.0F);
      int i;
      if (!QQTheme.a()) {
        i = Color.parseColor("#4D94FF");
      } else {
        i = Color.parseColor("#0071FF");
      }
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(i);
      this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(localLayoutParams);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.addRule(0, 2131378777);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void d()
  {
    int i;
    if (!QQTheme.a()) {
      i = Color.parseColor("#03081A");
    } else {
      i = Color.parseColor("#FFFFFF");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AdvancedTipsBar
 * JD-Core Version:    0.7.0.1
 */