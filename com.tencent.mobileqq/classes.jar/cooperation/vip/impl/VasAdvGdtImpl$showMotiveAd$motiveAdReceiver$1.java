package cooperation.vip.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import cooperation.vip.reward.VasProfitableCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/impl/VasAdvGdtImpl$showMotiveAd$motiveAdReceiver$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_CooperationVipRewardVasProfitableCallback.a(bool);
      return;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("profitable_flag");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.impl.VasAdvGdtImpl.showMotiveAd.motiveAdReceiver.1
 * JD-Core Version:    0.7.0.1
 */