package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class QQFMToastUtil$4
  implements Runnable
{
  QQFMToastUtil$4(String paramString) {}
  
  public void run()
  {
    QQToast.makeText(BaseApplication.getContext(), 2, this.a, 0).show(QQFMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFMToastUtil.4
 * JD-Core Version:    0.7.0.1
 */