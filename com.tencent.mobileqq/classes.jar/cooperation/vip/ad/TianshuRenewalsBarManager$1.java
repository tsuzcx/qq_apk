package cooperation.vip.ad;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class TianshuRenewalsBarManager$1
  implements View.OnClickListener
{
  TianshuRenewalsBarManager$1(VipBannerInfo paramVipBannerInfo) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a().a(RenewalsBannerProcessor.a, 0, null);
    TianshuReportUtils.a(this.a.a, 122);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuRenewalsBarManager.1
 * JD-Core Version:    0.7.0.1
 */