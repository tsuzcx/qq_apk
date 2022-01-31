import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;

public class nqd
  implements qfo
{
  public nqd(PublicAccountBrowser paramPublicAccountBrowser, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.findViewById(2131363457);
      if (PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser) == null)
      {
        PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, new RIJRedPacketPopupView(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localRelativeLayout.addView(PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser), localLayoutParams);
      }
      int i = xin.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, 16.0F);
      int j = localRelativeLayout.getHeight();
      int k = xin.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, 78.0F);
      PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser), i, j - k - i, false, false, paramString, 2147483647);
      PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, true);
      PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, paramInt);
      PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setOnClickListener(new nqe(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nqd
 * JD-Core Version:    0.7.0.1
 */