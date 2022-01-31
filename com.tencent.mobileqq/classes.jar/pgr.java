import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class pgr
  implements pol
{
  pgr(pgp parampgp, List paramList, ArticleInfo paramArticleInfo, pax parampax) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      QLog.i("PackProteusItem", 1, "[onItemClick] position overflow, position = " + paramInt + ", size = " + this.jdField_a_of_type_JavaUtilList.size());
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
      paramTemplateBean = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      this.jdField_a_of_type_Pax.a().a().a(paramTemplateBean, paramViewBase.getNativeView(), paramInt, paramInt);
      return;
    }
    catch (Exception paramViewBase)
    {
      QLog.e("PackProteusItem", 1, "[onItemClick], e = " + paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgr
 * JD-Core Version:    0.7.0.1
 */