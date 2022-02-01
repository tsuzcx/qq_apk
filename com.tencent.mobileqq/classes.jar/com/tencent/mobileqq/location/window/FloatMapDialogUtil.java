package com.tencent.mobileqq.location.window;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class FloatMapDialogUtil
{
  public static void a(Activity paramActivity, QQCustomDialog paramQQCustomDialog)
  {
    if (paramActivity != null) {
      try
      {
        if (!paramActivity.isFinishing())
        {
          paramQQCustomDialog.show();
          return;
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("FloatMapDialogUtil", 1, "showSafely: failed. ", paramActivity);
      }
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity)
  {
    paramQBaseActivity = new FloatMapDialogUtil.1(paramQBaseActivity);
    ThreadManager.getUIHandlerV2().postDelayed(paramQBaseActivity, 1000L);
  }
  
  public static void b(QBaseActivity paramQBaseActivity)
  {
    paramQBaseActivity = new FloatMapDialogUtil.2(paramQBaseActivity);
    ThreadManager.getUIHandlerV2().postDelayed(paramQBaseActivity, 7000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatMapDialogUtil
 * JD-Core Version:    0.7.0.1
 */