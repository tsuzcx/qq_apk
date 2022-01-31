package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.LinkedList;

public class PinnedDividerListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private PinnedDividerListView.DividerAdapter jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter;
  private PinnedDividerListView.OnLayoutListener jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$OnLayoutListener;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private int b;
  
  public PinnedDividerListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PinnedDividerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PinnedDividerListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    int j;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramInt1 < this.jdField_a_of_type_JavaUtilLinkedList.size()) {
        break label336;
      }
      i = paramInt1 - this.jdField_a_of_type_JavaUtilLinkedList.size();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(this.jdField_a_of_type_AndroidViewView, i);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(i))
      {
        this.jdField_a_of_type_Int = 0;
        paramInt1 = 1;
        j = getChildCount();
        if (paramInt1 != 0)
        {
          localView = getChildAt(0);
          if ((localView != null) && (localView.getVisibility() != 4)) {
            localView.setVisibility(4);
          }
        }
        if (paramInt1 == 0) {
          break label212;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 >= j) {
          break label217;
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
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(i + 1))
        {
          this.jdField_a_of_type_Int = 1;
          paramInt1 = 0;
          break;
        }
        this.jdField_a_of_type_Int = 0;
        paramInt1 = 0;
        break;
        label212:
        paramInt1 = 0;
      }
      label217:
      if (this.jdField_a_of_type_Int != 1) {
        break label328;
      }
      View localView = getChildAt(1);
      j = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
      if (localView == null) {
        break label323;
      }
      paramInt1 = localView.getTop();
      this.b = (j - paramInt1);
      label260:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.layout(0, -this.b, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - this.b);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, i, paramInt2, paramInt3);
      }
      return;
      label323:
      paramInt1 = 0;
      break;
      label328:
      this.b = 0;
      break label260;
      label336:
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      j = this.jdField_a_of_type_JavaUtilLinkedList.size();
      i = paramInt1;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.getCount() > 0)
      {
        i = paramInt1;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(0))
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(this.jdField_a_of_type_AndroidViewView, i);
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$OnLayoutListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$OnLayoutListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      measureChild(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2);
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
    if ((paramListAdapter instanceof PinnedDividerListView.DividerAdapter))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter = ((PinnedDividerListView.DividerAdapter)paramListAdapter);
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a();
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, this, false);
        requestLayout();
      }
      super.setAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter = null;
    super.setAdapter(paramListAdapter);
  }
  
  public void setOnLayoutListener(PinnedDividerListView.OnLayoutListener paramOnLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$OnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PinnedDividerListView
 * JD-Core Version:    0.7.0.1
 */