package com.tencent.mobileqq.qrscan.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class QRScanMainQIPCModule$1
  implements QRScanResDownloadManager.DownloadCallback
{
  QRScanMainQIPCModule$1(QRScanMainQIPCModule paramQRScanMainQIPCModule, int paramInt, String paramString) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.jdField_a_of_type_Int)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_download_progress", paramInt2);
      localBundle.putInt("key_res_type", paramInt1);
      QIPCServerHelper.getInstance().callClient(this.jdField_a_of_type_JavaLangString, "QRScanSubQIPCModule", "action_notify_download_process", localBundle, null);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("key_download_result", paramBoolean);
      localBundle.putInt("key_res_type", paramInt);
      QIPCServerHelper.getInstance().callClient(this.jdField_a_of_type_JavaLangString, "QRScanSubQIPCModule", "action_notify_download_result", localBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.QRScanMainQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */