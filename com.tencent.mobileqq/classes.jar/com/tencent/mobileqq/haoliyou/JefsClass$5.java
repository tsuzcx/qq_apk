package com.tencent.mobileqq.haoliyou;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.bigbrother.JumpConfirmFragment;
import com.tencent.mobileqq.bigbrother.JumpListener;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Locale;
import mqq.app.MobileQQ;

class JefsClass$5
  implements JumpListener
{
  JefsClass$5(JefsClass paramJefsClass, WeakReference paramWeakReference, JefsClass.CancelableRunnable paramCancelableRunnable, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (Context)this.a.get();
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, String.format(Locale.CHINA, "onReceive: success: %b, jump: %d, err_code: %d, err_msg: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    paramString = this.b;
    if (paramString == null) {
      return;
    }
    if (localObject == null)
    {
      TeleScreen.a().a(this.c, -3);
      QLog.i("TeleScreen|JefsClass", 1, "context is null");
      localObject = this.d;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      ReportController.b(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "", "1", paramString, "");
      return;
    }
    if ((paramBoolean) && (paramInt1 == 1))
    {
      JefsClass.a(this.e, paramString);
      return;
    }
    if ((paramBoolean) && (paramInt1 != 0))
    {
      TeleScreen.a().a(this.c, -2);
      return;
    }
    for (;;)
    {
      try
      {
        if ((localObject instanceof Activity))
        {
          paramString = (Activity)localObject;
          if ((paramString != null) && (!paramString.isFinishing()))
          {
            QLog.i("TeleScreen|JefsClass", 1, "leave QQ jump other app , act.isFinishing() == false");
            localObject = DialogUtil.a(paramString, 0, null, "即将离开QQ\n打开其他应用", paramString.getString(2131887648), paramString.getString(2131918066), new JefsClass.5.1(this), new JefsClass.5.2(this));
            if ((paramString instanceof QBaseActivity)) {
              ((QBaseActivity)paramString).setJumpDialog((Dialog)localObject);
            } else if ((paramString instanceof BasePluginActivity)) {
              ((BasePluginActivity)paramString).setJumpDialog((Dialog)localObject);
            }
            ((QQCustomDialog)localObject).show();
            return;
          }
          if (MobileQQ.sProcessId != 1)
          {
            if (JefsClass.a(this.e) == null) {
              JefsClass.a(this.e, new JefsClass.TeleScreenReceiver(this.e, null));
            }
            paramString = new IntentFilter("com.tencent.mobileqq.telescreen.action_run");
            paramString.addAction("com.tencent.mobileqq.telescreen.action_remove");
            MobileQQ.context.registerReceiver(JefsClass.a(this.e), paramString);
          }
          paramString = new Intent();
          paramString.putExtra("big_brother_source_key", this.d);
          paramString.putExtra("key_id", JefsClass.b(this.e, this.b));
          paramString.putExtra("key_process_id", MobileQQ.processName);
          paramString.putExtra("key_callback_id", this.c);
          paramString.putExtra("public_fragment_window_feature", 1);
          QPublicFragmentActivity.Launcher.a(paramString, QPublicTransFragmentActivity.class, JumpConfirmFragment.class);
          QLog.i("TeleScreen|JefsClass", 1, "leave QQ jump other app , act == null && act.isFinishing() == true");
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("TeleScreen|JefsClass", 1, paramString, new Object[0]);
        JefsClass.a(this.e, this.b);
        return;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.5
 * JD-Core Version:    0.7.0.1
 */