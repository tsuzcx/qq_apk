import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class mdl
  implements HttpWebCgiAsyncTask.Callback
{
  mdl(mdk parammdk) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager.a(this.a.b, Integer.toString(ReadInJoyWebDataManager.b));
      try
      {
        if ((this.a.jdField_a_of_type_Mdp != null) && ((this.a.jdField_a_of_type_Mdp instanceof mdp))) {
          this.a.jdField_a_of_type_Mdp.a(paramJSONObject);
        }
        paramBundle = paramJSONObject.toString();
        ReadInJoyWebDataManager.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager, this.a.b, paramBundle);
        this.a.jdField_a_of_type_OrgJsonJSONObject.put("data", paramBundle);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_OrgJsonJSONObject.toString(), "", this.a.jdField_a_of_type_OrgJsonJSONObject);
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:storeParams putData JSONException :" + paramBundle);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:return result :" + paramJSONObject);
      }
    }
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager.a(this.a.b, Integer.toString(ReadInJoyWebDataManager.a));
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:return result null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdl
 * JD-Core Version:    0.7.0.1
 */