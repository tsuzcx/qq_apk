package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.mobileqq.R.styleable;
import mvk;

public class HorizontalBallLoadingView
  extends MetaballView
{
  private float a;
  
  public HorizontalBallLoadingView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalBallLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalBallLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int a()
  {
    return (int)(mvk.a(getContext(), 6.0F) * this.a);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.BallLoadingView);
    this.a = paramContext.getFloat(0, 1.0F);
    paramContext.recycle();
  }
  
  protected int b()
  {
    return (int)(mvk.a(getContext(), 10.0F) * this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView
 * JD-Core Version:    0.7.0.1
 */