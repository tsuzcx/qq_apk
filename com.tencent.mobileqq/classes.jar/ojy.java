import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class ojy
  implements BusinessObserver
{
  ojy(oju paramoju, BaseCommentData paramBaseCommentData) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 1;
    String str = "";
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("data");
        if (arrayOfByte == null) {
          break label229;
        }
        paramBundle = new WebSsoBody.WebSsoResponseBody();
        try
        {
          paramBundle.mergeFrom(arrayOfByte);
          paramInt = paramBundle.ret.get();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyCommentSSOModule", 2, "commentReport ret=" + paramBundle.data.get());
          }
          if (paramInt == 0) {
            break label179;
          }
          try
          {
            paramBundle = new JSONObject(paramBundle.data.get()).optString("msg");
            paramInt = 0;
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            paramInt = 0;
            paramBundle = str;
            continue;
          }
          if ((paramInt == 0) && (oju.a(this.jdField_a_of_type_Oju) != null)) {
            oju.a(this.jdField_a_of_type_Oju).a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData, paramBundle);
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          continue;
        }
        paramBundle.printStackTrace();
      }
      catch (Exception paramBundle)
      {
        paramInt = 0;
      }
      for (;;)
      {
        for (;;)
        {
          paramBundle = str;
          break;
          label179:
          paramBundle = str;
          paramInt = i;
          try
          {
            if (oju.a(this.jdField_a_of_type_Oju) == null) {
              break;
            }
            oju.a(this.jdField_a_of_type_Oju).a(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData, "");
            paramBundle = str;
            paramInt = i;
          }
          catch (Exception paramBundle)
          {
            paramInt = 1;
          }
        }
      }
      label229:
      paramInt = 0;
      paramBundle = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ojy
 * JD-Core Version:    0.7.0.1
 */