import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

class pua
  implements View.OnClickListener
{
  pua(pty parampty, ArticleInfo paramArticleInfo, qdt paramqdt) {}
  
  public void onClick(View paramView)
  {
    onk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    onk.a(this.jdField_a_of_type_Pty.a, this.jdField_a_of_type_Qdt.b.b);
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", onk.d);
      paramView.put("kandian_mode", "" + onk.e());
      paramView.put("tab_source", "" + onk.d());
      noo.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pua
 * JD-Core Version:    0.7.0.1
 */