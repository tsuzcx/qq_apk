package com.tencent.mobileqq.emosm.web;

import android.content.res.Resources;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class MessengerService$9$1
  implements Runnable
{
  MessengerService$9$1(MessengerService.9 param9) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MessengerService.k(this.a.a);
    QQToast.makeText(localQQAppInterface.getApplication(), HardCodeUtil.a(2131904560), 0).show(localQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299920));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.9.1
 * JD-Core Version:    0.7.0.1
 */