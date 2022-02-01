package com.tencent.viola.ui.view.overscroll;

import android.view.MotionEvent;

public abstract interface AbsOverScrollDecorator$IDecoratorState
{
  public abstract void handleEntryTransition(IDecoratorState paramIDecoratorState);
  
  public abstract boolean handleMoveTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.AbsOverScrollDecorator.IDecoratorState
 * JD-Core Version:    0.7.0.1
 */