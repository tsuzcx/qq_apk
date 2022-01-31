import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class poc
  implements ViewBase.OnClickListener
{
  poc(pnz parampnz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    olo.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if ((pny.a(this.a.jdField_a_of_type_Pny) != null) && (this.a.jdField_a_of_type_Int < pny.a(this.a.jdField_a_of_type_Pny).size()))
    {
      onh.a(pny.a(this.a.jdField_a_of_type_Pny).getContext(), (BaseArticleInfo)pny.a(this.a.jdField_a_of_type_Pny).get(this.a.jdField_a_of_type_Int), paramViewBase.getEventAttachedData());
      return;
    }
    onh.a(pny.a(this.a.jdField_a_of_type_Pny).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     poc
 * JD-Core Version:    0.7.0.1
 */