package com.tencent.widget;

import alnk;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;

public class PinnedHeaderExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ExpandableListView.OnGroupClickListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener;
  private PinnedHeaderExpandableListView.ExpandableListAdapter jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter;
  private PinnedHeaderExpandableListView.OnLayoutListener jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  protected boolean c;
  
  public PinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = true;
    a(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = true;
    a(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = true;
    a(paramContext);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i = b(a(paramInt));
    int j;
    if (i != 2) {
      if (i == 0) {
        if ((b(a(paramInt + 1)) == 0) || (b(a(paramInt + 1)) == 2))
        {
          this.jdField_a_of_type_Int = -1;
          if (this.jdField_a_of_type_Int == -1) {
            break label309;
          }
          if (this.jdField_a_of_type_Int != 1) {
            break label301;
          }
          View localView = getChildAt(1);
          j = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
          if (localView == null) {
            break label296;
          }
          i = localView.getTop();
        }
      }
    }
    label93:
    for (this.jdField_b_of_type_Int = (j - i);; this.jdField_b_of_type_Int = 0)
    {
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      paramInt = c(a(paramInt));
      if ((paramInt != this.jdField_c_of_type_Int) || (paramBoolean) || (this.jdField_b_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a(this.jdField_a_of_type_AndroidViewView, paramInt);
        paramInt = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), 1073741824);
        i = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredHeight(), 1073741824);
        this.jdField_a_of_type_AndroidViewView.measure(paramInt, i);
        this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      }
      return;
      this.jdField_a_of_type_Int = 0;
      break;
      if (getChildAt(0).getBottom() > this.jdField_a_of_type_AndroidViewView.getMeasuredHeight())
      {
        this.jdField_a_of_type_Int = 0;
        break;
      }
      if (b(a(paramInt + 1)) == 0)
      {
        this.jdField_a_of_type_Int = 1;
        break;
      }
      this.jdField_a_of_type_Int = 0;
      break;
      this.jdField_a_of_type_Int = -1;
      break;
      i = 0;
      break label93;
    }
    label296:
    label301:
    label309:
    if (paramBoolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        a(localViewGroup.getChildAt(i));
        i += 1;
      }
    }
    paramView.refreshDrawableState();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(paramInt1, false);
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.jdField_b_of_type_Int);
      drawChild(paramCanvas, this.jdField_a_of_type_AndroidViewView, getDrawingTime());
      paramCanvas.restore();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent))) {}
      for (boolean bool = true;; bool = false)
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          this.jdField_a_of_type_Boolean = false;
        }
        return bool;
      }
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (f1 >= 0.0F) && (f1 <= this.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() - this.jdField_b_of_type_Int) && (paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent)))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(getFirstVisiblePosition(), true);
    }
    if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      measureChild(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2);
    }
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof PinnedHeaderExpandableListView.ExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = ((PinnedHeaderExpandableListView.ExpandableListAdapter)paramExpandableListAdapter);
      int i = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.a();
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, this, false);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new alnk(this));
        }
        requestLayout();
      }
    }
  }
  
  public void setHeaderViewShouldShow(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener paramOnGroupClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = paramOnGroupClickListener;
    super.setOnGroupClickListener(paramOnGroupClickListener);
  }
  
  public void setOnLayoutListener(PinnedHeaderExpandableListView.OnLayoutListener paramOnLayoutListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$OnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.PinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */