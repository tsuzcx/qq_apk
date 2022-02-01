package cooperation.vip.common;

import android.app.Activity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;

public class VipClass
  extends VipHandler
{
  private static VipClass b = new VipClass();
  
  public static VipClass getInstance()
  {
    return b;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramActivity, paramString, 2004, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.common.VipClass
 * JD-Core Version:    0.7.0.1
 */