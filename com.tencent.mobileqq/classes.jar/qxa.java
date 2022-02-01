import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class qxa
  implements ViewBase.OnClickListener
{
  qxa(qwy paramqwy) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    piv.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if ((qwx.a(this.a.jdField_a_of_type_Qwx) != null) && (this.a.jdField_a_of_type_Int < qwx.a(this.a.jdField_a_of_type_Qwx).size()))
    {
      pqx.a(qwx.a(this.a.jdField_a_of_type_Qwx).getContext(), (BaseArticleInfo)qwx.a(this.a.jdField_a_of_type_Qwx).get(this.a.jdField_a_of_type_Int), paramViewBase.getEventAttachedData());
      return;
    }
    pkh.a(qwx.a(this.a.jdField_a_of_type_Qwx).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxa
 * JD-Core Version:    0.7.0.1
 */