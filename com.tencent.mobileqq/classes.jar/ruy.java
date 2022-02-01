import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdGestureView;

class ruy
  implements ryp
{
  ruy(ruw paramruw) {}
  
  public void a(long paramLong)
  {
    if (ruw.a(this.a) != null) {
      ruw.a(this.a).a(paramLong);
    }
    if ((ruw.a(this.a) instanceof rvi))
    {
      localrvi = (rvi)ruw.a(this.a);
      if ((twr.a(localrvi)) && (((rvi)ruw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null))
      {
        ((rvi)ruw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setGestureAdInfo(localrvi, ruw.a(this.a));
        twr.a(((rvi)ruw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView, ((rvi)ruw.a(this.a)).b);
      }
      if ((paramLong >= twr.a((rvi)ruw.a(this.a), true)) && (paramLong <= twr.a((rvi)ruw.a(this.a), false))) {
        if (((rvi)ruw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null)
        {
          ((rvi)ruw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setVisibility(0);
          ((rvi)ruw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.a(true);
        }
      }
    }
    while (!(ruw.a(this.a) instanceof rvn))
    {
      rvi localrvi;
      for (;;)
      {
        int i = twr.a(localrvi.jdField_a_of_type_Ryo.a.a.v, false);
        if (((localrvi.jdField_a_of_type_Int == 5) || (localrvi.jdField_a_of_type_Int == 7)) && (paramLong >= i) && (!ruw.g(this.a)) && (ruw.a(this.a) != null))
        {
          ruw.a(this.a).sendEmptyMessage(6);
          ruw.f(this.a, true);
          if (twd.a(localrvi.jdField_a_of_type_Ryo.a)) {
            ruw.a(this.a).sendEmptyMessage(8);
          }
        }
        if (((localrvi.jdField_a_of_type_Int == 5) || (localrvi.jdField_a_of_type_Int == 7)) && (!ruw.h(this.a)) && (!ruw.i(this.a)) && (twq.b(localrvi.jdField_a_of_type_Ryo.a.a)) && (ruw.a(this.a) != null) && (((!ruw.a(this.a).a()) && (!ruw.a(this.a).b())) || ((twr.b(localrvi.jdField_a_of_type_Ryo.a)) && (localrvi.jdField_a_of_type_Ryo.a.a.b))))
        {
          int j = twr.a(localrvi.jdField_a_of_type_Ryo.a.a.v, true);
          i = j;
          if (j < 0) {
            i = uex.jdField_a_of_type_Int * 1000;
          }
          j = i;
          if (ruw.a(localrvi.jdField_a_of_type_Ryo.a))
          {
            j = i;
            if (localrvi.jdField_a_of_type_Ryo.a.a != null) {
              j = 3000;
            }
          }
          if ((paramLong >= j) && ((!twr.a(localrvi)) || (ruw.a(localrvi.jdField_a_of_type_Ryo.a))))
          {
            if (localrvi.d.getVisibility() == 0) {
              localrvi.d.setVisibility(8);
            }
            ruw.a(this.a).sendEmptyMessage(9);
            ruw.g(this.a, true);
          }
        }
        return;
        if (((rvi)ruw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null)
        {
          ((rvi)ruw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setVisibility(4);
          ((rvi)ruw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.a(false);
          ((rvi)ruw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.b();
        }
      }
    }
    ruw.f(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ruy
 * JD-Core Version:    0.7.0.1
 */