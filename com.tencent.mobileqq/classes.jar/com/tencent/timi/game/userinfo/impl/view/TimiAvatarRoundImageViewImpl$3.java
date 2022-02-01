package com.tencent.timi.game.userinfo.impl.view;

import android.text.TextUtils;

class TimiAvatarRoundImageViewImpl$3
  implements Runnable
{
  TimiAvatarRoundImageViewImpl$3(TimiAvatarRoundImageViewImpl paramTimiAvatarRoundImageViewImpl, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      TimiAvatarRoundImageViewImpl.a(this.this$0, this.a, false);
      return;
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl.3
 * JD-Core Version:    0.7.0.1
 */