import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class pwr
  implements ViewBase.OnClickListener
{
  pwr(pwn parampwn, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.b;
    if (paramViewBase != null)
    {
      rpt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
      pwn.a(this.jdField_a_of_type_Pwn, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 3, paramViewBase.e, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwr
 * JD-Core Version:    0.7.0.1
 */