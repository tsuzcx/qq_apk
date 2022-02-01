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
  public static final int HORIZONTAL_SPACE = ViewUtils.b(12.0F);
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
    paramInt1 = 0;
    while (paramInt1 < this.mRowLayoutList.size())
    {
      paramInt4 = getPaddingLeft();
      BubbleViewGroup.WarpLine localWarpLine = (BubbleViewGroup.WarpLine)this.mRowLayoutList.get(paramInt1);
      int k = getMeasuredWidth() - BubbleViewGroup.WarpLine.access$100(localWarpLine);
      paramInt3 = 0;
      while (paramInt3 < BubbleViewGroup.WarpLine.access$200(localWarpLine).size())
      {
        View localView = (View)BubbleViewGroup.WarpLine.access$200(localWarpLine).get(paramInt3);
        int i;
        if (isFull())
        {
          localView.layout(paramInt4, paramInt2, localView.getMeasuredWidth() + paramInt4 + k / BubbleViewGroup.WarpLine.access$200(localWarpLine).size(), localView.getMeasuredHeight() + paramInt2);
          i = localView.getMeasuredWidth() + HORIZONTAL_SPACE;
        }
        for (int j = k / BubbleViewGroup.WarpLine.access$200(localWarpLine).size();; j = HORIZONTAL_SPACE)
        {
          paramInt4 += i + j;
          break;
          i = getGravity();
          if (i != 0)
          {
            if (i != 2)
            {
              localView.layout(paramInt4, paramInt2, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt2);
            }
            else
            {
              i = k / 2 + paramInt4;
              localView.layout(i, paramInt2, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt2);
            }
          }
          else
          {
            i = paramInt4 + k;
            localView.layout(i, paramInt2, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt2);
          }
          i = localView.getMeasuredWidth();
        }
        paramInt3 += 1;
      }
      paramInt2 += BubbleViewGroup.WarpLine.access$400(localWarpLine) + VERTICAL_SPACE;
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i1 = getChildCount();
    measureChildren(paramInt1, paramInt2);
    int j = 0;
    if (i != -2147483648)
    {
      if (i != 0)
      {
        paramInt2 = m;
      }
      else
      {
        paramInt2 = 0;
        paramInt1 = 0;
        while (paramInt2 < i1)
        {
          i = paramInt1;
          if (paramInt2 != 0) {
            i = paramInt1 + HORIZONTAL_SPACE;
          }
          paramInt1 = i + getChildAt(paramInt2).getMeasuredWidth();
          paramInt2 += 1;
        }
        paramInt2 = paramInt1 + (getPaddingLeft() + getPaddingRight());
      }
    }
    else
    {
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt2 < i1)
      {
        i = paramInt1;
        if (paramInt2 != 0) {
          i = paramInt1 + HORIZONTAL_SPACE;
        }
        paramInt1 = i + getChildAt(paramInt2).getMeasuredWidth();
        paramInt2 += 1;
      }
      paramInt2 = getPaddingLeft() + getPaddingRight() + paramInt1;
      if (paramInt2 > m) {
        paramInt2 = m;
      }
    }
    BubbleViewGroup.WarpLine localWarpLine = new BubbleViewGroup.WarpLine(this, null);
    this.mRowLayoutList = new ArrayList();
    paramInt1 = 0;
    while ((paramInt1 < i1) && (this.mRowLayoutList.size() < 3))
    {
      if (BubbleViewGroup.WarpLine.access$100(localWarpLine) + getChildAt(paramInt1).getMeasuredWidth() + HORIZONTAL_SPACE > paramInt2)
      {
        if (BubbleViewGroup.WarpLine.access$200(localWarpLine).size() == 0)
        {
          BubbleViewGroup.WarpLine.access$300(localWarpLine, getChildAt(paramInt1));
          this.mRowLayoutList.add(localWarpLine);
          localWarpLine = new BubbleViewGroup.WarpLine(this, null);
        }
        else
        {
          this.mRowLayoutList.add(localWarpLine);
          localWarpLine = new BubbleViewGroup.WarpLine(this, null);
          BubbleViewGroup.WarpLine.access$300(localWarpLine, getChildAt(paramInt1));
        }
      }
      else {
        BubbleViewGroup.WarpLine.access$300(localWarpLine, getChildAt(paramInt1));
      }
      paramInt1 += 1;
    }
    if ((BubbleViewGroup.WarpLine.access$200(localWarpLine).size() > 0) && (!this.mRowLayoutList.contains(localWarpLine)) && (this.mRowLayoutList.size() < 3)) {
      this.mRowLayoutList.add(localWarpLine);
    }
    paramInt1 = getPaddingTop() + getPaddingBottom();
    i = j;
    while (i < this.mRowLayoutList.size())
    {
      j = paramInt1;
      if (i != 0) {
        j = paramInt1 + VERTICAL_SPACE;
      }
      paramInt1 = j + BubbleViewGroup.WarpLine.access$400((BubbleViewGroup.WarpLine)this.mRowLayoutList.get(i));
      i += 1;
    }
    if (n != -2147483648) {
      if (n != 0)
      {
        i = k;
        if (n == 1073741824) {
          break label498;
        }
      }
    }
    while (paramInt1 <= k)
    {
      i = paramInt1;
      break;
    }
    i = k;
    label498:
    setMeasuredDimension(paramInt2, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.widget.BubbleViewGroup
 * JD-Core Version:    0.7.0.1
 */