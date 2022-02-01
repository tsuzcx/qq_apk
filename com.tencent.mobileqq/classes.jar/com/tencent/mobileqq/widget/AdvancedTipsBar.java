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
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    e();
  }
  
  protected void d()
  {
    super.d();
    if (this.c != null)
    {
      this.c.setId(2131447455);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.rightMargin = ViewUtils.dip2px(16.0F);
      this.c.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void e()
  {
    super.e();
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.d != null)
    {
      this.d.setId(2131447454);
      localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = ViewUtils.dip2px(44.0F);
      int i;
      if (!QQTheme.isNowThemeIsNight()) {
        i = Color.parseColor("#4D94FF");
      } else {
        i = Color.parseColor("#0071FF");
      }
      this.d.setTextColor(i);
      this.d.setLayoutParams(localLayoutParams);
    }
    if (this.a != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.addRule(0, 2131447454);
      this.a.setLayoutParams(localLayoutParams);
    }
  }
  
  public void f()
  {
    int i;
    if (!QQTheme.isNowThemeIsNight()) {
      i = Color.parseColor("#03081A");
    } else {
      i = Color.parseColor("#FFFFFF");
    }
    this.a.setTextColor(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AdvancedTipsBar
 * JD-Core Version:    0.7.0.1
 */