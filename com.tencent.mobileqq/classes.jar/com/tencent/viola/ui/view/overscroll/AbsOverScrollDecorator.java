package com.tencent.viola.ui.view.overscroll;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public abstract class AbsOverScrollDecorator
  implements View.OnTouchListener
{
  public static final float DEFAULT_DECELERATE_FACTOR = -2.0F;
  public static final float DEFAULT_TOUCH_DRAG_MOVE_RATIO_BCK = 1.0F;
  public static final float DEFAULT_TOUCH_DRAG_MOVE_RATIO_FWD = 3.0F;
  protected static final int MAX_BOUNCE_BACK_DURATION_MS = 800;
  protected static final int MIN_BOUNCE_BACK_DURATION_MS = 200;
  public static final int STATE_DRAG_END_SIDE = 2;
  public static final int STATE_DRAG_START_SIDE = 1;
  public static final int STATE_IDLE = 0;
  protected final AbsOverScrollDecorator.BounceBackState mBounceBackState;
  protected AbsOverScrollDecorator.IDecoratorState mCurrentState;
  protected final AbsOverScrollDecorator.IdleState mIdleState;
  protected final AbsOverScrollDecorator.OverScrollingState mOverScrollingState;
  protected final AbsOverScrollDecorator.OverScrollStartAttributes mStartAttr = new AbsOverScrollDecorator.OverScrollStartAttributes();
  protected float mVelocity;
  protected final AbsOverScrollDecorator.IOverScrollDecoratorAdapter mViewAdapter;
  
  public AbsOverScrollDecorator(AbsOverScrollDecorator.IOverScrollDecoratorAdapter paramIOverScrollDecoratorAdapter, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mViewAdapter = paramIOverScrollDecoratorAdapter;
    this.mBounceBackState = new AbsOverScrollDecorator.BounceBackState(this, paramFloat1);
    this.mOverScrollingState = new AbsOverScrollDecorator.OverScrollingState(this, paramFloat2, paramFloat3);
    this.mIdleState = new AbsOverScrollDecorator.IdleState(this);
    this.mCurrentState = this.mIdleState;
    attach();
  }
  
  protected void attach()
  {
    getView().setOnTouchListener(this);
    getView().setOverScrollMode(2);
  }
  
  protected abstract AbsOverScrollDecorator.AnimationAttributes createAnimationAttributes();
  
  protected abstract AbsOverScrollDecorator.MotionAttributes createMotionAttributes();
  
  public View getView()
  {
    return this.mViewAdapter.getView();
  }
  
  protected void issueStateTransition(AbsOverScrollDecorator.IDecoratorState paramIDecoratorState)
  {
    AbsOverScrollDecorator.IDecoratorState localIDecoratorState = this.mCurrentState;
    this.mCurrentState = paramIDecoratorState;
    this.mCurrentState.handleEntryTransition(localIDecoratorState);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3) {
          return false;
        }
      }
      else {
        return this.mCurrentState.handleMoveTouchEvent(paramMotionEvent);
      }
    }
    return this.mCurrentState.handleUpOrCancelTouchEvent(paramMotionEvent);
  }
  
  protected abstract void translateView(View paramView, float paramFloat);
  
  protected abstract void translateViewAndEvent(View paramView, float paramFloat, MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.AbsOverScrollDecorator
 * JD-Core Version:    0.7.0.1
 */