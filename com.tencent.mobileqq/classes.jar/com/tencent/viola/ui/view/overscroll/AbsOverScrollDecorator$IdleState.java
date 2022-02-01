package com.tencent.viola.ui.view.overscroll;

import android.view.MotionEvent;
import android.view.View;

public class AbsOverScrollDecorator$IdleState
  implements AbsOverScrollDecorator.IDecoratorState
{
  final AbsOverScrollDecorator.MotionAttributes mMoveAttr;
  
  public AbsOverScrollDecorator$IdleState(AbsOverScrollDecorator paramAbsOverScrollDecorator)
  {
    this.mMoveAttr = paramAbsOverScrollDecorator.createMotionAttributes();
  }
  
  public void handleEntryTransition(AbsOverScrollDecorator.IDecoratorState paramIDecoratorState) {}
  
  public boolean handleMoveTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.this$0.mViewAdapter.getView();
    if (!this.mMoveAttr.init((View)localObject, paramMotionEvent)) {
      return false;
    }
    if (((this.this$0.mViewAdapter.isInAbsoluteStart()) && (this.mMoveAttr.mDir)) || ((this.this$0.mViewAdapter.isInAbsoluteEnd()) && (!this.mMoveAttr.mDir)))
    {
      this.this$0.mStartAttr.mPointerId = paramMotionEvent.getPointerId(0);
      this.this$0.mStartAttr.mAbsOffset = this.mMoveAttr.mAbsOffset;
      this.this$0.mStartAttr.mDir = this.mMoveAttr.mDir;
      localObject = this.this$0;
      ((AbsOverScrollDecorator)localObject).issueStateTransition(((AbsOverScrollDecorator)localObject).mOverScrollingState);
      return this.this$0.mOverScrollingState.handleMoveTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.AbsOverScrollDecorator.IdleState
 * JD-Core Version:    0.7.0.1
 */