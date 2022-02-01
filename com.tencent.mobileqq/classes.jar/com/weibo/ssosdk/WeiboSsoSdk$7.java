package com.weibo.ssosdk;

class WeiboSsoSdk$7
  implements Runnable
{
  WeiboSsoSdk$7(WeiboSsoSdk paramWeiboSsoSdk, AidListener paramAidListener) {}
  
  public void run()
  {
    try
    {
      WeiboSsoSdk.access$200(this.this$0, "", 1);
      label10:
      if (WeiboSsoSdk.access$000(this.this$0) == null) {
        WeiboSsoSdk.access$002(this.this$0, new WeiboSsoSdk.VisitorLoginInfo());
      }
      this.val$listener.handler(WeiboSsoSdk.access$000(this.this$0).getAid());
      return;
    }
    catch (Exception localException)
    {
      break label10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.weibo.ssosdk.WeiboSsoSdk.7
 * JD-Core Version:    0.7.0.1
 */