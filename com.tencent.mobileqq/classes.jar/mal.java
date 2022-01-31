import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import java.util.List;

public class mal
  implements Runnable
{
  public mal(VideoFeedsAdapter paramVideoFeedsAdapter, String paramString) {}
  
  public void run()
  {
    int j = VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getHeaderViewsCount();
    int i = VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getFirstVisiblePosition();
    int k;
    if (i <= VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getLastVisiblePosition())
    {
      k = i - j;
      if (k >= 0) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (k >= VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).size()) {
        return;
      }
      if ((((VideoInfo)VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).get(k)).j != null) && (((VideoInfo)VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).get(k)).j.equals(this.jdField_a_of_type_JavaLangString)) && (!((VideoInfo)VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).get(k)).a))
      {
        Object localObject = VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getChildAt(i - VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getFirstVisiblePosition()).getTag();
        if ((localObject instanceof VideoFeedsAdapter.VideoItemHolder))
        {
          localObject = (VideoFeedsAdapter.VideoItemHolder)localObject;
          if (((VideoInfo)VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).get(k)).f)
          {
            ((VideoFeedsAdapter.VideoItemHolder)localObject).o.setText("已关注");
            ((VideoFeedsAdapter.VideoItemHolder)localObject).o.setTextColor(Color.parseColor("#949392"));
            if (localObject == VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter)) {
              VideoFeedsHelper.a(((VideoFeedsAdapter.VideoItemHolder)localObject).g, 8, 600, 3000);
            } else {
              ((VideoFeedsAdapter.VideoItemHolder)localObject).g.setVisibility(8);
            }
          }
          else
          {
            ((VideoFeedsAdapter.VideoItemHolder)localObject).o.setText("关注");
            ((VideoFeedsAdapter.VideoItemHolder)localObject).o.setTextColor(Color.parseColor("#07D0B0"));
            ((VideoFeedsAdapter.VideoItemHolder)localObject).g.setVisibility(0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mal
 * JD-Core Version:    0.7.0.1
 */