package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.view.MotionEvent;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

public class DispatchTouchEventNotifier
  implements IEventNotifier
{
  private boolean mBefore;
  private MotionEvent mEvent;
  private boolean mResult;
  private Object mSender;
  private Window mWindow;
  
  public int getReuseType()
  {
    return 10;
  }
  
  public void init(Object paramObject, Window paramWindow, MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mSender = paramObject;
    this.mWindow = paramWindow;
    this.mEvent = paramMotionEvent;
    this.mResult = paramBoolean1;
    this.mBefore = paramBoolean2;
  }
  
  public void notifyEvent(IEventListener paramIEventListener)
  {
    paramIEventListener.onDispatchTouchEvent(this.mSender, this.mWindow, this.mEvent, this.mResult, this.mBefore);
  }
  
  public void reset()
  {
    this.mSender = null;
    this.mWindow = null;
    this.mEvent = null;
    this.mResult = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.notifier.DispatchTouchEventNotifier
 * JD-Core Version:    0.7.0.1
 */