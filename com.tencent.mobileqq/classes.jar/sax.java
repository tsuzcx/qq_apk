import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import org.json.JSONObject;

class sax
  implements smj
{
  sax(sav paramsav, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = pay.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      pkm.a().a(Long.valueOf(paramView).longValue(), sab.a(this.jdField_a_of_type_Sav.a).a.makeDislikeParam(paramArrayList, sab.a(this.jdField_a_of_type_Sav.a).g));
    }
    QQToast.a(sab.a(this.jdField_a_of_type_Sav.a), -1, sab.a(this.jdField_a_of_type_Sav.a).getString(2131698822), 0).b(sab.a(this.jdField_a_of_type_Sav.a).getResources().getDimensionPixelSize(2131299076));
    sab.a(this.jdField_a_of_type_Sav.a).dismiss();
    sab.b(this.jdField_a_of_type_Sav.a, false);
    odq.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new sie(ofe.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).i(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(paramArrayList).a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sax
 * JD-Core Version:    0.7.0.1
 */