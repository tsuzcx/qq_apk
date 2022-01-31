import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public final class lis
  implements Runnable
{
  public lis(ChannelCoverInfo paramChannelCoverInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = 1;
    str = "";
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("folder_status", ReadInJoyUtils.d);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null) {
          ((JSONObject)localObject).put("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId);
        }
        ((JSONObject)localObject).put("current_channel_id", 0);
        if (NetworkState.isWifiConn()) {
          i = 2;
        }
        ((JSONObject)localObject).put("network_type", i);
        if (this.jdField_a_of_type_Int != ChannelCoverView.jdField_a_of_type_Int) {
          continue;
        }
        ((JSONObject)localObject).put("channel_type", "2");
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mColumnType != 0)) {
          continue;
        }
        ((JSONObject)localObject).put("content_type", 1);
      }
      catch (Exception localException)
      {
        Object localObject = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ChannelCoverView", 2, "ERROR Exception=" + localException.getMessage());
        localObject = str;
        continue;
        ((JSONObject)localObject).put("content_type", 2);
        continue;
      }
      localObject = ((JSONObject)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "reportRecommendEvent T =" + this.jdField_a_of_type_JavaLangString + "; reportString = " + (String)localObject);
      }
      PublicAccountReportUtils.a(null, "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, "", "", "", (String)localObject, false);
      return;
      if (this.jdField_a_of_type_Int == ChannelCoverView.b) {
        ((JSONObject)localObject).put("channel_type", "1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lis
 * JD-Core Version:    0.7.0.1
 */