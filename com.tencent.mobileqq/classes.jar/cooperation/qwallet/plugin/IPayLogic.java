package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPayLogic
  extends QRouteApi
{
  public static final String DEFAULT_PF_PREF = "qq_m_qq-";
  public static final String MINIAPP_PF_PREF = "qqapp_qq-";
  public static final String RECEIVER_COM_KEY = "_qwallet_payresult_receiver";
  public static final String RECEIVER_LOGIC_LAYER_KEY = "receiver";
  public static final String TAG = "Q.qwallet.pay.PayLogic";
  
  public abstract void doOnRestoreInstanceState(Bundle paramBundle);
  
  public abstract void doOnSaveInstanceState(Bundle paramBundle);
  
  public abstract void end();
  
  public abstract void exec();
  
  public abstract IPayLogic getLogic(int paramInt);
  
  public abstract int getTag();
  
  public abstract boolean init(Intent paramIntent, AppRuntime paramAppRuntime, Activity paramActivity);
  
  public abstract boolean isPaying();
  
  public abstract Bundle newPay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle);
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  @Deprecated
  public abstract void onDestroy();
  
  public abstract void onEndFinished();
  
  public abstract boolean tryDoOnActivityResult(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.IPayLogic
 * JD-Core Version:    0.7.0.1
 */