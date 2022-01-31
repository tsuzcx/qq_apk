package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import bfos;
import bfru;
import bfuq;
import bfur;
import bfus;

public class PinnedHeaderExpandableListView
  extends XExpandableListView
  implements bfos
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bfos jdField_a_of_type_Bfos;
  private bfru jdField_a_of_type_Bfru;
  private bfur jdField_a_of_type_Bfur;
  private bfus jdField_a_of_type_Bfus;
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
    int j = 1;
    int k = b(a(paramInt));
    View localView;
    if (k != 2) {
      if (k == 0) {
        if ((b(a(paramInt + 1)) == 0) || (b(a(paramInt + 1)) == 2))
        {
          this.jdField_a_of_type_Int = -1;
          if (this.jdField_a_of_type_Int == -1) {
            break label425;
          }
          if (this.jdField_a_of_type_Int != 1) {
            break label303;
          }
          localView = getChildAt(1);
          int m = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
          if (localView == null) {
            break label298;
          }
          i = localView.getTop();
          label99:
          this.jdField_b_of_type_Int = (m - i);
          label107:
          if (!this.jdField_c_of_type_Boolean) {
            break label316;
          }
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          if (!this.jdField_a_of_type_Bfur.a()) {
            break label316;
          }
          if (k != 0) {
            break label506;
          }
          localView = getChildAt(0);
          if ((localView == null) || (isDirectChildHeaderOrFooter(localView))) {
            break label506;
          }
          localView.setVisibility(4);
        }
      }
    }
    label298:
    label303:
    label316:
    label506:
    for (int i = 1;; i = 0)
    {
      k = getChildCount();
      if (i != 0) {
        i = j;
      }
      for (;;)
      {
        if (i >= k) {
          break label316;
        }
        localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() != 0) && (!isDirectChildHeaderOrFooter(localView))) {
          localView.setVisibility(0);
        }
        i += 1;
        continue;
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
        break label99;
        this.jdField_b_of_type_Int = 0;
        break label107;
        i = 0;
      }
      paramInt = c(a(paramInt));
      if ((paramInt != this.jdField_c_of_type_Int) || (paramBoolean) || (this.jdField_b_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_Int = paramInt;
        this.jdField_a_of_type_Bfur.a(this.jdField_a_of_type_AndroidViewView, paramInt);
        paramInt = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), 1073741824);
        i = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredHeight(), 1073741824);
        this.jdField_a_of_type_AndroidViewView.measure(paramInt, i);
        this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      }
      for (;;)
      {
        return;
        if (paramBoolean) {
          this.jdField_b_of_type_Boolean = true;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Bfur.a())
        {
          i = getChildCount();
          paramInt = 0;
          while (paramInt < i)
          {
            localView = getChildAt(paramInt);
            if ((localView != null) && (localView.getVisibility() != 0) && (!isDirectChildHeaderOrFooter(localView))) {
              localView.setVisibility(0);
            }
            paramInt += 1;
          }
        }
      }
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
  
  protected void dispatchDraw(Canvas paramCanvas)
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
    if (this.jdField_a_of_type_Bfus != null) {
      this.jdField_a_of_type_Bfus.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
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
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(paramInt1, false);
    }
    if (this.jdField_a_of_type_Bfos != null) {
      this.jdField_a_of_type_Bfos.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Bfos != null) {
      this.jdField_a_of_type_Bfos.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof bfur))
    {
      this.jdField_a_of_type_Bfur = ((bfur)paramExpandableListAdapter);
      int i = this.jdField_a_of_type_Bfur.a();
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, this, false);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new bfuq(this));
        }
        requestLayout();
      }
    }
  }
  
  public void setHeaderViewShouldShow(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setOnGroupClickListener(bfru parambfru)
  {
    this.jdField_a_of_type_Bfru = parambfru;
    super.setOnGroupClickListener(parambfru);
  }
  
  public void setOnLayoutListener(bfus parambfus)
  {
    this.jdField_a_of_type_Bfus = parambfus;
  }
  
  public void setOnScrollListener(bfos parambfos)
  {
    this.jdField_a_of_type_Bfos = parambfos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.PinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */