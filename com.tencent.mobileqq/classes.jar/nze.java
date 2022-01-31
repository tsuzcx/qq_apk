import android.app.Activity;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.gdtad.aditem.GdtHandler.Params;

class nze
  implements ViewBase.OnClickListener
{
  nze(nzd paramnzd) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool1;
    int i;
    if ((nzc.a(this.a.jdField_a_of_type_Nzc) instanceof ProteusItemData)) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        bool1 = true;
        i = -1;
        if (oai.f((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
          oai.b(nzb.a(this.a.jdField_a_of_type_Nzc.a), (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
        }
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          rnk.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
        } while (!nzb.b);
        nzb.c = true;
      } while (nzc.a(this.a.jdField_a_of_type_Nzc) == null);
      nzc.a(this.a.jdField_a_of_type_Nzc).p();
      nzc.a(this.a.jdField_a_of_type_Nzc).o();
      return;
      bool1 = true;
      i = 4;
      break;
      bool1 = true;
      i = 3;
      break;
      bool1 = false;
      i = 5;
      break;
      bool1 = true;
      i = 8;
      break;
      bool1 = true;
      i = 1000;
      break;
      paramViewBase = oas.a((ProteusBannerVideoItemData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      if (!shq.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase)) {
        break label304;
      }
    } while (nzc.a(this.a.jdField_a_of_type_Nzc) == null);
    nzc.a(this.a.jdField_a_of_type_Nzc).p();
    return;
    label304:
    if (nzc.a(this.a.jdField_a_of_type_Nzc) != null) {}
    for (boolean bool2 = nzc.a(this.a.jdField_a_of_type_Nzc).a();; bool2 = false)
    {
      paramViewBase.setClickPos(i);
      Object localObject = new nxz(bool2);
      if (i == 8) {
        ((nxz)localObject).c = true;
      }
      localObject = shq.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, null, 2, bool1, (nxz)localObject);
      if (localObject == null) {
        break;
      }
      ((GdtHandler.Params)localObject).f = oaq.b((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      shq.a((GdtHandler.Params)localObject, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase);
      nzb.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject;
      if (nzb.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
      for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
      {
        nzb.jdField_a_of_type_Long = l;
        oas.a((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
        if (nzc.a(this.a.jdField_a_of_type_Nzc) == null) {
          break;
        }
        nzc.a(this.a.jdField_a_of_type_Nzc).p();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nze
 * JD-Core Version:    0.7.0.1
 */