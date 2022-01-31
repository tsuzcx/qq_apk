import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class omh
  implements ViewBase.OnClickListener
{
  omh(olw paramolw, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((!(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) || (this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean == null))
    {
      QLog.d("ProteusSupportUtil", 1, "click exception, return");
      return;
    }
    if ((this.jdField_a_of_type_Olw.jdField_a_of_type_Rap.a() == 0) || (oox.c(this.jdField_a_of_type_Olw.jdField_a_of_type_Rap.a())))
    {
      ota.a().a.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getRootView(), this.jdField_a_of_type_Olw.jdField_a_of_type_Rap.a(), this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      pyq.a().a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getRootView(), this.jdField_a_of_type_Olw.jdField_a_of_type_Rap.a(), this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    String str = this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getStyleName();
    Object localObject = olr.a(null, this.jdField_a_of_type_Olw.jdField_a_of_type_Int, this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if (localObject != null) {
      olr.a(((TemplateBean)localObject).findViewById(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getName()));
    }
    boolean bool = false;
    if (!qah.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      bool = ong.a().a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
    }
    olr.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
    osj.a().a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.invalidateProteusTemplateBean();
    this.jdField_a_of_type_Olw.jdField_a_of_type_Rap.notifyDataSetChanged();
    olr.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, (TemplateBean)localObject);
    paramViewBase = olr.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    localObject = ong.a().a();
    if (!TextUtils.isEmpty(paramViewBase))
    {
      if (qah.a(paramViewBase)) {
        onk.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramViewBase);
      }
      for (;;)
      {
        QLog.d("ProteusSupportUtil", 1, "UGRuleManager articleInfo hit ug title" + this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
        return;
        qol.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase);
      }
    }
    if ((!qah.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      onk.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (String)localObject);
      return;
    }
    if ((!qah.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!ong.a().a()) && (onk.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, str)))
    {
      onk.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, onk.i(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()));
      return;
    }
    onk.a(this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     omh
 * JD-Core Version:    0.7.0.1
 */