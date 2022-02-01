package com.tencent.mobileqq.qassistant.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qassistant.listener.IPanelDragListener;
import com.tencent.mobileqq.qassistant.listener.IPanelSlideListener;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class VoicePanelSlideContainer
  extends RelativeLayout
  implements View.OnLayoutChangeListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 20;
  private Context jdField_a_of_type_AndroidContentContext;
  private IPanelDragListener jdField_a_of_type_ComTencentMobileqqQassistantListenerIPanelDragListener;
  private IPanelSlideListener jdField_a_of_type_ComTencentMobileqqQassistantListenerIPanelSlideListener;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  private int c;
  
  public VoicePanelSlideContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoicePanelSlideContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoicePanelSlideContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramContext != null) {
      this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    }
    addOnLayoutChangeListener(this);
  }
  
  private void a()
  {
    int i = (int)getY();
    ObjectAnimator localObjectAnimator;
    if (i - this.b > getMeasuredHeight() / 2)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, "y", new float[] { i, this.c });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.addListener(new VoicePanelSlideContainer.1(this));
      localObjectAnimator.start();
      return;
    }
    int j = this.b;
    if (i > j)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, "y", new float[] { i, j });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.addListener(new VoicePanelSlideContainer.2(this));
      localObjectAnimator.start();
      return;
    }
    if (i == j) {
      a(false);
    }
  }
  
  private void a(int paramInt)
  {
    if ((getY() <= this.b) && (paramInt == 0))
    {
      a(false);
      return;
    }
    a(true);
    offsetTopAndBottom(paramInt);
  }
  
  private void a(boolean paramBoolean)
  {
    IPanelDragListener localIPanelDragListener = this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIPanelDragListener;
    if (localIPanelDragListener != null) {
      localIPanelDragListener.b(paramBoolean);
    }
  }
  
  private void b()
  {
    IPanelSlideListener localIPanelSlideListener = this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIPanelSlideListener;
    if (localIPanelSlideListener != null) {
      localIPanelSlideListener.b();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label101;
          }
        }
        else
        {
          float f = paramMotionEvent.getY();
          if (Math.abs(this.jdField_a_of_type_Float - f) > this.jdField_a_of_type_Int) {
            bool = true;
          }
          this.jdField_a_of_type_Boolean = bool;
          if (!this.jdField_a_of_type_Boolean) {
            break label101;
          }
          this.jdField_a_of_type_Float = paramMotionEvent.getY();
          break label101;
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Boolean = false;
    }
    label101:
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = this.jdField_a_of_type_AndroidContentContext;
    if (paramView != null) {
      this.c = ScreenUtil.getRealHeight(paramView);
    }
    this.b = ((int)getY());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          int k = (int)getY();
          int j = (int)(paramMotionEvent.getY() - this.jdField_a_of_type_Float);
          int m = this.b;
          i = j;
          if (k + j < m) {
            i = m - k;
          }
          a(i);
          return true;
        }
      }
      this.jdField_a_of_type_Boolean = false;
      a();
      return true;
    }
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public void setPanelDragListener(IPanelDragListener paramIPanelDragListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIPanelDragListener = paramIPanelDragListener;
  }
  
  public void setPanelSlideListener(IPanelSlideListener paramIPanelSlideListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIPanelSlideListener = paramIPanelSlideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoicePanelSlideContainer
 * JD-Core Version:    0.7.0.1
 */