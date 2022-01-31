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
    if (this.this$0.mStartAttr.mDir) {}
    for (int i = 1;; i = 2)
    {
      this.mCurrDragState = i;
      return;
    }
  }
  
  public boolean handleMoveTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.this$0.mStartAttr.mPointerId != paramMotionEvent.getPointerId(0)) {
      this.this$0.issueStateTransition(this.this$0.mBounceBackState);
    }
    View localView;
    do
    {
      return true;
      localView = this.this$0.mViewAdapter.getView();
    } while (!this.mMoveAttr.init(localView, paramMotionEvent));
    float f2 = this.mMoveAttr.mDeltaOffset;
    if (this.mMoveAttr.mDir == this.this$0.mStartAttr.mDir) {}
    for (float f1 = this.mTouchDragRatioFwd;; f1 = this.mTouchDragRatioBck)
    {
      f1 = f2 / f1;
      f2 = this.mMoveAttr.mAbsOffset + this.mMoveAttr.mDeltaOffset;
      if (((!this.this$0.mStartAttr.mDir) || (this.mMoveAttr.mDir) || (f2 > this.this$0.mStartAttr.mAbsOffset)) && ((this.this$0.mStartAttr.mDir) || (!this.mMoveAttr.mDir) || (f2 < this.this$0.mStartAttr.mAbsOffset))) {
        break;
      }
      this.this$0.translateViewAndEvent(localView, this.this$0.mStartAttr.mAbsOffset, paramMotionEvent);
      this.this$0.issueStateTransition(this.this$0.mIdleState);
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
    this.this$0.issueStateTransition(this.this$0.mBounceBackState);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.AbsOverScrollDecorator.OverScrollingState
 * JD-Core Version:    0.7.0.1
 */