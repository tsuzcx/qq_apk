package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class QQUtils$2
  implements Runnable
{
  QQUtils$2(boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    String str1;
    String str2;
    if (this.a)
    {
      str1 = this.b.getApp().getString(2131916945);
      str2 = "0";
    }
    else
    {
      str1 = null;
      str2 = "1";
    }
    if (str1 != null) {
      QQToast.makeText(this.b.getApp(), 2, str1, 0).show(this.c);
    }
    ReportController.b(this.b, "CliOper", "", "", "Fast_launch", "Fast_launch_creat", 0, 0, this.d, str2, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils.2
 * JD-Core Version:    0.7.0.1
 */