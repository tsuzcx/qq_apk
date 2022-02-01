import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import org.json.JSONObject;

class scy
  implements spt
{
  scy(scw paramscw, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = pha.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      pmh.a().a(Long.valueOf(paramView).longValue(), sce.a(this.jdField_a_of_type_Scw.a).a.makeDislikeParam(paramArrayList, sce.a(this.jdField_a_of_type_Scw.a).g));
    }
    QQToast.a(sce.a(this.jdField_a_of_type_Scw.a), -1, sce.a(this.jdField_a_of_type_Scw.a).getString(2131698480), 0).b(sce.a(this.jdField_a_of_type_Scw.a).getResources().getDimensionPixelSize(2131298998));
    sce.a(this.jdField_a_of_type_Scw.a).dismiss();
    sce.b(this.jdField_a_of_type_Scw.a, false);
    oat.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new skc(och.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(paramArrayList).a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scy
 * JD-Core Version:    0.7.0.1
 */