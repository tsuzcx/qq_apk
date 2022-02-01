package com.tencent.mobileqq.filemanager.util;

import auna;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class FMToastUtil$10
  implements Runnable
{
  public void run()
  {
    QQToast localQQToast = new QQToast(BaseApplicationImpl.getContext());
    localQQToast.a(2130839555);
    localQQToast.d(3000);
    localQQToast.c(this.a);
    localQQToast.b(auna.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil.10
 * JD-Core Version:    0.7.0.1
 */