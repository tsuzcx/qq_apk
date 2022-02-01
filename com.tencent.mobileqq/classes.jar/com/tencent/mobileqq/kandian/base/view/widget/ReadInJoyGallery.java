package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.widget.Gallery;

public class ReadInJoyGallery
  extends Gallery
{
  public static final String a;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(getContext());
  protected ReadInJoyGallery.OnDoubleTapListener a;
  private ReadInJoyGallery.OnScrollChangeListener jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyGallery$OnScrollChangeListener;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.atlas.");
    localStringBuilder.append(ReadInJoyGallery.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public ReadInJoyGallery(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  protected void a()
  {
    setMaxScale(2.147484E+009F);
    this.jdField_a_of_type_Int = (ViewConfiguration.get(getContext()).getScaledTouchSlop() / 3);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j != 1)
      {
        int i = 2;
        if (j == 2)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            if (this.jdField_b_of_type_Boolean)
            {
              super.dispatchTouchEvent(paramMotionEvent);
              return true;
            }
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          float f1 = paramMotionEvent.getX() - this.jdField_a_of_type_Float;
          float f2 = paramMotionEvent.getY() - this.jdField_b_of_type_Float;
          if ((Math.abs(f1) <= this.jdField_a_of_type_Int) && (Math.abs(f2) <= this.jdField_a_of_type_Int)) {
            return true;
          }
          this.jdField_a_of_type_Boolean = true;
          if (Math.abs(f1) > Math.abs(f2))
          {
            this.jdField_b_of_type_Boolean = true;
            this.d = true;
            if (f1 < 0.0F) {
              i = 1;
            }
            this.jdField_b_of_type_Int = i;
            super.dispatchTouchEvent(paramMotionEvent);
            return true;
          }
          if (this.mIsScaling)
          {
            this.jdField_b_of_type_Boolean = true;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          this.jdField_b_of_type_Boolean = false;
          return super.dispatchTouchEvent(paramMotionEvent);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.d = false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void forceLayout()
  {
    super.forceLayout();
  }
  
  public boolean isNeedSetLongPicAction()
  {
    return true;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    ReadInJoyGallery.OnDoubleTapListener localOnDoubleTapListener = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyGallery$OnDoubleTapListener;
    if (localOnDoubleTapListener != null) {
      localOnDoubleTapListener.a();
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.f)
    {
      if (paramMotionEvent.getPointerCount() >= 2) {
        return false;
      }
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return super.onInterceptTouchEvent(paramMotionEvent);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            if (this.f)
            {
              if ((this.d) && (this.jdField_b_of_type_Int == 2)) {
                return super.onInterceptTouchEvent(paramMotionEvent);
              }
              return false;
            }
            return super.onInterceptTouchEvent(paramMotionEvent);
          }
          return false;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.d) {
            return super.onInterceptTouchEvent(paramMotionEvent);
          }
          onTouchEvent(paramMotionEvent);
          return false;
        }
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent.setAction(3);
        onTouchEvent(paramMotionEvent);
        return false;
      }
      onTouchEvent(paramMotionEvent);
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public void setIsListPage(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setOnDoubleTapListener(ReadInJoyGallery.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyGallery$OnDoubleTapListener = paramOnDoubleTapListener;
  }
  
  public void setOnScrollChangeListener(ReadInJoyGallery.OnScrollChangeListener paramOnScrollChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyGallery$OnScrollChangeListener = paramOnScrollChangeListener;
  }
  
  protected void trackMotionScroll(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.trackMotionScroll(paramInt1, paramInt2, paramBoolean);
    ReadInJoyGallery.OnScrollChangeListener localOnScrollChangeListener = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyGallery$OnScrollChangeListener;
    if (localOnScrollChangeListener != null) {
      localOnScrollChangeListener.a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyGallery
 * JD-Core Version:    0.7.0.1
 */