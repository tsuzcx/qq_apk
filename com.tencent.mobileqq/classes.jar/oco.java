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

class oco
  implements ViewBase.OnClickListener
{
  oco(ocn paramocn) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool1;
    int i;
    if ((ocm.a(this.a.jdField_a_of_type_Ocm) instanceof ProteusItemData)) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        bool1 = true;
        i = -1;
        if (odv.f((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
          odv.b(ocl.a(this.a.jdField_a_of_type_Ocm.a), (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
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
          sdj.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
        } while (!ocl.b);
        ocl.c = true;
      } while (ocm.a(this.a.jdField_a_of_type_Ocm) == null);
      ocm.a(this.a.jdField_a_of_type_Ocm).p();
      ocm.a(this.a.jdField_a_of_type_Ocm).o();
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
      paramViewBase = oef.a((ProteusBannerVideoItemData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      if (!szl.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase)) {
        break label304;
      }
    } while (ocm.a(this.a.jdField_a_of_type_Ocm) == null);
    ocm.a(this.a.jdField_a_of_type_Ocm).p();
    return;
    label304:
    if (ocm.a(this.a.jdField_a_of_type_Ocm) != null) {}
    for (boolean bool2 = ocm.a(this.a.jdField_a_of_type_Ocm).a();; bool2 = false)
    {
      paramViewBase.setClickPos(i);
      Object localObject = new obg(bool2);
      if (i == 8) {
        ((obg)localObject).c = true;
      }
      localObject = szl.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, null, 2, bool1, (obg)localObject);
      if (localObject == null) {
        break;
      }
      ((GdtHandler.Params)localObject).f = oed.b((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      szl.a((GdtHandler.Params)localObject, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase);
      ocl.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject;
      if (ocl.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
      for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
      {
        ocl.jdField_a_of_type_Long = l;
        oef.a((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
        if (ocm.a(this.a.jdField_a_of_type_Ocm) == null) {
          break;
        }
        ocm.a(this.a.jdField_a_of_type_Ocm).p();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oco
 * JD-Core Version:    0.7.0.1
 */