import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class qlw
  implements qqp
{
  qlw(qls paramqls) {}
  
  public void a(long paramLong)
  {
    if (qls.a(this.a) != null) {
      qls.a(this.a).a(paramLong);
    }
    Object localObject;
    if ((qls.a(this.a) instanceof qmd))
    {
      localObject = (qmd)qls.a(this.a);
      if ((oau.a((qmd)localObject)) && (((qmd)qls.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null))
      {
        ((qmd)qls.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setGestureAdInfo((qmd)localObject, qls.a(this.a));
        oau.a(((qmd)qls.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView, ((qmd)qls.a(this.a)).b);
      }
      if ((paramLong >= oau.a((qmd)qls.a(this.a), true)) && (paramLong <= oau.a((qmd)qls.a(this.a), false)))
      {
        if (((qmd)qls.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
        {
          ((qmd)qls.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(0);
          ((qmd)qls.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(true);
        }
        if (((((qmd)localObject).jdField_a_of_type_Int == 5) || (((qmd)localObject).jdField_a_of_type_Int == 7)) && (paramLong >= sfh.jdField_a_of_type_Long) && (!qls.g(this.a)) && (qls.a(this.a) != null))
        {
          qls.a(this.a).sendEmptyMessage(6);
          qls.f(this.a, true);
        }
        if (((((qmd)localObject).jdField_a_of_type_Int == 5) || (((qmd)localObject).jdField_a_of_type_Int == 7)) && (!qls.h(this.a)) && (!qls.i(this.a)) && (oat.b(((qmd)localObject).jdField_a_of_type_Qqo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (qls.a(this.a) != null) && ((!((qmd)localObject).jdField_a_of_type_Boolean) || (qls.b(((qmd)localObject).jdField_a_of_type_Qqo.a))) && (((qmd)localObject).jdField_a_of_type_Qqo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.b))
        {
          int j = ((Integer)oat.a(((qmd)localObject).jdField_a_of_type_Qqo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v, "ad_card_show_time", Integer.valueOf(sfh.jdField_a_of_type_Int))).intValue() * 1000;
          int i = j;
          if (j < 0) {
            i = sfh.jdField_a_of_type_Int * 1000;
          }
          j = i;
          if (qls.b(((qmd)localObject).jdField_a_of_type_Qqo.a))
          {
            j = i;
            if (((qmd)localObject).jdField_a_of_type_Qqo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
              j = ((qmd)localObject).jdField_a_of_type_Qqo.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.r * 1000;
            }
          }
          if ((paramLong >= j) && ((!oau.a((qmd)localObject)) || (qls.b(((qmd)localObject).jdField_a_of_type_Qqo.a))))
          {
            if (((qmd)localObject).d.getVisibility() == 0) {
              ((qmd)localObject).d.setVisibility(8);
            }
            qls.a(this.a).sendEmptyMessage(9);
            qls.g(this.a, true);
          }
        }
      }
    }
    for (;;)
    {
      if (((qls.a(this.a) instanceof qmr)) && (!((qmr)qls.a(this.a)).jdField_a_of_type_Boolean)) {}
      try
      {
        if ((paramLong >= qls.a(this.a).b() - 7000L) && (rmc.a().a()))
        {
          localObject = qls.a(this.a).jdField_a_of_type_Qqo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
          if ((localObject != null) && (!((FusionBiuInfo)localObject).b)) {
            ((qmm)qls.a(this.a).jdField_a_of_type_Qjr).a(qls.a(this.a), true);
          }
        }
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
      }
      if (((qmd)qls.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView == null) {
        break;
      }
      ((qmd)qls.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
      ((qmd)qls.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(false);
      ((qmd)qls.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.b();
      break;
      if ((qls.a(this.a) instanceof qmi)) {
        qls.f(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlw
 * JD-Core Version:    0.7.0.1
 */