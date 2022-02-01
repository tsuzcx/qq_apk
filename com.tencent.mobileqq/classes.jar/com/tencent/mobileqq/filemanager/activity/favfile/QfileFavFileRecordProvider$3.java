package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.res.Resources;
import android.os.Bundle;
import arxv;
import bfvh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QfileFavFileRecordProvider$3
  implements Runnable
{
  public QfileFavFileRecordProvider$3(arxv paramarxv) {}
  
  public void run()
  {
    if (!arxv.c(this.this$0)) {
      return;
    }
    QLog.e(arxv.a, 1, arxv.b + "refresh favList timeout!!!");
    arxv.e(this.this$0);
    int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299076);
    int j = (int)bfvh.a(BaseApplicationImpl.getContext(), 5.0F);
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131697672, 0).b(i - j);
    arxv.f(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), new Bundle() } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.3
 * JD-Core Version:    0.7.0.1
 */