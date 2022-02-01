package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class BoxShadowLayout
  extends FrameLayout
{
  BoxShadow a;
  View b;
  int c;
  int d;
  
  public BoxShadowLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BoxShadowLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BoxShadowLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.a.getLayoutParams();
    int i = this.d;
    localLayoutParams.leftMargin = (paramInt - (int)(i * 0.5F));
    localLayoutParams.rightMargin = (paramInt - (int)(i * 0.5F));
    localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.leftMargin = paramInt;
    localLayoutParams.rightMargin = paramInt;
    localLayoutParams.bottomMargin = ((int)(this.d * 0.75F));
    this.b.setMinimumHeight(0);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = new BoxShadow(getContext(), paramInt1, paramInt2, paramInt3);
    this.b = paramView;
    this.d = paramInt1;
    paramInt2 = (int)(paramInt1 * 0.5F);
    paramView = new FrameLayout.LayoutParams(-1, -1);
    addView(this.a, paramView);
    paramView = new FrameLayout.LayoutParams(-1, -2);
    paramView.leftMargin = paramInt2;
    paramView.topMargin = 0;
    paramView.rightMargin = paramInt2;
    paramView.bottomMargin = paramInt1;
    addView(this.b, paramView);
  }
  
  public void setScrolling(boolean paramBoolean) {}
  
  public void setShadowColor(int paramInt)
  {
    this.a.setShadowColor(paramInt);
  }
  
  public void setYOffset(int paramInt)
  {
    this.c = paramInt;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.BoxShadowLayout
 * JD-Core Version:    0.7.0.1
 */