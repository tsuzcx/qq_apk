package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class QQFMToastUtil$9
  implements Runnable
{
  QQFMToastUtil$9(int paramInt) {}
  
  public void run()
  {
    QQToast.makeText(BaseApplication.getContext(), -1, this.a, 0).show(QQFMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFMToastUtil.9
 * JD-Core Version:    0.7.0.1
 */