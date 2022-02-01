package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import com.tencent.mobileqq.qassistant.audio.AudioNewController;

public class CommandRecognizeState
  extends State
{
  private AudioNewController jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController;
  private VoiceAssistantStateMachine jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine;
  
  public CommandRecognizeState(VoiceAssistantStateMachine paramVoiceAssistantStateMachine)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine = paramVoiceAssistantStateMachine;
  }
  
  public AudioNewController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController;
  }
  
  public String a()
  {
    return CommandRecognizeState.class.getSimpleName();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController = new AudioNewController();
    this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController.b(1);
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.a(paramMessage);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.c(5);
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineVoiceAssistantStateMachine.a(paramMessage);
    }
    return true;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController.a();
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewController = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.CommandRecognizeState
 * JD-Core Version:    0.7.0.1
 */