package com.tencent.mobileqq.utils;

import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class QQCustomArkDialogForAio$2
  implements ArkViewImplement.LoadCallback
{
  QQCustomArkDialogForAio$2(QQCustomArkDialogForAio paramQQCustomArkDialogForAio) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this.this$0);
    ThreadManager.getUIHandler().post(new QQCustomArkDialogForAio.2.1(this, localWeakReference, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialogForAio.2
 * JD-Core Version:    0.7.0.1
 */