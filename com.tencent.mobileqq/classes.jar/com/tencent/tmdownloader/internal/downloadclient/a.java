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
    if (this.a != null)
    {
      Object localObject1 = this.b;
      if (localObject1 != null)
      {
        localObject1 = ((Intent)localObject1).getAction();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        Object localObject2;
        if ((!((String)localObject1).equals("com.tencent.process.exit")) && (!((String)localObject1).equals("com.tencent.process.tmdownloader.exit")))
        {
          if ((!((String)localObject1).equals("mqq.intent.action.ACCOUNT_EXPIRED")) && (!((String)localObject1).equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!((String)localObject1).equals("mqq.intent.action.ACCOUNT_KICKED")) && (!((String)localObject1).equals("mqq.intent.action.LOGOUT")))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("mqq.intent.action.EXIT");
            ((StringBuilder)localObject2).append(this.a.getPackageName());
            if (!((String)localObject1).equals(((StringBuilder)localObject2).toString())) {}
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("action : ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ab.c("MQQCloseServiceReceiver", ((StringBuilder)localObject2).toString());
            MobileQQCloseServiceReceiver.a(this.c, this.a);
          }
        }
        else
        {
          if (this.b.getExtras() == null) {
            return;
          }
          localObject2 = this.b.getExtras().getStringArrayList("procNameList");
          String str = this.b.getExtras().getString("verify");
          int m = 1;
          int k = 0;
          int j;
          if ((str != null) && (str.length() != 0) && ((str.equals(MobileQQCloseServiceReceiver.a(this.c, (ArrayList)localObject2, (String)localObject1, false))) || (str.equals(MobileQQCloseServiceReceiver.a(this.c, (ArrayList)localObject2, (String)localObject1, true))))) {
            j = 1;
          } else {
            j = 0;
          }
          int i = m;
          if (localObject2 != null) {
            if (((ArrayList)localObject2).size() == 0)
            {
              i = m;
            }
            else
            {
              localObject1 = this.c.c(this.a);
              i = 0;
              while (k < ((ArrayList)localObject2).size())
              {
                if (((String)localObject1).equals(((ArrayList)localObject2).get(k))) {
                  i = 1;
                }
                k += 1;
              }
            }
          }
          if ((j != 0) && (i != 0)) {
            MobileQQCloseServiceReceiver.a(this.c, this.a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.a
 * JD-Core Version:    0.7.0.1
 */