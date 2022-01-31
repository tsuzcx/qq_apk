import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ome
  implements ViewBase.OnClickListener
{
  ome(olt paramolt, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((!(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) || (this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean == null))
    {
      QLog.d("ProteusSupportUtil", 1, "click exception, return");
      return;
    }
    if ((this.jdField_a_of_type_Olt.jdField_a_of_type_Ram.a() == 0) || (oou.c(this.jdField_a_of_type_Olt.jdField_a_of_type_Ram.a())))
    {
      osx.a().a.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getRootView(), this.jdField_a_of_type_Olt.jdField_a_of_type_Ram.a(), this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      pyn.a().a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getRootView(), this.jdField_a_of_type_Olt.jdField_a_of_type_Ram.a(), this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    String str = this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getStyleName();
    Object localObject = olo.a(null, this.jdField_a_of_type_Olt.jdField_a_of_type_Int, this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if (localObject != null) {
      olo.a(((TemplateBean)localObject).findViewById(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getName()));
    }
    boolean bool = false;
    if (!qae.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      bool = ond.a().a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
    }
    olo.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
    osg.a().a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.invalidateProteusTemplateBean();
    this.jdField_a_of_type_Olt.jdField_a_of_type_Ram.notifyDataSetChanged();
    olo.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, (TemplateBean)localObject);
    paramViewBase = olo.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    localObject = ond.a().a();
    if (!TextUtils.isEmpty(paramViewBase))
    {
      if (qae.a(paramViewBase)) {
        onh.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramViewBase);
      }
      for (;;)
      {
        QLog.d("ProteusSupportUtil", 1, "UGRuleManager articleInfo hit ug title" + this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
        return;
        qoi.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase);
      }
    }
    if ((!qae.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      onh.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (String)localObject);
      return;
    }
    if ((!qae.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!ond.a().a()) && (onh.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, str)))
    {
      onh.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, onh.i(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()));
      return;
    }
    onh.a(this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Olt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ome
 * JD-Core Version:    0.7.0.1
 */