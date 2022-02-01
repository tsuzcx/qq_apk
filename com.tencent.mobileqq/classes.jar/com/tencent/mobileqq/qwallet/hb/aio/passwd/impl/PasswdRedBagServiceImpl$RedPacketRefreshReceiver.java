package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.qphone.base.util.QLog;

class PasswdRedBagServiceImpl$RedPacketRefreshReceiver
  extends BroadcastReceiver
{
  private PasswdRedBagServiceImpl$RedPacketRefreshReceiver(PasswdRedBagServiceImpl paramPasswdRedBagServiceImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("grap_idiom_hb_result_action".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("grap_hb_state", 0);
      paramContext = paramIntent.getStringExtra("listid");
      String str1 = paramIntent.getStringExtra("grap_hb_frienduin");
      String str2 = paramIntent.getStringExtra("grap_hb_idiom");
      int j = paramIntent.getIntExtra("grap_hb_seq", 0);
      String str3 = paramIntent.getStringExtra("grap_idiom_alpha");
      paramIntent = paramIntent.getStringExtra("grap_poem_rule");
      PasswdRedBagInfo localPasswdRedBagInfo = this.a.getPasswdRedBagInfoById(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("grapHbState=");
      localStringBuilder.append(i);
      localStringBuilder.append(",passwdRedBagInfo=");
      localStringBuilder.append(localPasswdRedBagInfo);
      QLog.i("PasswdRedBagSgervice", 1, localStringBuilder.toString());
      if ((i != 1) && (i != 10))
      {
        if (i == 12)
        {
          if (localPasswdRedBagInfo == null) {
            return;
          }
          PasswdRedBagServiceImpl.access$000(this.a, paramContext, str1, 1, false);
          this.a.setPasswdRedBagLastedWord(paramContext, str2, str3, j, paramIntent);
          return;
        }
        if (i == 0)
        {
          if (localPasswdRedBagInfo.b() == 2) {
            PasswdRedBagServiceImpl.access$000(this.a, paramContext, str1, 1, true);
          }
        }
        else if (i == 14)
        {
          if (localPasswdRedBagInfo == null) {
            return;
          }
          this.a.setPasswdRedBagLastedWord(paramContext, str2, str3, j, paramIntent);
        }
      }
      else
      {
        PasswdRedBagServiceImpl.access$000(this.a, paramContext, str1, 1, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.RedPacketRefreshReceiver
 * JD-Core Version:    0.7.0.1
 */