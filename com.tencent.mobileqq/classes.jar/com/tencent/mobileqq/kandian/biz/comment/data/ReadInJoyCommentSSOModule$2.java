package com.tencent.mobileqq.kandian.biz.comment.data;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ReadInJoyCommentSSOModule$2
  implements BusinessObserver
{
  ReadInJoyCommentSSOModule$2(ReadInJoyCommentSSOModule paramReadInJoyCommentSSOModule, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 1;
    int i = 1;
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label209;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("commentLike ret=");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.d("ReadInJoyCommentSSOModule", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt != 0) {
          break label209;
        }
        paramInt = j;
        try
        {
          if (ReadInJoyCommentSSOModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule) == null) {
            break label211;
          }
          ReadInJoyCommentSSOModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule).a(true, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData, this.jdField_a_of_type_Int, this.b);
          paramInt = j;
        }
        catch (Exception paramBundle) {}
        paramBundle.printStackTrace();
      }
      catch (Exception paramBundle)
      {
        i = 0;
      }
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break label211;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchCommentList error info:");
      ((StringBuilder)localObject).append(paramBundle.getLocalizedMessage());
      QLog.d("ReadInJoyCommentSSOModule", 2, ((StringBuilder)localObject).toString());
      paramInt = i;
      break label211;
    }
    label209:
    paramInt = 0;
    label211:
    if ((paramInt == 0) && (ReadInJoyCommentSSOModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule) != null)) {
      ReadInJoyCommentSSOModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule).a(false, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentSSOModule.2
 * JD-Core Version:    0.7.0.1
 */