import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdGestureView;

class rnw
  implements rrn
{
  rnw(rnu paramrnu) {}
  
  public void a(long paramLong)
  {
    if (rnu.a(this.a) != null) {
      rnu.a(this.a).a(paramLong);
    }
    if ((rnu.a(this.a) instanceof rog))
    {
      localrog = (rog)rnu.a(this.a);
      if ((tqa.a(localrog)) && (((rog)rnu.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null))
      {
        ((rog)rnu.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setGestureAdInfo(localrog, rnu.a(this.a));
        tqa.a(((rog)rnu.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView, ((rog)rnu.a(this.a)).b);
      }
      if ((paramLong >= tqa.a((rog)rnu.a(this.a), true)) && (paramLong <= tqa.a((rog)rnu.a(this.a), false))) {
        if (((rog)rnu.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null)
        {
          ((rog)rnu.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setVisibility(0);
          ((rog)rnu.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.a(true);
        }
      }
    }
    while (!(rnu.a(this.a) instanceof rol))
    {
      rog localrog;
      for (;;)
      {
        int i = tqa.a(localrog.jdField_a_of_type_Rrm.a.a.v, false);
        if (((localrog.jdField_a_of_type_Int == 5) || (localrog.jdField_a_of_type_Int == 7)) && (paramLong >= i) && (!rnu.g(this.a)) && (rnu.a(this.a) != null))
        {
          rnu.a(this.a).sendEmptyMessage(6);
          rnu.f(this.a, true);
        }
        if (((localrog.jdField_a_of_type_Int == 5) || (localrog.jdField_a_of_type_Int == 7)) && (!rnu.h(this.a)) && (!rnu.i(this.a)) && (tpz.b(localrog.jdField_a_of_type_Rrm.a.a)) && (rnu.a(this.a) != null) && ((!localrog.jdField_a_of_type_Boolean) || (rnu.a(localrog.jdField_a_of_type_Rrm.a))) && (localrog.jdField_a_of_type_Rrm.a.a.b))
        {
          int j = tqa.a(localrog.jdField_a_of_type_Rrm.a.a.v, true);
          i = j;
          if (j < 0) {
            i = tyi.jdField_a_of_type_Int * 1000;
          }
          j = i;
          if (rnu.a(localrog.jdField_a_of_type_Rrm.a))
          {
            j = i;
            if (localrog.jdField_a_of_type_Rrm.a.a != null) {
              j = 3000;
            }
          }
          if ((paramLong >= j) && ((!tqa.a(localrog)) || (rnu.a(localrog.jdField_a_of_type_Rrm.a))))
          {
            if (localrog.d.getVisibility() == 0) {
              localrog.d.setVisibility(8);
            }
            rnu.a(this.a).sendEmptyMessage(9);
            rnu.g(this.a, true);
          }
        }
        return;
        if (((rog)rnu.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null)
        {
          ((rog)rnu.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setVisibility(4);
          ((rog)rnu.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.a(false);
          ((rog)rnu.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.b();
        }
      }
    }
    rnu.f(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnw
 * JD-Core Version:    0.7.0.1
 */