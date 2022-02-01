package com.tencent.tmdownloader.internal.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tmassistantbase.util.ab;
import java.util.ArrayList;

class a
  implements Runnable
{
  a(MobileQQCloseServiceReceiver paramMobileQQCloseServiceReceiver, Context paramContext, Intent paramIntent) {}
  
  public void run()
  {
    int k = 0;
    String str1;
    if ((this.a != null) && (this.b != null))
    {
      str1 = this.b.getAction();
      if (!TextUtils.isEmpty(str1)) {}
    }
    else
    {
      return;
      break label123;
    }
    label33:
    ArrayList localArrayList;
    String str2;
    int i;
    for (;;)
    {
      if ((str1.equals("com.tencent.process.exit")) || (str1.equals("com.tencent.process.tmdownloader.exit"))) {
        if (this.b.getExtras() != null)
        {
          localArrayList = this.b.getExtras().getStringArrayList("procNameList");
          str2 = this.b.getExtras().getString("verify");
          if ((str2 == null) || (str2.length() == 0)) {
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      int m;
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        m = 1;
        label123:
        if ((i == 0) || (m == 0)) {
          break label33;
        }
        MobileQQCloseServiceReceiver.a(this.c, this.a);
        return;
        if ((!str2.equals(MobileQQCloseServiceReceiver.a(this.c, localArrayList, str1, false))) && (!str2.equals(MobileQQCloseServiceReceiver.a(this.c, localArrayList, str1, true)))) {
          break label349;
        }
        i = 1;
        continue;
      }
      str1 = this.c.c(this.a);
      int j = 0;
      for (;;)
      {
        m = j;
        if (k >= localArrayList.size()) {
          break;
        }
        if (str1.equals(localArrayList.get(k))) {
          j = 1;
        }
        k += 1;
      }
      if ((!str1.equals("mqq.intent.action.ACCOUNT_EXPIRED")) && (!str1.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!str1.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!str1.equals("mqq.intent.action.LOGOUT")) && (!str1.equals("mqq.intent.action.EXIT" + this.a.getPackageName()))) {
        break label33;
      }
      ab.c("MQQCloseServiceReceiver", "action : " + str1);
      MobileQQCloseServiceReceiver.a(this.c, this.a);
      return;
      label349:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.a
 * JD-Core Version:    0.7.0.1
 */