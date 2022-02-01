package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class LabelViewItem
  extends TextView
{
  public LabelViewItem(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public LabelViewItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public LabelViewItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setBackgroundResource(2130845848);
    setTextSize(2, 11.0F);
    setTextColor(Color.parseColor("#ffaf4efb"));
    int i = a(8.0F);
    int j = a(3.0F);
    setPadding(i, j, i, j);
    setGravity(17);
  }
  
  public int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.LabelViewItem
 * JD-Core Version:    0.7.0.1
 */