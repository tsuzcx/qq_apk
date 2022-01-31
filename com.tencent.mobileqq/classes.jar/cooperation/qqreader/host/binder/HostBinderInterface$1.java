package cooperation.qqreader.host.binder;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteResultCallback;

class HostBinderInterface$1
  extends RemoteResultCallback
{
  HostBinderInterface$1(HostBinderInterface paramHostBinderInterface, HostBinderInterface.TransferCallback paramTransferCallback) {}
  
  public void onCallback(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_CooperationQqreaderHostBinderHostBinderInterface$TransferCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderHostBinderHostBinderInterface$TransferCallback.onCallback(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.binder.HostBinderInterface.1
 * JD-Core Version:    0.7.0.1
 */