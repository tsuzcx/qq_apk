package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.listener.IPanelEventListener;
import mqq.os.MqqHandler;

public class QuitVoicePanelState
  extends State
{
  private VoiceAssistantStateMachine a;
  
  public QuitVoicePanelState(VoiceAssistantStateMachine paramVoiceAssistantStateMachine)
  {
    this.a = paramVoiceAssistantStateMachine;
  }
  
  public boolean a(Message paramMessage)
  {
    if (paramMessage.what != 4) {
      return super.a(paramMessage);
    }
    if (this.a != null)
    {
      if (((paramMessage.obj instanceof Boolean)) && (this.a.k() != null))
      {
        boolean bool = ((Boolean)paramMessage.obj).booleanValue();
        ThreadManager.getUIHandler().post(new QuitVoicePanelState.1(this, bool));
      }
      if (this.a.h() != null) {
        this.a.h().b();
      }
      this.a.e(1);
      this.a.c(1);
    }
    return true;
  }
  
  public void b()
  {
    super.b();
  }
  
  public void c()
  {
    super.c();
  }
  
  public String d()
  {
    return QuitVoicePanelState.class.getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.QuitVoicePanelState
 * JD-Core Version:    0.7.0.1
 */