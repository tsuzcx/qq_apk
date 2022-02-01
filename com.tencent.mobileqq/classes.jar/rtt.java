import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import org.json.JSONObject;

class rtt
  implements sgx
{
  rtt(rtr paramrtr, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = ozs.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      pfa.a().a(Long.valueOf(paramView).longValue(), rsx.a(this.jdField_a_of_type_Rtr.a).a.makeDislikeParam(paramArrayList, rsx.a(this.jdField_a_of_type_Rtr.a).g));
    }
    QQToast.a(rsx.a(this.jdField_a_of_type_Rtr.a), -1, rsx.a(this.jdField_a_of_type_Rtr.a).getString(2131698587), 0).b(rsx.a(this.jdField_a_of_type_Rtr.a).getResources().getDimensionPixelSize(2131299011));
    rsx.a(this.jdField_a_of_type_Rtr.a).dismiss();
    rsx.b(this.jdField_a_of_type_Rtr.a, false);
    ocd.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new sbg(odr.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).i(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(paramArrayList).a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtt
 * JD-Core Version:    0.7.0.1
 */