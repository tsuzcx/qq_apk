package com.tencent.mobileqq.unifiedebug;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.unifiedebug.RemoteDebugReportMsg.RemoteLogRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class UnifiedDebugReporter$1
  implements BusinessObserver
{
  UnifiedDebugReporter$1(UnifiedDebugReporter paramUnifiedDebugReporter) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("extra_data");
      if (paramBundle == null) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        RemoteDebugReportMsg.RemoteLogRsp localRemoteLogRsp = new RemoteDebugReportMsg.RemoteLogRsp();
        localRemoteLogRsp.mergeFrom(paramBundle);
        if (localRemoteLogRsp.i32_ret.has())
        {
          paramInt = localRemoteLogRsp.i32_ret.get();
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugReporter", 2, "onReceive: retCode=" + paramInt);
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("UnifiedDebugReporter", 2, "onReceive: exception=" + paramBundle.getMessage());
        return;
      }
    }
    QLog.e("UnifiedDebugReporter", 2, "onReceive: isSuccess=" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugReporter.1
 * JD-Core Version:    0.7.0.1
 */