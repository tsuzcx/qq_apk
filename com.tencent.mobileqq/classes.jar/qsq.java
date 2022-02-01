import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class qsq
  implements View.OnClickListener
{
  qsq(qso paramqso, ArticleInfo paramArticleInfo, rga paramrga) {}
  
  public void onClick(View paramView)
  {
    pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    pay.a(this.jdField_a_of_type_Qso.a, this.jdField_a_of_type_Rga.b.b);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", pay.d);
      localJSONObject.put("kandian_mode", "" + pay.e());
      localJSONObject.put("tab_source", "" + pay.d());
      odq.a(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", localJSONObject.toString(), false);
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
 * Qualified Name:     qsq
 * JD-Core Version:    0.7.0.1
 */