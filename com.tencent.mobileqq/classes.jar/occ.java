import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class occ
  implements ViewBase.OnClickListener
{
  occ(ocb paramocb, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int k = 1;
    int m;
    int i;
    int j;
    if ((oca.a(this.jdField_a_of_type_Ocb.jdField_a_of_type_Oca) instanceof ProteusItemData))
    {
      m = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      switch (m)
      {
      default: 
        i = 0;
        j = -1;
      }
    }
    for (;;)
    {
      if (odv.g((AdData)this.jdField_a_of_type_Ocb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
        if (m != 1087) {
          break label469;
        }
      }
      label469:
      for (i = k;; i = 0)
      {
        j = odp.a(((AdData)this.jdField_a_of_type_Ocb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).k, false);
        paramViewBase = oef.a((AdData)this.jdField_a_of_type_Ocb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
        odp.a((Activity)this.jdField_a_of_type_Ocb.jdField_a_of_type_AndroidContentContext, paramViewBase);
        odp.a(this.jdField_a_of_type_Ocb.jdField_a_of_type_AndroidContentContext, (AdData)this.jdField_a_of_type_Ocb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, noy.a, i, j, 2);
        do
        {
          return;
          if (this.jdField_a_of_type_Ocb.jdField_a_of_type_AndroidContentContext == null) {
            break label482;
          }
          sdj.a(this.jdField_a_of_type_Ocb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.jdField_a_of_type_Ocb.jdField_a_of_type_AndroidContentContext);
          j = 8;
          i = 0;
          break;
          i = 1;
          j = 5;
          break;
          i = 1;
          j = 4;
          break;
          if (odv.f((AdData)this.jdField_a_of_type_Ocb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData))
          {
            odv.a(this.jdField_a_of_type_Ocb.jdField_a_of_type_AndroidContentContext, (AdData)this.jdField_a_of_type_Ocb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, 8);
            return;
          }
          j = 8;
          i = 1;
          break;
          i = 1;
          j = 1;
          break;
          i = 1;
          j = 3;
          break;
          i = 1;
          j = 1000;
          break;
          paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.findViewBaseByName("id_view_AdDownloadView");
          if (!(paramViewBase instanceof ogy)) {
            break label474;
          }
          i = odp.a(paramViewBase, this.jdField_a_of_type_Ocb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
          ((ogy)paramViewBase).h();
          odp.a(this.jdField_a_of_type_Ocb.jdField_a_of_type_AndroidContentContext, (AdData)this.jdField_a_of_type_Ocb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, noy.a, 1, i, 2);
          return;
        } while ((i == 0) || (m == -1));
        oca.a(this.jdField_a_of_type_Ocb.jdField_a_of_type_Oca, this.jdField_a_of_type_Ocb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase);
        obz.a(this.jdField_a_of_type_Ocb.jdField_a_of_type_Oca.a);
        scp.a(this.jdField_a_of_type_Ocb.jdField_a_of_type_AndroidContentContext, (AdData)oca.a(this.jdField_a_of_type_Ocb.jdField_a_of_type_Oca), true, j);
        return;
      }
      label474:
      j = 8;
      i = 1;
      continue;
      label482:
      j = 8;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     occ
 * JD-Core Version:    0.7.0.1
 */