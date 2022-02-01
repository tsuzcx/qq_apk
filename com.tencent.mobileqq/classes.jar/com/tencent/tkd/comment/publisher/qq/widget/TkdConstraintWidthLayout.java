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
    return new TkdConstraintWidthLayout.LayoutParams(-2, -2);
  }
  
  public LinearLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new TkdConstraintWidthLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new TkdConstraintWidthLayout.LayoutParams(paramLayoutParams);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getChildCount();
    paramInt1 = 0;
    Object localObject1 = null;
    paramInt2 = 0;
    while (paramInt1 < i)
    {
      View localView = getChildAt(paramInt1);
      TkdConstraintWidthLayout.LayoutParams localLayoutParams = (TkdConstraintWidthLayout.LayoutParams)localView.getLayoutParams();
      Object localObject2 = localObject1;
      if (localLayoutParams.constrainedWidth) {
        if (localObject1 == null) {
          localObject2 = localView;
        } else {
          throw new IllegalStateException("count of constrained children must be less than 1");
        }
      }
      paramInt2 += localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
      paramInt1 += 1;
      localObject1 = localObject2;
    }
    if ((paramInt2 > getMeasuredWidth()) && (localObject1 != null)) {
      localObject1.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - (paramInt2 - localObject1.getMeasuredWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(localObject1.getMeasuredHeight(), 1073741824));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.widget.TkdConstraintWidthLayout
 * JD-Core Version:    0.7.0.1
 */