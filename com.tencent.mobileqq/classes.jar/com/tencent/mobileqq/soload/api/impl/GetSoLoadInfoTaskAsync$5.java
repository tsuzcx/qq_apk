package com.tencent.mobileqq.soload.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class GetSoLoadInfoTaskAsync$5
  extends BroadcastReceiver
{
  public void onReceive(Context arg1, Intent paramIntent)
  {
    synchronized ()
    {
      if (GetSoLoadInfoTaskAsync.d().size() > 0)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onReceive] action:");
        ((StringBuilder)localObject).append(paramIntent.getAction());
        ((StringBuilder)localObject).append(",LOADING_SO_NAMES:");
        ((StringBuilder)localObject).append(GetSoLoadInfoTaskAsync.d());
        ((StringBuilder)localObject).append(",LOADING_SO_TIMES:");
        ((StringBuilder)localObject).append(GetSoLoadInfoTaskAsync.e());
        QLog.i("SoLoadWidget.GetSoTaskAsync", 1, ((StringBuilder)localObject).toString());
        paramIntent = GetSoLoadInfoTaskAsync.d().values().iterator();
        while (paramIntent.hasNext())
        {
          localObject = ((List)paramIntent.next()).iterator();
          while (((Iterator)localObject).hasNext())
          {
            OnGetSoLoadInfoListener localOnGetSoLoadInfoListener = (OnGetSoLoadInfoListener)((Iterator)localObject).next();
            SoLoadInfo localSoLoadInfo = new SoLoadInfo();
            localSoLoadInfo.curCode = 13;
            localOnGetSoLoadInfoListener.onGetLoadInfo(localSoLoadInfo);
          }
        }
        GetSoLoadInfoTaskAsync.d().clear();
        GetSoLoadInfoTaskAsync.e().clear();
      }
      return;
    }
    for (;;)
    {
      throw paramIntent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskAsync.5
 * JD-Core Version:    0.7.0.1
 */