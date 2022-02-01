package cooperation.qqreader;

import android.os.Bundle;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;

class QRRemoteAsynCommond$1
  extends PublicAccountObserver
{
  QRRemoteAsynCommond$1(QRRemoteAsynCommond paramQRRemoteAsynCommond, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    paramString = new Bundle();
    paramString.putBoolean("isSuccess", paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener.onInvokeFinish(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.QRRemoteAsynCommond.1
 * JD-Core Version:    0.7.0.1
 */