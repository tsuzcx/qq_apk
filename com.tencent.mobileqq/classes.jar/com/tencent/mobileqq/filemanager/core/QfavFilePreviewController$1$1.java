package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class QfavFilePreviewController$1$1
  implements Runnable
{
  QfavFilePreviewController$1$1(QfavFilePreviewController.1 param1, Bundle paramBundle) {}
  
  public void run()
  {
    QfavFilePreviewController.a(this.b.a, this.a.getInt("previewPort", 80));
    QfavFilePreviewController.a(this.b.a, this.a.getLong("previewCode", 0L));
    QfavFilePreviewController.a(this.b.a, this.a.getString("previewUid"));
    QfavFilePreviewController.b(this.b.a, this.a.getString("previewHost"));
    QfavFilePreviewController.c(this.b.a, this.a.getString("previewKey"));
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleRemoteCmd: mHost=");
      ((StringBuilder)localObject).append(QfavFilePreviewController.a(this.b.a));
      ((StringBuilder)localObject).append(", port=");
      ((StringBuilder)localObject).append(String.valueOf(QfavFilePreviewController.b(this.b.a)));
      ((StringBuilder)localObject).append(", key=");
      ((StringBuilder)localObject).append(QfavFilePreviewController.c(this.b.a));
      ((StringBuilder)localObject).append(", retCode =");
      ((StringBuilder)localObject).append(String.valueOf(QfavFilePreviewController.d(this.b.a)));
      QLog.i("QfavFilePreviewController", 2, ((StringBuilder)localObject).toString());
    }
    if (1 == QfavFilePreviewController.e(this.b.a))
    {
      localObject = this.b.a.a;
      boolean bool;
      if (0L == QfavFilePreviewController.d(this.b.a)) {
        bool = true;
      } else {
        bool = false;
      }
      ((ControlerCallback)localObject).a(bool, QfavFilePreviewController.a(this.b.a), String.valueOf(QfavFilePreviewController.b(this.b.a)), QfavFilePreviewController.d(this.b.a), null, QfavFilePreviewController.c(this.b.a), null, QfavFilePreviewController.f(this.b.a), null);
    }
    QfavFilePreviewController.b(this.b.a, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.1.1
 * JD-Core Version:    0.7.0.1
 */