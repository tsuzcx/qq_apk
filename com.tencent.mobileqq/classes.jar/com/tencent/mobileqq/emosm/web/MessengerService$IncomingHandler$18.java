package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MessengerService$IncomingHandler$18
  implements MiniAppLaunchListener
{
  MessengerService$IncomingHandler$18(MessengerService.IncomingHandler paramIncomingHandler, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", paramBundle.getLong("retCode", 0L));
        if (!paramBoolean) {
          localJSONObject.put("msg", paramBundle.getString("errMsg"));
        }
        localBundle.putString("result", localJSONObject.toString());
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e("launchMiniAppById", 1, "launchMiniAppById error,", paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.18
 * JD-Core Version:    0.7.0.1
 */