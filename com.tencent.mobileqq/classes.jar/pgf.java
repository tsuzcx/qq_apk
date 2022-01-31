import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;

class pgf
  implements poi
{
  pgf(pgd parampgd, ArticleInfo paramArticleInfo, pau parampau) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    QLog.d("NewPolymericMultiVideoProteusItem", 1, "position : " + paramInt);
    pgd.a(this.jdField_a_of_type_Pgd, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
    this.jdField_a_of_type_Pau.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramViewBase.getNativeView(), paramInt, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgf
 * JD-Core Version:    0.7.0.1
 */