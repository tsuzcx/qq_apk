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
  private static WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private static Class jdField_a_of_type_JavaLangClass;
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static Field jdField_b_of_type_JavaLangReflectField;
  private static Method jdField_b_of_type_JavaLangReflectMethod;
  public Runnable a;
  boolean jdField_a_of_type_Boolean = false;
  
  public QQToast$ProtectedToast(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new QQToast.ProtectedToast.1(this);
  }
  
  private static Object a(Object paramObject, String paramString)
  {
    return a(paramObject, a(paramObject, paramString));
  }
  
  private static Object a(Object paramObject, Field paramField)
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
  
  private static Field a(Object paramObject, String paramString)
  {
    paramObject = paramObject.getClass();
    while (paramObject != Object.class)
    {
      if (paramObject != null) {}
      try
      {
        Field localField = paramObject.getDeclaredField(paramString);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        paramObject = paramObject.getSuperclass();
      }
      return null;
    }
    return null;
  }
  
  private static boolean a(Object paramObject1, String paramString, Object paramObject2)
  {
    paramString = a(paramObject1, paramString);
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
      getView().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (!QQToast.a())
      {
        super.cancel();
        return;
      }
      Object localObject = jdField_a_of_type_JavaLangReflectField.get(this);
      if (jdField_b_of_type_JavaLangReflectMethod == null)
      {
        jdField_b_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getDeclaredMethod("hide", new Class[0]);
        jdField_b_of_type_JavaLangReflectMethod.setAccessible(true);
      }
      jdField_b_of_type_JavaLangReflectMethod.invoke(localObject, new Object[0]);
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
    try
    {
      if (getView() == null) {
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
    if (jdField_a_of_type_JavaLangReflectField == null)
    {
      jdField_a_of_type_JavaLangReflectField = Toast.class.getDeclaredField("mTN");
      jdField_a_of_type_JavaLangReflectField.setAccessible(true);
      if (Build.VERSION.SDK_INT == 25)
      {
        localObject1 = a(jdField_a_of_type_JavaLangReflectField, "mShow");
        if ((localObject1 instanceof Runnable)) {
          this.jdField_a_of_type_Boolean = a(jdField_a_of_type_JavaLangReflectField, "mShow", new QQToast.ProtectedToast.InternalRunnable(this, (Runnable)localObject1));
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          localObject1 = a(jdField_a_of_type_JavaLangReflectField, "mHandler");
          if ((localObject1 instanceof Handler)) {
            this.jdField_a_of_type_Boolean = a(localObject1, "mCallback", new QQToast.ProtectedToast.InternalHandlerCallback(this, (Handler)localObject1));
          }
        }
        if ((!this.jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
          QLog.d("QQToast", 2, "tryToHook error.");
        }
      }
    }
    Object localObject1 = jdField_a_of_type_JavaLangReflectField.get(this);
    Object localObject2;
    if (QQToast.b())
    {
      localObject2 = localObject1.getClass().getDeclaredField("mParams");
      ((Field)localObject2).setAccessible(true);
      jdField_a_of_type_AndroidViewWindowManager$LayoutParams = (WindowManager.LayoutParams)((Field)localObject2).get(localObject1);
      jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755568;
    }
    for (;;)
    {
      try
      {
        if (("" + Build.MANUFACTURER).equalsIgnoreCase("SAMSUNG")) {
          jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("layoutInDisplayCutoutMode").setInt(jdField_a_of_type_AndroidViewWindowManager$LayoutParams, 1);
        }
        localObject2 = (TextView)getView().findViewById(2131379617);
        if ((localObject2 != null) && (((TextView)localObject2).getText().length() < 6))
        {
          l = 900L;
          getView().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
          if (QLog.isColorLevel()) {
            QLog.d("QQToast", 2, "show");
          }
          if (!QQToast.a())
          {
            super.show();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QQToast", 2, QLog.getStackTraceString(localException));
        continue;
        if (jdField_a_of_type_JavaLangClass == null) {
          jdField_a_of_type_JavaLangClass = Class.forName("android.widget.Toast$TN");
        }
        if (jdField_b_of_type_JavaLangReflectField == null)
        {
          jdField_b_of_type_JavaLangReflectField = jdField_a_of_type_JavaLangClass.getDeclaredField("mNextView");
          jdField_b_of_type_JavaLangReflectField.setAccessible(true);
        }
        jdField_b_of_type_JavaLangReflectField.set(localObject1, getView());
        if (jdField_a_of_type_JavaLangReflectMethod == null)
        {
          jdField_a_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getDeclaredMethod("show", new Class[0]);
          jdField_a_of_type_JavaLangReflectMethod.setAccessible(true);
        }
        jdField_a_of_type_JavaLangReflectMethod.invoke(localObject1, new Object[0]);
        return;
      }
      long l = 1900L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.ProtectedToast
 * JD-Core Version:    0.7.0.1
 */