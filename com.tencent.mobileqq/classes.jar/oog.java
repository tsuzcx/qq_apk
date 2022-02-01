import android.app.Activity;
import android.content.Context;
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
import java.lang.ref.WeakReference;

class oog
  implements ViewBase.OnClickListener
{
  oog(oof paramoof) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool1;
    int i;
    if ((this.a.jdField_a_of_type_Ooe.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof ProteusItemData)) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        bool1 = true;
        i = -1;
        if (opz.g((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
          opz.b(this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
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
          do
          {
            return;
            tby.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
          } while (!ood.b);
          ood.c = true;
        } while (ooe.a(this.a.jdField_a_of_type_Ooe) == null);
        ooe.a(this.a.jdField_a_of_type_Ooe).q();
        ooe.a(this.a.jdField_a_of_type_Ooe).o();
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
        paramViewBase = oqk.a((ProteusBannerVideoItemData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      } while (paramViewBase == null);
      if (!ubb.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase)) {
        break label302;
      }
    } while (ooe.a(this.a.jdField_a_of_type_Ooe) == null);
    ooe.a(this.a.jdField_a_of_type_Ooe).q();
    return;
    label302:
    if (ooe.a(this.a.jdField_a_of_type_Ooe) != null) {}
    for (boolean bool2 = ooe.a(this.a.jdField_a_of_type_Ooe).a();; bool2 = false)
    {
      paramViewBase.setClickPos(i);
      Object localObject = new oml(bool2);
      if (i == 8) {
        ((oml)localObject).c = true;
      }
      localObject = ubb.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, null, 2, bool1, (oml)localObject);
      if (localObject == null) {
        break;
      }
      ((GdtHandler.Params)localObject).f = oqi.a((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      ubb.a((GdtHandler.Params)localObject, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase);
      ood.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject;
      ood.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      paramViewBase.setClickPos(i);
      olm.a(true, (Context)this.a.jdField_a_of_type_Ooe.jdField_a_of_type_JavaLangRefWeakReference.get(), oqk.a((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData), 2, nxw.a, 3);
      if (ooe.a(this.a.jdField_a_of_type_Ooe) == null) {
        break;
      }
      ooe.a(this.a.jdField_a_of_type_Ooe).q();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oog
 * JD-Core Version:    0.7.0.1
 */