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
  
  public String a()
  {
    return InitState.class.getSimpleName();
  }
  
  public void a()
  {
    super.a();
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return super.a(paramMessage);
    } while (this.a == null);
    this.a.c(2);
    return true;
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.InitState
 * JD-Core Version:    0.7.0.1
 */