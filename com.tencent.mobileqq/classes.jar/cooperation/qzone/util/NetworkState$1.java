package cooperation.qzone.util;

import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

final class NetworkState$1
  implements INetEventHandler
{
  public void onNetChangeEvent(boolean paramBoolean)
  {
    QLog.i("NetworkState", 1, "--onNetChangeEvent isNetEffective:" + paramBoolean);
    NetworkState.access$000(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.util.NetworkState.1
 * JD-Core Version:    0.7.0.1
 */