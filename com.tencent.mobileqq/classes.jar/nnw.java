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

class nnw
  implements ViewBase.OnClickListener
{
  nnw(nnv paramnnv) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool1;
    int i;
    if ((nnu.a(this.a.jdField_a_of_type_Nnu) instanceof ProteusItemData)) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        bool1 = true;
        i = -1;
        if (npa.f((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
          npa.b(nnt.a(this.a.jdField_a_of_type_Nnu.a), (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
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
          rav.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
        } while (!nnt.b);
        nnt.c = true;
      } while (nnu.a(this.a.jdField_a_of_type_Nnu) == null);
      nnu.a(this.a.jdField_a_of_type_Nnu).p();
      nnu.a(this.a.jdField_a_of_type_Nnu).o();
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
      paramViewBase = npk.a((ProteusBannerVideoItemData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      if (!rvb.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase)) {
        break label304;
      }
    } while (nnu.a(this.a.jdField_a_of_type_Nnu) == null);
    nnu.a(this.a.jdField_a_of_type_Nnu).p();
    return;
    label304:
    if (nnu.a(this.a.jdField_a_of_type_Nnu) != null) {}
    for (boolean bool2 = nnu.a(this.a.jdField_a_of_type_Nnu).a();; bool2 = false)
    {
      paramViewBase.setClickPos(i);
      Object localObject = new nmr(bool2);
      if (i == 8) {
        ((nmr)localObject).c = true;
      }
      localObject = rvb.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, null, 2, bool1, (nmr)localObject);
      if (localObject == null) {
        break;
      }
      ((yjs)localObject).f = npi.b((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      rvb.a((yjs)localObject, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase);
      nnt.jdField_a_of_type_Yjs = (yjs)localObject;
      if (nnt.jdField_a_of_type_Yjs != null) {}
      for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
      {
        nnt.jdField_a_of_type_Long = l;
        npk.a((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
        if (nnu.a(this.a.jdField_a_of_type_Nnu) == null) {
          break;
        }
        nnu.a(this.a.jdField_a_of_type_Nnu).p();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnw
 * JD-Core Version:    0.7.0.1
 */