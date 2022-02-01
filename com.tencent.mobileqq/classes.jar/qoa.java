import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qoa
  implements ViewBase.OnClickListener
{
  qoa(qnw paramqnw, qfw paramqfw, int paramInt, BaseArticleInfo paramBaseArticleInfo, ArticleInfo paramArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    EventCollector.getInstance().onViewClicked(paramViewBase.getNativeView());
    TemplateBean localTemplateBean2 = this.jdField_a_of_type_Qfw.a().mProteusTemplateBean;
    TemplateBean localTemplateBean1 = localTemplateBean2;
    if (localTemplateBean2 == null) {
      localTemplateBean1 = piv.a(this.jdField_a_of_type_Qfw.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Qfw.a());
    }
    if (localTemplateBean1 != null)
    {
      paramViewBase = qnw.a(this.jdField_a_of_type_Qnw, localTemplateBean1, paramViewBase);
      if (uks.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        uks.a((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Qfw.a().getContext(), this.jdField_a_of_type_Qfw.g());
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Qfw.a().a(false, (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qoa
 * JD-Core Version:    0.7.0.1
 */