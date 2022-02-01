import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class qmn
  implements ViewBase.OnClickListener
{
  qmn(qmj paramqmj) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.a.jdField_a_of_type_Qmi.a != null) && (this.a.jdField_a_of_type_Qmi.a.a() != null)) {
      pfr.a(this.a.jdField_a_of_type_Qmi.a.a(), this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    }
    pfr.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if ((qmi.a(this.a.jdField_a_of_type_Qmi) != null) && (this.a.jdField_a_of_type_Int < qmi.a(this.a.jdField_a_of_type_Qmi).size()))
    {
      pha.a(qmi.a(this.a.jdField_a_of_type_Qmi).getContext(), (BaseArticleInfo)qmi.a(this.a.jdField_a_of_type_Qmi).get(this.a.jdField_a_of_type_Int), paramViewBase.getEventAttachedData());
      return;
    }
    pha.a(qmi.a(this.a.jdField_a_of_type_Qmi).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmn
 * JD-Core Version:    0.7.0.1
 */