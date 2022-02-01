package com.tencent.mobileqq.vas.manager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ThemeSwitchManagerImpl$2
  extends Handler
{
  ThemeSwitchManagerImpl$2(ThemeSwitchManagerImpl paramThemeSwitchManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    if ((this.a.h != null) && (this.a.h.get() != null)) {
      localObject = (Activity)this.a.h.get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage activity is not TitleBarActivity, , what=");
      ((StringBuilder)localObject).append(paramMessage.what);
      QLog.d("ThemeSwitchManager", 2, ((StringBuilder)localObject).toString());
      return;
    }
    int i = paramMessage.what;
    if (i != 200)
    {
      if (i == 201)
      {
        this.a.onPostThemeChanged();
        QQToast.makeText((Context)localObject, HardCodeUtil.a(2131912236), 4000).show();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected value: ");
      ((StringBuilder)localObject).append(paramMessage.what);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    if ((!((Activity)localObject).isFinishing()) && ((this.a.a == null) || (!this.a.a.isShowing())))
    {
      this.a.a = new QQProgressDialog((Context)localObject, ((QBaseActivity)localObject).getTitleBarHeight());
      this.a.a.setCancelable(true);
      this.a.a.c(2131916957);
      this.a.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */