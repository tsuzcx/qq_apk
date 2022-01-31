import android.os.Handler;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsInterruptedAdManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayProgressListener;

public class meb
  implements VideoFeedsPlayManager.VideoPlayProgressListener
{
  public meb(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void a(long paramLong)
  {
    if ((VideoFeedsAdapter.a(this.a) instanceof VideoFeedsAdapter.ADVideoItemHolder))
    {
      localADVideoItemHolder = (VideoFeedsAdapter.ADVideoItemHolder)VideoFeedsAdapter.a(this.a);
      if ((localADVideoItemHolder.jdField_a_of_type_Int == 5) && (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a != null) && (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.a != null) && (localADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.a.c == 12) && (paramLong >= 3000L) && (!localADVideoItemHolder.d.isShown()) && (VideoFeedsAdapter.a(this.a) != null)) {
        VideoFeedsAdapter.a(this.a).sendEmptyMessage(6);
      }
    }
    while ((!(VideoFeedsAdapter.a(this.a) instanceof VideoFeedsAdapter.BaseVideoItemHolder)) || (VideoFeedsAdapter.a(this.a) == null))
    {
      VideoFeedsAdapter.ADVideoItemHolder localADVideoItemHolder;
      return;
    }
    VideoFeedsAdapter.a(this.a).a((int)(paramLong / 1000.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     meb
 * JD-Core Version:    0.7.0.1
 */