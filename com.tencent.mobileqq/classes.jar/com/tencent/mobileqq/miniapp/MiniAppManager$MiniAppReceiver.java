package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class MiniAppManager$MiniAppReceiver
  extends QQUIEventReceiver<MiniAppManager, MiniAppEvent>
{
  public MiniAppManager$MiniAppReceiver(@NonNull MiniAppManager paramMiniAppManager)
  {
    super(paramMiniAppManager);
  }
  
  public void a(@NonNull MiniAppManager paramMiniAppManager, @NonNull MiniAppEvent paramMiniAppEvent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive event:");
      ((StringBuilder)localObject).append(paramMiniAppEvent.toString());
      QLog.d("MiniAppManager", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramMiniAppEvent.c;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if (!paramMiniAppEvent.b) {
            MiniAppManager.a(paramMiniAppManager, paramMiniAppEvent.a.a, paramMiniAppEvent.a.b, 1004);
          }
        }
        else
        {
          MiniAppManager.a(paramMiniAppManager, MiniAppInfo.a((String)paramMiniAppEvent.e[0], ((Integer)paramMiniAppEvent.e[1]).intValue()));
        }
      }
      else {
        MiniAppManager.a(paramMiniAppManager, (MiniAppActivity)paramMiniAppEvent.e[0], (String)paramMiniAppEvent.e[1], ((Integer)paramMiniAppEvent.e[2]).intValue(), (MiniAppOptions)paramMiniAppEvent.e[3]);
      }
    }
    else if (("MiniAppLauncher".equals(paramMiniAppEvent.d)) && (IDownloader.a((String)paramMiniAppEvent.e[0]) == 1) && (((Integer)paramMiniAppEvent.e[2]).intValue() != 2))
    {
      localObject = (String)paramMiniAppEvent.e[1];
      if (paramMiniAppEvent.b)
      {
        QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131904706), 0).show();
        MiniAppInfo localMiniAppInfo = MiniAppManager.c(paramMiniAppManager).a((String)localObject, 2, 0, false);
        if (localMiniAppInfo != null)
        {
          localMiniAppInfo.q.putString("unzipped_path", (String)paramMiniAppEvent.e[3]);
          MiniAppManager.b(paramMiniAppManager, (IApp)MiniAppManager.b(paramMiniAppManager).get(localMiniAppInfo.p));
          return;
        }
      }
      paramMiniAppEvent = MiniAppInfo.a((String)localObject);
      MiniAppManager.a(paramMiniAppManager, paramMiniAppEvent[1], Integer.parseInt(paramMiniAppEvent[0]), 1003);
    }
  }
  
  public Class acceptEventClass()
  {
    return MiniAppEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppManager.MiniAppReceiver
 * JD-Core Version:    0.7.0.1
 */