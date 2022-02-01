package com.tencent.mobileqq.pic;

import ayxz;
import bdzi;
import com.tencent.mobileqq.app.QQAppInterface;
import eipc.EIPCResult;

public class PicShareToWX$TimeoutRunnable
  implements Runnable
{
  private PicShareToWX$TimeoutRunnable(PicShareToWX paramPicShareToWX) {}
  
  public void run()
  {
    PicShareToWX.a(this.this$0, true);
    if ((PicShareToWX.a(this.this$0) != null) && (PicShareToWX.a(this.this$0) != null)) {
      PicShareToWX.a(this.this$0).a().a(PicShareToWX.a(this.this$0));
    }
    if (PicShareToWX.a(this.this$0) != null) {
      PicShareToWX.a(this.this$0).callbackResult(PicShareToWX.a(this.this$0), EIPCResult.createResult(-102, null));
    }
    PicShareToWX.a(PicShareToWX.b(this.this$0), false);
    PicShareToWX.a(this.this$0, false, 12345, 0);
    this.this$0.c();
    this.this$0.b();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.TimeoutRunnable
 * JD-Core Version:    0.7.0.1
 */