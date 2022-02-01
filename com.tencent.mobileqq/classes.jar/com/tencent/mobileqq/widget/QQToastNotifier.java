package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;

public class QQToastNotifier
{
  Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new QQToastNotifier.1(this, Looper.getMainLooper());
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  
  public QQToastNotifier(Context paramContext) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    QQToastNotifier.ToastData localToastData = new QQToastNotifier.ToastData(null);
    localToastData.jdField_a_of_type_Int = paramInt4;
    localToastData.b = paramInt1;
    localToastData.c = paramInt3;
    localToastData.d = paramInt2;
    localMessage.obj = localToastData;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    QQToastNotifier.ToastData localToastData = new QQToastNotifier.ToastData(null);
    localToastData.jdField_a_of_type_Int = paramInt3;
    localToastData.jdField_a_of_type_JavaLangString = paramString;
    localToastData.c = paramInt2;
    localToastData.d = paramInt1;
    localMessage.obj = localToastData;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToastNotifier
 * JD-Core Version:    0.7.0.1
 */