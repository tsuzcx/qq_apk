package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class JumpForwardPkgUtil
{
  public static final boolean a(Activity paramActivity, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    for (;;)
    {
      return true;
      try
      {
        if (JumpForwardPkgManager.a().a())
        {
          String str = JumpForwardPkgManager.a(paramActivity);
          if (!TextUtils.isEmpty(str))
          {
            if (paramBoolean) {
              QQToast.a(paramActivity, 1, str, 1000).b(paramActivity.getResources().getDimensionPixelSize(2131299166));
            }
            paramActivity.moveTaskToBack(true);
            if (QLog.isColorLevel()) {
              QLog.d("JumpForwardPkgManager", 2, "checkAllowShare false");
            }
            return false;
          }
        }
      }
      catch (Throwable paramActivity) {}
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpForwardPkgUtil
 * JD-Core Version:    0.7.0.1
 */