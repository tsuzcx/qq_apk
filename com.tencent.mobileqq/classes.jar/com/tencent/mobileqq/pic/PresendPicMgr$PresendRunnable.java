package com.tencent.mobileqq.pic;

import aune;
import auog;

class PresendPicMgr$PresendRunnable
  implements Runnable
{
  private auog a;
  
  public PresendPicMgr$PresendRunnable(PresendPicMgr paramPresendPicMgr, auog paramauog)
  {
    this.a = paramauog;
  }
  
  public void run()
  {
    aune.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendRunnable
 * JD-Core Version:    0.7.0.1
 */