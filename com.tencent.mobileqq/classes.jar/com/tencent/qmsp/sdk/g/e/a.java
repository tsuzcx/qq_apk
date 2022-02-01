package com.tencent.qmsp.sdk.g.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

public class a
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null))
    {
      int j = 0;
      int i = paramIntent.getIntExtra("openIdNotifyFlag", 0);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shouldUpdateId, notifyFlag : ");
      ((StringBuilder)localObject).append(i);
      c.b(((StringBuilder)localObject).toString());
      if (i != 1)
      {
        boolean bool;
        if (i == 2)
        {
          localObject = paramIntent.getStringArrayListExtra("openIdPackageList");
          if (localObject == null) {
            return;
          }
          bool = ((ArrayList)localObject).contains(paramContext.getPackageName());
          if (bool)
          {
            paramContext = paramIntent.getStringExtra("openIdType");
            paramContext = c.a().a(paramContext);
            if (paramContext != null) {
              paramContext.b();
            }
            return;
          }
        }
        else
        {
          bool = true;
        }
        j = bool;
        if (i == 0)
        {
          j = bool;
          if (bool)
          {
            paramContext = paramIntent.getStringExtra("openIdType");
            paramContext = c.a().a(paramContext);
            if (paramContext != null) {
              paramContext.b();
            }
          }
        }
      }
      else if (TextUtils.equals(paramIntent.getStringExtra("openIdPackage"), paramContext.getPackageName()))
      {
        j = 1;
      }
      if (j != 0)
      {
        paramContext = paramIntent.getStringExtra("openIdType");
        paramContext = c.a().a(paramContext);
        if (paramContext != null) {
          paramContext.b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.e.a
 * JD-Core Version:    0.7.0.1
 */