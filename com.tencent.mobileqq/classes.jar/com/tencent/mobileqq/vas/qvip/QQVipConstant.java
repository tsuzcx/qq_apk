package com.tencent.mobileqq.vas.qvip;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQVipConstant
{
  public static String a(MessageRecord paramMessageRecord)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      Object localObject = paramMessageRecord.extStr;
      paramMessageRecord = str2;
      str1 = str2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = str2;
        localObject = new JSONObject((String)localObject);
        str1 = str2;
        str2 = ((JSONObject)localObject).optString("public_account_msg_id", "");
        paramMessageRecord = str2;
        str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          paramMessageRecord = ((JSONObject)localObject).optString("pa_msgId", "");
        }
      }
      return paramMessageRecord;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("QQVipConstant", 1, "getPAMsgId error =" + paramMessageRecord.toString());
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.QQVipConstant
 * JD-Core Version:    0.7.0.1
 */