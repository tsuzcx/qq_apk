import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import java.util.Set;

public class mdc
  implements Runnable
{
  public mdc(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).c() == 2))
    {
      this.a.b(4);
      VideoFeedsPlayManager.a(this.a, 8);
      VideoFeedsPlayManager.a(this.a).d();
      if (VideoFeedsPlayManager.d(this.a))
      {
        String str = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.h;
        if (VideoFeedsPlayManager.a(this.a).contains(str)) {
          break label125;
        }
        VideoFeedsPlayManager.a(this.a).add(str);
        VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.f = ReadinjoyAdVideoReportData.a;
      }
    }
    return;
    label125:
    VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.f = ReadinjoyAdVideoReportData.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdc
 * JD-Core Version:    0.7.0.1
 */