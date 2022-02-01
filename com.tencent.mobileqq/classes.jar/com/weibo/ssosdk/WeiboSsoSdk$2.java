package com.weibo.ssosdk;

import android.text.TextUtils;

class WeiboSsoSdk$2
  implements Runnable
{
  WeiboSsoSdk$2(WeiboSsoSdk paramWeiboSsoSdk) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(60000L);
      if (!WeiboSsoSdk.access$300(this.this$0)) {
        return;
      }
      if ((WeiboSsoSdk.access$000(this.this$0) != null) && (!TextUtils.isEmpty(WeiboSsoSdk.access$000(this.this$0).getAid()))) {}
      for (String str = WeiboSsoSdk.access$000(this.this$0).getAid();; str = WeiboSsoSdk.access$100(this.this$0))
      {
        WeiboSsoSdk.access$200(this.this$0, str, 2);
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.weibo.ssosdk.WeiboSsoSdk.2
 * JD-Core Version:    0.7.0.1
 */