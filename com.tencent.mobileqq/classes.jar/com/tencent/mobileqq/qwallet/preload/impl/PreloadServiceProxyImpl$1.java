package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.DownloadCallback;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;

class PreloadServiceProxyImpl$1
  extends ResultReceiver
{
  PreloadServiceProxyImpl$1(PreloadServiceProxyImpl paramPreloadServiceProxyImpl, Handler paramHandler, IPreloadService.DownloadCallback paramDownloadCallback, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null))
    {
      String str1 = paramBundle.getString("id");
      paramInt = paramBundle.getInt("result");
      String str2 = paramBundle.getString("path");
      paramBundle = (ResourceInfo)paramBundle.getSerializable("res_info");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PreloadServiceProxyImpl downloadModule");
        localStringBuilder.append(str2);
        localStringBuilder.append("|");
        localStringBuilder.append(paramBundle);
        QLog.d("PreloadServiceProxy", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$DownloadCallback.onDownloadResFinished(str1, paramInt, str2, paramBundle);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadServiceProxy", 2, "PreloadServiceProxyImpl downloadModule IPC wrong");
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$DownloadCallback.onDownloadResFinished(this.jdField_a_of_type_JavaLangString, -8, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */