package cooperation.qzone;

import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import cooperation.qzone.util.NetworkState.NetworkStateListener;

class UploadEnv$1
  implements NetworkState.NetworkStateListener
{
  UploadEnv$1(UploadEnv paramUploadEnv, UploadConfiguration.NetworkStateObserver paramNetworkStateObserver) {}
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "upload2: onNetworkConnect registerNetworkStateObserver|onNetworkConnect：" + paramBoolean);
    }
    UploadEnv.access$002(this.this$0, paramBoolean);
    this.val$observer.onStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.UploadEnv.1
 * JD-Core Version:    0.7.0.1
 */