package cooperation.vip.ad;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class TianshuRenewalsBarManager$2
  implements View.OnClickListener
{
  TianshuRenewalsBarManager$2(VipBannerInfo paramVipBannerInfo, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if ("1".equals(this.a.k)) {
      localIntent = new Intent(this.b, QQBrowserActivity.class);
    } else if ("2".equals(this.a.k)) {
      localIntent = new Intent(this.b, QQTranslucentBrowserActivity.class);
    } else {
      localIntent = null;
    }
    if (localIntent != null)
    {
      localIntent.putExtra("url", this.a.d);
      this.b.startActivity(localIntent);
      BannerManager.a().a(RenewalsBannerProcessor.a, 0, null);
    }
    TianshuReportUtils.a(this.a.a, 102);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.ad.TianshuRenewalsBarManager.2
 * JD-Core Version:    0.7.0.1
 */