package com.tencent.mobileqq.pic;

import eipc.EIPCResult;

class PicShareToWX$2$1
  implements Runnable
{
  PicShareToWX$2$1(PicShareToWX.2 param2, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    PicShareToWX.a().c();
    if (this.a.code != 0) {
      PicShareToWX.a().b();
    }
    PicShareToWX.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.2.1
 * JD-Core Version:    0.7.0.1
 */