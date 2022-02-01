package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class QQToast$ProtectedToast
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
  public Runnable cancelRunnable = new QQToast.ProtectedToast.1(this);
  boolean isHooked = false;
  
  public QQToast$ProtectedToast(Context paramContext)
  {
    super(paramContext);
  }
  
  private static Field getDeclaredField(Object paramObject, String paramString)
  {
    for (paramObject = paramObject.getClass(); (paramObject != Object.class) && (paramObject != null); paramObject = paramObject.getSuperclass()) {
      try
      {
        Field localField = paramObject.getDeclaredField(paramString);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        label23:
        break label23;
      }
    }
    return null;
  }
  
  private static Object getFieldValue(Object paramObject, String paramString)
  {
    return getFieldValue(paramObject, getDeclaredField(paramObject, paramString));
  }
  
  private static Object getFieldValue(Object paramObject, Field paramField)
  {
    if (paramField != null) {
      try
      {
        if (!paramField.isAccessible()) {
          paramField.setAccessible(true);
        }
        paramObject = paramField.get(paramObject);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    return null;
  }
  
  private static boolean setFieldValue(Object paramObject1, String paramString, Object paramObject2)
  {
    paramString = getDeclaredField(paramObject1, paramString);
    if (paramString != null) {
      try
      {
        if (Modifier.isFinal(paramString.getModifiers()))
        {
          Field localField = Field.class.getDeclaredField("accessFlags");
          localField.setAccessible(true);
          localField.setInt(paramString, paramString.getModifiers() & 0xFFFFFFEF);
        }
        if (!paramString.isAccessible()) {
          paramString.setAccessible(true);
        }
        paramString.set(paramObject1, paramObject2);
        return true;
      }
      catch (Exception paramObject1)
      {
        paramObject1.printStackTrace();
      }
    }
    return false;
  }
  
  public void cancel()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, new Object[] { "", "cancel!" });
      }
      getView().removeCallbacks(this.cancelRunnable);
      if (!QQToast.canUseCustomToast())
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
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, "", localThrowable);
      }
      if ((localThrowable instanceof NoSuchMethodException)) {
        super.cancel();
      }
    }
  }
  
  public void show()
  {
    for (;;)
    {
      try
      {
        if (getView() != null)
        {
          if (mTNField == null)
          {
            mTNField = Toast.class.getDeclaredField("mTN");
            mTNField.setAccessible(true);
            if (Build.VERSION.SDK_INT == 25)
            {
              localObject1 = getFieldValue(mTNField, "mShow");
              if ((localObject1 instanceof Runnable)) {
                this.isHooked = setFieldValue(mTNField, "mShow", new QQToast.ProtectedToast.InternalRunnable(this, (Runnable)localObject1));
              }
              if (!this.isHooked)
              {
                localObject1 = getFieldValue(mTNField, "mHandler");
                if ((localObject1 instanceof Handler)) {
                  this.isHooked = setFieldValue(localObject1, "mCallback", new QQToast.ProtectedToast.InternalHandlerCallback(this, (Handler)localObject1));
                }
              }
              if ((!this.isHooked) && (QLog.isColorLevel())) {
                QLog.d("QQToast", 2, "tryToHook error.");
              }
            }
          }
          Object localObject1 = mTNField.get(this);
          if (QQToast.useIOSLikeUI())
          {
            Object localObject2 = localObject1.getClass().getDeclaredField("mParams");
            ((Field)localObject2).setAccessible(true);
            params = (WindowManager.LayoutParams)((Field)localObject2).get(localObject1);
            params.flags = 40;
            params.windowAnimations = 2131953034;
            try
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("");
              ((StringBuilder)localObject2).append(Build.MANUFACTURER);
              if (((StringBuilder)localObject2).toString().equalsIgnoreCase("SAMSUNG")) {
                params.getClass().getField("layoutInDisplayCutoutMode").setInt(params, 1);
              }
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQToast", 2, QLog.getStackTraceString(localException));
              }
            }
          }
          TextView localTextView = (TextView)getView().findViewById(2131447672);
          if ((localTextView != null) && (localTextView.getText().length() < 6))
          {
            l = 900L;
            getView().postDelayed(this.cancelRunnable, l);
            boolean bool = QLog.isColorLevel();
            if (bool) {
              QLog.d("QQToast", 2, "show");
            }
            if (!QQToast.canUseCustomToast())
            {
              super.show();
              return;
            }
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
          }
        }
        else
        {
          throw new RuntimeException("setView must have been called");
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQToast", 2, "", localThrowable);
        }
        if (((localThrowable instanceof NoSuchMethodException)) || ((localThrowable instanceof NoSuchFieldException))) {
          super.show();
        }
        return;
      }
      long l = 1900L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.ProtectedToast
 * JD-Core Version:    0.7.0.1
 */