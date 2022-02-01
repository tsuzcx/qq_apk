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
  protected Timer a;
  protected volatile boolean b = false;
  protected volatile int c;
  protected Scroller d;
  private volatile boolean e = true;
  private volatile boolean f;
  private LyricViewScroll.LyricViewScrollListener g;
  
  public LyricViewScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  public void a(int paramInt)
  {
    if (!this.f)
    {
      paramInt -= this.c;
      if (paramInt != 0)
      {
        Scroller localScroller = this.d;
        localScroller.startScroll(localScroller.getFinalX(), this.c, 0, paramInt, 500);
        this.c = this.d.getFinalY();
        invalidate();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
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
            this.c = getScrollY();
            this.g.b(this.c);
            this.f = false;
            if (this.b)
            {
              localObject = this.a;
              if (localObject != null)
              {
                ((Timer)localObject).cancel();
                this.b = false;
              }
            }
          }
        }
        else
        {
          this.f = true;
          localObject = this.g;
          if (localObject != null) {
            ((LyricViewScroll.LyricViewScrollListener)localObject).a(getScrollY());
          }
        }
      }
      else
      {
        Log.v("LyricViewScroll", "onTouchEvent -> ACTION_UP");
        if (!this.b)
        {
          this.b = true;
          this.a = new Timer();
          this.a.scheduleAtFixedRate(new LyricViewScroll.1(this), 100L, 100L);
        }
      }
    }
    else
    {
      Log.v("LyricViewScroll", "onTouchEvent -> ACTION_DOWN");
      this.f = true;
      if (this.b)
      {
        localObject = this.a;
        if (localObject != null)
        {
          ((Timer)localObject).cancel();
          this.b = false;
        }
      }
    }
    try
    {
      this.d.forceFinished(true);
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
    if (!this.f)
    {
      this.d.forceFinished(true);
      this.c = paramInt;
      scrollTo(0, paramInt);
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((this.d.computeScrollOffset()) && (!this.f))
    {
      smoothScrollTo(this.d.getCurrX(), this.d.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setScrollListener(LyricViewScroll.LyricViewScrollListener paramLyricViewScrollListener)
  {
    this.g = paramLyricViewScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewScroll
 * JD-Core Version:    0.7.0.1
 */