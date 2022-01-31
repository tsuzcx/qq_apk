import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import java.util.List;

public class meu
  implements Runnable
{
  public meu(VideoFeedsAdapter paramVideoFeedsAdapter, String paramString) {}
  
  public void run()
  {
    int j = VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getHeaderViewsCount();
    int i = VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getFirstVisiblePosition();
    if (i <= VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getLastVisiblePosition())
    {
      int k = i - j;
      VideoInfo localVideoInfo;
      Object localObject;
      if ((k >= 0) && (k < VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).size()))
      {
        localVideoInfo = (VideoInfo)VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).get(k);
        if ((localVideoInfo.b) && (this.jdField_a_of_type_JavaLangString.equals(localVideoInfo.j)))
        {
          localObject = VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getChildAt(i - VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getFirstVisiblePosition()).getTag();
          if ((localObject instanceof VideoFeedsAdapter.VideoItemHolder)) {
            break label143;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label143:
        ((VideoFeedsAdapter.VideoItemHolder)localObject).a.setText(localVideoInfo.k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     meu
 * JD-Core Version:    0.7.0.1
 */