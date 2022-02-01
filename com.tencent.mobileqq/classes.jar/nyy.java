import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.widget.FadeIconImageView;

public class nyy
  implements qzb
{
  public nyy(PublicAccountBrowser paramPublicAccountBrowser, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.findViewById(2131376066);
      if (localViewStub != null)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.findViewById(2131376740);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
        int i = zby.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, 116.0F);
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localRelativeLayout.setLayoutParams(localLayoutParams);
        PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, (RIJRedPacketProgressView)localViewStub.inflate());
        PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setVisibility(0);
        PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setOnClickListener(new nyz(this));
      }
      if (PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser) != null)
      {
        PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).a();
        PublicAccountBrowser.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, this.jdField_a_of_type_JavaLangString);
        PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.a) {
          break label284;
        }
        if ((PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser) != null) && (PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).getVisibility() == 0)) {
          break label247;
        }
        PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setImageResource(2130849435);
        PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setVisibility(0);
        PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setVisibility(8);
      }
    }
    for (;;)
    {
      PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).a(2, PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser), this.jdField_a_of_type_JavaLangString);
      return;
      label247:
      PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setImageResource(2130849520);
      PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setVisibility(0);
      PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setVisibility(0);
      continue;
      label284:
      PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setVisibility(8);
      PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyy
 * JD-Core Version:    0.7.0.1
 */