import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class ooj
  implements BusinessObserver
{
  ooj(ooi paramooi, BaseCommentData paramBaseCommentData) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 1;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label249;
        }
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        paramInt = localWebSsoResponseBody.ret.get();
        paramBundle = localWebSsoResponseBody.data.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "deleteComment ret=" + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (paramInt != 0)
        {
          paramBundle.optString("msg");
          paramInt = 0;
          i = paramInt;
          if ((i == 0) && (ooi.a(this.jdField_a_of_type_Ooi) != null)) {
            ooi.a(this.jdField_a_of_type_Ooi).a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData);
          }
          return;
        }
        paramInt = paramBundle.optInt("ret");
        if (paramInt != 0) {
          break label249;
        }
        paramInt = i;
        try
        {
          if (ooi.a(this.jdField_a_of_type_Ooi) == null) {
            continue;
          }
          ooi.a(this.jdField_a_of_type_Ooi).a(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData);
          paramInt = i;
        }
        catch (Exception paramBundle)
        {
          paramInt = 1;
        }
      }
      catch (Exception paramBundle)
      {
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
        label249:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ooj
 * JD-Core Version:    0.7.0.1
 */