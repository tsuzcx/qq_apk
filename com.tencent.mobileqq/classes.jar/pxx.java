import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class pxx
  implements View.OnClickListener
{
  public pxx(ComponentJump paramComponentJump, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    nuq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoId, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoName, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoType, 1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.hasChannelInfo()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoId;
    }
    try
    {
      paramView = new JSONObject();
      paramView.put("feeds_channel_entrance", i);
      nol.a(null, "CliOper", "", "", "0X8006DF3", "0X8006DF3", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pxx
 * JD-Core Version:    0.7.0.1
 */