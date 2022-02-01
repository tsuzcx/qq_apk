package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;

class JumpAction$27
  implements Runnable
{
  JumpAction$27(JumpAction paramJumpAction) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    String str;
    IWebProcessPreload localIWebProcessPreload;
    do
    {
      do
      {
        return;
        str = this.this$0.a.getCurrentAccountUin();
      } while (TextUtils.isEmpty(str));
      localIWebProcessPreload = (IWebProcessPreload)QRoute.api(IWebProcessPreload.class);
    } while (localIWebProcessPreload != null);
    localIWebProcessPreload.setBusinessClickTimeMills(str, "reader");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.27
 * JD-Core Version:    0.7.0.1
 */