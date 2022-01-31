import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftAioPanelData.CoinInfo;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

public class ozf
  implements DialogInterface.OnClickListener
{
  public ozf(TroopGiftPanel paramTroopGiftPanel, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.c)))
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b();
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d == 2) {
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_topay", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d == 6)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_topay", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d == 7)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_topay", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e >= 4)
    {
      NearbyFlowerManager.a("gift_store", "pay_tip", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() + "", "", "");
      return;
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_topay", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozf
 * JD-Core Version:    0.7.0.1
 */