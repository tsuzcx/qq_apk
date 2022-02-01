package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.Switch;

public class FormSwitchSimpleItem
  extends FormSwitchItem
{
  private TextView a;
  
  public FormSwitchSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSwitchSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    if (this.a == null)
    {
      this.a = new TextView(getContext());
      this.a.setTextSize(2, 14.0F);
      this.a.setTextColor(getResources().getColorStateList(2131168133));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = getResources().getDimensionPixelSize(2131297718);
      localLayoutParams.addRule(0, this.d.getId());
      localLayoutParams.addRule(15);
      addView(this.a, localLayoutParams);
    }
  }
  
  public TextView getRightText()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSwitchSimpleItem
 * JD-Core Version:    0.7.0.1
 */