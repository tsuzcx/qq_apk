package cooperation.vip.ad;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class TianshuRenewalsBarManager$2
  implements View.OnClickListener
{
  TianshuRenewalsBarManager$2(VipBannerInfo paramVipBannerInfo, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if ("1".equals(this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.k)) {
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    }
    for (;;)
    {
      if (localIntent != null)
      {
        localIntent.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.d);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
        BannerManager.a().a(26, 0, null);
      }
      TianshuRenewalsBarManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 102, this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.a, this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.b);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ("2".equals(this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.k)) {
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQTranslucentBrowserActivity.class);
      } else {
        localIntent = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuRenewalsBarManager.2
 * JD-Core Version:    0.7.0.1
 */