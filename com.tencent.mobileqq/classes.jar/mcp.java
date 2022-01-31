import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.qphone.base.util.QLog;

class mcp
  implements Runnable
{
  mcp(mcn parammcn, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void run()
  {
    if ((VideoFeedsPlayActivity.a(this.jdField_a_of_type_Mcn.a) != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != VideoFeedsPlayActivity.a(this.jdField_a_of_type_Mcn.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam)) {}
    do
    {
      return;
      if (VideoFeedsPlayActivity.a(this.jdField_a_of_type_Mcn.a).a() != 1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "mListView.getLastScrollStatus() == VideoFeedsListView.SCROLL_STATE_TOUCH_SCROLL");
    return;
    VideoFeedsPlayActivity.a(this.jdField_a_of_type_Mcn.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcp
 * JD-Core Version:    0.7.0.1
 */