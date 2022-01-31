import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class qlt
  implements qqm
{
  qlt(qlp paramqlp) {}
  
  public void a(long paramLong)
  {
    if (qlp.a(this.a) != null) {
      qlp.a(this.a).a(paramLong);
    }
    Object localObject;
    if ((qlp.a(this.a) instanceof qma))
    {
      localObject = (qma)qlp.a(this.a);
      if ((oar.a((qma)localObject)) && (((qma)qlp.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null))
      {
        ((qma)qlp.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setGestureAdInfo((qma)localObject, qlp.a(this.a));
        oar.a(((qma)qlp.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView, ((qma)qlp.a(this.a)).b);
      }
      if ((paramLong >= oar.a((qma)qlp.a(this.a), true)) && (paramLong <= oar.a((qma)qlp.a(this.a), false)))
      {
        if (((qma)qlp.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
        {
          ((qma)qlp.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(0);
          ((qma)qlp.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(true);
        }
        if (((((qma)localObject).jdField_a_of_type_Int == 5) || (((qma)localObject).jdField_a_of_type_Int == 7)) && (paramLong >= sfe.jdField_a_of_type_Long) && (!qlp.g(this.a)) && (qlp.a(this.a) != null))
        {
          qlp.a(this.a).sendEmptyMessage(6);
          qlp.f(this.a, true);
        }
        if (((((qma)localObject).jdField_a_of_type_Int == 5) || (((qma)localObject).jdField_a_of_type_Int == 7)) && (!qlp.h(this.a)) && (!qlp.i(this.a)) && (oaq.b(((qma)localObject).jdField_a_of_type_Qql.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (qlp.a(this.a) != null) && ((!((qma)localObject).jdField_a_of_type_Boolean) || (qlp.b(((qma)localObject).jdField_a_of_type_Qql.a))) && (((qma)localObject).jdField_a_of_type_Qql.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.b))
        {
          int j = ((Integer)oaq.a(((qma)localObject).jdField_a_of_type_Qql.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v, "ad_card_show_time", Integer.valueOf(sfe.jdField_a_of_type_Int))).intValue() * 1000;
          int i = j;
          if (j < 0) {
            i = sfe.jdField_a_of_type_Int * 1000;
          }
          j = i;
          if (qlp.b(((qma)localObject).jdField_a_of_type_Qql.a))
          {
            j = i;
            if (((qma)localObject).jdField_a_of_type_Qql.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
              j = ((qma)localObject).jdField_a_of_type_Qql.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.r * 1000;
            }
          }
          if ((paramLong >= j) && ((!oar.a((qma)localObject)) || (qlp.b(((qma)localObject).jdField_a_of_type_Qql.a))))
          {
            if (((qma)localObject).d.getVisibility() == 0) {
              ((qma)localObject).d.setVisibility(8);
            }
            qlp.a(this.a).sendEmptyMessage(9);
            qlp.g(this.a, true);
          }
        }
      }
    }
    for (;;)
    {
      if (((qlp.a(this.a) instanceof qmo)) && (!((qmo)qlp.a(this.a)).jdField_a_of_type_Boolean)) {}
      try
      {
        if ((paramLong >= qlp.a(this.a).b() - 7000L) && (rlz.a().a()))
        {
          localObject = qlp.a(this.a).jdField_a_of_type_Qql.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
          if ((localObject != null) && (!((FusionBiuInfo)localObject).b)) {
            ((qmj)qlp.a(this.a).jdField_a_of_type_Qjo).a(qlp.a(this.a), true);
          }
        }
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
      }
      if (((qma)qlp.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView == null) {
        break;
      }
      ((qma)qlp.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
      ((qma)qlp.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(false);
      ((qma)qlp.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.b();
      break;
      if ((qlp.a(this.a) instanceof qmf)) {
        qlp.f(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlt
 * JD-Core Version:    0.7.0.1
 */