package com.tencent.mobileqq.qassistant.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qassistant.api.IQAssistantTempApi;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qroute.QRoute;

public class VoiceAssistantReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      if (!WakeManager.a().b())
      {
        AssistantUtils.b("VoiceAssistantReceiver not allow");
        return;
      }
      Object localObject = (IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class);
      paramContext = paramIntent.getAction();
      paramIntent = ((IQAssistantTempApi)localObject).getIpcConstants_ACTION_VOICE_RECORD_OFF();
      localObject = ((IQAssistantTempApi)localObject).getIpcConstants_ACTION_VOICE_RECORD_ON();
      if ((!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) && (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) && (!"com.tencent.mobileqq.action.ae.OPEN_CAMERA".equals(paramContext)) && (!paramIntent.equals(paramContext)))
      {
        if ((!"mqq.intent.action.QQ_FOREGROUND".equals(paramContext)) && (!"tencent.av.v2q.StopVideoChat".equals(paramContext)) && (!"com.tencent.mobileqq.action.ae.CLOSE_CAMERA".equals(paramContext)) && (!((String)localObject).equals(paramContext)))
        {
          if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramContext)) {
            WakeManager.a().b(paramContext);
          }
        }
        else
        {
          if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext)) {
            WakeManager.a().f = false;
          }
          if (("tencent.av.v2q.StopVideoChat".equals(paramContext)) || ("com.tencent.mobileqq.action.ae.CLOSE_CAMERA".equals(paramContext))) {
            WakeManager.a().g = false;
          }
          if (((String)localObject).equals(paramContext)) {
            WakeManager.a().h = false;
          }
          WakeManager.a().a(paramContext);
        }
      }
      else
      {
        AssistantUtils.a("HelloQQWake", "releaseQQWake()");
        if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
          WakeManager.a().f = true;
        }
        if (("tencent.av.v2q.StartVideoChat".equals(paramContext)) || ("com.tencent.mobileqq.action.ae.OPEN_CAMERA".equals(paramContext))) {
          WakeManager.a().g = true;
        }
        if (paramIntent.equals(paramContext)) {
          WakeManager.a().h = true;
        }
        paramIntent = AssistantUtils.a();
        if ((paramIntent != null) && (paramIntent.isVoicePanelShow())) {
          paramIntent.quitePanel(false);
        }
        WakeManager.a().b(paramContext);
        if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
          WakeManager.a().a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceAssistantReceiver
 * JD-Core Version:    0.7.0.1
 */