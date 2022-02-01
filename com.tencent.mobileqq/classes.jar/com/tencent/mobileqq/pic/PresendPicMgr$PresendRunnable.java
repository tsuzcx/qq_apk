package com.tencent.mobileqq.pic;

import ayxi;
import ayyl;

class PresendPicMgr$PresendRunnable
  implements Runnable
{
  private ayyl a;
  
  public PresendPicMgr$PresendRunnable(PresendPicMgr paramPresendPicMgr, ayyl paramayyl)
  {
    this.a = paramayyl;
  }
  
  public void run()
  {
    ayxi.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendRunnable
 * JD-Core Version:    0.7.0.1
 */