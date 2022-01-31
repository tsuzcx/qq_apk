package com.tencent.mobileqq.widget;

import alee;
import alef;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;

public class QQToastNotifier
{
  public Context a;
  private Handler a;
  public Toast a;
  
  public QQToastNotifier(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_a_of_type_AndroidOsHandler = new alee(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    alef localalef = new alef(null);
    localalef.jdField_a_of_type_Int = paramInt4;
    localalef.b = paramInt1;
    localalef.c = paramInt3;
    localalef.d = paramInt2;
    localMessage.obj = localalef;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    alef localalef = new alef(null);
    localalef.jdField_a_of_type_Int = paramInt3;
    localalef.jdField_a_of_type_JavaLangString = paramString;
    localalef.c = paramInt2;
    localalef.d = paramInt1;
    localMessage.obj = localalef;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToastNotifier
 * JD-Core Version:    0.7.0.1
 */