package com.tencent.turingfd.sdk.xq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

public class new
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    if ((paramContext == null) || (paramIntent == null)) {}
    label131:
    for (;;)
    {
      return;
      int i = paramIntent.getIntExtra("openIdNotifyFlag", 0);
      new StringBuilder().append("shouldUpdateId, notifyFlag : ").append(i).toString();
      if (i == 1) {
        if (!TextUtils.equals(paramIntent.getStringExtra("openIdPackage"), paramContext.getPackageName())) {
          break label127;
        }
      }
      for (;;)
      {
        if (!bool) {
          break label131;
        }
        paramContext = paramIntent.getStringExtra("openIdType");
        paramContext = try.d().d(paramContext);
        if (paramContext == null) {
          break;
        }
        paramContext.i = 0L;
        return;
        if (i == 2)
        {
          ArrayList localArrayList = paramIntent.getStringArrayListExtra("openIdPackageList");
          if (localArrayList != null) {
            bool = localArrayList.contains(paramContext.getPackageName());
          }
        }
        else
        {
          if (i == 0) {
            continue;
          }
        }
        label127:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.new
 * JD-Core Version:    0.7.0.1
 */