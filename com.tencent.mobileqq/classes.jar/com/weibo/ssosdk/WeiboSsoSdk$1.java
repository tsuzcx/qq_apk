package com.weibo.ssosdk;

import android.text.TextUtils;

class WeiboSsoSdk$1
  implements Runnable
{
  WeiboSsoSdk$1(WeiboSsoSdk paramWeiboSsoSdk) {}
  
  public void run()
  {
    try
    {
      for (;;)
      {
        Thread.sleep(86400000L);
        if ((WeiboSsoSdk.access$000(this.this$0) != null) && (!TextUtils.isEmpty(WeiboSsoSdk.access$000(this.this$0).getAid()))) {}
        for (String str = WeiboSsoSdk.access$000(this.this$0).getAid();; str = WeiboSsoSdk.access$100(this.this$0))
        {
          WeiboSsoSdk.access$200(WeiboSsoSdk.getInstance(), str, 2);
          break;
        }
      }
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.weibo.ssosdk.WeiboSsoSdk.1
 * JD-Core Version:    0.7.0.1
 */