import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class oxj
  extends TroopGiftCallback
{
  public oxj(TroopGiftPanel paramTroopGiftPanel, TroopGiftAioItemData paramTroopGiftAioItemData) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e >= 4)
    {
      NearbyFlowerManager.a("gift_store", "fail_all", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() + "", "", "");
      return;
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forall_fail", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult productId = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e >= 4)
    {
      NearbyFlowerManager.a("gift_store", "suc_all", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() + "", "", "");
      return;
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forall_suc", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxj
 * JD-Core Version:    0.7.0.1
 */