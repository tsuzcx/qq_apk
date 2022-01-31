import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;

class nqc
  implements View.OnClickListener
{
  nqc(nqb paramnqb) {}
  
  public void onClick(View paramView)
  {
    RIJRedPacketManager.a().a(paramView.getContext(), 2, 0, 0);
    PublicAccountBrowser.a(this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).b(2, PublicAccountBrowser.a(this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser), this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nqc
 * JD-Core Version:    0.7.0.1
 */