package com.tencent.qzonehub.api.impl;

import android.os.ResultReceiver;
import com.tencent.qzonehub.api.DownloadResultCallback;
import com.tencent.qzonehub.api.IQzoneVideoSoDownloadModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;

public class QzoneVideoSoDownloadModuleImpl
  implements IQzoneVideoSoDownloadModule
{
  public ResultReceiver getReceiverForSending(DownloadResultCallback paramDownloadResultCallback)
  {
    return QzoneVideoSoDownloadModule.getReceiverForSending(paramDownloadResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneVideoSoDownloadModuleImpl
 * JD-Core Version:    0.7.0.1
 */