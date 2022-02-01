package com.tencent.mobileqq.mqq.api.impl;

import com.tencent.mobileqq.adapter.IThreadListener;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;

public class ThreadListenerAdapter
  implements ThreadExcutor.IThreadListener
{
  private IThreadListener mThreadListener;
  
  private ThreadListenerAdapter(IThreadListener paramIThreadListener)
  {
    this.mThreadListener = paramIThreadListener;
  }
  
  static ThreadListenerAdapter from(IThreadListener paramIThreadListener)
  {
    return new ThreadListenerAdapter(paramIThreadListener);
  }
  
  public void onAdded()
  {
    if (this.mThreadListener != null) {
      this.mThreadListener.a();
    }
  }
  
  public void onPostRun()
  {
    if (this.mThreadListener != null) {
      this.mThreadListener.c();
    }
  }
  
  public void onPreRun()
  {
    if (this.mThreadListener != null) {
      this.mThreadListener.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mqq.api.impl.ThreadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */