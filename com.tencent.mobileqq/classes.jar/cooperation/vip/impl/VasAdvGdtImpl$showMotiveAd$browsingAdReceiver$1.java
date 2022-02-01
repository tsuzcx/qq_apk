package cooperation.vip.impl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.vip.reward.VasProfitableCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/impl/VasAdvGdtImpl$showMotiveAd$browsingAdReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvGdtImpl$showMotiveAd$browsingAdReceiver$1
  extends BroadcastReceiver
{
  VasAdvGdtImpl$showMotiveAd$browsingAdReceiver$1(Activity paramActivity, VasProfitableCallback paramVasProfitableCallback) {}
  
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver((BroadcastReceiver)this);
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null) {
        break label42;
      }
    }
    for (boolean bool = false;; bool = paramIntent.getBooleanExtra("profitable_flag", false))
    {
      this.jdField_a_of_type_CooperationVipRewardVasProfitableCallback.a(bool);
      return;
      paramContext = null;
      break;
      label42:
      switch (paramContext.hashCode())
      {
      default: 
        break;
      case 403339419: 
        if (!paramContext.equals("cooperation.vip.impl.vas_browsing_ad_action")) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.impl.VasAdvGdtImpl.showMotiveAd.browsingAdReceiver.1
 * JD-Core Version:    0.7.0.1
 */