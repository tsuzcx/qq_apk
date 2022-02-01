package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.res.Resources;
import android.os.Bundle;
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
    if (!QfileFavFileRecordProvider.i(this.this$0)) {
      return;
    }
    String str = QfileFavFileRecordProvider.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QfileFavFileRecordProvider.b);
    localStringBuilder.append("refresh favList timeout!!!");
    QLog.e(str, 1, localStringBuilder.toString());
    QfileFavFileRecordProvider.j(this.this$0);
    int i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920);
    int j = (int)DisplayUtils.a(BaseApplication.getContext(), 5.0F);
    QQToast.makeText(BaseApplication.getContext(), 0, 2131896194, 0).show(i - j);
    QfileFavFileRecordProvider.k(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), new Bundle() } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.3
 * JD-Core Version:    0.7.0.1
 */