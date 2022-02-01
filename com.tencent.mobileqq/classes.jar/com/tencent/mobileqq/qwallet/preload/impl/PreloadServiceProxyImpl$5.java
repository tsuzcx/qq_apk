package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class PreloadServiceProxyImpl$5
  extends ResultReceiver
{
  PreloadServiceProxyImpl$5(PreloadServiceProxyImpl paramPreloadServiceProxyImpl, Handler paramHandler, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null))
    {
      paramInt = paramBundle.getInt("result_code");
      paramBundle = (IPreloadService.PathResult)paramBundle.getSerializable("path_result");
      Object localObject = this.a;
      if (localObject != null) {
        ((IPreloadService.OnGetPathListener)localObject).onResult(paramInt, paramBundle);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadUrls");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.d("PreloadServiceProxy", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadServiceProxy", 2, "downloadUrls IPC wrong");
      }
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.onResult(1, IPreloadService.PathResult.getFailRes(null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */