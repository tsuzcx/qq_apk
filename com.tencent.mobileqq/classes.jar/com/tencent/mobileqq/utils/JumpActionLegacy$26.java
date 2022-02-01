package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;

class JumpActionLegacy$26
  implements Runnable
{
  JumpActionLegacy$26(JumpActionLegacy paramJumpActionLegacy) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    String str = this.this$0.a.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    IWebProcessPreload localIWebProcessPreload = (IWebProcessPreload)QRoute.api(IWebProcessPreload.class);
    if (localIWebProcessPreload != null) {
      localIWebProcessPreload.setBusinessClickTimeMills(str, "reader");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.26
 * JD-Core Version:    0.7.0.1
 */