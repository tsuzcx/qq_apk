package com.tencent.mobileqq.vas.qvip;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQVipConstant
{
  public static String a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = "";
    try
    {
      Object localObject2 = paramMessageRecord.extStr;
      paramMessageRecord = (MessageRecord)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return paramMessageRecord;
      }
      localObject2 = new JSONObject((String)localObject2);
      paramMessageRecord = ((JSONObject)localObject2).optString("public_account_msg_id", "");
      try
      {
        if (TextUtils.isEmpty(paramMessageRecord))
        {
          localObject1 = ((JSONObject)localObject2).optString("pa_msgId", "");
          return localObject1;
        }
        return paramMessageRecord;
      }
      catch (Throwable localThrowable1) {}
      localObject1 = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      paramMessageRecord = (MessageRecord)localObject1;
    }
    ((StringBuilder)localObject1).append("getPAMsgId error =");
    ((StringBuilder)localObject1).append(localThrowable2.toString());
    QLog.e("QQVipConstant", 1, ((StringBuilder)localObject1).toString());
    return paramMessageRecord;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.QQVipConstant
 * JD-Core Version:    0.7.0.1
 */