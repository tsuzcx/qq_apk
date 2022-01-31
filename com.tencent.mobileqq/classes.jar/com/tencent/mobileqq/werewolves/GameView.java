package com.tencent.mobileqq.werewolves;

import agmb;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class GameView
  extends FrameLayout
{
  agmb a;
  
  public GameView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GameView(Context paramContext, agmb paramagmb)
  {
    super(paramContext);
    this.a = paramagmb;
  }
  
  public GameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.aW();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.GameView
 * JD-Core Version:    0.7.0.1
 */