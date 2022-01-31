import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;

class rbc
  implements rft
{
  rbc(raw paramraw) {}
  
  public void a(long paramLong)
  {
    if (raw.a(this.a) != null) {
      raw.a(this.a).a(paramLong);
    }
    if ((raw.a(this.a) instanceof rbi))
    {
      localrbi = (rbi)raw.a(this.a);
      if ((oee.a(localrbi)) && (((rbi)raw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null))
      {
        ((rbi)raw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setGestureAdInfo(localrbi, raw.a(this.a));
        oee.a(((rbi)raw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView, ((rbi)raw.a(this.a)).b);
      }
      if ((paramLong >= oee.a((rbi)raw.a(this.a), true)) && (paramLong <= oee.a((rbi)raw.a(this.a), false))) {
        if (((rbi)raw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
        {
          ((rbi)raw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(0);
          ((rbi)raw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(true);
        }
      }
    }
    while (!(raw.a(this.a) instanceof rbn))
    {
      rbi localrbi;
      for (;;)
      {
        if (((localrbi.jdField_a_of_type_Int == 5) || (localrbi.jdField_a_of_type_Int == 7)) && (paramLong >= swy.jdField_a_of_type_Long) && (!raw.h(this.a)) && (raw.a(this.a) != null))
        {
          raw.a(this.a).sendEmptyMessage(6);
          raw.f(this.a, true);
        }
        if (((localrbi.jdField_a_of_type_Int == 5) || (localrbi.jdField_a_of_type_Int == 7)) && (!raw.i(this.a)) && (!raw.j(this.a)) && (oed.b(localrbi.jdField_a_of_type_Rfs.a.a)) && (raw.a(this.a) != null) && ((!localrbi.jdField_a_of_type_Boolean) || (raw.b(localrbi.jdField_a_of_type_Rfs.a))) && (localrbi.jdField_a_of_type_Rfs.a.a.b))
        {
          int j = ((Integer)oed.a(localrbi.jdField_a_of_type_Rfs.a.a.v, "ad_card_show_time", Integer.valueOf(swy.jdField_a_of_type_Int))).intValue() * 1000;
          int i = j;
          if (j < 0) {
            i = swy.jdField_a_of_type_Int * 1000;
          }
          j = i;
          if (raw.b(localrbi.jdField_a_of_type_Rfs.a))
          {
            j = i;
            if (localrbi.jdField_a_of_type_Rfs.a.a != null) {
              j = localrbi.jdField_a_of_type_Rfs.a.a.r * 1000;
            }
          }
          if ((paramLong >= j) && ((!oee.a(localrbi)) || (raw.b(localrbi.jdField_a_of_type_Rfs.a))))
          {
            if (localrbi.d.getVisibility() == 0) {
              localrbi.d.setVisibility(8);
            }
            raw.a(this.a).sendEmptyMessage(9);
            raw.g(this.a, true);
          }
        }
        return;
        if (((rbi)raw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
        {
          ((rbi)raw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
          ((rbi)raw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(false);
          ((rbi)raw.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.b();
        }
      }
    }
    raw.f(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbc
 * JD-Core Version:    0.7.0.1
 */