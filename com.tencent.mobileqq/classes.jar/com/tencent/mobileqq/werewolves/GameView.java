package com.tencent.mobileqq.werewolves;

import aeeh;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class GameView
  extends FrameLayout
{
  aeeh a;
  
  public GameView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GameView(Context paramContext, aeeh paramaeeh)
  {
    super(paramContext);
    this.a = paramaeeh;
  }
  
  public GameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.aS();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.GameView
 * JD-Core Version:    0.7.0.1
 */