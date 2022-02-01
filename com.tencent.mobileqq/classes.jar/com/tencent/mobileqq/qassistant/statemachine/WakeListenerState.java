package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import com.tencent.mobileqq.qassistant.wake.WakeManager;

public class WakeListenerState
  extends State
{
  private VoiceAssistantStateMachine a;
  
  public WakeListenerState(VoiceAssistantStateMachine paramVoiceAssistantStateMachine)
  {
    this.a = paramVoiceAssistantStateMachine;
  }
  
  public String a()
  {
    return WakeListenerState.class.getSimpleName();
  }
  
  public void a()
  {
    super.a();
    WakeManager.a().b();
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return super.a(paramMessage);
      } while (this.a == null);
      this.a.c(3);
      this.a.a(paramMessage);
      return true;
    } while (this.a == null);
    this.a.c(6);
    return true;
  }
  
  public void b()
  {
    super.b();
    WakeManager.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.WakeListenerState
 * JD-Core Version:    0.7.0.1
 */