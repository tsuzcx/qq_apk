import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class pzx
  implements qer
{
  pzx(pzs parampzs) {}
  
  public void a(long paramLong)
  {
    if (pzs.a(this.a) != null) {
      pzs.a(this.a).a(paramLong);
    }
    Object localObject;
    if ((pzs.a(this.a) instanceof qab))
    {
      localObject = (qab)pzs.a(this.a);
      if ((npj.a((qab)localObject)) && (((qab)pzs.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null))
      {
        ((qab)pzs.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setGestureAdInfo((qab)localObject, pzs.a(this.a));
        npj.a(((qab)pzs.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView, ((qab)pzs.a(this.a)).b);
      }
      if ((paramLong >= npj.a((qab)pzs.a(this.a), true)) && (paramLong <= npj.a((qab)pzs.a(this.a), false)))
      {
        if (((qab)pzs.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
        {
          ((qab)pzs.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(0);
          ((qab)pzs.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(true);
        }
        if (((((qab)localObject).jdField_a_of_type_Int == 5) || (((qab)localObject).jdField_a_of_type_Int == 7)) && (paramLong >= rsp.jdField_a_of_type_Long) && (!pzs.g(this.a)) && (pzs.a(this.a) != null))
        {
          pzs.a(this.a).sendEmptyMessage(6);
          pzs.f(this.a, true);
        }
        if (((((qab)localObject).jdField_a_of_type_Int == 5) || (((qab)localObject).jdField_a_of_type_Int == 7)) && (!pzs.h(this.a)) && (!pzs.i(this.a)) && (npi.b(((qab)localObject).jdField_a_of_type_Qeq.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (pzs.a(this.a) != null) && (!((qab)localObject).jdField_a_of_type_Boolean) && (((qab)localObject).jdField_a_of_type_Qeq.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.b))
        {
          int j = ((Integer)npi.a(((qab)localObject).jdField_a_of_type_Qeq.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v, "ad_card_show_time", Integer.valueOf(rsp.jdField_a_of_type_Int))).intValue() * 1000;
          int i = j;
          if (j < 0) {
            i = rsp.jdField_a_of_type_Int * 1000;
          }
          if ((paramLong >= i) && (!npj.a((qab)localObject)))
          {
            if (((qab)localObject).d.getVisibility() == 0) {
              ((qab)localObject).d.setVisibility(8);
            }
            pzs.a(this.a).sendEmptyMessage(9);
            pzs.g(this.a, true);
          }
        }
      }
    }
    for (;;)
    {
      if ((pzs.a(this.a) instanceof qap)) {}
      try
      {
        if ((paramLong >= pzs.a(this.a).b() - 7000L) && (qzk.a().a()))
        {
          localObject = pzs.a(this.a).jdField_a_of_type_Qeq.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
          if ((localObject != null) && (!((FusionBiuInfo)localObject).b)) {
            ((qap)pzs.a(this.a)).a(pzs.a(this.a), true);
          }
        }
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
      }
      if (((qab)pzs.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView == null) {
        break;
      }
      ((qab)pzs.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
      ((qab)pzs.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(false);
      ((qab)pzs.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.b();
      break;
      if ((pzs.a(this.a) instanceof qag)) {
        pzs.f(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzx
 * JD-Core Version:    0.7.0.1
 */