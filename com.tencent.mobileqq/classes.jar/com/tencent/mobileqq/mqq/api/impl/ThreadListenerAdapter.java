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
    IThreadListener localIThreadListener = this.mThreadListener;
    if (localIThreadListener != null) {
      localIThreadListener.a();
    }
  }
  
  public void onPostRun()
  {
    IThreadListener localIThreadListener = this.mThreadListener;
    if (localIThreadListener != null) {
      localIThreadListener.c();
    }
  }
  
  public void onPreRun()
  {
    IThreadListener localIThreadListener = this.mThreadListener;
    if (localIThreadListener != null) {
      localIThreadListener.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mqq.api.impl.ThreadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */