package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;

class QQToastNotifier$1
  extends Handler
{
  QQToastNotifier$1(QQToastNotifier paramQQToastNotifier, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQToastNotifier.ToastData localToastData = (QQToastNotifier.ToastData)paramMessage.obj;
    Object localObject = localToastData.jdField_a_of_type_JavaLangString;
    if (localObject != null)
    {
      paramMessage = (Message)localObject;
      if (((String)localObject).length() != 0) {}
    }
    else
    {
      try
      {
        paramMessage = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(localToastData.b);
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        paramMessage = (Message)localObject;
      }
    }
    if (this.a.jdField_a_of_type_AndroidWidgetToast == null)
    {
      localObject = this.a;
      ((QQToastNotifier)localObject).jdField_a_of_type_AndroidWidgetToast = QQToast.a(((QQToastNotifier)localObject).jdField_a_of_type_AndroidContentContext, localToastData.jdField_a_of_type_Int, paramMessage, localToastData.c).a(localToastData.d);
    }
    else
    {
      try
      {
        localObject = this.a.jdField_a_of_type_AndroidWidgetToast.getView();
        ((TextView)((View)localObject).findViewById(2131378963)).setText(paramMessage);
        ((ImageView)((View)localObject).findViewById(2131378961)).setImageResource(QQToast.a(localToastData.jdField_a_of_type_Int));
        this.a.jdField_a_of_type_AndroidWidgetToast.setDuration(localToastData.c);
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        this.a.jdField_a_of_type_AndroidWidgetToast = null;
        if (QLog.isColorLevel()) {
          QLog.i("QQToastNotifier", 2, paramMessage.toString());
        }
      }
    }
    if (this.a.jdField_a_of_type_AndroidWidgetToast != null) {
      this.a.jdField_a_of_type_AndroidWidgetToast.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToastNotifier.1
 * JD-Core Version:    0.7.0.1
 */