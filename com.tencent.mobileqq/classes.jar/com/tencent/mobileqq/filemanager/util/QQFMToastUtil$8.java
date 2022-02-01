package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class QQFMToastUtil$8
  implements Runnable
{
  QQFMToastUtil$8(int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    QQToast.makeText(BaseApplication.getContext(), this.a, this.b, this.c).show(QQFMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFMToastUtil.8
 * JD-Core Version:    0.7.0.1
 */