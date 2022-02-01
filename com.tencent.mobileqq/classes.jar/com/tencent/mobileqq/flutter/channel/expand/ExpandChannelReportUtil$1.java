package com.tencent.mobileqq.flutter.channel.expand;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandChannelReportUtil$1
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand", 2, "ACTION_DO_REPORT onCallback");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandChannelReportUtil.1
 * JD-Core Version:    0.7.0.1
 */