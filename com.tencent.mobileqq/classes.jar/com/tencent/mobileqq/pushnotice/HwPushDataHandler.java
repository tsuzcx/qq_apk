package com.tencent.mobileqq.pushnotice;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class HwPushDataHandler
  implements IThirdPushDataHandler
{
  public boolean a(Intent paramIntent)
  {
    return PushNoticeUtil.a(paramIntent);
  }
  
  public ThirdPushNotifyManager.PushNotificationData b(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("third_id");
    String str2 = paramIntent.getStringExtra("type");
    String str3 = paramIntent.getStringExtra("url");
    String str4 = paramIntent.getStringExtra("report_data");
    String str5 = paramIntent.getStringExtra("token");
    paramIntent = paramIntent.getStringExtra("to_uin");
    if (TextUtils.isEmpty(str1))
    {
      QLog.i("HwPushDataHandler", 1, "handlePushJumpIntent: thirdId is empty.");
      return null;
    }
    try
    {
      int j = Integer.parseInt(str1);
      int i;
      if (TextUtils.isEmpty(str2)) {
        i = -1;
      } else {
        i = Integer.parseInt(str2);
      }
      return new ThirdPushNotifyManager.PushNotificationData(j, i, str3, str4, str5, paramIntent);
    }
    catch (NumberFormatException paramIntent)
    {
      QLog.e("HwPushDataHandler", 1, "handlePushJumpIntent: exception.", paramIntent);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.HwPushDataHandler
 * JD-Core Version:    0.7.0.1
 */