import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.BannerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelTopBanner;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;

public class slc
  extends Handler
{
  public slc(ChannelTopBanner paramChannelTopBanner, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((ChannelTopBanner.a(this.a)) || (!ChannelTopBanner.b(this.a))) {}
    while (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.getCount() <= 1) {
      return;
    }
    paramMessage = this.a;
    paramMessage.jdField_a_of_type_Int += 1;
    this.a.jdField_a_of_type_Int %= this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.getCount();
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setCurrentItem(this.a.jdField_a_of_type_Int, true);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 4000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     slc
 * JD-Core Version:    0.7.0.1
 */