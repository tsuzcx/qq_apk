package com.tencent.mobileqq.emosm.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;

class MessengerService$IncomingHandler$19
  extends IPublicAccountObserver.OnCallback
{
  MessengerService$IncomingHandler$19(MessengerService.IncomingHandler paramIncomingHandler, Bundle paramBundle, MessengerService paramMessengerService, boolean paramBoolean) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    for (;;)
    {
      try
      {
        localObject = new Bundle();
        if (paramBoolean)
        {
          i = 1;
          ((Bundle)localObject).putInt("retCode", i);
          this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject);
          this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW success! isFollow: ");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
            ((StringBuilder)localObject).append("  uin: ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("MessengerService$IncomingHandler", 2, ((StringBuilder)localObject).toString());
          }
          localObject = new Intent("com.tencent.mobileqq.PublicAccountObserver");
          ((Intent)localObject).putExtra("action", "follow");
          ((Intent)localObject).putExtra("isSuccess", paramBoolean);
          ((Intent)localObject).putExtra("uin", paramString);
          this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.getApplicationContext().sendBroadcast((Intent)localObject);
          SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(1, paramString));
          return;
        }
      }
      catch (Throwable paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! ");
        ((StringBuilder)localObject).append(QLog.getStackTraceString(paramString));
        QLog.e("MessengerService$IncomingHandler", 2, ((StringBuilder)localObject).toString());
        return;
      }
      int i = 0;
    }
  }
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onUnfollowPublicAccount(paramBoolean, paramString);
    for (;;)
    {
      try
      {
        localObject = new Bundle();
        if (paramBoolean)
        {
          i = 1;
          ((Bundle)localObject).putInt("retCode", i);
          this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject);
          this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! isFollow: ");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
            ((StringBuilder)localObject).append("  uin: ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("MessengerService$IncomingHandler", 2, ((StringBuilder)localObject).toString());
          }
          localObject = new Intent("com.tencent.mobileqq.PublicAccountObserver");
          ((Intent)localObject).putExtra("action", "unFollow");
          ((Intent)localObject).putExtra("isSuccess", paramBoolean);
          ((Intent)localObject).putExtra("uin", paramString);
          this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.getApplicationContext().sendBroadcast((Intent)localObject);
          SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(0, paramString));
          return;
        }
      }
      catch (Throwable paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! ");
        ((StringBuilder)localObject).append(QLog.getStackTraceString(paramString));
        QLog.e("MessengerService$IncomingHandler", 2, ((StringBuilder)localObject).toString());
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.19
 * JD-Core Version:    0.7.0.1
 */