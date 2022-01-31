import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class pml
  implements puq
{
  pml(pmj parampmj, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    QLog.d("multiVideoColumnInfo", 1, "position : " + paramInt);
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.a;
    if ((paramInt >= 0) && (paramInt < paramViewBase.size()) && (paramViewBase.get(paramInt) != null) && (((qnb)paramViewBase.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null))
    {
      paramTemplateBean = ((qnb)paramViewBase.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo;
      rdm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramTemplateBean);
      pmj.a(this.jdField_a_of_type_Pmj, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2, paramTemplateBean.e, ((qnb)paramViewBase.get(paramInt)).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pml
 * JD-Core Version:    0.7.0.1
 */