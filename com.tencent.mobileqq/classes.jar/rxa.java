import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;

class rxa
  implements sas
{
  rxa(rwy paramrwy) {}
  
  public void a(long paramLong)
  {
    if (rwy.a(this.a) != null) {
      rwy.a(this.a).a(paramLong);
    }
    if ((rwy.a(this.a) instanceof rxl))
    {
      localrxl = (rxl)rwy.a(this.a);
      if ((oqj.a(localrxl)) && (((rxl)rwy.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null))
      {
        ((rxl)rwy.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setGestureAdInfo(localrxl, rwy.a(this.a));
        oqj.a(((rxl)rwy.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView, ((rxl)rwy.a(this.a)).b);
      }
      if ((paramLong >= oqj.a((rxl)rwy.a(this.a), true)) && (paramLong <= oqj.a((rxl)rwy.a(this.a), false))) {
        if (((rxl)rwy.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
        {
          ((rxl)rwy.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(0);
          ((rxl)rwy.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(true);
        }
      }
    }
    while (!(rwy.a(this.a) instanceof rxq))
    {
      rxl localrxl;
      for (;;)
      {
        int i = oqj.a(localrxl.jdField_a_of_type_Sar.a.a.v, false);
        if (((localrxl.jdField_a_of_type_Int == 5) || (localrxl.jdField_a_of_type_Int == 7)) && (paramLong >= i) && (!rwy.g(this.a)) && (rwy.a(this.a) != null))
        {
          rwy.a(this.a).sendEmptyMessage(6);
          rwy.f(this.a, true);
        }
        if (((localrxl.jdField_a_of_type_Int == 5) || (localrxl.jdField_a_of_type_Int == 7)) && (!rwy.h(this.a)) && (!rwy.i(this.a)) && (oqi.b(localrxl.jdField_a_of_type_Sar.a.a)) && (rwy.a(this.a) != null) && ((!localrxl.jdField_a_of_type_Boolean) || (rwy.b(localrxl.jdField_a_of_type_Sar.a))) && (localrxl.jdField_a_of_type_Sar.a.a.b))
        {
          int j = oqj.a(localrxl.jdField_a_of_type_Sar.a.a.v, true);
          i = j;
          if (j < 0) {
            i = tyg.jdField_a_of_type_Int * 1000;
          }
          j = i;
          if (rwy.b(localrxl.jdField_a_of_type_Sar.a))
          {
            j = i;
            if (localrxl.jdField_a_of_type_Sar.a.a != null) {
              j = 3000;
            }
          }
          if ((paramLong >= j) && ((!oqj.a(localrxl)) || (rwy.b(localrxl.jdField_a_of_type_Sar.a))))
          {
            if (localrxl.d.getVisibility() == 0) {
              localrxl.d.setVisibility(8);
            }
            rwy.a(this.a).sendEmptyMessage(9);
            rwy.g(this.a, true);
          }
        }
        return;
        if (((rxl)rwy.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
        {
          ((rxl)rwy.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
          ((rxl)rwy.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(false);
          ((rxl)rwy.a(this.a)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.b();
        }
      }
    }
    rwy.f(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxa
 * JD-Core Version:    0.7.0.1
 */