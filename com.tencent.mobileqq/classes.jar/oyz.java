import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.OnGetGiveGiftCallback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class oyz
  extends TroopGiftCallback
{
  public oyz(TroopGiftPanel paramTroopGiftPanel, TroopGiftPanel.OnGetGiveGiftCallback paramOnGetGiveGiftCallback) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "onGetStockResult count = " + paramInt1);
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c = (paramInt1 + paramInt2);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt1 + "");
      if (paramInt2 > 0)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d.setText("+" + paramInt2);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetGiveGiftCallback != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetGiveGiftCallback.a(paramList);
      return;
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d.setText("");
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d.setVisibility(8);
      continue;
      new Handler(Looper.getMainLooper()).post(new oza(this, paramInt1));
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a(paramList);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel", 2, "onGetStockResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetGiveGiftCallback != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnGetGiveGiftCallback.a(paramInt);
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "video_mall", "fail_expbean", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyz
 * JD-Core Version:    0.7.0.1
 */