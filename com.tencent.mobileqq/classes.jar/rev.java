import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class rev
  implements View.OnClickListener
{
  rev(ret paramret, ArticleInfo paramArticleInfo, rsh paramrsh) {}
  
  public void onClick(View paramView)
  {
    pqx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    pkh.a(this.jdField_a_of_type_Ret.a, this.jdField_a_of_type_Rsh.b.b);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", prp.a);
      localJSONObject.put("kandian_mode", "" + pqu.a());
      localJSONObject.put("tab_source", "" + pqf.a());
      olh.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", localJSONObject.toString(), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rev
 * JD-Core Version:    0.7.0.1
 */