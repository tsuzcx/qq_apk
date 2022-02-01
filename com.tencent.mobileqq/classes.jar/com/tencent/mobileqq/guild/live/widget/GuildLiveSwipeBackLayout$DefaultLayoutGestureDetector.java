package com.tencent.mobileqq.guild.live.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class GuildLiveSwipeBackLayout$DefaultLayoutGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  protected GuildLiveSwipeBackLayout$DefaultLayoutGestureDetector(GuildLiveSwipeBackLayout paramGuildLiveSwipeBackLayout) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
      if ((this.a.d) && (paramFloat1 >= 200.0F))
      {
        if ((f1 < 0.0F) && (f2 < 0.5F))
        {
          GuildLiveSwipeBackLayout localGuildLiveSwipeBackLayout = this.a;
          localGuildLiveSwipeBackLayout.m = true;
          localGuildLiveSwipeBackLayout.a();
        }
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.DefaultLayoutGestureDetector
 * JD-Core Version:    0.7.0.1
 */