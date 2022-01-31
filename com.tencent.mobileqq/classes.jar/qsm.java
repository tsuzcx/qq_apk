import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class qsm
  implements rcj
{
  qsm(qsk paramqsk, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = onk.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      osj.a().a(Long.valueOf(paramView).longValue(), qrw.a(this.jdField_a_of_type_Qsk.a).a.makeDislikeParam(paramArrayList, qrw.a(this.jdField_a_of_type_Qsk.a).g));
    }
    bcpw.a(qrw.a(this.jdField_a_of_type_Qsk.a), -1, qrw.a(this.jdField_a_of_type_Qsk.a).getString(2131699663), 0).b(qrw.a(this.jdField_a_of_type_Qsk.a).getResources().getDimensionPixelSize(2131298865));
    qrw.a(this.jdField_a_of_type_Qsk.a).dismiss();
    qrw.b(this.jdField_a_of_type_Qsk.a, false);
    noo.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new qze(npx.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(paramArrayList).a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsm
 * JD-Core Version:    0.7.0.1
 */