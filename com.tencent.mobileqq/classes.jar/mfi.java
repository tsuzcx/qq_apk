import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import java.util.Set;

public class mfi
  implements Runnable
{
  private boolean jdField_a_of_type_Boolean;
  
  public mfi(VideoPreDownloadMgr paramVideoPreDownloadMgr, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr) != null) {
        VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr).add(VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr));
      }
      if (VideoPreDownloadMgr.a() != null) {
        VideoPreDownloadMgr.a().add(VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr));
      }
    }
    VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr, null);
    VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfi
 * JD-Core Version:    0.7.0.1
 */