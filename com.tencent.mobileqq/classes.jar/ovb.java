import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ovb
  implements pct
{
  ovb(ouz paramouz, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    QLog.d("multiVideoColumnInfo", 1, "position : " + paramInt);
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.a;
    if ((paramInt >= 0) && (paramInt < paramViewBase.size()) && (paramViewBase.get(paramInt) != null) && (((prj)paramViewBase.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null))
    {
      paramTemplateBean = ((prj)paramViewBase.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo;
      qcn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramTemplateBean);
      ouz.a(this.jdField_a_of_type_Ouz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2, paramTemplateBean.e, ((prj)paramViewBase.get(paramInt)).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovb
 * JD-Core Version:    0.7.0.1
 */