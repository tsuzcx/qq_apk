import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class qsj
  implements rcg
{
  qsj(qsh paramqsh, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = onh.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      osg.a().a(Long.valueOf(paramView).longValue(), qrt.a(this.jdField_a_of_type_Qsh.a).a.makeDislikeParam(paramArrayList, qrt.a(this.jdField_a_of_type_Qsh.a).g));
    }
    bcql.a(qrt.a(this.jdField_a_of_type_Qsh.a), -1, qrt.a(this.jdField_a_of_type_Qsh.a).getString(2131699674), 0).b(qrt.a(this.jdField_a_of_type_Qsh.a).getResources().getDimensionPixelSize(2131298865));
    qrt.a(this.jdField_a_of_type_Qsh.a).dismiss();
    qrt.b(this.jdField_a_of_type_Qsh.a, false);
    nol.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new qzb(npu.a(null, null, null, null, this.jdField_a_of_type_OrgJsonJSONObject)).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).a(paramArrayList).a().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsj
 * JD-Core Version:    0.7.0.1
 */