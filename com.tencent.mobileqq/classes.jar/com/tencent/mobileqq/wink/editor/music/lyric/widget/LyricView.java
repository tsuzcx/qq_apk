package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.wink.R.styleable;

public class LyricView
  extends FrameLayout
{
  protected LyricViewInternalBase a;
  protected LyricViewScroll b;
  protected LyricViewAttribute c;
  protected boolean d;
  protected boolean e = true;
  protected View.OnClickListener f;
  protected LyricView.OnLineClickListener g;
  protected LyricView.OnLyricViewLongClickListener h;
  protected PointF i = new PointF();
  protected PointF j = new PointF();
  protected boolean k = false;
  protected boolean l = true;
  protected boolean m = false;
  private Handler n = new LyricView.1(this);
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.i, 0, 0);
    this.c = new LyricViewAttribute();
    this.c.a(paramContext);
    this.d = paramContext.getBoolean(R.styleable.y, false);
    paramContext.recycle();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.b.a(paramMotionEvent);
  }
  
  public LyricViewInternalBase getLyricViewInternal()
  {
    return this.a;
  }
  
  public LyricViewScroll getScrollView()
  {
    return this.b;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3) {
            this.n.removeMessages(10);
          }
        }
        else
        {
          this.j.set(f1, f2);
          if ((Math.abs(this.i.x - f1) > 10.0F) || (Math.abs(this.i.y - f2) > 10.0F)) {
            this.k = false;
          }
          if (Math.abs(f2 - this.i.y) > 10.0F) {
            this.l = false;
          }
        }
      }
      else
      {
        this.n.removeMessages(10);
        if ((!this.m) && (Math.abs(this.i.x - f1) < 10.0F) && (Math.abs(this.i.y - f2) < 10.0F))
        {
          View.OnClickListener localOnClickListener = this.f;
          if ((localOnClickListener != null) && (this.k)) {
            localOnClickListener.onClick(this);
          }
        }
        if ((!this.m) && (this.l) && (this.g != null))
        {
          i1 = (int)(this.b.getScrollY() + f2);
          i1 = this.a.c(i1);
          this.g.a(i1);
        }
        this.l = true;
        this.m = false;
        this.i.set(0.0F, 0.0F);
        this.j.set(f1, f2);
        this.k = false;
      }
    }
    else
    {
      this.i.set(f1, f2);
      this.j.set(f1, f2);
      this.k = true;
      this.n.sendEmptyMessageDelayed(10, 1000L);
    }
    if (this.e)
    {
      a(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void setIsDealTouchEvent(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.f = paramOnClickListener;
  }
  
  public void setOnLineClickListener(LyricView.OnLineClickListener paramOnLineClickListener)
  {
    this.g = paramOnLineClickListener;
  }
  
  public void setOnLyricViewLongClickListener(LyricView.OnLyricViewLongClickListener paramOnLyricViewLongClickListener)
  {
    this.h = paramOnLyricViewLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricView
 * JD-Core Version:    0.7.0.1
 */