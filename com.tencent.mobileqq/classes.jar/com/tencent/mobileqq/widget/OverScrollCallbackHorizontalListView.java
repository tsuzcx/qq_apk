package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.HorizontalListView;

public class OverScrollCallbackHorizontalListView
  extends HorizontalListView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private OverScrollCallbackHorizontalListView.Listener jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView$Listener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  
  public OverScrollCallbackHorizontalListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public OverScrollCallbackHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Int = AIOUtils.b(50.0F, getResources());
    setOverScrollMode(0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      float f2 = this.jdField_a_of_type_Float;
      f3 -= this.jdField_b_of_type_Float;
      if ((this.jdField_a_of_type_Boolean) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > DisplayUtil.a(getContext(), 5.0F))) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    else if ((i == 3) || (i == 1))
    {
      this.jdField_a_of_type_Boolean = false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramInt3 > this.jdField_a_of_type_Int))
    {
      this.jdField_b_of_type_Boolean = false;
      OverScrollCallbackHorizontalListView.Listener localListener = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView$Listener;
      if ((localListener != null) && (this.jdField_a_of_type_Boolean)) {
        localListener.a(this);
      }
    }
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public void setListener(OverScrollCallbackHorizontalListView.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView$Listener = paramListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView
 * JD-Core Version:    0.7.0.1
 */