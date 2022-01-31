package com.tencent.mobileqq.pic;

import awen;
import awfq;

class PresendPicMgr$PresendRunnable
  implements Runnable
{
  private awfq a;
  
  public PresendPicMgr$PresendRunnable(PresendPicMgr paramPresendPicMgr, awfq paramawfq)
  {
    this.a = paramawfq;
  }
  
  public void run()
  {
    awen.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendRunnable
 * JD-Core Version:    0.7.0.1
 */