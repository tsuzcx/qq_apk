package com.tencent.mobileqq.emosm.web;

import android.content.res.Resources;
import anvx;
import ashc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class MessengerService$8$1
  implements Runnable
{
  public MessengerService$8$1(ashc paramashc) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MessengerService.i(this.a.a);
    QQToast.a(localQQAppInterface.getApplication(), anvx.a(2131706147), 0).b(localQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299080));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.8.1
 * JD-Core Version:    0.7.0.1
 */