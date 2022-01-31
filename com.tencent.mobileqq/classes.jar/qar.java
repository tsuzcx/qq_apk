import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

class qar
  implements View.OnClickListener
{
  qar(qap paramqap, ArticleInfo paramArticleInfo, qnm paramqnm) {}
  
  public void onClick(View paramView)
  {
    ors.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    ors.a(this.jdField_a_of_type_Qap.a, this.jdField_a_of_type_Qnm.b.b);
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", ors.d);
      paramView.put("kandian_mode", "" + ors.e());
      paramView.put("tab_source", "" + ors.d());
      nrt.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qar
 * JD-Core Version:    0.7.0.1
 */