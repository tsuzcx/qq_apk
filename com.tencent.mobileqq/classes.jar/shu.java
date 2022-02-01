import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdGestureView;

class shu
  implements skr
{
  shu(shl paramshl) {}
  
  private void a(swi paramswi, long paramLong)
  {
    int j = uks.a(paramswi.jdField_a_of_type_Skq.a.a.v, true);
    int i = j;
    if (j < 0) {
      i = usu.jdField_a_of_type_Int * 1000;
    }
    j = i;
    if (shl.a(paramswi.jdField_a_of_type_Skq.a))
    {
      j = i;
      if (paramswi.jdField_a_of_type_Skq.a.a != null) {
        j = 3000;
      }
    }
    if ((paramLong >= j) && ((!uks.a(paramswi)) || (shl.a(paramswi.jdField_a_of_type_Skq.a))))
    {
      if (paramswi.d.getVisibility() == 0) {
        paramswi.d.setVisibility(8);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      if ((paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) && (paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a() != null)) {
        ukq.a("AD_DOWNLOAD_TAG", "show card with currentState = " + paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a().jdField_a_of_type_Int);
      }
      this.a.b = true;
    }
  }
  
  private boolean a(swi paramswi)
  {
    return ((paramswi.jdField_a_of_type_Int == 5) || (paramswi.jdField_a_of_type_Int == 7)) && (!this.a.e) && (!this.a.b) && (ukr.b(paramswi.jdField_a_of_type_Skq.a.a)) && (this.a.jdField_a_of_type_AndroidOsHandler != null) && ((!paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.e()) || (uks.b(paramswi.jdField_a_of_type_Skq.a))) && (paramswi.jdField_a_of_type_Skq.a.a.b);
  }
  
  private boolean a(swi paramswi, long paramLong)
  {
    boolean bool2 = false;
    int i = uks.a(paramswi.jdField_a_of_type_Skq.a.a.v, false);
    boolean bool1;
    if (paramswi.jdField_a_of_type_Int != 5)
    {
      bool1 = bool2;
      if (paramswi.jdField_a_of_type_Int != 7) {}
    }
    else
    {
      bool1 = bool2;
      if (paramLong >= i)
      {
        bool1 = bool2;
        if (!shl.d(this.a))
        {
          bool1 = bool2;
          if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void a(long paramLong)
  {
    if (this.a.jdField_a_of_type_Shw != null) {
      this.a.jdField_a_of_type_Shw.a(paramLong);
    }
    if ((shl.a(this.a) instanceof swi))
    {
      localswi = (swi)shl.a(this.a);
      if ((uks.a(localswi)) && (localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null))
      {
        localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setGestureAdInfo(localswi, this.a.jdField_a_of_type_AndroidAppActivity);
        uks.a(localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView, localswi.b);
      }
      if (localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null)
      {
        if ((paramLong >= uks.a((swi)shl.a(this.a), true)) && (paramLong <= uks.a((swi)shl.a(this.a), false)))
        {
          localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setVisibility(0);
          localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.a(true);
        }
      }
      else
      {
        if (a(localswi, paramLong))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
          shl.c(this.a, true);
          if (uke.a(localswi.jdField_a_of_type_Skq.a)) {
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
          }
        }
        if (a(localswi)) {
          a(localswi, paramLong);
        }
      }
    }
    while (shl.a(this.a) == null) {
      for (;;)
      {
        swi localswi;
        return;
        localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setVisibility(4);
        localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.a(false);
        localswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.b();
      }
    }
    shl.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shu
 * JD-Core Version:    0.7.0.1
 */