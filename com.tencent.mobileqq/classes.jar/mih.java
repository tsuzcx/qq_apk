import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;

class mih
  implements Runnable
{
  mih(mid parammid, int paramInt1, int paramInt2, String paramString, VideoPlayerWrapper paramVideoPlayerWrapper) {}
  
  public void run()
  {
    if (VideoPlayManager.a(this.jdField_a_of_type_Mid.a) != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.b;
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a, VideoPlayManager.a(this.jdField_a_of_type_Mid.a), VideoPlayManager.a(this.jdField_a_of_type_Mid.a), 6, new int[] { i, j });
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_Int + ":" + this.b);
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.jdField_a_of_type_Long = 0L;
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.jdField_a_of_type_Boolean = false;
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.e = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_b_of_type_Boolean;
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.p = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_b_of_type_Long;
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.o = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_a_of_type_Long;
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.q = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e();
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.r = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.h();
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.f = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.t = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.g();
      VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.u = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f();
      ReadInJoyUtils.a(VideoPlayManager.a(this.jdField_a_of_type_Mid.a).getApplicationContext(), ReadInJoyUtils.a(), false, VideoPlayManager.a(this.jdField_a_of_type_Mid.a).a.a());
    }
    VideoPlayManager.a(this.jdField_a_of_type_Mid.a, null);
    VideoPlayManager.a(this.jdField_a_of_type_Mid.a, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mih
 * JD-Core Version:    0.7.0.1
 */