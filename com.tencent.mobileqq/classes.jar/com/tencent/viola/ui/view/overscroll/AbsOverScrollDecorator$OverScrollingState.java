package com.tencent.viola.ui.view.overscroll;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class AbsOverScrollDecorator$OverScrollingState
  implements AbsOverScrollDecorator.IDecoratorState
{
  int mCurrDragState;
  final AbsOverScrollDecorator.MotionAttributes mMoveAttr;
  protected final float mTouchDragRatioBck;
  protected final float mTouchDragRatioFwd;
  
  public AbsOverScrollDecorator$OverScrollingState(AbsOverScrollDecorator paramAbsOverScrollDecorator, float paramFloat1, float paramFloat2)
  {
    this.mMoveAttr = paramAbsOverScrollDecorator.createMotionAttributes();
    this.mTouchDragRatioFwd = paramFloat1;
    this.mTouchDragRatioBck = paramFloat2;
  }
  
  public void handleEntryTransition(AbsOverScrollDecorator.IDecoratorState paramIDecoratorState)
  {
    int i;
    if (this.this$0.mStartAttr.mDir) {
      i = 1;
    } else {
      i = 2;
    }
    this.mCurrDragState = i;
  }
  
  public boolean handleMoveTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.this$0.mStartAttr.mPointerId != paramMotionEvent.getPointerId(0))
    {
      paramMotionEvent = this.this$0;
      paramMotionEvent.issueStateTransition(paramMotionEvent.mBounceBackState);
      return true;
    }
    View localView = this.this$0.mViewAdapter.getView();
    if (!this.mMoveAttr.init(localView, paramMotionEvent)) {
      return true;
    }
    float f2 = this.mMoveAttr.mDeltaOffset;
    if (this.mMoveAttr.mDir == this.this$0.mStartAttr.mDir) {
      f1 = this.mTouchDragRatioFwd;
    } else {
      f1 = this.mTouchDragRatioBck;
    }
    float f1 = f2 / f1;
    f2 = this.mMoveAttr.mAbsOffset + this.mMoveAttr.mDeltaOffset;
    if (((this.this$0.mStartAttr.mDir) && (!this.mMoveAttr.mDir) && (f2 <= this.this$0.mStartAttr.mAbsOffset)) || ((!this.this$0.mStartAttr.mDir) && (this.mMoveAttr.mDir) && (f2 >= this.this$0.mStartAttr.mAbsOffset)))
    {
      AbsOverScrollDecorator localAbsOverScrollDecorator = this.this$0;
      localAbsOverScrollDecorator.translateViewAndEvent(localView, localAbsOverScrollDecorator.mStartAttr.mAbsOffset, paramMotionEvent);
      paramMotionEvent = this.this$0;
      paramMotionEvent.issueStateTransition(paramMotionEvent.mIdleState);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.this$0.mVelocity = (f1 / (float)l);
    }
    this.this$0.translateView(localView, f2);
    return true;
  }
  
  public boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.this$0;
    paramMotionEvent.issueStateTransition(paramMotionEvent.mBounceBackState);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.AbsOverScrollDecorator.OverScrollingState
 * JD-Core Version:    0.7.0.1
 */