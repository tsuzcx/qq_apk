package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import eipc.EIPCResult;

class QWalletIPCModule$7
  implements IPreloadService.OnGetPathListener
{
  QWalletIPCModule$7(QWalletIPCModule paramQWalletIPCModule, int paramInt) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramPathResult);
    this.b.callbackResult(this.a, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.7
 * JD-Core Version:    0.7.0.1
 */