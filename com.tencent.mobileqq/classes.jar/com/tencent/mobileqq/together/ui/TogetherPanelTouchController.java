package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.AtPanelTouchListener;
import com.tencent.qphone.base.util.QLog;

public class TogetherPanelTouchController
  extends LinearLayout
{
  private float jdField_a_of_type_Float = -3.402824E+038F;
  private int jdField_a_of_type_Int = 1;
  private View jdField_a_of_type_AndroidViewView = null;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private AtPanelTouchController.AtPanelTouchListener jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController$AtPanelTouchListener;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d = false;
  private boolean e = false;
  
  public TogetherPanelTouchController(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TogetherPanelTouchController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TogetherPanelTouchController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a()
  {
    int i = 0;
    int k;
    for (int j = 0; i < getChildCount(); j = k)
    {
      View localView = getChildAt(i);
      k = j;
      if (localView.getVisibility() == 0) {
        k = j + localView.getHeight();
      }
      i += 1;
    }
    this.jdField_b_of_type_Int = j;
    return j / 3;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {
      return false;
    }
    int i = (int)paramMotionEvent.getRawY();
    int j = (int)paramMotionEvent.getRawX();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int k = paramMotionEvent[0];
    int m = paramMotionEvent[1];
    int n = paramView.getMeasuredWidth();
    int i1 = paramView.getMeasuredHeight();
    return (i >= m) && (i <= i1 + m) && (j >= k) && (j <= n + k);
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if ((this.c) && (!a(paramView, paramMotionEvent))) {
      return false;
    }
    this.jdField_b_of_type_Boolean = true;
    return true;
  }
  
  public float a(float paramFloat)
  {
    float f;
    if (this.jdField_a_of_type_Boolean) {
      f = 0.0F;
    } else {
      f = 20.0F;
    }
    int i = AIOUtils.b(f, getContext().getResources());
    int j = (int)(getScrollY() + paramFloat);
    if (j < i) {
      return paramFloat;
    }
    if (j >= i)
    {
      AtPanelTouchController.AtPanelTouchListener localAtPanelTouchListener = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController$AtPanelTouchListener;
      if (localAtPanelTouchListener != null) {
        localAtPanelTouchListener.a();
      }
      return i - getScrollY();
    }
    return 0.0F;
  }
  
  public void a(int paramInt)
  {
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    if (localScroller != null)
    {
      localScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
      invalidate();
      return;
    }
    scrollTo(0, paramInt);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    Object localObject = this.jdField_a_of_type_AndroidWidgetScroller;
    if ((localObject != null) && (((Scroller)localObject).computeScrollOffset()))
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      invalidate();
      return;
    }
    if (this.e)
    {
      this.e = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController$AtPanelTouchListener;
      if (localObject != null) {
        ((AtPanelTouchController.AtPanelTouchListener)localObject).a(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    View localView2 = this.jdField_a_of_type_AndroidViewView;
    boolean bool = false;
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = getChildAt(0);
    }
    if (!b(localView1, paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          float f2 = this.jdField_a_of_type_Float;
          if (f2 == -3.402824E+038F)
          {
            this.jdField_a_of_type_Float = f1;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          f2 = -(f1 - f2);
          float f3 = a(f2);
          if (QLog.isColorLevel())
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("NKSS=");
            paramMotionEvent.append(f3);
            paramMotionEvent.append(" differ=");
            paramMotionEvent.append(f2);
            QLog.d("UUUU", 2, paramMotionEvent.toString());
          }
          if ((this.jdField_b_of_type_Boolean) && (f3 != 0.0F)) {
            scrollBy(0, (int)f3);
          } else if (f3 > 0.0F) {
            scrollBy(0, (int)f3);
          }
          if (Math.abs(f2) > 5.0F) {
            this.d = true;
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController$AtPanelTouchListener;
          if (paramMotionEvent != null)
          {
            if (getScrollY() > 0) {
              bool = true;
            }
            paramMotionEvent.a(bool);
          }
          this.jdField_a_of_type_Float = f1;
          return true;
        }
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Float = -3.402824E+038F;
      if (!this.d) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      if (-getScrollY() < a()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 1)
      {
        a(0);
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController$AtPanelTouchListener != null)
      {
        this.e = true;
        a(-this.jdField_b_of_type_Int);
      }
      return false;
    }
    this.d = false;
    this.jdField_a_of_type_Float = paramMotionEvent.getY();
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setAtPanelTouchListener(AtPanelTouchController.AtPanelTouchListener paramAtPanelTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController$AtPanelTouchListener = paramAtPanelTouchListener;
  }
  
  public void setControlLitTongue(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setDisableMinScrollY(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setHeadView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPanelTouchController
 * JD-Core Version:    0.7.0.1
 */