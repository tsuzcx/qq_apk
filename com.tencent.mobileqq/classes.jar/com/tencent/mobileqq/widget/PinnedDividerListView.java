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
  private Context jdField_a_of_type_AndroidContentContext = null;
  private View jdField_a_of_type_AndroidViewView = null;
  private PinnedDividerListView.DividerAdapter jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter = null;
  private PinnedDividerListView.OnLayoutListener jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$OnLayoutListener = null;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
  private LinkedList<View> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private int b = 0;
  
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
  
  protected PinnedDividerListView.DividerAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter;
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
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.jdField_a_of_type_AndroidViewView, getDrawingTime());
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      i = getFirstVisiblePosition() - this.jdField_a_of_type_JavaUtilLinkedList.size();
      if ((i >= 0) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(this.jdField_a_of_type_AndroidViewView, i)))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localObject = this.jdField_a_of_type_AndroidViewView;
        ((View)localObject).layout(0, -this.b, ((View)localObject).getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - this.b);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(this.jdField_a_of_type_AndroidViewView, i);
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
    }
    int k = getChildCount();
    int i = this.jdField_a_of_type_JavaUtilLinkedList.size();
    for (;;)
    {
      int j = i + 1;
      if (j >= k) {
        break;
      }
      localObject = getChildAt(j);
      i = j;
      if (((View)localObject).getVisibility() != 0)
      {
        ((View)localObject).setVisibility(0);
        i = j;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$OnLayoutListener;
    if (localObject != null) {
      ((PinnedDividerListView.OnLayoutListener)localObject).a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      measureChild(localView, paramInt1, paramInt2);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      int j;
      if ((paramInt1 >= this.jdField_a_of_type_JavaUtilLinkedList.size()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(this.jdField_a_of_type_AndroidViewView, paramInt1 - this.jdField_a_of_type_JavaUtilLinkedList.size())))
      {
        j = paramInt1 - this.jdField_a_of_type_JavaUtilLinkedList.size();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(this.jdField_a_of_type_AndroidViewView, j);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(j))
        {
          this.jdField_a_of_type_Int = 0;
          paramInt1 = 1;
        }
        else
        {
          localObject = getChildAt(0);
          if ((localObject != null) && (((View)localObject).getBottom() > this.jdField_a_of_type_AndroidViewView.getMeasuredHeight())) {
            this.jdField_a_of_type_Int = 0;
          } else if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView$DividerAdapter.a(j + 1)) {
            this.jdField_a_of_type_Int = 1;
          } else {
            this.jdField_a_of_type_Int = 0;
          }
          paramInt1 = 0;
        }
        int k = getChildCount();
        i = paramInt1;
        if (paramInt1 != 0)
        {
          localObject = getChildAt(0);
          i = paramInt1;
          if (localObject != null)
          {
            i = paramInt1;
            if (((View)localObject).getVisibility() != 4)
            {
              ((View)localObject).setVisibility(4);
              i = paramInt1;
            }
          }
        }
        while (i < k)
        {
          localObject = getChildAt(i);
          if (((View)localObject).getVisibility() != 0) {
            ((View)localObject).setVisibility(0);
          }
          i += 1;
        }
        if (this.jdField_a_of_type_Int == 1)
        {
          localObject = getChildAt(1);
          i = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
          if (localObject != null) {
            paramInt1 = ((View)localObject).getTop();
          } else {
            paramInt1 = 0;
          }
          this.b = (i - paramInt1);
        }
        else
        {
          this.b = 0;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localObject = this.jdField_a_of_type_AndroidViewView;
        ((View)localObject).layout(0, -this.b, ((View)localObject).getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - this.b);
        i = j;
      }
      else
      {
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
    Object localObject = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScroll(paramAbsListView, i, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PinnedDividerListView
 * JD-Core Version:    0.7.0.1
 */