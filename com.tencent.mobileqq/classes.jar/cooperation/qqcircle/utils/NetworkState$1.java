package cooperation.qqcircle.utils;

import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

final class NetworkState$1
  implements INetEventHandler
{
  public void onNetChangeEvent(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--onNetChangeEvent isNetEffective:");
    localStringBuilder.append(paramBoolean);
    QLog.i("NetworkState", 1, localStringBuilder.toString());
    NetworkState.access$000(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.utils.NetworkState.1
 * JD-Core Version:    0.7.0.1
 */