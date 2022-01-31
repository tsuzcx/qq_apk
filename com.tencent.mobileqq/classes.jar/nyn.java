import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class nyn
  implements BusinessObserver
{
  nyn(nym paramnym, BaseCommentData paramBaseCommentData) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramInt = 1;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label226;
        }
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        i = localWebSsoResponseBody.ret.get();
        paramBundle = localWebSsoResponseBody.data.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "deleteComment ret=" + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (i != 0)
        {
          paramBundle.optString("msg");
          paramInt = 0;
          i = paramInt;
          if (i == 0) {
            nym.a(this.jdField_a_of_type_Nym).a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData);
          }
          return;
        }
        i = paramBundle.optInt("ret");
        if (i != 0) {
          break label226;
        }
        try
        {
          nym.a(this.jdField_a_of_type_Nym).a(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData);
        }
        catch (Exception paramBundle)
        {
          paramInt = 1;
        }
      }
      catch (Exception paramBundle)
      {
        int i;
        paramInt = 0;
        continue;
      }
      paramBundle.getLocalizedMessage();
      paramBundle.printStackTrace();
      i = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyCommentSSOModule", 2, "fetchCommentList error info:" + paramBundle.getLocalizedMessage());
        i = paramInt;
        continue;
        label226:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nyn
 * JD-Core Version:    0.7.0.1
 */