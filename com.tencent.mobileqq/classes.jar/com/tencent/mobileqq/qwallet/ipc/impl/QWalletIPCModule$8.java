package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathsListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import eipc.EIPCResult;
import java.util.HashMap;

class QWalletIPCModule$8
  implements IPreloadService.OnGetPathsListener
{
  QWalletIPCModule$8(QWalletIPCModule paramQWalletIPCModule, int paramInt) {}
  
  public void a(int paramInt, HashMap<String, IPreloadService.PathResult> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCModule.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.8
 * JD-Core Version:    0.7.0.1
 */