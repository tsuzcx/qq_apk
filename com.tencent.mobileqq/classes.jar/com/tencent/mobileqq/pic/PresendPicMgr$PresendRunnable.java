package com.tencent.mobileqq.pic;

import atpg;
import atqi;

class PresendPicMgr$PresendRunnable
  implements Runnable
{
  private atqi a;
  
  public PresendPicMgr$PresendRunnable(PresendPicMgr paramPresendPicMgr, atqi paramatqi)
  {
    this.a = paramatqi;
  }
  
  public void run()
  {
    atpg.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendRunnable
 * JD-Core Version:    0.7.0.1
 */