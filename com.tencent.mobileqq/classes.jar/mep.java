import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import org.json.JSONObject;

public class mep
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  public mep(VideoFeedsAdapter paramVideoFeedsAdapter, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public void a(View paramView, ArrayList paramArrayList, Object paramObject)
  {
    paramView = ReadInJoyUtils.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      ReadInJoyLogicEngine.a().a(Long.valueOf(paramView).longValue(), VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.makeDislikeParam(paramArrayList, VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g));
    }
    QQToast.a(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter), -1, VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getString(2131428476), 0).b(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getResources().getDimensionPixelSize(2131558448));
    VideoFeedsAdapter.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).dismiss();
    PublicAccountReportUtils.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, VideoReporter.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mep
 * JD-Core Version:    0.7.0.1
 */