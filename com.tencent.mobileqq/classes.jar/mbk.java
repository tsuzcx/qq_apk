import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class mbk
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  public mbk(VideoFeedsAdapter paramVideoFeedsAdapter, VideoInfo paramVideoInfo) {}
  
  public void a(View paramView, ArrayList paramArrayList, Object paramObject)
  {
    paramView = ReadInJoyUtils.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      if (VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      ReadInJoyLogicEngine.a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.makeDislikeParam(paramArrayList, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g));
      paramView = NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        break label185;
      }
    }
    label185:
    for (int i = ((DislikeInfo)paramArrayList.get(0)).a;; i = 0)
    {
      NativeAdUtils.a(null, VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter), NativeAdUtils.c, NativeAdUtils.n, paramView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, i);
      QQToast.a(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter), -1, VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getString(2131428476), 0).b(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getResources().getDimensionPixelSize(2131558448));
      VideoFeedsAdapter.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbk
 * JD-Core Version:    0.7.0.1
 */