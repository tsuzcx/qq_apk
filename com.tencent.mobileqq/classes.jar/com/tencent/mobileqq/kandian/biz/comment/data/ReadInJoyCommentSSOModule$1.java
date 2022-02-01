package com.tencent.mobileqq.kandian.biz.comment.data;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class ReadInJoyCommentSSOModule$1
  implements BusinessObserver
{
  ReadInJoyCommentSSOModule$1(ReadInJoyCommentSSOModule paramReadInJoyCommentSSOModule, BaseCommentData paramBaseCommentData) {}
  
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
          break label238;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("deleteComment ret=");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.d("ReadInJoyCommentSSOModule", 2, ((StringBuilder)localObject).toString());
        }
        paramBundle = new JSONObject(paramBundle);
        if (paramInt != 0)
        {
          paramBundle.optString("msg");
          break label238;
        }
        paramInt = paramBundle.optInt("ret");
        if (paramInt != 0) {
          break label238;
        }
        paramInt = j;
        try
        {
          if (ReadInJoyCommentSSOModule.a(this.b) == null) {
            break label240;
          }
          ReadInJoyCommentSSOModule.a(this.b).a(true, this.a, "");
          paramInt = j;
        }
        catch (Exception paramBundle) {}
        paramBundle.getLocalizedMessage();
      }
      catch (Exception paramBundle)
      {
        i = 0;
      }
      paramBundle.printStackTrace();
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break label240;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchCommentList error info:");
      ((StringBuilder)localObject).append(paramBundle.getLocalizedMessage());
      QLog.d("ReadInJoyCommentSSOModule", 2, ((StringBuilder)localObject).toString());
      paramInt = i;
      break label240;
    }
    label238:
    paramInt = 0;
    label240:
    if ((paramInt == 0) && (ReadInJoyCommentSSOModule.a(this.b) != null)) {
      ReadInJoyCommentSSOModule.a(this.b).a(false, this.a, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentSSOModule.1
 * JD-Core Version:    0.7.0.1
 */