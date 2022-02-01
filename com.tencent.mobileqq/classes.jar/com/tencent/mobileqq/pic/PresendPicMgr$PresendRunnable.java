package com.tencent.mobileqq.pic;

import azjq;
import azks;

class PresendPicMgr$PresendRunnable
  implements Runnable
{
  private azks a;
  
  public PresendPicMgr$PresendRunnable(PresendPicMgr paramPresendPicMgr, azks paramazks)
  {
    this.a = paramazks;
  }
  
  public void run()
  {
    azjq.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendRunnable
 * JD-Core Version:    0.7.0.1
 */