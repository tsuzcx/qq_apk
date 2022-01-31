import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class nyo
  implements BusinessObserver
{
  nyo(nym paramnym, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
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
          break label209;
        }
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        i = localWebSsoResponseBody.ret.get();
        paramBundle = localWebSsoResponseBody.data.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike ret=" + paramBundle);
        }
        if (i != 0) {
          break label209;
        }
        paramBundle.printStackTrace();
      }
      catch (Exception paramBundle)
      {
        try
        {
          nym.a(this.jdField_a_of_type_Nym).a(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, this.jdField_a_of_type_Int, this.b);
          i = paramInt;
          if (i == 0) {
            nym.a(this.jdField_a_of_type_Nym).a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, this.jdField_a_of_type_Int, this.b);
          }
          return;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            int i;
            paramInt = 1;
          }
        }
        paramBundle = paramBundle;
        paramInt = 0;
      }
      i = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyCommentSSOModule", 2, "fetchCommentList error info:" + paramBundle.getLocalizedMessage());
        i = paramInt;
        continue;
        label209:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nyo
 * JD-Core Version:    0.7.0.1
 */