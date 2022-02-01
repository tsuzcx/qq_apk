package com.tencent.mobileqq.qassistant.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.qphone.base.util.QLog;

class VoiceAssistantManager$VoiceAssistantReceiver
  extends BroadcastReceiver
{
  private VoiceAssistantManager$VoiceAssistantReceiver(VoiceAssistantManager paramVoiceAssistantManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (WakeManager.a().b()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VoiceAssistantManager", 2, "VoiceAssistantReceiver not allow");
        return;
        paramContext = paramIntent.getAction();
        if ((!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) && (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) && (!"com.tencent.mobileqq.action.ae.OPEN_CAMERA".equals(paramContext)) && (!"tencent.avgame.notify.voice.record.off".equals(paramContext))) {
          break;
        }
        AssistantUtils.a("HelloQQWake", "releaseQQWake()");
        if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
          WakeManager.a().f = true;
        }
        if (("tencent.av.v2q.StartVideoChat".equals(paramContext)) || ("com.tencent.mobileqq.action.ae.OPEN_CAMERA".equals(paramContext))) {
          WakeManager.a().g = true;
        }
        if ("tencent.avgame.notify.voice.record.off".equals(paramContext)) {
          WakeManager.a().h = true;
        }
        if (this.a.c()) {
          VoiceAssistantManager.a(this.a, false);
        }
        WakeManager.a().b(paramContext);
      } while (!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext));
      WakeManager.a().a();
      return;
      if (("mqq.intent.action.QQ_FOREGROUND".equals(paramContext)) || ("tencent.av.v2q.StopVideoChat".equals(paramContext)) || ("com.tencent.mobileqq.action.ae.CLOSE_CAMERA".equals(paramContext)) || ("tencent.avgame.notify.voice.record.on".equals(paramContext)))
      {
        if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext)) {
          WakeManager.a().f = false;
        }
        if (("tencent.av.v2q.StopVideoChat".equals(paramContext)) || ("com.tencent.mobileqq.action.ae.CLOSE_CAMERA".equals(paramContext))) {
          WakeManager.a().g = false;
        }
        if ("tencent.avgame.notify.voice.record.on".equals(paramContext)) {
          WakeManager.a().h = false;
        }
        WakeManager.a().a(paramContext);
        return;
      }
    } while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext));
    WakeManager.a().b(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceAssistantManager.VoiceAssistantReceiver
 * JD-Core Version:    0.7.0.1
 */