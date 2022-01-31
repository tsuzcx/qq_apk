package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bbqr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class FloatingScreenStatusReceiver
  extends BroadcastReceiver
{
  private static int jdField_a_of_type_Int = BaseApplicationImpl.sProcessId;
  private Context jdField_a_of_type_AndroidContentContext;
  private bbqr jdField_a_of_type_Bbqr;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public FloatingScreenStatusReceiver(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new IntentFilter();
    paramContext.addAction("tencent.mobileqq.floatingscreen.statuschange");
    paramContext.addAction("mqq.intent.action.QQ_BACKGROUND");
    paramContext.addAction("mqq.intent.action.QQ_FOREGROUND");
    paramContext.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    paramContext.addAction("mqq.intent.action.ACCOUNT_KICKED");
    paramContext.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    paramContext.addAction("mqq.intent.action.FORCE_LOGOUT");
    paramContext.addAction("mqq.intent.action.LOGOUT");
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentContext.getApplicationContext().registerReceiver(this, paramContext);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == -1) || (paramInt == this.b);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext.getApplicationContext().unregisterReceiver(this);
  }
  
  public void a(int paramInt, bbqr parambbqr)
  {
    this.b = paramInt;
    this.jdField_a_of_type_Bbqr = parambbqr;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    label282:
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          do
          {
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d("FSReceiver", 4, new Object[] { "action: ", paramIntent.getAction() });
            }
            if (!"tencent.mobileqq.floatingscreen.statuschange".equals(paramIntent.getAction())) {
              break label282;
            }
            i = paramIntent.getIntExtra("param_concern_floating_type", -1);
            if (a(i)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("FSReceiver", 2, new Object[] { "type not available, concern:", Integer.valueOf(i), " ,curr:", Integer.valueOf(this.b) });
          return;
          i = paramIntent.getIntExtra("param_curr_window_status", 0);
          j = paramIntent.getIntExtra("param_busitype", -1);
          if (QLog.isColorLevel()) {
            QLog.d("FSReceiver", 2, new Object[] { "busiType:", Integer.valueOf(j), " ,status:", Integer.valueOf(i), " ,hide:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
          }
          if (!paramIntent.hasExtra("param_ignored_processid")) {
            break;
          }
          j = paramIntent.getIntExtra("param_ignored_processid", -1);
        } while (jdField_a_of_type_Int == j);
        switch (i)
        {
        default: 
          return;
        case 102: 
          this.jdField_a_of_type_Bbqr.b();
          this.jdField_a_of_type_Boolean = true;
          return;
        case 103: 
          this.jdField_a_of_type_Bbqr.a(true);
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        this.jdField_a_of_type_Bbqr.c();
        return;
        if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
        {
          this.jdField_a_of_type_Bbqr.a();
          return;
        }
        if ("mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()))
        {
          this.jdField_a_of_type_Bbqr.b();
          return;
        }
        if (!"mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction())) {
          break;
        }
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Bbqr.a(false);
      return;
    } while ((!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(paramIntent.getAction())) && (!"mqq.intent.action.FORCE_LOGOUT".equals(paramIntent.getAction())) && (!"mqq.intent.action.LOGOUT".equals(paramIntent.getAction())));
    this.jdField_a_of_type_Bbqr.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver
 * JD-Core Version:    0.7.0.1
 */