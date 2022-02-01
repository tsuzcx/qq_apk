package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import com.tencent.mobileqq.qassistant.audio.AudioNewController;

public class CommandRecognizeState
  extends State
{
  private VoiceAssistantStateMachine a;
  private AudioNewController b;
  
  public CommandRecognizeState(VoiceAssistantStateMachine paramVoiceAssistantStateMachine)
  {
    this.a = paramVoiceAssistantStateMachine;
  }
  
  public AudioNewController a()
  {
    return this.b;
  }
  
  public boolean a(Message paramMessage)
  {
    if (paramMessage.what != 4) {
      return super.a(paramMessage);
    }
    VoiceAssistantStateMachine localVoiceAssistantStateMachine = this.a;
    if (localVoiceAssistantStateMachine != null)
    {
      localVoiceAssistantStateMachine.e(5);
      this.a.a(paramMessage);
    }
    return true;
  }
  
  public void b()
  {
    super.b();
    this.b = new AudioNewController();
    this.b.b(1);
  }
  
  public void c()
  {
    super.c();
    AudioNewController localAudioNewController = this.b;
    if (localAudioNewController != null)
    {
      localAudioNewController.a();
      this.b = null;
    }
  }
  
  public String d()
  {
    return CommandRecognizeState.class.getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.CommandRecognizeState
 * JD-Core Version:    0.7.0.1
 */