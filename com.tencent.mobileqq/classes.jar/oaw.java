import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class oaw
  implements ViewBase.OnClickListener
{
  oaw(oal paramoal, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((!(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) || (this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean == null))
    {
      QLog.d("ProteusSupportUtil", 1, "click exception, return");
      return;
    }
    if ((this.jdField_a_of_type_Oal.jdField_a_of_type_Qoe.a() == 0) || (odm.c(this.jdField_a_of_type_Oal.jdField_a_of_type_Qoe.a())))
    {
      ohp.a().a.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getRootView(), this.jdField_a_of_type_Oal.jdField_a_of_type_Qoe.a(), this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      pmv.a().a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getRootView(), this.jdField_a_of_type_Oal.jdField_a_of_type_Qoe.a(), this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    String str = this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getStyleName();
    Object localObject = oag.a(null, this.jdField_a_of_type_Oal.jdField_a_of_type_Int, this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if (localObject != null) {
      oag.a(((TemplateBean)localObject).findViewById(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getName()));
    }
    boolean bool = false;
    if (!pol.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      bool = obv.a().a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
    }
    oag.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
    ogy.a().a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.invalidateProteusTemplateBean();
    this.jdField_a_of_type_Oal.jdField_a_of_type_Qoe.notifyDataSetChanged();
    oag.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, (TemplateBean)localObject);
    paramViewBase = oag.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    localObject = obv.a().a();
    if (!TextUtils.isEmpty(paramViewBase))
    {
      if (pol.a(paramViewBase)) {
        obz.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramViewBase);
      }
      for (;;)
      {
        QLog.d("ProteusSupportUtil", 1, "UGRuleManager articleInfo hit ug title" + this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
        return;
        qcn.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase);
      }
    }
    if ((!pol.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      obz.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (String)localObject);
      return;
    }
    if ((!pol.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!obv.a().a()) && (obz.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, str)))
    {
      obz.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, obz.i(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()));
      return;
    }
    obz.a(this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oal.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oaw
 * JD-Core Version:    0.7.0.1
 */