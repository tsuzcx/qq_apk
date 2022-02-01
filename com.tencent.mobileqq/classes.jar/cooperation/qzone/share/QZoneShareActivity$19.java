package cooperation.qzone.share;

import android.os.Bundle;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;

class QZoneShareActivity$19
  implements OpensdkBusinessObserver
{
  QZoneShareActivity$19(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    synchronized (QZoneShareActivity.sAppinfoLock)
    {
      this.this$0.mIsGettingAppinfo = false;
      if (paramBoolean) {
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle != null)
          {
            GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
            localGetAppinfoResponse.mergeFrom(paramBundle);
            this.this$0.mGetAppinfoResponse = localGetAppinfoResponse;
            if (QLog.isColorLevel())
            {
              paramBundle = new StringBuilder();
              paramBundle.append("get appinfo time = ");
              paramBundle.append(System.currentTimeMillis() - this.this$0.mTempTime);
              QLog.d("QZoneShare", 2, paramBundle.toString());
            }
          }
        }
        catch (Exception paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 2, paramBundle.getMessage());
          }
        }
      }
      QZoneShareActivity.sAppinfoLock.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.19
 * JD-Core Version:    0.7.0.1
 */