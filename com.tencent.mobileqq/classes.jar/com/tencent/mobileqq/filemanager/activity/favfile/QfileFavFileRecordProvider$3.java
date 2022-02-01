package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.res.Resources;
import android.os.Bundle;
import atlm;
import bhmg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QfileFavFileRecordProvider$3
  implements Runnable
{
  public QfileFavFileRecordProvider$3(atlm paramatlm) {}
  
  public void run()
  {
    if (!atlm.c(this.this$0)) {
      return;
    }
    QLog.e(atlm.a, 1, atlm.b + "refresh favList timeout!!!");
    atlm.e(this.this$0);
    int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299011);
    int j = (int)bhmg.a(BaseApplicationImpl.getContext(), 5.0F);
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131697526, 0).b(i - j);
    atlm.f(this.this$0);
    this.this$0.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), new Bundle() } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.3
 * JD-Core Version:    0.7.0.1
 */