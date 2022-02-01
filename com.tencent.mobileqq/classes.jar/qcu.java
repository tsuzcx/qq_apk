import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class qcu
  implements View.OnClickListener
{
  qcu(qco paramqco, pxk parampxk, Container paramContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Pxk.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((rhn)localObject).a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (rho)((rhn)localObject).a.get(0);
      qco.a(this.jdField_a_of_type_Qco, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Pxk.a(), (int)((rho)localObject).a, this.jdField_a_of_type_Pxk.a().innerUniqueID, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Pxk.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcu
 * JD-Core Version:    0.7.0.1
 */