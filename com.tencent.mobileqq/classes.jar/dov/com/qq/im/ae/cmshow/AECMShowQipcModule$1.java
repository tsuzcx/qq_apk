package dov.com.qq.im.ae.cmshow;

import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

final class AECMShowQipcModule$1
  implements EIPCResultCallback
{
  AECMShowQipcModule$1(AECMShowResourceManager.CMJoyEssentialDownloadCallback paramCMJoyEssentialDownloadCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess())
    {
      bool = paramEIPCResult.data.getBoolean("key_resource_download_all_succeeded");
      paramEIPCResult = (HashMap)paramEIPCResult.data.getSerializable("key_resource_download_result");
      if (this.a != null) {
        this.a.a(bool, paramEIPCResult);
      }
    }
    while (this.a == null)
    {
      boolean bool;
      return;
    }
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowQipcModule.1
 * JD-Core Version:    0.7.0.1
 */