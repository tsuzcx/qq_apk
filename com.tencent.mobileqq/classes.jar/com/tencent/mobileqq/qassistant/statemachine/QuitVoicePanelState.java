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
  
  public String a()
  {
    return QuitVoicePanelState.class.getSimpleName();
  }
  
  public void a()
  {
    super.a();
  }
  
  public boolean a(Message paramMessage)
  {
    if (paramMessage.what != 4) {
      return super.a(paramMessage);
    }
    if (this.a != null)
    {
      if (((paramMessage.obj instanceof Boolean)) && (this.a.a() != null))
      {
        boolean bool = ((Boolean)paramMessage.obj).booleanValue();
        ThreadManager.getUIHandler().post(new QuitVoicePanelState.1(this, bool));
      }
      if (this.a.a() != null) {
        this.a.a().b();
      }
      this.a.c(1);
      this.a.a(1);
    }
    return true;
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.QuitVoicePanelState
 * JD-Core Version:    0.7.0.1
 */