import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pur
  implements ViewBase.OnClickListener
{
  pur(puq parampuq, ppu paramppu, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_Ppu.a();
    String str = paramViewBase.mSocialFeedInfo.a.f;
    ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, null);
    sel.a(paramViewBase, (int)paramViewBase.mChannelID);
    ubg.a(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pur
 * JD-Core Version:    0.7.0.1
 */