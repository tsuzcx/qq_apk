package com.tencent.tkd.comment.publisher.qq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class TkdConstraintWidthLayout
  extends LinearLayout
{
  public TkdConstraintWidthLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TkdConstraintWidthLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TkdConstraintWidthLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected LinearLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new TkdConstraintWidthLayout.LayoutParams(this, -2, -2);
  }
  
  public LinearLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new TkdConstraintWidthLayout.LayoutParams(this, getContext(), paramAttributeSet);
  }
  
  protected LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new TkdConstraintWidthLayout.LayoutParams(this, paramLayoutParams);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject1 = null;
    int i = getChildCount();
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt2 < i)
    {
      View localView = getChildAt(paramInt2);
      TkdConstraintWidthLayout.LayoutParams localLayoutParams = (TkdConstraintWidthLayout.LayoutParams)localView.getLayoutParams();
      Object localObject2 = localObject1;
      if (localLayoutParams.constrainedWidth)
      {
        if (localObject1 != null) {
          throw new IllegalStateException("count of constrained children must be less than 1");
        }
        localObject2 = localView;
      }
      int j = localView.getMeasuredWidth();
      int k = localLayoutParams.leftMargin;
      int m = localLayoutParams.rightMargin;
      paramInt2 += 1;
      paramInt1 += m + (j + k);
      localObject1 = localObject2;
    }
    if ((paramInt1 > getMeasuredWidth()) && (localObject1 != null)) {
      localObject1.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - (paramInt1 - localObject1.getMeasuredWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(localObject1.getMeasuredHeight(), 1073741824));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.widget.TkdConstraintWidthLayout
 * JD-Core Version:    0.7.0.1
 */