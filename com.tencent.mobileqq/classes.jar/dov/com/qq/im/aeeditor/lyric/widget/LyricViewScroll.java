package dov.com.qq.im.aeeditor.lyric.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;

public class LyricViewScroll
  extends ScrollView
{
  protected volatile int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new LyricViewScroll.1(this);
  protected Scroller a;
  private LyricViewScroll.LyicViewScrollSeekListener jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyicViewScrollSeekListener;
  private LyricViewScroll.LyricViewScrollListener jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyricViewScrollListener;
  protected boolean a;
  protected int b;
  protected volatile boolean b;
  private volatile boolean c = true;
  private volatile boolean d;
  
  public LyricViewScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 150;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  public void a(int paramInt)
  {
    if ((!this.d) && (this.jdField_b_of_type_Boolean))
    {
      paramInt -= this.jdField_a_of_type_Int;
      if (paramInt != 0)
      {
        if ((Math.abs(paramInt) > 300) && (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyicViewScrollSeekListener != null)) {
          this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyicViewScrollSeekListener.a();
        }
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidWidgetScroller.getFinalX(), this.jdField_a_of_type_Int, 0, paramInt, 600);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getFinalY();
        invalidate();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.c) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      Log.v("LyricViewScroll", "default:" + paramMotionEvent.getAction());
    }
    for (;;)
    {
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
      Log.v("LyricViewScroll", "onTouchEvent -> ACTION_DOWN");
      this.d = true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      continue;
      this.d = true;
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyricViewScrollListener != null)
      {
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyricViewScrollListener.a(getScrollY());
        continue;
        Log.v("LyricViewScroll", "onTouchEvent -> ACTION_UP");
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
        continue;
        Log.v("LyricViewScroll", "onTouchEvent -> ACTION_CANCEL");
        this.jdField_a_of_type_Int = getScrollY();
        if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyricViewScrollListener != null) {
          this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyricViewScrollListener.b(this.jdField_a_of_type_Int);
        }
        this.d = false;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
      }
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    if (!this.d)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      this.jdField_a_of_type_Int = paramInt;
      scrollTo(0, paramInt);
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((!this.d) && (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()))
    {
      smoothScrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
      if ((this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) && (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyicViewScrollSeekListener != null)) {
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyicViewScrollSeekListener.b();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    Log.d("LyricViewScroll", "setOverScrollMode begin -> mIsNeedEdgeGlow:" + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      Log.d("LyricViewScroll", "setOverScrollMode -> mode:" + paramInt);
      super.setOverScrollMode(paramInt);
      return;
    }
    super.setOverScrollMode(2);
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setScrollListener(LyricViewScroll.LyricViewScrollListener paramLyricViewScrollListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll$LyricViewScrollListener = paramLyricViewScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewScroll
 * JD-Core Version:    0.7.0.1
 */