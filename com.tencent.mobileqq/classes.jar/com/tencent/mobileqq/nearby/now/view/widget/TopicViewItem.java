package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class TopicViewItem
  extends TextView
{
  public TopicViewItem(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TopicViewItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TopicViewItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    int i = a(8.0F);
    setPadding(i, 0, i, 0);
    setGravity(17);
  }
  
  public int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.TopicViewItem
 * JD-Core Version:    0.7.0.1
 */