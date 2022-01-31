package com.tencent.mobileqq.pic;

import atpz;
import eipc.EIPCResult;

public class PicShareToWX$2$1
  implements Runnable
{
  public PicShareToWX$2$1(atpz paramatpz, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    PicShareToWX.a().c();
    if (this.a.code != 0) {
      PicShareToWX.a().b();
    }
    PicShareToWX.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.2.1
 * JD-Core Version:    0.7.0.1
 */