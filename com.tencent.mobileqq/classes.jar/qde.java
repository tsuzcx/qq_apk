import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class qde
  implements View.OnClickListener
{
  qde(qcy paramqcy, pvc parampvc, Container paramContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((rfe)localObject).a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (rff)((rfe)localObject).a.get(0);
      qcy.a(this.jdField_a_of_type_Qcy, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Pvc.a(), (int)((rff)localObject).a, this.jdField_a_of_type_Pvc.a().innerUniqueID, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Pvc.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qde
 * JD-Core Version:    0.7.0.1
 */