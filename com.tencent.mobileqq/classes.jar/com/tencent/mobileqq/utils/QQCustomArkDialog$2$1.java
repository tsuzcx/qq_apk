package com.tencent.mobileqq.utils;

import java.lang.ref.WeakReference;

class QQCustomArkDialog$2$1
  implements Runnable
{
  QQCustomArkDialog$2$1(QQCustomArkDialog.2 param2, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    QQCustomArkDialog localQQCustomArkDialog = (QQCustomArkDialog)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQCustomArkDialog == null) {
      return;
    }
    QQCustomArkDialog.a(localQQCustomArkDialog, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.2.1
 * JD-Core Version:    0.7.0.1
 */