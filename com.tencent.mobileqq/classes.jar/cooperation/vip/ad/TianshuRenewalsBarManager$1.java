package cooperation.vip.ad;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class TianshuRenewalsBarManager$1
  implements View.OnClickListener
{
  TianshuRenewalsBarManager$1(QQAppInterface paramQQAppInterface, VipBannerInfo paramVipBannerInfo) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a().a(26, 0, null);
    TianshuRenewalsBarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 122, this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.a, this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuRenewalsBarManager.1
 * JD-Core Version:    0.7.0.1
 */