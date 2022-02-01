import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class qkv
  implements ViewBase.OnClickListener
{
  qkv(qkt paramqkt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ozp.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if ((qks.a(this.a.jdField_a_of_type_Qks) != null) && (this.a.jdField_a_of_type_Int < qks.a(this.a.jdField_a_of_type_Qks).size()))
    {
      pay.a(qks.a(this.a.jdField_a_of_type_Qks).getContext(), (BaseArticleInfo)qks.a(this.a.jdField_a_of_type_Qks).get(this.a.jdField_a_of_type_Int), paramViewBase.getEventAttachedData());
      return;
    }
    pay.a(qks.a(this.a.jdField_a_of_type_Qks).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qkv
 * JD-Core Version:    0.7.0.1
 */