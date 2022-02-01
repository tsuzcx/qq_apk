package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import mqq.app.AppRuntime;

@QAPI(process={""})
@QRouteFactory(singleton=false)
public abstract interface IPayLogic
  extends QRouteApi
{
  public abstract void doOnRestoreInstanceState(Bundle paramBundle);
  
  public abstract void doOnSaveInstanceState(Bundle paramBundle);
  
  public abstract void end();
  
  public abstract void exec();
  
  public abstract int getTag();
  
  public abstract boolean init(Intent paramIntent, AppRuntime paramAppRuntime, Activity paramActivity);
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  @Deprecated
  public abstract void onDestroy();
  
  public abstract void onEndFinished();
  
  public abstract boolean tryDoOnActivityResult(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.IPayLogic
 * JD-Core Version:    0.7.0.1
 */