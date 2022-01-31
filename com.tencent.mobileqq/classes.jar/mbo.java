import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import java.util.List;

public class mbo
  implements Runnable
{
  public mbo(VideoFeedsAdapter paramVideoFeedsAdapter, String paramString) {}
  
  public void run()
  {
    int k = VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getHeaderViewsCount();
    int i = VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getFirstVisiblePosition();
    int j;
    if (i <= VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getLastVisiblePosition())
    {
      j = i - k;
      if (j >= 0) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (j >= VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).size()) {
        return;
      }
      if ((((VideoInfo)VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).get(j)).j != null) && (((VideoInfo)VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).get(j)).j.equals(this.jdField_a_of_type_JavaLangString)) && (!((VideoInfo)VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).get(j)).c))
      {
        Object localObject1 = VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getChildAt(i - VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getFirstVisiblePosition()).getTag();
        if ((localObject1 instanceof VideoFeedsAdapter.VideoItemHolder))
        {
          Object localObject2 = (VideoInfo)VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).get(j);
          j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.getItemViewType(j);
          VideoFeedsAdapter.VideoItemHolder localVideoItemHolder = (VideoFeedsAdapter.VideoItemHolder)localObject1;
          boolean bool = ((VideoInfo)localObject2).g;
          if (j == 2)
          {
            if (bool) {}
            for (j = 2130840861;; j = 2130840864)
            {
              ((VideoFeedsAdapter.ShortVideoItemHolder)localObject1).d.setImageResource(j);
              if (!bool) {
                break label355;
              }
              if (localVideoItemHolder != VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter)) {
                break label342;
              }
              VideoFeedsHelper.a(localVideoItemHolder.g, 8, 600, 3000);
              break;
            }
          }
          if (bool)
          {
            localObject1 = "已关注";
            label293:
            if (!bool) {
              break label335;
            }
          }
          label335:
          for (localObject2 = "#949392";; localObject2 = "#07D0B0")
          {
            localVideoItemHolder.p.setText((CharSequence)localObject1);
            localVideoItemHolder.p.setTextColor(Color.parseColor((String)localObject2));
            break;
            localObject1 = "关注";
            break label293;
          }
          label342:
          localVideoItemHolder.g.setVisibility(8);
          continue;
          label355:
          localVideoItemHolder.g.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbo
 * JD-Core Version:    0.7.0.1
 */