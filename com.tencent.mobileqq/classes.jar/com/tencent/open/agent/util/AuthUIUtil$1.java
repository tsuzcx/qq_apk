package com.tencent.open.agent.util;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQToast;

final class AuthUIUtil$1
  implements Runnable
{
  AuthUIUtil$1(Activity paramActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(this.a);
    if (this.b)
    {
      localQQToast.setToastIcon(QQToast.getIconRes(2));
      localQQToast.setType(2);
    }
    else
    {
      localQQToast.setToastIcon(QQToast.getIconRes(1));
      localQQToast.setType(1);
    }
    localQQToast.setDuration(1);
    localQQToast.setToastMsg(this.c);
    localQQToast.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthUIUtil.1
 * JD-Core Version:    0.7.0.1
 */