package com.tencent.mobileqq.pic;

import ayde;
import ayeg;

class PresendPicMgr$PresendRunnable
  implements Runnable
{
  private ayeg a;
  
  public PresendPicMgr$PresendRunnable(PresendPicMgr paramPresendPicMgr, ayeg paramayeg)
  {
    this.a = paramayeg;
  }
  
  public void run()
  {
    ayde.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendRunnable
 * JD-Core Version:    0.7.0.1
 */