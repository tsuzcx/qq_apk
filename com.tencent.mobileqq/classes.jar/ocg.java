import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class ocg
  implements ViewBase.OnClickListener
{
  ocg(ocf paramocf) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int j = 101;
    boolean bool2 = false;
    boolean bool1;
    int i;
    if ((oce.a(this.a.jdField_a_of_type_Oce) instanceof ProteusItemData))
    {
      bool1 = bool2;
      i = j;
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        bool1 = true;
        i = -1;
      }
    }
    while (((i == 4) || (i == 3) || (i == 1000) || (i == 8)) && (odv.f((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)))
    {
      odv.b(ocd.a(this.a.jdField_a_of_type_Oce.a), (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      return;
      sdj.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
      return;
      bool1 = true;
      i = 4;
      continue;
      bool1 = true;
      i = 3;
      continue;
      i = 5;
      bool1 = bool2;
      continue;
      bool1 = true;
      i = 8;
      continue;
      i = 1000;
      bool1 = true;
      continue;
      i = 102;
      bool1 = bool2;
      continue;
      i = 4;
      bool1 = bool2;
      continue;
      i = 3;
      bool1 = bool2;
      continue;
      bool1 = true;
      i = j;
      continue;
      i = 102;
      bool1 = true;
    }
    oce.a(this.a.jdField_a_of_type_Oce, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase);
    ocd.a(this.a.jdField_a_of_type_Oce.a);
    scp.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)oce.a(this.a.jdField_a_of_type_Oce), bool1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ocg
 * JD-Core Version:    0.7.0.1
 */