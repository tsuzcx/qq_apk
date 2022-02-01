import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class qtz
  implements View.OnClickListener
{
  qtz(qtx paramqtx, ArticleInfo paramArticleInfo, rii paramrii) {}
  
  public void onClick(View paramView)
  {
    pha.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    pha.a(this.jdField_a_of_type_Qtx.a, this.jdField_a_of_type_Rii.b.b);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", pha.d);
      localJSONObject.put("kandian_mode", "" + pha.e());
      localJSONObject.put("tab_source", "" + pha.d());
      oat.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", localJSONObject.toString(), false);
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
 * Qualified Name:     qtz
 * JD-Core Version:    0.7.0.1
 */