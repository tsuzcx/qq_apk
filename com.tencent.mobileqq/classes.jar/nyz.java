import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nyz
  implements View.OnClickListener
{
  nyz(nyy paramnyy) {}
  
  public void onClick(View paramView)
  {
    RIJRedPacketManager.a().a(paramView.getContext(), 2, 0, 0);
    PublicAccountBrowser.a(this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).b(2, PublicAccountBrowser.a(this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser), this.a.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyz
 * JD-Core Version:    0.7.0.1
 */