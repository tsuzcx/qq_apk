package com.tencent.mobileqq.utils;

import java.lang.ref.WeakReference;

class QQCustomArkDialog$2$1
  implements Runnable
{
  QQCustomArkDialog$2$1(QQCustomArkDialog.2 param2, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    QQCustomArkDialog localQQCustomArkDialog = (QQCustomArkDialog)this.a.get();
    if (localQQCustomArkDialog == null) {
      return;
    }
    QQCustomArkDialog.a(localQQCustomArkDialog, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.2.1
 * JD-Core Version:    0.7.0.1
 */