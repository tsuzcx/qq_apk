import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ozc
  extends TroopGiftCallback
{
  public ozc(TroopGiftPanel paramTroopGiftPanel, int paramInt, TroopGiftAioItemData paramTroopGiftAioItemData) {}
  
  public void a(int paramInt)
  {
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_suc", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidContentContext, "赠送失败", 0).b(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getResources().getDimensionPixelSize(2131558448));
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    Context localContext = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidContentContext;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "赠送失败";
    }
    QQToast.a(localContext, str, 0).b(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getResources().getDimensionPixelSize(2131558448));
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozc
 * JD-Core Version:    0.7.0.1
 */