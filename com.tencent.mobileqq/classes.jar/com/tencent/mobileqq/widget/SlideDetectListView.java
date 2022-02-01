package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class SlideDetectListView
  extends XListView
  implements MotionViewSetter
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 0;
  protected GestureDetector.SimpleOnGestureListener a;
  protected GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  private SlideDetectListView.OnSlideListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener = null;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  private AbsListView.OnScrollListener jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  protected boolean c;
  protected int d;
  protected boolean d;
  protected int e;
  protected boolean e;
  int f;
  
  public SlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new SlideDetectListView.1(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_e_of_type_Boolean = false;
    super.setOnScrollListener(new SlideDetectListView.2(this));
    this.f = (ViewConfiguration.getTouchSlop() + 2);
  }
  
  protected int a(int paramInt)
  {
    int j = getChildCount();
    if (j > 0)
    {
      View localView;
      if (!isStackFromBottom())
      {
        i = 0;
        while (i < j)
        {
          localView = getChildAt(i);
          if (paramInt <= localView.getBottom())
          {
            if (this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(localView.hashCode()))) {
              return -1;
            }
            i += getFirstVisiblePosition();
            paramInt = i;
            if (isOverscrollHeadVisiable()) {
              paramInt = i - 1;
            }
            return paramInt;
          }
          i += 1;
        }
      }
      int i = j - 1;
      while (i >= 0)
      {
        localView = getChildAt(i);
        if (paramInt >= localView.getTop())
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(localView.hashCode()))) {
            return -1;
          }
          i += getFirstVisiblePosition();
          paramInt = i;
          if (isOverscrollHeadVisiable()) {
            paramInt = i - 1;
          }
          return paramInt;
        }
        i -= 1;
      }
    }
    return -1;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected View a(int paramInt)
  {
    if (paramInt != -1) {
      try
      {
        View localView = getChildAt(paramInt - getFirstVisiblePosition());
        return localView;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramView.hashCode()));
    super.addFooterView(paramView, paramObject, paramBoolean);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramView.hashCode()));
    super.addHeaderView(paramView, paramObject, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean == true)
    {
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).setPressed(false);
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener;
        if (localObject != null) {
          ((SlideDetectListView.OnSlideListener)localObject).b(this, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int - getHeaderViewsCount());
        }
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void c()
  {
    b();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector == null)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener, new Handler(Looper.getMainLooper()));
      this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        this.jdField_b_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
      this.jdField_e_of_type_Boolean = false;
      i = a(this.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_AndroidViewView != null) && (a(i) == this.jdField_a_of_type_AndroidViewView))
      {
        if (paramMotionEvent.getX() >= this.jdField_a_of_type_AndroidViewView.getWidth() - this.jdField_d_of_type_Int)
        {
          if ((this.jdField_e_of_type_Int > 0) && (this.jdField_a_of_type_AndroidViewView.getHeight() > 0))
          {
            i = this.jdField_a_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_AndroidViewView.getHeight() / 2;
            int k = this.jdField_e_of_type_Int;
            int j = k / 2;
            k /= 2;
            int m = this.jdField_a_of_type_Int;
            if ((m > j + i) || (m < i - k))
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("accurate in delete:ycenter:");
                localStringBuilder.append(i);
                localStringBuilder.append(",motionheight:");
                localStringBuilder.append(this.jdField_a_of_type_AndroidViewView.getHeight());
                localStringBuilder.append("deleareaHeight:");
                localStringBuilder.append(this.jdField_e_of_type_Int);
                QLog.d("SlideDetectListView", 2, localStringBuilder.toString());
              }
              i = 0;
              break label308;
            }
          }
          i = 1;
          label308:
          if (i != 0)
          {
            this.jdField_e_of_type_Boolean = true;
            return false;
          }
        }
      }
      else if (this.jdField_a_of_type_Boolean == true) {
        return true;
      }
    }
    if (this.jdField_e_of_type_Boolean == true) {
      return false;
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      if (this.jdField_a_of_type_Boolean == true) {
        return true;
      }
      if (this.jdField_b_of_type_Boolean) {
        return false;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      if (this.jdField_a_of_type_Boolean == true)
      {
        paramMotionEvent = this.jdField_a_of_type_AndroidViewView;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.setPressed(false);
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener;
          if (paramMotionEvent != null) {
            paramMotionEvent.b(this, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int - getHeaderViewsCount());
          }
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewView = null;
        return false;
      }
    }
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Boolean != true)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    setPressed(false);
    paramMotionEvent = this.jdField_a_of_type_AndroidViewView;
    if (paramMotionEvent != null) {
      paramMotionEvent.setPressed(false);
    }
    return true;
  }
  
  public boolean removeFooterView(View paramView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(Integer.valueOf(paramView.hashCode()));
    return super.removeFooterView(paramView);
  }
  
  public boolean removeHeaderView(View paramView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(Integer.valueOf(paramView.hashCode()));
    return super.removeHeaderView(paramView);
  }
  
  public void setCanSlide(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setCheckStateWhenSlide(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = (paramBoolean ^ true);
  }
  
  public void setDeleteAreaDim(int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
  }
  
  public void setDeleteAreaWidth(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setMotionView(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_Int = (paramInt + getHeaderViewsCount());
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void setOnScrollGroupFloatingListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {}
  
  public void setOnScrollToTopListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setOnSlideListener(SlideDetectListView.OnSlideListener paramOnSlideListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener = paramOnSlideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDetectListView
 * JD-Core Version:    0.7.0.1
 */