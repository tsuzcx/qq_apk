package com.tencent.mobileqq.wink.editor.music.lyric.widget;

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
  protected Scroller b;
  protected boolean c = false;
  protected volatile boolean d = true;
  protected int e = 150;
  private volatile boolean f = true;
  private volatile boolean g;
  private LyricViewScroll.LyricViewScrollListener h;
  private LyricViewScroll.LyicViewScrollSeekListener i;
  private Handler j = new LyricViewScroll.1(this);
  
  public LyricViewScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  public void a(int paramInt)
  {
    if ((!this.g) && (this.d))
    {
      paramInt -= this.a;
      if (paramInt != 0)
      {
        if (Math.abs(paramInt) > 300)
        {
          localObject = this.i;
          if (localObject != null) {
            ((LyricViewScroll.LyicViewScrollSeekListener)localObject).a();
          }
        }
        Object localObject = this.b;
        ((Scroller)localObject).startScroll(((Scroller)localObject).getFinalX(), this.a, 0, paramInt, 600);
        this.a = this.b.getFinalY();
        invalidate();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.f) {
      return true;
    }
    int k = paramMotionEvent.getAction() & 0xFF;
    if (k != 0)
    {
      if (k != 1)
      {
        Object localObject;
        if (k != 2)
        {
          if (k != 3)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("default:");
            ((StringBuilder)localObject).append(paramMotionEvent.getAction());
            Log.v("LyricViewScroll", ((StringBuilder)localObject).toString());
          }
          else
          {
            Log.v("LyricViewScroll", "onTouchEvent -> ACTION_CANCEL");
            this.a = getScrollY();
            localObject = this.h;
            if (localObject != null) {
              ((LyricViewScroll.LyricViewScrollListener)localObject).b(this.a);
            }
            this.g = false;
            this.j.sendEmptyMessageDelayed(1, 100L);
          }
        }
        else
        {
          this.g = true;
          localObject = this.h;
          if (localObject != null) {
            ((LyricViewScroll.LyricViewScrollListener)localObject).a(getScrollY());
          }
        }
      }
      else
      {
        Log.v("LyricViewScroll", "onTouchEvent -> ACTION_UP");
        this.j.sendEmptyMessageDelayed(1, 100L);
      }
    }
    else
    {
      Log.v("LyricViewScroll", "onTouchEvent -> ACTION_DOWN");
      this.g = true;
      this.j.removeMessages(1);
    }
    try
    {
      this.b.forceFinished(true);
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
    if (!this.g)
    {
      this.b.forceFinished(true);
      this.a = paramInt;
      scrollTo(0, paramInt);
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((!this.g) && (this.b.computeScrollOffset()))
    {
      smoothScrollTo(this.b.getCurrX(), this.b.getCurrY());
      postInvalidate();
      if (this.b.isFinished())
      {
        LyricViewScroll.LyicViewScrollSeekListener localLyicViewScrollSeekListener = this.i;
        if (localLyicViewScrollSeekListener != null) {
          localLyicViewScrollSeekListener.b();
        }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOverScrollMode begin -> mIsNeedEdgeGlow:");
    localStringBuilder.append(this.c);
    Log.d("LyricViewScroll", localStringBuilder.toString());
    if (this.c)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOverScrollMode -> mode:");
      localStringBuilder.append(paramInt);
      Log.d("LyricViewScroll", localStringBuilder.toString());
      super.setOverScrollMode(paramInt);
      return;
    }
    super.setOverScrollMode(2);
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setScrollListener(LyricViewScroll.LyricViewScrollListener paramLyricViewScrollListener)
  {
    this.h = paramLyricViewScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewScroll
 * JD-Core Version:    0.7.0.1
 */