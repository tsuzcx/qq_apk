package com.tencent.mobileqq.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;

public class UECReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      if ("Success".equals(BaseApplicationImpl.sInjectResult)) {
        try
        {
          paramContext = UEC.a;
          if (paramContext != null)
          {
            paramContext.a(paramIntent.getParcelableArrayListExtra("UECData"));
            return;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UECReceiver
 * JD-Core Version:    0.7.0.1
 */