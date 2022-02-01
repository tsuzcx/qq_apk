package com.tencent.mobileqq.vas.theme;

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
    int i = paramMessage.what;
    if (i != 4099)
    {
      if (i != 4100) {
        return;
      }
      if (this.a.a != null) {
        QQToast.makeText(this.a.a.getApplication(), HardCodeUtil.a(2131905418), 4000).show();
      }
    }
    else if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Bundle)))
    {
      this.a.a(paramMessage.arg1, (Bundle)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.NightModeLogic.2
 * JD-Core Version:    0.7.0.1
 */