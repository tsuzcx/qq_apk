import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.common.app.BaseApplicationImpl;

class nqe
  implements View.OnClickListener
{
  nqe(nqd paramnqd) {}
  
  public void onClick(View paramView)
  {
    RIJRedPacketManager.a().a(this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, 5, PublicAccountBrowser.a(this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser), this.a.jdField_a_of_type_JavaLangString, new nqf(this), false, null);
    paramView = new orz();
    orz localorz = paramView.a("rowkey", this.a.jdField_a_of_type_JavaLangString).a("content_type", Integer.valueOf(2));
    if (bdin.h(BaseApplicationImpl.getContext())) {}
    for (int i = 2;; i = 1)
    {
      localorz.a("network_type", Integer.valueOf(i)).a("os", Integer.valueOf(1)).a("imei", ors.f());
      nrt.a("0X800ABBA", paramView.a());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nqe
 * JD-Core Version:    0.7.0.1
 */