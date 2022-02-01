package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;

public class QuitState
  extends State
{
  private VoiceAssistantStateMachine a;
  
  public QuitState(VoiceAssistantStateMachine paramVoiceAssistantStateMachine)
  {
    this.a = paramVoiceAssistantStateMachine;
  }
  
  public String a()
  {
    return QuitState.class.getSimpleName();
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
    this.a.c(1);
    this.a.a(paramMessage);
    return true;
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.QuitState
 * JD-Core Version:    0.7.0.1
 */