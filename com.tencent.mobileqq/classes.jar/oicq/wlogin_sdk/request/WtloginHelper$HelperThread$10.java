package oicq.wlogin_sdk.request;

class WtloginHelper$HelperThread$10
  implements Runnable
{
  WtloginHelper$HelperThread$10(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$600(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    WtloginHelper.access$200(this.this$1.mHelper).OnRequestTransport(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mRole, this.this$1.mReqContext, this.val$ret);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.10
 * JD-Core Version:    0.7.0.1
 */