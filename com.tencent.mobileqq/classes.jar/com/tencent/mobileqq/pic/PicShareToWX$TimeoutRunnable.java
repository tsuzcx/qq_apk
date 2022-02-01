package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import eipc.EIPCResult;

class PicShareToWX$TimeoutRunnable
  implements Runnable
{
  private PicShareToWX$TimeoutRunnable(PicShareToWX paramPicShareToWX) {}
  
  public void run()
  {
    PicShareToWX.a(this.this$0, true);
    if ((this.this$0.c != null) && (this.this$0.b != null)) {
      ((ITransFileController)this.this$0.c.getRuntimeService(ITransFileController.class)).stop(this.this$0.b);
    }
    if (this.this$0.f != null) {
      this.this$0.f.callbackResult(this.this$0.g, EIPCResult.createResult(-102, null));
    }
    PicShareToWX.a(this.this$0.e, false);
    PicShareToWX.a(this.this$0, false, 12345, 0);
    this.this$0.d();
    this.this$0.c();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.TimeoutRunnable
 * JD-Core Version:    0.7.0.1
 */