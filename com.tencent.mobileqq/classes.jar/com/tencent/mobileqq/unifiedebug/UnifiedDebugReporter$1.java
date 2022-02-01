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
      if (paramBundle != null)
      {
        try
        {
          localObject = new RemoteDebugReportMsg.RemoteLogRsp();
          ((RemoteDebugReportMsg.RemoteLogRsp)localObject).mergeFrom(paramBundle);
          if (!((RemoteDebugReportMsg.RemoteLogRsp)localObject).i32_ret.has()) {
            return;
          }
          paramInt = ((RemoteDebugReportMsg.RemoteLogRsp)localObject).i32_ret.get();
          if (!QLog.isColorLevel()) {
            return;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("onReceive: retCode=");
          paramBundle.append(paramInt);
          QLog.d("UnifiedDebugReporter", 2, paramBundle.toString());
          return;
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceive: exception=");
        ((StringBuilder)localObject).append(paramBundle.getMessage());
        QLog.e("UnifiedDebugReporter", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onReceive: isSuccess=");
      paramBundle.append(paramBoolean);
      QLog.e("UnifiedDebugReporter", 2, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugReporter.1
 * JD-Core Version:    0.7.0.1
 */