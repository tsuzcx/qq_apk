package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QfileFavFileRecordProvider$3
  implements Runnable
{
  QfileFavFileRecordProvider$3(QfileFavFileRecordProvider paramQfileFavFileRecordProvider) {}
  
  public void run()
  {
    if (!QfileFavFileRecordProvider.c(this.this$0)) {
      return;
    }
    QLog.e(QfileFavFileRecordProvider.a, 1, QfileFavFileRecordProvider.b + "refresh favList timeout!!!");
    QfileFavFileRecordProvider.e(this.this$0);
    int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299166);
    int j = (int)DisplayUtils.a(BaseApplicationImpl.getContext(), 5.0F);
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131698228, 0).b(i - j);
    QfileFavFileRecordProvider.f(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), new Bundle() } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.3
 * JD-Core Version:    0.7.0.1
 */