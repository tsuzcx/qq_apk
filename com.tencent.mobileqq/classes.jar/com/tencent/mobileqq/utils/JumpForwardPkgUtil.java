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
    if (paramActivity != null) {
      if (paramActivity.isFinishing()) {
        return true;
      }
    }
    try
    {
      if (JumpForwardPkgManager.a().c())
      {
        String str = JumpForwardPkgManager.b(paramActivity);
        if (!TextUtils.isEmpty(str))
        {
          if (paramBoolean) {
            QQToast.makeText(paramActivity, 1, str, 1000).show(paramActivity.getResources().getDimensionPixelSize(2131299920));
          }
          paramActivity.moveTaskToBack(true);
          if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "checkAllowShare false");
          }
          return false;
        }
      }
      return true;
    }
    catch (Throwable paramActivity) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpForwardPkgUtil
 * JD-Core Version:    0.7.0.1
 */