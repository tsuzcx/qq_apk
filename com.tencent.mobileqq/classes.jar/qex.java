import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class qex
  implements ViewBase.OnClickListener
{
  qex(qev paramqev) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    oyj.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if ((qeu.a(this.a.jdField_a_of_type_Qeu) != null) && (this.a.jdField_a_of_type_Int < qeu.a(this.a.jdField_a_of_type_Qeu).size()))
    {
      ozs.a(qeu.a(this.a.jdField_a_of_type_Qeu).getContext(), (BaseArticleInfo)qeu.a(this.a.jdField_a_of_type_Qeu).get(this.a.jdField_a_of_type_Int), paramViewBase.getEventAttachedData());
      return;
    }
    ozs.a(qeu.a(this.a.jdField_a_of_type_Qeu).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qex
 * JD-Core Version:    0.7.0.1
 */