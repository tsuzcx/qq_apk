import android.graphics.Rect;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotifyAd;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.qphone.base.util.QLog;

public class pcm
  implements BounceScrollView.OnScrollChangedListener
{
  public pcm(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd != null) && (this.a.d))
    {
      Rect localRect = new Rect();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getHitRect(localRect);
      if (this.a.jdField_a_of_type_ComTencentImageURLImageView.getLocalVisibleRect(localRect))
      {
        this.a.d = false;
        TroopBarUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd.a, 0, null, null);
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", "exp_ad", 0, 0, this.a.b, String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.a), "8020205751015455", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "onScrollChanged 广告图片可见-------------------------");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcm
 * JD-Core Version:    0.7.0.1
 */