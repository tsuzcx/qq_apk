package com.tencent.mobileqq.emosm.web;

import abtq;
import android.os.Handler;
import android.os.HandlerThread;

public class EmojiIPCAlarmer
{
  private volatile Handler a;
  public EmojiIPCAlarmer.TimeoutObserver a;
  
  public EmojiIPCAlarmer(EmojiIPCAlarmer.TimeoutObserver paramTimeoutObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer$TimeoutObserver = paramTimeoutObserver;
  }
  
  public Runnable a(int paramInt, long paramLong)
  {
    abtq localabtq = new abtq(this, paramInt);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(localabtq, paramLong);
    return localabtq;
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