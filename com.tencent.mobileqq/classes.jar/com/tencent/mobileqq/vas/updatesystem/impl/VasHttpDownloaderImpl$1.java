package com.tencent.mobileqq.vas.updatesystem.impl;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.entity.DownloadInfoParams;

class VasHttpDownloaderImpl$1
  implements Runnable
{
  VasHttpDownloaderImpl$1(VasHttpDownloaderImpl paramVasHttpDownloaderImpl, DownloadInfoParams paramDownloadInfoParams, IDownloadListener paramIDownloadListener) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentVasUpdateEntityDownloadInfoParams != null)
    {
      if (this.jdField_a_of_type_ComTencentVasUpdateCallbackListenerIDownloadListener == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPreloadDownloadStart  itemId = ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentVasUpdateEntityDownloadInfoParams.mItemId);
        localStringBuilder.append(" url= ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentVasUpdateEntityDownloadInfoParams.mUrl);
        localStringBuilder.append(" savePath = ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentVasUpdateEntityDownloadInfoParams.mSavePath);
        localStringBuilder.append(" from = ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentVasUpdateEntityDownloadInfoParams.mFrom);
        QLog.i("VasUpdate_HttpImpl", 2, localStringBuilder.toString());
      }
      this.this$0.startDownload(this.jdField_a_of_type_ComTencentVasUpdateEntityDownloadInfoParams, this.jdField_a_of_type_ComTencentVasUpdateCallbackListenerIDownloadListener, new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasHttpDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */