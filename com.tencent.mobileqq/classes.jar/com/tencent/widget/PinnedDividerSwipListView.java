package com.tencent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import bese;
import bhtv;
import bhzk;
import bhzl;
import java.util.LinkedList;

public class PinnedDividerSwipListView
  extends SwipListView
  implements bhtv
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bese jdField_a_of_type_Bese;
  private bhtv jdField_a_of_type_Bhtv;
  private bhzk jdField_a_of_type_Bhzk;
  private bhzl jdField_a_of_type_Bhzl;
  private LinkedList<View> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private int b;
  
  public PinnedDividerSwipListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PinnedDividerSwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PinnedDividerSwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  public void addHeaderView(View paramView)
  {
    addHeaderView(paramView, null, false);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addHeaderView(paramView, paramObject, paramBoolean);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.jdField_a_of_type_AndroidViewView, getDrawingTime());
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      i = getFirstVisiblePosition() - this.jdField_a_of_type_JavaUtilLinkedList.size();
      if (i < 0) {
        break label145;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.layout(0, -this.b, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - this.b);
      this.jdField_a_of_type_Bhzk.a(this.jdField_a_of_type_AndroidViewView, i);
    }
    for (;;)
    {
      int j = getChildCount();
      i = this.jdField_a_of_type_JavaUtilLinkedList.size() + 1;
      while (i < j)
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() != 0) {
          localView.setVisibility(0);
        }
        i += 1;
      }
      label145:
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
    if (this.jdField_a_of_type_Bese != null) {
      this.jdField_a_of_type_Bese.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      measureChild(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    int j;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramInt1 < this.jdField_a_of_type_JavaUtilLinkedList.size()) {
        break label351;
      }
      i = paramInt1 - this.jdField_a_of_type_JavaUtilLinkedList.size();
      this.jdField_a_of_type_Bhzk.a(this.jdField_a_of_type_AndroidViewView, i);
      if (this.jdField_a_of_type_Bhzk.a(i))
      {
        this.jdField_a_of_type_Int = 0;
        paramInt1 = 1;
        j = getChildCount();
        if (paramInt1 != 0)
        {
          localView = getChildAt(0);
          if (localView.getVisibility() != 4) {
            localView.setVisibility(4);
          }
        }
        if (paramInt1 == 0) {
          break label207;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 >= j) {
          break label212;
        }
        localView = getChildAt(paramInt1);
        if (localView.getVisibility() != 0) {
          localView.setVisibility(0);
        }
        paramInt1 += 1;
        continue;
        localView = getChildAt(0);
        if ((localView != null) && (localView.getBottom() > this.jdField_a_of_type_AndroidViewView.getMeasuredHeight()))
        {
          this.jdField_a_of_type_Int = 0;
          paramInt1 = 0;
          break;
        }
        if (this.jdField_a_of_type_Bhzk.a(i + 1))
        {
          this.jdField_a_of_type_Int = 1;
          paramInt1 = 0;
          break;
        }
        this.jdField_a_of_type_Int = 0;
        paramInt1 = 0;
        break;
        label207:
        paramInt1 = 0;
      }
      label212:
      if (this.jdField_a_of_type_Int != 1) {
        break label343;
      }
      View localView = getChildAt(1);
      j = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
      if (localView == null) {
        break label338;
      }
      paramInt1 = localView.getTop();
      this.b = (j - paramInt1);
      label255:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.layout(0, -this.b, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - this.b);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bhtv != null) {
        this.jdField_a_of_type_Bhtv.onScroll(paramAbsListView, i, paramInt2, paramInt3);
      }
      if (this.jdField_a_of_type_Bhzl != null) {
        this.jdField_a_of_type_Bhzl.onScroll(paramAbsListView, i, paramInt2, paramInt3);
      }
      return;
      label338:
      paramInt1 = 0;
      break;
      label343:
      this.b = 0;
      break label255;
      label351:
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      j = this.jdField_a_of_type_JavaUtilLinkedList.size();
      i = paramInt1;
      if (this.jdField_a_of_type_Bhzk.getCount() > 0)
      {
        i = paramInt1;
        if (this.jdField_a_of_type_Bhzk.a(0))
        {
          i = paramInt1;
          if (j >= paramInt1)
          {
            i = paramInt1;
            if (j < paramInt1 + paramInt2)
            {
              getChildAt(j - paramInt1).setVisibility(0);
              i = paramInt1;
            }
          }
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Bhtv != null) {
      this.jdField_a_of_type_Bhtv.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (this.jdField_a_of_type_Bhzl != null) {
      this.jdField_a_of_type_Bhzl.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean removeHeaderView(View paramView)
  {
    boolean bool = super.removeHeaderView(paramView);
    if (bool) {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramView);
    }
    return bool;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof bhzk))
    {
      this.jdField_a_of_type_Bhzk = ((bhzk)paramListAdapter);
      int i = this.jdField_a_of_type_Bhzk.a();
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, this, false);
        requestLayout();
      }
      super.setAdapter(this.jdField_a_of_type_Bhzk);
      return;
    }
    this.jdField_a_of_type_Bhzk = null;
    super.setAdapter(paramListAdapter);
  }
  
  public void setOnLayoutListener(bese parambese)
  {
    this.jdField_a_of_type_Bese = parambese;
  }
  
  public void setOnScrollListener(bhtv parambhtv)
  {
    this.jdField_a_of_type_Bhtv = parambhtv;
  }
  
  public void setOnScrollListenerAdapter(bhzl parambhzl)
  {
    this.jdField_a_of_type_Bhzl = parambhzl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.PinnedDividerSwipListView
 * JD-Core Version:    0.7.0.1
 */