package com.tencent.mobileqq.qqexpand.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendLimitChatManager$3
  implements DialogInterface.OnClickListener
{
  ExtendFriendLimitChatManager$3(ExtendFriendLimitChatManager paramExtendFriendLimitChatManager, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      try
      {
        paramDialogInterface = new Intent(paramDialogInterface, QQBrowserActivity.class);
        paramDialogInterface.putExtra("url", ExtendFriendLimitChatManager.c(this.b));
        this.a.startActivity(paramDialogInterface);
        if (QLog.isColorLevel())
        {
          paramDialogInterface = new StringBuilder();
          paramDialogInterface.append("showRealNameAuthDialog click confirm ");
          paramDialogInterface.append(ExtendFriendLimitChatManager.c(this.b));
          QLog.i("ExtendFriendLimitChatManager", 2, paramDialogInterface.toString());
          return;
        }
      }
      catch (Exception paramDialogInterface)
      {
        QLog.w("ExtendFriendLimitChatManager", 1, "", paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager.3
 * JD-Core Version:    0.7.0.1
 */