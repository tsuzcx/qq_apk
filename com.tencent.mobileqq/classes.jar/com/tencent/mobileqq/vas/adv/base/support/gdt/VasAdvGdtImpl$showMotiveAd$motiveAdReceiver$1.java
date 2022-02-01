package com.tencent.mobileqq.vas.adv.base.support.gdt;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.vas.adv.reward.VasProfitableCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtImpl$showMotiveAd$motiveAdReceiver$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvGdtImpl$showMotiveAd$motiveAdReceiver$1
  extends ResultReceiver
{
  VasAdvGdtImpl$showMotiveAd$motiveAdReceiver$1(VasProfitableCallback paramVasProfitableCallback, Handler paramHandler1, Handler paramHandler2)
  {
    super(paramHandler2);
  }
  
  protected void onReceiveResult(int paramInt, @Nullable Bundle paramBundle)
  {
    boolean bool = false;
    if ((paramInt == -1) && (paramBundle != null)) {
      bool = paramBundle.getBoolean("profitable_flag");
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAdvRewardVasProfitableCallback.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl.showMotiveAd.motiveAdReceiver.1
 * JD-Core Version:    0.7.0.1
 */