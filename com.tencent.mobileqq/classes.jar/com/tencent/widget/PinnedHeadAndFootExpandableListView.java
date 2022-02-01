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
import blbu;
import bldz;
import blea;
import bleb;
import blec;
import bled;
import com.tencent.qphone.base.util.QLog;

public class PinnedHeadAndFootExpandableListView
  extends XExpandableListView
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext = null;
  public View a;
  public blbu a;
  public bleb a;
  public blec a;
  bled jdField_a_of_type_Bled = null;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
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
  private boolean jdField_e_of_type_Boolean;
  public int f = -1;
  public int g;
  
  public PinnedHeadAndFootExpandableListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Bleb = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Blbu = null;
    a(paramContext);
  }
  
  public PinnedHeadAndFootExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Bleb = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Blbu = null;
    a(paramContext);
  }
  
  public PinnedHeadAndFootExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Bleb = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Blbu = null;
    a(paramContext);
  }
  
  private View a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (!(paramView instanceof ViewGroup)) {
      localObject = paramView;
    }
    label58:
    label89:
    label101:
    for (;;)
    {
      return localObject;
      localObject = (ViewGroup)paramView;
      int k = ((ViewGroup)localObject).getChildCount();
      boolean bool = isChildrenDrawingOrderEnabled();
      int i = k - 1;
      int j;
      if (i >= 0) {
        if (bool)
        {
          j = getChildDrawingOrder(k, i);
          paramView = ((ViewGroup)localObject).getChildAt(j);
          if (!a(paramView, paramInt1, paramInt2)) {
            break label89;
          }
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label101;
        }
        return paramView;
        j = i;
        break label58;
        i -= 1;
        break;
        paramView = null;
      }
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bleb != null) && (this.jdField_a_of_type_AndroidViewView != null) && (paramInt < this.jdField_a_of_type_Bleb.getGroupCount()))
    {
      this.f = paramInt;
      if (paramInt < 1) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Bleb.a(this.jdField_a_of_type_AndroidViewView, paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i = ExpandableListView.b(a(paramInt));
    int j;
    if (i != 2) {
      if (i == 0) {
        if ((ExpandableListView.b(a(paramInt + 1)) == 0) || (ExpandableListView.b(a(paramInt + 1)) == 2))
        {
          this.jdField_c_of_type_Int = -1;
          if (this.jdField_c_of_type_Int == -1) {
            break label304;
          }
          if (this.jdField_c_of_type_Int != 1) {
            break label296;
          }
          View localView = getChildAt(1);
          j = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
          if (localView == null) {
            break label291;
          }
          i = localView.getTop();
        }
      }
    }
    label93:
    for (this.jdField_d_of_type_Int = (j - i);; this.jdField_d_of_type_Int = 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramInt = ExpandableListView.c(a(paramInt));
      if ((paramInt != this.jdField_e_of_type_Int) || (paramBoolean) || (this.jdField_e_of_type_Boolean))
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_e_of_type_Int = paramInt;
        this.jdField_a_of_type_Bleb.a(this.jdField_b_of_type_AndroidViewView, paramInt);
        paramInt = View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_AndroidViewView.getMeasuredWidth(), 1073741824);
        i = View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_AndroidViewView.getMeasuredHeight(), 1073741824);
        this.jdField_b_of_type_AndroidViewView.measure(paramInt, i);
        this.jdField_b_of_type_AndroidViewView.layout(0, 0, this.jdField_b_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_b_of_type_AndroidViewView.getMeasuredHeight());
      }
      return;
      this.jdField_c_of_type_Int = 0;
      break;
      if (getChildAt(0).getBottom() > this.jdField_b_of_type_AndroidViewView.getMeasuredHeight())
      {
        this.jdField_c_of_type_Int = 0;
        break;
      }
      if (ExpandableListView.b(a(paramInt + 1)) == 0)
      {
        this.jdField_c_of_type_Int = 1;
        break;
      }
      this.jdField_c_of_type_Int = 0;
      break;
      this.jdField_c_of_type_Int = -1;
      break;
      i = 0;
      break label93;
    }
    label291:
    label296:
    label304:
    if (paramBoolean) {
      this.jdField_e_of_type_Boolean = true;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
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
    if (this.jdField_a_of_type_Blec != null) {
      this.jdField_a_of_type_Blec.a();
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PinnedHeadAndFootExpandableListView", 2, "mHeaderView null");
      }
    }
    do
    {
      return;
      localObject = super.a();
      if ((localObject instanceof bleb)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PinnedHeadAndFootExpandableListView", 2, "object null");
    return;
    Object localObject = (bleb)localObject;
    int i2 = getFirstVisiblePosition();
    int k = getLastVisiblePosition();
    int i3 = ExpandableListView.c(a(k));
    int n = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int i1 = getHeight();
    int i4 = i1 - n;
    int j = k - 2;
    int m = k - 1;
    int i5 = ExpandableListView.c(a(j));
    int i;
    if (i3 == ((bleb)localObject).getGroupCount() - 1)
    {
      i = 1;
      if ((j < 0) || (i5 == i3)) {
        break label377;
      }
      if (ExpandableListView.c(a(m)) != i3) {
        break label441;
      }
    }
    label441:
    for (j = m;; j = k)
    {
      localObject = getChildAt(j - i2);
      if (i1 - ((View)localObject).getTop() >= n)
      {
        a(i3 + 1);
        k = ((View)localObject).getTop() + n;
        j = k;
        if (k < i1 - n) {
          j = i1 - n;
        }
        if (i != 0)
        {
          this.f = -1;
          this.jdField_a_of_type_AndroidViewView.layout(0, -n, this.jdField_a_of_type_Int, -n);
          return;
          i = 0;
          break;
        }
        this.jdField_a_of_type_AndroidViewView.layout(0, j, this.jdField_a_of_type_Int, j + n);
        return;
      }
      a(i3);
      if ((i != 0) && (j != k))
      {
        this.f = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -n, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
        return;
      }
      if (ExpandableListView.b(a(m)) == 0)
      {
        b();
        this.f = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -n, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.layout(0, i4, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int + i4);
      return;
      label377:
      if (i != 0)
      {
        this.f = -1;
        this.jdField_a_of_type_AndroidViewView.layout(0, -this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, -this.jdField_b_of_type_Int);
      }
      for (;;)
      {
        a(i3 + 1);
        return;
        this.jdField_a_of_type_AndroidViewView.layout(0, i4, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int + i4);
      }
    }
  }
  
  public void addHeaderView(View paramView)
  {
    this.g = 1;
    super.addHeaderView(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0))
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.jdField_d_of_type_Int);
      drawChild(paramCanvas, this.jdField_b_of_type_AndroidViewView, getDrawingTime());
      paramCanvas.restore();
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
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
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (j >= this.jdField_a_of_type_AndroidViewView.getTop()) && (j <= this.jdField_a_of_type_AndroidViewView.getBottom()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.jdField_c_of_type_AndroidViewView = a(this.jdField_a_of_type_AndroidViewView, i, j);
        this.jdField_c_of_type_Boolean = true;
      }
      while (paramMotionEvent.getAction() != 1) {
        return true;
      }
      if ((a(this.jdField_a_of_type_AndroidViewView, i, j) == this.jdField_c_of_type_AndroidViewView) && (this.jdField_c_of_type_AndroidViewView.isClickable()))
      {
        this.jdField_c_of_type_AndroidViewView.performClick();
        invalidate(new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        return true;
        if ((!this.jdField_d_of_type_Boolean) || (ExpandableListView.c(a(k)) == -1) || (!this.jdField_c_of_type_Boolean)) {}
      }
    }
    this.jdField_c_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent))) {}
      for (boolean bool = true;; bool = false)
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          this.jdField_a_of_type_Boolean = false;
        }
        return bool;
      }
    }
    if ((this.jdField_b_of_type_AndroidViewView != null) && (f1 >= 0.0F) && (f1 <= this.jdField_b_of_type_AndroidViewView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.jdField_b_of_type_AndroidViewView.getMeasuredHeight() - this.jdField_d_of_type_Int) && (paramMotionEvent.getAction() == 0) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent)))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.jdField_b_of_type_AndroidViewView != null) {
      a(this.jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      a(getFirstVisiblePosition(), true);
    }
    if (this.jdField_a_of_type_Bled != null) {
      this.jdField_a_of_type_Bled.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      measureChild(this.jdField_b_of_type_AndroidViewView, paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      measureChild(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2);
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
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
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
    if ((paramExpandableListAdapter instanceof bleb))
    {
      this.jdField_a_of_type_Bleb = ((bleb)paramExpandableListAdapter);
      int i = this.jdField_a_of_type_Bleb.a();
      if (i != 0)
      {
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, this, false);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          this.jdField_b_of_type_AndroidViewView.setTag("headerView");
          this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new bldz(this));
        }
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView == null))
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, this, false);
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            this.jdField_a_of_type_AndroidViewView.setTag("footerView");
            this.jdField_a_of_type_AndroidViewView.setOnClickListener(new blea(this, this));
          }
        }
        requestLayout();
      }
    }
  }
  
  public void setFooterEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void setFooterListener(blec paramblec)
  {
    this.jdField_a_of_type_Blec = paramblec;
  }
  
  public void setOnGroupClickListener(blbu paramblbu)
  {
    this.jdField_a_of_type_Blbu = paramblbu;
    super.setOnGroupClickListener(paramblbu);
  }
  
  public void setOnLayoutListener(bled parambled)
  {
    this.jdField_a_of_type_Bled = parambled;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.PinnedHeadAndFootExpandableListView
 * JD-Core Version:    0.7.0.1
 */