import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nzd
  implements View.OnClickListener
{
  public nzd(PublicAccountBrowser paramPublicAccountBrowser, RIJRedPacketPopupView paramRIJRedPacketPopupView) {}
  
  public void onClick(View paramView)
  {
    PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzd
 * JD-Core Version:    0.7.0.1
 */