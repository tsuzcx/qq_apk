package cooperation.qzone;

import com.tencent.mobileqq.qroute.route.Router.OnCompleteListener;
import com.tencent.qphone.base.util.QLog;

final class QZoneHelper$3
  implements Router.OnCompleteListener
{
  public void onError(int paramInt)
  {
    QLog.i("QZoneHelper", 2, "start SendHbActivity onError");
  }
  
  public void onSuccess()
  {
    QLog.i("QZoneHelper", 2, "start SendHbActivity onSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.3
 * JD-Core Version:    0.7.0.1
 */