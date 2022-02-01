package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;
import com.tencent.widget.TraceUtils;

public class FlowLayout
  extends TagFlowLayout
{
  public FlowLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceUtils.traceBegin("FlowLayout.onLayout");
    int k = getWidth();
    int m = getChildCount();
    paramInt4 = 0;
    paramInt2 = 0;
    paramInt3 = 0;
    int i = 0;
    while (paramInt4 < m)
    {
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8)
      {
        paramInt1 = paramInt3;
      }
      else
      {
        int n = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        paramInt1 = paramInt3;
        int j = paramInt2;
        if (localMarginLayoutParams.leftMargin + paramInt2 + n + localMarginLayoutParams.rightMargin > k)
        {
          paramInt1 = paramInt3 + i;
          j = 0;
        }
        i = localMarginLayoutParams.topMargin + i1 + localMarginLayoutParams.bottomMargin;
        paramInt2 = localMarginLayoutParams.leftMargin + j;
        paramInt3 = localMarginLayoutParams.topMargin + paramInt1;
        localView.layout(paramInt2, paramInt3, paramInt2 + n, i1 + paramInt3);
        paramInt2 = j + (localMarginLayoutParams.leftMargin + n + localMarginLayoutParams.rightMargin);
      }
      paramInt4 += 1;
      paramInt3 = paramInt1;
    }
    TraceUtils.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FlowLayout
 * JD-Core Version:    0.7.0.1
 */