package com.tencent.mobileqq.pic;

import awjp;
import eipc.EIPCResult;

public class PicShareToWX$2$1
  implements Runnable
{
  public PicShareToWX$2$1(awjp paramawjp, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    PicShareToWX.a().c();
    if (this.a.code != 0) {
      PicShareToWX.a().b();
    }
    PicShareToWX.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.2.1
 * JD-Core Version:    0.7.0.1
 */