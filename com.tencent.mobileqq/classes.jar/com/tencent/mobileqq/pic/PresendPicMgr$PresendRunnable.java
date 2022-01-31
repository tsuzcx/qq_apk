package com.tencent.mobileqq.pic;

import awiw;
import awjz;

class PresendPicMgr$PresendRunnable
  implements Runnable
{
  private awjz a;
  
  public PresendPicMgr$PresendRunnable(PresendPicMgr paramPresendPicMgr, awjz paramawjz)
  {
    this.a = paramawjz;
  }
  
  public void run()
  {
    awiw.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendRunnable
 * JD-Core Version:    0.7.0.1
 */