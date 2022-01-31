package com.tencent.mobileqq.pic;

import aung;
import auoi;

class PresendPicMgr$PresendRunnable
  implements Runnable
{
  private auoi a;
  
  public PresendPicMgr$PresendRunnable(PresendPicMgr paramPresendPicMgr, auoi paramauoi)
  {
    this.a = paramauoi;
  }
  
  public void run()
  {
    aung.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendRunnable
 * JD-Core Version:    0.7.0.1
 */