package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class QQFMToastUtil$10
  implements Runnable
{
  QQFMToastUtil$10(int paramInt) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(BaseApplication.getContext());
    localQQToast.a(2130839548);
    localQQToast.d(3000);
    localQQToast.c(this.a);
    localQQToast.b(QQFMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFMToastUtil.10
 * JD-Core Version:    0.7.0.1
 */