package cooperation.weiyun;

import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;

final class TransmissionHelper$1
  implements INetEventHandler
{
  public void onNetChangeEvent(boolean paramBoolean)
  {
    WeiyunTransmissionStatus.getInstance().onReceiveNetChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.TransmissionHelper.1
 * JD-Core Version:    0.7.0.1
 */