import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import org.json.JSONObject;

public class mfq
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  public mfq(VideoShareHelper paramVideoShareHelper, BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject) {}
  
  public void a(View paramView, ArrayList paramArrayList, Object paramObject)
  {
    VideoShareHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper, true);
    ReadInJoyUtils.a();
    VideoShareHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper).dismiss();
    ((Animation)VideoShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper).getTag(2131362291)).setAnimationListener(new mfr(this, paramArrayList));
    VideoShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper).startAnimation((Animation)VideoShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper).getTag(2131362291));
    PublicAccountReportUtils.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, VideoReporter.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfq
 * JD-Core Version:    0.7.0.1
 */