import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import org.json.JSONObject;

class rhv
  implements rse
{
  rhv(rht paramrht, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = ors.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      owy.a().a(Long.valueOf(paramView).longValue(), rhf.a(this.jdField_a_of_type_Rht.a).a.makeDislikeParam(paramArrayList, rhf.a(this.jdField_a_of_type_Rht.a).g));
    }
    QQToast.a(rhf.a(this.jdField_a_of_type_Rht.a), -1, rhf.a(this.jdField_a_of_type_Rht.a).getString(2131700042), 0).b(rhf.a(this.jdField_a_of_type_Rht.a).getResources().getDimensionPixelSize(2131298914));
    rhf.a(this.jdField_a_of_type_Rht.a).dismiss();
    rhf.b(this.jdField_a_of_type_Rht.a, false);
    nrt.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new ron(ntd.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(paramArrayList).a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhv
 * JD-Core Version:    0.7.0.1
 */