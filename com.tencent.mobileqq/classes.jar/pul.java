import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class pul
  implements ViewBase.OnClickListener
{
  pul(puh parampuh) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.a.jdField_a_of_type_Pug.a != null) && (this.a.jdField_a_of_type_Pug.a.a() != null)) {
      opy.a(this.a.jdField_a_of_type_Pug.a.a(), this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    }
    opy.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if ((pug.a(this.a.jdField_a_of_type_Pug) != null) && (this.a.jdField_a_of_type_Int < pug.a(this.a.jdField_a_of_type_Pug).size()))
    {
      ors.a(pug.a(this.a.jdField_a_of_type_Pug).getContext(), (BaseArticleInfo)pug.a(this.a.jdField_a_of_type_Pug).get(this.a.jdField_a_of_type_Int), paramViewBase.getEventAttachedData());
      return;
    }
    ors.a(pug.a(this.a.jdField_a_of_type_Pug).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pul
 * JD-Core Version:    0.7.0.1
 */