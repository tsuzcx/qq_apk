package com.tencent.mobileqq.vas.adv.base.support.gdt;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.vas.adv.reward.VasProfitableCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtImpl$showMotiveAd$browsingAdReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvGdtImpl$showMotiveAd$browsingAdReceiver$1
  extends BroadcastReceiver
{
  VasAdvGdtImpl$showMotiveAd$browsingAdReceiver$1(Activity paramActivity, VasProfitableCallback paramVasProfitableCallback) {}
  
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    this.a.unregisterReceiver((BroadcastReceiver)this);
    if (paramIntent != null) {
      paramContext = paramIntent.getAction();
    } else {
      paramContext = null;
    }
    boolean bool = false;
    if ((paramContext != null) && (paramContext.hashCode() == 403339419) && (paramContext.equals("cooperation.vip.impl.vas_browsing_ad_action"))) {
      bool = paramIntent.getBooleanExtra("profitable_flag", false);
    }
    this.b.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl.showMotiveAd.browsingAdReceiver.1
 * JD-Core Version:    0.7.0.1
 */