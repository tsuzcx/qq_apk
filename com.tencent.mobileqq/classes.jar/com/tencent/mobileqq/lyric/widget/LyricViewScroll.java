package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.Timer;

public class LyricViewScroll
  extends ScrollView
{
  protected volatile int a;
  protected Scroller a;
  private LyricViewScroll.LyricViewScrollListener a;
  protected Timer a;
  protected volatile boolean a;
  private volatile boolean b = true;
  private volatile boolean c;
  
  public LyricViewScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  public void a(int paramInt)
  {
    if (!this.c)
    {
      paramInt -= this.jdField_a_of_type_Int;
      if (paramInt != 0)
      {
        Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
        localScroller.startScroll(localScroller.getFinalX(), this.jdField_a_of_type_Int, 0, paramInt, 500);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getFinalY();
        invalidate();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.b) {
      return true;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("default:");
            ((StringBuilder)localObject).append(paramMotionEvent.getAction());
            Log.v("LyricViewScroll", ((StringBuilder)localObject).toString());
          }
          else
          {
            Log.v("LyricViewScroll", "onTouchEvent -> ACTION_CANCEL");
            this.jdField_a_of_type_Int = getScrollY();
            this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener.b(this.jdField_a_of_type_Int);
            this.c = false;
            if (this.jdField_a_of_type_Boolean)
            {
              localObject = this.jdField_a_of_type_JavaUtilTimer;
              if (localObject != null)
              {
                ((Timer)localObject).cancel();
                this.jdField_a_of_type_Boolean = false;
              }
            }
          }
        }
        else
        {
          this.c = true;
          localObject = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener;
          if (localObject != null) {
            ((LyricViewScroll.LyricViewScrollListener)localObject).a(getScrollY());
          }
        }
      }
      else
      {
        Log.v("LyricViewScroll", "onTouchEvent -> ACTION_UP");
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilTimer = new Timer();
          this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new LyricViewScroll.1(this), 100L, 100L);
        }
      }
    }
    else
    {
      Log.v("LyricViewScroll", "onTouchEvent -> ACTION_DOWN");
      this.c = true;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_JavaUtilTimer;
        if (localObject != null)
        {
          ((Timer)localObject).cancel();
          this.jdField_a_of_type_Boolean = false;
        }
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      Log.e("LyricViewScroll", paramMotionEvent.toString());
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    if (!this.c)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      this.jdField_a_of_type_Int = paramInt;
      scrollTo(0, paramInt);
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) && (!this.c))
    {
      smoothScrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setScrollListener(LyricViewScroll.LyricViewScrollListener paramLyricViewScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener = paramLyricViewScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewScroll
 * JD-Core Version:    0.7.0.1
 */