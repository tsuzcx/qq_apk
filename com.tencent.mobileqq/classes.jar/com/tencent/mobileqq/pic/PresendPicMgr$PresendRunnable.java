package com.tencent.mobileqq.pic;

import azpw;
import azqy;

class PresendPicMgr$PresendRunnable
  implements Runnable
{
  private azqy a;
  
  public PresendPicMgr$PresendRunnable(PresendPicMgr paramPresendPicMgr, azqy paramazqy)
  {
    this.a = paramazqy;
  }
  
  public void run()
  {
    azpw.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendRunnable
 * JD-Core Version:    0.7.0.1
 */