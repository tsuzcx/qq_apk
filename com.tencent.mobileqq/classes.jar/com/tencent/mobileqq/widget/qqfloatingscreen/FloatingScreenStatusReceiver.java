package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bhma;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class FloatingScreenStatusReceiver
  extends BroadcastReceiver
{
  private static int jdField_a_of_type_Int = BaseApplicationImpl.sProcessId;
  private Context jdField_a_of_type_AndroidContentContext;
  private bhma jdField_a_of_type_Bhma;
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
  
  public void a(int paramInt, bhma parambhma)
  {
    this.b = paramInt;
    this.jdField_a_of_type_Bhma = parambhma;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FSReceiver", 4, new Object[] { "action: ", paramIntent.getAction() });
        }
        if ("tencent.mobileqq.floatingscreen.statuschange".equals(paramIntent.getAction()))
        {
          i = paramIntent.getIntExtra("param_concern_floating_type", -1);
          if (!a(i))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FSReceiver", 2, new Object[] { "type not available, concern:", Integer.valueOf(i), " ,curr:", Integer.valueOf(this.b) });
            }
          }
          else
          {
            i = paramIntent.getIntExtra("param_curr_window_status", 0);
            int j = paramIntent.getIntExtra("param_busitype", -1);
            if (QLog.isColorLevel()) {
              QLog.d("FSReceiver", 2, new Object[] { "busiType:", Integer.valueOf(j), " ,status:", Integer.valueOf(i), " ,hide:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
            }
            if (paramIntent.hasExtra("param_ignored_processid"))
            {
              j = paramIntent.getIntExtra("param_ignored_processid", -1);
              if (jdField_a_of_type_Int == j) {}
            }
            else
            {
              switch (i)
              {
              default: 
                return;
              case 102: 
                this.jdField_a_of_type_Bhma.b();
                this.jdField_a_of_type_Boolean = true;
                return;
              case 103: 
                this.jdField_a_of_type_Bhma.a(true);
                this.jdField_a_of_type_Boolean = false;
                return;
              }
              this.jdField_a_of_type_Bhma.c();
            }
          }
        }
        else
        {
          if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
          {
            this.jdField_a_of_type_Bhma.a();
            return;
          }
          if ("mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()))
          {
            this.jdField_a_of_type_Bhma.b();
            return;
          }
          if (!"mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction())) {
            break;
          }
          paramContext = paramIntent.getStringExtra("process_name");
          if ((paramContext != null) && (paramContext.contains("openSdk"))) {}
          while ((i == 0) && (!this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_Bhma.a(false);
            return;
            i = 0;
          }
        }
      }
    } while ((!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(paramIntent.getAction())) && (!"mqq.intent.action.FORCE_LOGOUT".equals(paramIntent.getAction())) && (!"mqq.intent.action.LOGOUT".equals(paramIntent.getAction())));
    i = paramIntent.getIntExtra("type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FSReceiver", 2, "cnrType=" + i + " action=" + paramIntent.getAction());
    }
    this.jdField_a_of_type_Bhma.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver
 * JD-Core Version:    0.7.0.1
 */