package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

final class QQUtils$1
  implements Runnable
{
  QQUtils$1(QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    QQToast.makeText(this.a.getApp(), this.b, 0).show(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils.1
 * JD-Core Version:    0.7.0.1
 */