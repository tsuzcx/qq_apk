import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class lsa
  implements BusinessObserver
{
  public lsa(AdvertisementInfoModule paramAdvertisementInfoModule, AdvertisementInfo paramAdvertisementInfo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "type = " + paramInt + " is success:" + paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      WebSsoBody.WebSsoResponseBody localWebSsoResponseBody;
      if (paramBundle != null)
      {
        localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        if (!localWebSsoResponseBody.ret.has()) {
          break label253;
        }
      }
      label253:
      for (paramInt = localWebSsoResponseBody.ret.get();; paramInt = -1)
      {
        if (paramInt == 0)
        {
          paramBundle = localWebSsoResponseBody.data.get();
          if (QLog.isColorLevel()) {
            QLog.d("AdvertisementInfoModule", 2, "back json " + paramBundle);
          }
          paramBundle = new JSONObject(paramBundle);
          paramInt = i;
          if (paramBundle.has("ret")) {
            paramInt = paramBundle.getInt("ret");
          }
          if (paramInt == 0)
          {
            paramBundle = paramBundle.optJSONArray("data");
            if ((paramBundle != null) && (paramBundle.length() > 0))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAppJson = paramBundle.getJSONObject(0).toString();
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementInfoModule", 2, "back  data json " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAppJson);
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAdvertisementInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
            }
          }
        }
        return;
      }
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsa
 * JD-Core Version:    0.7.0.1
 */