package com.tencent.mobileqq.emosm.web;

import ajya;
import android.content.res.Resources;
import anuo;
import bcql;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class MessengerService$8$1
  implements Runnable
{
  public MessengerService$8$1(anuo paramanuo) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MessengerService.i(this.a.a);
    bcql.a(localQQAppInterface.getApplication(), ajya.a(2131706684), 0).b(localQQAppInterface.getApp().getResources().getDimensionPixelSize(2131298865));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.8.1
 * JD-Core Version:    0.7.0.1
 */