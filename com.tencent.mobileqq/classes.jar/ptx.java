import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

class ptx
  implements View.OnClickListener
{
  ptx(ptv paramptv, ArticleInfo paramArticleInfo, qdq paramqdq) {}
  
  public void onClick(View paramView)
  {
    onh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    onh.a(this.jdField_a_of_type_Ptv.a, this.jdField_a_of_type_Qdq.b.b);
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", onh.d);
      paramView.put("kandian_mode", "" + onh.e());
      paramView.put("tab_source", "" + onh.d());
      nol.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ptx
 * JD-Core Version:    0.7.0.1
 */