import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class szx
  implements ViewBase.OnClickListener
{
  szx(szw paramszw) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    szv.a(this.a.jdField_a_of_type_Szv, i).a(paramViewBase, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szx
 * JD-Core Version:    0.7.0.1
 */