package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathsListener;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

class PreloadServiceProxyImpl$4
  implements EIPCResultCallback
{
  PreloadServiceProxyImpl$4(PreloadServiceProxyImpl paramPreloadServiceProxyImpl, IPreloadService.OnGetPathsListener paramOnGetPathsListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      int i = paramEIPCResult.data.getInt("result_code");
      paramEIPCResult = (HashMap)paramEIPCResult.data.getSerializable("path_result");
      IPreloadService.OnGetPathsListener localOnGetPathsListener = this.a;
      if (localOnGetPathsListener != null) {
        localOnGetPathsListener.a(i, paramEIPCResult);
      }
    }
    else
    {
      paramEIPCResult = this.a;
      if (paramEIPCResult != null) {
        paramEIPCResult.a(1, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */