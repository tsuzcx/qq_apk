import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nzb
  implements View.OnClickListener
{
  nzb(nza paramnza) {}
  
  public void onClick(View paramView)
  {
    RIJRedPacketManager.a().a(this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, 5, PublicAccountBrowser.a(this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser), this.a.jdField_a_of_type_JavaLangString, new nzc(this), false, null);
    phi localphi1 = new phi();
    phi localphi2 = localphi1.a("rowkey", this.a.jdField_a_of_type_JavaLangString).a("content_type", Integer.valueOf(2));
    if (bgnt.h(BaseApplicationImpl.getContext())) {}
    for (int i = 2;; i = 1)
    {
      localphi2.a("network_type", Integer.valueOf(i)).a("os", Integer.valueOf(1)).a("imei", pha.h());
      oat.a("0X800ABBA", localphi1.a());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzb
 * JD-Core Version:    0.7.0.1
 */