package com.tencent.mobileqq.theme;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class NightModeLogic$2
  extends Handler
{
  NightModeLogic$2(NightModeLogic paramNightModeLogic, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof Bundle)));
      this.a.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return;
    } while (this.a.a == null);
    QQToast.a(this.a.a.getApplication(), HardCodeUtil.a(2131707578), 4000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic.2
 * JD-Core Version:    0.7.0.1
 */