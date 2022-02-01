package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneVideoSoDownloadModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

final class VideoJsProxyImpl$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = ((IQzoneVideoSoDownloadModule)QRoute.api(IQzoneVideoSoDownloadModule.class)).getReceiverForSending(new VideoJsProxyImpl.1.1(this));
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putParcelable("key_download_result_receiver", (Parcelable)localObject1);
    localObject1 = QIPCClientHelper.getInstance().getClient().callServer("QzoneVideoSoDownloadModule", "action_download_avcodec", (Bundle)localObject2);
    if ((localObject1 != null) && (((EIPCResult)localObject1).code == 0))
    {
      QLog.i("VideoJsPlugin", 1, "loadFFmpeg: start");
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadFFmpeg: failed ");
    int i;
    if (localObject1 == null) {
      i = -1;
    } else {
      i = ((EIPCResult)localObject1).code;
    }
    ((StringBuilder)localObject2).append(i);
    QLog.w("VideoJsPlugin", 1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */