package com.tencent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import com.tencent.qphone.base.util.QLog;

public class PinnedHeadAndFootExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext = null;
  View jdField_a_of_type_AndroidViewView = null;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
  ExpandableListView.OnGroupClickListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = null;
  PinnedHeadAndFootExpandableListView.ExpandableListAdapter jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter = null;
  PinnedHeadAndFootExpandableListView.FooterExpandListViewListener jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$FooterExpandListViewListener;
  PinnedHeadAndFootExpandableListView.OnLayoutListener jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$OnLayoutListener = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView = null;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = false;
  int f = -1;
  public int g;
  
  public PinnedHeadAndFootExpandableListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PinnedHeadAndFootExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PinnedHeadAndFootExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private View a(View paramView, int paramInt1, int paramInt2)
  {
    if (!(paramView instanceof ViewGroup)) {
      return paramView;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView;
    int k = localViewGroup.getChildCount();
    boolean bool = isChildrenDrawingOrderEnabled();
    Object localObject = null;
    int i = k - 1;
    for (;;)
    {
      paramView = localObject;
      if (i < 0) {
        break;
      }
      int j;
      if (bool) {
        j = getChildDrawingOrder(k, i);
      } else {
        j = i;
      }
      paramView = localViewGroup.getChildAt(j);
      if (a(paramView, paramInt1, paramInt2)) {
        break;
      }
      i -= 1;
    }
    if (paramView == null) {
      return localViewGroup;
    }
    return paramView;
  }
  
  private void a(int paramInt)
  {
    PinnedHeadAndFootExpandableListView.ExpandableListAdapter localExpandableListAdapter = this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter;
    if ((localExpandableListAdapter != null) && (this.jdField_a_of_type_AndroidViewView != null) && (paramInt < localExpandableListAdapter.getGroupCount()))
    {
      this.f = paramInt;
      if (paramInt < 1)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter.a(this.jdField_a_of_type_AndroidViewView, paramInt);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i = ExpandableListView.getPackedPositionType(getExpandableListPosition(paramInt));
    if (i != 2)
    {
      if (i == 0)
      {
        i = paramInt + 1;
        if ((ExpandableListView.getPackedPositionType(getExpandableListPosition(i)) != 0) && (ExpandableListView.getPackedPositionType(getExpandableListPosition(i)) != 2)) {
          this.jdField_c_of_type_Int = 0;
        } else {
          this.jdField_c_of_type_Int = -1;
        }
      }
      else if (getChildAt(0).getBottom() > this.jdField_b_of_type_AndroidViewView.getMeasuredHeight())
      {
        this.jdField_c_of_type_Int = 0;
      }
      else if (ExpandableListView.getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 0)
      {
        this.jdField_c_of_type_Int = 1;
      }
      else
      {
        this.jdField_c_of_type_Int = 0;
      }
    }
    else {
      this.jdField_c_of_type_Int = -1;
    }
    i = this.jdField_c_of_type_Int;
    if (i != -1)
    {
      View localView;
      if (i == 1)
      {
        localView = getChildAt(1);
        int j = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
        if (localView != null) {
          i = localView.getTop();
        } else {
          i = 0;
        }
        this.jdField_d_of_type_Int = (j - i);
      }
      else
      {
        this.jdField_d_of_type_Int = 0;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramInt = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(paramInt));
      if ((paramInt != this.jdField_e_of_type_Int) || (paramBoolean) || (this.jdField_e_of_type_Boolean))
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_e_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter.a(this.jdField_b_of_type_AndroidViewView, paramInt);
        paramInt = View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_AndroidViewView.getMeasuredWidth(), 1073741824);
        i = View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_AndroidViewView.getMeasuredHeight(), 1073741824);
        this.jdField_b_of_type_AndroidViewView.measure(paramInt, i);
        localView = this.jdField_b_of_type_AndroidViewView;
        localView.layout(0, 0, localView.getMeasuredWidth(), this.jdField_b_of_type_AndroidViewView.getMeasuredHeight());
      }
    }
    else
    {
      if (paramBoolean) {
        this.jdField_e_of_type_Boolean = true;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    }
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
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    return (paramView.isClickable()) && (paramInt2 >= paramView.getTop()) && (paramInt2 <= paramView.getBottom()) && (paramInt1 >= paramView.getLeft()) && (paramInt1 <= paramView.getRight());
  }
  
  private void b()
  {
    setFooterEnable(false);
    PinnedHeadAndFootExpandableListView.FooterExpandListViewListener localFooterExpandListViewListener = this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$FooterExpandListViewListener;
    if (localFooterExpandListViewListener != null) {
      localFooterExpandListViewListener.a();
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PinnedHeadAndFootExpandableListView", 2, "mHeaderView null");
      }
      return;
    }
    Object localObject = super.getExpandableListAdapter();
    if (!(localObject instanceof PinnedHeadAndFootExpandableListView.ExpandableListAdapter))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PinnedHeadAndFootExpandableListView", 2, "object null");
      }
      return;
    }
    localObject = (PinnedHeadAndFootExpandableListView.ExpandableListAdapter)localObject;
    int i3 = getFirstVisiblePosition();
    int m = getLastVisiblePosition();
    int i2 = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(m));
    int i1 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int i4 = getHeight();
    int k = i4 - i1;
    int j = m - 2;
    int n = m - 1;
    int i5 = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(j));
    int i;
    if (i2 == ((PinnedHeadAndFootExpandableListView.ExpandableListAdapter)localObject).getGroupCount() - 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j >= 0) && (i5 != i2))
    {
      if (ExpandableListView.getPackedPositionGroup(getExpandableListPosition(n)) == i2) {
        j = n;
      } else {
        j = m;
      }
      localObject = getChildAt(j - i3);
      if (i4 - ((View)localObject).getTop() >= i1)
      {
        a(i2 + 1);
        m = ((View)localObject).getTop() + i1;
        j = m;
        if (m < k) {
          j = k;
        }
        if (i != 0)
        {
          this.f = -1;
          localObject = this.jdField_a_of_type_AndroidViewView;
          i = -i1;
          ((View)localObject).layout(0, i, this.jdField_a_of_type_Int, i);
          return;
        }
        this.jdField_a_of_type_AndroidViewView.layout(0, j, this.jdField_a_of_type_Int, i1 + j);
        return;
      }
      a(i2);
      if ((i != 0) && (j != m))
      {
        this.f = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -i1, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
        return;
      }
      if (ExpandableListView.getPackedPositionType(getExpandableListPosition(n)) == 0)
      {
        b();
        this.f = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -i1, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.layout(0, k, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int + k);
      return;
    }
    if (i != 0)
    {
      this.f = -1;
      localObject = this.jdField_a_of_type_AndroidViewView;
      i = this.jdField_b_of_type_Int;
      ((View)localObject).layout(0, -i, this.jdField_a_of_type_Int, -i);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.layout(0, k, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int + k);
    }
    a(i2 + 1);
  }
  
  public void addHeaderView(View paramView)
  {
    this.g = 1;
    super.addHeaderView(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.jdField_d_of_type_Int);
      drawChild(paramCanvas, this.jdField_b_of_type_AndroidViewView, getDrawingTime());
      paramCanvas.restore();
    }
    localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      drawChild(paramCanvas, this.jdField_a_of_type_AndroidViewView, getDrawingTime());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = (int)f1;
    int j = (int)f2;
    int k = pointToPosition(i, j);
    View localView = this.jdField_a_of_type_AndroidViewView;
    boolean bool;
    if ((localView != null) && (localView.getVisibility() == 0) && (j >= this.jdField_a_of_type_AndroidViewView.getTop()) && (j <= this.jdField_a_of_type_AndroidViewView.getBottom()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.jdField_c_of_type_AndroidViewView = a(this.jdField_a_of_type_AndroidViewView, i, j);
        this.jdField_c_of_type_Boolean = true;
        return true;
      }
      if (paramMotionEvent.getAction() == 1)
      {
        paramMotionEvent = a(this.jdField_a_of_type_AndroidViewView, i, j);
        localView = this.jdField_c_of_type_AndroidViewView;
        if ((paramMotionEvent == localView) && (localView.isClickable()))
        {
          this.jdField_c_of_type_AndroidViewView.performClick();
          invalidate(new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
        }
        else if ((this.jdField_d_of_type_Boolean) && (ExpandableListView.getPackedPositionGroup(getExpandableListPosition(k)) != -1))
        {
          bool = this.jdField_c_of_type_Boolean;
        }
        this.jdField_c_of_type_Boolean = false;
      }
      return true;
    }
    this.jdField_c_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_Boolean)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if ((localView != null) && (localView.dispatchTouchEvent(paramMotionEvent))) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.jdField_a_of_type_Boolean = false;
      }
      return bool;
    }
    localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && (f1 >= 0.0F) && (f1 <= localView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.jdField_b_of_type_AndroidViewView.getMeasuredHeight() - this.jdField_d_of_type_Int) && (paramMotionEvent.getAction() == 0) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent)))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      a(localView);
    }
    localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      a(localView);
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      a(getFirstVisiblePosition(), true);
    }
    PinnedHeadAndFootExpandableListView.OnLayoutListener localOnLayoutListener = this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$OnLayoutListener;
    if (localOnLayoutListener != null) {
      localOnLayoutListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      measureChild(localView, paramInt1, paramInt2);
    }
    localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      measureChild(localView, paramInt1, paramInt2);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      a(paramInt1, false);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a();
    }
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
    this.g = 0;
    return super.removeHeaderView(paramView);
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof PinnedHeadAndFootExpandableListView.ExpandableListAdapter))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter = ((PinnedHeadAndFootExpandableListView.ExpandableListAdapter)paramExpandableListAdapter);
      int i = this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter.a();
      if (i != 0)
      {
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, this, false);
        paramExpandableListAdapter = this.jdField_b_of_type_AndroidViewView;
        if (paramExpandableListAdapter != null)
        {
          paramExpandableListAdapter.setTag("headerView");
          this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new PinnedHeadAndFootExpandableListView.1(this));
        }
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView == null))
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, this, false);
          paramExpandableListAdapter = this.jdField_a_of_type_AndroidViewView;
          if (paramExpandableListAdapter != null)
          {
            paramExpandableListAdapter.setTag("footerView");
            this.jdField_a_of_type_AndroidViewView.setOnClickListener(new PinnedHeadAndFootExpandableListView.2(this, this));
          }
        }
        requestLayout();
      }
    }
  }
  
  public void setFooterEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localView.setVisibility(0);
        return;
      }
      localView.setVisibility(8);
    }
  }
  
  public void setFooterListener(PinnedHeadAndFootExpandableListView.FooterExpandListViewListener paramFooterExpandListViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$FooterExpandListViewListener = paramFooterExpandListViewListener;
  }
  
  public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener paramOnGroupClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener = paramOnGroupClickListener;
    super.setOnGroupClickListener(paramOnGroupClickListener);
  }
  
  public void setOnLayoutListener(PinnedHeadAndFootExpandableListView.OnLayoutListener paramOnLayoutListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$OnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.PinnedHeadAndFootExpandableListView
 * JD-Core Version:    0.7.0.1
 */