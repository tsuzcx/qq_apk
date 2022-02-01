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
  
  public boolean a(Message paramMessage)
  {
    int i = paramMessage.what;
    VoiceAssistantStateMachine localVoiceAssistantStateMachine;
    if (i != 2)
    {
      if (i == 5)
      {
        localVoiceAssistantStateMachine = this.a;
        if (localVoiceAssistantStateMachine != null)
        {
          localVoiceAssistantStateMachine.e(6);
          return true;
        }
      }
    }
    else
    {
      localVoiceAssistantStateMachine = this.a;
      if (localVoiceAssistantStateMachine != null)
      {
        localVoiceAssistantStateMachine.e(3);
        this.a.a(paramMessage);
        return true;
      }
    }
    return super.a(paramMessage);
  }
  
  public void b()
  {
    super.b();
    WakeManager.a().f();
  }
  
  public void c()
  {
    super.c();
    WakeManager.a().g();
  }
  
  public String d()
  {
    return WakeListenerState.class.getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.WakeListenerState
 * JD-Core Version:    0.7.0.1
 */