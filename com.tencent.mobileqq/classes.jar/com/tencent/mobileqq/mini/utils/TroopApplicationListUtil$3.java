package com.tencent.mobileqq.mini.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import bgyr;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class TroopApplicationListUtil$3
  extends Handler
{
  TroopApplicationListUtil$3(Looper paramLooper, String paramString1, String paramString2)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof bgyr))
    {
      paramMessage = (bgyr)paramMessage.obj;
      if (paramMessage.c == 0) {
        try
        {
          QLog.d("TroopApplicationListUtil", 1, new Object[] { "handleMessage cgiState.htmlBody: ", paramMessage.d });
          int i = new JSONObject(paramMessage.d).optInt("ec", -1);
          TroopApplicationListUtil.showToast(i);
          TroopApplicationListUtil.access$000(i, this.val$groupUin, this.val$appId);
          return;
        }
        catch (Exception paramMessage)
        {
          QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList exception ", paramMessage);
          return;
        }
      }
      QLog.d("TroopApplicationListUtil", 1, new Object[] { "handleMessage cgiState.resultCode: ", Integer.valueOf(paramMessage.c) });
      return;
    }
    QLog.e("TroopApplicationListUtil", 1, new Object[] { "handleMessage addMiniAppToTroopApplicationList ", " invalid msg.obj" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.3
 * JD-Core Version:    0.7.0.1
 */