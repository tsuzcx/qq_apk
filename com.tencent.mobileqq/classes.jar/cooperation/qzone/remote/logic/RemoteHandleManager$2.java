package cooperation.qzone.remote.logic;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;

class RemoteHandleManager$2
  implements QZoneApiProxy.QZoneLoadCallback
{
  RemoteHandleManager$2(RemoteHandleManager paramRemoteHandleManager, SendMsg paramSendMsg, String paramString) {}
  
  public void onLoadOver(boolean paramBoolean)
  {
    if (this.this$0.getServiceProxy() != null)
    {
      this.this$0.getServiceProxy().sendMsg(this.val$sendMsg);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendData getServiceProxy()== null cmd= ");
    localStringBuilder.append(this.val$destCmd);
    QLog.e("RemoteHandleManager", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.remote.logic.RemoteHandleManager.2
 * JD-Core Version:    0.7.0.1
 */