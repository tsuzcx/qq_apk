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

class nzh
  implements ViewBase.OnClickListener
{
  nzh(nzg paramnzg) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool1;
    int i;
    if ((nzf.a(this.a.jdField_a_of_type_Nzf) instanceof ProteusItemData)) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        bool1 = true;
        i = -1;
        if (oal.f((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
          oal.b(nze.a(this.a.jdField_a_of_type_Nzf.a), (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
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
          rnn.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
        } while (!nze.b);
        nze.c = true;
      } while (nzf.a(this.a.jdField_a_of_type_Nzf) == null);
      nzf.a(this.a.jdField_a_of_type_Nzf).p();
      nzf.a(this.a.jdField_a_of_type_Nzf).o();
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
      paramViewBase = oav.a((ProteusBannerVideoItemData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      if (!sht.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase)) {
        break label304;
      }
    } while (nzf.a(this.a.jdField_a_of_type_Nzf) == null);
    nzf.a(this.a.jdField_a_of_type_Nzf).p();
    return;
    label304:
    if (nzf.a(this.a.jdField_a_of_type_Nzf) != null) {}
    for (boolean bool2 = nzf.a(this.a.jdField_a_of_type_Nzf).a();; bool2 = false)
    {
      paramViewBase.setClickPos(i);
      Object localObject = new nyc(bool2);
      if (i == 8) {
        ((nyc)localObject).c = true;
      }
      localObject = sht.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, null, 2, bool1, (nyc)localObject);
      if (localObject == null) {
        break;
      }
      ((GdtHandler.Params)localObject).f = oat.b((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      sht.a((GdtHandler.Params)localObject, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase);
      nze.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject;
      if (nze.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
      for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
      {
        nze.jdField_a_of_type_Long = l;
        oav.a((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
        if (nzf.a(this.a.jdField_a_of_type_Nzf) == null) {
          break;
        }
        nzf.a(this.a.jdField_a_of_type_Nzf).p();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzh
 * JD-Core Version:    0.7.0.1
 */