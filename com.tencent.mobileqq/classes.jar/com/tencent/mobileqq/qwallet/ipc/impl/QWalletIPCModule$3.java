package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.qwallet.temp.IConditionSearchManager;
import com.qwallet.temp.IConditionSearchManager.IConfigListenerProxy;

class QWalletIPCModule$3
  implements IConditionSearchManager.IConfigListenerProxy
{
  QWalletIPCModule$3(QWalletIPCModule paramQWalletIPCModule, Bundle paramBundle, int paramInt, ResultReceiver paramResultReceiver, IConditionSearchManager paramIConditionSearchManager) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.putInt("updateResult", this.b);
    if (paramBoolean) {
      this.a.putInt("isUpdateSuccess", 1);
    } else {
      this.a.putInt("isUpdateSuccess", -1);
    }
    this.c.send(1, this.a);
    this.d.removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.3
 * JD-Core Version:    0.7.0.1
 */