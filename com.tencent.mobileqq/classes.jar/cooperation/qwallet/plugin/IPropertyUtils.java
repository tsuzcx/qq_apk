package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPropertyUtils
  extends QRouteApi
{
  public abstract String getNetworkType(Context paramContext);
  
  public abstract String getQWalletPluginProxyActivityName();
  
  public abstract int getScreenWidth(Activity paramActivity);
  
  public abstract int getTitleBarHeight(Activity paramActivity);
  
  public abstract int getToastOffset(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.IPropertyUtils
 * JD-Core Version:    0.7.0.1
 */