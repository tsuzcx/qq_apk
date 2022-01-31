package com.tencent.mobileqq.werewolves;

import aepe;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class GameView
  extends FrameLayout
{
  aepe a;
  
  public GameView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GameView(Context paramContext, aepe paramaepe)
  {
    super(paramContext);
    this.a = paramaepe;
  }
  
  public GameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.aU();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.GameView
 * JD-Core Version:    0.7.0.1
 */