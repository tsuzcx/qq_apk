package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

public class CardView
  extends RelativeLayout
{
  protected final int a;
  protected final int b;
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    new DisplayMetrics();
    paramContext = super.getResources().getDisplayMetrics();
    this.a = paramContext.widthPixels;
    this.b = paramContext.heightPixels;
  }
  
  protected float a()
  {
    return 2.214984F;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < super.getChildCount())
    {
      super.getChildAt(paramInt1).layout(0, 0, getWidth(), getHeight());
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f1 = this.a;
    float f2 = f1 / a();
    super.setMeasuredDimension((int)f1, (int)f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.CardView
 * JD-Core Version:    0.7.0.1
 */