import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class pog
  implements ViewBase.OnClickListener
{
  pog(poc parampoc) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.a.jdField_a_of_type_Pob.a != null) && (this.a.jdField_a_of_type_Pob.a.a() != null)) {
      olr.a(this.a.jdField_a_of_type_Pob.a.a(), this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    }
    olr.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if ((pob.a(this.a.jdField_a_of_type_Pob) != null) && (this.a.jdField_a_of_type_Int < pob.a(this.a.jdField_a_of_type_Pob).size()))
    {
      onk.a(pob.a(this.a.jdField_a_of_type_Pob).getContext(), (BaseArticleInfo)pob.a(this.a.jdField_a_of_type_Pob).get(this.a.jdField_a_of_type_Int), paramViewBase.getEventAttachedData());
      return;
    }
    onk.a(pob.a(this.a.jdField_a_of_type_Pob).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pog
 * JD-Core Version:    0.7.0.1
 */