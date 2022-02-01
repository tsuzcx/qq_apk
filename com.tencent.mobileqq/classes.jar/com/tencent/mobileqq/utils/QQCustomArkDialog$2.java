package com.tencent.mobileqq.utils;

import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class QQCustomArkDialog$2
  implements ArkViewImplement.LoadCallback
{
  QQCustomArkDialog$2(QQCustomArkDialog paramQQCustomArkDialog) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this.a);
    ThreadManager.getUIHandler().post(new QQCustomArkDialog.2.1(this, localWeakReference, paramInt));
    if (paramInt == 0) {
      return;
    }
    QQCustomArkDialog.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomArkDialog", 2, new Object[] { "arkView init finish,load state = ", Integer.valueOf(paramInt), ";outsideShowDialog = ", Boolean.valueOf(QQCustomArkDialog.a(this.a)), ";alreadyShowDialog:", Boolean.valueOf(QQCustomArkDialog.b(this.a)) });
    }
    if (QQCustomArkDialog.a(this.a)) {
      ThreadManager.getUIHandler().post(new QQCustomArkDialog.2.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.2
 * JD-Core Version:    0.7.0.1
 */