import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.ArrayList;

class ovw
  implements View.OnClickListener
{
  ovw(ovq paramovq, opw paramopw, Container paramContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Opw.a().mSocialFeedInfo.a;
    ArrayList localArrayList = paramView.a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    paramView = (pra)paramView.a.get(0);
    ovq.a(this.jdField_a_of_type_Ovq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Opw.a(), (int)paramView.a, this.jdField_a_of_type_Opw.a().innerUniqueID, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Opw.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovw
 * JD-Core Version:    0.7.0.1
 */