import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ook
  implements BusinessObserver
{
  ook(ooi paramooi, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
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
          break label234;
        }
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        paramInt = localWebSsoResponseBody.ret.get();
        paramBundle = localWebSsoResponseBody.data.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike ret=" + paramBundle);
        }
        if (paramInt != 0) {
          break label234;
        }
        paramInt = i;
        paramBundle.printStackTrace();
      }
      catch (Exception paramBundle)
      {
        try
        {
          if (ooi.a(this.jdField_a_of_type_Ooi) != null)
          {
            ooi.a(this.jdField_a_of_type_Ooi).a(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, this.jdField_a_of_type_Int, this.b);
            paramInt = i;
          }
          i = paramInt;
          if ((i == 0) && (ooi.a(this.jdField_a_of_type_Ooi) != null)) {
            ooi.a(this.jdField_a_of_type_Ooi).a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, this.jdField_a_of_type_Int, this.b);
          }
          return;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
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
        label234:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ook
 * JD-Core Version:    0.7.0.1
 */