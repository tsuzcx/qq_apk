import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

class pif
  implements View.OnClickListener
{
  pif(pid parampid, ArticleInfo paramArticleInfo, prv paramprv) {}
  
  public void onClick(View paramView)
  {
    obz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    obz.a(this.jdField_a_of_type_Pid.a, this.jdField_a_of_type_Prv.b.b);
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", obz.d);
      paramView.put("kandian_mode", "" + obz.e());
      paramView.put("tab_source", "" + obz.d());
      ndn.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pif
 * JD-Core Version:    0.7.0.1
 */