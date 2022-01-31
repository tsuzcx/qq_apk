package com.tencent.mobileqq.emosm.web;

import andq;
import android.os.Handler;
import android.os.HandlerThread;

public class EmojiIPCAlarmer
{
  andq jdField_a_of_type_Andq;
  private volatile Handler jdField_a_of_type_AndroidOsHandler;
  
  public EmojiIPCAlarmer(andq paramandq)
  {
    this.jdField_a_of_type_Andq = paramandq;
  }
  
  public Runnable a(int paramInt, long paramLong)
  {
    EmojiIPCAlarmer.TimeoutTaskWrapper localTimeoutTaskWrapper = new EmojiIPCAlarmer.TimeoutTaskWrapper(this, paramInt);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(localTimeoutTaskWrapper, paramLong);
    return localTimeoutTaskWrapper;
  }
  
  public void a()
  {
    HandlerThread localHandlerThread = new HandlerThread("EmojiIPCTimeoutChecker", 5);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer
 * JD-Core Version:    0.7.0.1
 */