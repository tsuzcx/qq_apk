package com.tencent.mobileqq.emosm.web;

import alud;
import android.content.res.Resources;
import apqf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class MessengerService$8$1
  implements Runnable
{
  public MessengerService$8$1(apqf paramapqf) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MessengerService.i(this.a.a);
    QQToast.a(localQQAppInterface.getApplication(), alud.a(2131707068), 0).b(localQQAppInterface.getApp().getResources().getDimensionPixelSize(2131298914));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.8.1
 * JD-Core Version:    0.7.0.1
 */