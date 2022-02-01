package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class QQFMToastUtil$6
  implements Runnable
{
  QQFMToastUtil$6(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplication.getContext(), 0, this.a, 0).b(QQFMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFMToastUtil.6
 * JD-Core Version:    0.7.0.1
 */