import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.5;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class qzj
  implements bcgo
{
  public qzj(ReadInJoyWebDataManager.5 param5) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null)
    {
      this.a.this$0.a(this.a.b, Integer.toString(qzi.b));
      try
      {
        if ((this.a.jdField_a_of_type_Qzn != null) && ((this.a.jdField_a_of_type_Qzn instanceof qzn))) {
          this.a.jdField_a_of_type_Qzn.a(paramJSONObject);
        }
        paramBundle = paramJSONObject.toString();
        qzi.a(this.a.this$0, this.a.b, paramBundle);
        if (this.a.jdField_a_of_type_OrgJsonJSONObject != null)
        {
          this.a.jdField_a_of_type_OrgJsonJSONObject.put("data", paramBundle);
          this.a.this$0.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_OrgJsonJSONObject.toString(), "", this.a.jdField_a_of_type_OrgJsonJSONObject);
        }
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
      this.a.this$0.a(this.a.b, Integer.toString(qzi.a));
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:return result null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qzj
 * JD-Core Version:    0.7.0.1
 */