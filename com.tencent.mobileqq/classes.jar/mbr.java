import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import java.util.ArrayList;
import java.util.List;

public class mbr
  implements PopupMenuDialog.OnClickActionListener
{
  public mbr(VideoFeedsAdapter paramVideoFeedsAdapter, VideoInfo paramVideoInfo) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    QQToast.a(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter), 0, 2131438684, 0).a();
    if ((VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter) != null) && (VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).contains(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)))
    {
      int i = VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).indexOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      VideoFeedsAdapter.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).remove(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.notifyDataSetChanged();
      if (i < VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).size())
      {
        String str = ((VideoInfo)VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).get(i)).jdField_a_of_type_JavaLangString;
        Message localMessage = new Message();
        localMessage.what = 5;
        localMessage.obj = str;
        VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).sendMessageDelayed(localMessage, 500L);
      }
    }
    paramMenuItem = (VideoAdInfo.NegFeedback)this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e.get(paramMenuItem.a);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.f = paramMenuItem.a;
    paramMenuItem = NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter)))
    {
      NativeAdUtils.a(null, VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter), NativeAdUtils.c, NativeAdUtils.n, paramMenuItem, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.f);
      return;
    }
    NativeAdUtils.a(null, VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter), NativeAdUtils.c, NativeAdUtils.m, paramMenuItem, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbr
 * JD-Core Version:    0.7.0.1
 */