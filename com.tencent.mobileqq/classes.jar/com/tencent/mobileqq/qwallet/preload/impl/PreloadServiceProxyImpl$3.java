package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class PreloadServiceProxyImpl$3
  implements EIPCResultCallback
{
  PreloadServiceProxyImpl$3(PreloadServiceProxyImpl paramPreloadServiceProxyImpl, IPreloadService.OnGetPathListener paramOnGetPathListener, DownloadParam paramDownloadParam) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      i = paramEIPCResult.data.getInt("result_code");
      paramEIPCResult = (IPreloadService.PathResult)paramEIPCResult.data.getSerializable("path_result");
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathListener.onResult(i, paramEIPCResult);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathListener == null)
    {
      int i;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathListener.onResult(1, IPreloadService.PathResult.getFailRes(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */