import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class qgo
  implements qpy
{
  qgo(qgm paramqgm, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = obz.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      ogy.a().a(Long.valueOf(paramView).longValue(), qfy.a(this.jdField_a_of_type_Qgm.a).a.makeDislikeParam(paramArrayList, qfy.a(this.jdField_a_of_type_Qgm.a).g));
    }
    bbmy.a(qfy.a(this.jdField_a_of_type_Qgm.a), -1, qfy.a(this.jdField_a_of_type_Qgm.a).getString(2131633875), 0).b(qfy.a(this.jdField_a_of_type_Qgm.a).getResources().getDimensionPixelSize(2131167766));
    qfy.a(this.jdField_a_of_type_Qgm.a).dismiss();
    qfy.b(this.jdField_a_of_type_Qgm.a, false);
    ndn.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new qmv(new.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(paramArrayList).a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgo
 * JD-Core Version:    0.7.0.1
 */