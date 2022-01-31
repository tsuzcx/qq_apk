import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.ArrayList;

class pfh
  implements View.OnClickListener
{
  pfh(pfb parampfb, pau parampau, Container paramContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Pau.a().mSocialFeedInfo.a;
    ArrayList localArrayList = paramView.a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    paramView = (qcw)paramView.a.get(0);
    pfb.a(this.jdField_a_of_type_Pfb, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Pau.a(), (int)paramView.a, this.jdField_a_of_type_Pau.a().innerUniqueID, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Pau.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfh
 * JD-Core Version:    0.7.0.1
 */