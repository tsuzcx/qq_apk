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

class nyq
  implements BusinessObserver
{
  nyq(nym paramnym, BaseCommentData paramBaseCommentData) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramInt = 1;
    String str = "";
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("data");
        if (arrayOfByte == null) {
          break label201;
        }
        paramBundle = new WebSsoBody.WebSsoResponseBody();
        try
        {
          paramBundle.mergeFrom(arrayOfByte);
          int i = paramBundle.ret.get();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyCommentSSOModule", 2, "commentReport ret=" + paramBundle.data.get());
          }
          if (i == 0) {
            break label170;
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
          if (paramInt == 0) {
            nym.a(this.jdField_a_of_type_Nym).a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData, paramBundle);
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
          try
          {
            label170:
            nym.a(this.jdField_a_of_type_Nym).a(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData, "");
            paramBundle = str;
          }
          catch (Exception paramBundle)
          {
            paramInt = 1;
          }
        }
      }
      label201:
      paramInt = 0;
      paramBundle = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nyq
 * JD-Core Version:    0.7.0.1
 */