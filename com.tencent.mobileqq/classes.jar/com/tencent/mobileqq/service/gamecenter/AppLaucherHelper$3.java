package com.tencent.mobileqq.service.gamecenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

class AppLaucherHelper$3
  extends Handler
{
  AppLaucherHelper$3(AppLaucherHelper paramAppLaucherHelper, Looper paramLooper, Context paramContext, String paramString1, int paramInt, AppInterface paramAppInterface, String paramString2, String paramString3)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      paramMessage = this.g;
      paramMessage.h = true;
      if (paramMessage.b != null)
      {
        this.g.b.setObserver(null);
        this.g.b = null;
      }
      AppLaucherHelper.a(this.g, this.d, this.a, this.e, this.f, this.b, "", this.c);
      return;
    }
    paramMessage = this.g;
    paramMessage.h = true;
    if (paramMessage.b != null)
    {
      this.g.b.setObserver(null);
      this.g.b = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp time out");
    }
    paramMessage = AppLaucherHelper.b(this.g.e);
    AppUtil.a(this.a, this.b, paramMessage, this.c);
    AppLaucherHelper.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.gamecenter.AppLaucherHelper.3
 * JD-Core Version:    0.7.0.1
 */