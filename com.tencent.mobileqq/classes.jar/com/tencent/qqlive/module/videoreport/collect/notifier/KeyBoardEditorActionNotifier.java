package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

public class KeyBoardEditorActionNotifier
  implements IEventNotifier
{
  private int mActionId;
  private int mFrom;
  private KeyEvent mKeyEvent;
  private TextView mView;
  
  public int getReuseType()
  {
    return 11;
  }
  
  public void init(TextView paramTextView, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    this.mView = paramTextView;
    this.mActionId = paramInt1;
    this.mKeyEvent = paramKeyEvent;
    this.mFrom = paramInt2;
  }
  
  public void notifyEvent(IEventListener paramIEventListener)
  {
    paramIEventListener.onEditorAction(this.mView, this.mActionId, this.mKeyEvent, this.mFrom);
  }
  
  public void reset()
  {
    this.mView = null;
    this.mActionId = -1;
    this.mKeyEvent = null;
    this.mFrom = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.notifier.KeyBoardEditorActionNotifier
 * JD-Core Version:    0.7.0.1
 */