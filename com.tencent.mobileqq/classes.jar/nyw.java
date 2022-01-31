import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class nyw
  implements ViewBase.OnClickListener
{
  nyw(nyv paramnyv) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int j = 101;
    boolean bool2 = false;
    boolean bool1;
    int i;
    if ((nyu.a(this.a.jdField_a_of_type_Nyu) instanceof ProteusItemData))
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
    while (((i == 4) || (i == 3) || (i == 1000) || (i == 8)) && (oai.f((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)))
    {
      oai.b(nyt.a(this.a.jdField_a_of_type_Nyu.a), (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      return;
      rnk.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
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
    nyu.a(this.a.jdField_a_of_type_Nyu, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase);
    nyt.a(this.a.jdField_a_of_type_Nyu.a);
    rmq.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)nyu.a(this.a.jdField_a_of_type_Nyu), bool1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyw
 * JD-Core Version:    0.7.0.1
 */