import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class pcn
  implements ViewBase.OnClickListener
{
  pcn(pck parampck) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    oag.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if ((pcj.a(this.a.jdField_a_of_type_Pcj) != null) && (this.a.jdField_a_of_type_Int < pcj.a(this.a.jdField_a_of_type_Pcj).size()))
    {
      obz.a(pcj.a(this.a.jdField_a_of_type_Pcj).getContext(), (BaseArticleInfo)pcj.a(this.a.jdField_a_of_type_Pcj).get(this.a.jdField_a_of_type_Int), paramViewBase.getEventAttachedData());
      return;
    }
    obz.a(pcj.a(this.a.jdField_a_of_type_Pcj).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcn
 * JD-Core Version:    0.7.0.1
 */