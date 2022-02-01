import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class qpg
  implements View.OnClickListener
{
  qpg(qpa paramqpa, qfw paramqfw, Container paramContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Qfw.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((rrl)localObject).a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (rrm)((rrl)localObject).a.get(0);
      qpa.a(this.jdField_a_of_type_Qpa, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Qfw.a(), (int)((rrm)localObject).a, this.jdField_a_of_type_Qfw.a().innerUniqueID, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Qfw.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpg
 * JD-Core Version:    0.7.0.1
 */