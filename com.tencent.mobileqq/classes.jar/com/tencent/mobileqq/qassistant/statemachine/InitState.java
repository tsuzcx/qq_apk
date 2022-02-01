package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;

public class InitState
  extends State
{
  private VoiceAssistantStateMachine a;
  
  public InitState(VoiceAssistantStateMachine paramVoiceAssistantStateMachine)
  {
    this.a = paramVoiceAssistantStateMachine;
  }
  
  public boolean a(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.a;
      if (localVoiceAssistantStateMachine != null)
      {
        localVoiceAssistantStateMachine.e(2);
        return true;
      }
    }
    return super.a(paramMessage);
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
    return InitState.class.getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.InitState
 * JD-Core Version:    0.7.0.1
 */