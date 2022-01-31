import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class oqh
  implements ViewBase.OnClickListener
{
  oqh(oqd paramoqd) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((!(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) || (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean == null))
    {
      QLog.d("ProteusSupportUtil", 1, "STR_ID_CMD_PARTNER_HEADER_CLICK,click exception, return");
      return;
    }
    TemplateBean localTemplateBean = opy.a(null, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if (localTemplateBean != null) {
      opy.a(localTemplateBean.findViewById(paramViewBase.getName()));
    }
    opy.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, localTemplateBean, paramViewBase);
    ors.d(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oqh
 * JD-Core Version:    0.7.0.1
 */