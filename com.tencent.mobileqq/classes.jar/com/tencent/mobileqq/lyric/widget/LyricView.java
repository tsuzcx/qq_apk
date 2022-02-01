package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;

public class LyricView
  extends FrameLayout
{
  protected LyricViewInternal a;
  protected LyricViewScroll b;
  protected LyricViewAttribute c;
  protected boolean d;
  protected boolean e = true;
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ModuleLyricView, 0, 0);
    this.c = new LyricViewAttribute();
    this.c.a(paramContext);
    this.d = paramContext.getBoolean(16, false);
    paramContext.recycle();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.b.a(paramMotionEvent);
  }
  
  public LyricViewInternal getLyricViewInternal()
  {
    return this.a;
  }
  
  public LyricViewScroll getScrollView()
  {
    return this.b;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.c(paramInt4 - paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricView
 * JD-Core Version:    0.7.0.1
 */