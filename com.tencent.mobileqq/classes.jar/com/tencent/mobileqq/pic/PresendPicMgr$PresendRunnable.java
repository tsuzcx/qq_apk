package com.tencent.mobileqq.pic;

class PresendPicMgr$PresendRunnable
  implements Runnable
{
  private PresendPicMgr.PresendReq a;
  
  public PresendPicMgr$PresendRunnable(PresendPicMgr paramPresendPicMgr, PresendPicMgr.PresendReq paramPresendReq)
  {
    this.a = paramPresendReq;
  }
  
  public void run()
  {
    Logger.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.a);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendRunnable
 * JD-Core Version:    0.7.0.1
 */