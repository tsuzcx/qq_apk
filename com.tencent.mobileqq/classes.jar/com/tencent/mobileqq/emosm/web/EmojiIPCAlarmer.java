package com.tencent.mobileqq.emosm.web;

import android.os.Handler;
import android.os.HandlerThread;
import asij;

public class EmojiIPCAlarmer
{
  private volatile Handler jdField_a_of_type_AndroidOsHandler;
  asij jdField_a_of_type_Asij;
  
  public EmojiIPCAlarmer(asij paramasij)
  {
    this.jdField_a_of_type_Asij = paramasij;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer
 * JD-Core Version:    0.7.0.1
 */