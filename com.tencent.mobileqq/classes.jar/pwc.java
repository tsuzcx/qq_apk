import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pwc
  implements ViewBase.OnClickListener
{
  pwc(pwa parampwa, ppu paramppu, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    EventCollector.getInstance().onViewClicked(paramViewBase.getNativeView());
    TemplateBean localTemplateBean = this.jdField_a_of_type_Ppu.a().mProteusTemplateBean;
    if (localTemplateBean != null)
    {
      paramViewBase = pwa.a(this.jdField_a_of_type_Pwa, localTemplateBean, paramViewBase);
      if (tqa.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        tqa.a((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Ppu.a().getContext(), this.jdField_a_of_type_Ppu.h());
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Ppu.a().a(false, (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (ArticleInfo)this.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwc
 * JD-Core Version:    0.7.0.1
 */