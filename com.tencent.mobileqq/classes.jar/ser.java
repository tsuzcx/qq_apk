import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.ReportPublicAccountResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class ser
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "reportClickEventForAdver onReceive: " + String.valueOf(paramBoolean));
    }
    long l2;
    if (paramBoolean) {
      l2 = -1L;
    }
    do
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        mobileqq_mp.ReportPublicAccountResponse localReportPublicAccountResponse = new mobileqq_mp.ReportPublicAccountResponse();
        localReportPublicAccountResponse.mergeFrom(paramBundle);
        l1 = l2;
        if (localReportPublicAccountResponse.ret_info.has())
        {
          l1 = l2;
          if (localReportPublicAccountResponse.ret_info.ret_code.has())
          {
            paramInt = localReportPublicAccountResponse.ret_info.ret_code.get();
            l2 = paramInt;
            l1 = l2;
            if (l2 == 0L)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PAReport", 2, "reportClickEventRuntime ret_code: " + String.valueOf(l2));
              }
              return;
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        long l1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PAReport", 2, "reportClickEventRuntime exception", paramBundle);
        return;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label288;
        }
        QLog.d("PAReport", 2, "reportClickEventRuntime ret_code: " + String.valueOf(-1L));
      }
    } while (!QLog.isColorLevel());
    QLog.d("PAReport", 2, "reportClickEventRuntime ret_code: " + String.valueOf(l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ser
 * JD-Core Version:    0.7.0.1
 */