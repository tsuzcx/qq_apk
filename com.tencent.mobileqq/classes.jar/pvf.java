import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class pvf
  implements View.OnClickListener
{
  pvf(puz parampuz, ppu paramppu, Container paramContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.a;
    ArrayList localArrayList = ((qyg)localObject).a;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (qyh)((qyg)localObject).a.get(0);
      puz.a(this.jdField_a_of_type_Puz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_Ppu.a(), (int)((qyh)localObject).a, this.jdField_a_of_type_Ppu.a().innerUniqueID, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Ppu.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvf
 * JD-Core Version:    0.7.0.1
 */