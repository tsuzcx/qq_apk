package com.tencent.mobileqq.gamecenter.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class CommUtils
{
  private static QQProgressDialog a;
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static void a()
  {
    QQProgressDialog localQQProgressDialog = a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        a.cancel();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    a = null;
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null) {
      if (paramActivity.isFinishing()) {
        return;
      }
    }
    try
    {
      try
      {
        if (a == null)
        {
          a = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
          a.c(2131718766);
        }
        a.show();
        paramActivity = a;
        if ((paramActivity == null) || (paramActivity.isShowing())) {
          break label111;
        }
      }
      finally
      {
        QQProgressDialog localQQProgressDialog = a;
        if ((localQQProgressDialog != null) && (!localQQProgressDialog.isShowing())) {
          a = null;
        }
      }
    }
    catch (Exception paramActivity)
    {
      label92:
      break label92;
    }
    paramActivity = a;
    if ((paramActivity != null) && (!paramActivity.isShowing())) {
      a = null;
    }
    label111:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.CommUtils
 * JD-Core Version:    0.7.0.1
 */