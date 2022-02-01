package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.style;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class MiniToast$ProtectedToast
  extends Toast
{
  private static final int LONG_DELAY = 3500;
  private static final int SHORT_DELAY = 2000;
  private static Class TNClass;
  private static Method hideMethod;
  private static Field mNextViewField;
  private static Field mTNField;
  private static WindowManager.LayoutParams params;
  private static Method showMethod;
  public Runnable cancelRunnable = new MiniToast.ProtectedToast.1(this);
  
  public MiniToast$ProtectedToast(Context paramContext)
  {
    super(paramContext);
  }
  
  public void cancel()
  {
    try
    {
      QMLog.d("QQToast", "cancel!");
      ThreadManager.getUIHandler().removeCallbacks(this.cancelRunnable);
      if (!MiniToast.canUseCustomToast(getView().getContext(), false))
      {
        super.cancel();
        return;
      }
      Object localObject = mTNField.get(this);
      if (hideMethod == null)
      {
        hideMethod = TNClass.getDeclaredMethod("hide", new Class[0]);
        hideMethod.setAccessible(true);
      }
      hideMethod.invoke(localObject, new Object[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.d("QQToast", "", localThrowable);
      if ((localThrowable instanceof NoSuchMethodException)) {
        super.cancel();
      }
    }
  }
  
  public void show()
  {
    try
    {
      if (getView() == null) {
        throw new RuntimeException("setView must have been called");
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.d("QQToast", "", localThrowable);
      if (((localThrowable instanceof NoSuchMethodException)) || ((localThrowable instanceof NoSuchFieldException))) {
        super.show();
      }
      return;
    }
    if (mTNField == null)
    {
      mTNField = Toast.class.getDeclaredField("mTN");
      mTNField.setAccessible(true);
    }
    Object localObject1 = mTNField.get(this);
    Object localObject2;
    if (MiniToast.useIOSLikeUI())
    {
      localObject2 = localObject1.getClass().getDeclaredField("mParams");
      ((Field)localObject2).setAccessible(true);
      params = (WindowManager.LayoutParams)((Field)localObject2).get(localObject1);
      params.flags = 40;
      params.windowAnimations = R.style.mini_sdk_custom_animation_toast;
    }
    for (;;)
    {
      try
      {
        if (("" + Build.MANUFACTURER).equalsIgnoreCase("SAMSUNG")) {
          params.getClass().getField("layoutInDisplayCutoutMode").setInt(params, 1);
        }
        localObject2 = (TextView)getView().findViewById(R.id.toast_msg);
        if ((localObject2 != null) && (((TextView)localObject2).getText().length() < 6))
        {
          l = 900L;
          ThreadManager.getUIHandler().postDelayed(this.cancelRunnable, l);
          QMLog.d("QQToast", "show");
          if (!MiniToast.canUseCustomToast(getView().getContext(), false))
          {
            super.show();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QMLog.e("QQToast", localException.getMessage(), localException);
        continue;
        if (TNClass == null) {
          TNClass = Class.forName("android.widget.Toast$TN");
        }
        if (mNextViewField == null)
        {
          mNextViewField = TNClass.getDeclaredField("mNextView");
          mNextViewField.setAccessible(true);
        }
        mNextViewField.set(localObject1, getView());
        if (showMethod == null)
        {
          showMethod = TNClass.getDeclaredMethod("show", new Class[0]);
          showMethod.setAccessible(true);
        }
        showMethod.invoke(localObject1, new Object[0]);
        return;
      }
      long l = 1900L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniToast.ProtectedToast
 * JD-Core Version:    0.7.0.1
 */