package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class QQProgressNotifier
  implements DialogInterface.OnCancelListener, Handler.Callback
{
  int a;
  protected QQProgressDialog a;
  protected final WeakReference<Activity> a;
  protected final ArrayList<DialogInterface.OnCancelListener> a;
  protected final Handler b;
  
  public QQProgressNotifier(Activity paramActivity)
  {
    this(paramActivity, -1);
  }
  
  public QQProgressNotifier(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, null);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProgressNotifier", 2, "show baseActivity is null");
      }
      return;
    }
    if ((paramOnCancelListener != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnCancelListener))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramOnCancelListener);
    }
    this.b.removeMessages(1);
    this.b.removeMessages(2);
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      paramOnCancelListener = Message.obtain();
      paramOnCancelListener.what = 1;
      paramOnCancelListener.arg1 = paramInt1;
      paramOnCancelListener.arg2 = 0;
      paramOnCancelListener.obj = paramString;
      this.b.sendMessageDelayed(paramOnCancelListener, paramInt2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      int i = this.jdField_a_of_type_Int;
      if (i > 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity, 0, i, 17);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299168));
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnCancelListener(null);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnCancelListener(this);
    }
    if (paramInt1 == 0)
    {
      if ((paramString != null) && (!"".equals(paramString.trim()))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(localActivity.getString(2131718766));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
      if (localActivity.isFinishing())
      {
        if (QLog.isDevelopLevel())
        {
          paramString = new StringBuilder();
          paramString.append("[");
          paramString.append(localActivity.isFinishing());
          paramString.append("]");
          QLog.d("QQProgressNotifier", 4, paramString.toString());
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
    else
    {
      if ((paramInt1 != 2) && (paramInt1 != 4) && (paramInt1 != 6))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(2130839588);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(2130839573);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        if (localActivity.isFinishing())
        {
          if (QLog.isDevelopLevel())
          {
            paramString = new StringBuilder();
            paramString.append("[");
            paramString.append(localActivity.isFinishing());
            paramString.append("]");
            QLog.d("QQProgressNotifier", 4, paramString.toString());
          }
        }
        else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
      }
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt1;
      paramOnCancelListener = this.b;
      long l;
      if (paramInt2 > 0) {
        l = paramInt2;
      } else {
        l = 1000L;
      }
      paramOnCancelListener.sendMessageDelayed(paramString, l);
    }
  }
  
  public boolean a()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    return (localQQProgressDialog != null) && (localQQProgressDialog.isShowing());
  }
  
  public void b()
  {
    this.b.removeMessages(1);
    this.b.removeMessages(2);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProgressNotifier", 2, "show baseActivity is null");
      }
      return;
    }
    a(paramInt1, localActivity.getString(paramInt2), paramInt3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      a(paramMessage.arg1, (String)paramMessage.obj, paramMessage.arg2);
      return true;
    }
    if (paramMessage.what == 2)
    {
      b();
      if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 4) || (paramMessage.arg1 == 6) || (paramMessage.arg1 == 5))
      {
        Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localActivity != null)
        {
          if ((paramMessage.arg1 != 6) && (paramMessage.arg1 != 5))
          {
            localActivity.setResult(-1);
          }
          else
          {
            paramMessage = new Intent();
            paramMessage.putExtra("isNeedFinish", true);
            localActivity.setResult(-1, paramMessage);
          }
          localActivity.finish();
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QQProgressNotifier", 2, "handleMessage baseActivity is null");
        }
      }
    }
    return true;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProgressNotifier", 4, "onCancel");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      paramDialogInterface = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDialogInterface.hasNext())
      {
        DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)paramDialogInterface.next();
        if (localOnCancelListener != null) {
          localOnCancelListener.onCancel(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQProgressNotifier
 * JD-Core Version:    0.7.0.1
 */