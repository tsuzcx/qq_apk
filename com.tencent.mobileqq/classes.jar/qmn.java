import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class qmn
  implements View.OnClickListener
{
  qmn(qml paramqml, ArticleInfo paramArticleInfo, qzb paramqzb) {}
  
  public void onClick(View paramView)
  {
    ozs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    ozs.a(this.jdField_a_of_type_Qml.a, this.jdField_a_of_type_Qzb.b.b);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", ozs.d);
      localJSONObject.put("kandian_mode", "" + ozs.e());
      localJSONObject.put("tab_source", "" + ozs.d());
      ocd.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", localJSONObject.toString(), false);
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
 * Qualified Name:     qmn
 * JD-Core Version:    0.7.0.1
 */