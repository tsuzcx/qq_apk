package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

final class VideoJsPlugin$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = QzoneVideoSoDownloadModule.getReceiverForSending(new VideoJsPlugin.1.1(this));
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putParcelable("key_download_result_receiver", (Parcelable)localObject1);
    localObject1 = QIPCClientHelper.getInstance().getClient().callServer("QzoneVideoSoDownloadModule", "action_download_avcodec", (Bundle)localObject2);
    if ((localObject1 != null) && (((EIPCResult)localObject1).code == 0))
    {
      QLog.i("VideoJsPlugin", 1, "loadFFmpeg: start");
      return;
    }
    localObject2 = new StringBuilder().append("loadFFmpeg: failed ");
    if (localObject1 == null) {}
    for (int i = -1;; i = ((EIPCResult)localObject1).code)
    {
      QLog.w("VideoJsPlugin", 1, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */