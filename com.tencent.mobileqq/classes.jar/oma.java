import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class oma
  implements ViewBase.OnClickListener
{
  oma(olt paramolt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo != null))
    {
      paramViewBase = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.d;
      onh.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oma
 * JD-Core Version:    0.7.0.1
 */