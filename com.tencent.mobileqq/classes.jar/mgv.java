import android.app.Activity;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class mgv
  implements Runnable
{
  mgv(mgu parammgu) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b.remove(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    ReadInJoyBaseAdapter.b(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, true);
    this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
    int i = 2131428470;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      i = 2131428471;
    }
    if ((this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a instanceof BaseActivity))
    {
      QQToast.a(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a, -1, this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a.getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a).getTitleBarHeight());
      this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_Int, this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        if ((this.a.jdField_a_of_type_JavaLangObject == null) || (!(this.a.jdField_a_of_type_JavaLangObject instanceof DislikeInfo))) {
          break label606;
        }
      }
    }
    label606:
    for (long l = ((DislikeInfo)this.a.jdField_a_of_type_JavaLangObject).a;; l = 0L) {
      for (;;)
      {
        ReadInJoyLogicEngine.a().a(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a, (AdvertisementInfo)this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l);
        try
        {
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
          ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.c);
          ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
          if ((this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a instanceof BaseActivity))
          {
            ((JSONObject)localObject).put("folder_status", ReadInJoyUtils.d);
            ((JSONObject)localObject).put("kandian_mode", ReadInJoyUtils.e());
            ((JSONObject)localObject).put("feeds_type", "" + ReadInJoyUtils.a(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
            localObject = ((JSONObject)localObject).toString();
            PublicAccountReportUtils.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", ReadInJoyUtils.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
          }
          while (!(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a instanceof PluginBaseActivity))
          {
            return;
            if (!(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a instanceof PluginBaseActivity)) {
              break;
            }
            QQToast.a(this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a, -1, this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a.getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Mgt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a).g());
            break;
          }
          ((JSONObject)localObject).put("folder_status", 1);
          ReportController.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgv
 * JD-Core Version:    0.7.0.1
 */