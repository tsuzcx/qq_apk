package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.widget.ScrollView;

public class NestedScrollView
  extends ScrollView
{
  public NestedScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setClipChildren(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.NestedScrollView
 * JD-Core Version:    0.7.0.1
 */