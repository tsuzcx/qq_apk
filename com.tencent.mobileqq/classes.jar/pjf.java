import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

class pjf
  implements View.OnClickListener
{
  pjf(pja parampja, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    nxu.a(pja.a(this.jdField_a_of_type_Pja), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoId, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoName, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoType, 1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.hasChannelInfo()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoId;
    }
    try
    {
      paramView = new JSONObject();
      paramView.put("feeds_channel_entrance", i);
      nrt.a(null, "CliOper", "", "", "0X8006DF3", "0X8006DF3", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pjf
 * JD-Core Version:    0.7.0.1
 */