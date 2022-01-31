import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class nns
  implements ViewBase.OnClickListener
{
  nns(nnr paramnnr) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i;
    boolean bool;
    if ((nnq.a(this.a.jdField_a_of_type_Nnq) instanceof ProteusItemData)) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        i = -1;
        bool = true;
      }
    }
    while (((i == 4) || (i == 3) || (i == 1000) || (i == 8)) && (npa.f((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)))
    {
      npa.b(nnp.a(this.a.jdField_a_of_type_Nnq.a), (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      return;
      rav.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
      return;
      bool = true;
      i = 4;
      continue;
      bool = true;
      i = 3;
      continue;
      i = 5;
      bool = false;
      continue;
      bool = true;
      i = 8;
      continue;
      bool = true;
      i = 1000;
    }
    nnq.a(this.a.jdField_a_of_type_Nnq, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase);
    rab.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)nnq.a(this.a.jdField_a_of_type_Nnq), bool, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nns
 * JD-Core Version:    0.7.0.1
 */