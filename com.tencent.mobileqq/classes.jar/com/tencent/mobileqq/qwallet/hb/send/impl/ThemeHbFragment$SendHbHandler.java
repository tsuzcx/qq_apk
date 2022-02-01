package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;

class ThemeHbFragment$SendHbHandler
  extends Handler
{
  ThemeHbFragment$SendHbHandler(ThemeHbFragment paramThemeHbFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 100) {
      return;
    }
    if (!TextUtils.isEmpty(ThemeHbFragment.a(this.a))) {
      ThemeHbFragment.a(this.a).setText(ThemeHbFragment.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ThemeHbFragment.SendHbHandler
 * JD-Core Version:    0.7.0.1
 */