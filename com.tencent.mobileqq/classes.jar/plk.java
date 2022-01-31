import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import java.util.ArrayList;

class plk
  implements View.OnClickListener
{
  plk(ple parample, pgd parampgd, Container paramContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.a;
    ArrayList localArrayList = paramView.a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    paramView = (qms)paramView.a.get(0);
    ple.a(this.jdField_a_of_type_Ple, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Pgd.a(), (int)paramView.a, this.jdField_a_of_type_Pgd.a().innerUniqueID, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Pgd.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     plk
 * JD-Core Version:    0.7.0.1
 */