package com.tencent.tkd.comment.publisher.qq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.tkd.comment.publisher.qq.R.styleable;

public class TkdConstraintWidthLayout$LayoutParams
  extends LinearLayout.LayoutParams
{
  boolean constrainedWidth;
  
  public TkdConstraintWidthLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public TkdConstraintWidthLayout$LayoutParams(int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramInt1, paramInt2, paramFloat);
  }
  
  public TkdConstraintWidthLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.a);
    this.constrainedWidth = paramContext.getBoolean(R.styleable.b, false);
    paramContext.recycle();
  }
  
  public TkdConstraintWidthLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public TkdConstraintWidthLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public TkdConstraintWidthLayout$LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this(paramLayoutParams);
    this.weight = paramLayoutParams.weight;
    this.gravity = paramLayoutParams.gravity;
  }
  
  public TkdConstraintWidthLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    this(paramLayoutParams);
    this.constrainedWidth = paramLayoutParams.constrainedWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.widget.TkdConstraintWidthLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */