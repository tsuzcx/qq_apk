import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import org.json.JSONObject;

class snc
  implements szt
{
  snc(sna paramsna, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = pkh.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      pvj.a().a(Long.valueOf(paramView).longValue(), smg.a(this.jdField_a_of_type_Sna.a).a.makeDislikeParam(paramArrayList, smg.a(this.jdField_a_of_type_Sna.a).g));
    }
    QQToast.a(smg.a(this.jdField_a_of_type_Sna.a), -1, smg.a(this.jdField_a_of_type_Sna.a).getString(2131699166), 0).b(smg.a(this.jdField_a_of_type_Sna.a).getResources().getDimensionPixelSize(2131299080));
    smg.a(this.jdField_a_of_type_Sna.a).dismiss();
    smg.b(this.jdField_a_of_type_Sna.a, false);
    olh.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new suu(omx.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).i(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(paramArrayList).a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snc
 * JD-Core Version:    0.7.0.1
 */