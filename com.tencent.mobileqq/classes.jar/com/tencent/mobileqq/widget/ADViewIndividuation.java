package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ADViewIndividuation
  extends ADView
{
  private int a = 0;
  
  public ADViewIndividuation(Context paramContext)
  {
    super(paramContext);
    this.A = 8;
    this.B = 18;
    this.v = 2130848911;
    this.w = this.v;
  }
  
  public ADViewIndividuation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.A = 4;
    this.B = 8;
    this.v = 2130848911;
    this.w = this.v;
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    setNavVisible(this.a, false);
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 100000);
    localLayoutParams.addRule(7, 100000);
    localLayoutParams.setMargins(0, 0, 0, (int)(this.z * 6.0F));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setPadding((int)(this.z * 4.0F), 0, (int)(this.z * 2.0F), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public void setNavVisible(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      return;
    }
    Object localObject = (ViewGroup)this.x.getChildAt(0);
    if (localObject != null)
    {
      localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
      if (localObject != null)
      {
        if (paramInt > 0) {
          paramInt = 0;
        } else {
          paramInt = 8;
        }
        ((LinearLayout)localObject).setVisibility(paramInt);
        if (paramBoolean) {
          this.a = 0;
        }
        return;
      }
    }
    if (paramBoolean) {
      this.a = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADViewIndividuation
 * JD-Core Version:    0.7.0.1
 */