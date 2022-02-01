package cooperation.qzone.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQZoneEventHandlerProxy;

public class QZoneEventHandler
{
  private static final String TAG = "QZoneEventHandler";
  
  public static boolean handleActivityEvent(Object paramObject, int paramInt1, int paramInt2, Intent paramIntent)
  {
    return ((IQZoneEventHandlerProxy)QRoute.api(IQZoneEventHandlerProxy.class)).handleActivityEvent(paramObject, paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.api.QZoneEventHandler
 * JD-Core Version:    0.7.0.1
 */