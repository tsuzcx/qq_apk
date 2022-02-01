package cooperation.qzone;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzonePatchApi;

final class QZoneHelper$7
  implements Runnable
{
  public void run()
  {
    ((IQzonePatchApi)QRoute.api(IQzonePatchApi.class)).getPatchList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.7
 * JD-Core Version:    0.7.0.1
 */