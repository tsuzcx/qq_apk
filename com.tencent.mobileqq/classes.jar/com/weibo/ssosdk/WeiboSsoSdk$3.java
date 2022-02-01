package com.weibo.ssosdk;

import android.text.TextUtils;

class WeiboSsoSdk$3
  implements Runnable
{
  WeiboSsoSdk$3(WeiboSsoSdk paramWeiboSsoSdk) {}
  
  public void run()
  {
    if ((WeiboSsoSdk.access$000(this.this$0) != null) && (!TextUtils.isEmpty(WeiboSsoSdk.access$000(this.this$0).getAid()))) {}
    for (String str = WeiboSsoSdk.access$000(this.this$0).getAid();; str = WeiboSsoSdk.access$100(this.this$0)) {
      try
      {
        WeiboSsoSdk.access$200(this.this$0, str, 2);
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.weibo.ssosdk.WeiboSsoSdk.3
 * JD-Core Version:    0.7.0.1
 */