import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class nzd
  implements ViewBase.OnClickListener
{
  nzd(nzc paramnzc) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i;
    boolean bool;
    if ((nzb.a(this.a.jdField_a_of_type_Nzb) instanceof ProteusItemData)) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        i = -1;
        bool = true;
      }
    }
    while (((i == 4) || (i == 3) || (i == 1000) || (i == 8)) && (oal.f((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)))
    {
      oal.b(nza.a(this.a.jdField_a_of_type_Nzb.a), (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      return;
      rnn.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
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
    nzb.a(this.a.jdField_a_of_type_Nzb, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase);
    rmt.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)nzb.a(this.a.jdField_a_of_type_Nzb), bool, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzd
 * JD-Core Version:    0.7.0.1
 */