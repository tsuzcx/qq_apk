package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;

public class PropertyUtils
{
  public static String getNetworkType(Context paramContext)
  {
    return ((IPropertyUtils)QRoute.api(IPropertyUtils.class)).getNetworkType(paramContext);
  }
  
  public static int getScreenWidth(Activity paramActivity)
  {
    return ((IPropertyUtils)QRoute.api(IPropertyUtils.class)).getScreenWidth(paramActivity);
  }
  
  public static int getTitleBarHeight(Activity paramActivity)
  {
    return ((IPropertyUtils)QRoute.api(IPropertyUtils.class)).getTitleBarHeight(paramActivity);
  }
  
  public static int getToastOffset(Context paramContext)
  {
    return ((IPropertyUtils)QRoute.api(IPropertyUtils.class)).getToastOffset(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.PropertyUtils
 * JD-Core Version:    0.7.0.1
 */