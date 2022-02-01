package cooperation.qqcircle.utils;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.utils.NetworkState.1
 * JD-Core Version:    0.7.0.1
 */