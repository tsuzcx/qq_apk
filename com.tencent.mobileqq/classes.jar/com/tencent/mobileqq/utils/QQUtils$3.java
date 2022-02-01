package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class QQUtils$3
  implements Runnable
{
  public void run()
  {
    String str;
    if (this.a) {
      str = this.b.getApp().getString(2131916945);
    } else {
      str = null;
    }
    if (str != null) {
      QQToast.makeText(this.b.getApp(), 2, str, 0).show(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils.3
 * JD-Core Version:    0.7.0.1
 */