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
  
  public TkdConstraintWidthLayout$LayoutParams(TkdConstraintWidthLayout paramTkdConstraintWidthLayout, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public TkdConstraintWidthLayout$LayoutParams(TkdConstraintWidthLayout paramTkdConstraintWidthLayout, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramInt1, paramInt2, paramFloat);
  }
  
  public TkdConstraintWidthLayout$LayoutParams(TkdConstraintWidthLayout paramTkdConstraintWidthLayout, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramTkdConstraintWidthLayout = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.jdField_a_of_type_ArrayOfInt);
    this.constrainedWidth = paramTkdConstraintWidthLayout.getBoolean(R.styleable.jdField_a_of_type_Int, false);
    paramTkdConstraintWidthLayout.recycle();
  }
  
  public TkdConstraintWidthLayout$LayoutParams(TkdConstraintWidthLayout paramTkdConstraintWidthLayout, ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public TkdConstraintWidthLayout$LayoutParams(TkdConstraintWidthLayout paramTkdConstraintWidthLayout, ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public TkdConstraintWidthLayout$LayoutParams(TkdConstraintWidthLayout paramTkdConstraintWidthLayout, LinearLayout.LayoutParams paramLayoutParams)
  {
    this(paramTkdConstraintWidthLayout, paramLayoutParams);
    this.weight = paramLayoutParams.weight;
    this.gravity = paramLayoutParams.gravity;
  }
  
  public TkdConstraintWidthLayout$LayoutParams(TkdConstraintWidthLayout paramTkdConstraintWidthLayout, LayoutParams paramLayoutParams)
  {
    this(paramTkdConstraintWidthLayout, paramLayoutParams);
    this.constrainedWidth = paramLayoutParams.constrainedWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.widget.TkdConstraintWidthLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */