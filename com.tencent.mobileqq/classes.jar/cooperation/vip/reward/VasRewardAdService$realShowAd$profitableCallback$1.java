package cooperation.vip.reward;

import com.tencent.TMG.utils.QLog;
import cooperation.vip.VasAdvService.ShowAdCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/reward/VasRewardAdService$realShowAd$profitableCallback$1", "Lcooperation/vip/reward/VasProfitableCallback;", "onResult", "", "profitable", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasRewardAdService$realShowAd$profitableCallback$1
  implements VasProfitableCallback
{
  VasRewardAdService$realShowAd$profitableCallback$1(VasAdvService.ShowAdCallback paramShowAdCallback) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_CooperationVipVasAdvService$ShowAdCallback.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("VasRewardAdService", 0, "showRewardAdv onResult profitable: " + paramBoolean);
    }
    if (paramBoolean == true) {
      VasRewardAdService.a(this.jdField_a_of_type_CooperationVipRewardVasRewardAdService);
    }
    while (paramBoolean) {
      return;
    }
    VasRewardAdService.a(this.jdField_a_of_type_CooperationVipRewardVasRewardAdService, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.reward.VasRewardAdService.realShowAd.profitableCallback.1
 * JD-Core Version:    0.7.0.1
 */