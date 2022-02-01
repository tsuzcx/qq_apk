package com.tencent.mobileqq.mini.entry.search.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class BubbleViewGroup
  extends ViewGroup
{
  public static final int HORIZONTAL_SPACE = ViewUtils.dpToPx(12.0F);
  public static final int MAX_ROW = 3;
  public static final int VERTICAL_SPACE = HORIZONTAL_SPACE;
  private List<BubbleViewGroup.WarpLine> mRowLayoutList;
  
  public BubbleViewGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public BubbleViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getGravity()
  {
    return 1;
  }
  
  public boolean isFull()
  {
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getPaddingTop();
    paramInt3 = 0;
    while (paramInt3 < this.mRowLayoutList.size())
    {
      paramInt1 = getPaddingLeft();
      BubbleViewGroup.WarpLine localWarpLine = (BubbleViewGroup.WarpLine)this.mRowLayoutList.get(paramInt3);
      int i = getMeasuredWidth() - BubbleViewGroup.WarpLine.access$100(localWarpLine);
      paramInt4 = 0;
      while (paramInt4 < BubbleViewGroup.WarpLine.access$200(localWarpLine).size())
      {
        View localView = (View)BubbleViewGroup.WarpLine.access$200(localWarpLine).get(paramInt4);
        if (isFull())
        {
          localView.layout(paramInt1, paramInt2, localView.getMeasuredWidth() + paramInt1 + i / BubbleViewGroup.WarpLine.access$200(localWarpLine).size(), localView.getMeasuredHeight() + paramInt2);
          paramInt1 += localView.getMeasuredWidth() + HORIZONTAL_SPACE + i / BubbleViewGroup.WarpLine.access$200(localWarpLine).size();
          paramInt4 += 1;
        }
        else
        {
          switch (getGravity())
          {
          case 1: 
          default: 
            localView.layout(paramInt1, paramInt2, localView.getMeasuredWidth() + paramInt1, localView.getMeasuredHeight() + paramInt2);
          }
          for (;;)
          {
            paramInt1 += localView.getMeasuredWidth() + HORIZONTAL_SPACE;
            break;
            localView.layout(paramInt1 + i, paramInt2, paramInt1 + i + localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt2);
            continue;
            localView.layout(i / 2 + paramInt1, paramInt2, i / 2 + paramInt1 + localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt2);
          }
        }
      }
      paramInt1 = BubbleViewGroup.WarpLine.access$400(localWarpLine);
      paramInt4 = VERTICAL_SPACE;
      paramInt3 += 1;
      paramInt2 += paramInt1 + paramInt4;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    int i1 = getChildCount();
    measureChildren(paramInt1, paramInt2);
    paramInt2 = i;
    BubbleViewGroup.WarpLine localWarpLine;
    switch (k)
    {
    default: 
      paramInt2 = i;
    case 1073741824: 
      localWarpLine = new BubbleViewGroup.WarpLine(this, null);
      this.mRowLayoutList = new ArrayList();
      paramInt1 = 0;
      if ((paramInt1 >= i1) || (this.mRowLayoutList.size() >= 3))
      {
        if ((BubbleViewGroup.WarpLine.access$200(localWarpLine).size() > 0) && (!this.mRowLayoutList.contains(localWarpLine)) && (this.mRowLayoutList.size() < 3)) {
          this.mRowLayoutList.add(localWarpLine);
        }
        paramInt1 = getPaddingTop() + getPaddingBottom();
        i = m;
        label186:
        if (i >= this.mRowLayoutList.size()) {
          break label491;
        }
        if (i == 0) {
          break label557;
        }
        paramInt1 += VERTICAL_SPACE;
      }
      break;
    }
    label557:
    for (;;)
    {
      k = BubbleViewGroup.WarpLine.access$400((BubbleViewGroup.WarpLine)this.mRowLayoutList.get(i));
      i += 1;
      paramInt1 += k;
      break label186;
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt2 < i1)
      {
        k = paramInt1;
        if (paramInt2 != 0) {
          k = paramInt1 + HORIZONTAL_SPACE;
        }
        paramInt1 = getChildAt(paramInt2).getMeasuredWidth();
        paramInt2 += 1;
        paramInt1 += k;
      }
      paramInt2 = paramInt1 + (getPaddingLeft() + getPaddingRight());
      paramInt1 = paramInt2;
      if (paramInt2 > i) {
        paramInt1 = i;
      }
      paramInt2 = paramInt1;
      break;
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt2 < i1)
      {
        i = paramInt1;
        if (paramInt2 != 0) {
          i = paramInt1 + HORIZONTAL_SPACE;
        }
        paramInt1 = getChildAt(paramInt2).getMeasuredWidth();
        paramInt2 += 1;
        paramInt1 += i;
      }
      paramInt2 = getPaddingLeft() + getPaddingRight() + paramInt1;
      break;
      if (BubbleViewGroup.WarpLine.access$100(localWarpLine) + getChildAt(paramInt1).getMeasuredWidth() + HORIZONTAL_SPACE > paramInt2) {
        if (BubbleViewGroup.WarpLine.access$200(localWarpLine).size() == 0)
        {
          BubbleViewGroup.WarpLine.access$300(localWarpLine, getChildAt(paramInt1));
          this.mRowLayoutList.add(localWarpLine);
          localWarpLine = new BubbleViewGroup.WarpLine(this, null);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.mRowLayoutList.add(localWarpLine);
        localWarpLine = new BubbleViewGroup.WarpLine(this, null);
        BubbleViewGroup.WarpLine.access$300(localWarpLine, getChildAt(paramInt1));
        continue;
        BubbleViewGroup.WarpLine.access$300(localWarpLine, getChildAt(paramInt1));
      }
      label491:
      i = paramInt1;
      switch (n)
      {
      default: 
        i = paramInt1;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt2, i);
        return;
        i = j;
        continue;
        i = paramInt1;
        if (paramInt1 > j) {
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.widget.BubbleViewGroup
 * JD-Core Version:    0.7.0.1
 */