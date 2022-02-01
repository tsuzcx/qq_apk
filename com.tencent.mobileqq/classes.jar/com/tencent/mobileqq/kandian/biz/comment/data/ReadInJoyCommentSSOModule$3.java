package com.tencent.mobileqq.kandian.biz.comment.data;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyCommentSSOModule$3
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str2 = "";
    String str1 = str2;
    Object localObject;
    if (paramBoolean)
    {
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("data");
        str1 = str2;
        if (arrayOfByte == null) {
          break label207;
        }
        paramBundle = new WebSsoBody.WebSsoResponseBody();
        try
        {
          paramBundle.mergeFrom(arrayOfByte);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        paramInt = paramBundle.ret.get();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("commentReport ret=");
          ((StringBuilder)localObject).append(paramBundle.data.get());
          QLog.d("ReadInJoyCommentSSOModule", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt != 0) {
          try
          {
            localObject = new JSONObject(paramBundle.data.get()).optString("msg");
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            localObject = str2;
          }
        }
        try
        {
          if (ReadInJoyCommentSSOModule.a(this.b) != null) {
            ReadInJoyCommentSSOModule.a(this.b).b(true, this.a, "");
          }
          paramInt = 1;
          localObject = str2;
        }
        catch (Exception paramBundle)
        {
          paramInt = 1;
        }
        paramBundle.printStackTrace();
      }
      catch (Exception paramBundle)
      {
        paramInt = 0;
      }
      localObject = str2;
      break label209;
    }
    label207:
    paramInt = 0;
    label209:
    if ((paramInt == 0) && (ReadInJoyCommentSSOModule.a(this.b) != null)) {
      ReadInJoyCommentSSOModule.a(this.b).b(false, this.a, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentSSOModule.3
 * JD-Core Version:    0.7.0.1
 */