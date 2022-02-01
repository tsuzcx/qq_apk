package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import bkpj;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;

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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bkpj.a("FlowLayout.onLayout");
    int k = getWidth();
    paramInt3 = 0;
    paramInt2 = 0;
    int m = getChildCount();
    paramInt4 = 0;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 8) {
        paramInt1 = paramInt2;
      }
      int n;
      for (paramInt2 = paramInt4;; paramInt2 = paramInt2 + n + paramInt4)
      {
        i += 1;
        paramInt4 = paramInt2;
        paramInt2 = paramInt1;
        break;
        int i1 = localView.getMeasuredWidth();
        n = localView.getMeasuredHeight();
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        paramInt1 = paramInt2;
        int j = paramInt3;
        if (localMarginLayoutParams.leftMargin + paramInt3 + i1 + localMarginLayoutParams.rightMargin > k)
        {
          paramInt1 = paramInt2 + paramInt4;
          j = 0;
        }
        paramInt2 = localMarginLayoutParams.topMargin;
        paramInt4 = localMarginLayoutParams.bottomMargin;
        paramInt3 = localMarginLayoutParams.leftMargin + j;
        int i2 = localMarginLayoutParams.topMargin + paramInt1;
        localView.layout(paramInt3, i2, paramInt3 + i1, n + i2);
        paramInt3 = localMarginLayoutParams.leftMargin;
        paramInt3 = j + (localMarginLayoutParams.rightMargin + (paramInt3 + i1));
      }
    }
    bkpj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FlowLayout
 * JD-Core Version:    0.7.0.1
 */