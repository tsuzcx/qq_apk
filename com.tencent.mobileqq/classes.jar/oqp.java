import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class oqp
  implements ViewBase.OnClickListener
{
  oqp(oqd paramoqd, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((!(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) || (this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean == null))
    {
      QLog.d("ProteusSupportUtil", 1, "click exception, return");
      return;
    }
    if ((this.jdField_a_of_type_Oqd.jdField_a_of_type_Rqj.a() == 0) || (otf.c(this.jdField_a_of_type_Oqd.jdField_a_of_type_Rqj.a())))
    {
      oxp.a().a.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getRootView(), this.jdField_a_of_type_Oqd.jdField_a_of_type_Rqj.a(), this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      qhl.a().a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getRootView(), this.jdField_a_of_type_Oqd.jdField_a_of_type_Rqj.a(), this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    int i;
    String str;
    Object localObject;
    boolean bool;
    if (otf.c(this.jdField_a_of_type_Oqd.jdField_a_of_type_Rqj.a()))
    {
      if (ors.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        i = 4;
        opt.a(i);
        QLog.d("ProteusSupportUtil", 2, "click daily card , update operationFlag : " + i);
      }
    }
    else
    {
      str = this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getStyleName();
      localObject = opy.a(null, this.jdField_a_of_type_Oqd.jdField_a_of_type_Int, this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      if (localObject != null) {
        opy.a(((TemplateBean)localObject).findViewById(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getName()));
      }
      bool = false;
      if (!qjz.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        bool = oro.a().a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
      }
      opy.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
      owy.a().a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.invalidateProteusTemplateBean();
      this.jdField_a_of_type_Oqd.jdField_a_of_type_Rqj.notifyDataSetChanged();
      opy.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, (TemplateBean)localObject);
      paramViewBase = opy.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localObject = oro.a().a();
      if (TextUtils.isEmpty(paramViewBase)) {
        break label459;
      }
      if (!qjz.a(paramViewBase)) {
        break label442;
      }
      ors.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramViewBase);
    }
    for (;;)
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager articleInfo hit ug title" + this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
      return;
      i = 2;
      break;
      label442:
      rdm.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase);
    }
    label459:
    if ((!qjz.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      ors.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (String)localObject);
      return;
    }
    if ((!qjz.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!oro.a().a()) && (ors.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, str)))
    {
      ors.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, ors.i(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()));
      return;
    }
    ors.a(this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Oqd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oqp
 * JD-Core Version:    0.7.0.1
 */