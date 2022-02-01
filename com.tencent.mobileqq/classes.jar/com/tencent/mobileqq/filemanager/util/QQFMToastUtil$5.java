package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class QQFMToastUtil$5
  implements Runnable
{
  QQFMToastUtil$5(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplication.getContext(), 2, this.a, 1).b(QQFMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFMToastUtil.5
 * JD-Core Version:    0.7.0.1
 */