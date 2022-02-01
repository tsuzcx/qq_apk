package dov.com.qq.im.capture.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import bpva;
import bpvo;
import bpvp;
import com.tencent.qphone.base.util.QLog;

public class NestedScrollingParentLayout
  extends FrameLayout
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = -1;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new bpvo(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bpva jdField_a_of_type_Bpva;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private RecyclerView.OnScrollListener jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new bpvp(this);
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private bpva jdField_b_of_type_Bpva;
  private RecyclerView c;
  
  public NestedScrollingParentLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public NestedScrollingParentLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NestedScrollingParentLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NestedScrollingParentLayout", 2, "onStartNestedScroll target += " + paramView);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView) {
      this.jdField_a_of_type_Int = -1;
    }
    while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != this.c) {
      return;
    }
    this.jdField_b_of_type_Int = -1;
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    int n = (int)paramMotionEvent.getRawX();
    int i1 = (int)paramMotionEvent.getRawY();
    return (n >= i) && (n <= k + i) && (i1 >= j) && (i1 <= m + j);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("NestedScrollingParentLayout", 2, "onTouchEvent event += ");
      }
      if (a(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView, paramMotionEvent)) {
        a(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView);
      } else if (a(this.c, paramMotionEvent)) {
        a(this.c);
      }
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onStartNestedScroll(paramView1, paramView2, paramInt);
    }
    a(paramView2);
    return true;
  }
  
  public void setItemPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOnResume(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTwoRecyclerView(RecyclerView paramRecyclerView1, RecyclerView paramRecyclerView2, bpva parambpva1, bpva parambpva2)
  {
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView1;
    this.c = paramRecyclerView2;
    this.jdField_a_of_type_Bpva = parambpva1;
    this.jdField_b_of_type_Bpva = parambpva2;
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    this.c.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.NestedScrollingParentLayout
 * JD-Core Version:    0.7.0.1
 */