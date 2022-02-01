import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class nzr
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        if ((localWebSsoResponseBody.ret.get() == 0) && (QLog.isColorLevel())) {
          QLog.d("NativeAdUtils", 2, "doAdReport success!");
        }
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzr
 * JD-Core Version:    0.7.0.1
 */